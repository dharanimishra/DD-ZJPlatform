// login panel
			$(document).ready(function() {
				
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
	
	//<!-- for alert sundip shah-->
	$('.a1').hide();
	$('.a2').hide();
	$('.a3').hide();
	
	$('._sText2').hide();	
	$('._sText3').hide();
	$('._sText4').hide();
	
		
	$('.alert1').hover( function(){
		$('.a1').show();
		$('.alert1').css("background-image", "url(images/background-pattern.jpg)");	
		$('.alert1').css("cursor", "pointer");
	}, function(){
			$('.a1').hide();
			$('.alert1').css("background-image", "");
			
	});
	
	$('.alert1').click( function(){
		$('._sText2').toggle();
	});
	
	$('.aa1').click( function(){
		$('._sText2').fadeOut('slow');
	});
	
	$('.a1').click( function(){
		$('.alert1').fadeOut('slow');
	});
	
	$('.alert2').hover( function(){
		$('.a2').show();
		$('.alert2').css("background-image", "url(images/background-pattern.jpg)");
		$('.alert2').css("cursor", "pointer");
	}, function(){
			$('.a2').hide();
			$('.alert2').css("background-image", "");			
	});
	
	$('.a2').click( function(){
		$('.alert2').fadeOut('slow');
	});
	
	$('.alert3').hover( function(){
		$('.a3').show();
		$('.alert3').css("background-image", "url(images/background-pattern.jpg)");
		$('.alert3').css("cursor", "pointer");
	}, function(){
			$('.a3').hide();
			$('.alert3').css("background-image", "");
	});
	
	$('.a3').click( function(){
		$('.alert3').fadeOut('slow');
	});
	
//<!-- For to-do Sundip Shah-->
	$('.td1').hide();
	$('.td2').hide();
	$('.td3').hide();
		
	$('.todo1').hover( function(){
		$('.td1').show();
		$('.todo1').css("background-image", "url(images/background-pattern.jpg)");
	}, function(){
			$('.td1').hide();
			$('.todo1').css("background-image", "");
	});
	
	$('.td1').click( function(){
		$('.todo1').fadeOut('slow');
	});
	
	$('.todo2').hover( function(){
		$('.td2').show();
		$('.todo2').css("background-image", "url(images/background-pattern.jpg)");
	}, function(){
			$('.td2').hide();
			$('.todo2').css("background-image", "");
	});
	
	$('.td2').click( function(){
		$('.todo2').fadeOut('slow');
	});
	
	$('.todo3').hover( function(){
		$('.td3').show();
		$('.todo3').css("background-image", "url(images/background-pattern.jpg)");
	}, function(){
			$('.td3').hide();
			$('.todo3').css("background-image", "");
	});
	
	$('.td3').click( function(){
		$('.todo3').fadeOut('slow');
	});
	
	//<!-- contact and recomendation tabs to links Sundip Shah-->
	

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
	
	//<!-- for calendar -->
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
	
	/* for classbox */
	//<!-- added by sundip shah --> 
 
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
				
				
			$(".signin").click(function(e) {          
			e.preventDefault();
			$("fieldset#signin_menu").toggle();
			$(".signin").toggleClass("menu-open");
			});

			$("fieldset#signin_menu").mouseup(function() {
			return false
			});
			$(document).mouseup(function(e) {
			if($(e.target).parent("a.signin").length==0) {
			$(".signin").removeClass("menu-open");
			$("fieldset#signin_menu").hide();
			}
			});			






		});
//username-help
		$(function() {
		$('#forgot_username_link').tipsy({gravity: 'w'});   
		});


//fancyboxes
	$(function() {
	$("a.lbx-100").fancybox({
				'width'				: '100%',
				'height'			: '95%',
				'autoScale'			: false,
				'transitionIn'		: 'elastic',
				'transitionOut'		: 'elastic',
				'type'				: 'iframe'
				
			});
			
//enrich,			
	$("a.lbx-45-25").fancybox({
				'width'				: 500,
				'height'			: 300,
				'autoScale'			: false,
				'transitionIn'		: 'elastic',
				'transitionOut'		: 'elastic',
				'type'				: 'iframe'
			});	
//status
	$("a.lbx-70-50").fancybox({
				'width'				: 700,
				'height'			: 500,
				'autoScale'			: false,
				'transitionIn'		: 'elastic',
				'transitionOut'		: 'elastic',
				'type'				: 'iframe'
			});	
	
//todo fancybox
	$("a.todo_fancybox").fancybox({
		'width'				: 700,
		'height'			: 700,
		'autoScale'			: false,
		'transitionIn'		: 'elastic',
		'transitionOut'		: 'elastic',
		'type'				: 'iframe',
		'afterClose': function(){get_and_populate_todo();}
		
	});		

	//alert fancybox
	$("a.alert_fancybox").fancybox({
		'width'				: 700,
		'height'			: 700,
		'autoScale'			: false,
		'transitionIn'		: 'elastic',
		'transitionOut'		: 'elastic',
		'type'				: 'iframe',
		'afterClose': function(){get_and_populate_alerts();}
		
	});	
	
//status
	$("a.lbx-80-50").fancybox({
				'width'				: 450,
				'height'			: 450,
				'autoScale'			: false,
				'transitionIn'		: 'elastic',
				'transitionOut'		: 'elastic',
				'type'				: 'iframe'
			});		
			
			//status
	$("a.lbx-small").fancybox({
				'width'				: 400,
				'height'			: 200,
				
				'transitionIn'		: 'elastic',
				'transitionOut'		: 'elastic'
				
				
			});						
	});	
	
					
//fancyboxes end


//progress bars
	$(function() {
		$( "#progressbar30" ).progressbar({
			value: 30
		});
		
		$( "#progressbar60" ).progressbar({
			value: 60
		});
		$( "#progressbar80" ).progressbar({
			value: 80
		});	
		$( "#progressbar65" ).progressbar({
			value: 65
		});		
	});

//
	$(function() {
		
$('input[type="text"], textarea').each(function(){

	this.value = $(this).attr('title');
	this.value="";
	$(this).addClass('text-label');

	$(this).focus(function(){	    
		if(this.value == $(this).attr('title')) {
			this.value = '';
			$(this).removeClass('text-label');			
		}
	});

	$(this).blur(function(){
		if(this.value == '') {
			this.value = $(this).attr('title');
			this.value="";
			$(this).addClass('text-label');
		}
	});
});
	
	
	});

//tipsy
$(function() {
   $('a[rel=tipsy]').tipsy({fade: true});
 });

//search 
 
   $(function() {
				
				var $ui 		= $('#ui_element');
				
				$ui.find('#search').bind('focus click',function(){
					$ui.find('.sb_down')
					   .addClass('sb_up')
					   .removeClass('sb_down')
					   .andSelf()
					   .find('.sb_dropdown')
					   .show();
				});
				
				$ui.bind('mouseleave',function(){
					$ui.find('.sb_up')
					   .addClass('sb_down')
					   .removeClass('sb_up')
					   .andSelf()
					   .find('.sb_dropdown')
					   .hide();
				});
				
				$ui.find('.sb_dropdown').find('label[for="all"]').prev().bind('click',function(){
					$(this).parent().siblings().find(':checkbox').attr('checked',this.checked).attr('disabled',this.checked);
				});
            });
 
 