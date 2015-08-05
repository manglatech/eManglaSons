package com.mt.is.solr.config;

import com.mt.is.solr.exception.VZWSolrException;

public class SolrServiceConfigLoader {

	private static SolrServiceConfigLoader _instance;
	private SolrServiceConfig config;
	
	private SolrServiceConfigLoader(){
	}
	
	public static SolrServiceConfigLoader getInstance(){
		if(_instance == null){
			_instance = new SolrServiceConfigLoader();
		}
		return _instance;
	}
	public void initializeSolrServiceConfig(SolrServiceConfig config){
		_instance.config = config;
	}
	
	public SolrServiceConfig getConfig() throws VZWSolrException{
		if(_instance.config == null)
			throw new VZWSolrException("Solr Service Config is not initialize");
		
		return _instance.config;
	}
}
