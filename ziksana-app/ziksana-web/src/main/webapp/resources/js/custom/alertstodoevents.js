// JavaScript Document
$(document).ready(function(e) {
$(".contentareaevent").hide();
$(".contentareaalrt").hide();
$(".contentareatodo").hide();  


$(".tagalert").click(function(e) {
	$(".contentareaevent").hide();
	$(".contentareatodo").hide();
	get_and_populate_alerts();
    $(".contentareaalrt").slideDown(200); 
    
});  

$(".tagevent").click(function(e) {
	 $(".contentareaalrt").hide(); 
	 $(".contentareatodo").hide();
    $(".contentareaevent").slideDown(200); 
});

$(".tagtask").click(function(e) {
	 $(".contentareaalrt").hide(); 
    $(".contentareaevent").hide();
    get_and_populate_todo();
	$(".contentareatodo").slideDown(200);
});

});

function short_string(string){
	
	if(string.length > 50){
		return string.substring(0,50)+'...';
	} else {
		return string;
	}	
} 

function get_and_populate_alerts(){
	$.ajax({
	  	type: 'GET',
		url: '/ziksana-web/zalert/getalerts',
		dataType: 'xml',
		success: function( data ) {
			
				var no_of_available_alerts;
				var output_alert="";
				$.get('/ziksana-web/zalert/getalertsize', {}, function(size){
			
					no_of_available_alerts = size;
					
					output_alert+="<div class='alrtheader' style='height:50px; background-color: rgba(50, 50, 50, 0.75); padding:10px; border-bottom:1px solid #ccc;'>";
					output_alert+="<p class='pull-left' style='color: rgb(255, 255, 255); font-size: 15px;margin-top: 5px;'> Alerts </p>";
					output_alert+="<p class='pull-right' style='color:#fff;'>Manage Alerts <a href='#linkurl'> <img src='/ziksana-web/resources/images/icons/calen.png' style='height:30px; margin-left:6px; vertical-align:middle;'/> </a> </p> </div>";
					output_alert+="<div class='alrtcontent' style='height:270px; padding-left:20px;'>";
					output_alert+="<table class='table table-hover'><tbody>";
					
					console.log('No of avaliable alerts: '+no_of_available_alerts);
					if(no_of_available_alerts == 0){$('#alerts_placeholder').html(outputAlertEmpty);} else{
						
						$(data).find("alertitem").each(function(index){
						output_alert+="<tr><td width='20%'>12:45 pm</td><td width='70%' style='vertical-align:middle;'>"+$(this).find('description').text()+"</td></tr> ";
						
						});
						
					}
					
					output_alert+="</tbody></table> </div>";
					output_alert+="<div class='eventfooter' style='height:30px; background-color: rgba(50, 50, 50, 0.75); padding:10px; border-top:1px solid #ccc; padding:5px; padding-left:10px; color:#fff;'>";
					output_alert+="<p> You have "+no_of_available_alerts+" Alerts today </p></div>";
					$('#alerts_placeholder').html( output_alert);
				
					
				});
			
		}
	
	});
				
}

//TODO Ajax Call
var no_of_available_todo;
function get_and_populate_todo(){
	$.ajax({
	  	type: 'GET',
		url: '/ziksana-web/ztodo/showalltodo',
		dataType: 'xml',
		success: function( data ) {
				
				var output_todo="";
				
				var indexValue = 0;
				
			
				
				
				$.get('/ziksana-web/ztodo/gettodosize', {}, function(size){ 
					no_of_available_todo = size;
				
					var ouputEmptyTodo="";
					
					
					if(no_of_available_todo == 0){$('#todos_placeholder').html(ouputEmptyTodo);} else{
						

						 
						ouputEmptyTodo+="<div class='alrtheader' style='height:50px; background-color: rgba(50, 50, 50, 0.75); padding:10px; border-bottom:1px solid #ccc;'>";
						ouputEmptyTodo+="<p class='pull-left' style='color: rgb(255, 255, 255); font-size: 15px;margin-top: 5px;'> TO Do's </p>";
						ouputEmptyTodo+="<p class='pull-right' style='color:#fff;'>Manage TO Do's <a href='#linkurl'> <img src='/ziksana-web/resources/images/icons/calendar.png' style='height:30px; margin-left:6px; vertical-align:middle;'/> </a> </p> </div>";
						ouputEmptyTodo+="<div class='alrtcontent' style='height:270px; padding-left:20px;'>";
						ouputEmptyTodo+="<table class='table innertable table-hover'><tbody>";
						 $(data).find("todoitem").each(function(index){
							 if($(this).find("status").text() == 1){
							 ouputEmptyTodo+="<tr id='todorow"+$(this).find('id').text()+"' class='closedtodo'><td width='10%'><input  name='checkstatus"+$(this).find('id').text()+"' onchange='handleChange(this,"+$(this).find('id').text()+");' type='checkbox' value='' checked /></td><td width='30%' style='vertical-align:middle;'>"+$(this).find("categoryName").text()+"</td><td width='70%' style='vertical-align:middle;'>"+$(this).find("subject").text()+"</td></tr> ";
							 }else{
								 ouputEmptyTodo+="<tr id='todorow"+$(this).find('id').text()+"'><td width='10%'><input name='checkstatus"+$(this).find('id').text()+"' type='checkbox' onchange='handleChange(this,"+$(this).find('id').text()+");' value=''/ ></td><td width='30%' style='vertical-align:middle;'>"+$(this).find("categoryName").text()+"</td><td width='70%' style='vertical-align:middle;'>"+$(this).find("subject").text()+"</td></tr> ";
							 }
							 
						 });
						ouputEmptyTodo+="</tbody></table> </div>";
						ouputEmptyTodo+="<div class='eventfooter' style='height:30px; background-color: rgba(50, 50, 50, 0.75); padding:10px; border-top:1px solid #ccc; padding:5px; padding-left:10px; color:#fff;'>";
						ouputEmptyTodo+="<p id='incompletesize'class='f-l'> You have "+no_of_available_todo+" Incompleted Task </p><p class='f-r'> <a href='#' style='color:#fff;'>Remove completed Task</a></p></div>";
						 
						$('#todos_placeholder').html(ouputEmptyTodo);
						
						
					}
					
				});
		}	
	});
						  
}

function handleChange(a,cb) {
	  var i = $('#checkstatus'+cb+'').val();
	  if(a.checked == true){
		  
		  $.post( '/ziksana-web/ztodo/updatetodostatus'
			        , {'todoItemId':cb,'status':a.checked}
			        , function( data )
			        {
			        
			        	 $('#todorow'+cb+'').addClass('closedtodo');

							$.get('/ziksana-web/ztodo/gettodosize', {}, function(size){ 
								x = "You have "+size+"";
								$('#incompletesize').html(x);
							});
			 
			        });  
		  
	  }else{
		  $.post( '/ziksana-web/ztodo/updatetodostatus'
			        , {'todoItemId':cb,'status':a.checked}
			        , function( data )
			        {
			        	 $('#todorow'+cb+'').removeClass('closedtodo');
			        	 $.get('/ziksana-web/ztodo/gettodosize', {}, function(size){ 
								x = "You have "+size+"";
								$('#incompletesize').html(x);
							});
			        });  
	  }


	}
