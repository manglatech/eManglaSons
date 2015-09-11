package com.mt.is.controller

import grails.converters.deep.JSON

import com.mt.is.domain.Catalog
import com.mt.is.service.menu.NavigationMenuService

class HomePageController {

	NavigationMenuService navigationMenuService 
	
    def index() {
		println "Default Page Called"
	}
	def home(){
		println "Landing Page Called"
				
		Catalog catalog = (Catalog) navigationMenuService.getNavigationMenu()
		
		withFormat {
			html { [msCatalog:catalog] }
			json { render catalog as JSON }
		}
	}
	def landingPage(){
		println "landingPage Called"
	}
	
	def contactus(){
		println "Contact Us Page Called"
	}
	
	def playGround(){
		println "Fetch Navigation"
		def catalog = Catalog.list()
		
		[topCategories:catalog]
		
	}
}
