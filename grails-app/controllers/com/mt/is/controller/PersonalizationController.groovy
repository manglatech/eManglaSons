package com.mt.is.controller

import com.mt.is.domain.Product;

import grails.converters.JSON

class PersonalizationController {
	
	def personalizationService
		   
    def index() { }
	
	def featuredProducts(){
		
		def products = personalizationService.retriveFeaturedProducts(params?.location, params?.productId);
		withFormat {
			html { [featuredProducts:products] }
			json { render products as JSON }
		}
	}
	
	def recommendedProducts(){
		
		def products = personalizationService.retriveRecommentedProducts(params?.location, params?.productId)
	
		withFormat {
			html { [recommendedProducts:products] }
			json { render products as JSON }
		}
	}
	
}
