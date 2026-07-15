package com.njackal.pointedcaps.datagen;

import com.njackal.pointedcaps.PointedCaps;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class BlockLootTableProvider extends BlockLootSubProvider {
    public BlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.DEFAULT_FLAGS, registries);
    }

    @Override
    protected void generate() {
        dropSelf(PointedCaps.SPELL_PAPER.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return PointedCaps.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
