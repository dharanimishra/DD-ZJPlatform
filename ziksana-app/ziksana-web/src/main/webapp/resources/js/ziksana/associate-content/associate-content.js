	//default is set to 5
	itemsPerPage = 5;
	defaultPageIndex = 1;
	noOfPages = new Number(0);

	$(document).ready(function() {
		//var abc = '${learningContentAsJSONString}';
		//alert("kjkjkjk "+ abc);
		//putInSessionStorage("repositoryContents", '${learningContentAsJSONString}');
		//addToSessionStorage(${learningContentAsJSONString});
		//getAllLearningContents();
		$('#ContentPanel2').hide();
		setItemsPerPage();
	});
	
	function setItemsPerPage(){
		if($('#itemsToBeDisplayedPerPage').val()){
			itemsPerPage = $('#itemsToBeDisplayedPerPage').val();
		}
		//Uncomment following line it is only to test paginatio by setting it to 2 items per page
		//itemsPerPage = 1;
		//else it will default to 5
		console.log("Items per page set to" + itemsPerPage);
	}
	
	//var sessionKey = "repositoryContents";
	function addToSessionStorage(value){
		//alert("I am in" + sessionKey);
		//putInSessionStorage(sessionKey, value);
		//alert("Added to session storage "  + value);
	}
	
	function forceToAssociateSelectedContent(){
		var selectedContentCheckBoxes = $("input:checkbox[name=learningContentToBeAssociated]:checked");
		if (selectedContentCheckBoxes && selectedContentCheckBoxes.length > 0){
			confirm_delete_component = confirm('Are you sure you don\'t want to associate the selected contents? \nClick OK if you want associate the selected content else click Cancel.');
			if (confirm_delete_component == true) {
				associateContents();
			}
			else{
				return;
			}
		}
	}

	function getLearningContentObject(learningContentId){
		
		console.log("in getLearningContentObject id is " + learningContentId);
		var jsonString = document.getElementById("learingContents").value;
		var contentArray = jQuery.parseJSON( jsonString );
		
		for(var i=0; i<contentArray.length; i++){
			if(learningContentId == contentArray[i].id){
				return contentArray[i];
			}
		}
	}

	function getUnAssociatedContentArray(contentArray){
		var unAssociatedContentArray = new Array();
		
		var compId = $("#selectedLearningComponentId").val();
		 
		var childArrayString = tree.getSubItems('COMPONENT_' + compId );
		console.log("contentArray.length" + contentArray.length + "  --------- childArrayString is " + childArrayString);
		if(childArrayString && childArrayString.trim() != ""){
			//var childArray = childArrayString.split(',');
			var j =0;

			for(var i=0; i < contentArray.length; i++){
				var contentItem = contentArray[i];
				var contentIdString = 'CONTENT_'+ contentItem.id;
				console.log("childArrayString.indexOf(contentIdString) " + childArrayString.indexOf(contentIdString));
				if(childArrayString.indexOf(contentIdString) == -1){
					console.log("in side if contentIdString " + contentIdString);
					unAssociatedContentArray[j] = contentItem;
					j++;
				}
				else{
					continue;
				}
			}
		}
		else{
			// no associated contents found return the original array as it is
			unAssociatedContentArray = contentArray;
		}
		
		return unAssociatedContentArray;
	}
	
	function getOtherLearningContents(contentType, inPageIndex){
		//console.log("hkjhjkhjkhjkhkjhjhjhjkhkjhjkhjh");
		forceToAssociateSelectedContent();
		
		if(!inPageIndex || "" == inPageIndex){
			pageIndex = defaultPageIndex;
		}
		else{
			pageIndex = inPageIndex;
		}
		console.log("In getOtherLearningContents pageIndex is " + pageIndex);

		$('#page1').empty();
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
		var unAssociatedContentArray = getUnAssociatedContentArray(contentArrayBasedOnContentType);
		//console.log("contentArray.length " + contentArray.length);
		noOfPages = Math.ceil(unAssociatedContentArray.length/itemsPerPage);
		//console.log("noOfPages " + noOfPages + " itemsPerPage " + itemsPerPage);
		
		if(unAssociatedContentArray.length ==0){
			setNoContentFoundText(contentType);
		}
		else{
			setNoContentFoundText('');
		}
		
		if(unAssociatedContentArray.length > itemsPerPage){
			console.log("unAssociatedContentArray.length " + unAssociatedContentArray.length + " itemsPerPage " + itemsPerPage);
			getPageDiv(noOfPages, contentType, pageIndex);
		}
		else{
			$('#pageNumbers').empty();
		}
		console.log("In else unAssociatedContentArray.length " + unAssociatedContentArray.length + " itemsPerPage " + itemsPerPage);
		
		var divs = '';
		if(pageIndex == 1){
			for(var i=0;i<unAssociatedContentArray.length;i++){
				divs = divs + getDiv(unAssociatedContentArray[i]);
				if(i==(itemsPerPage-1)){
					break;
				}
			}
			//console.log("othersssssssssssssss " + divs);
		}
		else{
			for(var i=((pageIndex-1) * itemsPerPage);i<unAssociatedContentArray.length;i++){
				divs = divs + getDiv(unAssociatedContentArray[i]);
				if(i == ((itemsPerPage * pageIndex)-1)){
					break;
				}
			}
			
		}		
		$('#page1').html(divs);
		$('#ContentPanel2').show();
	}

	function getLearningContentsByType(contentType, pageIndex){

		forceToAssociateSelectedContent();

		if(!pageIndex || "" == pageIndex){
			pageIndex = defaultPageIndex;
		}
		
		$('#page1').empty();
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
		
		var unAssociatedContentArray = getUnAssociatedContentArray(contentArrayBasedOnContentType);

		noOfPages = Math.ceil(unAssociatedContentArray.length/itemsPerPage);
		console.log("noOfPages " + noOfPages);

		if(unAssociatedContentArray.length ==0){
			setNoContentFoundText(contentType);
		}
		else{
			setNoContentFoundText("");
		}
		
		if(unAssociatedContentArray.length > itemsPerPage){
			getPageDiv(noOfPages, contentType, pageIndex);
		}
		else{
			$('#pageNumbers').empty();
		}
		var divs = '';
		if(pageIndex == 1){
			for(var i=0; i < unAssociatedContentArray.length; i++){
				divs = divs + getDiv(unAssociatedContentArray[i]);
				if(i==(itemsPerPage-1)){
					break;
				}
			}
		}
		else{
			for(var i=((pageIndex-1) * itemsPerPage); i < unAssociatedContentArray.length; i++){
				divs = divs + getDiv(unAssociatedContentArray[i]);
				if(i == ((itemsPerPage * pageIndex)-1)){
					break;
				}
			}
			
		}		
		//console.log("divs --->> " + divs);
		$('#page1').html(divs);
		$('#ContentPanel2').show();
	}

	function getAllLearningContents(pageIndex){

		forceToAssociateSelectedContent(); 
		
		if(!pageIndex || "" == pageIndex){
			pageIndex = defaultPageIndex;
		}
		
		$('#page1').empty();
		var jsonString = document.getElementById("learingContents").value;
		var contentArray = new Array();
		contentArray =  jQuery.parseJSON( jsonString );
		console.log("contentArray.length " + contentArray.length + " itemsPerPage  " + itemsPerPage);

		var unAssociatedContentArray = getUnAssociatedContentArray(contentArray);
		console.log("unAssociatedContentArray.length " + unAssociatedContentArray.length + " itemsPerPage  " + itemsPerPage);

		noOfPages = Math.ceil(unAssociatedContentArray.length/itemsPerPage);
		
		if(unAssociatedContentArray.length ==0){
			setNoContentFoundText("ALL");
			//alert("This is " + setNoContentFoundText("ALL"));
		}
		else{
			setNoContentFoundText("");
		}
		
		if( unAssociatedContentArray.length > itemsPerPage ){
			getPageDiv(noOfPages, "ALL", pageIndex);
		}
		else{
			$('#pageNumbers').empty();
		}
		
		
		console.log("noOfPages " + noOfPages);
		var divs = '';
		
		if(pageIndex == 1){
			for(var i=0; i < unAssociatedContentArray.length; i++){
				divs = divs + getDiv(unAssociatedContentArray[i]);
				if(i==(itemsPerPage-1)){
					break;
				}
			}
		}
		else{
			for(var i=((pageIndex-1) * itemsPerPage); i < unAssociatedContentArray.length; i++){
				divs = divs + getDiv(unAssociatedContentArray[i]);
				if(i == ((itemsPerPage * pageIndex)-1)){
					break;
				}
			}
			
		}		
		$('#page1').html(divs);
		$('#ContentPanel2').show();
	}

	function getPreviewPath(learningContentObject){
		var staticFileServerPath = $("#fileServerPath").val();
		console.log("In associate content getPreviewPath" + staticFileServerPath);
		var content_type = learningContentObject.contentType;
		var previewPath = learningContentObject.screenshotPath;
		console.log("In associate content screenshotPath for " + learningContentObject.contentName + " - " +previewPath);
		var imagePath = '';
		if(previewPath && (previewPath != null || previewPath.trim() != "")){
			imagePath =staticFileServerPath + previewPath;
			console.log("In associate content in the if  for " + learningContentObject.contentName + " - " +previewPath);
		}
		else{
		
			if (content_type.toUpperCase() == 'VIDEO') {
				imagePath = '../../../resources/images/preview/video.png';
			} else if (content_type.toUpperCase() == 'AUDIO') {
				imagePath = '../../../resources/images/preview/audio.png';
			} else if (content_type.toUpperCase() == 'IMAGE') {
				imagePath = '../../../resources/images/preview/image.png';
			} else if (content_type.toUpperCase() == 'DOC') {
				imagePath = '../../../resources/images/preview/doc.png';
			} else if (content_type.toUpperCase() == 'PPT') {
				imagePath = '../../../resources/images/preview/ppt.jpg';
			} else if (content_type.toUpperCase() == 'PDF') {
				imagePath = '../../../resources/images/preview/pdf.png';
			}
			else if (content_type.toUpperCase() == 'LINK') {
				imagePath = '../../../resources/images/preview/link.png';
			}
			console.log("In associate content finallly the imagePath is ------------>>>> " + imagePath);
		}
		return imagePath;
	}
	
	function getDiv(learningContentObject){
		
			var staticFileServerPath = $("#staticFileServer").val();
			//console.log("Hello the getPreviewPath(learningContentObject) " + getPreviewPath(learningContentObject) );
			var readMoreLink = "";
			
			if(learningContentObject.contentDescription && learningContentObject.contentDescription.length > 150){
				readMoreLink = '<a class="toggle_seemore" style="float:right;color:#fff" onclick="toggleSeemore($(this));" > Read More </a>';
			}
			
			var learningContentDiv =  '<div class="associatelr">' +
	
			'<div class="associatesearchitem">'+
	
				'<div class="associateleft f-l" style="width:100%;">'+
					'<input name="learningContentToBeAssociated" type="checkbox" value="' + learningContentObject.id +'" style="border:1px solid;"/>'+
					'<img src="'+ getPreviewPath(learningContentObject) +'" alt="" border="4px solid #999;" style="vertical-align:middle;" class="associatesearchimg  all-box-shadow"/>'+
					'</div> <!--end of associtemleft-->'+
	
					'<div class="associateright f-l">'+
	
	
					'<div class="associatecategoryhead">' + learningContentObject.contentName + '</div>'+
	
					'<div class="associatetagscontainer">'+
						'<p class="associatecategoryname f-l"> Category :   <a href="#linkurl"> Areas</a>/<a href="#linkurl">Topic</a>/<a href="#linkurl">Subject</a> </p>'+
					'<div class="ClearFix"> </div>'+
					'</div> <!--end of associatetagscontainer-->'+

	
					'<div class="associatedesccont"> '+
						'<p class="associatecategorydesc">' + learningContentObject.contentDescription + '</p>'+
						readMoreLink +
						//'<a class="toggle_seemore" style="float:right;color:#fff" onclick="toggleSeemore($(this));" > Read More </a>'+
					'</div> <!--end of associatedesccont-->'+ 
					'<div class="ClearFix"> </div>'+
	
	
	
					'</div> <!--end of associtemright-->'+
					 
	
					
					
					
				'<div class="ClearFix"> </div>'+
	
			'</div> <!--end  of associatesearchitem-->'+
	
		'</div> <!--end of associatelr-->';
		return learningContentDiv;
	}
	
	
	function getPageDiv(noOfPages, filterType, pageIndex){
		console.log("In getPageDiv noOfPages " + noOfPages + " pageIndex " + pageIndex + " filterType " + filterType);
		var pageDiv = $('#pageNumbers');
		var functionName = '';
		if("ALL" == filterType.toUpperCase()){
			functionName = 'getAllLearningContents(';
		}
		else if("VIDEO" == filterType.toUpperCase() || "LINK" == filterType.toUpperCase()){
			functionName = 'getLearningContentsByType(\''+ filterType + '\',';
		}
		if("OTHERS" == filterType.toUpperCase()){
			functionName = 'getOtherLearningContents(\''+ filterType + '\',';
		}
		
		pageDiv.empty();
		for(i=1; i<=noOfPages; i++){
				if(pageIndex == i){
					pageDiv.append('<a onClick="' + functionName + i +')" title="'+ i + '" href="#" id="btnpg1" class="swShowPageActive"></a>');
				}
				else{
					pageDiv.append('<a onClick="' + functionName + i +')" title="'+ i + '" href="#" id="btnpg1" class="swShowPage"></a>');
				}
		}
	}
	
	function setNoContentFoundText(category){
		
		var noDataText = "";
		category = category.toUpperCase();
		if(category != ""){
			noDataText = 'No '+ getCategoryText(category) +'contents in repository.' ;
		}
		//alert("category" + category + " - noDataText " + noDataText);
		$('#noContentFound').text(noDataText);
	}
	
	function getCategoryText(category){
		var categoryText = "";
		if(category == "LINK"){
			categoryText = "Web Link ";
			
		}
		else if(category == "VIDEO"){
			categoryText = "Video ";
			
		}
		else if(category == "OTHERS"){
			categoryText = "Other ";
			
		}
		return categoryText;
	}
	
	function isItemPresent(childArrayString, contentItem){
		//alert("childArrayString " + childArrayString + " contentItem " + contentItem);
		if(!childArrayString){
			return false;
		}
		var childArray = childArrayString.split(',');
		if(childArray.length > 0){
			for(i = 0; i < childArray.length; i++){
				//alert("Yes got it " + childArray[i] + "  "  + contentItem);
				if(childArray[i] == contentItem){
					//alert("Yes got it");
					return true;
				}
				else{
					continue; 
				}
			}
		}
		else{
			return false;
		}
	}
	function associateContents(){
		
		//var array = document.getElementsByName('learningContentToBeAssociated[]');
		var selectedContentCheckBoxes = $("input:checkbox[name=learningContentToBeAssociated]:checked");
		var selectedContents = "";
		var compId = $("#selectedLearningComponentId").val();
		for(i=0;i < selectedContentCheckBoxes.length;i++){
			selectedContents = selectedContents + selectedContentCheckBoxes[i].value;
			if(selectedContentCheckBoxes.length-1 != i){
				selectedContents = selectedContents + ",";
			}
		}
		
/*		
  		// uncomment following if you need to show all the contents and then show an alert if
  		// the content is already associated
  		var childArray = tree.getSubItems('COMPONENT_' + compId );
		//check if the conent is already associated if yes then throw an alert and dont allow the user to duplicate.
		//could have done it in the loop above but for simplicity doing it again
		for(i=0;i < selectedContentCheckBoxes.length;i++){
			var contentItem = selectedContentCheckBoxes[i].value;
			
			
			if(isItemPresent(childArray, 'CONTENT_'+ contentItem )){
				alert("The " + tree.getItemText('CONTENT_'+contentItem )+ " is already associated with " + tree.getItemText(tree.getSelectedItemId()) );
				return;
			}
			
		}
*/
		$('#selectedLearningContentList').val(selectedContents); 
		console.log("selectedContents " + selectedContents + " selected component id is " + compId);
		if(selectedContents == "" || !selectedContents){
			alert("No content selected. Please select content to be associated.");
			return;
		}
		var uri = '/ziksana-web/zcourse/1/associatecontent';

		var courseId = $('#courseid').val();
		
		var parameters = {
			"courseId" : courseId,
			"learningComponentId" : compId,
			"learningContentsToBeAssociated" : selectedContents
		};
		
		console.log("courseId " + courseId + " selectedContents " + selectedContents + " selected component id is " + compId);

		console.log("parameters.length " + parameters.length);
		console.log("uri " + uri );
		
		$.post(uri, parameters, function(data) {
			console.log(data);
			if (data.response == 'success') {
				course_id = data.id;
				window.location.href = "/ziksana-web/zcourse/1/repositorycontents/"
						+ courseId ;

			} else {
				$('#tempdiv1').html(
						'<span style="color:red;">'
								+ data.message + '</span>');
			}
		});
		//getAllLearningContents();
	}
	
	function resetCheckBoxes(){
		$('input:checkbox[name=learningContentToBeAssociated]').removeAttr('checked');
		var courseId = $('#courseid').val();
		var uri = '/ziksana-web/zcourse/1/repositorycontents/' + courseId ;

		$.get(uri);
		$('#ContentPanel2').hide();
/*
		var parameters = {
				"courseId" : courseId
		};
		
		$.post(uri, parameters, function(data) {
			console.log(data);
			if (data.response == 'success') {
				course_id = data.id;
				window.location.href = "/ziksana-web/zcourse/1/repositorycontents/"
						+ courseId;

			} else {
				$('#tempdiv1').html(
						'<span style="color:red;">'
								+ data.message + '</span>');
			}
		});
*/
	}

	function toggleSeemore(link){
		p = link.prev('p');
		 
		if(p.hasClass('show_more')){
			link.text('Read More');
			p.removeClass('show_more');
		} else {
			link.text('Hide');
			p.addClass('show_more');
		}
		
		return false;
}
