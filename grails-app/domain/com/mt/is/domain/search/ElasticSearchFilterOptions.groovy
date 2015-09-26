package com.mt.is.domain.search

class ElasticSearchFilterOptions {
	
	String fieldName
	String value
	boolean appendWildCard
	boolean prependWildCard
	
    static constraints = {
    }
	
	static belognsTo = [ElasticSearchQuery]
	
}
