
<script>


</script>
<div id="loginwrapper">


	<div id="contentpanel">


		<div id="headercontainer">

			<div id="HeaderLogo" class="f-l">

				<img src="/ziksana-web/resources/images/home/loginlogo.png"
					style="height: 80px;" />

			</div>
			<!--end of headerlogo-->

			<div class="clearfix"></div>


		</div>


		<div id="profilecontainer">

			<div class="page-header">
				<div class="icon">
					<img src="/ziksana-web/resources/images/icons/information_icon.png"style="height: 25px;"/>
				</div>
				<h1><fmt:message key="profile.setup.name"></fmt:message> </h1>
			</div>


			<div class="fileupload  f-l">
				<div class="associateimage" width="300px">

					<c:if test="${empty member.picturePath}">
						<img style="width: 122px; margin-bottom: .25em;" id="profile_thumbnail_image" src="/ziksana-web/resources/images/no-image.jpg"/>
					</c:if>
					<c:if test="${not empty ms.url && not empty member.picturePath}">
						<img style="width: 122px; margin-bottom: .25em;" id="profile_thumbnail_image" src="${ms.url}<c:out value="${member.picturePath}"/>" />
					</c:if> 
					<input readonly="readonly" type="hidden" id="Cimageupl" />


					<div id="thubmnail_upload_message" ></div>
					<div id="loaderText"></div>

					<input
						style="height: 25px; width: 120px; margin-left: 37px; margin-top: 8px;"
						type="file" name="thumbnail_image_file_upload" 
						id="thumbnail_image_file_upload" />
					<div id="status"></div>
					<script type="text/javascript">
						$(function() {
							$('#thumbnail_image_file_upload')
									.uploadify(
											{
												'swf' : '${staticFileServer}resources/swf/uploadify.swf',
												'queueSizeLimit' : 1,
												'successTimeout' : 350,
												'buttonText' : '<fmt:message key="profile.button.text"></fmt:message>',
												'uploader' : '${ms.uploadScript}',
												'fileTypeExts' : '*.gif; *.jpg; *.jpeg; *.png',
												'fileSizeLimit' : '1024KB',
												'onUploadStart' : function(file) {
													$('#sbtvalidation').attr(
															'disabled',
															'disabled');
												},
												//'debug': true,
												//'scriptData':{'contentId': $('#learningContentId').val().split('_')[1]},
												'onUploadSuccess' : function(
														file, data, response) {
													json_string = data;
													data_object = $
															.parseJSON(json_string);
													console.log(data_object);

													if (data_object.Uploaded == 'true') {
														$('#Cimageupl')
																.val(
																		data_object.ContentPath);
														$(
																'#profile_thumbnail_image')
																.attr(
																		'src',
																		'${ms.url}'
																				+ data_object.ContentPath);
														$(
																'#thubmnail_upload_message')
																.html('');

													} else { //there is an error in the upload process

														$('#message')
																.html(
																		data_object.message);
													}
													$('#sbtvalidation')
															.removeAttr(
																	'disabled'); //enable submit button

												}
											// Your options here
											});
						});

						function remove_uploaded_thumbnail() {
							$('#Cimageupl').val('');//clear uploaded file path
							$('#thubmnail_upload_message').html('');
							$('#profile_thumbnail_image')
									.attr('src',
											'${staticFileServer}resources/images/default-course.jpg');

						}
					</script>


				</div>
				<!--
				<div class="fileupload-preview fileupload-exists thumbnail"
					style="width: 200px; height: 150px;"></div>
				<div class="Clearfix"></div>
				<span class="btn btn-file"><span class="fileupload-new">Upload Profile image</span><span class="fileupload-exists">Change</span><input
					type="file" /></span> <a href="#" class="btn fileupload-exists"
					data-dismiss="fileupload">Remove</a> -->
			</div>


			<div class="profiledetail f-l">

				<P class="ppname">
					<span class="ppnamespan"> <fmt:message key="profile.name"></fmt:message>
					</span> :
					<c:out value="${member.firstName}" />
					<c:out value="${member.lastName}" />
					<label id="memberIdValue" style="display: none;"><c:out value="${member.memberId}" /></label>
					<label id="memberProfileImageValue" style="display: none;"><c:out value="${member.primaryEmailId}" /></label>
				</P>

				<P class="ppemail">
					<fmt:message key="profile.primaryemail"></fmt:message>
					: <a href="#linkurl"> <c:out value="${member.primaryEmailId}" />
					</a>
				</P>

				<p class="ppdesgspan">
					<span class="ppdesg"> <fmt:message key="profile.designation"></fmt:message>
					</span> :
					<c:out value="${member.designation}" />
				</p>

			</div>


			<div class="clearfix"></div>
			<div id="profile_response_message"style="color: red; padding: 5px; text-align: center;"></div>
			<div id="profile_response_success"style="color: green; padding: 5px; text-align: center;"></div>
			<hr />

			<div class="formcontainer">
				
					
				<div class="control-group">
					<label class="control-label nexaf" for="Course Name"><fmt:message
							key="profile.alternateemail"></fmt:message> </label>
					<div class="controls">
						<input autofocus="autofocus"
							
							id="alternateEmailId" type="text" class="profileinput"
							name="alt_mail" placeholder="Alternate Email" />
					</div>
					<div style="color: red; padding: 5px;" id="erroralternateEmailId"></div>
					<div style="color: red; padding: 5px;" id="errorEmailId"></div>
				</div>


				<div class="control-group">
					<label class="control-label nexaf" for="Course Name"
						style="width: 180px;"><fmt:message
							key="profile.securityquestion1"></fmt:message><span class="requiredField">*</span> </label>
					<div class="controls">
						<select class="profileselect" id="securityQuestionOne">
							<option selected="selected"><fmt:message key="profile.select.text"></fmt:message></option>
							<c:forEach var="profile" items="${profileList}">
								<option value="${profile.securityQuestionId}">${profile.securityQuestionText}</option>
							</c:forEach>
						</select>
					</div>
					<div style="color: red; padding: 5px;" id="errorsecurityQuestionOne"></div>
				</div>



				<div class="control-group">
					<label class="control-label nexaf" for="Course Name"><fmt:message
							key="profile.securityanswer1"></fmt:message><span class="requiredField">*</span></label>
					<div class="controls">
						<input type="text" class="profileinput" id="securityAnswerone"
							name="sec_answer1" placeholder="<fmt:message
							key="profile.securityanswer1"></fmt:message>" />
					</div>
					<div style="color: red; padding: 5px;" id="errorsecurityAnswerone"></div>
				</div>



				<div class="control-group">
					<label class="control-label nexaf" for="Course Name"
						style="width: 180px;"><fmt:message
							key="profile.securityquestion2"></fmt:message><span class="requiredField">*</span> </label>
					<div class="controls">

						<select class="profileselect" id="securityQuestionTwo">
							<option selected="selected"><fmt:message key="profile.select.text"></fmt:message></option>
							<c:forEach var="profile" items="${profileList}">
								<option value="${profile.securityQuestionId}">${profile.securityQuestionText}</option>
							</c:forEach>
						</select>
					</div>
					<div style="color: red; padding: 5px;" id="errorsecurityQuestionTwo"></div>
				</div>



				<div class="control-group">
					<label class="control-label nexaf" for="Course Name"
						style="width: 180px;"><fmt:message
							key="profile.securityanswer2"></fmt:message><span class="requiredField">*</span> </label>
					<div class="controls">
						<input type="text" class="profileinput" id="securityAnswertwo"
							name="sec_answer2" placeholder="<fmt:message
							key="profile.securityanswer2"></fmt:message>" />
					</div>
					<div style="color: red; padding: 5px;" id="errorsecurityAnswertwo"></div>
				</div>






				<input class="btn btn-primary f-r"
					style="margin-right: -15px; height: 30px; width:80px;" type="submit"
					onclick="updateUserProfile()"
					value="<fmt:message key="profile.submit"></fmt:message>" /> 
					<input onclick="clearProfileForm()" class="btn btn-primary f-r" style="margin-right: 20px; height: 30px; width:80px;" type="reset"
					value="<fmt:message key="profile.cancel"></fmt:message>" />
				<div class="clearfix"></div>


			</div>
			<!--End of formcontainer -->



		</div>
		<!--end of profile containet -->


		<div class="clearfix"></div>


	</div>
	<!--end of contentpanel-->


