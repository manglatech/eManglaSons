package com.mt.is.domain.search

class ElasticSearchQuery {

	String code
	String query
	String fieldName
	String page
	String noOfRecords
	
	static hasMany = [
		matchQueris: ElasticSearchMatchQueryOptions,
		arrregations: ElasticSearchAggregations, 
		sortOptions : ElasticSearchSortOptions, 
		filterOptions : ElasticSearchFilterOptions
		]	
	
    static constraints = {
    }
	
}
