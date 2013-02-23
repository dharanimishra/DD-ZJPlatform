// JavaScript Document

$(document).ready(function(e) {
	
	
	  var hoverHTMLDemoBasic = '' + 'We welcome you to join us on our seminar on Artificial intelligence. ';
$("#demo-basic").hovercard({
        detailsHTML: hoverHTMLDemoBasic,
        width: 300,
        //cardImgSrc: 'http://1.gravatar.com/avatar/30f5be9e9d9b2d0206a08407310759be?s=90&d=http%3A%2F%2F1.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D90&r=G'
    });
	
$("#demo-basic3").hovercard({
        detailsHTML: hoverHTMLDemoBasic,
        width: 300,
		height: 600,
        //cardImgSrc: 'http://1.gravatar.com/avatar/30f5be9e9d9b2d0206a08407310759be?s=90&d=http%3A%2F%2F1.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D90&r=G'
    });
	
	  
$("#demo-basic2").hovercard({
        detailsHTML: hoverHTMLDemoBasic,
        width: 300,
        //cardImgSrc: 'http://1.gravatar.com/avatar/30f5be9e9d9b2d0206a08407310759be?s=90&d=http%3A%2F%2F1.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D90&r=G'
    });
	
	
	
$("#demo-basictodo1").hovercard({
        detailsHTML: hoverHTMLDemoBasic,
        width: 300,
        //cardImgSrc: 'http://1.gravatar.com/avatar/30f5be9e9d9b2d0206a08407310759be?s=90&d=http%3A%2F%2F1.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D90&r=G'
    });
	
	    
$("#demo-basictodo2").hovercard({
        detailsHTML: hoverHTMLDemoBasic,
        width: 300,
        //cardImgSrc: 'http://1.gravatar.com/avatar/30f5be9e9d9b2d0206a08407310759be?s=90&d=http%3A%2F%2F1.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D90&r=G'
    });
	
$("#demo-basictodo3").hovercard({
        detailsHTML: hoverHTMLDemoBasic,
        width: 300,
        //cardImgSrc: 'http://1.gravatar.com/avatar/30f5be9e9d9b2d0206a08407310759be?s=90&d=http%3A%2F%2F1.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D90&r=G'
    });
	
	
	
	//$(".elementlinks").empty();
		$("._cLeft").show();
		$("._cMiddle").show();
		$("._cRight").show();
		$(".todo").hide();
		$(".alert_todo").hide();
	
	$("#calendarlink").hide();
	 $('#alertlink').show();
	  $('#todolink').show();
	 
	 $("#alertlink").click(function(e) {
	 	$('#alertlink').hide();
        $("#calendarlink").show();
	  	$('#todolink').show();
		$("._cLeft").hide();
		$("._cMiddle").hide();
		$("._cRight").hide();
		$(".todo").hide();
		$(".alert_todo").show();
    });
	
	$("#todolink").click(function(e) {
	 	$('#alertlink').show();
        $("#calendarlink").show();
	  	$('#todolink').hide();
		$("._cLeft").hide();
		$("._cMiddle").hide();
		$("._cRight").hide();
		$(".alert_todo").hide();
		$(".todo").show();
    });
	
	$("#calendarlink").click(function(e) {
	 	$('#alertlink').show();
        $("#calendarlink").hide();
	  	$('#todolink').show();
		$(".todo").hide();
		$(".alert_todo").hide();
		$("._cLeft").show();
		$("._cMiddle").show();
		$("._cRight").show();
    });
	
	
	
	// start of calendar
	
	/*for calendar */
$('._e1').fadeIn("slow");
	$('._current').click( function(){
		$(this).css("background-image", " url(images/front-bg.gif)");
		/*$('._e1').fadeIn('slow');*/
		
		$('._e1').fadeIn("slow");
		$('._e2').hide();
		$('._e3').hide();
		$('._e4').hide();
		$('._up1').css("background-image", "");
		$('._up2').css("background-image", "");
		$('._up3').css("background-image", "");
	});
	$('._e2').hide();
	$('._up1').click( function(){
		$(this).css("background-image", " url(images/front-bg.gif)");
		$('._e2').fadeIn('slow');
		$('._e1').hide();
		$('._e3').hide();
		$('._e4').hide();
		$('._current').css("background-image", "");
		$('._up2').css("background-image", "");
		$('._up3').css("background-image", "");
		
	});
	
	$('._e3').hide();
	$('._up2').click( function(){
		$(this).css("background-image", " url(images/front-bg.gif)");
		$('._e3').fadeIn('slow');
		$('._e4').hide();
		$('._e2').hide();
		$('._e1').hide();
		$('._current').css("background-image", "");
		$('._up1').css("background-image", "");
		$('._up3').css("background-image", "");
	});
	
	$('._e4').hide();
	$('._up3').click( function(){
		$(this).css("background-image", " url(images/front-bg.gif)");
		$('._e4').fadeIn('slow');
		$('._e3').hide();
		$('._e2').hide();
		$('._e1').hide();
		$('._current').css("background-image", "");
		$('._up2').css("background-image", "");
		$('._up1').css("background-image", "");
	});
	
	// end of calendar
	
	
	
	//for to do
			
	$('#btalert1').click( function(){
		$('#conalert1').hide('slow');
	});
	
	$('#btalert2').click( function(){
		$('#conalert2').hide('slow');
	});
	
	$('#btalert3').click( function(){
		$('#conalert3').hide('slow');
	});
	
	$('#cktodo1').click( function(){
		$('#contodo1').hide('slow');
	});
	
	
	$('#cktodo2').click( function(){
		$('#contodo2').hide('slow');
	});
	
	$('#cktodo3').click( function(){
		$('#contodo3').hide('slow');
	});
		
	// end of to do
	
	
	
	// lightbox
	
	
	$("a.lbx-calendar").fancybox({
				'width'				: 950,
				'height'			: 800,
				'autoScale'			: true,
				'transitionIn'		: 'elastic',
				'transitionOut'		: 'elastic',
				'type'				: 'iframe'
			});		
			
		$("a.lbx-70-50").fancybox({
				'width'				: 700,
				'height'			: 500,
				'autoScale'			: false,
				'transitionIn'		: 'elastic',
				'transitionOut'		: 'elastic',
				'type'				: 'iframe'
			});	
	
	//end of lightbox
	
	
	
	
}); // end of document ready