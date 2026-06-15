package com.marcos.createimmersivetacz;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.neoforge.common.SoundAction;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.Nullable;

public class GunpowderFluidType extends FluidType {
    public static final ResourceLocation STILL =
            ResourceLocation.fromNamespaceAndPath(
                    CreateImmersiveTaCZ.MODID,
                    "block/gunpowder"
            );

    public static final ResourceLocation FLOWING =
            ResourceLocation.fromNamespaceAndPath(
                    CreateImmersiveTaCZ.MODID,
                    "block/gunpowder_flow"
            );



    public GunpowderFluidType() {
        super(Properties.create().sound(SoundActions.BUCKET_EMPTY, SoundEvents.SAND_BREAK));
    }
}
