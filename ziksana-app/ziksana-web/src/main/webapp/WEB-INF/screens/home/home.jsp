<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<meta charset="utf-8" />
<meta name="description" content="Create Course">
<title>Ziksana Homepage</title>  
<link href="/ziksana-web/resources/css/main/styles2.css" rel="stylesheet" type="text/css" media="all" />
<link href="/ziksana-web/resources/css/stylesheets.css" rel="stylesheet" type="text/css" />
<link href="/ziksana-web/resources/css/main/modern.css" rel="stylesheet" type="text/css" />



<script type='text/javascript' src='/ziksana-web/resources/js/lib/jquery/jquery-1.9.1.min.js'></script>
<script type='text/javascript' src='/ziksana-web/resources/js/custom/jqueryeasing.js'></script>
<script type="text/javascript" src="/ziksana-web/resources/js/custom/alertstodoevents.js"></script>

<style>
.tileheadaa
{
margin-left:20px;
font-size: 20px;
font-size:30px;	
}

table tr th
{
color:#fff;
font-size:18px;	
border:none !important;
}

table tr td
{
color:#fff;
font-size:18px;	
border:none !important;
}

.table-hover tbody tr:hover td, .table-hover tbody tr:hover th {
background-color: rgba(206, 204, 204, 0.27);
}

</style>

</head>

<body class="metrouicss">

<div id="background">

<div id="wrapper">

<section>

<div id="Nav_bar">



 <ul>
	 <li class="navhome active "><a href="#linkurl">My Home</a> </li> 
 
     <li class="navcourse "><a href="#linkurl">My Courses</a> </li> 
 
     <li class="navstudent"><a href="#linkurl">My Contents</a> </li>
 
     <li class="navanalytic"><a href="#linkurl"> My Analytics</a> </li>  
 
 </ul>
 
 </div>

</section> <!--end of Mainnavigationbar-->


<section >

<div id="leftpanel">

<div id="Headerborder">



 <div id="HeaderLogo" class="f-l">
     
     <img src="/ziksana-web/resources/images/home/logo2.png"/>
     
 </div> <!--end of headerlogo-->




     
	<div id="HeaderNav" class="f-r">

<div id="ProfilePic" class="f-l"><img src="/ziksana-web/resources/images/home/profile.png" align="middle" class="Profile"></div>     
<div id="ProfileName" class="f-l"> Scott Chris </div>
<div id="AccountSetting" class="f-l"><span><img class="Profilepic" src="/ziksana-web/resources/images/home/actlck.png"/></span> <span class="Accounthead">Account Settings</span> <img class="Dropdown" src="../images/home/dropdown.png"/> </div>    
     
   
   
    </div> <!--end of HeaderNav-->
   <div class="Clearfix"> </div>   
 
</div>   
  
 

<div id="Zikbreadcrumbback" style="margin-left:20px;">     
 
<div class="Zikbreadcrumb f-l">

<div class="fifteen columns" id="page-title">
        <a style="margin-top:-3px;" class="back" href="javascript:history.back()"></a>
 <p class="page-title">
            <span style="font-size:13px; color:#6bbde8;">Home</span> < Create Course      </p>

</div>
 
</div> <!--end of breadcrumb-->    
   
 
 
</div>

<div class="Clearfix"> </div>



<div id="contentpanel">


<div class="tilecontainer pull-left">




  <div class="tile bg-color-blue" style="width:270px;">
 
 <p><img src="/ziksana-web/resources/images/home/profilepic.png" align="left" style="margin-top: 15px; margin-left: 5px; height:100px; margin-right:10px;" class="img-polaroid"/></p>
 
 <p  class="profiletilename pull-left" style="font-size: 20px; width:120px;
margin-top: 15px;"> Scott Chris </p>
<p> Associate Professor </p>

 
  <img  src="/ziksana-web/resources/images/home/badge.png" width="146" style="width:148px; margin-left:-4px;"/>
 
 
  </div>
  
  
  <div class="tile bg-color-blueDark">
   <img class="tileimg" src="/ziksana-web/resources/images/icons/createcontent.png"/>
   <h3>Create Content</h3>
  
  </div>
  <div class="tile">
  
   <img class="tileimg" src="/ziksana-web/resources/images/icons/managecourse.png"/>
   <h3>Manage Content</h3>
  
  </div>
  
  
   <div class="tile bg-color-blueDark">
  
   <img class="tileimg" src="/ziksana-web/resources/images/icons/editcoursecontent.png"/>
   <h3 style="width:90px;">Edit draft course</h3>
  
  </div>
  
  
   <div class="tile bg-color-blue">
  
   <img class="tileimg" src="/ziksana-web/resources/images/icons/createcourse.png"/>
   <h3 style="margin-left:10px; font-size:20px; width:30px;">Create course</h3>
  
  </div>
  
  
  
  
   <div class="tile bg-color-orange icon" style="width: 200px; height:130px;">
                        <div class="tile-content">
                            <img src="/ziksana-web/resources/images/icons/courseanaltic.png" />
                        </div>
                        <div class="brand">
                            <h3 style="margin-left:10px; font-size:22px; width:160px;">Course Analytics</h3>
                        </div>
            </div>
                    
   
   
    <div class="tile bg-color-orange icon  mt-changescene" style="width: 200px; height:130px;">
                       <div class="tile-content"><img src="/ziksana-web/resources/images/icons/announcement.png" alt="mes" />
                        </div>
                        <div class="brand">
                            <h3 style="margin-left:10px; font-size:22px;">Announcements</h3>
                        </div>
            </div>                 
                    
  
   
  
  
  
  <div class="Clearfix"> </div>


