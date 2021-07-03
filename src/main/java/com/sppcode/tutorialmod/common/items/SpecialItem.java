package com.sppcode.tutorialmod.common.items;

import java.util.List;

//import javax.swing.text.html.parser.Entity;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.Minecraft;
//import net.minecraft.client.gui.fonts.TexturedGlyph.Effect;
//import net.minecraft.client.util.ITooltipFlag;
//import net.minecraft.client.util.InputMappings;
import net.minecraft.client.util.*;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
//import net.minecraft.potion.AbsorptionEffect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
//import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
//import net.minecraftforge.event.entity.EntityJoinWorldEvent;


public class SpecialItem extends Item {
	
	public SpecialItem(Properties properties) {
		super(properties);
	}
	
	@Override	//the "appendHoverText" replaces the old "addInformation"
	@OnlyIn(Dist.CLIENT)	//denotes a client only property
	public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip,
			ITooltipFlag flagIn) {
		
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
		if(InputMappings.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), GLFW.GLFW_KEY_LEFT_SHIFT)) 
		{
			tooltip.add(new TranslationTextComponent("\u00A7eCongrats nice work..."));
		}
		else
		{
			tooltip.add(new TranslationTextComponent("tooltip.special_item.hold_shift"));
		}
	}
	
	@Override	//the "use" replaces the old "onItemRightClick"
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
		
		playerIn.addEffect(new EffectInstance(Effects.GLOWING, 200, 5));
		
		/*
		ZombieEntity entity = new ZombieEntity(worldIn);
		entity.setPos(playerIn.getX(), playerIn.getY(), playerIn.getZ());
		worldIn.addFreshEntity(entity);*/
		playerIn.getCooldowns().addCooldown(this, 100);
		
		return ActionResult.success(playerIn.getItemInHand(handIn));
	}
}
