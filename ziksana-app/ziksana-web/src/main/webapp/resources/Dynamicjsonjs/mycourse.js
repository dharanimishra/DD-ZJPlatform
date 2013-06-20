itemsPerPage = 20;
defaultPageIndex = 1;
noOfPages = new Number(0);

$(document).ready(function() {
	getAllCourse("ALL");
});

function getDraftCourses(courseStatus, pageIndex) {

	if (!pageIndex || "" == pageIndex) {
		pageIndex = defaultPageIndex;
	}
	
	$('#container4').empty();
	var jsonString = document.getElementById("courses").value;
	// var jsonString = getFromSessionStorage(sessionKey);
	var courseArray = jQuery.parseJSON(jsonString);

	// first create a separate array based on content type
	var courseArrayBasedOnStatus = new Array();
	var j = 0;
	for (i = 0; i < courseArray.length; i++) {
		if ('DRAFT' == courseArray[i].courseStatus.toUpperCase()) {
			courseArrayBasedOnStatus[j] = courseArray[i];
			
			j++;
		}
	}

	noOfPages = Math.ceil(courseArrayBasedOnStatus.length / itemsPerPage);
	//console.log("noOfPages " + noOfPages);
	
	if(courseArrayBasedOnStatus.length ==0){
		setNoContentFoundText(courseStatus);
		$("#content_type_filter").hide();
	}
	else{
		setNoContentFoundText('');
		$("#content_type_filter").show();
	}
	
	if(courseArrayBasedOnStatus.length > itemsPerPage){
		getPageDiv(noOfPages, courseStatus, pageIndex);
	}
	else{
		$('#pageNumbers').empty();
	}
	getPageDiv(noOfPages,courseStatus,pageIndex);
	var divs = '';
	if (pageIndex == 1) {
		for (i = 0; i < courseArrayBasedOnStatus.length; i++) {
			divs = divs + getDiv(courseArrayBasedOnStatus[i]);
			if (i == (itemsPerPage - 1)) {
				break;
			}
		}
	} else {
		for (i = ((pageIndex - 1) * itemsPerPage); i < courseArrayBasedOnStatus.length; i++) {
			divs = divs + getDiv(courseArrayBasedOnStatus[i]);
			if (i == ((itemsPerPage * pageIndex) - 1)) {
				break;
			}
		}

	}
	$('#container4').html(divs);
}



function getReviewCourses(courseStatus, pageIndex) {

	if (!pageIndex || "" == pageIndex) {
		pageIndex = defaultPageIndex;
	}
	
	$('#container4').empty();
	var jsonString = document.getElementById("courses").value;
	// var jsonString = getFromSessionStorage(sessionKey);
	var courseArray = jQuery.parseJSON(jsonString);
	
	// first create a separate array based on content type
	var courseArrayBasedOnStatus = new Array();
	var j = 0;
	for (i = 0; i < courseArray.length; i++) {		
		if ('READY_FOR_RELEASE' == courseArray[i].courseStatus.toUpperCase()) {
			courseArrayBasedOnStatus[j] = courseArray[i];
			
			j++;
		}
	}

	noOfPages = Math.ceil(courseArrayBasedOnStatus.length / itemsPerPage);
	//console.log("noOfPages " + noOfPages);
	
	if(courseArrayBasedOnStatus.length ==0){
		setNoContentFoundText(courseStatus);
		$("#content_type_filter").hide();
	}
	else{
		setNoContentFoundText('');
		$("#content_type_filter").show();
	}
	
	if(courseArrayBasedOnStatus.length > itemsPerPage){
		getPageDiv(noOfPages, courseStatus, pageIndex);
	}
	else{
		$('#pageNumbers').empty();
	}
	getPageDiv(noOfPages,courseStatus,pageIndex);
	var divs = '';
	if (pageIndex == 1) {
		for (i = 0; i < courseArrayBasedOnStatus.length; i++) {
			divs = divs + getDiv(courseArrayBasedOnStatus[i]);
			if (i == (itemsPerPage - 1)) {
				break;
			}
		}
	} else {
		for (i = ((pageIndex - 1) * itemsPerPage); i < courseArrayBasedOnStatus.length; i++) {
			divs = divs + getDiv(courseArrayBasedOnStatus[i]);
			if (i == ((itemsPerPage * pageIndex) - 1)) {
				break;
			}
		}

	}
	$('#container4').html(divs);
}

