<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="showPollUrl" value="/secure/showpoll/111111" />
<c:url var="submitPollUrl" value="/secure/submitpoll" />
<c:url var="jsJqueryFormUrl" value="../resources/js/jquery.form.js" /> 
<script type="text/javascript" src="${jsJqueryFormUrl}"></script>
<script type="text/javascript">
function showMask(masks)
{

$('#'+masks).show();
}
function hideMask(maskh)
{
$('#'+maskh).hide();
}
</script>
<script type="text/javascript">
 function submitPole(memberId)
 {
	 
	 pollid = $('#pollId').val();	
	 optionindex = $('#optionIndex').val();
	  $.post( '<c:url value='/secure/submitpoll'/>'
		 		 , {'pollId':pollid,'optionIndex':optionindex}
		 		 , function( data )
		  			{
		 			console.log( 'Poll data from AJAX:', $(data).text());
		 			
		 			var output = "";
                    
		 			$(data).find("questionresultpair").each(function(index)  
		 					{
		 					 $(this).find("pollResult").find("option").each(function(index)
		 							 {
		 						     output+="<p  style='padding-left: 10px;'>"+ $(this).find("optiontext").text()+"</p>";  
		 						    output+="<p  style='padding-left: 10px;'>"+ $(this).find("count").text()+"</p>";
		 							 });
		 					 
		 				 	 //output+="<p  style='padding-left: 10px;'>"+ $(this).find("answer1count").text()+"</p>";
		 				 	 //alert(output);
		 					});
		 			$('div.pollresult').html(output);
		 			$('div.pollresult').show();
		 			 }
					, 'xml' );     
	   
	
 }
 </script>
<script type="text/javascript">
$(document).ready(function() {
	$.ajax({
		  	type: 'GET',
			url: '${showPollUrl}',
			dataType: 'xml',
			success: function( data ) {
					if (console && console.log){
						//alert('writing to console');	
						//console.log( 'Poll sample of data:', $(data).text());
								
					}
					var output="";
					var firstpollid="";
					var lastpollid="";
					
					$(data).find("questionresultpair").each(function(index)  
							{
						
						   // alert('poll results');
						 	var question = "<p class='titles-info font-Signika text-size-px18 light-gray'>" + $(this).find("pollQuestion").find("questionText").text() + "</p>";
						 	var currentId = $(this).find("pollQuestion").find("id").text();
						 	//alert('current id is '+currentId)
							if ($(this).find("pollQuestion").find("active").text() == "true"){
						 		output+="<div id='q" + index + "' style='width: 225px;' class='pollquestion'>";
						 		output+=question;
						 		output+="<form id='" + $(this).find("pollQuestion").find("id").text() + "' action=''>";
						 		output+="<input type='hidden' id='pollId' name='pollId' value='" + $(this).find("pollQuestion").find("id").text() + "'>";
						 		
						 		
						 		var answers="";
						 		$(this).find("pollQuestion").find("option").each(function(answerindex){
						 			if (answerindex == 0){
						 				answers+= "<input type='radio' name='radiobtn" + currentId + "' value='" + $(this).attr("index") + "' checked>" + "<label for='" + answerindex + "'>&nbsp;" + $(this).text() + "</label><br/>";
						 				output+="<input type='hidden' id='optionIndex' name='optionIndex' value='" + $(this).attr("index") + "'>";
						 			}else{
						 				answers+= "<input type='radio' name='radiobtn" + currentId + "' value='" + $(this).attr("index") + "'>" + "<label for='" + answerindex + "'>&nbsp;" + $(this).text() + "</label><br/>";
						 			}						 				
						 		});
						 		
						 		output+=answers;
						 		output+="<br/><button id='" + index + "' onClick='submitPole(" + $(this).attr("memberId") + ")' style=' float: left;' class='votebtn'>Vote</button></p><br/>";
						 		output+="</form><br/>";
						 		output+="<br/>";
							} else {
								output+="<div id='q" + index + "' style='width: 225px;' class='pollquestion' expired='true'>";
								output+=question;
							}
							
							var result="";
							
							//alert('voted');
							//alert($(this).find("pollQuestion").find("active").text());
					        result+="<p><b></b> &nbsp; <div style='background-color: #09F; height: 20px; width: "+ $(this).find("pollResult").find("answer1count").text + "%;'></div>&nbsp;<b>"+ $(this).find("pollResult").find("answer1count").text;
							
							if (index == 0){
								firstpollid = $(this).find("pollQuestion").find("id").text();
								output+="<div id='result" + index + "' class='pollresult'>"+result+"<button id='" + index + "' style='margin-left:170px;' class='btnnext'>Next &rarr;</button></div></div>";
					 		} else {
					 			if (index == ($(data).find("questionresultpair").size()-1)){
//									console.log("Entering last one questionresultpair");
									lastpollid = $(this).find("pollQuestion").find("id").text();
									output+="<div id='result" + index + "' class='pollresult'>"+result+"<button class='btnprev' id='"+ index +"' >&larr; Prev</button></div></div>";
								}
								else {
						 			output+="<div id='result" + index + "' class='pollresult'>"+result+"<button  id='"+ index + "' style='float:right;' class='btnnext'>Next &rarr;</button><button  class='btnprev' id='"+ index + "' >&larr; Prev</button></div></div>";
						 		};
					 		}

							console.log("poll output string" + output);
					});
					
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

//					$("#btn_next5").click( function(){
//			        	alert("This will take you to the first question, as this is the last question..");
//			        	$("#q5").hide();
//			        	$("#q1").fadeIn();
//			        });
		}
	});	
});
</script>

