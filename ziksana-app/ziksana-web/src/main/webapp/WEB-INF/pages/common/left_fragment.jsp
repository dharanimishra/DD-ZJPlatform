<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css" href="resources/css/masks.css" />
<style>
#question_info_message {padding: .5em; color: green; font-family: arial, sans-serif;}
#question_buttons_container{display:table; width: 100%;}   
#question_buttons_container > div{display:table-cell;}  
</style>


              <div class="col-lft" >
              
              <div class="user-info all-box-shadow pad demo_message_container" style="" >
              <div class="demo_message">
    <p>
            For Demonstration Only.<br /> Functionality to be available in subsequent Playpens
            
            </p>

</div>
              
              <div class="grey-out  f-l">
              
              <c:url var="imageUrl_profile1" value="/resources/images/user/pic-id-102.jpg" />
              
          <a href="#" rel="tipsy" title="${firstname} ${lastname}"><div class="white-in main-pic"  style="background:url(${imageUrl_profile1});" > </div></a>
          </div>
              <div class="user-dtls f-l"> 
              <span class="user-id">${firstname} ${lastname}</span>
              <a href="#" style="margin-left: 2px;" rel="tipsy" title="Profile 65% complete" class="zinfo zicons ls-no f-l" ></a>
              <span class="text-size-px10 blue text-weight-400 font-Signika b-b f-l">
              Complete your Profile </span>
           <!-- <div id="progressbar65" style="width:100px;" class="f-l"></div>
            <br/> <span class="light-blue">Profile 65% complete</span>-->
            <span class="text-size-px14 light-gray text-weight-400 font-Signika b-b">
              <br>
            ${title} </span>
          
            <p><span class="text-size-px12 light-gray font-Arial b-b">ID: ${memberId}</span></p>
              <div id="edu-star"></div>
          </div>
          <c:url var="htmlUrl_profile1" value="/resources/popup/e-status.html" />
              <div class="user-belt"><span class="blue text-size-px12 text-weight-600"><a class="lbx-70-50" href="${htmlUrl_profile1}">Guru</a></span> </div>
            </div>
             <!--test githup-->
            <!-- blogs added by sundip-->
         
      <c:url var="blogListUrl" value="/blog/list" />

			
     <script type="text/javascript">
         
            $(document).ready(function() {
            	$.ajax({
        		  	type: 'GET',
        			url: '${blogListUrl}',
        			dataType: 'html',
        			success: function(  data ) {
        				       console.log('blogList Return Value: ' + data);
                    			document.getElementById("blogList").innerHTML=$(data).html();
                    			
        			}});
            }); 
			</script> 
		 	
			
			
            
            
            
           
            
          <div class="user-contacts all-box-shadow pad " >     
           <div id="blogList"></div> <div id="blogListError"></div>   
           <div id="tabs" class="demo_message_container">
	        
           <span class="titles-info font-Signika text-size-px18 light-gray " >Contacts</span>
			
           		<a class="tab0">All</a>
				<a class="tab1">First</a>
                <a class="tab2">Second</a>
				<a class="tab3">Others</a>
				<br/><br/>
			
            <div class="tabs-0">
            
            <div class="demo_message" class="_blogMain  demo_message_container">
  
    <p>
            For Demonstration Only.<br /> Functionality to be available in subsequent Playpens
            
            </p>

	</div>
			
                   <ul class="contact-list" >
                    <li class="member">
                    <!--  <div class="grey-out">
                    <c:url var="imageUrl_profile2" value="/resources/images/user/2my-photor.png" />
                        <div class="white-in contact-pic" style="background:url(${imageUrl_profile2});" ><a href="#" rel="tipsy" title="Jason (Physics)"></a></div>
                      </div> -->
                      <c:url var="imageUrl_profile3" value="/resources/images/user/2my-photo.png" />
                      <div class="white-in contact-pichome" style="background:url(${imageUrl_profile3});" ><a href="#" rel="tipsy" title="Jason (Physics)"></a></div>
                    </li>
                    <li class="member _bgmain">
                      <!--<div class="grey-out _bgmain">
                      <c:url var="imageUrl_profile4" value="/resources/images/user/1my-photor.png" />
                        <div class="white-in contact-pic _bgmain" style="background:url(${imageUrl_profile4});"><a href="#" rel="tipsy" title="John (Electronics)"></a></div>
                      </div> -->
                      <c:url var="imageUrl_profile5" value="/resources/images/user/1my-photo.png" />
                       <div class="white-in contact-pichome _bgmain" style="background:url(${imageUrl_profile5});"><a href="#" rel="tipsy" title="John (Electronics)"></a></div>
                    </li>
                    <li class="member _bgmain">
                      <!--<div class="grey-out _bgmain">
                      <c:url var="imageUrl_profile6" value="/resources/images/user/3my-photo.png" />
                        <div class="white-in contact-pichome _bgmain" style="background:url(${imageUrl_profile6});"><a href="#" rel="tipsy" title="Linda (Robotics)"></a></div>
                      </div>-->
                      <c:url var="imageUrl_profile7" value="/resources/images/user/3my-photo.png" />
                      <div class="white-in contact-pichome _bgmain" style="background:url(${imageUrl_profile7});"><a href="#" rel="tipsy" title="Linda (Robotics)"></a></div>
                    </li><li class="member _bgmain">
                      <!--<div class="grey-out _bgmain">
                      <c:url var="imageUrl_profile8" value="/resources/images/user/2my-photo.png" />
                        <div class="white-in contact-pichome _bgmain" style="background:url(${imageUrl_profile8});"><a href="#" rel="tipsy" title="Jackie (Robotics)"></a></div>
                      </div>-->
                      <c:url var="imageUrl_profile9" value="/resources/images/user/2my-photo.png" />
                       <div class="white-in contact-pichome _bgmain" style="background:url(${imageUrl_profile9});"><a href="#" rel="tipsy" title="Jackie (Robotics)"></a></div>
                    </li>
                    <li class="member _bgmain">
                     <!-- <div class="grey-out _bgmain">
                     <c:url var="imageUrl_profile10" value="/resources/images/user/1my-photo.png" />
                        <div class="white-in contact-pichome _bgmain" style="background:url(${imageUrl_profile10});"><a href="#" rel="tipsy" title="Rose (Mathematics)"></a></div>
                      </div>-->
                      <c:url var="imageUrl_profile11" value="/resources/images/user/1my-photo.png" />
                      <div class="white-in contact-pichome _bgmain" style="background:url(${imageUrl_profile11});"><a href="#" rel="tipsy" title="Rose (Mathematics)"></a></div>
                    </li>
                  </ul>
                  
                          <a href="" class="Block"><span class="f-r text-pading-top">People Search</span> <strong class="in-search zicons ls f-r"></strong></a> 
            </div>
            <c:url var="imageUrl_profile12" value="/resources/images/background-pattern.jpg" />
            <div class="tabs-1" style="background-image:url(${imageUrl_profile12});">  
            <ul class="contact-list" >
                    <!--<li class="member">
                      <div class="grey-out">-->
                      <c:url var="imageUrl_profile13" value="/resources/images/user/2my-photo.png" />
                        <div class="white-in contact-pichome" style="background:url(${imageUrl_profile13});" ><a href="#" rel="tipsy" title="Jason (Physics)"></a></div>
                  <!--    </div>
                    </li> -->
                   </ul>
                    </div>
                    
            <c:url var="imageUrl_profile14" value="/resources/images/background-pattern.jpg" />
       
			<div class="tabs-2"  style="background-image:url(${imageUrl_profile14});"> <ul class="contact-list" >
                    <li class="member">
                     <!-- <div class="grey-out">
                     <c:url var="imageUrl_profile15" value="/resources/images/user/3my-photo.png" />
                        <div class="white-in contact-pichome" style="background:url(${imageUrl_profile15});" ><a href="#"></a></div>
                      </div>-->
                      <c:url var="imageUrl_profile16" value="/resources/images/user/3my-photo.png" />
                       <div class="white-in contact-pichome" style="background:url(${imageUrl_profile16});" ><a href="#" rel="tipsy" title="Linda (Robotics)"></a></div>
                    </li>
                   </ul>
                   </div>
			
           <div class="tabs-3">
            
                   <ul class="contact-list" >
                   
                    <li class="member _bgmain">
                     <!-- <div class="grey-out _bgmain">
                     <c:url var="imageUrl_profile17" value="/resources/images/user/1my-photo.png" />
                        <div class="white-in contact-pichome _bgmain" style="background:url(${imageUrl_profile17});"><a href="#"></a></div>
                      </div> -->
                      <c:url var="imageUrl_profile18" value="/resources/images/user/1my-photo.png" />
                      <div class="white-in contact-pichome _bgmain" style="background:url(${imageUrl_profile18});"><a href="#"  rel="tipsy" title="John (Electronics)"></a></div>
                    </li>
                    <li class="member _bgmain">
                      <!--<div class="grey-out _bgmain ">
                      <c:url var="imageUrl_profile19" value="/resources/images/user/3my-photo.png" />
                        <div class="white-in contact-pichome _bgmain" style="background:url(${imageUrl_profile19});"><a href="#"></a></div>
                      </div> -->
                      <c:url var="imageUrl_profile20" value="/resources/images/user/3my-photo.png" />
                       <div class="white-in contact-pichome _bgmain" style="background:url(${imageUrl_profile20});"><a href="#" rel="tipsy" title="Linda (Robotics)"></a></div>
                    </li>
                  </ul>  
                  <br/>
                                  
            </div>
      
          <p class="txt-r _bgmain" style="padding-right:10px; clear:both;">
           
          </p>
        </div>
        </div>
        
      <!-- unanswered script -->
