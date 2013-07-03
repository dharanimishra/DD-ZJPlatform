

var jsonObject = null;
var originalContentPath = "";
var componentId = parent.selectedTreeContentComponentId;
var contentId = parent.selectedTreeContentId;
var courseId = parent.courseId;
var learningContentObject = parent.getLearningContentObject(contentId);





function getEnrichmentsByType(enrichmentType){
	var jsonString = $("#enrichmentList").val();
	var contentEnrichmentArray = jQuery.parseJSON( jsonString );
	var filteredArray = new Array();
	var j = 0;
	for(var i=0; i < contentEnrichmentArray.length; i++){
		var contentEnrichment = contentEnrichmentArray[i];
		if(enrichmentType.toUpperCase() == contentEnrichment.enrichmentType.toUpperCase()){
			filteredArray[j] = contentEnrichment;
			j++;
		}
	}
	return filteredArray;
}

function ff_get_content_key()
{
	
	originalContentPath = learningContentObject.contentURL;
	//console.log("originalContentPath ---->>>>>>>  " + originalContentPath);
	var uri = "http://54.243.235.88/zikload-xml/uploads/video/" + originalContentPath + "/" + originalContentPath +".mp4";
	return uri;
}

function ff_set_response(enrichResponse)
{
	//console.log("enrichResponse is " + enrichResponse);
	jsonObject = parent.getJsonObject(enrichResponse);
	console.log(jsonObject.ContentKey + "<<<<<<<<<<<<<<<<<<<<<<<< ------------- >>>>>>>>>>>>>>>>>   "+ originalContentPath);
	if(jsonObject.ContentKey != originalContentPath){
		//console.log("Creating a new content old key was "  + originalContentPath + " and the new key is  " + jsonObject.ContentKey);
		//createContent();
	}
	//TODO delete later
	else{
		//console.log("Doing nothing old key was "  + originalContentPath + " and the new key is  " + jsonObject.ContentKey);
	}
}

function createContent(){
	
	var uri = '/ziksana-web/zcourse/1/enrich';
	//console.log("came here jsonObject.NumberOfThumbnails " + jsonObject.NumberOfThumbnails);
	//console.log("the values are " + jsonObject.ThumbnailPicturePath + " " + jsonObject.Decoration + " " + jsonObject.ContentKey);
	var parameters = {
		"contentPath" : jsonObject.ContentKey,
		"contentType" : jsonObject.ContentType,
		"decorationTypeName" : jsonObject.Decoration,
		"thumbnailPath" : jsonObject.ThumbnailPicturePath,
		"noOfThumbnails" : jsonObject.NumberOfThumbnails,
		"learningComponentId" : componentId,
		"previousLearningContentId" : contentId
	};
	//console.log("delete content course id is  " + CourseId);
	//console.log("parameters.length " + parameters.length);
	
	//return;
	$.post(uri, parameters, function(data) {
		console.log(data);
		if (data.response == 'success') {
			// what to do here?
			console.log("Recording saved");
			return "SUCCESS";
		} else {
			$('#tempdiv1').html(
					'<span style="color:red;">'
							+ "Failed" + '</span>');
			return "FAIL";
		}
		//console.log("reconrd content response is ------>>>>>  " + data.response);
	});
}

function ff_get_content_format()
{
	// video linux server needs it in lower case
	return learningContentObject.contentFormat.toLowerCase();
}


function ff_get_decoration_type()
{
	return "Decoration:Annotated";
}
function ff_close_player(){
	//alert("Hissssssssssss I am here");
	//window.parent.$('#page-header-div').show();
	//window.parent.$('#definetab').show();
	//window.parent.$('#leftPane').show();
	//window.parent.$('#recorded_content_container').hide();
	refreshTree();
}

function  ff_console_log(msg){
	//switch on this if you want log messages from flash
	console.log(msg);
}

function refreshTree(){
	parent.document.location.reload(true);
}

function refreshTree(){
	parent.document.location.reload(true);
	
}

function saveEnrichment(jsonString){
	
	//alert("jsonString ====  " + jsonString);
	var uri = '/ziksana-web/zcourse/1/enrichment';
	var parameters = {
		"courseId" : courseId,
		"jsonResponse" : jsonString,
		"learningComponentId" : componentId,
		"learningContentId" : contentId
	};
	
	//return 787878;
	var id = -1;
	jQuery.ajax({
        url:    uri,
        success: function(result) {
	        id = result;
        },
        async:   false,
        data: parameters
   });
	//alert("id is " + id);
	return id;
}

function getEnrichmentId(){
	return $('#enrich_id').val();
}

function editEnrichment(jsonString){
	
	//alert("jsonString ====  " + jsonString);
	var uri = '/ziksana-web/zcourse/1/enrichment';
	var parameters = {
		"courseId" : courseId,
		"jsonResponse" : jsonString,
		"learningComponentId" : componentId,
		"learningContentId" : contentId
	};
	
	var id = -1;
	jQuery.ajax({
        url:    uri,
        success: function(result) {
	        id = result;
        },
        async:   false,
        data: parameters
   });
	return id;
}


function deleteEnrichment(jsonString){
	
	//alert("jsonString ====  " + jsonString);
	var uri = '/ziksana-web/zcourse/1/enrichment/3';
	var parameters = {
		"courseId" : courseId,
		"jsonResponse" : jsonString,
		"learningComponentId" : componentId,
		"learningContentId" : contentId
	};
	
	var success = false;
	jQuery.ajax({
        url:    uri,
        success: function(result) {
        	success = result;
        },
        async:   false,
        data: parameters
   });
	return success;
}
