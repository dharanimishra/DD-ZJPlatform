// JavaScript Document

$(document).ready(function(e) {
    	$("#tempdiv").empty();

	//Function for course subject drop down list on change of a value
	$("#Assoccontentarea").change(function(e) {
	//alert("Topic change handler");
    
	uri = '/ziksana-web/secure/getContentArea'; //this is a demo uri which will return a hardcoded data when simulation is on.

    token = ''; //dummy token for demo. you have to send real token.

    request_type = 'GET'; //can be GET or POST. In this case, a GET request

    var parameters = { "Module_Topic": Assoccontentarea };
    constructNoteAssocarea();
    successCallback = noteSuccessCallbackAssocarea2; //provide a function that will be called when the request is successful. A data object will be passed to this function that contains tha actual data (ziksanaMessage obj in this case.) returned by the server.
    
    errorCallback = commonErrorCallback; // provide a function that will be called when the ajax request encounters an error. You can use the default commonErrorCallback function which will alert the error status code and error text from the server. 

    //Step 2: Send Message Using sendMessage(); function.
    sendMessage(uri, token, parameters, request_type, successCallback, errorCallback);
        
    });
	
		
	function constructNoteAssocarea(){
    //Get the data from the text and input field.

	 var Course_Topic = $('#Assoccontentarea').val(); //gets the value typed in description field
    uri = '/ziksana-web/secure/getContentArea';
	alert(Course_Topic);
	ziksanaSimulationMessages['/ziksana-web/secure/getContentArea'].CM_Area= Course_Topic;
	
	}		

	function noteSuccessCallbackAssocarea(data){
		//this is the function we wanted the ziksana message framework to call when the ajax response is a success.
	   // data will contain the ziksanaMessageObject. If you have used sendMessage() function instead of sendZiksnaMessage(), you will get the actual data returned by the server instead of the ziksanaMessage object.
	
	   // parse ziksanaMessageObject to extract the body of the message.
		var msgbody = parseZiksanaMessage(data);
		Course_Topic = msgbody.CM_Area;
		//let's add the contents of the message into the div with an id of 'note_container'
		$('#tempdiv').append('Content Area: <strong>'+Course_Topic+'</strong><br/>');
	
	}
	
	function noteSuccessCallbackAssocarea2(data){
		//this is the function we wanted the ziksana message framework to call when the ajax response is a success.
	   // data will contain the ziksanaMessageObject. If you have used sendMessage() function instead of sendZiksnaMessage(), you will get the actual data returned by the server instead of the ziksanaMessage object.
	
	   // parse ziksanaMessageObject to extract the body of the message.
		Course_Topic = data.CM_Area;
		//let's add the contents of the message into the div with an id of 'note_container'
		$('#tempdiv').append('Content Area: <strong>'+Course_Topic+'</strong><br/>');
	}
	
	
		//Function for course subject drop down list on change of a value
	$("#Assoccontentsubject").change(function(e) {
	//alert("Topic change handler");
    
	uri = '/ziksana-web/secure/getContent'; //this is a demo uri which will return a hardcoded data when simulation is on.

    token = ''; //dummy token for demo. you have to send real token.

    request_type = 'GET'; //can be GET or POST. In this case, a GET request

    var parameters = { "Module_Topic": Assoccontentsubject };
    constructNoteAssocsub();
    successCallback = noteSuccessCallbackAssocsub2; //provide a function that will be called when the request is successful. A data object will be passed to this function that contains tha actual data (ziksanaMessage obj in this case.) returned by the server.
    
    errorCallback = commonErrorCallback; // provide a function that will be called when the ajax request encounters an error. You can use the default commonErrorCallback function which will alert the error status code and error text from the server. 

    //Step 2: Send Message Using sendMessage(); function.
    sendMessage(uri, token, parameters, request_type, successCallback, errorCallback);
        
    });
	
		
	function constructNoteAssocsub(){
    //Get the data from the text and input field.

	 var Course_Topic = $('#Assoccontentsubject').val(); //gets the value typed in description field
    uri = '/ziksana-web/secure/getContent';

	ziksanaSimulationMessages['/ziksana-web/secure/getContent'].CM_Area= Course_Topic;
	alert(Course_Topic);
}		

	function noteSuccessCallbackAssocsub(data){
		//this is the function we wanted the ziksana message framework to call when the ajax response is a success.
	   // data will contain the ziksanaMessageObject. If you have used sendMessage() function instead of sendZiksnaMessage(), you will get the actual data returned by the server instead of the ziksanaMessage object.
	
	   // parse ziksanaMessageObject to extract the body of the message.
		var msgbody = parseZiksanaMessage(data);
		Course_Topic = msgbody.CM_Area;
		//let's add the contents of the message into the div with an id of 'note_container'
		$('#tempdiv').append('Content Subject: <strong>'+Course_Topic+'</strong><br/>');
	
	}
	
	function noteSuccessCallbackAssocsub2(data){
		//this is the function we wanted the ziksana message framework to call when the ajax response is a success.
	   // data will contain the ziksanaMessageObject. If you have used sendMessage() function instead of sendZiksnaMessage(), you will get the actual data returned by the server instead of the ziksanaMessage object.
	
	   // parse ziksanaMessageObject to extract the body of the message.
		Course_Topic = data.CM_Area;
		//let's add the contents of the message into the div with an id of 'note_container'
		$('#tempdiv').append('Content Subject: <strong>'+Course_Topic+'</strong><br/>');
	}
	
	
	
	//Function for course subject drop down list on change of a value
	$("#Assoccontenttopic").change(function(e) {
	//alert("Topic change handler");
    
	uri = '/ziksana-web/secure/getTopic'; //this is a demo uri which will return a hardcoded data when simulation is on.

    token = ''; //dummy token for demo. you have to send real token.

    request_type = 'GET'; //can be GET or POST. In this case, a GET request

    var parameters = { "Module_Topic": Assoccontenttopic };
    constructNoteAssoctopic();
    successCallback = noteSuccessCallbackAssoctopic2; //provide a function that will be called when the request is successful. A data object will be passed to this function that contains tha actual data (ziksanaMessage obj in this case.) returned by the server.
    
    errorCallback = commonErrorCallback; // provide a function that will be called when the ajax request encounters an error. You can use the default commonErrorCallback function which will alert the error status code and error text from the server. 

    //Step 2: Send Message Using sendMessage(); function.
    sendMessage(uri, token, parameters, request_type, successCallback, errorCallback);
        
    });
	
		
	function constructNoteAssoctopic(){
    //Get the data from the text and input field.

	 var Course_Topic = $('#Assoccontenttopic').val(); //gets the value typed in description field
    uri = '/ziksana-web/secure/getTopic';

	ziksanaSimulationMessages['/ziksana-web/secure/getTopic'].CM_Area= Course_Topic;
	//alert(Course_Topic);
}		

	function noteSuccessCallbackAssoctopic(data){
		//this is the function we wanted the ziksana message framework to call when the ajax response is a success.
	   // data will contain the ziksanaMessageObject. If you have used sendMessage() function instead of sendZiksnaMessage(), you will get the actual data returned by the server instead of the ziksanaMessage object.
	
	   // parse ziksanaMessageObject to extract the body of the message.
		var msgbody = parseZiksanaMessage(data);
		Course_Topic = msgbody.CM_Area;
		//let's add the contents of the message into the div with an id of 'note_container'
		$('#tempdiv').append('Content Topic: <strong>'+Course_Topic+'</strong><br/>');
	
	}
	
	function noteSuccessCallbackAssoctopic2(data){
		//this is the function we wanted the ziksana message framework to call when the ajax response is a success.
	   // data will contain the ziksanaMessageObject. If you have used sendMessage() function instead of sendZiksnaMessage(), you will get the actual data returned by the server instead of the ziksanaMessage object.
	
	   // parse ziksanaMessageObject to extract the body of the message.
		Course_Topic = data.CM_Area;
		//let's add the contents of the message into the div with an id of 'note_container'
		$('#tempdiv').append('Content Topic: <strong>'+Course_Topic+'</strong><br/>');
	}

});

