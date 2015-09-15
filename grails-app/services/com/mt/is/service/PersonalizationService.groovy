package com.mt.is.service

import com.mt.is.domain.Product;

import grails.transaction.Transactional

class PersonalizationService {
	
	boolean transactional = false
	
	def springSecurityService
	
    def retriveFeaturedProducts(def location, def productId) {
		
		def user = springSecurityService.isLoggedIn() ? springSecurityService.loadCurrentUser() : null
		
		println "Finding Featured Products for User: ${user?.id}"
		println "Location of Featured Products is ${location}"
		println "FeaturedProducts for Product ${productId}"
		
		if (user) {
			println "Finding Featured Products for User: ${user.id}"
			
		}else{
			// return TOP 3 Items Sold or View by Users.
			def products = Product.where {
				featured  == true
			}.list(max: 3)
		}
			
		
						
    }
	
	def retriveRecommentedProducts(def location, def productId){
		
		def user = springSecurityService.isLoggedIn() ? springSecurityService.loadCurrentUser() : null
		if (user) {
			println "Finding Recommended Products for User: ${user.id}"
		}
		
		println "Location of Recommendation is ${location}"
		println "Recommendation Products for Product ${productId}"
		
		def products = Product.where {
							featured  == true
						}.list(max: 3)
		
		println "Total Recommended Products found : ${products?.size()}"
		
	}
}
