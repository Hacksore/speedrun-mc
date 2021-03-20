package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents.Load;

public class ExampleMod implements ModInitializer {
	public static long runStart;

	@Override
	public void onInitialize() {
		System.out.println("Hello Fabric world!");
	}

	public static final Event<Load> LOAD = EventFactory.createArrayBacked(Load.class, callbacks -> (server, world) -> {
		System.out.println("Game started setting timestamp");
		ExampleMod.runStart = System.currentTimeMillis();
	});
}
