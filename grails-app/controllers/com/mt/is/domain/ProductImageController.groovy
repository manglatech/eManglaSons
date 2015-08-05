package com.mt.is.domain



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ProductImageController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ProductImage.list(params), model:[productImageInstanceCount: ProductImage.count()]
    }

    def show(ProductImage productImageInstance) {
        respond productImageInstance
    }

    def create() {
        respond new ProductImage(params)
    }

    @Transactional
    def save(ProductImage productImageInstance) {
        if (productImageInstance == null) {
            notFound()
            return
        }

        if (productImageInstance.hasErrors()) {
            respond productImageInstance.errors, view:'create'
            return
        }

        productImageInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'productImage.label', default: 'ProductImage'), productImageInstance.id])
                redirect productImageInstance
            }
            '*' { respond productImageInstance, [status: CREATED] }
        }
    }

    def edit(ProductImage productImageInstance) {
        respond productImageInstance
    }

    @Transactional
    def update(ProductImage productImageInstance) {
        if (productImageInstance == null) {
            notFound()
            return
        }

        if (productImageInstance.hasErrors()) {
            respond productImageInstance.errors, view:'edit'
            return
        }

        productImageInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ProductImage.label', default: 'ProductImage'), productImageInstance.id])
                redirect productImageInstance
            }
            '*'{ respond productImageInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ProductImage productImageInstance) {

        if (productImageInstance == null) {
            notFound()
            return
        }

        productImageInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ProductImage.label', default: 'ProductImage'), productImageInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'productImage.label', default: 'ProductImage'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
