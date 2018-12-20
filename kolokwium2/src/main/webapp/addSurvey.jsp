<%@page import="javax.swing.text.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adding a survey</title>
</head>
<body>

<jsp:useBean id="appStorage" class="aformela.shop.service.StorageService" scope="application" />
<jsp:useBean id="sessStorage" class="aformela.shop.service.StorageService" scope="session" />
<jsp:useBean id="survey" class="aformela.shop.domain.Survey" scope="session" />

<form action="surveyData.jsp">

  From (yyyy-mm-dd) :<input type="text" name="pocz" value="${survey.pocz}" /><br />
  To (yyyy-mm-dd) :	<input type="text" name="kon" value="${survey.kon}" /><br />
  Frequency :<br />
  
  <%String s = "";
  if(survey.getCzestotliwosc()!=null && survey.getCzestotliwosc().equals("daily")) s="checked";%>
  			<input type="radio" name="frequency" value="daily" checked />daily<br />
  <% s = "";
  if(survey.getCzestotliwosc()!=null && survey.getCzestotliwosc().equals("weekly")) s="checked";%>
			<input type="radio" name="frequency" value="weekly" ${s} />every week<br />
	<% s = "";
  if(survey.getCzestotliwosc()!=null && survey.getCzestotliwosc().equals("monthly")) s="checked";%>
			<input type="radio" name="frequency" value="monthly" ${s} />every month<br />
  Opinions:<br />
			<input type="checkbox" name="opinion" value="good" />good<br />
			<input type="checkbox" name="opinion" value="ok" />ok<br />
			<input type="checkbox" name="opinion" value="bad" />bad<br />
  
  <input type="submit" value=" OK ">
  
</form>

</body>
</html>