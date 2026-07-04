/*
 * Decompiled with CFR 0.152.
 */
package com.a.a;

import com.a.a.NBTBase;
import com.a.a.NBTTagCompound;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class C_m {
    public static NBTTagCompound readTags(InputStream inputStream) throws IOException {
        NBTTagCompound nBTTagCompound;
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(inputStream)));){
            nBTTagCompound = C_m.read(dataInputStream);
        }
        return nBTTagCompound;
    }

    public static void writeTags(NBTTagCompound nBTTagCompound, OutputStream outputStream) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new GZIPOutputStream(outputStream));){
            C_m.write(nBTTagCompound, dataOutputStream);
        }
    }

    public static NBTTagCompound decompress(byte[] byArray) throws IOException {
        NBTTagCompound nBTTagCompound;
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(byArray))));){
            nBTTagCompound = C_m.read(dataInputStream);
        }
        return nBTTagCompound;
    }

    public static byte[] compress(NBTTagCompound nBTTagCompound) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (DataOutputStream dataOutputStream = new DataOutputStream(new GZIPOutputStream(byteArrayOutputStream));){
            C_m.write(nBTTagCompound, dataOutputStream);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void safeWrite(NBTTagCompound nBTTagCompound, File file) throws IOException {
        File file2 = new File(file.getAbsolutePath() + "_tmp");
        if (file2.exists()) {
            file2.delete();
        }
        C_m.write(nBTTagCompound, file2);
        if (file.exists()) {
            file.delete();
        }
        if (file.exists()) {
            throw new IOException("Failed to delete " + file);
        }
        file2.renameTo(file);
    }

    public static void write(NBTTagCompound nBTTagCompound, File file) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));){
            C_m.write(nBTTagCompound, dataOutputStream);
        }
    }

    public static NBTTagCompound read(File file) throws IOException {
        NBTTagCompound nBTTagCompound;
        if (!file.exists()) {
            return null;
        }
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));){
            nBTTagCompound = C_m.read(dataInputStream);
        }
        return nBTTagCompound;
    }

    public static NBTTagCompound read(DataInput dataInput) throws IOException {
        NBTBase nBTBase = NBTBase.b(dataInput);
        if (nBTBase instanceof NBTTagCompound) {
            return (NBTTagCompound)nBTBase;
        }
        throw new IOException("Root tag must be a named compound tag");
    }

    public static void write(NBTTagCompound nBTTagCompound, DataOutput dataOutput) throws IOException {
        NBTBase.a(nBTTagCompound, dataOutput);
    }
}

