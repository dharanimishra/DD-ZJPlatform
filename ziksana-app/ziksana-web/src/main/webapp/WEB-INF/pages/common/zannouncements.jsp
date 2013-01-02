
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>zAnnouncements</title>

<link rel="stylesheet" href="../resources/css/zCss.css" type="text/css"/>
<link type="text/css" href="../resources/css/jquery-ui-1.8.23.custom.css" rel="stylesheet" />
<link rel="stylesheet" href="../resources/css/bootstrap.css" />
<link href="../resources/css/jquery.mCustomScrollbar.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="../resources/css/zeni/zeni2.css" />
</head>
<script type="text/javascript" src="../resources/js/tree/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="../resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../resources/js/jquery-ui-1.8.21.custom.min.js"></script>
<script src="../resources/js/bootstrap.min.js"></script>
   <script src="../resources/js/bootstrap.js"></script>
<script type="text/javascript" src="../resources/js/jquery.js"></script>
<script type="text/javascript" src="../resources/js/zGroup.js"></script>
<script type="text/javascript" src="../resources/js/tablerow.js"></script>
<script type="text/javascript" src="../resources/js/date.js"></script>
<!--<script src="js/isotope/jquery-1.7.2.min.js"></script>-->
<script type="text/javascript" src="../resources/js/jquery-1.8.0.min.js"></script>
		<script type="text/javascript" src="../resources/js/jquery-ui-1.8.23.custom.min.js"></script>
<script type="text/javascript">
	$(function(){
				
				$( ".datepicker" ).datepicker();			

			});
	
			
		function closeit()
		{
		$.fancybox.close();
		}	
		function showdate()
		{
		var today = Date.today().toString('dd/MM/yyyy');
		
		document.getElementById("endDate").value=today;
		}
		function showenddate()
		{
		var today = new Date();
		var last_week = Date.prev().week().toString('dd/MM/yyyy');
		var last_month = Date.prev().month();
		
		document.getElementById("startDate").value=last_week;
		}	
			
</script>

<!-- Announcement  -->
<c:url var="getInstitutionAnnouncementUrl" value='/secure/getinstitutionannouncements'/>
<c:url var="getInstitutionunitAnnouncementUrl" value='/secure/getinstitutionunitannouncements'/>
<c:url var="getCourseAnnouncementUrl" value='/secure/getcourseannouncements'/>

<c:url var="showannouncements" value="/secure/showannouncements/100" />
  <script type="text/javascript">
$(document).ready(function() {
	$(document).ready(function() {
		setInterval(function() {
			
	 
		}, 500);	
		
		
	});
	get_all_announcements();

 function get_all_announcements(){
	$.ajax({
		  	type: 'GET',
			url: '${showannouncements}',
			dataType: 'xml',
			success: function( data ) {
					if (console && console.log){
								console.log( 'data:', data);
					}
					var output_announcement="";
					output_announcement+="<table class='table reviewtable'>";
					output_announcement+="<thead style='font-size:12px; font-family:tahoma; font-style:normal; color:#666;'>";
					output_announcement+="<tr><th>Announcement</th><th>Date of Announcement</th></tr>";
					output_announcement+="</thead><tbody>";
					$(data).find("announcements").each(function(index){
						
					
						
						
						output_announcement+="<tr><td style=' width:350px;'><a href='#' onClick='getMessagedescription("+index+")'><label id='edit_message"+index+"'>"+ $(this).find("message").text()+"</label></a></td>";
						output_announcement+="<td><label id='edit_description"+index+"'>"+ $(this).find("validUntil").text()+"</label></td></tr>";
						
	                   	
												
					});
					output_announcement+="</tbody></table>";
					output_announcement+="<a class='' style='color:blue;float:right;' href='#' onClick='$(\"#row_selection_form_container\").show();'>Details</a>";
					//console.log("Announcements: " + output_announcement);
				
					
					$('#announcement_placeholder').html(output_announcement);
				
					
					 
					
			}
	});
	
}	
	
}); 
 outputDetails_description = "";
