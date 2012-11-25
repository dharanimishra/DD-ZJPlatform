<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Title</title>
	
	<!--Body Style sheet-->
	<link href="resources/css/styles.css" rel="stylesheet" type="text/css">
	<link href="resources/css/type-setting.css" rel="stylesheet" type="text/css">
	<link href="resources/css/effects.css" rel="stylesheet" type="text/css">
	<link href="resources/css/nav.css" rel="stylesheet" type="text/css">
	<!--End Body Style sheet-->
	
</head>

<body>



<div id="login" class="for-rounded-box , all-box-shadow" style="width:400px; margin:0 auto; margin-top:50px;">
<%
    
if(request.getAttribute("loginResult") != null && ((String)request.getAttribute("loginResult")).equals("true") ) {
%>
 <p> Login Failed. Please try again. </p>
<%
}
%>

                  <div class="col-open-container">
                          <div class="custom-1">
                          <div  class="log-title two-top-rounded-box">Login
                          </div>
                          </div> 
                          <div  class="for-rounded-box  all-box-shadow white-bg"> 
                        <div id="login-container" class="border-left , border-right">
                       	  <form   method="POST"   action="/ziksana-web/login">
                           	<p class="titles-info-no-border teal-color">User Name*</p>
                            <input type="text" name="username"  class="input-logen" title="">
                           	<p class="titles-info-no-border teal-color">Password*</p>
                            <input type="password" name="password"  class="input-logen" title="">
                            <br>
                            <br>
<p>
              <input name="signin_submit" class="signin-submit-login" type="submit"  value="Signin" alt="Signin" style="text-decoration:none" ><strong class="wite"></strong>
              <br>
              <br>
</p>
                            <p class="p-p"><input type="checkbox" name="remember" alt="Remember me" class="checkbox-login">
                            <strong class="light-blue text-size-px10">Remember me</strong></p>
                            <p>&nbsp; </p>
                            <p class="text-size-px9"><a href="#">Forgot your password or username</a>?</p>

                          </form>
                        </div>
                        
                        </div>
                    </div>
                </div>
</body>
</html>
