// JavaScript Document
var counter = 0;
// var id = "Root";
function onButtonClick(menuitemId, type) {

	var menuaction = menuitemId;

	if (menuaction == "Add_Module") {
		// alert("open the menu for add module.");
		$('#Viewmodulecontainer').hide();
		$('#instruction').hide();
		$('#searchassociatecontainer').hide();
		$('#DegineCourse2').hide();
		$('#definequalifiercontainer').hide();
		$('#Addmodulecontainer').show();
		document.getElementById('AddModule').reset();
		document.getElementById("contentname").focus();
		$("#Btnsbtcmodule").click(
				function(event) {
					var d = new Date();
					tree.insertNewChild(tree.getSelectedItemId(), d.valueOf(),
							document.getElementById('Cmoduletxtbox').value, 0,
							0, 0, 0, 'SELECT');
					fixImage(d.valueOf());
					tree.refreshItem(tree.getSelectedItemId());
				});
	} else if (menuaction == "Search_Add_Module") {
		// alert("open the menu for Search_Add_Module module.");
		$('#Viewmodulecontainer').hide();
		$('#instruction').hide();
		$('#DegineCourse2').hide();
		$('#definequalifiercontainer').hide();
		$('#Addmodulecontainer').hide();
		$('#searchassociatecontainer').show();
	} else if (menuaction == "Define_Qualifiers") {
		// alert("open the menu for Define_Qualifiers module.");
		$('#Viewmodulecontainer').hide();
		$('#instruction').hide();
		$('#searchassociatecontainer').hide();
		$('#DegineCourse2').hide();
		$('#Addmodulecontainer').hide();
		$('#definequalifiercontainer').show();
	} else if (menuaction == "ModuleEdit") {
		$('#Viewmodulecontainer').hide();
		$('#instruction').hide();
		$('#searchassociatecontainer').hide();
		$('#DegineCourse2').hide();
		$('#Addmodulecontainer').show();

		ComponentId = tree.getSelectedItemId();
		nodeParentId = tree.getParentId(ComponentId);

		// use ajax to get the added value

		uri = '/ziksana-web/secure/getCourseModule';

		token = ''; // dummy token for demo. you have to send real token.
		request_type = 'POST'; // can be GET or POST. In this case, a GET
		// request

		var Course_id = $('#courseid').val();

		var parameters = {
			"Course_id" : Course_id,
			"Component_id" : ComponentId
		};

		$
				.post(
						uri,
						parameters,
						function(data) {
							console.log(data);
							if (data.response == 'success') {
								courseLearningComponentId = data.courseLearningComponentId;
								learningComponentId = data.learningComponentId;
								module_name = data.modulename;
								module_desc = data.moduledesc;
								subject_area = data.subjectarea;
								subject = data.subject;
								topic = data.topic;
								tag_field = data.tagfield;
								learningObjectIndicator = data.learningObjectIndicator;
								prescribedLCDuration = data.prescribedLCDuration;
								prescribedLCDurationUnit = data.prescribedLCDurationUnit;
								image_upload = data.imageupload;

								$('#courseid').val(Course_id);

								$('#courseLearningComponentId').val(
										courseLearningComponentId);

								$('#learningComponentId').val(
										learningComponentId);

								$('#Cmoduletxtbox').val(module_name);

								if (module_desc.charAt(0) == '<') {

									$('#Cmoduledescrte').val(module_desc);

									$('#addmodulerichedit').click();

								} else {

									$('#Cmoduledesc').val(module_desc);

								}
								$('#Addmoduletag1').val(tag_field);
								if (learningObjectIndicator == true) {
									$('#addmodulecheckbox').attr('checked',
											true);
									$('#saveassociateobject').show();
								} else {
									$('#addmodulecheckbox').attr('checked',
											false);
									$('#saveassociateobject').hide();
								}

								$('#Cmoduleduration').val(prescribedLCDuration);

								$('#Cmoduleunits')
										.val(prescribedLCDurationUnit);

								// $('#Cimageupl').val(image_upload);

								// // populate subject area

								$.get('/ziksana-web/secure/getSubjectArea', {},
										function(data) {
											options = data;
											var option_string = '';
											// option_string += '<option
											// value="Select Subject
											// Area">Select Subject
											// Area</option>';

											for (i in options) {
												label = options[i].label;
												value = options[i].value;
												option = '<option value="'
														+ value + '">' + label
														+ '</option>';

												option_string += option;
											}
											$('#Cmoduleareaddl').html(
													option_string);

											$('#Cmoduleareaddl').val(
													subject_area);

										});

								token = '';
								request_type = 'GET';
								uri = '/ziksana-web/secure/getSubject';

								$.get(uri, {
									'Course_Area' : subject_area
								},
										function(data) {
											options = data;
											var option_string = '';
											// option_string += '<option
											// value="Select
											// Subject">Select
											// Subject</option>';
											for (i in options) {
												label = options[i].label;
												value = options[i].value;
												option = '<option value="'
														+ value + '">' + label
														+ '</option>';

												option_string += option;
											}

											$('#Cmodulesubjectddl').html(
													option_string);
											$('#Cmodulesubjectddl')
													.val(subject);

										});

								uri = '/ziksana-web/secure/getTopic';
								token = '';
								request_type = 'GET';
								$.get(uri, {
									'Course_Subject' : subject
								}, function(data) {
									options = data;
									var option_string = '';
									// option_string += '<option
									// value="Select
									// Topic">Select
									// Topic</option>';
									for (i in options) {
										label = options[i].label;
										value = options[i].value;

										option = '<option value="' + value
												+ '">' + label + '</option>';

										option_string += option;
									}

									$('#Cmoduletopicddl').html(option_string);
									$('#Cmoduletopicddl').val(topic);

								});
								// end populating topic

							} else {
								$('#tempdiv1').html(
										'<span style="color:red;">'
												+ data.message + '</span>');
							}

						});

		// }//end of validation if block

	} else if (menuaction == "CourseEdit") {
		// alert("open the menu for CourseEdit module.");
		var CourseId = $('#courseid').val();
		$('#courseid').val(CourseId);
		window.location.href = "/ziksana-web/secure/editcourse/" + CourseId;
	} else if (menuaction == "View") {
		// alert("open the menu for View module.");
		$('#instruction').hide();
		$('#searchassociatecontainer').hide();
		$('#DegineCourse2').hide();
		$('#definequalifiercontainer').hide();
		$('#Addmodulecontainer').hide();
		$('#Viewmodulecontainer').show();
	} else if (menuaction == "Delete") {
		// alert("open the menu for Delete module.");

		ComponentId = tree.getSelectedItemId();
		console.log(ComponentId);
		uri = '/ziksana-web/secure/removeCourseComponents';

		token = ''; // dummy token for demo. you have to send real token.
		request_type = 'POST'; // can be GET or POST. In this case, a GET
		// request

		var CourseId = $('#courseid').val();

		var parameters = {
			"Course_id" : CourseId,
			"Component_id" : ComponentId
		};

		$.post(uri, parameters,
				function(data) {
					console.log(data);
					if (data.response == 'success') {
						course_id = data.id;
					} else {
						$('#tempdiv').html(
								'<span style="color:red;">' + data.message
										+ '</span>');
					}

				});
		tree.deleteItem(tree.getSelectedItemId(), true);

	}
}

