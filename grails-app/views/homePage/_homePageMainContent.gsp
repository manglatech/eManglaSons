	
	<g:render template="/homePage/homePageBanners"/>
	
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-12">

				<!--  Featured products 	 -->
				<g:render template="/personalization/fProductsAjax" model="[location:'homepage']"/>
				<!--  Featured products  End -->
				<!--recommended_items-->
				<g:render template="/personalization/rProductsAjax" model="[location:'homepage']"/>
				<!--recommended_items End-->
				</div>
			</div>
		</div>
	</section>