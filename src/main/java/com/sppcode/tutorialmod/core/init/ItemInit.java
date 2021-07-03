package com.sppcode.tutorialmod.core.init;

import com.sppcode.tutorialmod.TutorialMod;
import com.sppcode.tutorialmod.common.items.SpecialItem;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

	//We use deferred registers to register most kinds of items
	//into the game.
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, 
			TutorialMod.MOD_ID);
	
	//btw, what used to be item.properties().group...
	//is now item.properties().tab !!!
	public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", 
			() -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));

	
	public static final RegistryObject<SpecialItem> SPECIAL_ITEM = ITEMS.register("special_item", 
			() -> new SpecialItem(new Item.Properties()
					.tab(ItemGroup.TAB_MISC)
					.durability(100)
					.defaultDurability(5)));
	
	
	//Block Items...
	
	public static final RegistryObject<BlockItem> EXAMPLE_BLOCK =
			ITEMS.register("example_block", () ->
			new BlockItem(BlockInit.EXAMPLE_BLOCK.get(), 
					new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
}