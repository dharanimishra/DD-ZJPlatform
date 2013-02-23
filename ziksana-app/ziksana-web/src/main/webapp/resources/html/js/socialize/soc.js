$(document).ready(function() {
			

			  $('#clcourse').hide();
			  $('#clmodule').hide();
			   $('#claggregrate').hide();
			$('#tab_reviewers').click(function()
			{
				alert("hai");
			});
			
			$('#node_2').click( function(){
				$("#li-1").show();
			});
			
			$('#node_4').click( function(){
				$("#li-2").show();
			});
			
			$('#_node_6').click( function(){
				$("#li-3").show();
			});
			
			$("#content1").change( function () { 
			var c = this.checked ? '#F8F8F8' : '#e7e6e6';
			   $('#li-1').css('background-color',c);
			  				
    });
			
			
			$("#content2").change( function () { 
			var c = this.checked ? '#F8F8F8' : '#e7e6e6';
			   $('#li-2').css('background-color',c);
				
    });
	
	
			$("#content3").change( function () { 
			var c = this.checked ? '#F8F8F8' : '#e7e6e6';
			   $('#li-3').css('background-color',c);
				
    });
	
	
	
	
	$("#type1").change( function () { 
			var c = this.checked ? '#F8F8F8' : '#e7e6e6';
			   $('#td-1').css('background-color',c);			   
			  				
    });
			
			
			$("#type2").change( function () { 
			var c = this.checked ? '#F8F8F8' : '#e7e6e6';
			   $('#td-2').css('background-color',c);
				
    });
	
	
			$("#type3").change( function () { 
			var c = this.checked ? '#F8F8F8' : '#e7e6e6';
			   $('#td-3').css('background-color',c);
				
    });
	
		
	$(".contact-pic a#r1").hover( function () {
		$(".contact-pic a#r1").css("background-image", "url(../images/socialize/circle2.png)");
		$(".contact-pic a#r1").css("height", "120%");
		$(".contact-pic a#r1").css("width", "120%");
		$(".contact-pic a#r1").css("margin-left", "-8px");
		$(".contact-pic a#r1").css("margin-top", "-8px");
		$(".contact-pic a#r1").fadeIn("slow");
		},
		function () {
          $(".contact-pic a#r1").css("background-image", "url(../images/socialize/circle.png)");
		  $(".contact-pic a#r1").css("height", "100%");
		$(".contact-pic a#r1").css("width", "100%");
		$(".contact-pic a#r1").css("margin-left", "0px");
		$(".contact-pic a#r1").css("margin-top", "0px");
		$(".contact-pic a#r1").fadeIn("slow");
         });

	$(".contact-pic a#r2").hover( function () {
		$(".contact-pic a#r2").css("background-image", "url(../images/socialize/circle2.png)");
		$(".contact-pic a#r2").css("height", "120%");
		$(".contact-pic a#r2").css("width", "120%");
		$(".contact-pic a#r2").css("margin-left", "-8px");
		$(".contact-pic a#r2").css("margin-top", "-8px");
		$(".contact-pic a#r2").fadeIn("slow");
		},
		function () {
          $(".contact-pic a#r2").css("background-image", "url(../images/socialize/circle.png)");
		  $(".contact-pic a#r2").css("height", "100%");
		$(".contact-pic a#r2").css("width", "100%");
		$(".contact-pic a#r2").css("margin-left", "0px");
		$(".contact-pic a#r2").css("margin-top", "0px");
		$(".contact-pic a#r2").fadeIn("slow");
         });
		 
		 $(".contact-pic a#r3").hover( function () {
		$(".contact-pic a#r3").css("background-image", "url(../images/socialize/circle2.png)");
		$(".contact-pic a#r3").css("height", "120%");
		$(".contact-pic a#r3").css("width", "120%");
		$(".contact-pic a#r3").css("margin-left", "-8px");
		$(".contact-pic a#r3").css("margin-top", "-8px");
		$(".contact-pic a#r3").fadeIn("slow");
		},
		function () {
          $(".contact-pic a#r3").css("background-image", "url(../images/socialize/circle.png)");
		  $(".contact-pic a#r3").css("height", "100%");
		$(".contact-pic a#r3").css("width", "100%");
		$(".contact-pic a#r3").css("margin-left", "0px");
		$(".contact-pic a#r3").css("margin-top", "0px");
		$(".contact-pic a#r3").fadeIn("slow");
         });
		 
		  $(".contact-pic a#r4").hover( function () {
		$(".contact-pic a#r4").css("background-image", "url(../images/socialize/circle2.png)");
		$(".contact-pic a#r4").css("height", "120%");
		$(".contact-pic a#r4").css("width", "120%");
		$(".contact-pic a#r4").css("margin-left", "-8px");
		$(".contact-pic a#r4").css("margin-top", "-8px");
		$(".contact-pic a#r4").fadeIn("slow");
		},
		function () {
          $(".contact-pic a#r4").css("background-image", "url(../images/socialize/circle.png)");
		  $(".contact-pic a#r4").css("height", "100%");
		$(".contact-pic a#r4").css("width", "100%");
		$(".contact-pic a#r4").css("margin-left", "0px");
		$(".contact-pic a#r4").css("margin-top", "0px");
		$(".contact-pic a#r4").fadeIn("slow");
         });
		 
		 
		 $('._rev').click( function(){
			 $('#form1').fadeIn();
			  $('#form2').hide();
			  $('#form3').hide();
			   $('#form4').hide();
			    $('#clcourse').hide();
			  $('#clmodule').hide();
			   $('#claggregrate').hide();
		 });
		 
		  
		 
		 
		 
		  $('#form2').hide();
		 
	$('._comp').click( function(){
			 $('#form2').fadeIn();
			  $('#form1').hide();
			  $('#form3').hide();
			   $('#form4').hide();
			     $('#clcourse').hide();
			  $('#clmodule').hide();
			   $('#claggregrate').hide();
	});
	
	 $('#form3').hide();
		 
	$('._inP').click( function(){
		$('#form3').fadeIn();
			 $('#form2').hide();
			  $('#form1').hide();
			   $('#form4').hide();
			     $('#clcourse').hide();
			  $('#clmodule').hide();
			   $('#claggregrate').hide();
	});
	
	 $('#form4').hide();
		 
	$('._dec').click( function(){
		 $('#form4').fadeIn();
		$('#form3').hide();
			 $('#form2').hide();
			  $('#form1').hide();
			    $('#clcourse').hide();
			  $('#clmodule').hide();
			   $('#claggregrate').hide();
	});
	
	/* for nodes_playbook.html */
	
	$('.node1').hide();
	$('.node2').hide();
	$('.node3').hide();
	$('.node4').hide();
	$('._nd1').click( function(){
		$('.node1').fadeIn();
		$('._info').hide();
		$('.node3').hide();
		$('.node4').hide();
		$('.node2').hide();
	});
	$('._nd2').click( function(){
		$('.node2').fadeIn();
		$('._info').hide();
		$('.node1').hide();
		$('.node3').hide();
		$('.node4').hide();
	});
	$('._nd3').click( function(){
		$('.node3').fadeIn();
		$('._info').hide();
		$('.node1').hide();
		$('.node2').hide();
		$('.node4').hide();
	});
	$('._nd4').click( function(){
		$('.node4').fadeIn();
		$('._info').hide();
		$('.node1').hide();
		$('.node2').hide();
		$('.node3').hide();
	});

});
	
	$(function() {
		var availableTags = [
			"Anthony",
			"Anna",
			"Brian",
			"Brad",
			"Curtney",
			"Clara",
			"Comorthy",
			"Eric",
			"Frank",
			"Greham",
			"Harry",
			"John",
			"Lilla",
			"Peter",
			"Ruby",
			"Stacy"
		];
		$( "#tags" ).autocomplete({
			source: availableTags
		});
		$( "#tags1" ).autocomplete({
			source: availableTags
		});
		$( "#tags2" ).autocomplete({
			source: availableTags
		});
		$( "#tags3" ).autocomplete({
			source: availableTags
		});
		
		
		
		
	});
	
	