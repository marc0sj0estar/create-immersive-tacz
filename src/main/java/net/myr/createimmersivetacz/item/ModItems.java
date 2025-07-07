package net.myr.createimmersivetacz.item;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.myr.createimmersivetacz.CreateImmersiveTacz;
import net.myr.createimmersivetacz.fluid.ModFluids;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CreateImmersiveTacz.MOD_ID);

    public static final RegistryObject<Item> GUN_BARREL = ITEMS.register("gunbarrel", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GUN_TRIGGER = ITEMS.register("gun_trigger", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PRIMER = ITEMS.register("primer", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SLAP_CASING = ITEMS.register("slap_casing", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RIMMED_BLUNT_AP_CASING = ITEMS.register("rimmed_blunt_ap_casing", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PNEUMATIC_PISTOL_CASING = ITEMS.register("pneumatic_pistol_casing", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TWELVE_GAUGE_SHELL = ITEMS.register("twelve_gauge_shell", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FIRING_MECHANISM = ITEMS.register("firing_mechanism", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GERNADE_CASING = ITEMS.register("gernade_casing", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HE_CASING = ITEMS.register("40mmhe_casing", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GUNPOWDER_BUCKET = ITEMS.register("gunpowder_bucket",
            () -> new BucketItem(ModFluids.SOURCE_GUNPOWDER,
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> NITROPOWDER_BUCKET = ITEMS.register("nitropowder_bucket",
            () -> new BucketItem(ModFluids.SOURCE_NITROPOWDER,
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}