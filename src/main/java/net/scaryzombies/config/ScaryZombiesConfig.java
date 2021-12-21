package net.scaryzombies.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import net.scaryzombies.ScaryZombiesMod;

@Config(name = ScaryZombiesMod.MOD_ID)
public class ScaryZombiesConfig implements ConfigData {
    public double SWIMSIGHT = 0.1D;
    public double SNEAKSIGHT = 0.5D;
    public double STANDSIGHT = 1.0D;
    public double SPRINTSIGHT = 2.0D;

}
