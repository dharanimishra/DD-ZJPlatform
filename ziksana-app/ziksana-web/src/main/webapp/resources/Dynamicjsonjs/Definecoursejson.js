// JavaScript Document

Course_ID = "";

$(document)
		.ready(
				function(e) {
					var course_id = $('#courseid').val();
					if (course_id != "") {
						getCourse();
						$
								.post(
										'/ziksana-web/zcourse/getsubclassification',
										{
											'CourseId' : course_id
										},
										function(data) {
											console.log(data);
											var subClassificationId = data.subjClassificationId;
											var subject_area_pre = data.subjectArea;
											var subject_pre = data.subjectCategory;
											var topic_pre = data.subjectTopic;

											// Start

											$
													.get(
															'/ziksana-web/zcourse/getsubjectarea',
															{},
															function(data) {
																options = data;
																var option_string = '';
																for (i in options) {
																	label = options[i].label;
																	value = options[i].value;

																	if (value == subject_area) {
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
																$('#Careaddl')
																		.html(
																				option_string);
																$('#Careaddl')
																		.select2(
																				"val",
																				subject_area);
																console
																		.log("subject area is: "
																				+ subject_area);

															});

											token = '';
											request_type = 'GET';
											uri = '/ziksana-web/zcourse/getsubject';

											$
													.get(
															uri,
															{
																'Course_Area' : subject_area
															},
															function(data) {
																options = data;
																var option_string = '';
																option_string += '<option value="Select Subject">Select Subject</option>';
																for (i in options) {
																	label = options[i].label;
																	value = options[i].value;
																	if (value == subject) {
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

																$(
																		'#Csubjectddl')
																		.html(
																				option_string);
																$(
																		'#Csubjectddl')
																		.select2(
																				"val",
																				subject);
																console
																		.log("subject_pre is: "
																				+ subject);
															});

											uri = '/ziksana-web/zcourse/gettopic';
											token = '';
											request_type = 'GET';
											$
													.get(
															uri,
															{
																'Course_Subject' : subject
															},
															function(data) {
																options = data;
																var option_string = '';
																option_string += '<option value="Select Topic">Select Topic</option>';
																for (i in options) {
																	label = options[i].label;
																	value = options[i].value;
																	if (value == topic) {
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
																$('#Ctopicddl')
																		.html(
																				option_string);
																$('#Ctopicddl')
																		.select2(
																				"val",
																				topic);
																console
																		.log("topic_pre is: "
																				+ topic);

															});

											// End

										});

					} else {
						$
								.get(
										'/ziksana-web/zcourse/getsubjectarea',
										{},
										function(data) {
											options = data;
											var option_string = '';
											for (i in options) {
												label = options[i].label;
												value = options[i].value;
												if (i == 0) {
													option = '<option selected="selected" value="'
															+ value
															+ '">'
															+ label
															+ '</option>';
												} else
													option = '<option value="'
															+ value + '">'
															+ label
															+ '</option>';

												option_string += option;
											}
											$('#Careaddl').html(option_string);
											console.log("Careaddl is: "
													+ option_string);

										});
					}
					// Function for Subject Area drop down list on change of a
					// value
					$("#Careaddl")
							.change(
									function(e) {
										token = '';
										request_type = 'GET';
										uri = '/ziksana-web/zcourse/getsubject';
										var Course_Area = $('#Careaddl').val();

										$
												.get(
														uri,
														{
															'Course_Area' : Course_Area
														},
														function(data) {
															options = data;
															var option_string = '';
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

															$('#Csubjectddl')
																	.html(
																			option_string);

														});
										var topic = '<option value="Select Topic">Select Topic</option>';
										$('#Ctopicddl').html(topic);
									});

					// /Function for Course subject drop down list on change of
					// a value
					$("#Csubjectddl")
							.change(
									function(e) {
										// alert ("Inside subject change
										// handler");

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

					$("#Ctopicddl").change(function(e) {

						uri = '/ziksana-web/zcourse/gettopic';
						token = '';
						request_type = 'GET';

						var Course_Topic = $('#Ctopicddl').val();
						var parameters = {
							"Course_Topic" : Course_Topic
						};

					});
				});

function createCourse() {

	validation = jQuery("#DegineCourse").validationEngine('validate');
	if (validation == true) {
		// Step 1: Assign Parameters required by the sendMessage function.
		uri = '/ziksana-web/zcourse/savecourse';

		token = ''; // dummy token for demo. you have to send real token.
		request_type = 'POST'; // can be GET or POST. In this case, a GET
		// request

		var Course_id = $('#courseid').val();

		console.log("Course_id :" + Course_id);

		var Course_Name = $('#defaultvalue').val();

		var Course_Descriptions;
		var Course_Descriptionrte;

		Course_Descriptionrte = CKEDITOR.instances['Cdescriptionrte'].getData();
		Course_Descriptions = Course_Descriptionrte;

		var Subject_Area = $('#Careaddl').val();

		var Subject = $('#Csubjectddl').val();

		var Topic = $('#Ctopicddl').val();

		var Coursetag_Field = $('#Ctagfield_course').val();

		console.log(Coursetag_Field);

		var Course_Credits = $('#spinner1').val();

		var Extra_Credits = $('#spinner2').val();

		var Course_Duration = $('#spinner3').val();

		var Duration_Type = $('#Cdurationtype').val();

		var Assoc_Image = $('#Cimageupl').val();

		console.log('Assoc_Image ..' + Assoc_Image);

		var parameters = {
			"Course_id" : Course_id,
			"Course_Name" : Course_Name,
			"Course_Description" : Course_Descriptions,
			"Subject_Area" : Subject_Area,
			"Subject" : Subject,
			"Topic" : Topic,
			"Coursetag_Field" : Coursetag_Field,
			"Course_Credits" : Course_Credits,
			"Extra_Credits" : Extra_Credits,
			"Course_Duration" : Course_Duration,
			"Duration_Type" : Duration_Type,
			"Assoc_Image" : Assoc_Image
		};

		$
				.post(
						uri,
						parameters,
						function(data) {
							console.log(data);
							if (data.response == 'success') {
								course_id = data.id;
								$('#courseid').val(course_id);
								window.location.href = "/ziksana-web/zcourse/createmodule/"
										+ course_id;

							} else {
								$('#tempdiv1').html(
										'<span style="color:red;">'
												+ data.message + '</span>');
							}

						});

	}// end of validation if block

}

function getCourse() {
	// course contains module is exists
	var Course_id = $('#courseid').val();

	// $.ajax({
	// type : 'GET',
	// url : '/ziksana-web/zcourse/ismoduleexists/' + Course_id + '',
	// success : function(data) {
	// $('#moduleExists').val(data);
	//
	// }
	// });
	// validation = jQuery("#DegineCourse").validationEngine('validate');
	// if(validation == true){
	// Step 1: Assign Parameters required by the sendMessage function.
	uri = '/ziksana-web/zcourse/getcourse';

	token = ''; // dummy token for demo. you have to send real token.
	request_type = 'POST'; // can be GET or POST. In this case, a GET request

	var parameters = {
		"Course_id" : Course_id
	};
	if (Course_id != '') {
		$('#sbtvalidation').attr('value', 'Done');
	}
	var available_tags, selected_tags;

	$
			.post(
					uri,
					parameters,
					function(data) {
						console.log(data);
						if (data.response == 'success') {
							course_id = data.id;
							//$('#courseid').val(course_id);
							course_name = data.coursename;
							course_desc = data.coursedesc;
							subject_area = data.subjectarea;
							subject = data.subject;
							topic = data.topic;
							tag_field = data.tagfield;
							selected_tags = data.selected_tags.split(',');
							available_tags = data.selected_tags.split(',');
							credits = data.credits;
							extra_credits = data.extracredits;
							duration = data.duration;
							duration_type = data.durationtype;
							image_upload = data.imageupload;

							if (image_upload == '') {
								thumbnail_url = '/ziksana-web/resources/images/preview/defaultcourse.png';
							} else {
								thumbnail_url = media_server_url + image_upload;
							}
							$('#course_thumbnail_image').attr('src',
									thumbnail_url);
							$('#thubmnail_upload_message')
									.html(
											'<a onclick="remove_uploaded_thumbnail();" title="Remove Image" class="remove" style="margin-left:20px">Remove</a>');

							//$('#courseid').val(course_id);

							$('#defaultvalue').val(course_name);

							$('#Cdescriptionrte').val(course_desc);

							$('#Ctagfield_course').val(selected_tags);

							$('#spinner1').val(credits);

							$('#spinner2').val(extra_credits);

							$('#spinner3').val(duration);

							// $('#Cdurationtype').val(duration_type);

							$('#Cimageupl').val(image_upload);

							// // populate subject area

						} else {
							$('#tempdiv').html(
									'<span style="color:red;">' + data.message
											+ '</span>');
						}

					});

	// }//end of validation if block

}

function noteSuccessCallback(data) {

	var msgbody = parseZiksanaMessage(data);
	course_id = msgbody.id;
	note_title = msgbody.title;
	note_description = msgbody.description;
	Coursetag_Field = msgbody.Ct_Field;
	Course_Credits = msgbody.Credits;
	Extra_Credits = msgbody.E_Credits;
	Course_Duration = msgbody.Duration;
	Duration_Type = msgbody.D_Type;
	Course_Area = msgbody.C_Area;
	Course_Subject = msgbody.C_Subject;
	Course_Topic = msgbody.C_Topic;

}

function onSuccessfulCourseCreation(data) {
	if (data.response == 'success') {
		course_id = data.id;
		$('#courseid').val(course_id);
		window.location.href = "/ziksana-web/zcourse/createmodule/" + course_id;

	} else {
		$('#tempdiv1').html(
				'<span style="color:red;">' + data.message + '</span>');
	}

	function plainText() {
		$('#Cdescription').val('');
	}
	function richText() {
		$('#Cdescription').val('');
	}
}

function populate_tag_cloud(selected_tags, available_tags) {
	$("#Ctagfield_e").superblyTagField({
		allowNewTags : true,
		showTagsNumber : 10,
		preset : selected_tags,
		tags : available_tags
	});
}