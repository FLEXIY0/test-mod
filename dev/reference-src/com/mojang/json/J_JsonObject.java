/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.EnumJsonNodeType;
import com.mojang.json.J_JsonRootNode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class J_JsonObject
extends J_JsonRootNode {
    private final Map<?, ?> field_27222_a;

    J_JsonObject(Map map) {
        this.field_27222_a = new HashMap(map);
    }

    public Map func_27214_c() {
        return new HashMap(this.field_27222_a);
    }

    @Override
    public EnumJsonNodeType func_27218_a() {
        return EnumJsonNodeType.OBJECT;
    }

    @Override
    public String func_27216_b() {
        throw new IllegalStateException("Attempt to get text on a JsonNode without text.");
    }

    public List func_27215_d() {
        throw new IllegalStateException("Attempt to get elements on a JsonNode without elements.");
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && this.getClass() == object.getClass()) {
            J_JsonObject j_JsonObject = (J_JsonObject)object;
            return this.field_27222_a.equals(j_JsonObject.field_27222_a);
        }
        return false;
    }

    public int hashCode() {
        return this.field_27222_a.hashCode();
    }

    public String toString() {
        return "JsonObject fields:[" + this.field_27222_a + "]";
    }
}

