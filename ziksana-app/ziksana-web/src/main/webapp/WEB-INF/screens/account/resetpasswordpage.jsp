
<div id="loginwrapper">


 <div id="contentpanel">

 
 <div id="headercontainer">
 
 <div id="HeaderLogo" class="f-l">
     
     <img src="/ziksana-web/resources/images/home/loginlogo.png" style="height:80px;"/>
     
 </div> <!--end of headerlogo-->


<div class="f-l" style="padding-left:0px;">

</div><!--End of page-header -->
<div class="clearfix"></div>


</div>
   <!--start od the slider-->


</div> <!--end of contentpanel-->




 <div class="frgtpassmiddle">
 
   
   
   <div class="registerdtls">
   
   <div class="zenilogo" style="margin-left:200px;"></div>  
   <!--end of zenilogo-->
   	
   <c:if test="${userIdVerfication == 'UserId Verfication Page'}">
		   <div class="frmforgotpass">
		  
					
					   
					  
						
					 <p style="text-align:center; font-size:18px;"><fmt:message key="restpass.forgotpass"></fmt:message></p>
					 
					  <p class="reghead" style="text-align:center;"><fmt:message key="restpass.verifytext"></fmt:message> </p>
					  
					  <p style="text-align:center;margin-top:10px; color:#999;"><fmt:message key="restpass.smalltext"></fmt:message></p> 
					  <hr style="background-color:#f28920; margin-bottom:20px; width: 550px;
					margin-left: -0px;">
					
					    
						        
					    
					   
					    <div class="separate" style="margin-left:160px;"> 
					       
					     	  
					       
					      
					      <label class="nexaf"  style="padding-top:-10px;"><fmt:message key="restpass.userid"></fmt:message></label>
					     
					      <input  class="nexafN" placeholder="<fmt:message key="restpass.Enteruid"></fmt:message>" autocomplete="off" type="text" name="frgtuserid" id="frgtuserid"  autofocus="autofocus"  data-prompt-position="inline"/>
					       <a  style=" float:right; font-size:14px;" href="/ziksana-web/unsecure/0/forgotuserid"><fmt:message key="restpass.forgotuid"></fmt:message></a>				     
					      
					 </div><!-- end of separate  -->   
					    
					     <span  id='errorUserIdResponse'  class="nexafN" style="color:red;margin-left:160px;"></span> 
					 <div class="clearfix"> </div>
					
					<br>
					<br>
					
					<div class="btnseperate" >
					
					
					<a href="javascript:validateUserId()"  id="idnext" class="btn " style=" margin-left: 16px;width:80px; "> <fmt:message key="home.next"></fmt:message> </a>
					<a href="/ziksana-web/secure/logout"  class="btn " style=" margin-left: 16px;width:80px;"> <fmt:message key="profile.cancel"></fmt:message> </a> 	
					
					
					</div>
			
		
		   </div> <!--end of frmloginzeni-->
   
   		</c:if>
	    <c:if test="${seqVerfication == 'Sec Ques 1 Verfication Page' }">
	    	 
				  <div class="frmsecques1">
			
				
				<p class="reghead" style="text-align:center;"><fmt:message key="restpass.verifyquest"></fmt:message> </p>
				  
				  <p style="text-align:center;margin-top:10px; color:#999;"><fmt:message key="restpass.text"></fmt:message></p> 
				
				  <hr style="background-color:#f28920; margin-bottom:20px; width: 550px; margin-left: -0px;">
				
				
				 <div class="separate" style="margin-left:150px;"> 
				
				
				 <label  style="font-weight:bold; padding-top:-10px; margin-left:50px;"><fmt:message key="restpass.qust10f2"></fmt:message></label>   
					        
				 <p id="securityQuestionOneText" class="nexaf" style="margin-top:10px; margin-bottom:7px;">${profile.securityQuestionText}</p>
				 <label style ="display:none;" id="securityQuestionOneId">${profile.securityQuestionId}</label>
				 <label style ="display:none;" id="memberIdSQOne">${profile.memberId}</label>
					  <input type="text" class="validate[required] text-input nexafN" autocomplete="off" value="" id="txtsec1"  
				      placeholder="<fmt:message key="restpass.enterAns"></fmt:message>" autofocus="autofocus" data-prompt-position="inline"/>
				       
				<p  id='errorAnswerOneResponse' class="nexafN" style="margin-top:5px; color:red;"></p>
				<p style="margin-top:5px; color:#999; font-size:10px;"> </p>
					
				
				</div>  <!-- end of sepeate    -->  
				    
				  
				
				
				 
				<div class="btnseperate" >
				<a  href="javascript:securityQuestionOne()"  id="idnext" class="btn" style=" margin-left: 16px;width:80px; "><fmt:message key="home.next"></fmt:message></a> 	
				 <a href="/ziksana-web/secure/logout"  class="btn" style=" margin-left: 16px;width:80px;"><fmt:message key="profile.cancel"></fmt:message> </a> 	
				
				 <div class="clearfix"> </div>
				       
				</div>

				
				
				   </div> <!--end of frmloginzeni-->  
				  
				  
					    		
					    
	    
	    
	    </c:if>
	  
 <c:if test="${seqVerfication == 'Sec Ques 2 Verfication Page' }">
	    	 
				  <div class="frmsecques2">
			
				
				<p class="reghead" style="text-align:center;"><fmt:message key="restpass.verifyquest"></fmt:message></p>
				  
				  <p style="text-align:center;margin-top:10px; color:#999;"><fmt:message key="restpass.text"></fmt:message></p> 
				
				  <hr style="background-color:#f28920; margin-bottom:20px; width: 550px; margin-left: -0px;">
				
				
				 <div class="separate" style="margin-left:150px;"> 
				
				
				 <label  style="font-weight:bold; padding-top:-10px; margin-left:50px;"><fmt:message key="restpass.qust20f2"></fmt:message></label>   
					        
				 <p id="securityQuestionTwoText" class="nexaf" style="margin-top:10px; margin-bottom:7px;">${profile.securityQuestionText}</p>
				 <label style ="display:none;" id="securityQuestionTwo">${profile.securityQuestionId}</label>
				 <label style ="display:none;" id="memberIdSQTwo">${profile.memberId}</label>
					  <input type="text" class="validate[required] text-input nexafN" autocomplete="off" value="" id="txtsec2" 
				      placeholder="<fmt:message key="restpass.enterAns"></fmt:message>" autofocus="autofocus"  data-prompt-position="inline"/>
				       
				<p  id='errorAnswerTwoResponse' class="nexafN" style="margin-top:5px; color:red;"></p>
				<p style="margin-top:5px; color:#999; font-size:10px;"> </p>
					
				
				</div>  <!-- end of sepeate    -->  
				    
				  
				
				
				 
				<div class="btnseperate" >
				<a href="javascript:securityQuestionTwo()"  id="idnext" class="btn " style=" margin-left: 16px;width:80px; "><fmt:message key="home.next"></fmt:message> </a> 		
				   <a href="/ziksana-web/secure/logout"  class="btn" style=" margin-left: 16px;width:80px;"><fmt:message key="profile.cancel"></fmt:message> </a> 	
					
				 <div class="clearfix"> </div>
				       
				</div>

				
				
				   </div> <!--end of frmloginzeni-->  
				  
				  
					    		
					    
	    
	    
	    </c:if>
     	<c:if test="${resetPassword == 'Reset Password Verification' }">
     			
			    <div class="resetpassword">
			    <label style="display:none" id="memberIdRef">${memberId}</label>
			    <label style="display:none" id="currentPassword">${currentPassword}</label>
			     <!--  <p class="reghead" style="margin-left:150px;">Select your Password </p> --> 
			      <div class="separate" style="margin-left:10px; text-align:center;"> 
			      
			    <p class="reghead" style="margin-left:40px;"><fmt:message key="restpass.selpass"></fmt:message> </p>  
			    <p style="text-align:center;margin-top:10px; color:#999;">
