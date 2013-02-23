// JavaScript Document

$(document).ready(function(e) {
	
	
	
	
	
		$(".trcontentwrapper").animate({left:'635px', width:'+=638px'},500);
		//$(".trcontentwrapper").css('position','inherit');
	
	$("#reviewtab").attr('disabled','disabled');
	$("#reviewtab").css('cursor','default');
	
	$("#publishtab").attr('disabled','disabled');
	$("#publishtab").css('cursor','default');
	
	//arrow for the build and review and publish hover
	
	$('.arrow').show();
	$('#buildtab').css('border-bottom-color' ,'#c60');
	$('#buildtab').css('border-bottom-width', '2px');
//	$('.arrow').hide();
//   $(".dummy").hover(function(e) {
//	   //alert();
//   $('.arrow').show();
//		$(".dummy").mouseout(function(e){
//		$('.arrow').hide();	
//		
//		});
//   });
   
    $("#tabs li a").hover(function(e) {
	  //alert('ff');
	  var row = $(this).attr('class');
	  
	  $(this).addClass('tabhover tbcategoryhover');
      //alert(row);
	  
   $("#tabs li a").mouseleave(function(e){	
    $(this).removeClass('tabhover tbcategoryhover tbcatcolor');

     });
    });
	
   
     $("")
   
});	
	//review 340px;
	//publish 580px;
 

