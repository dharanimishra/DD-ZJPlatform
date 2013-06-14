

var response = "";
var originalContentPath = "";
var componentId = parent.selectedTreeContentComponentId;
var contentId = parent.selectedTreeContentId;




//var staticResponse = '{"}';
function ff_get_content_key()
{
	console.log('inside ff_get_content_key');
	originalContentPath = parent.getLearningContentObject(contentId).contentURL;
	//alert("originalContentPath " + originalContentPath);
	console.log("the key is " + parent.getJsonObject().ContentKey);
	return originalContentPath;
}

function ff_set_response(annotationResponse)
{
	response = annotationResponse;
	alert("response " + response);
}

function ff_get_content_format()
{
	return "document";
}


function ff_get_decoration_type()
{
	return "Decoration:Annotated";
}
function ff_close_player(){
	window.parent.$('#page-header-div').show();
	window.parent.$('#definetab').show();
	window.parent.$('#leftPane').show();
	window.parent.$('#annotated_content_container').hide();
}

function ff_display_console_message(msg){
	console.log(msg);
	
}