<fmt:message key="restpass.passworddes"></fmt:message> 
</p>
<p style="color:green;padding: 0 .5em;border-radius: 3px;text-align:center" id="passwordResponse"></p>
     			<p style="color:red;padding: 0 .5em;border-radius: 3px;text-align:center" id="passwordFailResponse"></p>
<hr style="background-color:#f28920; margin-bottom:20px; width: 550px; margin-left: -0px;">
			<div style="width:390px;text-align:left; margin-left:150px;"> 
			 <div class="Clearfix"></div>
					 <div class="req_message">( All fields are mandatory)</div>
					 <div class="Clearfix"></div>
			 <div class="control-group">
			      <label class="control-label nexaf" style="padding-top:-10px;"><fmt:message key="new.password"></fmt:message></label>
			      <div class="controls">
				<div style="color: red;" class="nexafN" id="result"></div>
			      <input class="nexafN" onchange="removeFocusPassword()" value="" autofocus="autofocus" placeholder="<fmt:message key="new.password"></fmt:message>"  type="password" name="password" id="password" data-prompt-position="inline"/>
			      
			      </div></div> 
			      
			      
			        <div class="control-group">
			      <label class="control-label nexaf " style=""><fmt:message key="confirm.password"></fmt:message></label>
			      <div class="controls">
				
			     <input class="nexafN" value="" placeholder="<fmt:message key="confirm.password"></fmt:message>"  type="password" name="passwordcng" id="retypePassword" data-prompt-position="inline"  />
			      </div>
			       
			      </div>
			    <div id="result1" class="nexafN"></div>
			 <div class="btnseperate" >
			<br/><br/>
			<a href="javascript:checkpass()"  id="idnext" class="btn" style=" margin-left: 16px;width:80px; "> <fmt:message key="profile.submit"></fmt:message> </a> 	
			<a href="/ziksana-web/secure/logout"  class="btn" style=" margin-left: 16px;width:80px;"> <fmt:message key="profile.cancel"></fmt:message> </a> 	
			
			  <div class="clearfix"> </div>
			  
			</div>
			</div>
			
			      
			      
			      </div>
			  
			   </div> <!--end of frmloginzeni-->   
			   
			   
     	
     	</c:if>
     	 <c:if test="${resetPasswordSuccess == 'Password Reset Successful Page'}">
	     	 <div class="resetpassword" style="text-align:center;height:190px">
	     	 		<h2 style="color:green;margin:auto;font-size:14pt;font-weight: 600;">Password Reset Successful</h2>
	     	 		<br/>
	     	 		<span>Please Login with your new Password</span><br/><br/>
	     	 		<a class="btn" href="/ziksana-web/login">Login</a>
	     	 </div>
     	 </c:if>
     	  <c:if test="${resetEmailSuccess == 'Your Use Id has been sent to email address successfully'}">
	     	 <div class="resetpassword" style="text-align:center;height:190px">
	     	 		<h2 style="color:green;margin:auto;font-size:14pt;font-weight: 600;">Your Use Id has been sent to email address successfully.</h2>
	     	 		<br/>
	     	 		<span>Please Login with your credentials</span><br/><br/>
	     	 		<a class="btn" href="/ziksana-web/login">Login</a>
	     	 </div>
     	 </c:if>
