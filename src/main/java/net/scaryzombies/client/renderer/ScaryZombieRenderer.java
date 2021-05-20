package net.scaryzombies.client.renderer;

import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.util.Identifier;
import net.scaryzombies.common.entity.ScaryZombieEntity;

public class ScaryZombieRenderer extends BipedEntityRenderer<ScaryZombieEntity, ZombieEntityModel<ScaryZombieEntity>> {
    //    private static final Identifier SKIN = new Identifier("scaryzombies:textures/entity/scaryzombie.png");
    public ScaryZombieRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new ZombieEntityModel<>(0.0f, false), 0.5f);
        this.addFeature(
                new ArmorFeatureRenderer<>(this, new ZombieEntityModel<>(0.5f, true),
                        new ZombieEntityModel<>(1.0f, true)));
    }

/*    @Override
    public Identifier getTexture(ScaryZombieEntity scze) {
        return SKIN;
    }
*/
}
