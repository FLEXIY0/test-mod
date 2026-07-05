/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.EnumJsonNodeType;
import com.mojang.json.J_JsonNode;
import com.mojang.json.J_LeafFunctor;
import java.util.Map;

final class J_JsonObjectNodeSelector
extends J_LeafFunctor {
    J_JsonObjectNodeSelector() {
    }

    public boolean func_27070_a(J_JsonNode j_JsonNode) {
        return EnumJsonNodeType.OBJECT == j_JsonNode.func_27218_a();
    }

    @Override
    public String func_27060_a() {
        return "A short form object";
    }

    public Map<?, ?> func_27071_b(J_JsonNode j_JsonNode) {
        return j_JsonNode.func_27214_c();
    }

    public String toString() {
        return "an object";
    }

    @Override
    public Object func_27063_c(Object object) {
        return this.func_27071_b((J_JsonNode)object);
    }

    @Override
    public boolean func_27058_a(Object object) {
        return this.func_27070_a((J_JsonNode)object);
    }
}