<!--  -->
  <c:if test="${emailVerfication == 'Email Verfication Page'}">
		   <div class="frmforgotpass">
		  
					
					   
					  
						
					 <p style="text-align:center; font-size:18px;"><fmt:message key="restpass.forgotuid"/> </p>
					 
					  <p class="reghead" style="text-align:center;"><fmt:message key="resetpass.we.needEmail"></fmt:message> </p>
					  
					  <p style="text-align:center;margin-top:10px; color:#999;"><fmt:message key="resetpass.unauthorized"></fmt:message></p> 
					  <hr style="background-color:#f28920; margin-bottom:20px; width: 550px;
					margin-left: -0px;">
					
					    
						        
					    
					   
					    <div class="separate" style="margin-left:160px;"> 
					       
					     	  
					       
					       <span  id='successEmailResponse' style="color:green; "></span> 
					      <label class="nexaf" style="padding-top:-10px;"><fmt:message key="resetpass.emailid"/></label>
					     
					      <input class="nexafN" placeholder="<fmt:message key="restpass.EnterEmailID"/>" autocomplete="off" autofocus="autofocus" type="text" id="frgtemailid"  data-prompt-position="inline"/> 				     
					      
					 </div><!-- end of separate  -->   
					    
					     <span  id='errorEmailResponse' class="nexafN" style="color:red;margin-left:160px;"></span> 
					 <div class="clearfix"> </div>
					
					<br>
					<br>
					
					<div class="btnseperate" >
						<a href="javascript:validateEmailId()"  id="idnext" class="btn " style=" margin-left: 16px;width:80px; "><fmt:message key="profile.submit"></fmt:message> </a> 	
						<a href="/ziksana-web/secure/logout"  class="btn " style=" margin-left: 16px;width:80px;"> <fmt:message key="profile.cancel"></fmt:message> </a> 	
						
								
					  
					  <div class="clearfix"> </div>
					  
					</div>
			
		
		   </div> <!--end of frmloginzeni-->
   
   		</c:if>
   
   <div class="getpassword">
 
  
   </div> <!--end of frmloginzeni-->  
   
   
   
 
   </div>  <!--end of logindetails-->
   
 
 <div class="clearfix"> </div>
 
 
   </div> <!--end of loginmiddle-->


 <div class="clearfix"> </div>


