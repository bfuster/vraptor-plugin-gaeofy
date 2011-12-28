package com.squaremarks.gaeofy.datastore;

import java.util.List;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;

/**
 * Objectify template
 * 
 * @author bfuster
 * 
 */
public interface DataStoreTemplate {

	/**
	 * Put entity into datastore
	 * 
	 * @return
	 */
	public <T> Key<T> save(T obj);
	
	/**
	 * put db assync
	 */
	public <T> void saveAsync(T obj);
	
	/**
	 * Put entities into database
	 * 
	 * @param <T>
	 * @param objs
	 * @return
	 */
	public <T> Iterable<T> save(Iterable<T> objs);

	/**
	 * Get an object, given it's key
	 * 
	 * @param <T>
	 * @param key
	 * @return
	 */
	public <T> T get(Key<T> key);
	
	/**
	 * Batch get entities
	 * @param <T>
	 * @param keys
	 * @return
	 */
	public <T> Iterable<T> get(Iterable<Key<T>> keys); 

	/**
	 * Put entities into datastore
	 * 
	 * @return
	 */
	public <T> Iterable<T> save(T... obj);
	
	/**
	 * Put entities async into datastore
	 * 
	 * @return
	 */
	public <T> void saveAsync(T... obj);

	/**
	 * List entities
	 * 
	 * @param <T>
	 * @param obj
	 * @return
	 */
	public <T> List<T> list(Class<T> clazz);

	/**
	 * Returns an ofy object
	 * 
	 * @return
	 */
	public Objectify ofy();

}
