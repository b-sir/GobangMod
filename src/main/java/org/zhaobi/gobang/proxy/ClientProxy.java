package org.zhaobi.gobang.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	public void preInit(FMLPreInitializationEvent event) //预初始化
    {
		super.preInit(event);
    }

    public void init(FMLInitializationEvent event) //初始化
    {
    	super.init(event);
    }
    
    public void postInit(FMLPostInitializationEvent event) //初始化后
    {
    	super.postInit(event);
    }
}
