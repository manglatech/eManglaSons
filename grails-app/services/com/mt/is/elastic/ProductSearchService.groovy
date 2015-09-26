package com.mt.is.elastic

import org.apache.lucene.queryparser.xml.FilterBuilder;
import org.codehaus.groovy.grails.commons.GrailsDomainClass;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import com.mt.is.domain.Product;
import com.mt.is.domain.search.ElasticSearchQuery;
import com.mt.is.search.base.BaseSearchService;

import grails.transaction.Transactional
import grails.util.GrailsNameUtils;


class ProductSearchService extends BaseSearchService{

   static transactional = false
   
   def searchProducts(def queryCode){
	   def queries = ElasticSearchQuery.findByCode(queryCode)
	   
	   if(queries){
		   def query = queries.first()
		   return search(query)
	   }
	   
	   return null
   }   
   
   def parseResult(def result){
	   println "Parse Result Called !!! "
	   populatedProducts(result)
   }
   
   private def populatedProducts(def res) {
	   
	   def products = []
	   res.searchResults.each {
		   
		   def product = new Product()
		   println "New Product ${product}"
		   product.name = it.name
		   product.id = it.id
		   product.description = it.description
		   product.price = it.price
		   product.brand = it.brand
		   product.featured = it.featured
		   product.inStock = it.inStock
		   
		   println "Product ${product} And Name ${it.name}"
		   products.add(product)
	   }
	   
	   return products
   }
   def productSearch(String searchTerm){
		def res = Product.search("${searchTerm}")
		println "ProductSearch Called !! Found ${res.total} result(s)"
		def products = populatedProducts(res)
	}
	def featuredProductSearch(){
		def res = Product.search("featured:true")
		println "FeaturedProductSearch Called !! Found ${res.total} result(s)"
		def products = populatedProducts(res)
	}
}
