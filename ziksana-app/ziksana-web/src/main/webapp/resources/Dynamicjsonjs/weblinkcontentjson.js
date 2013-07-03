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
						$('select.Careaddl').select2("destroy");
						$('select.Careaddl').html(option_string).select2();

					});

					// function getSubject() {
					$("select.Careaddl")
							.change(
									function(e) {
										edit_content_info_container = $(this)
												.parents('.addweblink');
										token = '';
										request_type = 'GET';
										uri = '/ziksana-web/zcourse/getsubject';

										var Course_Area = '';
										Course_Area = edit_content_info_container
												.find('select.Careaddl').val();
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

															edit_content_info_container.find('select.Careaddl').select2("destroy").html(area_string).select2();
															edit_content_info_container.find('select.Csubjectddl').select2("destroy").html(option_string).select2();

														});
										var topic = '<option value="Select Topic">Select Topic</option>';
										edit_content_info_container.find('select.Ctopicddl').select2("destroy").html(topic).select2();
									});

					// function getTopic() {

					$("select.Csubjectddl")
							.change(
									function(e) {
										edit_content_info_container = $(this)
												.parents('.addweblink');
										console
												.log("Inside subject change handler");
										uri = '/ziksana-web/zcourse/gettopic';
										token = '';
										request_type = 'GET';
										var Course_Subject = edit_content_info_container
												.find('select.Csubjectddl')
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
															edit_content_info_container.find('select.Ctopicddl').select2("destroy").html(option_string).select2();

														});

									});
				});


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