</div> <!--end of loginwrapper-->
 <c:url var="userverfyUrl" value="/unsecure/0/isuseridexists/" />
 <c:url var="emailverfyUrl" value="/unsecure/0/senduserid/" />

<script type="text/javascript">
function validateUserId(){
	 
	forgotUserId = $('#frgtuserid').val();
	if(forgotUserId == ''){
		$('#errorUserIdResponse').html("<fmt:message key="error.enteruser"></fmt:message>");
		$('#frgtuserid').focus();
		$('#frgtuserid').addClass('error_profile');
	}else if(forgotUserId.indexOf(' ') >= 0){
		  
		   $('#errorUserIdResponse').html("<fmt:message key="resetpass.whitespace"/>");
		   $('#frgtuserid').focus();
		   $('#frgtuserid').addClass('error_profile');
	}else{
		if(("#errorUserIdResponse.inside:contains('<fmt:message key="error.enteruser"></fmt:message>')")){
			document.getElementById("errorUserIdResponse").innerHTML = '';
			$('#frgtuserid').focus();
			$('#frgtuserid').addClass('error_profile');
		}
		
		$.ajax({
		  	type: 'GET',
			url: '${userverfyUrl}'+forgotUserId,
			success: function( data ) {
				console.log(data);
				if(data == 'User ID entered is incorrect.'){
					$('#errorUserIdResponse').html('<fmt:message key="resetpass.useridincorrect"/>');
				}
				if(data == 'UserId Verification Successful.'){
					
							$.ajax({
							  	type: 'GET',
								url: '/ziksana-web/unsecure/0/isaccountlocked/'+forgotUserId,
								success: function( data ) {
									console.log(data);
									if(data == 'SUCCESS'){										
										$('#frgtuserid').removeClass('error_profile');
										$.ajax({
										  	type: 'GET',
											url: '/ziksana-web/unsecure/0/isprofilecompleted/'+forgotUserId,
											success: function( data ) {
												console.log(data);
												if(data == 'SUCCESS'){										
													window.location.href = "/ziksana-web/unsecure/0/firstsecurityverfication/"+forgotUserId+"";
												}else{
													$('#errorUserIdResponse').html(data);
												}
											
												
											}
										});
																				
									}else{
										$('#errorUserIdResponse').html(data);
									}
								
									
								}
							});
					
					
							
			
				}
			
				
			}
		});
	
	}
}

function securityQuestionOne(){
	securityQuestionOneText = $('#securityQuestionOneText').text();
	securityAnswerOne = $('#txtsec1').val();
	memberIdSQOne = $('#memberIdSQOne').text();
	if(securityAnswerOne == ''){
		$('#errorAnswerOneResponse').html("<fmt:message key="resetpass.remember.text"/><a href='#'><fmt:message key="login.Administrator"/></a>");		
		$('#txtsec1').focus();
		$('#txtsec1').addClass('error_profile');
	}else {
		if(("#errorAnswerOneResponse.inside:contains('<fmt:message key="resetpass.remember.text"/>')")){
			document.getElementById("errorAnswerOneResponse").innerHTML = '';
		}
		$.post( '/ziksana-web/unsecure/0/checkfirstanswer'
		        , {'answer':securityAnswerOne,'secretQuestion':securityQuestionOneText,'memberId':memberIdSQOne}
		        , function( data )
		        {
		        	if(data == 'SUCCESS'){
		        		$('#txtsec1').removeClass('error_profile');
		        		window.location.href = "/ziksana-web/unsecure/0/secondsecurityverfication/"+memberIdSQOne+"";
					}else{
						$('#errorAnswerOneResponse').html('<fmt:message key="security.answer.fail"/><a href="#"><fmt:message key="login.Administrator"/></a>');
						$('#txtsec1').focus();
						$('#txtsec1').addClass('error_profile');
					}
		        }
				 ); 
		
	
	}
}


