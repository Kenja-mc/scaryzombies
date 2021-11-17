package net.scaryzombies.entity.mob.ScaryZombie;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ScaryZombieEntity extends ZombieEntity {
    public static final Identifier SZE_MOB_ID = new Identifier("scaryzombies", "scary_zombie");

    public ScaryZombieEntity(EntityType<? extends ScaryZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createZombieAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64.0d)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.5d)
                .add(EntityAttributes.GENERIC_ARMOR, 0.0d)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 14.0d)
                .add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS)

                // TODO: Balance knockback
                // .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 0.0)
                // .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.5)
                ;
    }

    /*
    TODO Define smarter AI using Warden virbations
    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.2, false));
        this.goalSelector.add(2, new WanderAroundGoal(this, 1));
        this.targetSelector.add(3, new RevengeGoal(this));
        // this.goalSelector.add(4, new LookAroundGoal(this));  This can be performance heavy
        // this.goalSelector.add(5, new SwimGoal(this));        Removing Swim goals for now.
    }
     */

    @Override
    protected boolean canConvertInWater() {
        // TODO: Make a Drowned Variant?
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

    @Override
    protected ItemStack getSkull() {
        return ItemStack.EMPTY;
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
*/

    //TODO: Custom sound assets
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_HUSK_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_HUSK_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_HUSK_DEATH;
    }

    @Override
    protected SoundEvent getStepSound() {
        return SoundEvents.ENTITY_HUSK_STEP;
    }
}
