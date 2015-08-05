package com.mt.is.solr.config;

public interface SolrServiceConfig {

	public String getSolrHostName();

	public boolean isIncludeProducts();

	public boolean isIncludeProjects();

	public boolean isIncludeVendor();
	
	public int getSearchMaxResultCnt();
	
	public int getSearchVendorMaxResultCnt();
	
	public int getSearchProdMaxResultCnt();
	
	public int getSearchProjMaxResultCnt();
	
	public String getPMTURL();
	
	public String getDSDTURL();
	
	public String getMyApplication();
	
	public String getPMTURLContext();
	
	public String getDSDTURLContext();
	
}
