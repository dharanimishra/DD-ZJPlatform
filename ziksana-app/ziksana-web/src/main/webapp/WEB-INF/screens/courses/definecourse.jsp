<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href="${staticFileServer}resources/css/main/styles2.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${staticFileServer}resources/css/main/icons.css"
	rel="stylesheet" type="text/css" />
<link href="${staticFileServer}resources/css/stylesheets.css"
	rel="stylesheet" type="text/css" />

<link rel="stylesheet"
	href="${staticFileServer}resources/css/common/tags/superbly-tagfield.css" />

<script type='text/javascript'
	src='${staticFileServer}resources/js/lib/jquery/jquery-1.9.1.min.js'></script>
<script type='text/javascript'
	src='${staticFileServer}resources/js/lib/jquery/jquery-ui-1.10.1.custom.min.js'></script>
<script type='text/javascript'
	src='${staticFileServer}resources/js/lib/jquery/jquery-migrate-1.1.1.min.js'></script>
<script type='text/javascript'
	src='${staticFileServer}resources/js/custom/respond.min.js'></script>
<script type='text/javascript'
	src='${staticFileServer}resources/js/lib/ckeditor/ckeditor.js'></script>
<script type='text/javascript'
	src="${staticFileServer}resources/js/lib/uniform/jquery.uniform.min.js"></script>
<script type='text/javascript'
	src='${staticFileServer}resources/js/lib/tagsinput/jquery.tagsinput.min.js'></script>
<script type='text/javascript'
	src="${staticFileServer}resources/js/lib/select/select2.min.js"></script>
<script type='text/javascript'
	src="${staticFileServer}resources/js/lib/plupload/previewupload.js"></script>
<script type='text/javascript'
	src='${staticFileServer}resources/js/custom/plugins.js'></script>

<script type="text/javascript"
	src="${staticFileServer}resources/js/ziksana/coursecreation/define.js"></script>

<script type="text/javascript"
	src="${staticFileServer}resources/Dynamicjsonjs/z_message.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/Dynamicjsonjs/z_simulation_message.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/Dynamicjsonjs/Definecoursejson.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/ziksana/jquerylibrary/common/table/tablerow.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/ziksana/jquerylibrary/common/search/search.js"></script>
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
		self.scrollTo(0, 0);
		$('#homepage_nav').removeClass('current');
		$('#myprograms_nav').addClass('current');
	});

	var media_server_url = '${ms.url}';
</script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//Fetch course details and populate the form
						console.log("on page ...");
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

<script type="text/javascript">
	function showrich() {

		$('._richTextShow').css("display", "none");
		$('#richText').css("display", "none");
		$('._plainTextShow').show();
		$('#plainText').css("display", "block");
	}
	function showplain() {

		$('._richTextShow').css("display", "block");
		$('#richText').css("display", "block");
		$('._plainTextShow').css("display", "none");
		$('#plainText').css("display", "none");
	}

	function getArea() {
		$
				.get(
						'/ziksana-web/zcourse/getsubjectarea',
						{},
						function(data) {
							options = data;
							var option_string = '';
							for (i in options) {
								label = options[i].label;
								value = options[i].value;
								if (i == 0) {
									option = '<option selected="selected" value="' + value
							+ '">'
											+ label + '</option>';
								} else
									option = '<option value="' + value + '">'
											+ label + '</option>';

								option_string += option;
							}
							$('#Careaddl').html(option_string);

						});

		//	}

		//function getSubject() {
		$("#Careaddl")
				.change(
						function(e) {
							token = '';
							request_type = 'GET';
							uri = '/ziksana-web/zcourse/getsubject';

							var Course_Area = '';
							Course_Area = $('#Careaddl').val();
							$
									.get(
											uri,
											{
												'Course_Area' : Course_Area
											},
											function(data) {
												options = data;
												var option_string = '';
												var area_string = '<option selected="selected" value='+Course_Area+'>'
														+ Course_Area
														+ '</option>';
												option_string += '<option selected="selected" value="Select Subject">Select Subject</option>';
												for (i in options) {
													label = options[i].label;
													value = options[i].value;
													if (i == 0) {
														option = '<option  value="'
											+ value
											+ '">'
																+ label
																+ '</option>';
													} else

														option = '<option value="'
											+ value
											+ '">'
																+ label
																+ '</option>';

													option_string += option;
												}

												$('#Careaddl')
														.html(area_string);
												$('#Csubjectddl').html(
														option_string);

											});
							var topic = '<option value="Select Topic">Select Topic</option>';
							$('#Ctopicddl').html(topic);
						});

		//}

		//function getTopic() {

		$("#Csubjectddl")
				.change(
						function(e) {
							console.log("Inside subject change handler");
							uri = '/ziksana-web/zcourse/gettopic';
							token = '';
							request_type = 'GET';
							var Course_Subject = $('#Csubjectddl').val();
							var parameters = {
								"Course_Subject" : Course_Subject
							};

							$
									.get(
											uri,
											{
												'Course_Subject' : Course_Subject
											},
											function(data) {
												options = data;
												var option_string = '';
												option_string += '<option selected="selected" value="Select Topic">Select Topic</option>';
												for (i in options) {
													label = options[i].label;
													value = options[i].value;
													if (i == 0) {
														option = '<option value="'
											+ value
											+ '">'
																+ label
																+ '</option>';
													} else

														option = '<option value="'
											+ value
											+ '">'
																+ label
																+ '</option>';

													option_string += option;
												}

												$('#Ctopicddl').html(
														option_string);

											});

						});
		//}
	} // End getArea()
