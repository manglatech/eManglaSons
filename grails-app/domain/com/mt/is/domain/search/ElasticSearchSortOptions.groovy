package com.mt.is.domain.search

class ElasticSearchSortOptions {
	
	String fieldName
	String orderType
	
    static constraints = {
    }
	
	static belognsTo = [ElasticSearchQuery]
	
}
