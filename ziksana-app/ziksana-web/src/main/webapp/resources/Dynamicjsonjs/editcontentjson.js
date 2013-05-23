// JavaScript Document

$(document)
		.ready(
				function(e) {
					$.get('/ziksana-web/zcourse/getsubjectarea', {}, function(
							data) {
						options = data;
						var option_string = '';
						for (i in options) {
							label = options[i].label;
							value = options[i].value;
							if (i == 0) {
								option = '<option selected="selected" value="'
										+ value + '">' + label + '</option>';
							} else
								option = '<option value="' + value + '">'
										+ label + '</option>';

							option_string += option;
						}
						$('#Careaddl').html(option_string);

					});

					// function getSubject() {
					$("#Careaddl")
							.change(
									function(e) {
										token = '';
										request_type = 'GET';
										uri = '/ziksana-web/zcourse/getsubject';

										var Course_Area = '';
										Course_Area = $('#Careaddl').val();
										$
												.get(
														uri,
														{
															'Course_Area' : Course_Area
														},
														function(data) {
															options = data;
															var option_string = '';
															var area_string = '<option selected="selected" value='
																	+ Course_Area
																	+ '>'
																	+ Course_Area
																	+ '</option>';
															option_string += '<option selected="selected" value="Select Subject">Select Subject</option>';
															for (i in options) {
																label = options[i].label;
																value = options[i].value;
																if (i == 0) {
																	option = '<option  value="'
																			+ value
																			+ '">'
																			+ label
																			+ '</option>';
																} else

																	option = '<option value="'
																			+ value
																			+ '">'
																			+ label
																			+ '</option>';

																option_string += option;
															}

															$('#Careaddl')
																	.html(
																			area_string);
															$('#Csubjectddl')
																	.html(
																			option_string);

														});
										var topic = '<option value="Select Topic">Select Topic</option>';
										$('#Ctopicddl').html(topic);
									});

					// function getTopic() {

					$("#Csubjectddl")
							.change(
									function(e) {
										console
												.log("Inside subject change handler");
										uri = '/ziksana-web/zcourse/gettopic';
										token = '';
										request_type = 'GET';
										var Course_Subject = $('#Csubjectddl')
												.val();
										var parameters = {
											"Course_Subject" : Course_Subject
										};

										$
												.get(
														uri,
														{
															'Course_Subject' : Course_Subject
														},
														function(data) {
															options = data;
															var option_string = '';
															option_string += '<option selected="selected" value="Select Topic">Select Topic</option>';
															for (i in options) {
																label = options[i].label;
																value = options[i].value;
																if (i == 0) {
																	option = '<option value="'
																			+ value
																			+ '">'
																			+ label
																			+ '</option>';
																} else

																	option = '<option value="'
																			+ value
																			+ '">'
																			+ label
																			+ '</option>';

																option_string += option;
															}

															$('#Ctopicddl')
																	.html(
																			option_string);

														});

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
		console.log(data);

	});

}