<c:url var="knowmwpopup" value="/secure/getknowmepopupwindow" />
	   
<c:url var="showUnAnswered" value="/secure/getunansweredquestions" />
  <script type="text/javascript">
  setInterval(function() {
		

	}, 500);
  get_and_UnAnswered_questions();
  
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
						var optionIndex= "";
				 		$(this).find("options").each(function(){
				 			
				 			$(this).find("option").each(function(){
				 				
				 				options +=  $(this).text()+"/";
				 				//optionIndex += $(this).find(index).val()+"/";
				 				
				 			});
				 			options = options.substring(0,options.length-1);
				 			optionArray.push(options);
				 			//optionIndexArray.push(optionIndex);	
				 			
				 		});
				 		
					
					});
					console.log("unAnswered Question Id ==>"+ questionIdArray);
					console.log("unanswered array: ==> " + questionArray);
					console.log("option array==>"+  optionArray);
					console.log("memberPersonalitytestId==>"+memberPersonalitytestId);
					console.log("option array index"+optionIndexArray);
				
					displayUnAnsweredPairs(0);		
					
			}
	
	});
	
});

  }
function displayUnAnsweredPairs(current){
	var outputResult="";
	outputResult+="<p class='titles-info font-Signika text-size-px18 light-gray'>Know me better</p>";
	outputResult+="<div id='question_info_message'></div>";
	outputResult+="<div id='quest'>";
	outputResult+="<label style='display:none;' id='cur-qus-id'>"+questionIdArray[current]+"</label><label id='cur-qus-value'>"+questionArray[current]+"</label> ";
	outputResult+="<table width='180px' height='30px' >";

	var optionsList = optionArray[current].split("/");

	/* outputResult+= "<tr><td ><input type='radio'  id='checked-val'  checked='checked' name='radiobtn' value='1'><label id='option-ans' for='option'>Yes</label></td></tr>";
	outputResult+= "<tr><td ><input type='radio'  id='checked-val' name='radiobtn' value='2'><label id='option-ans' for='option'>No</label></td></tr>"; */
	 for(var i = 0; i < optionsList.length ; i++){
		
			if(i==0){
			outputResult+= "<tr><td ><label><input type='radio' checked  id='checked-val" + i + "'  name='radiobtn' value='"+i+"'>" + optionsList[i] + "</label></td></tr>";
			} else {
			outputResult+= "<tr><td ><label><input type='radio'  id='checked-val" + i + "'  name='radiobtn' value='"+i+"'>" + optionsList[i] + "</label></td></tr>";	
			}
		}	 
	
	outputResult+="</table>";
	outputResult+="<br/>";
	
	

		outputResult+="<button class='f-rt' id='knowme-save' onClick='submitValue()'>Submit</button>";
	
	  
	   outputResult+="<div class='txt-r' ><a class='text-size-px11  lbx-70-50' href='${knowmwpopup}' class='Block'><span class='f-r text-pading-top text-pading-right'><span class='text-pading-right'>More</span></span></a>";
	
		 
	
	
	$('#knowme-ques').html(outputResult);
}

