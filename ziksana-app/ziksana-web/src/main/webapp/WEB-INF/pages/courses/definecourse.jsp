<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Define Course</title>
<!--Body Style sheet-->
<link href="/ziksana-web/resources/css/main/styles.css" rel="stylesheet"
	type="text/css" />
<link href="/ziksana-web/resources/css/styles.css" rel="stylesheet"
	type="text/css" />
<link href="/ziksana-web/resources/css/main/type-setting.css"
	rel="stylesheet" type="text/css" />
<link href="/ziksana-web/resources/css/main/effects.css"
	rel="stylesheet" type="text/css" />
<link href="/ziksana-web/resources/css/main/nav.css" rel="stylesheet"
	type="text/css" />
<link
	href="/ziksana-web/resources/css/common/wizard/wizardstylesheet.css"
	rel="stylesheet" type="text/css" />
<link href="/ziksana-web/resources/css/common/spinner/smartspinner.css"
	rel="stylesheet" type="text/css" />
<link
	href="/ziksana-web/resources/css/common/tags/superbly-tagfield.css"
	rel="stylesheet" type="text/css" />
<link href="/ziksana-web/resources/css/common/search/search.css"
	rel="stylesheet" type="text/css" />
<link href="/ziksana-web/resources/css/common/validation/validation.css"
	rel="stylesheet" type="text/css" />
<link href="/ziksana-web/resources/js/ui/jquery.fancybox-1.3.4.css"
	media="screen" rel="stylesheet" type="text/css" />
<link href="/ziksana-web/resources/js/tree/styles/styleTree.css"
	rel="stylesheet" type="text/css" />
<!-- for the layout of the tree -->
<!--End Body Style sheet-->
<script type="text/javascript"
	src="/ziksana-web/resources/js/ziksana/jquerylibrary/main/jquery-1.7.1.min.js"></script>
<script type="text/javascript"
	src="/ziksana-web/resources/Dynamicjsonjs/z_message.js"></script>
<script type="text/javascript"
	src="/ziksana-web/resources/Dynamicjsonjs/z_simulation_message.js"></script>
<script type="text/javascript"
	src="/ziksana-web/resources/Dynamicjsonjs/Definecoursejson.js"></script>
<script type="text/javascript"
	src="/ziksana-web/resources/Dynamicjsonjs/Addmoduledynamicjson.js"></script>
<script type="text/javascript"
	src="/ziksana-web/resources/js/ziksana/jquerylibrary/common/table/tablerow.js"></script>
<script type="text/javascript"
	src="/ziksana-web/resources/js/ziksana/jquerylibrary/common/search/search.js"></script>
<script type="text/javascript"
	src="/ziksana-web/resources/js/ziksana/ckeditor/adapters/jquery.js"></script>

<script type="text/javascript"
	src="/ziksana-web/resources/js/ziksana/ckeditor/ckeditor.js"></script>
<script type="text/javascript"
	src="/ziksana-web/resources/js/ziksana/jquerylibrary/common/spinner/smartspinner.js"></script>
<script type="text/javascript"
	src="/ziksana-web/resources/js/ziksana/coursecreation/define.js"></script>
<!-- scripts for tree -->
<script type="text/javascript"
	src="/ziksana-web/resources/js/tree/gettheme.js"></script>
<script type="text/javascript"
	src="/ziksana-web/resources/js/tree/core.js"></script>
<script type="text/javascript"
	src="/ziksana-web/resources/js/tree/buttons.js"></script>
<script type="text/javascript"
	src="/ziksana-web/resources/js/tree/scrollbar.js"></script>
<script type="text/javascript"
	src="/ziksana-web/resources/js/tree/panel.js"></script>
<script type="text/javascript"
	src="/ziksana-web/resources/js/tree/dragdrop.js"></script>
<script type="text/javascript"
	src="/ziksana-web/resources/js/tree/tree.js"></script>
<script type="text/javascript"
	src="/ziksana-web/resources/js/tree/menu.js"></script>
