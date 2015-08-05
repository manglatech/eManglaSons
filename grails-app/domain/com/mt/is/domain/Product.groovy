package com.mt.is.domain

import pl.burningice.plugins.image.ast.FileImageContainer;

@FileImageContainer(field = 'productImage')
class Product {
	
	String code = "12345678"
	String name
	String description
	Long price = 0L
	String brand = "Apex"
	boolean inStock = true
	boolean featured = false
	
	static belongsTo = [Category]
	
	static hasMany = [pcategories : Category, sku : SKU, attributes : Attribute]	
	static mappedBy = [pcategories : 'products']
	
	static constraints = {
		name blank:false
		description nullable:true, maxSize:6000
    }
	
	String toString(){
		return name
	}
	
}
