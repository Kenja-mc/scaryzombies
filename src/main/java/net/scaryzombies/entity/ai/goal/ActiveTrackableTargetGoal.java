package net.scaryzombies.entity.ai.goal;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.jetbrains.annotations.Nullable;

import static net.scaryzombies.ScaryZombiesMod.CONFIG;

public class ActiveTrackableTargetGoal extends ActiveTargetGoal {
    protected final Class targetClass;

    @Nullable
    public ActiveTrackableTargetGoal(MobEntity mob, Class targetClass, boolean checkVisibility) {
        super(mob, targetClass, checkVisibility);
        this.targetClass = targetClass;
    }

    @Override
    protected void findClosestTarget() {
        if (this.targetClass == PlayerEntity.class) {
            // LOGGER.info("Looking for swimming player.");
            this.targetEntity = this.mob.world.getClosestPlayer(this.mob.getX(), this.mob.getY(), this.mob.getZ(),
                    this.getFollowRange() * CONFIG.SWIMSIGHT, Entity::isInSwimmingPose);
            if (this.targetEntity != null) return;

            // LOGGER.info("Looking for sneaking player.");
            this.targetEntity = this.mob.world.getClosestPlayer(this.mob.getX(), this.mob.getY(), this.mob.getZ(),
                    this.getFollowRange() * CONFIG.SNEAKSIGHT, Entity::isInSneakingPose);
            if (this.targetEntity != null) return;

            // LOGGER.info("Looking for standing player.");
            this.targetEntity = this.mob.world.getClosestPlayer(this.mob.getX(), this.mob.getY(), this.mob.getZ(),
                    this.getFollowRange() * CONFIG.STANDSIGHT, entity -> entity.getPose() == EntityPose.STANDING);
            if (this.targetEntity != null) return;

            // LOGGER.info("Looking for sprinting player.");
            this.targetEntity = this.mob.world.getClosestPlayer(this.mob.getX(), this.mob.getY(), this.mob.getZ(),
                    this.getFollowRange() * CONFIG.SPRINTSIGHT, Entity::isSprinting);

        } else {
            this.targetEntity = null;
        }
    }
}
