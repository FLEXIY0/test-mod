/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.J_ChainedFunctor;
import com.mojang.json.J_JsonArrayNodeSelector;
import com.mojang.json.J_JsonElementNodeSelector;
import com.mojang.json.J_JsonFieldNodeSelector;
import com.mojang.json.J_JsonNodeFactories;
import com.mojang.json.J_JsonNodeSelector;
import com.mojang.json.J_JsonObjectNodeSelector;
import com.mojang.json.J_JsonStringNode;
import com.mojang.json.J_JsonStringNodeSelector;
import java.util.Arrays;

public final class J_JsonNodeSelectors {
    public static J_JsonNodeSelector func_27349_a(Object ... objectArray) {
        return J_JsonNodeSelectors.func_27352_a(objectArray, new J_JsonNodeSelector(new J_JsonStringNodeSelector()));
    }

    public static J_JsonNodeSelector func_27346_b(Object ... objectArray) {
        return J_JsonNodeSelectors.func_27352_a(objectArray, new J_JsonNodeSelector(new J_JsonArrayNodeSelector()));
    }

    public static J_JsonNodeSelector func_27353_c(Object ... objectArray) {
        return J_JsonNodeSelectors.func_27352_a(objectArray, new J_JsonNodeSelector(new J_JsonObjectNodeSelector()));
    }

    public static J_JsonNodeSelector func_27348_a(String string) {
        return J_JsonNodeSelectors.func_27350_a(J_JsonNodeFactories.func_27316_a(string));
    }

    public static J_JsonNodeSelector func_27350_a(J_JsonStringNode j_JsonStringNode) {
        return new J_JsonNodeSelector(new J_JsonFieldNodeSelector(j_JsonStringNode));
    }

    public static J_JsonNodeSelector func_27351_b(String string) {
        return J_JsonNodeSelectors.func_27353_c(new Object[0]).func_27355_a(J_JsonNodeSelectors.func_27348_a(string));
    }

    public static J_JsonNodeSelector func_27347_a(int n) {
        return new J_JsonNodeSelector(new J_JsonElementNodeSelector(n));
    }

    public static J_JsonNodeSelector func_27354_b(int n) {
        return J_JsonNodeSelectors.func_27346_b(new Object[0]).func_27355_a(J_JsonNodeSelectors.func_27347_a(n));
    }

    private static J_JsonNodeSelector func_27352_a(Object[] objectArray, J_JsonNodeSelector j_JsonNodeSelector) {
        J_JsonNodeSelector j_JsonNodeSelector2 = j_JsonNodeSelector;
        for (int i = objectArray.length - 1; i >= 0; --i) {
            if (objectArray[i] instanceof Integer) {
                j_JsonNodeSelector2 = J_JsonNodeSelectors.func_27345_a(J_JsonNodeSelectors.func_27354_b((Integer)objectArray[i]), j_JsonNodeSelector2);
                continue;
            }
            if (!(objectArray[i] instanceof String)) {
                throw new IllegalArgumentException("Element [" + objectArray[i] + "] of path elements [" + Arrays.toString(objectArray) + "] was of illegal type [" + objectArray[i].getClass().getCanonicalName() + "]; only Integer and String are valid.");
            }
            j_JsonNodeSelector2 = J_JsonNodeSelectors.func_27345_a(J_JsonNodeSelectors.func_27351_b((String)objectArray[i]), j_JsonNodeSelector2);
        }
        return j_JsonNodeSelector2;
    }

    private static J_JsonNodeSelector func_27345_a(J_JsonNodeSelector j_JsonNodeSelector, J_JsonNodeSelector j_JsonNodeSelector2) {
        return new J_JsonNodeSelector(new J_ChainedFunctor(j_JsonNodeSelector, j_JsonNodeSelector2));
    }
}

