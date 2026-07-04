/*
 * Decompiled with CFR 0.152.
 */
package paulscode.sound;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.sound.sampled.AudioFormat;
import paulscode.sound.Channel;
import paulscode.sound.FilenameURL;
import paulscode.sound.ListenerData;
import paulscode.sound.MidiChannel;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.SoundSystemLogger;
import paulscode.sound.Source;
import paulscode.sound.StreamThread;

public class Library {
    private SoundSystemLogger logger = SoundSystemConfig.getLogger();
    protected ListenerData listener;
    protected HashMap bufferMap = new HashMap();
    protected HashMap sourceMap = new HashMap();
    private MidiChannel midiChannel;
    protected List streamingChannels;
    protected List normalChannels;
    private String[] streamingChannelSourceNames;
    private String[] normalChannelSourceNames;
    private int nextStreamingChannel = 0;
    private int nextNormalChannel = 0;
    protected StreamThread streamThread;

    public Library() {
        this.listener = new ListenerData(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f);
        this.streamingChannels = new LinkedList();
        this.normalChannels = new LinkedList();
        this.streamingChannelSourceNames = new String[SoundSystemConfig.getNumberStreamingChannels()];
        this.normalChannelSourceNames = new String[SoundSystemConfig.getNumberNormalChannels()];
        this.streamThread = new StreamThread();
        this.streamThread.start();
    }

