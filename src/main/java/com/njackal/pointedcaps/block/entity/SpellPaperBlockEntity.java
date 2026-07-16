package com.njackal.pointedcaps.block.entity;

import com.njackal.pointedcaps.screen.SpellPaperMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SpellPaperBlockEntity extends BlockEntity implements MenuProvider {
    public SpellPaperBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.SPELL_PAPER_BE.get(), pos, blockState);
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable("container.pointedcaps.spell_paper");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new SpellPaperMenu(i, inventory, this);
    }

    public static void tick(Level level, BlockPos blockPos, BlockState blockState, BlockEntity o) {
        level.addParticle(
                ParticleTypes.SMOKE,
                blockPos.getX() + 0.5,
                blockPos.getY() + 0.1,
                blockPos.getZ() + 0.5,
                0,
                0,
                0
        );

        //Spawn Entity
        /*
        Entity pig = new Pig(EntityType.PIG, level);
        pig.setPos(blockPos.getX() + 0.5, blockPos.getY() + 1, blockPos.getZ() + 0.5);
        level.addFreshEntity(pig);
         */
    }
}
