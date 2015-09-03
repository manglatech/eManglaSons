package com.mt.is.domain.rules

class DroolsRule {

	String ruleText
	//String rule
	String description
	String packageName

	static mapping = {
		ruleText type: 'text'
		//rule type: 'text'
	}

	static constraints = {
		ruleText blank: false
		//rule blank: false
		packageName nullable: true, blank: true
		description blank: false
	}
}
