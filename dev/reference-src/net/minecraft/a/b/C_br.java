/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.a.b;

import com.a.a.NBTTagCompound;
import com.a.a.NBTTagString;
import net.minecraft.a.a.C_g;
import net.minecraft.a.b.C_v;
import net.minecraft.a.b.Item;
import net.minecraft.a.b.ItemStack;
import net.minecraft.a.c.e.EntityPlayer;
import net.minecraft.client.statistics.StatList;

public class C_br
extends Item {
    public C_br(int n) {
        super(n);
        this.setStackSize(1);
    }

    public static boolean validBookTagContents(NBTTagCompound nBTTagCompound) {
        if (!C_v.validBookTagPages(nBTTagCompound)) {
            return false;
        }
        if (!nBTTagCompound.a("title")) {
            return false;
        }
        String string = nBTTagCompound.g("title");
        return string != null && string.length() <= 16 ? nBTTagCompound.a("author") : false;
    }

    @Override
    public String getItemName(ItemStack itemStack) {
        NBTTagCompound nBTTagCompound;
        NBTTagString nBTTagString;
        if (itemStack.hasTagCompound() && (nBTTagString = (NBTTagString)(nBTTagCompound = itemStack.getTagCompound()).getTag("title")) != null) {
            return nBTTagString.toString();
        }
        return super.getItemName(itemStack);
    }

    @Override
    public String getItemDescription(ItemStack itemStack, int n) {
        NBTTagCompound nBTTagCompound;
        NBTTagString nBTTagString;
        if (itemStack.hasTagCompound() && (nBTTagString = (NBTTagString)(nBTTagCompound = itemStack.getTagCompound()).getTag("author")) != null) {
            this.desc[0] = nBTTagString.toString();
        }
        return this.desc[n];
    }

    @Override
    public int getItemDescriptionLength(ItemStack itemStack) {
        return this.desc.length + (itemStack.hasTagCompound() ? 0 : 0);
    }

    @Override
    public ItemStack a(ItemStack itemStack, C_g c_g, EntityPlayer entityPlayer) {
        entityPlayer.addStat(StatList.objectUseStats[itemStack.c], 1);
        entityPlayer.displayGUIBook(itemStack);
        return itemStack;
    }
}

