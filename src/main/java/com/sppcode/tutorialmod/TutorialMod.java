package com.sppcode.tutorialmod;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sppcode.tutorialmod.core.init.BlockInit;
import com.sppcode.tutorialmod.core.init.ItemInit;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TutorialMod.MOD_ID)

public class TutorialMod
{
	public static final String MOD_ID = "tutorial";
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

   
    
    
    
    //btw, recognize this? this is an object basically!
    public TutorialMod() 
    {
    	IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    	bus.addListener(this::setup);

    	
    	ItemInit.ITEMS.register(bus); //this officially regsters our item I guess lol
    	
    	//Block Items...
    	BlockInit.BLOCKS.register(bus);
    	
    	
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    
    
    
    
    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        
    }



}
