package com.mt.is.controller.search

import org.apache.solr.common.SolrDocumentList

import com.mt.is.domain.Product
import com.mt.is.solr.SolrRequestParam
import com.mt.is.solr.processors.SolrRequestProcessorImpl

class SearchController {

	def myESearchService
	
	def index(){
		println "Search Form Called !! "
	}
	def globalSearch() {
		
		println "Search Called !!"
		def products = myESearchService.productSearch(params.searchTerm);
		println "Rending Search Result Page"
		//render(view: '/search/searchResult', model: [products:products])
		render(view: '/product/productlist', model: [products:products])
	}
	
	private void logException(final Exception exception) {
		log.error "Exception occurred. ${exception?.message}", exception
	}
}
