// JavaScript Document
var counter =0;
//var id = "Root";
			

			function createtree()	
			{
				
			tree = new dhtmlXTreeObject("treeboxbox_tree", "100%", "100%", 0);
			tree.setSkin('dhx_skyblue');
			tree.setImagePath("js/ziksana/jquerylibrary/tree/treeimages/csh_bluebooks/");
			tree._getOpenState(true);
			tree.enableDragAndDrop(true);
			tree.enableMercyDrag(true); 
			tree.attachEvent("onRightClick", function (itemId){
				tree.selectItem(itemId,false);
			});
			tree.enableTreeLines(true);
			tree.setImageArrays("plus", "plus_ar.png", "plus_ar.png", "plus_ar.png", "plus_ar.png", "plus_ar.png");
			tree.setImageArrays("minus", "minus_ar.png", "minus_ar.png", "minus_ar.png", "minus_ar.png", "minus_ar.png");
			tree.loadXML("js/ziksana/jquerylibrary/tree/xml/treemodel.xml");
			
			
			mygrid = new dhtmlXGridObject('gridbox');
			mygrid.selMultiRows = true;
			mygrid.setImagePath("js/ziksana/jquerylibrary/tree/gridimages/");
			mygrid.setHeader("Type,Course/Module Title");
			mygrid.setInitWidths("200,400");
			mygrid.setColAlign("middle,middle");
			mygrid.setColTypes("ed,ro");
			mygrid.setColSorting("str,str");
			mygrid.setMultiLine(true);
			mygrid.enableDragAndDrop(true);
			mygrid.setDragBehavior("sibling");
			mygrid.attachEvent("onRowSelect",function(rowId,columnIndex){
				var isotopval = mygrid.cells(rowId,0).getValue();
			if(isotopval == 'Course'){	
			 $('#clcourse').fadeIn();
			 $('#claggregrate').hide();
			  $('#clmodule').hide();
			 $('#form1').hide();
			  $('#form2').hide();
			  $('#form3').hide();
			   $('#form4').hide();
		 }
		 
		  if(isotopval == 'Content'){	
			 $('#clmodule').fadeIn();
			 $('#clcourse').hide();
			  $('#claggregrate').hide();
			 $('#form1').hide();
			  $('#form2').hide();
			  $('#form3').hide();
			   $('#form4').hide();
		 }
		 
		  if(isotopval == 'Module'){	
			 $('#claggregrate').fadeIn();
			 $('#clcourse').hide();
			  $('#clmodule').hide();
			 $('#form1').hide();
			  $('#form2').hide();
			  $('#form3').hide();
			   $('#form4').hide();
		 }
		 
				
				//alert(("#"+rowId));
				
			});
//			 mygrid.attachEvent("onBeforeDrag", function(id){
//				 alert(tree.getChildItemIdByIndex(id,1))
//				 ;});
			//start grid;
			mygrid.init();
			mygrid.setSkin("dhx_skyblue");
			mygrid.loadXML("js/ziksana/jquerylibrary/tree/xml/grid.xml");
			
					//redefine tree-to-grid drop element;
    mygrid.treeToGridElement = function(treeObj, treeNodeId, gridRowId) {
		//alert(tree.getSelectedItemId());
		var id = tree.getSelectedItemId();
		var counter =0;
		var child = tree.hasChildren(id);
		var instr = id.indexOf("Child");
		var assimenu = id.indexOf("assignment");
		var testmenu = id.indexOf("test");
		
		//alert(id);
		// mygrid.addRow(mygrid.uid(), [ind1, ind2], 1);
		
  

						if(child  >= 0)
									if(assimenu >= 0)	
									{
									return ['Assignment', treeObj.getItemText(treeNodeId)];
									}
									else if(testmenu >= 0)
									{
									return ['Test', treeObj.getItemText(treeNodeId)];
									}
									else if(instr >= 0)
									{
									return ['Module', treeObj.getItemText(treeNodeId)];
									}
									else
									{
									return ['Content', treeObj.getItemText(treeNodeId)];
									}	
			

	}
    //redefine grid-to-tree drop element;
    mygrid.gridToTreeElement = function(treeObj, treeNodeId, gridRowId) {
        return this.cells(gridRowId, 1).getValue();
    }
	
	
			}
			
			
			
			
$(document).ready(function(e) {
	var id = null;
	var extimg = null;
	createtree();
	
//	$("table.obj").click(function(e) {
//       // alert();
//		alert($(this).val());
//		//alert(yourObject.toSource());
//
//    });
				
});
