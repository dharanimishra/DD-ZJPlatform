<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html >
<head>
	 <link rel="stylesheet" href="../resources/css/zeni/zeni2.css" />
<!--	<link rel="stylesheet" href="../resources/css/bootstrap.css" /> -->
	<link href="../resources/images/ziksana-icon.png" rel="shortcut icon"/>
	<link rel="stylesheet" type="text/css" media="screen" href="../resources/css/basic-styles.css"/>
		<link rel="stylesheet" type="text/css" href="../resources/css/custom-theme/old-jquery-ui-1.8.21.custom.css">
	<link rel="stylesheet" type="text/css" href="../resources/css/custom-theme/jquery-ui-1.8.21.custom.css">
    <link rel="stylesheet" type="text/css" media="screen" href="../resources/css/type-setting.css"/>
  
	<script src="../resources/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="../resources/js/sortable.js"></script>
	<script src="../resources/js/ui/jquery.ui.core.js"></script>
	<script src="../resources/js/ui/jquery.ui.widget.js"></script>
	<script src="../resources/js/ui/jquery.ui.tabs.js"></script>
	<script src="../resources/js/ui/jquery.ui.progressbar.js"></script>
	<script src="../resources/js/ui/jquery.ui.button.js"></script>
	
<style>
.row-hover {

 border:2px solid #27b ! important;
 background-color:#66CCFF;
 color: blue;
 }
 #updateTable tr:hover td {background: #CADFE2 !important;}

