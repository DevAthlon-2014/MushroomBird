package com.mushroombird.devathlon.effect;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.mushroombird.devathlon.util.ReflectionUtil;

/**
 * EffectEnum
 * @author MushroomBird
 */
public enum Effect {
	
	/**
	 * BowFire bukkit effect
	 */
	BOW_FIRE(org.bukkit.Effect.BOW_FIRE.getClass());
	
	Class<?> clazz;
	
	Effect(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	public Class<?> getClazz() {
		return clazz;
	}
	
	/**
	 * Animate an effect at location
	 * @param location Effect location
	 * @param radius Animate radius
	 */
	@SuppressWarnings("deprecation")
	public void animate( Location location, int radius ) {
		for ( int i = 0; i < Bukkit.getOnlinePlayers().length; i++ ) {
			Player player = Bukkit.getOnlinePlayers()[i];
			if (player.getLocation().distance(location) > radius) {
				continue;
			}
			ReflectionUtil.sendPacket(player, null /* TODO Edit */);
		}
	}
}
