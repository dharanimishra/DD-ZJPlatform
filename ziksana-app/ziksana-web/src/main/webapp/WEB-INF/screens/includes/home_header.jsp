
<div id="Headerborder">



 <div id="HeaderLogo" class="f-l">
     
     <img src="/ziksana-web/resources/images/home/logo2.png"/>
     
 </div> <!--end of headerlogo-->

     
	<div id="HeaderNav" class="f-r">

<div id="ProfilePic" class="f-l "><img src="<c:out value="/ziksana-web${member.picturePath}"/> " align="middle" class=" rounded_image Profile"></div>     
<div id="ProfileName" class="f-l"> <c:out value="${member.firstName}"/> <c:out value="${member.lastName}"/> </div>
<div id="user_menu_container">
<div id="AccountSetting" class="f-l"><span><img class="Profilepic" src="/ziksana-web/resources/images/home/actlck.png"/></span> <span class="Accounthead">Account Settings</span> <img id="user_menu_trigger" class="Dropdown" src="/ziksana-web/resources/images/home/dropdown.png"/> </div>    
<div id="user_menu">
	<a href="#">Preferences</a>
	<a href="#">Privacy</a>
	<a href="/ziksana-web/secure/logout">Sign Out</a>
</div>   
</div> 
   
   
    </div> <!--end of HeaderNav-->
   <div class="Clearfix"> </div>   
 
</div>   
  
 