package com.mt.is.solr.config;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.mt.is.solr.exception.VZWSolrException;

public class SolrConfigLocator {
	
	private static SolrConfigLocator _locator = null;
	private Map<String, SolrRequestConfig> configList = new HashMap<String, SolrRequestConfig>();
	private JAXBContext jc;
	
	public static SolrConfigLocator getInstance() {
		if(_locator == null){
			_locator = new SolrConfigLocator();
		}
		return _locator;
	}
	
	private SolrConfigLocator(){}

	public SolrRequestConfig getConfig(String reqConfig) throws VZWSolrException {
		SolrRequestConfig rConfig = configList.get(reqConfig);
		
		if(rConfig == null){
			String fileName = "solr/"+ reqConfig + ".xml";
			try {
				
				jc = JAXBContext.newInstance(SolrRequestConfig.class);
				Unmarshaller unmarshaller = jc.createUnmarshaller();
				InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
		        rConfig = (SolrRequestConfig) unmarshaller.unmarshal(inputStream);
		        configList.put(reqConfig,  rConfig);
		        
			} catch (Exception e) {
				throw new VZWSolrException("could not find Configuration for config:"+reqConfig);
			}
		}
		return rConfig;
	} 
}
