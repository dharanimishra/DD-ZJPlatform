<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta>
<meta http-equiv="Content-Type" content="text/html"  />
<title>Login</title>

<!--Body Style sheet-->
<link href="resources/css/styles.css" rel="stylesheet" type="text/css">
<link href="resources/css/type-setting.css" rel="stylesheet" type="text/css">
<link href="resources/css/effects.css" rel="stylesheet" type="text/css">
<link href="${properties.staticFileServer}resources/css/nav.css" rel="stylesheet" type="text/css">

<!--End Body Style sheet-->

<!--<link rel="stylesheet" type="text/css" href="resources/css/easyslider/demo.css" />-->
<link rel="stylesheet" type="text/css" href="resources/css/easyslider/style2.css" />
<link
	href='http://fonts.googleapis.com/css?family=Economica:700,400italic'
	rel='stylesheet' type='text/css'>
<noscript>
	<link rel="stylesheet" type="text/css" href="resources/css/easyslider/nojs.css" />
</noscript>
<script type="text/javascript"
	src="resources/js/easyslider/modernizr.custom.28468.js"></script>
<script type="text/javascript" src="resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="resources/js/custom/login.js"></script>
<script type="text/javascript" src="resources/js/easyslider/jquery.cslider.js"></script>
<script type="text/javascript">
	$(function() {

		$('#da-slider').cslider({
			autoplay : true,
			hover : stop,
			bgincrement : 0
		});

	});
</script>


<style>
.loginwrapper {
	background-color: #FFFFFF;
	background-image:url("/ziksana-web/resources/images/slider/unibg.png");
	background-repeat:no-repeat;
	background-size:100% auto;
}

.loginhead {
	background-color: #6d9ec5;
	height: 80px;
	margin-right: auto;
	margin-left: auto;
}

.zikregister {
	float: right;
	margin-right: auto;
	margin-left: auto;
}

.loginbottom {
	background-color: #222E36;
	height: 80px;
	margin-bottom: 0;
	margin-top: 20px;
}

.loginmiddle {
	background-color: #FFF;
	margin-right: auto;
	margin-left: auto;
	width: 1010px;
	/*border:1px solid #ccc;*/
	padding: 20px;
	margin-top: 20px;
	-moz-box-shadow: 1px 2px 15px #000000;
	-webkit-box-shadow: 1px 2px 15px #000000;
	box-shadow: 1px 2px 15px #000000;
}

.slider { /*border:3px solid #ccc;*/
	width: 590px;
	/*height:600px;*/
	float: left;
	box-shadow: 1px 1px 1px 1px rgba(221, 221, 221, 1);
	-webkit-box-shadow: 1px 1px 1px 1px rgba(221, 221, 221, 1);
	-moz-box-shadow: 1px 1px 1px 1px rgba(221, 221, 221, 1);
}

.logindtls {
	width: 400px;
	float: left;
	margin-left: 5px;
	moz-box-shadow: 3px 4px 4px -3px #D9D9D9;
	-webkit-box-shadow: 3px 4px 4px -3px #D9D9D9;
	box-shadow: 3px 4px 4px -3px #D9D9D9;
	border: 3px solid rgba(185, 179, 179, 0.38);
}

.zenilogo {
	margin-left: 120px;
	margin-bottom: 20px;
}

.zenimainlogo {
	margin-left: 30px;
}

.frmloginzeni {
	height: 315px;
	margin-left: 30px;
}

.clearfix {
	float: none;
	clear: both;
}

.box {
	background: #fefefe;
	border: 1px solid #C3D4DB;
	border-top: 1px;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-moz-box-shadow: rgba(0, 0, 0, 0.15) 0 0 1px;
	-webkit-box-shadow: rgba(0, 0, 0, 0.15) 0 0 1px;
	box-shadow: rgba(0, 0, 0, 0.15) 0 0 1px;
	color: #444;
	font: normal 12px/14px Arial, Helvetica, Sans-serif;
	/* margin:0 auto 30px;*/
	overflow: hidden;
}

.box.login { /*height:290px;*/
	width: 332px;
	position: absolute;
	padding: 10PX;
	border: 1px solid #999;
	/*left:50%;
	top:50%;
	margin:-130px 0 0 -166px;*/
}

