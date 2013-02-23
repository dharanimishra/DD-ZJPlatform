// JavaScript Document
$(document).ready(function(e) {
    
	//Function for course subject drop down list on change of a value
	$("#Cmoduleareaddl").change(function(e) {
	//alert("Topic change handler");
    
	uri = '/ziksana-web/secure/getModuleArea'; //this is a demo uri which will return a hardcoded data when simulation is on.

    token = ''; //dummy token for demo. you have to send real token.

    request_type = 'GET'; //can be GET or POST. In this case, a GET request

    var parameters = { "Module_Topic": Cmoduleareaddl };
    constructNotemodulearea();
    successCallback = noteSuccessCallbackmodulearea2; //provide a function that will be called when the request is successful. A data object will be passed to this function that contains tha actual data (ziksanaMessage obj in this case.) returned by the server.
    
    errorCallback = commonErrorCallback; // provide a function that will be called when the ajax request encounters an error. You can use the default commonErrorCallback function which will alert the error status code and error text from the server. 

    //Step 2: Send Message Using sendMessage(); function.
    sendMessage(uri, token, parameters, request_type, successCallback, errorCallback);
        
    });
	
		
	function constructNotemodulearea(){
    //Get the data from the text and input field.

	 var Course_Topic = $('#Cmoduleareaddl').val(); //gets the value typed in description field
    uri = '/ziksana-web/secure/getModuleArea';

	ziksanaSimulationMessages['/ziksana-web/secure/getModuleArea'].CM_Area= Course_Topic;
	//alert(Course_Topic);
}		

	function noteSuccessCallbackmodulearea(data){
		//this is the function we wanted the ziksana message framework to call when the ajax response is a success.
	   // data will contain the ziksanaMessageObject. If you have used sendMessage() function instead of sendZiksnaMessage(), you will get the actual data returned by the server instead of the ziksanaMessage object.
	
	   // parse ziksanaMessageObject to extract the body of the message.
		var msgbody = parseZiksanaMessage(data);
		Course_Topic = msgbody.CM_Area;
		//let's add the contents of the message into the div with an id of 'note_container'
		$('#tempdiv2').append('Module Topic: <strong>'+Course_Topic+'</strong><br/>');
	
	}
	
	function noteSuccessCallbackmodulearea2(data){
		//this is the function we wanted the ziksana message framework to call when the ajax response is a success.
	   // data will contain the ziksanaMessageObject. If you have used sendMessage() function instead of sendZiksnaMessage(), you will get the actual data returned by the server instead of the ziksanaMessage object.
	
	   // parse ziksanaMessageObject to extract the body of the message.
		Course_Topic = data.CM_Area;
		//let's add the contents of the message into the div with an id of 'note_container'
		$('#tempdiv2').append('Module Topic: <strong>'+Course_Topic+'</strong><br/>');
	}



	//Function for course subject drop down list on change of a value
	$("#Cmodulesubjectddl").change(function(e) {
	//alert("Topic change handler");
    
	uri = '/ziksana-web/secure/getModule'; //this is a demo uri which will return a hardcoded data when simulation is on.

    token = ''; //dummy token for demo. you have to send real token.

    request_type = 'GET'; //can be GET or POST. In this case, a GET request

    var parameters = { "Module_Subject": Cmodulesubjectddl };
    constructNotemodulesub();
    successCallback = noteSuccessCallbackmodulesub2; //provide a function that will be called when the request is successful. A data object will be passed to this function that contains tha actual data (ziksanaMessage obj in this case.) returned by the server.
    
    errorCallback = commonErrorCallback; // provide a function that will be called when the ajax request encounters an error. You can use the default commonErrorCallback function which will alert the error status code and error text from the server. 

    //Step 2: Send Message Using sendMessage(); function.
    sendMessage(uri, token, parameters, request_type, successCallback, errorCallback);
        
    });
	
		
	function constructNotemodulesub(){
    //Get the data from the text and input field.

	 var Course_Topic = $('#Cmodulesubjectddl').val(); //gets the value typed in description field
    uri = '/ziksana-web/secure/getModule';

	ziksanaSimulationMessages['/ziksana-web/secure/getModule'].CM_Sub= Course_Topic;
	//alert(Course_Topic);
	}		

	function noteSuccessCallbackmodulesub(data){
		//this is the function we wanted the ziksana message framework to call when the ajax response is a success.
	   // data will contain the ziksanaMessageObject. If you have used sendMessage() function instead of sendZiksnaMessage(), you will get the actual data returned by the server instead of the ziksanaMessage object.
	
	   // parse ziksanaMessageObject to extract the body of the message.
		var msgbody = parseZiksanaMessage(data);
		Course_Topic = msgbody.CM_Sub;
		//let's add the contents of the message into the div with an id of 'note_container'
		$('#tempdiv2').append('Module Subject: <strong>'+Course_Topic+'</strong><br/>');
	
	}
	
	function noteSuccessCallbackmodulesub2(data){
		//this is the function we wanted the ziksana message framework to call when the ajax response is a success.
	   // data will contain the ziksanaMessageObject. If you have used sendMessage() function instead of sendZiksnaMessage(), you will get the actual data returned by the server instead of the ziksanaMessage object.
	
	   // parse ziksanaMessageObject to extract the body of the message.
		Course_Topic = data.CM_Sub;
		//let's add the contents of the message into the div with an id of 'note_container'
		$('#tempdiv2').append('Module Subject: <strong>'+Course_Topic+'</strong><br/>');
	}
	
	
	
	//Function for course subject drop down list on change of a value
	$("#Cmoduletopicddl").change(function(e) {
	//alert("Topic change handler");
    
	uri = '/ziksana-web/secure/getModuleTopic'; //this is a demo uri which will return a hardcoded data when simulation is on.

    token = ''; //dummy token for demo. you have to send real token.

    request_type = 'GET'; //can be GET or POST. In this case, a GET request

    var parameters = { "Module_Subject": Cmoduletopicddl };
    constructNotemoduletopic();
    successCallback = noteSuccessCallbackmoduletopic2; //provide a function that will be called when the request is successful. A data object will be passed to this function that contains tha actual data (ziksanaMessage obj in this case.) returned by the server.
    
    errorCallback = commonErrorCallback; // provide a function that will be called when the ajax request encounters an error. You can use the default commonErrorCallback function which will alert the error status code and error text from the server. 

    //Step 2: Send Message Using sendMessage(); function.
    sendMessage(uri, token, parameters, request_type, successCallback, errorCallback);
        
    });
	
		
	function constructNotemoduletopic(){
    //Get the data from the text and input field.

	 var Course_Topic = $('#Cmoduletopicddl').val(); //gets the value typed in description field
    uri = '/ziksana-web/secure/getModuleTopic';

	ziksanaSimulationMessages['/ziksana-web/secure/getModuleTopic'].CM_topic= Course_Topic;
	//alert(Course_Topic);
	}		

	function noteSuccessCallbackmoduletopic(data){
		//this is the function we wanted the ziksana message framework to call when the ajax response is a success.
	   // data will contain the ziksanaMessageObject. If you have used sendMessage() function instead of sendZiksnaMessage(), you will get the actual data returned by the server instead of the ziksanaMessage object.
	
	   // parse ziksanaMessageObject to extract the body of the message.
		var msgbody = parseZiksanaMessage(data);
		Course_Topic = msgbody.CM_topic;
		//let's add the contents of the message into the div with an id of 'note_container'
		$('#tempdiv2').append('Module Topic: <strong>'+Course_Topic+'</strong><br/>');
	
	}
	
	function noteSuccessCallbackmoduletopic2(data){
		//this is the function we wanted the ziksana message framework to call when the ajax response is a success.
	   // data will contain the ziksanaMessageObject. If you have used sendMessage() function instead of sendZiksnaMessage(), you will get the actual data returned by the server instead of the ziksanaMessage object.
	
	   // parse ziksanaMessageObject to extract the body of the message.
		Course_Topic = data.CM_topic;
		//let's add the contents of the message into the div with an id of 'note_container'
		$('#tempdiv2').append('Module Topic: <strong>'+Course_Topic+'</strong><br/>');
	}



});




