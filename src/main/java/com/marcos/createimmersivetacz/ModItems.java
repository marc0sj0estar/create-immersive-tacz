package com.marcos.createimmersivetacz;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public final class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateImmersiveTaCZ.MODID);

    public static final DeferredItem<Item> GUN_BARREL = ITEMS.register(
            "gun_barrel",
            () -> new Item(new Item.Properties())
    );

    public static final DeferredItem<Item> GUN_TRIGGER = ITEMS.register(
            "gun_trigger",
            () -> new Item(new Item.Properties())
    );

    public static final DeferredItem<Item> PRIMER = ITEMS.register(
            "primer",
            () -> new Item(new Item.Properties())
    );

    public static final DeferredItem<Item> SLAP_CASING = ITEMS.register(
            "slap_casing",
            () -> new Item(new Item.Properties())
    );

    public static final DeferredItem<Item> RIMMED_BLUNT_AP_CASING = ITEMS.register(
            "rimmed_blunt_ap_casing",
            () -> new Item(new Item.Properties())
    );

    public static final DeferredItem<Item> PNEUMATIC_PISTOL_CASING = ITEMS.register(
            "pneumatic_pistol_casing",
            () -> new Item(new Item.Properties())
    );

    public static final DeferredItem<Item> TWELVE_GAUGE_SHELL = ITEMS.register(
            "twelve_gauge_shell",
            () -> new Item(new Item.Properties())
    );

    public static final DeferredItem<Item> FIRING_MECHANISM = ITEMS.register(
            "firing_mechanism",
            () -> new Item(new Item.Properties())
    );

    public static final DeferredItem<Item> GRENADE_CASING = ITEMS.register(
            "grenade_casing",
            () -> new Item(new Item.Properties())
    );

    public static final DeferredItem<Item> HE_CASING = ITEMS.register(
            "40mmhe_casing",
            () -> new Item(new Item.Properties())
    );


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
