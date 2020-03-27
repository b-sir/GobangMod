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
		
		this.setSoundType(SoundType.STONE);//��ʾ�������ȥ������
		this.setHardness(50.0f);//��ʾ����Ӳ�� ����ʯ��Ӳ��Ϊ50
		this.setHarvestLevel("axe", 1);//pickaxe��ʾ���ӣ�axe��ʾ���� shovel��ʾ���ӣ� 2��ʾ�������ϲ����ھ�3-��ʯ 1-ʯ 0-ľ/��
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
