itemsPerPage = 20;
defaultPageIndex = 1;
noOfPages = new Number(0);

$(document).ready(function() {
	getAllLearningContents();
});

function getBaseLearingContent(learningContentId){
	var jsonString = document.getElementById("learingContents").value;
	var contentArray = jQuery.parseJSON( jsonString );
	for(var i = 0; i<contentArray.length; i++){
		if(learningContentId == contentArray[i].id && (!contentArray[i].id || contentArray[i].id > 0)){
			getBaseLearingContent(contentArray[i].id);
		}
		else{
			return contentArray[i];
		}
	}
}

function getOtherLearningContents(contentType, pageIndex) {

	if (!pageIndex || "" == pageIndex) {
		pageIndex = defaultPageIndex;
	}

	$('#container4').empty();
	var jsonString = document.getElementById("learingContents").value;
	// var jsonString = getFromSessionStorage(sessionKey);
	var contentArray = jQuery.parseJSON(jsonString);

	// first create a separate array based on content type
	var contentArrayBasedOnContentType = new Array();
	var j = 0;
	for (i = 0; i < contentArray.length; i++) {
		if ('VIDEO' != contentArray[i].contentType.toUpperCase()
				&& 'LINK' != contentArray[i].contentType.toUpperCase()) {
			if(!contentArray[i].parentLearningContentId || contentArray[i].parentLearningContentId == 0){
				contentArrayBasedOnContentType[j] = contentArray[i];
				j++;
			}
		}
	}
	//console.log("contentArray.length " + contentArray.length);
	//console.log("contentArrayBasedOnContentType.length "
	//		+ contentArrayBasedOnContentType.length);
	noOfPages = Math.ceil(contentArrayBasedOnContentType.length / itemsPerPage);
	//console.log("noOfPages " + noOfPages);

	if(contentArrayBasedOnContentType.length ==0){
		setNoContentFoundText(contentType);
		//$("#content_type_filter").hide();
	}
	else{
		setNoContentFoundText('');
		$("#content_type_filter").show();
	}
	
	
	if(contentArrayBasedOnContentType.length > itemsPerPage){
		getPageDiv(noOfPages, "OTHERS", pageIndex);
	}
	else{
		$('#pageNumbers').empty();
	}

	var divs = '';
	if (pageIndex == 1) {
		for (i = 0; i < contentArrayBasedOnContentType.length; i++) {
			divs = divs + getDiv(contentArrayBasedOnContentType[i]);
			if (i == (itemsPerPage - 1)) {
				break;
			}
		}
		// console.log("othersssssssssssssss " + divs);
	} else {
		for (i = ((pageIndex - 1) * itemsPerPage); i < contentArrayBasedOnContentType.length; i++) {
			divs = divs + getDiv(contentArrayBasedOnContentType[i]);
			if (i == ((itemsPerPage * pageIndex) - 1)) {
				break;
			}
		}

	}
	$('#container4').html(divs);
}

