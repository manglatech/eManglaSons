package com.mt.is.drools

import org.kie.api.runtime.KieSession
import org.kie.api.runtime.StatelessKieSession

import com.mt.is.domain.user.User

class UserRuleController {

	def droolsService
	StatelessKieSession defaultKieStatelessSession
	//KieSession ticketStatefulSession
	
    def index() {
	}
	
	def executeRule(){
		[model: model]
	}
	
	def getModel() {
		def model = [results:[:]]

		def nirali = new User("nirali", "nirali");
		Object[] facts1 = [nirali]
		droolsService.executeFromFile("rules/user.drl", [nirali])
		model.results["droolsService - my user name is $nirali.username (false)"] = nirali.username
		
		println "nirali Rule"
		
		def user = new User("dhaval", "dhaval");
		Object[] facts = [user]
		droolsService.executeFromFile("rules/user.drl", [user])
		model.results["droolsService - my user name is $user.username (true)"] = user.username
		
		 user = new User("dhaval", "dhaval");
		 facts = [user]
		 defaultKieStatelessSession.execute(Arrays.asList(facts))
		 model.results["defaultKieStatelessSession - my user name is $user.username (true)"] = user.username
		
		return model
	}
}
