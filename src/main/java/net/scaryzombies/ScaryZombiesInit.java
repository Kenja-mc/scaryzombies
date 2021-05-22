package net.scaryzombies;

import net.scaryzombies.Entity.CubeEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.scaryzombies.Entity.ScaryZombieEntity;
import net.scaryzombies.Item.FabricItem;

public class ScaryZombiesInit implements ModInitializer {

    public static final Item FABRIC_ITEM = new FabricItem(new FabricItemSettings().group(ItemGroup.MISC));

    /*
     * Registers our Cube Entity under the ID "entitytesting:cube".
     *
     * The Entity is registered under the SpawnGroup#CREATURE category, which is what most animals and passive/neutral mobs use.
     * It has a hitbox size of .75x.75, or 12 "pixels" wide (3/4ths of a block).
     */
    public static final EntityType<CubeEntity> CUBE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("scaryzombies", "cube"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CubeEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    public static final EntityType<ScaryZombieEntity> SCARY_ZOMBIE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("scaryzombies", "scary_zombie"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ScaryZombieEntity::new).dimensions(EntityDimensions.fixed(0.6f, 1.95f)).build()
    );

    @Override
    public void onInitialize() {
        System.out.println("Yo.");

        Registry.register(Registry.ITEM, new Identifier("scaryzombies", "fabric_item"), FABRIC_ITEM);

        /*
         * Register our Cube Entity's default attributes.
         * Attributes are properties or stats of the mobs, including things like attack damage and health.
         * The game will crash if the Entity doesn't have the proper attributes registered in time.
         *
         * In 1.15, this was done by a method override inside the Entity class.
         * Most vanilla entities have a static method (eg. ZombieEntity#createZombieAttributes) for initializing their attributes.
         */
        FabricDefaultAttributeRegistry.register(CUBE, CubeEntity.createMobAttributes());

        FabricDefaultAttributeRegistry.register(SCARY_ZOMBIE, ScaryZombieEntity.createScaryZombieEntityAttributes());
    }
}
