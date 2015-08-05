package com.mt.is.service.shop

import com.mt.is.domain.Product;

import grails.transaction.Transactional

@Transactional
class ProductService {

	@Transactional(readOnly = true)
    def fetchProductDetails() {
		def product = Product.findByName("Royal Paints")
		if(product)
			product.first()
    }
}
