package com.mt.is.utils

import java.sql.Types;

import org.hibernate.dialect.MySQL5InnoDBDialect

class MyCustomMySQL5InnoDBDialect extends MySQL5InnoDBDialect {
	
	MyCustomMySQL5InnoDBDialect(){
		println "Custom DB Dialect Called"
		registerColumnType(Types.TINYINT, 'boolean')
	}
}
