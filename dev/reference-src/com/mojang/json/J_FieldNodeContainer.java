/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.J_JsonFieldBuilder;
import com.mojang.json.J_JsonListenerToJdomAdapter;
import com.mojang.json.J_JsonNodeBuilder;
import com.mojang.json.J_NodeContainer;

class J_FieldNodeContainer
implements J_NodeContainer {
    final J_JsonFieldBuilder field_27292_a;
    final J_JsonListenerToJdomAdapter field_27291_b;

    J_FieldNodeContainer(J_JsonListenerToJdomAdapter j_JsonListenerToJdomAdapter, J_JsonFieldBuilder j_JsonFieldBuilder) {
        this.field_27291_b = j_JsonListenerToJdomAdapter;
        this.field_27292_a = j_JsonFieldBuilder;
    }

    @Override
    public void func_27290_a(J_JsonNodeBuilder j_JsonNodeBuilder) {
        this.field_27292_a.func_27300_b(j_JsonNodeBuilder);
    }

    @Override
    public void func_27289_a(J_JsonFieldBuilder j_JsonFieldBuilder) {
        throw new RuntimeException("Coding failure in Argo:  Attempt to add a field to a field.");
    }
}

