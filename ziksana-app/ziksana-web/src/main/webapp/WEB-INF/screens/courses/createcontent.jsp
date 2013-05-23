
<script type='text/javascript'
	src="${staticFileServer}resources/js/lib/plupload/previewupload.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/custom/createcontent/addweblink.js"></script>

<script type="text/javascript"
	src="${staticFileServer}resources/Dynamicjsonjs/createcontentjson.js"></script>


<style>
.tileheadaa {
	margin-left: 20px;
	font-size: 20px;
	font-size: 30px;
}

table tr th {
	color: #fff;
	font-size: 18px;
	border: none !important;
}

table tr td {
	color: #fff;
	font-size: 18px;
	border: none !important;
}

.table-hover tbody tr:hover td,.table-hover tbody tr:hover th {
	background-color: rgba(206, 204, 204, 0.27);
}

.uploadify {
	clear: both;
	left: 50px;
	margin-bottom: 1em;
	position: relative;
	left: 10px;
}
</style>

<div id="Zikbreadcrumbback" style="margin-left: 20px;">
	<div class="Zikbreadcrumb f-l">
		<div class="fifteen columns" id="page-title">
			<a style="margin-top: -3px;" class="back"
				href="javascript:history.back()"></a>
			<p class="page-title">
				<span style="font-size: 13px; color: #6bbde8;">Home</span> < Create
				Content
			</p>
		</div>
	</div>
	<!--end of breadcrumb-->
</div>

<div class="Clearfix"></div>
<div id="contentpanel">
	<div class="tilecontainer pull-left"
		style="margin-top: 40px; width: 140px;">



		<div class="tile bg-color-orange icon" id="uploadbtn" style="">
			<div class="tile-content">
				<img src="${staticFileServer}resources/images/content/upload.png" />
			</div>
			<div class="brand">
				<h3 style="margin-left: 10px; font-size: 16px; width: 160px;">
					<a href="ziksana-web/zcourse/1/createcontent"></a>Upload Content
				</h3>
			</div>
		</div>


		<div class="tile bg-color-grayDark icon" id="addweblinkbtn" style="">
			<div class="tile-content">
				<img src="${staticFileServer}resources/images/content/link.png" />
			</div>
			<div class="brand">
				<h3 style="margin-left: 10px; font-size: 16px; width: 160px;">
					<a href="ziksana-web/zcourse/1/weblinkcontent"></a>Add Web Link
				</h3>
			</div>
		</div>



		<div class="Clearfix"></div>


	</div>
	<!--end of tilescontainer-->

	<!--end of tilescontainer-->
	<div class="contentarea pull-right" style="width: 940px;">
		<div class="createcontentwrapper">
			<div class="uploadcontent1">
				<form id="createcontentform" method="post">
					<div class="createcontentpanelhead">Upload Content</div>
					<!--end of panel head-->
					<div class="draganddrop pull-left">
						<div style="margin-top: 30px; margin-left: 60px;">
							<div style="width: 122px; height: 120px; float: left">
								<img id="course_thumbnail_image"
									src="http://www.placehold.it/80x80/EFEFEF/AAAAAA" align="left" />

							</div>

							<input readonly="readonly" type="hidden" id="Cimageupl"
								style="margin-left: 20px;" /> <input type="hidden"
								id="ContentName"> <input type="hidden" id="ContentType">
							<input type="hidden" id="ContentTypeName">
							<div id="message"></div>
							<div id="thubmnail_upload_message"></div>
							<div id="loaderText"></div>
							<input type="file" name="thumbnail_image_file_upload"
								tabindex="11" id="thumbnail_image_file_upload"
								style="margin-left: 196px;" />
							<div id="status"></div>
							<script type="text/javascript">
								$(function() {
									$('#thumbnail_image_file_upload')
											.uploadify(
													{
														'swf' : '${staticFileServer}resources/swf/uploadify.swf',
														'queueSizeLimit' : 1,
														'successTimeout' : 350,
														'buttonText' : 'Upload File',
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
																$('#Cimageupl').val(data_object.ContentPath);
																$('#ContentName').val(data_object.ContentName);
																$('#ContentType').val(data_object.ContentType);
																$('#ContentTypeName').val(data_object.ContentTypeName);
																$('#course_thumbnail_image').attr('src','${ms.url}'+ data_object.ContentPath);
																$('#thubmnail_upload_message').html('<a onclick="remove_uploaded_thumbnail();" title="Remove Image" class="remove" style="margin-left:20px">Remove</a>');

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
									$('#ContentName').val(''); //clear ContentName
									$('#ContentType').val(''); //clear ContentType
									$('#ContentTypeName').val(''); //clear ContentTypeName
									$('#thubmnail_upload_message').html('');
									$('#course_thumbnail_image').attr('src','${staticFileServer}resources/images/default-course.jpg');

								}
							</script>
						</div>
						<!-- 						<input type="hidden" id="MAX_FILE_SIZE" name="MAX_FILE_SIZE"
							value="300000" />

						<div>

							<input type="file" id="fileselect" name="fileselect[]"
								multiple/ style="margin-left: 20px; margin-top: 20px;">
							<div id="filedrag" class="uploadheadsdrop">Drag and Drop
								files here</div>
						</div>

						<div id="submitbutton">
							<button type="submit">Upload Files</button>
						</div> -->

					</div>
					<!--end of drag anf drop-->
					<div class="previewarea pull-left">
						<div class="messagecontainer">
							<p class="uploadheads"
								style="font-size: 30px; margin-left: 70px; padding-top: 180px;">Preview
								Area</p>

							<div id="messages" style="min-height: 100px;"></div>
							<!--End of Messages -->
							<div class="ClearFix"></div>
							<!--End of ClearFix -->
						</div>
						<!--End of Messagecontainer -->
					</div>
					<!--end of preview area-->
					<div class="clearfix"></div>
					<div class="createcontentpanelhead" style="margin-top: 4px;">
						<a href="#linkurl" class="btn pull-right"
							style="margin-left: 10px;"> Cancel </a> <a
							class="btn pull-right saveup1" type="button"
							onClick="createContent();return false;">Next</a>
						<div class="clearfix"></div>
					</div>
					<!--end of panel head-->
				</form>
			</div>
			<!--end of uploadcontent1-->
		</div>
		<!--end of weblink-->
	</div>
	<!--end of image wrapper -->
</div>
<!--end of contentarea-->
</div>
<!--end of contentpanel-->

<div class="Clearfix"></div>
<!--end of body wrapper-->




<%-- <script type="text/javascript"
	src="${staticFileServer}resources/js/custom/createcontent/filedrag.js"></script> --%>
