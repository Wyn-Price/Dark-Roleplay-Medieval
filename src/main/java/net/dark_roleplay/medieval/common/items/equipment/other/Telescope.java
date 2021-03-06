package net.dark_roleplay.medieval.common.items.equipment.other;

import net.dark_roleplay.drpcore.api.items.DRPItem;
import net.dark_roleplay.medieval.client.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class Telescope extends DRPItem{

	public Telescope(String name, String foldername) {
		super(name, foldername, 1);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer playerIn, EnumHand handIn){
		if(world.isRemote){
			ClientProxy.telescopeLevel ++;
			if(ClientProxy.telescopeLevel == 4){
				ClientProxy.telescopeLevel = 0;
				Minecraft.getMinecraft().gameSettings.smoothCamera = false;
			}
		}
        return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }

	
}
