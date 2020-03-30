package org.zhaobi.gobang;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class GobangCreativeTabs extends CreativeTabs {

	public static GobangCreativeTabs tabGobang = new GobangCreativeTabs();
	
	public GobangCreativeTabs() {
		super("gobang");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(GobangMod.proxy.b_Board);
	}

}
