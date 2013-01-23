<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>

<link rel="stylesheet" type="text/css" href="../resources/css/masks.css" />
<script type="text/javascript" src="../resources/js/sortable.js"></script>

<style>

.t_up:hover {
  background: url("/ziksana-web/resources/images/downtoggle.png") no-repeat scroll right 15px rgba(218, 216, 216, 0.17) !important;
}
.t_down:hover {
  background: url("/ziksana-web/resources/images/uptoggle.png") no-repeat scroll right 15px rgba(218, 216, 216, 0.17) !important;
}
#question_info_message {
	padding: .5em;
	color: green;
	font-family: arial, sans-serif;
}

#question_buttons_container {
	display: table;
	width: 100%;
}

#question_buttons_container>div {
	display: table-cell;
}



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
.jdash-head-title {
	font-size:18px;
	font-family:signika;  
	cursor: move;
	color: #666;
}
.jdash-head-title:hover { color: #ccc; }
.jdash-head-title:hover span.sub-title { color: #666666; }
.moreclass {font-size:12px;color:#27B;}
</style>
<body>

<div class="col-lft">

	<div class="user-info all-box-shadow pad demo_message_container"
		style="">
		<div class="demo_message">
			<p>
				For Demonstration Only.<br /> Functionality to be available in
				subsequent Playpens

			</p>

		</div>

		<div class="grey-out  f-l">

			<c:url var="imageUrl_profile1"
				value="${member.picturePath}" />

			<!-- <a href="#" rel="tipsy" title="${firstname} ${lastname}"><div class="white-in main-pic"  style="background:url(${imageUrl_profile1});" > </div></a> -->
			<a href="#" rel="tipsy"
				title="<c:out value="${member.firstName}"/> <c:out value="${member.lastName}"/>"><div
					class="white-in main-pic"
					style="background:url(${imageUrl_profile1});"></div></a>
		</div>
		<div class="user-dtls f-l">
			<span class="user-id"><c:out value="${member.firstName}" /> <c:out
					value="${member.lastName}" /></span> <a href="#" style="margin-left: 2px;"
				rel="tipsy" title="Profile 65% complete"
				class="zinfo zicons ls-no f-l"></a> <span
				class="text-size-px10 blue text-weight-400 font-Signika b-b f-l">
				Complete your Profile </span>
			<!-- <div id="progressbar65" style="width:100px;" class="f-l"></div>
            <br/> <span class="light-blue">Profile 65% complete</span>-->
			<span
				class="text-size-px14 light-gray text-weight-400 font-Signika b-b">
				<br> <c:out value="${member.designation}" />
			</span>

			<p>
				<span class="text-size-px12 light-gray font-Arial b-b">ID: <c:out
						value="${member.memberId}" /></span>
			</p>
			<div id="edu-star"></div>
		</div>
		<c:url var="htmlUrl_profile1" value="/resources/popup/e-status.html" />
		<div class="user-belt">
			<span class="blue text-size-px12 text-weight-600"><a
				class="lbx-70-50" href="${htmlUrl_profile1}">Guru</a></span>
		</div>
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
        				     
                    			document.getElementById("blogList").innerHTML=$(data).html();
                    			
        			}});
            }); 
            
            $('#edu-star').raty({
				
				click		: function(score, evt) {
					$(this).fadeOut(function() { $(this).fadeIn(); });
				},
				targetKeep	: true,
				path:'../resources/images/img/',
				score		: '<c:out value="${member.rating}"/>',
				cancel: true
			});
			</script>






	<div class="user-contacts all-box-shadow pad ">


		<div id="blogList"></div>
		<div id="blogListError"></div>


	</div>

	<div class="user-contacts all-box-shadow pad ">

		<div id="tabs" class="demo_message_container">

			<span class="jdash-head-title titles-info ">Contacts</span>

			<a class="tab0">All</a> <a class="tab1">First</a> <a class="tab2">Second</a>
			<a class="tab3">Others</a> <br />
			<br />

			<div class="tabs-0">

				<div class="demo_message" class="_blogMain  demo_message_container">

					<p>
						For Demonstration Only.<br /> Functionality to be available in
						subsequent Playpens

					</p>

				</div>

				<ul class="contact-list">
					<li class="member">
						<!--  <div class="grey-out">
                    <c:url var="imageUrl_profile2" value="/resources/images/user/2my-photor.png" />
                        <div class="white-in contact-pic" style="background:url(${imageUrl_profile2});" ><a href="#" rel="tipsy" title="Jason (Physics)"></a></div>
                      </div> --> <c:url var="imageUrl_profile3"
							value="/resources/images/user/2my-photo.png" />
						<div class="white-in contact-pichome"
							style="background:url(${imageUrl_profile3});">
							<a href="#" rel="tipsy" title="Jason (Physics)"></a>
						</div>
					</li>
					<li class="member _bgmain">
						<!--<div class="grey-out _bgmain">
                      <c:url var="imageUrl_profile4" value="/resources/images/user/1my-photor.png" />
                        <div class="white-in contact-pic _bgmain" style="background:url(${imageUrl_profile4});"><a href="#" rel="tipsy" title="John (Electronics)"></a></div>
                      </div> --> <c:url var="imageUrl_profile5"
							value="/resources/images/user/1my-photo.png" />
						<div class="white-in contact-pichome _bgmain"
							style="background:url(${imageUrl_profile5});">
							<a href="#" rel="tipsy" title="John (Electronics)"></a>
						</div>
					</li>
					<li class="member _bgmain">
						<!--<div class="grey-out _bgmain">
                      <c:url var="imageUrl_profile6" value="/resources/images/user/3my-photo.png" />
                        <div class="white-in contact-pichome _bgmain" style="background:url(${imageUrl_profile6});"><a href="#" rel="tipsy" title="Linda (Robotics)"></a></div>
                      </div>--> <c:url var="imageUrl_profile7"
							value="/resources/images/user/3my-photo.png" />
						<div class="white-in contact-pichome _bgmain"
							style="background:url(${imageUrl_profile7});">
							<a href="#" rel="tipsy" title="Linda (Robotics)"></a>
						</div>
					</li>
					<li class="member _bgmain">
						<!--<div class="grey-out _bgmain">
                      <c:url var="imageUrl_profile8" value="/resources/images/user/2my-photo.png" />
                        <div class="white-in contact-pichome _bgmain" style="background:url(${imageUrl_profile8});"><a href="#" rel="tipsy" title="Jackie (Robotics)"></a></div>
                      </div>--> <c:url var="imageUrl_profile9"
							value="/resources/images/user/2my-photo.png" />
						<div class="white-in contact-pichome _bgmain"
							style="background:url(${imageUrl_profile9});">
							<a href="#" rel="tipsy" title="Jackie (Robotics)"></a>
						</div>
					</li>
					<li class="member _bgmain">
						<!-- <div class="grey-out _bgmain">
                     <c:url var="imageUrl_profile10" value="/resources/images/user/1my-photo.png" />
                        <div class="white-in contact-pichome _bgmain" style="background:url(${imageUrl_profile10});"><a href="#" rel="tipsy" title="Rose (Mathematics)"></a></div>
                      </div>--> <c:url var="imageUrl_profile11"
							value="/resources/images/user/1my-photo.png" />
						<div class="white-in contact-pichome _bgmain"
							style="background:url(${imageUrl_profile11});">
							<a href="#" rel="tipsy" title="Rose (Mathematics)"></a>
						</div>
					</li>
				</ul>

				<a href="" class="Block"><span class="f-r text-pading-top">People
						Search</span> <strong class="in-search zicons ls f-r"></strong></a>
			</div>
			<c:url var="imageUrl_profile12"
				value="/resources/images/background-pattern.jpg" />
			<div class="tabs-1"
				style="background-image:url(${imageUrl_profile12});">
				<ul class="contact-list">
					<!--<li class="member">
                      <div class="grey-out">-->
					<c:url var="imageUrl_profile13"
						value="/resources/images/user/2my-photo.png" />
					<div class="white-in contact-pichome"
						style="background:url(${imageUrl_profile13});">
						<a href="#" rel="tipsy" title="Jason (Physics)"></a>
					</div>
					<!--    </div>
                    </li> -->
				</ul>
			</div>

			<c:url var="imageUrl_profile14"
				value="/resources/images/background-pattern.jpg" />

			<div class="tabs-2"
				style="background-image:url(${imageUrl_profile14});">
				<ul class="contact-list">
					<li class="member">
						<!-- <div class="grey-out">
                     <c:url var="imageUrl_profile15" value="/resources/images/user/3my-photo.png" />
                        <div class="white-in contact-pichome" style="background:url(${imageUrl_profile15});" ><a href="#"></a></div>
                      </div>--> <c:url var="imageUrl_profile16"
							value="/resources/images/user/3my-photo.png" />
						<div class="white-in contact-pichome"
							style="background:url(${imageUrl_profile16});">
							<a href="#" rel="tipsy" title="Linda (Robotics)"></a>
						</div>
					</li>
				</ul>
			</div>

			<div class="tabs-3">

				<ul class="contact-list">

					<li class="member _bgmain">
						<!-- <div class="grey-out _bgmain">
                     <c:url var="imageUrl_profile17" value="/resources/images/user/1my-photo.png" />
                        <div class="white-in contact-pichome _bgmain" style="background:url(${imageUrl_profile17});"><a href="#"></a></div>
                      </div> --> <c:url var="imageUrl_profile18"
							value="/resources/images/user/1my-photo.png" />
						<div class="white-in contact-pichome _bgmain"
							style="background:url(${imageUrl_profile18});">
							<a href="#" rel="tipsy" title="John (Electronics)"></a>
						</div>
					</li>
					<li class="member _bgmain">
						<!--<div class="grey-out _bgmain ">
                      <c:url var="imageUrl_profile19" value="/resources/images/user/3my-photo.png" />
                        <div class="white-in contact-pichome _bgmain" style="background:url(${imageUrl_profile19});"><a href="#"></a></div>
                      </div> --> <c:url var="imageUrl_profile20"
							value="/resources/images/user/3my-photo.png" />
						<div class="white-in contact-pichome _bgmain"
							style="background:url(${imageUrl_profile20});">
							<a href="#" rel="tipsy" title="Linda (Robotics)"></a>
						</div>
					</li>
				</ul>
				<br />

			</div>

			<p class="txt-r _bgmain" style="padding-right: 10px; clear: both;">

			</p>
		</div>
	</div>

	<!-- unanswered script -->
	<c:url var="knowmwpopup" value="/secure/getknowmepopupwindow" />

	<c:url var="showUnAnswered" value="/secure/getunansweredquestions" />
	<script type="text/javascript">

  setInterval(function() {
	  

	}, 5000);
  get_and_UnAnswered_questions();
 
  function get_and_UnAnswered_questions(){
  currentQuestion = 0;
$(document).ready(function() {
	
	
	$.ajax({
		  	type: 'GET',
			url: '${showUnAnswered}',
			dataType: 'xml',
			success: function( data ) {
					
					var output="";
					 questionArray= new Array();
					 questionIdArray = new Array();
					 optionArray = new Array();
					 optionIndexArray = new Array();
					
					$(data).find("Questions").each(function(index){
						
						
						 questionArray.push($(this).find("Question").text()); 
						
						questionIdArray.push($(this).find("questiobankid").text());
						
						var options = "";
						var option_index= "";
						
				 		$(this).find("options").each(function(){
				 			
				 			
				 			$(this).find("option").each(function(){
				 				
				 				options +=  $(this).text()+"/";
				 				option_index += $(this).attr('index')+"/";
				 				
				 				
				 			});
				 			options = options.substring(0,options.length-1);
				 			option_index = option_index.substring(0,option_index.length-1);
				 			optionArray.push(options);
				 			optionIndexArray.push(option_index);	
				 			
				 		});
				 		
					
					});
					
					
					displayUnAnsweredPairs(0);		
					
			}
	
	});
	
});

  }
