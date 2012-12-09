
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="createcourselink" value="/secure/createcourse" />
<c:url var="associatecontentlink" value="/secure/associatecontent" />
<c:url var="enrichcontentlink" value="/secure/enrichcontent" />
<c:url var="assignmentlink" value="/secure/createassignment" />

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Define Course tests</title>
<!--Body Style sheet-->
<link rel="stylesheet" type="text/css"
	href="../resources/css/dropdown.css" />
<link href="../resources/css/styles.css" rel="stylesheet"
	type="text/css">
<link href="../resources/css/type-setting.css" rel="stylesheet"
	type="text/css">
<link href="../resources/css/effects.css" rel="stylesheet"
	type="text/css">
<link href="../resources/css/nav.css" rel="stylesheet" type="text/css">
<link href="../resources/css/wizard/wizardstylesheet.css"
	rel="stylesheet" type="text/css">
<link href="../resources/css/spinner/smartspinner.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet"
	href="../resources/css/chosen/superbly-tagfield.css" />
<link rel='stylesheet' type='text/css' href="../resources/css/nav.css" />
<link href="../resources/css/search.css" rel="stylesheet"
	type="text/css">
<!--End Body Style sheet-->

<script type="text/javascript" src="../resources/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="../resources/js/search.js"></script>
<script type="text/javascript"
	src="../resources/js/ckeditor/adapters/jquery.js"></script>
<script type="text/javascript"
	src="../resources/js/ckeditor/ckeditor.js"></script>
<script src="../resources/js/custom.js" type="text/javascript"></script>
<script type='text/javascript'
	src="../resources/js/autocomplete/jquery-ui-1.8.23.custom.min.js"></script>
<script type="text/javascript"
	src="../resources/js/spinner/smartspinner.js"></script>

<script type="text/javascript" src="../resources/js/tablerow.js"></script>
<!-- css for tree -->
<link rel="stylesheet"
	href="../../resources/js/tree/styles/styleTree.css" type="text/css" />
<!-- for the layout of the tree -->

<!-- scripts for tree -->
<script type="text/javascript" src="../resources/js/tree/gettheme.js"></script>
<script type="text/javascript"
	src="../resources/js/tree/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="../resources/js/tree/core.js"></script>
<script type="text/javascript" src="../resources/js/tree/buttons.js"></script>
<script type="text/javascript" src="../resources/js/tree/scrollbar.js"></script>
<script type="text/javascript" src="../resources/js/tree/panel.js"></script>
<script type="text/javascript" src="../resources/js/tree/dragdrop.js"></script>
<script type="text/javascript" src="../resources/js/tree/tree.js"></script>
<script type="text/javascript" src="../resources/js/tree/menu.js"></script>
<script type="text/javascript" src="../resources/js/tree/myTree.js"></script>
<script type="text/javascript" src="../resources/js/tree/splitter.js"></script>
<script type="text/javascript" src="../resources/js/tree/jqxexpander.js"></script>
<!-- End tree -->
<link rel="stylesheet" type="text/css"
	href="../resources/js/ui/jquery.fancybox-1.3.4.css" media="screen" />
<script type="text/javascript"
	src="../resources/js/ui/jquery.mousewheel-3.0.4.pack.js"></script>
<script type="text/javascript"
	src="../resources/js/ui/jquery.fancybox-1.3.4.pack.js"></script>
<script type='text/javascript'
	src="../resources/js/custom/libraryfunction.js"></script>
<script type="text/javascript" src="../resources/js/custom/RTE.js"></script>
<!-- scripts for number spinner -->
<script type="text/javascript"
	src="../resources/js/chosen/superbly-tagfield.min.js"></script>

<script src="../resources/js/dropdown/hover-dropdown.min.js"></script>
<script src="../resources/js/dropdown/tiwtter.js"></script>
<script>
	$(document).ready(function() {
		$('.js-activated').dropdownHover();
	});
</script>

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
	background: hsla(34, 85%, 25%, 1);
	color: #ccc;
	text-shadow: 1px 1px 2px rgba(34, 29, 29, 1);
}

.breadcrumb li:nth-child(1) a:after {
	border-left-color: hsla(34, 85%, 25%, 1) !important;
}
</style>


</head>

