package com.mt.is.solr.processors;

import com.mt.is.solr.SolrRequestParam;
import com.mt.is.solr.exception.VZWSolrException;

public interface SolrRequestProcessor {
	public Object executeSolrReq(String action,SolrRequestParam param) throws VZWSolrException;
}
