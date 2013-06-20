itemsPerPage = 20;
defaultPageIndex = 1;
noOfPages = new Number(0);

$(document).ready(function() {
	getAllCourse("ALL");
});

function getDraftCourses(contentType, pageIndex) {

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
		if ('DRAFT' != contentArray[i].contentType.toUpperCase()) {
			contentArrayBasedOnContentType[j] = contentArray[i];
			j++;
		}
	}

	noOfPages = Math.ceil(contentArrayBasedOnContentType.length / itemsPerPage);
	//console.log("noOfPages " + noOfPages);
	
	if(contentArrayBasedOnContentType.length ==0){
		setNoContentFoundText(contentType);
		$("#content_type_filter").hide();
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


	getPageDiv(noOfPages,contentType,pageIndex);
	//console.log("getPageDiv(noOfPages, OTHERS)"
	//		+ getPageDiv(noOfPages, "OTHERS"));
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

function getCourseByType(contentType, pageIndex) {

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
	//console.log("contentArray.length " + contentArray.length);
	//console.log("contentArrayBasedOnContentType.length "
	//		+ contentArrayBasedOnContentType.length);
	noOfPages = Math.ceil(contentArrayBasedOnContentType.length / itemsPerPage);
	//console.log("noOfPages " + noOfPages);
	
	if(contentArrayBasedOnContentType.length ==0){
		setNoContentFoundText(contentType);
		$("#content_type_filter").hide();
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

	getPageDiv(noOfPages, contentType,pageIndex);

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

function getAllCourse(contentType,pageIndex) {

	if (!pageIndex || "" == pageIndex) {
		pageIndex = defaultPageIndex;
	}
	$('#container4').empty();
	var jsonString = document.getElementById("courses").value;
	var courseArray = jQuery.parseJSON(jsonString);
	//console.log("courseArray.length " + courseArray.length + " itemsPerPage  "
	//		+ itemsPerPage);
	noOfPages = Math.ceil(courseArray.length / itemsPerPage);
	
	if(courseArray.length ==0){
		setNoContentFoundText(contentType);
		$("#content_type_filter").hide();
	}
	else{
		setNoContentFoundText('');
		$("#content_type_filter").show();
	}
	
	if(courseArray.length > itemsPerPage){
		getPageDiv(noOfPages, contentType, pageIndex);
	}
	else{
		$('#pageNumbers').empty();
	}

	//console.log("noOfPages " + noOfPages);
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
	//console.log("In my content getPreviewPath" + staticFileServerPath);
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
			+ ');" title="Delete" class="remove_this pull-right">X</a> <a onclick="editCourse('
			+ courseObject.id
			+ ');"  class="pull-right"  title="Edit"><img src="../../resources/images/content/edit.svg" style="height: 35px;" /></a>'

			// +'<a href="#linkurl" title="Review playbook"
			// class="pull-right"><img class="iconcc"
			// src="../../resources/images/content/reviewplaybook.svg"
			// style="height:35px;"/></a>'

			// +'<a href="#linkurl" title="Publish" class="pull-right"><img
			// src="../../resources/images/content/publish.svg"
			// style="height:35px;"/></a>'
			+ '</div>' + '<div class="Clearfix"></div>' + '</div>';

	return learningContentDiv;

}

function getPageDiv(noOfPages, filterType,pageIndex) {
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
		if(pageIndex == i){
			pageDiv.append('<a onClick="' + functionName + i +')" title="'+ i + '" href="#" id="btnpg1" class="swShowPageActive"></a>');
		}
		else{
			pageDiv.append('<a onClick="' + functionName + i +')" title="'+ i + '" href="#" id="btnpg1" class="swShowPage"></a>');
		}
	}
}

function editCourse(courseId) {
	if (courseId != null) {
		window.location.href = '/ziksana-web/zcourse/editcourse/COURSE_' + courseId;
	} else {
		window.location.href = '/ziksana-web/zcourse/createcourse';
	}
}

function deleteCourse(courseId) {

	// Delete Course

	confirm_delete = confirm('Are you sure to delete?');
	if (confirm_delete == true) {

		uri = '/ziksana-web/zcourse/1/removecourse';
		var parameters = {
			"courseId" : courseId
		};
		$.post(uri, parameters, function(data) {
			//console.log(data);
			window.location.href = "/ziksana-web/zcourse/1/mycourse";
		});
	} else {
		window.location.href = "/ziksana-web/zcourse/1/mycourse";
	}
}

$(function() {
	$('.show_in_fancybox, .google').fancybox();
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
		noDataText = "No courses in repository.";
		$('#container4').empty();
	}
	else {
		noDataText = "No courses in this category.";
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
	$('#noCourseFound').text(noDataText);
}

