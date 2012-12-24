<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html >
<head>

	<link href="../resources/images/ziksana-icon.png" rel="shortcut icon"/>
	<link rel="stylesheet" type="text/css" media="screen" href="../resources/css/basic-styles.css"/>
		<link rel="stylesheet" type="text/css" href="../resources/css/custom-theme/old-jquery-ui-1.8.21.custom.css">
	<link rel="stylesheet" type="text/css" href="../resources/css/custom-theme/jquery-ui-1.8.21.custom.css">
    <link rel="stylesheet" type="text/css" media="screen" href="../resources/css/type-setting.css"/>
  
	<script src="../resources/js/jquery-1.7.2.min.js"></script>
	
	<script src="../resources/js/ui/jquery.ui.core.js"></script>
	<script src="../resources/js/ui/jquery.ui.widget.js"></script>
	<script src="../resources/js/ui/jquery.ui.tabs.js"></script>
	<script src="../resources/js/ui/jquery.ui.progressbar.js"></script>
	<script src="../resources/js/ui/jquery.ui.button.js"></script>
	<!--topup-->
	<!-- unanswered script -->
<c:url var="showUnAnswered" value="/secure/getunansweredquestions" />
  <script type="text/javascript">
  currentQuestion = 0;
$(document).ready(function() {
	$.ajax({
		  	type: 'GET',
			url: '${showUnAnswered}',
			dataType: 'xml',
			success: function( data ) {
					if (console && console.log){
								console.log( 'unanswered data:', data);
					}
					var output="";
					 questionArray= new Array();
					 questionIdArray = new Array();
					 optionArray = new Array();
					 optionIndexArray = new Array();
					 memberPersonalitytestId = 0;
					$(data).find("Questions").each(function(index){
						
						//var pairIdQuestion = $(this).find("questiobankid").text()+"="+$(this).find("Question").text();
						 questionArray.push($(this).find("Question").text()); 
						
						questionIdArray.push($(this).find("questiobankid").text());
						
						var options = "";
				 		$(this).find("options").each(function(){
				 			
				 			$(this).find("option").each(function(){
				 				
				 				options +=  $(this).text()+"/";
				 				
				 			});
				 			options = options.substring(0,options.length-1);
				 			optionArray.push(options);
				 				
				 			
				 		});
				 		
					
					});
					console.log("unAnswered Question Id ==>"+ questionIdArray);
					console.log("unanswered array: ==> " + questionArray);
					console.log("option array==>"+  optionArray);
					console.log("memberPersonalitytestId==>"+memberPersonalitytestId);
				
					
					

					
				
					
					displayUnAnsweredPairs(currentQuestion);		
					
			}
	
	});
	
});


function displayUnAnsweredPairs(current){
	var outputResult="";
	
	outputResult+="<div id='quest'>";
	outputResult+="<label id='cur-qus-id'>"+questionIdArray[current]+"</label><label id='cur-qus-value'>"+questionArray[current]+"</label> ";
	outputResult+="<table width='180px' height='30px' >";

	var optionsList = optionArray[current].split("/");
	for(var i = 0 ; i < optionsList.length ; i++){
		
		outputResult+= "<tr><td ><input type='radio' id='checked-val' name='radiobtn' value='"+i+"'>" + "<label id='option-ans' for='option'>" + optionsList[i] + "</label></td></tr>";
		
	}
	//alert(current+","+questionArray.length);
	outputResult+="</table>";
	outputResult+="<br/>";
	outputResult+="<button class='f-rt' id='btnnxt' onClick='submitValue()'>Submit</button>";
	if(current!=questionArray.length-1)
	outputResult+="<button class='f-rt' id='btnnxt' onClick='nextquestion()'>Next >></button>";
	
	if(current!=0)
		outputResult+="<button class='f-rt' id='btnnxt' onClick='prevquestion()'><< Previous</button>";
		
		 
	
	
	$('#newque').html(outputResult);
}
function nextquestion(){
	//var cur=currentQuestion+1<questionArray.length-2?currentQuestion++:questionArray.lengt;
	displayUnAnsweredPairs(++currentQuestion);
}
function prevquestion(){
	//var cur=currentQuestion+1<questionArray.length-2?currentQuestion++:questionArray.lengt;
	displayUnAnsweredPairs(--currentQuestion);
}

