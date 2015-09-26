package com.mt.is.controller.search

import org.codehaus.groovy.grails.commons.GrailsApplication;
import org.grails.plugins.elasticsearch.ElasticSearchAdminService;
import org.grails.plugins.elasticsearch.ElasticSearchHelper;

import com.mt.is.domain.Product;

import grails.test.spock.IntegrationSpec

class SearchControllerIntegrationSpec extends IntegrationSpec {
	
	def searchController
	ElasticSearchAdminService elasticSearchAdminService
	ElasticSearchHelper elasticSearchHelper
	GrailsApplication grailsApplication
	
    def setup() {
		def product01 = new Product(name: 'Royal', brand: 'apex', price: 3.95)
		product01.save(failOnError: true)

		def product02 = new Product(name: 'White', brand: 'apex', price: 5.99)
		product02.save(failOnError: true)

		def product03 = new Product(name: 'Black', brand: 'tractor', price: 10.99)
		product03.save(failOnError: true)

		def product04 = new Product(name: 'Green', brand: 'apex', price: 45.50)
		product04.save(failOnError: true)
    }

    def cleanup() {
    }

    void "test something"() {
    }
}