function securityQuestionTwo(){
	securityQuestionTwoText = $('#securityQuestionTwoText').text();
	securityAnswerTwo = $('#txtsec2').val();
	memberIdSQTwo = $('#memberIdSQTwo').text();
	console.log(memberIdSQTwo);
	console.log(securityAnswerTwo);
	console.log(securityQuestionTwoText);
	if(securityAnswerTwo == ''){
		$('#errorAnswerTwoResponse').html("<fmt:message key="resetpass.remember.text"/><a href='#'><fmt:message key="login.Administrator"/></a>");		
		$('#txtsec2').focus();
		$('#txtsec2').addClass('error_profile');
	}else {
		if(("#errorAnswerTwoResponse.inside:contains('<fmt:message key="resetpass.remember.text"/>')")){
			document.getElementById("errorAnswerTwoResponse").innerHTML = '';
		}
		$.post( '/ziksana-web/unsecure/0/checksecondanswer'
		        , {'answer':securityAnswerTwo,'secretQuestion':securityQuestionTwoText,'memberId':memberIdSQTwo}
		        , function( data )
		        {
		        	if(data == 'SUCCESS'){
		        		$('#txtsec2').removeClass('error_profile');
		        		window.location.href = "/ziksana-web/unsecure/0/password/newpassword/"+memberIdSQTwo+"";
		        		 
					}else{
						$('#errorAnswerTwoResponse').html('<fmt:message key="security.answer.fail"/><a href="#"><fmt:message key="login.Administrator"/></a>');
						$('#txtsec2').focus();
						$('#txtsec2').addClass('error_profile');
					}
		        }
				 ); 
		
	
	}
}

