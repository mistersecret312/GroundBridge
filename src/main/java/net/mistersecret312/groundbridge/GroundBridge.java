package net.mistersecret312.groundbridge;

import net.mistersecret312.groundbridge.common.init.BlockInit;
import net.mistersecret312.groundbridge.common.init.ItemInit;
import net.mistersecret312.groundbridge.common.init.ItemTabsInit;
import net.mistersecret312.groundbridge.common.init.WorldGenInit;
import net.mistersecret312.groundbridge.common.network.GBNetwork;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(GroundBridge.MODID)
public class GroundBridge
{
    
    public static final String MODID = "groundbridge";
    
    public static final Logger LOGGER = LogUtils.getLogger();

    public GroundBridge()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        BlockInit.register(modEventBus);
        ItemInit.register(modEventBus);
        ItemTabsInit.register(modEventBus);
        WorldGenInit.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        GBNetwork.registerPackets();
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }

        @SubscribeEvent
        public static void registerDimensionalEffects(RegisterDimensionSpecialEffectsEvent event){

        }
    }
}
