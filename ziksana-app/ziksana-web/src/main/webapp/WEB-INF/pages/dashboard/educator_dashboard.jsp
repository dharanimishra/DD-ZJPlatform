<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url var="showEventUrl" value="/secure/showmycalendar/111111" />
<c:url var="eventImageUrl" value="/resources/images/front-bg.gif" />
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


<c:url var="todoImageUrl" value="/resources/images/background-pattern.jpg" />
<c:url var="showAlertUrl" value="/secure/showmyalert/111111" />
<c:url var="deleteAlertUrl" value="/secure/deletealert/111111" />
<script type="text/javascript">
$(document).ready(function() {
	$.ajax({
		  	type: 'GET',
			url: '${showAlertUrl}',
			dataType: 'xml',
			success: function( data ) {
					if (console && console.log){
								console.log( 'Sample of data:', data);
					}
					var output="";
					
					$(data).find("alertitem").each(function(index){
						output+="<div class='alertitem'>";
						output+="<span class='Zalart zicons ls-no f-l a1'></span>&nbsp;";
						//output+="<font class='_hText'>" + alertitem.subject + "</font>";
						
						output+="<font class='_sText'>" + $(this).find("description").text() + "</font>";
						output+="<span class='alert zclose  zicons ls-no f-r'></span>";
						//output+="<input type='hidden' id='alertItemId' value='" + alertitem.id + "' />";
						output+="</div>";						
					});
					
					/*
					for (var i in data.alertItems)
					{
						var alertitem = data.alertItems[i];
						output+="<div class='alertitem'>";
						output+="<span class='Zalart zicons ls-no f-l a1'></span>&nbsp;";
						output+="<font class='_hText'>" + alertitem.subject + "</font>";
						output+="<font class='_sText'>" + alertitem.detail + "</font>";
						output+="<span class='alert zclose  zicons ls-no f-r'></span>";
						output+="<input type='hidden' id='alertItemId' value='" + alertitem.id + "' />";
						output+="</div>";						
					}
					*/
					console.log("output string: " + output);
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
									console.log('delete alert fired');
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
</script>

<c:url var="showTodoUrl" value="/secure/showmytodo/111111" />
<c:url var="deleteTodoUrl" value="/secure/deletetodo/1111111" />
<script type="text/javascript">
$(document).ready(function() {
	$.ajax({
		  	type: 'GET',
			url: '${showTodoUrl}',
			dataType: 'xml',
			success: function( data ) {
					if (console && console.log){
								console.log( 'Sample of data:', data);
					}
					var output="";
					
					$(data).find("todoitem").each(function(index){
						output+="<div class='todoitem'>";
						output+=$(this).find("categoryName").text() + ": " + $(this).find("subject").text();
						output+="<span class='td zclose  zicons ls-no f-r'></span>";
						output+="<input type='hidden' id='todoItemId' value='" + $(this).find("id").text() + "' />";
						output+="</div>";						
					});

					console.log("output string: " + output);
					$('#todos_placeholder').html( output);
					
					$('span.td').hide();
					
					$('div.todoitem').hover( function(){
						console.log("this is: " + $(this).html());
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
									console.log('delete todo fired');
								}
							});
						});
						$(this).css("background-image", "url(${todoImageUrl})");
					}, function(){
						$(this).children('.td').hide();
						$(this).children('.td').unbind();
						$(this).css("background-image", "");
					});
					
			}
	});
	
});
</script>

                <div class="center for-rounded-box all-box-shadow">
                
                	<div class="_cMain">
                    	<c:url var="htmlUrl_planner" value="/calendar" />
                    	<div style=" float:left;"><p> 
                    	<c:set var="now" value="<%=new java.util.Date()%>" />

                    	<fmt:formatDate type="date" pattern="EEE, MMM d, ''yy" value="${now}"  />
                    	
 						</p></div>
                        <div style=" float:left; margin-left: 5px; margin-top:5px;"><a class="icon-cal text-size-px11 lbx-70-50" href="${htmlUrl_planner}">Calendar</a></div>

                    	<div class="_cLeft all-box-shadow" style=" clear:both; border:1px solid #CCC;">
                        	<div id='event_left_placeholder'></div>
                        </div>
                        <div class="_cMiddle">                        
                        </div>
                        <div class="_cRight all-box-shadow" style=" border:1px solid #CCC; width:190px;">
                        	<div id='event_right_placeholder'></div> 
                        </div>
                        
                   
                    </div>
              <br/><br/>
                    <div class="alert_todo" >
                    
                   		<div class="alerts" >
                        	 <span class="titles-info font-Signika text-size-px18 light-gray">Alerts</span>
                             <div id='alerts_placeholder'></div>
                        </div>
                        
                        <div class="todo">
                        	 <span class="titles-info font-Signika text-size-px18 light-gray">To-dos</span>
                            
                              	<div id="todos_placeholder"></div>
                                
                               <div class="_addTodo"> <a class="text-size-px11" href="#" >Add more</a></div>
                            
                        </div>
                        
                   </div>   
                   
                   <div class="class-talk">
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