//Password Validation Script
passwordStrength='';
passwordFailType='';
$(document).ready(function() {
	
	
	
	$('#password').keyup(function(){
		passwordStrength = checkStrength($('#password').val());
		
		 
		
	});
		
	
	function checkStrength(password){
    
	//initial strength
    strength = 0;
	
    var x = $('#password').val();
	 if ((x.charAt(0).match(/([0-9,!,%,&,@,#,$,^,*,?,_,~])/)))
	 {
		 $('#result').html('<span style="padding-left:5px;"><fmt:message key="profile.error.password"/></span>');
	 	return false;
	 }

   
    //if the password length is less than 6, return message.
    if (password.length < 8) { 
		$('#result').removeClass();
		/*$('#result').addClass('short')*/
		$('#result').html('<div style="width:180px;margin-top:7px;border:1px solid #fff;"><div id="red"></div><div id="blank"></div><div id="blank"></div><div id="blank"></div><div style="margin-top: -7px;">&nbsp;&nbsp;<fmt:message key="resetpass.tooshort"/></div><div style="color:orange;"><fmt:message key="resetpass.8char"/></div></div>');
		return false;
	}
    
    //length is ok, lets continue.
	
	//if length is 8 characters or more, increase strength value
	if (password.length > 7) strength += 1;
	
	//if password contains both lower and uppercase characters, increase strength value
	if (password.match(/([a-z].*[A-Z])|([A-Z].*[a-z])/))  strength += 1;
	
	//if it has numbers and characters, increase strength value
	if (password.match(/([a-zA-Z])/) && password.match(/([0-9])/))  strength += 1; 
	
	//if it has one special character, increase strength value
    if (password.match(/([!,%,&,@,#,$,^,*,?,_,~])/))  strength += 1;
	
	//if it has two special characters, increase strength value
    if (password.match(/(.*[!,%,&,@,#,$,^,*,?,_,~].*[!,%,&,@,#,$,^,*,?,_,~])/)) strength += 1;
	
	//now we have calculated strength value, we can return messages
	
	//if value is less than 2

	if (strength < 2 ) {
		$('#result').removeClass();
		$('#result').addClass('weak');
		$('#result').html('<div style="width:180px; margin-top:7px;border:1px solid #fff;"><div id="red"></div><div id="blue"></div><div id="blank"></div><div id="blank"></div><div style="margin-top: -7px;color:red;">&nbsp;&nbsp;<fmt:message key="resetpass.weekpass"/> </div><div style="color:orange;"><fmt:message key="restpass.passworddes"/>  </div></div>');
		return false;			
	} else if (strength == 2 ) {
		$('#result').removeClass();
		$('#result').addClass('good');
		$('#result').html('<div style="width:180px;margin-top:7px;border:1px solid #fff;"><div id="red"></div><div id="blue"></div><div id="orange"></div><div id="blank"></div><div style="margin-top: -7px;color:green;">&nbsp;&nbsp;<fmt:message key="resetpass.good"/></div></div>');
		return true;	
	} else {
		$('#result').removeClass();
		$('#result').html('<div style="width:180px;margin-top:7px;border:1px solid #fff;"><div id="red"></div><div id="blue"></div><div id="orange"></div><div id="green"></div><div style="margin-top: -7px;color:green;">&nbsp;&nbsp;<fmt:message key="resetpass.strong"/></div></div> ');
		return true;
	}
}
	
	
});
function checkpass()
{
	if(passwordStrength){
		
		if($('#retypePassword').val()==''){
			$('#result1').html("<fmt:message key="resetpass.confirm"/>");
			$('#retypePassword').addClass('error_profile');
		}
		
		else if ($('#password').val()!=$('#retypePassword').val()){
			$('#result1').html("<fmt:message key="resetpass.pass.donot.match"/>");
			$('#password').addClass('error_profile');
		}else{
			newPassword = $('#password').val();
			retypePassword = $('#retypePassword').val();
			
			memberIdRef = $('#memberIdRef').text();
			currentPassword = $('#currentPassword').text();
			if(retypePassword != currentPassword){
			 $.post( '/ziksana-web/unsecure/0/password/changepassword'
			        , {'newPassword':newPassword,'confirmPassword':retypePassword,'memberId':memberIdRef}
			        , function( data )
			        {
			        	if(data == 'Password reset is successful'){
			        		 window.location.href ="/ziksana-web/unsecure/0/passwordresetsuccess" ;
			        		 $('#password').removeClass('error_profile');
			        		/* 
			        		$('#passwordResponse').html("<fmt:message key="password.successfull.please"/><a href='/ziksana-web/secure/logout'> <fmt:message key="login.button"/></a>")
			        	$('#passwordFailResponse').html("");
			        		$('#result1').html("");
			        		$('#result').html("") */
			        		
						}else{
							$('#passwordFailResponse').html(data);
							$('#password').addClass('error_profile');
						}
			        }
					 );  
			}else{
				$('#passwordFailResponse').html("<fmt:message key="reuse.password.error"/>");
			}
		}
	
		
	}else{
		if($('#password').val() == ''){
		$('#result').html("<fmt:message key="resetpass.enterpass"/>");
		$('#password').focus();
		$('#password').addClass('error_password');
		}
	}

}
function removeFocusPassword(){
	$('#password').focusout();
	$('#password').removeClass('error_password');
	document.getElementById("result").innerHTML = '';
}

function passwordStartCharectors(val){
	
	console.log(val);
	if(val.substring(0, 1).matches("a-z") || val.substring(0, 1).matches("A-Z")){
		return true;
	}else{
		return false;
	}
}

function validateEmailId(){
	
	forgotEmailId = $('#frgtemailid').val();
	if(forgotEmailId == ''){
		$('#errorEmailResponse').html("<fmt:message key="enter.email"/>");
		$('#frgtemailid').addClass('error_profile');
	}else {
		if(("#errorEmailResponse.inside:contains('Enter EmailId')")){
			document.getElementById("errorEmailResponse").innerHTML = '';
		}
		
		
		$.post( '/ziksana-web/unsecure/0/senduserid'
		        , {'emailId':forgotEmailId}
		        , function( data )
		        {
		        	if(data == 'Success'){
		        		$('#frgtemailid').removeClass('error_profile');
		        		window.location.href = "/ziksana-web/unsecure/0/success";
		        		/* confirm_alert = $('#successEmailResponse').html('<fmt:message key="userid.sent.email"/><a href="/ziksana-web/secure/logout"> <fmt:message key="login.button"/></a>');
						if(confirm_alert == true){
							window.location.href = "/ziksana-web/secure/logout";
						}else{
						
						} */
		        		
					}else{
						$('#errorEmailResponse').html('<fmt:message key="userid.email.error"/>');
						$('#frgtemailid').addClass('error_profile');
					}
		        }
				 ); 
		
		
		
			
	}

}

</script>
 
 <style>
 
#result1{
	color:red;
}
.error_password{
	border:1px solid red!important;
}
 </style>
  