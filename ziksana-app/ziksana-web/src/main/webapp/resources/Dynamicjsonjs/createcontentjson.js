// JavaScript Document

function createContent() {

	// Step 1: Assign Parameters required by the sendMessage function.
	uri = '/ziksana-web/zcourse/1/createcontents';

	token = ''; // dummy token for demo. you have to send real token.
	request_type = 'POST'; // can be GET or POST. In this case, a GET request

	var parameters = $('form#multiple_content_upload').serialize();

	$.post(uri, parameters, function(data) {
		//console.log(data);
		window.location.href = "/ziksana-web/zcourse/1/editcontent";

	});

}

function cancelContent() {

	window.location.href = "/ziksana-web/zcourse/1/createcontent";

}