<body onLoad="self.scrollTo(0,0)">

	<div id="wrapper">
		<!--Header Container-->
		<header class="bottom-box-shadow bckground-wihte">
			<div class="topheader">
				<!--logo container-->
				<div class="logo">
					<p>
						<a href="#"><img height="73" width="189"
							src="../resources/../resources/images/logo.jpg" /></a>
					</p>
				</div>
				<!--end logo container-->
				<div class="status-container">
					<div id="status-icons"
						class="bottom-box-shadow two-bottom-rounded-box">
						<ul>
							<li><a href="#" class="email-icon" rel="tipsy"
								title="3 New Messages"><span class="wite-title">3</span></a></li>
							<li><a href="#" class="peoples-icon orange-bc" rel="tipsy"
								title="5 Contact requests"><span class="wite-title">5</span></a></li>
							<li><a href="#" class="alart-icon orange-bc" rel="tipsy"
								title="1 Connect Request"><span class="wite-title">1</span></a></li>
							<li><a href="#" class="announcement-icon orange-bc"
								rel="tipsy" title="3 New Announcement"><span
									class="wite-title">3</span></a></li>
							<li><a href="#" class=" amount-icon blue-bc" rel="tipsy"
								title="Ziks available"><span class="wite-title">355500</span></a></li>

						</ul>
						<div></div>
					</div>
					<div class="account-container two-bottom-rounded-box">
						<div class="container">
							<div class="topnav">
								<a href="#" class="signin wite bold"><span
									class="text-size-px12 wite bold">My Account</span></a>
							</div>
							<fieldset id="signin_menu">
								<ul>
									<li><a href="#">Preferences</a></li>
									<li><a href="#">Privacy</a></li>
									<li><a href="#">Sign Out</a></li>
								</ul>
							</fieldset>
						</div>
					</div>
				</div>
			</div>
			<nav>
				<!--menu-->
				<div class="menu">
					<ul>
						<li><a href="educatorHomepage.html" class="current">My
								Home</a>
							<div class="nav-line"></div></li>
						<li><a href="myprograms.html">My Programs</a>
							<div class="nav-line"></div></li>
						<li><a href="#">My Students</a>
							<div class="nav-line"></div></li>
						<li><a href="#" style="margin-left: -10px;">My Locker</a></li>
					</ul>
				</div>
				<!--End menu-->
				<div class="searchpanel">
					<div>
						<form id="ui_element" class="sb_wrapper">
							<span class="sb_down"></span> <input type="text" name="search"
								id="search" placeholder="Search..." title="Search..."
								autosave="unique"
								class="two-left-rounded-box two-right-rounded-box"> <input
								id="submit" type="submit" value="Submit">

							<ul class="sb_dropdown" style="display: none;">
								<li class="sb_filter">Filter your search</li>
								<li><input type="checkbox" /><label for="all"><strong>All
											Categories</strong></label></li>
								<li><input type="checkbox" /><label for="Automotive">Students</label></li>
								<li><input type="checkbox" /><label for="Baby">Locker</label></li>
								<li><input type="checkbox" /><label for="Beauty">Program</label></li>

							</ul>
						</form>
					</div>
				</div>
				<div class="searchoptions">
					<ul class="dropdown nav">
						<li><a href="#linkurl" title="Help"><span
								class="srch-op-a"></span></a></li>


						<li class="dropdown"><a href="#linkurl"
							class="dropdown-toggle js-activated" title="ZInformation"><span
								class="srch-op-b"></span></a>
							<ul class="dropdown-menu">
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zMessage.html">zAnnouncements</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zMeetings.html">zNews</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="">zPoll</a></li>

							</ul></li>

						<li><a href="#" title="ZGoods"><span class="srch-op-e">
							</span></a></li>

						<li class="dropdown"><a href="#linkurl"
							class="dropdown-toggle js-activated" title="ToolZ"><span
								class="srch-op-d"> </span></a>
							<ul class="dropdown-menu">
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zMessage.html">zMessage</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zMeetings.html">zMeetings</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="">zAlerts</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="#linkurl">To Do list</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="#linkurl">zSteps</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zGroups.html">zGroups</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zCollege.html">zCollage</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zDelegate.html">zDelegate</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="#linkurl">zQuestion Bank</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zLibrary.html">zLibrary</a></li>
								<li style="float: left;"><a tabindex="-1" href="#linkurl">zHealthcheck</a></li>



							</ul></li>
						<li class="dropdown"><a href="#linkurl"
							class="dropdown-toggle js-activated" title="Zeni"><span
								class="srch-op-c"> </span></a>
							<ul class="dropdown-menu">
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zRecommend.html">zRecommends</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zReward.html">Rewardz</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zStats.html">zStats</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zAsk.html">Askz</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zCards.html">zcard</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zStrate.html">Stratez</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zClass.html">zClass</a></li>
							</ul></li>

					</ul>
				</div>
			</nav>
		</header>
		<!--End Header Container-->
		<div class="sub-nav">
			<div class="f-l">
				<strong class="text-size-px12 font-Signika blue"><a
					href="#">My Courses </a> > </strong><strong
					class="light-gray text-size-px12">Create New Course </strong>
			</div>
			<div class="f-r">
				<strong class="text-size-px14 light-gray"><a
					href="publish.html">Publish</a> | <a href="defineengagement.html">Manage</a></strong><a
					class="light-blue" href="#"><img width="12" height="12"
					alt="add more" src="../resources/images/plus.png"> </a>
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
								<li><a href="${createcourselink}"
									style="width: 100px; text-align: center;"><span
										class="bcumb">1.</span> Define Course</a></li>
								<li><a href="${associatecontentlink}"
									style="text-align: center;">2. Associate Content</a></li>
								<li><a href="${enrichcontentlink}"
									style="width: 124px; text-align: center;">3. Enrich Content</a></li>
								<li><a href="${assignmentlink}"
									style="width: 130px; text-align: center;">4. Define
										Assignment</a></li>
								<li><a href="modelthinkingdefineplanner.html"
									style="text-align: center;">5. Define Planner</a></li>
								<li><a href="modelthinkingdefineplaybook.html"
									style="text-align: center;">6. Define Playbook</a></li>
								<li><a href="modelthinkingdefinesocialize.html"
									style="width: 120px; text-align: center;">7. Socialize
										Course</a></li>
								<li></li>
								<!--<li><a href="#">Hidden</a></li>-->
							</ul>


						</div>
						<!--Wizard end  -->

						<!--start of first Tab -->


						<div class="definecontainer" id="definetab">

							<!--<a class="btn btn-info f-r saveTop"  id="topSave" style="margin-right:-200px;" >Save and Continue</a>-->
							<form id="DegineCourse" class="form-horizontal">

								<br />

								<div class="definehelp"
									style="width: 900px; font-family: Helvetica; font-weight: bold; color: #125F92;">
									<img src="../resources/images/icons/helpicon.png" align="left"
										style="padding-left: 5px; margin-right: 4px; margin-top: -8px;" />Provide
									Course Details
								</div>

								<!----------------- start of first container --------------->

								<div class="_coursename">
									<div class="control-group">
										<div id="uerror"></div>
										<label class="control-label labelclass " for="CourseName"
											style="margin-top: -4px; font-weight: bold;">Course
											Name :</label>
										<div class="controls">
											<input type="text" autofocus class="defaultvaluem treeRoot"
												id="coursename"
												style="width: 240px; margin-left: 10px; color: #666;"
												tabindex="1" placeholder="" />
										</div>
										<br /> <label for="coursedescription" class="labelclass"
											style="font-weight: bold;"><b>Course Description
												:</b></label> <a class="f-r _plainText" href="#linkurl"
											style="text-decoration: none;">Plain Text Editor</a> <a
											class="f-r _richText" href="#linkurl"
											style="text-decoration: none;">Rich Text Editor</a>
										<textarea cols="124" rows="8"
											class="_plainTextShow defaultvaluem labelclass"
											style="resize: none; color: #666;"></textarea>
										<br />
										<div class="_richTextShow">
											<textarea id="coursedescription" name="editor1pageload"
												class="defaultvalue _focus" tabindex="2">
												<b>Describe the Course being created</b>
											</textarea>
										</div>
										<script type="text/javascript">
											CKEDITOR.replace('editor1pageload');
											$('#coursename')
													.focusout(
															function() {
																//put your code here
																coursevalue = $(
																		'coursename')
																		.val();
																alert(coursevalue);
																$
																		.post(
																				'/ziksana-web/secure/addCourse',
																				{
																					'coursename' : coursevalue
																				},
																				function(
																						data) {
																					alert(data);
																				});

															});

											$('#coursedescription')
													.focusout(
															function() {
																//put your code here
																coursedescriptionvalue = $(
																		'coursedescription')
																		.val();
																alert(coursedescriptionvalue);
																$
																		.post(
																				'/ziksana-web/secure/addCourse',
																				{
																					'coursedescription' : coursedescriptionvalue
																				},
																				function(
																						data) {
																					alert(data);
																				});
															});
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
												Subject Area : </label> <label class="labelclass"
												style="margin-left: 120px; font-weight: bold;">
												Subject: </label> <label class="labelclass"
												style="margin-left: 155px; font-weight: bold;">
												Topic: </label>
										</div>
										<div class="moduleselection">
											<select name="SelectArea" tabindex="3"
												class="defaultvalue labelclass"
												style="margin-right: 15px; width: 200px;">
												<option>Science</option>
												<option>Computer science</option>
												<option>information and general works</option>
												<option>Philosophy and psychology</option>
												<option>Religion</option>
												<option>Social sciences</option>
												<option>Language</option>
												<option>Technology and applied science</option>
												<option>Arts and recreation</option>
												<option>Literature</option>
												<option>History and geography</option>
											</select> <select name="SelectArea" tabindex="4"
												class="defaultvalue labelclass"
												style="margin-right: 15px; width: 200px;">
												<option>Science</option>
												<option>mathematics</option>
												<option>Astronomy & Allied Sciences</option>
												<option>Physics</option>
												<option>Chemistry & Allied Sciences</option>
												<option>Earth Sciences</option>
												<option>Paleontology; Paleozoology</option>
												<option>Life sciences</option>
												<option>Plants</option>
												<option>Zoological sciences/Animals</option>
											</select> <select name="SelectArea" tabindex="5"
												class="defaultvalue labelclass" style="width: 200px;">
												<option>Theory and Research</option>
												<option>Physiology</option>
												<option>Biochemistry</option>
												<option>Physiological systems of animals</option>
												<option>Not assigned or no longer used</option>
												<option>Physiological systems of plants</option>
												<option>Genetics and evolution</option>
												<option>Ecology</option>
												<option>Natural history of organisms</option>
												<option>Microorganisms</option>
												<option>fungi</option>
												<option>algae</option>
											</select>
										</div>
										<!-- end of moduleselection--->

										<div class="coursetags">
											<br /> <label class="control-label labelclass"
												for="coursetags"
												style="margin-top: -2px; font-weight: bold;">Specify
												any tags : </label> <input type="text" autofocus
												class="defaultvaluem treeRoot" id="defaultvalue"
												style="width: 240px; margin-left: 10px; color: #666;"
												tabindex="1" value="Model Thinking, Decision Models" /> <br />
											<br />
										</div>
										<!-- end of coursetags--->

										<div class="coursecredits">
											<label for="coursetags" class="labelclass"
												style="font-weight: bold;">Specify Course Credits :</label>
											<input type="text" id="Credits" class="smartspinner"
												tabindex="7" style="margin-left: 18px;" />
											<script type="text/javascript"
												src="../resources/js/spinner/smartspinner.js"></script>
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
																						min : 0,
																						initValue : 10,
																						max : 20,
																					});

																});
											</script>
											<label for="coursetags" class="labelclass"
												style="margin-left: 20px; font-weight: bold;">Specify
												Course Extra Credits :</label> <input type="text" id="ExtraCredits"
												tabindex="8" class="defaultvalue"
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
																						min : 0,
																						initValue : 0,
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
												style="width: 30px; margin-left: 9px;" class="defaultvalue"
												tabindex="9" />
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
																						min : 0,
																						initValue : 15,
																						max : 20,
																					});

																});
											</script>
											<select name="SelectArea" tabindex="10" class="defaultvalue"
												style="margin-left: 20px;">
												<option value="week">Weeks</option>
												<option value="month">Months</option>
												<option value="day">Days</option>

											</select>

										</div>
										<!-- end of courseduration--->

										<div class="addinformation">
											<a class="lbx-70-50" id="_addNewInfo"
												href="library/AddNewInformation.html">Add New
												Information </a>
										</div>
									</div>
									<!-- end of secondcontainer--->
								</div>
								<!-- end of control group--->


								<!----------------- start of third container --------------->
								<div class="_thirdcontainer">
									<div class="contentsecurity">

										<img id="aSide" src="../../resources/images/tipsy-east.gif"
											align="left"
											style="height: 10px; width: 10px; margin-top: 5px; cursor: pointer;"
											title="View Requirements" /> <img id="aDown"
											src="../../resources/images/tipsy-south.gif" align="left"
											style="height: 10px; width: 10px; margin-top: 5px; cursor: pointer;"
											title="Hide Requirements" />
										<p class="labelclass"
											style="margin-left: 15px; font-weight: bold;">Define
											Video Content Security requirements</p>
										<br>
										<div id="showSecurity">
											<input type="checkbox" name="chksecurity" id="chksecurity"
												class="labelclass" value="Institution Logo" tabindex="11"
												style="margin-left: 20px;" /> <span class="labelclass"
												style="padding-left: 5px;">Institution Logo? </span> <input
												type="checkbox" class="labelclass" name="chksecurity2"
												id="chksecurity2" value="your Signature" tabindex="12"
												style="margin-left: 20px;" /><span class="labelclass"
												style="padding-left: 5px;">Your Signature? </span> <input
												type="checkbox" name="security" id="security"
												class="labelclass" value="Floating Watermark" tabindex="13"
												style="margin-left: 20px;"><span class="labelclass"
												id="securitytxt" style="padding-left: 5px;">Floating
												Watermark? </span></input>

										</div>

									</div>
									<!-- end of contentsecurty--->



									<div class="associateimage" style="margin-top: 30px;">

										<p class="labelclass" style="font-weight: bold;">Associate
											an Image for your Course</p>
										<br /> <img src="../resources/images/modelthinking.png"
											alt="Modelthinking" width="94" height="94" border="3"
											style="border: 2px solid #ccc;" /> <input type="file"
											tabindex="14" style="margin-left: 20px;" /> <a
											href="#linkurl" id="cancellink"><img
											src="../resources/images/delete.jpg" />Cancel</a>

										<script language="javascript">
											$(document)
													.ready(
															function() {
																$("#cancellink")
																		.click(
																				function(
																						event) {
																					window.location.href = "modelthinking.html";
																				});

															});
										</script>

									</div>
									<!-- end of associateimage--->

								</div>
								<!-- end of third container--->

								<input type="button" class="btn btn-info f-r" id="done1"
									value="Done" style="margin-right: -200px;">

							</form>
							<div class="ecd" style="height: 15px;">
								<input type="button" class="btn btn-info f-r" id="show1"
									value="Edit Course Details"
									style="margin-right: -257px; margin-bottom: 4px; clear: both;">
							</div>
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

