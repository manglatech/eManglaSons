package com.mt.is.domain.users

class FeedBackController {

    def scaffold = FeedBack
	
	def saveFeedBack ={
		def feedBackInstance = new FeedBack(params)
		if(!feedBackInstance.hasErrors() && feedBackInstance.save(flush:true)) {
			[feedback:feedBackInstance]
		}else{
			respond feedBackInstance.errors, view:'/feedback/_feedBackForm'
		}
	}
	def createFeedBackForm = {
		respond new FeedBack(), view:'/feedback/_createFeedBack'
	}
}
