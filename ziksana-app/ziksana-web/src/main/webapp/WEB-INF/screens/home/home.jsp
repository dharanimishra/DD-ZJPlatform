<div id="Zikbreadcrumbback" style="margin-left:20px;">     
 
<div class="Zikbreadcrumb f-l">

<div class="fifteen columns" id="page-title">

 <p class="page-title">
            <span style="font-size:13px; color:#6bbde8;">Home</span></p>

</div>
 
</div> <!--end of breadcrumb-->    
   
 
 
</div>

<div class="Clearfix"> </div>




<div id="contentpanel">


<div class="tilecontainer pull-left">




  <div class="tile bg-color-blue" style="width:270px;">
 <c:if test="${empty member.picturePath}">
 <p><img src="<c:out value="/ziksana-web${member.picturePath}"/> " align="left" style="margin-top: 15px; margin-left: 5px; height:100px; margin-right:10px;" class="img-polaroid"/></p>
 </c:if>
 <c:if test="${not empty ms.url && not empty member.picturePath}">
 <p><img src="${ms.url}<c:out value="${member.picturePath}"/>" align="left" style="margin-top: 15px; margin-left: 5px; height:100px; margin-right:10px;" class="img-polaroid"/></p>
 </c:if>
 <p  class="profiletilename pull-left" style="font-size: 20px; width:120px;
margin-top: 15px;"><c:out value="${member.firstName}"/> <c:out value="${member.lastName}"/></p>
<p> <c:out value="${member.designation}"/> </p>

 
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
  
  <a href="/ziksana-web/zcourse/createcourse">
   <div  class="tile bg-color-blue">
  
   <img class="tileimg" src="/ziksana-web/resources/images/icons/createcourse.png"/>
   <h3 style="margin-left:10px; font-size:20px; width:30px;">Create course</h3>
  
  </div></a>
  
  
  
  
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
  
  
  
  <div class="contentareaalrt" id="alerts_placeholder" style="position:absolute; height:340px; width:650px; margin-top:60px;">
 
      
 </div>
  
  <div class="Clearfix"></div>
  
  <div class="contentareatodo" id="todos_placeholder" style="position:absolute; height:340px; width:650px; margin-top:60px;">
 
 
      
 </div>
 
  <div class="Clearfix"></div>
  
 
  
  
  
 </div> <!--end of image wrapper -->
  
                             

</div> <!--end of contentarea-->

</div> <!--end of contentpanel-->