function getLearningContentsByType(contentType, pageIndex) {

	if (!pageIndex || "" == pageIndex) {
		pageIndex = defaultPageIndex;
	}

	$('#container4').empty();
	var jsonString = document.getElementById("learingContents").value;
	// var jsonString = getFromSessionStorage(sessionKey);
	var contentArray = jQuery.parseJSON(jsonString);

	// first create a separate array based on content type
	var contentArrayBasedOnContentType = new Array();
	var j = 0;
	for (i = 0; i < contentArray.length; i++) {
		if (contentType.toUpperCase() == contentArray[i].contentType
				.toUpperCase()) {
			if(!contentArray[i].parentLearningContentId || contentArray[i].parentLearningContentId == 0){
				contentArrayBasedOnContentType[j] = contentArray[i];
				j++;
			}
		}
	}
	//console.log("contentArray.length " + contentArray.length);
	//console.log("contentArrayBasedOnContentType.length "
	//		+ contentArrayBasedOnContentType.length);
	noOfPages = Math.ceil(contentArrayBasedOnContentType.length / itemsPerPage);
	//console.log("noOfPages " + noOfPages);
	
	if(contentArrayBasedOnContentType.length ==0){
		setNoContentFoundText(contentType);
		//$("#content_type_filter").hide();
	}
	else{
		setNoContentFoundText('');
		$("#content_type_filter").show();
	}
	
	
	if(contentArrayBasedOnContentType.length > itemsPerPage){
		getPageDiv(noOfPages, contentType, pageIndex);
	}
	else{
		$('#pageNumbers').empty();
	}

	var divs = '';
	if (pageIndex == 1) {
		for (i = 0; i < contentArrayBasedOnContentType.length; i++) {
			divs = divs + getDiv(contentArrayBasedOnContentType[i]);
			if (i == (itemsPerPage - 1)) {
				break;
			}
		}
	} else {
		for (i = ((pageIndex - 1) * itemsPerPage); i < contentArrayBasedOnContentType.length; i++) {
			divs = divs + getDiv(contentArrayBasedOnContentType[i]);
			if (i == ((itemsPerPage * pageIndex) - 1)) {
				break;
			}
		}

	}
	// console.log("divs --->> " + divs);
	$('#container4').html(divs);
}

function getAllLearningContents(pageIndex) {

	if (!pageIndex || "" == pageIndex) {
		pageIndex = defaultPageIndex;
	}

	$('#container4').empty();
	var jsonString = document.getElementById("learingContents").value;
	var contentArray = jQuery.parseJSON(jsonString);

	var contentArrayWithoutParent = new Array();
	var j = 0;
	for (i = 0; i < contentArray.length; i++) {
		if(!contentArray[i].parentLearningContentId || contentArray[i].parentLearningContentId == 0){
			contentArrayWithoutParent[j] = contentArray[i];
			j++;
		}
	}
	
	
	//console.log("contentArray.length " + contentArrayWithoutParent.length
	//		+ " itemsPerPage  " + itemsPerPage);
	noOfPages = Math.ceil(contentArrayWithoutParent.length / itemsPerPage);
	
	if(contentArrayWithoutParent.length ==0){
		setNoContentFoundText("ALL");
		$("#content_type_filter").hide();
	}
	else{
		setNoContentFoundText('');
		$("#content_type_filter").show();
	}
	
	if(contentArrayWithoutParent.length > itemsPerPage){
		getPageDiv(noOfPages, "ALL", pageIndex);
	}
	else{
		$('#pageNumbers').empty();
	}

	//console.log("noOfPages " + noOfPages);
	var divs = '';

	if (pageIndex == 1) {
		for (i = 0; i < contentArrayWithoutParent.length; i++) {
			divs = divs + getDiv(contentArrayWithoutParent[i]);
			if (i == (itemsPerPage - 1)) {
				break;
			}
		}
	} else {
		for (i = ((pageIndex - 1) * itemsPerPage); i < contentArrayWithoutParent.length; i++) {
			divs = divs + getDiv(contentArrayWithoutParent[i]);
			if (i == ((itemsPerPage * pageIndex) - 1)) {
				break;
			}
		}

	}
	$('#container4').html(divs);
}

