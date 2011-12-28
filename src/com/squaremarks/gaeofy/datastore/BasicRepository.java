package com.squaremarks.gaeofy.datastore;


/**
 * Just joining repository default behaviors (save, remove, list)
 * 
 * @author bfuster
 * 
 * @param <T>
 */

public interface BasicRepository<T> extends SaveRepository<T>,
		RemoveRepository<T>, ListRepository<T> {
}
