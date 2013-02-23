// JavaScript Document by Sundip editable
 $(document).ready(function () {
            var theme = getTheme();
			var item2;
				$("#jqxMenu").hide();
				 $(".jqxMenu2").hide();
				 $('#Addmodulecontainer').hide();
				 $('#searchassociatecontainer').hide();
				 $('#definequalifiercontainer').hide();
				 $('#Viewmodulecontainer').hide();
				 $('#deginecourse2').hide();
				 $('#Viewmodulecontainer2').hide();
				 $('#instruction').show();
            // Create jqxTree with drag n drop
            $('#jqxTree').jqxTree({ allowDrag: true, allowDrop: true, width: '180px', theme: theme });
			
				// $('#jqxTree').jqxTree({ theme: theme });
				$('#jqxExpander').jqxExpander({ showArrow: false, toggleMode: 'none', width: '240px', theme: theme });
				 $(window).scrollTop(0,0);
				 
			//cancel link
			$(".cancellinkdefinecourse").click(function(e) {
				//$("#ContentPanel").empty();
                $('#Addmodulecontainer').hide();
				 $('#searchassociatecontainer').hide();
				 $('#definequalifiercontainer').hide();
				 $('#Viewmodulecontainer').hide();
				 $('#deginecourse2').hide();
				 $('#Viewmodulecontainer2').hide();
				 $('#instruction').show();
            });
			
			//spliiter
	$("#splitter").jqxSplitter({ theme: theme, panels: [{ size: 180}] });
           // $('#jqxTree').bind('select', function (event) {
				// var args = event.args;
                //var item = $('#jqxTree').jqxTree('getItem', args.element);
              //  $('#ContentPanel').html('<div style="padding: 10px;"> ' + item.label + '</div>');
				/*$("#ContentPanel").html("<div style='margin: 10px;'>" + "child elements here" + "</div>");*/
				
            //});
			
			//contextmenu assign
            var contextMenu = $("#jqxMenu").jqxMenu({ width: '140px', theme: theme, height: 'auto', autoOpenPopup: false, mode: 'popup' });
		var clickedItem = null;
		
		 var contextMenusec = $(".jqxMenu2").jqxMenu({ width: '140px', theme: theme, height: 'auto', autoOpenPopup: false, mode: 'popup' });
		var clickedItem = null;
			
       $("#splitter").click(function(e) {
       		$("#jqxMenu").hide();
			$(".jqxMenu2").hide();
    });
			 
			 
        


			
			//on focus change
			
			$('.treeRoot').change(function () {				
					
					var selectedItem = $('#jqxTree').jqxTree('selectedItem');
					var addIte = $('#defaultvalue').val();
						
						
					if (selectedItem == null && addIte != "") {
						$('#jqxTree').jqxTree('addTo', {label: addIte });
						 //$("#addTxt").attr("disabled", "disabled");
					}
					else if(selectedItem == null && addIte == ""){
						$('#jqxTree').jqxTree('addTo', { label: 'Course name' });
						 //$("#addTxt").attr("disabled", "disabled");
					}
					else if(selectedItem != null && addIte != ""){
							
						$('#imgRoot').after("<span item-title='true' id='_root'>"+ addIte +"</span>");
					}
					else if(selectedItem != null && addIte == ""){
						$('#imgRoot').after("<span item-title='true' id='_root'>Course Name</span>");
					}
					else
					{
						$('#_root').replaceWith("<span item-title='true' id='_root'>Course Name</span>");
					}	
					
						
				
			});

            // open the context menu when the user presses the mouse right button.
            $("#jqx-draggable-1").live('mousedown', function (event) {
                var target = $(event.target).parents('li:first')[0];
            	$("#jqxMenu").hide();
				 $(".jqxMenu2").hide();
                var rightClick = isRightClick(event);
                if (rightClick && target != null) {
                    $("#jqxTree").jqxTree('selectItem', target);
                    var scrollTop = $(window).scrollTop();
                    var scrollLeft = $(window).scrollLeft();

                    contextMenu.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
					
                    return false;
                }
            });
            
			 // open the context menu when the user presses the mouse right button.
            $("#jqx-draggable-2").live('mousedown', function (event) {
                var target = $(event.target).parents('li:first')[0];
            	$("#jqxMenu").hide();
				 $(".jqxMenu2").hide();
                var rightClick = isRightClick(event);
                if (rightClick && target != null) {
                    $("#jqxTree").jqxTree('selectItem', target);
                    var scrollTop = $(window).scrollTop();
                    var scrollLeft = $(window).scrollLeft();

                    contextMenusec.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
					
                    return false;
                }
            });
			
			 // open the context menu when the user presses the mouse right button.
            $("#jqx-draggable-3").live('mousedown', function (event) {
                var target = $(event.target).parents('li:first')[0];
            	$("#jqxMenu").hide();
				 $(".jqxMenu2").hide();
                var rightClick = isRightClick(event);
                if (rightClick && target != null) {
                    $("#jqxTree").jqxTree('selectItem', target);
                    var scrollTop = $(window).scrollTop();
                    var scrollLeft = $(window).scrollLeft();

                    contextMenusec.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
					
                    return false;
                }
            });
			
			 // open the context menu when the user presses the mouse right button.
            $("#jqx-draggable-4").live('mousedown', function (event) {
                var target = $(event.target).parents('li:first')[0];
            	$("#jqxMenu").hide();
				 $(".jqxMenu2").hide();
                var rightClick = isRightClick(event);
                if (rightClick && target != null) {
                    $("#jqxTree").jqxTree('selectItem', target);
                    var scrollTop = $(window).scrollTop();
                    var scrollLeft = $(window).scrollLeft();

                    contextMenusec.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
					
                    return false;
                }
            });
			
			
            
         
			
			
			$("#linkaddmodule").click(function (event) {
				//$('#ContentPanel').empty();
				//$('#ContentPanel').append('<iframe src="library/Add Module.html" style="width:940px; height:945px;" scrolling="no"></iframe> '); 
				var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                $('#jqxTree').jqxTree('addTo', { label: 'Item' }, selectedItem.element);
				  $('#Viewmodulecontainer').hide();
				  $('#instruction').hide();
				 $('#searchassociatecontainer').hide();
				 $('#DegineCourse2').hide();
				 $('#definequalifiercontainer').hide();
				  $('#Addmodulecontainer').show();
						
			});
			
			$("#linksearchmodule").click(function (event) {
				 $('#Viewmodulecontainer').hide();
				 $('#instruction').hide();
				$('#Addmodulecontainer').hide();
				$('#DegineCourse2').hide();
				$('#definequalifiercontainer').hide();
				$('#searchassociatecontainer').show();
				//$('#ContentPanel').empty();
				 //$('#ContentPanel').append('<iframe src="library/Search & Associate Content.html" style="width:940px; height:945px;" scrolling="no"></iframe> ');
			});
			
			$("#linkdefinequalifiers").click(function (event) {
				//$('#ContentPanel').empty();
				 //$('#ContentPanel').append('<iframe src="library/Define Qualifier modelthinking.html" style="width:940px; height:945px;" scrolling="no"></iframe> ');
				$('#Addmodulecontainer').hide();
				 $('#Viewmodulecontainer').hide();
				 $('#instruction').hide();
				 $('#DegineCourse2').hide();
				$('#searchassociatecontainer').hide();
				$('#definequalifiercontainer').show();
			});
			
			
			
			$("#linkviewqualifiers").click(function (event) {
				//$('#ContentPanel').empty();
				 //$('#ContentPanel').append('<iframe src="library/Define Qualifier modelthinking.html" style="width:940px; height:945px;" scrolling="no"></iframe> ');
				window.location.href= "viewmodelthinking.html";
				
				//$('#deginecourse').hide();
//				 $('#deginecourse2').show();
//				 document.DegineCourse.defaultvalue.disables = true;
			});
			
			
			$("#linkedit").click(function (event) {
				//$('#ContentPanel').empty();
				// $('#ContentPanel').append('<iframe src="library/viewmodelthinking.html" style="width:940px; height:945px;" scrolling="no"></iframe> ');
				// $('#test').show();
				window.location.href= "editmodelthinking.html";
			});
			
			
			
				$("#linkaddmodule2").click(function (event) {
				//$('#ContentPanel').empty();
				//$('#ContentPanel').append('<iframe src="library/Add Module.html" style="width:940px; height:945px;" scrolling="no"></iframe> '); 
				var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                $('#jqxTree').jqxTree('addTo', { label: 'Item' }, selectedItem.element);
				  $('#Viewmodulecontainer').hide();
				 $('#searchassociatecontainer').hide();
				 $('#Viewmodulecontainer2').hide();
				 $('#instruction').hide();
				 $('#DegineCourse2').hide();
				 $('#definequalifiercontainer').hide();
				  $('#Addmodulecontainer').show();
						
			});
			
			$("#linksearchmodule2").click(function (event) {
				 $('#Viewmodulecontainer').hide();
				$('#Addmodulecontainer').hide();
				$('#Viewmodulecontainer2').hide();
				$('#instruction').hide();
				$('#DegineCourse2').hide();
				$('#definequalifiercontainer').hide();
				$('#searchassociatecontainer').show();
				//$('#ContentPanel').empty();
				 //$('#ContentPanel').append('<iframe src="library/Search & Associate Content.html" style="width:940px; height:945px;" scrolling="no"></iframe> ');
			});
			
			$("#linkdefinequalifiers2").click(function (event) {
				//$('#ContentPanel').empty();
				 //$('#ContentPanel').append('<iframe src="library/Define Qualifier modelthinking.html" style="width:940px; height:945px;" scrolling="no"></iframe> ');
				$('#Addmodulecontainer').hide();
				 $('#Viewmodulecontainer').hide();
				 $('#Viewmodulecontainer2').hide();
				 $('#instruction').hide();
				 $('#DegineCourse2').hide();
				$('#searchassociatecontainer').hide();
				$('#definequalifiercontainer').show();
			});
			
			
			
			$("#linkviewqualifiers2").click(function (event) {
				//$('#ContentPanel').empty();
				 //$('#ContentPanel').append('<iframe src="library/Define Qualifier modelthinking.html" style="width:940px; height:945px;" scrolling="no"></iframe> ');
				//window.location.href= "modelthinking2.html";
				
				//$('#deginecourse').hide();
//				 $('#deginecourse2').show();
//				 document.DegineCourse.defaultvalue.disables = true;
				 $('#Addmodulecontainer').hide();
				$('#searchassociatecontainer').hide();
				$('#DegineCourse2').hide();
				$('#instruction').hide();
				$('#definequalifiercontainer').hide();
				$('#Viewmodulecontainer').hide();
				$('#Viewmodulecontainer2').show();
			});
			
			
			$("#linkedit2").click(function (event) {
				//$('#ContentPanel').empty();
				// $('#ContentPanel').append('<iframe src="library/viewmodelthinking.html" style="width:940px; height:945px;" scrolling="no"></iframe> ');
				// $('#test').show();
				$('#Viewmodulecontainer2').hide();
				$('#Addmodulecontainer').hide();
				$('#searchassociatecontainer').hide();
				$('#DegineCourse2').hide();
				$('#instruction').hide();
				$('#definequalifiercontainer').hide();
				$('#Viewmodulecontainer').show();
			});
			
			$("#deletesublink2").click(function(e) {
                var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
							var checkstr =  confirm('are you sure you want to delete this?');
							if(checkstr == true){
							  $('#jqxTree').jqxTree('removeItem', selectedItem.element);
							}
				 }
            });
			
			
		//	
//			$("#sublinkaddmodule2").click(function (event) {
//				//$('#ContentPanel').empty();
//				 //$('#ContentPanel').append('<iframe src="library/Add Module.html" style="width:965px; height:945px;" scrolling="no"></iframe> ');
//				  // var selectedItem = $('#jqxTree').jqxTree('selectedItem');
//				  alert('child');
//                //$('#jqxTree').jqxTree('addTo', { label: 'Item' }, selectedItem.element);
//				$('#modelthinkingaddmodule').show();
//			});
//			
//			$("#sublinksearchmodule2").click(function (event) {
//				$('#ContentPanel').empty();
//				 $('#ContentPanel').append('<iframe src="library/Search & Associate Content.html" style="width:965px; height:945px;" scrolling="no"></iframe> ');
//			});
//			
//			$("#sublinkqualifier2").click(function (event) {
//				$('#ContentPanel').empty();
//				 $('#ContentPanel').append('<iframe src="library/Define Qualifier modelthinkingempty.html" style="width:965px; height:945px;" scrolling="no"></iframe> ');
//			});
//			
//			
//			$("#sublinkviewqualifiers").click(function (event) {
//				$('#ContentPanel').empty();
//				 $('#ContentPanel').append('<iframe src="library/viewmodelthinking.html" style="width:965px; height:945px;" scrolling="no"></iframe> ');
//			});
			

           $("#jqxMenu li").live('itemclick', function (event) {
                var item = $(event.args).text();
                switch (item) {
//                    case "Add Module":
//					alert();
//                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
//                        if (selectedItem != null) {
//							 $('#jqxTree').jqxTree('addTo', { label: 'Item' }, selectedItem.element);
//							 $('#ContentPanel').empty();
//							  $('#ContentPanel').append('<iframe src="library/Associate Content.html" style="width:805px; height:945px;" scrolling="no"></iframe> ');
//						}
//                        break;
//					case "Search and Add":
//                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
//                        if (selectedItem != null) {
//                           	 $('#ContentPanel').empty();
//							  $('#ContentPanel').append('<iframe src="library/Search & Associate Content.html" style="width:805px; height:945px;" scrolling="no"></iframe> ');
//						}	
//											
//					case "Define Qualifiers":
//                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
//                        if (selectedItem != null) {
//                          	 $('#ContentPanel').empty();
//							  $('#ContentPanel').append('<iframe src="library/Define Qualifier.html" style="width:705px; height:945px;" scrolling="no"></iframe> ');
//						}
//						break;
//						
//					case "Edit":
//                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
//                        if (selectedItem != null) {
//                          	 $('#ContentPanel').empty();
//							 $('#DegineCourse').fadeIn('slow');
//							$('#done1').show();
//							$("#show1").hide();
//							$(".saveTop").show();
//						}
//						break;
//					case "View":
//                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
//                        if (selectedItem != null) {
//                          	 $('#ContentPanel').empty();
//							 alert("Click on edit for now!!");
//						}
//						break;	
					case "Delete":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
							var checkstr =  confirm('are you sure you want to delete this?');
							if(checkstr == true){
							  $('#jqxTree').jqxTree('removeItem', selectedItem.element);
							}else{
							return false;
							}                           
                        }
                        break;
				 
                }
            });
			
			
			 $("#jqxTree").live('hover', function (event) {
			 	$("#jqxTree").attr('title', 'Right Click to edit');
			 });
			
			
			
			
			 $("#Sbtcoursedtl").click( function(){
			 $('#DegineCourse').hide();	
			 $("#treeHideShow").show();	
			 $(".saveTop").hide();		
			 $("#Editcoursedtl").hide().delay(500).fadeIn();
			 //var selectedItem2 = $('#jqxTree').jqxTree('selectedItem');
			 //var item2 = $('#jqxTree').jqxTree('getSelectedItem', selectedItem2.element);
			 item2 = $('#jqxTree').jqxTree('getSelectedItem', $("#jqxTree").find('li:first')[0]);
			 //alert(item2)
			});

            

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
					 //alert(item2);
                        if (selectedItem != null && selectedItem!=item2) {
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
				 // shift+s to Search and add note
				 if(e.which == 83 && isCtrl == true) {
				 	 var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
                            $('#Viewmodulecontainer').hide();
							$('#Addmodulecontainer').hide();
							$('#DegineCourse2').hide();
							$('#definequalifiercontainer').hide();
							$('#searchassociatecontainer').show();
						}
				 }	  
				 // shift+q to define qualifier
				  if(e.which == 81 && isCtrl == true) {
				 	 var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
                            $('#Addmodulecontainer').hide();
							$('#Viewmodulecontainer').hide();
							$('#DegineCourse2').hide();
							$('#searchassociatecontainer').hide();
							$('#definequalifiercontainer').show();
						}
				 }
				 // shift+e to edit 
				  if(e.which == 69 && isCtrl == true) {
				 	 var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
                            $('#Addmodulecontainer').hide();
							$('#searchassociatecontainer').hide();
							$('#DegineCourse2').hide();
							$('#definequalifiercontainer').hide();
							$('#Viewmodulecontainer').show();
						}
				 }	  
				 // shift+v to view qualifier
				 if(e.which == 86 && isCtrl == true) {
				 	 var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
                           	window.location.href= "modelthinking2.html";
	
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
			
			
			//Define Qualifier table Row Delete Functionality
			$('.deletedefqualifierrec1').click(function(e) {
                $("#defrow1").remove();
            });
			$('.deletedefqualifierrec2').click(function(e) {
                $("#defrow2").remove();
            });
			$('.deletedefqualifierrec3').click(function(e) {
                $("#defrow3").remove();
            });
			$('.deletedefqualifierrec4').click(function(e) {
                $("#defrow4").remove();
            });
			
			
     });