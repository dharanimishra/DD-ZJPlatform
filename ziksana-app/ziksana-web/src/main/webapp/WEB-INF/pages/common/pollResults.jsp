<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta />
<title>poll details</title>
<link rel="stylesheet" href="../resources/css/zCss.css" type="text/css"/>
<link type="text/css" href="../resources/css/jquery-ui-1.8.23.custom.css" rel="stylesheet" />
<link rel="stylesheet" href="../resources/css/bootstrap.css" />
<link href="../resources/css/jquery.mCustomScrollbar.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="../resources/css/zeni/zeni2.css" />
<script src="js/bootstrap.min.js"></script>
   <script src="js/bootstrap.js"></script>
<script type="text/javascript" src="../resources/js/jquery.js"></script>
<script type="text/javascript" src="../resources/js/zGroup.js"></script>
<script type="text/javascript" src="../resources/js/tablerow.js"></script>
<script type="text/javascript" src="../resources/js/date.js"></script>
<!--<script src="js/isotope/jquery-1.7.2.min.js"></script>-->
<script type="text/javascript" src="../resources/js/jquery-1.8.0.min.js"></script>
		<script type="text/javascript" src="../resources/js/jquery-ui-1.8.23.custom.min.js"></script>
		<script type="text/javascript">
			$(function(){
				// Datepicker
				$( ".datepicker" ).datepicker();			

			});
function details(asd)
{

var val= $('#'+asd).html();
$("#linksMeeting").fadeIn();
$("#zReturn1").hide();

$("#linksdetails").html(val);
$("#details-poll").hide();

}			
			
function closeit()
{
$.fancybox.close();
}	
function selectrow()
{
$('#tr1').css("background-color", "#000000");
}	
function showdetails()
{
var test=$("#linksdetails").html();

if(test=="")
{
alert("Please select a row and click the details button");
}
else{
$("#zReturn1").show();
$("#details-poll").show();

}
}	
function showdate()
{
var today = Date.today().toString('dd/MM/yyyy');

document.getElementById("EDate").value=today;
}
function showenddate()
{
var today = new Date();
var last_week = Date.prev().week().toString('dd/MM/yyyy');
var last_month = Date.prev().month();

document.getElementById("vDate").value=last_month;
}				
		</script>
		
 <c:url var="getAllPollQues" value="/secure/getallpollquestions" />
  <script type="text/javascript">
$(document).ready(function() {
	$.ajax({
		  	type: 'GET',
			url: '${getAllPollQues}',
			dataType: 'xml',
			success: function( data ) {
					if (console && console.log){
								console.log( 'Recommend of data:', data);
					}
					var output_announcement="";
					output_announcement+="<table class='table reviewtable'>";
					output_announcement+="<thead style='font-size:12px; font-family:tahoma; font-style:normal; color:#666;'>";
					output_announcement+="<tr><th>Poll Date</th><th>Questions</th></tr>";
					output_announcement+="</thead><tbody>";
					
					$(data).find("QuestionsList").each(function(index){
						
						output_announcement+="<tr><td style=' width:350px;'><a href='#' onClick='getMessagedescription("+index+")'><label id='edit_message"+index+"'>"+ $(this).find("questionId").text()+"</label></a></td>";
						output_announcement+="<td><label id='edit_description"+index+"'>"+ $(this).find("questionName").text()+"</label></td></tr>";
						
												
					});
					output_announcement+="</tbody></table>";
					console.log("All Poll Questions: " + output_announcement);
				
					
					$('#tblGroup').html(output_announcement);
					
			}
	});
	
});
</script>
</head>

<body onload="showdate(),showenddate()">

<div class="zannouncementwrapper">
	<!-- Main container -->
	<div id="zAnnouncement">
    	
        <div class="helptext">
        Poll details describing page
        </div>
       
        <div id="contentGroup">
        	
              
        	
                    <label value="Period" style="display:inline;">Start Date</label> 
             
            <input type="text" style="display:inline;width:80px;" id="vDate" class="datepicker" title="Date Required" value="Value (Date)"/> 
            
                    <label value="Period"  style="display:inline;">End Date</label> 
                                  
             
			  <input type="text" style="display:inline;width:80px;" id="EDate" class="datepicker" title="Date Required" value="Value (Date)"/> 
            <a id="_go" class="aClass">Go</a>
        </div>
        <!-- end contentGroup -->
        <div id="showGroup" class="zAnn">
              
                <div id="tblGroup">
               
                </div>
				<div style="float:right; padding-top:30px;"><a href="#" onclick="showdetails()">Details</a></div>
				<div id="linksMeeting" style=" display:none; border-top:1px solid grey">
            	
				
				<div id ="details-poll">
				<br/>
               <b> Details of the select Row in the table should be displayed here</b>
           		<br/>
          <div id="linksdetails">
		  </div>
            <div id="bars" width=600px;>
			Strongly agree <br/>
			<div style="width:300px; height:20px; background-color:green;"></div>
			50%vote<br/>
			Agree <br/>
			<div style="width:150px; height:20px; background-color:red;"></div>
			25%vote<br/>
			Disagree <br/>
			<div style="width:150px; height:20px; background-color:blue;"></div>
			25%vote
		  </div>
		  </div>
            </div>
            <!-- linksMeeting -->
                <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
	<script>!window.jQuery.ui && document.write(unescape('%3Cscript src="jquery/jquery-ui-1.8.21.custom.min.js"%3E%3C/script%3E'))</script>
	<!-- mousewheel plugin -->
	<script src="../resources/js/scrollbar/jquery.mousewheel.min.js"></script>
	<!-- custom scrollbars plugin -->
	<script src="../resources/js/scrollbar/jquery.mCustomScrollbar.js"></script>
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
	</script> 
               <!-- end tblGroup -->
            </div>
             <!-- end tblGroup -->
           
   
   <div id="zReturn1" style="margin-top:5px; display:none;height:30px;"> 

 <input type="button" class="btn btn-info" id="btn_return" onclick="closeit()" name="btn_return" value="Return"/>
        	</div>
            <!-- end zReturn -->
             
    </div>
    <!-- end zAnnouncement -->

</div>
</body>
</html>
