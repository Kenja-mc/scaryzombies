/*
package net.scaryzombies.mobs.ScaryZombie;

import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;

public class ScaryZombieMeleeAttackGoal extends MeleeAttackGoal {
    private final ScaryZombieEntity sze;
    private int ticks;

    public ScaryZombieMeleeAttackGoal(ScaryZombieEntity sze, double speed) {
        super(sze, speed, false);
        this.sze = sze;
        //TODO: What does pausewhenmobidle mean?
    }

    public void start() {
        super.start();
        this.ticks = 0;
    }

    public void stop() {
        super.stop();
        this.sze.setAttacking(false);
    }

    public void tick() {
        super.tick();
        ++this.ticks;
        if (this.ticks >= 5 && this.getCooldown() < this.getMaxCooldown() / 2) {
            this.sze.setAttacking(true);
        } else {
            this.sze.setAttacking(false);
        }

    }
}

 */
