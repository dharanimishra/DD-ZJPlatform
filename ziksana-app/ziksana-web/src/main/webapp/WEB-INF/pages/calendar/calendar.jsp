<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<link rel='stylesheet' type='text/css' href='/ziksana-web/resources/js/fullcalendar/fullcalendar.css' />
<link rel='stylesheet' type='text/css' href='/ziksana-web/resources/js/fullcalendar/fullcalendar.print.css' media='print' />
<script type='text/javascript' src='/ziksana-web/resources/js/fullcalendar/jquery-1.8.1.min.js'></script>
<script type='text/javascript' src='/ziksana-web/resources/js/fullcalendar/jquery-ui-1.8.23.custom.min.js'></script>
<script type='text/javascript' src='/ziksana-web/resources/js/fullcalendar/fullcalendar.min.js'></script>

 <c:url var="eventListUrl" value="/calendar/getevents" />
 <c:url var="eventEditUrl" value="/calendar/editevent" />
 <c:url var="eventDeleteUrl" value="/calendar/deleteevent" />
 <c:url var="editUrl" value="/resources/images/edit.png" />
 <c:url var="deleteUrl" value="/resources/images/delete.jpg" />
 
<script type='text/javascript'>

	
	 $(document).ready(function() {
         var date = new Date();
         var d = date.getDate();
         var m = date.getMonth();
         var y = date.getFullYear();
       $.getJSON('${eventListUrl}', function (data) {
         var calendar = $('#calendar').fullCalendar({
             header: {
                 left: 'prev,next today',
                 center: 'Ziksana Event Calendar',
                 right: 'month,agendaWeek,agendaDay'
             },
             defaultView:'agendaDay',
             selectable: true,
             selectHelper: true,
             select: function(start, end, allDay) {
            	// myRef = window.open('${eventEditUrl}','mywin','left=800,top=300,width=220,height=220,resizable=0,maximize=0');
                 var title = prompt('Event Title:');
                // popup.show();
                 var title = myRef;
                 if (title) {
                     calendar.fullCalendar('renderEvent',
                     {
                         title: title,
                         start: start,
                         end: end,
                         allDay: allDay
                     },
                             true // make the event "stick"
                             );
                 }
                 calendar.fullCalendar('unselect');
             },
             editable: true,
             events:data,
             
             eventMouseover: function(event, domEvent) {
            	//alert('mouse over called ' + event.id);
 				var layer =	'<div id="events-layer" class="fc-transparent" style="position:absolute; width:100%; height:100%; top:-1px; text-align:right; z-index:100"><a><img src="${editUrl}" title="edit" width="14" id="edbut'+event.id+'" border="0" style="padding-right:5px; padding-top:2px;" /></a><a><img src="${deleteUrl}" title="delete" width="14" id="delbut'+event.id+'" border="0" style="padding-right:5px; padding-top:2px;" /></a></div>';
 				$(this).append(layer);
 				
 				$("#delbut"+event.id).hide();
 				$("#delbut"+event.id).fadeIn(300);
 				$("#delbut"+event.id).click(function filter() {
 		           if (!confirm("Really want to delete this event")) {
                       revertFunc();
                  }
                  else {
				       $('#calendar').fullCalendar('removeEvents',event.id)
				      
				                        $.ajax({
				                        url:'${eventDeleteUrl}',
				                        type:'post',
				                        data:{
				                           id:event.id,
				                                                    }
				                   }).done(function(data) {
				                      
				                   });
				         }
				   });
 				
	 				$("#edbut"+event.id).hide();
	 				$("#edbut"+event.id).fadeIn(300);
	 				$("#edbut"+event.id).click(function() {
	 					var title = prompt('Current Event Title: ' + event.title + '\n\nNew Event Title: ');
	 					$('#calendar').fullCalendar('updateEvent', event)
	 			       
	                    $.ajax({
	                    url:'${eventEditUrl}',
	                    type:'post',
	                    data:{
	                       id:event.id,
	                       title:title,
	                                                }
	               }).done(function(data) {
	                  /* alert(event.title);*/
	                                      
	               });
 					
 				});
             },
 				eventMouseout: function(calEvent, domEvent) {
	 	            $("#events-layer").remove();
	 	            },
             
            /* eventClick: function(event, element) {

    		      myRef = window.open('form.jsp','mywin','left=800,top=300,width=220,height=220,toolbar=no,location=no,resizable=no');

    		        $('#calendar').fullCalendar('updateEvent', event);

    		    },*/
    		    
             
    		eventDrop: function(event, delta) {
 				alert(event.title + ' was moved ' + delta + ' days\n' +
 					'(should probably update your database)');
 			},
 			
 			/*eventClick: function(event) {
 		        if (event.url) {
 		            window.open(event.url);
 		            return false;
 		        }
 		    },
 		    
 		    
 		   eventClick: function(event, element) {

 		        event.title = "CLICKED!";

 		        $('#calendar').fullCalendar('updateEvent', event);

 		    },*/
 			
 			loading: function(bool) {
 				if (bool) $('#loading').show();
 				else $('#loading').hide();
 			}
         });
      });
       
     });


</script>
<style type='text/css'>

	body {
		margin-top: 40px;
		text-align: center;
		font-size: 14px;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		}
		
	#loading {
		position: absolute;
		top: 5px;
		right: 5px;
		}

	#calendar {
		width: 900px;
		margin: 0 auto;
		}

</style>
</head>
<body>
<div id='loading' style='display:none'>loading...</div>
<div id='calendar'></div>
<div id="event_edit_container" class="popup" style="display: none; height: auto; min-height: 42px; width: auto;">
	<form>
		<input type="hidden" value=""></input>
		<ul>
			<li>
				<span>Date: </span>
				<span class="date_holder">Oct 02, 2012</span>
			</li>
			<li>
				<label for="start">Start Time: </label>
				<select name="start">
			</li>
			<li>
				<label for="end">End Time: </label>
				<select name="end">
			</li>
			<li>
				<label for="title">Title: </label>
				<input type="text" name="title">
			</li>
			<li>
				<label for="body">Body: </label>
				<textarea name="body"></textarea>
			</li>
		</ul>
	</form>
</div>
</body>
</html>