#jqxExpander {
	width: 320px;
	height: auto;
}
</style>

							<div id="treeHideShow"
								style="font-size: 10px; margin-bottom: 10px;">

								<p class="definehelp all all-box-shadow"
									style="width: 965px; padding: 5px; font-family: Helvetica; font-weight: bold; font-size: 18px; color: #125F92; height: 30px;">
									<img src="../resources/images/icons/helpicon.png" align="left"
										style="padding-left: 5px; margin-right: 4px; line-height: 28px;" /><b>Right
										Click over the Tree Node to further Define the Course. </b>
								</p>


								<div id="splitter" style='clear: both;'>

									<div id='jqxWidget'>
										<div id='jqxExpander'>
											<div
												style="background-color: #FFFFFF; border: none; display: none;"></div>
											<div id='jqxTree' style='float: left;'>
												<ul class="jqx-tree-dropdown-root">
													<li item-expanded="true"
														class="jqx-tree-item-li jqx-disableselect"
														style="float: none;"><span
														style="height: 17px; border: none; float: left; width: 16px; margin-top: 2px;"
														class="jqx-disableselect"></span>
														<div
															style="display: inline-block; -webkit-user-select: none; font-size: 11px; font-weight: bold;"
															class="jqx-rc-all draggable jqx-tree-item jqx-item jqx-draggable"
															id="jqx-draggable-1" unselectable="on">
															<img style='float: left; margin-right: 5px;'
																src='../resources/images/tree.png' id="imgRoot" />Model
															Thinking
														</div>
														<ul class="jqx-tree-dropdown"
															style="overflow: hidden; display: block;">
															<li item-expanded="true"
																class="jqx-tree-item-li jqx-disableselect"
																style="float: none;"><span
																style="height: 17px; border: none; background-color: transparent; float: left; width: 16px; margin-top: 2px; visibility: hidden;"
																class="jqx-tree-item-arrow-collapse jqx-disableselect"></span>
																<div
																	style="display: inline-block; -webkit-user-select: none; font-size: 10px; font-weight: bold;"
																	class="jqxmenumodel jqx-rc-all draggable jqx-tree-item jqx-item jqx-draggable"
																	id="jqx-draggable-2" unselectable="on">
																	<img style='float: left; margin-right: 5px;'
																		src='../resources/images/led/note.png' id="imgRoot" />Why
																	Model Thinking
																</div></li>
															<li item-expanded="true"
																class="jqx-tree-item-li jqx-disableselect"
																style="float: none;"><span
																style="height: 17px; border: none; background-color: transparent; float: left; width: 16px; margin-top: 2px; visibility: hidden;"
																class="jqx-tree-item-arrow-collapse jqx-disableselect"></span>
																<div
																	style="display: inline-block; font-size: 10px; font-weight: bold;"
																	class="jqxmenumodel jqx-rc-all draggable jqx-tree-item jqx-item 
 jqx-draggable"
																	id="jqx-draggable-3">
																	<img style='float: left; margin-right: 5px;'
																		src='../resources/images/led/note.png' id="imgRoot" />Aggregation
																</div></li>
															<li item-expanded="true"
																class="jqx-tree-item-li jqx-disableselect"
																style="float: none;"><span
																style="height: 17px; border: none; background-color: transparent; float: left; width: 16px; margin-top: 2px; visibility: hidden;"
																class="jqx-tree-item-arrow-collapse jqx-disableselect"></span>
																<div
																	style="display: inline-block; font-size: 10px; font-weight: bold;"
																	class="jqxmenumodel jqx-rc-all draggable jqx-tree-item 
