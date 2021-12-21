package net.scaryzombies;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.mixin.object.builder.SpawnRestrictionAccessor;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;
import net.scaryzombies.config.ScaryZombiesConfig;
import net.scaryzombies.entity.mob.ScaryZombie.ScaryZombieEntity;

public class ScaryZombiesMod implements ModInitializer {
    public static final String MOD_ID = "scaryzombies";
    public static ScaryZombiesConfig CONFIG = new ScaryZombiesConfig();
    public static final EntityType<ScaryZombieEntity> SZ_ENTITY = Registry.register(
            Registry.ENTITY_TYPE, ScaryZombieEntity.SZE_MOB_ID,
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ScaryZombieEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.95f))
                    // .trackRangeBlocks()
                    // .forceTrackedVelocityUpdates(true)
                    // .trackedUpdateRate(3)
                    .build()
    );

    @Override
    public void onInitialize() {
        // System.out.println("Initializing ScaryZombies...");
        //Initializations
        // Init Cloth Config
        AutoConfig.register(ScaryZombiesConfig.class, Toml4jConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(ScaryZombiesConfig.class).getConfig();

        // Register ScaryZombieEntity
        FabricDefaultAttributeRegistry.register(SZ_ENTITY, ScaryZombieEntity.createZombieAttributes());

        // Register spawn conditions
        SpawnRestrictionAccessor.callRegister(SZ_ENTITY, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);

        // Register spawn egg
        Registry.register(Registry.ITEM, new Identifier("scaryzombies", "scary_zombie_spawn_egg"),
                new SpawnEggItem(SZ_ENTITY, -1, -1, new FabricItemSettings().group(ItemGroup.MISC)));
    }

}
