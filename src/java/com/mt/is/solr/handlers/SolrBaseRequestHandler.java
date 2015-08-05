package com.mt.is.solr.handlers;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

import com.mt.is.solr.SolrRequestParam;
import com.mt.is.solr.config.SolrQueryConfig;
import com.mt.is.solr.config.SolrServiceConfigLoader;
import com.mt.is.solr.exception.VZWSolrException;
import com.mt.is.solr.parsers.SolrParserProcessor;
import com.mt.is.solr.parsers.SolrParserProcessorImpl;

public class SolrBaseRequestHandler {

	protected SolrParserProcessor parserProcessor = SolrParserProcessorImpl
			.getInstance();
	protected SolrClient server;
	private static final Logger logger = Logger
			.getLogger(SolrBaseRequestHandler.class);

	protected SolrClient getSolrServer() throws VZWSolrException {
		if (server == null) {

			//String solrHostName = SolrServiceConfigLoader.getInstance().getConfig().getSolrHostName();
			String solrHostName = "http://localhost:8983/solr/GSOLR";
			//String solrHostName = "http://saswcicszad251.sdc.vzwcorp.com:6151/solr/NTCore";
			// String solrHostName =

			logger.debug("Solr Host:" + solrHostName);
			server = new HttpSolrClient(solrHostName);
		}
		return server;
	}

	/*protected String parseQuery(SolrRequestConfig config, SolrRequestParam param)
			throws VZWSolrException {

		List<SolrQueryConfig> qList = config.getFilterQuery();
		String query = null;
		if (qList != null) {
			query = parseQuery(qList, param);
		}
		return query;
	}*/

	protected String parseQuery(List<SolrQueryConfig> qList, SolrRequestParam param)
			throws VZWSolrException {
		return parserProcessor.processQuery(qList, param);
	}

	protected String parseQuery(SolrQueryConfig q, SolrRequestParam param)
			throws VZWSolrException {
		return parserProcessor.processQuery(q, param);
	}
}
