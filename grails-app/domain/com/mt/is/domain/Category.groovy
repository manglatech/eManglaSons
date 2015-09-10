package com.mt.is.domain

class Category implements Comparable{
	
	static searchable = {
		only = ['name','displayName','description','catalogs']
		catalogs component:true
	}
		
	String name
	String displayName
	String description
	
	static hasMany  = [catalogs: Catalog, parentMapping : CategoryMapping, childMapping : CategoryMapping, products : Product]
	static mappedBy  = [catalogs: 'categories', parentMapping: 'child', childMapping: 'parent', products: 'pcategories']
	static mapping = { 
		parentMapping cascade: 'all-delete-orphan'
	}
	
	static constraints = {
		name blank:false,unique:true
		displayName blank:false
		description nullable:true, maxSize:1000
		products cascade:'save , update'
	}
	
	String toString(){
		return displayName
	}
	int compareTo(obj) {
		name.compareTo(obj.name)
	}
}
