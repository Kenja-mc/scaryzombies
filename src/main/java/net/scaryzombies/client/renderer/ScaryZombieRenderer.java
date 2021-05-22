package net.scaryzombies.client.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.scaryzombies.entity.ScaryZombieEntity;
import net.minecraft.util.Identifier;


@Environment(EnvType.CLIENT)
public class ScaryZombieRenderer extends MobEntityRenderer<ScaryZombieEntity, ZombieEntityModel<ScaryZombieEntity>> {

    public ScaryZombieRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new ZombieEntityModel<>(0.0f, false), 1);
        this.addFeature(
                new ArmorFeatureRenderer<>(this, new ZombieEntityModel<>(0.5f, true),
                        new ZombieEntityModel<>(1.0f, true))
        );
    }

    private static final Identifier SKIN = new Identifier("minecraft:textures/entity/zombie/zombie.png");

    @Override
    public Identifier getTexture(ScaryZombieEntity sze) {
        return SKIN;
    }

}
