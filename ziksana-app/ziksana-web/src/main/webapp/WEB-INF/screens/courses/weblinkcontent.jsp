<script type='text/javascript'
	src="${staticFileServer}resources/js/custom/plugins.js"></script>
<script type='text/javascript'
	src="${staticFileServer}resources/js/lib/plupload/previewupload.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/custom/createcontent/addweblink.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/Dynamicjsonjs/weblinkcontentjson.js"></script>
	<script type='text/javascript'
	src="${staticFileServer}resources/js/validation/jquery.validate.js"></script>
	
<style>
 	footer{display:none}
</style> 	
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
 .tile-content > a{
 width:100%;
  height:100%;float:left
 }
 .brand a:hover{
 color:#fff!important;text-decoration:none
 }
 .tile-content > a >img {
    height: 64px;
    left: 50%;
    margin-left: -32px;
    margin-top: -32px;
    position: absolute;
    top: 50%;
    width: 64px;
}
</style>
<script>
$(document).ready(function() { // On page load
  $("#navstudent").addClass("active");  
 
});
</script>
<div id="Zikbreadcrumbback" style="margin-left: 20px;">
	<div class="Zikbreadcrumb f-l">
		<div class="fifteen columns" id="page-title">
			<a style="margin-top: -3px;" class="back"
				href="javascript:history.back()"></a>
			<p class="page-title">
				<span style="font-size: 13px; color: #6bbde8;"><a href="/ziksana-web/secure/1/homepage" style="font-size: 13px; color: #6bbde8;"><fmt:message key="home.hometext"/></a></span> < <fmt:message key="home.createcontent"/> </p>
		</div>
	</div>
	<!--end of breadcrumb-->
</div>

<div class="Clearfix"></div>
<div id="contentpanel">
	<div class="tilecontainer pull-left"
		style="margin-top: 40px; width: 140px;margin-left:10px;">
		<div class="tile bg-color-orange icon" id="uploadbtn" style="">
			<div class="tile-content">
				<a href="/ziksana-web/zcourse/1/createcontent"> <img
					src="/ziksana-web/resources/images/content/upload.png" /></a>
			</div>
			<div class="brand">
				<h3 style="margin-left: 10px; font-size: 16px; width: 160px;">
					<a href="/ziksana-web/zcourse/1/createcontent" style="font-size: 16px;">Upload Content</a>
				</h3>
			</div>
		</div>


		<div class="tile bg-color-grayDark icon" id="addweblinkbtn" style="">
			<div class="tile-content">
				<a href="/ziksana-web/zcourse/1/weblinkcontent"> <img
					src="/ziksana-web/resources/images/content/link.png" /></a>
			</div>
			<div class="brand">
				<h3 style="margin-left: 10px; font-size: 16px; width: 160px;">
					<a href="/ziksana-web/zcourse/1/weblinkcontent" style="font-size: 16px;">Add Web Link</a>
				</h3>
			</div>
		</div>
		<div class="Clearfix"></div>
	</div>
	<!--end of tiles container-->

	<div class="contentarea pull-right" style="width: 940px;margin-right:25px">
		<div class="createcontentwrapper">
			<form id="createweblinkform" method="post"
				action="/ziksana-web/zcourse/1/multiweblinkcontents">
				<div class="addweblink">
		
					<div class="createcontentpanelhead">
						Add Web Link
						<c:if test="${message != null}">
    						<div><p>${message}</p></div>
						</c:if>
			
						<div class="addmpre pull-right">
							<a class="adlink" id="weblink"><img
								src="/ziksana-web/resources/images/content/plus.png"
								style="height: 30px;" /></a>
						</div> 
						
						<!--end of add more-->
						<div class="Clearfix"></div>
					</div>
					<!--end of panel head-->
					<!-- <div id="web_link_container"> -->
					<div id="web_link_container"  class="weblinkcontainer" style="background-color:#0099cc">
						<div class="weblink_row">
							<div class="uploadphoto pull-left" style="width:150px">
								<img id="thumbnail_image" src="/ziksana-web/resources/images/preview/link.png" style="width: 80px;height:80px;margin-left: 20px; margin-bottom: 5px;" align="left" />
								<div id="message"></div>
								<div id="thubmnail_upload_message"></div>
								<div id="loaderText"></div>
								<input type="file" name="thumbnail_image_file_upload"
									tabindex="11" id="thumbnail_image_file_upload"
									style="margin-left: 196px;" />
									
							<% String old_thumbnail_path = "${staticFileServer}resources/images/genetics.jpg"; %>
							<input type="hidden" name="contentPath" id="thumbnail_path" value="<%=old_thumbnail_path%>"/>
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
															'onUploadStart' : function(
																	file) {
																//$('#sbtvalidation').attr('disabled','disabled');
															},
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
																	$('#thumbnail_image').attr('src','${ms.url}'+content_path);
																	$('#thumbnail_path').val(content_path);
																	console.log("content_path :"+content_path);
																} else { //there is an error in the upload process

																	$(
																			'#message')
																			.html(
																					data_object.message);
																}
																$('#sbtvalidation').removeAttr('disabled'); //enable submit button
															}
														// Your options here
														});
									});
								</script>
							</div>
						
						<!--end of uploadphoto-->
						<div class="rowfields pull-left" style="width: 745px;">
							<ul style="overflow: hidden; width: 98%;margin-top: 0;">
								<li style="width: 180px;">
								<input type="hidden" name="contentPath[]" value=""/>
								<input type="text" placeholder="Enter Name"
									name="contentName[]" class="required validate[required]"
									style="height: 28px; margin-top: 15px; width: 170px;margin-bottom:0px;" /></li>
								<li style="width: 350px;"><input type="url" placeholder="http://" id="linkurl" name="contentUrl[]"
									style="height: 28px; margin-top: 15px; width: 170px;margin-bottom:0px;margin-right: 23px;" class="required validate[required]"/></li>
								<li  style="width: 150px;"><a href="#" class="editdetailsweblink" style="font-size:13px;"><img src="../../resources/images/content/edit.svg" style="width:19px;margin-right: 3px; height:30px"/>
								Edit Details</a></li>
								<li style="width:50px;text-align:center;padding-top:13px"><a title="Delete" class="remove_this">X</a></li>
							</ul>
						</div>
						<!--end of rowfields-->
						<div class="clearfix"></div>
						<div class="editslide pull-left" style="display:none">
						<label for="ContentDescription" style="width:100%;clear:both; margin-top: 6px; padding-left: 10px;">Description</label>
							<textarea rows="4" cols="12" name="contentDescription[]" 
								style="width: 330px; margin-bottom: 10px; margin-left: 10px;" placeholder="Describe the content for  Web link"></textarea>
						</div>
						<div class="editslide pull-left" style="margin-left: 10px;display:none">
							<ul><li style="margin-bottom: 10px;">	<label>Select Area</label>
							<select id="Careaddl" name="contentArea[]" class="select Careaddl">
								<option>Specify Area</option>
							</select> </li><li  style="margin-bottom: 10px;">
							<label>Select Subject</label>
							 <select class="select Csubjectddl" id="Csubjectddl"
								name="contentSubject[]">
								<option>Specify Subject</option>
							</select></li>
							 <li>
		                	<label>Select Topic</label>
			           <select class="select Ctopicddl" id="Ctopicddl" name="contentTopic[]">
								<option>Specify Topic</option>
							</select></li>
		       <li>	<label>Specify Tags</label>
							<input type="text" placeholder="Specify Tags" name="contentTag[]"
								style="height: 30px; margin-right: 12px; width: 233px;">
						</li></ul></div>
						<div class="clearfix"></div>
					</div>
					<!-- end of uploadrow-->
					</div>
					<!-- </div> -->
				</div>
				<!--End of weblink container -->
				<div class="createcontentpanelhead" style="margin-top: 4px;">
					<button class="btn blue pull-right saveup1" id="sbtvalidation"
						onClick="$('form#createweblinkform').submit();">Add Web link</button>
					<div class="clearfix"></div>
				</div>
				<!--end of panel head-->
			</form>
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
</div>

