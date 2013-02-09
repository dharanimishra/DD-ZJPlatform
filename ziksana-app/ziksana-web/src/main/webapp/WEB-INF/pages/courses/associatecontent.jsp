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
	src="/ziksana-web/resources/Dynamicjsonjs/Associatecontentjson.js"></script>
<script type="text/javascript"
	src="/ziksana-web/resources/Dynamicjsonjs/Addmoduledynamicjson.js"></script>
<script type="text/javascript"
	src="/ziksana-web/resources/js/ziksana/jquerylibrary/common/table/tablerow.js"></script>
<script type="text/javascript"
	src="/ziksana-web/resources/js/ziksana/jquerylibrary/common/search/search.js"></script>
<script type="text/javascript"
	src="/ziksana-web/resources/js/ziksana/ckeditor/ckeditor.js"></script>
<script type="text/javascript"
	src="/ziksana-web/resources/js/ziksana/jquerylibrary/common/spinner/smartspinner.js"></script>
<script type='text/javascript'
	src="/ziksana-web/resources/js/ziksana/coursecreation/associate.js"></script>
<script type='text/javascript'
	src="/ziksana-web/resources/js/custom/course_associate.js"></script>
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
	src="/ziksana-web/resources/js/tree/menujq.js"></script>
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
	src="/ziksana-web/resources/js/ziksana/jquerylibrary/tree/treedataassociate.js"></script>
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


<script type="text/javascript">
$(document).ready(function(e) {
$(".containerTableStyle").css('height','400px');
$(".containerTableStyle").css('overflow','auto');

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

	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		jQuery("#Associatequalifier").validationEngine();
	});
</script>
<link rel="stylesheet" type="text/css"
	href="/ziksana-web/resources/css/uploadify.css" />
<script type="text/javascript"
	src="/ziksana-web/resources/js/jquery.uploadify-3.1.min.js"></script>
<script type="text/javascript"
	src="/ziksana-web/resources/js/custom/jquery.uploadify-3.1.min.js"></script>
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

.breadcrumb li:nth-child(2) a {
	background: #6D9EC5;
	color: #fff;
}

.breadcrumb li:nth-child(2) a:after {
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

span.standartTreeRow:hover {
	background: rgba(85, 142, 187, 0.63);
	color: #fff;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	border-radius: 3px;
	padding: 3px;
}

.containerTableStyle { /* overflow: scroll;
	overflow-y: hidden; */
	
}
</style>
</head>

<body onLoad="self.scrollTo(0,0)">

	<div id="wrapper">
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


			</div>
			<nav>
				<div class="menu" style="margin-left: 0px;">
					<ul>
						<li><a href="/ziksana-web/secure/educatordashboard ">My
								Home</a>
							<div class="nav-line"></div></li>
						<li><a href="/ziksana-web/secure/showMyPrograms"
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
		<div class="sub-nav">
			<div class="f-l">
				<strong class="text-size-px12 font-Signika blue"><a
					href="/ziksana-web/secure/showMyPrograms">My Courses </a> </strong><strong
					class="light-gray text-size-px12">Create New Course </strong>
			</div>
		<div class="f-r">
				<strong class="text-size-px14 light-gray"><a>Publish</a> |
					<a>Manage</a></strong><a class="light-blue"><img width="12" height="12"
					alt="add more" src="/ziksana-web/resources/images/plus.png">
				</a>
			</div>
		</div>
		<!--Main Content-->

		<section>
			<div class="section">



				<div class="col-create" style="width: 1000px;">
					<div class="for-rounded-box all-box-shadow white-bg">



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
								<li><a href="" style="width: 130px; text-align: center;">4.
										Define Assignment</a></li>
								<li><a href="" style="text-align: center;">5. Define
										Planner</a></li>
								<li><a href="" style="text-align: center;">6. Define
										Playbook</a></li>
								<li><a href="" style="width: 120px; text-align: center;">7.
										Socialize Course</a></li>
								<li></li>
								<!--<li><a href="#">Hidden</a></li>-->
							</ul>


						</div>
						<!--Wizard end -->

						<!--start of first Tab -->


						<div class="definecontainer" id="definetab">
							<span style="font-size:16px; font-wight:bold;  color:#27b;">Organize and Enhance Content</span>
							<!--<a class="btn btn-info f-r saveTop" id="topSave" style="margin-right:-200px;" >Save and Continue</a>-->
						</div>
						<br>  <input type="hidden" id="courseid"
							value="${courseId}" /> <input type="hidden"
							id="courseLearningComponentId" value="" /> <input type="hidden"
							id="learningComponentId" value="" /> <input type="hidden"
							id="learningContentId" value="" /> <input type="hidden"
							id="ContentPath" name="ContentPath" value="" /> <input
							type="hidden" id="ThumbnailPicturePath"
							name="ThumbnailPicturePath" value="" /> <input type="hidden"
							id="NumberOfThumbnails" name="NumberOfThumbnails" value="" /> <input
							type="hidden" id="ContentType" name="ContentType" value="" />

						<style type="text/css">
#splitter {
	width: 975px;
	height: auto;
}

