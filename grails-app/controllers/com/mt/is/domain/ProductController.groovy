package com.mt.is.domain



import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ProductController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	def imageUploadService
	
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Product.list(params), model:[productInstanceCount: Product.count()]
    }
	def productlist() {
		params.max = 9
		println "CategoryId ${params?.id}"
		def cId = params?.id
		def products = Product.withCriteria {
			pcategories{
				eq ('id',cId as Long)
			}
			maxResults(9)
		}
		//println "Size ${products.size()}"
		[products: products]
	}
	
    def show(Product productInstance) {
        respond productInstance
    }
	def addImage(Product productInstance) {
		respond productInstance
	}
	
	@Transactional
	def saveImage(Product productInstance) {
		
		if (productInstance == null) {
            notFound()
            return
        }
		
		println "SAVE Image Now"
		productInstance.imageExtension = 'jpg'
		
		imageUploadService.save(productInstance,true)
		println "Saved CHANGED"
		
		redirect action:"index", method:"GET"
		
	}
    def create() {
        respond new Product(params)
    }

    @Transactional
    def save(Product productInstance) {
        if (productInstance == null) {
            notFound()
            return
        }

        if (productInstance.hasErrors()) {
            respond productInstance.errors, view:'create'
            return
        }

        productInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'product.label', default: 'Product'), productInstance.id])
                redirect productInstance
            }
            '*' { respond productInstance, [status: CREATED] }
        }
    }

    def edit(Product productInstance) {
        respond productInstance
    }

    @Transactional
    def update(Product productInstance) {
        if (productInstance == null) {
            notFound()
            return
        }

        if (productInstance.hasErrors()) {
            respond productInstance.errors, view:'edit'
            return
        }

        productInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Product.label', default: 'Product'), productInstance.id])
                redirect productInstance
            }
            '*'{ respond productInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Product productInstance) {

        if (productInstance == null) {
            notFound()
            return
        }

        productInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Product.label', default: 'Product'), productInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }
	
	
	
	def productdetails(){
		
		if (params?.id == null) {
			notFound()
			return
		}
		
		println "Product Details Page Called"
		def product = Product.get(params?.id)
		
		def uniqueAttributes = []
		
		product.sku.each{ sku ->
			uniqueAttributes << sku.attributes
		}
		println "Before ${uniqueAttributes}"
		uniqueAttributes.unique();
		println "Unique ${uniqueAttributes}"
		
		def dataMap = [:]
		
		def uniqueAttributesMap = uniqueAttributes.collectEntries { attr ->
			dataMap[attr.name] = attr.value
			[(attr.name): attr.value]
		}
		
		def uniqueAttributesMap1 = [:].withDefault {[]}
		
		uniqueAttributes.each{
			uniqueAttributesMap1[it.name].add(it.value)
			
			//uniqueAttributesMap1.getAt(it.name) ? uniqueAttributesMap1.getAt(it.name) << it.value : uniqueAttributesMap1.put(it.name,[it.value])
			 
			/*if(uniqueAttributesMap1[it.name]){
				uniqueAttributesMap1.getAt(it.name)?.add(it.value)
			}else{
				uniqueAttributesMap1.put(it.name,[it.value])
			}*/
		}
		
		println "MAP- ${uniqueAttributesMap}"
		println "MAP1- ${uniqueAttributesMap1}"
		println "dataMAP- ${dataMap}"
		
		
		/*
		Map uniqueAttributesMap1 = new HashMap<String,ArrayList<String>>();
		Map<String,ArrayList<String>> uniqueAttributesMap = uniqueAttributes.collectEntries {
			println  "${uniqueAttributesMap1}"
			println  "${it.name} - ${it.value}"
			if(uniqueAttributesMap1[it.name]){
				println "IF 12"
				uniqueAttributesMap1.getAt(it.name).add(it.value)
				[it.name,[it.value]]
			}else{
				println "ELSE 12"
				uniqueAttributesMap1.put(it.name,[it.value])
				[it.name,[it.value]]
			}
		}
		println "MAP ${uniqueAttributesMap}"
		println "MAP1 ${uniqueAttributesMap1}"
		*/
		
		
		
		
		println "found Proudct: ${product}"
		
		[msProduct:product, prodDiffTypes:uniqueAttributesMap]
		
	}

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'product.label', default: 'Product'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
	
}
