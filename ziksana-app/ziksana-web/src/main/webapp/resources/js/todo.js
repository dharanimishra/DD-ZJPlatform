$(document).ready(function () {
	var counter = 5;
	//$("#contodo5").hide();
   
    
   $("#addatodolink").click(function(e) {
    	$("#contodo5").show();
		$("#contodo4").show();
		$("#fifthrow").show();
		$("#todobody").append('<tr width="100%" class="todocontainer todoinfo" style="height:28px;padding:5px;" id=contodos><td width="20px" class="todoinfo-icon" style="float:left; padding-right:10px;"><img src="../images/icons/todo.png" alt="Info" /></td><td width="40px" class="todoinfo-category" style="margin-top:7px; padding-right:10px;" id=todoinfo-category'+counter+'></td><td class="todoinfo-decription" style="margin-top:7px;" id="todoinfo-decription5" ><div width="300px" id=demo-basictodo'+counter+' style="font-weight:lighter; cursor:pointer; width:225px;"></div></td><td width="20px" class="todoinfo-button" style="padding-top:7px;" ><a href="#linkurl" rel="tipsy" title="Complete"><input type="checkbox" id=cktodo'+counter+'> </a></td></tr>');
//
		var a;
		
	    a = document.getElementById('Todocategory').value
		$("#todoinfo-category"+ counter).append(a);
//		
//		document.write +=(a);
//		
//		
		
		 var b;
		 b = document.getElementById('tododescriptionvalue').value
		 $("#demo-basictodo"+ counter).append(b);
		// document.write +=(b);
		
		 
		 $("#cktodo"+counter).click(function(e) {
           $("#contodos").remove();
        });
		 
		 
		
		  var hoverHTMLDemoBasic = ' ' + 'We welcome you to join us on our seminar on Artificial intelligence.';
		  $("#demo-basictodo"+counter).hovercard({
          detailsHTML: hoverHTMLDemoBasic,
          width: 300,
		  });
		  counter++;
	});
   
  $('#cktodo1').click( function(){
		$('#contodo1').hide('fast');
	});
	
	
	$('#cktodo2').click( function(){
		$('#contodo2').hide('fast');
	});
	
	$('#cktodo3').click( function(){
		$('#contodo3').hide('fast');
	});  
   

});