function submitValue(){
	testQuestionId = $('#cur-qus-id').text();
	 testQuestionValue = $('#cur-qus-value').text();
	 memberAnswer = $('#option-ans').text();
	 questionBankAnswerId = $('input[name=radiobtn]:checked').val();
	/*  alert("currenttQuestId"+testQuestionId);
	 alert("currenttQuestValue"+testQuestionValue);
	 alert("currentOPtionAnswer"+memberAnswer);
	 alert("currentcheckedValue"+questionBankAnswerId); */
	  $.post( '<c:url value='/secure/saveknowme'/>'
		        , {'memberAnswer':memberAnswer,'testQuestionValue':testQuestionValue,'testQuestionId':testQuestionId,'questionBankAnswerId':questionBankAnswerId}
		        , function( data )
		        {
		        

		        }
				, 'json' );  
}
</script>
 
	<!-- End -->



<!--  -->
<script>
	$(function() {

		$( "button").button();
		$( "button, input:submit" , ".action-row").button();
		$( "button:first" , ".course-button-bar").button({icons: { secondary: "ui-icon-pencil"}} 
		).next().button({icons: { secondary: "ui-icon-wrench"}} 
		).next().button({icons: { secondary: "ui-icon-signal-diag"}} 
		);
		$( "#radio-1, #radio-2, #radio-3, #format" ).buttonset();
		
	});

function nextquest1()
{
$('#quest2').show();
$('#btnpre').show();
$('#quest1').hide();
$('#quest3').hide();
}
function nextquest2()
{
$('#btnpre').show();
$('#quest2').hide();
$('#btnpre').show();
$('#quest1').hide();
$('#quest3').show();
}

 



function prevquest1()
{
$('#btnpre').hide();
		$('#quest2').hide();
		$('#quest3').hide();
		$('#quest1').show();
}

function prevquest2()
    {
        $('#btnpre').show();
$('#quest1').hide();
$('#quest3').hide();
$('#quest2').show();
$('#btnnxt').show();
    }



function disque2()
{
$('#td1').css("background-color"," #ffffff");
$('#td2').css("background-color"," #DAE8F2");
$('#td3').css("background-color"," #ffffff");

}
function disque3()
{
$('#td1').css("background-color"," #ffffff");
$('#td2').css("background-color"," #ffffff");
$('#td3').css("background-color"," #DAE8F2");

}
function disque1()
{

$('#td1').css("background-color"," #DAE8F2");
$('#td2').css("background-color"," #ffffff");
$('#td3').css("background-color"," #ffffff");


}


function closeit(){
parent.jQuery.fancybox.close();

}


function answer()
{
var bgcol = $('#td1').css('backgroundColor'); 
var bgco2 = $('#td2').css('backgroundColor'); 
var bgco3 = $('#td3').css('backgroundColor'); 



if((bgcol!= "rgb(218, 232, 242)")&&(bgco2!= "rgb(218, 232, 242)")&&(bgco3!= "rgb(218, 232, 242)"))
		{
		alert('Please Select a Question and Click on Details');
		}
else if(bgcol== "rgb(218, 232, 242)")
{
$('#disque2').hide();
$('#disque3').hide();
$('#disque1').show();
}
else if(bgco2== "rgb(218, 232, 242)")
{
$('#disque1').hide();
$('#disque3').hide();
$('#disque2').show();
}
else if(bgco3== "rgb(218, 232, 242)")
{
$('#disque1').hide();
$('#disque2').hide();
$('#disque3').show();
}
}

function submit1()
	{
	var x1=document.getElementById("red").checked;
	var y1=document.getElementById("red1").checked;
	if ((y1 == true)||((x1 == true)))
		{
		alert('Answer submited');
		}
		else
		{
		alert('Please select an answer and press submit button');
		}
	}	

function submit3()
	{
	var x=document.getElementById("blue").checked;
	var y=document.getElementById("blue1").checked
  
	if ((y == true)||((x == true)))
		{
		alert('Answer submited');
		}
		else
		{
		alert('Please select an answer and press submit button');
		}
	}
