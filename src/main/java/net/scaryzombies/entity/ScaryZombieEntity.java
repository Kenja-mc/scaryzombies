package net.scaryzombies.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class ScaryZombieEntity extends ZombieEntity {

    public ScaryZombieEntity(EntityType<? extends ZombieEntity> entityType, World world){
        super(entityType, world);
        this.experiencePoints = 10;
    }

    public static DefaultAttributeContainer.Builder createScaryZombieEntityAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0d)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 5.0d)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.5d)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 40.0d)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.5d)
                .add(EntityAttributes.GENERIC_ARMOR, 0.0d)
                .add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS, 10d)
                ;
    }

    @Override
    public boolean canPickUpLoot() {
        return false;
    }

    @Override
    public boolean isConvertingInWater() {
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

}
