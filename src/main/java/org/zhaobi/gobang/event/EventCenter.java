package org.zhaobi.gobang.event;

import org.zhaobi.gobang.GobangMod;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventCenter {

	public EventCenter() {
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
    public void onPlayerRightClickBlock(PlayerInteractEvent.RightClickBlock event) //右键方块时调用 注意会疯狂调用不止一次
    {
    	BlockPos pos = event.getPos();
    	IBlockState blockState = event.getWorld().getBlockState(pos);
    	Block block = blockState.getBlock();
    	EntityPlayer player = event.getEntityPlayer();
    	World world = event.getWorld();
    	
    	if (world.isRemote) {
			GobangMod.logger.info("Righy Click C");
    	}
    	else
    	{
    		GobangMod.logger.info("Righy Click S");
    	}
    	
    }
	
	@SubscribeEvent(priority = EventPriority.HIGH) //手里有物品 右键时调用
    public void onPlayerRightClickItem(PlayerInteractEvent.RightClickItem event) {
		World world = event.getWorld();
		
		
		if (world.isRemote) {
			GobangMod.logger.info("Right Click IIIII C");
    	}
    	else
    	{
    		GobangMod.logger.info("Right Click IIIII S");
    	}
		
		
		
		event.setCanceled(true);
	}
	
	@SubscribeEvent
    public void pickupItem(EntityItemPickupEvent event) {
        System.out.println("Item picked up!");
        
    }
	
	/*
    @SubscribeEvent
    public void onPlayerDrawBlock(DrawBlockHighlightEvent event) //玩家对准一个方块后会不停的调用
    {
    	//GobangMod.logger.info("DrawBlockHighlightEvent: " + event.getTarget().getBlockPos().toString());
    }
    */
    
}
