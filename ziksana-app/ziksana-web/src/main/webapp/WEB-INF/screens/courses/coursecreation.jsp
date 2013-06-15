<script type='text/javascript'
	src="${staticFileServer}resources/js/custom/plugins.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/Dynamicjsonjs/z_message.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/Dynamicjsonjs/z_simulation_message.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/Dynamicjsonjs/Addmoduledynamicjson.js"></script>

<!--Script for the Tree -->
<script src="${staticFileServer}resources/js/lib/tree/Common/common.js"></script>
<script src="${staticFileServer}resources/js/lib/tree/Common/dtree.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/lib/tree/Menu/menu.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/lib/tree/Menu/menu_ext.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/lib/tree/treedata.js"></script>

<script
	src="${staticFileServer}resources/js/ziksana/validation/jquery.validationen.js"
	type="text/javascript" charset="utf-8"></script>
<script
	src="${staticFileServer}resources/js/ziksana/validation/jquery.validation.js"
	type="text/javascript" charset="utf-8"></script>

<link rel="stylesheet" type="text/css"
	href="${staticFileServer}resources/css/common/tree/menu.css" />
<link rel="stylesheet" type="text/css"
	href="${staticFileServer}resources/js/lib/splitter/splitter.css" />


<script type='text/javascript'
	src='${staticFileServer}resources/js/lib/tagsinput/jquery.tagsinput.min.js'></script>

<style>
.ds {
	margin-left: 40px;
	color: #0a91ac !important;
}
</style>
<style>
#splitter {
	width: 100%;
	height: auto;
}

#jqxTree {
	height: auto;
	width: auto;
}
</style>

<script>
$(document).ready(function() { // On page load
  $("#navcourse").addClass("active");  
 
});
</script>
<div class="navheadlp" style="padding-left: 151px;">


	<ul>
		<c:if test="${courseId == null}">
			<li style="margin-left: 40px;"><a
				href="/ziksana-web/zcourse/createcourse"><span> <img
						src="/ziksana-web/resources/images/navarrowb.png"
						style="margin-right: 10px; height: 22px;">
				</span> <fmt:message key="course.DescribeCourse" /></a></li>
		</c:if>

		<c:if test="${courseId != null}">
			<li style="margin-left: 40px;"><a
				href="/ziksana-web/zcourse/editcourse/${courseId}"><span>
						<img src="/ziksana-web/resources/images/navarrowb.png"
						style="margin-right: 10px; height: 22px;">
				</span> <fmt:message key="course.DescribeCourse" /></a></li>
		</c:if>
		<c:if test="${courseId == null}">
			<li><a style="color: #f06c0b;"
				href="/ziksana-web/zcourse/createcourse"><span><img
						src="/ziksana-web/resources/images/navarrow.png"
						style="margin-right: 10px; height: 22px;"> </span> <fmt:message
						key="Define.Structure" /></a></li>
		</c:if>
		<c:if test="${courseId != null}">
			<li><a style="color: #f06c0b;"
				href="/ziksana-web/zcourse/createmodule/${courseId}"><span><img
						src="/ziksana-web/resources/images/navarrow.png"
						style="margin-right: 10px; height: 22px;"> </span> <fmt:message
						key="Define.Structure" /></a></li>
		</c:if>

		<c:if test="${courseId == null}">
			<li><a href="/ziksana-web/zcourse/createcourse"><span><img
						src="/ziksana-web/resources/images/navarrowb.png"
						style="margin-right: 10px; height: 22px;"> </span> <fmt:message
						key="Associate.content" /></a></li>
		</c:if>
		<c:if test="${courseId != null}">
			<li><a
				href="/ziksana-web/zcourse/1/repositorycontents/${courseId}"><span><img
						src="/ziksana-web/resources/images/navarrowb.png"
						style="margin-right: 10px; height: 22px;"> </span> <fmt:message
						key="Associate.content" /></a></li>
		</c:if>
		<li><span><img
				src="/ziksana-web/resources/images/navarrowb.png"
				style="margin-right: 10px; height: 22px;"> </span> <fmt:message
				key="Define.assignment" /></li>

	</ul>


</div>

