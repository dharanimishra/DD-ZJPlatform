<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<title>zAnnouncements</title>

<link rel="stylesheet" href="../resources/css/zCss.css" type="text/css" />
<link type="text/css"
	href="../resources/css/jquery-ui-1.8.23.custom.css" rel="stylesheet" />
<link rel="stylesheet" href="../resources/css/bootstrap.css" />
<link href="../resources/css/jquery.mCustomScrollbar.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="../resources/css/zeni/zeni2.css" />
</head>
<script type="text/javascript"
	src="../resources/js/tree/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="../resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="../resources/js/jquery-ui-1.8.21.custom.min.js"></script>
<script src="../resources/js/bootstrap.min.js"></script>
<script src="../resources/js/bootstrap.js"></script>
<script type="text/javascript" src="../resources/js/jquery.js"></script>
<script type="text/javascript" src="../resources/js/zGroup.js"></script>
<script type="text/javascript" src="../resources/js/tablerow.js"></script>
<script type="text/javascript" src="../resources/js/date.js"></script>
<!--<script src="js/isotope/jquery-1.7.2.min.js"></script>-->
<script type="text/javascript" src="../resources/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript"
	src="../resources/js/jquery-ui-1.8.23.custom.min.js"></script>
<style>

.row-hover {

 border:2px solid #27b ! important;
 background-color:#66CCFF;
 color: blue;
 }
 #updateTable tr:hover td {background: #CADFE2 !important;}
</style>
<script type="text/javascript">
	$(function(){
				
				$( ".datepicker" ).datepicker();			

			});
	
			
	function closeIt(){
		 
		  parent.jQuery.fancybox.close();

		  
}
		function showdate()
		{
		var today = Date.today().toString('MM/dd/yyyy');
		
		document.getElementById("endDate").value=today;
		}
		function showenddate()
		{
		var today = new Date();
		var last_week = Date.prev().week().toString('MM/dd/yyyy');
		var last_month = Date.prev().month();
		
		document.getElementById("startDate").value=last_week;
		}	
			

</script>

<!-- Announcement  -->

<c:url var="getAnnouncementAllDateUrl"
	value='/secure/getannouncementsallbydate' />
<c:url var="getInstitutionAnnouncementUrl"
	value='/secure/getinstitutionannouncements' />
<c:url var="getInstitutionunitAnnouncementUrl"
	value='/secure/getinstitutionunitannouncements' />
<c:url var="getCourseAnnouncementUrl"
	value='/secure/getcourseannouncements' />
<c:url var="showannouncements" value="/secure/showannouncements" />
<c:url var="showannouncementsall" value="/secure/showannouncementsAll" />
<script type="text/javascript">
$(document).ready(function() {
	$(document).ready(function() {
		setInterval(function() {
			
	 
		}, 500);	
		
		get_all_announcements();
	});
	

 function get_all_announcements(){
	$.ajax({
		  	type: 'GET',
			url: '${showannouncementsall}',
			dataType: 'xml',
			success: function( data ) {
					
					var output_announcement="";
					output_announcement+="<table id = 'updateTable' class='table tb1'>";
					output_announcement+="<tr style='background-color:#3ca3c1;height:30px;border:1px solid gray;'><th width='200px' style='color:#fff;'>Announcement</th>";
					output_announcement+="<th  width='200px' style='color:#fff;'>Date of Announcement</th></tr>";
					output_announcement+="<tbody>";
					$(data).find("announcementsList").each(function(){
						if($(this).find("announcementSize").text()==0){
							output_announcement+="<tr><td>No New Announcements</td></tr>";
						}
					$(data).find("announcements").each(function(index){
						
					
						
						
						output_announcement+="<tr id='announcement_row_"+index+"' onClick='getMessagedescription("+index+")'><td style=' width:350px;'><label class='edit_message'>"+ $(this).find("message").text()+"</label><label class='edit_desc' style='display:none;'>"+ $(this).find("description").text()+"</label></td>";
						output_announcement+="<td><label class='edit_description'>"+ $(this).find("announcementDate").text()+"</label></td></tr>";
						
	                   	
												
					});
					});
					output_announcement+="</tbody></table>";
					//output_announcement+="<a class='' style='color:blue;float:right;' href='#' onClick='$(\"#row_selection_form_container1\").show();'>Details</a>";
					//console.log("Announcements: " + output_announcement);
				
					
					$('#announcement_placeholder').html(output_announcement);
				
					
					 
					
			}
	});
	
}	
	
}); 
 
