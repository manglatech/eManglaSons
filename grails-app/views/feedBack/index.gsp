
<%@ page import="com.mt.is.domain.users.FeedBack" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'feedBack.label', default: 'FeedBack')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-feedBack" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-feedBack" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'feedBack.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="phone" title="${message(code: 'feedBack.phone.label', default: 'Phone')}" />
					
						<g:sortableColumn property="email" title="${message(code: 'feedBack.email.label', default: 'Email')}" />
					
						<g:sortableColumn property="subject" title="${message(code: 'feedBack.subject.label', default: 'Subject')}" />
					
						<g:sortableColumn property="message" title="${message(code: 'feedBack.message.label', default: 'Message')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${feedBackInstanceList}" status="i" var="feedBackInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${feedBackInstance.id}">${fieldValue(bean: feedBackInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: feedBackInstance, field: "phone")}</td>
					
						<td>${fieldValue(bean: feedBackInstance, field: "email")}</td>
					
						<td>${fieldValue(bean: feedBackInstance, field: "subject")}</td>
					
						<td>${fieldValue(bean: feedBackInstance, field: "message")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${feedBackInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
