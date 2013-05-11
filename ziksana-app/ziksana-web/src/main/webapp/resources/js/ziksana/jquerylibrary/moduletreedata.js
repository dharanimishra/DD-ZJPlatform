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
		$('#searchassociatecontainer').hide();
	} else if (menuaction == "Define_Qualifiers") {
		// alert("open the menu for Define_Qualifiers module.");
		$('#Viewmodulecontainer').hide();
		$('#instruction').hide();
		$('#searchassociatecontainer').hide();
		$('#DegineCourse2').hide();
		$('#Addmodulecontainer').hide();
		$('#definequalifiercontainer').hide();
	} else if (menuaction == "Edit") {
		// alert("open the menu for Edit module.");
		window.location.href = "editmodelthinking.html";
	} else if (menuaction == "RootView") {
		// alert("open the menu for Edit module.");
		window.location.href = "viewmodelthinking.html";
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
		tree.deleteItem(tree.getSelectedItemId(), true);
	}
	// tree.setItemColor(id, menuitemId.split("_")[1]);
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
		if (node_type = "COMPONENT") {
			$('#courseLearningComponentId').val(itemId);
		}
		console.log(itemId);

		tree.selectItem(itemId, false);
		var id = tree.getSelectedItemId();
		// alert(id);

		// tree.selectItem(id,true);
		if (node_type == "COURSE") {
			// alert(tree.contextID);
			menu.hideItem('Delete');
			menu.hideItem('View');
			menu.showItem('RootView');
			menu.showItem('CourseEdit');

		} else {
			// alert(tree.contextID);
			menu.hideItem('RootView');
			menu.showItem('Delete');
			menu.showItem('View');
		}
		return true;
	});

	tree.setImageArrays("plus", "plus_ar.png", "plus_ar.png", "plus_ar.png",
			"plus_ar.png", "plus_ar.png");
	tree.setImageArrays("minus", "minus_ar.png", "minus_ar.png",
			"minus_ar.png", "minus_ar.png", "minus_ar.png");

	courseId = course_id.split('_')[1];
	tree.loadXML("/ziksana-web/zcourse/getparenttree/" + courseId);

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