</div> <!--end of tilescontainer-->

                                
                                
 <div class="contentarea pull-right" style="height:auto;">
 
 

<div class="imagewrapper" style="height:412px;">
 
 
 <div class="panelhead" style="margin-top:-10px;">
  
  <ul>
  <li><a href="#linkrl" class="tagevent"> Events </a> </li> 
  <li><a href="#linkurl" class="tagalert"> Alerts </a> </li>
  <li><a href="#linkurl" class="tagtask"> To Do </a> </li>

  
  </ul>

 </div> <!--end of panel head-->
 
 <div class="contentareaevent" style="height:340px; width:650px;">
 
 <div class="eventheader" style="height:50px; background-color: rgba(50, 50, 50, 0.75); padding:10px; border-bottom:1px solid #ccc;">
 
 <p class="pull-left" style="color: rgb(255, 255, 255);
font-size: 15px;
margin-top: 5px;"> List of Events Today </p>
 
 <p class="pull-right" style="color:#fff;">Manage Events <a href="#linkurl"> <img src="/ziksana-web/resources/images/icons/calendar.png" style="height:30px; margin-left:6px; vertical-align:middle;"/> </a> </p> 
 </div>
 
 <div class="eventcontent" style="height:270px;">
  <table class="table table-hover">
            
            <tbody>
              <tr>
                <td>12:45 pm</td>
                <td>02.45 pm </td>
                <td>Meeting with Ziksana</td>
                
              </tr>
              <tr>
                <td>12:45 pm</td>
                <td>02.45 pm </td>
                <td>Football Match at university Ground</td>
                
              </tr>
              <tr>
                <td>12:45 pm</td>
                <td>02.45 pm </td>
                <td>Meeting with Professor John</td>
                
              </tr>
             
            </tbody>
          </table>
 
 </div>
 
 
 <div class="eventfooter" style="height:30px; background-color: rgba(50, 50, 50, 0.75); padding:10px; border-top:1px solid #ccc; padding:5px; color:#fff;">
 <p> you have 5 events today </p>
 
 </div>
 
  
      
 </div><!--end cotentareaevent-->
 
 
 
 
 
 <div class="contentareaevent" style="height:340px; width:650px;">
 
 <div class="eventheader" style="height:50px; background-color: rgba(50, 50, 50, 0.75); padding:10px; border-bottom:1px solid #ccc;">
 
 <p class="pull-left" style="color: rgb(255, 255, 255);
font-size: 15px;
margin-top: 5px;"> List of Events Today </p>
 
 <p class="pull-right" style="color:#fff;">Manage Events <a href="#linkurl"> <img src="/ziksana-web/resources/images/icons/calendar.png" style="height:30px; margin-left:6px; vertical-align:middle;"/> </a> </p> 
 </div>
 
 <div class="eventcontent" style="height:270px;">
  <table class="table table-hover">
            
            <tbody>
              <tr>
                <td>12:45 pm</td>
                <td>02.45 pm </td>
                <td>Meeting with Ziksana</td>
                
              </tr>
              <tr>
                <td>12:45 pm</td>
                <td>02.45 pm </td>
                <td>Football Match at university Ground</td>
                
              </tr>
              <tr>
                <td>12:45 pm</td>
                <td>02.45 pm </td>
                <td>Meeting with Professor John</td>
                
              </tr>
             
            </tbody>
          </table>
 
 </div>
 
 
 <div class="eventfooter" style="height:30px; background-color: rgba(50, 50, 50, 0.75); padding:10px; border-top:1px solid #ccc; padding:5px; padding-left:10px; color:#fff;">
 <p> You have 5 events today </p>
 
 </div>
 
  
      
 </div><!--end of panelhead-->
  
  <div class="Clearfix"></div>
  
  
  
  <div class="contentareaalrt" style="position:absolute; height:340px; width:650px; margin-top:60px;">
 
 <div class="alrtheader" style="height:50px; background-color: rgba(50, 50, 50, 0.75); padding:10px; border-bottom:1px solid #ccc;">
 
 <p class="pull-left" style="color: rgb(255, 255, 255);
