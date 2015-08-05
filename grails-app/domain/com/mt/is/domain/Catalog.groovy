package com.mt.is.domain

class Catalog {
	
	String name
	String description
		
	static constraints = {
		name blank:false, unique:true
		description nullable:true, maxSize:1000
    }
	
	static belongsTo = [Category]
	static hasMany = [categories: Category]
	static mappedBy = [categories:"catalogs"]
	
	String toString(){
		return name
	}
	
}
