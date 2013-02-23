$(document).ready(function(e) {
		var counter = 2;
		var a = 1;
		var desc = 3;
		var val = null;
		var multi = 3;
		
	//$("#delete").hide();
	// Adds choice when clicked on the add choice button on multichoice single
    $("#addmultisingle").click(function(e) {
			
        $("#controls_QuesMultiChoicesingle").append('<tr id=multisinglerows><td><input type="text" class="defaultvalue validate[required]" placeholder="Enter your Choice" style="width:400px;"/></td><td><input name="answertype" type="radio"></td><td><label class="labelclass" for="Correct Answers" >Choose the Correct Asnwer</label></td><td><a href="#linkurl" id=Delete'+counter+'><img src="../images/delete.jpg" height="12px" width="12px"/></a></td></tr>');
	
	
	$("#Delete"+counter).click(function(e) {
		
        $("#multisinglerows").remove();
    });
	counter++;
	});
	
	
	// Adds choice when clicked on the add choice button on multi choice multi
    $("#addmultimulti").click(function(e) {
        $("#controls_QuesMultiChoicemulti").append('<tr id=multirows'+multi+'><td><input type="text" class="defaultvalue validate[required]" id=mcmques'+multi+' name=mcmques'+multi+' placeholder="Enter your Choice" tabindex="" style="width:400px;"/></td><td style="margin-top:-5px;"><input name="maxcheck1" id="maxcheck1" class="validate[minCheckbox[2] checkbox]" type="checkbox" value="True"/><label class="labelclass" for="Correct Answers" >Choose the Correct Asnwer</label></td><td><a href="#linkurl" id=Delete'+multi+'><img src="../images/delete.jpg" height="12px" width="12px"/></a></td></tr> ');    
		
	$("#Delete"+multi).click(function(e) {
        $("#multirows"+multi).remove();
		multi--;
    });
	
	multi++;
	});
	
	// Adds choice when clicked on the add choice button on ordering choice
    $("#Addorderingchoice").click(function(e) {
        $("#controls_Quesorderingchoice").append('<tr id=orderingchoicerows><td><input type="text" class="defaultvalue validate[required]" placeholder="Enter your Choice" style="width:400px;" /></td><td style="margin-top:-5px;"></td><td><a href="#linkurl" id=Delete'+counter+'><img src="../images/delete.jpg" height="12px" width="12px"/></a></td>     </tr>');
   
	$("#Delete"+counter).click(function(e) {
        $("#orderingchoicerows").remove();
    });
	counter++;
	});
	
	
	
	// Adds question when clicked on the add choice button on match the follwing
    $("#Addmatchfollowingquestion").click(function(e) {
		a++;
        $("#controls_QuesMatchfollowingfirst").append('<tr id=matchquestionrows><td><span style="margin-top:10px; color:#69F;"> Q-'+a+' </span></td><td><input type="text" class="defaultvalue validate[required]" placeholder="Enter the Question" style="width:160px;"/></td><td><a href="#linkurl" id=Delete'+counter+'><img src="../images/delete.jpg" height="12px" width="12px"/></a></td></tr>');
	
	$("#Delete"+counter).click(function(e) {
        $("#matchquestionrows").remove();
    });
	counter++;
	});
	
	
	
	// Adds answer when clicked on the more answers choice button on match the follwing
    $("#Addmatchfollowinganswer").click(function(e) {
        $("#controls_QuesMatchfollowingsecond").append('<tr id=matchfollowingrows>  <td><input type="text" class="defaultvalue validate[required]" placeholder="Enter the Answer" style="width:120px;" /> </td>  <td><select name="SelectArea" class="defaultvalue labelclass" style="width:190px; margin-left:5px; font-size:11px; padding:5px;"> <option>Select the Matching Question </option></select> </td> <td><a href="#linkurl" id=Delete'+counter+'><img src="../images/delete.jpg" height="12px" width="12px"/></a></td></tr>');
	
	$("#Delete"+counter).click(function(e) {
        $("#matchfollowingrows").remove();
    });
	counter++;
	});
	
	
	
	// Adds input for keyword for auto grading and adds drop down for specifying its weight
    $("#Addgradedescriptive").click(function(e) {
		
        $("#controls_QuesDescriptive").append('<tr><td><input type="text" id=deskeywords'+desc+' class="defaultvalue validate[required]" placeholder="Enter keywords for Autograding" tabindex="" style="width:295px;" /></td> <td id=removeen'+desc+'><select name=desweight'+desc+' id=desweight'+desc+' disabled="disabled" class="defaultvalue labelclass" style="width:205px; margin-left:5px; font-size:12px; padding:5px;"> <option>Select Keyword Weight </option><option>1 </option><option>2 </option><option>3 </option><option>4 </option><option>5 </option><option>6 </option><option>7 </option><option>8 </option><option>9 </option><option>10</option></select></td><td><a href="#linkurl" id=Delete'+counter+'><img src="../images/delete.jpg" height="12px" width="12px"/></a></td></tr>');
	
	$("#controls_QuesDescriptive tr td :input").click(function(e) {
        var str = $(this).attr('id');
		//alert(str);
		var len = str.length;
		val = str.substring(len-1, len);
		//alert(val);
		$("#"+str).focusout(function(e) {
			//alert(($("#"+str).val()));
            if ($("#"+str).val() !=  "")	
				{
					//alert("true");					
			 $('#desweight'+val).removeAttr('disabled');
			 }				
			 else			
			 {//alert("false");			
			 $("#desweight"+val).attr('disabled', 'disabled');	    
			 }
        });
		
    });
	
	$("#Delete"+counter).click(function(e) {
        $("#descriptiverows").remove();
    });
	
	
		desc++;
		counter++;
	});
	
	
	
	//all Question stuff from Create new question
						
    $('#_QuesTrueFalse').hide();
	$('#_QuesMultiChoicesingle').hide();
	$('#_QuesMultiChoicemulti').hide();
	$('#_Quesorderingchoice').hide();
	$('#_QuesMatchfollowing').hide();
	$('#_QuesFillBlanks').hide();
	$('#_QuesJumbledques').hide();
	$('#_QuesDescriptive').hide();
	$('#_QuesMaths').hide();
	$('#_QuesFrame').hide();
	
	
	$('#_QuesSelect').change( function () {
        if ($('#_QuesSelect').val() == "True/False"){
            $('#_QuesTrueFalse').slideDown("");
			$('#_QuesMultiChoicesingle').hide();
			$('#_QuesMultiChoicemulti').hide();
			$('#_Quesorderingchoice').hide();
			$('#_QuesMatchfollowing').hide();
			$('#_QuesFillBlanks').hide();
			$('#_QuesJumbledques').hide();
			$('#_QuesDescriptive').hide();
			$('#_QuesMaths').hide();
				$('#_QuesFrame').hide();
		
			 
		}
		
		 else if ($('#_QuesSelect').val() == "MultiChoiceSingle"){
           	
			$('#_QuesMultiChoicesingle').slideDown("");
			 $('#_QuesTrueFalse').hide();
			 $('#_QuesMultiChoicemulti').hide();
			 $('#_Quesorderingchoice').hide();
			 $('#_QuesMatchfollowing').hide();
			 $('#_QuesFillBlanks').hide();
			 $('#_QuesJumbledques').hide();
			 $('#_QuesDescriptive').hide();
			 $('#_QuesMaths').hide();
			 	$('#_QuesFrame').hide();
		
			  
		 }
		 
		  else if ($('#_QuesSelect').val() == "MultiChoiceMulti"){
           	
			$('#_QuesMultiChoicemulti').slideDown("");
			 $('#_QuesTrueFalse').hide();
			 $('#_QuesMultiChoicesingle').hide();
			 $('#_Quesorderingchoice').hide();
			$('#_QuesMatchfollowing').hide();
			$('#_QuesFillBlanks').hide();
			$('#_QuesJumbledques').hide();
			$('#_QuesDescriptive').hide();
			$('#_QuesMaths').hide();
				$('#_QuesFrame').hide();
		
			  
		 }
		 
		 
		   else if ($('#_QuesSelect').val() == "OrderingChoices"){
           	
			$('#_Quesorderingchoice').slideDown("");
			 $('#_QuesTrueFalse').hide();
			 $('#_QuesMultiChoicesingle').hide();
			 $('#_QuesMultiChoicemulti').hide();
			 $('#_QuesMatchfollowing').hide();
			 $('#_QuesFillBlanks').hide();
			 $('#_QuesJumbledques').hide();
			 $('#_QuesDescriptive').hide();
			 $('#_QuesMaths').hide();
			 	$('#_QuesFrame').hide();
			
					  
		 }
		 
		 
		    else if ($('#_QuesSelect').val() == "MatchFollowing"){
           	
			$('#_QuesMatchfollowing').slideDown("");
			 $('#_QuesTrueFalse').hide();
			 $('#_QuesMultiChoicesingle').hide();
			 $('#_QuesMultiChoicemulti').hide();
			 $('#_Quesorderingchoice').hide();
			 $('#_QuesFillBlanks').hide();
			 $('#_QuesJumbledques').hide();
			 $('#_QuesDescriptive').hide();
			 $('#_QuesMaths').hide();
			 	$('#_QuesFrame').hide();
			
					  
		 }
		 
		 
		  else if ($('#_QuesSelect').val() == "FillBlanks"){
           	
			$('#_QuesFillBlanks').slideDown("");
			 $('#_QuesTrueFalse').hide();
			 $('#_QuesMultiChoicesingle').hide();
			 $('#_QuesMultiChoicemulti').hide();
			 $('#_Quesorderingchoice').hide();
			 $('#_QuesMatchfollowing').hide();
			 $('#_QuesJumbledques').hide();
			 $('#_QuesDescriptive').hide();
			 $('#_QuesMaths').hide();
			 	$('#_QuesFrame').hide();
		
					  
		 }
		 
		 else if ($('#_QuesSelect').val() == "JumbledSequence"){
           	
			$('#_QuesJumbledques').slideDown("");
			 $('#_QuesTrueFalse').hide();
			 $('#_QuesMultiChoicesingle').hide();
			 $('#_QuesMultiChoicemulti').hide();
			 $('#_Quesorderingchoice').hide();
			 $('#_QuesMatchfollowing').hide();
			 $('#_QuesFillBlanks').hide();
			 $('#_QuesDescriptive').hide();
			 $('#_QuesMaths').hide();
			 	$('#_QuesFrame').hide();
			
					  
		 }
		 
		 
		  else if ($('#_QuesSelect').val() == "Descriptive"){
           	
			$('#_QuesDescriptive').slideDown("");
			 $('#_QuesTrueFalse').hide();
			 $('#_QuesMultiChoicesingle').hide();
			 $('#_QuesMultiChoicemulti').hide();
			 $('#_Quesorderingchoice').hide();
			 $('#_QuesMatchfollowing').hide();
			 $('#_QuesFillBlanks').hide();
			 $('#_QuesJumbledques').hide();
			 $('#_QuesMaths').hide();
			 	$('#_QuesFrame').hide();
			
					  
		 }
		 
		   else if ($('#_QuesSelect').val() == "Mathematical"){
           	
			$('#_QuesMaths').slideDown("");
			 $('#_QuesTrueFalse').hide();
			 $('#_QuesMultiChoicesingle').hide();
			 $('#_QuesMultiChoicemulti').hide();
			 $('#_Quesorderingchoice').hide();
			 $('#_QuesMatchfollowing').hide();
			 $('#_QuesFillBlanks').hide();
			 $('#_QuesJumbledques').hide();
			$('#_QuesDescriptive').hide();
				$('#_QuesFrame').hide();
			
					  
		 }
		 
		    else if ($('#_QuesSelect').val() == "FrameQuestions"){
           	
			$('#_QuesFrame').slideDown("");
			 $('#_QuesTrueFalse').hide();
			 $('#_QuesMultiChoicesingle').hide();
			 $('#_QuesMultiChoicemulti').hide();
			 $('#_Quesorderingchoice').hide();
			 $('#_QuesMatchfollowing').hide();
			 $('#_QuesFillBlanks').hide();
			 $('#_QuesJumbledques').hide();
			$('#_QuesDescriptive').hide();
				$('#_QuesMaths').hide();
		
					  
		 }
   

   }); 
   
   
   
   	//for texteditor hide and show
		$('._plainText').hide();
		$('._richTextShow').hide();
		
		$('._richText').click( function(){
			$('._richText').hide();
			$('._plainTextShow').hide();
			$('._plainText').show();
			$('._richTextShow').show();
		});
		
		$('._plainText').click( function(){
			$('._richText').show();
			$('._plainTextShow').show();
			$('._plainText').hide();
			$('._richTextShow').hide();
		});
		
		
// new question specify tag

   $(function() {
            var carTags = ['Science','Physics','Maths','Biology','Sports','English','Economics','Ziksana','Chevrolet'];
            $("#newquestiontags").superblyTagField({
                allowNewTags: true,
                showTagsNumber: 10,
                 title:'ggg',
                tags: carTags
            });

			        
            $('#tagDemoButton2').click(function(e){
                alert($("#newquestiontags").val());
            });
			
        });		
		

// true flase exit

$("#tfexit").click(function(e) {
      
	  
	  $('#frm_truefalse').validationEngine('hide')
      $('#frm_truefalse :input').removeClass('errorform validateff');
	  $('#_QuesTrueFalse').hide();
	  $('#_QuesSelect').val('1');
	
    });
	
//multichoicesingle exit

$("#mcsexit").click(function(e) {
      
	  $('#frm_multichoicesingle').validationEngine('hide')
      $('#frm_multichoicesingle :input').removeClass('errorform validateff');
	  $('#_QuesMultiChoicesingle').hide();
	  $('#_QuesSelect').val('1');
	  
    });

//multichoicemulti exit

$("#mcmexit").click(function(e) {
      
	  $('#frm_multichoicemulti').validationEngine('hide')
      $('#frm_multichoicemulti :input').removeClass('errorform validateff');
	  $('#_QuesMultiChoicemulti').hide();
	  $('#_QuesSelect').val('1');
	  
    });

//ordering choice exit

$("#ocexit").click(function(e) {
      
	  $('#frm_orderingchoice').validationEngine('hide')
      $('#frm_orderingchoice :input').removeClass('errorform validateff');
	  $('#_Quesorderingchoice').hide();
	  $('#_QuesSelect').val('1');
	  
    });
	
// match the following exit

$("#mfexit").click(function(e) {
      
	  $('#frm_Matchfollowing').validationEngine('hide')
      $('#frm_Matchfollowing :input').removeClass('errorform validateff');
	  $('#_QuesMatchfollowing').hide();
	  $('#_QuesSelect').val('1');
	  
    });	
	

// jumbled exit

$("#joexit").click(function(e) {
      
	  $('#frm_Jumbledques').validationEngine('hide')
      $('#frm_Jumbledques :input').removeClass('errorform validateff');
	 $('#_QuesJumbledques').hide();
	  $('#_QuesSelect').val('1');
	  
    });	

// Fill in the blanks exit

$("#ftbexit").click(function(e) {
      
	  $('#frm_FillBlanks').validationEngine('hide')
      $('#frm_FillBlanks :input').removeClass('errorform validateff');
	 $('#_QuesFillBlanks').hide();
	  $('#_QuesSelect').val('1');
	  
    });	

// deescriptive exit

$("#desexit").click(function(e) {
      
	  $('#frm_Descriptive').validationEngine('hide')
      $('#frm_Descriptive :input').removeClass('errorform validateff');
	$('#_QuesDescriptive').hide();
	  $('#_QuesSelect').val('1');
	  
    });	

//mathexit

$("#mathexit").click(function(e) {
      
	  $('#frm_Maths').validationEngine('hide')
      $('#frm_Maths :input').removeClass('errorform validateff');
	  $('#_QuesMaths').hide();
	  $('#_QuesSelect').val('1');
	  
    });	
	
//frame exit

//mathexit

$("#frexit").click(function(e) {
      
	  $('#frm_Frame').validationEngine('hide')
      $('#frm_Frame :input').removeClass('errorform validateff');
	 $('#_QuesFrame').hide();
	  $('#_QuesSelect').val('1');
	  
    });	
		
	
	
}); // end of document.ready