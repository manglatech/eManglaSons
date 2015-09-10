package com.mt.is.domain

class Catalog {
	
	static searchable = {
		root false
		only = ['name','description']
	}
	
	String name
	String description
	SortedSet categories
		
	static constraints = {
		name blank:false, unique:true
		description nullable:true, maxSize:1000
    }
	static hasMany = [categories: Category]
	static belongsTo = [Category]
	
	String toString(){
		return name
	}
	
}
