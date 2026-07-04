/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.J_CompactJsonFormatter;
import com.mojang.json.J_JsonFormatter;
import com.mojang.json.J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException;
import com.mojang.json.J_JsonNodeDoesNotMatchJsonNodeSelectorException;
import com.mojang.json.J_JsonRootNode;

public final class J_JsonNodeDoesNotMatchPathElementsException
extends J_JsonNodeDoesNotMatchJsonNodeSelectorException {
    private static final long serialVersionUID = 1L;
    private static final J_JsonFormatter field_27320_a = new J_CompactJsonFormatter();

    static J_JsonNodeDoesNotMatchPathElementsException func_27319_a(J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException j_JsonNodeDoesNotMatchChainedJsonNodeSelectorException, Object[] objectArray, J_JsonRootNode j_JsonRootNode) {
        return new J_JsonNodeDoesNotMatchPathElementsException(j_JsonNodeDoesNotMatchChainedJsonNodeSelectorException, objectArray, j_JsonRootNode);
    }

    private J_JsonNodeDoesNotMatchPathElementsException(J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException j_JsonNodeDoesNotMatchChainedJsonNodeSelectorException, Object[] objectArray, J_JsonRootNode j_JsonRootNode) {
        super(J_JsonNodeDoesNotMatchPathElementsException.func_27318_b(j_JsonNodeDoesNotMatchChainedJsonNodeSelectorException, objectArray, j_JsonRootNode));
    }

    private static String func_27318_b(J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException j_JsonNodeDoesNotMatchChainedJsonNodeSelectorException, Object[] objectArray, J_JsonRootNode j_JsonRootNode) {
        return "Failed to find " + j_JsonNodeDoesNotMatchChainedJsonNodeSelectorException.field_27326_a.toString() + " at [" + J_JsonNodeDoesNotMatchChainedJsonNodeSelectorException.func_27324_a(j_JsonNodeDoesNotMatchChainedJsonNodeSelectorException.field_27325_b) + "] while resolving [" + J_JsonNodeDoesNotMatchPathElementsException.func_27317_a(objectArray) + "] in " + field_27320_a.func_27327_a(j_JsonRootNode) + ".";
    }

    private static String func_27317_a(Object[] objectArray) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl = true;
        Object[] objectArray2 = objectArray;
        int n = objectArray.length;
        for (int i = 0; i < n; ++i) {
            Object object = objectArray2[i];
            if (!bl) {
                stringBuilder.append(".");
            }
            bl = false;
            if (object instanceof String) {
                stringBuilder.append("\"").append(object).append("\"");
                continue;
            }
            stringBuilder.append(object);
        }
        return stringBuilder.toString();
    }
}

