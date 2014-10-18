package com.mushroombird.devathlon.util;

import java.lang.reflect.Method;

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
		return null;
	}
}