function getActiveCourses(courseStatus, pageIndex) {

	if (!pageIndex || "" == pageIndex) {
		pageIndex = defaultPageIndex;
	}
	
	$('#container4').empty();
	var jsonString = document.getElementById("courses").value;
	// var jsonString = getFromSessionStorage(sessionKey);
	var courseArray = jQuery.parseJSON(jsonString);
	
	// first create a separate array based on content type
	var courseArrayBasedOnStatus = new Array();
	var j = 0;
	for (i = 0; i < courseArray.length; i++) {
		if ('ACTIVE' == courseArray[i].courseStatus.toUpperCase()) {
			courseArrayBasedOnStatus[j] = courseArray[i];
			
			j++;
		}
	}

	noOfPages = Math.ceil(courseArrayBasedOnStatus.length / itemsPerPage);
	//console.log("noOfPages " + noOfPages);
	
	if(courseArrayBasedOnStatus.length ==0){
		setNoContentFoundText(courseStatus);
		$("#content_type_filter").hide();
	}
	else{
		setNoContentFoundText('');
		$("#content_type_filter").show();
	}
	
	if(courseArrayBasedOnStatus.length > itemsPerPage){
		getPageDiv(noOfPages, courseStatus, pageIndex);
	}
	else{
		$('#pageNumbers').empty();
	}
	getPageDiv(noOfPages,courseStatus,pageIndex);
	var divs = '';
	if (pageIndex == 1) {
		for (i = 0; i < courseArrayBasedOnStatus.length; i++) {
			divs = divs + getDiv(courseArrayBasedOnStatus[i]);
			if (i == (itemsPerPage - 1)) {
				break;
			}
		}
	} else {
		for (i = ((pageIndex - 1) * itemsPerPage); i < courseArrayBasedOnStatus.length; i++) {
			divs = divs + getDiv(courseArrayBasedOnStatus[i]);
			if (i == ((itemsPerPage * pageIndex) - 1)) {
				break;
			}
		}

	}
	$('#container4').html(divs);
}


function getAllCourse(courseStatus,pageIndex) {

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
		setNoContentFoundText(courseStatus);
		$("#content_type_filter").hide();
	}
	else{
		setNoContentFoundText('');
		$("#content_type_filter").show();
	}
	
	if(courseArray.length > itemsPerPage){
		getPageDiv(noOfPages, courseStatus, pageIndex);
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

	var preview_path = '';

	var staticFileServerPath = $("#fileServerPath").val();
	var courseStatus = courseObject.courseStatus.toUpperCase();
	var screenshotPath = courseObject.thumbnailPicturePath;

	if (screenshotPath
			&& (screenshotPath != null || screenshotPath.trim() != "")) {
		preview_path = staticFileServerPath + screenshotPath;
	} else {
		preview_path = '../../resources/images/preview/defaultcourse.png';
	}
	var activeDiv='';
	var reviewDiv='';
	var totalDiv='';
	if('ACTIVE' ==courseStatus ){
		totalDiv='<a onclick="activeCourse('+ courseObject.id + ');" title="Publish" class="pull-right"><img src="../../resources/images/content/publish.svg" style="height:35px;"/></a>'
		+'<a onclick="reviewCourse('
		+ courseObject.id
		+ ');" title="Review playbook" class="pull-right"><img class="iconcc" src="../../resources/images/content/reviewplaybook.svg" style="height:35px;"/></a>';
	} 
	
	if('READY_FOR_RELEASE'==courseStatus){
		totalDiv='<a onclick="activeCourse('+ courseObject.id + ');" title="Publish" class="pull-right"><img src="../../resources/images/content/publish.svg" style="height:35px;"/></a>';
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
			+ ');"  class="pull-right"  title="Edit"><img src="../../resources/images/content/edit.svg" style="height: 35px;" /></a>'+totalDiv	
			+ '</div>' + '<div class="Clearfix"></div>' + '</div>';

	return learningContentDiv;

}

function getPageDiv(noOfPages, filterType,pageIndex) {
	var pageDiv = $('#pageNumbers');
	var functionName = '';
	if ("ALL" == filterType) {
		functionName = 'getAllCourse(';
	} else if ("ACTIVE" == filterType) {
		functionName = 'getActiveCourses(\'' + filterType + '\',';
	}
	if ("READY_FOR_RELEASE" == filterType) {
		functionName = 'getReviewCourses(\'' + filterType + '\',';
	}
	if ("DRAFT" == filterType) {
		functionName = 'getDraftCourses(\'' + filterType + '\',';
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


function ReviewPlaybook(courseId) {
	if (confirm_delete == true) {
		uri = '/ziksana-web/zcourse/1/reviewplaybook';
		confirm_delete = confirm('Are you sure to review playbook?');
		var parameters = {
			"courseId" : courseId
		};
		$.post(uri, parameters, function(data) {
			
		});
	}
}

function reviewCourse(courseId) {
	confirm_delete = confirm('Are you sure to review?');
	if (confirm_delete == true) {
		uri = '/ziksana-web/zcourse/1/reviewcourse';
		var parameters = {
			"courseId" : courseId
		};
		$.post(uri, parameters, function(data) {
			
		});
	}
}

function activeCourse(courseId) {
	confirm_delete = confirm('Are you sure to active?');
	if (confirm_delete == true) {
		uri = '/ziksana-web/zcourse/1/activecourse';
		var parameters = {
			"courseId" : courseId
		};
		$.post(uri, parameters, function(data) {
			
		});
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

