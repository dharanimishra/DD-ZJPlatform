// JavaScript Document

$(document)
		.ready(
				function(e) {
					
					var content_id = $('#content_id').val();
					console.log("subject classification content_id :"+content_id);
					var subject_area_pre = '';
					var subject_pre = '';
					var topic_pre = '';
					$.post('/ziksana-web/zcourse/getcontentsubclassification',
									{
										'content_id' : content_id
									},
									function(data) {
										//console.log(data);
										var subClassificationId = data.subjClassificationId;
										subject_area_pre = data.subjectArea;
										subject_pre = data.subjectCategory;
										topic_pre = data.subjectTopic;
										console.log("subject_area_pre: "+subject_area_pre);
										console.log("subject_pre: "+subject_pre);
										console.log("topic_pre: "+topic_pre);
										// Start

										$.get('/ziksana-web/zcourse/getsubjectarea',
														{},
														function(data) {
															options = data;
															var option_string = '';
															for (i in options) {
																label = options[i].label;
																value = options[i].value;

																if (value == subject_area_pre) {
																	option = '<option selected="selected" value="'
																			+ value
																			+ '">'
																			+ label
																			+ '</option>';

																} else {
																	option = '<option value="'
																			+ value
																			+ '">'
																			+ label
																			+ '</option>';

																}

																option_string += option;
															}
															$('#Careaddl').html(option_string);
															$('#Careaddl').select2("val",subject_area_pre);
															console.log("subject area is: "+ subject_area_pre);

														});

										token = '';
										request_type = 'GET';
										uri = '/ziksana-web/zcourse/getsubject';

										$
												.get(
														uri,
														{
															'Course_Area' : subject_area_pre
														},
														function(data) {
															options = data;
															var option_string = '';
															option_string += '<option value="Select Subject">Select Subject</option>';
															for (i in options) {
																label = options[i].label;
																value = options[i].value;
																if (value == subject_pre) {
																	option = '<option selected="selected" value="'
																			+ value
																			+ '">'
																			+ label
																			+ '</option>';
																} else {
																	option = '<option value="'
																			+ value
																			+ '">'
																			+ label
																			+ '</option>';
																}

																option_string += option;
															}

															$('#Csubjectddl').html(option_string);
															$('#Csubjectddl').select2("val",subject_pre);
															console.log("subject_pre is: "+ subject_pre);
														});

										uri = '/ziksana-web/zcourse/gettopic';
										token = '';
										request_type = 'GET';
										$
												.get(
														uri,
														{
															'Course_Subject' : subject_pre
														},
														function(data) {
															options = data;
															var option_string = '';
															option_string += '<option value="Select Topic">Select Topic</option>';
															for (i in options) {
																label = options[i].label;
																value = options[i].value;
																if (value == topic_pre) {
																	option = '<option selected="selected" value="'
																			+ value
																			+ '">'
																			+ label
																			+ '</option>';
																} else {
																	option = '<option value="'
																			+ value
																			+ '">'
																			+ label
																			+ '</option>';
																}
																option_string += option;
															}
															$('#Ctopicddl').html(option_string);
															$('#Ctopicddl').select2("val",topic_pre);
															console.log("topic_pre is: "+ topic_pre);

														});

										// End
									

									});
				});

function editContent() {

	// Step 1: Assign Parameters required by the sendMessage function.
	uri = '/ziksana-web/zcourse/1/editcontents';

	token = ''; // dummy token for demo. you have to send real token.
	request_type = 'POST'; // can be GET or POST. In this case, a GET request

	var ContentId = $('#contentId').val();

	var ContentName = $('#EditName').val();

	var ContentDescription = $('#ContentDescription').val();

	var ThumbnailPicturePath = $('#Cimageupl').val();

	var Subject_Area = $('#Careaddl').val();

	var Subject = $('#Csubjectddl').val();

	var Topic = $('#Ctopicddl').val();

	var parameters = {
		"ContentId" : ContentId,
		"ContentName" : ContentName,
		"ContentDescription" : ContentDescription,
		"ThumbnailPicturePath" : ThumbnailPicturePath,
		"Subject_Area" : Subject_Area,
		"Subject" : Subject,
		"Topic" : Topic

	};

	$.post(uri, parameters, function(data) {
		//console.log(data);

	});

}

function deleteContent(content_id) {

	// Checking for Content Association

	uri = '/ziksana-web/zcourse/1/checkcontentassociation';
	var parameters = {
		"contentId" : content_id
	};
	$
			.post(
					uri,
					parameters,
					function(data) {
						//console.log(data);
						if (data.response == 'active') {
							confirm_delete = confirm('This content is associated with a course. Please delink the content with the course to proceed with Delete');
							if (confirm_delete == true) {			
								
							}
						} else {
							confirm_delete = confirm('Are you sure to delete?');
							if (confirm_delete == true) {
								uri = '/ziksana-web/zcourse/1/deletecontent';
								var parameters = {
									"contentId" : content_id
								};
								$.post(uri,parameters,function(data) {
									if (data.response == 'success') {
									console.log("content_content_id"+content_id);
							     	$('#content_'+content_id).remove();
							     	console.log("$('#content_'+content_id).remove() ");
									}
								});

							}
						}

					});

}
