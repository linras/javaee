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

<jsp:useBean id="sessStorage" class="aformela.shop.service.StorageService" scope="session" />
<jsp:useBean id="button" class="aformela.shop.domain.Button" scope="session" />
<jsp:setProperty name="button" property="*" /> 
<%	//storage.addSomeSurveys();
// 	if(appStorage.getSurveys().isEmpty()){
// 		appStorage.addSomeSurveys();
// 	}
	if(request.getParameter("delete")!=null ){
		int index = Integer.parseInt(request.getParameter("delete"));
		index--;
		sessStorage.getButtons().remove(index);
	}
	
		if(request.getParameter("edit")!=null){
			int index = Integer.parseInt(request.getParameter("edit"));
			index--;
			out.print(index);
			button = sessStorage.getButtons().get(index);
			sessStorage.getButtons().remove(index);
			out.print("<script>window.location.href = \"addButton.jsp\"</script>");
		}
	
		
  for (Button b : sessStorage.getButtons()) {
	  out.print("<br>"+(sessStorage.getButtons().indexOf(b)+1)+". ");
	  out.print(b.toString());
  }
  out.print("<br><br><h1>Do you want to delete/edit some? If yes insert number: </h1>");
%>
  <form action="yourButtons.jsp">
  	Delete: <input type="text" name="delete" >
  <input type="submit" value=" OK ">
  </form>
  <br>
  <form action="yourButtons.jsp">
  	Edit: <input type="text" name="edit" >
  <input type="submit" value=" OK ">
  </form>
<p>
  <a href="index.jsp">Back to shopping</a>
</p>

</body>
</html>