function  getassociatecontentsave()
{
	
	uri = '/ziksana-web/secure/saveOrUpdateContent'; //this is a demo uri which will return a hardcoded data when simulation is on.

    token = ''; //dummy token for demo. you have to send real token.

    request_type = 'GET'; //can be GET or POST. In this case, a GET request

    var parameters = { "Course_id": firstformcourseid, "Content_Name": contentname, "Content_Description": contentdesc, "Associatetag_Field": Associatetag, "Assoctab_img":associateimgupl, "Assoccontent_type": q_type, "Associmgtype": imgultype, "Assoclink_type": defaultvalue, "Assoctext_type": q_typecdesdcrte};
	
    constructNoteassociatecontentformrest();
    successCallback = noteSuccessCallbackassoccontent2; //provide a function that will be called when the request is successful. A data object will be passed to this function that contains tha actual data (ziksanaMessage obj in this case.) returned by the server.
    
    errorCallback = commonErrorCallback; // provide a function that will be called when the ajax request encounters an error. You can use the default commonErrorCallback function which will alert the error status code and error text from the server. 

    //Step 2: Send Message Using sendMessage(); function.
    sendMessage(uri, token, parameters, request_type, successCallback, errorCallback);
	

}

function constructNoteassociatecontentformrest()
{
	    //Get the data from the text and input field.
	var course_id  = $('#firstformcourseid').val();
    var Assoc_Name = $('#contentname').val(); //gets the value typed in title field
    var Assoc_Description = $('#contentdesc').val(); //gets the value typed in description field
	var Assoctag_Field = $('#Associatetag').val();
	var Assoctab_Image = $('#associateimgupl').val(); //gets the value typed in description field
	var Content_type = $('#q_type').val(); //gets the value typed in title field
	var Assoctype_img = $("#imgultype").val();
    uri = '/ziksana-web/secure/saveOrUpdateContent';
	if(Content_type == "Upload Content")
	{
		var Assoctype_content = $("#imgultype").val();
		ziksanaSimulationMessages['/ziksana-web/secure/saveOrUpdateContent'].id = course_id;
    ziksanaSimulationMessages['/ziksana-web/secure/saveOrUpdateContent'].title = Assoc_Name;
    ziksanaSimulationMessages['/ziksana-web/secure/saveOrUpdateContent'].description = Assoc_Description;
	ziksanaSimulationMessages['/ziksana-web/secure/saveOrUpdateContent'].At_Field = Assoctag_Field;
	ziksanaSimulationMessages['/ziksana-web/secure/saveOrUpdateContent'].AM_Image = Assoctab_Image;
    ziksanaSimulationMessages['/ziksana-web/secure/saveOrUpdateContent'].Ac_Type = Content_type;
	ziksanaSimulationMessages['/ziksana-web/secure/saveOrUpdateContent'].Ac_Desc = Assoctype_content;
	}
	else if(Content_type == "External WebPage")
	{
		var Assoctype_content = $("#defaultvalue").val();
		ziksanaSimulationMessages['/ziksana-web/secure/saveOrUpdateContent'].id = course_id;
    ziksanaSimulationMessages['/ziksana-web/secure/saveOrUpdateContent'].title = Assoc_Name;
    ziksanaSimulationMessages['/ziksana-web/secure/saveOrUpdateContent'].description = Assoc_Description;
	ziksanaSimulationMessages['/ziksana-web/secure/saveOrUpdateContent'].At_Field = Assoctag_Field;
	ziksanaSimulationMessages['/ziksana-web/secure/saveOrUpdateContent'].AM_Image = Assoctab_Image;
    ziksanaSimulationMessages['/ziksana-web/secure/saveOrUpdateContent'].Ac_Type = Content_type;
	ziksanaSimulationMessages['/ziksana-web/secure/saveOrUpdateContent'].Ac_Desc = Assoctype_content;
	}
	else if(Content_type == "Create Content")
	{
		var Assoctype_content = $("#q_typecdesdcrte").val();
		ziksanaSimulationMessages['/ziksana-web/secure/saveOrUpdateContent'].id = course_id;
    ziksanaSimulationMessages['/ziksana-web/secure/saveOrUpdateContent'].title = Assoc_Name;
    ziksanaSimulationMessages['/ziksana-web/secure/saveOrUpdateContent'].description = Assoc_Description;
	ziksanaSimulationMessages['/ziksana-web/secure/saveOrUpdateContent'].At_Field = Assoctag_Field;
	ziksanaSimulationMessages['/ziksana-web/secure/saveOrUpdateContent'].AM_Image = Assoctab_Image;
    ziksanaSimulationMessages['/ziksana-web/secure/saveOrUpdateContent'].Ac_Type = Content_type;
	ziksanaSimulationMessages['/ziksana-web/secure/saveOrUpdateContent'].Ac_Desc = Assoctype_content;
	}
	else
	{
	ziksanaSimulationMessages['/ziksana-web/secure/saveOrUpdateContent'].id = course_id;
    ziksanaSimulationMessages['/ziksana-web/secure/saveOrUpdateContent'].title = Assoc_Name;
    ziksanaSimulationMessages['/ziksana-web/secure/saveOrUpdateContent'].description = Assoc_Description;
	ziksanaSimulationMessages['/ziksana-web/secure/saveOrUpdateContent'].At_Field = Assoctag_Field;
	ziksanaSimulationMessages['/ziksana-web/secure/saveOrUpdateContent'].AM_Image = Assoctab_Image;
    ziksanaSimulationMessages['/ziksana-web/secure/saveOrUpdateContent'].Ac_Type = Content_type;
	}
}

