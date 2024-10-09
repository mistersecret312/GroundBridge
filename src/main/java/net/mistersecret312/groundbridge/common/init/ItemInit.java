package net.mistersecret312.groundbridge.common.init;

import java.util.function.Function;

import net.minecraft.ChatFormatting;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mistersecret312.groundbridge.GroundBridge;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GroundBridge.MODID);

    public static final RegistryObject<Item> BLUE_ENERGON = ITEMS.register("energon", () -> new Item(new Item.Properties().stacksTo(64)
            .rarity(Rarity.create("blue_energon", ChatFormatting.BLUE))));
    public static final RegistryObject<Item> RED_ENERGON = ITEMS.register("red_energon", () -> new Item(new Item.Properties().stacksTo(64)
            .rarity(Rarity.create("red_energon", ChatFormatting.DARK_RED))));
    public static final RegistryObject<Item> DARK_ENERGON = ITEMS.register("dark_energon", () -> new Item(new Item.Properties().stacksTo(64)
            .rarity(Rarity.create("dark_energon", ChatFormatting.DARK_PURPLE))));
    public static final RegistryObject<Item> TOXIC_ENERGON = ITEMS.register("toxic_energon", () -> new Item(new Item.Properties().stacksTo(64)
            .rarity(Rarity.create("toxic_energon", ChatFormatting.GREEN))));

    public static RegistryObject<BlockItem> registerBlockItem(RegistryObject<?extends Block> block, Function<Item.Properties, Item.Properties> prop){
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), prop.apply(new Item.Properties())));
    }

    public static RegistryObject<BlockItem> registerBlockItem(RegistryObject<? extends Block> block){
        return registerBlockItem(block, prop -> prop);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
