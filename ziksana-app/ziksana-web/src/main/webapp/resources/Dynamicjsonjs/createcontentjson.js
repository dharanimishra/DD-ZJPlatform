// JavaScript Document

function createContent() {

	// Step 1: Assign Parameters required by the sendMessage function.
	uri = '/ziksana-web/zcourse/1/createcontents';

	token = ''; // dummy token for demo. you have to send real token.
	request_type = 'POST'; // can be GET or POST. In this case, a GET request

	var ContentName = $('#ContentName').val();

	var ContentPath = $('#Cimageupl').val();

	var ThumbnailPicturePath = $('#ThumbnailPicturePath').val();

	var NumberOfThumbnails = $('#NumberOfThumbnails').val();

	var ContentType = $('#ContentType').val();

	console.log("ContentType :" + ContentType);

	var parameters = {
		"ContentName" : ContentName,
		"ContentPath" : ContentPath,
		"ThumbnailPicturePath" : ThumbnailPicturePath,
		"NumberOfThumbnails" : NumberOfThumbnails,
		"ContentType" : ContentType,

	};

	$.post(uri, parameters, function(data) {
		console.log(data);

	});

}
