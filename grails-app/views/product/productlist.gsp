<!DOCTYPE html>
<html lang="en">
<g:render template="/common/head" />
<body>
<div id="productList">
	<section id="advertisement">
		<div class="container">
			<r:img uri="/images/shop/advertisement.jpg"/>
		</div>
	</section>
	
	<section>
		<div class="container">
			<div class="row">
				
				<g:render template="productFilters" />
				
				<div class="col-sm-9 padding-right">
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center"> Items </h2>
						
						<g:if test="${products?.size()}">
						<g:each in="${products}" var="product">
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<g:link controller="product" action="productdetails" params='[id:"${product.id}"]'>
											<bi:img bean="${product}" size="small" />
										</g:link>
										<h2>${product?.price}</h2>
										<g:link controller="product" action="productdetails" params='[id:"${product.id}"]'>
											<p>${product?.name}</p>
										</g:link>
										<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
									</div>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href=""><i class="fa fa-plus-square"></i>Add to wishlist</a></li>
										<li><a href=""><i class="fa fa-plus-square"></i>Add to compare</a></li>
									</ul>
								</div>
							</div>
						</div>
						</g:each>
						<div style="clear:both">
							<ul class="pagination">
								<li class="active"><a href="">1</a></li>
								<li><a href="">2</a></li>
								<li><a href="">3</a></li>
								<li><a href="">&raquo;</a></li>
							</ul>
						</div>
						</g:if>
						<g:else>
							<div class="col-sm-4">
								<div class="single-products">
									No Products Found !!
								</div>
							</div>
						</g:else>					
					</div><!--features_items-->
				</div>
			</div>
		</div>
	</section>
</div>
  
</body>
</html>