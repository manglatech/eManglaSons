package com.mt.is.mail

import com.mt.is.mail.body.EmailHtmlProducer

class HTMLEmailInfo extends EmailInfo {
	
	EmailHtmlProducer htmlProducer
		
	def getHtml(){
		if(htmlProducer)
			return htmlProducer.getHtmlContent()
	}
}
