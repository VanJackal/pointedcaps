package com.njackal.pointedcaps.entity;

import com.njackal.pointedcaps.PointedCaps;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, PointedCaps.MODID);

    public static final Supplier<EntityType<SpellParticleEntity>> SPELL_PARTICLE =
            registerEntity("spell_particle", EntityType.Builder.of(SpellParticleEntity::new, MobCategory.MISC)
                    .sized(0.25f, 0.25f)
                    .fireImmune()
                    .noSave()
            );

    public static <T extends Entity> Supplier<EntityType<T>> registerEntity(String key, EntityType.Builder<T> builder) {
        return ENTITIES.register(key, () -> builder.build(key));
    }

    public static void register(IEventBus bus) {
        ENTITIES.register(bus);
    }
}
