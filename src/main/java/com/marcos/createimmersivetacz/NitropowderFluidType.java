package com.marcos.createimmersivetacz;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;

public class NitropowderFluidType extends FluidType {
    public static final ResourceLocation STILL =
            ResourceLocation.fromNamespaceAndPath(
                    CreateImmersiveTaCZ.MODID,
                    "block/nitropowder"
            );

    public static final ResourceLocation FLOWING =
            ResourceLocation.fromNamespaceAndPath(
                    CreateImmersiveTaCZ.MODID,
                    "block/nitropowder_flow"
            );

    public NitropowderFluidType() {
        super(Properties.create().sound(SoundActions.BUCKET_EMPTY, SoundEvents.SAND_BREAK));
    }
}
