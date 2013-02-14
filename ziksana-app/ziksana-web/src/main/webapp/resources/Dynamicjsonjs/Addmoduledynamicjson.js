// JavaScript Document
$(document)
		.ready(
				function(e) {

					var course_id = $('#courseid').val();
					console.log(course_id);
					var subjectArea = '', subjectCategory = '', subjectTopic = '';
					var subClassificationId = 0;
					$.post('/ziksana-web/secure/getSubClassification', {
						'CourseId' : course_id
					}, function(data) {
						console.log(data);
						subClassificationId = data.subjClassificationId;
						var subArea = data.subjectArea;
						var subCategory = data.subjectCategory;
						var subTopic = data.subjectTopic;

						subjectArea = '<option selected="selected" value="'
								+ subArea + '">' + subArea + '</option>';
						subjectCategory = '<option selected="selected" value="'
								+ subCategory + '">' + subCategory
								+ '</option>';
						subjectTopic = '<option selected="selected" value="'
								+ subTopic + '">' + subTopic + '</option>';

					});

					$.get('/ziksana-web/secure/getSubjectArea', {}, function(
							data) {
						options = data;
						var option_string = '';
						if (subClassificationId > 0) {
							option_string += subjectArea;
						}
						for (i in options) {
							label = options[i].label;
							value = options[i].value;
							if (i == 0) {
								option = '<option value="' + value + '">'
										+ label + '</option>';
							} else
								option = '<option value="' + value + '">'
										+ label + '</option>';

							option_string += option;
						}
						$('#Cmoduleareaddl').html(option_string);
						if (subClassificationId > 0) {
							$('#Cmodulesubjectddl').html(subjectCategory);
							$('#Cmoduletopicddl').html(subjectTopic);
						}

					});

					$("#Cmoduleareaddl")
							.change(
									function(e) {
										token = '';
										request_type = 'GET';
										uri = '/ziksana-web/secure/getSubject';
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

															$(
																	'#Cmodulesubjectddl')
																	.html(
																			option_string);

															var topic = '<option value="Select Topic">Select Topic</option>';
															$(
																	'#Cmoduletopicddl')
																	.html(topic);

														});

									});

					function noteSuccessCallbackcoursearea(data) {

						var msgbody = parseZiksanaMessage(data);
						Course_Area = msgbody.C_Area;
						$('#tempdiv').append(
								'Course_Area: <strong>' + Course_Area
										+ '</strong><br/>');

					}

					function noteSuccessCallbackcoursearea2(data) {

						Course_Area = data.C_Area;

						$('#tempdiv').append(
								'Course_Area: <strong>' + Course_Area
										+ '</strong><br/>');
					}

					$("#Cmodulesubjectddl")
							.change(
									function(e) {
										uri = '/ziksana-web/secure/getTopic';
										token = '';
										request_type = 'GET';

										var Course_Subject = $(
												'#Cmodulesubjectddl').val();

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

															$(
																	'#Cmoduletopicddl')
																	.html(
																			option_string);

														});

									});

					function noteSuccessCallbackcoursesubject(data) {

						var msgbody = parseZiksanaMessage(data);
						Course_Subject = msgbody.C_Subject;
						$('#tempdiv').append(
								'Course Subject: <strong>' + Course_Subject
										+ '</strong><br/>');

					}

					function noteSuccessCallbackcoursesubject2(data) {
						Course_Subject = data.C_Subject;
						$('#tempdiv').append(
								'Course Subject: <strong>' + Course_Subject
										+ '</strong><br/>');
					}
					$("#Cmoduletopicddl").change(function(e) {

						uri = '/ziksana-web/secure/getTopic';
						token = '';
						request_type = 'GET';

						var Course_Topic = $('#Cmoduletopicddl').val();
						var parameters = {
							"Course_Topic" : Course_Topic
						};

					});

					function noteSuccessCallbackcoursetopic(data) {
						var msgbody = parseZiksanaMessage(data);
						Course_Topic = msgbody.C_Topic;
						// let's add the contents of the message into the div
						// with an id of 'note_container'
						$('#tempdiv').append(
								'Course Topic: <strong>' + Course_Topic
										+ '</strong><br/>');

					}

					function noteSuccessCallbackcoursetopic2(data) {
						Course_Topic = data.C_Topic;
						$('#tempdiv').append(
								'Course Topic: <strong>' + Course_Topic
										+ '</strong><br/>');
					}

				});

function getaddmodulesave() {

	validation = jQuery("#AddModule").validationEngine('validate');
	if (validation == true) {
		// Step 1: Assign Parameters required by the sendMessage function.
		$('#Btnsbtcmodule').attr('disabled', 'disabled'); // disables the

		uri = '/ziksana-web/secure/saveLearningComponent';

		token = ''; // dummy token for demo. you have to send real token.

		request_type = 'POST'; // can be GET or POST. In this case, a GET

		var Learning_Object = 0;

		var course_id = $('#courseid').val();

		var CourseLearningComponentId = $('#courseLearningComponentId').val();

		var learningComponentId = $('#learningComponentId').val();

		var Module_Name = $('#Cmoduletxtbox').val();
		var Module_Description;

		if (CKEDITOR.instances['Cmoduledescrte'] == undefined) {
			Module_Description = $('#Cmoduledesc').val();
		} else {
			Module_Description = CKEDITOR.instances['Cmoduledescrte'].getData();
		}
		var valid = $('#addmodulecheckbox').is(':checked');
		if (valid == true) {
			Learning_Object = 1;
		} else {
			Learning_Object = 0;
		}

		var Subject_Area = $('#Cmoduleareaddl').val();
		var Subject = $('#Cmodulesubjectddl').val();
		var Topic = $('#Cmoduletopicddl').val();
		var Moduletag_Field = $('#Addmoduletag1').val();
		var Module_Weight = $('#Cmoduleweight').val();
		var Module_Duration = $('#Cmoduleduration').val();
		var ModuleDuration_Type = $('#Cmoduleunits').val();
		var Assoc_Image = $('#Cmoduleimgupl').val();

		var parameters = {
			"Course_id" : course_id,
			"CourseLearningComponentId" : CourseLearningComponentId,
			"LearningComponentId" : learningComponentId,
			"Course_Module" : Module_Name,
			"Module_Description" : Module_Description,
			"Subject_Area" : Subject_Area,
			"Subject" : Subject,
			"Topic" : Topic,
			"Moduletag_Field" : Moduletag_Field,
			"Learning_Object":Learning_Object,
			"Module_Weight" : Module_Weight,
			"Module_Duration" : Module_Duration,
			"ModuleDuration_Type" : ModuleDuration_Type,
			"Assoc_Image" : Assoc_Image
		};

		$.post(uri, parameters, function(data) {
			console.log(data);
			if (data.response == 'success') {
				course_id = data.id;
				$('#courseid').val(course_id);
				if (course_id != '' & course_id != null) {
					$('#courseid').val(course_id);
					window.location.href = "/ziksana-web/secure/createmodule/"
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
	if (course_id != '' & course_id != null) {
		window.location.href = window.location.href;
	}

}