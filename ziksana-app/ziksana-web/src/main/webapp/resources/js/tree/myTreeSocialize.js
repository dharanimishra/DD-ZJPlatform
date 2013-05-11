// JavaScript Document by Sundip editable

 $(document).ready(function () {
            var theme = getTheme();

            // Create jqxTree with drag n drop
            $('#jqxTree').jqxTree({ allowDrag: true, allowDrop: true, width: '180px', theme: theme });
			$('#jqxExpander').jqxExpander({ showArrow: false, toggleMode: 'none', width: '240px', theme: theme });
			//spliiter
	        $("#splitter").jqxSplitter({ theme: theme, panels: [{ size: 240}] });
			$(window).scrollTop(0,0); 
			//contextmenu assign
            var contextMenu = $("#jqxMenu").jqxMenu({ width: '145px', theme: theme, height: 'auto', autoOpenPopup: false, mode: 'popup' });
			var clickedItem = null;
			
			
			
			

            // open the context menu when the user presses the mouse right button.
            $("#jqxTree li").live('mousedown', function (event) {
                var target = $(event.target).parents('li:first')[0];
            
                var rightClick = isRightClick(event);
                if (rightClick && target != null) {
                    $("#jqxTree").jqxTree('selectItem', target);
                    var scrollTop = $(window).scrollTop();
                    var scrollLeft = $(window).scrollLeft();

                    contextMenu.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
                    return false;
                }
            });

            $("#jqxMenu").live('itemclick', function (event) {
                var item = $(event.args).text();
                switch (item) {
                    case "Add Component":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
							 $('#jqxTree').jqxTree('addTo', { label: 'Item' }, selectedItem.element);
							 $('#ContentPanel').empty();
							
						}
                        break;
						
									
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
			
			
			 $("#jqxTree li").live('hover', function (event) {
			 	$("#jqxTree li").attr('title', 'Right Click to edit');
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