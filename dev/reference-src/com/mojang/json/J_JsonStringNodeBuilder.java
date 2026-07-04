/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.J_JsonNode;
import com.mojang.json.J_JsonNodeBuilder;
import com.mojang.json.J_JsonNodeFactories;
import com.mojang.json.J_JsonStringNode;

public final class J_JsonStringNodeBuilder
implements J_JsonNodeBuilder {
    private final String field_27244_a;

    J_JsonStringNodeBuilder(String string) {
        this.field_27244_a = string;
    }

    public J_JsonStringNode func_27243_a() {
        return J_JsonNodeFactories.func_27316_a(this.field_27244_a);
    }

    @Override
    public J_JsonNode func_27234_b() {
        return this.func_27243_a();
    }
}

