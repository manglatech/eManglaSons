package com.mt.is.solr.parsers;

import java.util.List;

import com.mt.is.solr.SolrRequestParam;
import com.mt.is.solr.config.SolrQueryConfig;
import com.mt.is.solr.exception.VZWSolrException;

public interface SolrParserProcessor {

	String processQuery(List<SolrQueryConfig> qList, SolrRequestParam param) throws VZWSolrException;
	String processQuery(SolrQueryConfig q, SolrRequestParam param)throws VZWSolrException;

}
