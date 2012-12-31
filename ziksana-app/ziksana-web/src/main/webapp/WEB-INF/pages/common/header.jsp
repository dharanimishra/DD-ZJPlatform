<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <header class="bottom-box-shadow bckground-wihte">
            	<div class="topheader"> 
          <!--logo container-->
          <div class="logo">
          	<c:url var="imageUrl_header1" value="/resources/images/logo.jpg" />
            <p><a href="index.html"><img src="${imageUrl_header1}" width="189" height="73"></a></p>
            
          </div>
          <!--end logo container-->
          <div class="status-container">
            <div id="status-icons" class="bottom-box-shadow two-bottom-rounded-box">
              <ul>
                <li><a href="#" class="email-icon" rel="tipsy" title="3 New emails"><span class="wite-title">3</span></a></li>
                <li><a href="#" class="alart-icon orange-bc" rel="tipsy" title="1 Circle Invite"><span class="wite-title">1</span></a></li>
                <li><a href="#" class=" amount-icon blue-bc"  rel="tipsy" title="Ziks available"><span class="wite-title">355500</span></a></li>
                <li><a href="#" class="peoples-icon orange-bc" rel="tipsy" title="5 Contact requests"><span class="wite-title">5</span></a></li>
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
        </div>
            <nav>
                <!--menu-->
                    <div class="menu">
                      <ul>
                        <li><a href="" class="current">My Home</a><div class="nav-line"></div></li>
                        <li><a href="myprogram">My Programs</a><div class="nav-line"></div></li>
                        <li><a href="#">My Students</a><div class="nav-line"></div></li>
                        <li><a href="#">My Locker</a></li>
                      </ul>
                    </div>
                    <!--End menu-->
       	   	  		<div class="searchpanel">
       	   	  		 <div>
                      <form id="ui_element" class="sb_wrapper">
                       <span class="sb_down"></span>
                   <input type="text" name="search" id="search" placeholder="Search..." title="Search..." autosave="unique" class="two-left-rounded-box two-right-rounded-box">
   	   	  		        <input id="submit" type="submit" value="Submit">
                         
                     <ul class="sb_dropdown" style="display:none;">
						<li class="sb_filter">Filter your search</li>
						<li><input type="checkbox"/><label for="all"><strong>All Categories</strong></label></li>
						<li><input type="checkbox"/><label for="Automotive">Students</label></li>
						<li><input type="checkbox"/><label for="Baby">Locker</label></li>
						<li><input type="checkbox"/><label for="Beauty">Program</label></li>
                       <!-- <p>
                        </p>
                        <p>
						<li><input type="checkbox"/><label for="all"><strong>All Categories</strong></label></li>
						<li><input type="checkbox"/><label for="Automotive">Filter by Area</label></li>
						<li><input type="checkbox"/><label for="Baby">Filter by Subject</label></li>
						<li><input type="checkbox"/><label for="Beauty">Filter by Topic</label></li>
                        </p> -->
					</ul>
       	   	  		  </form>
              </div>
       	   	  		</div>
   	   	  	  		<div class="searchoptions">
                   	  <ul>
                   	    <li class="srch-op-a"><a href="#" rel="tipsy" title="Help"></a></li>
                   	    <li class="srch-op-b"><a href="#" rel="tipsy" title="Information"></a></li>
                    	<li class="srch-op-c"><a href="#" rel="tipsy" title="Zeni"></a></li>
                  	  </ul>
   	   	  	  		</div>
                    </nav>
     </header>