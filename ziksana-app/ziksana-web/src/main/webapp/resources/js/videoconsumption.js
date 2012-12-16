// JavaScript Document/* for video consumption */
	
	$(document).ready(function() {
		$('.educatoroverlay').hide();
		$('.mynotesoverlay').hide();
		$('.bookmarkoverlay').hide();
		$('.contactoverlay').hide();
		$('.wikioverlay').hide();
		$('.booksoverlay').hide();
		$('.notesoverlay').hide();
		

	
	
	$('#btnmynotes').click( function(){
		$('.mynotesoverlay').show();
		$('.educatoroverlay').hide();
		$('.contactoverlay').hide();
		$('.bookmarkoverlay').hide();
		$('.wikioverlay').hide();
		$('.booksoverlay').hide();
		$('.notesoverlay').hide();
	});
	
	$('#btnmybookmarks').click( function(){
		$('.bookmarkoverlay').show();
		$('.mynotesoverlay').hide();
		$('.educatoroverlay').hide();
		$('.contactoverlay').hide();
		$('.wikioverlay').hide();
		$('.booksoverlay').hide();
		$('.notesoverlay').hide();
		
	});
	
	$('#btnmycircle').click( function(){
	    $('.contactoverlay').show();
		$('.bookmarkoverlay').hide();
		$('.mynotesoverlay').hide();
		$('.educatoroverlay').hide();
		$('.wikioverlay').hide();
		$('.booksoverlay').hide();
		$('.notesoverlay').hide();
	
		
	});
	
	$('#btneducatorflv').click( function(){
	   $('.educatoroverlay').slideToggle('fast');
	    $('.contactoverlay').hide();
		$('.bookmarkoverlay').hide();
		$('.mynotesoverlay').hide();
		$('.wikioverlay').hide();
		$('.booksoverlay').hide();
		$('.notesoverlay').hide();
		
	
		
	});
	
	
	$('#btnwikiflv').click( function(){
			$('.wikioverlay').slideToggle('fast');
	   $('.educatoroverlay').hide();
	    $('.contactoverlay').hide();
		$('.bookmarkoverlay').hide();
		$('.mynotesoverlay').hide();
	
		$('.booksoverlay').hide();
		$('.notesoverlay').hide();
	
	});
	
	$('#btnbooksflv').click( function(){
	  $('.booksoverlay').slideToggle('fast');
	  $('.wikioverlay').hide();
	   $('.educatoroverlay').hide();
	    $('.contactoverlay').hide();
		$('.bookmarkoverlay').hide();
		$('.mynotesoverlay').hide();
	
		$('.notesoverlay').hide();
	
	});
	
		$('#btnnotesflv').click( function(){
	  
	  $('.notesoverlay').slideToggle('fast');
	
	  $('.booksoverlay').hide();
	  $('.wikioverlay').hide();
	   $('.educatoroverlay').hide();
	    $('.contactoverlay').hide();
		$('.bookmarkoverlay').hide();
		 $('.mynotesoverlay').hide();
		
	});
	
	
	
	$('.btncloseeducatoroverlay').click( function(){
	   $('.educatoroverlay').hide();
	    $('.contactoverlay').hide();
		$('.bookmarkoverlay').hide();
		$('.mynotesoverlay').hide(); 
		$('.wikioverlay').hide();
		$('.booksoverlay').hide();
		$('.notesoverlay').hide();
	
	});
	
	
	});