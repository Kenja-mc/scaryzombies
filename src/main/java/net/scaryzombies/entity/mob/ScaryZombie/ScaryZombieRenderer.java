package net.scaryzombies.entity.mob.ScaryZombie;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ZombieEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ScaryZombieRenderer extends ZombieEntityRenderer {
    private static final Identifier TEXTURE = new Identifier("scaryzombies", "textures/mobs/zombie.png");

    public ScaryZombieRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    protected void scale(ZombieEntity zombieEntity, MatrixStack matrixStack, float f) {
        float g = 1.0625F;
        matrixStack.scale(1.0625F, 1.0625F, 1.0625F);
        super.scale(zombieEntity, matrixStack, f);
    }

    public Identifier getTexture(ScaryZombieEntity entity) {
        return TEXTURE;
    }

}

