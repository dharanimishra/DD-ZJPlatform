// JavaScript Document
$(document).ready(function(e) {
    var type;
});

			function constructNoteformnumerictextdate(){
			//Get the data from the text and input field.
			var new_Info = $("#Caddnewinfolblname").val();
			var info_Descriptionnumeric = $('#Caddnewinfonumeric').val();
			var info_Descriptiondate = $('#Caddnewinfodate').val();
			var info_Descriptiontext = $('#Caddnewinfotext').val();
			uri = '/ziksana-web/secure/saveAddnlInfo';
			ziksanaSimulationMessages['/ziksana-web/secure/saveAddnlInfo'].Newinfo = new_Info;
			ziksanaSimulationMessages['/ziksana-web/secure/saveAddnlInfo'].Descnumeric = info_Descriptionnumeric;
			ziksanaSimulationMessages['/ziksana-web/secure/saveAddnlInfo'].Descdate = info_Descriptiondate;
			ziksanaSimulationMessages['/ziksana-web/secure/saveAddnlInfo'].Desctext = info_Descriptiontext;
			}			

	
			
	function getaddnewinfosave()
{
		type = document.getElementById('Caddnewinfotype').value;
		if(type == "Numeric")
		{
							    //This function demonstrates how to send a message using sendMessage() function. This does not use Ziksana Message format for communication. The communicaiton is direct.

    //Step 1: Assign Parameters required by the sendMessage function.
    uri = '/ziksana-web/secure/saveAddnlInfo'; //this is a demo uri which will return a hardcoded data when simulation is on.

    token = ''; //dummy token for demo. you have to send real token.

    request_type = 'GET'; //can be GET or POST. In this case, a GET request

    var parameters = { "new_Info": Caddnewinfolblname, "info_Description":Caddnewinfonumeric};
	
    constructNoteformnumerictextdate();
    successCallback = noteSuccessCallback2num; //provide a function that will be called when the request is successful. A data object will be passed to this function that contains tha actual data (ziksanaMessage obj in this case.) returned by the server.
    
    errorCallback = commonErrorCallback; // provide a function that will be called when the ajax request encounters an error. You can use the default commonErrorCallback function which will alert the error status code and error text from the server. 

    //Step 2: Send Message Using sendMessage(); function.
    sendMessage(uri, token, parameters, request_type, successCallback, errorCallback);


		}
		else if(type == "Date")
		{
							    //This function demonstrates how to send a message using sendMessage() function. This does not use Ziksana Message format for communication. The communicaiton is direct.

    //Step 1: Assign Parameters required by the sendMessage function.
    uri = '/ziksana-web/secure/saveAddnlInfo'; //this is a demo uri which will return a hardcoded data when simulation is on.

    token = ''; //dummy token for demo. you have to send real token.

    request_type = 'GET'; //can be GET or POST. In this case, a GET request

    var parameters = { "new_Info": Caddnewinfolblname, "info_Description":Caddnewinfodate};
	
    constructNoteformnumerictextdate();
    successCallback = noteSuccessCallback2dat; //provide a function that will be called when the request is successful. A data object will be passed to this function that contains tha actual data (ziksanaMessage obj in this case.) returned by the server.
    
    errorCallback = commonErrorCallback; // provide a function that will be called when the ajax request encounters an error. You can use the default commonErrorCallback function which will alert the error status code and error text from the server. 

    //Step 2: Send Message Using sendMessage(); function.
    sendMessage(uri, token, parameters, request_type, successCallback, errorCallback);


		}
		else if(type == "Text")
			{
								    //This function demonstrates how to send a message using sendMessage() function. This does not use Ziksana Message format for communication. The communicaiton is direct.

    //Step 1: Assign Parameters required by the sendMessage function.
    uri = '/ziksana-web/secure/saveAddnlInfo'; //this is a demo uri which will return a hardcoded data when simulation is on.

    token = ''; //dummy token for demo. you have to send real token.

    request_type = 'GET'; //can be GET or POST. In this case, a GET request

    var parameters = { "new_Info": Caddnewinfolblname, "info_Description": Caddnewinfotext };
	
    constructNoteformnumerictextdate();
    successCallback = noteSuccessCallback2txt; //provide a function that will be called when the request is successful. A data object will be passed to this function that contains tha actual data (ziksanaMessage obj in this case.) returned by the server.
    
    errorCallback = commonErrorCallback; // provide a function that will be called when the ajax request encounters an error. You can use the default commonErrorCallback function which will alert the error status code and error text from the server. 

    //Step 2: Send Message Using sendMessage(); function.
    sendMessage(uri, token, parameters, request_type, successCallback, errorCallback);


			}
	}		
	
		
	function noteSuccessCallbacknum(data){
    //this is the function we wanted the ziksana message framework to call when the ajax response is a success.
   // data will contain the ziksanaMessageObject. If you have used sendMessage() function instead of sendZiksnaMessage(), you will get the actual data returned by the server instead of the ziksanaMessage object.
   // parse ziksanaMessageObject to extract the body of the message.
    var msgbody = parseZiksanaMessage(data);

   // we know that this message body will include the note 'title', 'description' & 'duration'. So, extract it.
  
    new_info = msgbody.Newinfo;
    newinfo_Desc = msgbody.Descnumeric;
    $('#tempdiv').append('New_Info: <strong>'+new_info+'</strong><br>Info_description: '+newinfo_Desc);
	}
	
	function noteSuccessCallbackdat(data){
    //this is the function we wanted the ziksana message framework to call when the ajax response is a success.
   // data will contain the ziksanaMessageObject. If you have used sendMessage() function instead of sendZiksnaMessage(), you will get the actual data returned by the server instead of the ziksanaMessage object.
   // parse ziksanaMessageObject to extract the body of the message.
    var msgbody = parseZiksanaMessage(data);

   // we know that this message body will include the note 'title', 'description' & 'duration'. So, extract it.
  
    new_info = msgbody.Newinfo;
    newinfo_Desc =  msgbody.Descdate;
    $('#tempdiv').append('New_Info: <strong>'+new_info+'</strong><br>Info_description: '+newinfo_Desc);
	}
	
	function noteSuccessCallbacktxt(data){
    //this is the function we wanted the ziksana message framework to call when the ajax response is a success.
   // data will contain the ziksanaMessageObject. If you have used sendMessage() function instead of sendZiksnaMessage(), you will get the actual data returned by the server instead of the ziksanaMessage object.
   // parse ziksanaMessageObject to extract the body of the message.
    var msgbody = parseZiksanaMessage(data);

   // we know that this message body will include the note 'title', 'description' & 'duration'. So, extract it.
  
    new_info = msgbody.Newinfo;
    newinfo_Desc = msgbody.Desctext;
    $('#tempdiv').append('New_Info: <strong>'+new_info+'</strong><br>Info_description: '+newinfo_Desc);
	}



