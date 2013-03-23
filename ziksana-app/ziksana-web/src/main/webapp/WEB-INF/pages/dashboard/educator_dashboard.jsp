
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- <script type="text/javascript" src="resources/js/tree/jquery-1.8.0.min.js"></script> -->

<!-- <link href="../resources/css/styles.css" rel="stylesheet" type="text/css"> -->

	<!-- <link href="../resources/css/type-setting.css" rel="stylesheet" type="text/css"> -->
	<link href="../resources/css/effects.css" rel="stylesheet" type="text/css">
	<link href="../resources/css/nav.css" rel="stylesheet" type="text/css">
	
	<link rel="stylesheet" type="text/css" href="../resources/css/dropdown.css" />
	<link rel="stylesheet" type="text/css" href="../resources/css/jquery.fancybox.2.1.3.css"/>
	<!-- <link rel="stylesheet" type="text/css" href="resources/css/masks.css" /> -->
	
    <link rel="stylesheet" type="text/css" href="../resources/css/tag/tagit-simple-blue.css">
    <link rel="stylesheet" href="../resources/css/tipsy.css" type="text/css" />
    
    <link rel="stylesheet" type="text/css" href="../resources/css/custom-theme/jquery-ui-1.8.21.custom.css">
     <link href="../resources/css/news/newsticker.css" rel="stylesheet" type="text/css" />
     <link href="../resources/css/tipsy.css" rel="stylesheet" type="text/css" />
     
   	
	 <script src="../resources/js/jquery-1.7.2.min.js"></script>
	 <script src="../resources/js/ui/jquery.ui.core.js"></script>
	 <script src="../resources/js/ui/jquery.ui.widget.js"></script>
	 <script src="../resources/js/ui/jquery.ui.button.js"></script>
	 <script src="../resources/js/ui/jquery.ui.progressbar.js"></script>
	 <script src="../resources/js/ui/jquery.ui.tabs.js"></script>
     <script src="../resources/js/jquery.hovercard.js"></script>
     <script src="../resources/js/jquery.fancybox.pack.2.1.3.js"></script>
     <script src="../resources/js/jquery.collapse.js"></script>
     <script src="../resources/js/todo.js" type="text/javascript"></script> 
     <script language="javascript" type="text/javascript" src="../resources/js/custom/Todoalertshovercard.js"></script>
	<script type="text/javascript" src="../resources/js/jquery-1.2.2.pack.js"></script>
	
	<script type="text/javascript" src="../resources/js/jquery.tipsy.js"></script>
	<script type="text/javascript" src="../resources/js/custom/z_common.js"></script>
	
<style>
.moreclass
 {
 font-size:12px;
 color:#27B;
 }
</style>
<c:url var="deleteAlertUrl" value="/ziksana-web/zalert/deletealert/" />
<script type="text/javascript">


function deleteFunction(val){
	
	
	confirm_delete_alert = confirm('Are you sure you want to delete this item?');
	if(confirm_delete_alert == true){
		
		
	
	$.ajax({
	  	type: 'DELETE',
		url: '${deleteAlertUrl}'+val,
		
		success: function( data ) {
			
			$('#alert_'+val).remove();
			get_and_populate_alerts();
			
			
		}
	});
	
	
	}
}
</script>



