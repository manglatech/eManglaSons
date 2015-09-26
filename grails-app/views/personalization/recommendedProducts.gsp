<div class="recommended_items">
						<h2 class="title text-center">recommended items</h2>
						
						<div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
							<div class="carousel-inner">
								<div class="item active">
								
									<g:each in="${recommendedProducts}" var="product">
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<g:link controller="product" action="productdetails" params='[id:"${product.id}"]'>
														<bi:img size="small" bean="${product}" />
													</g:link>
														<h2>${product?.price}</h2>
													<g:link controller="product" action="productdetails" params='[id:"${product.id}"]'>
														<p>${product?.name}</p>
													</g:link>
											
											<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
												</div>												
											</div>
										</div>
									</div>
									</g:each>
									
								</div>
							</div>
							 <a class="left recommended-item-control" href="#recommended-item-carousel" data-slide="prev">
								<i class="fa fa-angle-left"></i>
							  </a>
							  <a class="right recommended-item-control" href="#recommended-item-carousel" data-slide="next">
								<i class="fa fa-angle-right"></i>
							  </a>			
						</div>
					</div>