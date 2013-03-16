<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true"%>

 
      <header class="bottom-box-shadow bckground-wihte">
           
	  <p></P>
            	<div class="topheader"> 
          <!--logo container-->
         
          	<c:url var="imageUrl_header1" value="/resources/images/ziksana_button_logo.png" />
            <c:url var="launcherPage" value="/secure/launcher"/>
            <p><a><img data-launcher data-launchpage="${launcherPage}" src="${imageUrl_header1}" width=120px height=120px style="position: absolute;top:3px;  left:30px; margin-left:0px;  "/></a></p>
        	<!-- <header class="bottom-box-shadow bckground-wihte"> -->
			
         
          <!--end logo container-->
         
        </div>
            <nav>
                <!--menu-->
                <c:if test="${member.roleType eq 'EDUCATOR'}">
                    <div class="menu" >
                      <ul>
                        <li><a id="homepage_nav" href="/ziksana-web/secure/homepage" class="current">My Home</a><div class="nav-line"></div></li>
						
                        <li><a id="myprograms_nav" href="/ziksana-web/zcourse/myprograms">My Programs</a><div class="nav-line"></div></li>
                        <li><a href="#">My Students</a><div class="nav-line"></div></li>
                        <li><a href="#" style="margin-left:-10px;">&nbsp;&nbsp;My Locker</a></li>
                      </ul>
                    </div>
                    </c:if>
                     <c:if test="${member.roleType eq 'LEARNER'}">
                    <div class="menu" >
                      <ul>
                        <li><a id="homepage_nav" href="/ziksana-web/secure/homepage" class="current">My Home</a><div class="nav-line"></div></li>
						
                        <li><a id="myprograms_nav" href="/ziksana-web/zcourse/myprograms">My Programs</a><div class="nav-line"></div></li>
                        <li><a href="#">My Performance</a><div class="nav-line"></div></li>
                        <li><a href="#" style="margin-left:-10px;">&nbsp;&nbsp;My Locker</a></li>
                      </ul>
                    </div>
                    </c:if>
                    <!--End menu-->
       	   	  		 <div class="status-container">
            <div id="status-icons" class="bottom-box-shadow two-bottom-rounded-box">
              <ul>
                <li><a href="#" class="email-icon" rel="tipsy" title="3 New Messages"><span class="wite-title">3</span></a></li>
                 <li><a href="#" class="peoples-icon orange-bc" rel="tipsy" title="5 Contact requests"><span class="wite-title">5</span></a></li>
                <li><a href="#" class="alart-icon orange-bc" rel="tipsy" title="1 Connect Request"><span class="wite-title">1</span></a></li>
                <li><a href="#" class="announcement-icon orange-bc" rel="tipsy" title="3 New Announcement"><span class="wite-title">3</span></a></li>
                 <li><a href="#" class=" amount-icon blue-bc"  rel="tipsy" title="Ziks available"><span class="wite-title">355500</span></a></li>
               
              </ul>

              <div > </div>
            </div>
            <div class="account-container two-bottom-rounded-box">
              <div class="container7">
                <div class="topnav" ><a href="#" class="signin wite bold"><span class="text-size-px12 wite bold">My Account</span></a> </div>
                <fieldset id="signin_menu">
                 <ul>
                   <li><a href="#">Preferences</a></li>
                   <li><a href="#">Privacy</a></li>
                   <li><a href="/ziksana-web/secure/logout">Sign Out</a></li></ul>
                </fieldset>
              </div>
            </div>
          </div>
   	   	  	  		
                    </nav>
                    
     </header>