<c:url var="showEventUrl" value="/secure/showmycalendar/111111" />
<c:url var="eventImageUrl" value="resources/images/front-bg.gif" />
<script type="text/javascript">
$(document).ready(function() {
	$.ajax({
		  	type: 'GET',
			url: '${showEventUrl}',
			dataType: 'json',
			success: function( data ) {

					var output_left="";
					var output_right="";
					
					for (var i in data.events)
					{
						var event = data.events[i];
						output_left+="<div class='_upcoming' id='event" + i + "'>";
						output_left+="<div class='_uDate' id='event" + i + "'>";
						output_left+="<b id='event" + i + "'>" + event.sMonth + "</b><br/> <b id='event" + i + "'>" + event.day + "</b> ";
						output_left+="</div>";
						output_left+="<div class='_uevent' id='event" + i + "'>";
						output_left+=event.eventTitle;
						output_left+="</div></div>";

						output_right+="<div class='_eventdetail' id='event" + i + "'>";
						output_right+="<div style='margin-top:9px; padding-bottom: 9px; padding-left: 5px;'>";
						output_right+="<span class='bold text-size-px12 orange ehead'>" + event.eventSubject + "</span>";
						output_right+="</div>";
						if(event.eventDetail != null && event.eventDetail != ""){
							output_right+="<div >" + event.eventDetail + "</div>";
						}
						output_right+="<div ><i class='bold'>Place: </i>" + event.eventLocation;
						output_right+="<i class='bold'><br/>Time: </i>" + event.timePeriod + "</div>";
						if(event.contactNumber != null && event.contactNumber != ""){
							output_right+="<i class='bold'>Contact:</i> " + event.contactNumber + "</div>";
						}
						output_right+="</div>";
					}
//					console.log("output_left string: " + output_left);
//					console.log("output_right string: " + output_right);
					
					$('#event_left_placeholder').html(output_left);
					$('#event_right_placeholder').html(output_right);
					
					$('#event_left_placeholder').children('div:first-child').removeClass().addClass('_current');
					$('#event_left_placeholder').children('div:first-child').children('div:first-child').removeClass().addClass('_cDate');
					$('#event_left_placeholder').children('div:first-child').children('div:last-child').removeClass().addClass('_cevent');
					
					$('#event_right_placeholder').children('div:first-child').show();
					$('#event_right_placeholder').children('div:first-child').siblings().hide();
					
					$('#event_left_placeholder').children('div').click(function(event){
						$(this).css("background-image", " url(${eventImageUrl})");
						$(this).siblings().css("background-image", "");
						
						$('#event_right_placeholder').children('#' + event.target.id).show();
						$('#event_right_placeholder').children('#' + event.target.id).siblings().hide();
					});
					
					
			}
	});
	
});
$(document).ready(function() {

	var m_names = new Array("JAN", "FEB", "MAR", 
	"APR", "MAY", "JUNE", "JUL", "AUG", "SEP", 
	"OCT", "NOV", "DEC");

	var d = new Date();
	var curr_date = d.getDate();
	var curr_month = d.getMonth();
	var curr_year = d.getFullYear();
	var mondate=curr_date + "- " + m_names[curr_month] + "";
	$('.dmonth').html(mondate);

	});
</script>

 
 
  <c:url var="closeicon" value="/resources/images/icons/close-icon.png" />
 <c:url var="htmlUrl_alert" value="/zalert/alertpopuppage" />
 <c:url var="deleteTodoUrl" value="/ztodo/deletetodo/" />                          
                          
<c:url var="todoImageUrl" value="/resources/images/background-pattern.jpg" />
<c:url var="showAlertUrl" value="/zalert/getthreealerts" />

 <c:url var="htmlUrl_todo" value="/ztodo/gettodopopuppage" />
 <c:url var="todo" value="/resources/images/icons/todo.png" />
<c:url var="showTodoUrl" value="/ztodo/getthreetodo" />
 
<script type="text/javascript">
$(document).ready(function() {
	setInterval(function() {
		//get_and_populate_todo();
		get_and_populate_todo();
		get_and_populate_alerts();
 
	}, 1*30*1000);	
	
	get_and_populate_todo();
	get_and_populate_alerts();
});