<script type="text/javascript"
	src="/ziksana-web/resources/js/tree/myTree.js"></script>
<script type="text/javascript"
	src="/ziksana-web/resources/js/tree/splitter.js"></script>
<script type="text/javascript"
	src="/ziksana-web/resources/js/tree/jqxexpander.js"></script>
<link rel="stylesheet" type="text/css"
	href="/ziksana-web/resources/css/common/tree/menu.css" />
<link rel="stylesheet" type="text/css"
	href="/ziksana-web/resources/css/common/tree/menu.css" />
<script
	src="/ziksana-web/resources/js/ziksana/jquerylibrary/tree/Common/common.js"></script>
<script
	src="/ziksana-web/resources/js/ziksana/jquerylibrary/tree/Common/dtree.js"></script>
<script
	src="/ziksana-web/resources/js/ziksana/jquerylibrary/tree/Menu/menu.js"></script>
<script
	src="/ziksana-web/resources/js/ziksana/jquerylibrary/tree/Menu/menu_ext.js"></script>
<script
	src="/ziksana-web/resources/js/ziksana/jquerylibrary/tree/treedata.js"></script>
<script
	src="/ziksana-web/resources/js/ziksana/jquerylibrary/tree/Common/tree_ed.js"></script>
<script
	src="/ziksana-web/resources/js/ziksana/jquerylibrary/tree/Common/dataprocessor.js"></script>
<script src="/ziksana-web/resources/js/custom/z_plugins.js"></script>
<script src="/ziksana-web/resources/js/custom/z_common.js"></script>
<!-- End tree -->
<script
	src="/ziksana-web/resources/js/ui/jquery.mousewheel-3.0.4.pack.js"
	type="text/javascript"></script>
<script src="/ziksana-web/resources/js/ui/jquery.fancybox-1.3.4.pack.js"
	type="text/javascript"></script>
<script src="/ziksana-web/resources/js/custom/libraryfunction.js"
	type="text/javascript"></script>
<script
	src="/ziksana-web/resources/js/ziksana/jquerylibrary/common/tags/superbly-tagfield.min.js"
	type="text/javascript"></script>
<script
	src="/ziksana-web/resources/js/ziksana/validation/jquery.validationen.js"
	type="text/javascript" charset="utf-8"></script>
<script
	src="/ziksana-web/resources/js/ziksana/validation/jquery.validation.js"
	type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css"
	href="/ziksana-web/resources/css/uploadify.css" />
<script type="text/javascript"
	src="/ziksana-web/resources/js/jquery.uploadify-3.1.min.js"></script>
<script type="text/javascript"
	src="/ziksana-web/resources/js/custom/jquery.uploadify-3.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(e) {
		$(".containerTableStyle").css('height', '400px');
		$(".containerTableStyle").css('overflow', 'auto');

	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".signin").click(function(e) {
			e.preventDefault();
			$("fieldset#signin_menu").toggle();
			$(".signin").toggleClass("menu-open");
		});

		$("fieldset#signin_menu").mouseup(function() {
			return false
		});
		$(document).mouseup(function(e) {
			if ($(e.target).parent("a.signin").length == 0) {
				$(".signin").removeClass("menu-open");
				$("fieldset#signin_menu").hide();
			}
		});

		//Fetch course details and populate the form
		getCourse();

	});
</script>
<style type="text/css">
#message {
	padding: 1em 0;
	color: steelblue;
}
</style>
<style>
.jqx-widget-content {
	-moz-background-clip: padding;
	background-clip: padding-box;
	-webkit-background-clip: padding-box;
	-webkit-tap-highlight-color: rgba(0, 0, 0, 0);
	font-family: Verdana, Arial, sans-serif;
	font-style: normal;
	font-size: 18px;
	border-color: rgba(199, 199, 199, 0.38);
	background: #fff;
}

