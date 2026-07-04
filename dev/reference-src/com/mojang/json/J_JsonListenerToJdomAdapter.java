/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.J_ArrayNodeContainer;
import com.mojang.json.J_FieldNodeContainer;
import com.mojang.json.J_JsonArrayNodeBuilder;
import com.mojang.json.J_JsonFieldBuilder;
import com.mojang.json.J_JsonListener;
import com.mojang.json.J_JsonNodeBuilder;
import com.mojang.json.J_JsonNodeBuilders;
import com.mojang.json.J_JsonObjectNodeBuilder;
import com.mojang.json.J_JsonRootNode;
import com.mojang.json.J_NodeContainer;
import com.mojang.json.J_ObjectNodeContainer;
import java.util.Stack;

final class J_JsonListenerToJdomAdapter
implements J_JsonListener {
    private final Stack<J_NodeContainer> field_27210_a = new Stack();
    private J_JsonNodeBuilder field_27209_b;

    J_JsonListenerToJdomAdapter() {
    }

    J_JsonRootNode func_27208_a() {
        return (J_JsonRootNode)this.field_27209_b.func_27234_b();
    }

    @Override
    public void func_27195_b() {
    }

    @Override
    public void func_27204_c() {
    }

    @Override
    public void func_27200_d() {
        J_JsonArrayNodeBuilder j_JsonArrayNodeBuilder = J_JsonNodeBuilders.func_27249_e();
        this.func_27207_a(j_JsonArrayNodeBuilder);
        this.field_27210_a.push(new J_ArrayNodeContainer(this, j_JsonArrayNodeBuilder));
    }

    @Override
    public void func_27197_e() {
        this.field_27210_a.pop();
    }

    @Override
    public void func_27194_f() {
        J_JsonObjectNodeBuilder j_JsonObjectNodeBuilder = J_JsonNodeBuilders.func_27253_d();
        this.func_27207_a(j_JsonObjectNodeBuilder);
        this.field_27210_a.push(new J_ObjectNodeContainer(this, j_JsonObjectNodeBuilder));
    }

    @Override
    public void func_27203_g() {
        this.field_27210_a.pop();
    }

    @Override
    public void func_27205_a(String string) {
        J_JsonFieldBuilder j_JsonFieldBuilder = J_JsonFieldBuilder.func_27301_a().func_27304_a(J_JsonNodeBuilders.func_27254_b(string));
        this.field_27210_a.peek().func_27289_a(j_JsonFieldBuilder);
        this.field_27210_a.push(new J_FieldNodeContainer(this, j_JsonFieldBuilder));
    }

    @Override
    public void func_27199_h() {
        this.field_27210_a.pop();
    }

    @Override
    public void func_27201_b(String string) {
        this.func_27206_b(J_JsonNodeBuilders.func_27250_a(string));
    }

    @Override
    public void func_27196_i() {
        this.func_27206_b(J_JsonNodeBuilders.func_27251_b());
    }

    @Override
    public void func_27198_c(String string) {
        this.func_27206_b(J_JsonNodeBuilders.func_27254_b(string));
    }

    @Override
    public void func_27193_j() {
        this.func_27206_b(J_JsonNodeBuilders.func_27252_c());
    }

    @Override
    public void func_27202_k() {
        this.func_27206_b(J_JsonNodeBuilders.func_27248_a());
    }

    private void func_27207_a(J_JsonNodeBuilder j_JsonNodeBuilder) {
        if (this.field_27209_b == null) {
            this.field_27209_b = j_JsonNodeBuilder;
        } else {
            this.func_27206_b(j_JsonNodeBuilder);
        }
    }

    private void func_27206_b(J_JsonNodeBuilder j_JsonNodeBuilder) {
        this.field_27210_a.peek().func_27290_a(j_JsonNodeBuilder);
    }
}

