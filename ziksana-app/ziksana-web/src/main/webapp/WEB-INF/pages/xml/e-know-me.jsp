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
  $('table.highlight_rows td').live('click', function(){
		td = $(this);
		table = $(this).parents('table');
		td.click(function(){
			$(this).parents('table').find('tr').removeClass('highlighted_row');
			
			$(this).parent('tr').addClass('highlighted_row');
			
			
		});
		
	});
  function closeIt(){
		
	 
	  parent.jQuery.fancybox.close();
	   
}
  $(document).ready(function() {
		setInterval(function() {
			
	 
		}, 500);	
		
		get_and_UnAnswered_questions();
	
	}); // end of doc ready
	
	
	function get_and_UnAnswered_questions(){
		$.ajax({
		  	type: 'GET',
			url: '${showUnAnswered}',
			dataType: 'xml',
			success: function( data ) {
					var output="";
					var firstpollid="";
					var lastpollid="";
						$(data).find("unanswered").each(function(index){
							var question = "<br/><p style='font-weight:bold; clear:both;display:inline; text-decoration:none; margin-left:0px; cursor:pointer;color:grey;'>" + $(this).find("Question").text() + "</p><br/>";
							var currentId = $(this).find("questiobankid").text();
							output+="<div id='question_info_message' style='font-family:verdana; '></div>";
							if ($(this).find("Questions").find("Question").text()){
						 		output+="<div id='q" + index + "' style='width: 418px;' class='knowmequestion'>";
						 		output+=question;
						 		
						 		output+="<input type='hidden' id='quesId"+index+"' name='quesId"+index+"' value='" + $(this).find("questiobankid").text() + "'>";
						 		output+="<input type='hidden' id='quesValue"+index+"' name='quesValue"+index+"' value='" + $(this).find("Question").text() + "'>";
						 		
						 		
						 		var answers="";
						 		var quesAnswerArray = new Array();
						 		var quesAnsArrayindex = new Array();
						 		$(this).find("options").find("option").each(function(answerindex){
						 			
						 			quesAnswerArray[$(this).attr('index')-1]=$(this).text();
									quesAnsArrayindex[$(this).attr('index')-1]=$(this).attr('index');
						 			
									
						 								 				
						 		});
						 		
						 		for(var i = 0; i < quesAnswerArray.length ; i++){
						 			answers+= "<br/>";
						 			if(i == 0){
						 			answers+= "<input type='radio'  checked  id='checked-val'  name='question_" + currentId +"' value='"+quesAnsArrayindex[i]+"--"+quesAnswerArray[i]+"'>" + quesAnswerArray[i] + "<br/>";
						 			}else{
						 				answers+= "<input type='radio' id='checked-val'  name='question_" + currentId +"' value='"+quesAnsArrayindex[i]+"--"+quesAnswerArray[i]+"'>" + quesAnswerArray[i] + "<br/>";
						 			}
						 		}
						 		
					 		
						 		
						 		output+=answers;
						 		output+="<br/>";
							} else {
								output+="<div id='q" + index + "' style='width: 225px;' class='knowmequestion' expired='true'>";
								output+=question;
							}
							var result="";
							if (index == 0){
								firstquestionId = $(this).find("questiobankid").text();
								
								output+="<div style='width:300px;margin-left:118px;margin-top:30px;' id='result" + index + "' class='knowmeresult'>"+result+"<button id='submit_knowme" + index + "' onClick='submitKnowmeBetter(" + index + ")' style='width:70px;height:30px; margin-left:30px; ' class='votebtn btn btn btn-info-knowme'>Submit</button><button id='" + index + "' onclick='' style='margin-left:25px;height:30px; width:70px;' class='btnnext btn btn-info-knowme'>Next </button></div></div>";
					 		} else {
					 			if (index == ($(data).find("unanswered").size()-1)){

									lastquestionId = $(this).find("questiobankid").text();
									
									output+="<div style='width:300px;margin-left:118px;margin-top:30px;' id='result" + index + "' class='knowmeresult'>"+result+"<button  style='float:left; height:30px; width:70px;' onclick='' class='btnprev btn btn-info-knowme' id='"+ index +"' >Prev</button><button id='submit_knowme" + index + "' onClick='submitKnowmeBetter(" + index + ")' style='width:70px; height:30px;margin-left:30px;' class='votebtn btn btn btn-info-knowme'>Submit</button></div></div>";
								}
								else {
									
						 			output+="<div  style='width:300px; margin-left:118px; margin-top:30px;' id='result" + index + "' class='knowmeresult '>"+result+"<button onclick='' id='"+ index + "' style='float:right;width:70px;height:30px;' class='btnnext btn btn-info-knowme'>Next </button><button  style='width:70px;margin-left:30px;height:30px;' class='btnprev btn btn-info-knowme' id='"+ index + "' >Prev</button><button id='submit_knowme" + index + "' onClick='submitKnowmeBetter(" + index + ")'style='width:70px;margin-left:30px;height:30px;'  class='votebtn btn btn btn-info-knowme'>Submit</button></div></div>";
						 		};
					 		}
							
							
						});
						
					$('#newque').html(output);
					//to view the very first poll when page loads
			        //hide all result first
			       
			        $("div.knowmequestion").hide();
			        
			        //show the first poll question
			        $("div#q0").show();
					
					$('input[type=radio]').click( function(event){
			        	//alert('test alert')
			        	//console.log("radio button clicked " + $(this).attr('name'));
              			
              			$(this).parent().children("input#optionIndex").attr("value", $(this).attr("value"));
              			console.log("hidden input#optionIndex value " + $(this).parent().children("input#optionIndex").attr("value"));
              		});
					
					//associate click event to all next buttons
					$("button.btnnext").click( function(event){
						$("div#q" + event.target.id).hide();
              			$("div#q" + (parseInt(event.target.id)+1)).show();
						$('div#question_info_message').hide();
              			if($("div#q" + (parseInt(event.target.id)+1)).attr("expired")){
              				$("div#result" + (parseInt(event.target.id)+1)).show();
              			}
              		});
					
					//associate click event to all previous buttons
					$("button.btnprev").click( function(event){
						$("div#q" + event.target.id).hide();
						$("div#q" + (parseInt(event.target.id)-1)).show();
						$('div#question_info_message').hide();
						if($("div#q" + (parseInt(event.target.id)-1)).attr("expired")){
              				$("div#result" + (parseInt(event.target.id)-1)).show();
              			}
              		});
					
					}
					
					
				});
		
	
	}
	
	function submitKnowmeBetter(index){
		var cur_question_id = $('#quesId'+index+'').val();
		var testQuestionValue =  $('#quesValue'+index+'').val();
		var question_answer = $('input[name="question_'+cur_question_id+'"]:checked').val();
		var answerid_answer_pair = new Array();
		answerid_answer_pair = question_answer.split("--");
		var questionBankAnswerId = answerid_answer_pair[0];
		var memberAnswer = answerid_answer_pair[1];	    
	
		 $.post('<c:url value='/secure/saveknowme'/>'
			        , {'memberAnswer':memberAnswer,'testQuestionValue':testQuestionValue,'testQuestionId':cur_question_id,'questionBankAnswerId':questionBankAnswerId}
			        , function( data )
			        {
			        
						$('div#question_info_message').show();
						$('#question_info_message').html("Answer Submitted Successfully");
						 $('#submit_knowme'+index+'').attr('disabled','true');						 
						 $('#submit_knowme'+index+'').removeClass('btn-info-knowme'); 
						
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
	$('#answered_question_form_container').hide();
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
		<button class='btn btn-info-knowme'style='margin-left:345px;margin-top:30px;height:30px; width:70px;' onClick=' parent.jQuery.fancybox.close();' class='f-rt'>Return</button>
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
	outputResult+="<tr style='background-color:#3ca3c1;height:30px;border:1px solid gray;'><th width='200px' style='color:#fff; font-weight:bold;'>&nbsp;&nbsp;&nbsp;QUESTIONS</th>";
	outputResult+="<th  width='200px' style='color:#fff; font-weight:bold;'>ANSWERED DATE</th></tr>";
	
	
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
				
		 				
		 	});

			for(var i=0;i<ansArrayindex.length;i++){
				if(checkedvalex == ansArrayindex[i]){
	 				outputAns+="<br/><input type='radio' name='optbtn' checked value='"+ansArrayindex[i]+"/"+answerArray[i]+"'/><label id='cur-id'>"+answerArray[i]+"</label>";
	 				}else
	 				outputAns+="<br/><input type='radio' name='optbtn' value='"+ansArrayindex[i]+"/"+answerArray[i]+"'/><label id='cur-id'>"+answerArray[i]+"</label>";
			}

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
	

	
	   
	    $.post( '<c:url value='/secure/updateknowmebetter'/>'
		        , {'editCheckedAnswer':split_ansid_ans[1],'editQuesval':editQuesval,'editQuesid':editQuesid,'editAnsId':split_ansid_ans[0],'memberPersonalityTestId':memberpersonalityTestIdAnswered}
		        , function( data )
		        {
		        
					
					$('#question_info_message_update').show();
		        	$('#question_info_message_update').html("Answer Updated Successfully");
		        	get_and_Answered_questions();

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
