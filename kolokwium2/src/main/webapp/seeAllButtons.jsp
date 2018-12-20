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


<%	//storage.addSomeSurveys();
	if(appStorage.getButtons().isEmpty()){
		appStorage.addSomeButtons();
	}

  for (Button b : appStorage.getButtons()) {
	  out.print("<br>");
	  out.print(b.toString());
  }
%>
<p>
  <a href="index.jsp">Back to shopping</a>
</p>

</body>
</html>