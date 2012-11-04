// JavaScript Document by Sundip Shah

$(document).ready(function(){   

	$('.pollResults').hide(); 
	$('._vote').click( function(){
		$('.pollResults').show('fast');
		$('.poll-container').hide();
		$('._load').show('slow');
	});
	
	$('._voteAgain').click( function(){
		$('.pollResults').hide();
		$('.poll-container').fadeIn('fast');
	});

	//	<!-- contact and recomendation tabs to links Sundip Shah-->
	
	$('.tab0').click( function(){
		$('.tabs-0').fadeIn();
		$('.tabs-2').hide();
		$('.tabs-1').hide();
		$('.tabs-3').hide();
	});
	
	$('.tabs-1').hide();
	$('.tab1').click( function(){
		$('.tabs-1').fadeIn();
		$('.tabs-0').hide();
		$('.tabs-2').hide();
		$('.tabs-3').hide();
	});
	
	$('.tabs-2').hide();
	$('.tab2').click( function(){
		$('.tabs-2').fadeIn();
		$('.tabs-1').hide();
		$('.tabs-0').hide();
		$('.tabs-3').hide();
	});
	
	$('.tabs-3').hide();
	$('.tab3').click( function(){
		$('.tabs-3').fadeIn();
		$('.tabs-2').hide();
		$('.tabs-1').hide();
		$('.tabs-0').hide();
	});
	
	/* Zeni recommendation Sundip Shah*/
	
	$('.rec0').click( function(){
		$('.rec-0').fadeIn();
		$('.rec-2').hide();
		$('.rec-1').hide();
		
	});
	
	$('.rec-1').hide();
	$('.rec1').click( function(){
		$('.rec-1').fadeIn();
		$('.rec-0').hide();
		$('.rec-2').hide();
		
	});
	
	$('.rec-2').hide();
	$('.rec2').click( function(){
		$('.rec-2').fadeIn();
		$('.rec-1').hide();
		$('.rec-0').hide();
		
	});
	
//	<!-- for calendar -->
$('._e1').fadeIn("slow");
	$('._current').click( function(){
		$(this).css("background-image", " url(images/front-bg.gif)");
		$('._e1').fadeIn('slow');
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
	
	/* for classbox */
//	<!-- added by sundip shah --> 
 
 $("#new_comment").hide();
 $("#btn_comment").click(function() {
  $("# dash-bord-bar").append("<br/>");
  $("#new_comment").toggle('fast');
  $("#new_comment").val("Enter a comment");
  
 });
 
 $("#new_comment").keyup(function(event){
    if(event.keyCode == 13){
       var newcomment = $("#new_comment").val();
	  
	     $(".comments-container").append("<br/>").val();
	  $(".comments-container").append($("#new_comment").val());
	 
	   $(".comments-container").append("<br/>").val();
		
			 }
});
// <!-- upto here -->
	
}); 