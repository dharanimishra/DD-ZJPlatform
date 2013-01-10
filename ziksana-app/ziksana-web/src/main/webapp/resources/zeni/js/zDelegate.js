$(document).ready(function(e) {
		//global variable declaration
		var menuItem = $('#menuItem option').attr('id');
		var componentItem;
		$('#menuItem option').hover( function(){
			$(this).css('background-color', 'rgb(30, 163, 193)');
		}, function(){
			$(this).css('background-color', '#FFF');
		});
		//on change of select
		
		
		//hide usage on page load
        $('#usageHistory').hide();
		$("#advance_search_form").hide();
		$('#delegateRight').hide();
		
		//search
		//Search show and hide	
			$("#btn_advance").click(function () {		
			$("#advance_search_form").toggle();
			});
			
			
			$("#btn_exit").click(function () {
			$("#advance_search_form").hide("slow");
			});
		
		//on click of menuitem
		$('#menuItem option').click( function(){
			menuItem = $(this).attr('id');
			alert("Show usage history for " + menuItem);
			$('#usageHistory').fadeIn();
			
			});	
		
			
		//on click of details
		$('#_details').click( function(){
			alert("Show delegate data for " + menuItem);
			$('#delegateRight').fadeIn();
			$('#rightDesc').hide();
			$('#_delegate').val(menuItem);
		});	
		
		//on click of new
		$('#_new').click( function(){
			alert('Clears the form to assign new delegate or view');
			$('#delegateRight').fadeIn();
			$('#rightDesc').hide();
			$('#_delegate').val('');
		});	
		
		//on click of componentitem
		$('#componentItem option').click( function(){
				componentItem = $(this).attr('id');
				alert('show description for ' + componentItem)
				$('#rightDesc').fadeIn();
				$('#_desc').val('Description for ' + componentItem);
		});	
		
		//onclick save
		$('#btn_save').click( function(){
				var checkstr =  confirm('are you sure you want to save this form in current state?');
							if(checkstr == true){
							 alert('This will Save your data !!');
							}else{
							return false;
							}          
		});	
		
		//onclick return
		$('#btn_return').click( function(){
			var checkstr =  confirm('Are you sure to quit!!');
							if(checkstr == true){
							 $('#delegateWrapper').hide();
							}else{
							return false;
							}          
		});	
		
	/*	$('select').change(function() {
    $('option').css('background', 'none');
    $('option:selected').css('backgroundColor', 'red');
}).change();*/

    });