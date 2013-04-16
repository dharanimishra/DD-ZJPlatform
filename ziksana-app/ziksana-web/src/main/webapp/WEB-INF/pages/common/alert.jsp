
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<title>Alerts</title>
<!--Body Style sheet-->
<script type="text/javascript" src="${staticFileServer}resources/js/tree/jquery-1.8.0.min.js"></script>
<link href="${staticFileServer}resources/css/styles.css" rel="stylesheet" type="text/css">
	<link href="${staticFileServer}resources/css/type-setting.css" rel="stylesheet" type="text/css">
	<link href="${staticFileServer}resources/css/effects.css" rel="stylesheet" type="text/css">
	<link href="${staticFileServer}resources/css/nav.css" rel="stylesheet" type="text/css">
   	
   	<script src="${staticFileServer}resources/js/jquery-ui-1.9.2.custom/js/jquery-1.8.3.js"></script>
 <script src="${staticFileServer}resources/js/jquery-ui-1.9.2.custom/js/jquery-ui-1.9.2.custom.min.js"></script>
 <link href="${staticFileServer}resources/js/jquery-ui-1.9.2.custom/css/ui-lightness/jquery-ui-1.9.2.custom.css" type="text/css"/>
 
   	
   	
 	
	
	 <script src="${staticFileServer}resources/js/ui/jquery.ui.widget.js"></script>
	 <script src="${staticFileServer}resources/js/ui/jquery.ui.button.js"></script>
	 <script src="${staticFileServer}resources/js/ui/jquery.ui.progressbar.js"></script>
	 <script src="${staticFileServer}resources/js/ui/jquery.ui.tabs.js"></script>
     <script src="${staticFileServer}resources/js/jquery.hovercard.js"></script>
     <script src="${staticFileServer}resources/js/todo.js" type="text/javascript"></script> 
      <link rel="stylesheet" href="${staticFileServer}resources/css/zCss.css" type="text/css"/>
	 <link rel="stylesheet" href="${staticFileServer}resources/css/zeni/zeni2.css" type="text/css"/>
     <script language="javascript" type="text/javascript" src="${staticFileServer}resources/js/custom/Todoalertshovercard.js"></script>
 

</head>
 <style>
	.ui-progressbar .ui-progressbar-value { background-image: url(images/pbar-ani.gif); }	
	body{
	background-color:#ffffff;
	}
	.todoWrap
	{
	width:750px;
	
	background-color:#ffffff;
	}
  </style>
       
</head>
<body>
<c:url var="info" value="/resources/images/icons/info.png" />
<c:url var="closeicon" value="/resources/images/icons/close-icon.png" />
 
	<c:url var="deleteAlertUrl" value="/zalert/deletealert/" />
<script type="text/javascript">
function deleteFunction(val){
	
	
	confirm_delete_alert = confirm('Are you sure you want to delete this item?');
	if(confirm_delete_alert == true){
		
		
	
	$.ajax({
	  	type: 'DELETE',
		url: '${deleteAlertUrl}'+val,
		dataType: 'json',
		success: function( data ) {
			console.log('delete alert fired');
			//delete the alert div
			
			
		}
	});
	$('#alert_'+val).remove();
	
	}
}