</script>


<div id="background">



	<div id="wrapper">
		<section>
			<div id="headercontainer">

				<div id="HeaderLogo" class="f-l">

					<img src="/ziksana-web/resources/images/home/loginlogo.png"
						style="height: 80px;" />

				</div>
				<!--end of headerlogo-->

				<div class="clearfix"></div>


			</div>
			<div id="leftpanel">
				<div id="Zikbreadcrumbback" style="margin-left: 20px;">

					<div class="Zikbreadcrumb f-l">

						<div class="fifteen columns" id="page-title">
							<a class="back" href="javascript:history.back()"></a>
							<p class="page-title">
								<span style="font-size: 13px; color: #6bbde8;">Home</span> <
								Create Course
							</p>

							<!-- <div class="breadcrumbs"><a href="#linkurl">Home</a> <span class="delim">/</span> Create Course</div>-->
						</div>

					</div>
					<!--end of breadcrumb-->


					<!--<div class="ProfileRibbon f-r"><img src="../images/home/ribbon.png" alt="Recommendations" style="position:relative;"/>

						<p class="ProfileRibbonhead"><a href="#linkurl"> A few Recommendations for you to Optimize time and meet your goals today </a></p>
						</div>-->
					<!--end of ProfileRibbon-->

					<!--<div id="ZikSearch" class="f-r"> 
   
 <div id="search">
<div class="search-input form-search">
<input id="s" name="q" onblur="if (this.value == '') {this.value = 'Search';}" onfocus="if (this.value == 'Search') {this.value = '';}" type="text" value="Search">
<input id="buttonsinput" style="vertical-align: top;" type="submit" value="">
</div></div>   

