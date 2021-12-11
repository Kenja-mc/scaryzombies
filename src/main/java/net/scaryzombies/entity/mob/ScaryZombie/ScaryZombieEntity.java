package net.scaryzombies.entity.mob.ScaryZombie;

import net.minecraft.entity.Entity;
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
import net.minecraft.world.WorldView;

public class ScaryZombieEntity extends ZombieEntity {
    public static final Identifier SZE_MOB_ID = new Identifier("scaryzombies", "scary_zombie");

    public ScaryZombieEntity(EntityType<? extends ScaryZombieEntity> entityType, World world) {
        super(entityType, world);
        this.setCanBreakDoors(false);

    }

    public static DefaultAttributeContainer.Builder createZombieAttributes() {
        return HostileEntity.createHostileAttributes()
//                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64.0d) //Currently not working: https://bugs.mojang.com/browse/MC-145656
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

    @Override
    public boolean tryAttack(Entity target) {
        boolean battack = super.tryAttack(target);

        return battack;
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
    TODO: Give it blocks it can break?
    public static boolean canDestroy(BlockState block) {
        return !block.isAir() && block.isOf(Blocks.STONE) || block.isOf(Blocks.COBBLESTONE);
    }
    */

    /*
    // Experimental: Using Warden Listener
    // https://github.com/Osmiooo/wildmod/blob/master/src/main/java/frozenblock/wild/mod/entity/WardenEntity.java
    public void listen(BlockPos eventPos, World eventWorld, LivingEntity eventEntity) {
        this.lasteventpos = eventPos;
        this.lasteventworld = eventWorld;
        this.lastevententity = eventEntity;
    }
     */
}
