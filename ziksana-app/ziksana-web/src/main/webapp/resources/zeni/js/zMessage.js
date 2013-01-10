	$(document).ready(function() {
	
		  
			  <!-- FOR Zmessage-->
			  <!-- hiding at the start -->
	$("#advance_search_form").hide();
 	$("#linksMessage").hide();
	$("#afterClick").hide();
	
	//on click of details show the message inside the panel
	$("#msg1").click(function () {		
   		$("#linksMessage").fadeIn();
		var val1 = $("#tr1 td:first").html();
		$("#clickedMessage").val(val1);
		$("#afterClick").hide();
	});
		
	$("#msg2").click(function () {		
   		$("#linksMessage").fadeIn();
		var val1 = $("#tr2 td:first").html();
		$("#clickedMessage").val(val1);
		$("#afterClick").hide();
	});
	
	$("#msg3").click(function () {		
   		$("#linksMessage").fadeIn();
		var val1 = $("#tr3 td:first").html();
		$("#clickedMessage").val(val1);
		$("#afterClick").hide();
	});
	
	//reply, replyall and forward
	$("#_reply").click(function () {		
   		$("#afterClick").fadeIn('slow');
		$("#afterClick").val("Reply to the person..");
	});
	
	$("#_replyAll").click(function () {		
   		$("#afterClick").fadeIn('slow');
		$("#afterClick").val("Reply to all..");
	});
	
	$("#_forward").click(function () {		
   		$("#afterClick").fadeIn('slow');
		$("#afterClick").val("Forward this..");
	});
	//Search show and hide	
	$("#btn_advance").click(function () {		
    $("#advance_search_form").toggle("slow");
	});
	
	
	$("#btn_exit").click(function () {
    $("#advance_search_form").hide("slow");
    });
			  
});