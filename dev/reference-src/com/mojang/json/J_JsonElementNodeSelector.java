/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.J_JsonNode;
import com.mojang.json.J_LeafFunctor;
import java.util.List;

final class J_JsonElementNodeSelector
extends J_LeafFunctor {
    final int field_27069_a;

    J_JsonElementNodeSelector(int n) {
        this.field_27069_a = n;
    }

    public boolean func_27067_a(List<?> list) {
        return list.size() > this.field_27069_a;
    }

    @Override
    public String func_27060_a() {
        return Integer.toString(this.field_27069_a);
    }

    public J_JsonNode func_27068_b(List<?> list) {
        return (J_JsonNode)list.get(this.field_27069_a);
    }

    public String toString() {
        return "an element at index [" + this.field_27069_a + "]";
    }

    @Override
    public Object func_27063_c(Object object) {
        return this.func_27068_b((List)object);
    }

    @Override
    public boolean func_27058_a(Object object) {
        return this.func_27067_a((List)object);
    }
}

