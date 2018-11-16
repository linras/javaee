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
<jsp:useBean id="sessionStorage" class="aformela.shop.service.StorageService" scope="session" />
<jsp:setProperty name="survey" property="*" /> 

<jsp:getProperty name="survey" property="pocz"></jsp:getProperty>
<%
	/* if(request.getParameterValues("pocz")!=null) {
		for (String nr : request.getParameterValues("opinion")) {
			Survey newsurvey = storage.getAllSurveys().get(Integer.parseInt(nr));
			sessionStorage.addSurvey(newsurvey);
		} 
	}
	
	if(sessionStorage.getAllSurveys()!=null) {
		out.println("<h2>YOUR SURVEYS:</h2>");
		for(Survey s : sessionStorage.getAllSurveys()) {
			out.println(s+"</br>");
		}
	} */

%>
			
	<br><a href='index.jsp'>back to menu</a>
	</body></html>
