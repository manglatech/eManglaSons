package com.mt.is.domain.promotions

import org.codehaus.groovy.grails.orm.hibernate.cfg.IdentityEnumType;

class Promotion {
	
	String name
	String code
	String promoUrl
	String description
	PromotionRule promoRule
	PromotionType promoType
	
	static mapping = {
		promoType(enumType:"string")
	}
	
    static constraints = {
		name blank:false, nullable:false
		code blank:false, nullable:false
		promoUrl blank:false, nullable:false
    }
	
}
