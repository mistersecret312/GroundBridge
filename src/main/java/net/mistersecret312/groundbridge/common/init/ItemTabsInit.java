package net.mistersecret312.groundbridge.common.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.mistersecret312.groundbridge.GroundBridge;

public class ItemTabsInit {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GroundBridge.MODID);

    public static final RegistryObject<CreativeModeTab> MAIN = CREATIVE_MODE_TABS.register("main",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemInit.BLUE_ENERGON.get()))
                    .title(Component.translatable("creativetab.groundbridge.main"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ItemInit.BLUE_ENERGON.get());
                        pOutput.accept(ItemInit.RED_ENERGON.get());
                        pOutput.accept(ItemInit.DARK_ENERGON.get());
                        pOutput.accept(ItemInit.TOXIC_ENERGON.get());
                        pOutput.accept(BlockInit.BLUE_ENERGON_ORE.get());
                        pOutput.accept(BlockInit.RED_ENERGON_ORE.get());
                        pOutput.accept(BlockInit.DARK_ENERGON_ORE.get());
                        pOutput.accept(BlockInit.TOXIC_ENERGON_ORE.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
