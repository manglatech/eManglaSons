package com.mt.is.service.mail

import com.mt.is.mail.BodyEmailInfo;
import com.mt.is.mail.EmailInfo;
import com.mt.is.mail.HTMLEmailInfo;
import com.sun.mail.imap.YoungerTerm;
import com.sun.mail.imap.protocol.BODY;

import grails.transaction.Transactional


class NotifierService {

	boolean transactional = false

	def sendEmailMessage(EmailInfo info) {
		
		sendMail {
			
			to info.to
			subject info.subject
			
			if(info.bcc)
				bcc info.bcc
			if(info.cc)
				cc info.cc
			if(info.from)
				from info.from
			if(info.class == BodyEmailInfo)	
				body info.bodyProducer.getBodyContent()
			if(info.class == HTMLEmailInfo)
				html info.htmlProducer.getHtmlContent()
			
		}
	}
}
