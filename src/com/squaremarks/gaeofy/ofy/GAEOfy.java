package com.squaremarks.gaeofy.ofy;

import java.util.HashMap;
import java.util.Map;

import com.googlecode.objectify.ObjectifyService;

public class GAEOfy {

	private static final Map<String, Class<?>> clazzMap = new HashMap<String, Class<?>>();
	
	public static void register(Class<?> clazz, String... names) {

		ObjectifyService.register(clazz);
		
		for (String s : names)
			clazzMap.put(s, clazz);
		
		clazzMap.put(clazz.getName(), clazz);
		
	}
	
	public static Class<?> clazz(String key) {
		
		return clazzMap.get(key);
	}
	
	
}
