/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.J_ChainedFunctor;
import com.mojang.json.J_Functor;

public final class J_JsonNodeSelector {
    final J_Functor field_27359_a;

    J_JsonNodeSelector(J_Functor j_Functor) {
        this.field_27359_a = j_Functor;
    }

    public boolean func_27356_a(Object object) {
        return this.field_27359_a.func_27058_a(object);
    }

    public Object func_27357_b(Object object) {
        return this.field_27359_a.func_27059_b(object);
    }

    public J_JsonNodeSelector func_27355_a(J_JsonNodeSelector j_JsonNodeSelector) {
        return new J_JsonNodeSelector(new J_ChainedFunctor(this, j_JsonNodeSelector));
    }

    String func_27358_a() {
        return this.field_27359_a.func_27060_a();
    }

    public String toString() {
        return this.field_27359_a.toString();
    }
}

