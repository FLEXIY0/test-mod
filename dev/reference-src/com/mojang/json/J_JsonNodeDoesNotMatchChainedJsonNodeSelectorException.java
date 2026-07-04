/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.J_Functor;
import com.mojang.json.J_JsonNodeDoesNotMatchJsonNodeSelectorException;
import com.mojang.json.J_JsonNodeSelector;
import java.util.LinkedList;
import java.util.List;

public final class J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException
extends J_JsonNodeDoesNotMatchJsonNodeSelectorException {
    private static final long serialVersionUID = 1L;
    final J_Functor field_27326_a;
    final List<J_JsonNodeSelector> field_27325_b;

    static J_JsonNodeDoesNotMatchJsonNodeSelectorException func_27322_a(J_Functor j_Functor) {
        return new J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException(j_Functor, new LinkedList<J_JsonNodeSelector>());
    }

    static J_JsonNodeDoesNotMatchJsonNodeSelectorException func_27323_a(J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException j_JsonNodeDoesNotMatchChainedJsonNodeSelectorException, J_JsonNodeSelector j_JsonNodeSelector) {
        LinkedList<J_JsonNodeSelector> linkedList = new LinkedList<J_JsonNodeSelector>(j_JsonNodeDoesNotMatchChainedJsonNodeSelectorException.field_27325_b);
        linkedList.add(j_JsonNodeSelector);
        return new J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException(j_JsonNodeDoesNotMatchChainedJsonNodeSelectorException.field_27326_a, linkedList);
    }

    static J_JsonNodeDoesNotMatchJsonNodeSelectorException func_27321_b(J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException j_JsonNodeDoesNotMatchChainedJsonNodeSelectorException, J_JsonNodeSelector j_JsonNodeSelector) {
        LinkedList<J_JsonNodeSelector> linkedList = new LinkedList<J_JsonNodeSelector>();
        linkedList.add(j_JsonNodeSelector);
        return new J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException(j_JsonNodeDoesNotMatchChainedJsonNodeSelectorException.field_27326_a, linkedList);
    }

    private J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException(J_Functor j_Functor, List<J_JsonNodeSelector> list) {
        super("Failed to match any JSON node at [" + J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException.func_27324_a(list) + "]");
        this.field_27326_a = j_Functor;
        this.field_27325_b = list;
    }

    static String func_27324_a(List<J_JsonNodeSelector> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; --i) {
            stringBuilder.append(list.get(i).func_27358_a());
            if (i == 0) continue;
            stringBuilder.append(".");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "JsonNodeDoesNotMatchJsonNodeSelectorException{failedNode=" + this.field_27326_a + ", failPath=" + this.field_27325_b + '}';
    }
}

