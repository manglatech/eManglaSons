package com.mt.is.mail.body

class TemplateBodyProduer implements EmailBodyProducer{

	String view
	String plugin
	def model
	
	@Override
	public def getBodyContent() {
		
		println "Get Body Called on TemplateBodyProducer"
		
		//def bodyArgs
		
		def bodyArgs = [:]
		view && bodyArgs << [view:"${view}"]
		model && bodyArgs << [model:model]
		plugin && bodyArgs << [plugin:"${plugin}"]
		
		println "Generated Arguments ${bodyArgs}"
		
		bodyArgs
	}
}
