	$(document).ready(function() {
	
		  
				//for StrateZ
	 <!-- hiding at the start -->
	$("#advance_search_form").hide();
 	$("#linksMessage").hide();
	$("#afterClick").hide();
	
	//on click of details show the message inside the panel
	$("#msg1").click(function () {		
   		$("#linksMessage").fadeIn();
		var val1 = $("#tr1 td:first").html();
		$("#clickedMessage").val('Additional information for ' + val1);
		
	});
		
	$("#msg2").click(function () {		
   		$("#linksMessage").fadeIn();
		var val1 = $("#tr2 td:first").html();
		$("#clickedMessage").val('Additional information for ' + val1);
		
	});
	
	$("#msg3").click(function () {		
   		$("#linksMessage").fadeIn();
		var val1 = $("#tr3 td:first").html();
		$("#clickedMessage").val('Additional information for ' + val1);
		
	});
	
	
	//Search show and hide	
	$("#btn_advance").click(function () {		
    $("#advance_search_form").toggle("slow");
	});
	
	
	$("#btn_exit").click(function () {
    $("#advance_search_form").hide("slow");
    });
	
	//on load disabled
	$('#search').attr('disabled', 'disabled');
	$('#btn_top_search').attr('disabled', 'disabled');
	$('#btn_advance').attr('disabled', 'disabled');
	
	//radio button display
	$('#mySearch').click( function(){
		$('#mySub').removeAttr('checked');
		$('#search').removeAttr('disabled');
		$('#btn_top_search').removeAttr('disabled');
		$('#btn_advance').removeAttr('disabled');
		$('#myProgram').attr('disabled', 'disabled');
		$('#myCourses').attr('disabled', 'disabled');
		var selectedCourse = $('#search').val();
		$('#selectedCourse').attr('value', selectedCourse);
	});
	
	$('#mySub').click( function(){
		$('#mySearch').removeAttr('checked');
		$('#search').attr('disabled', 'disabled');
		$('#btn_top_search').attr('disabled', 'disabled');
		$('#btn_advance').attr('disabled', 'disabled');
		$('#myProgram').removeAttr('disabled');
		$('#myCourses').removeAttr('disabled');
		//selected course value
		var selectedCourse = $('#myCourses').val();
		$('#selectedCourse').attr('value', selectedCourse);
		
	});
			  
	//for zCollege
	$('#collegeRight').hide();
	var aid;
	
	$('#nodeId').click( function(){
		aid = 	$('#nodeId').attr('id');
		
	});
	
	$('#middleDetails').click( function(){
		if(aid == 'nodeId' )
		{
			$('#collegeRight').fadeIn();
		}
		else
		{
			alert('select a node and than click on arrow');
		}
	});
	
	
});