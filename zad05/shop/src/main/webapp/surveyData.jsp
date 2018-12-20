<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>What you added</title>
</head>
<body>
<jsp:useBean id="survey" class="aformela.shop.domain.Survey" scope="session" />
<jsp:setProperty name="survey" property="*" /> 

<jsp:useBean id="appStorage" class="aformela.shop.service.StorageService" scope="application" />
<jsp:useBean id="sessStorage" class="aformela.shop.service.StorageService" scope="session" />

<% 
	if (request.getParameter("frequency") != null) {
		survey.setCzestotliwosc(request.getParameter("frequency"));
	}
	if (request.getParameter("opinion") != null) {
		String[] uwagi = request.getParameterValues("opinion");
		survey.setUwagi(uwagi);
	}

	out.print(survey.toString());
  	appStorage.addSur(survey);
   	sessStorage.addSur(survey);
%>

<p>Following survey has been added to storage: </p>
<p>From: ${survey.pocz} </p>
<p>To: ${survey.kon}</p>
<p>Frequency: ${survey.czestotliwosc}</p>
<p>Opinions: ${survey.uwagiToString()}</p>
<%-- <p>Is female: <jsp:getProperty name="bird" property="female"></jsp:getProperty></p> --%>
<%-- <p>Has <jsp:getProperty name="bird" property="countOfColors"></jsp:getProperty> colors</p> --%>
<p>
  <a href="seeAllSurveys.jsp">Show all surveys</a>
  <a href="yourSurvey.jsp">Show your surveys</a>
</p>
</body>
</html>