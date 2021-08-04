package net.fabricmc.hacksore.mixin;

import net.fabricmc.hacksore.SpeedRunMC;
import net.minecraft.client.MinecraftClient;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

    // set the pauseEnd timestamp when the game is un paused
    // also reset the pauseStart
    @Inject(at = @At(value = "TAIL"), method = "openPauseMenu")
    private void openPauseMenu(boolean pause, CallbackInfo cbInfo) {
        SpeedRunMC.openPauseMenu(pause);
    }

}
