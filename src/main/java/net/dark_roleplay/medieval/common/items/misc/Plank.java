package net.dark_roleplay.medieval.common.items.misc;

import java.util.List;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Plank extends Item {

	private static String unlocalizedName = "Plank";

	public Plank() {
		this.setHasSubtypes(true);
		this.setRegistryName("Plank");
		this.setUnlocalizedName("Plank");
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab);
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item itemIn, CreativeTabs tab, List subItems) {

		List<ItemStack> subItems2 = (List<ItemStack>) subItems;

		for(int i = 0; i < 6; i++){
			subItems2.add(new ItemStack(itemIn, 1, i));
		}

		subItems = subItems2;
	}

}