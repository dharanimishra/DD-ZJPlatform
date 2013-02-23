// JavaScript Document
var counter =0;
//var id = "Root";
	function onButtonClick(menuitemId, type) {
		
		//alert("Right click menu action");
		//alert();
    //var id2 = tree.contextID;
	//alert(id2);
	//alert(id);
	//alert(menuitemId);
//	tree.focusItem(tree.contextID);
//	tree.selectItem(tree.contextID,true);
//	menumanipulation(itemId);
	var menuaction = menuitemId;
	
	//menumanipulation(itemId);
	if(menuaction == "Define_Assignment")
	{
		//alert("open the menu for add module.");
				$("#vwassignment").hide();
				$("#vwaddtest").hide();
				$("#vwassociate").hide();
				$("#editassignment").hide();
                $("#vwdefine").show();
	}
	
	
	
	//Menu Action for Assignment Created in Tree
	else if(menuaction == "Add_test")
	{
		//alert("open the menu for Search_Add_Module module.");
				$("#vwassignment").hide();
				$("#vwassociate").hide();
				$("#editassignment").hide();
                $("#vwdefine").hide();
				$("#vwaddtest").show();
	}
	else if(menuaction == "View_assignment")
	{
				$("#vwassociate").hide();
				$("#editassignment").hide();
                $("#vwdefine").hide();
				$("#vwaddtest").hide();
				$("#vwassignment").show();
	}
	else if(menuaction == "Edit_assignment")
	{
		//alert("this should open the form in a editable mode.");
				$("#vwassociate").hide();
                $("#vwdefine").hide();
				$("#vwaddtest").hide();
				$("#vwassignment").hide();
				$("#editassignment").show();
	}
	else if(menuaction == "Delete_assignment")
	{
		alert("this should delete Assignment.");
	}
	
	//Menu Action for Test Created in Tree
	else if(menuaction == "Associate_Question")
	{
		//alert("this should open the external link.");
                $("#vwdefine").hide();
				$("#vwaddtest").hide();
				$("#vwassignment").hide();
				$("#editassignment").hide();
				$("#vwassociate").show();
	}
	else if(menuaction == "View_test_detail")
	{
		alert("this should open the Test Detail in Non-Editable Mode.");
	}
	else if(menuaction == "Edit_test_detail")
	{
		alert("this should open the Test Detail in Editable mode.");
	}
	else if(menuaction == "Delete_test")
	{
		alert("this should Delete the Test from Tree.");
	}
			}
			
			
	
	function fixImage(id) {
		switch (tree.getLevel(id)) {
    case 1:
        ;
        tree.setItemImage2(id, 'folderClosed.gif', 'folderOpen.gif', 'folderClosed.gif');
        break;
    default:
        ;
        tree.setItemImage2(id, "notesIcon.png", "notesIcon.png", "notesIcon.png");
        break;
    }
}

			function createtree()	
			{
				
				menu = new dhtmlXMenuObject();
				menu.setIconsPath("js/ziksana/jquerylibrary/tree/treeimages/images/");
				menu.renderAsContextMenu();
				menu.attachEvent("onClick", onButtonClick);
				menu.loadXML("js/ziksana/jquerylibrary/tree/xml/_contextassignment.xml");
	
			
				
			tree = new dhtmlXTreeObject("treeboxbox_tree", "100%", "100%", 0);
			tree.setSkin('dhx_skyblue');
			tree.setImagePath("js/ziksana/jquerylibrary/tree/treeimages/csh_bluebooks/");
			tree._getOpenState(true);
			tree.enableDragAndDrop(true);
			tree.enableTreeLines(true);
			
			tree.enableContextMenu(menu);
			tree.attachEvent("onAfterContextMenu", getMenu);
			function getMenu(id) {
				menu.clearAll();
				menu.loadXML("xml/menu_" + id.split(":")[0] + ".xml");
				//alert(menu.loadXML("xml/menu_" + id.split(":")[0] + ".xml"));
				return true;
			}
			
			tree.attachEvent("onBeforeContextMenu", function (itemId){
							//alert(id);
							//tree._selected();
						menu.hideItem('Add_test');
						menu.hideItem('View_assignment');
						menu.hideItem('Edit_assignment');
						menu.hideItem('Delete_assignment');
						
						menu.hideItem('Associate_Question');
						menu.hideItem('View_test_detail');
						menu.hideItem('Edit_test_detail');
						menu.hideItem('Delete_test');
						
						menu.hideItem('Define_Assignment');
							
							
							tree.selectItem(itemId,false);
							var id = tree.getSelectedItemId();
							//alert(id);
							var instr = id.indexOf("Child");
							var assimenu = id.indexOf("assignment");
							var testmenu = id.indexOf("test");
							//alert(instr);
							var txt = tree.getItemText(tree.getSelectedItemId());
							//alert(id +" = "+txt);
							//alert(id);
							//alert(id);
							
							//tree.selectItem(id,true);


					if (tree.getSelectedItemId() == txt || instr >= 0 ) {
						//alert(tree.contextID);
						menu.hideItem('Add_test');
						menu.hideItem('View_assignment');
						menu.hideItem('Edit_assignment');
						menu.hideItem('Delete_assignment');
						
						menu.hideItem('Associate_Question');
						menu.hideItem('View_test_detail');
						menu.hideItem('Edit_test_detail');
						menu.hideItem('Delete_test');
						
						menu.showItem('Define_Assignment');
						
					}else if(assimenu >=0){
						menu.showItem('Add_test');
						menu.showItem('View_assignment');
						menu.showItem('Edit_assignment');
						menu.showItem('Delete_assignment');
						
						menu.hideItem('Associate_Question');
						menu.hideItem('View_test_detail');
						menu.hideItem('Edit_test_detail');
						menu.hideItem('Delete_test');
						
						menu.hideItem('Define_Assignment');
					}else if(testmenu >= 0)
					{
						menu.showItem('Associate_Question');
						menu.showItem('View_test_detail');
						menu.showItem('Edit_test_detail');
						menu.showItem('Delete_test');
						
						menu.hideItem('Add_test');
						menu.hideItem('View_assignment');
						menu.hideItem('Edit_assignment');
						menu.hideItem('Delete_assignment');
						
						menu.hideItem('Define_Assignment');
					}
					return true;
				});

			
			tree.setImageArrays("plus", "plus_ar.png", "plus_ar.png", "plus_ar.png", "plus_ar.png", "plus_ar.png");
			tree.setImageArrays("minus", "minus_ar.png", "minus_ar.png", "minus_ar.png", "minus_ar.png", "minus_ar.png");
			tree.loadXML("js/ziksana/jquerylibrary/tree/xml/treemodel.xml");
			
			}
			
			
			
			
$(document).ready(function(e) {
		$("#vwassignment").hide();
				$("#vwaddtest").hide();
				$("#vwassociate").hide();
                $("#vwdefine").hide();
				$("#editassignment").hide();
	var id = null;
	var extimg = null;
	createtree();
	
			
				
		function createnode()
		{
			
			 var im0 = "tree.png"; // the icon for a leaf node
        	 var im1 = "tree.png"; // the icon for an expanded parent node
       		 var im2 = "tree.png"; 
			//tree.insertNewChild(tree.getSelectedItemId()||0,(new Date()).valueOf(),'New item')
			
			tree.insertNewItem('0','Root',document.getElementById('defaultvalue').value,0,im0,im1,im2,'SELECT,TOP');
				
	
			
			//tree.deleteItem("dummy",true);
			//tree.smartRefreshItem(0);
		}
		
			
			
		
});
