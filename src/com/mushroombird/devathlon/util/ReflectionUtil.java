package com.mushroombird.devathlon.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.mushroombird.devathlon.Devathlon;

/**
 * ReflectionUtil
 * @author MushroomBird
 */
public class ReflectionUtil {
	
	/**
	 * Get a method
	 */
	public static Method getMethod(Class<?> clazz, String name, Class<?>... args) {
		for (int i = 0; i < clazz.getMethods().length; i++) {
			Method method = clazz.getMethods()[i];
			if (method.getName().equals(name) && args.length != 0) {
				method.setAccessible(true);
				return method;
			}
		}
		//IF CAN'T GET METHOD, RETURNS NULL
		return null;
	}
	
	/**
	 * Get a Field
	 */
	public static Field getField(Class<?> clazz, String name) {
		try {
			return clazz.getDeclaredField(name);
		} catch (NoSuchFieldException | SecurityException e) {
			Devathlon.getInstance().getLogger().info("Can't get field! @see " + ReflectionUtil.class.getName() + ": Method: getFields");
		}
		
		//IF CAN'T GET FIELD, RETURNS NULL
		return null;
	}
	
	/**
	 * Set value
	 */
	public static void setValue(Class<?> clazz, String fieldName, Object object, Object value) {
		Field field = getField(clazz, fieldName);
		try {
			field.setAccessible(true);
			field.set(field, value);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			Devathlon.getInstance().getLogger().info("Can't set value! @see " + ReflectionUtil.class.getName() + ": Method: setValue");
		}
	}
}
