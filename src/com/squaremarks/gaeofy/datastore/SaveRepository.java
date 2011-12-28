package com.squaremarks.gaeofy.datastore;

public interface SaveRepository<T> {

	/**
	 * Save domain
	 * 
	 * @param obj
	 * @return
	 */
	public T save(T obj);

}
