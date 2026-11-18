package com.marcos.createimmersivetacz;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.client.event.RegisterClientCommandsEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(CreateImmersiveTaCZ.MODID)
public class CreateImmersiveTaCZ {

    public static final String MODID = "createimmersivetacz";
    private static final Logger LOGGER = LogUtils.getLogger();
    private static boolean createArmorerInstalled = false;

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATIVE_MODE_TAB = CREATIVE_MODE_TABS.register("creative_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("creativetab.create_immersive_tacz_tab")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ModItems.GUN_TRIGGER.get().getDefaultInstance())
            .displayItems((parameters, output) -> {

                output.accept(ModItems.GUN_BARREL.get());
                output.accept(ModItems.GUN_TRIGGER.get());
                output.accept(ModItems.FIRING_MECHANISM.get());
                output.accept(ModItems.PRIMER.get());

                output.accept(ModItems.SLAP_CASING.get());
                output.accept(ModItems.RIMMED_BLUNT_AP_CASING.get());
                output.accept(ModItems.PNEUMATIC_PISTOL_CASING.get());
                output.accept(ModItems.TWELVE_GAUGE_SHELL.get());
                output.accept(ModItems.GRENADE_CASING.get());
                output.accept(ModItems.HE_CASING.get());

                output.accept(ModFluids.GUNPOWDER_BUCKET.get());
                output.accept(ModFluids.NITROPOWDER_BUCKET.get());


            }).build());

    public CreateImmersiveTaCZ(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        CREATIVE_MODE_TABS.register(modEventBus);

        ModItems.register(modEventBus);
        ModFluids.register(modEventBus);



        NeoForge.EVENT_BUS.register(this);

        modContainer.registerConfig(ModConfig.Type.CLIENT, Config.SPEC);


        createArmorerInstalled =
                hasCreateArmorerInstalled("tacz")
                        || hasCreateArmorerInstalled("tacz+1.20.1");

        if (!createArmorerInstalled) {
            LOGGER.error(
                    "Create Armorer is not installed; place it in the /tacz folder"
            );
        }

    }

    private boolean hasCreateArmorerInstalled(String pathName) {
        Path taczDir = FMLPaths.GAMEDIR.get().resolve(pathName);

        if (!Files.isDirectory(taczDir)) {
            return false;
        }

        try (Stream<Path> files = Files.list(taczDir)) {
            return files
                    .map(path -> path.getFileName().toString())
                    .anyMatch(name -> name.startsWith("Create Armorer"));
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            return false;
        }
    }

    @SubscribeEvent
    public void onClientLogin(ClientPlayerNetworkEvent.LoggingIn event) {
        if (!createArmorerInstalled && !Config.HIDE_NOTIFICATIONS.getAsBoolean()) {
            event.getPlayer().sendSystemMessage(
                    Component.translatable("warning.createimmersivetacz.create_armorer_not_installed")
                            .withColor(0xB5A642)
                            .append(Component.translatable("warning.createimmersivetacz.create_armorer_not_installed_2")
                                    .setStyle(Style.EMPTY
                                            .withColor(TextColor.fromRgb(0xB5A642))
                                            .withUnderlined(true)
                                            .withClickEvent(new ClickEvent(
                                                    ClickEvent.Action.RUN_COMMAND,
                                                    "/createimmersivetacz disable-warning"))
                                    )
                            )
            );

        }
    }



    @SubscribeEvent
    public void registerClientCommands(RegisterClientCommandsEvent event) {
        event.getDispatcher().register(
                Commands.literal("createimmersivetacz").then(Commands.literal("disable-warning")
                        .executes(context -> {
                            Config.HIDE_NOTIFICATIONS.set(true);

                            if (Minecraft.getInstance().player != null) {
                                Minecraft.getInstance().player.displayClientMessage(
                                        Component.translatable(
                                                "warning.createimmersivetacz.create_armorer_not_installed_disabled"
                                        ).withColor(0xB5A642),
                                        false
                                );
                            }

                            return 1;
                        }))
        );
    }


    private void commonSetup(FMLCommonSetupEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