function getMessagedescription(indexValue){
	
 	$('.tb1 tr').removeClass('row-hover');
	$('#announcement_row_'+indexValue+'').addClass('row-hover'); 
	outputDetails_description = "";
	var announcement_message= $('#announcement_row_'+indexValue+' .edit_message').text();
	var announcement_date = $('#announcement_row_'+indexValue+' .edit_description').text();
	var announcement_dec = $('#announcement_row_'+indexValue+' .edit_desc').text();

	outputDetails_description+="<div  id='row_selection_form_container1'>";
	outputDetails_description+="<br/><b> Details of the select Row in the table should be displayed here</b>";
	outputDetails_description+="<div>";
	outputDetails_description+="<br/></br><u><label style='font-weight:bold;'>"+announcement_message+"</label></u><label >"+announcement_date+"</label><label  >"+announcement_dec+"</label>";
	outputDetails_description+="</div>";
	

	//$("#linksMeeting").fadeIn();
	$("#linksdetails").html(outputDetails_description);
	
}

function getCategoryByBetweenDates(){
	var categoryName= $('#zCategory').val();
	var startDate = $('#startDate').val();
	var endDate = $('#endDate').val();
	
	var startDate1 = startDate.toString('dd/MM/yyyy');
	var endDate1 = endDate.toString('dd/MM/yyyy');
	
	if(categoryName == 'All'){
		 $.post( '${getAnnouncementAllDateUrl}'
			        , {'startDate':startDate1,'endDate':endDate1}
			        , function( data )
			        {
			        
			        	var output_announcement="";
			        	output_announcement+="<table id = 'updateTable' class='table tb1'>";
						output_announcement+="<tr style='background-color:#3ca3c1;height:30px;border:1px solid gray;'><th width='200px' style='color:#fff;'>Announcement</th>";
						output_announcement+="<th  width='200px' style='color:#fff;'>Date of Announcement</th></tr>";
						output_announcement+="<tbody>";
						$(data).find("announcementsList").each(function(){
							if($(this).find("announcementSize").text()==0){
								output_announcement+="<tr><td>No New Announcements</td></tr>";
							}
						$(data).find("announcements").each(function(index){
							
						
							
							
							output_announcement+="<tr id='announcement_row_"+index+"' onClick='getMessagedescription("+index+")'><td style=' width:350px;'><label class='edit_message'>"+ $(this).find("message").text()+"</label><label class='edit_desc' style='display:none;'>"+ $(this).find("description").text()+"</label></td>";
							output_announcement+="<td><label class='edit_description'>"+ $(this).find("announcementDate").text()+"</label></td></tr>";
							
		                   	
													
						});
						});
						output_announcement+="</tbody></table>";
						//output_announcement+="<a class='' style='color:blue;float:right;' href='#' onClick='$(\"#row_selection_form_container\").show();'>Details</a>";
						//console.log("Announcements: " + output_announcement);
					
						
						$('#announcement_placeholder').html(output_announcement);
						

			        }
					 ); 

	
	} else if(categoryName == 'University'){
		
		 $.post( '${getInstitutionAnnouncementUrl}'
			        , {'startDate':startDate1,'endDate':endDate1}
			        , function( data )
			        {
			        
			        	var output_announcement="";
			        	output_announcement+="<table id = 'updateTable' class='table tb1'>";
						output_announcement+="<tr style='background-color:#3ca3c1;height:30px;border:1px solid gray;'><th width='200px' style='color:#fff;'>Announcement</th>";
						output_announcement+="<th  width='200px' style='color:#fff;'>Date of Announcement</th></tr>";
						output_announcement+="<tbody>";
						$(data).find("announcementsList").each(function(){
							if($(this).find("announcementSize").text()==0){
								output_announcement+="<tr><td>No New Announcements</td></tr>";
							}
						$(data).find("announcements").each(function(index){
							
						
							
							
							output_announcement+="<tr id='announcement_row_"+index+"' onClick='getMessagedescription("+index+")'><td style=' width:350px;'><label class='edit_message'>"+ $(this).find("message").text()+"</label><label class='edit_desc' style='display:none;'>"+ $(this).find("description").text()+"</label></td>";
							output_announcement+="<td><label class='edit_description'>"+ $(this).find("announcementDate").text()+"</label></td></tr>";
							
		                   	
													
						});
						});
						output_announcement+="</tbody></table>";
						//output_announcement+="<a class='' style='color:blue;float:right;' href='#' onClick='$(\"#row_selection_form_container\").show();'>Details</a>";
						//console.log("Announcements: " + output_announcement);
					
						
						$('#announcement_placeholder').html(output_announcement);
						

			        }
					 ); 
	} else if(categoryName == 'Department'){
		 $.post( '${getInstitutionunitAnnouncementUrl}'
			        , {'startDate':startDate1,'endDate':endDate1}
			        , function( data )
			        {
			        
			        	var output_announcement="";
			        	output_announcement+="<table id = 'updateTable' class='table tb1'>";
						output_announcement+="<tr style='background-color:#3ca3c1;height:30px;border:1px solid gray;'><th width='200px' style='color:#fff;'>Announcement</th>";
						output_announcement+="<th  width='200px' style='color:#fff;'>Date of Announcement</th></tr>";
						output_announcement+="<tbody>";
						$(data).find("announcementsList").each(function(){
							if($(this).find("announcementSize").text()==0){
								output_announcement+="<tr><td>No New Announcements</td></tr>";
							}
						$(data).find("announcements").each(function(index){
							
						
							
							
							output_announcement+="<tr id='announcement_row_"+index+"' onClick='getMessagedescription("+index+")'><td style=' width:350px;'><label class='edit_message'>"+ $(this).find("message").text()+"</label><label class='edit_desc' style='display:none;'>"+ $(this).find("description").text()+"</label></td>";
							output_announcement+="<td><label class='edit_description'>"+ $(this).find("announcementDate").text()+"</label></td></tr>";
							
		                   	
													
						});
						});
						output_announcement+="</tbody></table>";
						//output_announcement+="<a class='' style='color:blue;float:right;' href='#' onClick='$(\"#row_selection_form_container\").show();'>Details</a>";
						//console.log("Announcements: " + output_announcement);
					
						
						$('#announcement_placeholder').html(output_announcement);
						

			        }
				); 
	} else if(categoryName == 'Course'){
		 $.post( '${getCourseAnnouncementUrl}'
			        , {'startDate':startDate1,'endDate':endDate1}
			        , function( data )
			        {
			        
			        	var output_announcement="";
			        	output_announcement+="<table id = 'updateTable' class='table tb1'>";
						output_announcement+="<tr style='background-color:#3ca3c1;height:30px;border:1px solid gray;'><th width='200px' style='color:#fff;'>Announcement</th>";
						output_announcement+="<th  width='200px' style='color:#fff;'>Date of Announcement</th></tr>";
						output_announcement+="<tbody>";
						$(data).find("announcementsList").each(function(){
							if($(this).find("announcementSize").text()==0){
								output_announcement+="<tr><td>No New Announcements</td></tr>";
							}
						$(data).find("announcements").each(function(index){
							
						
							
							
							output_announcement+="<tr id='announcement_row_"+index+"' onClick='getMessagedescription("+index+")'><td style=' width:350px;'><label class='edit_message'>"+ $(this).find("message").text()+"</label><label class='edit_desc' style='display:none;'>"+ $(this).find("description").text()+"</label></td>";
							output_announcement+="<td><label class='edit_description'>"+ $(this).find("announcementDate").text()+"</label></td></tr>";
							
		                   	
													
						});
						});
						output_announcement+="</tbody></table>";
						//output_announcement+="<a class='' style='color:blue;float:right;' href='#' onClick='$(\"#row_selection_form_container\").show();'>Details</a>";
						//console.log("Announcements: " + output_announcement);
					
						
						$('#announcement_placeholder').html(output_announcement);
						

			        }
					 ); 
	} else{
		alert("Please select category");
	}
		
	
}
</script>

