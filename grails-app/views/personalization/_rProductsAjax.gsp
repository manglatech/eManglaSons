<div id="recommendedProductsResult">
	<g:formRemote name="recommendedProductsForm" url="[controller:'personalization', action:'recommendedProducts']" update="recommendedProductsResult">
	    <div class="form-group col-md-12">
	    	<g:hiddenField name="location" value="${location}"/>
	    	<g:hiddenField name="productId" value="${productId}"/>
			<g:actionSubmit class="btn btn-primary pull-right" value="${message(code: 'feedback.button.submit.label', default: 'Submit')}" />
		</div>
	</g:formRemote>
</div>
<script>
	$(document).ready(function() {
    	$('#recommendedProductsForm').submit();
	});
</script>