#jqxTree {
	height: auto;
	width: auto;
}
</style>

						<div id="gggg" style="font-size: 10px; margin-bottom: 10px;">

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
									setImagePath="/ziksana-web/resources/js/ziksana/jquerylibrary/tree/treeimages/csh_bluebooks/">
								</div>


								<!-- End of Tree -->


								<div id="ContentPanel2"
									style="font-size: 11px; background-image: none; margin-left: 25px;">
									<!-- Start of Default Instruction -->

								<div id="instruction" style="padding: 10px;">
										<img src="/ziksana-web/resources/images/ContentContextualHelp1.jpg"
											class="all-box-shadow" alt="instructions"
											title="Key-Board instruction" width="720"
											style="border: 1px solid #ccc; padding: 5px; border: 1px solid #ccc;">
									</div>

									<!-- End of Default Instruction -->


									<div class="definecontainer" id="associatedefinecontainer">

										<div class="definehelp"
											style="width: 680px; font-family: Helvetica; font-weight: bold; color: #125F92; line-height: 20px;">
											<img src="/ziksana-web/resources/images/icons/helpicon.png"
												align="left" style="margin-right: 5px;" />Create new
											content by either uploading an already available content, <br />
											providing an URL reference or by Creating a document as your
											content.
										</div>

										<form id="Associatequalifier" class="form-horizontal">
											<!----------------- start of first container --------------->
											<div class="coursename">
												<div class="control-group">
													<label class="control-label labelclass" for="Content Name"
														style="margin-top: -4px; font-weight: bold;">Content
														Name:</label>
													<div class="controls">
														<input type="text" id="contentname"
															class="defaultvalue validate[required]" autofocus
															placeholder="Specify the name of the Content"
															style="width: 240px; margin-left: 10px; color: #666;" />
													</div>

													<br /> <label for="moduledescription" class="labelclass"
														style="font-weight: bold;">Content Description :</label> <a
														class="f-r _richText" href="#linkurl"
														style="text-decoration: none;">Rich Text Editor</a> <a
														class="f-r _plainText" href="#linkurl"
														style="text-decoration: none;">Plain Text Editor</a>
													<textarea placeholder="Describe the Content being created"
														class="_plainTextShow labelclass defaultvalue" cols="90"
														rows="7" style="resize: none;color: #666;"> </textarea>
													<br />
													<div class="_richTextShow">
														<textarea placeholder="Describe the Content being created"
															id="Associatecdescrte" name="Associatecdescrte"
															class="defaultvalue _focus"></textarea>
													</div>

												</div>
												<!-- end of coursename--->
											</div>
											<!-- end of control group--->

											<!----------------- start of second container --------------->
											<div class="secondcontainer">
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
														<select name="Careaddl" id="Careaddl"
															class="defaultvalue labelclass"
															style="margin-right: 15px; width: 200px;">
															<option value="">Select Subject Area</option>

														</select> <select name="Csubjectddl" id="Csubjectddl"
															class="defaultvalue labelclass"
															style="margin-right: 15px; width: 200px;">
															<option value="">Select Subject</option>

														</select> <select name="Ctopicddl" id="Ctopicddl"
															class="defaultvalue labelclass" style="width: 200px;">
															<option value="">Select Topic</option>
														</select>
													</div>
													<div class="coursetags">
														<br /> <label class="control-label labelclass"
															for="contenttags"
															style="margin-top: -2px; font-weight: bold;">Specify
															any tags : </label> <input type="text" id="Associatetag"
															style="margin-left: 290px;color: #666;"></input> <br />
													</div>
													<!-- end of coursetags--->
													<img src="/ziksana-web/resources/images/icons/upload.png"
														align="left" /><label class="control-label labelclass"
														for="uploadimage"
														style="margin-top: -2px; font-weight: bold;">Upload
														any Image for the Content : </label> <input type="hidden"
														readonly="readonly" id="Cimageupl" class="labelclass" />
													<div id="thubmnail_upload_message"></div>
													<div id="loaderText"></div>
													<input type="file" name="thumbnail_image_file_upload"
														id="thumbnail_image_file_upload" />
													<div id="status"></div>
													<script type="text/javascript">
													var mediaserver_url = '${ms.url}';
													
													</script>
													<script type="text/javascript">
														$(function() {
															
															$(
																	'#thumbnail_image_file_upload')
																	.uploadify(
																			{
																				'swf' : '/ziksana-web/resources/swf/uploadify.swf',
																				'queueSizeLimit' : 1,
																				'uploader' : '${ms.uploadScript}',
																				'fileTypeExts' : '*.gif; *.jpg; *.jpeg; *.png',
																				'fileSizeLimit' : '10024KB',
																				'onUploadStart': function(file){ $('#btnsbtassoccontent').attr('disabled','disabled'); },
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
																					$('#btnsbtassoccontent').removeAttr('disabled'); //enable submit button
																				}
																			// Your options here
																			});
														});
													</script>




												</div>
												<!-- end of secondcontainer--->
											</div>
											<!-- end of control group--->

											<div class="forthcontainer">
												<!-- start of forth container--->

												<div class="moduleselection">
													<select name="q_type"
														class="defaultvalue labelclass validate[required]"
														id="q_type" style="margin-right: 15px; width: 410px;">
														<option value="">Select how would you like to add
															Content</option>
														<option value="UploadContent">Upload Content</option>

														<!--  <option value="ExternalWebPage">Associate URL of
															the Content</option>

														<option value="CreateContent">Create Content</option> -->
													</select>
												</div>
												<!-- end of moduleselection--->
												<br />
												<div id="type-1">
													<img src="/ziksana-web/resources/images/icons/upload.png"
														align="left" /><label class="control-label labelclass"
														for="uploadimage"
														style="margin-top: -2px; font-weight: bold;">Upload
														the Content (mp4/mp3/doc/docx/ppt/pptx/pdf): </label>

													<div id="message"></div>
													<div id="loaderText"></div>
													<input type="file" name="file_upload" id="file_upload" />
													<div id="status"></div>
													<script type="text/javascript">
														$(function() {
															$('#file_upload')
																	.uploadify(
																			{
																				'swf' : '/ziksana-web/resources/swf/uploadify.swf',
																				'queueSizeLimit' : 1,
																				'successTimeout' : 350,
																				'uploader' : '${ms.uploadScript}',
																				//'debug': true,
																				//'scriptData':{'contentId': $('#learningContentId').val().split('_')[1]},
																				'onUploadStart': function(file){ $('#btnsbtassoccontent').attr('disabled','disabled'); },
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
																						//console.log('inside true');
																						//$('#message').html(data_object);
																						$('#ContentPath').val(data_object.ContentPath);
																						$('#ThumbnailPicturePath').val(data_object.ThumbnailPicturePath);
																						$('#NumberOfThumbnails').val(data_object.NumberOfThumbnails);
																						$('#ContentType').val(
																										data_object.ContentType);
																						$(
																								'#message')
																								.html(
																										'Upload Successful! You may now click Submit Button to Associate the Content!');

																					} else { //there is an error in the upload process

																						$(
																								'#message')
																								.html(
																										data_object.message);
																					}
																					
																					$('#btnsbtassoccontent').removeAttr('disabled'); //enable submit button

																				}
																			// Your options here
																			});
														});
													</script>


												</div>
												<!----- end of type=1 --->

												<div id="type-2">
													<label class="control-label labelclass" for="uploadimage"
														style="margin-top: -2px;">Associate URL: </label> <input
														type="text" id="defaultvalue"
														class="defaultvalue validate[required]"
														placeholder="Provide the full URL/Web Address including HTTP://"
														style="width: 310px; margin-left: 10px;" />
												</div>
												<!----- end of type=2 --->

												<div id="type-3">
													<label for="moduledescription" class="labelclass">Content
														Description :</label> <br /> <br />
													<textarea id="q_typecdesdcrte" name="q_typecdesdcrte"
														class="defaultvalue validate[required]">Type the Content Here</textarea>

												</div>
												<!----- end of type=2 --->

											</div>
											<!-- end of forth container--->

											<div class="buttonassoc" style="height: 20px;">
												<a class="cancellinkassociatecontent btn btn-info" href=""
													style="float: right; margin-right: 20px; text-decoration: none;">
													Cancel </a> <input type="submit" class="btn btn-info"
													id="btnsbtassoccontent" value="Submit"
													onClick="getAssociateContentSave(); return false;"
													style="float: right; margin-right: 20px; text-decoration: none;" />

											</div>
										</form>
									</div>
									<!-- End of Associate Content associatedefinecontainer -->



									<!-- Start of Search & Associate Content -->

									<!-- End of Search & Associate Content -->





								</div>
								<!-- Content Panel End -->

								<a class="btn btn-info"
									href="/ziksana-web/secure/enrichcontent/${courseId}"
									style="float: right; margin-bottom: 20px; margin-top: 20px;"
									id="">Save and Continue</a>



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
	<style rel="text/css">
#SWFUpload_1 {
	left: 0;
	cursor: pointer;
	top: 2px;
}
</style>
</body>
</html>
