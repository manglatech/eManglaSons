package com.mt.is.domain

import pl.burningice.plugins.image.ast.FileImageContainer;

@FileImageContainer(field = 'skuImage')
class SKU {
	
	String code
	String name
	String displayName
	String description
	
	static belongsTo = [Product]
	
	static hasMany = [ attributes : Attribute ]
	//static mappedBy = [skuProduct : 'sku']
		
	static constraints = {
		code blank:false, unique:true
		name blank:false
		description nullable:true, maxSize:1000
	}
	
	String toString(){
		return name
	}
}
