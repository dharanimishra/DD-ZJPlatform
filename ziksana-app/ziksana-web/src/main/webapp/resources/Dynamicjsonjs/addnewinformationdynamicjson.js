// JavaScript Document
$(document).ready(function(e) {
	var type;
});

function constructNoteformnumerictextdate() {
	// Get the data from the text and input field.
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

function getaddnewinfosave() {
	type = document.getElementById('Caddnewinfotype').value;
	if (type == "Numeric") {
		// This function demonstrates how to send a message using sendMessage()
		// function. This does not use Ziksana Message format for communication.
		// The communicaiton is direct.

		// Step 1: Assign Parameters required by the sendMessage function.
		uri = '/ziksana-web/secure/saveAddnlInfo'; // this is a demo uri which
		// will return a hardcoded
		// data when simulation is
		// on.

		token = ''; // dummy token for demo. you have to send real token.

		request_type = 'GET'; // can be GET or POST. In this case, a GET
		// request

		var new_Info = $("#Caddnewinfolblname").val();
		var info_Descriptionnumeric = $('#Caddnewinfonumeric').val();
		var info_Descriptiondate = $('#Caddnewinfodate').val();
		var info_Descriptiontext = $('#Caddnewinfotext').val();

		var parameters = {
			"new_Info" : new_Info,
			"info_Description" : info_Descriptionnumeric,
			"info_Descriptiondate" : info_Descriptiondate,
			"info_Des criptiontext" : info_Descriptiontext

		};

		successCallback = noteSuccessCallback2num;

		errorCallback = commonErrorCallback;

		// Step 2: Send Message Using sendMessage(); function.
		sendMessage(uri, token, parameters, request_type, successCallback,
				errorCallback);

	} else if (type == "Date") {
		// Step 1: Assign Parameters required by the sendMessage function.
		uri = '/ziksana-web/secure/saveAddnlInfo'; // this is a demo uri which

		token = ''; // dummy token for demo. you have to send real token.

		request_type = 'GET'; // can be GET or POST. In this case, a GET
		// request

		var parameters = {
			"new_Info" : Caddnewinfolblname,
			"info_Description" : Caddnewinfodate
		};

		constructNoteformnumerictextdate();
		successCallback = noteSuccessCallback2dat;

		errorCallback = commonErrorCallback;

		// Step 2: Send Message Using sendMessage(); function.
		sendMessage(uri, token, parameters, request_type, successCallback,
				errorCallback);

	} else if (type == "Text") {

		// Step 1: Assign Parameters required by the sendMessage function.
		uri = '/ziksana-web/secure/saveAddnlInfo';

		token = '';

		request_type = 'GET';
		var parameters = {
			"new_Info" : Caddnewinfolblname,
			"info_Description" : Caddnewinfotext
		};

		constructNoteformnumerictextdate();
		successCallback = noteSuccessCallback2txt;
		errorCallback = commonErrorCallback;

		// Step 2: Send Message Using sendMessage(); function.
		sendMessage(uri, token, parameters, request_type, successCallback,
				errorCallback);

	}
}

function noteSuccessCallbacknum(data) {
	var msgbody = parseZiksanaMessage(data);

	new_info = msgbody.Newinfo;
	newinfo_Desc = msgbody.Descnumeric;
	$('#tempdiv').append(
			'New_Info: <strong>' + new_info + '</strong><br>Info_description: '
					+ newinfo_Desc);
}

function noteSuccessCallbackdat(data) {
	var msgbody = parseZiksanaMessage(data);

	new_info = msgbody.Newinfo;
	newinfo_Desc = msgbody.Descdate;
	$('#tempdiv').append(
			'New_Info: <strong>' + new_info + '</strong><br>Info_description: '
					+ newinfo_Desc);
}

function noteSuccessCallbacktxt(data) {
	var msgbody = parseZiksanaMessage(data);
	new_info = msgbody.Newinfo;
	newinfo_Desc = msgbody.Desctext;
	$('#tempdiv').append(
			'New_Info: <strong>' + new_info + '</strong><br>Info_description: '
					+ newinfo_Desc);
}

function noteSuccessCallback2num(data) {
	new_info = data.Newinfo;
	newinfo_Desc = data.Descnumeric;
	$('#tempdiv').append(
			'New_Info: <strong>' + new_info
					+ '</strong><br/>Info_description: ' + newinfo_Desc);
}
function noteSuccessCallback2dat(data) {
	new_info = data.Newinfo;
	newinfo_Desc = data.Descdate;
	$('#tempdiv').append(
			'New_Info: <strong>' + new_info
					+ '</strong><br/>Info_description: ' + newinfo_Desc);
}
function noteSuccessCallback2txt(data) {
	new_info = data.Newinfo;
	newinfo_Desc = data.Desctext;
	$('#tempdiv').append(
			'New_Info: <strong>' + new_info
					+ '</strong><br/>Info_description: ' + newinfo_Desc);
}