function closeit(){
parent.jQuery.fancybox.close();

}
</script>
	
	
	<c:url var="showAlertUrl" value="/zalert/getalerts" />
	 <c:url var="deleteAlertUrl" value="/zalert/deletealert/" />
	 <script type="text/javascript">
	 $(document).ready(function() {
		 var images = new Array();
			images[0] = "<c:url  value='${staticFileServer}resources/images/icons/urgent.png' />";
			images[1] = "<c:url  value='${staticFileServer}resources/images/icons/warning.png' />";
			images[2] = "<c:url  value='${staticFileServer}resources/images/icons/info.png' />";
			images[3] = "<c:url  value='${staticFileServer}resources/images/icons/info.png' />";
			images[4] = "<c:url  value='${staticFileServer}resources/images/icons/info.png' />";
			images[5] = "<c:url  value='${staticFileServer}resources/images/icons/info.png' />";
			images[6] = "<c:url  value='${staticFileServer}resources/images/icons/info.png' />";
	 	$.ajax({
	 		  	type: 'GET',
	 			url: '${showAlertUrl}',
	 			dataType: 'xml',
 			success: function( data ) {
	 					
				var output="";
					output+="<div class='alerts' style='width: 100%; height: 100%;margin-left:40px;'>";
					output+="<div class='helptext'>Alerts</div>";
					$(data).find("alertitem").each(function(index){
						
						output+="<div id='alert_"+$(this).find("id").text()+"' class='alertcontainer' style='border:1px solid #F5F5F5;' id='conalert3'>";
						output+="<div class='alertinfo' style='height:28px;padding:5px;'>";
						output+="<div class='alertinfo-icon' style='float:left;display:inline; margin-right:10px;'>";
						 
						output+="<a href='' rel='tipsy'  style='cursor:default;'  > <img title='' src='"+images[index]+"'  alt='INFO' /> </a></div>";
						output+="<div class='alertinfo-category todotip_container' style='display:inline;' >"+short_string_category($(this).find("category").text())+"<div class='categorytip'>"+$(this).find("category").text()+" </div></div>";
						
						output+="<div class='todotip_container' id='demo-basic"+$(this).find("id").text()+"' style='font-weight:lighter;clear:both;display:inline; margin-left:10px; cursor:pointer;color:grey;'>"+short_string($(this).find('description').text())+"</a><div class='todotip'>"+$(this).find("description").text()+" </div></div><div><a href='#' onclick='deleteFunction("+$(this).find('id').text()+")'  title='Delete' style='float:right; id='btalert3' rel='tipsy' title='Close'> <img src='${closeicon}' height='15' width='15'/> </a></div></div>";
						
						output+="</div>";	
						
						
						
									
				});
					output+="<hr/><a class='btn btn-info f-r' onclick='closeit()'> Return </a></div></div>";
					
					//console.log("output string: " + output);
					$('#alertplaceholder').html( output);
					
					$('span.Zalart').hide();
					$('span.alert').hide();
					$('font._sText').hide();	
					
					$('div.alertitem').hover( function(){
						console.log("this is: " + $(this).html());
						$(this).children('.alert').show();
						$(this).children('.Zalart').show();
						$(this).children('._sText').show();
						$(this).children('._hText').hide();
						$(this).css("background-image", "url(${todoImageUrl})");
						$(this).children('.alert').click( function(){
								$(this).parent().fadeOut('slow');
								$(this).unbind();
							console.log("alertItemId is: " + $(this).parent().children('#alertItemId').attr('value'));
								$.ajax({
								  	type: 'DELETE',
									url: '${deleteAlertUrl}/' + $(this).parent().children('#alertItemId').attr('value'),
									dataType: 'json',
									success: function( data ) {
										console.log('delete alert fired');
									}
								});
							});
							
						}, function(){
							$(this).children('.alert').hide();
							$(this).children('.Zalart').hide();
						$(this).children('._sText').hide();
							$(this).children('._hText').show();
							$(this).children('.alert').unbind();
							$(this).css("background-image", "");
						});
						
				}
		});
		
	});
	 
	/// TODO: move this function to a common js file later
	 function short_string(string){
	 	
	 	if(string.length > 50){
	 		return string.substring(0,50)+'...';
	 	} else {
	 		return string;
	 	}	
	 } 
	 function short_string_category(value){
			if(value.length > 9){
				return value.substring(0,9)+'...';
			} else {
				return value;
			}	
		}

	</script>
	<div class="todoWrap">
	<div  class="alert_todo" style="margin-left:10px;" >
	 
	                   		 <div id= "alertplaceholder" style="width:600px;height:500px;" class="alerts" >
	        				 
	                  
	                        </div> 
	                        
	                        </div>
	                        </div>
	</body>
	</html>

