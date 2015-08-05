package com.mt.is.domain.users

class FeedBack {

	String name
	String email
	String phone
	String subject
	String message
	
    static constraints = {
		
		name blank:false
		phone blank:false, maxSize:10
		email blank:false, email:true
		subject blank:false, maxSize:100
		message balnk:false, maxSize:1500
		
    }
}
