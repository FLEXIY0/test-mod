/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.EnumJsonNodeType;
import com.mojang.json.J_JsonNode;
import com.mojang.json.J_LeafFunctor;
import java.util.List;

final class J_JsonArrayNodeSelector
extends J_LeafFunctor {
    J_JsonArrayNodeSelector() {
    }

    public boolean func_27074_a(J_JsonNode j_JsonNode) {
        return EnumJsonNodeType.ARRAY == j_JsonNode.func_27218_a();
    }

    @Override
    public String func_27060_a() {
        return "A short form array";
    }

    public List<?> func_27075_b(J_JsonNode j_JsonNode) {
        return j_JsonNode.func_27215_d();
    }

    public String toString() {
        return "an array";
    }

    @Override
    public Object func_27063_c(Object object) {
        return this.func_27075_b((J_JsonNode)object);
    }

    @Override
    public boolean func_27058_a(Object object) {
        return this.func_27074_a((J_JsonNode)object);
    }
}

