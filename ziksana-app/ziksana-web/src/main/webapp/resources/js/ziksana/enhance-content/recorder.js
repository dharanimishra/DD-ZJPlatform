

var jsonObject = null;
var originalContentPath = "";
var componentId = parent.selectedTreeContentComponentId;
var contentId = parent.selectedTreeContentId;
var courseId = parent.courseId;
var learningContentObject = parent.getLearningContentObject(contentId);




function ff_get_content_key()
{
	if("" == originalContentPath.trim()){
		originalContentPath = learningContentObject.contentURL;
	}
	//console.log("originalContentPath " + originalContentPath);
	return originalContentPath;
}

function ff_set_response(recordingResponse)
{
	//console.log("recording Response is " + recordingResponse);

	jsonObject = parent.getJsonObject(recordingResponse);
	console.log(jsonObject.ContentKey + "<<<<<<<<<<<<<<<<<<<<<<<< ------------- >>>>>>>>>>>>>>>>>   "+ originalContentPath);
	if(jsonObject.ContentKey != originalContentPath){
		console.log("Creating a new content old key was "  + originalContentPath + " and the new key is  " + jsonObject.ContentKey);
		originalContentPath = jsonObject.ContentKey;
		createContent();
		//console.log("ff_get_content_key() ===============  " + ff_get_content_key());
	}
	//TODO delete later
	else{
		//console.log("Doing nothing old key was "  + originalContentPath + " and the new key is  " + jsonObject.ContentKey);
	}
	
}

function createContent(){
	
	var uri = '/ziksana-web/zcourse/1/record';
	console.log("came here jsonObject.NumberOfThumbnails " + jsonObject.NumberOfThumbnails);
	console.log("the values are " + jsonObject.ThumbnailPicturePath + " " + jsonObject.Decoration + " " + jsonObject.ContentKey);
	var parameters = {
		"contentPath" : jsonObject.ContentKey,
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

function ff_display_console_message(msg){
	//switch on this if you want log messages from flash
	//console.log(msg);
}

function refreshTree(){
	parent.document.location.reload(true);
}

function refreshTree(){
	parent.document.location.reload(true);
	
}

function ff_in_progress(){
	 alert("Work in progress");
}
