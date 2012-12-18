
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<title>Alerts</title>
<!--Body Style sheet-->
 <link rel="stylesheet" type="text/css" href="../css/dropdown.css" />
<link href="../resources/css/styles.css" rel="stylesheet" type="text/css">
<link href="../resources/css/type-setting.css" rel="stylesheet" type="text/css">
<link href="../resources/css/effects.css" rel="stylesheet" type="text/css">
<link href="../resources/css/nav.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="../resources/css/tag/tagit-simple-blue.css">
<link rel="stylesheet" href="../resources/css/tipsy.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="../resources/css/custom-theme/old-jquery-ui-1.8.21.custom.css">
<link rel="stylesheet" type="text/css" href="../resources/css/custom-theme/jquery-ui-1.8.21.custom.css">
<link href="../resources/css/news/newsticker.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="../js/accordion/style.css" />
<script src="../resources/js/jquery-1.7.2.min.js"></script>
 <script src="../resources/js/dropdown/hover-dropdown.min.js"></script>
   <script src="../resources/js/dropdown/tiwtter.js"></script>
<script src="../resources/js/ui/jquery.ui.core.js"></script>
<script src="../resources/js/ui/jquery.ui.widget.js"></script>
<script src="../resources/js/ui/jquery.ui.button.js"></script>
<script src="../resources/js/ui/jquery.ui.progressbar.js"></script>
<script src="../resources/js/ui/jquery.ui.tabs.js"></script>
 <script src="../resources/js/jquery.hovercard.js"></script>
 <script language="javascript" type="text/javascript" src="../resources/js/custom/Todoalertshovercard.js"></script>
  <!--fancybox-->
<script type="text/javascript" src="../resources/js/ui/jquery.mousewheel-3.0.4.pack.js"></script>
<script type="text/javascript" src="../resources/js/ui/jquery.fancybox-1.3.4.pack.js"></script>
  <script type="text/javascript" src="../resources/js/todo.js"></script>
<link rel="stylesheet" type="text/css" href="../resources/js/ui/jquery.fancybox-1.3.4.css" media="screen" />
<!--fancybox end-->
</head>
 <style>
	.ui-progressbar .ui-progressbar-value { background-image: url(images/pbar-ani.gif); }	
  </style>
       
</head>
<body>
<c:url var="info" value="/resources/images/icons/info.png" />
<c:url var="closeicon" value="/resources/images/icons/close-icon.png" />
 <script type="text/javascript">
function changeImage(a){

	var images = new Array();
	images[0] = "<c:url  value='/resources/images/icons/urgent.png' />";
	images[1] = "<c:url  value='/resources/images/icons/warning.png' />";
	images[2] = "<c:url  value='/resources/images/icons/info.png' />";
	
	 var comic = document.getElementById("exp").src;
	 if(a==1000){
		  $("#exp").attr('src', images[0]);
	 }else if(a==1001){
		 $("#exp").attr('src', images[1]);
	 }else if(a==1002){
		 $("#exp").attr('src', images[2]);
	 }
	  
}
	</script>
	
	<c:url var="showAlertUrl" value="/secure/showmyalert/111111" />
	 <c:url var="deleteAlertUrl" value="/secure/deletealert/" />
	 <script type="text/javascript">
	 $(document).ready(function() {
	 	$.ajax({
	 		  	type: 'GET',
	 			url: '${showAlertUrl}',
	 			dataType: 'xml',
 			success: function( data ) {
	 					if (console && console.log){
								console.log( 'Sample of data:', data);
				}
				var output="";
					output+="<div  class='alerts'>";
					output+="<span class='titles-info font-Signika text-size-px18 light-gray'>Alerts</span>";
					$(data).find("alertitem").each(function(index){
						
						output+="<div class='alertcontainer' style='border:1px solid #F5F5F5;' id='conalert3'>";
						output+="<div class='alertinfo' style='height:28px;padding:5px;'>";
						output+="<div class='alertinfo-icon' style='float:left;display:inline; margin-right:10px;'>";
						output+="<a href='#linkurl' rel='tipsy' title='Info' style='cursor:default;' > <img id='exp' src='${info}' onload='changeImage("+$(this).find("priority").text()+")' /> </a></div>";
						output+="<div class='alertinfo-category'style='display:inline;' >"+$(this).find("category").text()+"</div>";
						output+="<span class='alert zclose  zicons ls-no f-r'></span>";
						output+="<input type='hidden' id='alertItemId' value='" +$(this).find("id").text()  + "' />";
						/* output+="<div class='alertinfo-decription' style='float:left; height:14px; font-family:verdana; font-size:11px; padding:4px;'>"; */
						output+="<div id='demo-basic2'  style='font-weight:lighter;clear:both;display:inline; margin-left:10px; cursor:pointer;'>"+$(this).find("description").text()+"</div><a href='${deleteAlertUrl}"+$(this).find("id").text()+"' title='Delete' style='float:right; id='btalert3' rel='tipsy' title='Close'> <img src='${closeicon}' height='15' width='15'/> </a></div>";
						/* output+="<div class='alertinfo-button' style='display:inline;margin-left:10px;' >"; */
						output+="</div></div>";
						
						/* output+="<div class='alertitem'>";
						output+="<span class='Zalart zicons ls-no f-l a1'></span>&nbsp;";
						//output+="<font class='_hText'>" + alertitem.subject + "</font>";
						
						//output+="<font class='_sText'>" + $(this).find("description").text() + "</font>";
						output+= $(this).find("description").text(); 
						output+="<span class='alert zclose  zicons ls-no f-r'></span>";
						output+="<input type='hidden' id='alertItemId' value='" +$(this).find("id").text()  + "' />";
						output+="</div>";	 */					
				});
					
					
					console.log("output string: " + output);
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
	</script>
	<div style="border:2px solid #900; class="alert_todo" style="margin-left:70px;" >
	 
	                   		<div id= "alertplaceholder"  class="alerts" >
	        				 <span class="titles-info font-Signika text-size-px18 light-gray">Alerts</span>
	                  
	                        </div> <!--end of alert-->
	                        
	                        </div>
	</body>
	</html>

