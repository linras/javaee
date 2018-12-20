<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>What you added</title>
</head>
<body>
<jsp:useBean id="button" class="aformela.shop.domain.Button" scope="session" />
<jsp:setProperty name="button" property="*" /> 

<jsp:useBean id="appStorage" class="aformela.shop.service.StorageService" scope="application" />
<jsp:useBean id="sessStorage" class="aformela.shop.service.StorageService" scope="session" />

<% 
	if (request.getParameter("dziurki") != null) {
		button.setDziurki(request.getParameter("dziurki"));
	}
	if (request.getParameter("opinion") != null) {
		String[] uwagi = request.getParameterValues("opinion");
		button.setUwagi(uwagi);
	}

	out.print(button.toString());
  	appStorage.addButton(button);
   	sessStorage.addButton(button);
%>

<p>Following button has been added to storage: </p>
<p>Name: ${button.nazwa} </p>
<p>Price: ${button.price}</p>
<p>Date: ${button.data}</p>
<p>Holes: ${button.dziurki}</p>
<p>Opinions: ${button.uwagiToString()}</p>
<p>
  <a href="seeAllButtons.jsp">Show all buttons</a><br>
  <a href="yourButtons.jsp">Show your buttons</a>
</p>
</body>
</html>