function getMessagedescription(indexValue){
	
	var message= $('#edit_message'+indexValue+'').text();
	var description = $('#edit_description'+indexValue+'').text();
	
	outputDetails_description+="<div  style='display:none;' id='row_selection_form_container'>";
	outputDetails_description+="<br/><b> Details of the select Row in the table should be displayed here</b>";
	outputDetails_description+="<div>";
	outputDetails_description+="<br/></br><label>"+message+"</label><label >"+description+"</label>";
	outputDetails_description+="</div>";
	
	//$("#linksMeeting").fadeIn();
	$("#linksdetails").html(outputDetails_description);
	
}

function getCategoryByBetweenDates(){
	var categoryName= $('#zCategory').val();
	var startDate = $('#startDate').val();
	var endDate = $('#endDate').val();
	var memberRoleId = 100;
	
	if(categoryName == 'All'){
		$.ajax({
		  	type: 'GET',
			url: '${showannouncements}',
			dataType: 'xml',
			success: function( data ) {
					if (console && console.log){
								console.log( 'data:', data);
					}
					var output_announcement="";
					output_announcement+="<table class='table reviewtable'>";
					output_announcement+="<thead style='font-size:12px; font-family:tahoma; font-style:normal; color:#666;'>";
					output_announcement+="<tr><th>Announcement</th><th>Date of Announcement</th></tr>";
					output_announcement+="</thead><tbody>";
					$(data).find("announcements").each(function(index){
						
					
						
						
						output_announcement+="<tr><td style=' width:350px;'><a href='#' onClick='getMessagedescription("+index+")'><label id='edit_message"+index+"'>"+ $(this).find("message").text()+"</label></a></td>";
						output_announcement+="<td><label id='edit_description"+index+"'>"+ $(this).find("validUntil").text()+"</label></td></tr>";
						
	                   	
												
					});
					output_announcement+="</tbody></table>";
					output_announcement+="<a class='' style='color:blue;float:right;' href='#' onClick='$(\"#row_selection_form_container\").show();'>Details</a>";
					//console.log("Announcements: " + output_announcement);
				
					
					$('#announcement_placeholder').html(output_announcement);
				
					
					 
					
			}
	});
	
	
	} else if(categoryName == 'University'){
		
		 $.post( '${getInstitutionAnnouncementUrl}'
			        , {'memberRoleId':memberRoleId,'startDate':startDate,'endDate':endDate,}
			        , function( data )
			        {
			        
			        	var output_announcement="";
						output_announcement+="<table class='table reviewtable'>";
						output_announcement+="<thead style='font-size:12px; font-family:tahoma; font-style:normal; color:#666;'>";
						output_announcement+="<tr><th>Announcement</th><th>Date of Announcement</th></tr>";
						output_announcement+="</thead><tbody>";
						$(data).find("announcements").each(function(index){
							
						
							
							
							output_announcement+="<tr><td style=' width:350px;'><a href='#' onClick='getMessagedescription("+index+")'><label id='edit_message"+index+"'>"+ $(this).find("message").text()+"</label></a></td>";
							output_announcement+="<td><label id='edit_description"+index+"'>"+ $(this).find("validUntil").text()+"</label></td></tr>";
							
		                   	
													
						});
						output_announcement+="</tbody></table>";
						output_announcement+="<a class='' style='color:blue;float:right;' href='#' onClick='$(\"#row_selection_form_container\").show();'>Details</a>";
						//console.log("Announcements: " + output_announcement);
					
						
						$('#announcement_placeholder').html(output_announcement);
						

			        }
					 ); 
	} else if(categoryName == 'Department'){
		 $.post( '${getInstitutionunitAnnouncementUrl}'
			        , {'memberRoleId':memberRoleId,'startDate':startDate,'endDate':endDate,}
			        , function( data )
			        {
			        
			        	var output_announcement="";
						output_announcement+="<table class='table reviewtable'>";
						output_announcement+="<thead style='font-size:12px; font-family:tahoma; font-style:normal; color:#666;'>";
						output_announcement+="<tr><th>Announcement</th><th>Date of Announcement</th></tr>";
						output_announcement+="</thead><tbody>";
						$(data).find("announcements").each(function(index){
							
						
							
							
							output_announcement+="<tr><td style=' width:350px;'><a href='#' onClick='getMessagedescription("+index+")'><label id='edit_message"+index+"'>"+ $(this).find("message").text()+"</label></a></td>";
							output_announcement+="<td><label id='edit_description"+index+"'>"+ $(this).find("validUntil").text()+"</label></td></tr>";
							
		                   	
													
						});
						output_announcement+="</tbody></table>";
						output_announcement+="<a class='' style='color:blue;float:right;' href='#' onClick='$(\"#row_selection_form_container\").show();'>Details</a>";
						//console.log("Announcements: " + output_announcement);
					
						
						$('#announcement_placeholder').html(output_announcement);
						

			        }
				); 
	} else if(categoryName == 'Course'){
		 $.post( '${getCourseAnnouncementUrl}'
			        , {'memberRoleId':memberRoleId,'startDate':startDate,'endDate':endDate,}
			        , function( data )
			        {
			        
			        	var output_announcement="";
						output_announcement+="<table class='table reviewtable'>";
						output_announcement+="<thead style='font-size:12px; font-family:tahoma; font-style:normal; color:#666;'>";
						output_announcement+="<tr><th>Announcement</th><th>Date of Announcement</th></tr>";
						output_announcement+="</thead><tbody>";
						$(data).find("announcements").each(function(index){
							
						
							
							
							output_announcement+="<tr><td style=' width:350px;'><a href='#' onClick='getMessagedescription("+index+")'><label id='edit_message"+index+"'>"+ $(this).find("message").text()+"</label></a></td>";
							output_announcement+="<td><label id='edit_description"+index+"'>"+ $(this).find("validUntil").text()+"</label></td></tr>";
							
		                   	
													
						});
						output_announcement+="</tbody></table>";
						output_announcement+="<a class='' style='color:blue;float:right;' href='#' onClick='$(\"#row_selection_form_container\").show();'>Details</a>";
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
    	
        <div class="helptext">
        	Help text describing the page
        </div>
        <div id="error">
        	<!-- <span id="_required">Enter a date *</span> -->
        </div>
        <div id="contentGroup">
        	Category:<select name="zCategory"  id="zCategory" style="display:inline;width:100px;">
                     <option selected="selected" value="All">All</option>
                     <option value="University">University</option> 
                      <option value="Department">Department</option> 
                       <option value="Course">Course</option>                
              </select>
              
        	
                    <label value="Period" style="display:inline;">Start Period</label> 
             
            <input type="text" id="startDate" class="datepicker" style="display:inline;width:80px;" title="Date Required" value="Value (Date)"/> 
            
                    <label value="endDate" style="display:inline;">End Period</label> 
                                  
             
			  <input type="text" id="endDate" style="display:inline;width:80px;" class="datepicker" title="Date Required" value="Value (Date)"/> 
            <a id="_go" onCLick=getCategoryByBetweenDates() class="aClass">Go</a>
        
		</div>
        <!-- end contentGroup -->
        
		
		
		<div id="showGroup" class="zAnn">
              
                <div id="tblGroup">
					<div id=announcement_placeholder>
					</div>
					
                </div>
		
				<div id="linksMeeting" style="border-top:1px solid grey">
            	<br/>
               
           		
          
		  
		   <div id="linksdetails">
		  </div>
             
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
           
   
   <div id="zReturn" style="margin-top:5px; height:30px;">    		 
  <!-- <input type="button" class="btn btn-info" id="btn_return" onClick="" name="btn_return" value="Return"/> --> 

        	</div>
            <!-- end zReturn -->
             
    </div>
    <!-- end zAnnouncement -->

</div>
</body>
</html>
