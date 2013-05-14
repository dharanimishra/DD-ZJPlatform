<link href="${staticFileServer}resources/css/main/styles2.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${staticFileServer}resources/css/stylesheets.css"
	rel="stylesheet" type="text/css" />
<link href="${staticFileServer}resources/css/main/modern.css"
	rel="stylesheet" type="text/css" />

<script type='text/javascript'
	src="${staticFileServer}resources/js/lib/plupload/previewupload.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/custom/createcontent/addweblink.js"></script>

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
		style="margin-top: 40px; width: 240px;">
		<div class="tile bg-color-blueDark icon" id="uploadbtn"
			style="width: 300px; height: 140px;">
			<div class="tile-content">
				<img src="${staticFileServer}resources/images/content/upload.png" />
			</div>
			<div class="brand">
				<h3 style="margin-left: 10px; font-size: 18px; width: 160px;">
					<a href="/ziksana-web/zcourse/createcontent"></a>Upload Content
				</h3>
			</div>
		</div>


		<div class="tile bg-color-grayDark icon" id="addweblinkbtn"
			style="width: 300px; height: 140px;">
			<div class="tile-content">
				<img src="${staticFileServer}resources/images/content/link.png" />
			</div>
			<div class="brand">
				<h3 style="margin-left: 10px; font-size: 18px; width: 160px;">
					<a href="/ziksana-web/zcourse/weblinkcontent"></a>Add Web Link
				</h3>
			</div>
		</div>
		<div class="Clearfix"></div>
	</div>
	<!--end of tiles container-->

	<div class="contentarea pull-right" style="width: 650px;">
		<div class="createcontentwrapper">
			<div class="uploadcontent1" style="display: none;">
				<div class="createcontentpanelhead">Upload Content</div>
				<!--end of panel head-->
				<div class="draganddrop pull-left">
					<form id="upload" method="POST" enctype="multipart/form-data">
						<div style="margin-top: 30px;">
							<label style="width: 260px;" for="input"
								class="control-label nexaf">Associate an Image for your
								Course :</label>

							<!--   <div style="width: 122px; height: 120px; float: left">
								<img id="course_thumbnail_image"
									src="${staticFileServer}resources/images/default-course.jpg"
									align="left" />
									</div>
							-->
							<input readonly="readonly" type="hidden" id="Cimageupl"
								style="margin-left: 20px;" />


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
																				'<a onclick="remove_uploaded_thumbnail();" title="Remove Image" class="remove" style="margin-left:20px">Remove</a>');

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
													'${staticFileServer}resources/images/default-course.jpg');

								}
							</script>
						</div>
						<!-- <input type="hidden" id="MAX_FILE_SIZE" name="MAX_FILE_SIZE"
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
					</form>
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
						style="margin-left: 10px;"> Cancel </a> <a href="#linkurl"
						class="btn pull-right saveup1"> Next </a>
					<div class="clearfix"></div>

				</div>
				<!--end of panel head-->

			</div>
			<!--end of uploadcontent1-->


			<div class="uploadcontent2">
				<div class="createcontentpanelhead">Upload Content</div>
				<!--end of panel head-->

				<div class="Clearfix"></div>

				<div class="uploadrowodd">
					<div class="uploadphoto pull-left">
						<div class="fileupload fileupload-new" data-provides="fileupload">
							<div class="fileupload-new thumbnail"
								style="width: 80px; height: 80px;">
								<img src="http://www.placehold.it/80x80/EFEFEF/AAAAAA" />
							</div>
							<div class="Clearfix"></div>
							<div class="fileupload-preview fileupload-exists thumbnail"
								style="width: 120px; height: 100px;"></div>
							<div class="Clearfix"></div>
							<span class="btn btn-file"><span class="fileupload-new">Upload
									image</span><span class="fileupload-exists">Change</span><input
								type="file" /></span> <a href="#" class="btn fileupload-exists"
								data-dismiss="fileupload">Remove</a>
						</div>
					</div>
					<!--end of uploadphoto-->

					<div class="rowfields pull-left">

						<ul>
							<li style="padding-right: 30px;">File Name</li>
							<li style="padding-right: 30px;"><a href="#linkurl">Edit
									Name</a></li>
							<li><a href="#linkurl" class="editdetailsweblink">Edit
									Details</a></li>

						</ul>
					</div>
					<!--end of rowfields-->
					<div class="clearfix"></div>
				</div>
				<!-- end of uploadrow-->
				<div class="uploadroweven" style="display: none;">
					<div class="uploadphoto pull-left">
						<div class="fileupload fileupload-new" data-provides="fileupload">
							<div class="fileupload-new thumbnail"
								style="width: 80px; height: 80px;">
								<img src="http://www.placehold.it/80x80/EFEFEF/AAAAAA" />
							</div>
							<div class="Clearfix"></div>
							<div class="fileupload-preview fileupload-exists thumbnail"
								style="width: 120px; height: 100px;"></div>
							<div class="Clearfix"></div>
							<span class="btn btn-file"><span class="fileupload-new">Upload
									image</span><span class="fileupload-exists">Change</span><input
								type="file" /></span> <a href="#" class="btn fileupload-exists"
								data-dismiss="fileupload">Remove</a>
						</div>
					</div>
					<!--end of uploadphoto-->

					<div class="clearfix"></div>

				</div>
				<!-- end of uploadrow-->
				<div class="createcontentpanelhead" style="margin-top: 4px;">
					<a href="#linkurl" class="btn pull-right saveup1"
						style="margin-left: 10px;"> Add Content </a> <a href="#linkurl"
						class="btn pull-right" style="margin-left: 10px;"> Save </a> <a
						href="#linkurl" class="btn pull-right saveup1"
						style="margin-left: 10px;"> Previous </a>

					<div class="clearfix"></div>
				</div>
				<!--end of panel head-->
			</div>
			<!--end of uploadcontent2-->

			<div class="addweblink" style="display: none;">
				<div class="createcontentpanelhead">
					Add Web Link
					<div class="addmpre pull-right">
						<a href="#linkurl" class="adlink" id="weblink"><img
							src="${staticFileServer}resources/images/content/plus.png"
							style="height: 30px;" /></a>

					</div>
					<!--end of add more-->
					<div class="Clearfix"></div>
				</div>
				<!--end of panel head-->
				<div class="weblinkcontainer">
					<div class="uploadrowodd">
						<div class="uploadphoto pull-left">
							<div class="fileupload fileupload-new" data-provides="fileupload">
								<div class="fileupload-new thumbnail"
									style="width: 80px; height: 80px;">
									<img src="http://www.placehold.it/80x80/EFEFEF/AAAAAA" />
								</div>
								<div class="fileupload-preview fileupload-exists thumbnail"
									style="width: 120px; height: 100px;"></div>
								<span class="btn btn-file"><span class="fileupload-new">Upload
										image</span><span class="fileupload-exists">Change</span><input
									type="file" /></span> <a href="#" class="btn fileupload-exists"
									data-dismiss="fileupload">Remove</a>
							</div>
						</div>
						<!--end of uploadphoto-->

						<div class="rowfields pull-left">
							<ul>
								<li><input type="text" placeholder="Enter Name"
									style="height: 25px; margin-top: 15px; width: 150px;" /></li>
								<li><input type="text" placeholder="Htttp://"
									style="height: 25px; margin-top: 15px; width: 150px;" /></li>
								<li><a href="#linkurl">Edit Details</a></li>
							</ul>
						</div>
						<!--end of rowfields-->
						<div class="clearfix"></div>
					</div>
					<!-- end of uploadrow-->
					<div class="uploadroweven">
						<div class="uploadphoto pull-left">
							<div class="fileupload fileupload-new" data-provides="fileupload">
								<div class="fileupload-new thumbnail"
									style="width: 80px; height: 80px;">
									<img src="http://www.placehold.it/80x80/EFEFEF/AAAAAA" />
								</div>
								<div class="fileupload-preview fileupload-exists thumbnail"
									style="width: 120px; height: 100px;"></div>
								<span class="btn btn-file"><span class="fileupload-new">Upload
										image</span><span class="fileupload-exists">Change</span><input
									type="file" /></span> <a href="#" class="btn fileupload-exists"
									data-dismiss="fileupload">Remove</a>
							</div>
						</div>
						<!--end of uploadphoto-->
						<div class="rowfields pull-left">

							<ul>
								<li><input type="text" placeholder="Enter Name"
									style="height: 25px; margin-top: 15px; width: 150px;" /></li>
								<li><input type="text" placeholder="Htttp://"
									style="height: 25px; margin-top: 15px; width: 150px;" /></li>
								<li><a href="#linkurl" class="editdetailsweblink">Edit
										Details</a></li>
							</ul>
						</div>
						<!--end of rowfields-->
						<div class="clearfix"></div>
						<div class="editslide pull-left">
							<textarea rows="4" cols="12"
								style="width: 374px; margin-bottom: 10px;">Details for the Web link </textarea>
						</div>

						<div class="editslide pull-left" style="margin-left: 5px;">
							<input type="text" placeholder="Specify Tags"
								style="height: 30px; margin-top: 7px; width: 220px;"> <select>
								<option>Specify Subject</option>
							</select> <br> <select>
								<option>Specify Subject</option>
							</select> <select>
								<option>Specify Subject</option>
							</select>

						</div>
						<div class="clearfix"></div>
					</div>
					<!-- end of uploadrow-->

				</div>
				<!--End of weblink container -->
				<div class="createcontentpanelhead" style="margin-top: 4px;">

					<a href="#linkurl" class="btn pull-right saveup1"> Add Web link
					</a>
					<div class="clearfix"></div>

				</div>
				<!--end of panel head-->


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

<div class="Clearfix"></div>


<%-- <script type="text/javascript"
	src="${staticFileServer}resources/js/custom/createcontent/filedrag.js"></script> --%>
