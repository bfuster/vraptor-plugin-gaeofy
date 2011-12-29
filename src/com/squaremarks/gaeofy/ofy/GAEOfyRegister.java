package com.squaremarks.gaeofy.ofy;

import static com.googlecode.objectify.ObjectifyService.register;


/**
 * GAEOfyRegister 
 * 
 * @author brunofuster
 *
 */
public class GAEOfyRegister {

	public GAEOfyRegister and(Class<?>... clazz) {

		for (Class<?> c : clazz)
			register(c);
		
		return this;
	}
	
}
