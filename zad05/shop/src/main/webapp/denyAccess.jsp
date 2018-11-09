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

<%
if(request.getParameterValues("box")!=null) {
	for (String nr : request.getParameterValues("box")) {
		//out.println(nr);
		sessionStorage.setZgody(nr);
		//out.println(sessionStorage.getZgody(nr));
	}
}

%>

</body>
</html>