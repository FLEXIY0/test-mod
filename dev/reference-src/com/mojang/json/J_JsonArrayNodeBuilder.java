/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.J_JsonNode;
import com.mojang.json.J_JsonNodeBuilder;
import com.mojang.json.J_JsonNodeFactories;
import com.mojang.json.J_JsonRootNode;
import java.util.LinkedList;
import java.util.List;

public final class J_JsonArrayNodeBuilder
implements J_JsonNodeBuilder {
    private final List<J_JsonNodeBuilder> field_27242_a = new LinkedList<J_JsonNodeBuilder>();

    public J_JsonArrayNodeBuilder func_27240_a(J_JsonNodeBuilder j_JsonNodeBuilder) {
        this.field_27242_a.add(j_JsonNodeBuilder);
        return this;
    }

    public J_JsonRootNode func_27241_a() {
        LinkedList<J_JsonNode> linkedList = new LinkedList<J_JsonNode>();
        for (J_JsonNodeBuilder j_JsonNodeBuilder : this.field_27242_a) {
            linkedList.add(j_JsonNodeBuilder.func_27234_b());
        }
        return J_JsonNodeFactories.func_27309_a(linkedList);
    }

    @Override
    public J_JsonNode func_27234_b() {
        return this.func_27241_a();
    }
}

