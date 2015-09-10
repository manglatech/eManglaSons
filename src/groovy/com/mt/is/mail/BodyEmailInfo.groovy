package com.mt.is.mail

import com.mt.is.mail.body.EmailBodyProducer

class BodyEmailInfo extends EmailInfo{
	
	EmailBodyProducer bodyProducer
	
	def getBody(){
		if(bodyProducer)
			return bodyProducer.getBodyContent()
	}
	
}
