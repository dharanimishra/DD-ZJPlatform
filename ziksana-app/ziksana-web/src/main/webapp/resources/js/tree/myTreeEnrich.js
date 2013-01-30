// JavaScript Document by Sundip editable

 $(document).ready(function () {
            var theme = getTheme();
			 $("#jqxMenu").hide();
				$(".jqxMenu2").hide();
				$(".jqxMenu3").hide();
				$(".jqxMenu4").hide();
				
            // Create jqxTree with drag n drop
            $('#jqxTree').jqxTree({ allowDrag: true, allowDrop: true, width: '240px', theme: theme });
			$('#jqxExpander').jqxExpander({ showArrow: false, toggleMode: 'none', width: '300px', theme: theme });
			//spliiter
			$("#splitter").jqxSplitter({ theme: theme, panels: [{ size: 240}] });
			$(window).scrollTop(0,0);
           // $('#jqxTree').bind('select', function (event) {
//				 var args = event.args;
//                var item = $('#jqxTree').jqxTree('getItem', args.element);
//				$('#jqxTree').open();
//                $('#ContentPanel').html('<div style="padding: 10px;"> ' + item.label + '</div>');
//				$("#ContentPanel").html("<div style='margin: 10px;'>" + "child elements here" + "</div>");
//				 $('#ContentPanel').append('< style="width:805px; height:945px;" scrolling="no"> ');
//				
//            });
			
			//contextmenu assign
           // var contextMenu = $("#jqxMenu").jqxMenu({ width: '140px', theme: theme, height: 'auto', autoOpenPopup: false, mode: 'popup' });
//			var clickedItem = null;
			
			// var contextMenusec = $(".jqxMenu11").jqxMenu({ width: '140px', theme: theme, height: 'auto', autoOpenPopup: false, mode: 'popup' });
//		var clickedItem = null;
//			
			
			var contextMenuthi = $(".jqxMenu3").jqxMenu({ width: '140px', theme: theme, height: 'auto', autoOpenPopup: false, mode: 'popup' });
		var clickedItem = null;
		
		//var contextMenufou = $(".jqxMenu10").jqxMenu({ width: '140px', theme: theme, height: 'auto', autoOpenPopup: false, mode: 'popup' });
//		var clickedItem = null;

			
			$("#splitter").click(function (event) {
			// $("#jqxMenu").hide();
				$(".jqxMenu11").hide();
				$(".jqxMenu3").hide();
				$(".jqxMenu10").hide();
			});
			

            // open the context menu when the user presses the mouse right button.
			
			// $("#jqx-draggable-1").live('hover', function (event) {
//			 	$("#jqx-draggable-1").attr('title', 'Right Click to edit');
//			 });
//            $("#jqx-draggable-1").live('mousedown', function (event) {
//				$("#jqxMenu").hide();
//				$(".jqxMenu2").hide();
//				$(".jqxMenu3").hide();
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

				 $("#jqx-draggable-5").live('hover', function (event) {
			 	$("#jqx-draggable-5").attr('title', '');
			 });
			
			   $("#jqx-draggable-5").live('mousedown', function (event) {
				  $(".jqxMenu11").hide();
				$(".jqxMenu3").hide();
				$(".jqxMenu10").hide();
                var target = $(event.target).parents('li:first')[0];
            	
                var rightClick = isRightClick(event);
                if (rightClick && target != null) {
                	
      
                    $("#jqxTree").jqxTree('selectItem', target);
                    var scrollTop = $(window).scrollTop();
                    var scrollLeft = $(window).scrollLeft();

                   // contextMenu.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
                    return false;
					$(".jqxMenu3").hide();
                }
			   });
			   
			   $("#jqx-draggable-9").live('hover', function (event) {
			 	$("#jqx-draggable-9").attr('title', '');
			 });
			
			   $("#jqx-draggable-9").live('mousedown', function (event) {
				  $(".jqxMenu11").hide();
				$(".jqxMenu3").hide();
				$(".jqxMenu10").hide();
                var target = $(event.target).parents('li:first')[0];
            	
                var rightClick = isRightClick(event);
                if (rightClick && target != null) {
                    $("#jqxTree").jqxTree('selectItem', target);
                    var scrollTop = $(window).scrollTop();
                    var scrollLeft = $(window).scrollLeft();

                   // contextMenu.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
                    return false;
					$(".jqxMenu3").hide();
                }
			   });
			
			
			 $("#jqx-draggable-7").live('hover', function (event) {
			 	$("#jqx-draggable-7").attr('title', 'Right Click to edit');
			 });
			
			   $("#jqx-draggable-7").live('mousedown', function (event) {
				  $(".jqxMenu11").hide();
				$(".jqxMenu3").hide();
				$(".jqxMenu10").hide();
                var target = $(event.target).parents('li:first')[0];
            	
                var rightClick = isRightClick(event);
                if (rightClick && target != null) {
                    $("#jqxTree").jqxTree('selectItem', target);
                    var scrollTop = $(window).scrollTop();
                    var scrollLeft = $(window).scrollLeft();

                   // contextMenuthi.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
                    return false;
                }
            });
			
			
			$("#videocontainer").click(function (event) {
				$('#ContentPanel').empty();
				 $('#ContentPanel').append('<iframe src="enrichcontent.html" style="width:705px; height:600px;" scrolling="no"></iframe> ');
			});
			
			$("#videocontainer2").click(function (event) {
				$('#ContentPanel').empty();
				$('#ContentPanel').append('<iframe src="enrichcontent.html" style="width:705px; height:600px;" scrolling="no"></iframe> ');
			});
			
			$("#videocontainer3").click(function (event) {
				$('#ContentPanel').empty();
				 $('#ContentPanel').append('<iframe src="enrichcontent.html" style="width:705px; height:600px;" scrolling="no"></iframe> ');
			});
			
			 $("#jqx-draggable-6").live('hover', function (event) {
			 	$("#jqx-draggable-6").attr('title', 'Right Click to edit');
			 });
			 $("#jqx-draggable-6").live('mousedown', function (event) {
				 $(".jqxMenu11").hide();
				$(".jqxMenu3").hide();
				$(".jqxMenu10").hide();
                var target = $(event.target).parents('li:first')[0];
            	
                var rightClick = isRightClick(event);
                if (rightClick && target != null) {
                    $("#jqxTree").jqxTree('selectItem', target);
                    var scrollTop = $(window).scrollTop();
                    var scrollLeft = $(window).scrollLeft();

                    contextMenuthi.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
                    return false;
                }
            });
			
			 $("#jqx-draggable-11").live('hover', function (event) {
			 	$("#jqx-draggable-11").attr('title', 'Right Click to edit');
			 });
			
			 $("#jqx-draggable-11").live('mousedown', function (event) {
				$(".jqxMenu11").hide();
				$(".jqxMenu3").hide();
				$(".jqxMenu10").hide();
				
                var target = $(event.target).parents('li:first')[0];
            	
                var rightClick = isRightClick(event);
                if (rightClick && target != null) {
                    $("#jqxTree").jqxTree('selectItem', target);
                    var scrollTop = $(window).scrollTop();
                    var scrollLeft = $(window).scrollLeft();

                    contextMenuthi.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
                    return false;
                }
            });
            
			
			 
			   
		
			

          //  $("#jqxMenu").live('itemclick', function (event) {
//                var item = $(event.args).text();
//                switch (item) {
//                    case "Associate Content":
//                        //var selectedItem = $('#jqxTree').jqxTree('selectedItem');
//                        //if (selectedItem != null) {
//							 $("#enrichsearchassociatecontainer").show();
//							 $('#jqxTree').jqxTree('addTo', { label: 'Item' }, selectedItem.element);
//							  break;
//							 //$('#ContentPanel').empty();
//							 // $('#ContentPanel').append('<iframe src="library/Associate Content.html" style="width:805px; height:945px;" scrolling="no"></iframe> ');
//						//}
//                       
//					case "Search and Associate Content":
//                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
//                        if (selectedItem != null) {
//                           	 $('#ContentPanel').empty();
//							  $('#ContentPanel').append('<iframe src="library/Search & Associate Content.html" style="width:805px; height:945px;" scrolling="no"></iframe> ');
//						}	
//											
//					/*case "Enhance Content":
//                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
//                        if (selectedItem != null) {
//                          	 $('#ContentPanel').empty();
//							 
//							 $('#ContentPanel').append('<iframe src="enrichcontent.html" style="width:805px; height:945px;" scrolling="no"></iframe> ');
//						}
//						break;*/
//						
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
			
			
			 $(document).bind('contextMenusec', function (e) {
                if ($(e.target).parents('.jqx-tree').length > 0) {
                    return false;
                }
                return true;
            });
			
			 $(document).bind('contextMenuthi', function (e) {
                if ($(e.target).parents('.jqx-tree').length > 0) {
                    return false;
                }
                return true;
            });
			
			 $(document).bind('contextMenufou', function (e) {
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