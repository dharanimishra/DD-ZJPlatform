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
<style type="text/css">
.row-hover {
  background-color:#66CCFF ! important;
 color: blue;
}
</style>
		
<c:url var="pollquestionsanswers" value="/secure/getallpollquestionsanswers/" />
		<script type="text/javascript">
			$(function(){
				// Datepicker
				$( ".datepicker" ).datepicker();			

			});
			
function details(asd)
{
	$('.tb1 tr').removeClass('row-hover');
	$('#edit_message'+asd+'').addClass('row-hover');
questionId = $('#edit_message'+asd+'').text();
//alert(questionId);

	 $.ajax({
		
		  	type: 'GET',
			url: '${pollquestionsanswers}'+questionId+'',
			dataType: 'xml',
			success: function( data ) {
				$(data).find("QuestionsAnswersList").each(function(){
				 var outputAnswers="";
				 outputAnswers+="<br/><b> Details of the select Row in the table should be displayed here</b><br/>";
				outputAnswers+="Strongly agree <br/>";
				outputAnswers+="<div style='width:"+$(this).find("answer1").text()+"%; height:20px; background-color:green;'></div>";
				outputAnswers+=""+$(this).find("answer1").text()+"%vote<br/>";
				outputAnswers+="Agree <br/>";
				outputAnswers+="<div style='width:"+$(this).find("answer2").text()+"%; height:20px; background-color:red;'></div>";
				outputAnswers+=""+$(this).find("answer2").text()+"%vote<br/>";
				outputAnswers+="Disagree <br/>";
				outputAnswers+="<div style='width:"+$(this).find("answer3").text()+"%; height:20px; background-color:blue;'></div>";
				outputAnswers+=""+$(this).find("answer3").text()+"%vote";
				 //alert(outputAnswers);
				 $('#bars-answer').html(outputAnswers);
				});
			}
	
	});	
	
	

var val= $('#row_selection_'+asd+'').html();

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
var last_month = Date.prev().month().toString('dd/MM/yyyy');

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
					
					output_announcement+="<table class='table tb1'>";
					output_announcement+="<tr style='background-color:#3ca3c1;height:30px;border:1px solid gray;'><th width='200px' style='color:#fff;'>Poll Date</th>";
					output_announcement+="<th  width='200px' style='color:#fff;'>Questions</th></tr>";
					output_announcement+="<tbody>";
					
					$(data).find("QuestionsList").each(function(){
						$(data).find("Questions").each(function(index){
						
						output_announcement+="<tr id='row_selection_"+index+"'><td style=''><a href='#' onClick='details("+index+")'><label style='display:none' id='edit_message"+index+"'>"+ $(this).find("questionId").text()+"</label><label id='edit_messages"+index+"'>"+ $(this).find("questionDate").text()+"</label></a></td>";
						output_announcement+="<td><label id='edit_description"+index+"'>"+ $(this).find("questionName").text()+"</label></td></tr>"; 
						
						});
												
					});
					output_announcement+="</tbody></table>";
					console.log("All Poll Questions: " + output_announcement);
				
					
					$('#tblGroup').html(output_announcement);
					
			}
	});
	
});
function hideContents(){
	
	$('#details-poll').hide();
	$('bars-answer').hide();
	$('#zReturn1').hide();
}
</script>
</head>

<body onload="showdate(),showenddate()">

<div class="zannouncementwrapper">
	<!-- Main container -->
	<div id="zAnnouncement">
    	
        <div class="helptext">
        Polls Results
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
				
          <div id="linksdetails">
		  </div>
            <div id="bars-answer" width=600px;>
			
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

 <input type="button" class="btn btn-info" id="btn_return" onclick="hideContents()" name="btn_return" value="Return"/>
        	</div>
            <!-- end zReturn -->
             
    </div>
    <!-- end zAnnouncement -->

</div>
</body>
</html>
