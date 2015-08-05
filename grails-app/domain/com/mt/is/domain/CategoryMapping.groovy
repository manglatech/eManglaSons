package com.mt.is.domain

class CategoryMapping {
	
	Category parent
	Category child
	
	static belongsTo = [Category]
    
	static constraints = {
		child nullable:false
		parent nullable:false
	}
	
	String toString(){
		return parent.displayName + child.displayName
	}
}
