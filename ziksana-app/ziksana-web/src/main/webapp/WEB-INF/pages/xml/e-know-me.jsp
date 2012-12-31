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
	
	<!-- unanswered script -->
<c:url var="showUnAnswered" value="/secure/getunansweredquestions" />
<c:url var="showAnswered" value="/secure/getansweredquestions" />
  <script type="text/javascript">
  $(document).ready(function() {
		setInterval(function() {
			
	 
		}, 500);	
		
		get_and_UnAnswered_questions();
		
	});
  
  
function get_and_UnAnswered_questions(){  
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
					// console.log("unAnswered Question Id ==>"+ questionIdArray);
					// console.log("unanswered array: ==> " + questionArray);
					// console.log("option array==>"+  optionArray);
					// console.log("memberPersonalitytestId==>"+memberPersonalitytestId);
				
					
					

					
				
					
					displayUnAnsweredPairs(currentQuestion);		
					
			}
	
	});
	
});

}


function displayUnAnsweredPairs(current){
	var outputResult="";
	
	outputResult+="<div id='quest'>";
	outputResult+="<div id='question_info_message'></div>";
	outputResult+="<label style='display:none;' id='cur-qus-id'>"+questionIdArray[current]+"</label><label id='cur-qus-value'>"+questionArray[current]+"</label> ";
	outputResult+="<table width='180px' height='30px' >";

	var optionsList = optionArray[current].split("/");
	/* outputResult+= "<tr><td ><input type='radio'  id='checked-val'  checked='checked' name='radiobtn' value='1'><label id='option-ans' for='option'>Yes</label></td></tr>";
	outputResult+= "<tr><td ><input type='radio'  id='checked-val' name='radiobtn' value='2'><label id='option-ans' for='option'>No</label></td></tr>"; */
	 for(var i = 0 ; i < optionsList.length ; i++){
			
		outputResult+= "<tr><td ><input type='radio'  id='checked-val' name='radiobtn' value='"+i+"'>" + "<label id='option-ans' for='option'>" + optionsList[i] + "</label></td></tr>";
		
	} 
	//alert(current+","+questionArray.length);
	outputResult+="</table>";
	outputResult+="<br/>";
	
	
	outputResult+="<div id='question_buttons_container'>";
	if(current!=0){
		outputResult+="<div><input type='button' id='previous_question' onClick='prevquestion()' value='Previous'/></div>";
	}else{
		outputResult+="<div><input disabled='disabled' type='button' id='previous_question' onClick='prevquestion()' value='Previous'/></div>";
	}
	outputResult+="<div><input type='submit' id='submit_question_button' onClick='submitValue()' value='Submit'/></div>";
	if(current!=questionArray.length-1){
	outputResult+="<div><input  type='button' id='next_question' onClick='nextquestion()' value='Next' /></div>";
	} else {
	outputResult+="<div><input disabled='disabled' type='button' id='next_question' onClick='nextquestion()' value='Next' /></div>";
	}
	
	outputResult+='</div>';	
		
		 
	
	
	$('#newque').html(outputResult);
}

function checkBoxSelection(val){
	alert(val);
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
	var testQuestionValue;
	memberAnswer = '';
	 questionBankAnswerId = $('input[name=radiobtn]:checked').val();
	 
	  $("input:checked").each(function(){ 
		     testQuestionValue=$(this).val();
		     
		     if(testQuestionValue == 1){
				  memberAnswer = 'Yes';
			  }else{
				  memberAnswer= 'No';
			  } 
		     
		     $.post( '<c:url value='/secure/saveknowme'/>'
				        , {'memberAnswer':memberAnswer,'testQuestionValue':testQuestionValue,'testQuestionId':testQuestionId,'questionBankAnswerId':questionBankAnswerId}
				        , function( data )
				        {
				        
							$('#question_info_message').html("Answer Submitted Successfully");
							// setTimeout('$("#question_info_message").hide();',4000);
							$("input#submit_question_button").attr("disabled", "disabled");
							
				        }
						, 'xml' );  
		     
		});
  
}
</script>
<script type="text/javascript">
   function change(value){
   var x=value;
   if (x==2)
	{
	   get_and_Answered_questions();
	$('.new-que').hide();
	$('.pre-que').show();
	}
	else
	{
		get_and_UnAnswered_questions();
	$('.new-que').show();
	$('.pre-que').hide();
	}
     
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
#question_info_message_update{padding: .5em; color: green; font-family: arial, sans-serif;}
#question_info_message {padding: .5em; color: green; font-family: arial, sans-serif;}
#question_buttons_container{display:table; width: 100%;}   
#question_buttons_container > div{display:table-cell;}   
   
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
						  <option value="1" selected="selected" >Show Me - New Questions</option>
						  <option value="2" >Show Me - Previously Answered</option>						  
					  </select>
					</form>
       </div>

		<div class="pre-que">
 			<div id="answer-display">
 						
 			</div>
							
			<div id="click-det">
			</div>
		</div>
							
							 
		<div id="newque" class="new-que">
							  
		</div>
			    
			    
				 
<!-- Apply Answer value -->

  <script type="text/javascript">
  function get_and_Answered_questions(){
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
					answerDate = new Array();
					answerAnsIndex = new Array();
						$(data).find("answered").each(function(index){
							answeredQuestionId.push($(this).find("questiobankid").text());							
							answeredQuestion.push($(this).find("question").text());
							answerDate.push($(this).find("responsedate").text());
							answerAnsIndex.push($(this).find("answerid").text());
							answeredAnsewer.push($(this).find("answer").text());
						});
				answeredQuestionDisplay();		
			}
			
	});
});

}





