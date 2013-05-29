	itemsPerPage = 2;
	defaultPageIndex = 1;
	noOfPages = new Number(0);

$(document).ready(function() {
	getAllLearningContents();
});

function getOtherLearningContents(contentType, pageIndex){
	
	if(!pageIndex || "" == pageIndex){
		pageIndex = defaultPageIndex;
	}

	$('#container4').empty();
	var jsonString = document.getElementById("learingContents").value;
	//var jsonString = getFromSessionStorage(sessionKey);
	var contentArray = jQuery.parseJSON( jsonString );
	
	// first create a separate array based on content type
	var contentArrayBasedOnContentType = new Array();
	var j =0;
	for(i=0;i<contentArray.length;i++){
		if('VIDEO' != contentArray[i].contentType.toUpperCase() && 'LINK' != contentArray[i].contentType.toUpperCase()){
			contentArrayBasedOnContentType[j] = contentArray[i];
			j++;
		}
	}
	console.log("contentArray.length " + contentArray.length);
	console.log("contentArrayBasedOnContentType.length " + contentArrayBasedOnContentType.length);
	noOfPages = Math.ceil(contentArrayBasedOnContentType.length/itemsPerPage);
	console.log("noOfPages " + noOfPages);
	
	getPageDiv(noOfPages, "OTHERS");
	console.log("getPageDiv(noOfPages, OTHERS)" + getPageDiv(noOfPages, "OTHERS"));
	var divs = '';
	if(pageIndex == 1){
		for(i=0;i<contentArrayBasedOnContentType.length;i++){
			divs = divs + getDiv(contentArrayBasedOnContentType[i]);
			if(i==(itemsPerPage-1)){
				break;
			}
		}
		//console.log("othersssssssssssssss " + divs);
	}
	else{
		for(i=((pageIndex-1) * itemsPerPage);i<contentArrayBasedOnContentType.length;i++){
			divs = divs + getDiv(contentArrayBasedOnContentType[i]);
			if(i == ((itemsPerPage * pageIndex)-1)){
				break;
			}
		}
		
	}		
	$('#container4').html(divs);
}

function getLearningContentsByType(contentType, pageIndex){

	if(!pageIndex || "" == pageIndex){
		pageIndex = defaultPageIndex;
	}
	
	$('#container4').empty();
	var jsonString = document.getElementById("learingContents").value;
	//var jsonString = getFromSessionStorage(sessionKey);
	var contentArray = jQuery.parseJSON( jsonString );
	
	// first create a separate array based on content type
	var contentArrayBasedOnContentType = new Array();
	var j =0;
	for(i=0;i<contentArray.length;i++){
		if(contentType.toUpperCase() == contentArray[i].contentType.toUpperCase()){
			contentArrayBasedOnContentType[j] = contentArray[i];
			j++;
		}
	}
	console.log("contentArray.length " + contentArray.length);
	console.log("contentArrayBasedOnContentType.length " + contentArrayBasedOnContentType.length);
	noOfPages = Math.ceil(contentArrayBasedOnContentType.length/itemsPerPage);
	console.log("noOfPages " + noOfPages);
	
	getPageDiv(noOfPages, contentType);

	var divs = '';
	if(pageIndex == 1){
		for(i=0;i<contentArrayBasedOnContentType.length;i++){
			divs = divs + getDiv(contentArrayBasedOnContentType[i]);
			if(i==(itemsPerPage-1)){
				break;
			}
		}
	}
	else{
		for(i=((pageIndex-1) * itemsPerPage);i<contentArrayBasedOnContentType.length;i++){
			divs = divs + getDiv(contentArrayBasedOnContentType[i]);
			if(i == ((itemsPerPage * pageIndex)-1)){
				break;
			}
		}
		
	}		
	//console.log("divs --->> " + divs);
	$('#container4').html(divs);
}

