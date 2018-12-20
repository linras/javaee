<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adding a button</title>
</head>
<body>

<jsp:useBean id="appStorage" class="aformela.shop.service.StorageService" scope="application" />
<jsp:useBean id="sessStorage" class="aformela.shop.service.StorageService" scope="session" />
<jsp:useBean id="button" class="aformela.shop.domain.Button" scope="session" />

<form action="buttonData.jsp">

  Name :<input type="text" name="nazwa" value="${button.nazwa}" /><br />
  Price :<input type="text" name="price" value="${button.price}" /><br />
  Date (yyyy-mm-dd) :	<input type="text" name="data" value="${button.data}" /><br />
  DZiurki :<br />
  
  			<input type="radio" name="dziurki" value="dwie"  />2<br />
			<input type="radio" name="dziurki" value="cztery"  />4<br />
			<input type="radio" name="dziurki" value="szesc"  />6<br />
  Opinions:<br />
			<input type="checkbox" name="opinion" value="good" />good<br />
			<input type="checkbox" name="opinion" value="ok" />ok<br />
			<input type="checkbox" name="opinion" value="bad" />bad<br />
  
  <input type="submit" value=" OK ">
  
</form>

</body>
</html>