.jqx-widget {
	-moz-background-clip: padding;
	background-clip: padding-box;
	-webkit-background-clip: padding-box;
	direction: ltr;
	-webkit-tap-highlight-color: rgba(0, 0, 0, 0);
	font-family: Verdana, Arial, sans-serif;
	font-style: normal;
	font-size: 19px;
}

.breadcrumb li:nth-child(1) a {
	background: #6D9EC5;
	color: #fff;
}

.breadcrumb li:nth-child(1) a:after {
	border-left-color: #6D9EC5 !important;
}

.selectedTreeRow {
	border-color: #27b;
	background: #6D9EC5;
	color: #fff;
	font-weight: bold;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	border-radius: 3px;
	padding-top: -2px;
	padding-bottom: -2px;
	padding-left: 3px;
	padding-right: 3px;
}

/*.standartTreeRow:hover
{
width:auto;
border-color:#000; background:none; color:#900;
-moz-border-radius: 3px;
-webkit-border-radius: 3px;
border-radius: 3px;
padding:-5px;
}*/
span.standartTreeRow:hover {
	background: rgba(85, 142, 187, 0.63);
	color: #fff;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	border-radius: 3px;
	padding: 3px;
}
.mnuclass {
    color: #2277BB;
    font-family: verdana;
    font-size: 12px;
    font-weight: normal;
    text-decoration: none;
}
</style>
</head>

