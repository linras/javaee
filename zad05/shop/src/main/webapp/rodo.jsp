<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <jsp:useBean id="sessionStorage" class="aformela.shop.service.StorageService" scope="session" />
	<form action='rodo.jsp' method='GET'>
		<input type='checkbox' name='box' value='first'>First </br>
		<input type='checkbox' name='box' value='second'>Second </br>
		<input type='checkbox' name='box' value='third'>Third </br>
		
	<input type='submit' value=' OK ' /></form>
	<h1>You must check 1 and 2 to visit site content. </h1>
	
	<%
	if(request.getParameterValues("box")!=null) {
		for (String nr : request.getParameterValues("box")) {
			//out.println(nr);
			sessionStorage.setZgody(nr);
			//out.println(sessionStorage.getZgody(nr));
		}
}
	if(sessionStorage.getZgody("first")==true && sessionStorage.getZgody("second")==true){ %>
		<script>
	    window.location.href = "index.jsp"
	    </script>
<%
	}
%>
</body>
</html>