
$(document).ready(function() {
		getAllLearningContents();
	});
	
	 
	function getOtherLearningContents(contentType){
		$('#page1').empty();
		var jsonString = document.getElementById("learingContents").value;
		var contentArray = jQuery.parseJSON( jsonString );
		
		//alert(contentType);
		var divs = '';
		for(i=0;i<contentArray.length;i++){
			//alert("contentType from arr" + contentArray[i].contentType + " --- " +  contentType);
			if('VIDEO' != contentArray[i].contentType.toUpperCase() && 'LINK' != contentArray[i].contentType.toUpperCase()){
				divs = divs + getDiv(contentArray[i]);
				//$('#page1').append(div);
				//alert(div);
			} 
			$('#page1').html(divs);
		}
	}

	function getLearningContentsByType(contentType){
		$('#page1').empty();
		var jsonString = document.getElementById("learingContents").value;
		var contentArray = jQuery.parseJSON( jsonString );
		
		//alert(contentType);
		var divs = '';
		for(i=0;i<contentArray.length;i++){
			//alert("contentType from arr" + contentArray[i].contentType + " --- " +  contentType);
			if(contentType.toUpperCase() == contentArray[i].contentType.toUpperCase()){
				divs = divs + getDiv(contentArray[i]);
				//$('#page1').append(div);
				//alert(div);
			} 
			$('#page1').html(divs);
		}
	}

	function getAllLearningContents(){
		//alert("Hi");
		$('#page1').empty();
		var jsonString = document.getElementById("learingContents").value;
		//alert(jsonString);
		var contentArray = jQuery.parseJSON( jsonString );
		var divs = '';
		for(i=0;i<contentArray.length;i++){
			divs = divs + getDiv(contentArray[i]);
			//alert(div);
		}
		//$('#page1').append(divs);
		$('#page1').html(divs);
	}

	
	
	function getDiv(learningContentObject){
		
			var learningContentDiv =  '<div id="associatelr">' +
	
			'<div class="associatesearchitem">'+
	
				'<div class="associateleft f-l" style="width:100%;">'+
					'<input id="learningContentToBeAssociated" type="checkbox" style="border:1px solid;"/>'+
					'<img src="../images/programs/tsunami.jpg" alt="" border="4px solid #999;" style="vertical-align:middle;" class="associatesearchimg  all-box-shadow"/>'+
					'</div> <!--end of associtemleft-->'+
	
					'<div class="associateright f-l">'+
	
	
					'<div class="associatecategoryhead">' + learningContentObject.contentName + '</div>'+
	
					'<div class="associatetagscontainer">'+
						'<p class="associatecategorytags f-r"> Tags : <a href="#linkurl">x</a>,<a href="#linkurl">y</a>,<a href="#linkurl">z</a> </p>'+
						'<p class="associatecategoryname f-l"> Category :   <a href="#linkurl"> Areas</a>/<a href="#linkurl">Topic</a>/<a href="#linkurl">Subject</a> </p>'+
					'<div class="ClearFix"> </div>'+
					'</div> <!--end of associatetagscontainer-->'+
	
					'<div class="ClearFix"> </div>'+
	
					'<div class="associatedesccont"> '+
						'<p class="associatecategorydesc">' + learningContentObject.ContentDescription + '</p>'+
					'</div> <!--end of associatedesccont-->'+
	
					'<p class="f-r"><a href="#linkurl"> See More </a> </p>'+
					'<div class="ClearFix"> </div>'+
	
	
	
					'</div> <!--end of associtemright-->'+
	
	
				'<div class="ClearFix"> </div>'+
	
			'</div> <!--end  of associatesearchitem-->'+
	
		'</div> <!--end of associatelr-->' +
		'<div class="ClearFix"> </div>';
		return learningContentDiv;
	}
