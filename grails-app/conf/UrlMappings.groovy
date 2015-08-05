class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
		"/"(controller:"HomePage",action:"index")
		"/home"(controller:"HomePage",action:"home")
		"/products"(controller:"Shop",action:"productlist")
		"/productDetails"(controller:"Shop",action:"productdetails")
		"/contactus"(controller:"HomePage",action:"contactus")
		"/login"(controller:"Login",action:"auth")
        "500"(view:'/error')
		"/productImage"(view:"/productImage.gsp")
	}
}