function get_and_populate_alerts(){
	var images = new Array();
	images[0] = "<c:url  value='../resources/images/icons/urgent.png' />";
	images[1] = "<c:url  value='../resources/images/icons/warning.png' />";
	images[2] = "<c:url  value='../resources/images/icons/info.png' />";

	$.ajax({
	  	type: 'GET',
		url: '${showAlertUrl}',
		dataType: 'xml',
		success: function( data ) {
			
				var no_of_available_alerts;
				
				$.get('/ziksana-web/zalert/getalertsize', {}, function(size){
			
					no_of_available_alerts = size;
				
				
				
				
				
				var output="";
				var outputAlertEmpty="";
				outputAlertEmpty+="<div  class='alerts'>";
				outputAlertEmpty+="<span class='titles-info jdash-head-title''>Alerts</span>";
	
				outputAlertEmpty+="<b>No Alerts Found</b></div>";
				
				console.log('No of avaliable alerts: '+no_of_available_alerts);
				if(no_of_available_alerts == 0){$('#alerts_placeholder').html(outputAlertEmpty);} else{
					
					
				if(no_of_available_alerts > 3){
					
					//populate the three with more button.
					
					output+="<div  class='alerts'>";
					output+="<span class='titles-info jdash-head-title''>Alerts</span>";
					
					$(data).find("alertitem").each(function(index){
						
					
						
						output+="<div id='alert_"+$(this).find("id").text()+"' class='alertcontainer' style='border:1px solid #F5F5F5;' id='conalert3'>";
						output+="<div class='alertinfo' style='height:28px;padding:5px;'>";
						output+="<div class='alertinfo-icon' style='float:left;display:inline; margin-right:10px;'>";
						 
						output+="<a href='#' class='' rel='tipsy'  style='cursor:default;'> <img src='"+images[index]+"'  alt='INFO' /> </a></div>";
						output+="<div class='alertinfo-category todotip_container' style='display:inline;' >"+short_string_category($(this).find("category").text())+"<div class='categorytip'>"+$(this).find("category").text()+" </div></div>";
						
						output+="<div class='todotip_container' id='demo-basic"+$(this).find("id").text()+"' style='font-weight:lighter;clear:both;display:inline; margin-left:10px; cursor:pointer;color:grey;'>"+short_string($(this).find('description').text())+"</a><div class='todotip'>"+$(this).find("description").text()+" </div></div><a class='close-icon' rel='tipsy' title='Delete' href='#' onclick='deleteFunction("+$(this).find('id').text()+")' style='float:right;'  > <img src='${closeicon}' height='15' width='15' > </a></div>";
						
						output+="</div>";						
									
					});
					output+="</div>";
					output+="<div  style='height:30px; float:right;'> <a class='text-size-px11 moreclass alert_fancybox' href='${htmlUrl_alert}' >More</a></div>";
					$('#alerts_placeholder').html( output);
				} else {
					//populate the three without more button
					output+="<div  class='alerts'>";
					output+="<span class='titles-info jdash-head-title'>Alerts</span>";
	
					$(data).find("alertitem").each(function(index){
					output+="<div id='alert_"+$(this).find("id").text()+"' class='alertcontainer' style='border:1px solid #F5F5F5;' id='conalert3'>";
					output+="<div class='alertinfo' style='height:28px;padding:5px;'>";
					output+="<div class='alertinfo-icon' style='float:left;display:inline; margin-right:10px;'>";
					 
					output+="<a href='' rel='tipsy'  style='cursor:default;'  > <img src='"+images[index]+"'  alt='INFO' /> </a></div>";
					output+="<div class='alertinfo-category todotip_container' style='display:inline;' >"+short_string_category($(this).find("category").text())+"<div class='categorytip'>"+$(this).find("category").text()+" </div></div>";
					
					output+="<div class='todotip_container' id='demo-basic"+$(this).find("id").text()+"' style='font-weight:lighter;clear:both;display:inline; margin-left:10px; cursor:pointer;color:grey;'>"+short_string($(this).find('description').text())+"</a><div class='todotip'>"+$(this).find("description").text()+" </div></div><a class='' rel='tipsy' href='#' onclick='deleteFunction("+$(this).find('id').text()+")' style='float:right;'  title='Delete''> <img  src='${closeicon}' height='15' width='15'> </a></div>";
					
					output+="</div>";
					
						});
					output+="</div>";
					$('#alerts_placeholder').html(output);
				}
							

				
				}//end if not zero.
			

				
				}


				);
				

		}
});
	
}

