package net.scaryzombies;

import net.scaryzombies.client.renderer.CubeEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.scaryzombies.client.renderer.ScaryZombieRenderer;

@Environment(EnvType.CLIENT)
public class Renderinit implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        /*
         * Registers our Cube Entity's renderer, which provides a model and texture for the entity.
         *
         * Entity Renderers can also manipulate the model before it renders based on entity context (EndermanEntityRenderer#render).
         */
        EntityRendererRegistry.INSTANCE.register(ScaryZombiesInit.CUBE, (dispatcher, context) -> new CubeEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(ScaryZombiesInit.SCARY_ZOMBIE, (dispatcher, context) -> new ScaryZombieRenderer(dispatcher));

    }
}
