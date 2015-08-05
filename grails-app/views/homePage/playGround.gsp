<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Persons</title>
	</head>
	<body>
        <g:each in="${topCategories}" var="topCategory">
            <h3>${topCategory.name}</h3>
            <g:each in="${topCategory.categories}" var="childCategory">
            	<h4>${childCategory.name}</h4>
            	<g:each in="${childCategory.childMapping}" var="child1Category">
            		<h4>${child1Category.child.name}</h4>
            	</g:each>
            </g:each>
            <br/>
        </g:each>
	</body>
</html>