function getDiv(learningContentObject) {

	var viewer_url = '';
	var preview_path = '';

	var staticFileServerPath = $("#fileServerPath").val();
	//console.log("In my content getPreviewPath" + staticFileServerPath);
	var content_type = learningContentObject.contentType.toUpperCase();
	var screenshotPath = learningContentObject.screenshotPath;
	
	//console.log(" content_type :"+content_type);

	if (content_type == 'VIDEO') {
		viewer_url = '/ziksana-web/zcourse/1/modalplayer/'
				+ learningContentObject.id;
		if (screenshotPath
				&& (screenshotPath != null || screenshotPath.trim() != "")) {
			preview_path = staticFileServerPath + screenshotPath;
			//console.log("In my content in the if  for "
			//		+ learningContentObject.contentName + " - " + preview_path);
		} else {
			preview_path = '../../resources/images/preview/video.png';
		}
	} else if (content_type == 'AUDIO') {
		viewer_url = '/ziksana-web/zcourse/1/modalplayer/'
				+ learningContentObject.id;
		if (screenshotPath
				&& (screenshotPath != null || screenshotPath.trim() != "")) {
			preview_path = staticFileServerPath + screenshotPath;
			//console.log("In my content in the if  for "
			//		+ learningContentObject.contentName + " - " + preview_path);
		} else {
			preview_path = '../../resources/images/preview/audio.png';
		}
	} else if (content_type == 'IMAGE') {
		viewer_url = '/ziksana-web/zcourse/1/slides/'
				+ learningContentObject.id;
		if (screenshotPath
				&& (screenshotPath != null || screenshotPath.trim() != "")) {
			preview_path = staticFileServerPath + screenshotPath;
			//console.log("In my content in the if  for "
			//		+ learningContentObject.contentName + " - " + preview_path);
		} else {
			preview_path = '../../resources/images/preview/image.png';
		}
	} else if (content_type == 'DOC') {
		viewer_url = '/ziksana-web/zcourse/1/slides/'
				+ learningContentObject.id;
		if (screenshotPath
				&& (screenshotPath != null || screenshotPath.trim() != "")) {
			preview_path = staticFileServerPath + screenshotPath;
			//console.log("In my content in the if  for "
			//		+ learningContentObject.contentName + " - " + preview_path);
		} else {
			preview_path = '../../resources/images/preview/doc.png';
		}
	} else if (content_type == 'PPT') {
		viewer_url = '/ziksana-web/zcourse/1/slides/'
				+ learningContentObject.id;
		if (screenshotPath
				&& (screenshotPath != null || screenshotPath.trim() != "")) {
			preview_path = staticFileServerPath + screenshotPath;
			//console.log("In my content in the if  for "
			//		+ learningContentObject.contentName + " - " + preview_path);
		} else {
			preview_path = '../../resources/images/preview/ppt.jpg';
		}
	} else if (content_type == 'PDF') {
		viewer_url = '/ziksana-web/zcourse/1/slides/'
				+ learningContentObject.id;
		if (screenshotPath
				&& (screenshotPath != null || screenshotPath.trim() != "")) {
			preview_path = staticFileServerPath + screenshotPath;
			//console.log("In my content in the if  for "
			//		+ learningContentObject.contentName + " - " + preview_path);
		} else {
			preview_path = '../../resources/images/preview/pdf.png';
		}
	} else {
		if (screenshotPath
				&& (screenshotPath != null || screenshotPath.trim() != "")) {
			preview_path = staticFileServerPath + screenshotPath;
		console.log("In my content in the if  for "
					+ learningContentObject.contentName + " - " + preview_path+" content_type"+content_type);
		} else {
			preview_path = '../../resources/images/preview/link.png';
		}
	}
	var learningContentDiv='';
	
	if(content_type == 'LINK'){
		 learningContentDiv = '<div id="createcontent-main" class="item All">'
				+ '<p class="createcontenthead">'
				+ learningContentObject.contentName
				+ '</p><p class="createcontentimg">'
				+ '<img src="'
				+ preview_path
				+ '" />'
				+ '</p>'
				+ '<div class="description">'
				+ '<a onclick="deleteContent('
				+ learningContentObject.id
				+ ');" title="Delete Content" class="remove_this pull-right">X</a>' 
				+'<a onclick="editWeblinkContent('
				+ learningContentObject.id
				+ ');" title="Edit Content Detail" class="pull-right"><img class="iconcc" src="../../resources/images/content/edit.svg" style="height: 35px;cursor:pointer;" /></a>'
				+'<a href="'
				+ learningContentObject.contentURL
				+ '"  title="View Content" target="_new" class="pull-right"><img src="../../resources/images/content/view-content.svg" style="height: 35px;" /></a>'
				+ '</div>' + '<div class="Clearfix"></div>' + '</div>';
		
	} else {

	learningContentDiv = '<div id="createcontent-main" class="item All">'
			+ '<p class="createcontenthead">'
			+ learningContentObject.contentName
			+ '</p><p class="createcontentimg">'
			+ '<img src="'
			+ preview_path
			+ '" />'
			+ '</p>'
			+ '<div class="description">'
			+ '<a onclick="deleteContent('
			+ learningContentObject.id
			+ ');" title="Delete Content" class="remove_this pull-right">X</a>'
			+'<a onclick="editContent('
				+ learningContentObject.id
				+ ');" title="Edit Content Detail" class="pull-right"><img class="iconcc" src="../../resources/images/content/edit.svg" style="height: 35px;cursor:pointer;" /></a>'
			+'<a href="'
			+ viewer_url
			+ '"  class="show_in_fancybox pull-right" title="View Content" data-fancybox-type="iframe"><img src="../../resources/images/content/view-content.svg" style="height: 35px;" /></a>'
			+ '</div>' + '<div class="Clearfix"></div>' + '</div>';
	}

	return learningContentDiv;

}

