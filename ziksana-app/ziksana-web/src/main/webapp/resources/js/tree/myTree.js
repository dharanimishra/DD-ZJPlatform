// JavaScript Document by Sundip editable

 $(document).ready(function () {
            var theme = getTheme();

            // Create jqxTree with drag n drop
            $('#jqxTree').jqxTree({ allowDrag: true, allowDrop: true, height: '1000px', width: '180px', theme: theme });
			
			//spliiter
			$("#splitter").jqxSplitter({ theme: theme, width: 965, height: 1000, panels: [{ size: 180}] });
            $('#jqxTree').bind('select', function (event) {
				 var args = event.args;
                var item = $('#jqxTree').jqxTree('getItem', args.element);
                $('#ContentPanel').html('<div style="padding: 10px;">Selected node : ' + item.label + '</div>');
				/*$("#ContentPanel").html("<div style='margin: 10px;'>" + "child elements here" + "</div>");*/
				
            });
			
			//contextmenu assign
            var contextMenu = $("#jqxMenu").jqxMenu({ width: '140px', theme: theme, height: 'auto', autoOpenPopup: false, mode: 'popup' });
			var clickedItem = null;
			
			
			
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
                    case "Add Module":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
							alert("add module");
                            $('#jqxTree').jqxTree('addTo', { label: 'Item' }, selectedItem.element);
							 $('#ContentPanel').empty();
							  $('#ContentPanel').append('<iframe src="library/Add Module.html" style="width:725px; height:980px;"></iframe> ');
						}
                        break;
					case "Search and Add":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
							alert("search and add");
                           	 $('#ContentPanel').empty();
							  $('#ContentPanel').append('<iframe src="Search & Associate Module" style="width:725px; height:980px;"></iframe> ');
						}	
						break;					
					case "Define Qualifiers":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
							alert("Define qualifiers");
                          	 $('#ContentPanel').empty();
							  $('#ContentPanel').append('<iframe src="library/Define Qualifier.html" style="width:725px; height:980px;"></iframe> ');
						}
						break;
						
					case "Edit":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
							alert("edit node");
                          	 $('#ContentPanel').empty();
							 $('#DegineCourse').fadeIn('slow');
							$('#done1').show();
							$("#show1").hide();
							$(".saveTop").show();
						}
						break;
					case "View":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
							alert("view related node");
                          	 $('#ContentPanel').empty();
							 alert("Click on edit for now!!");
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