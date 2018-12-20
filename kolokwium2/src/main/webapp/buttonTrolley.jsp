<%@page import="aformela.shop.domain.Button"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Birds</title>
</head>
<body>

<jsp:useBean id="appStorage" class="aformela.shop.service.StorageService" scope="application" />
<jsp:useBean id="sessStorage" class="aformela.shop.service.StorageService" scope="session" />

<%
	if(request.getParameterValues("button")!=null) {
		for (String nr : request.getParameterValues("button")) {
			Button newB = appStorage.getButtons().get(Integer.parseInt(nr));
			sessStorage.addButton(newB);
		}
	}
	
	if(sessStorage.getButtons()!=null) {
		out.println("<h2>YOUR BUTTONS:</h2>");
		for(Button b : sessStorage.getButtons()) {
			out.println(b+"</br>");
		}
	}

%>
			
	<br><a href='index.jsp'>back to menu</a>
	</body></html>
