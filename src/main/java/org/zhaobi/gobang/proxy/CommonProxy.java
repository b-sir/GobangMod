package org.zhaobi.gobang.proxy;


import org.zhaobi.gobang.event.EventCenter;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) //Ԥ��ʼ��
    {
		
    }

    public void init(FMLInitializationEvent event) //��ʼ��
    {
    	new EventCenter();
    }
    
    public void postInit(FMLPostInitializationEvent event) //��ʼ����
    {
        
    }
}
