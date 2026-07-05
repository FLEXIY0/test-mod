/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.J_JsonArrayNodeBuilder;
import com.mojang.json.J_JsonFalseNodeBuilder;
import com.mojang.json.J_JsonNodeBuilder;
import com.mojang.json.J_JsonNullNodeBuilder;
import com.mojang.json.J_JsonNumberNodeBuilder;
import com.mojang.json.J_JsonObjectNodeBuilder;
import com.mojang.json.J_JsonStringNodeBuilder;
import com.mojang.json.J_JsonTrueNodeBuilder;

public final class J_JsonNodeBuilders {
    public static J_JsonNodeBuilder func_27248_a() {
        return new J_JsonNullNodeBuilder();
    }

    public static J_JsonNodeBuilder func_27251_b() {
        return new J_JsonTrueNodeBuilder();
    }

    public static J_JsonNodeBuilder func_27252_c() {
        return new J_JsonFalseNodeBuilder();
    }

    public static J_JsonNodeBuilder func_27250_a(String string) {
        return new J_JsonNumberNodeBuilder(string);
    }

    public static J_JsonStringNodeBuilder func_27254_b(String string) {
        return new J_JsonStringNodeBuilder(string);
    }

    public static J_JsonObjectNodeBuilder func_27253_d() {
        return new J_JsonObjectNodeBuilder();
    }

    public static J_JsonArrayNodeBuilder func_27249_e() {
        return new J_JsonArrayNodeBuilder();
    }
}

