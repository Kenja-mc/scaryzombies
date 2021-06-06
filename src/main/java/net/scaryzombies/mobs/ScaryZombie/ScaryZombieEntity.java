package net.scaryzombies.mobs.ScaryZombie;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;

public class ScaryZombieEntity extends ZombieEntity {

    public ScaryZombieEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
//        this.experiencePoints = 10;
    }

    public static DefaultAttributeContainer.Builder createScaryZombieEntityAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 7.0 + 7.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.387)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64)

//                TODO: Define other attributes
                // .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.5)
                // .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 0.0)
                // .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.5)
                // .add(EntityAttributes.GENERIC_ARMOR, 0.0)
                // .add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS, 0.0)

                ;

    }

//    TODO Also define drops
//    @Override
//    public boolean canPickUpLoot() {
//        return true;
//    }

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
