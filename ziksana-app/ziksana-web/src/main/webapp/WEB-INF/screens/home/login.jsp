<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div id="loginwrapper">


	<div id="contentpanel">


		<div id="headercontainer">

			<div id="HeaderLogo" class="f-l">

				<img src="/ziksana-web/resources/images/home/loginlogo.png" style="height: 80px;" />
				       
			</div>
			<!--end of headerlogo-->


			<div class="f-l" style="padding-left: 0px;">
				<p class="tbboxheadfntds"
					style="font-weight: bolder; font-size: 22px; margin-left: 90px; color: #fff;">
					Welcome to Ziksana</p>
					
			</div>
			<!--End of page-header -->
			<div class="clearfix">
				 <span style="float:right; color:#fff; font-weight:bold; padding:30px;"> <a style="color:#fff;" href="?siteLanguage=en_US">English</a>|<a style="color:#fff;"  href="?siteLanguage=fr_FR">French</a></span>
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
									<h4 class="title">Zik Power</h4>
									<!-- /Text title -->

									<!-- Text description -->
									<p class="description">
										Ziksana has given me the Power to Leave at my Pace the way<br />
										i want..
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
									<h4 class="title">Revolution</h4>
									<p class="description">
										Dreams do come true if you keep believing in yourself.<br />
										Anything is possible.
									</p>

								</div>
							</div>
						</div>
						<!--/slide -->

						<div class="slide">
							<img src="/ziksana-web/resources/images/login/foundationofeducation.jpg">
							<div class="slide_content">
								<div class="slide_content_wrap">
									<h4 class="title">Foundation For Life</h4>
									<p class="description">
										To accomplish great things, we must not only act,<br /> but
										also dream; not only plan, but also believe.
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

				<p style="font-size: 22px; color: #fff;">Sign in to your Account
				</p>

			</div>
		
			<div class="from-container" style="margin: auto; width: 290px; margin-top: 30px;">
					<div id="loginerror">
						<%
							if (request.getAttribute("loginResult") != null
									&& ((String) request.getAttribute("loginResult"))
											.equals("true")) {
						%>
						<c:if test="${accountLocked !=null}">
						<p style="color:#d14836;"><c:out value="${accountLocked}"></c:out><a href="/unsecure/admin/contactadminstrator#">&nbsp;Administrator</a></p>
						</c:if>		
						<c:if test="${accountLocked ==null}">
					
						</c:if>
						<%
							}
						%>
					</div>
				<form name="loginfrm"  method="POST" action="/ziksana-web/login" onsubmit="return(validate());">
				<div class="control-group">
					<label for="Username" class="login-label"><fmt:message key="login.username"></fmt:message>:</label>
					<div class="controls">
						<input  autofocus="autofocus" name="username" type="text" class="textBox"
							style="background-image: url(/ziksana-web/resources/images/home/logintext.png); background-position: left; background-repeat: no-repeat; padding-left: 45px; height: 30px; border-radius: 0; width: 230px"
							placeholder="Enter your Username" />
					</div>
					
					<p style="color:#d14836;" id="userIdValidation">
					<c:if test="${ not empty userIdValidationResponse}">
							<c:out value="${userIdValidationResponse}" />
					</c:if>
					</p>
				</div>

				<div class="control-group">
					<label for="Password" class="login-label"><fmt:message key="login.password"></fmt:message>:</label>
					<div class="controls">
						<input  name="password" type="Password" class="textBox"
							style="background-image: url(/ziksana-web/resources/images/home/passwordtext.png); background-position: left; background-repeat: no-repeat; padding-left: 45px; height: 30px; border-radius: 0; width: 230px;"
							placeholder="Enter your Password" />
					</div>
					<p style="color:#d14836;" id="passwordValidation">
					<c:if test="${ not empty passwordValidationResponse}">
					<c:out value="${passwordValidationResponse}"></c:out>
					</c:if>
					</p>
				</div>

				<div class="clearfix"></div>
				<a href="#linkurl"> Trouble Signing in? </a>
					<input type="submit" class="btn f-r" style="padding: 7px; margin: 5px;" value="Log in"/>
				
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
	
	if(document.loginfrm.username.value == ""){		
		 $('#userIdValidation').html("Enter User ID");
		 document.getElementById("passwordValidation").innerHTML = '';
		 document.loginfrm.username.focus();
		 return false;
		 
	}else if(document.loginfrm.password.value == ""){
		$('#passwordValidation').html("Enter Password");
		document.getElementById("userIdValidation").innerHTML = '';
			document.loginfrm.password.focus();
			return false;
		 
	}else {
		document.getElementById("userIdValidation").innerHTML = '';
		document.getElementById("passwordValidation").innerHTML = '';
		return true;
	}
	
	
	
}
    $(document).ready(function () {

        // Populate user based on cookie language
        var language = $.cookies.get('org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE');
        $('#language')
                .val(language)
                .change(function () {
                    var newHref = window.location.href;
                    if (newHref.indexOf('?siteLanguage') > 0) {
                        newHref = newHref.substring(0, newHref.indexOf('?siteLanguage'));
                    }
                    newHref += '?siteLanguage=' + $('#language').val();
                    window.location.href = newHref;
                });
    });
</script>