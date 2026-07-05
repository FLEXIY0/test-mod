/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.statistics;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5String {
    private String string;

    public MD5String(String string) {
        this.string = string;
    }

    public String func_27369_a(String string) {
        try {
            String string2 = this.string + string;
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(string2.getBytes(), 0, string2.length());
            return new BigInteger(1, messageDigest.digest()).toString(16);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException(noSuchAlgorithmException);
        }
    }
}

