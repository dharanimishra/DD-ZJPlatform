$(function() {
	var mediaserver_url = '';
	var mediaserver_uploadscript = '';
	var mediaserver_uploadcontent = '';

	$.get("/ziksana-web/getmediacontents", function(data) {

		console.log(data);
		mediaserver_url = data.url.toString();
		mediaserver_uploadscript = data.uploadScript.toString();
		mediaserver_uploadcontent = data.uploadContent.toString();
		console.log(mediaserver_url);
		console.log(mediaserver_uploadscript);
		console.log(mediaserver_uploadcontent);

	});
});// end document ready
function fnCheckExt(fileName) {
	var file = $("#imgultype").val();
	var strExtn = file.substr(fileName.value.lastIndexOf(".") + 1, file.length);
	strExtn.toLowerCase();
	extimg = strExtn;
}

var counter = 0;
// var id = "Root";
function onButtonClick(menuitemId, type) {

	// alert("Right click menu action");
	// alert();
	// var id2 = tree.contextID;
	// alert(id2);
	// alert(id);
	// alert(menuitemId);
	// tree.focusItem(tree.contextID);
	// tree.selectItem(tree.contextID,true);
	// menumanipulation(itemId);
	var menuaction = menuitemId;

	// menumanipulation(itemId);
	if (menuaction == "Associate_Content") {
		// alert("open the menu for add module.");
		$('#instruction').hide();
		$('#Associatecontentsearch').hide();
		$('#associatedefinecontainer').show();

		$("#btnsbtassoccontent").click(
				function(e) {
					// alert(extimg);
					var im0 = "notesIcon.png"; // the icon for a leaf node
					var im1 = "notesIcon.png"; // the icon for an expanded
					// parent node
					var im2 = "notesIcon.png";

					// alert();
					// var file = document.getElementById('imgultype').value;
					// alert(file);
					// var strExtn =
					// file.substr(fileName.value.lastIndexOf(".")+1,file.length);
					// alert(strExtn);

					var typ = document.getElementById('q_type').value;
					// alert(typ);
					if (typ == "Upload Content") {
						if (extimg == "pdf" || extimg == "pdfx") {
							im0 = "pdf.png"; // the icon for a leaf node
							im1 = "pdf.png"; // the icon for an expanded
							// parent node
							im2 = "pdf.png";
							var d = new Date();
							tree.insertNewChild(tree.getSelectedItemId(), d
									.valueOf(), document
									.getElementById('contentname').value, 0,
									im0, im1, im2, 'SELECT');
							tree.smartRefreshItem(0);
						} else if (extimg == "jpg" || extimg == "jpeg"
								|| extimg == "png" || extimg == "gif"
								|| extimg == "tif" || extimg == "bmp") {
							im0 = "img.png"; // the icon for a leaf node
							im1 = "img.png"; // the icon for an expanded
							// parent node
							im2 = "img.png";
							var d = new Date();
							tree.insertNewChild(tree.getSelectedItemId(), d
									.valueOf(), document
									.getElementById('contentname').value, 0,
									im0, im1, im2, 'SELECT');
							tree.smartRefreshItem(0);
						} else if (extimg == "mp4" || extimg == "avi"
								|| extimg == "divx" || extimg == "mpg"
								|| extimg == "mpeg" || extimg == "flv"
								|| extimg == "wmv" || extimg == "swf") {
							im0 = "video.png"; // the icon for a leaf node
							im1 = "video.png"; // the icon for an expanded
							// parent node
							im2 = "video.png";
							var d = new Date();
							tree.insertNewChild(tree.getSelectedItemId(), d
									.valueOf(), document
									.getElementById('contentname').value, 0,
									im0, im1, im2, 'SELECT');
							tree.smartRefreshItem(0);
						} else if (extimg == "ppt" || extimg == "pptx"
								|| extimg == "pps") {
							im0 = "ppt.png"; // the icon for a leaf node
							im1 = "ppt.png"; // the icon for an expanded
							// parent node
							im2 = "ppt.png";
							var d = new Date();
							tree.insertNewChild(tree.getSelectedItemId(), d
									.valueOf(), document
									.getElementById('contentname').value, 0,
									im0, im1, im2, 'SELECT');
							tree.smartRefreshItem(0);
						} else if (extimg == "doc" || extimg == "docx"
								|| extimg == "rtf" || extimg == "wps") {
							im0 = "word.png"; // the icon for a leaf node
							im1 = "word.png"; // the icon for an expanded
							// parent node
							im2 = "word.png";
							var d = new Date();
							tree.insertNewChild(tree.getSelectedItemId(), d
									.valueOf(), document
									.getElementById('contentname').value, 0,
									im0, im1, im2, 'SELECT');
							tree.smartRefreshItem(0);
						} else if (extimg == "xls" || extimg == "xlsx"
								|| extimg == "xlr") {
							im0 = "excel.png"; // the icon for a leaf node
							im1 = "excel.png"; // the icon for an expanded
							// parent node
							im2 = "excel.png";
							var d = new Date();
							tree.insertNewChild(tree.getSelectedItemId(), d
									.valueOf(), document
									.getElementById('contentname').value, 0,
									im0, im1, im2, 'SELECT');
							tree.smartRefreshItem(0);
						}
					} else if (typ == "External WebPage") {
						im0 = "link.png"; // the icon for a leaf node
						im1 = "link.png"; // the icon for an expanded parent
						// node
						im2 = "link.png";
						var d = new Date();
						tree.insertNewChild(tree.getSelectedItemId(), d
								.valueOf(), document
								.getElementById('contentname').value, 0, im0,
								im1, im2, 'SELECT');
						tree.smartRefreshItem(0);
					} else {
						im0 = "notesIcon.png"; // the icon for a leaf node
						im1 = "notesIcon.png"; // the icon for an expanded
						// parent node
						im2 = "notesIcon.png";
						var d = new Date();
						tree.insertNewChild(tree.getSelectedItemId(), d
								.valueOf(), document
								.getElementById('contentname').value, 0, im0,
								im1, im2, 'SELECT');
						tree.smartRefreshItem(0);
					}

				});

	} else if (menuaction == "Enrich") {

		content_id = tree.getSelectedItemId();
		parsed_content_id = content_id.split('_')[1];
		component_id = tree.getParentId(content_id);
		parsed_component_id = component_id.split('_')[1];
		console.log('Component Id is: ' + component_id);
		parsed_course_id = $('#courseid').val().split('_')[1];

		// begin enhance menu logic

		console.log("HI content id is: " + content_id);

		var node_id = tree.getSelectedItemId();

		node_type = node_id.split('_')[0];
		content_type_id = node_id.split('_')[2];
		
		console.log("content_type_id in player :"+content_type_id);

		if (node_type == "CONTENT") {
			// content_id = node_id.split('_')[3];
			// component_id = node_id.split('_')[2];
			// content_type_id = node_id.split('_')[1];

			if (content_type_id == 1) {// video -- 1

				course_id = $('#courseId').val();
				$('#ContentPanel').empty();
				$('#ContentPanel')
						.append(
								'<iframe src="/ziksana-web/subscription/enrichplayer/'
										+ parsed_course_id
										+ '/'
										+ parsed_component_id
										+ '/'
										+ parsed_content_id
										+ '" style="width:705px; height:600px;" scrolling="no"></iframe>');

			} else if (content_type_id == 11) {// Enhanced video -- 11

				course_id = $('#courseId').val();
				$('#ContentPanel').empty();
				$('#ContentPanel')
						.append(
								'<iframe src="/ziksana-web/subscription/ev_enrichplayer/'
										+ parsed_course_id
										+ '/'
										+ parsed_component_id
										+ '/'
										+ parsed_content_id
										+ '" style="width:800px; height:700px;" scrolling="no"></iframe>');

			} else {
				$('#ContentPanel').empty();

			}

		}
		// end enhance menu logic

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
			.loadXML("/ziksana-web/resources/js/ziksana/jquerylibrary/tree/xml/_contextenrich.xml");

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
		console.log(itemId);

		node_type = itemId.split('_')[0];
		content_type = itemId.split('_')[2];
		console.log("contenttype: " + content_type);
		
		if (node_type == "COURSE") {
			$('#courseid').val(itemId);
		}

		if (node_type == "COMPONENT") {
			$('#learningComponentId').val(itemId);
		}

		if (node_type == "CONTENT") {
			$('#learningContentId').val(itemId);
		}

		tree.selectItem(itemId, false);
		var id = tree.getSelectedItemId();
		// var content_type =
		// tree.getAttribute(tree.getSelectedItemId(),"contenttype");
		// alert(content_type);
		var instr = id.indexOf("Child");
		// alert(instr);
		var txt = tree.getItemText(tree.getSelectedItemId());
		// alert(txt);
		// alert(id);
		// alert(id);

		// tree.selectItem(id,true);

		if (node_type == "COURSE") {
			// alert(tree.contextID);
			menu.hideItem('Delete');
			menu.hideItem('View');
			menu.hideItem('Edit');
			menu.hideItem('Enhance');
			menu.hideItem('Enrich');
			menu.hideItem('Associate_Content');
			menu.hideItem('Search_Associate_Content');

		}

		if (node_type == "COMPONENT") {
			// alert(tree.contextID);
			menu.hideItem('Delete');
			menu.hideItem('View');
			menu.hideItem('Edit');
			menu.hideItem('Enhance');
			menu.hideItem('Enrich');
			menu.hideItem('Associate_Content');
			menu.hideItem('Search_Associate_Content');

		}
		if (node_type == "CONTENT") {
			// alert(tree.contextID);
			menu.hideItem('Associate_Content');
			menu.hideItem('Search_Associate_Content');
			menu.hideItem('Delete');
			menu.hideItem('View');
			menu.hideItem('Edit');
			menu.hideItem('Enhance');
			if (content_type != '1' && content_type != '11') {
				return false;
			} else { // 1-video and // 11-Enhanced video
				menu.showItem('Enrich');
				console.log("Enrich enter :" + content_type);
			}
		}
		return true;
	});

	tree.setImageArrays("plus", "plus_ar.png", "plus_ar.png", "plus_ar.png",
			"plus_ar.png", "plus_ar.png");
	tree.setImageArrays("minus", "minus_ar.png", "minus_ar.png",
			"minus_ar.png", "minus_ar.png", "minus_ar.png");
	// tree.loadXML("/ziksana-web/resources/js/ziksana/jquerylibrary/tree/xml/treemodel.xml");
	// tree.loadXML("/ziksana-web/zcourse/getchildtree/150");
	courseId = course_id.split('_')[1];
	tree.loadXML("/ziksana-web/zcourse/getenrichtree/" + courseId);

}

$(document).ready(
		function(e) {
			var id = null;
			var extimg = null;
			createtree($('#courseid').val());
			function createnode() {

				var im0 = "tree.png"; // the icon for a leaf node
				var im1 = "tree.png"; // the icon for an expanded parent node
				var im2 = "tree.png";
				// tree.insertNewChild(tree.getSelectedItemId()||0,(new
				// Date()).valueOf(),'New item')

				tree.insertNewItem('0', 'Root', document
						.getElementById('defaultvalue').value, 0, im0, im1,
						im2, 'SELECT,TOP');

				// tree.deleteItem("dummy",true);
				// tree.smartRefreshItem(0);
			}
		});