function get_and_populate_todo(){
/* Todo	 */
$.ajax({
  	type: 'GET',
	url: '${showTodoUrl}',
	dataType: 'xml',
	success: function( data ) {
			
			var output_todo="";
			
			var indexValue = 0;
			
		
			var no_of_available_todo;
			
			$.get('/ziksana-web/ztodo/gettodosize', {}, function(size){ 
				no_of_available_todo = size;
			
				var ouputEmptyTodo="";
				ouputEmptyTodo+="<div  class='Todo's'>";
				ouputEmptyTodo+="<span class='titles-info jdash-head-title'>To-Dos</span>";
				ouputEmptyTodo+="<strong>No Todos Found</strong>";
				ouputEmptyTodo+="<div style='height:30px; text-align: right;'><a class='todo_fancybox text-size-px11 text-size-px11' href='${htmlUrl_todo}' >More</a><div>";
				ouputEmptyTodo+='</div>';
				
				if(no_of_available_todo == 0){$('#todos_placeholder').html(ouputEmptyTodo);} else{
					
					  
				  
							output_todo+="<div  class='Todo's'>";
						output_todo+="<span class='titles-info jdash-head-title'>To-Dos</span>";
						
						
					  $(data).find("todoitem").each(function(index){
							output_todo+="<div id='todoid"+$(this).find("id").text()+"' class='todocontainer' style='border:1px solid #F5F5F5;' id='contodo1'>";
							output_todo+="<div class='todoinfo' style='height:28px;padding:5px;'>";
							output_todo+="<div id='todo-row' class='todoinfo-icon' style='float:left;display:inline; margin-right:10px;'>";
							 
							output_todo+="<img src='${todo}' alt='Info' /></div>";
							output_todo+="<div class='todoinfo-category todotip_container' style='display:inline;' >"+short_string_category($(this).find("categoryName").text())+"<div class='categorytip'>"+$(this).find("categoryName").text()+" </div></div>";
							
							output_todo+="<div class='todotip_container' id='demo-basic"+$(this).find("id").text()+"' style='font-weight:lighter; clear:both;display:inline; text-decoration:none; margin-left:10px; cursor:pointer;color:grey;'>"+short_string($(this).find('subject').text())+"</a><div class='todotip'>"+$(this).find("subject").text()+"</div></div><input type='checkbox' onClick='checkonTodoItem("+$(this).find("id").text()+")' id='cktodo1' title='' style='float:right;'></div>";
							
							output_todo+="</div>";						
											
						});
							output_todo+="</div>";						
							
							output_todo+="<div style='height:30px; text-align: right;'><a class='todo_fancybox text-size-px11 text-size-px11 moreclass' href='${htmlUrl_todo}' >More</a><div>";
							$('#todos_placeholder').html(output_todo);
				
				}
			
			
			
			
		});
			
			
	}
});
	
}

</script>


<script type="text/javascript">

function checkonTodoItem(val){
	$.ajax({
	  	type: 'DELETE',
		url: '${deleteTodoUrl}'+val,
		dataType: 'json',
		success: function( data ) {
		
			$('#todoid'+val).remove();
			get_and_populate_todo();
			
		}
	});
	$('#todoid'+val).hide();
	get_and_populate_todo();

	
	
}


function short_string(string){
	
	if(string.length > 50){
		return string.substring(0,50)+'...';
	} else {
		return string;
	}	
} 

function short_string_category(value){
	if(value.length > 9){
		return value.substring(0,9)+'...';
	} else {
		return value;
	}	
}

</script>

<body>


                <div class="center for-rounded-box all-box-shadow" >
		                
                	<div class="_cMain demo_message_container" style="display:table;" >
                	 <div class="demo_message " style="font-size:18px;">
					   
					            For Demonstration Only. Functionality to be available in subsequent Playpens
					            
					            
					
					</div>
                    	<c:url var="htmlUrl_planner" value="/calendar" />
                    	<div style=" float:left;"><p> 
                    	<c:set var="now" value="<%=new java.util.Date()%>" />

                    	<fmt:formatDate type="date" pattern="EEE, MMM d, ''yy" value="${now}"  />
                    	
 						</p></div>
                  <div style=" float:left; margin-left: 3px; margin-top:5px;"><a>Calendar</a></div>

                    	<div class="_cLeft all-box-shadow" style="">
                        

                            
                            <div class="_upcoming _up1">
                            	<div class="_cDate" style="color:#A80000;">
                                	<span class="dmonth"></span><br> <b>09.00 AM</b>
                                </div>
                                
                                <div class="_uevent" style="">
                                	Lecture -<br/> Critical Thinking
                                </div>
                            </div>
                            
                            <div class="_upcoming _up1">
                            	<div class="_uDate">
                                	<b>15-FEB</b><br> <b>12.00 PM</b> 
                                </div>
                                
                                <div class="_uevent" style="" >
                                	Students Meet
                                </div>
                            </div>
                            
                            <div class="_upcoming _up2">
                            	<div class="_uDate">
                                	<b>16-FEB</b><br> <b>02.00 PM</b> 
                                </div>
                                
                                <div class="_uevent" style="padding-top:2px; text-align:middle;">
                                	Lecture - <br/> Model Thinking
                                </div>
                            </div>
                             <div class="_upcoming _up2">
                            	<div class="_uDate">
                                	<b>17-FEB</b><br> <b>02.00 PM</b> 
                                </div>
                                
                                <div class="_uevent" style="padding-top:2px; text-align:middle;">
                                	Lecture - <br/>Think Mental Models          
                                </div>
                            </div>
                            

                            
                        	
                        </div>
                        <div class="_cMiddle">                        
                        </div>
                        <div class="_cRight all-box-shadow">
                        	<div class="_e1">
                            	<div style="margin-top:9px; padding-bottom: 9px; padding-left: 5px;"><span class="bold text-size-px12 orange ehead"><span class="dmonth"></span> Lecture - Critical Thinking</span></div>

								<div><i class=" bold">Place: </i>Building A, Room 1A<br>
								<i class=" bold"><br>Time: </i>9:00 am - 10:30 am <br>
								<i class=" bold"><br>Contact: </i>(680) 231 6899 </div>
                            </div>
                            
                            <div class="_e2" style="display: none;">
                            <div style="margin-top:9px; padding-bottom: 9px; padding-left: 5px;"><span class="bold text-size-px12 ehead">Jan 23 - Lunch with Ziksana</span></div>
      <div><i class=" bold">Place: </i><br>
