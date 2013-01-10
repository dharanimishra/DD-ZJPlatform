	$(document).ready(function() {
	
		  
			  <!-- FOR zLibrary-->
			  <!-- hiding at the start -->
			  
	$("#advance_search_form").hide();
 	$("#linksMessage").hide();
	$("#showMessage").hide();
	
	//Search show and hide	
	$("#btn_advance").click(function () {		
    $("#advance_search_form").toggle("slow");
	$("#showMessage").hide();
	$("#linksMessage").hide();
	});
	
	$("#btn_top_search").click(function(){
		$("#showMessage").fadeIn();
		$("#advance_search_form").hide();
		$("#linksMessage").hide();
	});
	
	$("#btn_search").click(function(){
		$("#showMessage").fadeIn();
		$("#advance_search_form").slideUp();
		$("#linksMessage").hide();
	});
	
	$("#btn_exit").click(function () {
    $("#advance_search_form").hide("slow");
	$("#linksMessage").hide();
    });
	
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
	
	
			  
});