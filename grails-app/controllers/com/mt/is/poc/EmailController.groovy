package com.mt.is.poc

import com.mt.is.mail.BodyEmailInfo
import com.mt.is.mail.EmailInfo;
import com.mt.is.mail.HTMLEmailInfo;
import com.mt.is.mail.body.GenericBodyProducer
import com.mt.is.mail.body.TemplateBodyProduer

class EmailController {

	def notifierService 
	
	def index(){
		
	}
    def textEmail() { 
		
		def emailInfo = new BodyEmailInfo()
		
		emailInfo.with {
			to = ["patel.dhaval@yahoo.com","dhavaly2k@yahoo.com"]
			subject = "Sample Test Email !! "
			bodyProducer = new GenericBodyProducer(body:"Sample")
		}
		
		notifierService.sendEmailMessage(emailInfo)
		render " Email Sent !!"
		
	}
	def htmlEmail() {
		
		def emailInfo = new HTMLEmailInfo()
		
		emailInfo.with {
			to = "patel.dhaval@yahoo.com"
			subject = "Sample Test Email !! "
			htmlProducer = new GenericBodyProducer(html:"<h1> Sample <h1> ")
		}
		
		notifierService.sendEmailMessage(emailInfo)
		render "Email Sent !!"
		
	}
	def htmlTemplateEmail() {
		
		def emailInfo = new HTMLEmailInfo()
		
		emailInfo.with {
			to = "patel.dhaval@yahoo.com"
			subject = "Sample Test Email !! "
			htmlProducer = new GenericBodyProducer(
				html:g.render(template:"emailTemplate")
			)
		}
		notifierService.sendEmailMessage(emailInfo)
		render "Email Sent !!"
		
	}
	def bodyTemplateEmail() {
		
		def emailInfo = new BodyEmailInfo()
		emailInfo.with {
			to = ["patel.dhaval@yahoo.com","dhavaly2k@yahoo.com"]
			subject = "Sample Test Email !! "
			bodyProducer = new GenericBodyProducer()
			bodyProducer.with {
				body = g.render(template:"emailTemplate")
			}
		}
		
		notifierService.sendEmailMessage(emailInfo)
		render "Email Sent !!"
	}
	
	def bodyDynamicTemplateEmail() {
		
		def emailInfo = new BodyEmailInfo()
		
		emailInfo.with {
			to = ["patel.dhaval@yahoo.com"]
			subject = "Sample Test Email !! "
			bodyProducer = new TemplateBodyProduer()
			bodyProducer.with {
				view = "/email/template"
				model = [name:"Dhaval Patel"]
			}
		}
		
		notifierService.sendEmailMessage(emailInfo)
		render "Email Sent !!"
		
	}
	
}