function selectFirstValue(val){
	//alert(val);
	
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
		     //alert()
		     
		    /*  if(testQuestionValue == 1){
				  memberAnswer = 'Yes';
			  }else{
				  memberAnswer= 'No';
			  } 
		      */
		     $.post( '<c:url value='/secure/saveknowme'/>'
				        , {'memberAnswer':memberAnswer,'testQuestionValue':testQuestionValue,'testQuestionId':testQuestionId,'questionBankAnswerId':questionBankAnswerId}
				        , function( data )
				        {
				        
							//alert("Answer Submitted Successfully");
							$('#question_info_message').html("Answer Submitted Successfully");
							$("#knowme-save").attr('disabled','true');
				        }
						, 'xml' );  
		     
		});
  }
</script>
        
         <div id="knowme-ques" class="user-insight user-contacts all-box-shadow pad" >
			 
			 <!--  <ul>
			    <li class=""><span class="p-p _blogs bckground-blue-light">You are usually the first to react to a sudden event.</span>
			      <div id="radio" class="btn-set" style="margin-top:3px; margin-bottom:5px;">
			        <input type="radio" id="radio1" name="radio" />
			        <label for="radio1">Yes</label>
			        <input type="radio" id="radio2" name="radio"  />
			        <label for="radio2">Sometimes</label>
			        <input type="radio" id="radio3" name="radio" />
			        <label for="radio3">Never</label>
			        <br>
			    </div>
			    </li> -->
    
  
  </div>
  
  <label o></label>
  <!-- recommendation zeni -->
 
  <c:url var="showRecomendUrl" value="/secure/getmapperrecomendations" />
  <script type="text/javascript">
