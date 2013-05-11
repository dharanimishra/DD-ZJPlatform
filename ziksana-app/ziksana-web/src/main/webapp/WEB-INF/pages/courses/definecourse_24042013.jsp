<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<meta charset="utf-8">
<title>Define Course</title>
<!--Body Style sheet-->



<link
	href="${staticFileServer}resources/css/common/wizard/wizardstylesheet.css"
	rel="stylesheet" type="text/css" />

<link
	href="${staticFileServer}resources/css/common/tags/superbly-tagfield.css"
	rel="stylesheet" type="text/css" />

<link href="${staticFileServer}resources/css/common/validation/validation.css"
	rel="stylesheet" type="text/css" />

<link href="${staticFileServer}resources/js/tree/styles/styleTree.css"
	rel="stylesheet" type="text/css" />
<!-- for the layout of the tree -->
<!--End Body Style sheet-->

<script type="text/javascript"
	src="${staticFileServer}resources/Dynamicjsonjs/z_message.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/Dynamicjsonjs/z_simulation_message.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/Dynamicjsonjs/Definecoursejson.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/Dynamicjsonjs/Addmoduledynamicjson.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/ziksana/jquerylibrary/common/table/tablerow.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/ziksana/jquerylibrary/common/search/search.js"></script>


<script type="text/javascript"
	src="${staticFileServer}resources/js/ziksana/ckeditor/ckeditor.js"></script>

<script type="text/javascript"
	src="${staticFileServer}resources/js/ziksana/coursecreation/define.js"></script>
<!-- scripts for tree -->
<script type="text/javascript"
	src="${staticFileServer}resources/js/tree/gettheme.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/tree/core.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/tree/buttons.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/tree/scrollbar.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/tree/panel.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/tree/dragdrop.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/tree/tree.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/tree/menu.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/tree/myTree.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/tree/splitter.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/tree/jqxexpander.js"></script>
<link rel="stylesheet" type="text/css"
	href="${staticFileServer}resources/css/common/tree/menu.css" />
<link rel="stylesheet" type="text/css"
	href="${staticFileServer}resources/css/common/tree/menu.css" />
<script
	src="${staticFileServer}resources/js/ziksana/jquerylibrary/tree/Common/common.js"></script>
<script
	src="${staticFileServer}resources/js/ziksana/jquerylibrary/tree/Common/dtree.js"></script>
<script
	src="${staticFileServer}resources/js/ziksana/jquerylibrary/tree/Menu/menu.js"></script>
<script
	src="${staticFileServer}resources/js/ziksana/jquerylibrary/tree/Menu/menu_ext.js"></script>
<script
	src="${staticFileServer}resources/js/ziksana/jquerylibrary/tree/treedata.js"></script>
<script
	src="${staticFileServer}resources/js/ziksana/jquerylibrary/tree/Common/tree_ed.js"></script>
<script
	src="${staticFileServer}resources/js/ziksana/jquerylibrary/tree/Common/dataprocessor.js"></script>

<!-- End tree -->
<script
	src="${staticFileServer}resources/js/ui/jquery.mousewheel-3.0.4.pack.js"
	type="text/javascript"></script>

<script src="${staticFileServer}resources/js/custom/libraryfunction.js"
	type="text/javascript"></script>
<script
	src="${staticFileServer}resources/js/ziksana/jquerylibrary/common/tags/superbly-tagfield.min.js"
	type="text/javascript"></script>
<script
	src="${staticFileServer}resources/js/ziksana/validation/jquery.validationen.js"
	type="text/javascript" charset="utf-8"></script>
<script
	src="${staticFileServer}resources/js/ziksana/validation/jquery.validation.js"
	type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css"
	href="${staticFileServer}resources/css/uploadify.css" />








<script type="text/javascript">
	$('document').ready(function() {

		$('#Duration').spinner({
			min : 0,
			max : 20,
			step : 1,
		});
		$('#Credits').spinner({
			min : 0,
			max : 20
		});
		$('#ExtraCredits').spinner({
			min : 0,
			max : 20
		});

	});
