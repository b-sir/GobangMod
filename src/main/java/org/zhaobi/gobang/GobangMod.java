package org.zhaobi.gobang;

import org.apache.logging.log4j.Logger;
import org.zhaobi.gobang.proxy.CommonProxy;


import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = GobangMod.MODID, name = GobangMod.NAME, version = GobangMod.VERSION)
public class GobangMod {
	public static final String MODID = "gobang";
    public static final String NAME = "BSir's Gobang Mod";
    public static final String VERSION = "1.0.0.0";
    
    public static Logger logger;
    
    @SidedProxy(clientSide = "org.zhaobi.gobang.proxy.ClientProxy", 
            serverSide = "org.zhaobi.gobang.proxy.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.init(event);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) //≥ı ºªØ∫Û
    {
    	proxy.postInit(event);
    }
}
