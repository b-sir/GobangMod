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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
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
		
		this.setSoundType(SoundType.STONE);//表示方块踩上去的声音
		this.setHardness(50.0f);//表示方块硬度 黑曜石的硬度为50
		this.setHarvestLevel("axe", 1);//pickaxe表示镐子（axe表示斧子 shovel表示铲子） 2表示铁镐以上才能挖掘（3-钻石 1-石 0-木/金）
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
		worldIn.setBlockToAir(pos.up());
		worldIn.setBlockToAir(pos.up(2));
    }
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		IBlockState state2 = getActualState(state, worldIn, pos);
		if (state2.getValue(NORTH) == false 
				&& state2.getValue(SOUTH) == false 
				&& state2.getValue(EAST) == false 
				&& state2.getValue(WEST) == false )
		{ //单独棋盘Block，点击后展开
			GobangMod.logger.info(" Chess Board Opened!  {}", worldIn.isRemote?"C":"S");
			this.openChessBoard(worldIn, pos, state2);
		}
        return false;
    }
	
	//将单独的棋盘Block展开15x15大小
	private void openChessBoard(World worldIn, BlockPos pos, IBlockState state) 
	{
		for(int i = -7; i <=7; i++) {
			for(int j = -7; j <=7; j++) {
				if(i == 0 && j == 0) continue;
				worldIn.setBlockState(pos.add(i, 0, j), this.getDefaultState());
			}
		}
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
