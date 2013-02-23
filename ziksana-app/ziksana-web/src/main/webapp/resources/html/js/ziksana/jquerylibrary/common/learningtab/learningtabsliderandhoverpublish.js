// JavaScript Document

$(document).ready(function(e) {
	
	$(".arrow").css('margin-left', '480px');
	
		$(".trcontentwrapper").animate({left:'635px', width:'+=638px'},500);
		//$(".trcontentwrapper").css('position','inherit');
	
	$("#buildtab").click(function(e) {
        window.location.href = 'createlpdefineprogram.html';
    });
	
	$("#reviewtab").click(function(e) {
        window.location.href = 'createlpreviewplaybook.html';
    });
	
	//$("#buildtab").attr('disabled','disabled');
	//$("#buildtab").css('cursor','default');
	
	//$("#reviewtab").attr('disabled','disabled');
	//$("#reviewtab").css('cursor','default');
	
	//arrow for the build and review and publish hover
	
	$('.arrow').show();
	$('#publishtab').css('border-bottom-color' ,'#c60');
	$('#publishtab').css('border-bottom-width', '2px');
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
 

