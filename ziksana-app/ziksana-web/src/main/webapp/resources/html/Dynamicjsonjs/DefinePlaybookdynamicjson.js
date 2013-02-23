// JavaScript Document
function getplaybooksave()
{
	//alert('inside function')
	 //This function demonstrates how to send a message using sendMessage() function. This does not use Ziksana Message format for communication. The communicaiton is direct.

    //Step 1: Assign Parameters required by the sendMessage function.
    uri = '/ziksana-web/secure/saveorupdatenewplaybook'; //this is a demo uri which will return a hardcoded data when simulation is on.

    token = ''; //dummy token for demo. you have to send real token.

    request_type = 'GET'; //can be GET or POST. In this case, a GET request

    var parameters = { "Course_id": firstformcourseid, "Course_Module": Playbookname, "Module_Description": Playbookdesc};
	
    constructNotecreateplaybookform();
    successCallback = noteSuccessCallbackcreateplaybook2; //provide a function that will be called when the request is successful. A data object will be passed to this function that contains tha actual data (ziksanaMessage obj in this case.) returned by the server.
    
    errorCallback = commonErrorCallback; // provide a function that will be called when the ajax request encounters an error. You can use the default commonErrorCallback function which will alert the error status code and error text from the server. 

    //Step 2: Send Message Using sendMessage(); function.
    sendMessage(uri, token, parameters, request_type, successCallback, errorCallback);
	

}

function constructNotecreateplaybookform(){
    //Get the data from the text and input field.
	var course_id  = $('#firstformcourseid').val();
    var Module_Name = $('#Playbookname').val(); //gets the value typed in title field
    var Module_Description = $('#Playbookdesc').val(); //gets the value typed in description field
	//alert(course_id);
	
    uri = '/ziksana-web/secure/saveorupdatenewplaybook';
	ziksanaSimulationMessages['/ziksana-web/secure/saveorupdatenewplaybook'].id = course_id;
    ziksanaSimulationMessages['/ziksana-web/secure/saveorupdatenewplaybook'].title = Module_Name;
    ziksanaSimulationMessages['/ziksana-web/secure/saveorupdatenewplaybook'].description = Module_Description;
	//alert('out of the function');
	
}


function noteSuccessCallbackcreateplaybook(data){
    //this is the function we wanted the ziksana message framework to call when the ajax response is a success.
   // data will contain the ziksanaMessageObject. If you have used sendMessage() function instead of sendZiksnaMessage(), you will get the actual data returned by the server instead of the ziksanaMessage object.

   // parse ziksanaMessageObject to extract the body of the message.
    var msgbody = parseZiksanaMessage(data);

   // we know that this message body will include the note 'title', 'description' & 'duration'. So, extract it.
	course_id  = msgbody.id;
    note_title = msgbody.title;
    note_description = msgbody.description;


    //let's add the contents of the message into the div with an id of 'note_container'

    $('#tempdiv2').append('Course_id: <strong>'+course_id+'<br/>Playbook_Name: <strong>'+note_title+'</strong><br>Playbook_description: '+note_description+'<br/>');

}


function noteSuccessCallbackcreateplaybook2(data){
    //this is the function we wanted the ziksana message framework to call when the ajax response is a success.
    //data will contain the data recieved by the server.
    //we know that this data contains the note 'title', 'description' & 'duration'. So, extract it.
    //alert("Inside success callback2");
	course_id  = data.id;
    note_title = data.title;
    note_description = data.description;
	
    //let's add the contents of the message into the div with an id of 'note_container'

    $('#tempdiv2').append('Course_id: <strong>'+course_id+'</strong><br/>Playbook_Name: <strong>'+note_title+'</strong><br/>Playbook_description: '+note_description+'<br/>');

}