function submit2()
	{
	var z=document.getElementById("que").checked;
	var z1=document.getElementById("que1").checked;
	var z2=document.getElementById("que2").checked;
	var z3=document.getElementById("que3").checked;
	var z4=document.getElementById("que4").checked;
	var z5=document.getElementById("que5").checked;
	
	if ((z == true)||(z1 == true)||(z2 == true)||(z3 == true)||(z4== true)||(z5 == true))
		{
		alert('Answer submited');
		}
		else
		{
		alert('Please select an answer and press submit button');
		}
	
	
	
	}


</script>
<script type="text/javascript">
   function change(value){
   var x=value;
   if (x==2)
	{
	$('.new-que').hide();
	$('.pre-que').show();
	}
	else
	{
	$('.new-que').show();
$('.pre-que').hide();
	}
     
   } 
function subans()
{
alert("Answer submitted successfully");
}   
</script>
	
    <style>

	body{ background:#fff;}
	
input,  select, textarea{ 
color:#555; font-weight:normal!important; padding:3px; font-size:1.2em!important; 
font-family:Arial, Helvetica, sans-serif!important; }

   .pre-que{
   width:400px;
  
   display:none;
   }
    #tabq{
   width:400px;
   height:150px;
   overflow:auto;
  
   }
.new-que{
width:400px;
   height:300px;
}
.quest-table 
{
border:1px solid black;
}
.quest-table1 
{
background-color:grey;
color:black;
border:1px solid black;
}
#quest2,#quest3,#disque2,#disque3,#disque1
{
display:none;
}
#btn{margin:10px; padding:2px}
#btnpre{margin:10px; padding:2px}
#btnnxt{margin:10px; padding:2px}
.knowmetop{
padding: 10px;
background-color: #DAE8F2;
}
   </style>
</head>

<body>
<p>
</p>
<table style="width:600px;">
  <tr>
  <td colspan=2>
<img align="left" style="margin-right:10px; margin-top: 6px; margin-right:5px; height:20px; width:20px; padding-left:5px;" src="../resources/images/icons/helpicon.png">
<div class="knowmetop">You can answer a few personality questions to help us undersatnd you better..</div>
  <!--
    <img class="knowme" src="../images/icons/zicons2.png" width="1" height="1" /><h2 class="bld c369 Slogen-one" style="font-size:1em;">You can answer a few personality questions to help us undersatnd you better..</h2><br>
-->
</td>
</tr>
	<tr>   
   <td width="33%"  style="vertical-align:top;"><p><img src="../resources/images/hero-knb.jpg" width="249" height="200" alt="Guru"></p>
      <p style="font-size:1.8em;" class="Slogen-one">Know me better?</p>
      <p style="font-size:1.2em"><br>
    Helps put more effective tools in your hands</p> <br>
   <h2 class="bld c369">&nbsp;</h2></td>
    <td width="66%"  style="vertical-align:top;">
     
        
        <div id="select_que">
		
		 <form >
                      <select onchange="change(this.value)">
						  <option value="1" >Show Me - New Questions</option>
						  <option value="2" >Show Me - Previously Answered</option>						  
					  </select>
		</form>
                    </div>
                    
                    
                 
       
                    
 
                
                    
                    
       
                 </div>
				 <br/>
				
				 
<!-- Apply Answer value -->
<c:url var="showAnswered" value="/secure/getansweredquestions" />
  <script type="text/javascript">
$(document).ready(function() {
	$.ajax({
		  	type: 'GET',
			url: '${showAnswered}',
			dataType: 'xml',
			success: function( data ) {
					if (console && console.log){
								console.log( 'answered data:', data);
					}
					
					answeredQuestion = new Array();
					answeredQuestionId = new Array();
					answeredAnsewer = new Array();
					answerAnsIndex = new Array();
						$(data).find("answered").each(function(index){
							answeredQuestionId.push($(this).find("questiobankid").text());							
							answeredQuestion.push($(this).find("question").text());
							
							answerAnsIndex.push($(this).find("answerid").text());
							answeredAnsewer.push($(this).find("answer").text());
						});
				answeredQuestionDisplay();		
			}
			
	});
});

