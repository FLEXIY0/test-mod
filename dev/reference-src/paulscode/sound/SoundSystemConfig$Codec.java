/*
 * Decompiled with CFR 0.152.
 */
package paulscode.sound;

import java.util.Locale;
import paulscode.sound.ICodec;
import paulscode.sound.SoundSystemConfig;

class SoundSystemConfig$Codec {
    public String extensionRegX = "";
    public Class iCodecClass;

    public SoundSystemConfig$Codec(String string, Class clazz) {
        if (string != null && string.length() > 0) {
            this.extensionRegX = ".*";
            for (int i = 0; i < string.length(); ++i) {
                String string2 = string.substring(i, i + 1);
                this.extensionRegX = this.extensionRegX + "[" + string2.toLowerCase(Locale.ENGLISH) + string2.toUpperCase(Locale.ENGLISH) + "]";
            }
            this.extensionRegX = this.extensionRegX + "$";
        }
        this.iCodecClass = clazz;
    }

    public ICodec getInstance() {
        Object object;
        if (this.iCodecClass == null) {
            return null;
        }
        try {
            object = this.iCodecClass.newInstance();
        }
        catch (InstantiationException instantiationException) {
            SoundSystemConfig$Codec soundSystemConfig$Codec = this;
            SoundSystemConfig.access$000("Unrecognized ICodec implementation in method 'getInstance'.  Ensure that the implementing class has one public, parameterless constructor.");
            return null;
        }
        catch (IllegalAccessException illegalAccessException) {
            SoundSystemConfig$Codec soundSystemConfig$Codec = this;
            SoundSystemConfig.access$000("Unrecognized ICodec implementation in method 'getInstance'.  Ensure that the implementing class has one public, parameterless constructor.");
            return null;
        }
        catch (ExceptionInInitializerError exceptionInInitializerError) {
            SoundSystemConfig$Codec soundSystemConfig$Codec = this;
            SoundSystemConfig.access$000("Unrecognized ICodec implementation in method 'getInstance'.  Ensure that the implementing class has one public, parameterless constructor.");
            return null;
        }
        catch (SecurityException securityException) {
            SoundSystemConfig$Codec soundSystemConfig$Codec = this;
            SoundSystemConfig.access$000("Unrecognized ICodec implementation in method 'getInstance'.  Ensure that the implementing class has one public, parameterless constructor.");
            return null;
        }
        if (object == null) {
            object = this;
            SoundSystemConfig.access$000("Unrecognized ICodec implementation in method 'getInstance'.  Ensure that the implementing class has one public, parameterless constructor.");
            return null;
        }
        return (ICodec)object;
    }

    private void instantiationErrorMessage() {
        SoundSystemConfig.access$000("Unrecognized ICodec implementation in method 'getInstance'.  Ensure that the implementing class has one public, parameterless constructor.");
    }
}