function displayUnAnsweredPairs(current){
	var outputResult="";
	outputResult+="<span class='jdash-head-title titles-info t_toggler t_up' >Know me better</span>";
	if(questionIdArray[current] == null){
		outputResult+="No New Questions";
	}else{
	outputResult+="<div class='t_content'>";
	outputResult+="<div id='question_info_message'style='font-family:verdana; '></div>";
	outputResult+="<div id='quest'style='font-weight:lighter; clear:both;display:inline; text-decoration:none; margin-left:10px; cursor:pointer;color:grey;'>";
	outputResult+="<input type='hidden' id='cur-qus-id' value='"+questionIdArray[current]+"'/><label id='cur-qus-value'>"+questionArray[current]+"</label>";
	outputResult+="<table class='sortable' width='180px' height='30px' >";

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
			outputResult+= "<tr><td style='font-weight:lighter; clear:both;display:inline; text-decoration:none; margin-left:10px; cursor:pointer;color:grey;'><input type='radio'  checked  id='checked-val'  name='question_" + questionIdArray[current] +"' value='"+optionsIdList1[i]+"--"+optionsList1[i]+"'>" + optionsList1[i] + "</td></tr>";
			} else {
			outputResult+= "<tr><td style='font-weight:lighter; clear:both;display:inline; text-decoration:none; margin-left:10px; cursor:pointer;color:grey;'><input type='radio'  id='checked-val'  name='question_" + questionIdArray[current] +"' value='"+optionsIdList1[i]+"--"+optionsList1[i]+"'>" + optionsList1[i] + "</td></tr>";	
			}
		}	 
	
	outputResult+="</table>";
	outputResult+="<br/>";
	
	

		outputResult+="<button class='btn' id='knowme-save' onClick='submitValue()'>Submit</button>";
	
	  
	  
	  // outputResult+="<div class='txt-r' ><a class='text-size-px11  lbx-70-50' href='${knowmwpopup}' class='Block' style='color: #27b;'>More..</a></div>";
	
		 
	 outputResult+="</div>";
	
	}
	  outputResult+="<div class='txt-r' ><a class='text-size-px11  lbx-70-50' href='${knowmwpopup}' class='Block'><span class='f-r text-pading-top moreclass text-pading-right'>More</span></a></div>";
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
	question_id = $('#cur-qus-id').val();
	var testQuestionValue = $('#cur-qus-value').text();
	question_answer = $('input[name="question_'+question_id+'"]:checked').val();
	
	
	
	
	var answerid_answer_pair = new Array();
	answerid_answer_pair = question_answer.split("--");
	questionBankAnswerId = answerid_answer_pair[0];
	memberAnswer = answerid_answer_pair[1];

		   
		       $.post( '<c:url value='/secure/saveknowme'/>'
				        , {'memberAnswer':memberAnswer,'testQuestionValue':testQuestionValue,'testQuestionId':question_id,'questionBankAnswerId':questionBankAnswerId}
				        , function(data)
				        {
				        
							
							$('#question_info_message').html("Answer Submitted Successfully");
							$("#knowme-save").attr('disabled','true');
							setTimeout('get_and_UnAnswered_questions()',2000);
							
				        }
						);   
		  
		    
		
  }
