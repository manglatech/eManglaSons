package com.mt.is.domain.promotions

import com.mt.is.domain.user.User;

class UserPromotions {
	
	String name
	String publishingChannel
	String status
	
	
    static constraints = {
    }
	static belongsTo = [users:User, promotions:Promotion]
	static hasMany = [users:User, promotions: Promotion]
	
}
