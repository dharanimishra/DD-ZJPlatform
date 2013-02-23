// JavaScript Document

            
$(document).ready(function(e) {
    
	//Function for Subject Area drop down list on change of a value		
	$("#Careaddl").change(function(e) {
		//alert("Careaddl has changed");
		
	uri = '/ziksana-web/secure/getSubjectArea'; //this is a demo uri which will return a hardcoded data when simulation is on.

    token = ''; //dummy token for demo. you have to send real token.

    request_type = 'GET'; //can be GET or POST. In this case, a GET request

    var parameters = { "Course_Area": Careaddl };
     constructNotecoursearea();
    successCallback = noteSuccessCallbackcoursearea2; //provide a function that will be called when the request is successful. A data object will be passed to this function that contains tha actual data (ziksanaMessage obj in this case.) returned by the server.
    
    errorCallback = commonErrorCallback; // provide a function that will be called when the ajax request encounters an error. You can use the default commonErrorCallback function which will alert the error status code and error text from the server. 

    //Step 2: Send Message Using sendMessage(); function.
    sendMessage(uri, token, parameters, request_type, successCallback, errorCallback);
       
		
    });
	
	function constructNotecoursearea(){
    //Get the data from the text and input field.

	var Course_Area = $('#Careaddl').val(); //gets the value typed in description field
    uri = '/ziksana-web/secure/getSubjectArea';

	ziksanaSimulationMessages['/ziksana-web/secure/getSubjectArea'].C_Area = Course_Area;
	//alert(Course_Area);
}			

	function noteSuccessCallbackcoursearea(data){
		//this is the function we wanted the ziksana message framework to call when the ajax response is a success.
	   // data will contain the ziksanaMessageObject. If you have used sendMessage() function instead of sendZiksnaMessage(), you will get the actual data returned by the server instead of the ziksanaMessage object.
	
	   // parse ziksanaMessageObject to extract the body of the message.
		var msgbody = parseZiksanaMessage(data);
		Course_Area = msgbody.C_Area;
		//let's add the contents of the message into the div with an id of 'note_container'
		$('#tempdiv').append('Course_Area: <strong>'+Course_Area+'</strong><br/>');
	
	}
	
	function noteSuccessCallbackcoursearea2(data){
		//this is the function we wanted the ziksana message framework to call when the ajax response is a success.
	   // data will contain the ziksanaMessageObject. If you have used sendMessage() function instead of sendZiksnaMessage(), you will get the actual data returned by the server instead of the ziksanaMessage object.
	
	   // parse ziksanaMessageObject to extract the body of the message.
		Course_Area = data.C_Area;
		//let's add the contents of the message into the div with an id of 'note_container'
		$('#tempdiv').append('Course_Area: <strong>'+Course_Area+'</strong><br/>');
	}
			
	
	///Function for Course subject drop down list on change of a value		
	$("#Csubjectddl").change(function(e) {
		//alert ("Inside subject change handler");
	
	uri = '/ziksana-web/secure/getSubject'; //this is a demo uri which will return a hardcoded data when simulation is on.

    token = ''; //dummy token for demo. you have to send real token.

    request_type = 'GET'; //can be GET or POST. In this case, a GET request

    var parameters = { "Course_Subject": Csubjectddl };
     constructNotecoursesubject();
    successCallback = noteSuccessCallbackcoursesubject2; //provide a function that will be called when the request is successful. A data object will be passed to this function that contains tha actual data (ziksanaMessage obj in this case.) returned by the server.
    
    errorCallback = commonErrorCallback; // provide a function that will be called when the ajax request encounters an error. You can use the default commonErrorCallback function which will alert the error status code and error text from the server. 

    //Step 2: Send Message Using sendMessage(); function.
    sendMessage(uri, token, parameters, request_type, successCallback, errorCallback);
       
    });
	
	
	
	function constructNotecoursesubject(){
    //Get the data from the text and input field.

	var Course_Subject = $('#Csubjectddl').val();
    uri = '/ziksana-web/secure/getSubject';

	ziksanaSimulationMessages['/ziksana-web/secure/getSubject'].C_Subject = Course_Subject;
}			

	function noteSuccessCallbackcoursesubject(data){
		//this is the function we wanted the ziksana message framework to call when the ajax response is a success.
	   // data will contain the ziksanaMessageObject. If you have used sendMessage() function instead of sendZiksnaMessage(), you will get the actual data returned by the server instead of the ziksanaMessage object.
	
	   // parse ziksanaMessageObject to extract the body of the message.
		var msgbody = parseZiksanaMessage(data);
		Course_Subject = msgbody.C_Subject
		//let's add the contents of the message into the div with an id of 'note_container'
		$('#tempdiv').append('Course Subject: <strong>'+Course_Subject+'</strong><br/>');
	
	}
	
	function noteSuccessCallbackcoursesubject2(data){
		//this is the function we wanted the ziksana message framework to call when the ajax response is a success.
	   // data will contain the ziksanaMessageObject. If you have used sendMessage() function instead of sendZiksnaMessage(), you will get the actual data returned by the server instead of the ziksanaMessage object.
	
	   // parse ziksanaMessageObject to extract the body of the message.
		Course_Subject = data.C_Subject;
		//let's add the contents of the message into the div with an id of 'note_container'
		$('#tempdiv').append('Course Subject: <strong>'+Course_Subject+'</strong><br/>');
	}
	
	
	//Function for course subject drop down list on change of a value
	$("#Ctopicddl").change(function(e) {
	//alert("Topic change handler");
    
	uri = '/ziksana-web/secure/getTopic'; //this is a demo uri which will return a hardcoded data when simulation is on.

    token = ''; //dummy token for demo. you have to send real token.

    request_type = 'GET'; //can be GET or POST. In this case, a GET request

    var parameters = { "Course_Topic": Ctopicddl };
    constructNotecoursetopic();
    successCallback = noteSuccessCallbackcoursetopic2; //provide a function that will be called when the request is successful. A data object will be passed to this function that contains tha actual data (ziksanaMessage obj in this case.) returned by the server.
    
    errorCallback = commonErrorCallback; // provide a function that will be called when the ajax request encounters an error. You can use the default commonErrorCallback function which will alert the error status code and error text from the server. 

    //Step 2: Send Message Using sendMessage(); function.
    sendMessage(uri, token, parameters, request_type, successCallback, errorCallback);
        
    });
	
		
	function constructNotecoursetopic(){
    //Get the data from the text and input field.

	 var Course_Topic = $('#Ctopicddl').val(); //gets the value typed in description field
    uri = '/ziksana-web/secure/getTopic';

	ziksanaSimulationMessages['/ziksana-web/secure/getTopic'].C_Topic = Course_Topic;
	//alert(Course_Topic);
	}		

	function noteSuccessCallbackcoursetopic(data){
		//this is the function we wanted the ziksana message framework to call when the ajax response is a success.
	   // data will contain the ziksanaMessageObject. If you have used sendMessage() function instead of sendZiksnaMessage(), you will get the actual data returned by the server instead of the ziksanaMessage object.
	
	   // parse ziksanaMessageObject to extract the body of the message.
		var msgbody = parseZiksanaMessage(data);
		Course_Topic = msgbody.C_Topic;
		//let's add the contents of the message into the div with an id of 'note_container'
		$('#tempdiv').append('Course Topic: <strong>'+Course_Topic+'</strong><br/>');
	
	}
	
	function noteSuccessCallbackcoursetopic2(data){
		//this is the function we wanted the ziksana message framework to call when the ajax response is a success.
	   // data will contain the ziksanaMessageObject. If you have used sendMessage() function instead of sendZiksnaMessage(), you will get the actual data returned by the server instead of the ziksanaMessage object.
	
	   // parse ziksanaMessageObject to extract the body of the message.
		Course_Topic = data.C_Topic;
		//let's add the contents of the message into the div with an id of 'note_container'
		$('#tempdiv').append('Course Topic: <strong>'+Course_Topic+'</strong><br/>');
	}
	
	
	
	

	
	
	$("#Cimageupl").mouseout(function(e) {

	uri = '/ziksana-web/secure/uploadFile'; //this is a demo uri which will return a hardcoded data when simulation is on.

    token = ''; //dummy token for demo. you have to send real token.

    request_type = 'POST'; //can be GET or POST. In this case, a GET request

    var parameters = { "Assoc_Image": Cimageupl };
   constructNoteimgupl();
    successCallback = noteSuccessCallbackimgupl2; //provide a function that will be called when the request is successful. A data object will be passed to this function that contains tha actual data (ziksanaMessage obj in this case.) returned by the server.
    
    errorCallback = commonErrorCallback; // provide a function that will be called when the ajax request encounters an error. You can use the default commonErrorCallback function which will alert the error status code and error text from the server. 

    //Step 2: Send Message Using sendMessage(); function.
    sendMessage(uri, token, parameters, request_type, successCallback, errorCallback);
    });
	
	
	function constructNoteimgupl(){
    //Get the data from the text and input field.
	var Assoc_Image = $('#Cimageupl').val(); //gets the value typed in description field
    uri = '/ziksana-web/secure/uploadFile';
	ziksanaSimulationMessages['/ziksana-web/secure/uploadFile'].A_Image = Assoc_Image;
	
	}
	
	function noteSuccessCallbackimgupl(data){
		//this is the function we wanted the ziksana message framework to call when the ajax response is a success.
	   // data will contain the ziksanaMessageObject. If you have used sendMessage() function instead of sendZiksnaMessage(), you will get the actual data returned by the server instead of the ziksanaMessage object.
	
	   // parse ziksanaMessageObject to extract the body of the message.
		var msgbody = parseZiksanaMessage(data);
		Assoc_Image = msgbody.A_Image;
		//let's add the contents of the message into the div with an id of 'note_container'
		$('#tempdiv').append('Assoc Image: <strong>'+Assoc_Image+'</strong><br/>');
	
	}
	
	function noteSuccessCallbackimgupl2(data){
		//this is the function we wanted the ziksana message framework to call when the ajax response is a success.
	   // data will contain the ziksanaMessageObject. If you have used sendMessage() function instead of sendZiksnaMessage(), you will get the actual data returned by the server instead of the ziksanaMessage object.
	
	   // parse ziksanaMessageObject to extract the body of the message.
		Assoc_Image = data.A_Image;
		//let's add the contents of the message into the div with an id of 'note_container'
		$('#tempdiv').append('Assoc Image: <strong>'+Assoc_Image+'</strong><br/>');
	}
	
});	



	
function getdefinecoursesave(){
    //This function demonstrates how to send a message using sendMessage() function. This does not use Ziksana Message format for communication. The communicaiton is direct.

    //Step 1: Assign Parameters required by the sendMessage function.
    uri = '/ziksana-web/secure/saveCourse'; //this is a demo uri which will return a hardcoded data when simulation is on.

    token = ''; //dummy token for demo. you have to send real token.

    request_type = 'GET'; //can be GET or POST. In this case, a GET request

    var parameters = { "Course_id": firstformcourseid, "Course_Name": defaultvalue, "Course_Description": Cdescription, "Coursetag_Field": Ctagfield, "Course_Credits": Credits, "Extra_Credits":ExtraCredits, "Course_Duration":Duration, "Duration_Type":Cdurationtype };
    constructNoteformrest();
    successCallback = noteSuccessCallback2; //provide a function that will be called when the request is successful. A data object will be passed to this function that contains tha actual data (ziksanaMessage obj in this case.) returned by the server.
    
    errorCallback = commonErrorCallback; // provide a function that will be called when the ajax request encounters an error. You can use the default commonErrorCallback function which will alert the error status code and error text from the server. 

    //Step 2: Send Message Using sendMessage(); function.
    sendMessage(uri, token, parameters, request_type, successCallback, errorCallback);
	


			}
			

			
            
