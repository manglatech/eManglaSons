package com.mt.is.controller.search

import org.apache.solr.common.SolrDocumentList

import com.mt.is.domain.Product
import com.mt.is.domain.search.ElasticSearchQuery;
import com.mt.is.solr.SolrRequestParam
import com.mt.is.solr.processors.SolrRequestProcessorImpl

class SearchController {

	def productSearchService
	
	def index(){
		println "Search Form Called !! "
	}
	def globalSearch() {
		
		println "Search Called !!"
		def products = productSearchService.productSearch(params.searchTerm);
		render(view: '/product/productlist', model: [products:products])
	}
	
	def productSearch() {
		
		def queryCode = params.get('queryCode')
		def products = productSearchService.searchProducts(queryCode);
		render(view: '/product/productlist', model: [products:products])
		
	}
	
	
	private void logException(final Exception exception) {
		log.error "Exception occurred. ${exception?.message}", exception
	}
}
