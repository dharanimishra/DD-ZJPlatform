itemsPerPage = 20;
defaultPageIndex = 1;
noOfPages = new Number(0);

$(document).ready(function() {
	getAllLearningContents();
});

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
			contentArrayBasedOnContentType[j] = contentArray[i];
			j++;
		}
	}
	console.log("contentArray.length " + contentArray.length);
	console.log("contentArrayBasedOnContentType.length "
			+ contentArrayBasedOnContentType.length);
	noOfPages = Math.ceil(contentArrayBasedOnContentType.length / itemsPerPage);
	console.log("noOfPages " + noOfPages);

	getPageDiv(noOfPages, "OTHERS");
	console.log("getPageDiv(noOfPages, OTHERS)"
			+ getPageDiv(noOfPages, "OTHERS"));
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
			contentArrayBasedOnContentType[j] = contentArray[i];
			j++;
		}
	}
	console.log("contentArray.length " + contentArray.length);
	console.log("contentArrayBasedOnContentType.length "
			+ contentArrayBasedOnContentType.length);
	noOfPages = Math.ceil(contentArrayBasedOnContentType.length / itemsPerPage);
	console.log("noOfPages " + noOfPages);

	getPageDiv(noOfPages, contentType);

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
	console.log("contentArray.length " + contentArray.length
			+ " itemsPerPage  " + itemsPerPage);
	noOfPages = Math.ceil(contentArray.length / itemsPerPage);

	getPageDiv(noOfPages, "ALL");

	console.log("noOfPages " + noOfPages);
	var divs = '';

	if (pageIndex == 1) {
		for (i = 0; i < contentArray.length; i++) {
			divs = divs + getDiv(contentArray[i]);
			if (i == (itemsPerPage - 1)) {
				break;
			}
		}
	} else {
		for (i = ((pageIndex - 1) * itemsPerPage); i < contentArray.length; i++) {
			divs = divs + getDiv(contentArray[i]);
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
	content_type = learningContentObject.contentType.toUpperCase();

	if (content_type == 'VIDEO') {
		viewer_url = '/ziksana-web/zcourse/1/modalplayer/'
				+ learningContentObject.id;
		preview_path = '../../resources/images/preview/video.png';
	} else if (content_type == 'AUDIO') {
		viewer_url = '/ziksana-web/zcourse/1/modalplayer/'
				+ learningContentObject.id;
		preview_path = '../../resources/images/preview/audio.png';
	} else if (content_type == 'IMAGE') {
		viewer_url = '/ziksana-web/zcourse/1/slides/'
				+ learningContentObject.id;
		preview_path = '../../resources/images/preview/image.png';
	} else if (content_type == 'DOC') {
		viewer_url = '/ziksana-web/zcourse/1/slides/'
				+ learningContentObject.id;
		preview_path = '../../resources/images/preview/doc.png';
	} else if (content_type == 'PPT') {
		viewer_url = '/ziksana-web/zcourse/1/slides/'
				+ learningContentObject.id;
		preview_path = '../../resources/images/preview/ppt.jpg';
	} else if (content_type == 'PDF') {
		viewer_url = '/ziksana-web/zcourse/1/slides/'
				+ learningContentObject.id;
		preview_path = '../../resources/images/preview/pdf.png';
	} else if (content_type == 'LINK') {
		viewer_url = learningContentObject.contentUrl;
		preview_path = '../../resources/images/preview/link.png';
	}

	var learningContentDiv = '<div id="createcontent-main" class="item All">'
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
			+ ');" class="pull-right"><img class="iconcc" src="../../resources/images/content/deleteicon.png"style="height: 35px;" /></a> <a href="'
			+ viewer_url
			+ '"  class="show_in_fancybox pull-right" data-fancybox-type="iframe"><img src="../../resources/images/content/view-content.png" style="height: 35px;" /></a>'
			+ '</div>' + '<div class="Clearfix"></div>' + '</div>';

	return learningContentDiv;

}

function getPageDiv(noOfPages, filterType) {
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
		pageDiv
				.append('<span class="pagination_bar pactive"><a onClick="'
						+ functionName
						+ i
						+ ')" href="#" id="btnpg1" class="swShowPageActive pagination_bar"></a></span>');
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
						console.log(data);
						if (data.response == 'active') {
							confirm_delete = confirm('There are Content Association found. Are you sure to delete?');
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
													console.log(data);
													if (data.response == 'success') {
														window.location.href = "/ziksana-web/zcourse/1/mycontent";
													} else {
														window.location.href = "/ziksana-web/zcourse/1/mycontent";
													}

												});

							}
						} else {
							confirm_delete = confirm('There are no any Content Association found. Are you sure to delete?');
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
													console.log(data);
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

$(function() {
	$('.show_in_fancybox, .google').fancybox();
});