<body onLoad="self.scrollTo(0,0)">

	<div id="wrapper">
		<!--Header Container-->
		<!--Header Container-->
		<p>
			<a><img data-launcher
				data-launchpage="/ziksana-web/secure/launcher"
				src="/ziksana-web/resources/images/ziksana_button_logo.png"
				width=120px height=120px
				style="position: absolute; top: 3px; left: 30px; margin-left: 0px;" /></a>
		</p>
		<header class="bottom-box-shadow bckground-wihte">

			<div class="topheader">
				<!--logo container-->

				<!--end logo container-->


			</div>
			<nav>
				<div class="menu" style="margin-left: 0px;">
					<ul>
						<li><a href="/ziksana-web//secure/educatordashboard">My
								Home</a>
							<div class="nav-line"></div></li>
						<li><a href="/ziksana-web//secure/showMyPrograms"
							class="current">My Programs</a>
							<div class="nav-line"></div></li>
						<li><a>My Students</a>
							<div class="nav-line"></div></li>
						<li><a style="margin-left: -10px;">My Locker</a></li>
					</ul>
				</div>

				<div class="status-container">

					<div id="status-icons"
						class="bottom-box-shadow two-bottom-rounded-box ">

						<ul>
							<li><a class="email-icon" rel="tipsy" title="3 New Messages"><span
									class="wite-title">3</span></a></li>
							<li><a class="peoples-icon orange-bc" rel="tipsy"
								title="5 Contact requests"><span class="wite-title">5</span></a></li>
							<li><a class="alart-icon orange-bc" rel="tipsy"
								title="1 Connect Request"><span class="wite-title">1</span></a></li>
							<li><a class="announcement-icon orange-bc" rel="tipsy"
								title="3 New Announcement"><span class="wite-title">3</span></a></li>
							<li><a class=" amount-icon blue-bc" rel="tipsy"
								title="Ziks available"><span class="wite-title">355500</span></a></li>

						</ul>
						<div></div>
					</div>
					<div class="account-container two-bottom-rounded-box">
						<div class="container">
							<div class="topnav">
								<a class="signin wite bold"><span
									class="text-size-px12 wite bold">My Account</span></a>
							</div>
							<fieldset id="signin_menu">
								<ul>
									<li><a>Preferences</a></li>
									<li><a>Privacy</a></li>
									<li><a href="/ziksana-web/secure/logout">Sign Out</a></li>
								</ul>
							</fieldset>
						</div>
					</div>
				</div>
			</nav>
		</header>
		<!--End Header Container-->
		<!--End Header Container-->
		<div class="sub-nav">
			<div class="f-l">
				<strong class="text-size-px12 font-Signika blue"><a
					href="/ziksana-web/secure/showMyPrograms">My Courses </a> </strong>|<strong
					class="light-gray text-size-px12 font-Signika">Create New Course </strong>
			</div>
			<div class="f-r">
				<a href="#" class="mnuclass" > Manage </a> | <a class="mnuclass"  href="#"> Publish</a>
				<a class="light-blue"><img width="12" height="12" alt="add more" src="/ziksana-web/resources/images/plus.png">
				</a>
			</div>
		</div>
		<!--Main Content-->

		<section>
			<div class="section">
				<div class="col-create" style="width: 1000px;">
					<div class="for-rounded-box  all-box-shadow white-bg">
						<!--Wizard start-->
						<div id="page-wrap">

							<ul class="breadcrumb" style="padding: 1px;">


								<li><a href="/ziksana-web/secure/createcourse/${courseId}"
									style="width: 100px; text-align: center;"><span
										class="bcumb">1.</span> Define Course</a></li>
								<li><a
									href="/ziksana-web/secure/associatecontent/${courseId}"
									style="text-align: center;">2. Organize Content</a></li>
								<li><a href="/ziksana-web/secure/enrichcontent/${courseId}"
									style="width: 124px; text-align: center;">3. Enrich Content</a></li>
								<li><a style="width: 130px; text-align: center;">4.
										Define Assignment</a></li>
								<li><a style="text-align: center;">5. Define Planner</a></li>
								<li><a style="text-align: center;">6. Define Playbook</a></li>
								<li><a style="width: 120px; text-align: center;">7.
										Socialize Course</a></li>
								<li></li>
								<!--<li><a href="#">Hidden</a></li>-->
							</ul>


						</div>
						<!--Wizard end  -->

						<!--start of first Tab -->


						<div class="definecontainer" id="definetab">


							<!--<a class="btn btn-info f-r saveTop"  id="topSave" style="margin-right:-200px;" >Save and Continue</a>-->
							<form id="DegineCourse" class="form-horizontal formular"
								method="post">
								<div id="EditCourseDetails" class="ecd" style="height: 15px;">
									<!--<input type="button" class="btn btn-info f-r"
										id="Editcoursedtl1" value="Edit Course Details"
										onClick="getCourse(); return false;"
										style="display:none; margin-right: -257px; margin-bottom: 4px; clear: both; display: none;">-->
								</div>

								<br />

								<div class="definehelp"
									style="width: 900px; font-family: Helvetica; font-weight: bold; color: #125F92;">
									<img src="/ziksana-web/resources/images/icons/helpicon.png"
										align="left"
										style="padding-left: 5px; margin-right: 4px; margin-top: -8px;" />Provide
									Course Details
								</div>

								<!----------------- start of first container --------------->
								<div class="_coursename">
									<div class="control-group">
										<input type="hidden" id="courseid" value="${courseId}" />
										 <label
											class="control-label labelclass " for="CourseName"
											style="margin-top: -4px; font-weight: bold;">Course
											Name :</label>
										<div class="controls">
											<input type="text" autofocus
												class="defaultvaluem treeRoot validate[required]"
												id="defaultvalue"
												style="width: 240px; margin-left: 10px; color: #666;"
												placeholder="Specify the Course Name" />
										</div>

										<br /> <label for="coursedescription" class="labelclass"
											style="font-weight: bold;"><b>Course Description
												:</b></label> <a class="f-r _plainText" href="#" onClick="plainText()"
											style="text-decoration: none;">Plain Text Editor</a> <a
											class="f-r _richText" id="rich_text_editor" href="#" onClick="richText()"
											style="text-decoration: none;">Rich Text Editor</a>

										<textarea placeholder="Describe the Course being created" cols="124" rows="8" id="Cdescription" class="_plainTextShow defaultvaluem labelclass" style="width: 880px; color: #666;"></textarea>
										<br />
										<div class="_richTextShow">
											<textarea placeholder="Describe the Course being created" id="Cdescriptionrte" name="editor2" class="defaultvalue _focus"></textarea>
										</div>
										<script type="text/javascript">
											CKEDITOR.replace('Cdescriptionrte');
										</script>

									</div>
									<!-- end of coursename--->
								</div>
								<!-- end of control group--->

								<!----------------- start of second container --------------->
								<div class="_secondcontainer">
									<div class="control-group">
										<div>
											<label class="labelclass" style="font-weight: bold;">
												Course Area : </label> <label class="labelclass"
												style="margin-left: 120px; font-weight: bold;">
												Course Subject: </label> <label class="labelclass"
												style="margin-left: 100px; font-weight: bold;">
												Course Topic: </label>
										</div>

										<div class="moduleselection">
											<select name="Careaddl" id="Careaddl"
												class="defaultvalue labelclass"
												style="margin-right: 15px; width: 200px;">
												<!--  <option value="Select Subject Area">Select Subject
													Area</option> -->


											</select> <select name="Csubjectddl" id="Csubjectddl"
												class="defaultvalue labelclass"
												style="margin-right: 15px; width: 200px;">
												<option value="Select Subject">Select Subject</option>

											</select> <select name="Ctopicddl" id="Ctopicddl"
												class="defaultvalue labelclass " style="width: 200px;">
												<option value="Select Topic">Select Topic</option>

											</select>
										</div>
										<!-- end of moduleselection--->

										<div class="coursetags">
											<br /> 
											<label class="labelclass"
												for="coursetags"
												style="margin-top: -2px; font-weight: bold;">Specify
												any tags : </label> <input id="Ctagfield_e" type="text"
												style="margin-left: 20px;width:250px;height:25px;"></input> <br /> <br />
										</div>
										<!-- end of coursetags--->

										<div class="coursecredits">
											<label for="coursetags" class="labelclass"
												style="font-weight: bold;">Specify Course Credits :</label>
											<input type="text" id="Credits" class="smartspinner "
												style="margin-left: 18px;" />
											<script type="text/javascript"
												src="/ziksana-web/resources/js/ziksana/jquerylibrary/common/spinner/smartspinner.js"></script>
											<script type="text/javascript">
												$(document)
														.ready(
																function() {

																	var s = $(
																			'#Credits')
																			.spinit(
																					{
																						height : 20,
																						width : 30,
																						min : null,
																						placeholder : null,
																						initValue : null,
																						max : 20,
																					});

																});
											</script>
											<label for="coursetags" class="labelclass"
												style="margin-left: 20px; font-weight: bold;">Specify
												Course Extra Credits :</label> <input type="text" id="ExtraCredits"
												class="defaultvalue validate[required]"
												style="width: 30px; margin-left: 10px;" />
											<script type="text/javascript">
												$(document)
														.ready(
																function() {
																	var s = $(
																			'#ExtraCredits')
																			.spinit(
																					{
																						height : 20,
																						width : 30,
																						min : null,
																						initValue : null,
																						max : 20,
																					});

																});
											</script>
										</div>
										<!-- end of coursecredits--->

										<div class="courseduration">
											<br /> <label for="coursetags" class="labelclass"
												style="font-weight: bold;">Specify Course Duration :</label>
											<input type="text" id="Duration"
												style="width: 30px; margin-left: 9px;"
												class="defaultvalue validate[required]" />
											<script type="text/javascript">
												$(document)
														.ready(
																function() {
																	var s = $(
																			'#Duration')
																			.spinit(
																					{
																						height : 20,
																						width : 30,
																						min : null,
																						initValue : null,
																						max : 20,
																					});

																});
											</script>
											<select name="SelectArea" id="Cdurationtype"
												class="defaultvalue" style="margin-left: 20px;">
												<option value="1">Weeks</option>
												<option value="2">Months</option>
												<option value="3">Days</option>

											</select>

										</div>
										<!-- end of courseduration--->

										<!--  <div class="addinformation">
											<a class="lbx-addnew" id="_addNewInfo"
												href="/ziksana-web/secure/getAddnlInfo">Add New
												Information </a>
										</div> -->
									</div>
									<!-- end of secondcontainer--->
								</div>
								<!-- end of control group--->


								<!----------------- start of third container --------------->
								<div class="_thirdcontainer">
									<!-- <div class="contentsecurity">

										<img id="aSide"
											src="/ziksana-web/resources/images/tipsy-east.gif"
											align="left"
											style="height: 10px; width: 10px; margin-top: 5px; cursor: pointer;"
											title="View Requirements" /> <img id="aDown"
											src="/ziksana-web/resources/images/tipsy-south.gif"
											align="left"
											style="height: 10px; width: 10px; margin-top: 5px; cursor: pointer;"
											title="Hide Requirements" />
										<p class="labelclass"
											style="margin-left: 15px; font-weight: bold;">Define
											Video Content Security requirements</p>
										<br>
										<div id="showSecurity">
											<input type="checkbox" name="Chksecuritylogo"
												id="Chksecuritylogo" class="labelclass"
												value="Institution Logo" style="margin-left: 20px;" /> <span
												class="labelclass" style="padding-left: 5px;">Institution
												Logo? </span> <input type="checkbox" class="labelclass"
												name="Chksecuritysignature" id="Chksecuritysignature"
												value="your Signature" style="margin-left: 20px;" /><span
												class="labelclass" style="padding-left: 5px;">Your
												Signature? </span> <input type="checkbox"
												name="Chksecuritywatermark" id="Chksecuritywatermark"
												class="labelclass" value="Floating Watermark"
												style="margin-left: 20px;"><span class="labelclass"
												id="watermarktxt" style="padding-left: 5px;">Floating
												Watermark? </span></input>

										</div>

									</div> -->
									<!-- end of contentsecurty--->

									<div class="associateimage" style="margin-top: 30px;">

										<p class="labelclass" style="font-weight: bold;">Associate
											an Image for your Course</p>
										<br /> <img
											src="/ziksana-web/resources/images/modelthinking.png"
											alt="Modelthinking" width="94" height="94" border="3"
											style="border: 2px solid #ccc;" /> <input
											readonly="readonly" type="hidden" id="Cimageupl"
											style="margin-left: 20px;" />
										<!--  <a href="#linkurl"
											id="cancellink"> <img
											src="/ziksana-web/resources/images/delete.jpg" />Cancel</a>-->

										<div id="thubmnail_upload_message"></div>
										<div id="loaderText"></div>
										<input type="file" name="thumbnail_image_file_upload"
											id="thumbnail_image_file_upload" />
										<div id="status"></div>
										<script type="text/javascript">
											$(function() {
												$(
														'#thumbnail_image_file_upload')
														.uploadify(
																{
																	'swf' : '/ziksana-web/resources/swf/uploadify.swf',
																	'queueSizeLimit' : 1,
																	'successTimeout' : 350,
																	'uploader' : '${ms.uploadScript}',
																	'fileTypeExts' : '*.gif; *.jpg; *.jpeg; *.png',
																	'fileSizeLimit' : '10024KB',
																	'onUploadStart' : function(
																			file) {
																		$(
																				'#sbtvalidation')
																				.attr(
																						'disabled',
																						'disabled');
																	},
																	//'debug': true,
																	//'scriptData':{'contentId': $('#learningContentId').val().split('_')[1]},
																	'onUploadSuccess' : function(
																			file,
																			data,
																			response) {
																		json_string = data;
																		data_object = $
																				.parseJSON(json_string);
																		console
																				.log(data_object);
																		if (data_object.Uploaded == 'true') {
																			$(
																					'#Cimageupl')
																					.val(
																							data_object.ContentPath);
																			$(
																					'#thubmnail_upload_message')
																					.html(
																							'Thumbnail Image Upload Successful! ');

																		} else { //there is an error in the upload process

																			$(
																					'#message')
																					.html(
																							data_object.message);
																		}
																		$(
																				'#sbtvalidation')
																				.removeAttr(
																						'disabled'); //enable submit button

																	}
																// Your options here
																});
											});
										</script>


									</div>
									<!-- end of associateimage--->

								</div>
								<!-- end of third container--->

								<input type="submit" class="btn btn-info f-r" id="sbtvalidation"
									value="Submit" onClick="createCourse(); return false;"
									style="margin-right: -200px;">
								<!-- <a href="/ziksana-web/secure/createmodule/${courseId}"
									style="float:right; margin-bottom: 20px; margin-top: 2px; display: inline-block;right: -118px;position: relative;"
									class="btn btn-info">Save and Continue</a> -->

							</form>


							<br> <br>


							<style>
