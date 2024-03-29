<script type='text/javascript' src='/ziksana-web/resources/js/custom/plugins.js'></script>
<script type='text/javascript' src='/ziksana-web/resources/js/lib/slider/fwslider.js'></script>
<style>
#headercontainer{margin-bottom:30px}
</style>
<div id="loginwrapper">


	<div id="contentpanel" style="margin-bottom:0px">


		<div id="headercontainer">

			<div id="HeaderLogo" class="f-l">

				<img src="/ziksana-web/resources/images/home/loginlogo.svg" style="height:80px;width:200px" /> 
				
				       
			</div>
			<!--end of headerlogo-->


			<div class="f-l" style="padding-left: 0px;">
				<p class="tbboxheadfntds" style="font-weight: bolder; font-size: 22px; margin-left: 90px; color: #fff;">
					<fmt:message key="login.welcome"></fmt:message> </p>
					
			</div>
			<!--End of page-header -->
			<div class="clearfix">
				 <span style="float:right; color:#fff; font-weight:bold; padding:30px;"> <a style="color:#fff;" href="?siteLanguage=en_US">English</a>|<a style="color:#fff;"  href="?siteLanguage=du_DU">Dutch</a></span>
			</div>


		</div>
		<!--start od the slider-->

		<div id="slider_container" class="f-l">
			<div id="slider_holder" class="sixteen columns" style="height: 100%;">

				<div id="fwslider" style="height: 100%;">
					<div class="slider_container">

						<!-- ****************** STEP 3: ADD SLIDES ****************** -->

						<!-- Duplicate to create more slides -->
						<div class="slide">

							<!-- Slide image -->
							<img src="/ziksana-web/resources/images/login/Students.jpg">
							<!-- /Slide image -->

							<!-- Texts container -->
							<div class="slide_content">
								<div class="slide_content_wrap">
									<!-- Text title -->
									<h4 class="title"><fmt:message key="login.sliderhead1"></fmt:message></h4>
									<!-- /Text title -->

									<!-- Text description -->
									<p class="description"> <fmt:message key="login.sliderdescrip1"></fmt:message>
										
									</p>
									<!-- /Text description -->
								</div>
							</div>
							<!-- /Texts container -->

						</div>
						<!-- /Duplicate to create more slides -->

						<!-- ****************** /STEP 3: ADD SLIDES ****************** -->

						<div class="slide">
							<img src="/ziksana-web/resources/images/login/Educationrevolution.jpg">
							<div class="slide_content">
								<div class="slide_content_wrap">
									<h4 class="title"><fmt:message key="login.sliderhead2"></fmt:message></h4>
									<p class="description"><fmt:message key="login.sliderdescrip2"></fmt:message>
										
									</p>

								</div>
							</div>
						</div>
						<!--/slide -->

						<div class="slide">
							<img src="/ziksana-web/resources/images/login/foundationofeducation.jpg">
							<div class="slide_content">
								<div class="slide_content_wrap">
									<h4 class="title"><fmt:message key="login.sliderhead3"></fmt:message></h4>
									<p class="description"><fmt:message key="login.sliderdescrip3"></fmt:message>
										
									</p>

								</div>
							</div>
						</div>
						<!--/slide -->

					</div>

					<div class="timers"></div>

					<div class="slidePrev">
						<span></span>
					</div>
					<div class="slideNext">
						<span></span>
					</div>

				</div>
				<!--/slider -->
				<!-- SLIDER END HERE -->


			</div>
			<!-- Sequence Slider::END-->

		</div>
		<!--end of slider container-->



		<div id="login_container" class="f-r">

			<div id="loginheader">

				<p style="font-size: 22px; color: #fff;"><fmt:message key="login.singaccount"></fmt:message> </p>

			</div>
		
			<div class="from-container" style="margin: auto; width: 290px; margin-top: 30px;">
					<div id="loginerror">
						<%
							if (request.getAttribute("loginResult") != null
									&& ((String) request.getAttribute("loginResult"))
											.equals("true")) {
						%>
						<c:if test="${ldapResponse !=null }">
							<p  style="color:#d14836;"><c:out value="${accountLocked}"></c:out></p>
							
						</c:if>
						<c:if test="${accountLocked !=null}">
						<p style="color:#d14836;"><fmt:message key="login.accountlock.message"/><a href="/unsecure/admin/contactadminstrator#">&nbsp;<fmt:message key="login.Administrator"/></a></p>
						</c:if>		
						<c:if test="${accountLocked ==null}">
					
						</c:if>
						<%
							}
						%>
					</div>
				<form name="loginfrm"  method="POST" action="/ziksana-web/login" onsubmit="return(validate());">
				<div class="control-group">
					<label for="Username" class="login-label"><fmt:message key="login.username"></fmt:message></label>
					<div class="controls">
						<input  autofocus="autofocus" name="username" type="text" class="textBox"
							style="background-image: url(/ziksana-web/resources/images/home/logintext.svg); background-position: left; background-repeat: no-repeat; padding-left: 45px; height: 30px; border-radius: 0; width: 230px"
							placeholder="<fmt:message key="login.enterusername"></fmt:message>" />
					</div>
					
					<p style="color:#d14836;" id="userIdValidation">
					<c:if test="${ not empty userIdValidationResponse}">
							<fmt:message key="login.invalidusername"/>
					</c:if>
					</p>
				</div>

				<div class="control-group">
					<label for="Password" class="login-label"><fmt:message key="login.password"></fmt:message></label>
					<div class="controls">
						<input  name="password" type="Password" class="textBox"
							style="background-image: url(/ziksana-web/resources/images/home/passwordtext.svg); background-position: left; background-repeat: no-repeat; padding-left: 45px; height: 30px; border-radius: 0; width: 230px;"
							placeholder="<fmt:message key="login.enterpassword"></fmt:message>" />
					</div>
					<p style="color:#d14836;" id="passwordValidation">
					<c:if test="${ not empty passwordValidationResponse}">
						<c:if test="$"></c:if>
							<fmt:message key="login.invalidpassword"/>
					</c:if>
					</p>
				</div>

				<div class="clearfix"></div>
				<a href="/ziksana-web/unsecure/0/userverficationpage"><fmt:message key="login.trouble"></fmt:message>  </a>
					<input type="submit" class="btn f-r" style="padding: 7px; margin: 5px;width:80px;" value="<fmt:message key="login.button"></fmt:message>"/>
				
					</form>
			</div>
			
			<!--End of form-container -->
		</div>
		<!--end of login oontainer-->

		<div class="Clearfix"></div>
	</div>
	<!--end of contentpanel-->


