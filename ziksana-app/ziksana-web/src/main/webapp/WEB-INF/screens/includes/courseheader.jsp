
<%@ page session="true"%>


<div id="leftpanel">

	<div id="Headerborder" class="metrouicss">
			<div id="HeaderLogo" class="f-l">

				<img src="/ziksana-web/resources/images/home/logo2.png" />

			</div>
			<!--end of headerlogo-->

			<div id="HeaderNav" class="f-r">
				<div style="float: left; width: 70%">
					<div id="ProfilePic" class="f-r ">
						<img src="${ms.url}<c:out value="${member.picturePath}"/>"
							align="middle" class=" rounded_image Profile">

						<c:out value="${member.firstName}" />
						<c:out value="${member.lastName}" />
					</div>
				</div>
				<div id="user_menu_container" >
<div id="AccountSetting" class="f-l"><span><img class="Profilepic" src="/ziksana-web/resources/images/home/actlck.png"/></span> 

<span class="Accounthead"><fmt:message key="Account.Settings"></fmt:message></span> <img id="user_menu_trigger" class="Dropdown" src="/ziksana-web/resources/images/home/dropdown.png"/> </div>    
<div id="user_menu">
<!-- /ziksana-web/profile/1/manageprofile/<c:out value="${member.memberId}"/> -->
	<a href="/ziksana-web/profile/1/manageprofile/<c:out value="${member.memberId}"/>"><fmt:message key="Manage.profile"></fmt:message></a>
	<a href="/ziksana-web/secure/logout"><fmt:message key="signout"></fmt:message></a>