function noteSuccessCallback2num(data){
    //this is the function we wanted the ziksana message framework to call when the ajax response is a success.
    //data will contain the data recieved by the server.

    //we know that this data contains the note 'title', 'description' & 'duration'. So, extract it.
    //alert("Inside success callback2");
    new_info = data.Newinfo;
    newinfo_Desc = data.Descnumeric;
    $('#tempdiv').append('New_Info: <strong>'+new_info+'</strong><br/>Info_description: '+newinfo_Desc);
}
function noteSuccessCallback2dat(data){
    //this is the function we wanted the ziksana message framework to call when the ajax response is a success.
    //data will contain the data recieved by the server.

    //we know that this data contains the note 'title', 'description' & 'duration'. So, extract it.
    //alert("Inside success callback2");
    new_info = data.Newinfo;
    newinfo_Desc = data.Descdate;
    $('#tempdiv').append('New_Info: <strong>'+new_info+'</strong><br/>Info_description: '+newinfo_Desc);
}
function noteSuccessCallback2txt(data){
    //this is the function we wanted the ziksana message framework to call when the ajax response is a success.
    //data will contain the data recieved by the server.

    //we know that this data contains the note 'title', 'description' & 'duration'. So, extract it.
    //alert("Inside success callback2");
    new_info = data.Newinfo;
    newinfo_Desc = data.Desctext;
    $('#tempdiv').append('New_Info: <strong>'+new_info+'</strong><br/>Info_description: '+newinfo_Desc);
}
	
