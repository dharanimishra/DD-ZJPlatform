// JavaScript Document
 $(document).ready(function(e) {
    
   $("#membertable tr").click(function(e) {
    	var row = $(this).attr('class');
		//alert(row);
		$("#membertable tr").removeClass('trhover');
		$("#membertable tr").removeClass('oddcolor');
		$("#membertable tr").css('color','#000');
		$(this).addClass('oddcolor');
		$(this).css('color','#FFF');
		//$(this +"td").css('color','#FFF');
	});
	
	 $("#membertable tr").hover(function(e) {
    	var row = $(this).attr('class');
		//alert(row);
		if(!$(this).hasClass('oddcolor'))
		{
		$("#membertable tr").removeClass('trhover');
		//$("#membertable tr").css('color','#000');
		$(this).addClass('trhover');
		//$(this).css('color','#FFF');
		//$(this +"td").css('color','#FFF');
		}
	});
	
	});