jqx-item jqx-draggable"
																	id="jqx-draggable-4">
																	<img style='float: left; margin-right: 5px;'
																		src='../resources/images/led/note.png' id="imgRoot" />Decision
																	Models
																</div></li>
														</ul></li>
												</ul>

											</div>
										</div>


										<div id='jqxMenu'>
											<ul>
												<li id="linkaddmodule"><img
													src="../resources/images/plus.png" alt="Add" height="10"
													width="10" style="margin-right: 5px; margin-left: -5px;" />
													Add Module</li>
												<li id="linksearchmodule"><img
													src="../resources/images/find.png" alt="Find" height="10"
													width="10" style="margin-right: 5px; margin-left: -5px;" />
													Search and Add</li>
												<li id="linkdefinequalifiers"><img
													src="../resources/images/define.png" alt="Define"
													height="10" width="10"
													style="margin-right: 5px; margin-left: -5px;" /> Define
													Qualifiers</li>
												<li id="linkedit"><img
													src="../resources/images/edit.png" alt="Edit" height="10"
													width="10" style="margin-right: 5px; margin-left: -5px;" />
													Edit</li>
												<li id="linkviewqualifiers"><img
													src="../resources/images/view.png" alt="View" height="10"
													width="10" style="margin-right: 5px; margin-left: -5px;" />
													View</li>
											</ul>
										</div>

										<div id='jqxMenu' class="jqxMenu2">
											<ul>
												<li id="linkaddmodule2"><img
													src="../resources/images/plus.png" alt="Add" height="10"
													width="10" style="margin-right: 5px; margin-left: -5px;" />
													Add Module</li>
												<li id="linksearchmodule2"><img
													src="../resources/images/find.png" alt="Find" height="10"
													width="10" style="margin-right: 5px; margin-left: -5px;" />
													Search and Add</li>
												<li id="linkdefinequalifiers2"><img
													src="../resources/images/define.png" alt="Define"
													height="10" width="10"
													style="margin-right: 5px; margin-left: -5px;" /> Define
													Qualifiers</li>
												<li id="linkedit2"><img
													src="../resources/images/edit.png" alt="Edit" height="10"
													width="10" style="margin-right: 5px; margin-left: -5px;" />
													Edit</li>
												<li id="linkviewqualifiers2"><img
													src="../resources/images/view.png" alt="View" height="10"
													width="10" style="margin-right: 5px; margin-left: -5px;" />
													View</li>
												<li id="deletesublink2"><img
													src="../resources/images/cross.png" alt="Delete"
													height="10" width="10"
													style="margin-right: 5px; margin-left: -5px;" /> Delete</li>
											</ul>
										</div>

									</div>


									<div id="ContentPanel"
										style="font-size: 11px; background-image: none; margin-left: 25px;">
										<!-- Start of Default Instruction -->

										<div id="instruction" style="padding: 10px;">
											<img src="../resources/images/instruction.png"
												class="all-box-shadow" alt="instructions"
												title="Key-Board instruction" width="720"
												style="border: 1px solid #ccc; padding: 5px; border-radius: 7px; border: 1px solid #ccc;">
										</div>

										<!-- End of Default Instruction  -->
										<!-- Add Module Container -->
										<div class="Addmodulecontainer" id="Addmodulecontainer">
											<form id="AddModule" class="form-horizontal">
												<br />
												<div class="definehelp"
													style="width: 680px; font-family: Helvetica; font-weight: bold; color: #125F92;">
													<img src="../resources/images/icons/helpicon.png"
														align="left"
														style="padding-left: 5px; margin-right: 4px; margin-top: -8px;" />Define
													a New Course Module
												</div>

												<!----------------- start of first container --------------->
												<div class="coursename">
													<div class="control-group">
														<label class="control-label labelclass" for="CourseName"
															style="margin-top: -4px;">Course Module :</label>
														<div class="controls">
															<input type="text" id="defaultvalue" class="defaultvalue"
																autofocus
																placeholder="Specify the name of the Course Module"
																tabindex="1" style="width: 240px; margin-left: 10px;" />
														</div>


														<br /> <label for="moduledescription" class="labelclass">Module
															Description :</label> <a class="f-r _richText"
															id="addmodulerichedit" href="#linkurl"
															style="text-decoration: none;">Rich Text Editor</a> <a
															class="f-r _plainText" href="#linkurl"
															style="text-decoration: none;">Plain Text Editor</a>
														<textarea class="_plainTextShow labelclass defaultvalue"
															cols="90" rows="7" style="resize: none;"
															placeholder="Describe the Course being created"></textarea>
														<br />
														<div class="_richTextShow">
															<textarea id="editor2" name="editor2"
																class="defaultvalue _focus" tabindex="2">Describe the Course being created</textarea>
														</div>

													</div>
													<!-- end of coursename--->
												</div>
												<!-- end of control group--->

												<!----------------- start of second container --------------->
												<div class="secondcontainer">
													<div class="control-group">
														<div>
															<label class="labelclass"> Subject Area : </label> <label
																class="labelclass" style="margin-left: 120px;">
																Subject: </label> <label class="labelclass"
																style="margin-left: 155px;"> Topic: </label>
														</div>
														<div class="moduleselection">
															<select name="SelectArea" tabindex="3"
																class="defaultvalue labelclass"
																style="margin-right: 15px; width: 200px;">
																<option>Science</option>
																<option>Computer science</option>
																<option>information and general works</option>
																<option>Philosophy and psychology</option>
																<option>Religion</option>
																<option>Social sciences</option>
																<option>Language</option>
																<option>Technology and applied science</option>
																<option>Arts and recreation</option>
																<option>Literature</option>
																<option>History and geography</option>
															</select> <select name="SelectArea" tabindex="4"
																class="defaultvalue labelclass"
																style="margin-right: 15px; width: 200px;">
																<option>Science</option>
																<option>mathematics</option>
																<option>Astronomy & Allied Sciences</option>
																<option>Physics</option>
																<option>Chemistry & Allied Sciences</option>
																<option>Earth Sciences</option>
																<option>Paleontology; Paleozoology</option>
																<option>Life sciences</option>
																<option>Plants</option>
																<option>Zoological sciences/Animals</option>
															</select> <select name="SelectArea" tabindex="5"
																class="defaultvalue labelclass" style="width: 200px;">
																<option>Theory and Research</option>
																<option>Physiology</option>
																<option>Biochemistry</option>
																<option>Physiological systems of animals</option>
																<option>Not assigned or no longer used</option>
																<option>Physiological systems of plants</option>
																<option>Genetics and evolution</option>
																<option>Ecology</option>
																<option>Natural history of organisms</option>
																<option>Microorganisms</option>
																<option>fungi</option>
																<option>algae</option>
															</select>
														</div>
														<!-- end of moduleselection--->

														<div class="coursetags">
															<br /> <label class="control-label labelclass"
																for="moduletags" style="margin-top: -2px;">Specify
																any tags : </label> <input id="tagfield2" type="text"
																tabindex="6"></input> <br /> <label
																class="control-label labelclass" for="CourseName"
																tabindex="7" style="margin-top: -4px;">Enter
																Weight :</label>
															<div class="controls">
																<input type="text" id="defaultvalue"
																	class="defaultvalue" tabindex="8"
																	placeholder="Enter the Weight for the Module"
																	style="width: 240px; margin-left: 35px;" />
															</div>

														</div>
														<!-- end of coursetags--->
														<br /> <input type="checkbox" id="addmodulecheckbox"
															class="labelclass" value="Institution Logo" tabindex="9" />
														<span class="labelclass" style="padding-left: 5px;">Save
															as a Learning Object? </span>
														<div class="courseduration" id="saveassociateobject">
															<br /> <label for="Learning Duration" class="labelclass"
																style="">Specify the Duration of the Learning
																Object :</label> <input type="text" id="Duration"
																style="width: 30px;" class="defaultvalue" tabindex="10" />

															<!--<script type="text/javascript">
        $(document).ready(function() {
            var s =  $('#Duration').spinit({ height: 20, width: 30, min: 0, initValue: 0, max: 20,  });        

        });
    </script>-->
															<select name="SelectArea" tabindex="10"
																class="defaultvalue" style="margin-left: 5px;">
																<option>Specify Units</option>
																<option value="week">Weeks</option>
																<option value="month">Months</option>
																<option value="day">Days</option>

															</select>



															<div class="associateimage" style="margin-top: 15px;">

																<img src="../resources/images/icons/upload.png"
																	align="left" />
																<p class="labelclass">Associate an Image for your
																	Course</p>
																<input type="file" tabindex="14"
																	style="margin-left: 20px;" /> <a href="#linkurl"
																	id="cancellinkadd"><img
																	src="../resources/images/delete.jpg" />Cancel</a>

															</div>
															<!-- end of associateimage--->

														</div>
														<!-- end of courseduration--->
													</div>
													<!-- end of secondcontainer--->
												</div>
												<!-- end of control group--->







												<input type="button"
													class="cancellinkdefinecourse btn btn-info" value="Cancel"
													style="float: right; margin-right: 20px;"> <input
													type="button" class="btn btn-info" value="Submit"
													style="float: right; margin-right: 20px;"> <br />
												<br />
											</form>

										</div>
										<!-- end of add module container -->




										<!-- start of search and associate content -->


										<div class="searchassociatecontainer"
											id="searchassociatecontainer">
											<br />
											<div class="definehead"
												style="font-size: 17px; font-family: arial; font-weight: bold; color: #6D9EC5;">
												Search & Associate Modules</div>
											<div class="definehelp"
												style="width: 680px; font-family: Helvetica; font-weight: bold; color: #125F92;">
												<img src="../resources/images/icons/helpicon.png"
													align="left"
													style="padding-left: 5px; margin-right: 4px; margin-top: -4px;" />You
												can Search the Courses Sections created by you for other
												courses and also owned/shared learning objects.
											</div>

											<div class="secondcontainer" style="height: 50px;">

												<form id="ui_search" class="sb_qualifier">

													<span class="sb_downq"></span> <input class="sb_inputq"
														type="text"
														placeholder="Provide Name of the Course Section/Learning Object"
														style="font-size: 13px; width: 305px;" /> <input
														class="sb_searchq" value="" id="btnsearch"
														style="height: -30px;" /> <span><a href="#linkurl"
														class="btn"
														style="margin-top: 4px; margin-left: 2px; height: 18px; text-decoration: none;"
														id="_btnadvanced"> Advanced </a> </span>
													<!--<input   type="submit" value="Advanced" class="btn" style="float:left; margin-top:2px;"/> -->

													<ul class="sb_dropdownq" style="display: none;">
														<li class="sb_filterq">Filter your search</li>
														<li style="padding-right: 90px;"><input
															type="checkbox" /><label for="All">All</label></li>
														<li><input type="checkbox" /><label for="Owned">Course
																Section</label></li>
														<br />
														<br />
														<br />
														<li style="padding-right: 5px;"><input
															type="checkbox" /><label for="Institution Specified">Learning
																Objects</label></li>


													</ul>
												</form>
												<br /> <br />
											</div>
											<!-- end of search and associate content--->

											<!----------------- start of first container --------------->
											<div class="coursename" div id="_advanced">
												<div class="control-group">

													<form id="AddModule" class="form-horizontal">
														<legend
															style="font-size: 17px; font-family: arial; font-weight: bold; color: #6D9EC5;">
															Advanced Search Options</legend>
														<br /> <label class="control-label labelclass"
															for="Content Name" style="margin-top: -4px;">Content
															Name:</label>
														<div class="controls">
															<input type="text" id="defaultvalue" class="defaultvalue"
																autofocus
																placeholder="Provide Name of the Course Section/Learning Object"
																tabindex="1" style="width: 530px; margin-left: 10px;" />
														</div>

														<br />

														<div>
															<label class="labelclass"> Module Object: </label>
														</div>
														<div class="moduleselection">
															<select name="SelectArea2" tabindex="3"
																class="defaultvalue labelclass"
																style="margin-right: 15px; width: 210px;">
																<option>Select type of Object</option>

															</select>

														</div>
														<!-- end of moduleselection--->

														<br />

														<div>
															<label class="labelclass"> Module Area: </label> <label
																class="labelclass" style="margin-left: 140px;">Module
																Subject: </label> <label class="labelclass"
																style="margin-left: 115px;">Module Topic: </label>
														</div>

														<div class="moduleselection">
															<select name="SelectArea" tabindex="3"
																class="defaultvalue labelclass"
																style="margin-right: 15px; width: 210px;">
																<option>Select Module Area</option>
															</select> <select name="SelectArea" tabindex="4"
																class="defaultvalue labelclass"
																style="margin-right: 15px; width: 210px;">
																<option>Select Module Subject</option>
															</select> <select name="SelectArea" tabindex="5"
																class="defaultvalue labelclass" style="width: 210px;">
																<option>Select Module Topic</option>
															</select>
														</div>
														<!-- end of moduleselection--->

														<div class="coursetags">
															<br /> <label class="control-label labelclass"
																for="contenttags" style="margin-top: -2px;">Specify
																any tags: </label> <input id="tagfield4" type="text"
																tabindex="6" style="margin-left: 290px;"></input>
														</div>
														<!-- end of coursetags--->

														<input type="button" class="btn btn-info"
															id="searchdummybtn2" value="Search"
															style="float: right; margin-right: 20px;"> <br />
													</form>
												</div>
												<!-- end of coursename--->
											</div>
											<!-- end of control group--->



											<!----------------- start of second container --------------->
											<div class="frmsearchresults secondcontainer "
												id="secondcontainer">
												<div class="control-group">

													<form class="form-horizontal">
														<fieldset>
															<legend
																style="font-size: 17px; font-family: arial; font-weight: bold; color: #6D9EC5;">
																Search Results</legend>
															<table align="center" id="tblqualifier"
																class="table reviewtable">
																<thead
																	style="font-weight: bold; font-size: 6px; font-family: Arial">
																	<tr style="background-color: #E1E8F0;">
																		<th></th>
																		<th width="12%">Defined by</th>
																		<th width="10%">Type</th>
																		<th width="15%">Name</th>
																		<th width="12%">Course/LO</th>
																		<th width="12%">Usage Permissions</th>
																		<th width="7%">Ziks</th>
																		<th width="22%">Description</th>
																		<th width="10%"></th>
																	</tr>
																</thead>
																<tbody>
																	<tr>
																		<td><input type="checkbox" /></td>
																		<td>Author's Name</td>
																		<td>learning Object</td>
																		<td><a class="lbx-70-50" href="#linkurl">Trigonometry
																				101 </a></td>
																		<td>------</td>
																		<td>no Edit Permissions</td>
																		<td>20</td>
																		<td>All Concepts of Trigonometry</td>
																		<td><a class="lbx-70-50" href="#linkurl"
																			title="View"><img
																				src="../resources/images/led/application_osx.png" /></a></td>


																	</tr>
																	<tr>
																		<td><input type="checkbox" /></td>
																		<td>Me</td>
																		<td>Course section</td>
																		<td><a class="lbx-70-50" href="#linkurl">Basics
																				of Algebra </a></td>
																		<td>Maths 101</td>
																		<td>Owner</td>
																		<td>--</td>
																		<td>Basic concepts of Algebra..</td>
																		<td><a class="lbx-70-50" href="#linkurl"
																			title="View"><img
																				src="../resources/images/led/application_osx.png" /></a></td>
																	</tr>

																</tbody>
															</table>


															<a class="cancellinkdefinecourse btn btn-info"
																href="#linkurl"
																style="float: right; margin-right: 20px; text-decoration: none;">
																Cancel </a> <a class="btn btn-info lbx-70-50"
																href="library/Add Module.html"
																style="float: right; margin-right: 20px; text-decoration: none;">
																Add Modules </a>

														</fieldset>
													</form>

												</div>
												<!-- end of secondcontainer--->
											</div>
											<!-- end of control group--->
										</div>
										<!-- End of search and associate content -->

										<!-- Start of Third Container -->


										<div class="definequalifiercontainer"
											id="definequalifiercontainer"
											style="margin-left: 5px; margin-top: -20px;">
											<form id="AddNewInformation" class="form-horizontal">
												<br />

												<!----------------- start of first container --------------->
												<div class="DeineQualifier">
													<br />
													<div class="definehead"
														style="font-size: 17px; font-family: arial; font-weight: bold; color: #6D9EC5;">
														Define Qualifiers</div>



													<div class="definehelp"
														style="width: 680px; font-family: Helvetica; font-weight: bold; color: #125F92; height: 20px;">
														<img src="../resources/images/icons/helpicon.png"
															align="left"
															style="padding-left: 5px; margin-right: 4px; margin-top: -4px;" />
														Associated Qualifiers are Listed. You can choose to either
														search for a Qualifier or define a new Qualifier.
													</div>

													<br /> <br />
													<fieldset>
														<legend
															style="font-size: 17px; font-family: arial; font-weight: bold; color: #6D9EC5; margin-bottom: 4px;">
															Associated Qualifiers </legend>

														<table width="640" align="center"
															class="table reviewtable" id="tblqualifier">
															<thead style="font-weight: bold;">
																<tr style="background-color: #E1E8F0;">
																	<th width="13%">Defined by</th>
																	<th width="15%">Type</th>
																	<th width="22%">Title</th>
																	<th width="26%">Qualifier Text</th>
																	<th width="8%"></th>
																	<th width="8%"></th>
																	<th width="8%"></th>
																</tr>
															</thead>
															<tbody>
																<tr id="defrow1">
																	<td>Me</td>
																	<td>Pre-Requisites</td>
																	<td>Course Pre-Requisites</td>
																	<td id="coursetaught">This Couse is taught
																		completely...</td>


																	<td><a class="lbx-70-50" title="View"
																		href="library/viewdummytable.html"><img
																			src="../resources/images/view.png" /></a></td>
																	<td><a class="lbx-70-50" title="Edit"
																		href="library/editdummytable.html"><img
																			src="../resources/images/edit.png" /></a></td>
																	<td><a class="deletedefqualifierrec1 lbx-70-50"
																		title="Delete" href="#linkurl"><img
																			src="../resources/images/delete.jpg" alt="Delete"
																			title="Delete" /></a></td>


																</tr>
																<tr id="defrow2">
																	<td>Me</td>
																	<td>Learning outcome</td>
																	<td>Course Learning outcome</td>
																	<td>This student will not be able to execute...</td>
																	<td><a class="lbx-70-50" title="View"
																		href="library/viewdummytable.html"><img
																			src="../resources/images/view.png" /></a></td>
																	<td><a class="lbx-70-50" title="Edit"
																		href="library/editdummytable.html"><img
																			src="../resources/images/edit.png" /></a></td>
																	<td><a class="deletedefqualifierrec2 lbx-70-50"
																		title="Delete" href="#linkurl"><img
																			src="../resources/images/delete.jpg" alt="Delete"
																			title="Delete" /></a></td>
																</tr>

																<tr id="defrow3">
																	<td>Institution</td>
																	<td>Policy</td>
																	<td>Student Conduct and Discipline</td>
																	<td>This University has rules...</td>
																	<td><a class="lbx-70-50" title="View"
																		href="library/viewdummytable.html"><img
																			src="../resources/images/view.png" /></a></td>
																	<td></td>
																	<td><a class="deletedefqualifierrec3 lbx-70-50"
																		title="Delete" href="#linkurl"><img
																			src="../resources/images/delete.jpg" alt="Delete"
																			title="Delete" /></a></td>


																</tr>

																<tr id="defrow4">
																	<td>Institution</td>
																	<td>Policy</td>
																	<td>Academic Integrity</td>
																	<td>The faculty expects from students...</td>
																	<td><a class="lbx-70-50" title="View"
																		href="library/viewdummytable.html"><img
																			src="../resources/images/view.png" /></a></td>
																	<td></td>
																	<td><a class="deletedefqualifierrec4 lbx-70-50"
																		title="Delete" href="#linkurl"><img
																			src="../resources/images/delete.jpg" alt="Delete"
																			title="Delete" /></a></td>


																</tr>

															</tbody>
														</table>

														<div class="qualifierlinks" style="float: right">
															<a class="lbx-70-50"
																href="library/Search& Associate Qualifier.html">
																Search & Add Qualifier </a> &nbsp; &nbsp; <a
																class="lbx-70-50"
																href="library/Create New Qualifier.html"> Create &
																New Qualifier </a>
														</div>
													</fieldset>

												</div>
												<!-- end of DeineQualifier--->
												<div style="height: 50px;">
													<input type="button"
														class="cancellinkdefinecourse btn btn-info" value="Cancel"
														style="float: right; margin-right: 20px;"> <input
														type="button" class="btn btn-info" value="Submit"
														style="float: right; margin-right: 20px;">
												</div>
												<!--end of button div-->
											</form>
										</div>
										<!-- end of definecontainer--->



										<!-- End of Third Container -->

										<!-- Start of Viewmodelthinking -->

										<div id="Viewmodulecontainer">
											<div class="Addmodulecontainer">
												<form id="AddModule" class="form-horizontal">
													<br />
													<div class="definehelp"
														style="width: 680px; font-family: Helvetica; font-weight: bold; color: #125F92;">
														<img src="../resources/images/icons/helpicon.png"
															align="left"
															style="padding-left: 5px; margin-right: 4px; margin-top: -8px;" />Edit
														Course Module
													</div>

													<!----------------- start of first container --------------->
													<div class="coursename">
														<div class="control-group">
															<label class="control-label labelclass" for="CourseName"
																style="margin-top: -4px;">Course Module :</label>
															<div class="controls">
																<input type="text" id="defaultvalue"
																	class="defaultvalue" autofocus value="Model Thinking"
																	tabindex="1" style="width: 200px; margin-left: 10px;" />
															</div>


															<br /> <label for="moduledescription" class="labelclass">Module
																Description :</label>
															<textarea class="_plainTextShow labelclass defaultvalue"
																cols="90" rows="13" style="resize: none;">We live in a complex world with diverse people, firms, and governments whose behaviors aggregate to produce novel, unexpected phenomena. We see political uprisings, market crashes, and a never ending array of social trends. How do we make sense of it?
