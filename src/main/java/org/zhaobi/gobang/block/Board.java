package org.zhaobi.gobang.block;

import org.zhaobi.gobang.GobangCreativeTabs;
import org.zhaobi.gobang.GobangMod;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Board extends Block {

	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool EAST  = PropertyBool.create("east");
	public static final PropertyBool WEST  = PropertyBool.create("west");
	
	public Board() 
	{
		super(Material.ROCK);
		
		this.setSoundType(SoundType.STONE);//��ʾ�������ȥ������
		this.setHardness(50.0f);//��ʾ����Ӳ�� ����ʯ��Ӳ��Ϊ50
		this.setHarvestLevel("axe", 1);//pickaxe��ʾ���ӣ�axe��ʾ���� shovel��ʾ���ӣ� 2��ʾ�������ϲ����ھ�3-��ʯ 1-ʯ 0-ľ/��
		this.setCreativeTab(GobangCreativeTabs.tabGobang);
		this.setRegistryName("board");
		
		this.setUnlocalizedName("board");

		this.setDefaultState(getDefaultState()
				.withProperty(NORTH, false)
				.withProperty(SOUTH, false)
				.withProperty(EAST, false)
				.withProperty(WEST, false) );
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
		
    }
	
	@Override
	public BlockStateContainer createBlockState()
    {	
        return new BlockStateContainer(this, new IProperty[] {NORTH, SOUTH, EAST, WEST});
    }
	
	@Override
	public IBlockState getStateFromMeta(int metadata) {
	    return this.getDefaultState();
	}
	@Override
	public int getMetaFromState(IBlockState state) {
	    return 0;
	}
	
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state.withProperty(NORTH, (worldIn.getBlockState(pos.north()).getBlock() instanceof Board))
			.withProperty(SOUTH, (worldIn.getBlockState(pos.south()).getBlock() instanceof Board))
			.withProperty(EAST, (worldIn.getBlockState(pos.east()).getBlock() instanceof Board))
			.withProperty(WEST, (worldIn.getBlockState(pos.west()).getBlock() instanceof Board)) ;
	}
	

	@SideOnly(Side.CLIENT)
	public void clientInit()
	{
		ModelResourceLocation model = new ModelResourceLocation(this.getRegistryName(), "inventory");
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, model);
	}
}
