package marcos.createimmersivetacz;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ModItems {

    public static final Item EXAMPLE_ITEM = register(new Item(new Item.Properties()), "example_item");

    public static final Item GUN_BARREL = register(new Item(new Item.Properties()), "gun_barrel");
    public static final Item GUN_TRIGGER = register(new Item(new Item.Properties()), "gun_trigger");
    public static final Item PRIMER = register(new Item(new Item.Properties()), "primer");


    public static Item register(Item item, String id) {
        ResourceLocation itemID = ResourceLocation.fromNamespaceAndPath(CreateImmersiveTaCZ.MOD_ID, id);
        Item registeredItem = Registry.register(BuiltInRegistries.ITEM, itemID, item);
        return registeredItem;
    }


    public static final ResourceKey<CreativeModeTab> CUSTOM_ITEM_GROUP_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), ResourceLocation.fromNamespaceAndPath(CreateImmersiveTaCZ.MOD_ID, "item_group"));
    public static final CreativeModeTab CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.EXAMPLE_ITEM))
            .title(Component.translatable("creativetab.create_immersive_tacz_tab"))
            .build();

    public static void initialize() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.accept(ModItems.EXAMPLE_ITEM);
            itemGroup.accept(ModItems.GUN_BARREL);
            itemGroup.accept(ModItems.GUN_TRIGGER);
            itemGroup.accept(ModItems.PRIMER);
        });
    }
}
