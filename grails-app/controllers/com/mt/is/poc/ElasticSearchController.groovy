package com.mt.is.poc

import com.mt.is.domain.Product;

class ElasticSearchController {

    def index() {
		
		def res = Product.search("*transactions*")
		println "Found ${res.total} result(s)"
		res.searchResults.each {
			println it.name
		}
		render "Found ${res.total} result(s)"
	}
}
