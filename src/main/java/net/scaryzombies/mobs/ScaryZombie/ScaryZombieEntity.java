package net.scaryzombies.mobs.ScaryZombie;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class ScaryZombieEntity extends ZombieEntity {
    //   Registry
    public static final EntityType<ScaryZombieEntity> ENTITY =
            Registry.register(Registry.ENTITY_TYPE, new Identifier("scaryzombies", "scary_zombie"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ScaryZombieEntity::new)
                            .dimensions(EntityDimensions.fixed(0.6f, 1.95f))
                            .trackRangeBlocks(64)
                            .forceTrackedVelocityUpdates(true)
                            .trackedUpdateRate(3)
                            .build()
            );


    public ScaryZombieEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
        this.setAiDisabled(false);
        this.experiencePoints = 5;
    }

    public static void init() {
        FabricDefaultAttributeRegistry.register(ENTITY, ScaryZombieEntity.createScaryZombieEntityAttributes());
//        Register spawn egg
        Registry.register(Registry.ITEM, new Identifier("scaryzombies", "scary_zombie_spawn_egg"),
                new SpawnEggItem(ENTITY, -1, -1, new FabricItemSettings().group(ItemGroup.MISC)));
    }

    public static DefaultAttributeContainer.Builder createScaryZombieEntityAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 7.0 + 7.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.387)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64)

                // TODO: Define other attributes
                // .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.5)
                // .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 0.0)
                // .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.5)
                // .add(EntityAttributes.GENERIC_ARMOR, 0.0)
                // .add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS, 0.0)
                ;
    }

    //    TODO Define smarter AI
    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.2, false));
        this.goalSelector.add(2, new WanderAroundGoal(this, 1));
        this.targetSelector.add(3, new RevengeGoal(this));
    // this.goalSelector.add(4, new LookAroundGoal(this));  This can be performance heavy
    // this.goalSelector.add(5, new SwimGoal(this));        Removing Swim goals for now.
    }

    @Override
    public boolean isConvertingInWater() {
        // TODO: Make a Drowned Variant
        return false;
    }

    @Override
    public boolean burnsInDaylight() {
        return false;
    }

    @Override
    public boolean isBaby() {
        return false;
    }

/*

    TODO: Define drops
    @Override
    public boolean canPickUpLoot() {
        return true;
    }

    TODO: Define Spawn conditions
    @Override
    public boolean canSpawn(WorldView view) {
        BlockPos blockunderentity = new BlockPos(this.getX(), this.getY() - 1, this.getZ());
        BlockPos posentity = new BlockPos(this.getX(), this.getY(), this.getZ());
        return view.intersectsEntities(this) && !world.containsFluid(this.getBoundingBox())
                && this.world.getBlockState(posentity).getBlock().canMobSpawnInside()
                && this.world.getBlockState(blockunderentity).allowsSpawning(view, blockunderentity, Entityinit.TANK)
                && AutoConfig.getConfigHolder(configz.class).getConfig().TankSpawn;

    }

    TODO: Define Damage effects and infection?
    @Override
    public void dealDamage(LivingEntity attacker, Entity target) {
        LivingEntity bob = (LivingEntity) target;
        StatusEffectInstance weakness = new StatusEffectInstance(StatusEffect.byRawId(18), 100, 0, false, false);
        if (target instanceof LivingEntity && !world.isClient) {
            bob.addStatusEffect(weakness);
        }
    }

    TODO: Define reinforcement spawning

    TODO: Define new sound effects?
    @Override
    protected SoundEvent getAmbientSound() {
        return Soundinit.AMBIENTTANKEVENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return Soundinit.HURTTANKEVENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return Soundinit.DEATHTANKEVENT;
    }

    protected SoundEvent getStepSound() {
        return Soundinit.STEPTANKEVENT;
    }
*/

}
