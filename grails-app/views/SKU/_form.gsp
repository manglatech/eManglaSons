<%@ page import="com.mt.is.domain.SKU" %>
<%@ page import="com.mt.is.utils.AttributeType" %>



<div class="fieldcontain ${hasErrors(bean: SKUInstance, field: 'code', 'error')} required">
	<label for="code">
		<g:message code="SKU.code.label" default="Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="code" required="" value="${SKUInstance?.code}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: SKUInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="SKU.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${SKUInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: SKUInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="SKU.description.label" default="Description" />
		
	</label>
	<g:textArea name="description" cols="40" rows="5" maxlength="1000" value="${SKUInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: SKUInstance, field: 'attributes', 'error')} ">
	<label for="attributes">
		<g:message code="SKU.attributes.label" default="Attributes" />
		
	</label>
	<g:select name="attributes" from="${com.mt.is.domain.Attribute.findAllWhere(type:AttributeType.SKU)}" multiple="multiple" optionKey="id" size="5" value="${SKUInstance?.attributes*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: SKUInstance, field: 'displayName', 'error')} required">
	<label for="displayName">
		<g:message code="SKU.displayName.label" default="Display Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="displayName" required="" value="${SKUInstance?.displayName}"/>

</div>

