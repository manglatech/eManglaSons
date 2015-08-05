package com.mt.is.solr.parsers;

import java.util.List;

import com.mt.is.solr.SolrRequestParam;
import com.mt.is.solr.config.SolrQueryConfig;
import com.mt.is.solr.exception.VZWSolrException;
import com.mt.is.solr.utils.SolrUtils;

public class ListQueryParser implements SolrQueryParser {

	@Override
	public String parseQuery(SolrQueryConfig sQuery, SolrRequestParam param) throws VZWSolrException {
		
		List<Object> objs = null;
		
		try {
			objs = (List<Object>) SolrUtils.getMethodParam(sQuery.getParamMethod(), param);
		} catch (Exception e) {
			throw new VZWSolrException("Could not get Request Params");
		}
		
		String qString = sQuery.getQueryString();
		String listArg = qString.substring(qString.indexOf("#") + 1, qString.length());
		
		StringBuffer buff = new StringBuffer();
		if(objs != null){
			int index = 0;
			for(Object o : objs){
				if(index > 0){
					buff.append(" " + sQuery.getAppendList() + " ");
				}else{
					index++;
				}
				buff.append(listArg+":"+o);
			}
		}
		return buff.toString();
	}
}
