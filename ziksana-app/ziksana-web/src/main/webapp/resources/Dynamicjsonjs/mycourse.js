itemsPerPage = 20;
defaultPageIndex = 1;
noOfPages = new Number(0);

$(document).ready(function() {
	getAllCourse();
});

function getOtherLearningContents(contentType, pageIndex) {

	if (!pageIndex || "" == pageIndex) {
		pageIndex = defaultPageIndex;
	}

	$('#container4').empty();
	var jsonString = document.getElementById("courses").value;
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
	var jsonString = document.getElementById("courses").value;
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

function getAllCourse(pageIndex) {

	if (!pageIndex || "" == pageIndex) {
		pageIndex = defaultPageIndex;
	}

	$('#container4').empty();
	var jsonString = document.getElementById("courses").value;
	var courseArray = jQuery.parseJSON(jsonString);
	console.log("courseArray.length " + courseArray.length + " itemsPerPage  "
			+ itemsPerPage);
	noOfPages = Math.ceil(courseArray.length / itemsPerPage);

	getPageDiv(noOfPages, "ALL");

	console.log("noOfPages " + noOfPages);
	var divs = '';

	if (pageIndex == 1) {
		for (i = 0; i < courseArray.length; i++) {
			divs = divs + getDiv(courseArray[i]);
			if (i == (itemsPerPage - 1)) {
				break;
			}
		}
	} else {
		for (i = ((pageIndex - 1) * itemsPerPage); i < courseArray.length; i++) {
			divs = divs + getDiv(courseArray[i]);
			if (i == ((itemsPerPage * pageIndex) - 1)) {
				break;
			}
		}

	}
	$('#container4').html(divs);
}

function getDiv(courseObject) {

	var viewer_url = '';
	var preview_path = '';

	var staticFileServerPath = $("#fileServerPath").val();
	console.log("In my content getPreviewPath" + staticFileServerPath);
	// var courseStatus = courseObject.courseStatus.toUpperCase();
	var screenshotPath = courseObject.thumbnailPicturePath;

	if (screenshotPath
			&& (screenshotPath != null || screenshotPath.trim() != "")) {
		preview_path = staticFileServerPath + screenshotPath;
	} else {
		preview_path = '../../resources/images/preview/defaultcourse.png';
	}

	var learningContentDiv = '<div id="createcontent-main" class="item All">'
			+ '<p class="createcontenthead">'
			+ courseObject.courseName
			+ '</p><p class="createcontentimg">'
			+ '<img src="'
			+ preview_path
			+ '" />'
			+ '</p>'
			+ '<div class="description">'
			+ '<a onclick="deleteCourse('
			+ courseObject.id
			+ ');" class="pull-right"><img class="iconcc" src="../../resources/images/content/deleteicon.svg" style="height: 35px;" /></a> <a href="'
			+ viewer_url
			+ '"  class="show_in_fancybox pull-right" data-fancybox-type="iframe"><img src="../../resources/images/content/edit.svg" style="height: 35px;" /></a>'
			
			+'<a href="#linkurl" class="pull-right"><img class="iconcc" src="../../resources/images/content/reviewplaybook.svg" style="height:35px;"/></a>'

			+'<a href="#linkurl" class="pull-right"><img src="../../resources/images/content/publish.svg" style="height:35px;"/></a>'
			+ '</div>' + '<div class="Clearfix"></div>' + '</div>';

	return learningContentDiv;

}

function  getPageDiv(noOfPages, filterType) {
	var pageDiv = $('#pageNumbers');
	var functionName = '';
	if ("ALL" == filterType) {
		functionName = 'getAllCourse(';
	} else if ("ACTIVE" == filterType || "DRAFT" == filterType) {
		functionName = 'getActiveCourse(\'' + filterType + '\',';
	}
	if ("REVIEW" == filterType) {
		functionName = 'getReviewCourse(\'' + filterType + '\',';
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

function deleteCourse(course_id) {

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
