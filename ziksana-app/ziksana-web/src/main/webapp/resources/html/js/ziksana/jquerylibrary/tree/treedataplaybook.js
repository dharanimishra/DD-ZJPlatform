// JavaScript Document

	
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
				
			tree = new dhtmlXTreeObject("treeboxbox_tree", "100%", "100%", 0);
			tree.setSkin('dhx_skyblue');
			tree.setImagePath("js/ziksana/jquerylibrary/tree/treeimages/csh_bluebooks/");
			tree._getOpenState(true);
			tree.enableDragAndDrop(true);
			tree.setDragBehavior("sibling");
			tree.enableTreeLines(true);
			tree.setImageArrays("plus", "plus_ar.png", "plus_ar.png", "plus_ar.png", "plus_ar.png", "plus_ar.png");
			tree.setImageArrays("minus", "minus_ar.png", "minus_ar.png", "minus_ar.png", "minus_ar.png", "minus_ar.png");
			tree.loadXML("js/ziksana/jquerylibrary/tree/xml/treemodel.xml");
				
			
				
			tree = new dhtmlXTreeObject("treeboxbox_treeb", "100%", "100%", 0);
			tree.setSkin('dhx_skyblue');
			tree.setImagePath("js/ziksana/jquerylibrary/tree/treeimages/csh_bluebooks/");
			tree.enableThreeStateCheckboxes(true);
			tree.enableCheckBoxes(true);
			tree._getOpenState(true);
			tree.enableDragAndDrop(true);
			tree.setDragBehavior("sibling");
			tree.enableTreeLines(true);
			tree.setImageArrays("plus", "plus_ar.png", "plus_ar.png", "plus_ar.png", "plus_ar.png", "plus_ar.png");
			tree.setImageArrays("minus", "minus_ar.png", "minus_ar.png", "minus_ar.png", "minus_ar.png", "minus_ar.png");
			tree.loadXML("js/ziksana/jquerylibrary/tree/xml/treemodeltree2.xml");
			
			}
			
			
			
			
$(document).ready(function(e) {
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
