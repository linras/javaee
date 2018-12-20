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
    window.location.href = "rodo.jsp"
    </script>
    <% } %>
        <h2>Mini shop of buttons</h2>
        <%
    if(sessionStorage.getZgody("first") == true && sessionStorage.getZgody("second") == true)
    	{
    %>
    		<p><a href="buttonShopping.jsp">Add button from all buttons (zakupy)</a></p>
	        <p><a href="addButton.jsp">Add your button (formularz)</a></p>
	        <p><a href="seeAllButtons.jsp">See all buttons</a></p>
	        <p><a href="yourButtons.jsp">Your buttons (koszyk)</a></p>
<!-- 	        <p><a href="addBird.jsp">Add bird to the shop</a></p> -->
<!-- 	        <p><a href="shopping.jsp">Shopping</a></p> -->
<!-- 	        <p><a href="trolley.jsp">Your birds</a></p> -->
<!-- 	        <p><a href="addSurvey.jsp">Add survey</a></p> -->
<!-- 	        <p><a href="seeAllSurveys.jsp">See all surveys</a></p> -->
<!-- 	        <p><a href="yourSurvey.jsp">Your surveys</a></p> -->
     <% } 
    else {
    	out.print("First you must agree!");
    }
     %>
     <p><a href="/shop">REFRESH</a></p>
    </body>
</html>