    public void cleanup() {
        this.streamThread.kill();
        this.streamThread.interrupt();
        for (int i = 0; i < 50 && this.streamThread.alive(); ++i) {
            try {
                Thread.sleep(100L);
                continue;
            }
            catch (Exception exception) {}
        }
        if (this.streamThread.alive()) {
            this.errorMessage("Stream thread did not die!");
            this.message("Ignoring errors... continuing clean-up.");
        }
        if (this.midiChannel != null) {
            this.midiChannel.cleanup();
            this.midiChannel = null;
        }
        if (this.streamingChannels != null) {
            while (!this.streamingChannels.isEmpty()) {
                Channel channel = (Channel)this.streamingChannels.remove(0);
                channel.close();
                channel.cleanup();
            }
            this.streamingChannels.clear();
            this.streamingChannels = null;
        }
        if (this.normalChannels != null) {
            while (!this.normalChannels.isEmpty()) {
                Channel channel = (Channel)this.normalChannels.remove(0);
                channel.close();
                channel.cleanup();
            }
            this.normalChannels.clear();
            this.normalChannels = null;
        }
        Object object = this.sourceMap.keySet();
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = (String)object.next();
            if ((object2 = (Source)this.sourceMap.get(object2)) == null) continue;
            ((Source)object2).cleanup();
        }
        this.sourceMap.clear();
        this.sourceMap = null;
        this.listener = null;
        this.streamThread = null;
    }

    public void init() {
        Channel channel;
        int n;
        for (n = 0; n < SoundSystemConfig.getNumberStreamingChannels() && (channel = this.createChannel(1)) != null; ++n) {
            this.streamingChannels.add(channel);
        }
        for (n = 0; n < SoundSystemConfig.getNumberNormalChannels() && (channel = this.createChannel(0)) != null; ++n) {
            this.normalChannels.add(channel);
        }
    }

    public static boolean libraryCompatible() {
        return true;
    }

    protected Channel createChannel(int n) {
        return null;
    }

    public boolean loadSound(FilenameURL filenameURL) {
        return true;
    }

    public void unloadSound(String string) {
        this.bufferMap.remove(string);
    }

    public void rawDataStream(AudioFormat audioFormat, boolean bl, String string, float f, float f2, float f3, int n, float f4) {
        this.sourceMap.put(string, new Source(audioFormat, bl, string, f, f2, f3, n, f4));
    }

    public void newSource(boolean bl, boolean bl2, boolean bl3, String string, FilenameURL filenameURL, float f, float f2, float f3, int n, float f4) {
        this.sourceMap.put(string, new Source(bl, bl2, bl3, string, filenameURL, null, f, f2, f3, n, f4, false));
    }

    public void quickPlay(boolean bl, boolean bl2, boolean bl3, String string, FilenameURL filenameURL, float f, float f2, float f3, int n, float f4, boolean bl4) {
        this.sourceMap.put(string, new Source(bl, bl2, bl3, string, filenameURL, null, f, f2, f3, n, f4, bl4));
    }

    public void setTemporary(String object, boolean bl) {
        if ((object = (Source)this.sourceMap.get(object)) != null) {
            ((Source)object).setTemporary(bl);
        }
    }

    public void setPosition(String object, float f, float f2, float f3) {
        if ((object = (Source)this.sourceMap.get(object)) != null) {
            ((Source)object).setPosition(f, f2, f3);
        }
    }

    public void setPriority(String object, boolean bl) {
        if ((object = (Source)this.sourceMap.get(object)) != null) {
            ((Source)object).setPriority(bl);
        }
    }

    public void setLooping(String object, boolean bl) {
        if ((object = (Source)this.sourceMap.get(object)) != null) {
            ((Source)object).setLooping(bl);
        }
    }

    public void setAttenuation(String object, int n) {
        if ((object = (Source)this.sourceMap.get(object)) != null) {
            ((Source)object).setAttenuation(n);
        }
    }

    public void setDistOrRoll(String object, float f) {
        if ((object = (Source)this.sourceMap.get(object)) != null) {
            ((Source)object).setDistOrRoll(f);
        }
    }

    public int feedRawAudioData(String string, byte[] byArray) {
        if (string == null || string.equals("")) {
            this.errorMessage("Sourcename not specified in method 'feedRawAudioData'");
            return -1;
        }
        if (this.midiSourcename(string)) {
            this.errorMessage("Raw audio data can not be fed to the MIDI channel.");
            return -1;
        }
        Source source = (Source)this.sourceMap.get(string);
        if (source == null) {
            this.errorMessage("Source '" + string + "' not found in " + "method 'feedRawAudioData'");
        }
        return this.feedRawAudioData(source, byArray);
    }

    public int feedRawAudioData(Source source, byte[] byArray) {
        if (source == null) {
            this.errorMessage("Source parameter null in method 'feedRawAudioData'");
            return -1;
        }
        if (!source.toStream) {
            this.errorMessage("Only a streaming source may be specified in method 'feedRawAudioData'");
            return -1;
        }
        if (!source.rawDataStream) {
            this.errorMessage("Streaming source already associated with a file or URL in method'feedRawAudioData'");
            return -1;
        }
        if (!source.playing() || source.channel == null) {
            Channel channel = source.channel != null && source.channel.attachedSource == source ? source.channel : this.getNextChannel(source);
            int n = source.feedRawAudioData(channel, byArray);
            channel.attachedSource = source;
            this.streamThread.watch(source);
            this.streamThread.interrupt();
            return n;
        }
        return source.feedRawAudioData(source.channel, byArray);
    }

    public void play(String string) {
        if (string == null || string.equals("")) {
            this.errorMessage("Sourcename not specified in method 'play'");
            return;
        }
        if (this.midiSourcename(string)) {
            this.midiChannel.play();
            return;
        }
        Source source = (Source)this.sourceMap.get(string);
        if (source == null) {
            this.errorMessage("Source '" + string + "' not found in " + "method 'play'");
        }
        this.play(source);
    }

    public void play(Source source) {
        if (source == null) {
            return;
        }
        if (source.rawDataStream) {
            return;
        }
        if (!source.active()) {
            return;
        }
        if (!source.playing()) {
            Channel channel = this.getNextChannel(source);
            if (source != null && channel != null) {
                if (source.channel != null && source.channel.attachedSource != source) {
                    source.channel = null;
                }
                channel.attachedSource = source;
                source.play(channel);
                if (source.toStream) {
                    this.streamThread.watch(source);
                    this.streamThread.interrupt();
                }
            }
        }
    }

    public void stop(String object) {
        if (object == null || ((String)object).equals("")) {
            this.errorMessage("Sourcename not specified in method 'stop'");
            return;
        }
        if (this.midiSourcename((String)object)) {
            this.midiChannel.stop();
            return;
        }
        if ((object = (Source)this.sourceMap.get(object)) != null) {
            ((Source)object).stop();
        }
    }

    public void pause(String object) {
        if (object == null || ((String)object).equals("")) {
            this.errorMessage("Sourcename not specified in method 'stop'");
            return;
        }
        if (this.midiSourcename((String)object)) {
            this.midiChannel.pause();
            return;
        }
        if ((object = (Source)this.sourceMap.get(object)) != null) {
            ((Source)object).pause();
        }
    }

    public void rewind(String object) {
        if (this.midiSourcename((String)object)) {
            this.midiChannel.rewind();
            return;
        }
        if ((object = (Source)this.sourceMap.get(object)) != null) {
            ((Source)object).rewind();
        }
    }

    public void flush(String object) {
        if (this.midiSourcename((String)object)) {
            this.errorMessage("You can not flush the MIDI channel");
            return;
        }
        if ((object = (Source)this.sourceMap.get(object)) != null) {
            ((Source)object).flush();
        }
    }

    public void cull(String object) {
        if ((object = (Source)this.sourceMap.get(object)) != null) {
            ((Source)object).cull();
        }
    }

    public void activate(String object) {
        if ((object = (Source)this.sourceMap.get(object)) != null) {
            ((Source)object).activate();
            if (((Source)object).toPlay) {
                this.play((Source)object);
            }
        }
    }

    public void setMasterVolume(float f) {
        SoundSystemConfig.setMasterGain(f);
        if (this.midiChannel != null) {
            this.midiChannel.resetGain();
        }
    }

    public void setVolume(String object, float f) {
        if (this.midiSourcename((String)object)) {
            this.midiChannel.setVolume(f);
            return;
        }
        if ((object = (Source)this.sourceMap.get(object)) != null) {
            float f2 = f;
            if (f < 0.0f) {
                f2 = 0.0f;
            } else if (f > 1.0f) {
                f2 = 1.0f;
            }
            ((Source)object).sourceVolume = f2;
            ((Source)object).positionChanged();
        }
    }

    public float getVolume(String object) {
        if (this.midiSourcename((String)object)) {
            return this.midiChannel.getVolume();
        }
        if ((object = (Source)this.sourceMap.get(object)) != null) {
            return ((Source)object).sourceVolume;
        }
        return 0.0f;
    }

    public void setPitch(String object, float f) {
        if (!this.midiSourcename((String)object) && (object = (Source)this.sourceMap.get(object)) != null) {
            float f2 = f;
            if (f < 0.5f) {
                f2 = 0.5f;
            } else if (f > 2.0f) {
                f2 = 2.0f;
            }
            ((Source)object).setPitch(f2);
            ((Source)object).positionChanged();
        }
    }

    public float getPitch(String object) {
        if (!this.midiSourcename((String)object) && (object = (Source)this.sourceMap.get(object)) != null) {
            return ((Source)object).getPitch();
        }
        return 1.0f;
    }

    public void moveListener(float f, float f2, float f3) {
        this.setListenerPosition(this.listener.position.x + f, this.listener.position.y + f2, this.listener.position.z + f3);
    }

    public void setListenerPosition(float f, float f2, float f3) {
        this.listener.setPosition(f, f2, f3);
        Object object = this.sourceMap.keySet();
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = (String)object.next();
            if ((object2 = (Source)this.sourceMap.get(object2)) == null) continue;
            ((Source)object2).positionChanged();
        }
    }

    public void turnListener(float f) {
        this.setListenerAngle(this.listener.angle + f);
    }

    public void setListenerAngle(float f) {
        this.listener.setAngle(f);
        Object object = this.sourceMap.keySet();
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = (String)object.next();
            if ((object2 = (Source)this.sourceMap.get(object2)) == null) continue;
            ((Source)object2).positionChanged();
        }
    }

    public void setListenerOrientation(float f, float f2, float f3, float f4, float f5, float f6) {
        this.listener.setOrientation(f, f2, f3, f4, f5, f6);
        Object object = this.sourceMap.keySet();
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = (String)object.next();
            if ((object2 = (Source)this.sourceMap.get(object2)) == null) continue;
            ((Source)object2).positionChanged();
        }
    }

    public void setListenerData(ListenerData listenerData) {
        this.listener.setData(listenerData);
    }

    public void copySources(HashMap hashMap) {
        if (hashMap == null) {
            return;
        }
        Object object = hashMap.keySet();
        object = object.iterator();
        this.sourceMap.clear();
        while (object.hasNext()) {
            String string = (String)object.next();
            Source source = (Source)hashMap.get(string);
            if (source == null) continue;
            this.loadSound(source.filenameURL);
            this.sourceMap.put(string, new Source(source, null));
        }
    }

    public void removeSource(String string) {
        Source source = (Source)this.sourceMap.get(string);
        if (source != null) {
            source.cleanup();
        }
        this.sourceMap.remove(string);
    }

    public void removeTemporarySources() {
        Object object = this.sourceMap.keySet();
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = (String)object.next();
            if ((object2 = (Source)this.sourceMap.get(object2)) == null || !((Source)object2).temporary || ((Source)object2).playing()) continue;
            ((Source)object2).cleanup();
            object.remove();
        }
    }

    private Channel getNextChannel(Source source) {
        Object object;
        int n;
        String[] stringArray;
        List list;
        int n2;
        if (source == null) {
            return null;
        }
        String string = source.sourcename;
        if (string == null) {
            return null;
        }
        if (source.toStream) {
            n2 = this.nextStreamingChannel;
            list = this.streamingChannels;
            stringArray = this.streamingChannelSourceNames;
        } else {
            n2 = this.nextNormalChannel;
            list = this.normalChannels;
            stringArray = this.normalChannelSourceNames;
        }
        int n3 = list.size();
        for (n = 0; n < n3; ++n) {
            if (!string.equals(stringArray[n])) continue;
            return (Channel)list.get(n);
        }
        int n4 = n2;
        for (n = 0; n < n3; ++n) {
            object = stringArray[n4];
            object = object == null ? null : (Source)this.sourceMap.get(object);
            if (object == null || !((Source)object).playing()) {
                if (source.toStream) {
                    this.nextStreamingChannel = n4 + 1;
                    if (this.nextStreamingChannel >= n3) {
                        this.nextStreamingChannel = 0;
                    }
                } else {
                    this.nextNormalChannel = n4 + 1;
                    if (this.nextNormalChannel >= n3) {
                        this.nextNormalChannel = 0;
                    }
                }
                stringArray[n4] = string;
                return (Channel)list.get(n4);
            }
            if (++n4 < n3) continue;
            n4 = 0;
        }
        n4 = n2;
        for (n = 0; n < n3; ++n) {
            object = stringArray[n4];
            object = object == null ? null : (Source)this.sourceMap.get(object);
            if (object == null || !((Source)object).playing() || !((Source)object).priority) {
                if (source.toStream) {
                    this.nextStreamingChannel = n4 + 1;
                    if (this.nextStreamingChannel >= n3) {
                        this.nextStreamingChannel = 0;
                    }
                } else {
                    this.nextNormalChannel = n4 + 1;
                    if (this.nextNormalChannel >= n3) {
                        this.nextNormalChannel = 0;
                    }
                }
                stringArray[n4] = string;
                return (Channel)list.get(n4);
            }
            if (++n4 < n3) continue;
            n4 = 0;
        }
        return null;
    }

    public void replaySources() {
        Object object = this.sourceMap.keySet();
        object = object.iterator();
        while (object.hasNext()) {
            String string = (String)object.next();
            Source source = (Source)this.sourceMap.get(string);
            if (source == null || !source.toPlay || source.playing()) continue;
            this.play(string);
            source.toPlay = false;
        }
    }

    public void queueSound(String object, FilenameURL filenameURL) {
        if (this.midiSourcename((String)object)) {
            this.midiChannel.queueSound(filenameURL);
            return;
        }
        if ((object = (Source)this.sourceMap.get(object)) != null) {
            ((Source)object).queueSound(filenameURL);
        }
    }

    public void dequeueSound(String object, String string) {
        if (this.midiSourcename((String)object)) {
            this.midiChannel.dequeueSound(string);
            return;
        }
        if ((object = (Source)this.sourceMap.get(object)) != null) {
            ((Source)object).dequeueSound(string);
        }
    }

    public void fadeOut(String object, FilenameURL filenameURL, long l) {
        if (this.midiSourcename((String)object)) {
            this.midiChannel.fadeOut(filenameURL, l);
            return;
        }
        if ((object = (Source)this.sourceMap.get(object)) != null) {
            ((Source)object).fadeOut(filenameURL, l);
        }
    }

    public void fadeOutIn(String object, FilenameURL filenameURL, long l, long l2) {
        if (this.midiSourcename((String)object)) {
            this.midiChannel.fadeOutIn(filenameURL, l, l2);
            return;
        }
        if ((object = (Source)this.sourceMap.get(object)) != null) {
            ((Source)object).fadeOutIn(filenameURL, l, l2);
        }
    }

    public void checkFadeVolumes() {
        if (this.midiChannel != null) {
            this.midiChannel.resetGain();
        }
        for (int i = 0; i < this.streamingChannels.size(); ++i) {
            Object object = (Channel)this.streamingChannels.get(i);
            if (object == null || (object = ((Channel)object).attachedSource) == null) continue;
            ((Source)object).checkFadeOut();
        }
    }

    public void loadMidi(boolean bl, String string, FilenameURL filenameURL) {
        if (filenameURL == null) {
            this.errorMessage("Filename/URL not specified in method 'loadMidi'.");
            return;
        }
        if (!filenameURL.getFilename().matches(".*[mM][iI][dD][iI]?$")) {
            this.errorMessage("Filename/identifier doesn't end in '.mid' or'.midi' in method loadMidi.");
            return;
        }
        if (this.midiChannel == null) {
            this.midiChannel = new MidiChannel(bl, string, filenameURL);
            return;
        }
        this.midiChannel.switchSource(bl, string, filenameURL);
    }

    public void unloadMidi() {
        if (this.midiChannel != null) {
            this.midiChannel.cleanup();
        }
        this.midiChannel = null;
    }

    public boolean midiSourcename(String string) {
        if (this.midiChannel == null || string == null) {
            return false;
        }
        if (this.midiChannel.getSourcename() == null || string.equals("")) {
            return false;
        }
        return string.equals(this.midiChannel.getSourcename());
    }

    public Source getSource(String string) {
        return (Source)this.sourceMap.get(string);
    }

    public MidiChannel getMidiChannel() {
        return this.midiChannel;
    }

    public void setMidiChannel(MidiChannel midiChannel) {
        if (this.midiChannel != null && this.midiChannel != midiChannel) {
            this.midiChannel.cleanup();
        }
        this.midiChannel = midiChannel;
    }

    public void listenerMoved() {
        Object object = this.sourceMap.keySet();
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = (String)object.next();
            if ((object2 = (Source)this.sourceMap.get(object2)) == null) continue;
            ((Source)object2).listenerMoved();
        }
    }

    public HashMap getSources() {
        return this.sourceMap;
    }

    public ListenerData getListenerData() {
        return this.listener;
    }

    public static String getTitle() {
        return "No Sound";
    }

    public static String getDescription() {
        return "Silent Mode";
    }

    public String getClassName() {
        return "Library";
    }

    protected void message(String string) {
        this.logger.message(string, 0);
    }

    protected void importantMessage(String string) {
        this.logger.importantMessage(string, 0);
    }

    protected boolean errorCheck(boolean bl, String string) {
        return this.logger.errorCheck(bl, this.getClassName(), string, 0);
    }

    protected void errorMessage(String string) {
        this.logger.errorMessage(this.getClassName(), string, 0);
    }

    protected void printStackTrace(Exception exception) {
        this.logger.printStackTrace(exception, 1);
    }
}

