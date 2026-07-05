/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.J_JsonNode;
import java.util.ArrayList;

final class J_JsonNodeList
extends ArrayList<Object> {
    private static final long serialVersionUID = 1L;
    final Iterable<?> field_27405_a;

    J_JsonNodeList(Iterable<?> iterable) {
        this.field_27405_a = iterable;
        for (J_JsonNode j_JsonNode : this.field_27405_a) {
            this.add(j_JsonNode);
        }
    }
}

