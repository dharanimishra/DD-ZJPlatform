	
	
	
	$(document).ready(function() {
	
		  
			  <!-- FOR ZGroup-->
			  <!-- hiding at the start -->

 	$("#linksGroup").hide();
	
	
	//on click of details show the Group inside the panel
	$("#msg1").click(function () {		
   		$("#linksGroup").fadeIn();
		var val1 = $("#tr1 td:first").html();
		$("#clickedGroup").val("List of activities by : " + val1);
		$("#afterClick").hide();
	});
		
	$("#msg2").click(function () {		
   		$("#linksGroup").fadeIn();
		var val1 = $("#tr2 td:first").html();
		$("#clickedGroup").val("List of activities by : " + val1);
		$("#afterClick").hide();
	});	
	
	
	<!-- For JAnnouncement -->
	
	$(".zAnn").hide();
	$("#_required").hide();
		
	$("#_go").click(function () {
		if($("#vDate").val()!="")
		{	$("#zReturn").show();	
   			$(".zAnn").fadeIn();
			$("#_required").slideUp();
		}
		else
		{
			$("#_required").show("slow");
			$(".zAnn").hide();
		}
	});	
	
			  
});