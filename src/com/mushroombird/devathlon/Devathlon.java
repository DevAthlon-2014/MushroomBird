package com.mushroombird.devathlon;

import java.util.Random;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Devathlon plugin, created on 18.10.2014
 * @author MushroomBird
 */
public class Devathlon extends JavaPlugin {
	
	//INSTANCE
	private static Devathlon instance; 
	
	//RANDOM
	private static Random random = new Random();
	
	@Override
	public void onLoad() {
		instance = this;
	}
	
	@Override
	public void onEnable() {
		getLogger().info("Plugin aktiviert!");
	}
	
	@Override
	public void onDisable() {
		getLogger().info("Plugin deaktiviert!");
	}
	
	/**
	 * Get Instance of mainclass
	 * @return Instance of main class
	 */
	public static Devathlon getInstance() {
		return instance;
	}
	
	/**
	 * Get Random
	 * @see java.util.Random
	 * @return Random engine
	 */
	public static Random getRandomEngine() {
		return random;
	}
}
