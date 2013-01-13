// JavaScript Document

	$(document).ready(function(e) {
		
		//global variable declaration
		var trId;
        //hide at first
		$('.reviewmaindetails').hide();
		$('.reviewlowerconatiner').hide();
		$('#crDetails').hide();
		//on row click from table
		$('#rtr1').click( function(){
			  
			  $('.reviewmaindetails').fadeIn();
			  $('#crName').val($('#rtr1 td:first').html());
			  $('#crName').css('font-weight', 'bold');			  
			  $('#crDate').val($('#rtr1 td:last').html());
			  $('#crDate').css('font-weight', 'bold');	
			  trId = $(this).attr('id');
			  $('.reviewlowerconatiner').hide();
			  $('#crDetails').show();
		});
		$('#rtr2').click( function(){
			  $('.reviewmaindetails').fadeIn();
			  $('#crName').val($('#rtr2 td:first').html());
			  $('#crName').css('font-weight', 'bold');			  
			  $('#crDate').val($('#rtr2 td:last').html());
			  $('#crDate').css('font-weight', 'bold');	
			  trId = $(this).attr('id');
			  $('.reviewlowerconatiner').hide();
			  $('#crDetails').show();
		});
		$('#rtr3').click( function(){
			  $('.reviewmaindetails').fadeIn();
			  $('#crName').val($('#rtr3 td:first').html());
			  $('#crName').css('font-weight', 'bold');			  
			  $('#crDate').val($('#rtr3 td:last').html());
			  $('#crDate').css('font-weight', 'bold');	
			  trId = $(this).attr('id');
			  $('.reviewlowerconatiner').hide();
			 $('#crDetails').show();
		});
		$('#rtr4').click( function(){
			  $('.reviewmaindetails').fadeIn();
			  $('#crName').val($('#rtr4 td:first').html());
			  $('#crName').css('font-weight', 'bold');			  
			  $('#crDate').val($('#rtr4 td:last').html());
			  $('#crDate').css('font-weight', 'bold');	
			  trId = $(this).attr('id');
			  $('.reviewlowerconatiner').hide();
			 $('#crDetails').show();
		});
		
		//details link
		$('#crDetails').click( function(e){
			e.preventDefault();
			if(trId == 'rtr1')
			{
				$('.reviewlowerconatiner').fadeIn();
				//$('.reviewtree').html('Tree structure for ' + $('#rtr1 td:first').html());
			}
			else if(trId == 'rtr2')
			{
				$('.reviewlowerconatiner').fadeIn();
				//$('.reviewtree').html('Tree structure for ' + $('#rtr2 td:first').html());
			}
			else if(trId == 'rtr3')
			{
				$('.reviewlowerconatiner').fadeIn();
				//$('.reviewtree').html('Tree structure for ' + $('#rtr3 td:first').html());
			}
			else if(trId == 'rtr4')
			{
				$('.reviewlowerconatiner').fadeIn();
				//$('.reviewtree').html('Tree structure for ' + $('#rtr4 td:first').html());
			}
			else{
				alert('Please select one from above !!');
			}
		});
		
		//bottom buttons for content and playbook
		$('#crContent').click( function(e){
			e.preventDefault();
			alert('Open page for review content !!');
		});
		
		$('#crPlay').click( function(e){
			e.preventDefault();
			alert('Open page for review playbook !!');
		});
		
		//comment options
		var comment;
		$('#showCom').change( function(){
			comment = $('#showCom option:selected').val();		
			if(comment == 'all')
			{
				$('#closedtr1').show();
				$('#closedtr2').show();
				$('#closedtr3').show();
				$('#closedtr4').show();
				$('#opentr1').show();
				$('#opentr2').show();
				$('#opentr3').show();
				$('#ignoredtr1').show();
			}
			else if(comment == 'open')
			{
				
				$('#closedtr1').hide();
				$('#closedtr2').hide();
				$('#closedtr3').hide();
				$('#closedtr4').hide();
				$('#ignoredtr1').hide();
				$('#opentr1').show();
				$('#opentr2').show();
				$('#opentr3').show();
				
			}
			else if(comment == 'closed')
			{
				$('#closedtr1').show();
				$('#closedtr2').show();
				$('#closedtr3').show();
				$('#closedtr4').show();
				$('#opentr1').hide();
				$('#opentr2').hide();
				$('#opentr3').hide();
				$('#ignoredtr1').hide();
				
			}
			else if(comment == 'ignored')
			{
				$('#closedtr1').hide();
				$('#closedtr2').hide();
				$('#closedtr3').hide();
				$('#closedtr4').hide();
				$('#opentr1').hide();
				$('#opentr2').hide();
				$('#opentr3').hide();
				$('#ignoredtr1').show();
			}
			else
			{
				alert('Please select one');
			}
		});
		
		//add new comment
				
		$('#aCom').click( function(e){
			e.preventDefault();
			$("#reviewtable tbody").append("<tr><td><input type='text' placeholder='Component name..' /></td><td><input type='text' placeholder='Your comment..' /></td><td><input type='text' style='width:60px;' placeholder='Security..' /></td><td><input type='text' placeholder='Status..' style='width:60px;'/></td></tr>");
			$('.reviewtreetable').scrollTop( $('.reviewtreetable').height() )

		});
		
		//delete comment
		var rowSelect;
		$('#reviewtable tr').click( function(){
			rowSelect = $(this).attr('id');
		});
		
		$('#dCom').click( function(e){
			e.preventDefault();
			if(rowSelect)
			{
			var checkstr =  confirm('Are you sure to Delete!!');
							if(checkstr == true){
								$('#'+rowSelect).fadeOut();
							}else{
							return false;
							}
			}
			else
			{
				alert('Select a comment to delete!');
			}
			
		});
		
		//save form
		$('#crSave').click( function(e){
			e.preventDefault();
			var checkstr =  confirm('Are you sure to Save!!');
							if(checkstr == true){
							alert('Saved!');
							}else{
							return false;
						} 
		});
		
		$('#crReturn').click( function(e){
			e.preventDefault();
			var checkstr =  confirm('Are you sure to go back to the previous state!!');
							if(checkstr == true){
							$('.reviewmaindetails').hide();
							$('.reviewlowerconatiner').hide();
							$('#crDetails').hide();
							}else{
							return false;
						} 
		});
		     
    });