.boxBody {
	background: #fefefe;
	/*border-top:1px solid #dde0e8;*/
	border:0;
	padding: 10px 20px;
}

.box footer {
	background: #eff4f6;
	border-top: 1px solid #fff;
	padding: 12px 16px;
	overflow: hidden;
	/*height:32px;*/
}

.box label {
	display: block;
	font: 14px/22px Arial, Helvetica, Sans-serif;
	margin: 10px 0 0 6px;
}

.box footer label {
	float: left;
	margin: 4px 0 0;
}

.box footer input[type=checkbox] {
	vertical-align: sub;
	*vertical-align: middle;
	margin-right: 10px;
}

.box input[type=text],.box input[type=password],.txtField,.cjComboBox {
	border: 6px solid #F7F9FA;
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	border-radius: 3px;
	-moz-box-shadow: 2px 3px 3px rgba(0, 0, 0, 0.06) inset, 0 0 1px #95a2a7
		inset;
	-webkit-box-shadow: 2px 3px 3px rgba(0, 0, 0, 0.06) inset, 0 0 1px
		#95a2a7 inset;
	box-shadow: 2px 3px 3px rgba(0, 0, 0, 0.06) inset, 0 0 1px #95a2a7 inset;
	margin: 3px 0 4px;
	padding: 8px 6px;
	width: 270px;
	display: block;
}

.box input[type=text]:focus,.box input[type=password]:focus,.txtField:focus,.cjComboBox:focus
	{
	border: 6px solid #f0f7fc;
	-moz-box-shadow: 2px 3px 3px rgba(0, 0, 0, 0.04) inset, 0 0 1px #0d6db6
		inset;
	-webkit-box-shadow: 2px 3px 3px rgba(0, 0, 0, 0.04) inset, 0 0 1px
		#0d6db6 inset;
	box-shadow: 2px 3px 3px rgba(0, 0, 0, 0.04) inset, 0 0 1px #0d6db6 inset;
	color: #333;
}

.cjComboBox {
	width: 294px;
}

.cjComboBox.small {
	padding: 3px 2px 3px 6px;
	width: 100px;
	border-width: 3px !important;
}

.txtField.small {
	padding: 3px 6px;
	width: 200px;
	border-width: 3px !important;
}

.rLink {
	padding: 0 6px 0 0;
	font-size: 11px;
	float: right;
}

.box a { /*color:#999;*/
	
}

.box a:hover,.box a:focus {
	text-decoration: underline;
}

.box a:active {
	color: #f84747;
}

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
.loginbottom ul {
    color: #FFFFFF;
    margin-left: auto;
    margin-right: auto;
    padding-top: 60px;
    width: 680px;
    text-align:center; 
}
 
</style>

</head>
<c:url var="ziksanalogo" value="/resources/images/Ziksana.jpg" />
<c:url var="onelogo" value="/resources/images/slider/new1.png" />
<c:url var="logotwo" value="/resources/images/slider/new2.png" />
<c:url var="threelogo" value="/resources/images/slider/new3.png" />
<c:url var="fourlogo" value="/resources/images/slider/4.png" />
<body style="background-image: none;">

	<div class="loginwrapper">

		<div class="loginhead">

<!-- 			<div class="zenimainlogo">
				<img src="resources/images/Ziksana.jpg" alt="Ziksana" width="116" height="112" border="3" style="border:3px solid #F6902B; background-color:#FFFFFF; padding:10px; -moz-box-shadow: 1px 2px 5px #000000;
