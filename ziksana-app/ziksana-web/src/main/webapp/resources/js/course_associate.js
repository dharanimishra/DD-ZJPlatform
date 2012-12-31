/*
	Courses - Associate Tab functions
*/
// Subject Areas
var arrArea = ["Computer science","information & general works","Philosophy","parapsychology and occultism & psychology","Religion","Social sciences","Language","Science","Technology","Literature","History","geography","biography"];
// Subjects
var science = ["Science","Mathematics","Astronomy & allied sciences","Physics","Chemistry & allied sciences","Earth sciences","Paleontology; Paleozoology","Life sciences","Plants","Zoological sciences/Animals"];
var technology = ["Technology(Applied sciences)","Medical sciences; Medicine","Engineering & Applied operations","Agriculture","Home economics & family living","Management & auxiliary services","Chemical engineering","Manufacturing","Manufacture for specific uses","Buildings"];
// Topics
var sci_topic = ["Natural sciences & mathematics","Philosophy & theory","Organizations & management","Education,research, related topics","Natural history","Historical,geographic,persons treatment"];
var mat_topic = ["General principles","Algebra & number theory","Arithmetic","Topology",
"Analysis","Geometry","Not assigned or no longer used","Numerical analysis","Probabilities & applied mathematics"];
var tech_topic = ["Technology","Philosophy & theory","Education, research, related topics","Invention & patents","Historical, geographic, persons treatment"];
var medicine_topic = ["Human anatomy, cytology, histology","Human physiology","Personal health & safety","Incidence & prevention of disease","Pharmacology and therapeutics","Diseases","Surgery & related medical specialties","Gynecology & other medical specialties","Experimental medicine"];

// Data flows based on Selection
var arrSubject = {"Science":science,"Technology":technology};
var arrTopic = {"Science":sci_topic,"Mathematics":mat_topic,"Technology(Applied sciences)":tech_topic,"Medical sciences; Medicine":medicine_topic};

var treeNode = new Object();
var images = new Array();
var path = new Array('images/icons/video.png',
    'images/icons/pdf_icon.png',
    'images/icons/image-icon.png',
	'images/file.gif',	
	'images/icons/word-icon.png',
	'images/icons/url.png');
function preload() {
	for (i = 0; i < path.length; i++) {
		images[i] = new Image();
		images[i].src = path[i];
	}
}
preload();
// Usage:

	function ID(obj) { return document.getElementById(obj);}
	function associateHTMLID() { return parent.$("#associate_mainright"); }
