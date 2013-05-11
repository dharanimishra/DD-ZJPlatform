// JavaScript Document by Sundip editable

 $(document).ready(function () {
	 		
            var theme = getTheme();

            // Create jqxTree with drag n drop
            $('#jqxTree').jqxTree({ allowDrag: true, allowDrop: true, height: '950px', width: '250px', theme: theme });
			$('#jqxExpander').jqxExpander({ showArrow: false, toggleMode: 'none', width: '300px', height: 'auto', theme: theme });
			$("#splitter").jqxSplitter({ theme: theme, width: 965, height: 950, panels: [{ size: 250}] });
			$(window).scrollTop(0,0);
			//spliiter
			
           /* $('#jqxTree').bind('select', function (event) {
				$("#ContentPanel").html("<div style='margin: 10px;'>" + "child elements here" + "</div>");
            });*/
			
			//contextmenu assign
            var contextMenu = $("#jqxMenu").jqxMenu({ width: '140px', theme: theme, height: 'auto', autoOpenPopup: false, mode: 'popup' });
			//menu for planner
			var contextMenu2 = $("#jqxMenu2").jqxMenu({ width: '140px', theme: theme, height: 'auto', autoOpenPopup: false, mode: 'popup' });
			var clickedItem = null;
			
			
			//create node on tab key
			$('#addTxt').keypress(function (e) {
				if (e.keyCode == 9)
				{
					
					var selectedItem = $('#jqxTree').jqxTree('selectedItem');
					var addIte = $('#addTxt').val();
					
					
					
					if(selectedItem != null && addIte != ""){
							$('#imgRoot').after("<span item-title='true' id='_root'>" + addIte + "</span>");
							
					}
					else
					{
						$('#jqxTree').jqxTree('removeItem', selectedItem.element);						
						$('#jqxTree').jqxTree('addTo', {label: 'Course name' });
					}
					
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
                            $('#jqxTree').jqxTree('addTo', { label: 'Item' }, selectedItem.element);
                        }
                        break;
					case "Delete":
                        var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                        if (selectedItem != null) {
                            $('#jqxTree').jqxTree('removeItem', selectedItem.element);
                        }
                        break;
				 
                }
            });
			
			/*//on hover of nodes
			 $("#jqxTree li").live('hover', function (event) {
				  	var scrollTop = $(window).scrollTop();
                    var scrollLeft = $(window).scrollLeft();
				
					contextMenu2.jqxMenu('open', parseInt(event.clientX) + $(window).scrollLeft(), parseInt(event.clientY) + $(window).scrollTop());
                    return false;
				 
			 });*/
			 
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
		 
		   // disable the default browser's context menu.
            $(document).bind('contextmenu', function (e) {
                if ($(e.target).parents('.jqx-tree').length > 0) {
                    return false;
                }
                return true;
            });

			$(document).bind('contextmenu2', function (e) {
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
			
			 // Create and initialize Buttons
            $('#Add').jqxButton({ height: '25px', width: '42px', theme: theme });
            $('#Remove').jqxButton({ height: '25px', width: '45px', theme: theme });
            $('#Next').jqxButton({ height: '25px', width: '40px', theme: theme });
            $('#Previous').jqxButton({ height: '25px', width: '25px', theme: theme });
			//$('#load').jqxButton({ height: '25px', width: '40px', theme: theme });
			$('#_addWeek').jqxButton({ height: '25px', width: '80px', theme: theme });
			 // Add 
            $('#Add').click(function () {
                var selectedItem = $('#jqxTree').jqxTree('selectedItem');
				
				var addItem = $('#addTxt').val();
			
                if (selectedItem != null) {
                    $('#jqxTree').jqxTree('addTo', { label: addItem }, selectedItem.element);
					//save to tree
					/*xmlDoc=loadXMLDoc("saveTree.xml");
					newel=xmlDoc.createElement("author");
					x=xmlDoc.getElementsByTagName("title")[0];
					x.appendChild(newel);*/
                }
                else {
                    $('#jqxTree').jqxTree('addTo', { label: 'Item' });
                }
            });

            // Remove 
            $('#Remove').click(function () {
                var selectedItem = $('#jqxTree').jqxTree('selectedItem');
                if (selectedItem != null) {
                    $('#jqxTree').jqxTree('removeItem', selectedItem.element);
                }
            });
			
			 // Select Next Item
            $('#Next').click(function () {
                var selectedItem = $("#jqxTree").jqxTree('selectedItem');
                var nextItem = $("#jqxTree").jqxTree('getNextItem', selectedItem.element);
                if (nextItem != null) {
                    $("#jqxTree").jqxTree('selectItem', nextItem.element);
                    $("#jqxTree").jqxTree('ensureVisible', nextItem.element);
                }
            });

            // Select Previous Item
            $('#Previous').click(function () {
                var selectedItem = $("#jqxTree").jqxTree('selectedItem');
                var prevItem = $("#jqxTree").jqxTree('getPrevItem', selectedItem.element);
                if (prevItem != null) {
                    $("#jqxTree").jqxTree('selectItem', prevItem.element);
                    $("#jqxTree").jqxTree('ensureVisible', prevItem.element);
                }
            });
            $('#jqxTree').jqxTree('selectItem', $("#jqxTree").find('li:first')[0]);
			
			//treeb for planner
			
			//add week(s)
		
			$('#_addWeek').click( function(){
				
				//count number of rows in table
				//var not = document.getElementById('_planner').rows.length;
				//get the number of weeks	
				$('#_nextWeek').attr("disabled", "disabled");
				$('#_addWeek').attr("disabled", "disabled");
				var now = $('#_nextWeek').val();
				//total number of weeks at last		
				//var addt = Number(now) + Number(not);
				$('#_planner').append('<tr><th>W/D</th><th>Mon</th><th>Tue</th><th>Wed</th><th>Thu</th><th>Fri</th></tr>');			
				for(var i=1;i<=Number(now);i++)
				{				
					//$('#_planner').append('<tr><th>week-'+i+'</th><td><div id="day-'+i+'1" style="width: 200px; height: 200px;  float:left;">day-1</div></td><td><div id="day-'+i+'2" style="width: 200px; height: 200px;  float:left;">day-2</div></td><td><div id="day-'+i+'3" style="width: 200px; height: 200px;  float:left;">day-3</div></td><td><div id="day-'+i+'4" style="width: 200px; height: 200px;  float:left;">day-4</div></td><td><div id="day-'+i+'5" style="width: 200px; height: 200px;  float:left;">day-5</div></td></tr>');
					$('#_planner').append('<tr><th>Week-'+i+'</th><td id="w'+i+'d1" style="border: 1px solid #CCC; color:#666;"></td><td id="w'+i+'d2" style="border: 1px solid #CCC; color:#666;"></td><td id="w'+i+'d3" style="border: 1px solid #CCC; color:#666;"></td><td id="w'+i+'d4" style="border: 1px solid #CCC; color:#666;"></td><td id="w'+i+'d5" style="border: 1px solid #CCC; color:#666;"></td></tr>');
					$('#w'+i+'d1').jqxTree({ allowDrag: true, allowDrop: true, height: '110px', width: '131px', theme: theme });	
					$('#w'+i+'d2').jqxTree({ allowDrag: true, allowDrop: true, height: '110px', width: '131px', theme: theme });	
					$('#w'+i+'d3').jqxTree({ allowDrag: true, allowDrop: true, height: '110px', width: '131px', theme: theme });	
					$('#w'+i+'d4').jqxTree({ allowDrag: true, allowDrop: true, height: '110px', width: '131px', theme: theme });	
					$('#w'+i+'d5').jqxTree({ allowDrag: true, allowDrop: true, height: '110px', width: '131px', theme: theme });					
					
					//for extra weeks right click menu
					//day-1
					//open menu
					
					 $('#w'+i+'d1 li').live('mousedown', function (event) {
						var target = $(event.target).parents('li:first')[0];
					
						var rightClick = isRightClick(event);
						if (rightClick && target != null) {
							$('#w'+i+'d1').jqxTree('selectItem', target);
							var scrollTop = $(window).scrollTop();
							var scrollLeft = $(window).scrollLeft();
		
							contextMenu2.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
							return false;
						}
					});
					//events on menu
					$("#jqxMenu2").live('itemclick', function (event) {
						var item = $(event.args).text();
						switch (item) {
							case "Add":
								
								var selectedItem = $('#w'+i+'d1').jqxTree('selectedItem');
								
								
								if (selectedItem != null) {
									$('#w'+i+'d1').jqxTree('addTo', { label: 'Item' }, selectedItem.element);
								}
								break;
							case "Remove":
								var selectedItem = $('#w'+i+'d1').jqxTree('selectedItem');
								if (selectedItem != null) {
									$('#w'+i+'d1').jqxTree('removeItem', selectedItem.element);
								}
								break;
						 
						}
					});
					
					//day-2
					//open menu
					 $('#w'+i+'d2 li').live('mousedown', function (event) {
						var target = $(event.target).parents('li:first')[0];
					
						var rightClick = isRightClick(event);
						if (rightClick && target != null) {
							$('#w'+i+'d2').jqxTree('selectItem', target);
							var scrollTop = $(window).scrollTop();
							var scrollLeft = $(window).scrollLeft();
		
							contextMenu2.jqxMenu('open', parseInt(event.clientX) + 5 + scrollLeft, parseInt(event.clientY) + 5 + scrollTop);
							return false;
						}
					});
					//events on menu
					$("#jqxMenu2").live('itemclick', function (event) {
						var item = $(event.args).text();
						switch (item) {
							case "Add":
								
								var selectedItem = $('#w'+i+'d2').jqxTree('selectedItem');
								
								
								if (selectedItem != null) {
									$('#w'+i+'d2').jqxTree('addTo', { label: 'Item' }, selectedItem.element);
								}
								break;
							case "Remove":
								var selectedItem = $('#w'+i+'d2').jqxTree('selectedItem');
								if (selectedItem != null) {
									$('#w'+i+'d2').jqxTree('removeItem', selectedItem.element);
								}
								break;
						 
						}
					});
				}
			});
			
			$('#nextTree').click(function(){
				var content = $('.first').html();
				alert(content);
				$('.second').replaceWith(content);
				$('.second').show();
				$('.first').hide();
			});
			$('#preTree').click(function(){
				$('.first').show();
				$('.second').hide();
			});
			
		
     });