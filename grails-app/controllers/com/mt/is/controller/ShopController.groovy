package com.mt.is.controller

import com.mt.is.domain.Catalog;

class ShopController {

	def productService
	def navigationMenuService
	
    def index() { }
	
	def productlist(){
		println "Product List Page Called"
		Catalog catalog = Catalog.findByName("mscatalog").first()
		[msCatalog:catalog]
	}
	def productdetails(){
		
		println "Product Details Page Called"
		def product = productService.fetchProductDetails()
		
		def uniqueAttributes = []
		
		product.sku.each{ sku ->
			uniqueAttributes << sku.attributes
		}
		println "Before ${uniqueAttributes}"
		uniqueAttributes.unique();
		println "Unique ${uniqueAttributes}"
		
		def dataMap = [:]
		
		def uniqueAttributesMap = uniqueAttributes.collectEntries { attr ->
			dataMap[attr.name] = attr.value
			[(attr.name): attr.value]
		}
		
		def uniqueAttributesMap1 = [:].withDefault {[]}
		
		uniqueAttributes.each{
			uniqueAttributesMap1[it.name].add(it.value)
			
			//uniqueAttributesMap1.getAt(it.name) ? uniqueAttributesMap1.getAt(it.name) << it.value : uniqueAttributesMap1.put(it.name,[it.value])
			 
			/*if(uniqueAttributesMap1[it.name]){
				uniqueAttributesMap1.getAt(it.name)?.add(it.value)
			}else{
				uniqueAttributesMap1.put(it.name,[it.value])
			}*/
		}
		
		println "MAP- ${uniqueAttributesMap}"
		println "MAP1- ${uniqueAttributesMap1}"
		println "dataMAP- ${dataMap}"
		
		
		/*
		Map uniqueAttributesMap1 = new HashMap<String,ArrayList<String>>();
		Map<String,ArrayList<String>> uniqueAttributesMap = uniqueAttributes.collectEntries {
			println  "${uniqueAttributesMap1}"
			println  "${it.name} - ${it.value}"
			if(uniqueAttributesMap1[it.name]){
				println "IF 12"
				uniqueAttributesMap1.getAt(it.name).add(it.value)
				[it.name,[it.value]]
			}else{
				println "ELSE 12"
				uniqueAttributesMap1.put(it.name,[it.value])
				[it.name,[it.value]]
			}
		}
		println "MAP ${uniqueAttributesMap}"
		println "MAP1 ${uniqueAttributesMap1}"
		*/
		
		
		
		
		println "found Proudct: ${product}"
		
		def catalog = navigationMenuService.getNavigationMenu()
		println "found Catalog: ${catalog}"
		
		[msCatalog:catalog,msProduct:product, prodDiffTypes:uniqueAttributesMap]
		
	}
	
	def contactus(){
		println "Contact Us called on ShopController"
	}
}
