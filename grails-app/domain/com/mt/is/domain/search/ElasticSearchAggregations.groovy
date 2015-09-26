package com.mt.is.domain.search

class ElasticSearchAggregations {
	
	String label
	String fieldName
	String type
	String valueTo
	String valueFrom
	
    static constraints = {
    }
	
	static belognsTo = [ElasticSearchQuery]
	
}
