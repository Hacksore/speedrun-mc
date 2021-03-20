package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
public class ExampleMod implements ModInitializer {
	public static long runStart;

	@Override
	public void onInitialize() {
		System.out.println("Hello Fabric world!");

		ServerWorldEvents.LOAD.register((server, world) -> {
			System.out.println("Game started setting timestamp");
			ExampleMod.runStart = System.currentTimeMillis();
		});
	}
}
