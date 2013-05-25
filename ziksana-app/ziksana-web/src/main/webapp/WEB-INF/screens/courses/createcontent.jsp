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
					<a href="/ziksana-web/zcourse/1/createcontent">Upload Content</a>
				</h3>
			</div>
		</div>


		<div class="tile bg-color-grayDark icon" id="addweblinkbtn" style="">
			<div class="tile-content">
				<img src="${staticFileServer}resources/images/content/link.png" />
			</div>
			<div class="brand">
				<h3 style="margin-left: 10px; font-size: 16px; width: 160px;">
					<a href="/ziksana-web/zcourse/1/weblinkcontent">Add Web Link</a>
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

				<div class="createcontentpanelhead">Upload Content</div>
				<!--end of panel head-->
				<div class="draganddrop pull-left">
					<div style="margin-top: 30px; margin-left: 10px;">
						<!-- 							<div style="width: 122px; height: 100px; float: left">
								<img id="course_thumbnail_image" style="margin-left: 65px"
									src="http://www.placehold.it/80x80/EFEFEF/AAAAAA"
									align="center" />
							</div> -->


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
													'fileTypeExts' : '*.gif; *.jpg; *.jpeg; *.png; *.mp4; *.mp3; *.flv; *.doc; *.docx; *.ppt; *.pptx, *.pdf',
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
															content_path = data_object.ContentPath;
															content_name = data_object.ContentName;
															content_type_id = data_object.ContentType;
															content_type_name = data_object.ContentTypeName;
															thumbnail_path = data_object.ThumbnailPicturePath;
															no_of_thumbnails = data_object.NumberOfThumbnails;

															prepare_for_preview(
																	content_path,
																	content_name,
																	content_type_id,
																	content_type_name,
																	thumbnail_path,
																	no_of_thumbnails);

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

							function prepare_for_preview(content_path,
									content_name, content_type_id,
									content_type_name, thumbnail_path,
									no_of_thumbnails) {

								thumbnail_image_src = '${ms.url}'
										+ content_path;
								if (content_type_name !== 'IMAGE') {
									thumbnail_image_src = '${staticFileServer}resources/images/default-course.jpg';
								}

								div_html = '<div class="preview_uploaded_content">';
								div_html += '<div><img src="'+thumbnail_image_src+'" alt=""></div>';
								div_html += '<div><span class="title">'
										+ content_name
										+ '</span><input type="hidden" name="contentPath[]" value="'+content_path+'" /> <input type="hidden" name="contentName[]" value="'+content_name+'"><input type="hidden" name="contentType[]" value="'+content_type_id+'"><input type="hidden" name="contentTypeName[]" value="'+content_type_name+'"><input type="hidden" name="thumbnailPath[]" value="'+thumbnail_path+'"><input type="hidden" name="noOfThumbnails[]" value="'+no_of_thumbnails+'"></div>';
								div_html += '<div><a class="remove_this" onclick="$(this).parents(\'.preview_uploaded_content\').remove();">X</a></div>';
								div_html += '</div>';

								$('.previewarea .messagecontainer').remove();
								$('.previewarea form#multiple_content_upload')
										.append(div_html);

							}
						</script>
					</div>
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
					<form id="multiple_content_upload" method="post"
						action="/ziksana-web/zcourse/1/createcontents"></form>
					<!--End of Messagecontainer -->
				</div>
				<!--end of preview area-->
				<div class="clearfix"></div>
				<div class="createcontentpanelhead" style="margin-top: 4px;">
					<a href="#linkurl" class="btn pull-right"
						style="margin-left: 10px;"> Cancel </a> <a
						class="btn pull-right saveup1" type="button"
						onClick="$('form#multiple_content_upload').submit();">Next</a>
					<div class="clearfix"></div>
				</div>
				<!--end of panel head-->

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

<style type="text/css">
.preview_uploaded_content {
	background: none repeat scroll 0 0 silver;
	border-radius: 2px 2px 2px 2px;
	display: table;
	margin: 0.5em 2%;
	width: 96%;
}

.preview_uploaded_content>div {
	display: table-cell;
	min-height: 100px;
	padding: .5em;
	vertical-align: center;
	position: relative;
}

.preview_uploaded_content>div:first-child {
	width: 100px;
}

.preview_uploaded_content>div:last-child {
	width: 32px;
}

.preview_uploaded_content img {
	width: 100px;
}

.preview_uploaded_content .title {
	font-size: 14px;
	font-weight: bold;
}

a.remove_this {
	border: 2px solid white;
	border-radius: 60px 60px 60px 60px;
	color: white;
	cursor: pointer;
	display: inline-block;
	font-size: 28px;
	height: 42px;
	line-height: 38px;
	text-align: center;
	text-decoration: none;
	width: 42px;
}

a.remove_this:hover {
	color: red;
	border-color: red;
	text-decoration: none;
}
</style>
