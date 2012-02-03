/**
 * 
 */
package com.squaremarks.gaeofy.rest;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import br.com.caelum.vraptor.deserialization.Deserializes;
import br.com.caelum.vraptor.deserialization.JsonDeserializer;
import br.com.caelum.vraptor.http.ParameterNameProvider;
import br.com.caelum.vraptor.interceptor.TypeNameExtractor;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.resource.ResourceMethod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squaremarks.gaeofy.ofy.GAEOfy;

/**
 * @author brunofuster
 * 
 */

@Component
@Deserializes({"application/json","json"})
public class CustomJsonDeserializer extends JsonDeserializer {

	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss.SSS zzz").create();

	public CustomJsonDeserializer(ParameterNameProvider param,
			TypeNameExtractor type) {

		super(param, type);
	}

	@Override
	public Object[] deserialize(InputStream inputStream, ResourceMethod method) {

		JSONObject obj = null;
		Object o;

		try {

			
			obj = new JSONObject(IOUtils.toString(inputStream));

			Iterator<String> keys = obj.keys();
			String identifier = null;
			while (keys.hasNext()) {
				identifier = keys.next();
				break;
			}

			String objStr = ((JSONObject) obj.get(identifier)).toString();
			o = gson.fromJson(objStr, GAEOfy.clazz(identifier));

		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

		return new Object[] { o };
	}
}
