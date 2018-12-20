<%@page import="aformela.shop.domain.Survey"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Birds</title>
</head>
<body>

<jsp:useBean id="sessStorage" class="aformela.shop.service.StorageService" scope="session" />
<jsp:useBean id="survey" class="aformela.shop.domain.Survey" scope="session" />
<jsp:setProperty name="survey" property="*" /> 
<%	//storage.addSomeSurveys();
// 	if(appStorage.getSurveys().isEmpty()){
// 		appStorage.addSomeSurveys();
// 	}
	if(request.getParameter("delete")!=null ){
		int index = Integer.parseInt(request.getParameter("delete"));
		index--;
		sessStorage.getSurveys().remove(index);
	}
	
		if(request.getParameter("edit")!=null){
			int index = Integer.parseInt(request.getParameter("edit"));
			index--;
			out.print(index);
			survey = sessStorage.getSurveys().get(index);
			sessStorage.getSurveys().remove(index);
			out.print("<script>window.location.href = \"addSurvey.jsp\"</script>");
		}
	
		
  for (Survey sur : sessStorage.getSurveys()) {
	  out.print("<br>"+(sessStorage.getSurveys().indexOf(sur)+1)+". ");
	  out.print(sur.toString());
  }
  out.print("<br><br><h1>Do you want to delete/edit some? If yes insert number: </h1>");
%>
  <form action="yourSurvey.jsp">
  	Delete: <input type="text" name="delete" >
  <input type="submit" value=" OK ">
  </form>
  <br>
  <form action="yourSurvey.jsp">
  	Edit: <input type="text" name="edit" >
  <input type="submit" value=" OK ">
  </form>
<p>
  <a href="index.jsp">Back to shopping</a>
</p>

</body>
</html>