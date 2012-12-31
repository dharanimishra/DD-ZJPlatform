// Global

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

function loadArea()
{
	var obj = document.getElementById("course_areaval");	
    for(var i=1;i<=arrArea.length;i++){
	  //alert(area[i-1]);
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
