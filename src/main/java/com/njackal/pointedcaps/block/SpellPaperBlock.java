package com.njackal.pointedcaps.block;

import com.mojang.serialization.MapCodec;
import com.njackal.pointedcaps.block.entity.SpellPaperBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SpellPaperBlock extends BaseEntityBlock {
    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 1, 16);
    public static final MapCodec<SpellPaperBlock> CODEC = simpleCodec(SpellPaperBlock::new);
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

    @Override
    public @Nullable BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return new SpellPaperBlockEntity(blockPos, blockState);
    }

    @Override
    protected @NotNull MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if(level.getBlockEntity(pos) instanceof SpellPaperBlockEntity blockEntity){
            if(level.isClientSide){
                return InteractionResult.SUCCESS;
            } else {
                ((ServerPlayer)player).openMenu(
                        new SimpleMenuProvider(blockEntity, Component.translatable("container.pointedcaps.spell_paper")),
                        pos);
                return InteractionResult.CONSUME;
            }
        }
        return InteractionResult.PASS;
    }
}
