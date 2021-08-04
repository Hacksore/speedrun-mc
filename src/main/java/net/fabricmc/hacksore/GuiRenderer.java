package net.fabricmc.hacksore;

import net.minecraft.client.font.TextRenderer;
import org.apache.commons.lang3.time.DurationFormatUtils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class GuiRenderer {
  public static long totalPausedDuration = 0;

  public static long getElapsedTime() {
    boolean isPaused = MinecraftClient.getInstance().isPaused();

    if (isPaused) {
      totalPausedDuration = System.currentTimeMillis() - SpeedRunMC.pauseStart;
    }

    return (System.currentTimeMillis() - SpeedRunMC.runStart) - totalPausedDuration;
  }

  public static String getRunTimeString() {
    long durationMillis = GuiRenderer.getElapsedTime();
    if (durationMillis > 0) {
      return DurationFormatUtils.formatDuration(durationMillis, "HH:mm:ss:S");
    } else {
      return "nothing yet";
    }
  }

  public static void onRender(MatrixStack matrices, float tickDelta) {
    MinecraftClient mc = MinecraftClient.getInstance();
    TextRenderer textRenderer = mc.textRenderer;

    textRenderer.draw(matrices, getRunTimeString(), 10, 10, 0x00FFFFFF);

    String debug = String.format("(%s - %s) - %s", System.currentTimeMillis(), SpeedRunMC.runStart, totalPausedDuration);
    textRenderer.draw(matrices, debug, 10, 40, 0x00FFFFFF);

    long l = (System.currentTimeMillis() - SpeedRunMC.runStart) - totalPausedDuration;
    textRenderer.draw(matrices, "" + l, 10, 60, 0x00FFFFFF);


  }
}
