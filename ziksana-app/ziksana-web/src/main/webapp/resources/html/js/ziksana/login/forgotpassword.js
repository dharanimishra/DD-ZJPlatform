// JavaScript Document
$(document).ready(function(e) {

	$(".frmsecques1").hide();
	$('.frmsecques2').hide();
	$('.getpassword').hide();
	$('.resetpassword').hide();
	

		$("#frgtpassword").validateionEngine('attach', {
				  onValidationComplete: function(form, status){
					//alert("The form status is: " +status+", it will never submit");
					if(status == true)
					{
						$('.frmsecques1').show();
						$('.frmforgotpass').hide();	
						$('.frmsecques2').hide();
						$('.resetpassword').hide();	
					}
				  }  
				});   


//		jQuery("#secquestionfrm1").validationEngine('attach', {
//						  onValidationComplete: function(form, status){
//							//alert("The form status is: " +status+", it will never submit");
//							if(status == true)
//							{
//								$('.frmsecques2').show();
//								$('.frmsecques1').hide();
//								$('.frmforgotpass').hide();	
//								$('.getpassword').hide();	
//							}
//						  }  
//						});    
//				
//
//		jQuery("#secquestionfrm2").validationEngine('attach', {
//						  onValidationComplete: function(form, status){
//							//alert("The form status is: " +status+", it will never submit");
//							if(status == true)
//							{
//								$('.frmsecques2').hide();
//								$('.frmsecques1').hide();
//								$('.frmforgotpass').hide();	
//								$('.resetpassword').show();		
//							}
//						  }  
//						});    								 















//
//				$("#frgtpassword").validationEngine('attach', {
//				  onValidationComplete: function(form, status){
//					//alert("The form status is: " +status+", it will never submit");
//					if(status == true)
//					{
//						$('.frmsecques1').show();
//						$('.frmforgotpass').hide();	
//						$('.frmsecques2').hide();
//						$('.resetpassword').hide();	
//					}
//					else
//					{
//						return false
//					}
//				  }  
//		
//		
//				});   
//	
	
   




/*jQuery("#secquestionfrm1").validationEngine('attach', {
				  onValidationComplete: function(form, status){
					//alert("The form status is: " +status+", it will never submit");
					if(status == true)
					{
						$('.frmsecques2').show();
						$('.frmsecques1').hide();
						$('.frmforgotpass').hide();	
						$('.getpassword').hide();	
					}
				  }  
				});    
				

jQuery("#secquestionfrm2").validationEngine('attach', {
				  onValidationComplete: function(form, status){
					//alert("The form status is: " +status+", it will never submit");
					if(status == true)
					{
						$('.frmsecques2').hide();
						$('.frmsecques1').hide();
						$('.frmforgotpass').hide();	
						$('.resetpassword').show();		
					}
				  }  
				});    								 
*/


});