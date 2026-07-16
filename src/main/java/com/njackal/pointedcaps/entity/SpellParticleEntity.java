package com.njackal.pointedcaps.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class SpellParticleEntity extends Entity {
    public SpellParticleEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        //todo
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        //todo
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        //todo
    }
}