<c:url var="showCourseUrl" value="/secure/showmycourse/111111" />

<script type="text/javascript">

$(document).ready(function() {
	$.ajax({
		  	type: 'GET',
			url: '${showCourseUrl}',
			dataType: 'xml',
			success: function( data ) {
					if (console && console.log){
								console.log( 'course data:', data);
					}
					var draftcourse="";
					var activecourse="";
					var reviewcourse="";
					
					$(data).find("draftedcourses").find("course").each(function(index){
						
						var progress =  $(this).find("progress").text()+"%";
						
					    console.log("Yes I am in");  
					    draftcourse+="<p class='blok-title-L'><a href='#'>" +  ": " + $(this).find("title").text() + "</a></p>";
					          
							draftcourse+="<p></p>";
							draftcourse+="<div aria-valuenow='30' aria-valuemax='100' aria-valuemin='0' role='progressbar' id='progressbar30' style='width:100px;border:1px solid gray;' class='f-l ui-progressbar ui-widget ui-widget-content ui-corner-all'>";
							draftcourse+="<div style='width: " + progress + ";' class='ui-progressbar-value ui-widget-header ui-corner-left'></div>";
							draftcourse+="</div><span class='light-blue'>&nbsp;&nbsp;" + progress + " complete</span><p></p><p>&nbsp; </p>";
						
					    
					    console.log("it is written"); 
					});
					
                   $(data).find("reviewedcourses").find("course").each(function(index){
                	   var progress =  $(this).find("progress").text()+"%";
					    console.log("Yes I am in");  
					    reviewcourse+="<p class='blok-title-L'><a href='#'>" +  ": " + $(this).find("title").text() + "</a></p>";
					    reviewcourse+="<p></p>";
					    reviewcourse+="<div aria-valuenow='30' aria-valuemax='100' aria-valuemin='0' role='progressbar' id='progressbar30' style='width:100px;border:1px solid gray;' class='f-l ui-progressbar ui-widget ui-widget-content ui-corner-all'>";
					    
					    
					    console.log("it is written"); 
					});
					
                   
                   $(data).find("activecourses").find("course").each(function(index){
                	   var progress =  $(this).find("progress").text()+"%";
					    console.log("Yes I am in");  
					    activecourse+="<p class='blok-title-L'><a href='#'>" +  ": " + $(this).find("title").text() + "</a></p>";
					    
					    activecourse+="<p></p>";
					    activecourse+="<div aria-valuenow='30' aria-valuemax='100' aria-valuemin='0' role='progressbar' id='progressbar30' style='width:100px;border:1px solid gray;' class='f-l ui-progressbar ui-widget ui-widget-content ui-corner-all'>";
					    
					    console.log("it is written"); 
					});
					
					
					
					
					console.log("draftcourse is: " + draftcourse);
					console.log("activecourse is: " + activecourse);
					console.log("reviewcourse is: " + reviewcourse);
					
					$('#draft_placeholder').html( draftcourse);
					$('#active_placeholder').html( activecourse);
					$('#review_placeholder').html( reviewcourse);
			}
	});
	
});
</script>

 <c:url var="showAnnouncementUrl" value="/secure/getannouncement" />
 <c:url var="getannouncementbyid" value="/secure/showannouncementbyid/" />
  <script type="text/javascript">
