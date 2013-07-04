var counter = 0;
function onButtonClick(menuitemId, type) {
	var menuaction = menuitemId;
	//alert("menuaction " + menuaction);
	if (menuaction == "Add_Module") {
		// alert("open the menu for add module.");
		$('#Viewmodulecontainer').hide();
		$('#instruction').hide();
		$('#searchassociatecontainer').hide();
		$('#DegineCourse2').hide();
		$('#definequalifiercontainer').hide();
		$('#Addmodulecontainer').show();
		document.getElementById('AddModule').reset();
		$("#courseLearningComponentId").remove();
		$("#learningComponentId").remove();
		$("#Btnsbtcmodule").click(
				function(event) {
					var d = new Date();
					tree.insertNewChild(tree.getSelectedItemId(), d.valueOf(),
							document.getElementById('Cmoduletxtbox').value, 0,
							0, 0, 0, 'SELECT');
					fixImage(d.valueOf());
					tree.refreshItem(tree.getSelectedItemId());
				});
	} else if (menuaction == "Search_Associate_Content") {
		//alert("open the menu for Search_Associate_Content module.");
		var courseId = $('#courseid').val();
		componentId = tree.getSelectedItemId();
		var selectedComponentId = document.getElementById('selectedLearningComponentId').value = componentId.split('_')[1];
		//alert("selectedComponentId " + selectedComponentId);
		//TODO following code is commented because right now we are handling the display through hidden parameter but in future we will need to do it at real time
		//alert("selectedComponentId " + selectedComponentId);
/*	
		uri = serverContext + 'zcourse/1/repositorycontents/' + courseId; 
		request_type = 'GET'; // can be GET or POST. In this case, a GET

		var parameters = {
				"courseId" : courseId,
				"componentId" : nodeParentId.split('_')[1]
			};
*/
		getAllLearningContents();
	} else if (menuaction == "View") {
		learningContentId = tree.getSelectedItemId().split('_')[1];
		//console.log("learningContentId First :"+learningContentId);
		var viewer_url = '';
		content_type = getLearningContentObject(learningContentId).contentType.toUpperCase();
		var parentContentId = getLearningContentObject(learningContentId).parentLearningContentId;
		//alert("content_type " + content_type);
		if(parentContentId && parentContentId >0){
			//may be needed later we have a use case where in we have to show the last state of the content if viewed
			//learningContentId = parentContentId;
			
		}
		if(getBaseLearingContent(learningContentId)){
			learningContentId = getBaseLearingContent(learningContentId).id;
		}
		//else{}
		//console.log("learningContentId second:"+learningContentId);
		
		//alert("learningContentId " + learningContentId);
		
		if (content_type.toUpperCase() == 'VIDEO') {
			viewer_url = serverContext + 'zcourse/1/modalplayer/'
					+ learningContentId;
		} else if (content_type.toUpperCase() == 'AUDIO') {
			viewer_url = serverContext + 'zcourse/1/modalplayer/'
					+ learningContentId;
		} else if (content_type.toUpperCase() == 'IMAGE') {
			viewer_url = serverContext + 'zcourse/1/slides/'
					+ learningContentId;
			preview_path = '../../resources/images/preview/image.png';
		} else if (content_type.toUpperCase() == 'DOC') {
			viewer_url = serverContext + 'zcourse/1/slides/'
					+ learningContentId;
			preview_path = '../../resources/images/preview/doc.png';
		} else if (content_type.toUpperCase() == 'PPT') {
			viewer_url = serverContext + 'zcourse/1/slides/'
					+ learningContentId;
		} else if (content_type.toUpperCase() == 'PDF') {
			viewer_url = serverContext + 'zcourse/1/slides/'
					+ learningContentId;
		}
		else if (content_type.toUpperCase() == 'LINK') {
			viewer_url =  getLearningContentObject(learningContentId).contentURL;
		}

		//console.log("viewer_url ------------->>> " + viewer_url); 
		// open in lightbox
		
		if (content_type.toUpperCase() == 'LINK') {
			//viewer_url =  getLearningContentObject(learningContentId).contentURL;
			window.open(viewer_url);
		}
		else{
		 $.fancybox({
				'width': '85%',
				'height': '500',
				'autoScale': true,
				'transitionIn': 'fade',
				'transitionOut': 'fade',
				'type': 'iframe',
				'href': viewer_url
				
			});
		
		}
	} else if (menuaction == "Delete") {
		//alert("open the menu for Delete module.");
		var contentId = tree.getSelectedItemId().split('_')[1];

		var decorationTypeList = getLearningContentObject(contentId).decorationTypeList;
		var latestDecorationType = "";
		if(decorationTypeList && decorationTypeList.length > 0 ){
			latestDecorationType = decorationTypeList[(decorationTypeList.length - 1)];
		}
		//alert("latestDecorationType " + latestDecorationType);
		if("" != latestDecorationType){
			alert("Cannot delete this content as it is already " + latestDecorationType); 
			return;
		}
		
		confirm_delete_component = confirm('Do you want to delete this Content?');
		if (confirm_delete_component == true) {
			uri = serverContext + 'zcourse/1/unassociatecontent';


			var CourseId = $('#courseid').val();
			nodeParentId = tree.getParentId(tree.getSelectedItemId());

			//alert("courseId " + CourseId + " componentId " + nodeParentId.split('_')[1] + "  contentId " + contentId);
			var parameters = {
				"courseId" : CourseId,
				"componentId" : nodeParentId.split('_')[1],
				"contentId" : contentId
			};
			
			//console.log("delete content course id is  " + CourseId);
			//console.log("parameters.length " + parameters.length);
			
			//return;
			$.post(uri, parameters, function(data) {
				//console.log(data);
				if (data.response == 'success') {
					course_id = data.id;
					window.location.href = "/ziksana-web/zcourse/1/repositorycontents/"
							+ CourseId ;

				} else {
					$('#tempdiv1').html(
							'<span style="color:red;">'
									+ "Failed" + '</span>');
				}
			});
					
/*			$.post(uri, parameters, function(data) {
				console.log(data);
				if (data.response == 'success') {
					course_id = data.id;
				} else {
					$('#tempdiv').html(
							'<span style="color:red;">' + data.message
									+ '</span>');
				}
				//alert("data.message " + data.message);
			});
*/
			
			tree.deleteItem(tree.getSelectedItemId(), true);
			$('input:checkbox[name=learningContentToBeAssociated]').removeAttr('checked');
			$('#ContentPanel2').hide();
		}
	}else if (menuaction == "Associate_Content") {
		alert("in associate content");
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
	menu.setIconsPath("/ziksana-web/resources/js/lib/tree/treeimages/images/");
	menu.renderAsContextMenu();
	menu.attachEvent("onClick", onButtonClick);
	menu.loadXML("/ziksana-web/resources/js/lib/tree/xml/_associate_content_menu.xml");

	tree = new dhtmlXTreeObject("treeboxbox_tree", "100%", "100%", 0);
	tree.setSkin('dhx_skyblue');
	tree
			.setImagePath("/ziksana-web/resources/js/lib/tree/treeimages/csh_bluebooks/");
	tree._getOpenState(true);
	tree.enableDragAndDrop(true);
	tree.enableTreeLines(true);

	tree.enableContextMenu(menu);
	tree.attachEvent("onAfterContextMenu", getMenu);
	function getMenu(id) {
		//alert("id is " + id);
		menu.clearAll();
		menu.loadXML("xml/menu_" + id.split(":")[0] + ".xml");
		// alert(menu.loadXML("xml/menu_" + id.split(":")[0] + ".xml"));
		return true;
	}

	tree.attachEvent("onBeforeContextMenu", function(itemId) {

		node_type = itemId.split('_')[0];
		// console.log(node_type);

		if (node_type == "COURSE") {
			$('#courseid').val(itemId);
			//console.log("COURSE " + itemId);
		}

		if (node_type == "COMPONENT") {
			$('#courseLearningComponentId').val(itemId);
			//console.log("COMPONENT " + itemId);
		}

		parent_node_id = tree.getParentId(itemId);

		if (parent_node_id == '0') {
			//console.log('Node parent id is: ' + parent_node_id);
		} else {
			//console.log('Node parent id is COMPONENT: ' + parent_node_id);
			parent_node_type = parent_node_id.split('_')[0];
			if (parent_node_type = "COMPONENT") {
				$('#parentLearningComponentId').val(itemId);
			}
			//console.log("parent_node_id " + parent_node_id);
		}
		tree.selectItem(itemId, false);
		var id = tree.getSelectedItemId();
		// alert(id);

		// tree.selectItem(id,true);
		if (node_type == "COURSE") {
			//menu.showItem('Add_Module');
			//menu.hideItem('Delete');
			//menu.showItem('CourseEdit');
			//menu.hideItem('ModuleEdit');
			menu.hideItem('View');
			menu.hideItem('Delete');
			//menu.hideItem('Annotate');
			menu.hideItem('Search_Associate_Content');
		}

		if (node_type == "COMPONENT") {
			menu.hideItem('View');
			menu.hideItem('Delete');
			//menu.hideItem('Annotate');
			//menu.hideItem('CourseEdit');
			//menu.showItem('Delete');
			//menu.showItem('Associate_Content');
			menu.showItem('Search_Associate_Content');
		}

		if (node_type == "CONTENT") {
			menu.showItem('View');
			//console.log("Showing annnotate also");
			//menu.showItem('Annotate');
			menu.showItem('Delete');
			menu.hideItem('Search_Associate_Content');
		}
		return true;
	});

	tree.setImageArrays("plus", "plus_ar.png", "plus_ar.png", "plus_ar.png",
			"plus_ar.png", "plus_ar.png");
	tree.setImageArrays("minus", "minus_ar.png", "minus_ar.png",
			"minus_ar.png", "minus_ar.png", "minus_ar.png");
	courseId = course_id;
	tree.loadXML("/ziksana-web/zcourse/getchildtree/" + courseId);

}



$(document).ready(
		function(e) {
			var id = null;
			//alert("$('#courseid').val() " + $('#courseid').val());
			createtree($('#courseid').val());
			 $(".Addmodulecontainer").hide();
			function createnode() {

				var im0 = "Tree.png"; // the icon for a leaf node
				var im1 = "Tree.png"; // the icon for an expanded parent node
				var im2 = "Tree.png";
				// tree.insertNewChild(tree.getSelectedItemId()||0,(new
				// Date()).valueOf(),'New item')

				tree.insertNewItem('0', 'Root', document
						.getElementById('defaultvalue').value, 0, im0, im1,
						im2, 'SELECT,TOP');

				// tree.deleteItem("dummy",true);
				// tree.smartRefreshItem(0);
			}

		});
