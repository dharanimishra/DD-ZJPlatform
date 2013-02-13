// JavaScript Document

$(document)
		.ready(
				function(e) {

					course_id = $('#courseid').val();
					if (course_id != '' & course_id != null) {
						$('#Editcoursedtl1').show();
					} else {
						$('#Editcoursedtl1').hide();
					}

					$.get('/ziksana-web/secure/getSubjectArea', {}, function(
							data) {
						options = data;
						var option_string = '';
						// option_string += '<option value="Select Subject
						// Area">Select Subject Area</option>';

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
															// option_string +=
															// '<option
															// value="Select
															// Subject">Select
															// Subject</option>';
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
															// option_string +=
															// '<option
															// value="Select
															// Topic">Select
															// Topic</option>';
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

function createCourse() {

	validation = jQuery("#DegineCourse").validationEngine('validate');
	if (validation == true) {
		// Step 1: Assign Parameters required by the sendMessage function.
		uri = '/ziksana-web/secure/saveCourse';

		token = ''; // dummy token for demo. you have to send real token.
		request_type = 'POST'; // can be GET or POST. In this case, a GET
		// request

		var Course_id = $('#courseid').val();

		var Course_Name = $('#defaultvalue').val();

		var Course_Description;
		var Course_Descriptions;
		var Course_Descriptionrte;

		Course_Description = $('#Cdescription').val();
		// alert("Course_Description :"+Course_Description);

		if (Course_Description.length > 0) {
			Course_Descriptions = Course_Description;
			//alert("Course_Descriptions :" + Course_Descriptions);
		} else {
			Course_Descriptionrte = CKEDITOR.instances['Cdescriptionrte']
					.getData();
			Course_Descriptions = Course_Descriptionrte;
			//alert("Course_Descriptions :" + Course_Descriptions);
		}

		// if (CKEDITOR.instances['Cdescriptionrte'] == undefined) {
		//
		// //Course_Description = $('#Cdescription').val();
		// //alert("Course_Description :" + Course_Description);
		//
		// } else {
		// Course_Descriptionrte = CKEDITOR.instances['Cdescriptionrte']
		// .getData();
		// }

		// var Course_Descriptions = Course_Description + Course_Descriptionrte;
		var Subject_Area = $('#Careaddl').val();

		var Subject = $('#Csubjectddl').val();

		var Topic = $('#Ctopicddl').val();

		var Coursetag_Field = $('#Ctagfield_e').val();

		console.log(Coursetag_Field);

		var Course_Credits = $('#Credits').val();

		var Extra_Credits = $('#ExtraCredits').val();

		var Course_Duration = $('#Duration').val();

		var Duration_Type = $('#Cdurationtype').val();

		var Assoc_Image = $('#Cimageupl').val();

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
								window.location.href = "/ziksana-web/secure/createmodule/"
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

	// validation = jQuery("#DegineCourse").validationEngine('validate');
	// if(validation == true){
	// Step 1: Assign Parameters required by the sendMessage function.
	uri = '/ziksana-web/secure/getCourse';

	token = ''; // dummy token for demo. you have to send real token.
	request_type = 'POST'; // can be GET or POST. In this case, a GET request

	var Course_id = $('#courseid').val();

	var parameters = {
		"Course_id" : Course_id
	};

	var available_tags, selected_tags;

	$.post(uri, parameters, function(data) {
		console.log(data);
		if (data.response == 'success') {
			course_id = data.id;
			course_name = data.coursename;
			course_desc = data.coursedesc;
			subject_area = data.subjectarea;
			subject = data.subject;
			topic = data.topic;
			// tag_field = data.tagfield;
			selected_tags = data.selected_tags.split(',');
			available_tags = data.available_tags.split(',');
			credits = data.credits;
			extra_credits = data.extracredits;
			duration = data.duration;
			duration_type = data.durationtype;
			image_upload = data.imageupload;

			$('#courseid').val(course_id);

			$('#defaultvalue').val(course_name);

			console.log(course_desc);

			if (course_desc.charAt(0) == '<') {

				$('#Cdescriptionrte').val(course_desc);

				$('#rich_text_editor').click();

			} else {

				$('#Cdescription').val(course_desc);

			}

			/*$('#Ctagfield_e').superblyTagField({
				allowNewTags : true,
				showTagsNumber : 10,
				preset : selected_tags,
				tags : available_tags
			});
			*/

			$('#Ctagfield_e').val(selected_tags);
			
			$('#Credits').val(credits);

			$('#ExtraCredits').val(extra_credits);

			$('#Duration').val(duration);

			$('#Cdurationtype').val(duration_type);

			$('#Cimageupl').val(image_upload);

			// // populate subject area

			$.get('/ziksana-web/secure/getSubjectArea', {}, function(data) {
				options = data;
				var option_string = '';
				// option_string += '<option value="Select Subject Area">Select
				// Subject Area</option>';

				for (i in options) {
					label = options[i].label;
					value = options[i].value;

					option = '<option value="' + value + '">' + label
							+ '</option>';

					option_string += option;
				}
				$('#Careaddl').html(option_string);
				// now select the value already
				// selected by the
				// user
				$('#Careaddl').val(subject_area);

			});

			// // end populating subject area
			// // start populating subject
			token = '';
			request_type = 'GET';
			uri = '/ziksana-web/secure/getSubject';

			$.get(uri, {
				'Course_Area' : subject_area
			}, function(data) {
				options = data;
				var option_string = '';
				// option_string += '<option value="Select Subject">Select
				// Subject</option>';
				for (i in options) {
					label = options[i].label;
					value = options[i].value;

					option = '<option value="' + value + '">' + label
							+ '</option>';

					option_string += option;
				}

				$('#Csubjectddl').html(option_string);
				$('#Csubjectddl').val(subject);
				

			});

			// // end populating subject

			// Start populating topic

			uri = '/ziksana-web/secure/getTopic';
			token = '';
			request_type = 'GET';
			$.get(uri, {
				'Course_Subject' : subject
			}, function(data) {
				options = data;
				var option_string = '';
				// option_string += '<option value="Select Topic">Select
				// Topic</option>';
				for (i in options) {
					label = options[i].label;
					value = options[i].value;

					option = '<option value="' + value + '">' + label
							+ '</option>';

					option_string += option;
				}

				$('#Ctopicddl').html(option_string);
				$('#Ctopicddl').val(topic);

			});
			// end populating topic

		} else {
			$('#tempdiv').html(
					'<span style="color:red;">' + data.message + '</span>');
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
		window.location.href = "/ziksana-web/secure/createmodule/" + course_id;

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