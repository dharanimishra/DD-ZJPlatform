// JavaScript Document

	 $( document).ready(function(e) {
      
		
		$('#tree').hide();	
		$('#treeview').hide();
		$('#treeplay').hide();
				$('#viewButton').hide();
				$('#component').hide();	
				$('#remarks').hide();	
				//gloabal variables
				var course;
				var component;
				//on click events
				var rowSelect = null;
				var rowSelect2;
				$('#carousel img').click( function(){
				rowSelect = $(this).attr('id');
				$('#'+rowSelect2).css( "opacity", 1 );	
				$('#'+rowSelect).css( "opacity", 0.5 );	
				rowSelect2 = rowSelect;
				//alert(rowSelect);
				});
				
				$('.coursel').click( function(){
					if(rowSelect != null)
					{
					$('#tree').fadeIn();
					$('#treeview').show();
					$('#treeplay').show();
					}
					else
					{
					alert('Select a course to View Detail!');
					}
				});	
			
				//click on details
				$('#details').click( function(){
					if(course != undefined)
					{
					$('#tree').fadeIn();
					$('#tree').html("Tree structure for <b>" + course + "</b>");	
					$('#viewButton').fadeIn();
					}
					else
					{
						alert('Please select a course then click here');
					}
				});
				
				//content and playbook
				$('#viewContent').click( function(){
					alert("Popup for view content");
				});
				
				$('#viewPlay').click( function(){
					alert("Popup for view Playbook");
				});
				
				//edit component rule
				
				$('#tblCourse tr').click( function(){
					component = $(this).attr('id');
				});
				
				
				
				
				$('#cSave').click( function(){
					alert('Available Data saved!!');	
				});
				
				$('#cReturn').click( function(){
					confirm('Seriously!!!!!');
					confirm(' you will loose the current state!!!!!');
					confirm('How will you come back!!!!!');
					confirm('Ok! Dont panic!!!!');
					var checkstr2 =  confirm('Are you sure to quit!! This is final!!! For real.');
							if(checkstr2 == true){
							 $('#engagementContainer').hide();
							}else{
							return false;
							}      
				});
				
				
				$('#carousel img').click( function(){
					$('.selectedlink').removeClass('selectedlink');
					$(this).addClass('selectedlink');
					return false;
					
						
				});
		
		
		
		
		
    });
	function changeBorder(obj){
		alert(obj);
		obj.className = 'imgBorder';
		}

  