function answeredQuestionDisplay(){
	var outputResult="";
	outputResult+="<table class='quest-table' border=1>";
	outputResult+="<tr><th class='quest-table1' width='200px'>Questions</th>";
	outputResult+="<th class='quest-table1' width='60px'>Answered Date</th></tr>";
	
	outputResult+="<form action=''><tr>";
	for(var i = 0; i<answeredQuestion.length;i++){
		
		outputResult+="<tr><td><a  style='text-decoration:none;' href='#' onClick='overAnswer("+i+")'><label  id='questionUpdate"+i+"'>"+answeredQuestion[i]+"</label></a> </td><td><label style='display:none;' id='questionAnswer"+i+"'>"+answeredAnsewer[i]+"</label></td><td></tr>";
		}
	
	
	outputResult+="<tr></table>";
	outputResult+="<a class='f-rt' style='color:blue;' href='' onClick='$(\"#kmb_question_container\").show();'>Details</a>";
	$('#answer-display').html(outputResult);
}

function overAnswer(loop){
		
	 var outputAns = "";
	 editQuestion = $('#questionUpdate'+loop+'').text();
	 editChoice = $('#questionAnswer'+loop+'').text();
	
	outputAns+="<div style='margin-top: 40px; display:none;' id='kmb_question_container'><p>View or update the Answer:</p></br></br>";

	outputAns+="<table width='180px' height='50px' >";
	outputAns+="<tr><td><label id='edit-qus-id'>"+answeredQuestionId[loop]+"</label><label id='edit-qus-value'>"+editQuestion+"</label></td></tr>";
	
		if(editChoice == "Yes"){
			outputAns+="<tr><td><input type='radio' name='q1' value='1' checked='checked' ><label id='cur-id'>Yes</label</td></tr>";
			outputAns+="<tr><td><input type='radio' name='q1' value='2'  ><label id='cur-id'>No</label></td></tr>";
		} 
		if(editChoice == "No"){
			outputAns+="<tr><td><input type='radio' name='q1' value='1'  ><label id='cur-id'>Yes</label</td></tr>";
			outputAns+="<tr><td><input type='radio' name='q1' value='2' checked='checked'><label id='cur-id'>No</label></td></tr>";
			
		}
		outputAns+="</table>";
	
	outputAns+="<button onClick='closeit()' class='f-rt'>Return</button>"; 
	outputAns+="<button  onClick='updateValues()'>Update</button>"; 
	outputAns+="</div>";
	$('#click-det').html(outputAns);
	return false;
}

function updateValues(){
	 var editQuesid = $('#edit-qus-id').text();
	 var editQuesval = $('#edit-qus-value').text();
	 var editAnsId = $('input[name=q1]:radio:checked').val();
	var editCheckedAnswer = "";
	if(editAnsId == 1){
		editCheckedAnswer +="Yes";
	} else if(editAnsId == 2){
		editCheckedAnswer +="No";
	}

	
	   
	   $.post( '<c:url value='/secure/updateknowmebetter'/>'
		        , {'editCheckedAnswer':editCheckedAnswer,'editQuesval':editQuesval,'editQuesid':editQuesid,'editAnsId':editAnsId}
		        , function( data )
		        {
		        

		        }
				, 'json' ); 
	   
	  
}
	</script>
<!-- end -->



<div class="pre-que">
	<div id="answer-display">
	</div>
	
	<div id="click-det">
	</div>
</div>
							
							 
							 <div id="newque" class="new-que">
							  
							 </div>
			    
			    
			    
			    </td>
			    
			  </tr>
			</table>
<SCRIPT>
$('input[type="text"], textarea').each(function(){

	this.value = $(this).attr('title');
	$(this).addClass('text-label');

	$(this).focus(function(){
		if(this.value == $(this).attr('title')) {
			this.value = '';
			$(this).removeClass('text-label');
		}
	});

	$(this).blur(function(){
		if(this.value == '') {
			this.value = $(this).attr('title');
			$(this).addClass('text-label');
		}
	});
});

</SCRIPT>
</body>
</html>