function fixImage(id) {
	switch (tree.getLevel(id)) {
	case 1:
		;
		tree.setItemImage2(id, 'folderClosed.gif', 'folderOpen.gif',
				'folderClosed.gif');
		break;
	default:
		;
		tree.setItemImage2(id, "notesIcon.png", "notesIcon.png",
				"notesIcon.png");
		break;
	}
}

function createtree(course_id) {

	if (course_id == '' || course_id == null) {
		return false;
	}

	menu = new dhtmlXMenuObject();
	menu
			.setIconsPath("/ziksana-web/resources/js/ziksana/jquerylibrary/tree/treeimages/images/");
	menu.renderAsContextMenu();
	menu.attachEvent("onClick", onButtonClick);
	menu
			.loadXML("/ziksana-web/resources/js/ziksana/jquerylibrary/tree/xml/_context.xml");

	tree = new dhtmlXTreeObject("treeboxbox_tree", "100%", "100%", 0);
	tree.setSkin('dhx_skyblue');
	tree
			.setImagePath("/ziksana-web/resources/js/ziksana/jquerylibrary/tree/treeimages/csh_bluebooks/");
	tree._getOpenState(true);
	tree.enableDragAndDrop(true);
	tree.enableTreeLines(true);

	tree.enableContextMenu(menu);
	tree.attachEvent("onAfterContextMenu", getMenu);
	function getMenu(id) {
		menu.clearAll();
		menu.loadXML("xml/menu_" + id.split(":")[0] + ".xml");
		// alert(menu.loadXML("xml/menu_" + id.split(":")[0] + ".xml"));
		return true;
	}

	tree.attachEvent("onBeforeContextMenu", function(itemId) {
		// alert(id);
		// tree._selected();

		node_type = itemId.split('_')[0];
		// console.log(node_type);

		if (node_type == "COURSE") {
			$('#courseid').val(itemId);
		}

		if (node_type == "COMPONENT") {
			$('#courseLearningComponentId').val(itemId);
		}

		tree.selectItem(itemId, false);
		var id = tree.getSelectedItemId();
		// alert(id);

		// tree.selectItem(id,true);
		if (node_type == "COURSE") {
			menu.showItem('Add_Module');
			menu.hideItem('Delete');
			menu.showItem('CourseEdit');
			menu.hideItem('ModuleEdit');
		}

		if (node_type == "COMPONENT") {
			menu.showItem('Add_Module');
			menu.showItem('ModuleEdit');
			menu.hideItem('CourseEdit');
			menu.showItem('Delete');
			// menu.showItem('View');
		}
		return true;
	});

	tree.setImageArrays("plus", "plus_ar.png", "plus_ar.png", "plus_ar.png",
			"plus_ar.png", "plus_ar.png");
	tree.setImageArrays("minus", "minus_ar.png", "minus_ar.png",
			"minus_ar.png", "minus_ar.png", "minus_ar.png");

	courseId = course_id.split('_')[1];
	tree.loadXML("/ziksana-web/secure/getparenttree/" + courseId);

}

$(document).ready(
		function(e) {
			var id = null;
			createtree($('#courseid').val());

			$("#sbtvalidation").click(
					function(event) {
						var im0 = "tree.png"; // the icon for a leaf node
						var im1 = "tree.png"; // the icon for an expanded
						// parent node
						var im2 = "tree.png";
						// tree.insertNewChild(tree.getSelectedItemId()||0,(new
						// Date()).valueOf(),'New item')

						tree.insertNewItem('0', 'Root', document
								.getElementById('defaultvalue').value, 1, im0,
								im1, im2, 'SELECT,TOP');
						// tree.deleteItem("dummy",true);

					});
		});