$(document).ready(function() {
	$.ajax({
		  	type: 'GET',
			url: '${showRecomendUrl}',
			dataType: 'xml',
			success: function( data ) {
					if (console && console.log){
								console.log( 'Recommend of data:', data);
					}
					var output="";
					
					
					$(data).find("recommenditem").each(function(index){
						
						output+="<ol>";
	                    output+="<li class='p-p _blogs bckground-blue-light'>";
	                    output+="<b >"+ $(this).find("title").text()+"</b>";
	                    output+="<br/>";
	                    output+="<p  style='padding-left: 10px;'>"+ $(this).find("description").text()+"</p>";
	                    output+="</li></ol><br/>";
												
					});

					console.log("Recommendations: " + output);
				
					
					$('#recomend').html(output);
					
			}
	});
	
});
</script>
 
<div class="user-contacts all-box-shadow pad" >
           
           <div id="tabsbottom" style="background-color:#FFF; margin-bottom:15px;">
           <span class="titles-info font-Signika text-size-px18 light-gray">Zeni Recommendations</span>
			           
            	<a class="rec0">All</a>
				<a class="rec1">Course</a>
                <a class="rec2">Grades</a>
				<br/><br/>
                            
            <div id= "recomend" class="rec-0 ">
              
            </div>
            
         			          
      
          <p class="txt-r _bgmain" style="padding-right:10px; clear:both;">
          <c:url var="htmlUrl_profile2" value="/secure/zrecommendpopup" />
            <span><a class="text-size-px11  lbx-70-50" href="${htmlUrl_profile2}" class="" style="color: #27b;">More..</a></span>
          </p>
        </div>
        </div>
                </div>