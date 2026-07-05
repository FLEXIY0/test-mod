/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.EnumJsonNodeType;
import com.mojang.json.J_JsonNode;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

final class J_JsonNumberNode
extends J_JsonNode {
    private static final Pattern field_27226_a = Pattern.compile("(-?)(0|([1-9]([0-9]*)))(\\.[0-9]+)?((e|E)(\\+|-)?[0-9]+)?");
    private final String field_27225_b;

    J_JsonNumberNode(String string) {
        if (string == null) {
            throw new NullPointerException("Attempt to construct a JsonNumber with a null value.");
        }
        if (!field_27226_a.matcher(string).matches()) {
            throw new IllegalArgumentException("Attempt to construct a JsonNumber with a String [" + string + "] that does not match the JSON number specification.");
        }
        this.field_27225_b = string;
    }

    @Override
    public EnumJsonNodeType func_27218_a() {
        return EnumJsonNodeType.NUMBER;
    }

    @Override
    public String func_27216_b() {
        return this.field_27225_b;
    }

    @Override
    public Map<?, ?> func_27214_c() {
        throw new IllegalStateException("Attempt to get fields on a JsonNode without fields.");
    }

    @Override
    public List<?> func_27215_d() {
        throw new IllegalStateException("Attempt to get elements on a JsonNode without elements.");
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && this.getClass() == object.getClass()) {
            J_JsonNumberNode j_JsonNumberNode = (J_JsonNumberNode)object;
            return this.field_27225_b.equals(j_JsonNumberNode.field_27225_b);
        }
        return false;
    }

    public int hashCode() {
        return this.field_27225_b.hashCode();
    }

    public String toString() {
        return "JsonNumberNode value:[" + this.field_27225_b + "]";
    }
}

