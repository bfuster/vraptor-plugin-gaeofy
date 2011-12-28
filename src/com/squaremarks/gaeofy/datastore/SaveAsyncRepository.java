package com.squaremarks.gaeofy.datastore;

public interface SaveAsyncRepository<T> {

	/**
	 * Save domain
	 * 
	 * @param obj
	 * @return
	 */
	public void saveAsync(T obj);
}
