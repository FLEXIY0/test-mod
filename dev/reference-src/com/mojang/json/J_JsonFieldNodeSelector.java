/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.J_JsonNode;
import com.mojang.json.J_JsonStringNode;
import com.mojang.json.J_LeafFunctor;
import java.util.Map;

final class J_JsonFieldNodeSelector
extends J_LeafFunctor {
    final J_JsonStringNode field_27066_a;

    J_JsonFieldNodeSelector(J_JsonStringNode j_JsonStringNode) {
        this.field_27066_a = j_JsonStringNode;
    }

    public boolean func_27065_a(Map<?, ?> map) {
        return map.containsKey(this.field_27066_a);
    }

    @Override
    public String func_27060_a() {
        return "\"" + this.field_27066_a.func_27216_b() + "\"";
    }

    public J_JsonNode func_27064_b(Map<?, ?> map) {
        return (J_JsonNode)map.get(this.field_27066_a);
    }

    public String toString() {
        return "a field called [\"" + this.field_27066_a.func_27216_b() + "\"]";
    }

    @Override
    public Object func_27063_c(Object object) {
        return this.func_27064_b((Map)object);
    }

    @Override
    public boolean func_27058_a(Object object) {
        return this.func_27065_a((Map)object);
    }
}

