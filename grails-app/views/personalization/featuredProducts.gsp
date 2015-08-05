					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">Features Items</h2>
						
						<g:each in="${featuredProducts}" var="product">
						
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
										<div class="productinfo text-center">
											<g:remoteLink controller="product" action="productdetails" params='[id:"${product.id}"]' update="mainContent">
												<bi:img size="small" bean="${product}" />
											</g:remoteLink>
											
											<h2>RS ${product?.price}</h2>
											<g:remoteLink action="productdetails" controller="product"  params='[id:"${product.id}"]' update="mainContent">
											<p>${product?.name}</p>
											</g:remoteLink>
											
											<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to Store Pickup</a>
										</div>
								</div>
								
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="#"><i class="fa fa-plus-square"></i>Add to Store Pickup</a></li>
										<li><a href="#"><i class="fa fa-plus-square"></i>View Details</a></li>
										
										<li>
										
										<g:form controller="product" action="productdetails">
            										<g:textField name="id" value="${product?.id}"/>
            										<g:actionSubmit value="details"/>
        								</g:form>
        								
        								</li>
									</ul>
								</div>
							</div>
						</div>
						
						</g:each>
						
						
					</div><!--features_items-->