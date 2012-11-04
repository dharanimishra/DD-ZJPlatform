	$(document).ready(function() {
	
	<!--$("#id").lightbox_me();-->
	<!-- checking for selected values -->
	$( 'textarea.editor' ).ckeditor();
	
		 $('#type-1').hide();
		  $('#type-2').hide();
		   $('#type-3').hide();
		    $('#type-4').hide();
			 $('#type-5').hide();
			  $('#type-6').hide();
			   $('#type-7').hide();
			    $('#type-8').hide();
				 $('#type-11').hide();
				  $('#type-12').hide();
	
	$('#q_type').change(function () {
        if ($('#q_type').val() == "True/false"){
            $('#type-1').fadeIn("slow");
			 $('#type-2').hide();
			  $('#type-3').hide();
			  $('#type-4').hide();
			  $('#type-5').hide();
			  $('#type-6').hide();
			  $('#type-7').hide();
			  $('#type-8').hide();
			   $('#type-11').hide();
			   $('#type-12').hide();
           } 
		    else if ($('#q_type').val() == "Multi choice-single answer"){
            $('#type-1').hide();
			 $('#type-2').fadeIn("slow");
			  $('#type-3').hide();
			  $('#type-4').hide();
			  $('#type-5').hide();
			  $('#type-6').hide();
			  $('#type-7').hide();
			  $('#type-8').hide();
			   $('#type-11').hide();
			   $('#type-12').hide();
           } 
		 else if ($('#q_type').val() == "Multi choice-multi answer"){
            $('#type-1').hide();
			 $('#type-2').hide();
			  $('#type-3').fadeIn("slow");
			  $('#type-4').hide();
			  $('#type-5').hide();
			   $('#type-6').hide();
			   $('#type-7').hide();
			   $('#type-8').hide();
			    $('#type-11').hide();
				$('#type-12').hide();
           } 
		    else if ($('#q_type').val() == "Ordering Choices"){
            $('#type-1').hide();
			 $('#type-2').hide();
			 $('#type-3').hide();
			  $('#type-4').fadeIn("slow");
			  $('#type-5').hide();
			  $('#type-6').hide();
			  $('#type-7').hide();
			  $('#type-8').hide();
			   $('#type-11').hide();
			   $('#type-12').hide();
           } 
		    else if ($('#q_type').val() == "Match the Following"){
            $('#type-1').hide();
			 $('#type-2').hide();
			 $('#type-3').hide();
			  $('#type-4').hide();
			  $('#type-5').fadeIn("slow");
			  $('#type-6').hide();
			  $('#type-7').hide();
			  $('#type-8').hide();
			   $('#type-11').hide();
			   $('#type-12').hide();
           } 
		     else if ($('#q_type').val() == "Fill in the blanks"){
            $('#type-1').hide();
			 $('#type-2').hide();
			 $('#type-3').hide();
			  $('#type-4').hide();
			  $('#type-5').hide();
			  $('#type-6').fadeIn("slow");
			  $('#type-7').hide();
			  $('#type-8').hide();
			   $('#type-11').hide();
			   $('#type-12').hide();
           } 
		    else if ($('#q_type').val() == "Jumbled Sequence"){
            $('#type-1').hide();
			 $('#type-2').hide();
			 $('#type-3').hide();
			  $('#type-4').hide();
			  $('#type-5').hide();
			  $('#type-6').hide();
			  $('#type-7').fadeIn("slow");
			  $('#type-8').hide();
			   $('#type-11').hide();
			   $('#type-12').hide();
           } 
		   else if ($('#q_type').val() == "Descriptive"){
            $('#type-1').hide();
			 $('#type-2').hide();
			 $('#type-3').hide();
			  $('#type-4').hide();
			  $('#type-5').hide();
			  $('#type-6').hide();
			  $('#type-7').hide();
			  $('#type-8').fadeIn("slow");
			   $('#type-11').hide();
			   $('#type-12').hide();
           } 
		   else if ($('#q_type').val() == "Mathematical Questions"){
            $('#type-1').hide();
			 $('#type-2').hide();
			 $('#type-3').hide();
			  $('#type-4').hide();
			  $('#type-5').hide();
			  $('#type-6').hide();
			  $('#type-7').hide();
			  $('#type-8').hide();
			   $('#type-11').fadeIn("slow");
			   $('#type-12').hide();
           } 
		   else if ($('#q_type').val() == "Frame the Question"){
            $('#type-1').hide();
			 $('#type-2').hide();
			 $('#type-3').hide();
			  $('#type-4').hide();
			  $('#type-5').hide();
			  $('#type-6').hide();
			  $('#type-7').hide();
			  $('#type-8').hide();
			   $('#type-11').hide();
			   $('#type-12').fadeIn("slow");
           } 
		else {
            	
				$('#type-1').hide();
				 $('#type-2').hide();
			  	   $('#type-3').hide();
					$('#type-4').hide();
					$('#type-5').hide();
					$('#type-6').hide();
					$('#type-7').hide();
					$('#type-8').hide();
					 $('#type-11').hide();
					 $('#type-12').hide();
        } }); 
		
		<!-- for type 2-->
		$('#btn_add2').click(function(){
		 $('#ch_ans2').clone().appendTo('#more_choice2');
	     $('#q_choice2').clone().appendTo('#more_choice2');
		 
		 $('#more_choice2').append("</br>");
	     
	  });
	  
	  <!-- for type 3 -->
	  $('#btn_add3').click(function(){
		 $('#ch_ans3').clone().appendTo('#more_choice3');
	     $('#q_choice3').clone().appendTo('#more_choice3');
		 
		 $('#more_choice3').append("</br>");
	     
	  });
	  
	  <!-- for type 4-->
	  $('#btn_add4').click(function(){
		 $('#ch_ans4').clone().appendTo('#more_choice4');
	     $('#q_choice4').clone().appendTo('#more_choice4');
		 
		 $('#more_choice4').append("</br>");
	     
	  });
	  
		<!-- for type 5 -->
		 $('#btn_add_q5').click(function(){
		 $('#q_choice5').clone().appendTo('#more_choice_q5');
		 $('#more_choice_q5').append("</br>");
	     
	  });
	  
	   $('#btn_add_an5').click(function(){
		 $('#a_choice5').clone().appendTo('#more_choice_a5');
		 $('#a_q5').clone().appendTo('#more_choice_a5');
		 $('#more_choice_a5').append("</br>");
	     
	  });
	  
	   <!-- for type 8 -->
	  $('#btn_add8').click(function(){
		 $('#ch_ans8').clone().appendTo('#more_choice8');
	     $('#q_choice8').clone().appendTo('#more_choice8');
		 
		 $('#more_choice8').append("</br>");
	     
	  });
		
});