package net.scaryzombies;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.scaryzombies.mobs.ScaryZombie.ScaryZombieEntity;

public class ScaryZombiesModInit implements ModInitializer {

    public static final EntityType<ScaryZombieEntity> SCARY_ZOMBIE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("scaryzombies", "scary_zombie"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ScaryZombieEntity::new).dimensions(EntityDimensions.fixed(0.6f, 1.95f)).build()
    );

    @Override
    public void onInitialize() {
        System.out.println("Initializing ScaryZombies...");

        FabricDefaultAttributeRegistry.register(SCARY_ZOMBIE, ScaryZombieEntity.createScaryZombieEntityAttributes());
    }
}