</div>
<!--end of loginwrapper-->

<script type="text/javascript">
$(document).ready(function() {
	
 $("#thumbnail_image_file_upload-button").removeClass("uploadify-button"); 
	 $("#thumbnail_image_file_upload-button").addClass("btnupload");  
	});
function clearProfileForm(){
	/* $("input[type=text]").val('');
	
	$("select option").filter(function() {
	    return $(this).text() == 'Select the Security Question'; 
	}).attr('selected', true);

	document.getElementById("profile_response_message").innerHTML = ''; */
	window.location.href = "/ziksana-web/secure/logout";
}

	function updateUserProfile() {
		var memberId = $('#memberIdValue').text();
		var alternateEmailId = $('#alternateEmailId').val();
		var securityQuestionOne = $("#securityQuestionOne").val();
		var securityAnswerone = $("#securityAnswerone").val();
		var securityQuestionTwo = $("#securityQuestionTwo").val();
		var securityAnswerTwo = $("#securityAnswertwo").val();
		var profileAssoc_Image = $('#Cimageupl').val();

		
		firstQuestionValidation(securityQuestionOne);
		firstAnswerValidation(securityAnswerone);
		
		secondQuestionValidation(securityQuestionTwo);
		secondAnswerValidation(securityAnswerTwo);
		isEmailAlreadyExists('<c:out value="${member.primaryEmailId}" />');
		checkTwoSecurityQuestions(securityQuestionOne,securityQuestionTwo);
		if(firstQuestionValidation(securityQuestionOne) && firstAnswerValidation(securityAnswerone) && secondQuestionValidation(securityQuestionTwo) && secondAnswerValidation(securityAnswerTwo) && checkTwoSecurityQuestions(securityQuestionOne,securityQuestionTwo)){
			$.post( '<c:url value='/profile/updateprofile'/>'
			        , {'memberId':memberId,'alternateEmailId':alternateEmailId,'firstSecurityQuestionId':securityQuestionOne,'firstSecurityAnswer':securityAnswerone,'secondSecurityQuestionId':securityQuestionTwo,'secondSecurityAnswer':securityAnswerTwo,'profileImage':profileAssoc_Image}
			        , function( data )
			        {
			        
			        	if(data == 'success'){
				          	   
				          	   $('#profile_response_success').html("Profile Updated Sucessfully");
				          	   setTimeout(doRefreshCall,3000);

				             }
					
			        }
					 ); 
		}	
		

	}
	function firstQuestionValidation(question) {
		firstSelectBox = document.getElementById("securityQuestionOne");
		if (question == 'Select the Security Question') {
			
			$('#errorsecurityQuestionOne').html("Security questions are mandatory");

			return false;
		} else {
			if(("#errorsecurityQuestionOne.inside:contains('Security questions are mandatory')")){
				document.getElementById("errorsecurityQuestionOne").innerHTML = '';
			}
			return true;
		}
		
	}

	function firstAnswerValidation(securityAnswerone){
		firstAnswerBox = document.getElementById("securityAnswerone");
		if (securityAnswerone == '') {
			$('#errorsecurityAnswerone').html("Please Answer the Security Question");

			return false;
		} else{
			if(("#errorsecurityAnswerone.inside:contains('Please Answer the Security Question')")){
				document.getElementById("errorsecurityAnswerone").innerHTML = '';
			}
			return true;
		}
	}
	
	function secondQuestionValidation(question) {
		secondSelectBox = document.getElementById("securityQuestionTwo");
		if (question == 'Select the Security Question') {
			
			$('#errorsecurityQuestionTwo').html("Security questions are mandatory");
			
			return false;
		} else{
			if(("#errorsecurityQuestionTwo.inside:contains('Security questions are mandatory')")){
				document.getElementById("errorsecurityQuestionTwo").innerHTML = '';
			}
			
			return true;
		}
		
	}
	
	
	function secondAnswerValidation(securityAnswerTwo){
		secondAnswerBox = document.getElementById("securityAnswertwo");
		if (securityAnswerTwo == '') {
			$('#errorsecurityAnswertwo').html("Please Answer the Security Question");
		
			return false;
		} else {
			if(("#errorsecurityAnswertwo.inside:contains('Please Answer the Security Question')")){
				document.getElementById("errorsecurityAnswertwo").innerHTML = '';
			}
			return true;
		}
	}
	
	function checkTwoSecurityQuestions(securityQuestionOne,securityQuestionTwo){
		
		if(securityQuestionTwo !='Select the Security Question'){
		if(securityQuestionOne == securityQuestionTwo){
			
			$('#errorsecurityQuestionTwo').html("Please choose Different Question");
			return false;
		}else{
			if(("#errorsecurityQuestionTwo.inside:contains('Please choose Different Question')")){
				document.getElementById("errorsecurityQuestionTwo").innerHTML = '';
			}
			return true;
		}
		}
	}
	
	function isEmailAlreadyExists(primaryEmailId) {
		alternateEmailId = $("#alternateEmailId").val();
		
		if(alternateEmailId != ''){
			if (primaryEmailId == alternateEmailId) {
				console.log("hi");
				$('#errorEmailId').html("Alternate email id should not be same as Primary email id");
				
			}else{
				if(("#errorEmailId.inside:contains('email')")){
				document.getElementById("errorEmailId").innerHTML = '';
				}
			}
			var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
			if(alternateEmailId.match(mailformat))  
			{  
				document.getElementById("erroralternateEmailId").innerHTML = '';
			}else{
				$('#erroralternateEmailId').html("Invalid email format");
				
			}
		
	}
	}
	
	function doRefreshCall(){
		
		 window.location.href = "/ziksana-web/secure/homepage";
		 
	}
</script>
<style>
.btnupload
{
-webkit-border-radius: 0px;
border-radius: 6px;
border: 0px;
background:rgb(67, 178, 236);
color: #F9F9F9;
text-shadow: none;
text-align: center;
margin-bottom: 3px;
width:120px !important;
}
.btnupload:hover {
background: #008DC4;
color: #FFF;
width:120px !important;
}
#profilecontainer {
    box-shadow: 1px 2px 15px #000000;
    margin: auto auto 20px;
    padding: 50px;
    width: 600px;
}
</style>
