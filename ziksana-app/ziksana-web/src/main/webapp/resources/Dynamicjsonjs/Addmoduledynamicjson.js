// JavaScript Document
$(document)
		.ready(
				function(e) {
					var course_id = $('#courseid').val();
					$
							.post(
									'/ziksana-web/zcourse/getsubclassification',
									{
										'CourseId' : course_id
									},
									function(data) {
										//console.log(data);
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
															$('#Cmoduleareaddl')
																	.html(
																			option_string);
															$('#Cmoduleareaddl').select2("val",subject_area_pre);
															//console.log("subject area is: "+ subject_area_pre);

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

															$('#Cmodulesubjectddl').html(option_string);
															$('#Cmodulesubjectddl').select2("val",subject_pre);
															//console.log("subject_pre is: "+ subject_pre);
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
															$('#Cmoduletopicddl').html(option_string);
															$('#Cmoduletopicddl').select2("val",topic_pre);
															//console.log("topic_pre is: "+ topic_pre);

														});

										// End

									});

					$("#Cmoduleareaddl")
							.change(
									function(e) {
										token = '';
										request_type = 'GET';
										uri = '/ziksana-web/zcourse/getsubject';
										var Course_Area = $('#Cmoduleareaddl')
												.val();

										$
												.get(
														uri,
														{
															'Course_Area' : Course_Area
														},
														function(data) {
															options = data;
															var option_string = '';
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

															$('#Cmodulesubjectddl').html(option_string);
															var topic = '<option value="Select Topic">Select Topic</option>';
															$('#Cmoduletopicddl').html(topic);

														});

									});

					$("#Cmodulesubjectddl").change(
							function(e) {
								uri = '/ziksana-web/zcourse/gettopic';
								token = '';
								request_type = 'GET';

								var Course_Subject = $('#Cmodulesubjectddl')
										.val();

								$.get(uri, {
									'Course_Subject' : Course_Subject
								}, function(data) {
									options = data;
									var option_string = '';
									for (i in options) {
										label = options[i].label;
										value = options[i].value;
										if (i == 0) {
											option = '<option  value="' + value
													+ '">' + label
													+ '</option>';
										} else
											option = '<option value="' + value
													+ '">' + label
													+ '</option>';

										option_string += option;
									}

									$('#Cmoduletopicddl').html(option_string);

								});

							});

					$("#Cmoduletopicddl").change(function(e) {

						uri = '/ziksana-web/zcourse/gettopic';
						token = '';
						request_type = 'GET';

						var Course_Topic = $('#Cmoduletopicddl').val();
						var parameters = {
							"Course_Topic" : Course_Topic
						};

					});

				});

function getaddmodulesave() {

	validation = jQuery("#AddModule").validationEngine('validate');
	if (validation == true) {
		// Step 1: Assign Parameters required by the sendMessage function.
		$('#Btnsbtcmodule').attr('disabled', 'disabled'); // disables the

		uri = '/ziksana-web/zcourse/savelearningcomponent';

		token = ''; // dummy token for demo. you have to send real token.

		request_type = 'POST'; // can be GET or POST. In this case, a GET

		var Course_Descriptionrte = '';

		var course_id = $('#courseid').val();

		var CourseLearningComponentId = $('#courseLearningComponentId').val();

		var ParentLearningComponentId = $('#parentLearningComponentId').val();

		var learningComponentId = $('#learningComponentId').val();

		var Module_Name = $('#Course_Module').val();

		Course_Descriptionrte = CKEDITOR.instances['Cmoduledescrte'].getData();
		Module_Description = Course_Descriptionrte;

		var Subject_Area = $('#Cmoduleareaddl').val();
		var Subject = $('#Cmodulesubjectddl').val();
		var Topic = $('#Cmoduletopicddl').val();
		var Moduletag_Field = $('#Addmoduletag').val();
		var Assoc_Image = $('#Cimageupl').val();

		var parameters = {
			"Course_id" : course_id,
			"CourseLearningComponentId" : CourseLearningComponentId,
			"ParentLearningComponentId" : ParentLearningComponentId,
			"LearningComponentId" : learningComponentId,
			"Course_Module" : Module_Name,
			"Module_Description" : Module_Description,
			"Subject_Area" : Subject_Area,
			"Subject" : Subject,
			"Topic" : Topic,
			"Moduletag_Field" : Moduletag_Field,
			"Assoc_Image" : Assoc_Image

		};

		$.post(uri, parameters, function(data) {
			//console.log(data);
			if (data.response == 'success') {
				course_id = data.id;
				$('#courseid').val(course_id);
				if (course_id != '' & course_id != null) {
					$('#courseid').val(course_id);
					window.location.href = "/ziksana-web/zcourse/createmodule/"
							+ course_id;
					$('#tempdiv1').html(
							'<span style="color:red;">' + data.message
									+ '</span>');
				} else {
					$('#tempdiv1').html(
							'<span style="color:red;">' + data.message
									+ '</span>');
				}
			}
		});
	} else {
		
	}
}

function noteSuccessCallbackaddmodule(data) {
	// parse ziksanaMessageObject to extract the body of the message.
	var msgbody = parseZiksanaMessage(data);
	course_id = msgbody.id;
	note_title = msgbody.title;
	note_description = msgbody.description;
	Coursetag_Field = msgbody.Mt_Field;
	Course_Credits = msgbody.Mcredits;
	Course_Duration = msgbody.MDuration;
	Duration_Type = msgbody.DM_Type;
	Associate_img = msgbody.AM_Image;

	// let's add the contents of the message into the div with an id of
	// 'note_container'

	$('#tempdiv2').append(
			'Course_id: <strong>' + course_id + '<br/>Module_Name: <strong>'
					+ note_title + '</strong><br>Module_description: '
					+ note_description + '<br/><br/>Moduletag_Field: '
					+ Coursetag_Field + 'Module_Credits : ' + Course_Credits
					+ '<br>Module_Duration ' + Course_Duration
					+ '<br/>Duration Type : ' + Duration_Type
					+ '<br/>Associate_img : ' + Associate_img);

}

function onSuccessfulModuleCreation(data) {
	course_id = data.id;
	if (course_id != '' || course_id != null) {
		window.location.href = window.location.href;
	}

}

function getSaveandContinue() {

	var course_id = $('#courseid').val();
	var courseId = course_id.split('_')[1];
	
	//console.log("courseId :"+courseId);
	if (courseId != '' || courseId != null) {
		window.location.href = '/ziksana-web/zcourse/1/repositorycontents/'+ courseId;
	} else {
		window.location.href = '/ziksana-web/zcourse/createcourse';
	}

}

function getCancel() {

	var course_id = $('#courseid').val();
	var courseId = course_id.split('_')[1];
	if (courseId != '' || courseId != null) {
		window.location.href = "/ziksana-web/zcourse/createmodule/" + course_id;
	} else {
		window.location.href = "/ziksana-web/zcourse/createcourse";
	}

}