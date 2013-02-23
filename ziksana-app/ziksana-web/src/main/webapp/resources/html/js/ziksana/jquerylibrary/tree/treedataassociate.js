// JavaScript Document
function fnCheckExt(fileName)
{
	var file = $("#imgultype").val();
     var strExtn = file.substr(fileName.value.lastIndexOf(".")+1,file.length);
	 strExtn.toLowerCase();
     extimg = strExtn;
}


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
	if(menuaction == "Associate_Content")
	{
		//alert("open the menu for add module.");
		$('#instruction').hide();
		$('#Associatecontentsearch').hide();
		$('#associatedefinecontainer').show();
		
		$("#btnsbtassoccontent").click(function(e) {
			//alert(extimg);
					 var im0 = "notesIcon.png"; // the icon for a leaf node
					 var im1 = "notesIcon.png"; // the icon for an expanded parent node
					 var im2 = "notesIcon.png"; 
					 
//			alert();
//				var file = document.getElementById('imgultype').value;
//				alert(file);
//				 var strExtn = file.substr(fileName.value.lastIndexOf(".")+1,file.length);
//				 alert(strExtn);
//					function createassoc()
//					{
			$("#btnsbtassoccontent").click(function(e) {
				
				var typ = document.getElementById('q_type').value;
				//alert(typ);
				if(typ == "Upload Content")
				{
						 if(extimg == "pdf" || extimg == "pdfx")
						 {
							  im0 = "pdf.png"; // the icon for a leaf node
							  im1 = "pdf.png"; // the icon for an expanded parent node
							  im2 = "pdf.png"; 
							  var d=new Date(); tree.insertNewChild(tree.getSelectedItemId(),d.valueOf(),document.getElementById('contentname').value,0,im0,im1,im2,'SELECT');
							  tree.smartRefreshItem(0);
						 }
						else if(extimg == "jpg" || extimg == "jpeg" || extimg == "png" || extimg == "gif" || extimg == "tif" || extimg == "bmp")
						 {
							  im0 = "img.png"; // the icon for a leaf node
							  im1 = "img.png"; // the icon for an expanded parent node
							  im2 = "img.png"; 
							  var d=new Date(); tree.insertNewChild(tree.getSelectedItemId(),d.valueOf(),document.getElementById('contentname').value,0,im0,im1,im2,'SELECT');
							  tree.smartRefreshItem(0);
						 }
						else if(extimg == "mp4" || extimg == "avi" || extimg == "divx" || extimg == "mpg" || extimg == "mpeg" || extimg == "flv"|| extimg == "wmv" || extimg == "swf")
						 {
							  im0 = "video.png"; // the icon for a leaf node
							  im1 = "video.png"; // the icon for an expanded parent node
							  im2 = "video.png"; 
							  var d=new Date(); tree.insertNewChild(tree.getSelectedItemId(),d.valueOf(),document.getElementById('contentname').value,0,im0,im1,im2,'SELECT');
							  tree.smartRefreshItem(0);
						 }
						 else if(extimg == "ppt" || extimg == "pptx" || extimg == "pps")
						 {
							  im0 = "ppt.png"; // the icon for a leaf node
							  im1 = "ppt.png"; // the icon for an expanded parent node
							  im2 = "ppt.png"; 
							  var d=new Date(); tree.insertNewChild(tree.getSelectedItemId(),d.valueOf(),document.getElementById('contentname').value,0,im0,im1,im2,'SELECT');
							  tree.smartRefreshItem(0);
						 }
						  else if(extimg == "doc" || extimg == "docx" || extimg == "rtf" || extimg == "wps")
						 {
							  im0 = "word.png"; // the icon for a leaf node
							  im1 = "word.png"; // the icon for an expanded parent node
							  im2 = "word.png"; 
							  var d=new Date(); tree.insertNewChild(tree.getSelectedItemId(),d.valueOf(),document.getElementById('contentname').value,0,im0,im1,im2,'SELECT');
							  tree.smartRefreshItem(0);
						 }
						  else if(extimg == "xls" || extimg == "xlsx" || extimg == "xlr")
						 {
							  im0 = "excel.png"; // the icon for a leaf node
							  im1 = "excel.png"; // the icon for an expanded parent node
							  im2 = "excel.png";
							  var d=new Date(); tree.insertNewChild(tree.getSelectedItemId(),d.valueOf(),document.getElementById('contentname').value,0,im0,im1,im2,'SELECT');
							  tree.smartRefreshItem(0); 
						 }
				}
				else if(typ == "External WebPage")
				{
							  im0 = "link.png"; // the icon for a leaf node
							  im1 = "link.png"; // the icon for an expanded parent node
							  im2 = "link.png"; 
					var d=new Date(); tree.insertNewChild(tree.getSelectedItemId(),d.valueOf(),document.getElementById('contentname').value,0,im0,im1,im2,'SELECT');
					tree.smartRefreshItem(0);
				}
				else 
				{
							  im0 = "notesIcon.png"; // the icon for a leaf node
							  im1 = "notesIcon.png"; // the icon for an expanded parent node
							  im2 = "notesIcon.png"; 
					var d=new Date(); tree.insertNewChild(tree.getSelectedItemId(),d.valueOf(),document.getElementById('contentname').value,0,im0,im1,im2,'SELECT');
					tree.smartRefreshItem(0);
				}
				//	}
							});

				
            });
		
	}
	else if(menuaction == "Search_Associate_Content")
	{
		//alert("open the menu for Search_Add_Module module.");
//		$('#instruction').hide();
//		$('#associatedefinecontainer').hide();
//		$('#Associatecontentsearch').show();
	}
	else if(menuaction == "View")
	{
		alert("this should open the form in a non-editable mode.");
	}
	else if(menuaction == "Edit")
	{
		alert("this should open the form in a editable mode.");
	}
	else if(menuaction == "Delete")
	{
		alert("this should delete the form.");
	}
	else if(menuaction == "Enhance")
	{
		alert("this should open the external link.");
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
				menu.loadXML("js/ziksana/jquerylibrary/tree/xml/_contextassociate.xml");
	
			
				
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
						menu.hideItem('Delete');
						menu.hideItem('View');
						menu.hideItem('Edit');
						menu.hideItem('Enhance');
						menu.hideItem('Associate_Content');
						menu.hideItem('Search_Associate_Content');
							//alert(id);
							//tree._selected();
							tree.selectItem(itemId,false);
							var id = tree.getSelectedItemId();
							//alert(id);
							var instr = id.indexOf("Child");
							//alert(instr);
							var txt = tree.getItemText(tree.getSelectedItemId());
							//alert(txt);
							//alert(id);
							//alert(id);
							
							//tree.selectItem(id,true);


					if (tree.getSelectedItemId() == "Root" || tree.getSelectedItemId() == txt || instr >= 0 ) {
						//alert(tree.contextID);
						menu.hideItem('Delete');
						menu.hideItem('View');
						menu.hideItem('Edit');
						menu.hideItem('Enhance');
						menu.showItem('Associate_Content');
						menu.showItem('Search_Associate_Content');
						
					}else{
						//alert(tree.contextID);
						menu.hideItem('Associate_Content');
						menu.hideItem('Search_Associate_Content');
						menu.showItem('Delete');
						menu.showItem('View');
						menu.showItem('Edit');
						menu.showItem('Enhance');
					}
					return true;
				});

			
			tree.setImageArrays("plus", "plus_ar.png", "plus_ar.png", "plus_ar.png", "plus_ar.png", "plus_ar.png");
			tree.setImageArrays("minus", "minus_ar.png", "minus_ar.png", "minus_ar.png", "minus_ar.png", "minus_ar.png");
			tree.loadXML("js/ziksana/jquerylibrary/tree/xml/treemodel.xml");
			
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
