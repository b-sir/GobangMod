package org.zhaobi.gobang.block;

import org.zhaobi.gobang.GobangCreativeTabs;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Board extends Block {

	public Board() 
	{
		super(Material.ROCK);
		
		this.setSoundType(SoundType.STONE);//表示方块踩上去的声音
		this.setHardness(50.0f);//表示方块硬度 黑曜石的硬度为50
		this.setHarvestLevel("axe", 1);//pickaxe表示镐子（axe表示斧子 shovel表示铲子） 2表示铁镐以上才能挖掘（3-钻石 1-石 0-木/金）
		this.setCreativeTab(GobangCreativeTabs.tabGobang);
		this.setRegistryName("board");
		
		this.setUnlocalizedName("board");
	}

	@SideOnly(Side.CLIENT)
	public void clientInit()
	{
		ModelResourceLocation model = new ModelResourceLocation(this.getRegistryName(), "inventory");
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, model);
	}
}
