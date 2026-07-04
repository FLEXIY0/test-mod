/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.EnumJsonNodeType;
import com.mojang.json.J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException;
import com.mojang.json.J_JsonNodeDoesNotMatchPathElementsException;
import com.mojang.json.J_JsonNodeFactories;
import com.mojang.json.J_JsonNodeSelector;
import com.mojang.json.J_JsonNodeSelectors;
import java.util.List;
import java.util.Map;

public abstract class J_JsonNode {
    public abstract EnumJsonNodeType func_27218_a();

    public abstract String func_27216_b();

    public abstract Map<?, ?> func_27214_c();

    public abstract List<?> func_27215_d();

    public final String func_27213_a(Object ... objectArray) {
        return (String)this.func_27219_a(J_JsonNodeSelectors.func_27349_a(objectArray), this, objectArray);
    }

    public final List<?> func_27217_b(Object ... objectArray) {
        return (List)this.func_27219_a(J_JsonNodeSelectors.func_27346_b(objectArray), this, objectArray);
    }

    private Object func_27219_a(J_JsonNodeSelector j_JsonNodeSelector, J_JsonNode j_JsonNode, Object[] objectArray) {
        try {
            return j_JsonNodeSelector.func_27357_b(j_JsonNode);
        }
        catch (J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException j_JsonNodeDoesNotMatchChainedJsonNodeSelectorException) {
            throw J_JsonNodeDoesNotMatchPathElementsException.func_27319_a(j_JsonNodeDoesNotMatchChainedJsonNodeSelectorException, objectArray, J_JsonNodeFactories.func_27315_a(j_JsonNode));
        }
    }
}

