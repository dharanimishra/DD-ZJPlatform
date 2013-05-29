	itemsPerPage = 2;
	defaultPageIndex = 1;
	noOfPages = new Number(0);

	$(document).ready(function() {
		//var abc = '${learningContentAsJSONString}';
		//alert("kjkjkjk "+ abc);
		//putInSessionStorage("repositoryContents", '${learningContentAsJSONString}');
		//addToSessionStorage(${learningContentAsJSONString});
		//getAllLearningContents();
		$('#ContentPanel2').hide();
	});
	
	//var sessionKey = "repositoryContents";
	function addToSessionStorage(value){
		//alert("I am in" + sessionKey);
		//putInSessionStorage(sessionKey, value);
		//alert("Added to session storage "  + value);
	} 
	function getOtherLearningContents(contentType, pageIndex){
		
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
		$('#page1').html(divs);
		$('#ContentPanel2').show();
	}

	function getLearningContentsByType(contentType, pageIndex){

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
		$('#page1').html(divs);
		$('#ContentPanel2').show();
	}

	function getAllLearningContents(pageIndex){
		
		if(!pageIndex || "" == pageIndex){
			pageIndex = defaultPageIndex;
		}
		
		$('#page1').empty();
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
		$('#page1').html(divs);
		$('#ContentPanel2').show();
	}

	
	
	function getDiv(learningContentObject){
		
		
			var learningContentDiv =  '<div class="associatelr">' +
	
			'<div class="associatesearchitem">'+
	
				'<div class="associateleft f-l" style="width:100%;">'+
					'<input name="learningContentToBeAssociated" type="checkbox" value="' + learningContentObject.id +'" style="border:1px solid;"/>'+
					'<img src="../images/programs/tsunami.jpg" alt="" border="4px solid #999;" style="vertical-align:middle;" class="associatesearchimg  all-box-shadow"/>'+
					'</div> <!--end of associtemleft-->'+
	
					'<div class="associateright f-l">'+
	
	
					'<div class="associatecategoryhead">' + learningContentObject.contentName + '</div>'+
	
					'<div class="associatetagscontainer">'+
						'<p class="associatecategoryname f-l"> Category :   <a href="#linkurl"> Areas</a>/<a href="#linkurl">Topic</a>/<a href="#linkurl">Subject</a> </p>'+
					'<div class="ClearFix"> </div>'+
					'</div> <!--end of associatetagscontainer-->'+

	
					'<div class="associatedesccont"> '+
						'<p class="associatecategorydesc">' + learningContentObject.contentDescription + '</p>'+
						'<a class="toggle_seemore" style="float:right;color:#fff" onclick="toggleSeemore($(this));" > Read More </a>'+
					'</div> <!--end of associatedesccont-->'+ 
					'<div class="ClearFix"> </div>'+
	
	
	
					'</div> <!--end of associtemright-->'+
					 
	
					
					
					
				'<div class="ClearFix"> </div>'+
	
			'</div> <!--end  of associatesearchitem-->'+
	
		'</div> <!--end of associatelr-->';
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
	function associateContents(){
		
		//var array = document.getElementsByName('learningContentToBeAssociated[]');
		var selectedContentCheckBoxes = $("input:checkbox[name=learningContentToBeAssociated]:checked");
		var selectedContents = "";
		for(i=0;i < selectedContentCheckBoxes.length;i++){
			selectedContents = selectedContents + selectedContentCheckBoxes[i].value;
			if(selectedContentCheckBoxes.length-1 != i){
				selectedContents = selectedContents + ",";
			}
		}
		
		$('#selectedLearningContentList').val(selectedContents); 
		var compId = $("#selectedLearningComponentId").val();
		//alert("selectedContents " + selectedContents + " selected component id is " + compId);
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
						+ courseId;

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
	}
