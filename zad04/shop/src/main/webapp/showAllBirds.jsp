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
<%
  for (Bird bird : storage.getAllBirds()) {
	  out.println("<p>Name: " + bird.getName() + "; Price: " + bird.getPrice()+"; Date of birth: "+bird.getDateOfBirth() + "; Is Female: "+bird.isFemale()+"; Has "+bird.getCountOfColors()+" colors;"+"</p>");
  }
%>
<p>
  <a href="index.jsp">Back to shopping</a>
</p>

</body>
</html>