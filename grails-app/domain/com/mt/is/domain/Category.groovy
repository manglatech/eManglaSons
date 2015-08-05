package com.mt.is.domain

class Category {
	
	String name
	String displayName
	String description
	
	static hasMany  = [catalogs: Catalog, parentMapping : CategoryMapping, childMapping : CategoryMapping, products : Product]
	static mappedBy  = [catalogs: 'categories', parentMapping: 'child', childMapping: 'parent', products: 'pcategories']
	static mapping = { parentMapping cascade: 'all-delete-orphan'}
	
	static constraints = {
		name blank:false,unique:true
		displayName blank:false
		description nullable:true, maxSize:1000
	}
	
	String toString(){
		return displayName
	}
}
