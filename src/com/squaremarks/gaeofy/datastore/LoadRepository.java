package com.squaremarks.gaeofy.datastore;

import com.googlecode.objectify.Key;

public interface LoadRepository<T> {

	/**
	 * Load a single entity
	 * @param id
	 * @return
	 */
	T load(Long id);
	
	/**
	 * Batch load entities
	 * @param ids
	 * @return
	 */
	Iterable<T> load(Iterable<Key<T>> ids);

}
