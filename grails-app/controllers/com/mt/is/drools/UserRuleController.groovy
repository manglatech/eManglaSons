package com.mt.is.drools

import org.kie.api.runtime.KieSession
import org.kie.api.runtime.StatelessKieSession

import com.mt.is.domain.user.User

class UserRuleController {

	def droolsService
	//StatelessKieSession applicationStatelessSession
	//KieSession ticketStatefulSession
	
    def index() {
	}
	
	def executeRule(){
		[model: model]
	}
	
	def getModel() {
		def model = [results:[:]]

		/*def user = new User("dhaval", "dhaval");
		Object[] facts = [user]
		applicationStatelessSession.execute(Arrays.asList(facts))
		model.results["applicationStatelessSession - my user name is $user.username (true)"] = user.valid
		*/
		
		def nirali = new User("nirali", "nirali");
		Object[] facts1 = [nirali]
		droolsService.executeFromFile("rules/user.drl", [nirali])
		model.results["applicationStatelessSession - my user name is $nirali.username (false)"] = nirali.username
		
		println "nirali Rule"
		
		def user = new User("dhaval", "dhaval");
		Object[] facts = [user]
		droolsService.executeFromFile("rules/user.drl", [user])
		model.results["applicationStatelessSession - my user name is $user.username (true)"] = user.username
		
		}
}
