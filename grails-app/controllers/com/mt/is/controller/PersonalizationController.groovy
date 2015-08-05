package com.mt.is.controller

import com.mt.is.domain.Product;

import grails.converters.JSON

class PersonalizationController {
	
	def springSecurityService
		   
    def index() { }
	def featuredProducts(){
		
		def user = springSecurityService.isLoggedIn() ? springSecurityService.loadCurrentUser() : null
		if (user) {
			println "Finding Featured Products for User: ${user.id}"
		}
			
		println "Location of Featured Products is ${params?.location}"
		println "FeaturedProducts for Product ${params?.productId}"
		
		def products = Product.where {
							featured  == true
						}.list(max: 3)
		
		withFormat {
			html { [featuredProducts:products] }
			json { render featuredProducts as JSON }
		}
	}
	
	def recommendedProducts(){
		
		def user = springSecurityService.isLoggedIn() ? springSecurityService.loadCurrentUser() : null
		if (user) {
			println "Finding Recommended Products for User: ${user.id}"
		}
		
		println "Location of Recommendation is ${params?.location}"
		println "Recommendation Products for Product ${params?.productId}"
		
		def products = Product.where {
							featured  == true
						}.list(max: 3)
		
		println "Total Recommended Products found : ${products?.size()}"
		
		withFormat {
			html { [recommendedProducts:products] }
			json { render recommendedProducts as JSON }
		}
	}
	
}
