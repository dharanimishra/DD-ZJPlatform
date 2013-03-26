<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:url var="showPollUrl" value="/zpolls/showpoll" />

<c:url var="jsJqueryFormUrl" value="../resources/js/jquery.form.js" /> 
<script type="text/javascript" src="${jsJqueryFormUrl}"></script>
<%@ page session="true"%>

<c:url var="showpoll" value="/zpolls/getpollpopuppage" />          
       
 <style>
 .moreclass
 {
 font-size:12px;
 color:#27B;
 }
.pollOptionBG {
	background: #ffffff;
	padding: 1px;
	margin-top: 2px;
	margin-bottom: 2px;
	border-top:1px solid #eeeeee;
	border-bottom:1px solid #eeeeee; 
</style> 

<script type="text/javascript">


$('.t_toggler').on('click',function(){
		$(this).toggle(
			function(){
				toggle_handle = $(this);
				toggle_handle.addClass('t_down').removeClass('t_up');
				toggle_handle.next('.t_content').slideUp();
			},
			function(){
				toggle_handle = $(this);
				toggle_handle.addClass('t_up').removeClass('t_down');
				toggle_handle.next('.t_content').slideDown();
			}
		).click();
	});

</script>
<style>
.t_up:hover {
  background: url("/ziksana-web/resources/images/downtoggle.png") no-repeat scroll right 10px rgba(218, 216, 216, 0.17) !important;
}
.t_down:hover {
  background: url("/ziksana-web/resources/images/uptoggle.png") no-repeat scroll right 10px rgba(218, 216, 216, 0.17) !important;
}

	
.jdash-head-title {
	font-size:18px;
	font-family:signika;  
	cursor: auto;
	color: #666;
}
.jdash-head-title:hover { color: #ccc; }
.jdash-head-title:hover span.sub-title { color: #666666; }

	
body
{
font-family:verdana;

}	
	
	
</style>

<script type="text/javascript">

$(document).ready(function() {
	get_poll_Questions();
});
	function get_poll_Questions(){
		$.ajax({
		  	type: 'GET',
			url: '${showPollUrl}',
			dataType: 'xml',
			success: function( data ) {
					
					var output="";
					var firstpollid="";
					var lastpollid="";
					output+="<span class='jdash-head-title  titles-info  t_toggler t_up' >Poll</span>";
					 output+="<div class='t_content'>";
					 $(data).find("pollquestionresult").each(function(){
							if($(this).find("pollQuestionSize").text()==0){
								output+="No new Questions";
							}
					$(data).find("questionresultpair").each(function(index)  {
						
						   // alert('poll results');
						 	var question = "<p style='font-weight:lighter; clear:both;display:inline; text-decoration:none; margin-left:0px; cursor:pointer;color:grey;'>" + $(this).find("pollQuestion").find("questionText").text() + "</p><br/>";
						 	var currentId = $(this).find("pollQuestion").find("id").text();
						 	//alert('current id is '+currentId)
							if ($(this).find("pollQuestion").find("active").text() == "true"){
						 		output+="<div id='q" + index + "' style='width: 225px;' class='pollquestion'>";
						 		output+=question;
						 		//output+="<form id='" + $(this).find("pollQuestion").find("id").text() + "' action=''>";
						 		output+="<input type='hidden' id='pollId"+index+"' name='pollId"+index+"' value='" + $(this).find("pollQuestion").find("id").text() + "'>";
						 		
						 		
						 		var answers="";
						 		$(this).find("pollQuestion").find("option").each(function(answerindex){
						 			
						 			if (answerindex == 0){
						 				answers+= "<input type='radio' name='radiobtn" + currentId + "' value='" + $(this).attr("index") + "' checked>" + "<label style='font-weight:lighter; clear:both;display:inline; text-decoration:none; margin-left:10px; cursor:pointer;color:grey;' for='" + answerindex + "'>&nbsp;" + $(this).text() + "</label><br/>";
						 				output+="<input type='hidden' id='optionIndex' name='optionIndex' value='" + $(this).attr("index") + "'>";
						 			}else{
						 				answers+= "<input type='radio' name='radiobtn" + currentId + "' value='" + $(this).attr("index") + "'>" + "<label style='font-weight:lighter; clear:both;display:inline; text-decoration:none; margin-left:10px; cursor:pointer;color:grey;' for='" + answerindex + "'>&nbsp;" + $(this).text() + "</label><br/>";
						 			}	
						 		
						 		});
						 		
						 		output+=answers;
						 		
						 		output+="<br/><button id='submit_poll" + index + "' onClick='submitPole(" + index + ")' style=' float: left;' class='votebtn btn'>Vote</button></p>";
						 		//output+="<div id='result" + index + "' class=' '><button  class='btnprev f-rt btn-info-poll' id='"+ index + "' >&larr; Prev</button></div>";
						 		if (index != ($(data).find("questionresultpair").size()-1)){
						 		output+="<div id='result" + index + "' class=' '><button  id='"+ index + "' style='float:right;' class='btnnext nextbutton_vote btn'>Next &rarr;</button><br/></div>";
						 		}else{
						 		//output+="<div id='result" + index + "' class=' '><button  class='btnprev f-rt btn-info-poll' id='"+ index + "' >&larr; Prev</button></div>";
						 		}
						 		//output+="</form><br/>";
						 		output+="<br/>";
							} else {
								output+="<div id='q" + index + "' style='width: 225px;' class='pollquestion' expired='true'>";
								output+=question;
							}
							
							var result="";
							
							//alert('voted');
							//alert($(this).find("pollQuestion").find("active").text());
					        //result+="<p><b></b> &nbsp; <div style='background-color: #09F; height: 20px; width: "+ $(this).find("pollResult").find("answer1count").text + "%;'></div>&nbsp;<b>"+ $(this).find("pollResult").find("answer1count").text;
					        output+="<div id='result_bar' class='pollresultbar'> </div>";
							
							if (index == 0){
								firstpollid = $(this).find("pollQuestion").find("id").text();
								output+="<div  id='result" + index + "' class='pollresult'>"+result+"<button id='" + index + "' onclick='buttonPrevious()' style='margin-left:159px;width:78px;' class='btnnext btn'>Next &rarr;</button></div></div>";
					 		} else {
					 			if (index == ($(data).find("questionresultpair").size()-1)){
//									console.log("Entering last one questionresultpair");
									lastpollid = $(this).find("pollQuestion").find("id").text();
									output+="<br/><div style='width:35px; margin-top:10px;' id='result" + index + "' class='pollresult'>"+result+"<button  style='float:left;width:78px;' onclick='buttonPrevious()' class='btnprev btn' id='"+ index +"' >&larr; Prev</button></div></div>";
								}
								else {
						 			output+="<div  style='margin-top:10px;' id='result" + index + "' class='pollresult '>"+result+"<button onclick='buttonPrevious()' id='"+ index + "' style='float:right;width:78px;' class='btnnext btn'>Next &rarr;</button><button  style='width:78px;margin-top:0px;' class='btnprev btn' id='"+ index + "' >&larr; Prev</button></div></div>";
						 		};
					 		}

							//console.log("poll output string" + output);
					});
					
					output+="<div><a class='text-size-px11  lbx-70-50 moreclass' href='${showpoll}' style='color: #27b;margin-left:200px;'>More</a></span></div></div>";
					
					$('#poll_placeholder').html(output);
					
					$(data).find("questionresultpair").each(function(index){
						if ($(this).find("pollQuestion").find("active").text() == "true"){
							$("form#" + $(this).find("pollQuestion").find("id").text()).ajaxForm();
							console.log("ajaxForm set " + $(this).find("pollQuestion").find("id").text());
						}
					});
					
					//to view the very first poll when page loads
			        //hide all result first
			        $("div.pollresult").hide();
			        $("div.pollquestion").hide();
			        
			        //show the first poll question
			        $("div#q0").show();
			        
			        $('input[type=radio]').click( function(event){
			        	//alert('test alert')
			        	//console.log("radio button clicked " + $(this).attr('name'));
              			
              			$(this).parent().children("input#optionIndex").attr("value", $(this).attr("value"));
              			console.log("hidden input#optionIndex value " + $(this).parent().children("input#optionIndex").attr("value"));
              		});
					
					//associate click event to all vote button
					$("button.votebtn").click( function(event){
              			$(this).attr("disabled", "disabled");
              			//alert('voted boss')
              			$("div#result" + event.target.id).fadeIn("slow");
              		});
					
					//associate click event to all next buttons
					$("button.btnnext").click( function(event){
						$("div#q" + event.target.id).hide();
              			$("div#q" + (parseInt(event.target.id)+1)).show();

              			if($("div#q" + (parseInt(event.target.id)+1)).attr("expired")){
              				$("div#result" + (parseInt(event.target.id)+1)).show();
              			}
              		});
					
					//associate click event to all previous buttons
					$("button.btnprev").click( function(event){
						$("div#q" + event.target.id).hide();
						$("div#q" + (parseInt(event.target.id)-1)).show();

						if($("div#q" + (parseInt(event.target.id)-1)).attr("expired")){
              				$("div#result" + (parseInt(event.target.id)-1)).show();
              			}
              		});


					 });
		}
			
	});	

}

</script>

<c:url var="showCourseUrl" value="/zcourse/educatorcourses" />



<c:if test="${member.roleType eq 'EDUCATOR'}">

<script type="text/javascript">

$(document).ready(function() {
	$.ajax({
		  	type: 'GET',
			url: '${showCourseUrl}',
			dataType: 'xml',
			success: function( data ) {
					
					//alert('entering');
					var draftcourse="";
					//alert('yes');
					 drafted_courses_length = $(data).find("draftedcourses").find("course").length;
	                   if(drafted_courses_length >= 1){
					$(data).find("draftedcourses").find("course").each(function(index){
						
						var progress =  $(this).find("progress").text()+"%";
						
					    console.log("Yes I am in");  
					    draftcourse+="<p class='blok-title-L'><a href='/ziksana-web/zcourse/createcourse/courseid_"+$(this).attr('id')+"'>" +  " " +short_mycourse_title( $(this).find("title").text() )+ "</a></p>";
					          
							draftcourse+="";
							draftcourse+="<div aria-valuenow='30' aria-valuemax='100' aria-valuemin='0' role='progressbar' id='progressbar30' style='width:100px;border:1px solid gray;' class='f-l ui-progressbar ui-widget ui-widget-content ui-corner-all'>";
							draftcourse+="<div style='width: " + progress + ";' class='ui-progressbar-value ui-widget-header ui-corner-left'></div>";
							draftcourse+="</div><span class='light-blue'>&nbsp;&nbsp;" + progress + " complete</span>";
						
					    
					    console.log("it is written"); 
					});
						draftcourse+='<a class="moreclass" style="float:right; margin: 1em;" href="/ziksana-web/zcourse/myprogramsdraft">More</a><div class="clear"></div>';
	                   }
					
					var reviewcourse='';
					 reviewed_courses_length = $(data).find("reviewedcourses").find("course").length;
	                   if(reviewed_courses_length >= 1){
                   $(data).find("reviewedcourses").find("course").each(function(index){
                	   var progress =  $(this).find("progress").text()+"%";
					    console.log("Yes I am in");  
					    reviewcourse+="<p class='blok-title-L'><a href='#'>" +  " " + $(this).find("title").text() + "</a></p>";
					    reviewcourse+="<p></p>";
					    reviewcourse+="<div aria-valuenow='30' aria-valuemax='100' aria-valuemin='0' role='progressbar' id='progressbar30' style='width:100px;border:1px solid gray;' class='f-l ui-progressbar ui-widget ui-widget-content ui-corner-all'>";
					    reviewcourse+="</div><span class='light-blue'>&nbsp;&nbsp;" + progress + " complete</span><p></p><p>&nbsp; </p>";
						
					    
					    console.log("it is written"); 
					});
	               
                   		
	                   }
	                   
                   var activecourse='';
                   
                   active_courses_length = $(data).find("activecourses").find("course").length;
                   if(active_courses_length >= 1){
                   $(data).find("activecourses").find("course").each(function(index){
                	   var progress =  $(this).find("progress").text()+"%";
					    console.log("Yes I am in");  
					    activecourse+="<p class='blok-title-L'><a href='#'>" +  " " + $(this).find("title").text() + "</a></p>";
					    
					    activecourse+="<p></p>";
					    activecourse+="<div aria-valuenow='30' aria-valuemax='100' aria-valuemin='0' role='progressbar' id='progressbar30' style='width:100px;border:1px solid gray;' class='f-l ui-progressbar ui-widget ui-widget-content ui-corner-all'>";
					    activecourse+="</div><span class='light-blue'>&nbsp;&nbsp;" + progress + " complete</span><p></p><p>&nbsp; </p>";
						
					    console.log("it is written"); 
					});
                  
                   }
					
				
					$('#draft_placeholder').html( draftcourse);
					$('#active_placeholder').html( activecourse);
					$('#review_placeholder').html( reviewcourse);
			}
	});
	
});
function short_mycourse_title(value){
	if(value.length > 31){
		return value.substring(0,31)+'...';
	} else {
		return value;
	}	
}
</script>

</c:if>
<c:if test="${member.roleType =='LEARNER'}">
<c:url var="showLearner" value="/zcourse/learnercourses" />
<script type="text/javascript">
$(document).ready(function() {
	$.ajax({
		  	type: 'GET',
			url: '${showLearner}',
			dataType: 'xml',
			success: function( data ) {
					
					var learnercourse="";
					
					
					$(data).find("learnercourses").find("course").each(function(index){
						
						
						
					    console.log("Yes I am in");  
					    learnercourse+="<p class='blok-title-L'><a href='/ziksana-web/zcourse/course/"+$(this).attr('id')+"'>" +  " " + $(this).find("title").text() + "</a></p>";
					
						
					    
					    	console.log("it is written"); 
					});
					
					learnercourse+='<a class="moreclass" style="float:right; margin: 1em;" href="/ziksana-web/zcourse/myprogramsdraft">More</a><div class="clear"></div>';
					$('#learner_placeholder').html(learnercourse);
			}
	});
	
});
</script>		
</c:if>

 <c:url var="showAnnouncementUrl" value="/zannouncements/getannouncements" />
 <c:url var="getannouncementbyid" value="/zannouncements/showannouncementbyid/" />
  <script type="text/javascript">
$(document).ready(function() {
	$.ajax({
		  	type: 'GET',
			url: '${showAnnouncementUrl}',
			dataType: 'xml',
			success: function( data ) {
					
					var output="";
					
					$(data).find("announcementsList").each(function(){
						if($(this).find("announcementSize").text()==0){
							output+="No Announcement Display";
						}
						
					$(data).find("announcements").each(function(index){
						
	                    output+="<ol>";
	                    output+="<li class='p-p _blogs bckground-blue-light'>";
	                    output+="<input type='hidden' name='announcementId' value='"+$(this).find("announcementid").text()+"'/>";
	                    output+="<div class='todotip_container' > <a class='text-size-px13  lbx-70-50' href='${getannouncementbyid}"+$(this).find("announcementid").text()+"'>"+short_string( $(this).find("message").text())+"</a><div class='announcementtip'style='font-family:verdana;'>"+$(this).find("message").text()+" </div></div>";
						 output+="<div style='font-family:arial,sans-serif;color:gray;padding-left: 5px;'>"+$(this).find("announcementDate").text()+"</div>";
	                    output+="<br/>";
	                    output+="</li></ol>";
						
	                 
												
					});
					});
					
				
					
					$('#announcement').html(output);
				
					
					 
					
			}
	});
	//alert($('#roleType').val());

	
	
}); // end of doc ready

/// TODO: move this function to a common js file later
function short_string(string){
	
	if(string.length > 50){
		return string.substring(0,50)+'...';
	} else {
		return string;
	}	
} 

</script>
<body> 
               <div class="col-right" >
               
				
                  <div class="col-right-container for-rounded-box all-box-shadow">
                  <c:if test="${member.roleType eq 'EDUCATOR'}">
                  	<div class="Performance">   
                        <span class="jdash-head-title titles-info  t_toggler t_up" >My Courses (Draft)</span>
                       <div class="t_content"> 
       						<div id="draft_placeholder"></div>
				        <p class="titles-info jdash-head-title">My Courses (Review)<br></p>
                            <div id="active_placeholder"></div>
                        <p class="titles-info jdash-head-title">My Courses (Active)<br></p>
                            <div id="review_placeholder"></div>
                    </div>
                    </div>
                     </c:if>
                  <c:if test="${member.roleType eq 'LEARNER'}">
                   <div class="Performance">   
                        <p class="jdash-head-title titles-info t_toggler t_up">My Courses<br></p>
                        <div class="t_content">
       						<div id="learner_placeholder"></div>
       					</div>
       				</div>
       			
                 </c:if>
                  </div>
                 
                  
                 
                  <div class=" col-right-container for-rounded-box all-box-shadow demo_message_container" >
                   <div class="demo_message">
					    <p>
					            For Demonstration Only.<br /> Functionality to be available in subsequent Playpens
					            
					            </p>
					
					</div>
					<c:if test="${member.roleType eq 'EDUCATOR'}">
                  
                  	<div class="Performance">
                  	
               
                      <p class="jdash-head-title  titles-info">My Students <br></p>
                     <c:url var="imageUrl_report1" value="/resources/images/e-dash-chart1.png" />
                        <img width="220" height="185" alt="Grade" src="${imageUrl_report1}">                 

                 </div>
                 </c:if>
                 <c:if test="${member.roleType eq 'LEARNER'}">
                  
                  	<div class="Performance">
                  	
               
                      <p class="jdash-head-title  titles-info">My Performance<br></p>
                     <c:url var="imageUrl_report1" value="/resources/images/e-dash-chart1.png" />
                        <img width="220" height="185" alt="Grade" src="${imageUrl_report1}">                 

                 </div>
                 </c:if>
                 <br/>
                 <div class="txt-r">
                <button class="btn">Grade</button> <button class="btn">Facilitate</button>
                </div>
                  </div>
                  
                  <!-- poll system -->
                  
                   <div class="col-right-container for-rounded-box all-box-shadow">
                   <div class='t_content'>
                  		<div id="poll_placeholder"></div>
            			
            
                   </div>
                  </div>
                  <div class="col-right-container for-rounded-box all-box-shadow">
    <div id="tabsbottom" style="background-color:#FFF; margin-bottom:15px;">
           <span class="jdash-head-title titles-info t_toggler t_up" >Announcements</span>
           <div class="t_content">	                           
			           
            	                           
            <div id= "announcement" class="rec-0 ">
              
            </div>
            
          			          
      
          <p class="txt-r _bgmain" style="padding-right:10px; clear:both;">
          <c:url var="showannounpopup" value="/zannouncements/showannouncementpopup" />
            <span><a class="text-size-px11  lbx-70-50 moreclass" href="${showannounpopup}">More</a></span>
          </p>
        </div>
        </div>             


<script type="text/javascript">
 function submitPole(indexVal)
 {
	 
	 //alert(pollid);
	 
	 
	 pollid = $('#pollId'+indexVal+'').val();	
	 optionindex = $('#optionIndex').val();
	  $.post( '<c:url value='/zpolls/submitpoll/'/>'
		 		 , {'pollId':pollid,'optionIndex':optionindex}
		 		 , function( data )
		  			{
		 			console.log( 'Poll data from AJAX:', $(data).text());
		 			
		 			var output_poll = "";
                    
		 			$(data).find("questionresultpair").each(function(index)  
		 					{
		 				output_poll+="<div id='bar_results_value'>";
						output_poll+="<p class='font-Signika text-size-px18 light-gray'>Poll Result:</p>";
		 				var colorNames = new Array("Turquoise", "SpringGreen", "Salmon", "RoyalBlue","Crimson");
		 					 $(this).find("pollResult").find("option").each(function(index)
		 							
		 							 {
		 						output_poll+="<p  style='padding-left: 2px;padding-bottom: 10px;'>"+ $(this).find("optiontext").text()+"</p>"; 
		 					
		 						output_poll+="<p  style='padding-left: 2px;padding-bottom: 10px;'>"+ short_string_result($(this).find("percentage").text())+"% Votes</p>";
		 						
		 						output_poll+="<div style='width:"+ $(this).find("percentage").text()+ "%; height:20px; background-color:"+colorNames[index]+";'></div>"; 
		 						
		 						  
		 					});
		 					output_poll+="</div>"; 
		 				 	 //output+="<p  style='padding-left: 10px;'>"+ $(this).find("answer1count").text()+"</p>";
		 				 	 //alert(output);
		 					});
		 			$('div.pollresultbar').html(output_poll);
		 			$('div.pollresultbar').show();
		 			$('div.pollresult').show();
		 			
		 			 }
					 );     
	   
	  
	  document.getElementById("submit_poll"+indexVal).disabled=true;
	  $('.nextbutton_vote').hide();
	 $('#submit_poll'+indexVal+'').removeClass('btn-info-poll'); 
	 
	 function short_string_result(value){
			
				return value.substring(0,5);
			
		}
 }
 
 function buttonPrevious(){
	 //alert("Hello");
	 $('div.pollresultbar').hide();
	 
 }
 </script>
<!-- Feedzilla Widget BEGIN -->

<!-- <div class="feedzilla-news-widget feedzilla-6174072121341786" style="width:206px; padding: 0; text-align: center; font-size: 12px; border: 0;">
<script type="text/javascript" src="http://widgets.feedzilla.com/news/iframe/js/widget.js"></script>
<script type="text/javascript">
new FEEDZILLA.Widget({
	style: 'slide-top-to-bottom',
	culture_code: 'en_us',
	c: '30',
	sc: '-',
	headerTextColor: '#666666',
	contentLinkColor: '#297dc2',
	contentTextColor: '#666666',
	contentBackgroundColor: '#ffffff',
	title: 'News',
	order: 'relevance',
	count: '20',
	w: '217',
	h: '200',
	timestamp: 'true',
	scrollbar: 'false',
	theme: 'pepper-grinder',
	className: 'feedzilla-6174072121341786'
});
</script>

Feedzilla Widget END
                  
                  
                    <p class="titles-info">News<br></p>
                    <p class="p-p">ELearning Department - 'New tools added to Enrich Course Content.! - Striving towards excellence !
                     <br>02/25/2012 <br>
                     <br>ELearning Department -Ziksana releases Artificial Intelligence for UTD<br>
                      02/25/2012 <br>
                      
                      
                      
                      </p>
                    <div class="txt-r"><a href="#" class="text-size-px11">Read all</a></div>
                  </div>
                </div> -->
             
              </div>
              
              
             
</body>