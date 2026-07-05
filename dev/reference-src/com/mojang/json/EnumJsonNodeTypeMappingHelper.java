/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.EnumJsonNodeType;

class EnumJsonNodeTypeMappingHelper {
    static final int[] field_27341_a = new int[EnumJsonNodeType.values().length];

    EnumJsonNodeTypeMappingHelper() {
    }

    static {
        try {
            EnumJsonNodeTypeMappingHelper.field_27341_a[EnumJsonNodeType.ARRAY.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            EnumJsonNodeTypeMappingHelper.field_27341_a[EnumJsonNodeType.OBJECT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            EnumJsonNodeTypeMappingHelper.field_27341_a[EnumJsonNodeType.STRING.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            EnumJsonNodeTypeMappingHelper.field_27341_a[EnumJsonNodeType.NUMBER.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            EnumJsonNodeTypeMappingHelper.field_27341_a[EnumJsonNodeType.FALSE.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            EnumJsonNodeTypeMappingHelper.field_27341_a[EnumJsonNodeType.TRUE.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            EnumJsonNodeTypeMappingHelper.field_27341_a[EnumJsonNodeType.NULL.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

