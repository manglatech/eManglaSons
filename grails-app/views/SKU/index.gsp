
<%@ page import="com.mt.is.domain.SKU" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'SKU.label', default: 'SKU')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-SKU" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-SKU" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="code" title="${message(code: 'SKU.code.label', default: 'Code')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'SKU.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'SKU.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="displayName" title="${message(code: 'SKU.displayName.label', default: 'Display Name')}" />
						
						<g:sortableColumn property="image" title="${message(code: 'SKU.inStock.label', default: 'Image')}" />
						
						<g:sortableColumn property="storedImage" title="${message(code: 'SKU.inStock.label', default: 'Image')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${SKUInstanceList}" status="i" var="SKUInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${SKUInstance.id}">${fieldValue(bean: SKUInstance, field: "code")}</g:link></td>
					
						<td>${fieldValue(bean: SKUInstance, field: "name")}</td>
					
						<td>${fieldValue(bean: SKUInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: SKUInstance, field: "displayName")}</td>
						
						<td><g:link action="addImage" id="${SKUInstance.id}">Add Image</g:link></td>
						
						<td>
						<bi:hasImage bean="${SKUInstance}">
    						<bi:img size="small" bean="${SKUInstance}" />
						</bi:hasImage>
						</td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${SKUInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
