
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

<c:if test="${applicationTitle == 'User Profile Page creation'}">
		<div id="profilecontainer">

			<div class="page-header">
				<div class="icon">
					<img src="/ziksana-web/resources/images/icons/information_icon.png"style="height: 25px;"/>
				</div>
				<h1><fmt:message key="profile.setup.name"></fmt:message> </h1>
			</div>


			<div class="fileupload  f-l" style="width:250px;  ">
				<div class="associateimage" style="text-align:center;" >
            <div style="height:150px">
					<c:if test="${empty member.picturePath}">
						<img style="width: 144px; margin-bottom: .25em;margin-left: -55px;" id="profile_thumbnail_image" src="/ziksana-web/resources/images/no-image.jpg" align="center"/>
					</c:if>
					<c:if test="${not empty ms.url && not empty member.picturePath}">
						<img style="width: 144px; margin-bottom: .25em;margin-left: -55px;" id="profile_thumbnail_image" src="${ms.url}<c:out value="${member.picturePath}"/>" />
					</c:if> </div>
					<div class="clearfix"></div>
					<div style="width:120px;height:20px; margin-left: 37px; margin-top: 8px;"><input
						style="height: 25px; width: 120px;border:1px solid"
						type="file" name="thumbnail_image_file_upload" 
						id="thumbnail_image_file_upload" /></div>
					 <input readonly="readonly" type="hidden" id="Cimageupl" /> 


					<div id="thubmnail_upload_message" ></div>
					<div id="loaderText"></div>
 
					
					<div id="status"></div>
					<script type="text/javascript">
						$(function() {
							$('#thumbnail_image_file_upload')
									.uploadify(
											{
												'swf' : '${staticFileServer}resources/swf/uploadify.swf',
												'queueSizeLimit' : 1,
												'successTimeout' : 350,
												'buttonText' : 'Upload Image',
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
														.html(
																'<a onclick="remove_uploaded_thumbnail();" title="Remove Image" class="rmv" style="margin-left:20px">Remove</a>');

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
									.attr('src','/ziksana-web/resources/images/no-image.jpg');

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


			<div class="profiledetail f-l" style="width:50%; word-wrap:break-word;">

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
			<div id="profile_response_message"style="color: red; text-align: center;"></div>
			<div id="profile_response_success"style="color: green; text-align: center;"></div>
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
						<select class="profileselect nexaf" style="font-weight:normal" id="securityQuestionOne">
							<option selected="selected">Select the Security Question</option>
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
							name="sec_answer1" placeholder="Security Answer 1" />
					</div>
					<div style="color: red; padding: 5px;" id="errorsecurityAnswerone"></div>
				</div>



				<div class="control-group">
					<label class="control-label nexaf" for="Course Name"
						style="width: 180px;"><fmt:message
							key="profile.securityquestion2"></fmt:message><span class="requiredField">*</span> </label>
					<div class="controls">

						<select class="profileselect nexaf" style="font-weight:normal" id="securityQuestionTwo">
							<option selected="selected">Select the Security Question</option>
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
							name="sec_answer2" placeholder="Security Answer 2" />
					</div>
					<div style="color: red; padding: 5px;" id="errorsecurityAnswertwo"></div>
				</div>






				
					<input onclick="clearProfileForm()" class="btn btn-primary f-r" style=" height: 28px;margin-right: -15px;width:120px; " type="reset"
					value="<fmt:message key="profile.cancel"></fmt:message>" />
					<input class="btn btn-primary f-r"
					style=" height: 28px;margin-right: 20px;width:120px; " type="submit"
					onclick="updateUserProfile()"
					value="<fmt:message key="profile.submit"></fmt:message>" /> 
				<div class="clearfix"></div>


			</div>
			<!--End of formcontainer -->



		</div>
		<!--end of profile containet -->
		</c:if>
		<c:if test="${applicationTitle == 'User Profile Page Edit'}">
			<div id="profilecontainer">

			<div class="page-header">
				<div class="icon">
					<img src="/ziksana-web/resources/images/icons/information_icon.png"style="height: 25px;"/>
				</div>
				<h1><fmt:message key="edit.profile"></fmt:message></h1>
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
												'buttonText' : 'Change Image',
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
																.val(data_object.ContentPath);
															saveUploadedImage(data_object.ContentPath);
														$(
																'#profile_thumbnail_image')
																.attr(
																		'src',
																		'${ms.url}'
																				+ data_object.ContentPath);
														$(
														'#thubmnail_upload_message')
														.html(
																'<a onclick="remove_uploaded_thumbnail();" title="Remove Image" class="rmv" style="position: relative;top: 33px;">Remove</a>');

													} else { //there is an error in the upload process

														$('#message')
																.html(data_object.message);
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
											'/ziksana-web/resources/images/no-image.jpg');

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
					<label id="primaryEmailId" style="display: none;"><c:out value="${member.primaryEmailId}" /></label>
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
		<hr/>
							
					<div class="formcontainer form-horizontal">
					   
					    <div class="control-group"> 
						
						
						<div  id="passEdit">
					<label class="control-label nexaf" for="Change Password"><fmt:message key="login.password"></fmt:message> :</label>
					<label id="passwordUpdatedDate" class="control-label nexaf"  style="margin-left: 20px;width:300px;font-weight:normal"><c:out value="${passwordUpdated}"></c:out></label>	
						 <a   id="lblpass " onclick="showchangepwd('Edit_pass')" class="editfeild"><fmt:message key="Edit"></fmt:message></a>
						 </div>
					      
						  <div class="editcontroll border-user"  id="Edit_pass" ><a style="float:right;cursor:pointer;" onclick="hidecncl('passEdit');" title="Close">[X]</a>
						  <p style="color:green;padding: 0 .5em;border-radius: 3px;text-align:center" id="passwordResetResponse"></p>
     						<p style="color:red;padding: 0 .5em;border-radius: 3px;text-align:center" id="passwordResetFailResponse"></p>
						  <label class="control-label nexaf" for="Change Password"><fmt:message key="login.password"></fmt:message> :</label>
						 <div class="controls"> <label class="nexaf"><fmt:message key="Current"></fmt:message> :</label><input type="password" style="width:365px;" class="passinput" id="currentPassword" name="alt_mail" placeholder="<fmt:message key="Enter.cur.pass"></fmt:message>" /><div class="clearfix"></div><div style="color: red;" id="errorCurrentPassword"></div>
						   <label class="nexaf"><fmt:message key="New"></fmt:message> :</label> <input type="password" style="width:365px;" class="passinput" id="newPassword" name="alt_mail" placeholder="<fmt:message key="Enter.new.pass"></fmt:message>" /><div class="clearfix"></div><div style="color: red;" id="errorNewPassword"></div>
						    <label class="nexaf"><fmt:message key="retype.new"></fmt:message>:</label><input type="password" style="width:365px;" class="passinput" id="retypePassword" name="alt_mail" placeholder="<fmt:message key="re.new.pass"></fmt:message>" /></div><div style="color: red;" id="errorRetypePassword"></div><div class="clearfix"></div>
						   <div style="margin-top:6px;">
						   
					  		<button class="btn btn-primary f-r" onclick="checkpass()" type="button" style="margin-right:20px;" ><fmt:message key="save"></fmt:message></button>
						  </div>
						  </div>
						 </div>
						  
					      <div class="control-group"> 
					      <div class="clearfix"></div>
						 <div  id="lblaltEmail">
						 <label class="control-label nexaf" for="Course Name"><fmt:message key="profile.alternateemail"></fmt:message> :</label>
						 <label class="control-label nexaf" id="alternateMailLabel" for="AlternativeEmail Name" style="margin-left:20px;font-weight:normal"><c:out value="${profileAnswerOne.alternateEmailId}"></c:out></label>
						 
						
						 <a  onclick="editFeilds('EditAlt_mail')" class="editfeild"><fmt:message key="Edit"></fmt:message></a>
						 
					      </div>
						  <div class="editcontroll border-user" id="EditAlt_mail" ><a style="float:right;cursor:pointer;" onclick="showlbl('lblaltEmail');" title="Close">[X]</a>
						   <label class="control-label nexaf" for="Course Name"><fmt:message key="profile.alternateemail"></fmt:message> :</label>
						   <input type="text" style="width:365px;margin-left:19px;" id="alttenateEmailValue"  name="alt_mail" placeholder="Alternate Email" />
						   <p id="alternateEmailError" style="color:red;text-align:center"></p>
						   <div style="margin-top:6px;">
						  
					  <button class="btn btn-primary f-r" onclick="alterEmailSubmit('${profileAnswerOne.alternateEmailId}')" type="button" style="margin-right:20px;" ><fmt:message key="save"></fmt:message></button>
						  </div>
						  </div>
					      </div>
						  
					     
					      
					      <div class="control-group"> 
						  <div  id="lblsq1">
					     <label class="control-label nexaf" for="Course Name" style="width:180px;"><fmt:message key="profile.securityquestion1"></fmt:message> :</label>
						  
						 <label id="ques_text_diplayone" class="control-label nexaf" style="width:65%;font-weight:normal"><c:out value="${profileAnswerOne.securityQuestionText}"></c:out></label>
					      <a  onclick="changesq1('Editsq1')" class="editfeild" ><fmt:message key="Edit"></fmt:message></a>
						 </div>
					     
						  <div class="clearfix"></div>
						  
					      <div  id ="Editsq1" class="editcontroll border-user"  "><a style="float:right;cursor:pointer;" onclick="showlblsq1('lblsq1')" title="Close">[X]</a>
						  <label class="control-label nexaf" for="Course Name" style="width:180px;"><fmt:message key="profile.securityquestion1"></fmt:message> :</label>
						   
					    <select class="profileselect nexaf" style="font-weight:normal;margin-bottom: 10px; width: 377px;" id="editQuestionOne" >
							<option><fmt:message key="profile.select.text"></fmt:message></option>
							<c:forEach var="profile" items="${profileList}">
										<c:if test="${profileAnswerOne.securityQuestionText ==profile.securityQuestionText}">
											<option selected="selected" value="${profile.securityQuestionId}">${profile.securityQuestionText}</option>
										</c:if>
										<c:if test="${profileAnswerOne.securityQuestionText != profile.securityQuestionText}">
											<option value="${profile.securityQuestionId}">${profile.securityQuestionText}</option>
										</c:if>
							</c:forEach>
						</select>
					
					<label class="control-label nexaf" for="Course Name"><fmt:message key="profile.securityanswer1"></fmt:message></label>
					     <div class="controls">
					      <input type="password" class="profileinput" id="editSecAnswerOne" value="${profileAnswerOne.memberAnswer}"  name="sec_answer1" placeholder="Security Answer 1" style="width:365px;" />         
					      </div>
					      <p id="secQuesOneError" style="color:red;text-align:center"></p>
					<div style="margin-top:6px;">
						   
 					  <button class="btn btn-primary f-r" onclick="editUpdateSecuQuestion()" type="button" style="margin-right:20px;" ><fmt:message key="save"></fmt:message></button>
						  </div>
						  
					      </div>
						   </div>
					     
					      
					      
					     <div class="control-group"> 
					     
						 <div id="lblsq2">
						 <label class="control-label nexaf" for="Course Name" style="width:180px;"><fmt:message key="profile.securityquestion2"></fmt:message> :</label>
						 <label id="ques_text_diplaytwo" class="control-label nexaf" style="width:65%;font-weight:normal"><c:out value="${profileAnswerTwo.securityQuestionText}"></c:out></label>
					      <a  onclick="changesq2('Editsq2')" class="editfeild" ><fmt:message key="Edit"></fmt:message></a>
						 </div>
					      
						  <div class="clearfix"></div>
						  
					      <div  id ="Editsq2" class="editcontroll border-user"  ><a style="float:right;cursor:pointer;" onclick="showlblsq2('lblsq2');" title="Close">[X]</a>
						  <label class="control-label nexaf" for="Course Name" style="width:180px;"><fmt:message key="profile.securityquestion2"></fmt:message> :</label>
					    
					<select class="profileselect nexaf" style="font-weight:normal;margin-bottom: 10px; width: 377px;" id="securityQuestionTwo">
							<option ><fmt:message key="profile.select.text"></fmt:message></option>
							<c:forEach var="profile" items="${profileList}">
									
										<c:if test="${profileAnswerTwo.securityQuestionText ==profile.securityQuestionText}">
											<option selected="selected" value="${profile.securityQuestionId}">${profile.securityQuestionText}</option>
										</c:if>
										<c:if test="${profileAnswerTwo.securityQuestionText != profile.securityQuestionText}">
											<option value="${profile.securityQuestionId}">${profile.securityQuestionText}</option>
										</c:if>
									
										
									
							</c:forEach>
						</select>
					<label class="control-label nexaf" for="Course Name"><fmt:message key="profile.securityanswer2"></fmt:message>:</label>
					     <div class="controls">
					      <input type="password" class="profileinput" id="editSecAnswerTwo" value="${profileAnswerTwo.memberAnswer}" name="sec_answer2" placeholder="Security Answer 1" style="width:365px;"/>         
					      </div>
					      <p id="secQuesTwoError" style="color:red;text-align:center"></p>
					<div style="margin-top:6px;">
						   
					  <button class="btn btn-primary f-r" onclick="editSaveSecQuesTwo()" type="button" style="margin-right:20px;" ><fmt:message key="save"></fmt:message></button>
						  </div>
						  
					      </div>
					     </div>
					      
					<a href="/ziksana-web/secure/1/homepage"><button class="btn btn-primary f-r" type="button" style="margin-right:-15px; " ><fmt:message key="profile.cancel"></fmt:message></button></a>
					 
					<div class="clearfix"> </div>   
					
					
					</div><!--End of formcontainer -->


			
			</div>
		</c:if>

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
			$.post( '<c:url value='/profile/1/updateprofile'/>'
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
		
		 window.location.href = "/ziksana-web/secure/1/homepage";
		 
	}
	function editFeilds(divid){
		$('#'+divid).slideToggle();
		$("#lblaltEmail").hide();
		}
		function showlbl(divid){
		$('#'+divid).slideToggle();
		$("#EditAlt_mail").hide();
		}
		function showchangepwd(divid){
		$('#'+divid).slideToggle();
		$("#passEdit").hide();
		}
		function hidecncl(divid){
		$('#'+divid).slideToggle();
		$("#Edit_pass").hide();
		}
		function changesq1()
		{
		$("#Editsq1").slideToggle();
		$("#lblsq1").hide();

		}
		function showlblsq1(divid){
		$('#'+divid).slideToggle();
		$("#Editsq1").hide();
		}
		function changesq2()
		{
		$("#Editsq2").slideToggle();
		$("#lblsq2").hide();

		}
		function showlblsq2(divid){
		$('#'+divid).slideToggle();
		$("#Editsq2").hide();
		}
		function alterEmailSubmit(email){
			
			alternateEmailId = $("#alttenateEmailValue").val();
			memberIdVal = $("#memberIdValue").text();
			if(alternateEmailId != ''){
				if (primaryEmailId == alternateEmailId) {
					$('#alternateEmailError').html("Alternate email id should not be same as Primary email id");
					
				}else{
					if(("#alternateEmailError.inside:contains('email')")){
					document.getElementById("alternateEmailError").innerHTML = '';
					}
				}
				var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
				if(alternateEmailId.match(mailformat))  
				{  
					$.post( '/ziksana-web/profile/1/updatealternatemail'
					        , {'memberId':memberIdVal,'alternateEmailId':alternateEmailId}
					        , function( data )
					        {
					        
					        	if(data == 2){
				
						          	   $('#alternateMailLabel').html(alternateEmailId);						          	  
						          	 showlbl('lblaltEmail');
						             }
							
					        }
							 ); 
					
					document.getElementById("alternateEmailError").innerHTML = '';
				}else{
					$('#alternateEmailError').html("Invalid email format");
					
				}
			
		}
		}
		

//Password Validation Script
passwordStrength='';
passwordFailType='';
$(document).ready(function() {
	
	
	
	$('#newPassword').keyup(function(){
		passwordStrength = checkStrength($('#newPassword').val());
		
		 
		
	});
		
	
	function checkStrength(password){
    
	//initial strength
    strength = 0;
	
    var x = $('#newPassword').val();
	 if ((x.charAt(0).match(/([0-9,!,%,&,@,#,$,^,*,?,_,~])/)))
	 {
		 $('#errorNewPassword').html('<span style="padding-left:5px;">Password should start with a charactor</span>');
	 	return false;
	 }

   
    //if the password length is less than 6, return message.
    if (password.length < 6) { 
		$('#errorNewPassword').removeClass();
		/*$('#result').addClass('short')*/
		$('#errorNewPassword').html('<div id="red"></div><div id="blank"></div><div id="blank"></div><div id="blank"></div><span style="padding-left:5px;">Too Short</span><br/><span style="color:orange;">Password should be at least 8 characters</span>');
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
		$('#errorNewPassword').removeClass();
		$('#errorNewPassword').addClass('weak');
		$('#errorNewPassword').html('<div id="red"></div><div id="blue"></div><div id="blank"></div><div id="blank"></div><span style="padding-left:5px;">Weak password  </span><br/><span style="color:orange;">Password should be at least 8 characters in length with at least one Capital Letter/Number/Special Character </span>');
		return false;			
	} else if (strength == 2 ) {
		$('#errorNewPassword').removeClass();
		$('#errorNewPassword').addClass('good');
		$('#errorNewPassword').html('<div id="red"></div><div id="blue"></div><div id="orange"></div><div id="blank"></div><span style="padding-left:5px;color:green;">Good</span>');
		return true;	
	} else {
		$('#errorNewPassword').removeClass();
		$('#errorNewPassword').html('<div id="red"></div><div id="blue"></div><div id="orange"></div><div id="green"></div><span style="padding-left:5px;color:green;">Strong</span>');
		return true;
	}
}
	
	
});
function checkpass()
{
	if(passwordStrength){
		
		if($('#currentPassword').val()==''){
			$('#errorCurrentPassword').html("Enter Current Password");
			
		}
		
		else if ($('#newPassword').val()!=$('#retypePassword').val()){
			$('#errorRetypePassword').html("Passwords do not match");
			
			
		}else{
			oldPassword = $('#currentPassword').val();
			newPassword = $('#newPassword').val();
			retypePassword = $('#retypePassword').val();
			
			memberIdRef = $('#memberIdValue').text();

			
			 $.post( '/ziksana-web/secure/password/resetpassword'
			        , {'oldPassword':oldPassword,'confirmPassword':newPassword,'memberId':memberIdRef}
			        , function( data )
			        {
			        	if(data == 'Old Password is incorrect'){
			        		$('#errorCurrentPassword').html(data);
			        		
			        	}else{
			        	if(data != 'Password reset is not successful.'){
			        		
			        		$('#passwordResetResponse').html("Password reset is successful.");
			        		$('#passwordUpdatedDate').html(data);
			        		
			        		setTimeout("showMsg()",3000);
			        		
						}else{
							$('#passwordResetFailResponse').html(data);
							
						}
			        }
			        }
					 );  
		}
	
		
	}else{
		if($('#newPassword').val() == ''){
		$('#errorNewPassword').html("Please Enter Password");
		
		}
	}

}
function showMsg(){

	$('#currentPassword').val('');
	$('#newPassword').val('');
	$('#retypePassword').val('');
	$('#errorCurrentPassword').val('');
	$('#errorNewPassword').val('');
	$('#errorRetypePassword').val('');
	
	document.getElementById("passwordResetResponse").innerHTML = '';
	hidecncl('passEdit');
}

function passwordStartCharectors(val){
	
	console.log(val);
	if(val.substring(0, 1).matches("a-z") || val.substring(0, 1).matches("A-Z")){
		return true;
	}else{
		return false;
	}
}
function editUpdateSecuQuestion(){
	alternateEmailId = $("#alttenateEmailValue").val();
	memberIdVal = $("#memberIdValue").text();
	editQuestionOne = $("#editQuestionOne").val();
	
	var Select = document.getElementById("editQuestionOne");

	var editQuestionOneValue = Select.options[Select.selectedIndex].text;

	editSecAnswerOne= $("#editSecAnswerOne").val();
	console.log(alternateEmailId,memberIdVal,editQuestionOne,editQuestionOneValue,editSecAnswerOne);
	
	if(editSecAnswerOne == ''){
		$('#secQuesOneError').html("Enter Answer"); 
	}else{
	 $.post( '<c:url value='/profile/1/editupdateprofile'/>'
	        , {'memberId':memberIdVal,'alternateEmailId':alternateEmailId,'SecurityQuestionId':editQuestionOne,'SecurityQuestionValue':editQuestionOneValue,'SecurityAnswer':editSecAnswerOne}
	        , function( data )
	        {
	        
	        	if(data == 1){
		          	   	          	 
	        		showlblsq1('lblsq1');
	        		
		          	$('#ques_text_diplayone').html(editQuestionOneValue);
		          	$('#secQuesOneError').html(""); 
		             }else{
		            	  $('#secQuesTwoError').html("Error"); 
		             }
			
	        }
			 );
	}
}

function editSaveSecQuesTwo(){
	alternateEmailId = $("#alttenateEmailValue").val();
	memberIdVal = $("#memberIdValue").text();
	editQuestionTwo = $("#securityQuestionTwo").val();
	
	var Select = document.getElementById("securityQuestionTwo");

	var editQuestionOneValue = Select.options[Select.selectedIndex].text;

	editSecAnswerTwo= $("#editSecAnswerTwo").val();
	if(editSecAnswerTwo == ''){
		$('#secQuesTwoError').html("Enter Answer");
	}else{
	 $.post( '<c:url value='/profile/1/editupdateprofile'/>'
	        , {'memberId':memberIdVal,'alternateEmailId':alternateEmailId,'SecurityQuestionId':editQuestionTwo,'SecurityQuestionValue':editQuestionOneValue,'SecurityAnswer':editSecAnswerTwo}
	        , function( data )
	        {
	        
	        	if(data == 1){
		          	   	          	 
	        		showlblsq2('lblsq2');
		          	$('#ques_text_diplaytwo').html(editQuestionOneValue);
		          	$('#secQuesTwoError').html("");
		          	
		             }else{
		            	  $('#secQuesOneError').html("Error"); 
		             }
			
	        }
			 );
	}
}

function saveUploadedImage(val){
	member_id = $("#memberIdValue").text();
	profileImage = val;
	$.post( '<c:url value='/profile/1/updateprofileimage'/>'
	        , {'memberId':member_id,'profileImage':profileImage}
	        , function( data )
	        {
	        
	        		if(data == 1){
		          	   	console.log("Profile Image Upload Success");          	 	        		
		          	
		             }else{
		          	   	console.log("Profile Image Upload Failure");   
		             }
			
	        }
			 );  

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
position:relative;
 top: -35px;
}
.btnupload:hover  {
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
.editcontroll{
display:none;
 padding:10px 20px 10px 4px;
 margin-bottom:10px;
  overflow: auto;
  

}
.editfeild{
float:right;
 cursor:pointer;
}
.fileupload .swfupload {
    position: relative !important;
    top: 0!important;
}
.rmv { 
    background: none repeat scroll 0 0 #43B2EC !important;
    border: 0 none;
    border-radius: 6px 6px 6px 6px;
    color: #F9F9F9;
    cursor: pointer;
    float: left;
    left: 142px;
    margin-bottom: 3px;
    margin-left: -11px;
    padding: 5px;
    position: relative;
    text-align: center;
    text-shadow: none;
    top: -19px;
    width: 93px;
    text-decoration:none!important;
    }
 .uploadify-queue {
     width: 250px;
}
.border-user{
display: none;
border:1px solid #eee;
border-radius: 6px 6px 6px 6px;"
}
</style>
