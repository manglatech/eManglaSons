package com.mt.is.solr.handlers;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.SortClause;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import com.mt.is.solr.SolrRequestParam;
import com.mt.is.solr.config.SolrFilterQueryConfig;
import com.mt.is.solr.config.SolrQueryConfig;
import com.mt.is.solr.config.SolrRequestConfig;
import com.mt.is.solr.config.SolrSortConfig;
import com.mt.is.solr.exception.VZWSolrException;

public class SolrSearchQueryHandler extends SolrBaseRequestHandler implements SolrRequestHandler{

	protected SolrRequestParam param; 
	protected SolrRequestConfig config;
	protected SolrQuery query;
	
	@Override
	public Object execute(SolrRequestConfig config,
			SolrRequestParam param) throws VZWSolrException {
		
		this.param = param;
		this.config = config;
		
		SolrClient solrServer = getSolrServer();
		query = new SolrQuery();
		
		List<SolrQueryConfig> qList = config.getQuery();
		if(qList != null){
			String q = parseQuery(qList, param);
			System.out.println("QUERY=>:"+q+":");
			query.setQuery(q);
		}
		
		List<SolrQueryConfig> fqList = config.getFilterQuery();
		if(fqList != null){
			for(SolrQueryConfig fqConfig : fqList){
				String q = parseQuery(fqConfig, param);
				System.out.println("Filter QUERY=>:"+q+":");
				query.addFilterQuery(q);
			}
		}
		
		query.setRows(config.getMaxResults());
		//Override Values from Request Param
		if(param.getMaxResult() != null){
			config.setMaxResults(param.getMaxResult());
		}
		
		if(StringUtils.isNotBlank(config.getFields()))
			query.setFields(config.getFields());
		
		List<SolrSortConfig> sortConfigs = config.getSorts();
		if(sortConfigs != null){
			for(SolrSortConfig sConfig : sortConfigs){
				SortClause sortClause = new SortClause(sConfig.getField(), sConfig.getOrder());
				query.addSort(sortClause);
			}
		}
		
		if(config.getHlConfig() != null){
			query.setHighlight(config.getHlConfig().isEnable());
			query.addHighlightField(config.getHlConfig().getFields());
		}
		
		if(config.getFacetConfig() != null){
			query.setFacet(config.getFacetConfig().isEnable());
			query.setFacetMinCount(config.getFacetConfig().getMinCount());
			for(String field : config.getFacetConfig().getFields()){
				query.addFacetField(field);
			}
			query.setFacetLimit(config.getFacetConfig().getLimit());
		}
		
		QueryResponse response;
		
		try {
			
			preExecute(config, param);
			response = solrServer.query(query);
			return postExecute(response);
			
		} catch (SolrServerException e) {
			throw new VZWSolrException("Solr Exception in executing qeury",e);
		}catch (Exception e) {
			throw new VZWSolrException("Exception in executing qeury",e);
		}
	}
	
	protected void preExecute(SolrRequestConfig config,
			SolrRequestParam param) throws VZWSolrException{
		
		if(param.getFq() != null){
			if(param.isClearConfigFQ()){
				String[] fqs = query.getFilterQueries();
				for(int i=0; i <fqs.length; i++){
					query.removeFilterQuery(fqs[i]);
				}
			}
			for(SolrFilterQueryConfig fq: param.getFq()){
				query.addFilterQuery(fq.getKey()+":"+"\""+fq.getValue()+"\"");
			}
		}
		
	}
	
	protected Object postExecute(QueryResponse response) {
		SolrDocumentList results = response.getResults();
		return postExecute(results);
	}
	
	protected Object postExecute(SolrDocumentList results) {
		return results;
	}
	
}
