package net.myr.createimmersivetacz.fluid;


import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.myr.createimmersivetacz.CreateImmersiveTacz;
import net.myr.createimmersivetacz.item.ModItems;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, CreateImmersiveTacz.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_GUNPOWDER = FLUIDS.register("gunpowder_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.GUNPOWDER_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_GUNPOWDER = FLUIDS.register("flowing_gunpowder_fluid",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.GUNPOWDER_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties GUNPOWDER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.GUNPOWDER_FLUID_TYPE, SOURCE_GUNPOWDER, FLOWING_GUNPOWDER)
            .slopeFindDistance(2).levelDecreasePerBlock(2);

    public static final RegistryObject<FlowingFluid> SOURCE_NITROPOWDER = FLUIDS.register("nitropowder_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.NITROPOWDER_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_NITROPOWDER = FLUIDS.register("flowing_nitropowder_fluid",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.NITROPOWDER_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties NITROPOWDER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.NITROPOWDER_FLUID_TYPE, SOURCE_NITROPOWDER, FLOWING_NITROPOWDER)
            .slopeFindDistance(2).levelDecreasePerBlock(2);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}