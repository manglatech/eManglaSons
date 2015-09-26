package com.mt.is.domain.search

class ElasticSearchMatchQueryOptions {

	String field
	String value
	
    static constraints = {
    }
	static belognsTo = [ElasticSearchQuery]
}
