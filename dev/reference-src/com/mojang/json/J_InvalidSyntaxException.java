/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.J_ThingWithPosition;

public final class J_InvalidSyntaxException
extends Exception {
    private static final long serialVersionUID = 1L;

    J_InvalidSyntaxException(String string, J_ThingWithPosition j_ThingWithPosition) {
        super("At line " + j_ThingWithPosition.func_27330_b() + ", column " + j_ThingWithPosition.func_27331_a() + ":  " + string);
        j_ThingWithPosition.func_27331_a();
        j_ThingWithPosition.func_27330_b();
    }

    J_InvalidSyntaxException(String string, Throwable throwable, J_ThingWithPosition j_ThingWithPosition) {
        super("At line " + j_ThingWithPosition.func_27330_b() + ", column " + j_ThingWithPosition.func_27331_a() + ":  " + string, throwable);
        j_ThingWithPosition.func_27331_a();
        j_ThingWithPosition.func_27330_b();
    }
}

