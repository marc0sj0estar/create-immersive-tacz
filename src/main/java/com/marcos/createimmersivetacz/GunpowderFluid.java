package com.marcos.createimmersivetacz;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.fluids.FluidType;

import java.util.Optional;

public abstract class GunpowderFluid extends FlowingFluid {

    @Override
    public Fluid getSource() {
        return ModFluids.GUNPOWDER_FLUID.get();
    }

    @Override
    public Fluid getFlowing() {
        return ModFluids.FLOWING_GUNPOWDER_FLUID.get();
    }

    @Override
    public Item getBucket() {
        return ModFluids.GUNPOWDER_BUCKET.get();
    }

    @Override
    protected boolean canBeReplacedWith(
            FluidState state,
            BlockGetter level,
            BlockPos pos,
            Fluid fluid,
            Direction direction
    ) {
        return false;
    }

    @Override
    protected boolean canSpreadTo(BlockGetter level, BlockPos fromPos, BlockState fromBlockState, Direction direction, BlockPos toPos, BlockState toBlockState, FluidState toFluidState, Fluid fluid) {
        return false;
    }



    @Override
    public int getTickDelay(LevelReader level) {
        return 5;
    }

    @Override
    protected float getExplosionResistance() {
        return 0;
    }

    @Override
    protected boolean canConvertToSource(Level level) {
        return false;
    }

    @Override
    protected void beforeDestroyingBlock(
            LevelAccessor level,
            BlockPos pos,
            BlockState state
    ) {
    }

    @Override
    protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
        super.createFluidStateDefinition(builder);
    }

    @Override
    protected int getSlopeFindDistance(LevelReader level) {
        return 0;
    }

    @Override
    protected int getDropOff(LevelReader level) {
        return 0;
    }


    @Override
    public FluidType getFluidType() {
        return ModFluids.GUNPOWDER_FLUID_TYPE.get();
    }

    @Override
    public Optional<SoundEvent> getPickupSound() {
        return Optional.of(SoundEvents.SAND_BREAK);
    }

    public static class Source extends GunpowderFluid {

        @Override
        protected BlockState createLegacyBlock(FluidState state) {
            return ModFluids.GUNPOWDER_FLUID_BLOCK.get().defaultBlockState();
        }

        @Override
        public boolean isSource(FluidState state) {
            return true;
        }

        @Override
        public int getAmount(FluidState state) {
            return 8;
        }
    }

    public static class Flowing extends GunpowderFluid {

        @Override
        protected BlockState createLegacyBlock(FluidState state) {
            return ModFluids.GUNPOWDER_FLUID_BLOCK.get().defaultBlockState()
                    .setValue(LiquidBlock.LEVEL, getAmount(state) - 1);
        }

        @Override
        public boolean isSource(FluidState state) {
            return false;
        }

        @Override
        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }

        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

    }
}