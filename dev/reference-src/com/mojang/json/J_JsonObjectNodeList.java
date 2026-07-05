/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.J_JsonFieldBuilder;
import com.mojang.json.J_JsonObjectNodeBuilder;
import java.util.HashMap;

class J_JsonObjectNodeList
extends HashMap<Object, Object> {
    private static final long serialVersionUID = 1L;
    final J_JsonObjectNodeBuilder field_27308_a;

    J_JsonObjectNodeList(J_JsonObjectNodeBuilder j_JsonObjectNodeBuilder) {
        this.field_27308_a = j_JsonObjectNodeBuilder;
        for (J_JsonFieldBuilder j_JsonFieldBuilder : J_JsonObjectNodeBuilder.func_27236_a(this.field_27308_a)) {
            this.put(j_JsonFieldBuilder.func_27303_b(), j_JsonFieldBuilder.func_27302_c());
        }
    }
}

