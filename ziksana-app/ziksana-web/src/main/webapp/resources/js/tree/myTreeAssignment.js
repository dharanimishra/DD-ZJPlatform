// JavaScript Document by Sundip editable

 $(document).ready(function () {
            var theme = getTheme();
			//$('#jqxMenu').hide();
			    $('.coursename').hide();
				$('.jqxMenu2').hide();
				$('.jqxMenu4').hide();
				$('.jqxMenu3').hide();
				$("#vwassignment").hide();
				$("#vwaddtest").hide();
				$("#vwassociate").hide();
                $("#vwdefine").hide();
				$("#editassignment").hide();
				 //window.scroll('top', 20 - $win.scrollTop());
			//$('#_createnewquestion').hide();
			//$('#dfgr').hide();
			//$("#adtest").hide();
            // Create jqxTree with drag n drop
             $('#jqxTree').jqxTree({ allowDrag: true, allowDrop: true, width: '300px', theme: theme });
			$('#jqxExpander').jqxExpander({ showArrow: false, toggleMode: 'none',width: '300px', theme: theme });
			//spliiter
			$("#splitter").jqxSplitter({ theme: theme, panels: [{ size: 300}] });
           // $('#jqxTree').bind('select', function (event) {
//				 var args = event.args;
//                var item = $('#jqxTree').jqxTree('getItem', args.element);
//                $('#ContentPanel').html('<div style="padding: 10px;"> ' + item.label + '</div>');
//				$("#ContentPanel").html("<div style='margin: 10px;'>" + "child elements here" + "</div>");
//				
//            });
				
			$(".cancellinkdefineassignment").click(function(e) {
                $("#vwassignment").hide();
				$("#vwaddtest").hide();
				$("#vwassociate").hide();
                $("#vwdefine").hide();
				$("#editassignment").hide();
            });
			$(window).scrollTop(0,0);


			$("#jqx-draggable-6").live('hover', function (event) {
			 	$("#jqx-draggable-6").attr('title', '');
			 });
			
            $("#jqx-draggable-6").live('mousedown', function (event) {
                var target = $(event.target).parents('li:first')[0];
				  $('.jqxMenu2').hide();
				  $('.jqxMenu4').hide();
				  $('.jqxMenu3').hide();
                var rightClick = isRightClick(event);
                if (rightClick && target != null) {
                    $("#jqxTree").jqxTree('selectItem', target);
                    var scrollTop = $(window).scrollTop();
                    var scrollLeft = $(window).scrollLeft();

                    contextMenuthi.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
                    return false;
                }
            });
			
			
			$("#splitter").click(function(e) {
                $('.jqxMenu2').hide();
				$('.jqxMenu4').hide();
				$('.jqxMenu3').hide();
            });
			
			//contextmenu assign
            var contextMenu = $(".jqxMenu2").jqxMenu({ width: '145px', theme: theme, height: 'auto', autoOpenPopup: false, mode: 'popup' });
			var clickedItem = null;
//			
			 var contextMenuthi = $(".jqxMenu").jqxMenu({ width: '145px', theme: theme, height: 'auto', autoOpenPopup: false, mode: 'popup' });
			var clickedItem = null;

 			 var contextMenufou = $(".jqxMenu4").jqxMenu({ width: '145px', theme: theme, height: 'auto', autoOpenPopup: false, mode: 'popup' });
			var clickedItem = null;
//			
			 var contextMenusec = $(".jqxMenu3").jqxMenu({ width: '140px', theme: theme, height: 'auto', autoOpenPopup: false, mode: 'popup' });
		var clickedItem = null;
		
		$("#jqx-draggable-23").live('hover', function (event) {
			 	$("#jqx-draggable-23").attr('title', 'Right Click to edit');
			 });
			
            $("#jqx-draggable-23").live('mousedown', function (event) {
                var target = $(event.target).parents('li:first')[0];
            	$('.jqxMenu2').hide();
				$('.jqxMenu4').hide();
				$('.jqxMenu3').hide();
                var rightClick = isRightClick(event);
                if (rightClick && target != null) {
                    $("#jqxTree").jqxTree('selectItem', target);
                    var scrollTop = $(window).scrollTop();
                    var scrollLeft = $(window).scrollLeft();

                    contextMenu.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
                    return false;
                }
            });
			
			
			
			
			$("#jqx-draggable-24").live('hover', function (event) {
			 	$("#jqx-draggable-24").attr('title', 'Right Click to edit');
			 });
			
            $("#jqx-draggable-24").live('mousedown', function (event) {
                var target = $(event.target).parents('li:first')[0];
            	  $('.jqxMenu2').hide();
				$('.jqxMenu4').hide();
				$('.jqxMenu3').hide();
                var rightClick = isRightClick(event);
                if (rightClick && target != null) {
                    $("#jqxTree").jqxTree('selectItem', target);
                    var scrollTop = $(window).scrollTop();
                    var scrollLeft = $(window).scrollLeft();

                    contextMenufou.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
                    return false;
                }
            });
			
			$("#rootmenu").click(function(e) {
				$("#vwassignment").hide();
				$("#vwaddtest").hide();
				$("#vwassociate").hide();
                $("#vwdefine").show();
            });
			
			$("#adtes").click(function(e) {			
            });
			
			$("#assignmentview").click(function(e) {
            });
			
			$("#defasssoc").click(function(e) {
            });
			
		
				// $('#ContentPanel').show();
				
             //open the context menu when the user presses the mouse right button.
			
			 $(".rootnode").live('hover', function (event) {
			 	$(".rootnode").attr('title', 'Right Click to edit');
			 });
			
            $(".rootnode").live('mousedown', function (event) {
                var target = $(event.target).parents('li:first')[0];
            	$('.jqxMenu2').hide();
				$('.jqxMenu4').hide();
				$('.jqxMenu3').hide();
                var rightClick = isRightClick(event);
                if (rightClick && target != null) {
                    $("#jqxTree").jqxTree('selectItem', target);
                    var scrollTop = $(window).scrollTop();
                    var scrollLeft = $(window).scrollLeft();
                    contextMenusec.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
                    return false;
                }
            });
//			
//			$("#videolink").live('mousedown', function (event) {
//                var target = $(event.target).parents('li:first')[0];
//            $('#jqxMenu').hide();
//				$('.jqxMenu2').hide();
//                var rightClick = isRightClick(event);
//                if (rightClick && target != null) {
//                    $("#jqxTree").jqxTree('selectItem', target);
//                    var scrollTop = $(window).scrollTop();
//                    var scrollLeft = $(window).scrollLeft();
//
//                    contextMenusec.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
//                    return false;
//                }
//            });
//			
//			$("#videolink").live('hover', function (event) {
//			 	$("#videolink").attr('title', 'Right Click to edit');
//			 });
//			
//			$("#videolink").live('mousedown', function (event) {
//                var target = $(event.target).parents('li:first')[0];
//            $('#jqxMenu').hide();
//				$('.jqxMenu2').hide();
//                var rightClick = isRightClick(event);
//                if (rightClick && target != null) {
//                    $("#jqxTree").jqxTree('selectItem', target);
//                    var scrollTop = $(window).scrollTop();
//                    var scrollLeft = $(window).scrollLeft();
//
//                    contextMenusec.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
//                    return false;
//                }
//            });
//			
//			$("#videocontainer").click(function (event) {
//				$('#ContentPanel').empty();
//				 $('#ContentPanel').append('<iframe src="enrichcontent.html" style="width:705px; height:945px;" scrolling="no"></iframe> ');
//			});
//			
//			$("#videolink").live('mousedown', function (event) {
//                var target = $(event.target).parents('li:first')[0];
//            $('#jqxMenu').hide();
//				$('.jqxMenu2').hide();
//                var rightClick = isRightClick(event);
//                if (rightClick && target != null) {
//                    $("#jqxTree").jqxTree('selectItem', target);
//                    var scrollTop = $(window).scrollTop();
//                    var scrollLeft = $(window).scrollLeft();
//
//                    contextMenusec.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
//                    return false;
//                }
//            });

            $(".jqxMenu2 li").live('itemclick', function (event) {
                var item = $(event.args).text();
                switch (item) {
					case "Add Test":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
						$('#jqxTree').jqxTree('addTo', { label: 'Item' }, selectedItem.element);
                        if (selectedItem != null) {
							$("#editassignment").hide();
							$("#vwassignment").hide();
							$("#vwdefine").hide();
							$("#vwassociate").hide();
							$("#vwaddtest").show();
                          	 //$('#ContentPanel').empty();							
							// $('#ContentPanel').append('<iframe src="library/addtest.html" style="width:805px; height:945px;" scrolling="no"></iframe> ');
						}
						break;
					case "View Assignment":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {				
							$("#editassignment").hide();
							$("#vwdefine").hide();
							$("#vwassociate").hide();
							$("#vwaddtest").hide();
							$("#vwassignment").show();
						}	
					break;
					case "Edit Assignment":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
							$("#vwdefine").hide();
							$("#vwassociate").hide();
							$("#vwaddtest").hide();
							$("#vwassignment").hide();
							$("#editassignment").show();
						}
						break;	
					case "Delete Assignment":
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
			
			 $(".jqxMenu4 li").live('itemclick', function (event) {
                var item = $(event.args).text();
                switch (item) {
					case "Associate Questions":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
						$('#jqxTree').jqxTree('addTo', { label: 'Item' }, selectedItem.element);
                        if (selectedItem != null) {
							$("#vwassignment").hide();
							$("#vwdefine").hide();
							$("#vwaddtest").hide();
							$("#editassignment").hide();
							$("#vwassociate").show();
						}
						break;
					 case "Delete Test":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) 
						{
							var checkstr =  confirm('are you sure you want to delete this?');
							if(checkstr == true){
							  $('#jqxTree').jqxTree('removeItem', selectedItem.element);
							}          
                        }
                        break;
                }
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