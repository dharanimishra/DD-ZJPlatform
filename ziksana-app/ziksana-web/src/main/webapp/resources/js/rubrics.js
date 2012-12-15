	$(document).ready(function(e) {
		
		//hiding on start
		$('#descArea').hide();
		$('#createRubric').hide();		
		
		//global variable to store ids 
		var selectedid = '';	
		var selectedOption = '';
		//from dropdown list
		$('#usageArea').change( function(){
			selectedOption = $(this).val();
			if(selectedOption == 'Select')
			{
				$('#usageTable tr:first').hide();
				$('#tr1').hide();
				$('#tr2').hide();
				$('#tr3').hide();
				$('#descArea').hide();
			}
			
			if(selectedOption == 'Usage')
			{
				$('#usageTable tr:first').show();
				$('#tr1').fadeIn();
				$('#tr2').fadeIn();
				$('#tr3').fadeIn();		
				$('#descArea').hide();		
			}
			
			if(selectedOption == 'Science')
			{
				$('#usageTable tr:first').show();
				$('#tr1').fadeIn();
				$('#tr2').hide();
				$('#tr3').hide();
				$('#descArea').hide();
			}
			
			if(selectedOption == 'Music')
			{
				$('#usageTable tr:first').show();
				$('#tr2').fadeIn();
				$('#tr1').hide();
				$('#tr3').hide();
				$('#descArea').hide();
			}
			
			if(selectedOption == 'Language')
			{
				$('#usageTable tr:first').show();
				$('#tr3').fadeIn();
				$('#tr1').hide();
				$('#tr2').hide();
				$('#descArea').hide();
			}
			
		});
		
		//on each row will store differen id in global variable
		//you can loop through database and do below procedure in for
		//row1 
		$('#tr1').click( function(){
			$('#selecttr1').attr('checked', 'checked');
				selectedid = $('#tr1 td:first').html();
				$('#tr1').css('background-color', '#FFC');
				$('#tr2').css('background-color', '');
				$('#selecttr2').removeAttr('checked');
				$('#tr3').css('background-color', '');
				$('#selecttr3').removeAttr('checked');
				
				$('#descArea').val("Description for "+selectedid).show();
			});
		//row2	
			$('#tr2').click( function(){
			$('#selecttr2').attr('checked', 'checked');
			selectedid = $('#tr2 td:first').html();
				$('#tr2').css('background-color', '#FFC');
				$('#tr1').css('background-color', '');
				$('#selecttr1').removeAttr('checked');
				$('#tr3').css('background-color', '');
				$('#selecttr3').removeAttr('checked');
				
				$('#descArea').val("Description for "+selectedid).show();
			});
		//row3	
			$('#tr3').click( function(){
			$('#selecttr3').attr('checked', 'checked');
			selectedid = $('#tr3 td:first').html();
				$('#tr3').css('background-color', '#FFC');
				$('#tr1').css('background-color', '');
				$('#selecttr1').removeAttr('checked');
				$('#tr2').css('background-color', '');
				$('#selecttr2').removeAttr('checked');
				
				$('#descArea').val("Description for "+selectedid).show();
			});
			
			
		
			
		
		$('#view').click( function(){
			alert("This will be the details for rubrics '" + selectedid + "'");
		});
		
		$('#clone').click( function(){
			alert("This will make a clone for rubrics '" + selectedid + "'");
		});
		
		$('#return').click( function(){
			alert("Will close the pop-up form");
		});
		
		$('#create').click( function(){
			$('#createRubric').fadeIn();
		});
		
		$('#createReturn').click( function(){
			$('#createRubric').fadeOut();
		});
		
    });