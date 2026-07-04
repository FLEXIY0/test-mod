/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.J_Functor;
import com.mojang.json.J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException;
import com.mojang.json.J_JsonNodeSelector;

final class J_ChainedFunctor
implements J_Functor {
    private final J_JsonNodeSelector field_27062_a;
    private final J_JsonNodeSelector field_27061_b;

    J_ChainedFunctor(J_JsonNodeSelector j_JsonNodeSelector, J_JsonNodeSelector j_JsonNodeSelector2) {
        this.field_27062_a = j_JsonNodeSelector;
        this.field_27061_b = j_JsonNodeSelector2;
    }

    @Override
    public boolean func_27058_a(Object object) {
        return this.field_27062_a.func_27356_a(object) && this.field_27061_b.func_27356_a(this.field_27062_a.func_27357_b(object));
    }

    @Override
    public Object func_27059_b(Object object) {
        Object object2;
        try {
            object2 = this.field_27062_a.func_27357_b(object);
        }
        catch (J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException j_JsonNodeDoesNotMatchChainedJsonNodeSelectorException) {
            throw J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException.func_27321_b(j_JsonNodeDoesNotMatchChainedJsonNodeSelectorException, this.field_27062_a);
        }
        try {
            Object object3 = this.field_27061_b.func_27357_b(object2);
            return object3;
        }
        catch (J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException j_JsonNodeDoesNotMatchChainedJsonNodeSelectorException) {
            throw J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException.func_27323_a(j_JsonNodeDoesNotMatchChainedJsonNodeSelectorException, this.field_27062_a);
        }
    }

    @Override
    public String func_27060_a() {
        return this.field_27061_b.func_27358_a();
    }

    public String toString() {
        return this.field_27062_a.toString() + ", with " + this.field_27061_b.toString();
    }
}

