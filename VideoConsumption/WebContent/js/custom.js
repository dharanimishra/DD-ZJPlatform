// login panel
			$(document).ready(function() {
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

	$(function() {
		$( ".btn" ).button({
		
		});
	});
	$(function() {
		$( ".btn-set" ).buttonset();
	});
	
	
/*
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
//status
	$("a.lbx-80-50").fancybox({
				'width'				: 800,
				'height'			: 550,
				'autoScale'			: false,
				'transitionIn'		: 'elastic',
				'transitionOut'		: 'elastic',
				'type'				: 'iframe'
			});							
	});	
	
					
//fancyboxes end
*/

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
	});

//
	$(function() {
		
$('input[type="text"], textarea').each(function(){

	this.value = $(this).attr('title');
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
			$(this).addClass('text-label');
		}
	});
});
	
	
	});

//tipsy
$(function() {
   $('a[rel=tipsy]').tipsy({fade: true});
 });


//###############################################################################################################################	
//Script Name: main.js
//Code below authored by: Arun Prasad.
//###############################################################################################################################	
$(function(){
	
	//Initialize the Vertical Scroller for items-for-today
	$ (".items-for-today").verticalScrollPlus({speed: 300, step: 160, upID: "#ticker-next", downID: "#ticker-previous", scrollerID: "#ticker_items_for_today"});
	$ ("#my_playlist").verticalScrollPlus({speed: 300, step: 160, upID: "#ticker-next2", downID: "#ticker-previous2", scrollerID: "#my_playlist_items"});
	
}); //End of Doc Ready	
	
