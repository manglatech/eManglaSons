package com.mt.is.poc

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ElasticSearchController)
class ElasticSearchControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Search All Records"() {
		when:"The index action is executed"
		controller.index()

	then:"The response is correct"
		response.status == OK.value
    }
}
