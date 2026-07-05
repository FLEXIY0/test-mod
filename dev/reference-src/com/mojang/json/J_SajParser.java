/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.json;

import com.mojang.json.J_InvalidSyntaxException;
import com.mojang.json.J_JsonListener;
import com.mojang.json.J_PositionTrackingPushbackReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public final class J_SajParser {
    public void func_27463_a(Reader reader, J_JsonListener j_JsonListener) throws J_InvalidSyntaxException, IOException {
        J_PositionTrackingPushbackReader j_PositionTrackingPushbackReader = new J_PositionTrackingPushbackReader(reader);
        char c = (char)j_PositionTrackingPushbackReader.func_27333_c();
        switch (c) {
            case '[': {
                j_PositionTrackingPushbackReader.func_27334_a(c);
                j_JsonListener.func_27195_b();
                this.func_27455_a(j_PositionTrackingPushbackReader, j_JsonListener);
                break;
            }
            case '{': {
                j_PositionTrackingPushbackReader.func_27334_a(c);
                j_JsonListener.func_27195_b();
                this.func_27453_b(j_PositionTrackingPushbackReader, j_JsonListener);
                break;
            }
            default: {
                throw new J_InvalidSyntaxException("Expected either [ or { but got [" + c + "].", j_PositionTrackingPushbackReader);
            }
        }
        int n = this.func_27448_l(j_PositionTrackingPushbackReader);
        if (n != -1) {
            throw new J_InvalidSyntaxException("Got unexpected trailing character [" + (char)n + "].", j_PositionTrackingPushbackReader);
        }
        j_JsonListener.func_27204_c();
    }

    private void func_27455_a(J_PositionTrackingPushbackReader j_PositionTrackingPushbackReader, J_JsonListener j_JsonListener) throws J_InvalidSyntaxException, IOException {
        char c = (char)this.func_27448_l(j_PositionTrackingPushbackReader);
        if (c != '[') {
            throw new J_InvalidSyntaxException("Expected object to start with [ but got [" + c + "].", j_PositionTrackingPushbackReader);
        }
        j_JsonListener.func_27200_d();
        char c2 = (char)this.func_27448_l(j_PositionTrackingPushbackReader);
        j_PositionTrackingPushbackReader.func_27334_a(c2);
        if (c2 != ']') {
            this.func_27464_d(j_PositionTrackingPushbackReader, j_JsonListener);
        }
        boolean bl = false;
        block4: while (!bl) {
            char c3 = (char)this.func_27448_l(j_PositionTrackingPushbackReader);
            switch (c3) {
                case ',': {
                    this.func_27464_d(j_PositionTrackingPushbackReader, j_JsonListener);
                    continue block4;
                }
                case ']': {
                    bl = true;
                    continue block4;
                }
            }
            throw new J_InvalidSyntaxException("Expected either , or ] but got [" + c3 + "].", j_PositionTrackingPushbackReader);
        }
        j_JsonListener.func_27197_e();
    }

    private void func_27453_b(J_PositionTrackingPushbackReader j_PositionTrackingPushbackReader, J_JsonListener j_JsonListener) throws J_InvalidSyntaxException, IOException {
        char c = (char)this.func_27448_l(j_PositionTrackingPushbackReader);
        if (c != '{') {
            throw new J_InvalidSyntaxException("Expected object to start with { but got [" + c + "].", j_PositionTrackingPushbackReader);
        }
        j_JsonListener.func_27194_f();
        char c2 = (char)this.func_27448_l(j_PositionTrackingPushbackReader);
        j_PositionTrackingPushbackReader.func_27334_a(c2);
        if (c2 != '}') {
            this.func_27449_c(j_PositionTrackingPushbackReader, j_JsonListener);
        }
        boolean bl = false;
        block4: while (!bl) {
            char c3 = (char)this.func_27448_l(j_PositionTrackingPushbackReader);
            switch (c3) {
                case ',': {
                    this.func_27449_c(j_PositionTrackingPushbackReader, j_JsonListener);
                    continue block4;
                }
                case '}': {
                    bl = true;
                    continue block4;
                }
            }
            throw new J_InvalidSyntaxException("Expected either , or } but got [" + c3 + "].", j_PositionTrackingPushbackReader);
        }
        j_JsonListener.func_27203_g();
    }

    private void func_27449_c(J_PositionTrackingPushbackReader j_PositionTrackingPushbackReader, J_JsonListener j_JsonListener) throws J_InvalidSyntaxException, IOException {
        char c = (char)this.func_27448_l(j_PositionTrackingPushbackReader);
        if ('\"' != c) {
            throw new J_InvalidSyntaxException("Expected object identifier to begin with [\"] but got [" + c + "].", j_PositionTrackingPushbackReader);
        }
        j_PositionTrackingPushbackReader.func_27334_a(c);
        j_JsonListener.func_27205_a(this.func_27452_i(j_PositionTrackingPushbackReader));
        char c2 = (char)this.func_27448_l(j_PositionTrackingPushbackReader);
        if (c2 != ':') {
            throw new J_InvalidSyntaxException("Expected object identifier to be followed by : but got [" + c2 + "].", j_PositionTrackingPushbackReader);
        }
        this.func_27464_d(j_PositionTrackingPushbackReader, j_JsonListener);
        j_JsonListener.func_27199_h();
    }

    private void func_27464_d(J_PositionTrackingPushbackReader j_PositionTrackingPushbackReader, J_JsonListener j_JsonListener) throws J_InvalidSyntaxException, IOException {
        char c = (char)this.func_27448_l(j_PositionTrackingPushbackReader);
        switch (c) {
            case '\"': {
                j_PositionTrackingPushbackReader.func_27334_a(c);
                j_JsonListener.func_27198_c(this.func_27452_i(j_PositionTrackingPushbackReader));
                break;
            }
            case '-': 
            case '0': 
            case '1': 
            case '2': 
            case '3': 
            case '4': 
            case '5': 
            case '6': 
            case '7': 
            case '8': 
            case '9': {
                j_PositionTrackingPushbackReader.func_27334_a(c);
                j_JsonListener.func_27201_b(this.func_27459_a(j_PositionTrackingPushbackReader));
                break;
            }
            case '[': {
                j_PositionTrackingPushbackReader.func_27334_a(c);
                this.func_27455_a(j_PositionTrackingPushbackReader, j_JsonListener);
                break;
            }
            case 'f': {
                char[] cArray = new char[4];
                int n = j_PositionTrackingPushbackReader.func_27336_b(cArray);
                if (n == 4 && cArray[0] == 'a' && cArray[1] == 'l' && cArray[2] == 's' && cArray[3] == 'e') {
                    j_JsonListener.func_27193_j();
                    break;
                }
                j_PositionTrackingPushbackReader.func_27335_a(cArray);
                throw new J_InvalidSyntaxException("Expected 'f' to be followed by [[a, l, s, e]], but got [" + Arrays.toString(cArray) + "].", j_PositionTrackingPushbackReader);
            }
            case 'n': {
                char[] cArray = new char[3];
                int n = j_PositionTrackingPushbackReader.func_27336_b(cArray);
                if (n != 3 || cArray[0] != 'u' || cArray[1] != 'l' || cArray[2] != 'l') {
                    j_PositionTrackingPushbackReader.func_27335_a(cArray);
                    throw new J_InvalidSyntaxException("Expected 'n' to be followed by [[u, l, l]], but got [" + Arrays.toString(cArray) + "].", j_PositionTrackingPushbackReader);
                }
                j_JsonListener.func_27202_k();
                break;
            }
            case 't': {
                char[] cArray = new char[3];
                int n = j_PositionTrackingPushbackReader.func_27336_b(cArray);
                if (n != 3 || cArray[0] != 'r' || cArray[1] != 'u' || cArray[2] != 'e') {
                    j_PositionTrackingPushbackReader.func_27335_a(cArray);
                    throw new J_InvalidSyntaxException("Expected 't' to be followed by [[r, u, e]], but got [" + Arrays.toString(cArray) + "].", j_PositionTrackingPushbackReader);
                }
                j_JsonListener.func_27196_i();
                break;
            }
            case '{': {
                j_PositionTrackingPushbackReader.func_27334_a(c);
                this.func_27453_b(j_PositionTrackingPushbackReader, j_JsonListener);
                break;
            }
            default: {
                throw new J_InvalidSyntaxException("Invalid character at start of value [" + c + "].", j_PositionTrackingPushbackReader);
            }
        }
    }

    private String func_27459_a(J_PositionTrackingPushbackReader j_PositionTrackingPushbackReader) throws IOException, J_InvalidSyntaxException {
        StringBuilder stringBuilder = new StringBuilder();
        char c = (char)j_PositionTrackingPushbackReader.func_27333_c();
        if ('-' == c) {
            stringBuilder.append('-');
        } else {
            j_PositionTrackingPushbackReader.func_27334_a(c);
        }
        stringBuilder.append(this.func_27451_b(j_PositionTrackingPushbackReader));
        return stringBuilder.toString();
    }

    private String func_27451_b(J_PositionTrackingPushbackReader j_PositionTrackingPushbackReader) throws IOException, J_InvalidSyntaxException {
        StringBuilder stringBuilder = new StringBuilder();
        char c = (char)j_PositionTrackingPushbackReader.func_27333_c();
        if ('0' == c) {
            stringBuilder.append('0');
            stringBuilder.append(this.func_27462_f(j_PositionTrackingPushbackReader));
            stringBuilder.append(this.func_27454_g(j_PositionTrackingPushbackReader));
        } else {
            j_PositionTrackingPushbackReader.func_27334_a(c);
            stringBuilder.append(this.func_27460_c(j_PositionTrackingPushbackReader));
            stringBuilder.append(this.func_27456_e(j_PositionTrackingPushbackReader));
            stringBuilder.append(this.func_27462_f(j_PositionTrackingPushbackReader));
            stringBuilder.append(this.func_27454_g(j_PositionTrackingPushbackReader));
        }
        return stringBuilder.toString();
    }

    private char func_27460_c(J_PositionTrackingPushbackReader j_PositionTrackingPushbackReader) throws IOException, J_InvalidSyntaxException {
        char c = (char)j_PositionTrackingPushbackReader.func_27333_c();
        switch (c) {
            case '1': 
            case '2': 
            case '3': 
            case '4': 
            case '5': 
            case '6': 
            case '7': 
            case '8': 
            case '9': {
                return c;
            }
        }
        throw new J_InvalidSyntaxException("Expected a digit 1 - 9 but got [" + c + "].", j_PositionTrackingPushbackReader);
    }

    private char func_27458_d(J_PositionTrackingPushbackReader j_PositionTrackingPushbackReader) throws IOException, J_InvalidSyntaxException {
        char c = (char)j_PositionTrackingPushbackReader.func_27333_c();
        switch (c) {
            case '0': 
            case '1': 
            case '2': 
            case '3': 
            case '4': 
            case '5': 
            case '6': 
            case '7': 
            case '8': 
            case '9': {
                return c;
            }
        }
        throw new J_InvalidSyntaxException("Expected a digit 1 - 9 but got [" + c + "].", j_PositionTrackingPushbackReader);
    }

    private String func_27456_e(J_PositionTrackingPushbackReader j_PositionTrackingPushbackReader) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl = false;
        block3: while (!bl) {
            char c = (char)j_PositionTrackingPushbackReader.func_27333_c();
            switch (c) {
                case '0': 
                case '1': 
                case '2': 
                case '3': 
                case '4': 
                case '5': 
                case '6': 
                case '7': 
                case '8': 
                case '9': {
                    stringBuilder.append(c);
                    continue block3;
                }
            }
            bl = true;
            j_PositionTrackingPushbackReader.func_27334_a(c);
        }
        return stringBuilder.toString();
    }

    private String func_27462_f(J_PositionTrackingPushbackReader j_PositionTrackingPushbackReader) throws IOException, J_InvalidSyntaxException {
        StringBuilder stringBuilder = new StringBuilder();
        char c = (char)j_PositionTrackingPushbackReader.func_27333_c();
        if (c == '.') {
            stringBuilder.append('.');
            stringBuilder.append(this.func_27458_d(j_PositionTrackingPushbackReader));
            stringBuilder.append(this.func_27456_e(j_PositionTrackingPushbackReader));
        } else {
            j_PositionTrackingPushbackReader.func_27334_a(c);
        }
        return stringBuilder.toString();
    }

    private String func_27454_g(J_PositionTrackingPushbackReader j_PositionTrackingPushbackReader) throws IOException, J_InvalidSyntaxException {
        StringBuilder stringBuilder = new StringBuilder();
        char c = (char)j_PositionTrackingPushbackReader.func_27333_c();
        if (c != '.' && c != 'E') {
            j_PositionTrackingPushbackReader.func_27334_a(c);
        } else {
            stringBuilder.append('E');
            stringBuilder.append(this.func_27461_h(j_PositionTrackingPushbackReader));
            stringBuilder.append(this.func_27458_d(j_PositionTrackingPushbackReader));
            stringBuilder.append(this.func_27456_e(j_PositionTrackingPushbackReader));
        }
        return stringBuilder.toString();
    }

    private String func_27461_h(J_PositionTrackingPushbackReader j_PositionTrackingPushbackReader) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        char c = (char)j_PositionTrackingPushbackReader.func_27333_c();
        if (c != '+' && c != '-') {
            j_PositionTrackingPushbackReader.func_27334_a(c);
        } else {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private String func_27452_i(J_PositionTrackingPushbackReader j_PositionTrackingPushbackReader) throws J_InvalidSyntaxException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        char c = (char)j_PositionTrackingPushbackReader.func_27333_c();
        if ('\"' != c) {
            throw new J_InvalidSyntaxException("Expected [\"] but got [" + c + "].", j_PositionTrackingPushbackReader);
        }
        boolean bl = false;
        block4: while (!bl) {
            char c2 = (char)j_PositionTrackingPushbackReader.func_27333_c();
            switch (c2) {
                case '\"': {
                    bl = true;
                    continue block4;
                }
                case '\\': {
                    char c3 = this.func_27457_j(j_PositionTrackingPushbackReader);
                    stringBuilder.append(c3);
                    continue block4;
                }
            }
            stringBuilder.append(c2);
        }
        return stringBuilder.toString();
    }

    private char func_27457_j(J_PositionTrackingPushbackReader j_PositionTrackingPushbackReader) throws IOException, J_InvalidSyntaxException {
        char c;
        char c2 = (char)j_PositionTrackingPushbackReader.func_27333_c();
        switch (c2) {
            case '\"': {
                c = '\"';
                break;
            }
            case '/': {
                c = '/';
                break;
            }
            case '\\': {
                c = '\\';
                break;
            }
            case 'b': {
                c = '\b';
                break;
            }
            case 'f': {
                c = '\f';
                break;
            }
            case 'n': {
                c = '\n';
                break;
            }
            case 'r': {
                c = '\r';
                break;
            }
            case 't': {
                c = '\t';
                break;
            }
            case 'u': {
                c = (char)this.func_27450_k(j_PositionTrackingPushbackReader);
                break;
            }
            default: {
                throw new J_InvalidSyntaxException("Unrecognised escape character [" + c2 + "].", j_PositionTrackingPushbackReader);
            }
        }
        return c;
    }

    private int func_27450_k(J_PositionTrackingPushbackReader j_PositionTrackingPushbackReader) throws IOException, J_InvalidSyntaxException {
        char[] cArray = new char[4];
        int n = j_PositionTrackingPushbackReader.func_27336_b(cArray);
        if (n != 4) {
            throw new J_InvalidSyntaxException("Expected a 4 digit hexidecimal number but got only [" + n + "], namely [" + String.valueOf(cArray, 0, n) + "].", j_PositionTrackingPushbackReader);
        }
        try {
            int n2 = Integer.parseInt(String.valueOf(cArray), 16);
            return n2;
        }
        catch (NumberFormatException numberFormatException) {
            j_PositionTrackingPushbackReader.func_27335_a(cArray);
            throw new J_InvalidSyntaxException("Unable to parse [" + String.valueOf(cArray) + "] as a hexidecimal number.", numberFormatException, j_PositionTrackingPushbackReader);
        }
    }

    private int func_27448_l(J_PositionTrackingPushbackReader j_PositionTrackingPushbackReader) throws IOException {
        int n;
        boolean bl = false;
        do {
            n = j_PositionTrackingPushbackReader.func_27333_c();
            switch (n) {
                case 9: 
                case 10: 
                case 13: 
                case 32: {
                    break;
                }
                default: {
                    bl = true;
                }
            }
        } while (!bl);
        return n;
    }
}

