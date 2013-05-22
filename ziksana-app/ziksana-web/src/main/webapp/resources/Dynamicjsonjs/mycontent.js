var divName = 'container4';
function getOtherLearningContents(contentType) {
	$('#container4').empty();
	var jsonString = document.getElementById("learingContents").value;
	var contentArray = jQuery.parseJSON(jsonString);

	// alert(contentType);
	var divs = '';
	for (i = 0; i < contentArray.length; i++) {
		// alert("contentType from arr" + contentArray[i].contentType + " --- "
		// + contentType);
		if ('VIDEO' != contentArray[i].contentType.toUpperCase()
				&& 'LINK' != contentArray[i].contentType.toUpperCase()) {
			divs = divs + getDiv(contentArray[i]);
			// $('#page1').append(div);
			// alert(div);
		}
		$('#container4').html(divs);
	}
}

function getLearningContentsByType(contentType) {
	$('#container4').empty();
	var jsonString = document.getElementById("learingContents").value;
	var contentArray = jQuery.parseJSON(jsonString);

	// alert(contentType);
	var divs = '';
	for (i = 0; i < contentArray.length; i++) {
		// alert("contentType from arr" + contentArray[i].contentType + " --- "
		// + contentType);
		if (contentType.toUpperCase() == contentArray[i].contentType
				.toUpperCase()) {
			divs = divs + getDiv(contentArray[i]);
			// $('#page1').append(div);
			// alert(div);
		}
		$('#container4').html(divs);
	}
}

function getAllLearningContents() {
	// alert("Hi");
	$('#container4').empty();
	var jsonString = document.getElementById("learingContents").value;
	// alert(jsonString);
	var contentArray = jQuery.parseJSON(jsonString);
	var divs = '';
	for (i = 0; i < contentArray.length; i++) {
		divs = divs + getDiv(contentArray[i]);
		// alert(div);
	}
	// $('#page1').append(divs);
	$('#container4').html(divs);
}

function getDiv(learningContentObject) {

	alert('learningContentObject.contentName :'
			+ learningContentObject.contentName);

	var learningContentDiv = '<div id="createcontent-main" class="item All">'
			+ '<p class="createcontenthead">'
			+ learningContentObject.contentName
			+ '</p>';
			+ '<p class="createcontentimg">'
			+ '<img src="/ziksana-web/resources/images/genetics.jpg" />'
			+ '</p>'
			+ '<div class="description">'
			+ '<a href="#linkurl" class="pull-right"><img class="iconcc" src="${staticFileServer}resources/images/content/deleteicon.png"style="height: 35px;" /></a> <a href="#linkurl" class="pull-right"><img src="${staticFileServer}resources/images/content/view-content.png" style="height: 35px;" /></a>'
			+ '</div>' +'<div class="Clearfix"></div>' + '</div>';
			
			return learningContentDiv;

}
