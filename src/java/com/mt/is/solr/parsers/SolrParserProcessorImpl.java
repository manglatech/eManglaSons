package com.mt.is.solr.parsers;

import java.util.List;

import com.mt.is.solr.SolrRequestParam;
import com.mt.is.solr.config.SolrQueryConfig;
import com.mt.is.solr.exception.VZWSolrException;
import com.mt.is.solr.utils.SolrUtils;

public class SolrParserProcessorImpl implements SolrParserProcessor{
	
	private static SolrParserProcessorImpl _instance;
	private SolrParserProcessorImpl(){}
	
	
	public static SolrParserProcessorImpl getInstance(){
		if(_instance == null){
			_instance = new SolrParserProcessorImpl();
		}
		return _instance;
	}


	@Override
	public String processQuery(List<SolrQueryConfig> qList, SolrRequestParam param) throws VZWSolrException {
		StringBuffer buff = new StringBuffer();
		for(SolrQueryConfig q: qList){
			if(q.getQueryId() != null){
				if(param.getDisabledQueryIds().contains(q.getQueryId())){
					continue;
				}
			}
			buff.append(processQuery(q, param));
		}
		return buff.toString();
	}

	@Override
	public String processQuery(SolrQueryConfig q,SolrRequestParam param) throws VZWSolrException {
		StringBuffer buff = new StringBuffer();
		String parserStr = q.getParser();
		if(parserStr != null){
			SolrQueryParser parser = (SolrQueryParser) SolrUtils.getClassInstance(parserStr);
			String query = parser.parseQuery(q, param);
			if(query != null && !"".equalsIgnoreCase(query.trim())){
				if(q.getAppend() != null){
					buff.append(" "+q.getAppend()+" ");
				}
				buff.append("(");
				buff.append(query);
				buff.append(")");
			}
		}
		return buff.toString();
	}
}
