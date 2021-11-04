package net.scaryzombies.entity.mob.ScaryZombie;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.render.entity.ZombieEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ScaryZombieRenderer extends ZombieEntityRenderer {
//    private static final Identifier TEXTURE = new Identifier("scaryzombies", "textures/mobs/zombie.png");
    private static final Identifier TEXTURE = new Identifier("minecraft", "textures/entity/zombie/zombie.png");
//    public static EntityModelLayer SZE_MODEL_LAYER = new EntityModelLayer(ScaryZombieEntity.SZE_MOB_ID, "main");

    public ScaryZombieRenderer(Context context) {
        // Just yoinking vanilla EMLs for now
        super(context, EntityModelLayers.ZOMBIE, EntityModelLayers.ZOMBIE_INNER_ARMOR, EntityModelLayers.ZOMBIE_OUTER_ARMOR);
    }

    protected void scale(ZombieEntity zombieEntity, MatrixStack matrixStack, float f) {
        float g = 1.0625F;
        matrixStack.scale(1.0625F, 1.0625F, 1.0625F);
        super.scale(zombieEntity, matrixStack, f);
    }

    public Identifier getTexture(ScaryZombieEntity entity) {
        return TEXTURE;
    }

    public static void init() {
        //Register Model
//        EntityModelLayerRegistry.registerModelLayer(SZE_MODEL_LAYER, TexturedModelData.of());
    }

}

