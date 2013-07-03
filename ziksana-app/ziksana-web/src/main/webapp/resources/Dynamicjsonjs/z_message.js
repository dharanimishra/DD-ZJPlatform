// Script Name: z_message
// Ziksana Message Framework
// Author: Arun Prasad. R (VTG)
// Script Dependencies: jQuery Library > v1.5 to be loaded before this script in the page.



var SIMULATION = false; // Set SIMULATION to false in case in a production environment. 
var SIMULATION_ERROR_CODE = 0; // The header error code that will be sent back by the simulator in its response ziksan_message. Set SIMULATION_ERROR_CODE as appropriate to trigger a specific simulation response. When set to '0', simulation code from the simulation response will always be 0.
var ASYNC_AJAX = true; //should be true by default.



// LEGEND
// PARAMETER_NAME [DATA TYPE] - DESCRIPTION

// uri [String] - The uri to which the post is performed.
// controllerName [String] -the controller name
// token [String] - the token string. Set an empty string if token is not available. 
// parameters [Object] - A java script object with all the parameters required by your controller. Ex: myParameters = {"Param1":"value1", "Param2","value2"}
// messageType [String]
// requestType [String] - The type of ajax request. Usually one of the two 'GET' or 'POST' in Uppercase.

//successCallback [Function] - A function to be called if the request succeeds. The success callback will be passed the 'data' that contains the data returned by the request.

//errorCallback [Function] - A function to be called if the request fails. The function receives three arguments: Example: yourErrorCallbackFunction(jqXHR, textStatus, errorThrown); The jqXHR object, a string describing the type of error that occurred and an optional exception object, if one occurred. Possible values for the second argument (besides null) are "timeout", "error", "abort", and "parsererror". When an HTTP error occurs, errorThrown receives the textual portion of the HTTP status, such as "Not Found" or "Internal Server Error." 


//returns the body of the message or the exception object
function sendZiksanaMessage(uri, token, messageType, parameters, requestType, successCallback, errorCallback){

	send_xml_message = false; //to be implemented.

	validateParameters(parameters); //validate parameters
	
	// Construct the Request Ziksana Message Object
	ziksanaMessage = {
		"ziksana": {
			"header" : {

							"token": token
							//"messageType" : messageType
						},
			"body"   : {
							"parameters": parameters
						}
		}
	};


	if (SIMULATION == true){ //if simulation is set to true (On), then simulate the ajax reqeust instead.
		_simulateAjax(uri, ziksanaMessage, SIMULATION_ERROR_CODE, requestType, successCallback, errorCallback);
	} else {
		_processAjax(uri, ziksanaMessage, requestType, successCallback, errorCallback); //process the ajax request with the ziksana message.
	}


	///// Private Methods
	// processess the ajax request
	function _processAjax(uri, ziksanaMessage, requestType, successCallback, errorCallback){
		

		$.ajax({
	                async: ASYNC_AJAX,
	                url: uri,
	                //dataType: 'json',
	                type: requestType.toUpperCase(),
	                data: ziksanaMessage,
	                success: function(data, textStatus, jqXHR) {

						if (typeof successCallback === 'function') {
						        // successCallback is executable
	                        	successCallback(data);
						}

	                },
	                error: function(jqXHR, textStatus, errorThrown){
	           	
						if (typeof errorCallback === 'function') {
						        // errorCallback is executable
	                        	errorCallback(jqXHR, textStatus, errorThrown);
						}
	                }

	        });



}

	function _simulateAjax(uri, ziksanaMessage, SIMULATION_ERROR_CODE, requestType){

		// to be implemented.
		// should return a ziksana message object with appropriate error code
		// Construct the Ziksana Message Object
		defaultSimulatedZiksanaMessage = {
			"ziksana": {
				"header" : {

								"token": 'token',
								"responseCode" : SIMULATION_ERROR_CODE,
								"messageType" : ziksanaMessage.ziksana.header.messageType

							},
				"body"   : {
								"message": "simulation successful"
							}
			}
		};

		var generatedZiksanaMessageObject;

		if(ziksanaSimulationMessages[uri] != null){ //if the uri matches any key in the hardcoded ziksanaSimulationMessages, return the ziksanMessage object

			hardcodedZiksanaMessage = ziksanaSimulationMessages[uri];
			hardcodedZiksanaMessage.ziksana.header.responseCode = SIMULATION_ERROR_CODE;


			generatedZiksanaMessageObject = hardcodedZiksanaMessage;

		} else {

			generatedZiksanaMessageObject = defaultSimulatedZiksanaMessage;
		}

		//Trigger the Success Callback function and pass the ziksana message object
		if (typeof successCallback === 'function') {
	        // successCallback is executable
        	successCallback(generatedZiksanaMessageObject);
		}

	}


	///// End of Private Methods

} //End of sendZiksanaMessage




