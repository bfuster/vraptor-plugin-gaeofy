package com.squaremarks.gaeofy.datastore.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.googlecode.objectify.AsyncObjectify;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
import com.squaremarks.gaeofy.datastore.DataStoreTemplate;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;

@Component
@ApplicationScoped
public class DataStoreTemplateImpl implements DataStoreTemplate {

	private final Objectify ofy;
	private final AsyncObjectify ofyAsync;

	public DataStoreTemplateImpl() {
		this.ofy = ObjectifyService.begin();
		this.ofyAsync = this.ofy.async();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wesave.repository.DataStoreTemplate#save(java.lang.Object)
	 */
	public <T> Key<T> save(T obj) {

		return ofy().put(obj);
	}
	
	public <T> void saveAsync(T obj) {

		ofyAsync.put(obj);
	}
	
	/*
	 * (non-Javadoc)
	 * @see br.com.wesave.repository.DataStoreTemplate#save(java.util.Collection)
	 */
	public <T> Iterable<T> save(Collection<T> objs) {
		
		Map<Key<T>, T> put = ofy().put(objs);
		
		return get(put.keySet());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wesave.repository.DataStoreTemplate#save(java.lang.Iterable)
	 */
	@Override
	public <T> Iterable<T> save(Iterable<T> obj) {

		return ofy().put(obj).values();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wesave.repository.DataStoreTemplate#save(T[])
	 */
	@Override
	public <T> Iterable<T> save(T... obj) {

		return ofy().put(obj).values();
	}
	
	/*
	 * (non-Javadoc)
	 * @see br.com.wesave.repository.DataStoreTemplate#saveAsync(T[])
	 */
	@Override
	public <T> void saveAsync(T... obj) {
		
		ofyAsync.put(obj);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.wesave.repository.DataStoreTemplate#get(com.googlecode.objectify
	 * .Key)
	 */
	@Override
	public <T> T get(Key<T> key) {

		return ofy().get(key);
	}
	
	/*
	 * (non-Javadoc)
	 * @see br.com.wesave.repository.DataStoreTemplate#get(java.lang.Iterable)
	 */
	@Override
	public <T> Iterable<T> get(Iterable<Key<T>> keys) {
		
		return ofy().get(keys).values();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wesave.repository.DataStoreTemplate#list(java.lang.Class)
	 */
	@Override
	public <T> List<T> list(Class<T> clazz) {

		return ofy().query(clazz).list();
	}

	/*
	 * (non-Javadoc)
	 * @see com.squaremarks.gaeofy.datastore.DataStoreTemplate#query()
	 */
	@Override
	public <T> Query<T> query() {
		
		return ofy().query();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.squaremarks.gaeofy.datastore.DataStoreTemplate#query(java.lang.Class)
	 */
	@Override
	public <T> Query<T> query(Class<T> clazz) {
		
		return ofy().query(clazz);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.wesave.repository.DataStoreTemplate#ofy()
	 */
	@Override
	public Objectify ofy() {

		return ofy;
	}
	
	@Override
	public AsyncObjectify ofyAsync() {
		
		return ofyAsync;
	}
}