</script>

<script type="text/javascript">
	$(document).ready(function(e) {
		$(".containerTableStyle").css('height', '400px');
		$(".containerTableStyle").css('overflow', 'auto');
		self.scrollTo(0,0);
		  $('#homepage_nav').removeClass('current');
	      $('#myprograms_nav').addClass('current');
	});

	var media_server_url = '${ms.url}';
</script>
<script type="text/javascript">
	$(document)
			.ready(function(){
					

						//Fetch course details and populate the form
						getCourse();

						//Course Name Validation for Duplication while creating a course
						$('#defaultvalue')
								.focusout(
										function() {
											var courseId = $('#courseid').val();
											var courseName = $('#defaultvalue')
													.val();
											uri = '/ziksana-web/zcourse/iscourseexists/';
											var parameters = {
												"courseId" : courseId,
												"courseName" : courseName,

											};

											$
													.post(
															uri,
															parameters,
															function(data) {
																console
																		.log(data);
																if (data == 'COURSE EXISTS') {
																	if (courseName != "") {
																		var course = "' "
																				+ courseName
																						.toUpperCase()
																				+ " '";

																		alert("The course "
																				+ course
																				+ " already exists, try with another course name");
																	}
																}
															});
										});

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




	<div id="wrapper">
		<!--Header Container-->
		
		<!--End Header Container-->
		<div class="sub-nav">
			<div class="f-l">
				<strong class="text-size-px12 font-Signika blue"><a
					href="/ziksana-web//zcourse/myprograms">My Courses </a> </strong>|&nbsp;<strong
					class="light-gray text-size-px12 font-Signika">Create New
					Course </strong>
			</div>
			<div class="f-r">
				<a href="#" class="mnuclass"> Manage </a> | <a class="mnuclass"
					href="#"> Publish</a> <a class="light-blue"><img width="12"
					height="12" alt="add more"
					src="${staticFileServer}resources/images/plus.png"> </a>
			</div>
		</div>
		<!--Main Content-->

		<section>
			<div class="section">
				<div class="col-create" style="width: 1000px;">
					<div class="for-rounded-box  all-box-shadow white-bg">
						<!--Wizard start-->
						<div id="page-wrap">
							<c:if test="${courseId == null}">

								<ul class="breadcrumb" style="padding: 1px;">

									<li><a href="/ziksana-web/zcourse/createcourse"
										style="width: 100px; text-align: center;"><span
											class="bcumb">1.</span> Define Course</a></li>

									<li><a style="text-align: center;">2. Organize Content</a></li>

									<li><a style="width: 124px; text-align: center;">3.
											Enrich Content</a></li>

									<li><a
										href="/ziksana-web/resources/html/defineassignment.html"
										style="width: 130px; text-align: center;">4. Define
											Assignment</a></li>
									<li><a
										href="/ziksana-web/resources/html/defineplanner.html"
										style="text-align: center;">5. Define Planner</a></li>
									<li><a
										href="/ziksana-web/resources/html/defineplaybook.html"
										style="text-align: center;">6. Define Playbook</a></li>
									<li><a
										href="/ziksana-web/resources/html/definesocialize.html"
										style="width: 120px; text-align: center;">7. Socialize
											Course</a></li>
									<li></li>
								</ul>
							</c:if>
							<c:if test="${courseId != null}">

								<ul class="breadcrumb" style="padding: 1px;">

									<li><a href="/ziksana-web/zcourse/createcourse/${courseId}"
										style="width: 100px; text-align: center;"><span
											class="bcumb">1.</span> Define Course</a></li>

									<li><a
										href="/ziksana-web/zcourse/associatecontent/${courseId}"
										style="text-align: center;">2. Organize Content</a></li>

									<li><a
										href="/ziksana-web/zcourse/enrichcontent/${courseId}"
										style="width: 124px; text-align: center;">3. Enrich
											Content</a></li>

									<li><a
										href="/ziksana-web/resources/html/defineassignment.html"
										style="width: 130px; text-align: center;">4. Define
											Assignment</a></li>
									<li><a
										href="/ziksana-web/resources/html/defineplanner.html"
										style="text-align: center;">5. Define Planner</a></li>
									<li><a
										href="/ziksana-web/resources/html/defineplaybook.html"
										style="text-align: center;">6. Define Playbook</a></li>
									<li><a
										href="/ziksana-web/resources/html/definesocialize.html"
										style="width: 120px; text-align: center;">7. Socialize
											Course</a></li>
									<li></li>
								</ul>
							</c:if>
						</div>
						<!--Wizard end  -->

						<!--start of first Tab -->


						<div class="definecontainer" id="definetab">


							<!--<a class="btn btn-info f-r saveTop"  id="topSave" style="margin-right:-200px;" >Save and Continue</a>-->
							<form id="DegineCourse" class="form-horizontal formular"
								method="post">
								<div id="EditCourseDetails" class="ecd" style="height: 0px;">
									<!--<input type="button" class="btn btn-info f-r"
										id="Editcoursedtl1" value="Edit Course Details"
										onClick="getCourse(); return false;"
										style="display:none; margin-right: -257px; margin-bottom: 4px; clear: both; display: none;">-->
								</div>

								<br />

								<div class="definehelp"
									style="width: 900px; font-family: Helvetica; font-weight: bold; color: #125F92;">
									<img src="${staticFileServer}resources/images/icons/helpicon.png"
										align="left"
										style="padding-left: 5px; margin-right: 4px; margin-top: -8px;" />Provide
									Course Details
								</div>

								<!----------------- start of first container --------------->
								<div class="_coursename">
									<div class="control-group">
										<input type="hidden" id="courseid" value="${courseId}" /> 
										<input type="hidden" id="moduleexists" value="${module}" />
											
											 <label
											class="control-label labelclass " for="CourseName"
											style="margin-top: -4px; font-weight: bold;">Course
											Name :</label>
										<div class="controls">
											<input type="text" autofocus
												class="defaultvaluem treeRoot validate[required]"
												id="defaultvalue" tabindex="1"
												style="width: 240px; margin-left: 10px; color: #666;"
												maxlength="64" placeholder="Specify the Course Name" />
										</div>

										<br /> <label for="coursedescription" class="labelclass"
											style="font-weight: bold;"><b>Course Description
												:</b></label> <a class="f-r _plainText" href="#" onClick="plainText()"
											style="text-decoration: none;">Plain Text Editor</a> <a
											class="f-r _richText" id="rich_text_editor" href="#"
											onClick="richText()" style="text-decoration: none;">Rich
											Text Editor</a>

										<textarea placeholder="Describe the Course being created"
											cols="124" rows="8" id="Cdescription" tabindex="2"
											class="_plainTextShow defaultvaluem labelclass"
											style="width: 880px; color: #666;"></textarea>
										<br />
										<div class="_richTextShow">
											<textarea placeholder="Describe the Course being created"
												id="Cdescriptionrte" name="editor2" tabindex="2"
												class="defaultvalue _focus"></textarea>
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
											<select name="Careaddl" id="Careaddl" tabindex="3"
												class="defaultvalue labelclass"
												style="margin-right: 15px; width: 200px;">
												<!--  <option value="Select Subject Area">Select Subject
													Area</option> -->


											</select> <select name="Csubjectddl" id="Csubjectddl"
												class="defaultvalue labelclass" tabindex="4"
												style="margin-right: 15px; width: 200px;">
												<option value="Select Subject">Select Subject</option>

											</select> <select name="Ctopicddl" id="Ctopicddl" tabindex="5"
												class="defaultvalue labelclass " style="width: 200px;">
												<option value="Select Topic">Select Topic</option>

											</select>
										</div>
										<!-- end of moduleselection--->

										<div class="coursetags" >
											<br /> <label class="labelclass" for="coursetags"
												style="margin-top: -2px; font-weight: bold;">Specify
												any tags with comma seperator : </label> <br /> <input id="Ctagfield_e" type="text" tabindex="6"
												style="margin-left: 20px; width:350px; height: 50px; overflow:auto;"></input>
											<br /> 
										</div>
										<!-- end of coursetags--->

										<div class="coursecredits">
											<label for="coursetags" class="labelclass"
												style="font-weight: bold;">Specify Course Credits :</label>
											<input type="text" id="Credits" value="0" class=""
												tabindex="7" style="width: 15px; margin-left: 18px;" /> <label
												for="coursetags" class="labelclass"
												style="margin-left: 20px; font-weight: bold;">Specify
												Course Extra Credits :</label> <input type="text" id="ExtraCredits"
												class=" " value="0" tabindex="8"
												style="width: 15px; margin-left: 10px;" />

										</div>
										<!-- end of coursecredits--->

										<div class="courseduration">
											<br /> <label for="coursetags" class="labelclass"
												style="font-weight: bold;">Specify Course Duration :</label>
											<input type="text" id="Duration" value="0" tabindex="9"
												style="width: 15px; margin-left: 9px;" class="" /> <select
												name="SelectArea" id="Cdurationtype" tabindex="10"
												class="defaultvalue" style="margin-left: 20px;">
												<option value="1">Weeks</option>
												<option value="2">Months</option>
												<option value="3">Days</option>

											</select>

										</div>
										<!-- end of courseduration--->

										<!--  <div class="addinformation">
											<a class="lbx-addnew" id="_addNewInfo"
												href="${staticFileServer}zcourse/getaddnlinfo">Add New
												Information </a>
										</div> -->

									</div>
									<!-- end of secondcontainer--->
								</div>
								<!-- end of control group--->


								<!----------------- start of third container --------------->
								<!--<div class="_thirdcontainer">
									 <div class="contentsecurity">

										<img id="aSide"
											src="${staticFileServer}resources/images/tipsy-east.gif"
											align="left"
											style="height: 10px; width: 10px; margin-top: 5px; cursor: pointer;"
											title="View Requirements" /> <img id="aDown"
											src="${staticFileServer}resources/images/tipsy-south.gif"
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
									<br /> <img id="course_thumbnail_image"
										src="${staticFileServer}resources/images/default-course.jpg"
										align="left" /> <input readonly="readonly" type="hidden"
										id="Cimageupl" style="margin-left: 20px;" />


									<div id="thubmnail_upload_message"></div>
									<div id="loaderText"></div>
									<input type="file" name="thumbnail_image_file_upload"
										tabindex="11" id="thumbnail_image_file_upload" />
									<div id="status"></div>
									<script type="text/javascript">
										$(function() {
											$('#thumbnail_image_file_upload')
													.uploadify(
															{
																'swf' : '${staticFileServer}resources/swf/uploadify.swf',
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
																				'#course_thumbnail_image')
																				.attr(
																						'src',
																						'${ms.url}'
																								+ data_object.ContentPath);
																		$(
																				'#thubmnail_upload_message')
																				.html(
																						'<a onclick="remove_uploaded_thumbnail();" title="Remove Image">[X] Remove</a>');

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

										function remove_uploaded_thumbnail() {
											$('#Cimageupl').val('');//clear uploaded file path
											$('#thubmnail_upload_message')
													.html('');
											$('#course_thumbnail_image')
													.attr('src',
															'${staticFileServer}resources/images/default-course.jpg');

										}
									</script>


								</div>
								<!-- end of associateimage--->
						</div>
						<!-- end of third container--->

						<input type="submit" class="btn btn-info f-r" id="sbtvalidation"
							tabindex="13" value="Submit"
							onClick="createCourse(); return false;"
							style="margin-right: 10px;">
						<!-- <a href="${staticFileServer}zcourse/createmodule/${courseId}"
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
								<img src="${staticFileServer}resources/images/icons/helpicon.png"
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
										<img src="${staticFileServer}resources/images/instruction.png"
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
		function testCall() {
			alert("Please create a Course and add modules");
		}
	</script>


	<!--End Current Progress-->
	<!--Footer Container-->
	<!--End Footer Container-->
