/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.LWJGLException
 *  org.lwjgl.openal.AL
 *  org.lwjgl.openal.AL10
 */
package paulscode.sound.libraries;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import javax.sound.sampled.AudioFormat;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.AL10;
import paulscode.sound.Channel;
import paulscode.sound.FilenameURL;
import paulscode.sound.Library;
import paulscode.sound.ListenerData;
import paulscode.sound.SoundBuffer;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.SoundSystemException;
import paulscode.sound.Source;
import paulscode.sound.libraries.ChannelLWJGLOpenAL;
import paulscode.sound.libraries.SourceLWJGLOpenAL;

public class LibraryLWJGLOpenAL
extends Library {
    private static final boolean GET = false;
    private static final boolean SET = true;
    private static final boolean XXX = false;
    private FloatBuffer listenerPositionAL = null;
    private FloatBuffer listenerOrientation = null;
    private FloatBuffer listenerVelocity = null;
    private HashMap ALBufferMap = new HashMap();
    private static boolean alPitchSupported = true;

    public void init() {
        boolean bl;
        try {
            AL.create();
            bl = this.checkALError();
        }
        catch (LWJGLException lWJGLException) {
            this.errorMessage("Unable to initialize OpenAL.  Probable cause: OpenAL not supported.");
            this.printStackTrace((Exception)((Object)lWJGLException));
            throw new SoundSystemException(lWJGLException.getMessage(), 6);
        }
        if (bl) {
            this.importantMessage("OpenAL did not initialize properly!");
        } else {
            this.message("OpenAL initialized.");
        }
        this.listenerPositionAL = BufferUtils.createFloatBuffer((int)3).put(new float[]{this.listener.position.x, this.listener.position.y, this.listener.position.z});
        this.listenerOrientation = BufferUtils.createFloatBuffer((int)6).put(new float[]{this.listener.lookAt.x, this.listener.lookAt.y, this.listener.lookAt.z, this.listener.up.x, this.listener.up.y, this.listener.up.z});
        this.listenerVelocity = BufferUtils.createFloatBuffer((int)3).put(new float[]{0.0f, 0.0f, 0.0f});
        this.listenerPositionAL.flip();
        this.listenerOrientation.flip();
        this.listenerVelocity.flip();
        AL10.alListener((int)4100, (FloatBuffer)this.listenerPositionAL);
        bl = this.checkALError() || bl;
        AL10.alListener((int)4111, (FloatBuffer)this.listenerOrientation);
        bl = this.checkALError() || bl;
        AL10.alListener((int)4102, (FloatBuffer)this.listenerVelocity);
        bl = this.checkALError() || bl;
        if (bl) {
            this.importantMessage("OpenAL did not initialize properly!");
            throw new SoundSystemException("Problem encountered while loading OpenAL or creating the listener.  Probably cause:  OpenAL not supported", 6);
        }
        super.init();
        ChannelLWJGLOpenAL channelLWJGLOpenAL = (ChannelLWJGLOpenAL)this.normalChannels.get(1);
        try {
            AL10.alSourcef((int)channelLWJGLOpenAL.ALSource.get(0), (int)4099, (float)1.0f);
            if (this.checkALError()) {
                LibraryLWJGLOpenAL.alPitchSupported(true, false);
                throw new SoundSystemException("OpenAL: AL_PITCH not supported.", 13);
            }
            LibraryLWJGLOpenAL.alPitchSupported(true, true);
            return;
        }
        catch (Exception exception) {
            LibraryLWJGLOpenAL.alPitchSupported(true, false);
            throw new SoundSystemException("OpenAL: AL_PITCH not supported.", 13);
        }
    }

    public static boolean libraryCompatible() {
        if (AL.isCreated()) {
            return true;
        }
        try {
            AL.create();
        }
        catch (Exception exception) {
            return false;
        }
        try {
            AL.destroy();
        }
        catch (Exception exception) {}
        return true;
    }

    protected Channel createChannel(int n) {
        IntBuffer intBuffer = BufferUtils.createIntBuffer((int)1);
        try {
            AL10.alGenSources((IntBuffer)intBuffer);
        }
        catch (Exception exception) {
            AL10.alGetError();
            return null;
        }
        if (AL10.alGetError() != 0) {
            return null;
        }
        ChannelLWJGLOpenAL channelLWJGLOpenAL = new ChannelLWJGLOpenAL(n, intBuffer);
        return channelLWJGLOpenAL;
    }

    public void cleanup() {
        super.cleanup();
        Object object = this.bufferMap.keySet();
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = (String)object.next();
            if ((object2 = (IntBuffer)this.ALBufferMap.get(object2)) == null) continue;
            AL10.alDeleteBuffers((IntBuffer)object2);
            this.checkALError();
            ((IntBuffer)object2).clear();
        }
        this.bufferMap.clear();
        AL.destroy();
        this.bufferMap = null;
        this.listenerPositionAL = null;
        this.listenerOrientation = null;
        this.listenerVelocity = null;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean loadSound(FilenameURL filenameURL) {
        int n;
        if (this.bufferMap == null) {
            this.bufferMap = new HashMap();
            this.importantMessage("Buffer Map was null in method 'loadSound'");
        }
        if (this.ALBufferMap == null) {
            this.ALBufferMap = new HashMap();
            this.importantMessage("Open AL Buffer Map was null in method'loadSound'");
        }
        if (this.errorCheck(filenameURL == null, "Filename/URL not specified in method 'loadSound'")) {
            return false;
        }
        if (this.bufferMap.get(filenameURL.getFilename()) != null) {
            return true;
        }
        Object object = SoundSystemConfig.getCodec(filenameURL.getFilename());
        if (this.errorCheck(object == null, "No codec found for file '" + filenameURL.getFilename() + "' in method 'loadSound'")) {
            return false;
        }
        object.initialize(filenameURL.getURL());
        SoundBuffer soundBuffer = object.readAll();
        object.cleanup();
        if (this.errorCheck(soundBuffer == null, "Sound buffer null in method 'loadSound'")) {
            return false;
        }
        this.bufferMap.put(filenameURL.getFilename(), soundBuffer);
        object = soundBuffer.audioFormat;
        if (((AudioFormat)object).getChannels() == 1) {
            if (((AudioFormat)object).getSampleSizeInBits() == 8) {
                n = 4352;
            } else {
                if (((AudioFormat)object).getSampleSizeInBits() != 16) {
                    this.errorMessage("Illegal sample size in method 'loadSound'");
                    return false;
                }
                n = 4353;
            }
        } else {
            if (((AudioFormat)object).getChannels() != 2) {
                this.errorMessage("File neither mono nor stereo in method 'loadSound'");
                return false;
            }
            if (((AudioFormat)object).getSampleSizeInBits() == 8) {
                n = 4354;
            } else {
                if (((AudioFormat)object).getSampleSizeInBits() != 16) {
                    this.errorMessage("Illegal sample size in method 'loadSound'");
                    return false;
                }
                n = 4355;
            }
        }
        IntBuffer intBuffer = BufferUtils.createIntBuffer((int)1);
        AL10.alGenBuffers((IntBuffer)intBuffer);
        if (this.errorCheck(AL10.alGetError() != 0, "alGenBuffers error when loading " + filenameURL.getFilename())) {
            return false;
        }
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer((int)soundBuffer.audioData.length);
        byteBuffer.clear();
        byteBuffer.put(soundBuffer.audioData);
        byteBuffer.flip();
        AL10.alBufferData((int)intBuffer.get(0), (int)n, (ByteBuffer)byteBuffer, (int)((int)((AudioFormat)object).getSampleRate()));
        if (this.errorCheck(AL10.alGetError() != 0, "alBufferData error when loading " + filenameURL.getFilename()) && this.errorCheck(intBuffer == null, "Sound buffer was not created for " + filenameURL.getFilename())) {
            return false;
        }
        this.ALBufferMap.put(filenameURL.getFilename(), intBuffer);
        return true;
    }

    public void unloadSound(String string) {
        this.ALBufferMap.remove(string);
        super.unloadSound(string);
    }

    public void setMasterVolume(float f) {
        super.setMasterVolume(f);
        AL10.alListenerf((int)4106, (float)f);
        this.checkALError();
    }

    public void newSource(boolean bl, boolean bl2, boolean bl3, String string, FilenameURL filenameURL, float f, float f2, float f3, int n, float f4) {
        IntBuffer intBuffer = null;
        if (!bl2) {
            intBuffer = (IntBuffer)this.ALBufferMap.get(filenameURL.getFilename());
            if (intBuffer == null && !this.loadSound(filenameURL)) {
                this.errorMessage("Source '" + string + "' was not created " + "because an error occurred while loading " + filenameURL.getFilename());
                return;
            }
            intBuffer = (IntBuffer)this.ALBufferMap.get(filenameURL.getFilename());
            if (intBuffer == null) {
                this.errorMessage("Source '" + string + "' was not created " + "because a sound buffer was not found for " + filenameURL.getFilename());
                return;
            }
        }
        SoundBuffer soundBuffer = null;
        if (!bl2) {
            soundBuffer = (SoundBuffer)this.bufferMap.get(filenameURL.getFilename());
            if (soundBuffer == null && !this.loadSound(filenameURL)) {
                this.errorMessage("Source '" + string + "' was not created " + "because an error occurred while loading " + filenameURL.getFilename());
                return;
            }
            soundBuffer = (SoundBuffer)this.bufferMap.get(filenameURL.getFilename());
            if (soundBuffer == null) {
                this.errorMessage("Source '" + string + "' was not created " + "because audio data was not found for " + filenameURL.getFilename());
                return;
            }
        }
        this.sourceMap.put(string, new SourceLWJGLOpenAL(this.listenerPositionAL, intBuffer, bl, bl2, bl3, string, filenameURL, soundBuffer, f, f2, f3, n, f4, false));
    }

    public void rawDataStream(AudioFormat audioFormat, boolean bl, String string, float f, float f2, float f3, int n, float f4) {
        this.sourceMap.put(string, new SourceLWJGLOpenAL(this.listenerPositionAL, audioFormat, bl, string, f, f2, f3, n, f4));
    }

    public void quickPlay(boolean bl, boolean bl2, boolean bl3, String string, FilenameURL filenameURL, float f, float f2, float f3, int n, float f4, boolean bl4) {
        IntBuffer intBuffer = null;
        if (!bl2) {
            intBuffer = (IntBuffer)this.ALBufferMap.get(filenameURL.getFilename());
            if (intBuffer == null) {
                this.loadSound(filenameURL);
            }
            if ((intBuffer = (IntBuffer)this.ALBufferMap.get(filenameURL.getFilename())) == null) {
                this.errorMessage("Sound buffer was not created for " + filenameURL.getFilename());
                return;
            }
        }
        SoundBuffer soundBuffer = null;
        if (!bl2) {
            soundBuffer = (SoundBuffer)this.bufferMap.get(filenameURL.getFilename());
            if (soundBuffer == null && !this.loadSound(filenameURL)) {
                this.errorMessage("Source '" + string + "' was not created " + "because an error occurred while loading " + filenameURL.getFilename());
                return;
            }
            soundBuffer = (SoundBuffer)this.bufferMap.get(filenameURL.getFilename());
            if (soundBuffer == null) {
                this.errorMessage("Source '" + string + "' was not created " + "because audio data was not found for " + filenameURL.getFilename());
                return;
            }
        }
        SourceLWJGLOpenAL sourceLWJGLOpenAL = new SourceLWJGLOpenAL(this.listenerPositionAL, intBuffer, bl, bl2, bl3, string, filenameURL, soundBuffer, f, f2, f3, n, f4, false);
        this.sourceMap.put(string, sourceLWJGLOpenAL);
        this.play(sourceLWJGLOpenAL);
        if (bl4) {
            sourceLWJGLOpenAL.setTemporary(true);
        }
    }

    public void copySources(HashMap hashMap) {
        if (hashMap == null) {
            return;
        }
        Object object = hashMap.keySet();
        object = object.iterator();
        if (this.bufferMap == null) {
            this.bufferMap = new HashMap();
            this.importantMessage("Buffer Map was null in method 'copySources'");
        }
        if (this.ALBufferMap == null) {
            this.ALBufferMap = new HashMap();
            this.importantMessage("Open AL Buffer Map was null in method'copySources'");
        }
        this.sourceMap.clear();
        while (object.hasNext()) {
            String string = (String)object.next();
            Source source = (Source)hashMap.get(string);
            if (source == null) continue;
            SoundBuffer soundBuffer = null;
            if (!source.toStream) {
                this.loadSound(source.filenameURL);
                soundBuffer = (SoundBuffer)this.bufferMap.get(source.filenameURL.getFilename());
            }
            if (!source.toStream && soundBuffer == null) continue;
            this.sourceMap.put(string, new SourceLWJGLOpenAL(this.listenerPositionAL, (IntBuffer)this.ALBufferMap.get(source.filenameURL.getFilename()), source, soundBuffer));
        }
    }

    public void setListenerPosition(float f, float f2, float f3) {
        super.setListenerPosition(f, f2, f3);
        this.listenerPositionAL.put(0, f);
        this.listenerPositionAL.put(1, f2);
        this.listenerPositionAL.put(2, f3);
        AL10.alListener((int)4100, (FloatBuffer)this.listenerPositionAL);
        this.checkALError();
    }

    public void setListenerAngle(float f) {
        super.setListenerAngle(f);
        this.listenerOrientation.put(0, this.listener.lookAt.x);
        this.listenerOrientation.put(2, this.listener.lookAt.z);
        AL10.alListener((int)4111, (FloatBuffer)this.listenerOrientation);
        this.checkALError();
    }

    public void setListenerOrientation(float f, float f2, float f3, float f4, float f5, float f6) {
        super.setListenerOrientation(f, f2, f3, f4, f5, f6);
        this.listenerOrientation.put(0, f);
        this.listenerOrientation.put(1, f2);
        this.listenerOrientation.put(2, f3);
        this.listenerOrientation.put(3, f4);
        this.listenerOrientation.put(4, f5);
        this.listenerOrientation.put(5, f6);
        AL10.alListener((int)4111, (FloatBuffer)this.listenerOrientation);
        this.checkALError();
    }

    public void setListenerData(ListenerData listenerData) {
        super.setListenerData(listenerData);
        this.listenerPositionAL.put(0, listenerData.position.x);
        this.listenerPositionAL.put(1, listenerData.position.y);
        this.listenerPositionAL.put(2, listenerData.position.z);
        AL10.alListener((int)4100, (FloatBuffer)this.listenerPositionAL);
        this.listenerOrientation.put(0, listenerData.lookAt.x);
        this.listenerOrientation.put(1, listenerData.lookAt.y);
        this.listenerOrientation.put(2, listenerData.lookAt.z);
        this.listenerOrientation.put(3, listenerData.up.x);
        this.listenerOrientation.put(4, listenerData.up.y);
        this.listenerOrientation.put(5, listenerData.up.z);
        AL10.alListener((int)4111, (FloatBuffer)this.listenerOrientation);
        this.checkALError();
    }

    private boolean checkALError() {
        switch (AL10.alGetError()) {
            case 0: {
                return false;
            }
            case 40961: {
                this.errorMessage("Invalid name parameter.");
                return true;
            }
            case 40962: {
                this.errorMessage("Invalid parameter.");
                return true;
            }
            case 40963: {
                this.errorMessage("Invalid enumerated parameter value.");
                return true;
            }
            case 40964: {
                this.errorMessage("Illegal call.");
                return true;
            }
            case 40965: {
                this.errorMessage("Unable to allocate memory.");
                return true;
            }
        }
        this.errorMessage("An unrecognized error occurred.");
        return true;
    }

    public static boolean alPitchSupported() {
        return LibraryLWJGLOpenAL.alPitchSupported(false, false);
    }

    private static synchronized boolean alPitchSupported(boolean bl, boolean bl2) {
        if (bl) {
            alPitchSupported = bl2;
        }
        return alPitchSupported;
    }

    public static String getTitle() {
        return "LWJGL OpenAL";
    }

    public static String getDescription() {
        return "The LWJGL binding of OpenAL.  For more information, see http://www.lwjgl.org";
    }

    public String getClassName() {
        return "LibraryLWJGLOpenAL";
    }
}

