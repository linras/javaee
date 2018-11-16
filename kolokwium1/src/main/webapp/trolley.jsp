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
<jsp:useBean id="sessionStorage" class="aformela.shop.service.StorageService" scope="session" />

<%
	if(request.getParameterValues("bird")!=null) {
		for (String nr : request.getParameterValues("bird")) {
			Bird newBird = storage.getAllBirds().get(Integer.parseInt(nr));
			sessionStorage.add(newBird);
		}
	}
	
	if(sessionStorage.getAllBirds()!=null) {
		out.println("<h2>YOUR BIRDS:</h2>");
		for(Bird bird : sessionStorage.getAllBirds()) {
			out.println(bird+"</br>");
		}
	}

%>
			
	<br><a href='index.jsp'>back to menu</a>
	</body></html>
