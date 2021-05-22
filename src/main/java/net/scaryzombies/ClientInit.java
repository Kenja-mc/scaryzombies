package net.scaryzombies;

import net.scaryzombies.Client.Renderer.CubeEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.scaryzombies.Client.Renderer.ScaryZombieRenderer;

@Environment(EnvType.CLIENT)
public class ClientInit implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        /*
         * Registers our Cube Entity's Renderer, which provides a Model and texture for the Entity.
         *
         * Entity Renderers can also manipulate the Model before it renders based on Entity context (EndermanEntityRenderer#render).
         */
        EntityRendererRegistry.INSTANCE.register(ScaryZombiesInit.CUBE, (dispatcher, context) -> new CubeEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(ScaryZombiesInit.SCARY_ZOMBIE, (dispatcher, context) -> new ScaryZombieRenderer(dispatcher));

    }
}
