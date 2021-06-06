package net.scaryzombies.Entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.World;

public class ScaryZombieEntity extends ZombieEntity {

    public ScaryZombieEntity(EntityType<? extends ZombieEntity> entityType, World world){
        super(entityType, world);
        this.experiencePoints = 0;
    }

    public static DefaultAttributeContainer.Builder createScaryZombieEntityAttributes() {
        return HostileEntity.createHostileAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 7.0 + 7.0)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.387)
            .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64)

//            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.5)
//            .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 0.0)
//            .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.5)
//            .add(EntityAttributes.GENERIC_ARMOR, 0.0)
//            .add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS, 0.0)

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
