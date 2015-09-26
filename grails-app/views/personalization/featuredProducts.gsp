					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">Features Items</h2>
						
						<g:each in="${featuredProducts}" var="product">
						
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
										<div class="productinfo text-center">
											<g:link controller="product" action="productdetails" params='[id:"${product.id}"]'>
												<r:img uri="${product.imageUrl}" />
											</g:link>
											
											<h2>RS ${product?.price}</h2>
											<g:link action="productdetails" controller="product"  params='[id:"${product.id}"]'>
											<p>${product?.name}</p>
											</g:link>
											
											<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to Store Pickup</a>
										</div>
								</div>
							</div>
						</div>
						
						</g:each>
						
						
					</div><!--features_items-->