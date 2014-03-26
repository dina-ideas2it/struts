<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags"  prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details Page</title>
</head>
<body>
Dvd Id: <s:property value="dvd.id" /><br>
Dvd Title: <s:property value="dvd.title" /><br>
Cost: <s:property value="dvd.cost" /><br>
Dvd Category: <s:property value="dvd.category" /><br>
Dvd Rating: <s:property value="dvd.rating" /><br>
<s:url id="editURL" action="edit">
<s:param name="dvd.id" value="%{dvd.id}"></s:param>
</s:url>
<s:a href="%{editURL}">Edit</s:a>
</body>
</html>