function noteSuccessCallbackassoccontent(data){
    //this is the function we wanted the ziksana message framework to call when the ajax response is a success.
   // data will contain the ziksanaMessageObject. If you have used sendMessage() function instead of sendZiksnaMessage(), you will get the actual data returned by the server instead of the ziksanaMessage object.

   // parse ziksanaMessageObject to extract the body of the message.
    var msgbody = parseZiksanaMessage(data);

   // we know that this message body will include the note 'title', 'description' & 'duration'. So, extract it.
	course_id  = msgbody.id;
    note_title = msgbody.title;
    note_description = msgbody.description;
	Coursetag_Field = msgbody.At_Field;
	Associate_img = msgbody.AM_Image;
    Duration_Type = msgbody.Ac_Type;
	Content_desc  = msgbody.Ac_Desc;

    //let's add the contents of the message into the div with an id of 'note_container'
    $('#tempdiv').append('<br/>Course_id: <strong>'+course_id+'<br/>Content_Name: <strong>'+note_title+'</strong><br>Content_description: '+note_description+'<br/>Assoctag_Field: '+Coursetag_Field+'<br/>Associate_img : '+Associate_img+'<br/>Content_Type : '+Duration_Type+'<br/>Content_Desc : '+Content_desc);

}


function noteSuccessCallbackassoccontent2(data){
	
    //this is the function we wanted the ziksana message framework to call when the ajax response is a success.
    //data will contain the data recieved by the server.
    //we know that this data contains the note 'title', 'description' & 'duration'. So, extract it.
	course_id  = data.id;
    note_title = data.title;
    note_description = data.description;
	Coursetag_Field = data.At_Field;
	Associate_img = data.AM_Image;
    Duration_Type = data.Ac_Type;
	Content_desc  = data.Ac_Desc;
	
    //let's add the contents of the message into the div with an id of 'note_container'
    $('#tempdiv').append('<br/>Course_id: <strong>'+course_id+'<br/>Content_Name: <strong>'+note_title+'</strong><br>Content_description: '+note_description+'<br/>Assoctag_Field: '+Coursetag_Field+'<br/>Associate_img : '+Associate_img+'<br/>Content_Type : '+Duration_Type+'<br/>Content_Desc : '+Content_desc);
}

