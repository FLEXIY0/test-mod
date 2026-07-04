/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.J_InvalidSyntaxException;
import com.mojang.json.J_JsonListenerToJdomAdapter;
import com.mojang.json.J_JsonRootNode;
import com.mojang.json.J_SajParser;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class J_JdomParser {
    public J_JsonRootNode func_27366_a(Reader reader) throws J_InvalidSyntaxException, IOException {
        J_JsonListenerToJdomAdapter j_JsonListenerToJdomAdapter = new J_JsonListenerToJdomAdapter();
        new J_SajParser().func_27463_a(reader, j_JsonListenerToJdomAdapter);
        return j_JsonListenerToJdomAdapter.func_27208_a();
    }

    public J_JsonRootNode func_27367_a(String string) throws J_InvalidSyntaxException {
        try {
            J_JsonRootNode j_JsonRootNode = this.func_27366_a(new StringReader(string));
            return j_JsonRootNode;
        }
        catch (IOException iOException) {
            throw new RuntimeException("Coding failure in Argo:  StringWriter gave an IOException", iOException);
        }
    }
}

