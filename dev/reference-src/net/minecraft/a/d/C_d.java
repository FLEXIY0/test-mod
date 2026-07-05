/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.d;

import net.minecraft.a.d.C_e;

final class C_d
extends ThreadLocal<Object> {
    C_d() {
    }

    protected C_e createNewDefaultPool() {
        return new C_e(300, 2000);
    }

    @Override
    protected Object initialValue() {
        return this.createNewDefaultPool();
    }
}

