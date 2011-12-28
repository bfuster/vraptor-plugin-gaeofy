package com.squaremarks.gaeofy.datastore;

import java.util.Collection;

public interface ListRepository<T> {

	public Collection<T> list();

}
