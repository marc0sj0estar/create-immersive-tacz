package net.myr.createimmersivetacz.fluid;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.myr.createimmersivetacz.CreateImmersiveTacz;
import org.joml.Vector3f;

public class ModFluidTypes {
    public static final ResourceLocation GUNPOWDER_STILL_RL = new ResourceLocation("createimmersivetacz:block/gunpowder");
    public static final ResourceLocation GUNPOWDER_FLOW_RL = new ResourceLocation("createimmersivetacz:block/gunpowder");

    public static final ResourceLocation NITROPOWDER_STILL_RL = new ResourceLocation("createimmersivetacz:block/nitropowder");
    public static final ResourceLocation NITROPOWDER_FLOW_RL = new ResourceLocation("createimmersivetacz:block/nitropowder");


    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, CreateImmersiveTacz.MOD_ID);

    public static final RegistryObject<FluidType> GUNPOWDER_FLUID_TYPE = register("gunpowder_fluid",
            FluidType.Properties.create().lightLevel(2).density(15).viscosity(5).sound(SoundAction.get("drink"),
                    SoundEvents.HONEY_DRINK), GUNPOWDER_STILL_RL, GUNPOWDER_FLOW_RL);

    public static final RegistryObject<FluidType> NITROPOWDER_FLUID_TYPE = register("nitropowder_fluid",
            FluidType.Properties.create().lightLevel(2).density(15).viscosity(5), NITROPOWDER_STILL_RL, NITROPOWDER_FLOW_RL);

    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties, ResourceLocation still, ResourceLocation flow) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(still, flow,
                0xFFFFFFFF, new Vector3f(225f / 255f, 225f / 255f, 225f / 255f), properties));
    }





    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}