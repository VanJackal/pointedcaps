package com.njackal.pointedcaps.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SpellPaperBlockEntity extends BlockEntity {
    public SpellPaperBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.SPELL_PAPER_BE.get(), pos, blockState);
    }
}
