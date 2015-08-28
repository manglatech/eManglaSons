package com.mt.is.domain

import com.mt.is.domain.promotions.Promotion;
import com.mt.is.domain.user.User

class OrderPickUp {

	String name
	Long totalOrderPrice = 0L
	Long totalDiscountedOrderPrice = 0L
	User user
	String orderStatus
	
    static constraints = {	
    }
	
	static hasMany = [products:Product, appliedPromotions:Promotion]
	
	String toString(){
		return name
	}
	
}
