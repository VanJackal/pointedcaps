package com.njackal.pointedcaps;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class SpellPaperBlock extends Block {
    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 1, 16);
    public SpellPaperBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state,
                                        @NotNull BlockGetter worldIn,
                                        @NotNull BlockPos pos,
                                        @NotNull CollisionContext context) {
        return SHAPE;
    }

    @Override
    public void animateTick(@NotNull BlockState state,
                            @NotNull Level level,
                            @NotNull BlockPos pos,
                            @NotNull RandomSource random) {
        level.addParticle(
                ParticleTypes.FLAME,
                pos.getX()+0.5,
                pos.getY() + 1,
                pos.getZ()+0.5,
                0,
                0.1,
                0
        );
    }

}
