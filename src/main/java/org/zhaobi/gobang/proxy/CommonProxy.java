package org.zhaobi.gobang.proxy;


import org.zhaobi.gobang.block.Board;
import org.zhaobi.gobang.event.EventCenter;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class CommonProxy {

	public Board b_Board;
	
	public void preInit(FMLPreInitializationEvent event) //预初始化
    {
		registerItems();//注册所有的物品
    }

    public void init(FMLInitializationEvent event) //初始化
    {
    	new EventCenter();
    }
    
    public void postInit(FMLPostInitializationEvent event) //初始化后
    {
        
    }
    
    
    private void registerItems()//注册所有的物品
    {
    	this.b_Board = new Board();
    	this.registerABlock(b_Board);
    }
    
    private void registerAItem(Item item) 
    {
    	ForgeRegistries.ITEMS.register(item);
    }
    
    private void registerABlock(Block block)
    {
    	ForgeRegistries.BLOCKS.register(block);
    	
    	ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }
}
