
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

	} else if (menuaction == "Search_Associate_Content") {
		// alert("open the menu for Search_Add_Module module.");
		$('#instruction').hide();
		$('#associatedefinecontainer').hide();
		$('#Associatecontentsearch').show();
	} else if (menuaction == "View") {
		content_id = tree.getSelectedItemId();

		$.get('/ziksana-web/secure/content/getContentInfo', {
			'courseId' : $('#courseId').val(),
			'contentId' : content_id
		}, function(data) {

			content_type = (data.contentTypeString).toUpperCase();
			content_url = 'http://54.243.235.88/zikload-xml/uploads'
					+ data.contentUrl;
			content_path = data.contentUrl;

			if (content_type == 'VIDEO') {

				playVideo('/ziksana-web/secure/modalplayer/' + data.contentId);

			}
			
			if (content_type == 'ENHANCED_VIDEO') {

				playEnhancedVideo('/ziksana-web/secure/ev_modalplayer/' + data.contentId);

			}

			if (content_type == 'AUDIO') {

				playAudio('/ziksana-web/secure/modalplayer/' + data.contentId);

			}

			if (content_type == 'PDF' || content_type == 'DOC'

			|| content_type == 'PPT' || content_type == 'IMAGESET'
					|| content_type == 'IMAGE'

					|| content_type == 'EXCEL') {

				// displayImageSet('/ziksana-web/secure/slides/'+data.contentId);
				displayImageSet(content_path);

			}

		});

	} else if (menuaction == "Edit") {
		// /
		$('#associatedefinecontainer').show(); // show the associate container.

		node_id = tree.getSelectedItemId();

		$.post('/ziksana-web/secure/course/editNode', {
			'courseId' : $('#courseId').val(),
			'nodeId' : node_id
		}, function(data) {

			if (data) { // data will have the node content

				// window.location.href = window.location.href;
				$('#content_id').val(data.contentId);
				$('#contentname').val(data.contentName);
				$('.defaultvalue').html('Trignomentry details here');

			}

		});

		// //
	} else if (menuaction == "Delete") {
		// /
		// alert("this should delete the form.");

		node_id = tree.getSelectedItemId();

		$.post('/ziksana-web/secure/course/deleteNode', {
			'courseId' : $('#courseId').val(),
			'nodeId' : node_id
		}, function(data) {

			if (data == 1) { // node is deleted successfully

				window.location.href = window.location.href;

			}

		});

		// //
	} else if (menuaction == "Enhance") {

		content_id = tree.getSelectedItemId();
		parsed_content_id = content_id.split('_')[1];
		component_id = tree.getParentId(content_id);
		parsed_component_id = component_id.split('_')[1];
		console.log('Component Id is: '+ component_id);
		parsed_course_id = $('#courseid').val().split('_')[1];

		$.get('/ziksana-web/secure/content/getContentInfo', {
			'courseId' : $('#courseId').val(),
			'contentId' : content_id
		}, function(data) {

			content_type = (data.contentTypeString).toUpperCase();
			content_url = 'http://54.243.235.88/zikload-xml/uploads'
					+ data.contentUrl;
			content_path = data.contentUrl;

			if (content_type == 'PDF' || content_type == 'DOC'

			|| content_type == 'PPT' || content_type == 'IMAGESET'
					|| content_type == 'IMAGE'

					|| content_type == 'EXCEL') {
				// displayImageSet('/ziksana-web/secure/slides/'+data.contentId);
				displayEnhanceModal("/ziksana-web/secure/enhancePlayer/"
						+ parsed_content_id +'/'+parsed_component_id+'/'+parsed_course_id);

			}

		});

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
			.loadXML("/ziksana-web/resources/js/ziksana/jquerylibrary/tree/xml/_contextassociate.xml");

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
		// alert(id);
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
			menu.showItem('Associate_Content');
			//menu.showItem('Search_Associate_Content');

		}

		if (node_type == "COMPONENT") {
			// alert(tree.contextID);
			menu.hideItem('Delete');
			menu.hideItem('View');
			menu.hideItem('Edit');
			menu.hideItem('Enhance');
			menu.showItem('Associate_Content');
			//menu.showItem('Search_Associate_Content');

		}
		if (node_type == "CONTENT") {
			// alert(tree.contextID);
			menu.hideItem('Associate_Content');
			//menu.hideItem('Search_Associate_Content');
			menu.showItem('Delete');
			menu.showItem('View');
			menu.showItem('Edit');
			menu.showItem('Enhance');
		}
		return true;
	});

	tree.setImageArrays("plus", "plus_ar.png", "plus_ar.png", "plus_ar.png",
			"plus_ar.png", "plus_ar.png");
	tree.setImageArrays("minus", "minus_ar.png", "minus_ar.png",
			"minus_ar.png", "minus_ar.png", "minus_ar.png");
	// tree.loadXML("/ziksana-web/resources/js/ziksana/jquerylibrary/tree/xml/treemodel.xml");
	// tree.loadXML("/ziksana-web/secure/getchildtree/150");
	courseId = course_id.split('_')[1];
	tree.loadXML("/ziksana-web/secure/getchildtree/" + courseId);

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