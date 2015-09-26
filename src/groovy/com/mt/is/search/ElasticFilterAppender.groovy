package com.mt.is.search

import org.elasticsearch.index.query.FilterBuilder
import org.elasticsearch.index.query.FilterBuilders

import com.mt.is.domain.search.ElasticSearchFilterOptions

class ElasticFilterAppender {
	
	void appendFilters(List<ElasticSearchFilterOptions> options){
		if(options){
			
			options.each { option->
				FilterBuilder filter = FilterBuilders.termFilter(option.fieldName, option.value)
			}
			
		}
	}
}
