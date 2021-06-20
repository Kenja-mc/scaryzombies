package net.scaryzombies;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.scaryzombies.entity.mob.ScaryZombie.ScaryZombieRenderer;

@Environment(EnvType.CLIENT)
public class ScaryZombiesClient implements ClientModInitializer {
//    public static final EntityModelLayer SZE_MODEL_LAYER = new EntityModelLayer(ScaryZombiesMod.SZE_MOB_ID, "main");

    @Override
    public void onInitializeClient() {
        //Register Model
        ScaryZombieRenderer.init();
        //Register Renderer
        EntityRendererRegistry.INSTANCE.register(ScaryZombiesMod.SZ_ENTITY, ScaryZombieRenderer::new);
    }
}
