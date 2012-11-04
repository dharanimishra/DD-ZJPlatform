$(document).ready(function() {
			
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
		
	$(".contact-pic a#r1").hover( function () {
		$(".contact-pic a#r1").css("background-image", "url(images/socialize/circle2.png)");
		$(".contact-pic a#r1").css("height", "120%");
		$(".contact-pic a#r1").css("width", "120%");
		$(".contact-pic a#r1").css("margin-left", "-8px");
		$(".contact-pic a#r1").css("margin-top", "-8px");
		$(".contact-pic a#r1").fadeIn("slow");
		},
		function () {
			$(".contact-pic a#r1").css("background-image", "url(images/socialize/circle.png)");
			$(".contact-pic a#r1").css("height", "100%");
			$(".contact-pic a#r1").css("width", "100%");
			$(".contact-pic a#r1").css("margin-left", "0px");
			$(".contact-pic a#r1").css("margin-top", "0px");
			$(".contact-pic a#r1").fadeIn("slow");
    });

	$(".contact-pic a#r2").hover( function () {
		$(".contact-pic a#r2").css("background-image", "url(images/socialize/circle2.png)");
		$(".contact-pic a#r2").css("height", "120%");
		$(".contact-pic a#r2").css("width", "120%");
		$(".contact-pic a#r2").css("margin-left", "-8px");
		$(".contact-pic a#r2").css("margin-top", "-8px");
		$(".contact-pic a#r2").fadeIn("slow");
		},
		function () {
			$(".contact-pic a#r2").css("background-image", "url(images/socialize/circle.png)");
			$(".contact-pic a#r2").css("height", "100%");
			$(".contact-pic a#r2").css("width", "100%");
			$(".contact-pic a#r2").css("margin-left", "0px");
			$(".contact-pic a#r2").css("margin-top", "0px");
			$(".contact-pic a#r2").fadeIn("slow");
        });
		 
	$(".contact-pic a#r3").hover( function () {
		$(".contact-pic a#r3").css("background-image", "url(images/socialize/circle2.png)");
		$(".contact-pic a#r3").css("height", "120%");
		$(".contact-pic a#r3").css("width", "120%");
		$(".contact-pic a#r3").css("margin-left", "-8px");
		$(".contact-pic a#r3").css("margin-top", "-8px");
		$(".contact-pic a#r3").fadeIn("slow");
		},
		function () {
			$(".contact-pic a#r3").css("background-image", "url(images/socialize/circle.png)");
			$(".contact-pic a#r3").css("height", "100%");
			$(".contact-pic a#r3").css("width", "100%");
			$(".contact-pic a#r3").css("margin-left", "0px");
			$(".contact-pic a#r3").css("margin-top", "0px");
			$(".contact-pic a#r3").fadeIn("slow");
	});
});

$('.socializemaintabs').tabs();