.btn {
  border-color: #c5c5c5;
  border-color: rgba(0, 0, 0, 0.15) rgba(0, 0, 0, 0.15) rgba(0, 0, 0, 0.25);
} 
.btn-info-knowme {
  color: #ffffff;
  text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
  background-color: #49afcd;
  background-image: -moz-linear-gradient(top, #5bc0de, #2f96b4);
  background-image: -webkit-gradient(linear, 0 0, 0 100%, from(#5bc0de), to(#2f96b4));
 
  background-image: -o-linear-gradient(top, #5bc0de, #2f96b4);
  background-image: linear-gradient(to bottom, #5bc0de, #2f96b4);
  background-repeat: repeat-x;
  filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ff5bc0de', endColorstr='#ff2f96b4', GradientType=0);
  border-color: #2f96b4 #2f96b4 #1f6377;
  border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
  

  filter: progid:DXImageTransform.Microsoft.gradient(enabled = false);
}
</style>
	<!-- unanswered script -->
<c:url var="showUnAnswered" value="/secure/getunansweredquestions" />
<c:url var="showAnswered" value="/secure/getansweredquestions" />
	<style>
		.highlighted_row td {background: orange;}
		.highlighted_row tr:hover td {background: orange !important;}
	</style>
  <script type="text/javascript">
  function closeIt(){
		 
	  parent.jQuery.fancybox.close();
	 
	 
	  
}
  $(document).ready(function() {
		setInterval(function() {
			
	 
		}, 500);	
		
		get_and_UnAnswered_questions();
		

	
	$('table.highlight_rows td').live('click', function(){
		td = $(this);
		table = $(this).parents('table');
		td.click(function(){
			$(this).parents('table').find('tr').removeClass('highlighted_row');
			
			$(this).parent('tr').addClass('highlighted_row');
			
			
		});
		
	});
		
	}); // end of doc ready
  
  
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
					 memberPersonalitytestId=0;
					 
					$(data).find("Questions").each(function(index){
						
						//var pairIdQuestion = $(this).find("questiobankid").text()+"="+$(this).find("Question").text();
						 questionArray.push($(this).find("Question").text()); 
						
						questionIdArray.push($(this).find("questiobankid").text());
						
						var options = "";
						var option_index= "";
				 		$(this).find("options").each(function(){
				 			memberPersonalitytestId = $(this).find("memberpsttestid").text();
				 			$(this).find("option").each(function(){
				 				
				 				options +=  $(this).text()+"/";
				 				option_index += $(this).attr('index')+"/";
				 				
				 			});
				 			options = options.substring(0,options.length-1);
				 			option_index = option_index.substring(0,option_index.length-1);
				 			
				 			optionArray.push(options);
				 			optionIndexArray.push(option_index);	
				 			console.log(options);
					 		console.log(optionIndexArray);
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
	if(questionIdArray[current] == null){
		outputResult+="<br/><br/><div style='text-align=center'>No New Questions</div>";
	}else{
	outputResult+="<div id='quest'>";
	outputResult+="<div id='question_info_message'></div>";
	outputResult+="<input type='hidden' id='cur-qus-id' value='"+questionIdArray[current]+"'/><label id='cur-qus-value'>"+questionArray[current]+"</label><label style='display:none;' id='cur-user-member'>"+memberPersonalitytestId+"</label> ";
	outputResult+="<table  width='180px' height='30px' >";

	var optionsList = optionArray[current].split("/");
	var optionsIdList = optionIndexArray[current].split("/");
	var optionsList1=[];
	var optionsIdList1=[];
	for(var i = 0; i < optionsIdList.length ; i++){
		
		optionsList1[optionsIdList[i]-1]=optionsList[i];
		optionsIdList1[optionsIdList[i]-1]=optionsIdList[i];
	}
	
	 for(var i = 0; i < optionsIdList.length ; i++){
		
			if(i==0){
			outputResult+= "<tr><td ><input type='radio'  checked  id='checked-val'  name='question_" + questionIdArray[current] +"' value='"+optionsIdList1[i]+"--"+optionsList1[i]+"'>" + optionsList1[i] + "</td></tr>";
			} else {
			outputResult+= "<tr><td ><input type='radio'  id='checked-val'  name='question_" + questionIdArray[current] +"' value='"+optionsIdList1[i]+"--"+optionsList1[i]+"'>" + optionsList1[i] + "</td></tr>";	
			}
		}
	
	outputResult+="</table>";
	outputResult+="<br/>";
	
	
	outputResult+="<div style='width:200px;margin-left:150px;'  id='question_buttons_container'>";
	if(current!=0){
		outputResult+="<div width='50px'><input class='btn btn-info-knowme' type='button' id='previous_question' onClick='prevquestion()' value='Previous'/></div>";
	}else{
		outputResult+="<div width='50px'><input class='btn btn-info-knowme'  style='display: none;' type='button' id='previous_question' onClick='prevquestion()' value='Previous'/></div>";
	}
	outputResult+="<div width='50px'><input class='btn btn-info-knowme' type='submit' id='submit_question_button' onClick='submitValue()' value='Submit'/></div>";
	if(current!=questionArray.length-1){
	outputResult+="<div width='50px'><input class='btn btn-info-knowme'  type='button' id='next_question' onClick='nextquestion()' value='Next' /></div>";
	} else {
	outputResult+="<div width='50px'><input class='btn btn-info-knowme' style='display: none;' type='button' id='next_question' onClick='nextquestion()' value='Next' /></div>";
	}
	
	outputResult+='</div>';	
		
		 
	}
	
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
	question_id = $('#cur-qus-id').val();
	var testQuestionValue = $('#cur-qus-value').text();
	memberPstTestQuestionId = $('#cur-user-member').text();
	question_answer = $('input[name="question_'+question_id+'"]:checked').val();

	
	//console.log(question_answer);
	
	var answerid_answer_pair = new Array();
	answerid_answer_pair = question_answer.split("--");
	questionBankAnswerId = answerid_answer_pair[0];
	memberAnswer = answerid_answer_pair[1];

		   
		       $.post('<c:url value='/secure/saveknowme'/>'
				        , {'memberAnswer':memberAnswer,'testQuestionValue':testQuestionValue,'testQuestionId':question_id,'questionBankAnswerId':questionBankAnswerId, 'memPstTestId':memberPstTestQuestionId}
				        , function( data )
				        {
				        
							//alert("Answer Submitted Successfully");
							$('#question_info_message').html("Answer Submitted Successfully");
							$("#knowme-save").attr('disabled','true');
				        }
						);   
		  
		    
		
  
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

tr:hover{

}
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
<!-- <img align="left" style="margin-right:10px; margin-top: 6px; margin-right:5px; height:20px; width:20px; padding-left:5px;" src="../resources/images/icons/helpicon.png"> -->
<div class="helptext">You can answer a few personality questions to help us undersatnd you better..</div>
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
		<div style="">	    
		<button class='btn btn-info-knowme'style='margin-left:345px;margin-top:30px;height:30px;' onClick=' parent.jQuery.fancybox.close();' class='f-rt'>Return</button>
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
					memberpersonalityTestIdAnswered=0;
						$(data).find("answered").each(function(index){
							answeredQuestionId.push($(this).find("questiobankid").text());							
							answeredQuestion.push($(this).find("question").text());
							answerDate.push($(this).find("responsedate").text());
							answerAnsIndex.push($(this).find("answerid").text());
							answeredAnsewer.push($(this).find("answer").text());
							memberpersonalityTestIdAnswered=$(this).find("memberpersonalitytestid").text();
						});
						
				answeredQuestionDisplay();		
			}
			
	});
});

}





function answeredQuestionDisplay(){
	var outputResult="";
	outputResult+="<br/>";
	outputResult+="<table id='updateTable'  value='hide' class=' table tab1' style='border:1px solid gray;'>";
	outputResult+="<tr style='background-color:#3ca3c1;height:30px;border:1px solid gray;'><th width='200px' style='color:#fff;'>&nbsp;&nbsp;&nbsp;QUESTIONS</th>";
	outputResult+="<th  width='200px' style='color:#fff;'>ANSWERED DATE</th></tr>";
	
	
	for(var i = 0; i<answeredQuestion.length;i++){
		outputResult+="<tr  id='knowmew_row_"+i+"' onClick='displayAnsweredQuestionContainer("+i+")' ><td style='border-bottom:1px solid gray;' width='200px'><a style='text-decoration:none; margin-left:0px;' ><label  id='questionUpdate"+i+"'>"+answeredQuestion[i]+"</label> </td><td style='border-bottom:1px solid gray;'><label  id='questionDate"+i+"'>"+answerDate[i]+"</label><label style='display:none;' id='questionAnswerId"+i+"'>"+answerAnsIndex[i]+"</label><label style='display:none;' id='questionAnswer"+i+"'>"+answeredAnsewer[i]+"</label></a></td></tr>";
		
		}
	
	
	outputResult+="</table>";
	
	$('#answer-display').html(outputResult);
}


<c:url var="showUnAnsweredbyId" value="/secure/getunansweredquestionsbyid/" />
function displayAnsweredQuestionContainer(loop){
	
	 $('#updateTable tr').removeClass('row-hover');
		$('#knowmew_row_'+loop+'').addClass('row-hover');  
	var outputAns = "";
	 editQuestion = $('#questionUpdate'+loop+'').text();
	 editChoice = $('#questionAnswer'+loop+'').text();
	 //alert(editChoice);
	var checkedvalex = answerAnsIndex[loop];

	$.ajax({
	  	type: 'GET',
		url: '${showUnAnsweredbyId}'+answeredQuestionId[loop]+'',
		dataType: 'xml',
		success: function( data ) {
			
			outputAns+="<div style='' id='answered_question_form_container'>";
			outputAns+="<br/></br><u><p style='font-weight:bold;'>View or update the Answer:</p></u>";
			outputAns+="<div>";
			outputAns+="<div id='question_info_message_update'></div>";
			outputAns+="<br/><label style='display:none;' id='edit-qus-id'>"+answeredQuestionId[loop]+"</label><label id='edit-qus-value'>"+editQuestion+"</label><br/>";
					
			var ansArrayindex=[];
			var answerArray=[];
			$(data).find("option").each(function(){
				answerArray[$(this).attr('index')-1]=$(this).text();
				ansArrayindex[$(this).attr('index')-1]=$(this).attr('index');
				
		 				//if(checkedvalex == $(this).attr('index')){
		 				//outputAns+="<br/><input type='radio' name='optbtn' checked value='"+$(this).attr('index')+"/"+$(this).text()+"'/><label id='cur-id'>"+$(this).text()+"</label>";
		 				//}else
		 				//outputAns+="<br/><input type='radio' name='optbtn' value='"+$(this).attr('index')+"/"+$(this).text()+"'/><label id='cur-id'>"+$(this).text()+"</label>";
		 	});
			//alert(answerArray);
			for(var i=0;i<ansArrayindex.length;i++){
				if(checkedvalex == ansArrayindex[i]){
	 				outputAns+="<br/><input type='radio' name='optbtn' checked value='"+ansArrayindex[i]+"/"+answerArray[i]+"'/><label id='cur-id'>"+answerArray[i]+"</label>";
	 				}else
	 				outputAns+="<br/><input type='radio' name='optbtn' value='"+ansArrayindex[i]+"/"+answerArray[i]+"'/><label id='cur-id'>"+answerArray[i]+"</label>";
			}
		 	///
		 	outputAns+="</div>"; 
		 	outputAns+="<div>"; 
		 	outputAns+="<button class='btn btn-info-knowme' style='margin-left:0px;margin-top:30px;height:30px;' onClick='updateValues()' class='f-rt'>Submit Revisions</button>";
			
			 
			outputAns+="</div>"; 
			
			$('#click-det').html(outputAns);		 	
			
		}
		
	});
				
	return false;
}

function updateValues(){
	 var editQuesid = $('#edit-qus-id').text();
	 var editQuesval = $('#edit-qus-value').text();
	 var editAnsId = $('input[name=optbtn]:radio:checked').val();
	var editCheckedAnswer = "";

	var split_ansid_ans = new Array();
	split_ansid_ans = editAnsId.split("/");
	/* alert(editQuesid);
	alert(editQuesval);
	alert(editAnsId);
	alert("Id"+split_ansid_ans[0]);
	alert("value"+split_ansid_ans[1]); */

	
	   
	    $.post( '<c:url value='/secure/updateknowmebetter'/>'
		        , {'editCheckedAnswer':split_ansid_ans[1],'editQuesval':editQuesval,'editQuesid':editQuesid,'editAnsId':split_ansid_ans[0],'memberPersonalityTestId':memberpersonalityTestIdAnswered}
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