function getPageDiv(noOfPages, filterType,pageIndex) {
	var pageDiv = $('#pageNumbers');
	var functionName = '';
	if ("ALL" == filterType) {
		functionName = 'getAllLearningContents(';
	} else if ("VIDEO" == filterType || "LINK" == filterType) {
		functionName = 'getLearningContentsByType(\'' + filterType + '\',';
	}
	if ("OTHERS" == filterType) {
		functionName = 'getOtherLearningContents(\'' + filterType + '\',';
	}

	pageDiv.empty();
	for (i = 1; i <= noOfPages; i++) {
		if(pageIndex == i){
			pageDiv.append('<a onClick="' + functionName + i +')" title="'+ i + '" href="#" id="btnpg1" class="swShowPageActive"></a>');
		}
		else{
			pageDiv.append('<a onClick="' + functionName + i +')" title="'+ i + '" href="#" id="btnpg1" class="swShowPage"></a>');
		}
	}
}

function deleteContent(content_id) {

	// Checking for Content Association

	uri = '/ziksana-web/zcourse/1/checkcontentassociation';
	var parameters = {
		"contentId" : content_id
	};
	$
			.post(
					uri,
					parameters,
					function(data) {
						//console.log(data);
						if (data.response == 'active') {
							confirm_delete = confirm('This content is associated with a course. Please delink the content with the course to proceed with Delete');
							if (confirm_delete == true) {			
								window.location.href = "/ziksana-web/zcourse/1/mycontent";
							}
						} else {
							confirm_delete = confirm('Are you sure to delete?');
							if (confirm_delete == true) {
								uri = '/ziksana-web/zcourse/1/deletecontent';
								var parameters = {
									"contentId" : content_id
								};
								$
										.post(
												uri,
												parameters,
												function(data) {
													//console.log(data);
													if (data.response == 'success') {
														window.location.href = "/ziksana-web/zcourse/1/mycontent";
													} else {
														window.location.href = "/ziksana-web/zcourse/1/mycontent";
													}

												});

							}
						}

					});

}

function editContent(content_id) {
	window.location.href = '/ziksana-web/zcourse/1/createeditcontent/'+content_id;	
}

function editWeblinkContent(content_id) {
	window.location.href = '/ziksana-web/zcourse/1/editweblinkcontent/'+content_id;	
}

$(function() {
	$('.show_in_fancybox, .google').fancybox({autoWidth: true});
});

function calculatePage(val){
	if(val == 0){		
		return 0;
	}else if(val == 1){
		
		return 3;	
	}else if(val == 2){
	
		return 6;
	}
	
}

function getCategoryText(category){
	var noDataText = "";
	if(category == "ALL"){
		noDataText = "No contents in repository.";
		$('#container4').empty();
	}
	else {
		noDataText = "No contents in this category.";
		$('#container4').empty();
		
	}
	return noDataText;
}

function setNoContentFoundText(category){
	
	var noDataText = "";
	category = category.toUpperCase();
	if(category != ""){
		noDataText = getCategoryText(category);
	}
	//alert("category" + category + " - noDataText " + noDataText);
	$('#noContentFound').text(noDataText);
}
