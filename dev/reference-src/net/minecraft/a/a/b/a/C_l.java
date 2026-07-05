/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.a.b.a;

import com.a.a.NBTTagCompound;
import net.minecraft.a.a.b.a.TileEntity;

public class C_l
extends TileEntity {
    public String[] signText = new String[]{"", "", "", ""};
    public int lineBeingEdited = -1;
    public int textColor = 0;
    private boolean editable = true;

    @Override
    public void b(NBTTagCompound nBTTagCompound) {
        super.b(nBTTagCompound);
        nBTTagCompound.a("id", "Sign");
        nBTTagCompound.a("Text1", this.signText[0]);
        nBTTagCompound.a("Text2", this.signText[1]);
        nBTTagCompound.a("Text3", this.signText[2]);
        nBTTagCompound.a("Text4", this.signText[3]);
        nBTTagCompound.a("TextColor", this.textColor);
    }

    @Override
    public void a(NBTTagCompound nBTTagCompound) {
        this.editable = false;
        super.a(nBTTagCompound);
        for (int i = 0; i < 4; ++i) {
            this.signText[i] = nBTTagCompound.g("Text" + (i + 1));
            if (this.signText[i].length() <= 15) continue;
            this.signText[i] = this.signText[i].substring(0, 15);
        }
        this.textColor = nBTTagCompound.d("TextColor");
    }

    public void setEditable(boolean bl) {
        this.editable = bl;
    }

    public boolean isEditable() {
        return this.editable;
    }
}

