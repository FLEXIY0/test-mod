/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import com.a.a.NBTTagCompound;
import com.a.a.NBTTagList;
import com.a.a.NBTTagString;
import net.minecraft.a.a.World;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;

public class C_v
extends Item {
    public C_v(int n) {
        super(n);
        this.setStackSize(1);
    }

    @Override
    public ItemStack a(ItemStack itemStack, World c_g, EntityPlayer entityPlayer) {
        entityPlayer.displayGUIBook(itemStack);
        return itemStack;
    }

    public boolean getShareTag() {
        return true;
    }

    public static boolean validBookTagPages(NBTTagCompound nBTTagCompound) {
        if (nBTTagCompound == null) {
            return false;
        }
        if (!nBTTagCompound.a("pages")) {
            return false;
        }
        NBTTagList nBTTagList = (NBTTagList)nBTTagCompound.getTag("pages");
        for (int i = 0; i < nBTTagList.b(); ++i) {
            NBTTagString nBTTagString = (NBTTagString)nBTTagList.a(i);
            if (nBTTagString.a == null) {
                return false;
            }
            if (nBTTagString.a.length() <= 256) continue;
            return false;
        }
        return true;
    }
}

