<%@page import="aformela.shop.domain.Button"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Buttons</title>
</head>
<body>

<jsp:useBean id="appStorage" class="aformela.shop.service.StorageService" scope="application" />
<jsp:useBean id="sessStorage" class="aformela.shop.service.StorageService" scope="session" />

<h2>Shopping</h2><br>
<form action='buttonTrolley.jsp' method='GET'>
<%
if(appStorage.getButtons().isEmpty()){
	appStorage.addSomeButtons();
}

for (Button b : appStorage.getButtons()) {
	  	out.println("<input type='checkbox' name='button' value='" + 
		appStorage.getButtons().indexOf(b)+"'>"+b.toString()+"<br>");
}
%>
			
	<input type='submit' value=' OK ' /></form>
	<br><a href='index.jsp'>back to menu</a>
	</body></html>
