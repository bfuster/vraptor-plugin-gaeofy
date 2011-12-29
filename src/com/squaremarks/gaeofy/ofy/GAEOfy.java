package com.squaremarks.gaeofy.ofy;


/**
 * Just a helper to register objectify entities easier
 * 
 * @author brunofuster
 *
 */
public class GAEOfy {

	public static GAEOfyRegister register(Class<?>... clazz) {
		return new GAEOfyRegister().and(clazz);
	}
	
}
