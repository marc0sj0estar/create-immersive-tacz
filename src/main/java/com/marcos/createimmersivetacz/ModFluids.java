package com.marcos.createimmersivetacz;


import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;


public class ModFluids {

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(
                    NeoForgeRegistries.Keys.FLUID_TYPES,
                    CreateImmersiveTaCZ.MODID);

    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(
                    Registries.FLUID,
                    CreateImmersiveTaCZ.MODID);

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(
                    Registries.BLOCK,
                    CreateImmersiveTaCZ.MODID);

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(
                    Registries.ITEM,
                    CreateImmersiveTaCZ.MODID);

    public static final DeferredHolder<FluidType, FluidType> GUNPOWDER_FLUID_TYPE =
            FLUID_TYPES.register(
                    "gunpowder_fluid",
                    GunpowderFluidType::new);

    public static final DeferredHolder<Fluid, FlowingFluid> GUNPOWDER_FLUID =
            FLUIDS.register(
                    "gunpowder_fluid",
                    GunpowderFluid.Source::new);

    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_GUNPOWDER_FLUID =
            FLUIDS.register(
                    "flowing_gunpowder_fluid",
                    GunpowderFluid.Flowing::new);

    public static final DeferredHolder<Block, LiquidBlock> GUNPOWDER_FLUID_BLOCK =
            BLOCKS.register(
                    "gunpowder_fluid",
                    () -> new LiquidBlock(
                            GUNPOWDER_FLUID.get(),
                            BlockBehaviour.Properties.ofFullCopy(
                                    net.minecraft.world.level.block.Blocks.WATER
                            )
                    )
            );



    public static final DeferredHolder<Item, BucketItem> GUNPOWDER_BUCKET =
            ITEMS.register(
                    "gunpowder_bucket",
                    () -> new BucketItem(
                            GUNPOWDER_FLUID.get(),
                            new Item.Properties()
                                    .stacksTo(1)
                                    .craftRemainder(
                                            net.minecraft.world.item.Items.BUCKET
                                    )
                    )
            );


    public static final DeferredHolder<FluidType, FluidType> NITROPOWDER_FLUID_TYPE =
            FLUID_TYPES.register(
                    "nitropowder_fluid",
                    NitropowderFluidType::new);

    public static final DeferredHolder<Fluid, FlowingFluid> NITROPOWDER_FLUID =
            FLUIDS.register(
                    "nitropowder_fluid",
                    NitropowderFluid.Source::new);

    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_NITROPOWDER_FLUID =
            FLUIDS.register(
                    "flowing_nitropowder_fluid",
                    NitropowderFluid.Flowing::new);

    public static final DeferredHolder<Block, LiquidBlock> NITROPOWDER_FLUID_BLOCK =
            BLOCKS.register(
                    "nitropowder_fluid",
                    () -> new LiquidBlock(
                            NITROPOWDER_FLUID.get(),
                            BlockBehaviour.Properties.ofFullCopy(
                                    net.minecraft.world.level.block.Blocks.WATER
                            )
                    )
            );

    public static final DeferredHolder<Item, BucketItem> NITROPOWDER_BUCKET =
            ITEMS.register(
                    "nitropowder_bucket",
                    () -> new BucketItem(
                            NITROPOWDER_FLUID.get(),
                            new Item.Properties()
                                    .stacksTo(1)
                                    .craftRemainder(
                                            net.minecraft.world.item.Items.BUCKET
                                    )
                    )
            );

    public static void register(IEventBus bus) {
        FLUID_TYPES.register(bus);
        FLUIDS.register(bus);
        BLOCKS.register(bus);
        ITEMS.register(bus);
    }

}
