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
				<span style="color: #6bbde8;"><a href="/ziksana-web/secure/1/homepage"><fmt:message key="home.hometext"/></a></span> < <fmt:message key="home.createcontent"/> 
			</p>
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
					src="/ziksana-web/resources/images/content/upload.png" style="margin-top: -40px;" /></a>
			</div>
			<div class="brand">
				<h3 style="margin-left:-2px;margin-top:0px; 0px; font-size: 15px; width: 100%;text-align:center;">
					<a href="/ziksana-web/zcourse/1/createcontent" style="font-size: 15px;"><fmt:message key="Upload.Content"/></a>
				</h3>
			</div>
		</div>


		<div class="tile bg-color-grayDark icon" id="addweblinkbtn" style="">
			<div class="tile-content">
				<a href="/ziksana-web/zcourse/1/weblinkcontent"> <img
					src="/ziksana-web/resources/images/content/link.png" style="margin-top: -40px;" /></a>
			</div>
			<div class="brand">
				<h3 style="margin-left:-2px;margin-top:0px; 0px; font-size: 15px; width: 100%;text-align:center;">
					<a href="/ziksana-web/zcourse/1/weblinkcontent" style="font-size: 15px;"><fmt:message key="Add.Web.Link"/></a>
				</h3>
			</div>
		</div>
		<div class="Clearfix"></div>
	</div>
	<!--end of tiles container-->

	<div class="contentarea pull-right" style="width: 940px;margin-right:25px">
		<div class="createcontentwrapper">
			<form id="createweblinkform" method="post"
				action="/ziksana-web/zcourse/1/weblinkcontents">
				<div class="addweblink">
					<div class="createcontentpanelhead">
						<fmt:message key="Add.Web.Link"/>
						<div class="addmpre pull-right">
							<a class="adlink" id="weblink"><img
								src="${staticFileServer}resources/images/content/plus.png"
								style="height: 30px;" /></a>
						</div> 
						<!--end of add more-->
						<div class="Clearfix"></div>
					</div>
					<!--end of panel head-->
					<div class="weblinkcontainer" style="background-color:#0099cc">
						<div class="uploadroweven" style="padding: 10px;">
							<div class="uploadphoto pull-left" style="width: 350px">
								<img id="thumbnail_image" src="${staticFileServer}resources/images/preview/link.png" style="width: 100px; margin-bottom: 5px;" align="left" />
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
															'buttonText' : '<fmt:message key="profile.button.text"/>',
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
						<div class="rowfields pull-left">
							<ul>
								<li>
								<input type="hidden" name="contentPath" value=""/>
								<input type="text" placeholder="<fmt:message key="enter.name"/>"
									name="contentName" class="validate[required]"
									style="height: 25px; margin-top: 15px; width: 170px;margin-bottom:0px" /></li>
								<li><input type="url" placeholder="http://" id="linkurl" name="contentUrl"
									style="height: 25px; margin-top: 15px; width: 170px;margin-bottom:0px" class="validate[required]"/></li>
								<li><a href="#" class="editdetailsweblink"><fmt:message key="Edit.Details"/></a></li>
							</ul>
						</div>
						<!--end of rowfields-->
						<div class="clearfix"></div>
						<div class="editslide pull-left" style="display:none">
							<textarea rows="4" cols="12" name="contentDescription" 
								style="width: 374px; margin-bottom: 10px; margin-left: 10px;" placeholder="<fmt:message key="details.addweb"/>"></textarea>
						</div>
						<div class="editslide pull-left" style="margin-left: 5px;display:none">
							<input type="text" placeholder="<fmt:message key="course.SpecifyTags"/>" name="contentTag"
								style="height: 30px; margin-right: 12px; width: 233px;">
							<select id="Careaddl" name="contentArea" class="select Careaddl">
								<option><fmt:message key="Specify.Area"/></option>
							</select> <br> <select class="select Csubjectddl" id="Csubjectddl"
								name="contentSubject">
								<option><fmt:message key="Specify.Subject"/></option>
							</select> <select class="select Ctopicddl" id="Ctopicddl" name="contentTopic">
								<option><fmt:message key="Specify.Topic"/></option>
							</select>
						</div>
						<div class="clearfix"></div>
					</div>
					<!-- end of uploadrow-->
</div>
				</div>
				<!--End of weblink container -->
				<div class="createcontentpanelhead" style="margin-top: 4px;">
					<button class="btn f-r"  id="sbtvalidation"
						onClick="$('form#createweblinkform').submit();" style="background:#43B2EC;"><fmt:message key="Add.Web.Link"/></button>
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


</style>

<style type="text/css">
a.remove_this:hover {
	color: red;
	border-color: red;
	text-decoration: none;
}
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
label.error{color:#d14836;font-size:12px;margin-left:2px}
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
        	contentName: "<fmt:message key="enter.url.name"/>",
        	contentUrl:"<fmt:message key="enter.url"/>"
        }
        });
    });
  </script>