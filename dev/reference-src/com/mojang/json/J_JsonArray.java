/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.EnumJsonNodeType;
import com.mojang.json.J_JsonNodeList;
import com.mojang.json.J_JsonRootNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class J_JsonArray
extends J_JsonRootNode {
    private final List<?> field_27221_a;

    J_JsonArray(Iterable<?> iterable) {
        this.field_27221_a = J_JsonArray.func_27220_a(iterable);
    }

    @Override
    public EnumJsonNodeType func_27218_a() {
        return EnumJsonNodeType.ARRAY;
    }

    @Override
    public List<?> func_27215_d() {
        return new ArrayList(this.field_27221_a);
    }

    @Override
    public String func_27216_b() {
        throw new IllegalStateException("Attempt to get text on a JsonNode without text.");
    }

    @Override
    public Map<?, ?> func_27214_c() {
        throw new IllegalStateException("Attempt to get fields on a JsonNode without fields.");
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && this.getClass() == object.getClass()) {
            J_JsonArray j_JsonArray = (J_JsonArray)object;
            return this.field_27221_a.equals(j_JsonArray.field_27221_a);
        }
        return false;
    }

    public int hashCode() {
        return this.field_27221_a.hashCode();
    }

    public String toString() {
        return "JsonArray elements:[" + this.field_27221_a + "]";
    }

    private static List<?> func_27220_a(Iterable<?> iterable) {
        return new J_JsonNodeList(iterable);
    }
}