-webkit-box-shadow: 1px 2px 5px #000000;
box-shadow: 1px 2px 5px #000000;"/>

			</div> -->
			<!--end of zenimain-->

		</div>
		<!--end of loginhead-->

		<div class="loginmiddle">

			<div class="slider">


				<div id="da-slider" class="da-slider">
					<div class="da-slide">
						<!--<h2>Ziks Power</h2>-->
						<p>Ziksana helps me chase my curiosity. I can explore the depth and breadth of the subject to the extent I like..</p>
						<a href="#" class="da-link">Read more</a>
						<div class="da-img">
						
							<img src="${onelogo}" alt="image01" />
						</div>
					</div>
					<div class="da-slide">
						<!--<h2>Revolution</h2>-->
						<p>Ziksana analytics provides me useful information on my performance and my position in the class at all times. This helps to keep me on my toes.</p>
						<a href="#" class="da-link">Read more</a>
						<div class="da-img">
							<img src="${logotwo}" alt="image01" />
						</div>
					</div>
					<!-- <div class="da-slide">
						<h2>Your College. Your Future.</h2>
						<p>High achievers spot rich opportunities swiftly, make big
							decisions quickly and move into action immediately. Follow these
							principles and you can make your dreams come true.</p>
						<a href="#" class="da-link">Read more</a>
						<div class="da-img">
							<img src="${fourlogo}" alt="image01" />
						</div>
					</div> -->
					<div class="da-slide">
						<!--<h2>Your College. Your Future.</h2>-->
						<p>I can connect with my peers and educator while I observe the course. This is a very powerful tool.</p>
						<a href="#" class="da-link">Read more</a>
						<div class="da-img">
							<img src="${threelogo}" alt="image01" />
						</div>
					</div>
					<nav class="da-arrows">
						<span class="da-arrows-prev"></span> <span class="da-arrows-next"></span>
					</nav>
				</div>


			</div>
			<!--end of slider-->


			<div class="logindtls">

				<div class="zenilogo">
					<img src="${ziksanalogo}" alt="Ziksana" width="128"
						height="128" style="float: right; margin:.5em; " />
				</div>
				<!--end of zenilogo-->


				<div class="frmloginzeni" style="clear:right;">
					<div id="loginerror">
						<%
							if (request.getAttribute("loginResult") != null
									&& ((String) request.getAttribute("loginResult"))
											.equals("true")) {
						%>
						<p style="color:#d14836;">Login Failed. Please try again.</p>
						<%
							}
						%>
					</div>
					<form name="loginfrm" class="box login" method="POST"
						action="/ziksana-web/login">
						<fieldset class="boxBody">
							<label>Username</label> <input type="text" autofocus="autofocus" name="username"
								tabindex="1" placeholder="Enter your Username">
							<div id="uerror"></div>
							<label><a href="/ziksana-web/resources/html/forgotpassword.html" class="rLink" tabindex="5">Forgot your password?
									</a>Password</label> <input type="password" name="password"
								tabindex="2" placeholder="Enter your Password">
							<div id="perror"></div>
						</fieldset>
						<!--	<footer>-->

						<input type="submit" id="btnloginsecurity" class="btnLogin"
							value="Login" tabindex="4"> <label><input
							type="checkbox" tabindex="3"><span style="color: #27b;">Stay signed in </span></label>

						<!-- <input type="submit" class="btnLogin" value="Register" tabindex="4">-->
						<div class="clearfix"></div>
						<a href="#" class="rLink" tabindex="5" style="margin-top: 10px;float:left;margin-left:9px;">Connect with Ziksana </a>
						<a href="/ziksana-web/resources/html/register.html" class="rLink" tabindex="5" style="margin-top: 10px;">Can't access your account?</a>
						<!-- </footer>-->
					</form>

				</div>
				<!--end of frmloginzeni-->

			</div>
			<!--end of logindetails-->


			<div class="clearfix"></div>


		</div>
		<!--end of loginmiddle-->



		<div class="loginbottom">
		
		 
 
  <ul>
  <li>Copyright © 2013 <span style="color:#f28920;">Ziksana! </span> All rights reserved.&nbsp;|&nbsp; <span style="color:#9a9797;"><a href="#linkurl"  style="color:#9a9797;"> Terms of Service. </a></span>&nbsp;|&nbsp;<a href="#linkurl"  style="color:#9a9797;"> Guide to Online Security</a></span>&nbsp;|&nbsp;<a href="#linkurl" style="color:#9a9797;"> Privacy Policy </a></span></li> 
  
 </ul>
 
 
 
   
		
		</div>
		<!--end of loginbottom-->

	</div>
	<!--end of loginwrapper-->

</body>
</html>
