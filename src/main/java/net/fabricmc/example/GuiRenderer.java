package net.fabricmc.example;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

public class GuiRenderer {

  public static String getRunTime() {
    String timeString = "";
    timeString = "" + (System.currentTimeMillis() - ExampleMod.runStart);
    return timeString;
  }

  public static void onRender(MatrixStack matrices, float tickDelta) {

    DrawableHelper.fill(matrices, 10, 01, 100, 100, 0x00000000);
    MinecraftClient.getInstance().textRenderer.draw(matrices, getRunTime(), 10, 10, 0x00FFFFFF);

  }
}
