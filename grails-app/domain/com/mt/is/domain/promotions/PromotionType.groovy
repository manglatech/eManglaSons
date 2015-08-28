package com.mt.is.domain.promotions

enum PromotionType {
	
	WEB('WEB','website promotions'),
	IN_STORE('MOB','Mobile Promo'),
	AD_FLYER('PAPER','Paper Ad Flyer')
	
	final String name
	final String id
	
	private PromotionType(String id, String name){
		this.id = id
		this.name = name
	}
	
    static constraints = {
    }
}
