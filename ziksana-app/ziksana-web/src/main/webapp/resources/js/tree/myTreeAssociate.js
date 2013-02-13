// JavaScript Document by Sundip editable

 $(document).ready(function () {
            var theme = getTheme();
			var item2;
            // Create jqxTree with drag n drop
            $('#jqxTree').jqxTree({ allowDrag: true, allowDrop: true, width: '240px', theme: theme });
			$('#jqxExpander').jqxExpander({ showArrow: false, toggleMode: 'none',width: '300px', theme: theme });
			$(".jqxMenu2").hide();
			$("#jqxMenu").hide();
			$(".jqxMenu3").hide();
			$(".jqxMenu4").hide();
			$(".jqxMenu5").hide();
			$(".jqxMenu6").hide();
			$("#associatedefinecontainer").hide();
			$("#Associatecontentsearch").hide();
			
			
			$(".cancellinkassociatecontent").click(function(e) {
				$("#associatedefinecontainer").hide();
				$("#Associatecontentsearch").hide();
				$("#instruction").show();
            });
			//spliiter
			$("#splitter").jqxSplitter({ theme: theme, panels: [{ size: 240}] });
           // $('#jqxTree').bind('select', function (event) {
//				 var args = event.args;
//				 
//                var item = $('#jqxTree').jqxTree('getItem', args.element);
//                $('#ContentPanel').html('<div style="padding: 10px;"> ' + item.label + '</div>');
//				$("#ContentPanel").html("<div style='margin: 10px;'>" + "child elements here" + "</div>");
//				
//            });
				$(window).scrollTop(0,0);
			
			//contextmenu assign
            var contextMenu = $("#jqxMenu").jqxMenu({ width: '140px', theme: theme, height: 'auto', autoOpenPopup: false, mode: 'popup' });
			var clickedItem = null;
			
			
			 var contextMenusec = $(".jqxMenu2").jqxMenu({ width: '140px', theme: theme, height: 'auto', autoOpenPopup: false, mode: 'popup' });
			var clickedItem = null;
			
			var contextMenuthi = $(".jqxMenu3").jqxMenu({ width: '140px', theme: theme, height: 'auto', autoOpenPopup: false, mode: 'popup' });
			var clickedItem = null;
			
			var contextMenufou = $(".jqxMenu4").jqxMenu({ width: '140px', theme: theme, height: 'auto', autoOpenPopup: false, mode: 'popup' });
			var clickedItem = null;
			
			var contextMenufiv = $(".jqxMenu5").jqxMenu({ width: '140px', theme: theme, height: 'auto', autoOpenPopup: false, mode: 'popup' });
			var clickedItem = null;
			
			var contextMenusix = $(".jqxMenu6").jqxMenu({ width: '140px', theme: theme, height: 'auto', autoOpenPopup: false, mode: 'popup' });
			var clickedItem = null;
			
		
			//$("#videolink").click(function (event) {
//				$('#ContentPanel').empty();
//				 $('#ContentPanel').append('<iframe src="enrichcontent.html" style="width:705px; height:945px;" scrolling="no"></iframe> ');
//			});
//			
			$("#videolink2").click(function (event) {
				$('#ContentPanel').empty();
				// $('#ContentPanel').append('<iframe src="enrichcontent.html" style="width:705px; height:945px;" scrolling="no"></iframe> ');
				// $('#videolink3').attr("target", "_blank");
  				//$('#ContentPanel').addClass("lbx-70-50");
			});

			
  			


			
			$("#videolink3").click(function (event) {
				$('#ContentPanel').empty();
				// $('#ContentPanel').html('<a href="http://54.243.235.88/ZikDemo/Associate_Content/"  name="inframe"></a>');
				//document.location.href = "http://54.243.235.88/ZikDemo/Associate_Content/" ;
				//document.getElementById('ContentPanel').className = 'lbx-70-50';
			});
			
			
			$("#splitter").click(function (event) {
				 $(".jqxMenu2").hide();
			$("#jqxMenu").hide();
			$(".jqxMenu3").hide();
			$(".jqxMenu4").hide();
			$(".jqxMenu5").hide();
			$(".jqxMenu6").hide();
			});
			
			
            // open the context menu when the user presses the mouse right button.
            $("#jqx-draggable-1").live('mousedown', function (event) {
                var target = $(event.target).parents('li:first')[0];
           $(".jqxMenu2").hide();
			$("#jqxMenu").hide();
			$(".jqxMenu3").hide();
			$(".jqxMenu4").hide();
			$(".jqxMenu5").hide();
			$(".jqxMenu6").hide();
                var rightClick = isRightClick(event);
                if (rightClick && target != null) {
                    $("#jqxTree").jqxTree('selectItem', target);
                    var scrollTop = $(window).scrollTop();
                    var scrollLeft = $(window).scrollLeft();

                    contextMenu.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
                    return false;
                }
            });
			
			
			 $("#jqx-draggable-3").live('mousedown', function (event) {
                var target = $(event.target).parents('li:first')[0];
            $(".jqxMenu2").hide();
			$("#jqxMenu").hide();
			$(".jqxMenu3").hide();
			$(".jqxMenu4").hide();
			$(".jqxMenu5").hide();
			$(".jqxMenu6").hide();
                var rightClick = isRightClick(event);
                if (rightClick && target != null) {
                    $("#jqxTree").jqxTree('selectItem', target);
                    var scrollTop = $(window).scrollTop();
                    var scrollLeft = $(window).scrollLeft();

                    contextMenufou.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
                    return false;
                }
            });
			
			
			 $("#jqx-draggable-2").live('mousedown', function (event) {
                var target = $(event.target).parents('li:first')[0];
          $(".jqxMenu2").hide();
			$("#jqxMenu").hide();
			$(".jqxMenu3").hide();
			$(".jqxMenu4").hide();
			$(".jqxMenu5").hide();
			$(".jqxMenu6").hide();
                var rightClick = isRightClick(event);
                if (rightClick && target != null) {
                    $("#jqxTree").jqxTree('selectItem', target);
                    var scrollTop = $(window).scrollTop();
                    var scrollLeft = $(window).scrollLeft();

                    contextMenufou.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
                    return false;
                }
            });
			
			 $("#jqx-draggable-4").live('mousedown', function (event) {
                var target = $(event.target).parents('li:first')[0];
           $(".jqxMenu2").hide();
			$("#jqxMenu").hide();
			$(".jqxMenu3").hide();
			$(".jqxMenu4").hide();
			$(".jqxMenu5").hide();
			$(".jqxMenu6").hide();
                var rightClick = isRightClick(event);
                if (rightClick && target != null) {
                    $("#jqxTree").jqxTree('selectItem', target);
                    var scrollTop = $(window).scrollTop();
                    var scrollLeft = $(window).scrollLeft();

                    contextMenufou.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
                    return false;
                }
            });
			
			$("#jqx-draggable-6").live('mousedown', function (event) {
                var target = $(event.target).parents('li:first')[0];
            	$(".jqxMenu2").hide();
			$("#jqxMenu").hide();
			$(".jqxMenu3").hide();
			$(".jqxMenu4").hide();
			$(".jqxMenu5").hide();
			$(".jqxMenu6").hide();
                var rightClick = isRightClick(event);
                if (rightClick && target != null) {
                    $("#jqxTree").jqxTree('selectItem', target);
                    var scrollTop = $(window).scrollTop();
                    var scrollLeft = $(window).scrollLeft();

                    contextMenusec.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
                    return false;
                }
            });
			
			$("#jqx-draggable-7").live('mousedown', function (event) {
                var target = $(event.target).parents('li:first')[0];
            	$(".jqxMenu2").hide();
			$("#jqxMenu").hide();
			$(".jqxMenu3").hide();
			$(".jqxMenu4").hide();
			$(".jqxMenu5").hide();
			$(".jqxMenu6").hide();
                var rightClick = isRightClick(event);
                if (rightClick && target != null) {
                    $("#jqxTree").jqxTree('selectItem', target);
                    var scrollTop = $(window).scrollTop();
                    var scrollLeft = $(window).scrollLeft();

                    contextMenusix.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
                    return false;
                }
            });
			
			$("#jqx-draggable-11").live('mousedown', function (event) {
                var target = $(event.target).parents('li:first')[0];
            	$(".jqxMenu2").hide();
			$("#jqxMenu").hide();
			$(".jqxMenu3").hide();
			$(".jqxMenu4").hide();
			$(".jqxMenu5").hide();
			$(".jqxMenu6").hide();
                var rightClick = isRightClick(event);
                if (rightClick && target != null) {
                    $("#jqxTree").jqxTree('selectItem', target);
                    var scrollTop = $(window).scrollTop();
                    var scrollLeft = $(window).scrollLeft();

                    contextMenufiv.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
                    return false;
                }
            });
			
			$("#jqx-draggable-5").live('mousedown', function (event) {
                var target = $(event.target).parents('li:first')[0];
            	$(".jqxMenu2").hide();
			$("#jqxMenu").hide();
			$(".jqxMenu3").hide();
			$(".jqxMenu4").hide();
			$(".jqxMenu5").hide();
			$(".jqxMenu6").hide();
                var rightClick = isRightClick(event);
                if (rightClick && target != null) {
                    $("#jqxTree").jqxTree('selectItem', target);
                    var scrollTop = $(window).scrollTop();
                    var scrollLeft = $(window).scrollLeft();

                    contextMenuthi.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
                    return false;
                }
            });
			
			$("#jqx-draggable-10").live('mousedown', function (event) {
                var target = $(event.target).parents('li:first')[0];
            	 $(".jqxMenu2").hide();
			$("#jqxMenu").hide();
			$(".jqxMenu3").hide();
			$(".jqxMenu4").hide();
			$(".jqxMenu5").hide();
			$(".jqxMenu6").hide();
                var rightClick = isRightClick(event);
                if (rightClick && target != null) {
                    $("#jqxTree").jqxTree('selectItem', target);
                    var scrollTop = $(window).scrollTop();
                    var scrollLeft = $(window).scrollLeft();

                    contextMenuthi.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
                    return false;
                }
            });
			
			//$("#jqx-draggable-7").live('mousedown', function (event) {
//                var target = $(event.target).parents('li:first')[0];
//            	 $(".jqxMenu2").hide();
//			$("#jqxMenu").hide();
//			$(".jqxMenu3").hide();
//			$(".jqxMenu4").hide();
//                var rightClick = isRightClick(event);
//                if (rightClick && target != null) {
//                    $("#jqxTree").jqxTree('selectItem', target);
//                    var scrollTop = $(window).scrollTop();
//                    var scrollLeft = $(window).scrollLeft();
//
//                    contextMenuthi.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
//                    return false;
//                }
//            });
			
			$("#jqx-draggable-8").live('mousedown', function (event) {
                var target = $(event.target).parents('li:first')[0];
            	$(".jqxMenu2").hide();
			$("#jqxMenu").hide();
			$(".jqxMenu3").hide();
			$(".jqxMenu4").hide();
			$(".jqxMenu5").hide();
			$(".jqxMenu6").hide();
                var rightClick = isRightClick(event);
                if (rightClick && target != null) {
                    $("#jqxTree").jqxTree('selectItem', target);
                    var scrollTop = $(window).scrollTop();
                    var scrollLeft = $(window).scrollLeft();

                    contextMenuthi.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
                    return false;
                }
            });
			
			
			$("#jqx-draggable-9").live('mousedown', function (event) {
                var target = $(event.target).parents('li:first')[0];
            	$(".jqxMenu2").hide();
			$("#jqxMenu").hide();
			$(".jqxMenu3").hide();
			$(".jqxMenu4").hide();
			$(".jqxMenu5").hide();
			$(".jqxMenu6").hide();
                var rightClick = isRightClick(event);
                if (rightClick && target != null) {
                    $("#jqxTree").jqxTree('selectItem', target);
                    var scrollTop = $(window).scrollTop();
                    var scrollLeft = $(window).scrollLeft();

                    contextMenuthi.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
                    return false;
                }
            });
			
			$("#jqx-draggable-9").click(function(e) {
				$("#instruction").hide();
            });
			
			
			//$("#enrich").click(function (event) {
//				$('#ContentPanel').empty();
//				
//				put the code for the video and the file name over here
//				
//			});
//			
//			
//			$("#enrich2").click(function (event) {
//				$('#ContentPanel').empty();
//				 
//				 put the code for the video and the file name over here
//			});
			
			
			
			
			
			
			

            $(".jqxMenu1").live('itemclick', function (event) {
                var item = $(event.args).text();
                switch (item) {
                    case "Associate Content":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                       // if (selectedItem != null) {
							//$("#_advanced").hide();
							//$('#jqxTree').jqxTree('addTo', { label: 'Item' }, selectedItem.element);
                            $('#jqxTree').jqxTree('addTo', { label: 'Item' }, selectedItem.element);
							$("#instruction").hide();
							$("#Associatecontentsearch").hide();
							$("#associatedefinecontainer").show();
							   break;
							// $('#ContentPanel').empty();
							 //$('#ContentPanel').append('<iframe src="library/Associate Content.html" style="width:805px; height:945px;" scrolling="no"></iframe> ');
						//}
                      
					case "Search and Associate Content":
                        //var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                       // if (selectedItem != null) {
						    $("#instruction").hide();
							$("#associatedefinecontainer").hide();
							$("#Associatecontentsearch").show();
							break;
                           	// $('#ContentPanel').empty();
							//  $('#ContentPanel').append('<iframe src="library/Search & Associate Content.html" style="width:805px; height:945px;" scrolling="no"></iframe> ');
						//}	
											
				/*	case "Enhance Content":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
                          	 $('#ContentPanel').empty();
							 
							 $('#ContentPanel').append('<iframe src="Associate_Content/index.html" style="width:805px; height:945px;" scrolling="no"></iframe> ');
						}
						break;
					*/	
					/*case "Edit Content":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
							 $("#instruction").hide();
                          	 $('#ContentPanel').empty();
							alert('c. Shared by others with Edit Permissions!!');
						}
						break;
					case "View Content":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
							 $("#instruction").hide();
                          	 $('#ContentPanel').empty();
							 alert("This should open the content in a light box in a non-editable mode!!");
						}
						break;	
					case "Delete Content":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
					 //alert(item2);
                        if (selectedItem != null && selectedItem != item2)
						 {
							var checkstr =  confirm('are you sure you want to delete this?');
							if(checkstr == true)
							{
                            $('#jqxTree').jqxTree('removeItem', selectedItem.element);
							}
						}	
						break;		*/	 
                }
            });
			
			$(".jqxMenu4").live('itemclick', function (event) {
                var item = $(event.args).text();
                switch (item) {
                    case "Associate Content":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                       // if (selectedItem != null) {
							
							//$('#jqxTree').jqxTree('addTo', { label: 'Item' }, selectedItem.element);
                            $('#jqxTree').jqxTree('addTo', { label: 'Item' }, selectedItem.element);
							$("#instruction").hide();
							$("#Associatecontentsearch").hide();
							$("#associatedefinecontainer").show();
							 break;
							// $('#ContentPanel').empty();
							 //$('#ContentPanel').append('<iframe src="library/Associate Content.html" style="width:805px; height:945px;" scrolling="no"></iframe> ');
						//}
                        
					case "Search and Associate Content":
                        //var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                       // if (selectedItem != null) {
						   $("#instruction").hide();
							$("#associatedefinecontainer").hide();
							$("#Associatecontentsearch").show();
							break;
					
				}
			
			});
			
			
			//menu event for six sigma
			$(".jqxMenu2").live('itemclick', function (event) {
                var item = $(event.args).text();
                switch (item) {
                   case "Edit Content":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
							 $("#instruction").hide();
                          	 $('#ContentPanel').empty();
							alert('c. Shared by others with Edit Permissions!!');
						}
						break;
					case "View Content":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
							 $("#instruction").hide();
                          	 $('#ContentPanel').empty();
							 alert("This should open the content in a light box in a non-editable mode!!");
						}
						break;	
					case "Delete Content":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
					 //alert(item2);
                        if (selectedItem != null && selectedItem != item2)
						 {
							var checkstr =  confirm('are you sure you want to delete this?');
							if(checkstr == true)
							{
                            $('#jqxTree').jqxTree('removeItem', selectedItem.element);
							}
						}	
						break;			 
				}
			
			});
			//menu event for Documents in the tree Like Word File, PDF File.
			//Intelligent citizens of the world, why Model, Aggregation, Introduction to Decision Making
			$(".jqxMenu3 li").live('itemclick', function (event) {
                var item = $(event.args).text();
                switch (item) {
                   case "Edit Content":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
							 $("#instruction").hide();
                          	 $('#ContentPanel').empty();
							alert('c. Shared by others with Edit Permissions!!');
						}
						break;
					case "View Content":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
							 $("#instruction").hide();
                          	 $('#ContentPanel').empty();
							 alert("This should open the content in a light box in a non-editable mode!!");
						}
						break;	
					case "Delete Content":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
					 //alert(item2);
                        if (selectedItem != null && selectedItem != item2)
						 {
							var checkstr =  confirm('are you sure you want to delete this?');
							if(checkstr == true)
							{
                            $('#jqxTree').jqxTree('removeItem', selectedItem.element);
							}
						}	
						break;			 
				}
			
			});
			//menu event for Probability The Basics
			$(".jqxMenu5").live('itemclick', function (event) {
                var item = $(event.args).text();
                switch (item) {
                   case "Edit Content":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
							 $("#instruction").hide();
                          	 $('#ContentPanel').empty();
							alert('c. Shared by others with Edit Permissions!!');
						}
						break;
					case "View Content":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
							 $("#instruction").hide();
                          	 $('#ContentPanel').empty();
							 alert("This should open the content in a light box in a non-editable mode!!");
						}
						break;	
					case "Delete Content":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
					 //alert(item2);
                        if (selectedItem != null && selectedItem != item2)
						 {
							var checkstr =  confirm('are you sure you want to delete this?');
							if(checkstr == true)
							{
                            $('#jqxTree').jqxTree('removeItem', selectedItem.element);
							}
						}	
						break;			 
				}
			
			});
			//menu event for Preference aggregation
			$(".jqxMenu6").live('itemclick', function (event) {
                var item = $(event.args).text();
                switch (item) {
                   case "Edit Content":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
							 $("#instruction").hide();
                          	 $('#ContentPanel').empty();
							alert('c. Shared by others with Edit Permissions!!');
						}
						break;
					case "View Content":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
							 $("#instruction").hide();
                          	 $('#ContentPanel').empty();
							 alert("This should open the content in a light box in a non-editable mode!!");
						}
						break;	
					case "Delete Content":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
					 //alert(item2);
                        if (selectedItem != null && selectedItem != item2)
						 {
							var checkstr =  confirm('are you sure you want to delete this?');
							if(checkstr == true)
							{
                            $('#jqxTree').jqxTree('removeItem', selectedItem.element);
							}
						}	
						break;			 
				}
			
			});
			
			//To be used in future
