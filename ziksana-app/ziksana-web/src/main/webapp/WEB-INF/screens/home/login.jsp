<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="page" id="page-index">
    <div class="page-header">
        <div class="page-header-content">
            <h1>Welcome to Ziksana<small> Learning Naturally &trade;</small></h1>        
        </div>
    </div>
    <div class="page-region">
        <div class="page-region-content">
            <div class="grid">
                <div class="row">
                    <div class="span8">
                        <div class="hero-unit">
                            <div id="carousel1" class="carousel" data-role="carousel" data-param-duration="300">
                                <div class="slides">

                                    <div class="slide" id="slide1">
                                        <h2>Chase your curiosity!</h2>
                                        <p class="bg-color-blueDark padding20 fg-color-white">Ziksana helps me chase my curiosity. I can explore the depth and breadth of the subject to the extent I like...</p>
                                    </div>

                                    <div class="slide" id="slide2">
                                        <h2>Connect with your Peers!</h2>
                                        <p class="bg-color-green padding20 fg-color-white">I can connect with my peers and educator while I observe the course. This is a very powerful tool.</p>
                                    </div>

                                    <div class="slide" id="slide3">
                                        <h2>Gauge your Performance!</h2>
                                        <p class="bg-color-pink padding20 fg-color-white">Ziksana analytics provides me useful information on my performance and my position in the class at all times. This helps to keep me on my toes.</p>
                                    </div>
                                </div>

                                <span class="control left"><i class="icon-arrow-left-3"></i></span>
                                <span class="control right"><i class="icon-arrow-right-3"></i></span>

                            </div>
                        </div>
                    </div>
                    <div class="span4">
                        <div class="span4 padding30 text-center place-left bg-color-blueLight" id="login_box">
                       	 	<h2 class="fg-color-red">Login</h2>
                       	 	<div id="loginerror">
								<%
									if (request.getAttribute("loginResult") != null
											&& ((String) request.getAttribute("loginResult"))
													.equals("true")) {
									
								%>
								<p style="color:#d14836;">Login Failed. Please try again.${accountLocked}</p>
								<%
									}
								%>
								
							</div>
                        	<form name="loginfrm" class="box login" method="POST" action="/ziksana-web/login">
	                        	<div class="input-control text">
	                                    <input autofocus="autofocus" name="username" type="text" placeholder="Username">
	                                    <button class="btn-clear" tabindex="-1" type="button"></button>
	                            </div>
	                            <div class="input-control password">
	                                    <input name="password" type="password" placeholder="">
	                                    <button class="btn-reveal" tabindex="-1" type="button"></button>
	                            </div>
	                            <input type="submit" id="btnloginsecurity" value="Login" class="span"/>
								
							</form>
                            
                        </div>
                    </div>
                </div>
            </div>

           	<div class="row bg-color-blue"> 
           		<div class="span12 newsletter_subscription">
           			Subscribe to our Newsletter <input type="email" placeholder="name@example.com"/><button>Subscribe</button>
           		</div>
           	</div>
            <div class="grid">
                <div class="row">
                    <div class="span3">
                    	<div id="footer_company_info" class="padding30">
                        	<h4>Company</h4>
                        
	                        <a href="#">About Us</a><br/>
	                        <a href="#">Services</a><br/>
	                        <a href="#">Ziksana Connect</a><br/>
	                        <a href="#">Blog</a><br/>
	                        <a href="#">Contact Us</a><br/>
                    	</div>
                    </div>

                    <div class="span6 padding30 text-center fg-color-blue">
                        <p>Find us on these social networking sites.</p>
                        <i class="icon-facebook"></i>
                        <i class="icon-twitter"></i>
                        <i class="icon-linkedin"></i>
                        <i class="icon-youtube"></i>
                        <i class="icon-feed"></i>
                    </div>

                    <div class="span3">
                    	<div id="footer_company_locations" class="padding30 text-right">
                        	<h4>Locations</h4>
                       
	                        <a href="#">New York</a><br/>
	                        <a href="#">Amsterdam</a><br/>
	                        <a href="#">Singapore</a><br/>
	                        <a href="#">Bangalore</a><br/>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