function getAllLearningContents(pageIndex){
	
	if(!pageIndex || "" == pageIndex){
		pageIndex = defaultPageIndex;
	}
	
	$('#container4').empty();
	var jsonString = document.getElementById("learingContents").value;
	var contentArray = jQuery.parseJSON( jsonString );
	console.log("contentArray.length " + contentArray.length + " itemsPerPage  " + itemsPerPage);
	noOfPages = Math.ceil(contentArray.length/itemsPerPage);
	
	getPageDiv(noOfPages, "ALL");
	
	
	console.log("noOfPages " + noOfPages);
	var divs = '';
	
	if(pageIndex == 1){
		for(i=0;i<contentArray.length;i++){
			divs = divs + getDiv(contentArray[i]);
			if(i==(itemsPerPage-1)){
				break;
			}
		}
	}
	else{
		for(i=((pageIndex-1) * itemsPerPage);i<contentArray.length;i++){
			divs = divs + getDiv(contentArray[i]);
			if(i == ((itemsPerPage * pageIndex)-1)){
				break;
			}
		}
		
	}		
	$('#container4').html(divs);
}

function getDiv(learningContentObject) {

	var viewer_url = '';
	content_type = learningContentObject.contentType.toUpperCase();

	if (content_type == 'VIDEO' || content_type == 'AUDIO') {
		viewer_url = '/ziksana-web/zcourse/modalplayer/'
				+ learningContentObject.id;
	} else if (content_type == 'IMAGE') {
		viewer_url = '/ziksana-web/zcourse/slides/' + learningContentObject.id;
	} else if (content_type == 'DOC' || content_type == 'PPT'
			|| content_type == 'PDF') {
		viewer_url = '/ziksana-web/zcourse/slides/' + learningContentObject.id;
	} else if (content_type == 'LINK') {
		viewer_url =   learningContentObject.contentUrl;
	}

	var learningContentDiv = '<div id="createcontent-main" class="item All">'
			+ '<p class="createcontenthead">'
			+ learningContentObject.contentName
			+ '</p><p class="createcontentimg">'
			+ '<img src="../../resources/images/genetics.jpg" />'
			+ '</p>'
			+ '<div class="description">'
			+ '<a onclick="deleteContent('
			+ learningContentObject.id
			+ ');" class="pull-right"><img class="iconcc" src="../../resources/images/content/deleteicon.png"style="height: 35px;" /></a> <a href="'
			+ viewer_url
			+ '"  class="pull-right"><img src="../../resources/images/content/view-content.png" style="height: 35px;" /></a>'
			+ '</div>' + '<div class="Clearfix"></div>' + '</div>';

	return learningContentDiv;

}

function getPageDiv(noOfPages, filterType){
	var pageDiv = $('#pageNumbers');
	var functionName = '';
	if("ALL" == filterType){
		functionName = 'getAllLearningContents(';
	}
	else if("VIDEO" == filterType || "LINK" == filterType){
		functionName = 'getLearningContentsByType(\''+ filterType + '\',';
	}
	if("OTHERS" == filterType){
		functionName = 'getOtherLearningContents(\''+ filterType + '\',';
	}
	
	pageDiv.empty();
	for(i=1; i<=noOfPages; i++){
			pageDiv.append('<a onClick="' + functionName + i +')" href="#" id="btnpg1" class="swShowPageActive"></a>');
	}
}

function deleteContent(content_id) {
	confirm_delete = confirm('Are you sure?');
	if (confirm_delete) {
		if (confirm_delete_component == true) {
			uri = '/ziksana-web/zcourse/1/unassociatecontent';

			//token = ''; // dummy token for demo. you have to send real token.
			request_type = 'POST'; // can be GET or POST. In this case, a GET
			// request

			var CourseId = $('#courseid').val();
			nodeParentId = tree.getParentId(ComponentId);
			//alert("ComponentId " + ComponentId.split('_')[1] + " CourseId "  + CourseId + " nodeParentId " + nodeParentId.split('_')[1]);

			var parameters = {
				"courseId" : CourseId,
				"componentId" : nodeParentId.split('_')[1],
				"contentId" : ComponentId.split('_')[1]
			};
			
			console.log("delete content course id is  " + CourseId);
			console.log("parameters.length " + parameters.length);
			
			//return;
			
			$.post(uri, parameters, function(data) {
				console.log(data);
				if (data.response == 'success') {
					course_id = data.id;
				} else {
					$('#tempdiv').html(
							'<span style="color:red;">' + data.message
									+ '</span>');
				}
				//alert("data.message " + data.message);
			});
			

		}
	}
}
