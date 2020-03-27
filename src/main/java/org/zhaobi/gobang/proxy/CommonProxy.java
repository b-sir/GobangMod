package org.zhaobi.gobang.proxy;


import org.zhaobi.gobang.event.EventCenter;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) //预初始化
    {
		
    }

    public void init(FMLInitializationEvent event) //初始化
    {
    	new EventCenter();
    }
    
    public void postInit(FMLPostInitializationEvent event) //初始化后
    {
        
    }
}
