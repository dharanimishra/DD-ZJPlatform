<%@ page language="java" contentType="text/xml"%>
<%@page import="java.util.*"%>
<%@page import="com.ziksana.domain.course.LearningContent"%>

<script type='text/javascript'
	src="${staticFileServer}resources/js/custom/plugins.js"></script>
<script type='text/javascript'
	src="${staticFileServer}resources/js/lib/plupload/previewupload.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/custom/createcontent/addweblink.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/Dynamicjsonjs/editcontentjson.js"></script>

 	 
 

<div id="Zikbreadcrumbback" style="margin-left: 20px;"> <div
	class="Zikbreadcrumb f-l"> <div class="fifteen columns"
	id="page-title"> <a style="margin-top: -3px;" class="back"
	href="javascript:history.back()"></a> <p class="page-title"> <span
	style="font-size: 13px; color: #6bbde8;">Home</span> < Create Content </p>
</div> </div> <!--end of breadcrumb--> </div>

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
			<div
			class="Clearfix"></div> </div>
			 <!--end of tiles container--> 
			 <div class="contentarea pull-right" style="width: 940px;"> 
			 <div class="createcontentwrapper"> 
	
<div class="uploadcontent2">
	<div class="createcontentpanelhead">Upload Content</div> <!--end of panel head-->
		<c:if test="${message != null}">
    				<div><p>${message}</p></div>
				</c:if>
	<form  id="editcontentform" action="/ziksana-web/zcourse/1/editcontents" method="post"> 
	<% List<LearningContent> list = (List<LearningContent>) request.getAttribute("learningContentlist");
		int i=0;
		try {
	 	for (LearningContent content : list) {
	 		
	 		
	 %> 
		 <div class="edit_content_info" id="content_<%=content.getId()%>">
		 <div class="Clearfix"></div>
		 <% if(i%2==0) {%> 
		<div class="uploadrowodd" style="padding: 10px;width:100%;overflow: hidden;margin:auto"> 
		<% } else {%>
		<div class="uploadroweven" style="padding: 10px;width:100%;margin:auto"> 
		<% 
		}%>
	  <div class="uploadphoto pull-left" style="width: 260px">
	  
	  
				<img id="thumbnail_image_<%=content.getId()%>" src="${staticFileServer}resources/images/preview/image.png" style="width: 70px;height:70px;margin-bottom: 4px;" align="left" />
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
 	<div class="rowfields pull-left" style="height: 145px;width:70%;"> 
 	<ul>
		<li style="padding-right: 30px;color:#fff;font-size:15px">File Name<br> 
			<label id="labelContentId<%=content.getId()%>" name="content_name[]"><%=content.getContentName()%></label>
			<input style="display:none" type="text" id="EditName<%=content.getId()%>" name="content_name[]" value="<%=content.getContentName()%>" style="height:30px;width:238px"/>
		</li> 
		<li style="padding-right: 30px;color:#fff;font-size:15px;text-align:left"><a onclick="shotxtbox(<%=content.getId()%>)" style="cursor:pointer" >Edit Name</a></li>
		<li><a class="editdetailuplbtn toggle_details" style="cursor:pointer;text-align:center">Edit Details</a></li>
	</ul> 
	</div> 

	<div class="editslideup1 clearfix details" style="display:none"> 
		<div class="editslide pull-left"> 
		<textarea rows="4" cols="12"
		style="width: 350px; margin-bottom: 10px; margin-left: 5px;" id="ContentDescription"  name="content_desc[]" placeholder="Details for the upload image"></textarea>
		</div> 
		<div class="editslide pull-left" style="margin-left: 5px;">
			 <input type="text" placeholder="Specify Tags" name="content_tags[]" style="height: 30px; margin-right: 12px; width: 233px;"> 
			
			<select
				class="Careaddl select" name="content_area[]"> <option>Specify Area</option>
			</select> <br> 
			<select class="select Csubjectddl" name="content_subject[]"> <option>Specify
			Subject</option> </select> 
			
			<select class="select Ctopicddl" name="content_topic[]" > <option>Specify
			Topic</option> </select>
		
		</div> 

	</div> <!--end of continaer--> 
	
</div>	

 <% if(i%2==0) {%> 
		</div>
		<% } else {%>
		</div> 
		<% 
		}%>
 <%
 i++;
	}
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
</div> <!--end of image wrapper --> </div> <!--end of contentarea--> </div>

<!--end of contentpanel-->

<div class="Clearfix"></div>

<!--end of body wrapper-->

<div class="Clearfix"></div>

<style>

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
.editdetailuplbtn:hover{color:#ccc!important;text-decoration:none}
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
 