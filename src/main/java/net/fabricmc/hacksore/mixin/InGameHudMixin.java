package net.fabricmc.hacksore.mixin;

import net.fabricmc.hacksore.GuiRenderer;
import net.fabricmc.hacksore.SpeedRunMC;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin extends DrawableHelper {

	// call render for the custom text
	@Inject(at = @At(value = "TAIL"), method = "render")
	private void renderOverride(MatrixStack matrices, float tickDelta, CallbackInfo cbInfo) {
		GuiRenderer.onRender(matrices, tickDelta);
	}
}
