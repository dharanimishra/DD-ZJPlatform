// JavaScript Document
$(document).ready(function(e) {
	//general click on ignore tab on the top
	$(".ign").click( function(){
			
			$('#container4').isotope({ filter: '.Draft' });
			
		});
	
	//ignore content from the list
    $("#_ignore1").click( function(){
		
	
	
		$("#rec1").hide("slow");
		$("#rec1").removeClass("All");
		$("#rec2").css("margin-top", "0px");
		$("#rec3").css("margin-top", "0px");
		$("#rec4").css("margin-top", "0px");
			$("#_replace").replaceWith('<span id="_replaceWith">Redeemed On : <span class="zlinktext2"> 17/09/2012  </span></span>');
		$(".ign").click( function(){
			$("#rec1").addClass("Draft");
				
			$('#container4').isotope({ filter: '.Draft' });
			$("#rec1").show();
			/*var val1 = $("#_valid").html();
			alert(val1);
			val1 = "Redeemed On :";
			alert(val1);
			document.getElementById("_valid").innerHTML == val1;
			
				var d = new Date();	
				alert(d.getDate());	
				$("#_change").val(d.getDate());*/
		});	
		
	});
	
	 $("#_ignore2").click( function(){
	
		$("#rec2").hide("slow");
		$("#rec2").removeClass("All");
		$("#rec3").css("margin-top", "0px");
		$("#rec4").css("margin-top", "0px");
			$("#_replace2").replaceWith('<span id="_replaceWith">Redeemed On : <span class="zlinktext2"> 17/09/2012  </span></span>');
		$(".ign").click( function(){
			$("#rec2").addClass("Draft");
			$('#container4').isotope({ filter: '.Draft' });
			$("#rec2").show();
		});	
		
	});
	
	$("#_ignore3").click( function(){
	
		$("#rec3").hide("slow");
		$("#rec3").removeClass("All");
		$("#rec4").css("margin-top", "0px");
			$("#_replace3").replaceWith('<span id="_replaceWith">Redeemed On : <span class="zlinktext2"> 17/09/2012  </span></span>');
		$(".ign").click( function(){
			$("#rec3").addClass("Draft");
			$('#container4').isotope({ filter: '.Draft' });
			$("#rec3").show();
		});	
		
	});
	
	$("#_ignore4").click( function(){
	
		$("#rec4").hide("slow");
		$("#rec4").removeClass("All");
			$("#_replace4").replaceWith('<span id="_replaceWith">Redeemed On : <span class="zlinktext2"> 17/09/2012  </span></span>');
		$(".ign").click( function(){
			$("#rec4").addClass("Draft");
			$('#container4').isotope({ filter: '.Draft' });
			$("#rec4").show();
		});	
		
	});
	
	//for zask search
	
	 <!-- hiding at the start -->
			  
	$("#advance_search_form").hide();
 	$("#_qBox").hide();
	
	
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
});