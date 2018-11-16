<%@page import="aformela.shop.domain.Bird"%>
<%@page import="aformela.shop.domain.Survey"%>
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

<h2>Adding an survey</h2><br>
<form action='yourSurvey.jsp' method='GET'>
<input type="text" name="pocz" value="${survey.pocz}" />
<input type="text" name="pocz" value="${survey.kon}" /><br>
<input type="radio" name="czestotliwosc" value="${survey.czestotliwosc}"> Every day<br>
<input type="radio" name="czestotliwosc" value="${survey.czestotliwosc}"> Every week<br>
<input type="radio" name="czestotliwosc" value="${survey.czestotliwosc}"> Every month<br> 
<%
for (String o : storage.getAllOpinions()) {
	  	out.println("<input type='checkbox' name='opinion' value='" + 
		storage.getAllOpinions().indexOf(o)+"'>"+o+"<br>");
}
%>
			
	<input type='submit' value=' OK ' /></form>
	<br><a href='index.jsp'>back to menu</a>
	</body></html>
