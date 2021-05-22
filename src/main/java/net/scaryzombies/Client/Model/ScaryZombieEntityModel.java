//package net.scaryzombies.Client.Model;
//
//import net.minecraft.Client.Model.ModelPart;
//import net.minecraft.Client.render.VertexConsumer;
//import net.minecraft.Client.render.Entity.Model.EntityModel;
//import net.minecraft.Client.util.math.MatrixStack;
//import net.scaryzombies.Entity.ScaryZombieEntity;
//
//public class ScaryZombieEntityModel extends EntityModel<ScaryZombieEntity> {
//    private final ModelPart base;
//
//    public ScaryZombieEntityModel() {
//        base = new ModelPart(this, 0, 0);
//
//    }
//
//    @Override
//    public void setAngles(ScaryZombieEntity Entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
//
//    }
//
//    @Override
//    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
//        // translate Model down
//        // matrices.translate(0, 1.125, 0);
//
//        // render cube
//        base.render(matrices, vertices, light, overlay);
//    }
//}
