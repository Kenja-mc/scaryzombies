package net.scaryzombies.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// https://discord.com/channels/507304429255393322/507982478276034570/879918221350797312
// https://discord.com/channels/507304429255393322/507982478276034570/878550740833034260
@Mixin(TitleScreen.class)
public class TargetPredicateMixin {
    @Inject(
            method = "init",
            at = @At("HEAD")
    )
    private void init(CallbackInfo info) {
        System.out.println("This line is printed by an example mixin!");
    }
}
