
<div id="Headerborder">



 <div id="HeaderLogo" class="f-l">
     
     <img src="/ziksana-web/resources/images/home/logo2.png"/>
     
 </div> <!--end of headerlogo-->

     
	<div id="HeaderNav" class="f-r">
<div style=" float:left;width:70%">
<div id="ProfilePic" class="f-r ">

<c:if test="${empty member.picturePath}">
<img src="/ziksana-web/resources/images/no-image.jpg" align="middle" class=" rounded_image Profile">
</c:if>
<c:if test="${not empty ms.url && not empty member.picturePath}">
<img src="${ms.url}<c:out value="${member.picturePath}"/>" align="middle" class=" rounded_image Profile">
</c:if>  
 <c:out value="${member.firstName}"/> <c:out value="${member.lastName}"/> </div>
</div> 
<div id="user_menu_container">
<div id="AccountSetting" class="f-l"><span><img class="Profilepic" src="/ziksana-web/resources/images/home/actlck.png"/></span> 

<span class="Accounthead">Account Settings</span> <img id="user_menu_trigger" class="Dropdown" src="/ziksana-web/resources/images/home/dropdown.png"/> </div>    
<div id="user_menu">
<!-- /ziksana-web/profile/1/manageprofile/<c:out value="${member.memberId}"/> -->
	<a href="/ziksana-web/profile/1/manageprofile/<c:out value="${member.memberId}"/>">Manage Profile</a>
	<a href="/ziksana-web/secure/logout">Sign Out</a>
</div>   
</div> 
   
   
    </div> <!--end of HeaderNav-->
   <div class="Clearfix"> </div>   
 
</div>   
  
 