//			label:"Model Thinking", id:"rootLi", parentId:0, parentElement:null, parentItem:null, disabled:false, 
//			selected:false, locked:false, checked:false, level:0, isExpanded:true, hasItems:true, element:({}), subtreeElement:({}), checkBoxElement:null, titleElement:{0:({}), length:1}, arrow:({}), 
			
			$(function(){ // this will run when the document.ready event fires
			$("#instruction").show();
			 item2 = $('#jqxTree').jqxTree('getSelectedItem', $("#jqxTree").find('li:first')[0]);
			 //To be used in future
				/*alert(item2.label);*/
			});
			
			//alert();
			// keyboard events
			/*
			var isCtrl = false; 
			$(document).keyup(function (e) { 
			if(e.which == 16) isCtrl=false; 
			}).keydown(function (e) { 
			if(e.which == 16) isCtrl=true; 
				//shift+a to Shortcut to associate content 
				if(e.which == 65 && isCtrl == true) {
				
				 		var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
                            $('#jqxTree').jqxTree('addTo', { label: 'Item' }, selectedItem.element);
							$("#instruction").hide();
							$("#Associatecontentsearch").hide();
							$("#associatedefinecontainer").show();

                        }
				  }// shift+s to search and associate content
				  if(e.which == 83 && isCtrl == true) {
				
				 		var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
						    $("#instruction").hide();
							$("#associatedefinecontainer").hide();
							$("#Associatecontentsearch").show();
                        }
				  }
				  //Shift+v view content
				 if(e.which == 86 && isCtrl == true) {
				
				 		var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
							 $("#instruction").hide();
                          	 $('#ContentPanel').empty();
							 alert("This should open the content in a light box in a non-editable mode!!");
                        }
				  }//shift+e to edit content
				  if(e.which == 69 && isCtrl == true) {
				
				 		var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
							 $("#instruction").hide();
                          	 $('#ContentPanel').empty();
							alert('c. Shared by others with Edit Permissions!!');
                        }
				  }
				 //shift+d to delete 
				 if(e.which == 68 && isCtrl == true) {
				 	 var selectedItem = $('#jqxTree').jqxTree('selectedItem');
					 //alert(item2);
                        if (selectedItem != null && selectedItem != item2) {
							var checkstr =  confirm('are you sure you want to delete this?');
							if(checkstr == true)
							{
                            $('#jqxTree').jqxTree('removeItem', selectedItem.element);
							}
						}
						else
							{
								alert("Course Node cannot be Deleted");
							}
				 }	
				 
				 // still shortcut key to enhance content is remaining.
		 });	
		 */
		 
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
			
			$(document).bind('contextMenufiv', function (e) {
                if ($(e.target).parents('.jqx-tree').length > 0) {
                    return false;
                }
                return true;
            });
			
			$(document).bind('contextMenusix', function (e) {
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