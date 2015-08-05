package com.mt.is.search

import java.util.Collection;

import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import com.mt.is.domain.Product;
import com.mt.is.solr.SolrRequestParam;
import com.mt.is.solr.processors.SolrRequestProcessorImpl;

class SearchController {

	
	def index(){
		println "Search Form Called !! "
	}
	
    def search() { 
		
		println "Search Called !!"
		SolrRequestParam param = new SolrRequestParam();
		param.reqParams.put("searchTerm", params.searchTerm)
		
		SolrDocumentList list = (SolrDocumentList) SolrRequestProcessorImpl.getInstance().executeSolrReq("sampleSearch", param);
		
		println("SIZE ${list.size()} ");
		
		def products = []
		
		list.each{ 
			
			def product = new Product()
			
			product.name = (String) it.getFieldValue("name")
			product.id = (Long) it.getFieldValue("id")
			product.description = (String) it.getFieldValue("description")
			product.price = (Long) it.getFieldValue("price")
			product.brand = (String) it.getFieldValue("brand")
			product.featured = new Boolean(it.getFieldValue("isFeatured"))
			product.inStock = new Boolean(it.getFieldValue("inStock"))
			
			products.add(product)
		}
		
		println "Rending Search Result Page"
		render(view: '/search/searchResult', model: [products:products])
		
	}
	private void logException(final Exception exception) {
		log.error "Exception occurred. ${exception?.message}", exception
	}
}
