package com.mt.is.domain

import com.mt.is.utils.AttributeType;

class Attribute {
	
	String name
	String value
	AttributeType type
	
	static belognsTo = [SKU, Product]
	
    static constraints = {
		name blank: false
		type blank: false
    }
	
	String toString(){
		def nameElements = [name, value]
		nameElements.join("-")
	}
}
