// JavaScript Document by Sundip editable
	 			function createtree()	
			{
			
	    tree = new dhtmlXTreeObject("treeboxbox_tree", "100%", "100%", 0);
		tree.setSkin('dhx_skyblue');
		tree.setImagePath("../js/ziksana/jquerylibrary/tree/treeimages/csh_bluebooks/");
		tree.enableDragAndDrop(true);
		tree.enableMercyDrag(true); 
		tree.enableTreeLines(true);
		tree.attachEvent("onRightClick", function (itemId){
				tree.selectItem(itemId,false);
			});
		tree.setImageArrays("plus", "plus_ar.png", "plus_ar.png", "plus_ar.png", "plus_ar.png", "plus_ar.png");
		tree.setImageArrays("minus", "minus_ar.png", "minus_ar.png", "minus_ar.png", "minus_ar.png", "minus_ar.png");
		tree.loadXML("../js/ziksana/jquerylibrary/tree/xml/treemodel.xml");

			}
			
			
			
			
$(document).ready(function(e) {
	var id = null;
	var extimg = null;
				
	var theme = getTheme();
	$(window).scrollTop(0,0);
				 	  
   
			//spliiter
	$("#splitter").jqxSplitter({ theme: theme, panels: [{ size: 190}] });
	
	createtree();
	
});
