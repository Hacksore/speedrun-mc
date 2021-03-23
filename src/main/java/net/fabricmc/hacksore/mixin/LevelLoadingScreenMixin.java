package net.fabricmc.hacksore.mixin;

import net.fabricmc.hacksore.SpeedRunMC;
import net.minecraft.client.gui.screen.LevelLoadingScreen;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LevelLoadingScreen.class)
public class LevelLoadingScreenMixin {

	@Inject(at = @At(value = "HEAD"), method = "removed")
	private void removed(CallbackInfo cbInfo) {
		SpeedRunMC.runStart = System.currentTimeMillis();
	}
}