Models. Evidence shows that people who think with models consistently outperform those who don’t. And, moreover people who think with lots of models outperform people who use only one.
Why do models make us better thinkers?
Models help us to better organize information – to make sense of that fire hose or hairball of data (choose your metaphor) available on the Internet. Models improve our abilities to make accurate forecasts. They help us make better decisions and adopt more effective strategies. They even can improve our ability to design institutions and procedures. In this class, I present a starter kit of models: I start with models of tipping points. I move on to cover models explain the wisdom of crowds, models that show why some countries are rich and some are poor, and models that help unpack the strategic decisions of firm and politicians.</textarea>

														</div>
														<!-- end of coursename--->
													</div>
													<!-- end of control group--->

													<!----------------- start of second container --------------->
													<div class="secondcontainer">
														<div class="control-group">
															<div>
																<label class="labelclass"> Module Area: </label> <label
																	class="labelclass" style="margin-left: 130px;">Module
																	Subject: </label> <label class="labelclass"
																	style="margin-left: 105px;">Module Topic: </label>
															</div>
															<div class="moduleselection">
																<select name="SelectArea" tabindex="3"
																	class="defaultvalue labelclass"
																	style="margin-right: 15px; width: 200px;">
																	<option>Science</option>
																	<option>Computer science</option>
																	<option>information and general works</option>
																	<option>Philosophy and psychology</option>
																	<option>Religion</option>
																	<option>Social sciences</option>
																	<option>Language</option>
																	<option>Technology and applied science</option>
																	<option>Arts and recreation</option>
																	<option>Literature</option>
																	<option>History and geography</option>
																</select> <select name="SelectArea" tabindex="4"
																	class="defaultvalue labelclass"
																	style="margin-right: 15px; width: 200px;">
																	<option>Science</option>
																	<option>mathematics</option>
																	<option>Astronomy & Allied Sciences</option>
																	<option>Physics</option>
																	<option>Chemistry & Allied Sciences</option>
																	<option>Earth Sciences</option>
																	<option>Paleontology; Paleozoology</option>
																	<option>Life sciences</option>
																	<option>Plants</option>
																	<option>Zoological sciences/Animals</option>
																</select> <select name="SelectArea" tabindex="5"
																	class="defaultvalue labelclass" style="width: 200px;">
																	<option>Theory and Research</option>
																	<option>Physiology</option>
																	<option>Biochemistry</option>
																	<option>Physiological systems of animals</option>
																	<option>Not assigned or no longer used</option>
																	<option>Physiological systems of plants</option>
																	<option>Genetics and evolution</option>
																	<option>Ecology</option>
																	<option>Natural history of organisms</option>
																	<option>Microorganisms</option>
																	<option>fungi</option>
																	<option>algae</option>
																</select>
															</div>
															<!-- end of moduleselection--->

															<div class="coursetags">
																<br /> <label class="control-label labelclass"
																	for="moduletags" style="margin-top: -2px;">Specify
																	any tags : </label> <input type="text" autofocus
																	class="defaultvaluem treeRoot" id="defaultvalue"
																	style="width: 240px; margin-left: 10px; color: #666;"
																	value="Model Thinking, Decision Models" /> <br />


															</div>
															<!-- end of coursetags--->
															<br /> <input type="checkbox" id="viewmodulecheckbox"
																class="labelclass" value="Institution Logo" tabindex="9" />
															<span class="labelclass" style="padding-left: 5px;">Save
																as a Learning Object? </span>
															<div class="courseduration"
																id="viewmodulesaveassociateobject">
																<br /> <label for="Learning Duration"
																	class="labelclass" style="">Specify the
																	Duration of the Learning Object :</label> <input type="text"
																	id="Duration" style="width: 30px;" class="defaultvalue"
																	tabindex="10" />

																<!--<script type="text/javascript">
        $(document).ready(function() {
            var s =  $('#Duration').spinit({ height: 20, width: 30, min: 0, initValue: 0, max: 20,  });        

        });
    </script>-->
																<select name="SelectArea" tabindex="10"
																	class="defaultvalue" style="margin-left: 5px;">
																	<option>Specify Units</option>
																	<option value="week">Weeks</option>
																	<option value="month">Months</option>
																	<option value="day">Days</option>

																</select>



																<div class="associateimage" style="margin-top: 15px;">

																	<img src="../resources/images/icons/upload.png"
																		align="left" />
																	<p class="labelclass">Associate an Image for your
																		Course</p>
																	<input type="file" tabindex="14"
																		style="margin-left: 20px;" /> <a href="#linkurl"
																		id="cancellinkadd"><img
																		src="../resources/images/delete.jpg" />Cancel</a>

																</div>
																<!-- end of associateimage--->

															</div>
															<!-- end of courseduration--->
														</div>
														<!-- end of secondcontainer--->
													</div>
													<!-- end of control group--->


													<input type="button"
														class="cancellinkdefinecourse btn btn-info" value="Cancel"
														style="float: right; margin-right: 20px;" /> <input
														type="button" class="btn btn-info" value="Submit"
														style="float: right; margin-right: 20px;" /> <br /> <br />
												</form>

											</div>

										</div>
										<!-- End of viewmodelthinking -->

										<!-- start view modelthinking 2 -->


										<div id="Viewmodulecontainer2">
											<div class="Addmodulecontainer">
												<form id="AddModule" class="form-horizontal">
													<br />
													<div class="definehelp"
														style="width: 680px; font-family: Helvetica; font-weight: bold; color: #125F92;">
														<img src="../resources/images/icons/helpicon.png"
															align="left"
															style="padding-left: 5px; margin-right: 4px; margin-top: -8px;" />View
														Course Module
													</div>

													<!----------------- start of first container --------------->
													<div class="coursename">
														<div class="control-group">
															<label class="control-label labelclass" for="CourseName"
																style="margin-top: -4px;">Course Module :</label>
															<div class="controls">
																<input type="text" id="defaultvalue"
																	class="defaultvalue" readonly autofocus
																	value="Model Thinking" tabindex="1"
																	style="width: 200px; margin-left: 10px;" />
															</div>


															<br /> <label for="moduledescription" class="labelclass">Module
																Description :</label>
															<textarea class="_plainTextShow labelclass defaultvalue"
																cols="90" rows="13" readonly style="resize: none;">We live in a complex world with diverse people, firms, and governments whose behaviors aggregate to produce novel, unexpected phenomena. We see political uprisings, market crashes, and a never ending array of social trends. How do we make sense of it?
