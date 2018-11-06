<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="bird" class="aformela.shop.domain.Bird" scope="session" />
<jsp:setProperty name="bird" property="*" /> 

<jsp:useBean id="storage" class="aformela.shop.service.StorageService" scope="application" />

<% 
  storage.add(bird);
%>

<p>Following bird has been added to storage: </p>
<p>Name: ${bird.name} </p>
<p>Year of birth: ${bird.dateOfBirth}</p>
<p>Price: ${bird.price}</p>
<p>Is female: <jsp:getProperty name="bird" property="female"></jsp:getProperty></p>
<p>Has <jsp:getProperty name="bird" property="countOfColors"></jsp:getProperty> colors</p>
<p>
  <a href="showAllBirds.jsp">Show all birds</a>
</p>
</body>
</html>