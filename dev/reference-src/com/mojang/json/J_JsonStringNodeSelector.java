/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.EnumJsonNodeType;
import com.mojang.json.J_JsonNode;
import com.mojang.json.J_LeafFunctor;

final class J_JsonStringNodeSelector
extends J_LeafFunctor {
    J_JsonStringNodeSelector() {
    }

    public boolean func_27072_a(J_JsonNode j_JsonNode) {
        return EnumJsonNodeType.STRING == j_JsonNode.func_27218_a();
    }

    @Override
    public String func_27060_a() {
        return "A short form string";
    }

    public String func_27073_b(J_JsonNode j_JsonNode) {
        return j_JsonNode.func_27216_b();
    }

    public String toString() {
        return "a value that is a string";
    }

    @Override
    public Object func_27063_c(Object object) {
        return this.func_27073_b((J_JsonNode)object);
    }

    @Override
    public boolean func_27058_a(Object object) {
        return this.func_27072_a((J_JsonNode)object);
    }
}

