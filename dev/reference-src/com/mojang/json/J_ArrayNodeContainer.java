/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.J_JsonArrayNodeBuilder;
import com.mojang.json.J_JsonFieldBuilder;
import com.mojang.json.J_JsonListenerToJdomAdapter;
import com.mojang.json.J_JsonNodeBuilder;
import com.mojang.json.J_NodeContainer;

class J_ArrayNodeContainer
implements J_NodeContainer {
    final J_JsonArrayNodeBuilder field_27294_a;
    final J_JsonListenerToJdomAdapter field_27293_b;

    J_ArrayNodeContainer(J_JsonListenerToJdomAdapter j_JsonListenerToJdomAdapter, J_JsonArrayNodeBuilder j_JsonArrayNodeBuilder) {
        this.field_27293_b = j_JsonListenerToJdomAdapter;
        this.field_27294_a = j_JsonArrayNodeBuilder;
    }

    @Override
    public void func_27290_a(J_JsonNodeBuilder j_JsonNodeBuilder) {
        this.field_27294_a.func_27240_a(j_JsonNodeBuilder);
    }

    @Override
    public void func_27289_a(J_JsonFieldBuilder j_JsonFieldBuilder) {
        throw new RuntimeException("Coding failure in Argo:  Attempt to add a field to an array.");
    }
}

