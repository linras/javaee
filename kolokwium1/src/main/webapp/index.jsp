<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My application</title>
    </head>
    <body>
    <jsp:useBean id="sessionStorage" class="aformela.shop.service.StorageService" scope="session" />
    <%
    if(sessionStorage.getZgody("first") != true || sessionStorage.getZgody("second") != true)
    {
    %>
    <script>
    window.open('rodo.jsp','My Window','height= 480 px,width =640 ,')
    </script>
    <% } %>
        <h2>Mini shop of birds</h2>
        <%
    if(sessionStorage.getZgody("first") == true && sessionStorage.getZgody("second") == true)
    	{
    %>
	        <p><a href="addBird.jsp">Add bird to the shop</a></p>
	        <p><a href="shopping.jsp">Shopping</a></p>
	        <p><a href="trolley.jsp">Your birds</a></p>
	        <p><a href="addOpinion">Add an opinion</a></p>
	        <p><a href="survey.jsp">Add survey</a></p>
     <% } 
    else {
    	out.print("First you must agree!");
    }
     %>
     <p><a href="/shop">REFRESH</a></p>
    </body>
</html>
