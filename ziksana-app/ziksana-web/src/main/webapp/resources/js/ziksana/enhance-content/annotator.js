

var jsonObject = null;
var originalContentPath = "";
var componentId = parent.selectedTreeContentComponentId;
var contentId = parent.selectedTreeContentId;
var courseId = parent.courseId;
var learningContentObject = parent.getLearningContentObject(contentId);




function ff_get_content_key()
{
	originalContentPath = learningContentObject.contentURL;
	
	//TODO delete later for testing only
	//var testVar = '{"Uploaded":"true", "ContentPath":"/var/www/html/zikload-xml/uploads/document/f1371192015", "ThumbnailPicturePath":"/var/www/html/zikload-xml/uploads/document/f1371192015/thumbnails/", "NumberOfThumbnails":"1", "ContentType":"pdf", "ContentKey":"f1371192015","Decoration":"Annotated"}';
	//jsonObject = parent.getJsonObject(testVar);
	//console.log("got the json object " + jsonObject.Uploaded);
	//createContent();
	//console.log(contentId + "     originalContentPath ---------->>>>> " + originalContentPath);
	return originalContentPath;
}

function ff_set_response(annotationResponse)
{
	//console.log("annotationResponse " + annotationResponse);
	//TODO delete later for testing only
	//annotationResponse = '{"Uploaded":"true", "ContentPath":"/var/www/html/zikload-xml/uploads/document/f1371192015", "ThumbnailPicturePath":"/var/www/html/zikload-xml/uploads/document/f1371192015/thumbnails/", "NumberOfThumbnails":"1", "ContentType":"pdf", "ContentKey":"f1371192015","Decoration":"Annotated"}';

	jsonObject = parent.getJsonObject(annotationResponse);
	if(jsonObject.ContentKey != originalContentPath){
		//console.log("Creating a new content old key was "  + originalContentPath + " and the new key is  " + jsonObject.ContentKey);
		createContent();
	}
	//TODO delete later
	else{
		//console.log("Doing nothing old key was "  + originalContentPath + " and the new key is  " + jsonObject.ContentKey);
	}
	
}

function createContent(){
	
	var uri = parent.serverContext  + 'zcourse/1/annotate';
	//console.log("came here jsonObject.NumberOfThumbnails " + jsonObject.NumberOfThumbnails);
	//console.log("the values are " + jsonObject.ThumbnailPicturePath + " " + jsonObject.Decoration + " " + jsonObject.ContentKey);
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
		//console.log(data);
		if (data.response == 'success') {
			// what to do here?
			//console.log("Annoation saved");
			return "SUCCESS";
		} else {
			$('#tempdiv1').html(
					'<span style="color:red;">'
							+ "Failed" + '</span>');
			return "FAIL";
		}
		//console.log("reached here.......................");
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
	refreshTree();
}

function ff_display_console_message(msg){
	//switch on this if you want log messages from flash
	//console.log(msg);
	
}

function refreshTree(){
	parent.document.location.reload(true);
}
