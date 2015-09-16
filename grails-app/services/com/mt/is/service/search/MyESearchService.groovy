package com.mt.is.service.search

import com.mt.is.domain.Product;

class MyESearchService {
	
	static transactional = false
	
	def productSearch(String searchTerm){
		def res = Product.search("${searchTerm}")
		println "Found ${res.total} result(s)"
		def products = populatedProducts(res)
	}
	def featuredProductSearch(){
		println "ESearchService : FeaturedProductSearch Called !! "
		def res = Product.search("featured:true")
		println "Found ${res.total} result(s)"
		def products = populatedProducts(res)
	}
	
	private def populatedProducts(def res) {
		
		def products = []
		res.searchResults.each {
			def product = new Product()

			product.name = it.name
			product.id = it.id
			product.description = it.description
			product.price = it.price
			product.brand = it.brand
			product.featured = it.featured
			product.inStock = it.inStock

			products.add(product)
		}
		
		return products
	}
	
}
