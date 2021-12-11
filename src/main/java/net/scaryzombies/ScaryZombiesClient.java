package net.scaryzombies;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.scaryzombies.entity.mob.ScaryZombie.ScaryZombieRenderer;

@Environment(EnvType.CLIENT)
public class ScaryZombiesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        //Register Renderer
        EntityRendererRegistry.register(ScaryZombiesMod.SZ_ENTITY, ScaryZombieRenderer::new);
    }

}
