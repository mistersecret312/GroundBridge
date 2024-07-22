package net.mistersecret312.groundbridge.common.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mistersecret312.groundbridge.GroundBridge;
import net.mistersecret312.groundbridge.common.blocks.EnergonCrystalSmallBlock;

import java.util.function.Function;
import java.util.function.Supplier;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GroundBridge.MODID);

    public static final RegistryObject<Block> ENERGON_CRYSTAL_SMALL = registerWithItem("energon_crystal_small", () -> new EnergonCrystalSmallBlock(BlockBehaviour.Properties.of().strength(15F, 15F).noOcclusion()));

    public static <T extends Block> RegistryObject<T> registerWithItem(String name, final Supplier<T> block, Function<Item.Properties, Item.Properties> properties){
        final RegistryObject<T> reg = BLOCKS.register(name, block);
        ItemInit.ITEMS.register(name, () -> new BlockItem(reg.get(), properties.apply(new Item.Properties())));
        return reg;
    }

    public static <T extends Block> RegistryObject<T> registerWithItem(String name, final Supplier<T> block){
        return registerWithItem(name, block, p -> p);
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