<div id="formcontainer">

	<div class="page-header"
		style="padding-left: 0px !important; margin-bottom: 0px !important;">
		<div class="icon">
			<img
				src="${staticFileServer}resources/images/icons/information_icon.png"
				style="height: 25px;" />
		</div>
		<h1>
			<fmt:message key="module.organize.head" />
		</h1>
	</div>
	<!--End of page-header -->

	<div class="clearfix"></div>

	<div>

		<!-- BEGIN FORM-->
		<div id="splitterContainer">
			<div id="leftPane">
				<div id="treeboxbox_tree" style="width: 250px;" class="dhtmlxTree"
					setImagePath="${staticFileServer}resources/js/ziksana/jquerylibrary/tree/treeimages/csh_bluebooks/">
				</div>
			</div>
			<!-- #leftPane -->
			<div id="splitbarV" class="splitbarV"></div>
			<div id="rightPane">
				<div class="Addmodulecontainer" id="Addmodulecontainer"
					style="padding: 10px;">
					<form id="AddModule" method="post" class="form-horizontal">
						<input type="hidden" id="courseid" value="${courseId}" /> <input
							type="hidden" id="courseLearningComponentId" value="" /> <input
							type="hidden" id="parentLearningComponentId" value="" /> <input
							type="hidden" id="learningComponentId" value="" />
						<!--module form-->
						<!--Course Name-->
						<div class="control-group">
							<label class="control-label nexaf" for="Course Name"
								style="width: 120px"><fmt:message key="module.name" /></label>
							<div class="controls" style="margin-left: 130px;">
								<input type="text" id="Course_Module" class="defaultvaluem treeRoot validate[required]"
									placeholder="Enter module name" maxlength="64"
									style="width: 300px;" onchange="return trim(this)" />
							</div>
						</div>

						<!--end of course name-->

						<label for="Course Description" class="labelclass nexaf"
							style="font-weight: bold;"><b><fmt:message
									key="course.description" /></b></label>
						<div class="_richTextShow">
							<textarea id="Cmoduledescrte" name="editor1pageload"
								class="defaultvalue _focus">
													 
												</textarea>
						</div>
						<script type="text/javascript">
							CKEDITOR.replace('Cmoduledescrte');
						</script>
						<div class="control-group" style="margin-top: 20px;">
							<!-- 		<div>
								<label class="labelclass nexaf f-l"> Module Area : </label> <label
									class="labelclass nexaf f-l" style="margin-left: 130px;">
									Module Subject: </label> <label class="labelclass nexaf f-l"
									style="margin-left: 110px;"> Module Topic: </label>
							</div> -->
							<div class="clearfix"></div>
							<div class="moduleselection">
								<div style="width: 32%; margin-right: 2px" class="f-l">
									<label class="labelclass nexaf f-l"><fmt:message
											key="module.area" /> </label> <select name="s_example"
										id="Cmoduleareaddl" class="select" onchange="getArea();">
										<option value="0">
											<fmt:message key="course.choose.option" />
										</option>
									</select>
								</div>
								<div style="width: 32%;" class="f-l">
									<label class="labelclass nexaf f-l"> <fmt:message
											key="module.subject" />
									</label> <select name="s_example" class="select" id="Cmodulesubjectddl">
										<option value="0">
											<fmt:message key="course.choose.option" />
										</option>
									</select>
								</div>
								<div style="width: 22%;" class="f-l">
									<label class="labelclass nexaf f-l"> <fmt:message
											key="module.topic" />
									</label> <select name="s_example" class="select" id="Cmoduletopicddl">
										<option value="0">
											<fmt:message key="course.choose.option" />
										</option>
									</select>
								</div>
							</div>

						</div>
						<!--end of Subject Selection-->
						<div class="control-group" style="width: 90%">
							<label class="control-label nexaf" for="Specify Tags"
								style="width: 120px"><fmt:message
									key="course.SpecifyTags" /></label>
							<div class="controls" style="margin-left: 130px;">
								<input id="Addmoduletag" type="text" class="tags" value="" />
							</div>
						</div>

						<div class="clearfix"></div>

						<div style="margin-top: 0px;">
							<label style="width: 260px;" for="input"
								class="control-label nexaf"><fmt:message
									key="Associate.Image" /></label>
                            <div class="clearfix"></div>
							<div style="width: 100px; height: 105px; border:0px solid red">
								<img id="course_thumbnail_image"
									src="${staticFileServer}resources/images/preview/defaultcourse.png"
									align="center" /> <input readonly="readonly" type="hidden"
									id="Cimageupl" style="margin-left: 20px;height:100px" />
							</div>
                         <div style="border:0px solid #000;position:relative;margin-top:4px;margin-bottom:6px">   <input type="file" name="thumbnail_image_file_upload"
								tabindex="11" id="thumbnail_image_file_upload"
								style="margin-left: 196px;" /><div id="thubmnail_upload_message"></div></div>
							<div id="status">
							<div id="message"></div>
							
							<div id="loaderText"></div>
							</div>
							<script type="text/javascript">
								$(function() {
									$('#thumbnail_image_file_upload')
											.uploadify(
													{
														'swf' : '${staticFileServer}resources/swf/uploadify.swf',
														'queueSizeLimit' : 1,
														'successTimeout' : 350,
														'buttonText' : '<fmt:message key="profile.button.text" />',
														'uploader' : '${ms.uploadScript}',
														//'uploader' : 'http://54.243.235.88/zikload-xml/uploadify.php',
														'fileTypeExts' : '*.gif; *.jpg; *.jpeg; *.png',
														'fileSizeLimit' : '10024KB',
														'onUploadStart' : function(
																file) {
															$('#sbtvalidation')
																	.attr(
																			'disabled',
																			'disabled');
														},
														//'debug' : true,
														//'scriptData':{'contentId': $('#learningContentId').val().split('_')[1]},

														'onUploadSuccess' : function(
																file, data,
																response) {
															json_string = data;
															data_object = $
																	.parseJSON(json_string);
															console
																	.log(data_object);

															if (data_object.Uploaded == 'true') {
																$('#Cimageupl')
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
																				'<a onclick="remove_uploaded_thumbnail();" title="Remove Image" class="remove">Remove</a>');

															} else { //there is an error in the upload process

																$('#message')
																		.html(
																				data_object.message);
															}
															$('#sbtvalidation')
																	.removeAttr(
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
													'${staticFileServer}resources/images/preview/defaultcourse.png' );

								}
							</script>
						</div>
						<button class="btn f-r" type="button"
							onClick="getCancel();return false;" style="margin-right: 10px;">
							<fmt:message key="profile.cancel" />
						</button>
						<button class="btn f-r" type="button"
							onClick="getaddmodulesave();return false;"
							style="margin-right: 20px;">
							<fmt:message key="profile.submit" />
						</button>

						<div class="Clearfix"></div>

						<!--module form-->
					</form>
				</div>
			</div>
			<!-- #rightPane -->
		</div>
		<div class="Clearfix"></div>
		<button class="btn f-r" type="button"
			onClick="getSaveandContinue();return false;"
			style="margin-right: 30px;">
			<fmt:message key="btn.save.continue" />
		</button>
		<!-- <div id='jqxWidget' style='display: none;'>
								<div id="splitter" style='clear: both;'>

									Start of Tree
									

									End of Tree

									<div class="splitter-panel">
										
										End of Add Module

									</div>
									End of splitter-panel

								</div>
								End of splitter
							</div> -->
		<!--End of jqxWidget-->
		<!-- END FORM -->

	</div>
	<!--End of contentarea -->

</div>
<!--End of definestructureformcontainer -->

</div>
<!--end of contentpanel-->


</div>
</section>
</div>
<div class="Clearfix"></div>
<div class="Clearfix"></div>
</div>
<script>
	$(function() {
		$('#splitbarV').click(function() {
			console.log("hello");
			leftpane = $('#leftPane');
			if (leftpane.hasClass('hidden')) {
				leftpane.removeClass('hidden').show();
			} else {
				leftpane.addClass('hidden').hide();
			}
		});
	});
</script>
<style>
#treeboxbox_tree {
	overflow: auto !important
}
.remove {
  background: none repeat scroll 0 0 #43B2EC;
  border: 0 none;
  border-radius: 6px 6px 6px 6px;
  color: #F9F9F9;
  cursor: pointer !important;
  display: block;
  
  margin-left:4px;
  padding: 5px;
  position: relative;
  text-align: center;
  text-decoration: none !important;
  text-shadow: none;
  top: -3px;
  width: 120px;
}
#thubmnail_upload_message {
  
  height: 24px;
  margin-left: 120px;
  position: relative;
  top: -39px;
  width: 130px;
}
.uploadify-queue {
  
  position: absolute;
  width:300px; 
}
</style>

<style>
.select2-container {
	margin-right: 10px !important;
	width: 200px;
}

.splitclick {
	background: url("/ziksana-web/resources/images/panevc.gif") no-repeat
		scroll -5px 20% #CBE1FB;
	border: 1px solid #9CBDFF;
	float: left;
	font-size: 0;
	height: 40%;
	line-height: 0;
	margin-left: 15px;
	margin-top: 17px;
	position: absolute;
	width: 4px;
}

.hidetree {
	display: none;
	width: 24%
}

.formErrorContent {
  color: red;
  left: 62px;
  overflow: auto;
  position: absolute;
  top: 3px;
  width: 131px;
}
</style>
<script type="text/javascript">
	function trim(el) {
		el.value = el.value.replace(/(^\s*)|(\s*$)/gi, ""). // removes leading and trailing spaces
		replace(/[ ]{2,}/gi, " "). // replaces multiple spaces with one space 
		replace(/\n +/, "\n"); // Removes spaces after newlines
		return;
	}
</script>