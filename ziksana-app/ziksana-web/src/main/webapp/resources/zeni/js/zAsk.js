// JavaScript Document
$(document).ready(function(e) {

	//for zask search
	
	 <!-- hiding at the start -->
			  
	$("#advance_search_form").hide();
 	$("#_qBox").hide();
	$("#_sel").hide();
	$("#_sel2").hide();
	$("#_ansTxt").hide();
	//Search show and hide	
	$("#btn_advance").click(function () {		
    	$("#advance_search_form").toggle("slow");
		$("#_qBox").hide();
	});
	
	$("#btn_top_search").click(function(){
		
		$("#advance_search_form").hide();
		$("#_qBox").fadeIn();
		
	});
	
	$("#btn_search").click(function(){
		
		$("#advance_search_form").slideUp();
		$("#_qBox").fadeIn();
	});
	
	$("#btn_exit").click(function () {
    $("#advance_search_form").hide("slow");
	
    });
	
	$("#_rate").click(function () {
    $("#_sel").show("slow");
	$("#_sel2").hide("slow");
    });
	$("#_rate2").click(function () {
    $("#_sel2").show("slow");
	$("#_sel").hide("slow");
    });
	
	$("#_answer").click(function () {
    	$("#_ansTxt").toggle("slow");
		
		
		
    });
	
	$("#_cancel").click(function () {
    	$("#_ansTxt").hide("slow");
		
		
		
    });
});