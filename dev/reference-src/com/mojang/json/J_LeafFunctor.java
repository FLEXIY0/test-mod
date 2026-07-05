/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.J_Functor;
import com.mojang.json.J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException;

abstract class J_LeafFunctor
implements J_Functor {
    J_LeafFunctor() {
    }

    @Override
    public final Object func_27059_b(Object object) {
        if (!this.func_27058_a(object)) {
            throw J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException.func_27322_a(this);
        }
        return this.func_27063_c(object);
    }

    protected abstract Object func_27063_c(Object var1);
}

