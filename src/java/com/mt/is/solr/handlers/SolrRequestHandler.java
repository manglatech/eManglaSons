package com.mt.is.solr.handlers;

import com.mt.is.solr.SolrRequestParam;
import com.mt.is.solr.config.SolrRequestConfig;
import com.mt.is.solr.exception.VZWSolrException;

public interface SolrRequestHandler {
	public Object execute(SolrRequestConfig config,SolrRequestParam param) throws VZWSolrException; 
}