<body onload="showdate(),showenddate()">

	<div class="zannouncementwrapper">
		<!-- Main container -->
		<div id="zAnnouncement">

			<div class="helptext">Important Announcements</div>
			<div id="error">
				<!-- <span id="_required">Enter a date *</span> -->
			</div>
			<div id="contentGroup">
				Category:<select name="zCategory" id="zCategory"
					style="display: inline; width: 100px;">
					<option selected="selected" value="All">All</option>
					<option value="University">University</option>
					<option value="Department">Department</option>
					<option value="Course">Course</option>
				</select> <label value="Period" style="display: inline;">Start Period</label>

				<input type="text" id="startDate" class="datepicker"
					style="display: inline; width: 80px;" title="Date Required"
					value="Value (Date)" /> <label value="endDate"
					style="display: inline;">End Period</label> <input type="text"
					id="endDate" style="display: inline; width: 80px;"
					class="datepicker" title="Date Required" value="Value (Date)" /> <a
					id="_go" onCLick="getCategoryByBetweenDates()" class="aClass">Go</a>

			</div>
			<!-- end contentGroup getCategoryByBetweenDates-->



			<div id="showGroup" class="zAnn">

				<div id="tblGroup" style="height: 400px; overflow: auto;">
					<div id=announcement_placeholder></div>

				</div>
				

				<div id="linksMeeting" style="border-top: 1px solid grey">
					<br />

					<script type="text/javascript">
  function show_Announcement_Sigle_row_values(){
	  $('#row_selection_form_container1').show();
	  $('#return_announcements').show();
  }
  function hide_Announcement_Sigle_row_values(){
	  $('#row_selection_form_container1').show();
	  $('#return_announcements').show();
  }
  </script>


					<div id="linksdetails"></div>

				</div>
				 <!-- linksMeeting -->
                <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
	<script>!window.jQuery.ui && document.write(unescape('%3Cscript src="../resources/jquery/jquery-ui-1.8.21.custom.min.js"%3E%3C/script%3E'))</script>
	<!-- mousewheel plugin -->
				<script src="../resources/js/scrollbar/jquery.mousewheel.min.js"></script>
				<!-- custom scrollbars plugin -->
				<!-- <script src="../resources/js/scrollbar/jquery.mCustomScrollbar.js"></script>
	<script>
		(function($){
			$(window).load(function(){
				$("#tblGroup").mCustomScrollbar({
					scrollButtons:{
						enable:true
					}
				});
			});
		})(jQuery);
	</script>  -->
				<!-- end tblGroup -->
			</div>
			<!-- end tblGroup -->


			<div id="zReturn" style="margin-top: 5px; height: 30px;">
				
				<button id="return_announcements" style="float: right;" class="btn btn-info" onClick="closeIt()" name="btn_return">Return</button>

			</div>
			<!-- end zReturn -->

		</div>
		<!-- end zAnnouncement -->

	</div>

</body>

</html>
