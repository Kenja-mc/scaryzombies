/*
package net.scaryzombies.mobs.ScaryZombie;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.entity.mob.ZombieEntity;

@Environment(EnvType.CLIENT)
public class ScaryZombieModel<T extends ZombieEntity> extends ZombieEntityModel<T> {
    public ScaryZombieModel(ModelPart modelPart) {
        super(modelPart);
    }

    //From DrownedEntityModel.class
    public static TexturedModelData getTexturedModelData(Dilation dilation) {
        ModelData modelData = BipedEntityModel.getModelData(dilation, 0.0f);
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("left_arm", ModelPartBuilder.create().uv(32, 48).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, dilation), ModelTransform.pivot(5.0F, 2.0F, 0.0F));
        modelPartData.addChild("left_leg", ModelPartBuilder.create().uv(16, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, dilation), ModelTransform.pivot(1.9F, 12.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

}

 */
