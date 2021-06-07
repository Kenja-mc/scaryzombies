package net.scaryzombies;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.EntityType;
import net.scaryzombies.mobs.ScaryZombie.ScaryZombieEntity;
import net.scaryzombies.mobs.ScaryZombie.ScaryZombieRenderer;

@Environment(EnvType.CLIENT)
public class ClientInit implements ClientModInitializer {
    public static final EntityModelLayer SCARY_ZOMBIE_ML = new EntityModelLayer(ScaryZombiesModInit.id("scary_zombie_render_layer"), "scary_zombie_render_layer");

    public static EntityType<ScaryZombieEntity> SCARY_ZOMBIE;


    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.INSTANCE.register(SCARY_ZOMBIE, ScaryZombieRenderer::new);

        HudRenderCallback.EVENT.register((matrices, tickDelta) -> {
        });
        ClientTickEvents.END_CLIENT_TICK.register((client) -> {
        });
    }
}
