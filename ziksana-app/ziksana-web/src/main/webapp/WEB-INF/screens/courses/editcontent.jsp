<%@ page language="java" contentType="text/xml"%>
<%@page import="java.util.*"%>
<%@page import="com.ziksana.domain.course.LearningContent"%>
<%@page import="com.ziksana.domain.course.ContentType"%>

<script type='text/javascript'
	src="${staticFileServer}resources/js/custom/plugins.js"></script>
<script type='text/javascript'
	src="${staticFileServer}resources/js/lib/plupload/previewupload.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/custom/createcontent/addweblink.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/Dynamicjsonjs/editcontentjson.js"></script>

<style>
 	footer{display:none}
</style> 
 <script>
$(document).ready(function() { // On page load
  $("#navstudent").addClass("active");  
 
});
</script>

<div id="Zikbreadcrumbback" style="margin-left: 20px;"> 
<div
	class="Zikbreadcrumb f-l"> 
	<div class="fifteen columns"
	id="page-title"> <a style="margin-top: -3px;" class="back"
	href="javascript:history.back()"></a> <p class="page-title"> <span
	style="font-size: 13px; color: #6bbde8;">Home</span> < Create Content </p>
</div> 
</div> <!--end of breadcrumb--> 
</div>

<div class="Clearfix"></div>
<div id="contentpanel">
 <div class="tilecontainer pull-left"
			style="margin-top: 40px; width: 140px;margin-left:10px;"> 
			<div class="tile bg-color-orange icon" id="uploadbtn" style="">
			<div class="tile-content"> 
				<a href="/ziksana-web/zcourse/1/createcontent">
				<img src="${staticFileServer}resources/images/content/upload.png" /></a>
			</div>
			<div class="brand"> 
				<h3 style="margin-left: 10px; font-size: 16px; width: 160px;"> 
				<a href="/ziksana-web/zcourse/1/createcontent" style="font-size: 16px;">Upload Content</a> 
			</h3> 
	</div> 
	</div> 
		
		
		<div class="tile bg-color-grayDark icon" id="addweblinkbtn" style="">
			<div class="tile-content"> 
				<a href="/ziksana-web/zcourse/1/weblinkcontent">
				<img src="${staticFileServer}resources/images/content/link.png" /></a>
			 </div> 
		 <div  class="brand"> 
			<h3 style="margin-left: 10px; font-size: 16px; width: 160px;">
			<a href="/ziksana-web/zcourse/1/weblinkcontent" style="font-size: 16px;">Add Web Link</a> </h3> 
		</div> 
			</div> 
			
			<div class="Clearfix"></div> </div>
			 <!--end of tiles container--> 
			 <div class="contentarea pull-right" style="width: 940px;"> 
			<%--  <c:if test="${message != null}">
    				<div class="sucessmssg" id="sucessmsg"><p>${message}</p></div>
				</c:if> 
			 <div class="createcontentwrapper"> 
		<script>setTimeout( "jQuery('#sucessmsg').hide();",3000 );</script>--%>
