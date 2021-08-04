package net.fabricmc.hacksore;
import net.fabricmc.api.ModInitializer;
public class SpeedRunMC implements ModInitializer {
	public static long runStart = 0L;
	public static long pauseStart = 0L;
	public static long pauseEnd = 0L;

	@Override
	public void onInitialize() {

	}

	public static void openPauseMenu(boolean pause) {
		System.out.println("openPauseMenu");
		System.out.println("pause: " + pause);
		SpeedRunMC.pauseEnd = 0L;
		SpeedRunMC.pauseStart = System.currentTimeMillis();
	}

	public static void onGameStart() {
		System.out.println("GAME HAS STARTED!");
		SpeedRunMC.pauseStart = 0L;
		SpeedRunMC.pauseEnd = 0L;
		SpeedRunMC.runStart = System.currentTimeMillis();
	}

	public static void on() {
		System.out.println("GameMenuScreenMixin");
	}


}
