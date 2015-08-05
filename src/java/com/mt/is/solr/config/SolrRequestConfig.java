package com.mt.is.solr.config;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="SolrRequest")
public class SolrRequestConfig {

	//TODO: Change config same as Sort
	private List<SolrQueryConfig> query;
	private List<SolrQueryConfig> filterQuery;
	private String action;
	private String handler;
	private Integer maxResults;
	private String fields;
	private List<SolrSortConfig> sorts;
	private boolean debug;
	private String entity;
	private boolean clean;
	private SolrResultHighlightsConfig hlConfig;
	private SolrFacetConfig facetConfig;
	
	@XmlElement(name="action")
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	@XmlElement(name="filterQuery")
	@XmlElementWrapper(name="filterQueries")
	public List<SolrQueryConfig> getFilterQuery() {
		return filterQuery;
	}
	public void setFilterQuery(List<SolrQueryConfig> filterQuery) {
		this.filterQuery = filterQuery;
	}
	@XmlElement(name="query")
	@XmlElementWrapper(name="queries")
	public List<SolrQueryConfig> getQuery() {
		return query;
	}
	public void setQuery(List<SolrQueryConfig> query) {
		this.query = query;
	}
	
	@XmlElement(name="handler")
	public String getHandler() {
		return handler;
	}
	public void setHandler(String handler) {
		this.handler = handler;
	}
	
	@XmlElement(name="maxResults")
	public Integer getMaxResults() {
		if(maxResults == null)
			return 100000;
		return maxResults;
	}
	public void setMaxResults(Integer maxResults) {
		this.maxResults = maxResults;
	}
	@XmlElement(name="returnFields")
	public String getFields() {
		return fields;
	}
	public void setFields(String fields) {
		this.fields = fields;
	}
	@XmlElement(name="sort")
	@XmlElementWrapper(name="sorts")
	public List<SolrSortConfig> getSorts() {
		return sorts;
	}
	public void setSorts(List<SolrSortConfig> sorts) {
		this.sorts = sorts;
	}
	
	@XmlElement(name="debug")
	public boolean isDebug() {
		return debug;
	}
	public void setDebug(boolean debug) {
		this.debug = debug;
	}
	
	@XmlElement(name="entity")
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	
	@XmlElement(name="clean")
	public boolean isClean() {
		return clean;
	}
	public void setClean(boolean clean) {
		this.clean = clean;
	}
	@XmlElement(name="highlights")
	public SolrResultHighlightsConfig getHlConfig() {
		return hlConfig;
	}
	public void setHlConfig(SolrResultHighlightsConfig hlConfig) {
		this.hlConfig = hlConfig;
	}
	
	@XmlElement(name="facet")
	public SolrFacetConfig getFacetConfig() {
		return facetConfig;
	}
	public void setFacetConfig(SolrFacetConfig facetConfig) {
		this.facetConfig = facetConfig;
	}
}