// parses the ziksanaMessage object and returns the data
function parseZiksanaMessage(ziksanaMessage){

		// In case if header.responseCode is non-zero and header.messageType is "error"
		if(ziksanaMessage.ziksana.header.responseCode != 0 && ziksanaMessage.ziksana.header.messageType == 'error'){
			//extract exception from the body

			exception = {
				"code"           : ziksanaMessage.ziksana.body.exception.code, 
				"severity"       : ziksanaMessage.ziksana.body.exception.severity,
				"user_message"   : ziksanaMessage.ziksana.body.exception.user_message,
				"system_message" : ziksanaMessage.ziksana.body.exception.system_message
			}

			exception_message = 'There was an error: /n';
			exception_message += 'Code: ' + exception.code;
			exception_message += 'Severity: ' + exception.severity;
			exception_message += 'User Message: ' + exception.user_message;
			exception_message += 'System Message: ' + exception.system_message;

			alert(exception_message); //notify the exception
		
		} else { 

			return ziksanaMessage.ziksana.body; //return the body of the ziksana message to the caller.
		}

}


// validates the ziksanaMessage object and throws exception if invalid
function validateZiksanaMessage(ziksanaMessage){

	return true;
	//validation logic to be implemented.
	//sends back error object containing the error if invalid.

}


// wrapper function for a regular ajax call. Returns the response from the server. No ziksana message here.
function sendMessage(uri, token, parameters, requestType, successCallback, errorCallback){

   // alert("Inside sendMessage");
	if(SIMULATION == true){

		if(ziksanaSimulationMessages[uri] != null){ //if the uri matches any key in the hardcoded ziksanaSimulationMessages, return the value that matches the key
			hardcodedReturnMessage = ziksanaSimulationMessages[uri];

			//Trigger the Success Callback function and pass the hardcodedReturnMessage
			if (typeof successCallback === 'function') {
		        // successCallback is executable
	        	successCallback(hardcodedReturnMessage);
			}
			
		} 


	} else {
		$.ajax({
                async: ASYNC_AJAX,
                url: uri,
                dataType: 'json',
                type: requestType.toUpperCase(),
                data: parameters,
                success: function(data, textStatus, jqXHR) {

					if (typeof successCallback === 'function') {
					        // successCallback is executable
                        	successCallback(data);
					}

                },
                error: function(jqXHR, textStatus, errorThrown){
           	
					if (typeof errorCallback === 'function') {
					        // errorCallback is executable
                        	errorCallback(jqXHR, textStatus, errorThrown);
					}
                }
    	});
	}

}





// returns true if the parameters are valid, else throws an exception.
function validateParameters(parametersObject){
	// to be implemented.
	return true;
}


function testSuccessCallback(data){ alert('The Ajax request was a Success. \n\n You have to provide a custom success callback to further maniuplate the ajax results. Pass the [data] object returned to parseZiksanaMessage() method to extract the contents.');}
function commonErrorCallback(jqXHR, textStatus, errorThrown){
	error_message = 'An error occured with the current request! The server responded with:\n'
 	error_message += '\nStatus Code: '+ jqXHR.status;
 	error_message += '\nStatus Text: '+ jqXHR.statusText;

 	alert(error_message);

}





