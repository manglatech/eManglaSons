package com.mt.is.domain

import pl.burningice.plugins.image.ast.FileImageContainer;

@FileImageContainer(field = 'productImage')
class ProductImage {
	
	String name
	
    static constraints = {
		name unique:true
    }
}