function constructNoteformrest(){
    //Get the data from the text and input field.
	var Course_id = $('#firstformcourseid').val();
    var Course_Name = $('#defaultvalue').val(); //gets the value typed in title field
    var Course_Description = $('#Cdescription').val(); //gets the value typed in description field
	var Coursetag_Field = $('#Ctagfield').val();
	var Course_Credits = $('#Credits').val(); //gets the value typed in title field
    var Extra_Credits = $('#ExtraCredits').val(); //gets the value typed in description field
	var Course_Duration = $('#Duration').val(); //gets the value typed in title field
    var Duration_Type = $('#Cdurationtype').val(); //gets the value typed in description field
/*	var Course_Area = $('#Careaddl').val(); //gets the value typed in description field
	var Course_Subject = $('#Csubjectddl').val(); //gets the value typed in title field
    var Course_Topic = $('#Ctopicddl').val(); //gets the value typed in description field
*/	var Assoc_Image = $('#Cimageupl').val(); //gets the value typed in description field
    uri = '/ziksana-web/secure/saveCourse';
	 ziksanaSimulationMessages['/ziksana-web/secure/saveCourse'].id = Course_id;
    ziksanaSimulationMessages['/ziksana-web/secure/saveCourse'].title = Course_Name;
    ziksanaSimulationMessages['/ziksana-web/secure/saveCourse'].description = Course_Description;
	ziksanaSimulationMessages['/ziksana-web/secure/saveCourse'].Ct_Field = Coursetag_Field;
	ziksanaSimulationMessages['/ziksana-web/secure/saveCourse'].Credits = Course_Credits;
    ziksanaSimulationMessages['/ziksana-web/secure/saveCourse'].E_Credits = Extra_Credits;
	ziksanaSimulationMessages['/ziksana-web/secure/saveCourse'].Duration = Course_Duration;
    ziksanaSimulationMessages['/ziksana-web/secure/saveCourse'].D_Type = Duration_Type;
/*	ziksanaSimulationMessages['/ziksana-web/secure/getSubjectArea'].C_Area = Course_Area;
	ziksanaSimulationMessages['/ziksana-web/secure/getSubject'].C_Subject = Course_Subject;
    ziksanaSimulationMessages['/ziksana-web/secure/getTopic'].C_Topic = Course_Topic;
	ziksanaSimulationMessages['/ziksana-web/secure/uploadFile'].A_Image = Assoc_Image;
*/
	
}


