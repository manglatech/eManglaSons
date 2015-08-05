package com.mt.is.solr.parsers;

import java.util.Map;

import com.mt.is.solr.SolrRequestParam;
import com.mt.is.solr.config.SolrQueryConfig;
import com.mt.is.solr.exception.VZWSolrException;
import com.mt.is.solr.utils.SolrUtils;

public class ReplaceQueryParser implements SolrQueryParser {

	@Override
	public String parseQuery(SolrQueryConfig sQuery, SolrRequestParam param) throws VZWSolrException {
		
		String query = sQuery.getQueryString();
		Map<String, String> reqParams = null;
		if(sQuery.getParamMethod() != null){
			reqParams = (Map<String, String>) SolrUtils.getMethodParam(sQuery.getParamMethod(),param);
		}
		
		if(reqParams != null){
			for(String key : reqParams.keySet()){
				String value = reqParams.get(key);
				if(value != null){
					if(value.indexOf("(")>0){
						query = query.replaceAll("#"+key, "\""+value+"\"");
					}else{
						query = query.replaceAll("#"+key, value);
					}
				}
			}
		}
		return query;
	}
}
