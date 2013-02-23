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
	if(menuaction == "Add_Module")
	{
		//alert("open the menu for add module.");
		$('#Viewmodulecontainer').hide();
		$('#instruction').hide();
		$('#searchassociatecontainer').hide();
		$('#DegineCourse2').hide();
		$('#definequalifiercontainer').hide();
		$('#Addmodulecontainer').show();
		
		//$("#Btnsbtcmodule").click(function (event) {
				function createchild()
			{
			var d=new Date(); tree.insertNewChild(tree.getSelectedItemId(),d.valueOf(),document.getElementById('Cmoduletxtbox').value,0,0,0,0,'SELECT'); fixImage(d.valueOf());
			tree.smartRefreshItem(0);
			}
		//});
	}
	else if(menuaction == "Search_Add_Module")
	{
		//alert("open the menu for Search_Add_Module module.");
//		$('#Viewmodulecontainer').hide();
//		$('#instruction').hide();
//		$('#DegineCourse2').hide();
//		$('#definequalifiercontainer').hide();
//		$('#Addmodulecontainer').hide();
//		$('#searchassociatecontainer').show();
	}
	else if(menuaction == "Define_Qualifiers")
	{
		//alert("open the menu for Define_Qualifiers module.");
		$('#Viewmodulecontainer').hide();
		$('#instruction').hide();
		$('#searchassociatecontainer').hide();
		$('#DegineCourse2').hide();
		$('#Addmodulecontainer').hide();
		$('#definequalifiercontainer').show();
	}
	else if(menuaction == "Edit")
	{
		//alert("open the menu for Edit module.");
		window.location.href= "editmodelthinking.html";
	}
	else if(menuaction == "RootView")
	{
		//alert("open the menu for Edit module.");
		window.location.href= "viewmodelthinking.html";
	}
	else if(menuaction == "View")
	{
		//alert("open the menu for View module.");
		$('#instruction').hide();
		$('#searchassociatecontainer').hide();
		$('#DegineCourse2').hide();
		$('#definequalifiercontainer').hide();
		$('#Addmodulecontainer').hide();
		$('#Viewmodulecontainer').show();
	}
	else if(menuaction == "Delete")
	{
		//alert("open the menu for Delete module.");
		tree.deleteItem(tree.getSelectedItemId(),true);
	}
    //tree.setItemColor(id, menuitemId.split("_")[1]);
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
				menu.loadXML("js/ziksana/jquerylibrary/tree/xml/_context.xml");
	
			
				
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
					
						menu.hideItem('Add_Module');
						menu.hideItem('Search_Add_Module');
						menu.hideItem('Define_Qualifiers');
						menu.hideItem('Edit');
						menu.hideItem('Delete');
						menu.hideItem('View');
						menu.hideItem('RootView');
							//alert(id);
							//tree._selected();
							tree.selectItem(itemId,false);
							var id = tree.getSelectedItemId();
							
							var txt = tree.getItemText(tree.getSelectedItemId());
							var instr = id.indexOf("Child");
							//alert(txt);
							//alert(id);
							//alert(id);
							
							//tree.selectItem(id,true);


					if (tree.getSelectedItemId() == "Root" || tree.getSelectedItemId() == txt ) {
						//alert(tree.contextID);					
						menu.hideItem('Delete');
						menu.hideItem('View');
						
						
						
						menu.showItem('Add_Module');
						menu.showItem('Search_Add_Module');
						menu.showItem('Define_Qualifiers');
						menu.showItem('Edit');
						menu.showItem('RootView');
						
					} else if(instr >= 0){
						//alert(tree.contextID);
						menu.hideItem('RootView');
						
						
						menu.showItem('Add_Module');
						menu.showItem('Search_Add_Module');
						menu.showItem('Define_Qualifiers');
						menu.showItem('Edit');
						menu.showItem('View');
						menu.showItem('Delete');
					}
					return true;
				});

			
			tree.setImageArrays("plus", "plus_ar.png", "plus_ar.png", "plus_ar.png", "plus_ar.png", "plus_ar.png");
			tree.setImageArrays("minus", "minus_ar.png", "minus_ar.png", "minus_ar.png", "minus_ar.png", "minus_ar.png");
			tree.loadXML("js/ziksana/jquerylibrary/tree/xml/treemodel.xml");
			
			}
			
			
			
			
$(document).ready(function(e) {
	var id = null;
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
