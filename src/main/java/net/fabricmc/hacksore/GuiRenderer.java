package net.fabricmc.hacksore;

import org.apache.commons.lang3.time.DurationFormatUtils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

public class GuiRenderer { 

  public static String getRunTime() {
    long timeElapsed = (System.currentTimeMillis() - SpeedRunMC.runStart);
    return DurationFormatUtils.formatDuration(timeElapsed, "HH:mm:ss:S");
  }

  public static void onRender(MatrixStack matrices, float tickDelta) {

    DrawableHelper.fill(matrices, 10, 01, 100, 100, 0x00000000);
    MinecraftClient.getInstance().textRenderer.draw(matrices, getRunTime(), 10, 10, 0x00FFFFFF);

  }
}
