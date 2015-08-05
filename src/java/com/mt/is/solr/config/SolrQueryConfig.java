package com.mt.is.solr.config;

public class SolrQueryConfig {
	
	private String queryId;
	private String append;
	private String queryString;
	private String parser;
	private String appendList;
	private String paramMethod;
	
	public String getAppend() {
		return append;
	}
	public void setAppend(String append) {
		this.append = append;
	}
	public String getQueryString() {
		return queryString;
	}
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	public String getParser() {
		return parser;
	}
	public void setParser(String parser) {
		this.parser = parser;
	}
	public String getAppendList() {
		return appendList;
	}
	public void setAppendList(String appendList) {
		this.appendList = appendList;
	}
	public String getParamMethod() {
		return paramMethod;
	}
	public void setParamMethod(String paramMethod) {
		this.paramMethod = paramMethod;
	}
	public String getQueryId() {
		return queryId;
	}
	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}
	
}
