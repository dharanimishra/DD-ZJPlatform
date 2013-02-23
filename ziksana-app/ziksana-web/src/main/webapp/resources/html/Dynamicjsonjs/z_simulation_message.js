// Ziksana Simulation Messages

var ziksanaSimulationMessages = {} //this is the variable that contains all the simulated ziksana message objects


// Example 1
//Constructing a Sample Simulation Ziksana Message object for the uri '/questions/get/' and assigning it to the ziksanaSimulationMessages
// calling sendZiksanaMessage with '/questions/get/' as the uri will return this object

ziksanaSimulationMessages["/questions/get/"] = {
			"ziksana": {
				"header" : {

								"token": 'z2asf234r-09asdf234as799asj2h342as',  //example token
								"responseCode" : "200", //your expected responseCode
								"messageType" : 'getQuestion' //example question

							},
				"body"   : {
								"title": "What is Aggregation?",
								"duration": 450
							}
			}
};


//Example 2
//Constructing a Sample Simulation Ziksana Message object for the uri '/notes/get/' and assigning it to the ziksanaSimulationMessages

ziksanaSimulationMessages["/notes/get/"] = {
			"ziksana": {
				"header" : {

								"token": 'z2asf234r-09asdf234as799asj2h342as',  //example token
								"responseCode" : "200", //your expected responseCode
								"messageType" : 'getQuestion' //example question

							},
				"body"   : {
								"title": "Getting Value of an Input Field",
								"duration": 450,
								"description":"You can get the value of an input field using many ways. If the input element has an id, say 'my_input', you can get its value in jQuery using <code>$('#my_input').val();</code> In regular JavaScript, you can use <code>document.getElementById('my_input').value;</code>"
							}
			}
};

ziksanaSimulationMessages['/note/'] = {
								"title": "Note on Adding Simulated Messages",
								"description":"You can add simulated message objects like this in the 'z_simulated_message.js'. Have a look at the file to see how normal and ziksanaMessage simulation objects are added."	
}

ziksanaSimulationMessages['/ziksana-web/secure/getSubjectArea'] = {
								"title": "Subject Area",
								"description":"Getting Subject Area from Simulator"	
}

ziksanaSimulationMessages['/ziksana-web/secure/getSubject'] = {
								"title": "Subject",
								"description":"Getting Subject from Simulator"	
}

ziksanaSimulationMessages['/ziksana-web/secure/getTopic'] = {
								"title": "Topic",
								"description":"Getting Topic from Simulator"	
}

ziksanaSimulationMessages['/ziksana-web/secure/saveCourse'] = {
								"title": "Save Course",
								"description":"Saving the whole page"	
}
ziksanaSimulationMessages['/ziksana-web/secure/saveAddnlInfo'] = {
								"title": "Save Additional Information",
								"description":"Saving the whole page"	
}
ziksanaSimulationMessages['/ziksana-web/secure/getModuleArea'] = {
								"title": "Save Additional Information",
								"description":"Saving the whole page"	
}
ziksanaSimulationMessages['/ziksana-web/secure/getModule'] = {
								"title": "Save Additional Information",
								"description":"Saving the whole page"	
}
ziksanaSimulationMessages['/ziksana-web/secure/getModuleTopic'] = {
								"title": "Save Additional Information",
								"description":"Saving the whole page"	
}
ziksanaSimulationMessages['/ziksana-web/secure/saveLearningComponent'] = {
								"title": "Save Additional Information",
								"description":"Saving the whole page"	
}
ziksanaSimulationMessages['/ziksana-web/secure/saveQualifier'] = {
								"title": "Save Additional Information",
								"description":"Saving the whole page"	
}
ziksanaSimulationMessages['/ziksana-web/secure/saveorupdatenewplaybook'] = {
								"title": "Save Additional Information",
								"description":"Saving the whole page"	
}