</div>   
</div> 


			</div>
			<!--end of HeaderNav-->
			<div class="Clearfix"></div>
		</div>
		<div id="Zikbreadcrumbback" style="margin-left: 20px;">

			<div class="Zikbreadcrumb f-l">

				<div class="fifteen columns" id="page-title">
					<a class="back" href="javascript:history.back()"></a>
					<p class="page-title">
						<span style="color: #6bbde8;"> <fmt:message key="home.hometext"/></span> <
						<fmt:message key="home.createcourse"/>
					</p>
				</div>

			</div>
			<!--end of breadcrumb-->
		</div>
		<div class="Clearfix"></div>




		<div id="contentpanel">

			<div id="Wizard_header">

				<div id="uplpcontainer" class="all-box-shadow">



					<div id="lpcontainer">

						<div class="bordertop"></div>
						<!--end of bordertop-->
					
	 					<a class="no_text_decoration" href="/ziksana-web/zcourse/createcourse" >	
						<div id="buildtab" class="lpboxtab1 all-box-shadow" style="">

							<div class="tbboxhead">

								<p>
									<img src="/ziksana-web/resources/images/icons/toola.png"
										class="tbboximg" /><span class="tbboxheadfnt"> <fmt:message key="course.Define"/>
									</span>
								</p>

							</div>
							<!--end of tbboxhead  -->

							<div class="tbboxnum">

								<span class="badge1 badge-warning" style="font-size: 15px;">
									1. </span>
							</div>
							<!--end of tbboximg  -->

							<div class="tbboxdesc">

								<p><fmt:message key="course.structre.content"/></p>

							</div>
							<!--end of tbboxdesc  -->


						</div>
						<!--end of lptab1 -->
					</a>
				<c:if test="${courseId != null}">
							<c:if test="${fn:contains(courseId, 'COURSE')}">
								<c:set var="annotate" value="${fn:split(courseId, '_')}" />
	 							<a class="no_text_decoration" href="/ziksana-web/zcourse/1/annotatecontents/${annotate[1]}" >
							</c:if>
							<c:if test="${not fn:contains(courseId, 'COURSE')}">
	 							<a class="no_text_decoration" href="/ziksana-web/zcourse/1/annotatecontents/${courseId}" >
	 						</c:if>	

						<div id="enrichtab" class="lpboxtab1">


							<div class="tbboxheadds">

								<p>
									<img src="/ziksana-web/resources/images/icons/review.png"
										class="tbboximgds" /><span class="tbboxheadfntds">
										<fmt:message key="course.Enhance"/> </span>
								</p>

							</div>
							<!--end of tbboxhead  -->


							<div class="tbboxnumds">

								<span class="badge1" style="font-size: 15px;"> 2. </span>
							</div>
							<!--end of tbboximg  -->



							<div class="tbboxdescds">

								<p><fmt:message key="course.personalize"/></p>

							</div>
							<!--end of tbboxdesc  -->

						</div>
					</c:if>
					<c:if test="${courseId == null}">
					<div id="enrichtab" class="lpboxtab1">


							<div class="tbboxheadds">

								<p>
									<img src="/ziksana-web/resources/images/icons/review.png"
										class="tbboximgds" /><span class="tbboxheadfntds">
										<fmt:message key="course.Enhance"/> </span>
								</p>

							</div>
							<!--end of tbboxhead  -->


							<div class="tbboxnumds">

								<span class="badge1" style="font-size: 15px;"> 2. </span>
							</div>
							<!--end of tbboximg  -->



							<div class="tbboxdescds">

								<p><fmt:message key="course.personalize"/></p>

							</div>
							<!--end of tbboxdesc  -->

						</div>
					</c:if>
					
						<!--end of lptab1-->
						<c:if test="${courseId != null}">
							<c:if test="${fn:contains(courseId, 'COURSE')}">
								<c:set var="id" value="${fn:split(courseId, '_')}" />
	 							<a class="no_text_decoration" href="/ziksana-web/zcourse/1/planner/${id[1]}" >
							</c:if>
							<c:if test="${not fn:contains(courseId, 'COURSE')}">
	 							<a class="no_text_decoration" href="/ziksana-web/zcourse/1/planner/${courseId}" >
	 						</c:if>	
						<div id="publishtab" class="lpboxtab1">

							<div class="tbboxheadds">
							
							
								<p>
									<img src="/ziksana-web/resources/images/icons/publish1.png"
										class="tbboximgds" />
										
										<span class="tbboxheadfntpublish">
											<fmt:message key="course.Publish"/> 
										</span>
										
								</p>
							</div>
							<!--end of tbboxhead  -->
							<div class="tbboxnumds">

								<span class="badge1 badge-warningds" style="font-size: 15px;">
									3. </span>
							</div>
							<!--end of tbboximg  -->

							<div class="tbboxdescpub">
								<p><fmt:message key="course.publish.created"/> </p>

							</div>
							<!--end of tbboxdesc  -->

						</div>
						</a>
						<!--end of lptab1-->
						</c:if>
						<c:if test="${courseId == null}">
							<c:set var="courseId" value="${fn:split(courseId, '_')}" />
 							
						<div id="publishtab" class="lpboxtab1">

							<div class="tbboxheadds">
							
							
								<p>
									<img src="/ziksana-web/resources/images/icons/publish1.png"
										class="tbboximgds" />
										
										<span class="tbboxheadfntpublish">
											<fmt:message key="course.Publish"/> 
										</span>
										
								</p>
							</div>
							<!--end of tbboxhead  -->
							<div class="tbboxnumds">

								<span class="badge1 badge-warningds" style="font-size: 15px;">
									3. </span>
							</div>
							<!--end of tbboximg  -->

							<div class="tbboxdescpub">
								<p><fmt:message key="course.publish.created"/> </p>

							</div>
							<!--end of tbboxdesc  -->

						</div>
						<!--end of lptab1-->
						</c:if>


					</div>
					<!--end of lpcontainer-->

				</div>
				<!--end of uplpcontainer-->


				<div class="ClearFix"></div>

			</div>

			<div id="subnavlink">


				<!--<div class="linkinside">-->




			</div>
<script type="text/javascript">
function plannerPage(courseId){
	var str_array = courseId.split('_');
	
	window.location.href = "/ziksana-web/zcourse/1/planner"+courseId+"";
}
</script>