<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script type="text/javascript" src="resources/js/tree/jquery-1.8.0.min.js"></script>

<link href="resources/css/styles.css" rel="stylesheet" type="text/css">

	<link href="resources/css/type-setting.css" rel="stylesheet" type="text/css">
	<link href="resources/css/effects.css" rel="stylesheet" type="text/css">
	<link href="resources/css/nav.css" rel="stylesheet" type="text/css">
	
	<link rel="stylesheet" type="text/css" href="resources/css/dropdown.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/jquery.fancybox.2.1.3.css"/>
	<!-- <link rel="stylesheet" type="text/css" href="resources/css/masks.css" /> -->
	
    <link rel="stylesheet" type="text/css" href="resources/css/tag/tagit-simple-blue.css">
    <link rel="stylesheet" href="resources/css/tipsy.css" type="text/css" />
    <!-- <link rel="stylesheet" type="text/css" href="css/custom-theme/old-jquery-ui-1.8.21.custom.css"> -->
    <link rel="stylesheet" type="text/css" href="resources/css/custom-theme/jquery-ui-1.8.21.custom.css">
     <link href="resources/css/news/newsticker.css" rel="stylesheet" type="text/css" />
     
   	
	 <script src="resources/js/jquery-1.7.2.min.js"></script>
	 <script src="resources/js/ui/jquery.ui.core.js"></script>
	 <script src="resources/js/ui/jquery.ui.widget.js"></script>
	 <script src="resources/js/ui/jquery.ui.button.js"></script>
	 <script src="resources/js/ui/jquery.ui.progressbar.js"></script>
	 <script src="resources/js/ui/jquery.ui.tabs.js"></script>
     <script src="resources/js/jquery.hovercard.js"></script>
     <script src="resources/js/jquery.fancybox.pack.2.1.3.js"></script>
     <script src="resources/js/jquery.collapse.js"></script>
     <script src="resources/js/todo.js" type="text/javascript"></script> 
     <script language="javascript" type="text/javascript" src="resources/js/custom/Todoalertshovercard.js"></script>
	<script type="text/javascript" src="resources/js/jquery-1.2.2.pack.js"></script>
	<script type="text/javascript" src="resources/js/ajax-tooltip.js"></script>	
	<script type="text/javascript" src="resources/js/jquery.tipsy.js"></script>
	

<c:url var="deleteAlertUrl" value="/secure/deletealert/111111/" />
<script type="text/javascript">


function deleteFunction(val){
	/* alert('${deleteAlertUrl}'+val); */
	
	confirm_delete_alert = confirm('Are you sure you want to delete this item?');
	if(confirm_delete_alert == true){
		
		
	
	$.ajax({
	  	type: 'DELETE',
		url: '${deleteAlertUrl}'+val,
		dataType: 'json',
		success: function( data ) {
			console.log('delete alert fired');
			//delete the alert div
			
			
		}
	});
	$('#alert_'+val).remove();
	
	}
}
</script>

<%-- <c:url var="deleteTodoUrl" value="/secure/deletetodo/1111111" />
<script type="text/javascript">
function deleteTodoFunction(val){
	//alert(val);
	
	 confirm_delete_alert = confirm('Are you sure you want to delete this item?');
	if(confirm_delete_alert == true){
		
		
	
	$.ajax({
	  	type: 'DELETE',
		url: '${deleteTodoUrl}'+val,
		dataType: 'json',
		success: function( data ) {
			console.log('delete alert fired');
			//delete the alert div
			
			
		}
	});
	$('#todoid'+val).remove();
	
	}
}
</script> --%>

