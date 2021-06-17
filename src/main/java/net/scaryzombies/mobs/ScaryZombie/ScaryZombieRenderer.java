package net.scaryzombies.mobs.ScaryZombie;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.render.entity.ZombieEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.util.Identifier;
import net.scaryzombies.ScaryZombiesClient;
import net.scaryzombies.init.EntityModelLayersInit;

@Environment(EnvType.CLIENT)
public class ScaryZombieRenderer extends ZombieEntityRenderer {
    private static final Identifier TEXTURE = new Identifier("scaryzombies", "textures/mobs/zombie.png");

    public ScaryZombieRenderer(Context context) {
        super(context, EntityModelLayersInit.SZE_MODEL_LAYER, EntityModelLayers.ZOMBIE_INNER_ARMOR, EntityModelLayers.ZOMBIE_OUTER_ARMOR);
    }

    //From HuskEntityRenderer.class
    protected void scale(ZombieEntity zombieEntity, MatrixStack matrixStack, float f) {
        float g = 1.0625F;
        matrixStack.scale(1.0625F, 1.0625F, 1.0625F);
        super.scale(zombieEntity, matrixStack, f);
    }

    public Identifier getTexture(ScaryZombieEntity entity) {
        return TEXTURE;
    }

}