</div>-->
					<!--end of Ziksearch-->


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
											<img
												src="${staticFileServer}resources/images/icons/toola.png"
												class="tbboximg" /><span class="tbboxheadfnt">
												Define </span>
										</p>

									</div>
									<!--end of tbboxhead  -->

									<div class="tbboxnum">

										<span class="badge1 badge-warning" style="font-size: 20px;">
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
											<img
												src="${staticFileServer}resources/images/icons/review.png"
												class="tbboximgds" /><span class="tbboxheadfntds">
												Enrich </span>
										</p>

									</div>
									<!--end of tbboxhead  -->


									<div class="tbboxnumds">

										<span class="badge1" style="font-size: 20px;"> 2. </span>
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
											<img
												src="${staticFileServer}resources/images/icons/publish1.png"
												class="tbboximgds" /><span class="tbboxheadfntds">
												Publish </span>
										</p>

									</div>
									<!--end of tbboxhead  -->


									<div class="tbboxnumds">

										<span class="badge1 badge-warningds" style="font-size: 20px;">
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


						<div class="navheadlp">

							<ul>
								<li style="margin-left: 40px; color: #0a91ac;">Describe
									Course</li>
								<li>Define Structure</li>
								<li>Associate Content</li>
								<li>Define Assignment</li>

							</ul>

						</div>
						<!--end of navheadlp-->

						<div class="arrow1"></div>
						<div class="clearfix"></div>


						<div class="progress-bar blue stripes">
							<span style="width: 20%"></span>
						</div>
						<div class="clearfix"></div>
						<div class="navnumber">
							<ul>
								<li>
									<div class="circle-outer1">
										<a class="circle orange1" href="definecourse.html">1</a>
									</div> <!--circle-outer ends here-->
								</li>
								<li>
									<div class="circle-outer0" style="margin-left: 30px;">
										<a class="circle orange0" href="definestructure.html">2</a>
									</div> <!--circle-outer ends here-->
								</li>
								<li>
									<div class="circle-outer0">
										<a class="circle orange0" href="associatecontent.html">3</a>
									</div> <!--circle-outer ends here-->
								</li>
								<li>
									<div class="circle-outer0" style="margin-left: 50px;">
										<a class="circle orange0" href="defineassignment.html">4</a>
									</div> <!--circle-outer ends here-->
								</li>
							</ul>
						</div>
						<!--end of navnumber-->

						<div class="clearfix"></div>
					</div>
					<div id="formcontainer">
						<div class="page-header">
							<div class="icon">
								<img src="../images/icons/information_icon.png"
									style="height: 25px;" />
							</div>
							<h1>Provide Course Details</h1>
						</div>
						<div class="widget-body form">
							<!-- BEGIN FORM-->
							<form id="DegineCourse" method="post" class="form-horizontal">
								<!--Course Name-->
								<div class="_coursename">
									<div class="control-group">
										<input type="hidden" id="courseid" value="${courseId}" /> <input
											type="hidden" id="moduleexists" value="${module}" /> <label
											class="control-label labelclass " for="CourseName"
											style="margin-top: -4px; font-weight: bold;">Course
											Name :</label>
										<div class="controls">
											<input type="text" autofocus
												class="defaultvaluem treeRoot validate[required] "
												id="defaultvalue"
												style="width: 240px; margin-left: 10px; color: #666;"
												tabindex="1" placeholder="Model Thinking" />
										</div>

										<br /> <label for="coursedescription" class="labelclass"
											style="font-weight: bold;"><b>Course Description
												:</b></label> <a class="f-r _plainText" id="plainText" href="#linkurl"
											style="text-decoration: none;" onclick="showplain()">Rich
											Text Editor</a> <a class="f-r _richText" id="richText"
											href="#linkurl" style="text-decoration: none; display: none;"
											onclick="showrich()">Plain Text Editor</a>
										<textarea cols="124" rows="8" id="Cdescription"
											class="_plainTextShow defaultvaluem labelclass"
											style="width: 100%; color: #666;"> 
											</textarea>
										<br />
										<div class="_richTextShow" style="display: none;">
											<textarea id="Cdescriptionrte" name="editor1pageload"
												class="defaultvalue _focus">
													<b>Describe the Course being created</b>
												</textarea>
										</div>
										<script type="text/javascript">
											CKEDITOR.replace('Cdescriptionrte');
										</script>

									</div>
									<!-- end of coursename--->
								</div>
								<!-- end of control group--->
								<!--	<textarea placeholder="Course Description" name="Course_Description" 
     									 id="Course_Description" ></textarea>
   										 <textarea id="ckeditor" style="height: 300px;"></textarea>  -->
								<!--Course Selection-->
								<div class="control-group" style="margin-top: 20px;">

									<div>
										<label class="labelclass nexaf f-l"> Course Area : </label> <label
											class="labelclass nexaf f-l" style="margin-left: 160px;">
											Course Subject: </label> <label class="labelclass nexaf f-l"
											style="margin-left: 145px;"> Course Topic: </label>
									</div>

									<div class="clearfix"></div>


									<div class="moduleselection">
										<select name="Careaddl" id="Careaddl"
											class="defaultvalue labelclass" onclick="getArea();">
											<option value="0">choose a option...</option>
										</select> <select name="Csubjectddl" id="Csubjectddl"
											class="defaultvalue labelclass">
											<option value="0">choose a option...</option>
										</select> <select name="Ctopicddl" id="Ctopicddl"
											class="defaultvalue labelclass">
											<option value="0">choose a option...</option>
										</select>
									</div>
									<!-- end of moduleselection--->

								</div>
								<!--end of Subject Selection-->



								<div class="control-group" style="width: 69%">
									<label class="control-label nexaf" for="Specify Tags">Specify
										Tags :</label>
									<div class="controls">
										<input id="Ctagfield_e" type="text" class="tags"
											value="Computer Science, Literature, History" />
									</div>
								</div>
								<div class="control-group f-l">
									<label class="control-label nexaf" for="Course Credits"
										style="width: 230px;">Specify Course Credits :</label>
									<div class="controls" style="margin-left: 230px; width: 92px">
										<input type="text" name="spi" id="spinner" value="1"
											style="width: 50px;" />
									</div>
								</div>
								<div class="control-group f-l">
									<label class="control-label nexaf" for="Course Credits"
										style="margin-left: 20px; width: 280px;">Specify
										Course Extra Credits :</label>
									<div class="controls" style="width: 212px;">
										<input type="text" name="spi" id="spinner2" value="1"
											style="width: 50px;" />
									</div>
								</div>
								<div class="clearfix"></div>
								<div class="control-group f-l">
									<label class="control-label nexaf" for="input"
										style="width: 230px;">Specify Course Duration :</label>
									<div class="controls" style="margin-left: 230px; width: 92px">
										<input type="text" name="spi" id="spinner3" value="1"
											style="width: 50px;" />
									</div>
								</div>


								<select name="SelectArea" id="Cdurationtype"
									class="defaultvalue f-l" style="margin-left: 20px;">
									<option value="1">Weeks</option>
									<option value="2">Months</option>
									<option value="3">Days</option>
								</select>
								<div class="clearfix"></div>
								<!--  <div class="control-group">
									<label class="control-label nexaf" for="Asscoiate Content"
										style="width: 230px;"> Associate an Image for the
										Course :</label>
									<div class="controls">

										<div class="fileupload fileupload-new"
											data-provides="fileupload">
											<div class="fileupload-new thumbnail"
												style="width: 50px; height: 50px;">
												<img src="http://www.placehold.it/50x50/EFEFEF/AAAAAA" />
											</div>
											<div class="fileupload-preview fileupload-exists thumbnail"
												style="width: 70px; height: 50px;"></div>
											<span class="btn btn-file"><span
												class="fileupload-new">Upload image</span><span
												class="fileupload-exists">Change</span> <input type="file"
												name="thumbnail_image_file_upload"
												id="thumbnail_image_file_upload1" /></span> <a href="#"
												class="btn fileupload-exists" data-dismiss="fileupload">Remove</a>
										</div>
										<div id="status"></div>
									</div>
								</div> -->

								<div style="margin-top: 30px;">

									<p class="labelclass" style="font-weight: bold;">Associate
										an Image for your Course</p>
									<br /> <img id="course_thumbnail_image"
										src="${staticFileServer}resources/images/default-course.jpg"
										align="left" /> <input readonly="readonly" type="hidden"
										id="Cimageupl" style="margin-left: 20px;" />

									<div id="message"></div>
									<div id="thubmnail_upload_message"></div>
									<div id="loaderText"></div>
									<input type="file" name="thumbnail_image_file_upload"
										tabindex="11" id="thumbnail_image_file_upload" />
									<div id="status"></div>
									<script type="text/javascript">
										$(function() {
											alert("test");
											$('#thumbnail_image_file_upload')
													.uploadify(
															{
																'swf' : '${staticFileServer}resources/swf/uploadify.swf',
																'queueSizeLimit' : 1,
																'successTimeout' : 350,
																'uploader' : '${ms.uploadScript}',
																//'uploader' : 'http://54.243.235.88/zikload-xml/uploadify.php',
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
																'debug' : true,
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
								<button class="btn f-r" type="button"
									onClick="createCourse();return false;">Save and
									Continue</button>
								<div class="clearfix"></div>
							</form>
						</div>

					</div>

				</div>
				<!--end of contentpanel-->


			</div>
			<!--end of leftpanel-->


		</section>
		<!--end of section leftpanel-->

		<div class="Clearfix"></div>

	</div>
	<!--end of body wrapper-->

</div>

