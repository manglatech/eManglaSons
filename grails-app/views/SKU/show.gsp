
<%@ page import="com.mt.is.domain.SKU" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'SKU.label', default: 'SKU')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-SKU" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-SKU" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list SKU">
			
				<g:if test="${SKUInstance?.code}">
				<li class="fieldcontain">
					<span id="code-label" class="property-label"><g:message code="SKU.code.label" default="Code" /></span>
					
						<span class="property-value" aria-labelledby="code-label"><g:fieldValue bean="${SKUInstance}" field="code"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${SKUInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="SKU.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${SKUInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${SKUInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="SKU.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${SKUInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${SKUInstance?.attributes}">
				<li class="fieldcontain">
					<span id="attributes-label" class="property-label"><g:message code="SKU.attributes.label" default="Attributes" /></span>
					
						<g:each in="${SKUInstance.attributes}" var="a">
						<span class="property-value" aria-labelledby="attributes-label"><g:link controller="attribute" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${SKUInstance?.displayName}">
				<li class="fieldcontain">
					<span id="displayName-label" class="property-label"><g:message code="SKU.displayName.label" default="Display Name" /></span>
					
						<span class="property-value" aria-labelledby="displayName-label"><g:fieldValue bean="${SKUInstance}" field="displayName"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:SKUInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${SKUInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