#splitter {
	width: 975px;
	height: auto;
}

#jqxTree {
	height: auto;
	width: auto;
}
</style>

							<div id="treeHideShow"
								style="font-size: 10px; margin-bottom: 10px;">

								<p class="definehelp all all-box-shadow"
									style="width: 965px; padding: 5px; font-family: Helvetica; font-weight: bold; font-size: 18px; color: #125F92; height: 30px;">
									<img src="/ziksana-web/resources/images/icons/helpicon.png"
										align="left"
										style="padding-left: 5px; margin-right: 4px; line-height: 28px;" /><b>Right
										Click over the Tree Node to further Define the Course. </b>
								</p>


								<div id="splitter" style='clear: both;'>

									<!-- Start of Tree -->
									<div id="treeboxbox_tree" style="padding: 5px;"
										class="dhtmlxTree"
										setImagePath="../resourcse/js/ziksana/jquerylibrary/tree/treeimages/csh_bluebooks/">

									</div>


									<!-- End of Tree -->

									<div id="ContentPanel2"
										style="font-size: 11px; background-image: none; margin-left: 25px;">
										<!-- Start of Default Instruction -->

										<div id="instruction" style="padding: 10px;">
											<img src="/ziksana-web/resources/images/instruction.png"
												class="all-box-shadow" alt="instructions"
												title="Key-Board instruction" width="720"
												style="border: 1px solid #ccc; padding: 5px; border-radius: 7px; border: 1px solid #ccc;">
										</div>

										<!-- End of Default Instruction  -->
										<!-- Add Module Container -->

										<!-- start of search and associate content -->


										<!-- End of search and associate content -->

										<!-- Start of Third Container -->


										<!-- end of definecontainer--->



										<!-- End of Third Container -->

										<!-- Start of Viewmodelthinking -->


										<!-- End of viewmodelthinking -->

										<!-- start view modelthinking 2 -->


										<!-- End of viewmodelthinking -->

										<!-- End of view modelthinkin 2 -->





									</div>
									<!-- Content Panel End -->


								</div>
								<!-- end of definecontainer--->



								<!------------------------------- end of first Tab ---------------------------------------------->

								<!--End Center Container-->

							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!--End Main Content-->
		<!--Current Progress-->
		<div class="col border-top">
			<div class="collapse">
				<h3 class="border-left border-right border-top">Your current
					progress [ Starting ... ]</h3>
				<div>
					<p class="caption text-size-px18">Your progress this session...
					</p>
				</div>
			</div>
		</div>

		<script>
			$(".collapse").collapse({
				show : function() {
					this.animate({
						opacity : 'toggle',
						height : 'toggle'
					}, 300);
				},
				hide : function() {

					this.animate({
						opacity : 'toggle',
						height : 'toggle'
					}, 300);
				}
			});

			//rating-star	
			$('#edu-star').raty({

				click : function(score, evt) {
					$(this).fadeOut(function() {
						$(this).fadeIn();
					});
				},
				targetKeep : true,
				path : 'images/img/',
				score : 4,
				cancel : true
			});
		</script>


		<!--End Current Progress-->
		<!--Footer Container-->
		<footer> </footer>
		<!--End Footer Container-->
	</div>
</body>
</html>