</div>
<!--end of loginwrapper-->

<div class="Clearfix"> </div>
<script type="text/javascript" charset="UTF-8">
function validate(){
	$(".btn").addClass("button-submit"); 
	if(document.loginfrm.username.value == ""){		
		 $('#userIdValidation').html("<fmt:message key="error.enteruser"></fmt:message>");
		 document.getElementById("passwordValidation").innerHTML = '';
		 document.loginfrm.username.focus();
		 $(".btn").removeClass("button-submit");
		 return false;
		 
	}else if(document.loginfrm.password.value == ""){
		$('#passwordValidation').html("<fmt:message key="error.enterpass"></fmt:message>");
		document.getElementById("userIdValidation").innerHTML = '';
			document.loginfrm.password.focus();
			$(".btn").removeClass("button-submit");
			return false;
	}else {
		document.getElementById("userIdValidation").innerHTML = '';
		document.getElementById("passwordValidation").innerHTML = '';
		return true;
	}
	
	
	
}

$(document).ready(function(e) {

	
	   var allcookies = document.cookie;
	   //console.log("All Cookies : " + allcookies );

	   // Get all the cookies pairs in an array
	   cookiearray  = allcookies.split(';');

	   // Now take key value pair out of this array
	  value = new Array();
	   for(var i=0; i<cookiearray.length; i++){
	      name = cookiearray[i].split('=')[0];
	      value.push(cookiearray[i].split('=')[1]);
	      
	      
	
	}
	   console.log(value);
	}); 
</script>