function getaddmodulesave()
{
	//alert('inside function')
	 //This function demonstrates how to send a message using sendMessage() function. This does not use Ziksana Message format for communication. The communicaiton is direct.

    //Step 1: Assign Parameters required by the sendMessage function.
    uri = '/ziksana-web/secure/saveLearningComponent'; //this is a demo uri which will return a hardcoded data when simulation is on.

    token = ''; //dummy token for demo. you have to send real token.

    request_type = 'GET'; //can be GET or POST. In this case, a GET request

    var parameters = { "Course_id": firstformcourseid, "Course_Module": Cmoduletxtbox, "Module_Description": Cmoduledesc, "Moduletag_Field": Addmoduletag, "Module_Weight": Cmoduleweight, "Module_Duration":Cmoduleduration, "Duration_Type":Cmoduleunits, "Assoc_img":Cmoduleimgupl };
	
    constructNoteaddmoduleformrest();
    successCallback = noteSuccessCallbackaddmodule2; //provide a function that will be called when the request is successful. A data object will be passed to this function that contains tha actual data (ziksanaMessage obj in this case.) returned by the server.
    
    errorCallback = commonErrorCallback; // provide a function that will be called when the ajax request encounters an error. You can use the default commonErrorCallback function which will alert the error status code and error text from the server. 

    //Step 2: Send Message Using sendMessage(); function.
    sendMessage(uri, token, parameters, request_type, successCallback, errorCallback);
	

}

