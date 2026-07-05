/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.EnumJsonNodeType;
import com.mojang.json.J_JsonNode;
import java.util.List;
import java.util.Map;

public final class J_JsonStringNode
extends J_JsonNode
implements Comparable<Object> {
    private final String field_27224_a;

    J_JsonStringNode(String string) {
        if (string == null) {
            throw new NullPointerException("Attempt to construct a JsonString with a null value.");
        }
        this.field_27224_a = string;
    }

    @Override
    public EnumJsonNodeType func_27218_a() {
        return EnumJsonNodeType.STRING;
    }

    @Override
    public String func_27216_b() {
        return this.field_27224_a;
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
            J_JsonStringNode j_JsonStringNode = (J_JsonStringNode)object;
            return this.field_27224_a.equals(j_JsonStringNode.field_27224_a);
        }
        return false;
    }

    public int hashCode() {
        return this.field_27224_a.hashCode();
    }

    public String toString() {
        return "JsonStringNode value:[" + this.field_27224_a + "]";
    }

    public int func_27223_a(J_JsonStringNode j_JsonStringNode) {
        return this.field_27224_a.compareTo(j_JsonStringNode.field_27224_a);
    }

    @Override
    public int compareTo(Object object) {
        return this.func_27223_a((J_JsonStringNode)object);
    }
}

