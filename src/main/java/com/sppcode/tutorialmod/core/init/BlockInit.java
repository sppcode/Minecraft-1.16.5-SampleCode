package com.sppcode.tutorialmod.core.init;

import java.util.function.ToIntFunction;

import com.sppcode.tutorialmod.TutorialMod;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, 
			TutorialMod.MOD_ID);
	
	public static final RegistryObject<Block> EXAMPLE_BLOCK =
			BLOCKS.register("example_block", 		//.of is the equivalent of .create
			() -> new Block(AbstractBlock.Properties.of(Material.HEAVY_METAL, MaterialColor.COLOR_BLUE)
					.strength(15f, 30f) //hardness, resistance
					.harvestTool(ToolType.PICKAXE)
					.harvestLevel(2)
					.sound(SoundType.METAL)
					.requiresCorrectToolForDrops()));
	
	public static final RegistryObject<CustomBlock> CUSTOM_BLOCK = BLOCKS.register(CUSTOM_BLOCK, 
			() -> new CustomBlock(AbstractBlock.Properties
					.create(Material.WOOD)
					.harvestTool(ToolType.AXE)
					.harvestLevel(1)
					.sound(SoundType.WOOD)
					.requiresCorrectToolForDrops));
}
