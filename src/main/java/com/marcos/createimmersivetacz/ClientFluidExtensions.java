package com.marcos.createimmersivetacz;

import com.mojang.blaze3d.shaders.FogShape;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

@EventBusSubscriber(modid = CreateImmersiveTaCZ.MODID, value = Dist.CLIENT)
public class ClientFluidExtensions {

    @SubscribeEvent
    public static void registerFluidExtensions(RegisterClientExtensionsEvent event) {

        event.registerFluidType(
                new IClientFluidTypeExtensions() {

                    @Override
                    public ResourceLocation getStillTexture() {
                        return GunpowderFluidType.STILL;
                    }

                    @Override
                    public ResourceLocation getFlowingTexture() {
                        return GunpowderFluidType.FLOWING;
                    }

                    @Override
                    public int getTintColor() {
                        return 0xFFFFFFFF;
                    }

                },
                ModFluids.GUNPOWDER_FLUID_TYPE.get()
        );

        event.registerFluidType(
                new IClientFluidTypeExtensions() {

                    @Override
                    public ResourceLocation getStillTexture() {
                        return NitropowderFluidType.STILL;
                    }

                    @Override
                    public ResourceLocation getFlowingTexture() {
                        return NitropowderFluidType.FLOWING;
                    }

                    @Override
                    public int getTintColor() {
                        return 0xFFFFFFFF;
                    }

                },
                ModFluids.NITROPOWDER_FLUID_TYPE.get()
        );
    }
}