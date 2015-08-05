<%@ page import="com.mt.is.domain.Product" %>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="product.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${productInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="product.description.label" default="Description" />
		
	</label>
	<g:textArea name="description" cols="40" rows="5" maxlength="6000" value="${productInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'imageExtension', 'error')} ">
	<label for="imageExtension">
		<g:message code="product.imageExtension.label" default="Image Extension" />
		
	</label>
	<g:textField name="imageExtension" value="${productInstance?.imageExtension}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'brand', 'error')} required">
	<label for="brand">
		<g:message code="product.brand.label" default="Brand" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="brand" required="" value="${productInstance?.brand}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'code', 'error')} required">
	<label for="code">
		<g:message code="product.code.label" default="Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="code" required="" value="${productInstance?.code}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'inStock', 'error')} ">
	<label for="inStock">
		<g:message code="product.inStock.label" default="In Stock" />
		
	</label>
	<g:checkBox name="inStock" value="${productInstance?.inStock}" />

</div>
<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'featured', 'error')} ">
	<label for="inStock">
		<g:message code="product.featured.label" default="Featured" />
		
	</label>
	<g:checkBox name="featured" value="${productInstance?.featured}" />

</div>
<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'pcategories', 'error')} ">
	<label for="pcategories">
		<g:message code="product.pcategories.label" default="Pcategories" />
		
	</label>
</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'price', 'error')} required">
	<label for="price">
		<g:message code="product.price.label" default="Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="price" type="number" value="${productInstance.price}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'sku', 'error')} ">
	<label for="sku">
		<g:message code="product.sku.label" default="Sku" />
		
	</label>
	<g:select name="sku" from="${com.mt.is.domain.SKU.list()}" multiple="multiple" optionKey="id" size="5" value="${productInstance?.sku*.id}" class="many-to-many"/>

</div>
