/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.EnumJsonNodeTypeMappingHelper;
import com.mojang.json.J_JsonEscapedString;
import com.mojang.json.J_JsonFormatter;
import com.mojang.json.J_JsonNode;
import com.mojang.json.J_JsonRootNode;
import com.mojang.json.J_JsonStringNode;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.TreeSet;

public final class J_CompactJsonFormatter
implements J_JsonFormatter {
    @Override
    public String func_27327_a(J_JsonRootNode j_JsonRootNode) {
        StringWriter stringWriter = new StringWriter();
        try {
            this.func_27329_a(j_JsonRootNode, stringWriter);
        }
        catch (IOException iOException) {
            throw new RuntimeException("Coding failure in Argo:  StringWriter gave an IOException", iOException);
        }
        return stringWriter.toString();
    }

    public void func_27329_a(J_JsonRootNode j_JsonRootNode, Writer writer) throws IOException {
        this.func_27328_a(j_JsonRootNode, writer);
    }

    private void func_27328_a(J_JsonNode j_JsonNode, Writer writer) throws IOException {
        boolean bl = true;
        switch (EnumJsonNodeTypeMappingHelper.field_27341_a[j_JsonNode.func_27218_a().ordinal()]) {
            case 1: {
                writer.append('[');
                for (J_JsonNode j_JsonNode2 : j_JsonNode.func_27215_d()) {
                    if (!bl) {
                        writer.append(',');
                    }
                    bl = false;
                    this.func_27328_a(j_JsonNode2, writer);
                }
                writer.append(']');
                break;
            }
            case 2: {
                writer.append('{');
                for (J_JsonStringNode j_JsonStringNode : new TreeSet(j_JsonNode.func_27214_c().keySet())) {
                    if (!bl) {
                        writer.append(',');
                    }
                    bl = false;
                    this.func_27328_a(j_JsonStringNode, writer);
                    writer.append(':');
                    this.func_27328_a((J_JsonNode)j_JsonNode.func_27214_c().get(j_JsonStringNode), writer);
                }
                writer.append('}');
                break;
            }
            case 3: {
                writer.append('\"').append(new J_JsonEscapedString(j_JsonNode.func_27216_b()).toString()).append('\"');
                break;
            }
            case 4: {
                writer.append(j_JsonNode.func_27216_b());
                break;
            }
            case 5: {
                writer.append("false");
                break;
            }
            case 6: {
                writer.append("true");
                break;
            }
            case 7: {
                writer.append("null");
                break;
            }
            default: {
                throw new RuntimeException("Coding failure in Argo:  Attempt to format a JsonNode of unknown type [" + (Object)((Object)j_JsonNode.func_27218_a()) + "];");
            }
        }
    }
}