$(document).ready(function() {
	$.ajax({
		  	type: 'GET',
			url: '${showAnnouncementUrl}',
			dataType: 'xml',
			success: function( data ) {
					if (console && console.log){
								console.log( 'data:', data);
					}
					var output="";
					
					$(data).find("announcementsList").each(function(){
						if($(this).find("announcementSize").text()==0){
							output+="No Announcement Display";
						}
						
					$(data).find("announcements").each(function(index){
						
	                    output+="<ol>";
	                    output+="<li class='p-p _blogs bckground-blue-light'>";
	                    output+="<input type='hidden' name='announcementId' value='"+$(this).find("announcementid").text()+"'/>";
	                    output+="<div class='todotip_container' style='padding-left: 5px; '> <a class='text-size-px13  lbx-70-50' href='${getannouncementbyid}"+$(this).find("announcementid").text()+"'>"+short_string( $(this).find("message").text())+"</a><div class='announcementtip'>"+$(this).find("message").text()+" </div></div>";
						 output+="<div style='font-weight:bold'>"+ $(this).find("announcementDate").text()+"</div>";
	                    output+="<br/>";
	                    output+="</li></ol><br/>";
						
	                 
												
					});
					});
					console.log("Announcements: " + output);
				
					
					$('#announcement').html(output);
				
					
					 
					
			}
	});
	
});

/// TODO: move this function to a common js file later
function short_string(string){
	
	if(string.length > 50){
		return string.substring(0,50)+'...';
	} else {
		return string;
	}	
} 
</script>
 
               <div class="col-right" >
                  <div class="col-right-container for-rounded-box all-box-shadow">
                  	<div class="Performance">   
                        <p class="titles-info font-Signika text-size-px18 light-gray">My Courses (Draft)<br></p>
                        
       						<div id="draft_placeholder">
       						
       						</div>
       						<span style="color:#27b;margin-left:200px;"><a href="/ziksana-web/secure/showMyPrograms">More..</a></span>
				        <p class="titles-info font-Signika text-size-px18 light-gray">My Courses (Review)<br></p>
                            <div id="active_placeholder"></div>
                        <p class="titles-info font-Signika text-size-px18 light-gray">My Courses (Active)<br></p>
                            <div id="review_placeholder"></div>
                    </div>
                  </div>
                  
                  <div class=" col-right-container for-rounded-box all-box-shadow demo_message_container" >
                   <div class="demo_message">
					    <p>
					            For Demonstration Only.<br /> Functionality to be available in subsequent Playpens
					            
					            </p>
					
					</div>
                  
                  	<div class="Performance">
                      <p class="titles-info font-Signika text-size-px18 light-gray">My Students <br></p>
                     <c:url var="imageUrl_report1" value="/resources/images/e-dash-chart1.png" />
                        <img width="220" height="185" alt="Grade" src="${imageUrl_report1}">                 

                 </div>
                 <br/>
                 <div class="txt-r">
                <button class="btn">Grade</button> <button class="btn">Facilitate</button>
                </div>
                  </div>
                  
                  <!-- poll system -->
                  
                   <div class="col-right-container for-rounded-box all-box-shadow">
                  		<div id="poll_placeholder"></div>
            <c:url var="showpoll" value="/secure/getpollpopupwindow" />
           <div>
            <span><a class="text-size-px11  lbx-70-50" href="${showpoll}" class="" style="color: #27b;margin-left:200px;">More..</a></span>
            </div> 
                   </div>
                  
                  <div class="col-right-container for-rounded-box all-box-shadow">
    <div id="tabsbottom" style="background-color:#FFF; margin-bottom:15px;">
           <span class="titles-info font-Signika text-size-px18 light-gray">Announcements</span>
			           
            	                           
            <div id= "announcement" class="rec-0 ">
              
            </div>
            
          			          
      
          <p class="txt-r _bgmain" style="padding-right:10px; clear:both;">
          <c:url var="showannounpopup" value="/secure/showannouncementpopup" />
            <span><a class="text-size-px11  lbx-70-50" href="${showannounpopup}" class="" style="color: #27b;">More..</a></span>
          </p>
        </div>
        </div>             

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
