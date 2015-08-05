
<%@ page import="com.mt.is.domain.SKU" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'sku.label', default: 'SKU')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-product" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-sku" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			
			<g:uploadForm url="[resource:SKUInstance, action:'saveImage']" method="POST" enctype="multipart/form-data">
				<ol class="property-list product">
				
					<g:if test="${SKUInstance?.name}">
					<li class="fieldcontain">
						<span id="name-label" class="property-label"><g:message code="sku.name.label" default="Name" /></span>
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${SKUInstance}" field="name"/></span>
					</li>
					</g:if>
					
					<li class="fieldcontain">
						<span id="name-label" class="property-label"><g:message code="sku.image.label" default="Image" /></span>
						<span class="property-value" aria-labelledby="name-label">
							<g:field name="skuImage" type="file" required=""/>
						</span>
					</li>
				</ol>
				<fieldset class="buttons">
					<g:actionSubmit class="delete"  value="${message(code: 'default.button.saveImage.label', default: 'Save Image')}" />
				</fieldset>
			</g:uploadForm>
			
		</div>
	</body>
</html>
