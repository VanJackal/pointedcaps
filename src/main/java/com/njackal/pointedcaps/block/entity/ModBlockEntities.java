package com.njackal.pointedcaps.block.entity;

import com.njackal.pointedcaps.PointedCaps;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, PointedCaps.MODID);

    public static final Supplier<BlockEntityType<?>> SPELL_PAPER_BE =
            BLOCK_ENTITIES.register("spell_paper_be", () -> BlockEntityType.Builder.of(
                    SpellPaperBlockEntity::new, PointedCaps.SPELL_PAPER.get()).build(null));


    public static void register(IEventBus bus) {
        BLOCK_ENTITIES.register(bus);
    }
}