function answeredQuestionDisplay(){
	var outputResult="";
	outputResult+="<table id='updateTable' value='hide' class='quest-table' border=1>";
	outputResult+="<tr><th  width='200px'>&nbsp;&nbsp;&nbsp;Questions</th>";
	outputResult+="<th  width='120px'>Answered Date</th></tr>";
	
	outputResult+="<form action=''><tr>";
	for(var i = 0; i<answeredQuestion.length;i++){
		outputResult+="<tr><td width='200px'><a  style='text-decoration:none; margin-left:0px;' href='#' onClick='displayAnsweredQuestionContainer("+i+")'><label  id='questionUpdate"+i+"'>"+answeredQuestion[i]+"</label></a> </td><td><label  id='questionDate"+i+"'>"+answerDate[i]+"</label></td><td ><label style='display:none;' id='questionAnswer"+i+"'>"+answeredAnsewer[i]+"</label></td></tr>";
		//outputResult+="<tr><td><a  style='text-decoration:none;' href='#' onClick='displayAnsweredQuestionContainer("+i+")'><label  id='questionUpdate"+i+"'>"+answeredQuestion[i]+"</label></a> </td><td><label style='display:none;' id='questionAnswer"+i+"'>"+answeredAnsewer[i]+"</label></td><td><label  id='questionAnswer"+i+"'>"+answerDate[i]+"</label></td><td></tr>";
		}
	
	
	outputResult+="<tr></table>";
	outputResult+="<a class='' style='color:blue;float:right;' href='#' onClick='$(\"#answered_question_form_container\").show();'>Details</a>";
	$('#answer-display').html(outputResult);
}

function displayAnsweredQuestionContainer(loop){
		
	 var outputAns = "";
	 editQuestion = $('#questionUpdate'+loop+'').text();
	 editChoice = $('#questionAnswer'+loop+'').text();
	 alert(editChoice);
	
	outputAns+="<div style='display:none;' id='answered_question_form_container'>";
	outputAns+="<br/></br><u><p>View or update the Answer:</p></u>";
	outputAns+="<div>";
	outputAns+="<div id='question_info_message_update'></div>";
	outputAns+="<br/></br><label style='display:none;' id='edit-qus-id'>"+answeredQuestionId[loop]+"</label><label id='edit-qus-value'>"+editQuestion+"</label>";
	
		if(editChoice == "Yes"){
			outputAns+="</br><input type='radio' name='q1' value='1' checked='checked' /><label id='cur-id'>Yes</label>";
			outputAns+="</br><input type='radio' name='q1' value='2'/><label id='cur-id'>No</label>";
		} 
		if(editChoice == "No"){
			outputAns+="</br><input type='radio' name='q1' value='1'  /><label id='cur-id'>Yes</label>";
			outputAns+="</br><input type='radio' name='q1' value='2' checked='checked'/><label id='cur-id'>No</label>";
		}
	
	outputAns+="</div>"; 
	outputAns+="<button onClick='$(\"#answered_question_form_container\").hide();' class='f-rt'>Return</button>"; 
	outputAns+="<button  onClick='updateValues()' class='f-rt'>Submit Revisions</button>"; 
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
		        
					change(2);
		        	$('#question_info_message_update').html("Answer Updated Successfully");
					

		        }
				 ); 
	   
}
	</script>
<!-- end -->
	
			    
			    </td>
			    
			  </tr>
			</table>

</body>
</html>
