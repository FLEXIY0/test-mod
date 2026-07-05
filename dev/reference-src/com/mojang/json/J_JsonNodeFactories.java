/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.J_JsonArray;
import com.mojang.json.J_JsonConstants;
import com.mojang.json.J_JsonNode;
import com.mojang.json.J_JsonNumberNode;
import com.mojang.json.J_JsonObject;
import com.mojang.json.J_JsonRootNode;
import com.mojang.json.J_JsonStringNode;
import java.util.Arrays;
import java.util.Map;

public final class J_JsonNodeFactories {
    public static J_JsonNode func_27310_a() {
        return J_JsonConstants.field_27228_a;
    }

    public static J_JsonNode func_27313_b() {
        return J_JsonConstants.field_27227_b;
    }

    public static J_JsonNode func_27314_c() {
        return J_JsonConstants.field_27230_c;
    }

    public static J_JsonStringNode func_27316_a(String string) {
        return new J_JsonStringNode(string);
    }

    public static J_JsonNode func_27311_b(String string) {
        return new J_JsonNumberNode(string);
    }

    public static J_JsonRootNode func_27309_a(Iterable<J_JsonNode> iterable) {
        return new J_JsonArray(iterable);
    }

    public static J_JsonRootNode func_27315_a(J_JsonNode ... j_JsonNodeArray) {
        return J_JsonNodeFactories.func_27309_a(Arrays.asList(j_JsonNodeArray));
    }

    public static J_JsonRootNode func_27312_a(Map<?, ?> map) {
        return new J_JsonObject(map);
    }
}

