package net.scaryzombies.entity.mob.ScaryZombie;

import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.scaryzombies.entity.ai.goal.ActiveTrackableTargetGoal;

import java.util.function.Predicate;

public class ScaryZombieEntity extends ZombieEntity {
    public static final Identifier SZE_MOB_ID = new Identifier("scaryzombies", "scary_zombie");


    public ScaryZombieEntity(EntityType<? extends ScaryZombieEntity> entityType, World world) {
        super(entityType, world);
        this.setCanBreakDoors(false);
        // this.canImmediatelyDespawn()
    }

    public static DefaultAttributeContainer.Builder createZombieAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 35.0d)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0D)
                .add(EntityAttributes.GENERIC_ARMOR, 2.0D)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 14.0d)
                .add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS)
                // TODO: Balance knockback
                // .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 0.0)
                // .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.5)
                ;
    }
    // From ZombieEntity.class
    @Override
    protected void initGoals() {
        this.goalSelector.add(2, new ZombieAttackGoal(this, 1.0D, false));
        // SZs dont try to destroy turtle eggs
        // this.goalSelector.add(4, new ZombieEntity.DestroyEggGoal(this, 1.0D, 3));
        // SZs dont break doors
        // this.goalSelector.add(6, new MoveThroughVillageGoal(this, 1.0D, true, 4, this::canBreakDoors));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0D));
        // SZs don't look around. Also helps performance I think.
        // this.goalSelector.add(8, new LookAroundGoal(this));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));

        // SZs should alert friends like pigmen?
        this.targetSelector.add(1, (new RevengeGoal(this, new Class[0])).setGroupRevenge(new Class[]{ScaryZombieEntity.class}));
        // this.targetSelector.add(2, new ActiveTargetGoal(this, PlayerEntity.class, true));
        this.targetSelector.add(2, new ActiveTrackableTargetGoal(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal(this, MerchantEntity.class, false));
        // this.targetSelector.add(3, new ActiveTargetGoal(this, IronGolemEntity.class, true));
        // this.targetSelector.add(5, new ActiveTargetGoal(this, TurtleEntity.class, 10, true, false, TurtleEntity.BABY_TURTLE_ON_LAND_FILTER));
    }

    protected double getFollowRange() {
        return this.getAttributeValue(EntityAttributes.GENERIC_FOLLOW_RANGE);
    }


    // I figured out the bug with follow range I think.
    // isInWalkTargetRange does not properly update to match, as the range is still dependent on
    // squared distance.
    // https://bugs.mojang.com/browse/MC-145656
    // TODO: Check if this fixes bug with follow distance?
    /*
    @Override
    public boolean isInWalkTargetRange(BlockPos pos) {
        LOGGER.info("Checking if target is in range.");
        LOGGER.info("\tTarget position range: " + this.getPositionTargetRange());
        LOGGER.info("\tTarget position squared distance: " + this.getPositionTarget().getSquaredDistance(pos));
        LOGGER.info("\tTarget within 70 blocks?: " + this.getPositionTarget().isWithinDistance(this.getPos(), 70.0D));
        LOGGER.info("\tTarget within 35 blocks?: " + this.getPositionTarget().isWithinDistance(this.getPos(), 35.0D));
        LOGGER.info("\tTarget within 17.5 blocks?: " + this.getPositionTarget().isWithinDistance(this.getPos(), 17.5D));

        if (this.getTarget() == null) {
            return false;
        } else if (this.getPositionTargetRange() == -1.0F) {
            return true;
        } else if (this.getTarget().isPlayer() && this.getTarget().isPartOfGame()) {
            double targetDist = this.getPositionTarget().getSquaredDistance(pos);
            boolean isSwimming = this.getTarget().isInSwimmingPose();
            boolean isSneaking = this.getTarget().isInSneakingPose();
            boolean isStanding = this.getTarget().getPose() == EntityPose.STANDING;
            boolean isSprinting = this.getTarget().isSprinting();

            if (isSwimming && this.getPositionTarget().isWithinDistance(this.getPos(), this.getFollowRange() * 0.1)) {
                LOGGER.info("Found swimming player: " + this.getPositionTargetRange());
                return true;
            } else if (isSneaking && this.getPositionTarget().isWithinDistance(this.getPos(), this.getFollowRange() * 0.5)) {
                LOGGER.info("Found sneaking player: " + this.getPositionTargetRange());
                return true;
            } else if (isStanding && this.getPositionTarget().isWithinDistance(this.getPos(), this.getFollowRange())) {
                LOGGER.info("Found standing player: " + this.getPositionTargetRange());
                return true;
            } else if (isSprinting && this.getPositionTarget().isWithinDistance(this.getPos(), this.getFollowRange() * 2.0)) {
                LOGGER.info("Found sprinting player: " + this.getPositionTargetRange());
                return true;
            } else {
                return false;
            }
        } else if (!this.getTarget().isPlayer()){
            return this.getPositionTarget().getSquaredDistance(pos) < (double)(this.getPositionTargetRange() * this.getPositionTargetRange());
        } else {
            return false;
        }
    }
    */

    @Override
    public boolean isBaby() {
        return false;
    }

    @Override
    protected boolean canConvertInWater() {
        return false;
    }

    @Override
    public boolean burnsInDaylight() {
        return false;
    }

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

    @Override
    public boolean canPickupItem(ItemStack stack) {
        return false;
    }

    @Override
    protected ItemStack getSkull() {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canPickUpLoot() {
        return false;
    }

    /*
    Give it blocks it can break?
    public static boolean canDestroy(BlockState block) {
        return !block.isAir() && block.isOf(Blocks.STONE) || block.isOf(Blocks.COBBLESTONE);
    }
    */

    /*
    // Experimental: Try using Warden Listener? May hurt performance
    public void listen(BlockPos eventPos, World eventWorld, LivingEntity eventEntity) {
        this.lasteventpos = eventPos;
        this.lasteventworld = eventWorld;
        this.lastevententity = eventEntity;
    }
     */
}
