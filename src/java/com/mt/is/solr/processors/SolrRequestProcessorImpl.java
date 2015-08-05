package com.mt.is.solr.processors;

import java.util.HashMap;
import java.util.Map;

import com.mt.is.solr.SolrRequestParam;
import com.mt.is.solr.config.SolrConfigLocator;
import com.mt.is.solr.config.SolrRequestConfig;
import com.mt.is.solr.exception.VZWSolrException;
import com.mt.is.solr.handlers.SolrRequestHandler;
import com.mt.is.solr.utils.SolrUtils;

public class SolrRequestProcessorImpl implements SolrRequestProcessor{
	
	private static SolrRequestProcessorImpl _instance;
	private Map<String, SolrRequestHandler> _handlers = new HashMap<String, SolrRequestHandler>();
	private SolrConfigLocator _locator = SolrConfigLocator.getInstance();
	
	private SolrRequestProcessorImpl(){
	}
	public static SolrRequestProcessorImpl getInstance(){
		if(_instance == null){
			_instance = new SolrRequestProcessorImpl();
		}
		return _instance;
	} 
	
	@Override
	public Object executeSolrReq(String action, SolrRequestParam param) throws VZWSolrException{
		
		SolrRequestConfig config = _locator.getConfig(action);
		if(_handlers.get(action) == null){
			String handlerName = config.getHandler();
			SolrRequestHandler handler = (SolrRequestHandler) SolrUtils.getClassInstance(handlerName);
			_handlers.put(action, handler);
		}
		
		SolrRequestHandler handler = _handlers.get(action);
		return handler.execute(config, param);
		
	}
	
	public Map<String, SolrRequestHandler> getHandlers() {
		return _handlers;
	}
	public void setHandlers(Map<String, SolrRequestHandler> _handlers) {
		this._handlers = _handlers;
	}
}
