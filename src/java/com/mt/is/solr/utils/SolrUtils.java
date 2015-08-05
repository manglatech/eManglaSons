package com.mt.is.solr.utils;

import java.lang.reflect.Method;

import com.mt.is.solr.SolrRequestParam;
import com.mt.is.solr.exception.VZWSolrException;

public class SolrUtils {

	public static Object getClassInstance(String parserStr) throws VZWSolrException {
		Object o;
		Class<?> c;
		try {
			c = Class.forName(parserStr);
			o = c.newInstance();
		} catch (Exception e) {
			throw new VZWSolrException("Could not find class for "+ parserStr);
		}
		return o;
	}

	public static Object getMethodParam(String paramMethod,
			SolrRequestParam param) throws VZWSolrException {
		
		Method method = null;
		Object obj = null;
		
		try {
			method = param.getClass().getMethod(paramMethod);
			obj = method.invoke(param);
		} catch (Exception e) {
			throw new VZWSolrException("Could not get Request Params");
		}
		return obj;
	}
}