<div class="uploadcontent2">
	<div class="createcontentpanelhead">Upload Content</div> <!--end of panel head-->
		
	<form  id="editcontentform" action="/ziksana-web/zcourse/1/editcontents" method="post"> 
	<% List<LearningContent> list = (List<LearningContent>) request.getAttribute("learningContentlist");
		try {
	 	for (LearningContent content : list) {
	 		
	 		
	 %> 
		 <div class="edit_content_info" id="content_<%=content.getId()%>" style="min-height: 320px;">
		 <div class="Clearfix"></div>
	  <div class="uploadphoto pull-left" style="width: 150px;padding: 10px;">
	  <% 
	  
	 	 String imagePath="../../resources/images/preview/image.png";
			if ("VIDEO".equalsIgnoreCase(ContentType.VIDEO.getName())){
				imagePath="../../resources/images/preview/video.png";
			} else if("AUDIO".equalsIgnoreCase(ContentType.AUDIO.getName())){
				imagePath="../../resources/images/preview/audio.png";
			} else if("PDF".equalsIgnoreCase(ContentType.PDF.getName())){
				imagePath="../../resources/images/preview/pdf.png";
			}else if("PPT".equalsIgnoreCase(ContentType.PPT.getName())){
				imagePath="../../resources/images/preview/ppt.png";
			} else if("DOC".equalsIgnoreCase(ContentType.DOC.getName())){
				imagePath="../../resources/images/preview/doc.png";
			}
	  %>
	  
				<img id="thumbnail_image_<%=content.getId()%>" src="<%=imagePath%>" style="width: 70px;height:70px;margin-bottom: 4px;margin-left: 20px;" align="left" />
				<div id="message_<%=content.getId()%>"></div>
						<div id="thubmnail_upload_message_<%=content.getId()%>"></div>
						<div id="loaderText_<%=content.getId()%>"></div>
						<input type="file" name="thumbnail_image_file_upload_<%=content.getId()%>" id="thumbnail_image_file_upload_<%=content.getId()%>" style="width: 70px;height:70px;margin-bottom: 4px;" />
							<input type="hidden" name="content_id[]" value="<%=content.getId()%>"/>
							<% String old_thumbnail_path = "${staticFileServer}resources/images/genetics.jpg"; %>
							<input type="hidden" name="thumbnail_path[]" id="thumbnail_path_<%=content.getId()%>" value=""/>
						<div id="status_<%=content.getId()%>"></div>

						<script type="text/javascript">
							$(function() {
								$('#thumbnail_image_file_upload_<%=content.getId()%>').uploadify(
												{'swf' : '${staticFileServer}resources/swf/uploadify.swf',
													'queueSizeLimit' : 1,
													'successTimeout' : 350,
													'buttonText' : 'Upload Image',
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
															content_path = data_object.ContentPath;
															content_name = data_object.ContentName;
															content_type_id = data_object.ContentType;
															content_type_name = data_object.ContentTypeName;
															thumbnail_path = data_object.ThumbnailPicturePath;
															no_of_thumbnails = data_object.NumberOfThumbnails;

															$('#thumbnail_path_<%=content.getId()%>').val(content_path);
															$('#thumbnail_image_<%=content.getId()%>').attr('src','${ms.url}'+content_path);



														} else { //there is an error in the upload process

															$('#message').html(data_object.message);
														}
														$('#sbtvalidation').removeAttr('disabled'); //enable submit button

													}
												// Your options here
												});
							});


						</script>
					</div>

 <!--end of uploadphoto--> 
 <div class="uploaded_file_contents">
 	<div class="rowfields pull-left" style="height: 145px;width:82%;"> 
 	<ul style="margin-top: 30px;">
		<li style="padding-right: 30px;color:#fff;font-size:15px;width:55%">  
			<label id="labelContentId<%=content.getId()%>" name="content_name[]"><%=content.getContentName()%></label>
			<input style="display:none" type="text" id="EditName<%=content.getId()%>" name="content_name[]" value="<%=content.getContentName()%>" style="height:30px;width:238px"/>
		</li> 
		<li style="color:#fff;font-size:15px;text-align:center;width:16%">
		
		<a onclick="shotxtbox(<%=content.getId()%>)" style="cursor:pointer;font-size:13px;" class="editcntent" >
		<img src="../../resources/images/content/edit.svg" style="width:19px; height:30px"/> Edit Name</a></li>
		<li style="width:13%;text-align:center;">
		<a class="editdetailuplbtn toggle_details" style="cursor:pointer;text-align:center;font-size:13px;" >
		<img src="../../resources/images/content/edit.svg" style="width:19px;margin-right: 3px; height:30px"/>Edit Details</a></li>
		<li style="width:15%;text-align:center;padding-top:4px"><a title="Delete" onclick="deleteContent(<%=content.getId()%>);" class="remove_this">X</a></li>
	</ul> 
	</div> 

	<div class="editslideup1 clearfix details" style="display:none"> 
		<div class="editslideup1 clearfix details" style="display:none"> 
		<div class="editslide pull-left"> 
		<label for="ContentDescription" style="width:100%;clear:both; margin-top: 6px;">Description</label>
		<textarea rows="4" cols="12"
		style="width: 350px; margin-bottom: 10px; margin-left: 5px;" id="ContentDescription"  name="content_desc[]" placeholder="Describe the content uploaded"></textarea>
		</div>
		<div class="editslide pull-left" style="margin-left: 15px;width: 56%;">
		<ul><li style="margin-bottom: 10px;">	<label> Area</label>
			<select
				class="Careaddl select" name="content_area[]"> <option>Specify Area</option>
			</select></li><li  style="margin-bottom: 10px;">
			<label> Subject</label> 
			<select class="select Csubjectddl" name="content_subject[]"> <option>Specify
			Subject</option> </select></li>
			 <li>
			<label> Topic</label>
			<select class="select Ctopicddl" name="content_topic[]" > <option>Specify
			Topic</option> </select> </li>
		 <li>	<label>Specify Tags</label>
		 <input type="text" placeholder="Specify Tags" name="content_tags[]" style="height: 30px; margin-right: 12px; width: 233px;"> 
			</li></ul>
		</div> 

	</div> <!--end of continaer--> 
	