/*	
	function fillSubject() {
            alert(" This is Associate JS");
            var course_areaval = ID("course_areaval");
            var indexArea = course_areaval.selectedIndex

            var course_subjectval = ID("course_subjectval");
            var indexSubject = course_subjectval.selectedIndex
			
            if (indexArea == 1) {
                var course_subjectval = ID("course_subjectval");
                var subject0 = new Option('-Select Subject1-', 'Select Subject1');
                var subject1 = new Option('Subject 11', 'Subject 11');
                var subject2 = new Option('Subject 12', 'Subject 12');
                var subject3 = new Option('Subject 13', 'Subject 13');
				
                course_subjectval.options[0] = subject0;
				course_subjectval.options[1] = subject1;
				course_subjectval.options[2] = subject2;
				course_subjectval.options[3] = subject3;
            }else if (indexArea == 2) {

                var course_subjectval = ID("course_subjectval");
                var subject0 = new Option('-Select Subject2-', 'Select Subject2');
                var subject1 = new Option('Subject 21', 'Subject 21');
                var subject2 = new Option('Subject 22', 'Subject 22');
                var subject3 = new Option('Subject 23', 'Subject 23');
				
                course_subjectval.options[0] = subject0;
				course_subjectval.options[1] = subject1;
				course_subjectval.options[2] = subject2;
				course_subjectval.options[3] = subject3;
            }else if (indexArea == 3) {

                var course_subjectval = ID("course_subjectval");
                var subject0 = new Option('-Select Subject3-', 'Select Subject3');
                var subject1 = new Option('Subject 31', 'Subject 31');
                var subject2 = new Option('Subject 32', 'Subject 32');
                var subject3 = new Option('Subject 33', 'Subject 33');
				
                course_subjectval.options[0] = subject0;
				course_subjectval.options[1] = subject1;
				course_subjectval.options[2] = subject2;
				course_subjectval.options[3] = subject3;
            } else if (indexSubject== 1) {
                var course_topicval = ID("course_topicval");
                var topic0 = new Option('-Select Topic1-', '0');
                var topic1 = new Option('Topic 11', 'Topic 11');
                var topic2 = new Option('Topic 12', 'Topic 12');

                course_topicval.options[0] = topic0;
                course_topicval.options[1] = topic1;
                course_topicval.options[2] = topic2;
            }
			else if (indexSubject== 2) {
                var course_topicval = ID("course_topicval");
                var topic0 = new Option('-Select Topic1-', '0');
                var topic1 = new Option('Topic 21', 'Topic 21');
                var topic2 = new Option('Topic 22', 'Topic 22');

                course_topicval.options[0] = topic0;
                course_topicval.options[1] = topic1;
                course_topicval.options[2] = topic2;
            }


    }

	function fillTopic() {	

            var course_areaval = ID("course_areaval");
            var indexArea = course_areaval.selectedIndex

            var course_subjectval = ID("course_subjectval");
            var indexSubject = course_subjectval.selectedIndex

			if (indexSubject== 1) {
                var course_topicval = ID("course_topicval");
                var topic0 = new Option('-Select Topic1-', '0');
                var topic1 = new Option('Topic 11', 'Topic 11');
                var topic2 = new Option('Topic 12', 'Topic 12');

                course_topicval.options[0] = topic0;
                course_topicval.options[1] = topic1;
                course_topicval.options[2] = topic2;
            }
			else if (indexSubject== 2) {
                var course_topicval = ID("course_topicval");
                var topic0 = new Option('-Select Topic1-', '0');
                var topic1 = new Option('Topic 21', 'Topic 21');
                var topic2 = new Option('Topic 22', 'Topic 22');

                course_topicval.options[0] = topic0;
                course_topicval.options[1] = topic1;
                course_topicval.options[2] = topic2;
            }

    }

	*/
	function getIcon(extension)
	{
		var icon = path[3];		
		switch(extension)
		{
			case "mp4":
			case "flv":
				// Video Icon
				icon = path[0];
				break;
			case "pdf":
				// PDF icon
				icon = path[1];
				break;
			case "jpg":
			case "jpeg":
			case "gif":
			case "png":
				//Image Icon
				icon =path[3];
				break;
			case "content":
				// Content Type
				icon =path[4];
				break;
			case "url":
				icon=path[5];
				break;
		}		
		return icon;
	}
	function getFormat(extension)
	{
		var icon = path[3];		
		switch(extension)
		{
			case "mp4":
			case "flv": 
				icon ="video";				
				break;
			case "pdf":
				// PDF icon
				icon ="pdf";				
				break;
			case "jpg":
			case "jpeg":
			case "gif":
			case "png":			
				//Image Icon
				icon ="image";				
				break;
			case "content":
				// Content Type
				icon ="content";								
				break;
			case "url":
				icon="web";				
				break;
		}		
		return icon;
	}
	
	function showData(extension,val)
	{		    	
		parent.$("#course_tree_tabset-2").jstree("create", parent.currentNode,"last", { "data" :val,"attr":{"id":"node_",rel:getFormat(extension).toString()}},function() { }, true);
		parent.set_course_tree_data('course_tree_tabset-2'); //updates global tree data
		//parent.$(".tree_container").jstree("create", parent.currentNode,"last", { "data" :val,"attr":{"id":"node_",rel:getFormat(extension).toString()}},function() { }, true);
	}
	
	function addURLToTree(){
		var v = $(".highlights").val();
	    if(v!=""){
			showData("url",$(".highlights").val());			
			parent.$("#fancybox-close").click();			
		}
		return false;
	}
	
	function addTextToTree(){
		var v = $(".editor").val();
	    if(v!=""){
			showData("content",$(".editor").val());			
			parent.$("#fancybox-close").click();			
		}
		return false;
	}
	
	function addImageToTree(val)
	{	    
	    // This function will be called by jquery.plupload.queue.js file
	    var v = val.split(".");	   
		showData(v[1],val);			
		parent.$("#fancybox-close").click();					
	}	
	
	function associate_fancybox(node)
	{
		treeNode.current = node;
		var a = document.createElement("a");
		a.setAttribute("href","create_adddescribe.html");
		a.setAttribute("id","fancybox-btn");
		a.setAttribute("class","associate_lbx-80-50");				
		$("#tabset-2").append(a);
		$(".associate_lbx-80-50").fancybox({
			'width'				: 700,
			'height'			: 500,
			'autoScale'			: false,
			'transitionIn'		: 'elastic',
			'transitionOut'		: 'elastic',
			'type'				: 'iframe'
		});	
		a.click(function() {  $(document).ready(function(){$("a#fancybox-btn").fancybox();})});
		$("#fancybox-btn").click();
		console.log($(".associate_lbx-80-50"));	
	}
	

function loadArea()
{
	var obj = document.getElementById("course_areaval");	
    for(var i=1;i<=arrArea.length;i++){	  
	  obj.options[i] = new Option(arrArea[i-1]);
	}
}
function areaSelected(val)
{
  var arr = arrSubject[val];
  var obj = document.getElementById("course_subjectval");
  obj.innerHTML='<option value="">Select Subject</option>'; 
  var obj1 = document.getElementById("course_topicval");
  obj1.innerHTML='<option value="">Select Topic</option>';      
  if(arr != undefined){
	for(var i=1;i<=arr.length;i++){
	obj.options[i] = new Option(arr[i-1]);
	}
  }  
}

function subjectSelected(val)
{
  var arr = arrTopic[val];  
  var obj = document.getElementById("course_topicval");
  obj.innerHTML='<option value="">Select Topic</option>';    
  if(arr != undefined){
	for(var i=1;i<=arr.length;i++){
	obj.options[i] = new Option(arr[i-1]);
	}
  }  
}
$(document).ready(function(){
	loadArea();
});
