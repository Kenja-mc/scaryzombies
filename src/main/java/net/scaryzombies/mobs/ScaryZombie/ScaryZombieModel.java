package net.scaryzombies.mobs.ScaryZombie;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;

@Environment(EnvType.CLIENT)
public class ScaryZombieModel<T extends ScaryZombieEntity> extends BipedEntityModel<T> {

    public ScaryZombieModel(ModelPart root) {
        super(root);

    }
}
