package com.mt.is.search.query

import com.mt.is.domain.search.ElasticSearchQuery;

class QueryLoader {

	ElasticSearchQuery fetchQuery(String queryCode){
		
		def query = ElasticSearchQuery.findByCode(queryCode)
		if(query)
			query.first()
	}
}
