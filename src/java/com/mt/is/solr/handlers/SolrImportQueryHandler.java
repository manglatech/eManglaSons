package com.mt.is.solr.handlers;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.ModifiableSolrParams;

import com.mt.is.solr.SolrRequestParam;
import com.mt.is.solr.config.SolrRequestConfig;
import com.mt.is.solr.exception.VZWSolrException;

public class SolrImportQueryHandler extends SolrBaseRequestHandler
		implements SolrRequestHandler {

	@Override
	public Object execute(SolrRequestConfig config, SolrRequestParam param)
			throws VZWSolrException {

		SolrClient solrServer = getSolrServer();
		ModifiableSolrParams params = new ModifiableSolrParams();

		params.set("qt", "/dataimport");
		params.set("debug", config.isDebug());
		params.set("command", config.getAction());
		params.set("clean",config.isClean());
				
		if(config.getEntity() != null){
			params.set("entity",config.getEntity());
		}
		
		String id = param.getReqParams().get("UpdatedEntityId");
		if(id != null){
			params.set("UPD_ID", id);
		}
		
		try {
			QueryResponse response = solrServer.query(params);
			return postExecute(response);
		} catch (IOException e) {
			throw new VZWSolrException("Problem in executing qeury", e);
		} catch (SolrServerException e) {
			throw new VZWSolrException("Problem in executing qeury", e);
		} 
	}
	
	protected Object postExecute(QueryResponse results) {
		return results;
	}
}
