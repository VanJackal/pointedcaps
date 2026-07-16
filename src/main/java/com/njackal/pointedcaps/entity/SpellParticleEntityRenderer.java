package com.njackal.pointedcaps.entity;

import com.njackal.pointedcaps.PointedCaps;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class SpellParticleEntityRenderer extends EntityRenderer<SpellParticleEntity> {
    public SpellParticleEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(SpellParticleEntity spellParticleEntity) {
        return ResourceLocation.fromNamespaceAndPath(PointedCaps.MODID, "textures/entity/spell_particle.png");
    }
}
