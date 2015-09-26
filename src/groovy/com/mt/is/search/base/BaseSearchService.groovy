package com.mt.is.search.base

import grails.util.GrailsNameUtils

import org.codehaus.groovy.grails.commons.GrailsDomainClass
import org.elasticsearch.action.search.SearchRequest
import org.elasticsearch.action.search.SearchType
import org.elasticsearch.index.query.FilterBuilders
import org.elasticsearch.index.query.QueryBuilders
import org.elasticsearch.search.aggregations.AggregationBuilders
import org.elasticsearch.search.builder.SearchSourceBuilder

import com.mt.is.domain.Product
import com.mt.is.domain.search.ElasticSearchQuery

abstract class BaseSearchService {

	def elasticSearchService
	
	def search(ElasticSearchQuery elasticQuery){
		
		//def query = QueryBuilders.matchQuery(elasticQuery.fieldName, elasticQuery.query).
		
		SearchRequest request = new SearchRequest()
		request.searchType SearchType.DFS_QUERY_THEN_FETCH
		
		SearchSourceBuilder source = new SearchSourceBuilder()
		
		elasticQuery.filterOptions.each{
			source.postFilter(FilterBuilders.termFilter(it.fieldName, it.value))
		}
		elasticQuery.arrregations.each {
			source.aggregation(AggregationBuilders.terms(it.label).field(it.fieldName))
		}
		
		def params = [indices:Product, types:Product]
		
		println "Query ${request.source(source)}"
		
		def result = elasticSearchService.search(request.source(source),params)
		
		result.aggregations.each {
			println "key : ${it.key}"
			it.value.buckets.each{ count->
				println "key : ${count.key}"
				println "count: ${count.docCount}"
			}
		}
		
		println "Found ${result.total} result(s)"
		def parsedResult = parseResult(result)
	}
	
	abstract def parseResult(def result)
	
	private String getIndexName(GrailsDomainClass domainClass) {
		String name = grailsApplication.config.elasticSearch.index.name ?: domainClass.packageName
		if (name == null || name.length() == 0) {
			name = domainClass.getPropertyName()
		}
		return name.toLowerCase()
	}

	private String getTypeName(GrailsDomainClass domainClass) {
		GrailsNameUtils.getPropertyName(domainClass.clazz)
	}
}
