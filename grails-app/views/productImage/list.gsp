<g:each in="${productInstanceList}" status="i" var="productInstance">
	<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
	<td>${fieldValue(bean: productInstance, field: "name")}</td>
</g:each>