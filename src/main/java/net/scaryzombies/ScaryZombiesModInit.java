package net.scaryzombies;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;

import net.minecraft.util.Identifier;
import net.scaryzombies.mobs.ScaryZombie.ScaryZombieEntity;

public class ScaryZombiesModInit implements ModInitializer {
    public static final String MODID = "scaryzombies";

    @Override
    public void onInitialize() {
        System.out.println("Initializing ScaryZombies...");

        ScaryZombieEntity.init();

        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
        });

    }

    public static Identifier id(String namespace) {
        return new Identifier(MODID, namespace);
    }

}
