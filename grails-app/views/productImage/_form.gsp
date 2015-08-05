<%@ page import="com.mt.is.domain.ProductImage" %>



<div class="fieldcontain ${hasErrors(bean: productImageInstance, field: 'imageExtension', 'error')} ">
	<label for="imageExtension">
		<g:message code="productImage.imageExtension.label" default="Image Extension" />
		
	</label>
	<g:textField name="imageExtension" value="${productImageInstance?.imageExtension}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productImageInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="productImage.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${productImageInstance?.name}"/>

</div>

