package com.mt.is.service.menu

import com.mt.is.domain.Catalog;

import grails.transaction.Transactional

@Transactional
class NavigationMenuService {
	
	@Transactional(readOnly = true)
    def getNavigationMenu() {
		def catalog = Catalog.findByName("mscatalog")
		if(catalog)
			catalog.first()
	}	
}