function constructNoteaddmoduleformrest(){
    //Get the data from the text and input field.
	var course_id  = $('#firstformcourseid').val();
    var Module_Name = $('#Cmoduletxtbox').val(); //gets the value typed in title field
    var Module_Description = $('#Cmoduledesc').val(); //gets the value typed in description field
	var Moduletag_Field = $('#Addmoduletag').val();
	var Module_Credits = $('#Cmoduleweight').val(); //gets the value typed in title field
	var Module_Duration = $('#Cmoduleduration').val(); //gets the value typed in title field
    var ModuleDuration_Type = $('#Cmoduleunits').val(); //gets the value typed in description field
	var Assoc_Image = $('#Cmoduleimgupl').val(); //gets the value typed in description field
	//alert(course_id);
	
    uri = '/ziksana-web/secure/saveLearningComponent';
	ziksanaSimulationMessages['/ziksana-web/secure/saveLearningComponent'].id = course_id;
    ziksanaSimulationMessages['/ziksana-web/secure/saveLearningComponent'].title = Module_Name;
    ziksanaSimulationMessages['/ziksana-web/secure/saveLearningComponent'].description = Module_Description;
	ziksanaSimulationMessages['/ziksana-web/secure/saveLearningComponent'].Mt_Field = Moduletag_Field;
	ziksanaSimulationMessages['/ziksana-web/secure/saveLearningComponent'].Mcredits = Module_Credits;
	ziksanaSimulationMessages['/ziksana-web/secure/saveLearningComponent'].MDuration = Module_Duration;
    ziksanaSimulationMessages['/ziksana-web/secure/saveLearningComponent'].DM_Type = ModuleDuration_Type;
	ziksanaSimulationMessages['/ziksana-web/secure/saveLearningComponent'].AM_Image = Assoc_Image;
	//alert('out of the function');
	
}


function noteSuccessCallbackaddmodule(data){
    //this is the function we wanted the ziksana message framework to call when the ajax response is a success.
   // data will contain the ziksanaMessageObject. If you have used sendMessage() function instead of sendZiksnaMessage(), you will get the actual data returned by the server instead of the ziksanaMessage object.

   // parse ziksanaMessageObject to extract the body of the message.
    var msgbody = parseZiksanaMessage(data);

   // we know that this message body will include the note 'title', 'description' & 'duration'. So, extract it.
	course_id  = msgbody.id;
    note_title = msgbody.title;
    note_description = msgbody.description;
	Coursetag_Field = msgbody.Mt_Field;
	Course_Credits = msgbody.Mcredits;
	Course_Duration = msgbody.MDuration;
    Duration_Type = msgbody.DM_Type;
	Associate_img = msgbody.AM_Image;


    //let's add the contents of the message into the div with an id of 'note_container'

    $('#tempdiv2').append('Course_id: <strong>'+course_id+'<br/>Module_Name: <strong>'+note_title+'</strong><br>Module_description: '+note_description+'<br/><br/>Moduletag_Field: '+Coursetag_Field+'Module_Credits : '+Course_Credits+'<br>Module_Duration '+Course_Duration+'<br/>Duration Type : '+Duration_Type+'<br/>Associate_img : '+Associate_img);

}


function noteSuccessCallbackaddmodule2(data){
    //this is the function we wanted the ziksana message framework to call when the ajax response is a success.
    //data will contain the data recieved by the server.
    //we know that this data contains the note 'title', 'description' & 'duration'. So, extract it.
    //alert("Inside success callback2");
	course_id  = data.id;
    note_title = data.title;
    note_description = data.description;
	Coursetag_Field = data.Mt_Field;
	Course_Credits = data.Mcredits;
	Course_Duration = data.MDuration;
    Duration_Type = data.DM_Type;
	Associate_img = data.AM_Image;
	
    //let's add the contents of the message into the div with an id of 'note_container'

    $('#tempdiv2').append('Course_id: <strong>'+course_id+'</strong><br/>Module_Name: <strong>'+note_title+'</strong><br/>Module_description: '+note_description+'<br/>Moduletag_Field: '+Coursetag_Field+'<br/>Module_Credits : '+Course_Credits+'<br/>Module_Duration '+Course_Duration+'<br/>Duration Type : '+Duration_Type+'<br/>Associate_img : '+Associate_img);

}

