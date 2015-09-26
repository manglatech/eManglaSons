package com.mt.is.poc

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.FilterBuilder;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import com.mt.is.domain.Product;
import com.mt.is.search.ElasticFilterAppender;

class ElasticSearchController {

	def elasticSearchService
	
    def index() {
		
		def res = Product.search("*transactions*")
		println "Found ${res.total} result(s)"
		res.searchResults.each {
			println it.name
		}
		render "Found ${res.total} result(s)"
	}
	
	def all() {
		
		def query = QueryBuilders.matchQuery('name', 'Royal')
		SearchRequest request = new SearchRequest()
		request.searchType SearchType.DFS_QUERY_THEN_FETCH
		
		SearchSourceBuilder source = new SearchSourceBuilder()
		source.aggregation(AggregationBuilders.terms("brand").field("brand"))
		source.aggregation(AggregationBuilders.terms("price").field("price"))
		source.postFilter(FilterBuilders.termFilter("brand", "apex"))
		source.postFilter(FilterBuilders.termFilter("code", "12345678"))
		
		def result = elasticSearchService.search(request.source(source.query(query)),[indices:Product, types:Product])
		
		result.aggregations?.'brand'.buckets.each{
			println it.key
			println it.docCount
		}
		
		result.aggregations.each {
			println "key : ${it.key}"
			it.value.buckets.each{ count->
				println "key : ${count.key}"
				println "count: ${count.docCount}"
			}
		}
		
		
		render "Found ${result.total} result(s) AND Aggr : ${result.aggregations?.'brand'.buckets}"
	}
	
	def rangeAggr() {
		
		def query = QueryBuilders.matchQuery('name', 'Royal')
		SearchRequest request = new SearchRequest()
		request.searchType SearchType.DFS_QUERY_THEN_FETCH
		
		SearchSourceBuilder source = new SearchSourceBuilder()
		source.aggregation(
			AggregationBuilders.range("price").field("price")
			.addUnboundedTo(5)
			.addRange(6, 10)
			.addUnboundedFrom(10)
			)
		
		def result = elasticSearchService.search(request.source(source.query(query)),[indices:Product, types:Product])
		
		result.aggregations?.'price'.buckets.each{
			println "to ${it.to}"
			println "from ${it.from}"
			println "count ${it.docCount}"
		}
		render "Found ${result.total} result(s)"
	}
	
	def aggr() {
		
		def query = QueryBuilders.matchQuery('name', 'Royal')
		SearchRequest request = new SearchRequest()
		request.searchType SearchType.DFS_QUERY_THEN_FETCH
		
		SearchSourceBuilder source = new SearchSourceBuilder()
		source.aggregation(AggregationBuilders.terms("brand").field("brand"))
		source.aggregation(AggregationBuilders.terms("price").field("price"))
		
		def result = elasticSearchService.search(request.source(source.query(query)),[indices:Product, types:Product])
		
		result.aggregations?.'brand'.buckets.each{
			println it.key
			println it.docCount
		}
		
		result.aggregations.each {
			println "key : ${it.key}"
			it.value.buckets.each{ count->
				println "key : ${count.key}"
				println "count: ${count.docCount}"
			}
		}
		
		
		render "Found ${result.total} result(s) AND Aggr : ${result.aggregations?.'brand'.buckets}"
	}
	def filterQuery(){
		
		def query = QueryBuilders.matchQuery('name', 'Royal')
		
		SearchRequest request = new SearchRequest()
		request.searchType SearchType.DFS_QUERY_THEN_FETCH
		
		SearchSourceBuilder source = new SearchSourceBuilder()
		source.postFilter(FilterBuilders.termFilter("brand", "apex"))
		source.postFilter(FilterBuilders.termFilter("code", "12345678"))
		
		//FilterBuilder filter = FilterBuilders.termFilter("brand", "apex")
		def result = elasticSearchService.search(request.source(source.query(query)), [indices:Product, types:Product])
		
		render "Found ${result.total} result(s)"
		
	}
	def simpleQuery(){
		
		//def query = QueryBuilders.matchQuery('name', 'Royal')
		
		SearchRequest request = new SearchRequest()
		request.searchType SearchType.DFS_QUERY_THEN_FETCH
		
		SearchSourceBuilder source = new SearchSourceBuilder()
		//source.query("Royal")
		source.postFilter(FilterBuilders.termFilter("brand", "apex"))
		source.postFilter(FilterBuilders.termFilter("code", "12345678"))
		
		//FilterBuilder filter = FilterBuilders.termFilter("brand", "apex")
		def result = elasticSearchService.search(request.source(source), [indices:Product, types:Product])
		
		render "Found ${result.total} result(s)"
		
	}
}
