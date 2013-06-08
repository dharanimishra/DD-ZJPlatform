
<script type='text/javascript' src="${staticFileServer}resources/js/custom/plugins.js"></script>

<script type='text/javascript'
	src='${staticFileServer}resources/js/lib/tagsinput/jquery.tagsinput.min.js'></script>

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


<script type="text/javascript">
	$('document').ready(function() {
		$('#spinner').spinner({
			numberFormat: "n",
			min : 0,
			max : 20,
			
		});
		$('#spinner2').spinner({
			min : 0,
			max : 20
		});
		$('#spinner3').spinner({
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
	/* function showrich() {

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
	} */

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
<script>
function inputLimiter(e,allow) {
    var AllowableCharacters = '';
     if (allow == 'Numbers'){AllowableCharacters='1234567890';}
       var k = document.all?parseInt(e.keyCode): parseInt(e.which);
    if (k!=13 && k!=8 && k!=0){
        if ((e.ctrlKey==false) && (e.altKey==false)) {
        return (AllowableCharacters.indexOf(String.fromCharCode(k))!=-1);
        } else {
        return true;
        }
    } else {
        return true;
    }
}

</script>
<style>
.uploadify {margin-left:260px;}
.remove {
    background: none repeat scroll 0 0 #43B2EC;
    border: 0 none;
    border-radius: 6px 6px 6px 6px;
    color: #F9F9F9;
    cursor: pointer !important;
    float: left;
    margin-bottom: 3px;
    margin-left: -11px;
    padding: 5px;
    position: relative;
    text-align: center;
    text-decoration: none !important;
    text-shadow: none;
    top: 121px;
    width: 92px;
}
.remove:hover{width: 92px;}
 

</style>

<div class="navheadlp" style="padding-left: 151px;">
	<ul>
		<li style="margin-left: 40px; color: #f06c0b;"><span> <img
				src="/ziksana-web/resources/images/navarrow.png"
				style="margin-right: 10px; height: 22px;">
		</span> <fmt:message key="course.DescribeCourse"/></li>
		<li><span><img
				src="/ziksana-web/resources/images/navarrowb.png"
				style="margin-right: 10px; height: 22px;"> </span><fmt:message key="Define.Structure"/></li>
		<li><span><img
				src="/ziksana-web/resources/images/navarrowb.png"
				style="margin-right: 10px; height: 22px;"> </span><fmt:message key="Associate.content"/> </li>
		<li><span><img
				src="/ziksana-web/resources/images/navarrowb.png"
				style="margin-right: 10px; height: 22px;"> </span><fmt:message key="Define.assignment"/> </li>

	</ul>

</div>


<div class="clearfix"></div>
<div id="formcontainer">
	<div class="page-header">
		<div class="icon">
			<img
				src="${staticFileServer}resources/images/icons/information_icon.png"
				style="height: 25px;" />
		</div>
		<h1><fmt:message key="Provide.Course.Details"/></h1>
	</div>
	<div class="widget-body form">
		<!-- BEGIN FORM-->
		<form id="DegineCourse" method="post" class="form-horizontal">
			<!--Course Name-->
			<div class=" ">
				<div class="control-group">
					<input type="hidden" id="courseid" value="${courseId}"  /> <input
						type="hidden" id="moduleexists" value="${module}" /> <label
						class="control-label nexaf" for="Course Name"><fmt:message key="Course.name"/>
						</label>
					<div class="controls">
						<input type="text" autofocus
							class="defaultvaluem treeRoot validate[required]"
							id="defaultvalue" maxlength="64"
							style="width: 240px; margin-left: 10px; color: #666;"
							tabindex="1" placeholder="<fmt:message key="course.enter.name"/>" />
					</div>

					<br /> <label for="Course Description" class="nexaf"><fmt:message key="course.description"/></label>
					 <!-- <a class="f-r _plainText" id="plainText"
						href="#linkurl" style="text-decoration: none;"
						onclick="showplain()">Rich Text Editor</a> <a
						class="f-r _richText" id="richText" href="#linkurl"
						style="text-decoration: none; display: none;" onclick="showrich()">Plain
						Text Editor</a> -->
				<!-- 	<textarea cols="124" rows="8" id="Cdescription"
						class="_plainTextShow defaultvaluem labelclass"
						style="width: 100%; color: #666;"> 
											</textarea> -->
					<br />
					<div class="_richTextShow">
						<textarea id="Cdescriptionrte" name="editor1pageload"
							class="defaultvalue _focus">
													<b><fmt:message key="course.descrip.placeholder"/></b>
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
					<label class="labelclass nexaf f-l"> <fmt:message key="course.area"/> </label> <label
						class="labelclass nexaf f-l" style="margin-left: 217px;">
						<fmt:message key="course.subject"/></label> <label class="labelclass nexaf f-l"
						style="margin-left:200px;"><fmt:message key="course.topic"/></label>
				</div>

				<div class="clearfix"></div>

				<div class="moduleselection">
					<select name="s_example" id="Careaddl" class="select"
						onclick="getArea();">
						<option value="0"><fmt:message key="course.choose.option"/></option>
					</select> <select name="s_example" class="select" id="Csubjectddl">
						<option value="0"><fmt:message key="course.choose.option"/></option>
					</select><select name="s_example" class="select" id="Ctopicddl">
						<option value="0"><fmt:message key="course.choose.option"/></option>
					</select>
					<!-- <select name="Careaddl" id="Careaddl"
											class="defaultvalue labelclass" onclick="getArea();">
											<option value="0">choose a option...</option>
										</select> -->
					<!-- <select name="Csubjectddl" id="Csubjectddl"
											class="defaultvalue labelclass">
											<option value="0">choose a option...</option>
										</select> <select name="Ctopicddl" id="Ctopicddl"
											class="defaultvalue labelclass">
											<option value="0">choose a option...</option>
										</select> -->
				</div>
				<!-- end of moduleselection--->

			</div>
			<!--end of Subject Selection-->
			<div class="control-group" style="width: 65%">
				<label class="control-label nexaf" for="Specify Tags" style="width:229px">Specify
					Tags :</label>
				<div class="controls" style="margin-left:229px">
					<input type="text" class="tags" id="Ctagfield_course"
						value="" />
				</div>
			</div>
			<div class="control-group f-l">
				<label class="control-label nexaf" for="Course Credits"
					style="width: 230px;">Specify Course Credits :</label>
				<div class="controls" style="margin-left: 230px; width: 92px">
					<input type="text" name="spi" id="spinner" value="0" 
						style="width: 50px;" maxlength="2" onkeypress="return inputLimiter(event,'Numbers')" />
				</div>
			</div>
			<div class="control-group f-l">
				<label class="control-label nexaf" for="Course Credits"
					style="margin-left: 88px; width: 220px;">Specify Course
					Extra Credits :</label>
				<div class="controls" style="width: 212px;">
					<input type="text" name="spi" id="spinner2" value="0" 
						style="width: 50px;"  maxlength="2" onkeypress="return inputLimiter(event,'Numbers')"/>
				</div>
			</div>
			<div class="clearfix"></div>
			<div class="control-group f-l">
				<label class="control-label nexaf" for="input" style="width: 230px;">Specify
					Course Duration :</label>
				<div class="controls" style="margin-left: 230px; width: 92px">
					<input type="text" name="spi" id="spinner3"  value="0"
						style="width: 50px;" maxlength="2" onkeypress="return inputLimiter(event,'Numbers')" />
				</div>
			</div>


			<select name="SelectArea" id="Cdurationtype" class="defaultvalue f-l"
				style="margin-left: 20px;width:110px">
				<option value="1">Weeks</option>
				<option value="2"></option>
				<option value="3"></option>
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
												id="thumbnail_image_file_upload" /></span> <a href="#"
												class="btn fileupload-exists" data-dismiss="fileupload">Remove</a>
										</div>
										<div id="status"></div>
									</div>
								</div> -->

			<!-- <div class="control-group">
				<label class="control-label nexaf" for="Asscoiate Content"
					style="width: 230px;"> Associate an Image for the Course :</label>
				<div class="controls">
					<div class="fileupload fileupload-new" data-provides="fileupload">
						<div class="fileupload-new thumbnail"
							style="width: 50px; height: 50px;">
							<img src="http://www.placehold.it/50x50/EFEFEF/AAAAAA" />
						</div>
						<div class="fileupload-preview fileupload-exists thumbnail"
							style="width: 70px; height: 50px;"></div>
						<span class="btn btn-file"><span class="fileupload-new">Upload
								image</span><span class="fileupload-exists">Change</span><input
							type="file" /></span> <a href="#" class="btn fileupload-exists"
							data-dismiss="fileupload">Remove</a>
					</div>
				</div>

			</div> -->
			<div style="margin-top: 0px;">
				<label style="width: 260px;" for="input" class="control-label nexaf">Associate
					an Image for your Course :</label>

				<div style="width: 122px; height: 105px; float: left;padding-top:15px">
					<img id="course_thumbnail_image"
						src="http://www.placehold.it/100x100/EFEFEF/AAAAAA"
						align="left" /> <input readonly="readonly" type="hidden"
						id="Cimageupl" style="margin-left: 20px;" />
				</div>

				<div id="message"></div>
				<div id="thubmnail_upload_message"></div>
				<div id="loaderText"></div>
				<input type="file" name="thumbnail_image_file_upload" tabindex="11"
					id="thumbnail_image_file_upload" style="margin-left: 196px;" />
				<div id="status"></div>
				<script type="text/javascript">
					$(function() {
						$('#thumbnail_image_file_upload')
								.uploadify(
										{
											'swf' : '${staticFileServer}resources/swf/uploadify.swf',
											'queueSizeLimit' : 1,
											 'successTimeout' : 350,
											 'buttonText' : 'Upload Image',
											'uploader' : '${ms.uploadScript}',
											//'uploader' : 'http://54.243.235.88/zikload-xml/uploadify.php',
											'fileTypeExts' : '*.gif; *.jpg; *.jpeg; *.png',
											'fileSizeLimit' : '10024KB',
											'onUploadStart' : function(file) {
												$('#sbtvalidation').attr(
														'disabled', 'disabled');
											},
											//'debug' : true,
											//'scriptData':{'contentId': $('#learningContentId').val().split('_')[1]},

											'onUploadSuccess' : function(file,
													data, response) {
												json_string = data;
												data_object = $
														.parseJSON(json_string);
												console.log(data_object);

												if (data_object.Uploaded == 'true') {
													$('#Cimageupl')
															.val(
																	data_object.ContentPath);
													$('#course_thumbnail_image')
															.attr(
																	'src',
																	'${ms.url}'
																			+ data_object.ContentPath);
													$(
															'#thubmnail_upload_message')
															.html(
																	'<a onclick="remove_uploaded_thumbnail();" title="Remove Image" class="remove" style="margin-left:20px">Remove</a>');

												} else { //there is an error in the upload process

													$('#message')
															.html(
																	data_object.message);
												}
												$('#sbtvalidation').removeAttr(
														'disabled'); //enable submit button

											}
										// Your options here
										});
					});

					function remove_uploaded_thumbnail() {
						$('#Cimageupl').val('');//clear uploaded file path
						$('#thubmnail_upload_message').html('');
						$('#course_thumbnail_image')
								.attr('src',
										'${staticFileServer}resources/images/default-course.jpg');

					}
				</script>
			</div>
			<button class="btn f-r" type="button"
				onClick="createCourse();return false;">Save and Continue</button>
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
<style>
.select2-container {
    
    margin-right: 70px!important;
    
    width: 235px;
}
.formErrorContent {
    
    color: red;
    left: 67px;
    overflow: auto;
    position: relative;
    top: 81px;
}
.uploadify-queue{margin-left:260px}
@media screen and (-webkit-min-device-pixel-ratio:0)
{ 
   .formErrorContent  {top: 0px;}
}

</style>
