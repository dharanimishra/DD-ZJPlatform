<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.btnLogin {
	background: #6d9ec5;
	border: 2px solid #ffffff !important;
	cursor: pointer;
	padding: 11px 16px;
	font: bold 11px/14px Verdana, Tahomma, Geneva;
	text-shadow: rgba(0, 0, 0, 0.2) 0 1px 0px;
	color: #fff;
	-moz-box-shadow: inset rgba(255, 255, 255, 0.6) 0 1px 1px,
		rgba(0, 0, 0, 0.1) 0 1px 1px;
	-webkit-box-shadow: inset rgba(255, 255, 255, 0.6) 0 1px 1px,
		rgba(0, 0, 0, 0.1) 0 1px 1px;
	box-shadow: inset rgba(255, 255, 255, 0.6) 0 1px 1px, rgba(0, 0, 0, 0.1)
		0 1px 1px;
	margin-left: 12px;
	float: right;
	padding: 7px 21px;
}

.btnLogin:hover,.btnLogin:focus,.btnLogin:active {
	background: #f28920;
}

.btnLogin:active {
	text-shadow: rgba(0, 0, 0, 0.3) 0 -1px 0px;
}
body{
background: #D7D7D7;	
}
</style>
</head>
<body>

<img src="ziksana_button_logo.png" style="float:left; margin-left:20px;">


<div style="width:500px;  margin-left:170px;  margin:auto;">
		
<h1>${errorMessage} </h1><br/>
		<p><img src="/ziksana-web/resources/images/ziksana_error_page.png" width=408px height=272px> 
			<div style="float:right; font-weight:bold; font-family:inherit;">
				<p >Please Login Again.</p>
		<a href="/ziksana-web/secure/logout">
		<input  class="btnLogin" type="submit"  value="Login"></a>
		
		<div>
<div>
</body>

</html>