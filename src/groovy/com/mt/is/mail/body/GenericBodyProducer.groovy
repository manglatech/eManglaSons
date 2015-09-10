package com.mt.is.mail.body

class GenericBodyProducer implements EmailBodyProducer,EmailHtmlProducer {

	def body
	def html
		
	@Override
	public def getBodyContent() {
		return body;
	}

	@Override
	public def getHtmlContent() {
		return html;
	}
}