<style>
a.remove_this {
  border: 1px solid white;
  border-radius: 60px 60px 60px 60px;
  color: white;
  cursor: pointer;
  display: inline-block;
  font-size: 11px !important;
  height: 19px;
  line-height: 18px;
  text-align: center;
  text-decoration: none;
  width: 19px;float: right !important;
}

a.remove_this:hover {
	color: red!important;
	border-color: red;
	text-decoration: none;
}
.uploadrowodd { background-color: #CCCCCC;
   
}
.uploadroweven {
    background-color: #0099CC;
}
.select2-container {
	margin-right: 10px !important;
	width: 235px;
}

.rowfields ul {
	margin-left: 10px
}

.rowfields li {
	padding: 10px
}

.rowfields li a {
	float: left;
	margin-top: 16px;
}
.editslide label{ color:#fff;margin-bottom: 4px;}
.editslide ul{
list-style: none ;
width: 530px;overflow:hidden}
  
.editslide li {
  float: left; 
}

</style>

<style type="text/css">
 
.weblinkcontainer {
    background-color: #525252;
    height: 320px;
    overflow-x: hidden;
    overflow-y: auto;
}
#thumbnail_image_file_upload>object,#thumbnail_image_file_upload-button
	{
	cursor: pointer !important;
	width: 130px !important;
}
label.error {
  background: none repeat scroll 0 0 transparent;
  color: #D14836;
  font-size: 12px;
  margin-left: 2px;
  position: relative;
  top: 3px;
}
input.error {
    color: #555 !important;
}
.weblink_row { padding: .5em;}
#web_link_container div.weblink_row:nth-child(even) {
  background: none repeat scroll 0 0 #168EBE;
}
.editdetailsweblink:hover{color:#fff!important;text-decoration:none}

</style>

<script type="text/javascript">
    $(document).ready(function() {
      $("#createweblinkform").validate({
        rules: {
        	contentName: "required",
        	  contentUrl: "required",
          
        },
        contentUrl: {
			contentUrl: true
        },
        
        messages: {
        	contentName: "Enter URL Name.",
        	contentUrl:"Enter URL"
        }
        });
    });
  </script>