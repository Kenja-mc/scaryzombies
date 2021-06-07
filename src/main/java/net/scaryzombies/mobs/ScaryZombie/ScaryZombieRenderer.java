package net.scaryzombies.mobs.ScaryZombie;

import net.minecraft.client.render.entity.*;
import net.minecraft.util.Identifier;
import net.scaryzombies.ClientInit;

public class ScaryZombieRenderer extends MobEntityRenderer<ScaryZombieEntity, ScaryZombieModel<ScaryZombieEntity>> {

    public ScaryZombieRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new ScaryZombieModel<>(ctx.getPart(ClientInit.SCARY_ZOMBIE_ML)), 1);
    }

    @Override
    public Identifier getTexture(ScaryZombieEntity entity) {
        return new Identifier("scaryzombies:textures/mobs/scaryzombie/zombie.png");
    }

}

