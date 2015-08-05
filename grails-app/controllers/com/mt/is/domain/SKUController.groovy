package com.mt.is.domain



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SKUController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	def imageUploadService
	
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond SKU.list(params), model:[SKUInstanceCount: SKU.count()]
    }

    def show(SKU SKUInstance) {
		println "SHOW ${SKUInstance.imageExtension}"
        respond SKUInstance
    }

    def create() {
        respond new SKU(params)
    }
	
	def addImage(SKU SKUInstance) {
		respond SKUInstance
	}
	
	@Transactional
	def saveImage(SKU SKUInstance) {
		
		if (SKUInstance == null) {
			notFound()
			return
		}
		
		println " CHANGED !! "
		imageUploadService.save(SKUInstance,true)
		println "SAVEd ${SKUInstance.imageExtension}"
		
		if (SKUInstance.hasErrors()) {
			println "ERRORS ${SKUInstance.errors}"
			respond SKUInstance.errors, view:'addImage'
			return
		}
		
		redirect action:"index", method:"GET"
		
	}
	
    @Transactional
    def save(SKU SKUInstance) {
        if (SKUInstance == null) {
            notFound()
            return
        }

        if (SKUInstance.hasErrors()) {
            respond SKUInstance.errors, view:'create'
            return
        }

        SKUInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'SKU.label', default: 'SKU'), SKUInstance.id])
                redirect SKUInstance
            }
            '*' { respond SKUInstance, [status: CREATED] }
        }
    }

    def edit(SKU SKUInstance) {
        respond SKUInstance
    }

    @Transactional
    def update(SKU SKUInstance) {
        if (SKUInstance == null) {
            notFound()
            return
        }

        if (SKUInstance.hasErrors()) {
            respond SKUInstance.errors, view:'edit'
            return
        }

        SKUInstance.save flush:true
		println "Saved Now !! "
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'SKU.label', default: 'SKU'), SKUInstance.id])
                redirect SKUInstance
            }
            //'*'{ respond SKUInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(SKU SKUInstance) {

        if (SKUInstance == null) {
            notFound()
            return
        }

        SKUInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'SKU.label', default: 'SKU'), SKUInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'SKU.label', default: 'SKU'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
