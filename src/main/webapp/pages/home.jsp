<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>
			DVD RENTAL STORE
		</title>
	</head>
	<body>

		<s:form action="MyOwnAction">
		<s:textfield name="dvd.id"></s:textfield>
		<s:textfield name="dvd.title"></s:textfield>
		<s:textfield name="dvd.cost"></s:textfield>
		<s:textfield name="dvd.category"></s:textfield>
		<s:textfield name="dvd.rating"></s:textfield>
		<s:submit value="Test"></s:submit>
		</s:form>
	</body>
</html>
