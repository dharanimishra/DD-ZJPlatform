	$(document).ready(function() {
	
		  
			  <!-- FOR ZMeeting-->
			  <!-- hiding at the start -->
	$("#advance_search_form").hide();
 	$("#linksMeeting").hide();
	$("#afterClick").hide();
	
	//on click of details show the Meeting inside the panel
	$("#msg1").click(function () {		
   		$("#linksMeeting").fadeIn();
		var val1 = $("#tr1 td:first").html();
		$("#clickedMeeting").val(val1);
		$("#afterClick").hide();
	});
		
	$("#msg2").click(function () {		
   		$("#linksMeeting").fadeIn();
		var val1 = $("#tr2 td:first").html();
		$("#clickedMeeting").val(val1);
		$("#afterClick").hide();
	});
	
	$("#msg3").click(function () {		
   		$("#linksMeeting").fadeIn();
		var val1 = $("#tr3 td:first").html();
		$("#clickedMeeting").val(val1);
		$("#afterClick").hide();
	});
	
	//reply, replyall and forward
	$("#_new").click(function () {		
   		$("#afterClick").fadeIn('slow');
		$("#afterClick").val("Create new..");
	});
	
	$("#_accept").click(function () {		
   		$("#afterClick").fadeIn('slow');
		$("#afterClick").val("Accept this.. ");
	});
	
	$("#_Reject").click(function () {		
   		$("#afterClick").fadeIn('slow');
		$("#afterClick").val("Reject this..");
	});
	//Search show and hide	
	$("#btn_advance").click(function () {		
    $("#advance_search_form").toggle("slow");
	});
	
	
	$("#btn_exit").click(function () {
    $("#advance_search_form").hide("slow");
    });
	
	//for zStats
	
	
		$('#zCategoryStats').change(function(){
			
			if($(this).val() == "Month")
			{
				
				$("#data2").hide();
				$("#data1").show();
			}
			
			else if($(this).val() == "Week")
			{
				$("#data2").show();
				$("#data1").hide();
			}
			
			else
			{
				$("#data1").show();
				$("#data2").show();
			}

		});


	
			  
});