function noteSuccessCallback(data){
    //this is the function we wanted the ziksana message framework to call when the ajax response is a success.
   // data will contain the ziksanaMessageObject. If you have used sendMessage() function instead of sendZiksnaMessage(), you will get the actual data returned by the server instead of the ziksanaMessage object.

   // parse ziksanaMessageObject to extract the body of the message.
    var msgbody = parseZiksanaMessage(data);

   // we know that this message body will include the note 'title', 'description' & 'duration'. So, extract it.
   	course_id = msgbody.id;
    note_title = msgbody.title;
    note_description = msgbody.description;
	Coursetag_Field = msgbody.Ct_Field;
	Course_Credits = msgbody.Credits;
    Extra_Credits = msgbody.E_Credits;
	Course_Duration = msgbody.Duration;
    Duration_Type = msgbody.D_Type;
/*	Course_Area = msgbody.C_Area;
	Course_Subject = msgbody.C_Subject;
    Course_Topic = msgbody.C_Topic;
*/	


    //let's add the contents of the message into the div with an id of 'note_container'

    $('#tempdiv').append('Course_Id: <strong>'+course_id+'</strong><br>Course_Name: <strong>'+note_title+'</strong><br>Course_description: '+note_description+'<br/><br/>Coursetag_Field: '+Coursetag_Field+'Course_Credits : '+Course_Credits+' Extra_Credits: <strong>'+Extra_Credits+'</strong><br>Course_Duration '+Course_Duration+'<br/>Duration Type : '+Duration_Type+'<br/>');

}


function noteSuccessCallback2(data){
    //this is the function we wanted the ziksana message framework to call when the ajax response is a success.
    //data will contain the data recieved by the server.

    //we know that this data contains the note 'title', 'description' & 'duration'. So, extract it.
    //alert("Inside success callback2");
	course_id = data.id;
    note_title = data.title;
    note_description = data.description;
	Coursetag_Field = data.Ct_Field;
	Course_Credits = data.Credits;
    Extra_Credits = data.E_Credits;
	Course_Duration = data.Duration;
    Duration_Type = data.D_Type;
/*	Course_Area = data.C_Area;
	Course_Subject = data.C_Subject;
    Course_Topic = data.C_Topic;
*/	

    //let's add the contents of the message into the div with an id of 'note_container'

    $('#tempdiv').append('Course_Id: <strong>'+course_id+'</strong><br/>Course_Name: <strong>'+note_title+'</strong><br/>Course_description: '+note_description+'<br/>Coursetag_Field: '+Coursetag_Field+'<br/>Course_Credits : '+Course_Credits+' <br/>Extra_Credits: <strong>'+Extra_Credits+'</strong><br/>Course_Duration '+Course_Duration+'<br/>Duration Type : '+Duration_Type+'<br/>');

}

    