Models. Evidence shows that people who think with models consistently outperform those who don’t. And, moreover people who think with lots of models outperform people who use only one.
Why do models make us better thinkers?
Models help us to better organize information – to make sense of that fire hose or hairball of data (choose your metaphor) available on the Internet. Models improve our abilities to make accurate forecasts. They help us make better decisions and adopt more effective strategies. They even can improve our ability to design institutions and procedures. In this class, I present a starter kit of models: I start with models of tipping points. I move on to cover models explain the wisdom of crowds, models that show why some countries are rich and some are poor, and models that help unpack the strategic decisions of firm and politicians.</textarea>

														</div>
														<!-- end of coursename--->
													</div>
													<!-- end of control group--->

													<!----------------- start of second container --------------->
													<div class="secondcontainer">
														<div class="control-group">
															<div>
																<label class="labelclass"> Module Area: </label> <label
																	class="labelclass" style="margin-left: 130px;">Module
																	Subject: </label> <label class="labelclass"
																	style="margin-left: 105px;">Module Topic: </label>
															</div>
															<div class="moduleselection">
																<select name="SelectArea" tabindex="3"
																	class="defaultvalue labelclass" disabled="true"
																	style="margin-right: 15px; width: 200px;">
																	<option>Science</option>
																	<option>Computer science</option>
																	<option>information and general works</option>
																	<option>Philosophy and psychology</option>
																	<option>Religion</option>
																	<option>Social sciences</option>
																	<option>Language</option>
																	<option>Technology and applied science</option>
																	<option>Arts and recreation</option>
																	<option>Literature</option>
																	<option>History and geography</option>
																</select> <select name="SelectArea" tabindex="4"
																	class="defaultvalue labelclass" disabled="true"
																	style="margin-right: 15px; width: 200px;">
																	<option>Science</option>
																	<option>mathematics</option>
																	<option>Astronomy & Allied Sciences</option>
																	<option>Physics</option>
																	<option>Chemistry & Allied Sciences</option>
																	<option>Earth Sciences</option>
																	<option>Paleontology; Paleozoology</option>
																	<option>Life sciences</option>
																	<option>Plants</option>
																	<option>Zoological sciences/Animals</option>
																</select> <select name="SelectArea" tabindex="5"
																	class="defaultvalue labelclass" disabled="true"
																	style="width: 200px;">
																	<option>Theory and Research</option>
																	<option>Physiology</option>
																	<option>Biochemistry</option>
																	<option>Physiological systems of animals</option>
																	<option>Not assigned or no longer used</option>
																	<option>Physiological systems of plants</option>
																	<option>Genetics and evolution</option>
																	<option>Ecology</option>
																	<option>Natural history of organisms</option>
																	<option>Microorganisms</option>
																	<option>fungi</option>
																	<option>algae</option>
																</select>
															</div>
															<!-- end of moduleselection--->

															<div class="coursetags">
																<br /> <label class="control-label labelclass"
																	for="moduletags" style="margin-top: -2px;">Specify
																	any tags : </label> <input type="text" autofocus
																	class="defaultvaluem treeRoot" readonly
																	id="defaultvalue"
																	style="width: 240px; margin-left: 10px; color: #666;"
																	value="Model Thinking, Decision Models" /> <br />


															</div>
															<!-- end of coursetags--->
															<br /> <input type="checkbox" class="labelclass"
																value="Institution Logo" readonly tabindex="9" /> <span
																class="labelclass" style="padding-left: 5px;">Save
																as a Learning Object? </span>
															<div class="courseduration">
																<br /> <label for="Learning Duration"
																	class="labelclass" style="">Specify the
																	Duration of the Learning Object :</label> <input type="text"
																	id="Duration" readonly style="width: 30px;"
																	class="defaultvalue" tabindex="10" value="15" />

																<!--<script type="text/javascript">
        $(document).ready(function() {
            var s =  $('#Duration').spinit({ height: 20, width: 30, min: 0, initValue: 15, max: 20,  });        

        });
    </script>-->
																<select name="SelectArea" tabindex="10" disabled="true"
																	class="defaultvalue" style="margin-left: 5px;">
																	<option value="week">Weeks</option>
																	<option value="month">Months</option>
																	<option value="day">Days</option>

																</select>

																<div class="associateimage" style="margin-top: 15px;">

																	<img src="../resources/images/icons/upload.png"
																		align="left" />
																	<p class="labelclass">Associate an Image for your
																		Course</p>
																	<img src="../resources/images/modelthinking.png"
																		alt="Modelthinking" width="94" height="94" border="3"
																		style="border: 2px solid #ccc;" />
																</div>
																<!-- end of associateimage--->

															</div>
															<!-- end of courseduration--->
														</div>
														<!-- end of secondcontainer--->
													</div>
													<!-- end of control group--->







													<input type="button"
														class="cancellinkdefinecourse btn btn-info"
														disabled="true" value="Cancel"
														style="float: right; margin-right: 20px;" /> <input
														type="button" class="btn btn-info" disabled="true"
														value="Submit" style="float: right; margin-right: 20px;" />
													<br /> <br />
												</form>

											</div>

										</div>
										<!-- End of viewmodelthinking -->

										<!-- End of view modelthinkin 2 -->





									</div>
									<!-- Content Panel End -->
									<br /> <a class="btn btn-info f-r" id="saveBottom"
										style="margin-right: -200px;">Save and Continue</a> <br /> <br />

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
				path : '../resources/images/img/',
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
