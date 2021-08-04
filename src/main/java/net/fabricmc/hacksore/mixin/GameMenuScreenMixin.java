package net.fabricmc.hacksore.mixin;

import net.fabricmc.hacksore.SpeedRunMC;
import net.minecraft.client.gui.screen.GameMenuScreen;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMenuScreen.class)
public class GameMenuScreenMixin {

	// set the pauseStart timestamp when the game is paused
	@Inject(at = @At(value = "TAIL"), method = "<init>()V")
	private void constructor(boolean showMenu, CallbackInfo cbInfo) {
		SpeedRunMC.on();
	}
}
