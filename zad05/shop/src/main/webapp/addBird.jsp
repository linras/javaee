<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="storage" class="aformela.shop.service.StorageService" scope="application" />
<jsp:useBean id="bird" class="aformela.shop.domain.Bird" scope="session" />

<form action="data.jsp">

  Name :<input type="text" name="name" value="${bird.name}" /><br />
  Date of birth (yyyy-mm-dd):<input type="text"  name="dateOfBirth" value="${bird.dateOfBirth}" /><br />
  Price :<input type="text"  name="price" value="${bird.price}" /><br />
  Is female? true/false: <input type="text"  name="female" value="${bird.female}" /><br />
  Count of colors: <input type="text"  name="countOfColors" value="${bird.countOfColors}" /><br />
  <input type="submit" value=" OK ">
  
</form>

</body>
</html>