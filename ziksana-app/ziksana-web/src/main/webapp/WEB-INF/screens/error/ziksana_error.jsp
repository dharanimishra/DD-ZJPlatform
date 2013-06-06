<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<!DOCTYPE html>
<html>
<head>
<link href="/ziksana-web/resources/css/main/styles2.css" rel="stylesheet" type="text/css" media="all" />
<link href="/ziksana-web/resources/css/main/icons.css" rel="stylesheet" type="text/css"/>
<link href="/ziksana-web/resources/css/stylesheets.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div id="background">

<div id="wrapper">


<section >

<div id="loginwrapper"  style="padding-bottom:20px;height:450px">


 <div id="contentpanel">

<div id="headercontainer" style="overflow:auto">
 
 <div id="HeaderLogo" class="f-l">
     
     <img src="/ziksana-web/resources/images/home/loginlogo.png" style="height:80px;"/>
     
 </div> <!--end of headerlogo-->
 </div></div>
	<div class="frgtpassmiddle"  style="margin-bottom:0px">
 
   <div class="registerdtls" style="text-align:center">	
<h1>${errorMessage} </h1><br/>
		<p><img src="/ziksana-web/resources/images/ziksana_error_page.png" width=408px height=272px> 
			<div style=" margin: auto;text-align: center; font-weight:bold; font-family:inherit;">
				<h4 >There is an Error on the page .<br>Please Login Again.</h4>
		<a href="/ziksana-web/secure/logout"><input class="btn" type="submit"  value="Login" style="width:120px;padding:5px"></a>
		
	</div></div>	 
 </div></div></section></div>
 <footer id="footercontainer">
<div id="footerborder"> </div>
 

<div id="footercontent">

<div id="comapnyinfo">

<div class="companynav">
<ul>
<li> <a href="#linkurl" style="color: rgb(90, 90, 90);">  Company : </a> </li>
<li><a href="#linkurl"> About Us </a> </li>
<li> <a href="#linkurl"> Ziksana Connect </a> </li>
<li><a href="#linkurl"> Contact us </a> </li>

</ul>


</div> <!--end of companynav-->

</div> <!--end of companyinfo-->


<div id="locationinfo">

<div class="locationnav">

<ul>
<li><a href="#linkurl" style="color: rgb(90, 90, 90);"> Location : </a> </li>
<li><a href="#linkurl"> New york </a> </li>
<li> <a href="#linkurl"> Amsterdam </a> </li>
<li><a href="#linkurl"> Bangalore </a> </li>
</ul>

</div>

</div> <!--end of location info-->

<div class="Clearfix"> </div>

<div id="socialmeadia">
 
<p id="copyright"> Copyright@2013 Ziksana </p>

</div> <!--end of socialmedia-->



 </div> <!--end of footercontent-->
</footer>

<div class="Clearfix"> </div>
 
 </div>
</body>

</html>