</script>

	<div id="knowme-ques"
		class="user-insight user-contacts all-box-shadow pad">

	
	</div>

	<label ></label>
	<!-- recommendation zeni -->

	<c:url var="showRecomendUrl" value="/secure/getmapperrecomendations" />
	  <script type="text/javascript">
$(document).ready(function() {
	$.ajax({
		  	type: 'GET',
			url: '${showRecomendUrl}',
			dataType: 'xml',
			success: function( data ) {
					
					var output="";
					
					
					$(data).find("recommenditem").each(function(index){
						
						output+="<ol>";
	                    output+="<li class='p-p _blogs bckground-blue-light todotip_container'>";
	                    output+="<b >"+ $(this).find("title").text()+"</b>";
	                    output+="<br/>";
	                    output+="<div  style='display:inline;' style='padding-left: 10px;'>"+ $(this).find("description").text()+"</div><div class='recommendtip'>"+$(this).find("description").text()+" </div>";
	                    output+="</li></ol>";
												
					});

					
				
					
					$('#recomend').html(output);
					
			}
	});
	
});
</script>
 

	<div class="user-contacts all-box-shadow pad">

		<div id="tabsbottom"
			style="background-color: #FFF; margin-bottom: 15px;">
			<span class="jdash-head-title titles-info t_toggler t_up" >Zeni
				Recommendations</span>
			<div class="t_content">

			<div id="recomend" class="rec-0 " style='font-family:arial,sans-serif;color:gray;'> </div>



			<p class="txt-r _bgmain" style="padding-right: 10px; clear: both;">
				<c:url var="htmlUrl_profile2" value="/secure/zrecommendpopup" />
				<span><a class="text-size-px11  lbx-70-50 moreclass" href="${htmlUrl_profile2}" >More</a></span>
			</p>
			</div>
		</div>
	</div>
</div>
</body>