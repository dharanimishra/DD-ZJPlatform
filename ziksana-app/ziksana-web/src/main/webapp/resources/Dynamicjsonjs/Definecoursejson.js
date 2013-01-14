// JavaScript Document

$(document)
		.ready(
				function(e) {

					$
							.get(
									'/ziksana-web/secure/getSubjectArea',
									{},
									function(data) {
										options = data;
										var option_string = '';
										option_string += '<option value="">Select Course Area</option>';

										for (i in options) {
											label = options[i].label;
											value = options[i].value;

											option = '<option value="' + value
													+ '">' + label
													+ '</option>';

											option_string += option;
										}
										$('#Careaddl').html(option_string);

									});

					// Function for Subject Area drop down list on change of a
					// value
					$("#Careaddl")
							.change(
									function(e) {
										token = '';
										request_type = 'GET';
										uri = '/ziksana-web/secure/getSubject';
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
															option_string += '<option value="">Select Course Subject</option>';
															for (i in options) {
																label = options[i].label;
																value = options[i].value;

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

					// /Function for Course subject drop down list on change of
					// a value
					$("#Csubjectddl")
							.change(
									function(e) {
										// alert ("Inside subject change
										// handler");

										uri = '/ziksana-web/secure/getTopic';
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
															option_string += '<option value="">Select Course Topic</option>';
															for (i in options) {
																label = options[i].label;
																value = options[i].value;

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

					function noteSuccessCallbackcoursesubject(data) {

						var msgbody = parseZiksanaMessage(data);
						Course_Subject = msgbody.C_Subject
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
					$("#Ctopicddl").change(function(e) {

						uri = '/ziksana-web/secure/getTopic';
						token = '';
						request_type = 'GET';

						var Course_Topic = $('#Ctopicddl').val();
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

					$("#Cimageupl").mouseout(function(e) {

						uri = '/ziksana-web/secure/uploadFile';
						token = '';
						request_type = 'POST';
						var Assoc_Image = $('#Cimageupl').val();
						var parameters = {
							"Assoc_Image" : Assoc_Image
						};

						successCallback = noteSuccessCallbackimgupl2;

						errorCallback = commonErrorCallback;
					});

					function noteSuccessCallbackimgupl(data) {

						var msgbody = parseZiksanaMessage(data);
						Assoc_Image = msgbody.A_Image;
						// let's add the contents of the message into the div
						// with an id of 'note_container'
						$('#tempdiv').append(
								'Assoc Image: <strong>' + Assoc_Image
										+ '</strong><br/>');

					}

					function noteSuccessCallbackimgupl2(data) {
						Assoc_Image = data.A_Image;
						$('#tempdiv').append(
								'Assoc Image: <strong>' + Assoc_Image
										+ '</strong><br/>');
					}

				});

function getdefinecoursesave() {

	// Step 1: Assign Parameters required by the sendMessage function.
	uri = '/ziksana-web/secure/saveCourse';

	token = ''; // dummy token for demo. you have to send real token.
	request_type = 'GET'; // can be GET or POST. In this case, a GET request

	var Course_id = $('#courseid').val();

	var Course_Name = $('#defaultvalue').val();

	var Course_Description = $('#Cdescription').val();

	var Subject_Area = $('#Careaddl').val();

	var Subject = $('#Csubjectddl').val();

	var Topic = $('#Ctopicddl').val();

	var Coursetag_Field = $('#Ctagfield').val();

	var Course_Credits = $('#Credits').val();

	var Extra_Credits = $('#ExtraCredits').val();

	var Course_Duration = $('#Duration').val();

	var Duration_Type = $('#Cdurationtype').val();

	var Assoc_Image = $('#Cimageupl').val();

	var parameters = {
		"Course_id" : Course_id,
		"Course_Name" : Course_Name,
		"Course_Description" : Course_Description,
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

	successCallback = onSuccessfulCourseCreation;

	errorCallback = commonErrorCallback;

	// Step 2: Send Message Using sendMessage(); function.
	sendMessage(uri, token, parameters, request_type, successCallback,
			errorCallback);

	//alert("Course Request Sended..");

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

	// Set course id to the hiddden field returned from the server
	$('#tempdiv').append(
			'Course_Id: <strong>' + course_id
					+ '</strong><br>Course_Name: <strong>' + note_title
					+ '</strong><br>Course_description: ' + note_description
					+ '<br/><br/>Coursetag_Field: ' + Coursetag_Field
					+ 'Course_Credits : ' + Course_Credits
					+ ' Extra_Credits: <strong>' + Extra_Credits
					+ '</strong><br>Course_Duration ' + Course_Duration
					+ '<br/>Duration Type : ' + Duration_Type + '<br/>');
}

function onSuccessfulCourseCreation(data) {
	course_id = data.id;
	window.location.href = "/ziksana-web/secure/createmodule/" + course_id;
}