font-size: 15px;
margin-top: 5px;"> Alerts </p>
 
 <p class="pull-right" style="color:#fff;">Manage Alerts <a href="#linkurl"> <img src="/ziksana-web/resources/images/icons/calendar.png" style="height:30px; margin-left:6px; vertical-align:middle;"/> </a> </p> 
 </div>
 
 <div class="alrtcontent" style="height:270px; padding-left:20px;">
  <table class="table table-hover">
            
            <tbody>
              <tr>
                <td width="20%">12:45 pm</td>
                <td width="70%" style="vertical-align:middle;">You have 2 Assignment Due today.</td>
                
              </tr>
              <tr>
              <td width="20%">2:05 pm</td>
                <td width="70%" style="vertical-align:middle;">You have to Attend Extra Class.</td>
              </tr>
              <tr>
               <td width="20%">4:45 pm</td>
                <td width="70%" style="vertical-align:middle;">You have physics class.</td>
              </tr>
             
            </tbody>
          </table>
 
 </div>
 
 
 <div class="eventfooter" style="height:30px; background-color: rgba(50, 50, 50, 0.75); padding:10px; border-top:1px solid #ccc; padding:5px; padding-left:10px; color:#fff;">
 <p> You have 5 Alerts today </p>
 
 </div>
 
  
      
 </div>
  
  <div class="Clearfix"></div>
  
  <div class="contentareatodo" style="position:absolute; height:340px; width:650px; margin-top:60px;">
 
 <div class="todoheader" style="height:50px; background-color: rgba(50, 50, 50, 0.75); padding:10px; border-bottom:1px solid #ccc;">
 
 <p class="pull-left" style="color: rgb(255, 255, 255);
font-size: 15px;
margin-top: 5px;"> Manage Tasks </p>
 
 <p class="pull-right" style="color:#fff;">Manage Tasks <a href="#linkurl"> <img src="/ziksana-web/resources/images/icons/calendar.png" style="height:30px; margin-left:6px; vertical-align:middle;"/> </a> </p> 
 </div>
 
 <div class="todocontent" style="height:270px;">
  <table class="table table-hover" style="margin-left::20px;">
            
            <tbody>
              <tr>
                <td width="20%" style="padding-left:30px;"><input type="checkbox" id="taskchk1" value="complete"></td>
                <td width="70%" style="vertical-align:middle;">You have 2 Assignment Due today.</td>
              </tr>
              <tr>
                <td width="20%" style="padding-left:30px;"><input type="checkbox" checked disabled id="taskchk2" value="complete"></td>
                <td width="70%" style="vertical-align:middle;" class="completedtask">You have Completed 2 tasks given by chris.</td>
              </tr>             
            </tbody>
          </table>
 
 </div>
 
 
 <div class="eventfooter" style="height:30px; background-color: rgba(50, 50, 50, 0.75); padding:10px; border-top:1px solid #ccc; padding:5px; padding-left:10px; color:#fff;">
 <p class="f-l"> You have 1 Incompleted Task </p>
 
 <p class="f-r"> <a href="#linkurl" style="color:#fff;">Remove completed Task</a></p>
 
 </div>
 
  
      
 </div>
 
  <div class="Clearfix"></div>
  
 
  
  
  
 </div> <!--end of image wrapper -->
  
                             

</div> <!--end of contentarea-->

</div> <!--end of contentpanel-->


</div> <!--end of leftpanel-->





</section> <!--end of section leftpanel-->


<div class="Clearfix"> </div>


</div> <!--end of body wrapper-->


<footer id="footercontainer2">
<div id="footerborder"> </div>
<div id="footerbordernav">

<p>
<span style="color:#fff; font-size:14px;"> Newsletter Signup </span> <img src="/ziksana-web/resources/images/home/newsletter.png" style="height:25px;"/><span style="color:#fff; font-size:14px;"> to get prompt reply for your queries </span>
</p>

</div>

<div id="footercontent2">

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

<div id="socialmeadia2">


		<div id="social">
			
			<a href="#" title="Twitter"><img src="/ziksana-web/resources/images/socialmedia/twitter.png" alt="Twitter" /></a>
			<a href="#" title="Facebook"><img src="/ziksana-web/resources/images/socialmedia/facebook.png" alt="Facebook" /></a>
		    <a href="#" title="LinkedIn"><img src="/ziksana-web/resources/images/socialmedia/linkedin.png" alt="LinkedIn" /></a>
            <a href="#" title="RSS"><img src="/ziksana-web/resources/images/socialmedia/rss.png" alt="RSS" /></a>
     		<a href="#" title="YouTube"><img src="/ziksana-web/resources/images/socialmedia/youtube.png" alt="YouTube" /></a>
		</div>

<p id="copyright2"> Copyright@2013 Ziksana </p>

</div> <!--end of socialmedia-->



 </div> <!--end of footercontent-->
</footer>

<div class="Clearfix"> </div>


</div>
  

</body>
</html>
