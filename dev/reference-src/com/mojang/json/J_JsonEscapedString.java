/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

final class J_JsonEscapedString {
    private final String field_27031_a;

    J_JsonEscapedString(String string) {
        this.field_27031_a = string.replace("\\", "\\\\").replace("\"", "\\\"").replace("\b", "\\b").replace("\f", "\\f").replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t");
    }

    public String toString() {
        return this.field_27031_a;
    }
}

