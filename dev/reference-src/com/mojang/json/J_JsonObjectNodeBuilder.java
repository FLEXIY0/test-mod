/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.J_JsonFieldBuilder;
import com.mojang.json.J_JsonNode;
import com.mojang.json.J_JsonNodeBuilder;
import com.mojang.json.J_JsonNodeFactories;
import com.mojang.json.J_JsonObjectNodeList;
import com.mojang.json.J_JsonRootNode;
import java.util.LinkedList;
import java.util.List;

public final class J_JsonObjectNodeBuilder
implements J_JsonNodeBuilder {
    private final List<J_JsonFieldBuilder> field_27238_a = new LinkedList<J_JsonFieldBuilder>();

    public J_JsonObjectNodeBuilder func_27237_a(J_JsonFieldBuilder j_JsonFieldBuilder) {
        this.field_27238_a.add(j_JsonFieldBuilder);
        return this;
    }

    public J_JsonRootNode func_27235_a() {
        return J_JsonNodeFactories.func_27312_a(new J_JsonObjectNodeList(this));
    }

    @Override
    public J_JsonNode func_27234_b() {
        return this.func_27235_a();
    }

    static List<?> func_27236_a(J_JsonObjectNodeBuilder j_JsonObjectNodeBuilder) {
        return j_JsonObjectNodeBuilder.field_27238_a;
    }
}

