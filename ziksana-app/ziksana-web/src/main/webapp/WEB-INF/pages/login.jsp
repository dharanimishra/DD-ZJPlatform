<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter your name and password...</title>
</head>
<body>
<%
    
if(request.getAttribute("loginResult") != null && ((String)request.getAttribute("loginResult")).equals("true") ) {
%>
 <p> Login Failed. Please try again. </p>
<%
}
%>

<p>&nbsp;</p>
<form method="POST" action="/ziksana-web/login">
<p><font color="#800000" size="5">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Enter your name...:</font><input type="text" name="username" size="20"></p>
<p><font color="#800000" size="5">
Enter your password:</font><input type="text" name="password" size="20"></p>
<p><input type="submit" value="Submit" name="B1"></p>
</form>
</body>
</html>