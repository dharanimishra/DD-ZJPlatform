

	function getcreatequalifiersave()
	{
	//alert('inside function')
	 //This function demonstrates how to send a message using sendMessage() function. This does not use Ziksana Message format for communication. The communicaiton is direct.

    //Step 1: Assign Parameters required by the sendMessage function.
    uri = '/ziksana-web/secure/saveQualifier'; //this is a demo uri which will return a hardcoded data when simulation is on.

    token = ''; //dummy token for demo. you have to send real token.

    request_type = 'GET'; //can be GET or POST. In this case, a GET request

    var parameters = { "Course_id": Course_Id, "Module_Topic": Qualifiertypeddl, "Qualifier Type": Qualifiertitlelbl, "Qualifier Text": Qualifiertext };
	
    constructNotecreatequalifierform();
    successCallback = noteSuccessCallbackcreatequalifierform2; //provide a function that will be called when the request is successful. A data object will be passed to this function that contains tha actual data (ziksanaMessage obj in this case.) returned by the server.
    
    errorCallback = commonErrorCallback; // provide a function that will be called when the ajax request encounters an error. You can use the default commonErrorCallback function which will alert the error status code and error text from the server. 

    //Step 2: Send Message Using sendMessage(); function.
    sendMessage(uri, token, parameters, request_type, successCallback, errorCallback);
	}

function constructNotecreatequalifierform(){
    //Get the data from the text and input field.
	var courseid  = $('#Course_Id').val();
    var ModuleName = $('#Qualifiertypeddl').val(); //gets the value typed in title field
    var ModuleDescription = $('#Qualifiertitlelbl').val(); //gets the value typed in description field
	var ModuletagField = $('#Qualifiertext').val();
//	alert(ModuleName);
//	alert(ModuleDescription);
//	alert(ModuletagField);
    uri = '/ziksana-web/secure/saveQualifier';
	ziksanaSimulationMessages['/ziksana-web/secure/saveQualifier'].Cid = courseid;
    ziksanaSimulationMessages['/ziksana-web/secure/saveQualifier'].CM_Area = ModuleName;
    ziksanaSimulationMessages['/ziksana-web/secure/saveQualifier'].description = ModuleDescription;
	ziksanaSimulationMessages['/ziksana-web/secure/saveQualifier'].Mt_Field = ModuletagField;
	//alert('out of function');
}

function noteSuccessCallbackcreatequalifierform(data){
    //this is the function we wanted the ziksana message framework to call when the ajax response is a success.
   // data will contain the ziksanaMessageObject. If you have used sendMessage() function instead of sendZiksnaMessage(), you will get the actual data returned by the server instead of the ziksanaMessage object.
	//alert();
   // parse ziksanaMessageObject to extract the body of the message.
    var msgbody = parseZiksanaMessage(data);

   // we know that this message body will include the note 'title', 'description' & 'duration'. So, extract it.
	course_id  = msgbody.id;
	Course_Topic = msgbody.CM_Area;
    note_title = msgbody.description;
    note_description = msgbody.Mt_Field;
    //let's add the contents of the message into the div with an id of 'note_container'

    $('#tempdiv2').append('<br/>Course_id: <strong>'+course_id+'</strong><br/>Qualifier_type: <strong>'+Course_Topic+'</strong><br/>Qualifier_Title: <strong>'+note_title+'</strong><br/>Qualifier_description: '+note_description);

}


function noteSuccessCallbackcreatequalifierform2(data){
    //this is the function we wanted the ziksana message framework to call when the ajax response is a success.
    //data will contain the data recieved by the server.
    //we know that this data contains the note 'title', 'description' & 'duration'. So, extract it.
    //alert("Inside success callback2");
	//alert();
	course_id  = data.id;
	Course_Topic = data.CM_Area;
    note_title = data.description;
    note_description = data.Mt_Field;
    //let's add the contents of the message into the div with an id of 'note_container'

    $('#tempdiv2').append('<br/>Course_id: <strong>'+course_id+'</strong><br/>Qualifier_type: <strong>'+Course_Topic+'</strong><br/>Qualifier_Title: <strong>'+note_title+'</strong><br/>Qualifier_description: '+note_description);

}