<i class=" bold">Time: </i>12:00 pm - 1:30 pm<br>
                            </div>
                            </div>
                            
                            <div class="_e3" style="display: none;">
                             <div style="margin-top:9px; padding-bottom: 9px; padding-left: 5px;"><span class="bold text-size-px12 ehead">Jan 23 - Experiment with Playpen</span></div>
                            	
<div><i class=" bold">Place: </i><br>
<i class=" bold">Time: </i> 2:00 pm</div>
                            </div>
                            

                        </div>
                        
                   
                    </div>
            
  <!-- Todo More -->
 
  <!-- End -->
                    <div class="alert_todo" >
                    
                   		<div class="alerts" >
                        	 
                             <div id='alerts_placeholder'></div>
                             	
                        </div>
                        <br/>
                        <div  class="todo">
                        	
                           
                              	<div id="todos_placeholder">
                              	
                              	</div>
                            <!--  <div id='todo-more' class='_addTodo'>
                             
                             </div>  -->	
                                
                             
                            
                        </div>
                        
                   </div>   
                   
                   <div class="class-talk demo_message_container"  style=" clear:both; border:1px solid #CCC;">
                   <div class="demo_message" style="font-size:18px;">
					    <p>
					            For Demonstration Only.<br /> Functionality to be available in subsequent Playpens
					            
					            </p>
					
					</div>
                   
                      <p style="margin:-5px -1px 10px;" class="titles-info jdash-head-title" >Class Talk <!--<span class="rightof-title-info blue">Show only</span>--></p>
                      <c:url var="imageUrl_dashboard1" value="/resources/images/user/2my-photo.png" />
                      <img src="${imageUrl_dashboard1}" width="38" height="40" align="left" class="img">
                      <p class="user-p li font-Arial"><span class="blok-title-L">Jason Dechamp</span>Check out the blog '<span class="blue">Innovative Educational Technology</span>', its gives good ideas for our projects.</p>
                      <div class="dash-bord">
                      	<div class="dash-bord-icon">
                        </div>
                      	<div class="dash-bord-bar"> 
                 
                	<input id="btn_comment" name="btn_comment" type="button" value="" class="AskZ zicons ls f-r"/> <!-- added by sundip shah -->
                </div>
                 <textarea id="new_comment" name="new_comment" cols="43" rows="4"></textarea>
                        
                        <div class="comments-container">
                        <c:url var="imageUrl_dashboard1" value="/resources/images/user/cocntacts-users.jpg" />
                        <img src="${imageUrl_dashboard1}" width="40" height="42" align="left" class="img2">
                      <p class="user-p"><span class="blok-title-L">Jiameng Yu</span>I agree... its is very helpfu..</p>
                        </div>
                      </div>
                    </div>
                </div>
 
	</body>