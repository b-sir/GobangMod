package org.zhaobi.gobang.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	public void preInit(FMLPreInitializationEvent event) //Ԥ��ʼ��
    {
		super.preInit(event);
    }

    public void init(FMLInitializationEvent event) //��ʼ��
    {
    	super.init(event);
    }
    
    public void postInit(FMLPostInitializationEvent event) //��ʼ����
    {
    	super.postInit(event);
    }
}