<c:url var="showEventUrl" value="/secure/showmycalendar/111111" />
<c:url var="eventImageUrl" value="resources/images/front-bg.gif" />
<script type="text/javascript">
$(document).ready(function() {
	$.ajax({
		  	type: 'GET',
			url: '${showEventUrl}',
			dataType: 'json',
			success: function( data ) {
//					if (console && console.log){
//								console.log( 'Sample of data:', data);
//					}

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
</script>

 <script type="text/javascript">
function changeImage(a){
	
	var images = new Array();
	images[0] = "<c:url  value='resources/images/icons/urgent.png' />";
	images[1] = "<c:url  value='resources/images/icons/warning.png' />";
	images[2] = "<c:url  value='resources/images/icons/info.png' />";
	
	 var comic = document.getElementById("exp").src;
	 if(a==1000){
		  $("#exp").attr('src', images[0]);
	 }else if(a==1001){
		 $("#exp").attr('src', images[1]);
	 }else if(a==1002){
		 $("#exp").attr('src', images[2]);
	 }
	 
	  
}
</script>
 
 
 
  <c:url var="closeicon" value="/resources/images/icons/close-icon.png" />
 <c:url var="htmlUrl_alert" value="secure/getalertpopupwindow" />
                            
                          
<c:url var="todoImageUrl" value="/resources/images/background-pattern.jpg" />
<c:url var="showAlertUrl" value="/secure/showalert/111111" />
<c:url var="info"  value='/resources/images/icons/info.png' />
 <c:url var="htmlUrl_todo" value="secure/gettodopopupwindow" />
<script type="text/javascript">
$(document).ready(function() {
	$.ajax({
		  	type: 'GET',
			url: '${showAlertUrl}',
			dataType: 'xml',
			success: function( data ) {
				
					
					var output="";
					var indexValue=0;
					output+="<div  class='alerts'>";
					output+="<span class='titles-info font-Signika text-size-px18 light-gray'>Alerts</span>";
					$(data).find("alertitem").each(function(index){
						
						indexValue = index;
						output+="<div id='alert_"+$(this).find("id").text()+"' class='alertcontainer' style='border:1px solid #F5F5F5;' id='conalert3'>";
						output+="<div class='alertinfo' style='height:28px;padding:5px;'>";
						output+="<div class='alertinfo-icon' style='float:left;display:inline; margin-right:10px;'>";
						 
						output+="<a href='#linkurl' rel='tipsy'  style='cursor:default;' > <img id='exp' src='${info}' onload='changeImage("+$(this).find("priority").text()+")' alt='INFO' /> </a></div>";
						output+="<div class='alertinfo-category'style='display:inline;' >"+$(this).find("category").text()+"</div>";
						/* output+="<div class='alertinfo-decription' style='float:left; height:14px; font-family:verdana; font-size:11px; padding:4px;'>"; */
						output+="<div  id='demo-basic2'  style='font-weight:lighter;clear:both;display:inline; margin-left:10px; cursor:pointer;'><a id='tool' rel='"+$(this).find("description").text()+"'>"+$(this).find("description").text()+"</a></div><a href='#' onclick='deleteFunction("+$(this).find('id').text()+")'  title='Delete' style='float:right; id='btalert3' rel='tipsy' title='Close'> <img src='${closeicon}' height='15' width='15'/> </a></div>";
						/* output+="<div class='alertinfo-button' style='display:inline;margin-left:10px;' >"; */
						output+="</div></div>";
						
									
					});
					
					
					if(indexValue == 2)
					{
					output+="<div  style='height:30px; float:right;'> <a class='text-size-px11  lbx-70-50' href='${htmlUrl_alert}' >More</a></div>";
					}
					$('#alerts_placeholder').html( output);
					
					$('span.Zalart').hide();
					$('span.alert').hide();
					$('font._sText').hide();	
					
					$('div.alertitem').hover( function(){
						console.log("this is: " + $(this).html());
						$(this).children('.alert').show();
						$(this).children('.Zalart').show();
						$(this).children('._sText').show();
						$(this).children('._hText').hide();
						$(this).css("background-image", "url(${todoImageUrl})");
						$(this).children('.alert').click( function(){
							$(this).parent().fadeOut('slow');
							$(this).unbind();
							console.log("alertItemId is: " + $(this).parent().children('#alertItemId').attr('value'));
							$.ajax({
							  	type: 'DELETE',
								url: '${deleteAlertUrl}/' + $(this).parent().children('#alertItemId').attr('value'),
								dataType: 'json',
								success: function( data ) {
									//console.log('delete alert fired');
								}
							});
						});
						
					}, function(){
						$(this).children('.alert').hide();
						$(this).children('.Zalart').hide();
						$(this).children('._sText').hide();
						$(this).children('._hText').show();
						$(this).children('.alert').unbind();
						$(this).css("background-image", "");
					});
					
			}
	});
	
});
jQuery(function($) {
	var timer;
	function mouseoverActiontooltip(event)
	{
	$("body").append("<p id='tool'>"+ this.rel + "</p>");
	$("#tooltip").css("left",(event.pageX + 20) + "px");
	$("#tooltip").css("top",(event.pageY - 10) + "px");
	}

	function mouseoutActiontooltip(event)
	{
	$("#tooltip").remove();
	}
	function mousemoveActiontooltip(event)
	{
	$("#tooltip").css("left",(event.pageX + 20) + "px");
	$("#tooltip").css("top",(event.pageY - 10) + "px");
	}
	$('.tooltip').bind('mouseover', mouseoverActiontooltip);

	$('.tooltip').bind('mouseout', mouseoutActiontooltip);
});
</script>

<c:url var="todo" value="/resources/images/icons/todo.png" />
<c:url var="showTodoUrl" value="/secure/showtodo/111111" />




<script type="text/javascript">
$(document).ready(function() {
	

		$('.todo_tooltip').mouseover(function(){
			displayToolTip( $(this).find("a").text());
		
		});

	
	
	$.ajax({
		  	type: 'GET',
			url: '${showTodoUrl}',
			dataType: 'xml',
			success: function( data ) {
					
					var output="";
					
					var indexValue = 0;
					$(data).find("todoitem").each(function(index){
						
						indexValue = index;
						output+="<div id='todoid"+$(this).find("id").text()+"' class='todocontainer' style='border:1px solid #F5F5F5;' id='contodo1'>";
						output+="<div class='todoinfo' style='height:28px;padding:5px;'>";
						output+="<div id='todo-row' class='todoinfo-icon' style='float:left;display:inline; margin-right:10px;'>";
						 
						output+="<a href='#' rel='tipsy'  style='cursor:default;' ><img src='${todo}' alt='Info' /></div>";
						output+="<div class='todoinfo-category'style='display:inline;' >"+$(this).find("categoryName").text()+"</div>";
						//output+="<div></div>";
						output+="<div class='todo_tooltip' id='demo-basic2'  style='font-weight:lighter;clear:both;display:inline;text-decoration:none; margin-left:10px; cursor:pointer;'>"+$(this).find("subject").text()+"</div><input type='checkbox' onChange='checkonTodoItem("+$(this).find("id").text()+")' id='cktodo1' style='float:right;'></div>";
						/* output+="<div class='alertinfo-button' style='display:inline;margin-left:10px;' >"; */
						output+="</div></div>";
						
						
										
					});
					
					if(indexValue == 2)
					{
					output+="<div style='height:30px; float:right;'><a class='lbx-70-50 text-size-px11 text-size-px11' href='${htmlUrl_todo}' >More</a><div>";
						}
					$('#todos_placeholder').html( output);
					
					$('span.td').hide();
					
					/* $('div.todoitem').hover( function(){
						//console.log("this is: " + $(this).html());
						$(this).children('.td').show();
						$(this).children('.td').click( function(){
							$(this).parent().fadeOut('slow');
							$(this).unbind();
							console.log("todoItemId is: " + $(this).parent().children('#todoItemId').attr('value'));
							$.ajax({
							  	type: 'DELETE',
								url: '${deleteTodoUrl}/' + $(this).parent().children('#todoItemId').attr('value'),
								dataType: 'json',
								success: function( data ) {
									
								}
							});
						});
						$(this).css("background-image", "url(${todoImageUrl})");
					}, function(){
						$(this).children('.td').hide();
						$(this).children('.td').unbind();
						$(this).css("background-image", "");
					}); */
					
			}
	});
	
});
<c:url var="deleteTodoUrl" value="/secure/deletetodo/1111111" />
function checkonTodoItem(val){
	$.ajax({
	  	type: 'DELETE',
		url: '${deleteTodoUrl}'+val,
		dataType: 'json',
		success: function( data ) {
			console.log('delete alert fired');
			//delete the alert div
			
			
		}
	});
	$('#todoid'+val).remove();
	
}

function displayToolTip(value){
	 var hoverHTMLDemoBasic = '' + value; 
	
}
</script>




                <div class="center for-rounded-box all-box-shadow" >
		                
                	<div class="_cMain  demo_message_container" style="display:table;" >
                	 <div class="demo_message" style="font-size:18px;">
					   
					            For Demonstration Only. Functionality to be available in subsequent Playpens
					            
					            
					
					</div>
                    	<c:url var="htmlUrl_planner" value="/calendar" />
                    	<div style=" float:left;"><p> 
                    	<c:set var="now" value="<%=new java.util.Date()%>" />

                    	<fmt:formatDate type="date" pattern="EEE, MMM d, ''yy" value="${now}"  />
                    	
 						</p></div>
                        <div style=" float:left; margin-left: 5px; margin-top:5px;"><a class="icon-cal text-size-px11 lbx-70-50" href="${htmlUrl_planner}">Calendar</a></div>

                    	<div class="_cLeft all-box-shadow"  style=" clear:both; border:1px solid #CCC;">
                        	<div id='event_left_placeholder'></div>
                        </div>
                        <div class="_cMiddle">                        
                        </div>
                        <div class="_cRight all-box-shadow" style=" border:1px solid #CCC; width:190px;">
                        	<div id='event_right_placeholder'></div> 
                        </div>
                        
                   
                    </div>
              <br/><br/>
  <!-- Todo More -->
 
  <!-- End -->
                    <div class="alert_todo" >
                    
                   		<div class="alerts" >
                        	 
                             <div id='alerts_placeholder'></div>
                             	
                        </div>
                        
                        <div  class="todo">
                        	 <span class="titles-info font-Signika text-size-px18 light-gray">Todos</span>
                           
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
                   <div  id="classmask">
			            <br />
			            <br />
						<br />
						<br />
						<p style="font-size:18px;color:#ffffff">
			            For Demonstration Only.<br /><br /> Functionality to be available in subsequent Playpens
			            
			            </p>
			
			            
			        </div>
                      <p class="titles-info font-Signika text-size-px18 light-gray">Class Talk <!--<span class="rightof-title-info blue">Show only</span>--></p>
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