</div>	
 <%}
		}catch(Exception e){
		e.printStackTrace();	
		}
%>
</div>

<div class="clearfix"></div> 

</div> <!-- end of uploadrow-->
</form> 
</div>



<div class="createcontentpanelhead" style="margin-top: 4px;"> 
	<a href="#linkurl" class="btn pull-right" style="margin-left: 10px;" type="button" onClick="$('form#editcontentform').submit();"> Save </a> 
	<a	href="/ziksana-web/zcourse/1/createcontent" class="btn pull-right saveup1" style="margin-left: 10px;"> Previous </a>
	
	<!--  <a href="#linkurl" class="btn pull-right saveup1" style="margin-left: 10px;"> Previous</a> -->
<div class="clearfix"></div> 
</div> <!--end of panel head--> 


</div> <!--end of uploadcontent2-->
</div> <!--end of image wrapper --> </div> <!--end of contentarea--> 
</div>

<!--end of contentpanel-->
<!--end of body wrapper-->

<div class="Clearfix"></div>

<style>
.editcntent:hover{color:#fff!important;text-decoration:none}
.editdetailuplbtn:hover{color:#fff!important;text-decoration:none;}
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
  width: 19px;
}

a.remove_this:hover {
	color: red!important;
	border-color: red;
	text-decoration: none;
}
.editslide label{ color:#fff;padding-left:6px;margin-bottom: 4px;}
.editslide ul{
list-style: none ;
width: 559px;overflow:hidden}
  
.editslide li {
  float: left; 
}
.sucessmssg {
   
  color: green;
  margin-top: -29px;
  position: absolute;
  text-align: center;
  width: 70%;
}

.tileheadaa {
	margin-left: 20px;
	font-size: 20px;
 
}

.tileheadaa {
	margin-left: 20px;
	font-size: 20px;

 
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
 
.select2-container {
	margin-right: 10px !important;
	width: 235px;
}
.edit_content_info{background:#0099cc}
.uploadify{left:0px!important}

.rowfields ul {
overflow:hidden
}
.rowfields li {
  width: 33%;
}
.rowfields li input{
  height: 26px;
  width: 180px;
}
</style>

<script type="text/javascript">
$(function(){

$('.toggle_details').on('click', function(){
	toggle_handle = $(this);
	parent_container = toggle_handle.parents('.uploaded_file_contents');
	details_container = parent_container.find('div.details');
	if(details_container.is(':visible')){ //details container is visible
		details_container.hide();
	} else {
		details_container.show();
	}
});

});//end of doc ready

function shotxtbox(val){
$('#labelContentId'+val+'').hide();
$('#EditName'+val+'').show();


}
</script>
 