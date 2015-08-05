package com.mt.is.solr.handlers;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.UpdateResponse;

import com.mt.is.solr.SolrRequestParam;
import com.mt.is.solr.config.SolrQueryConfig;
import com.mt.is.solr.config.SolrRequestConfig;
import com.mt.is.solr.exception.VZWSolrException;

public class SolrDeleteQueryHandler extends SolrBaseRequestHandler implements
		SolrRequestHandler {

	@Override
	public Object execute(SolrRequestConfig config, SolrRequestParam param)
			throws VZWSolrException {
		
		SolrClient solrServer = getSolrServer();
		List<SolrQueryConfig> fq = config.getQuery();
		String q = parseQuery(fq, param);
		
		try{
			
			UpdateResponse response = solrServer.deleteByQuery(q);
			solrServer.commit();
			System.out.println("SolrDelete ***** TASK Deleted Successfully ");
			return postExecute(response);
			
		} catch (SolrServerException e) {
			throw new VZWSolrException("Problem in executing qeury",e);
		}catch (IOException e) {
			throw new VZWSolrException("Problem in executing qeury",e);
		}
	}
	protected Object postExecute(UpdateResponse results) {
		return results;
	}
}
