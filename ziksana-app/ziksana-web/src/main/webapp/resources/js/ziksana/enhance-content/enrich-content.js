

	serverContext = $('#staticFileServer').val();
	selectedTreeContentId = 0;
	selectedTreeContentComponentId = 0;
	courseId = $("#courseid").val();

	$(document).ready(function() {
		//var abc = '${learningContentAsJSONString}';
		//alert("kjkjkjk "+ abc);
		//putInSessionStorage("repositoryContents", '${learningContentAsJSONString}');
		//addToSessionStorage(${learningContentAsJSONString});
		//getAllLearningContents();
		serverContext = $('#staticFileServer').val();
		$('#ContentPanel2').hide();
	});
	function getLearningContentObject(learningContentId){
		//console.log("in getLearningContentObject id is " + learningContentId);
		var jsonString = document.getElementById("learingContents").value;
		var contentArray = jQuery.parseJSON( jsonString );
		
		for(var i=0; i<contentArray.length; i++){
			if(learningContentId == contentArray[i].id){
				return contentArray[i];
			}
		}
	}
