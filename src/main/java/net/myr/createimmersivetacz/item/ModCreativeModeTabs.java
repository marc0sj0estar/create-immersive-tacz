package net.myr.createimmersivetacz.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.myr.createimmersivetacz.CreateImmersiveTacz;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateImmersiveTacz.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MOD_TAB = CREATIVE_MODE_TABS.register("create_immersive_tacz_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GUN_BARREL.get()))
                    .title(Component.translatable("creativetab.create_immersive_tacz_tab"))
                    .displayItems((ItemDisplayParameters, output) ->
                    {
                        output.accept(ModItems.GUN_BARREL.get());
                        output.accept(ModItems.GUN_TRIGGER.get());
                        output.accept(ModItems.GUNPOWDER_BUCKET.get());
                        output.accept(ModItems.SLAP_CASING.get());
                        output.accept(ModItems.PNEUMATIC_PISTOL_CASING.get());
                        output.accept(ModItems.RIMMED_BLUNT_AP_CASING.get());
                        output.accept(ModItems.TWELVE_GAUGE_SHELL.get());
                        output.accept(ModItems.PRIMER.get());
                        output.accept(ModItems.FIRING_MECHANISM.get());
                        output.accept(ModItems.NITROPOWDER_BUCKET.get());
                    })
                    .build());
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
