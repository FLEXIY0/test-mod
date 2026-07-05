/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.J_JsonNode;
import com.mojang.json.J_JsonNodeBuilder;
import com.mojang.json.J_JsonStringNode;

final class J_JsonFieldBuilder {
    private J_JsonNodeBuilder field_27306_a;
    private J_JsonNodeBuilder field_27305_b;

    J_JsonFieldBuilder() {
    }

    static J_JsonFieldBuilder func_27301_a() {
        return new J_JsonFieldBuilder();
    }

    J_JsonFieldBuilder func_27304_a(J_JsonNodeBuilder j_JsonNodeBuilder) {
        this.field_27306_a = j_JsonNodeBuilder;
        return this;
    }

    J_JsonFieldBuilder func_27300_b(J_JsonNodeBuilder j_JsonNodeBuilder) {
        this.field_27305_b = j_JsonNodeBuilder;
        return this;
    }

    J_JsonStringNode func_27303_b() {
        return (J_JsonStringNode)this.field_27306_a.func_27234_b();
    }

    J_JsonNode func_27302_c() {
        return this.field_27305_b.func_27234_b();
    }
}

