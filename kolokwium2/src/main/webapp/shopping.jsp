<%@page import="aformela.shop.domain.Bird"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Birds</title>
</head>
<body>

<jsp:useBean id="storage" class="aformela.shop.service.StorageService" scope="application" />

<h2>Shopping</h2><br>
<form action='trolley.jsp' method='GET'>
<%
for (Bird bird : storage.getAllBirds()) {
	  	out.println("<input type='checkbox' name='bird' value='" + 
		storage.getAllBirds().indexOf(bird)+"'>"+bird.toString()+"<br>");
}
%>
			
	<input type='submit' value=' OK ' /></form>
	<br><a href='index.jsp'>back to menu</a>
	</body></html>
