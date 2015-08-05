package com.mt.is.solr.parsers;

import com.mt.is.solr.SolrRequestParam;
import com.mt.is.solr.config.SolrQueryConfig;
import com.mt.is.solr.exception.VZWSolrException;

public interface SolrQueryParser {
	public String parseQuery(SolrQueryConfig query, SolrRequestParam param) throws VZWSolrException;
}
