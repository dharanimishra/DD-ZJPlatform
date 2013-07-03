// JavaScript Document

$(document).ready(function(e) {
    
	$('._plainText').hide();
		$('#._richTextShow').hide();
		
		$('._richText').click( function(){
			$('._richText').hide();
			$('._plainTextShow').hide();
			$('._plainText').show();
			$('._richTextShow').show();
		});
		
		$('._plainText').click( function(){
			$('._richText').show();
			$('._plainTextShow').show();
			$('._plainText').hide();
			$('._richTextShow').hide();
		});
	
});
