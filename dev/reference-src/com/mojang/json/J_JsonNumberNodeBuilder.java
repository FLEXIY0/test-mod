/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.J_JsonNode;
import com.mojang.json.J_JsonNodeBuilder;
import com.mojang.json.J_JsonNodeFactories;

final class J_JsonNumberNodeBuilder
implements J_JsonNodeBuilder {
    private final J_JsonNode field_27239_a;

    J_JsonNumberNodeBuilder(String string) {
        this.field_27239_a = J_JsonNodeFactories.func_27311_b(string);
    }

    @Override
    public J_JsonNode func_27234_b() {
        return this.field_27239_a;
    }
}

