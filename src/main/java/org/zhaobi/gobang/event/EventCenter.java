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
    public void onPlayerRightClickBlock(PlayerInteractEvent.RightClickBlock event) //�Ҽ�����ʱ���� ע�������ò�ֹһ��
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
	
	@SubscribeEvent(priority = EventPriority.HIGH) //��������Ʒ �Ҽ�ʱ����
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
    public void onPlayerDrawBlock(DrawBlockHighlightEvent event) //��Ҷ�׼һ�������᲻ͣ�ĵ���
    {
    	//GobangMod.logger.info("DrawBlockHighlightEvent: " + event.getTarget().getBlockPos().toString());
    }
    */
    
}
