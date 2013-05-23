
<%@ page session="true"%>

<link href="/ziksana-web/resources/css/main/styles2.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="/ziksana-web/resources/css/main/icons.css" rel="stylesheet"
	type="text/css" />
<link href="/ziksana-web/resources/css/stylesheets.css" rel="stylesheet"
	type="text/css" />
<div id="leftpanel">

	<div id="Headerborder">
		<div id="HeaderLogo" class="f-l">
			<img src="/ziksana-web/resources/images/home/logo2.png" />
		</div>
		<!--end of headerlogo-->

		<div id="Headerborder">
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
				<div id="user_menu_container">
					<div id="AccountSetting" class="f-l">
						<span><img class="Profilepic"
							src="/ziksana-web/resources/images/home/actlck.png" /></span> <span
							class="Accounthead">Account Settings</span> <img
							id="user_menu_trigger" class="Dropdown"
							src="/ziksana-web/resources/images/home/dropdown.png" />
					</div>
					<div id="user_menu">
						<!-- /ziksana-web/profile/1/manageprofile/<c:out value="${member.memberId}"/> -->
						<a
							href="/ziksana-web/profile/1/manageprofile/<c:out value="${member.memberId}"/>">Manage
							Profile</a> <a href="/ziksana-web/secure/logout">Sign Out</a>
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
						<span style="font-size: 13px; color: #6bbde8;">Home</span> <
						Create Course
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
						<div id="buildtab" class="lpboxtab1 all-box-shadow" style="">

							<div class="tbboxhead">

								<p>
									<img src="/ziksana-web/resources/images/icons/toola.png"
										class="tbboximg" /><span class="tbboxheadfnt"> Define
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

								<p>Create the course structure and course content</p>

							</div>
							<!--end of tbboxdesc  -->


						</div>
						<!--end of lptab1-->



						<div id="enrichtab" class="lpboxtab1">


							<div class="tbboxheadds">

								<p>
									<img src="/ziksana-web/resources/images/icons/review.png"
										class="tbboximgds" /><span class="tbboxheadfntds">
										Enrich </span>
								</p>

							</div>
							<!--end of tbboxhead  -->


							<div class="tbboxnumds">

								<span class="badge1" style="font-size: 15px;"> 2. </span>
							</div>
							<!--end of tbboximg  -->



							<div class="tbboxdescds">

								<p>Personalize and enrich your content</p>

							</div>
							<!--end of tbboxdesc  -->

						</div>
						<!--end of lptab1-->


						<div id="publishtab" class="lpboxtab1">

							<div class="tbboxheadds">

								<p>
									<img src="/ziksana-web/resources/images/icons/publish1.png"
										class="tbboximgds" /><span class="tbboxheadfntds">
										Publish </span>
								</p>

							</div>
							<!--end of tbboxhead  -->


							<div class="tbboxnumds">

								<span class="badge1 badge-warningds" style="font-size: 15px;">
									3. </span>
							</div>
							<!--end of tbboximg  -->

							<div class="tbboxdescds">
								<p>Publish the course created</p>

							</div>
							<!--end of tbboxdesc  -->

						</div>
						<!--end of lptab1-->



					</div>
					<!--end of lpcontainer-->

				</div>
				<!--end of uplpcontainer-->


				<div class="ClearFix"></div>

			</div>

			<div id="subnavlink">


				<!--<div class="linkinside">-->




			</div>