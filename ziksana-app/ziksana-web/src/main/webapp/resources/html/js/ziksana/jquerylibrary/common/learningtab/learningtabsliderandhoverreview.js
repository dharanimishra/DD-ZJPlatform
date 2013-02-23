// JavaScript Document

$(document).ready(function(e) {
	
	$(".arrow").css('margin-left', '250px');
	
		$(".trcontentwrapper").animate({left:'635px', width:'+=638px'},500);
		//$(".trcontentwrapper").css('position','inherit');
	
	//$("#buildtab").attr('disabled','disabled');
	//$("#buildtab").css('cursor','default');
	
	$("#buildtab").click(function(e) {
        window.location.href = 'createlpdefineprogram.html';
    });
	
	$("#publishtab").attr('disabled','disabled');
	$("#publishtab").css('cursor','default');
	
	//arrow for the build and review and publish hover
	
	$('.arrow').show();
	$('#reviewtab').css('border-bottom-color' ,'#c60');
	$('#reviewtab').css('border-bottom-width', '2px');
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
 

