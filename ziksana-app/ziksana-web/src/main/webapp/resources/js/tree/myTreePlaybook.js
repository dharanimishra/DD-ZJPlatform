// JavaScript Document by Sundip editable

 $(document).ready(function () {
            var theme = getTheme();

            // Create jqxTree with drag n drop
             $('#jqxTree').jqxTree({ allowDrag: true, allowDrop: true, width: '280px', theme: theme });
			$('#jqxExpander').jqxExpander({ showArrow: false, toggleMode: 'none', width: '300px', theme: theme });
			// $('#jqxCheckBox').jqxCheckBox({ checked: true, theme: theme });
			//spliiter
			$("#splitter").jqxSplitter({ theme: theme, panels: [{ size: 280}] });
			 $('#_test').jqxTree({ allowDrag: true, allowDrop: true, checkboxes: true, checked: true, width: '280px', theme: theme });
		$(window).scrollTop(0,0);
          
			
			$('#_test').bind('change', function (event) {
                var checked = event.args.checked;
                $('#jqxTree').jqxTree({ hasThreeStates: checked });
            });
	          //$("#jqxTree").jqxTree('selectItem', $("#home")[0]);
				$("#treeb").hide();
			 
               $("#_createnewplaybook").hide();
			
			$("#editpage").click(function (event) {
				 $("#_createnewplaybook").show();
				   $("#editpage").hide();
			});
			
			$("#playbbokrichtextedit").click(function(e) {
                CKEDITOR.replace( 'editor1' );
            });
			
//			//$('#_test').hide();
//			$('#_createnewplaybook').hide();
	
			//spliiter
			//$("#splitter").jqxSplitter({ theme: theme, width: 965, height: 950, panels: [{ size: 240}] });
            //$('#jqxTree').bind('select', function (event) {
				// var args = event.args;
                //var item = $('#jqxTree').jqxTree('getItem', args.element);
               /* $('#ContentPanel').html('<div style="padding: 10px;"> ' + item.label + '</div>');*/
			   
			    //$('#ContentPanel').append('<iframe src="library/playbookdetail.html" style="width:805px; height:945px;" scrolling="no"></iframe> ');
				/*$("#ContentPanel").html("<div style='margin: 10px;'>" + "child elements here" + "</div>");*/
				
           // });
			
			//contextmenu assign
            var contextMenu = $("#jqxMenu").jqxMenu({ width: '140px', theme: theme, height: 'auto', autoOpenPopup: false, mode: 'popup' });
			var clickedItem = null;
			
			
			
			$("#_btnnewplaybook").click(function(e) {
				$("#treeb").hide();
			
			   $("#_playbookdetail").hide();
               $("#_createnewplaybook").show();
			   
            });
			
			$("#donetree").click(function(e) {
                $("#_playbookdetail").hide();
               $("#_createnewplaybook").hide();
			  $("#editpage").show();
			    $("#treeb").show();
			  //$('#jqxTree').jqxTree({ width: '340px'});
			//$("#splitter").jqxSplitter({panels: [{ size: 340}] });
			//$("#splitter2").jqxSplitter({ width:340, panels: [{ size: 340}] });
			// $('#_test').jqxTree({ width: '240px'});
			  
            });

            // open the context menu when the user presses the mouse right button.
          //  $("#jqxTree li").live('mousedown', function (event) {
//                var target = $(event.target).parents('li:first')[0];
//            
//                var rightClick = isRightClick(event);
//                if (rightClick && target != null) {
//                    $("#jqxTree").jqxTree('selectItem', target);
//                    var scrollTop = $(window).scrollTop();
//                    var scrollLeft = $(window).scrollLeft();
//
//                    contextMenu.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
//                    return false;
//                }
//            });

          //  $("#jqxMenu").live('itemclick', function (event) {
//                var item = $(event.args).text();
//                switch (item) {
//                    case "Associate Content":
//                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
//                        if (selectedItem != null) {
//							 $('#jqxTree').jqxTree('addTo', { label: 'Item' }, selectedItem.element);
//							 $('#ContentPanel').empty();
//							  $('#ContentPanel').append('<iframe src="library/Associate Content.html" style="width:805px; height:945px;" scrolling="no"></iframe> ');
//						}
//                        break;
//					case "Search and Associate Content":
//                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
//                        if (selectedItem != null) {
//                           	 $('#ContentPanel').empty();
//							  $('#ContentPanel').append('<iframe src="library/Search & Associate Content.html" style="width:805px; height:945px;" scrolling="no"></iframe> ');
//						}	
//											
//				/*	case "Enhance Content":
//                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
//                        if (selectedItem != null) {
//                          	 $('#ContentPanel').empty();
//							 
//							 $('#ContentPanel').append('<iframe src="Associate_Content/index.html" style="width:805px; height:945px;" scrolling="no"></iframe> ');
//						}
//						break;
//					*/	
//					case "Edit Content":
//                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
//                        if (selectedItem != null) {
//                          	 $('#ContentPanel').empty();
//							
//							alert('c. Shared by others with Edit Permissions!!');
//						}
//						break;
//					case "View Content":
//                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
//                        if (selectedItem != null) {
//                          	 $('#ContentPanel').empty();
//							 alert("This should open the content in a light box in a non-editable mode!!");
//						}
//						break;	
//					case "Delete Content":
//                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
//                        if (selectedItem != null) {
//							var checkstr =  confirm('are you sure you want to delete this?');
//							if(checkstr == true){
//							  $('#jqxTree').jqxTree('removeItem', selectedItem.element);
//							}else{
//							return false;
//							}                           
//                        }
//                        break;
//				 
//                }
//            });
//			
//			
//			 $("#jqxTree li").live('hover', function (event) {
//			 	$("#jqxTree li").attr('title', 'Right Click to edit');
//			 });

			
			// keyboard events
			var isCtrl = false; 
			$(document).keyup(function (e) { 
			if(e.which == 16) isCtrl=false; 
			}).keydown(function (e) { 
			if(e.which == 16) isCtrl=true; 
				//shift+a to add
				if(e.which == 65 && isCtrl == true) {
				
				 		var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
                            $('#jqxTree').jqxTree('addTo', { label: 'Item' }, selectedItem.element);
                        }
				  }
				 //shift+d to delete 
				if(e.which == 68 && isCtrl == true) {
				 	 var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
                            $('#jqxTree').jqxTree('removeItem', selectedItem.element);
						}
				 }	  
		 });	
		 
		 //disable browser default key shortcuts
		


            // disable the default browser's context menu.
            $(document).bind('contextmenu', function (e) {
                if ($(e.target).parents('.jqx-tree').length > 0) {
                    return false;
                }
                return true;
            });

            function isRightClick(event) {
                var rightclick;
                if (!event) var event = window.event;
                if (event.which) rightclick = (event.which == 3);
                else if (event.button) rightclick = (event.button == 2);
                return rightclick;
            }			
		
          
			//$('#load').jqxButton({ height: '25px', width: '40px', theme: theme });
			$('#_addWeek').jqxButton({ height: '25px', width: '40px', theme: theme });
			
            $('#jqxTree').jqxTree('selectItem', $("#jqxTree").find('li:first')[0]);			
			
			
			
     });