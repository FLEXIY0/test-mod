/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.J_JsonFieldBuilder;
import com.mojang.json.J_JsonListenerToJdomAdapter;
import com.mojang.json.J_JsonNodeBuilder;
import com.mojang.json.J_JsonObjectNodeBuilder;
import com.mojang.json.J_NodeContainer;

class J_ObjectNodeContainer
implements J_NodeContainer {
    final J_JsonObjectNodeBuilder field_27296_a;
    final J_JsonListenerToJdomAdapter field_27295_b;

    J_ObjectNodeContainer(J_JsonListenerToJdomAdapter j_JsonListenerToJdomAdapter, J_JsonObjectNodeBuilder j_JsonObjectNodeBuilder) {
        this.field_27295_b = j_JsonListenerToJdomAdapter;
        this.field_27296_a = j_JsonObjectNodeBuilder;
    }

    @Override
    public void func_27290_a(J_JsonNodeBuilder j_JsonNodeBuilder) {
        throw new RuntimeException("Coding failure in Argo:  Attempt to add a node to an object.");
    }

    @Override
    public void func_27289_a(J_JsonFieldBuilder j_JsonFieldBuilder) {
        this.field_27296_a.func_27237_a(j_JsonFieldBuilder);
    }
}

