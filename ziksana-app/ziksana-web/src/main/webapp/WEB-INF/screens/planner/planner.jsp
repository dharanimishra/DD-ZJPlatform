<%@ page language="java" contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.ziksana.domain.course.NestTreeNode"%>
<%@page import="com.ziksana.domain.course.NestContentNode"%>
<%@page import="com.ziksana.domain.course.ContentType"%>
<%@page import="com.ziksana.domain.course.Course"%>


<div class="navheadlp" style="padding-left: 20px;">
	<ul>
	<a href="/ziksana-web/zcourse/1/planner/${courseIds}" >
		<li style="margin-left: 40px; color: #f06c0b;"><span><img
				src="/ziksana-web/resources/images/navarrow.png"
				style="margin-right: 10px; height: 22px;"> </span>Define Planner</li></a>
		
		<li style="">
		<a href="/ziksana-web/zplaybook/1/htmlView/${courseIds}">
		<span><img
				src="/ziksana-web/resources/images/navarrowb.png"
				style="margin-right: 10px; height: 22px;"> </span>Review Playbook
				</a>
				 </li>
	

	</ul>

</div>
<div id="formcontainer">


<div class="clearfix"></div>
<form action="/ziksana-web/zcourse/1/submitplanner" style="min-height:350px;">
	<div id="planner_error"></div><div id="planner_success_message"></div>
	<div id="planner_container"> 
		<div text="${course.name}" class="planner_data" id="COURSE_${courseIds}">
		<input type="hidden" name="${courseIds}courseDuration" id="course_duration_in_weeks" value="${courseDuration}"/>
		<input type="hidden" id="course_duration_in_days"  class="duration" value="${course.duration * 7}"/>
		<div>
		<input type='hidden' value='COURSE_${coursename}' name='course_name'/>
		<input type='hidden' value='${courseIds}' id="courseId" name='course_id'/>
		
		<span class='node_title'><img class="node_icon" src="${courseIcon}"/> ${course.name}</span>

		<span class="duration_display">Course Duration in Weeks: <strong>${course.duration}</strong></span>
		</div>
		
	<%
	 	List<NestTreeNode> list = (List<NestTreeNode>) request.getAttribute("parentList");

	 	if (list != null)
	 		out.println(printTree(list));
	 %> </div> 
	 </div>
	 <hr/>
	 <div class="textAlignRight" style="margin-right:11px;">
 		<button  type="submit" name="savePlanner" id="submit_planner_data" class="btn blue"> Save </button>
 		<a href="/ziksana-web/zcourse/1/${courseIds}/viewplanner"  class="btn blue" style="width:92px;">Generate</a><br/><br/>
 		<button  type="submit" name="savePlannerAndContinue" id="submit_planner_data" class="btn blue"> Save and Continue </button>

 	</div>
 	<hr/>
 </form>
</div>

<style type="text/css">

.planner_data {
  background: url("/ziksana-web/resources/images/planner_div_bg.png") repeat scroll 0 0 transparent;
  color: white;
  display: inline-block;
  width: 1028px;
}
.planner_data div {
  clear: both;
  height: 32px;
  padding-left: 10px;
  text-align: right;
  line-height: 32px;
}
.planner_data > div {
}
.planner_data > div  div { padding-left: 15px;}
.planner_data div span.node_title {
  float: left;
}
.planner_data > div > span.node_title {
  font-weight: bold;
}
.planner_data select, .planner_data input {
  border: 1px solid white;
  border-radius: 2px 2px 2px 2px;
  font-size: 12px;
  height: 22px;
  margin: 0 0.25em;
  padding: 2px;
  text-align: left;
}
.planner_data div select {
  width: 90px;
}
.planner_data input {
  height: 16px !important;
}
input.note {
  margin-right: 0.5em !important;
}

.start_week, .end_week, .duration, .starts_at {
  width: 32px;
}

.starts_at {border-color: pink !important; background: #eee !important; display:none !important; }
.duration_display { margin-right: .5em; }

.node_icon {
  height: 18px;
  margin-right: 0.25em;
  vertical-align: top;
  width: 18px;
  vertical-align: middle;
}
.node_module {font-weight: bold;}

#planner_error:not(:empty) { color: red; font-size: 12px; padding: .5em;}
.duration_error { color: red !important; border: 2px solid red !important}
</style>

<!-- style for Active Tab for Publish -->
<style>
.tbboxheadfntds  {
    color: #8B8B8B;}
.tbboxheadfnt {
    color: #8B8B8B;}
.tbboxdesc p {
     color: #B1B1B1;
    font-family: 'Segoe UI Light','Open Sans',Verdana,Arial,Helvetica,sans-serif;
    font-size: 14px !important;width: 352px; 
}
.tbboxdesc {
    float: none;
    margin-top: 0;
    width: 328px;
    
}
.tbboxheadfntpublish {
    color: #4BB1CF;}
.tbboxdescds p {
    color: #B1B1B1;
    font-family: 'Segoe UI Light','Open Sans',Verdana,Arial,Helvetica,sans-serif;
    font-size: 14px!important;
}
#buildtab .badge-warning{background-color: #999999;}
#publishtab .badge1  {background-color: #F89406!important}
.tbboxdescpub p {
    color: #4BB1CF;
    font-family: 'segoe ui',sans-serif;
    font-size: 13px;
    font-weight: 100;
}
 #buildtab{width: 363px;}
 #publishtab{width:320px}
</style> 

<script type="text/javascript">
function saveandcontinue(courseId){
	
	document.getElementById('submit_planner_data').click(); 
	
	window.location.href = "/ziksana-web/zplaybook/1/htmlView/"+courseId+"";
}

function get_and_populate_planner_data(courseId){
	$.ajax({
	  	type: 'GET',
		url: '/ziksana-web/zcourse/1/getplannerlist/'+courseId,
		success: function( dataList ) {
			square_pixel = 24; //the width of the day in pixels
			
			course_duration_in_days = $('#course_duration_in_days').val(); //set it dynamically
			course_pixellength = (course_duration_in_days * square_pixel )+ 'px'; //remove when course duration is set
			
			
			
			
			for (var i = 0; i < dataList.length; i++) { 
						//console.log(dataList[i]);
						node = dataList[i];
						id = node.id;
						unique_id = node.nodeUniqueId;
						//console.log('unique i'+unique_id);
						course_id = node.courseId;
						duration = node.duration;
						component_id = node.learningComponentId;
						content_id = node.learningContentId;
						note = node.note;
						start_day = node.startDay;
						start_week = node.startWeek;
						starts_at = node.startsAt;
						
						if(!"".contains(id) && id != null){
							
							n_id = "0"+unique_id+"";
							$('[name="'+n_id+'"]').val(id);
							
							c_id = "0"+unique_id+"";
							$('[name="'+c_id+'"]').val(id);
						
						}
					
					//Modules Data Population
						if(!"".contains(duration) && duration != null){
							
							n_duration = ""+unique_id+"_duration";
							
							$('[name="'+n_duration+'"]').val(duration);
						
						
						}
						if(!"".contains(start_week) && start_week != null){
							n_startweek = ""+unique_id+"_startweek";
							$('[name="'+n_startweek+'"]').val(start_week);
							
						}
						if(!"".contains(start_day) && start_day != null){
							n_startday = ""+unique_id+"_startday";
							$('[name="'+n_startday+'"]').val(start_day);
							
						}
						if(!"".contains(note) && note != null){
							n_note = ""+unique_id+"_note";
							$('[name="'+n_note+'"]').val(note);
							
						}
						
						if(!"".contains(starts_at) && starts_at != null){
							n_startsAt = ""+unique_id+"_starts_at";
							$('[name="'+n_startsAt+'"]').val(starts_at);
							
						}
						
						
				}//end of for loop
				
			
			
			}//end of ajax success function

		});
}



$(function(){
//Active Tab for left side menu
$('#navcourse').addClass('active');
	
//reset planner node values
$('.start_week, .start_day').val('0');
$('.duration:not(#course_duration_in_days), .starts_at').val('');
get_and_populate_planner_data($('#courseId').val());	
$('.start_week, .start_day').change(function(){
    select = $(this);
    parent = select.parent('div');
    
    
    var week = parent.find('> .start_week').val();
    var day = parent.find('> .start_day').val();
    parent.find('> input.starts_at').val('');
    var start_at = '';
    if(day !== '' && week != ''){
        starts_at_day = (week*7)-(7-day);
        console.log(starts_at_day);
        parent.find('> input.starts_at').val(starts_at_day);
    } 
    
 

});

//Start week Calculation
$('.start_week').change(function(){
	 select_start_week = $(this);
	 
    parent_week_element = select_start_week.parent('div').parent('div').find('> .start_week');
 	
    //child_week_element = $(this).siblings('div');
    $(this).siblings('div').each(function(){ 
    	
    	if($(this).find('.start_week').val() > select_start_week.val()){
    		if($(this).find('.start_week').text() !='Start Week'){
	    		$(this).find('.start_week').find("option:first").attr("selected", true);
	    		$(this).find('.start_week').removeClass('duration_error');
	    		$(this).find('.start_day').find("option:first").attr("selected", true);
	    		$(this).find('.start_day').removeClass('duration_error');
	    		$(this).find('.duration').val('');
	    		$('#submit_planner_data').attr('disabled',false);
	    		//console.log("Matched"+$(this).find('.start_week').val());
    		}
    	}else{
    		if($(this).find('.start_week').text() !='Start Week'){
    			//console.log("NOT Matched"+$(this).find('.start_week').val());
    			$(this).find('.start_day').removeClass('duration_error');
    			$(this).find('.start_week').removeClass('duration_error');
    			$('#submit_planner_data').attr('disabled',false);
    		}
    	}
    	
    });

    
    if(parent_week_element.val() > select_start_week.val()){
    	select_start_week.addClass('duration_error');
    	
    	 $('#planner_error').html('The Start Week <strong> week '+select_start_week.val()+'</strong> unexceed  its parent node startweek of <strong>week '+parent_week_element.val()+'</strong>');
    	 $('#submit_planner_data').attr('disabled',true);
    	 
    }else {
    	select_start_week.removeClass('duration_error');
    	select_start_week.focusout();
    	
    	$('#planner_error').html('');
    	$('#submit_planner_data').attr('disabled',false);
    } 
    
    //Again user Changed Start week
    var course_duration_in_days = $('#course_duration_in_days').val();
  	var starts_at = select_start_week.siblings('.starts_at').val();
  	var duration = select_start_week.siblings('.duration').val();
    var available_days = course_duration_in_days - starts_at;
    
    if(duration != ''){
    if(duration > (available_days+1)){
    	//throw error
  		$('#planner_error').html('The node duration <strong>'+duration+'</strong> exceeds the available days <strong>'+(available_days+1)+'</strong> Days.');
  		select_start_week.siblings('.duration').addClass('duration_error').focus();
  		$('#submit_planner_data').attr('disabled',true);
    }else{
    	select_start_week.siblings('.duration').removeClass('duration_error').focusout();
    	$('#submit_planner_data').attr('disabled',false);
    }
    }
});

//Start Day Validation
$('.start_day').change(function(){
	 select_start_day = $(this);
	 
	    parent_day_element = select_start_day.parent('div').parent('div').find('> .start_day');
	    
/* 	    console.log("select_start_day "+select_start_day.val());
	    console.log("parent_day_element "+parent_day_element.val()) */
	    if(parent_day_element.val() > select_start_day.val()){
	    	select_start_day.addClass('duration_error');
	    	
	    	 $('#planner_error').html('The Start Day <strong> '+generate_numbers_to_days(select_start_day.val())+'</strong> unexceed  its parent node startday of <strong>'+generate_numbers_to_days(parent_day_element.val())+'</strong>');
	    	 $('#submit_planner_data').attr('disabled',true);
	    	 
	    }else {
	    	select_start_day.removeClass('duration_error');
	    	select_start_day.focusout();
	    	$('#planner_error').html('');
	    	$('#submit_planner_data').attr('disabled',false);
	    } 
	    
	    //Child Week 
	    //child_week_element = $(this).siblings('div');
	    $(this).siblings('div').each(function(){ 
	    	
	    	if($(this).find('.start_day').val() > select_start_week.val()){
	    		

		    		$(this).find('.start_day').find("option:first").attr("selected", true);
		    		$(this).find('.start_day').removeClass('duration_error');
		    		$(this).find('.duration').val('');
		    		$('#submit_planner_data').attr('disabled',false);
		    		//console.log("Matched"+$(this).find('.start_day').val());
	    		
	    	}else{
	    	
	    			//console.log("NOT Matched"+$(this).find('.start_day').val());
	    			$(this).find('.start_day').removeClass('duration_error');

	    			$('#submit_planner_data').attr('disabled',false);
	    		
	    	}
	    	
	    });
});

//Duration Validation
$('.duration').change(function(){
	//re-enable disabled submit button
	$('#submit_planner_data').removeAttr('disabled');
    duration_input = $(this);
    
    $('#planner_error').html('');
    		
    duration_input.removeClass('duration_error');
    duration = parseInt(duration_input.val());
    parent_duration_element = duration_input.parent('div').parent('div').find('> .duration');
    parent_duration = parent_duration_element.val();
    if(parent_duration == ''){ 
    	$('#planner_error').html('Please enter duration for the parent node.');
    	//$('#submit_planner_data').attr('disabled','disabled'); //disable submit button
    	duration_input.val(''); //clear duration
    	parent_duration_element.focus().addClass('duration_error');
    	$('#submit_planner_data').attr('disabled',true);
    	return false;
    }
 	parent_duration = parseInt(parent_duration);

    
    course_duration = parseInt($('#course_duration_in_days').val());
    if(duration > parent_duration){
        duration_input.addClass('duration_error');
        $('#planner_error').html('The node duration <strong>'+duration+'</strong> exceeds its parent node duration of <strong>'+parent_duration+'</strong> Days.').focus();
        $('#submit_planner_data').attr('disabled',true);
    } 
    
    children_duration_inputs = duration_input.siblings('div.node_title').find('.duration');
  
    if(children_duration_inputs.length > 0){
    	
    	children_duration_inputs.each(function(){
    		child_duration = $(this).val();
    		if(child_duration > duration){ //one of the child duration is higher than the newly added/edited duration
    			$('#planner_error').html('One of this node\'s child duration ('+child_duration+') is higher than that of the duration ['+duration+'] you have currently added');
    			duration_input.val('').addClass('duration_error').focus();
    			$('#submit_planner_data').attr('disabled',true);
    			return false;
    		}
    		
    	});
    	
    } 

   //
   
    

    var course_duration_in_days = $('#course_duration_in_days').val();
  	var starts_at = duration_input.siblings('.starts_at').val();
    var available_days = course_duration_in_days - starts_at;
    if(duration > (available_days+1)){
    	//throw error
  		$('#planner_error').html('The node duration <strong>'+duration+'</strong> exceeds the available days <strong>'+(available_days+1)+'</strong> Days.');
  		duration_input.val('').addClass('duration_error').focus();
  		$('#submit_planner_data').attr('disabled',true);
    }
    
   
    
});
//end of duration validation


});// end of doc ready

//Convert Numbers to Days
function generate_numbers_to_days(value){
	if(value == 1){
		return 'SUNDAY';
	}else if(value == 2){
		return 'MONDAY'
	}else if(value == 3){
		return 'TUESDAY';
	}else if(value == 4){
		return 'WEDNESDAY';
	}else if(value == 5){
		return 'THURSDAY';
	}else if(value == 6){
		return 'FRIDAY';
	}else if(value == 7){
		return 'SATURDAY';
	}
}
</script>


<%!
	public String build_options_for_startweek( int total_no_of_weeks){
	String option_html = "";
	
	
	
	option_html += "<option value='' selected='selected'>Start Week</option>";
	for(int i=1; i<=total_no_of_weeks; i++){
		option_html += "<option value='"+i+"'>Week "+i+"</option>";
	}
	return option_html;
}
%>

<%! public String printTree(List<NestTreeNode> parents) {
		StringBuffer sb = new StringBuffer();
		int initialValue = 0;
		String videoIcon = "/ziksana-web/resources/images/tree_icons/video.png";
		String audioIcon = "/ziksana-web/resources/images/tree_icons/audio.png";
		String folderClosed = "/ziksana-web/resources/images/tree_icons/folderClosed.gif";
		String folderOpen = "/ziksana-web/resources/images/tree_icons/folderOpen.gif";
		String pptIcon = "/ziksana-web/resources/images/tree_icons/powerpoint.png";
		String docIcon = "/ziksana-web/resources/images/tree_icons/word.png";
		String excelIcon = "/ziksana-web/resources/images/tree_icons/excel.png";
		String pdfIcon = "/ziksana-web/resources/images/tree_icons/pdf.png";
		String imageIcon = "/ziksana-web/resources/images/tree_icons/image.png";
		String noteIcon = "/ziksana-web/resources/images/tree_icons/note.png";
		String linkIcon = "/ziksana-web/resources/images/tree_icons/link.png";
		String chapterIcon = "/ziksana-web/resources/images/tree_icons/chapter.png";

		for (NestTreeNode node : parents) {
			if (node.getParentLearningComponentId() == 0){
				sb.append("<div>");
				//course-423_component-348
				sb.append("<input type='text' value='' style='display:none' name='"+initialValue+"course-"+node.getCourseId()+"_component-"+node.getId()+"'/>");
				sb.append("<input type='hidden' value='course-"+node.getCourseId()+"_component-"+node.getId()+"' name='coursecomponents'/>");
				//sb.append("<input type='hidden' value='"+node.getId()+"' name='course_"+node.getCourseId()+"_component_"+node.getId+"'/>");
				 sb.append("<span class='node_title'><img class='node_icon' src='"+folderOpen+"'/> " + node.getTitle() +"</span>");
				sb.append("<select name='course-"+node.getCourseId()+"_component-"+node.getId()+"_startweek' class='start_week' title='Start Week'>"+build_options_for_startweek(node.getDuration())+"</select>");
				sb.append("<select name='course-"+node.getCourseId()+"_component-"+node.getId()+"_startday' class='start_day' title='Start Day'><option value='1'>Sunday</option><option value='2' selected='selected'>Monday</option><option value='3'>Tuesday</option><option value='4'>Wednesday</option><option value='5'>Thruday</option><option value='6'>Friday</option><option value='7'>Saturday</option></select>");
				sb.append("<input type='text' value='' name='course-"+node.getCourseId()+"_component-"+node.getId()+"_duration' class='duration number' title='Duration in Days'/>");
				sb.append("<input type='text' value='' name='course-"+node.getCourseId()+"_component-"+node.getId()+"_starts_at' class='starts_at' title='Starts At'/>");
				sb.append("<input type='text' value='' name='course-"+node.getCourseId()+"_component-"+node.getId()+"_note' class='note' title='Note'/>"); 
				if (node.getContent() != null) {
					for (NestContentNode content : node.getContent()) {
						if (content.getContentType().equalsIgnoreCase(ContentType.VIDEO.getName()) || content.getContentType().equalsIgnoreCase(ContentType.ENHANCED_VIDEO.getName())) {
							
							sb.append("<div class='node_title'><span class='node_title'><img class='node_icon' src='"+videoIcon+"'/> " + content.getContentname()+"</span>");

						}else if (content.getContentType().equalsIgnoreCase(ContentType.AUDIO.getName())) {
							sb.append("<div class='node_title'><span class='node_title'><img class='node_icon' src='"+audioIcon+"'/> " + content.getContentname()+"</span>");

						}else if (content.getContentType().equalsIgnoreCase(ContentType.TEXTUAL.getName())) {
							sb.append("<div class='node_title'><span class='node_title'><img class='node_icon' src='"+noteIcon+"'/> " + content.getContentname()+"</span>");

						}else if (content.getContentType().equalsIgnoreCase(ContentType.PDF.getName())) {
							sb.append("<div class='node_title'><span class='node_title'><img class='node_icon' src='"+pdfIcon+"'/> " + content.getContentname()+"</span>");

						} else if (content.getContentType().equalsIgnoreCase(ContentType.DOC.getName())) {
							sb.append("<div class='node_title'><span class='node_title'><img class='node_icon' src='"+docIcon+"'/> " + content.getContentname()+"</span>");

						}else if (content.getContentType().equalsIgnoreCase(ContentType.PPT.getName())) {
							sb.append("<div class='node_title'><span class='node_title'><img class='node_icon' src='"+pptIcon+"'/> " + content.getContentname()+"</span>");

						}else if (content.getContentType().equalsIgnoreCase(ContentType.EXCEL.getName())) {
							sb.append("<div class='node_title'><span class='node_title'><img class='node_icon' src='"+excelIcon+"'/> " + content.getContentname()+"</span>");

						}else if (content.getContentType().equalsIgnoreCase(ContentType.IMAGE.getName())) {
							sb.append("<div class='node_title'><span class='node_title'><img class='node_icon' src='"+imageIcon+"'/> " + content.getContentname()+"</span>");
						}else if (content.getContentType().equalsIgnoreCase(ContentType.LINK.getName())) {
							sb.append("<div class='node_title'><span class='node_title'><img class='node_icon' src='"+linkIcon+"'/> " + content.getContentname()+"</span>");
						}
						
						
																									
						sb.append("<input type='text' style='display:none' value='' name='"+initialValue+"course-"+node.getCourseId()+"_component-"+node.getId()+"_content-"+content.getContentId()+"'/>");
							sb.append("<input type='hidden' value='course-"+node.getCourseId()+"_component-"+node.getId()+"_content-"+content.getContentId()+"' name='coursecontents'/>");
							//sb.append("<input type='hidden' value='"+content.getContentId()+"' name='course_"+node.getCourseId()+"_component_"+node.getId()+"_content_"+content.getContentId()+"'/>");
							 sb.append("<select name='course-"+node.getCourseId()+"_component-"+node.getId()+"_content-"+content.getContentId()+"_startweek' class='start_week' title='Start Week'>"+build_options_for_startweek(node.getDuration())+"</select>");
							sb.append("<select name='course-"+node.getCourseId()+"_component-"+node.getId()+"_content-"+content.getContentId()+"_startday' class='start_day' title='Start Day'><option value='1'>Sunday</option><option value='2' selected='selected'>Monday</option><option value='3'>Tuesday</option><option value='4'>Wednesday</option><option value='5'>Thruday</option><option value='6'>Friday</option><option value='7'>Saturday</option></select>");
							sb.append("<input type='text' value='' name='course-"+node.getCourseId()+"_component-"+node.getId()+"_content-"+content.getContentId()+"_duration' class='duration number' title='Duration in Days'/>");
							sb.append("<input type='text' value='' name='course-"+node.getCourseId()+"_component-"+node.getId()+"_content-"+content.getContentId()+"_starts_at' class='starts_at' title='Starts At'/>");
							sb.append("<input type='text' value='' name='course-"+node.getCourseId()+"_component-"+node.getId()+"_content-"+content.getContentId()+"_note' class='note' title='Note'/></div>");
						//
							

						
					}
				}
			}else{
				sb.append("<div>");
				sb.append("<input type='text' value='' style='display:none' name='"+initialValue+"course-"+node.getCourseId()+"_component-"+node.getId()+"'/>");
				sb.append("<input type='hidden' value='course-"+node.getCourseId()+"_component-"+node.getId()+"' name='coursecomponents'/>");
				//sb.append("<input type='hidden' value='"+node.getId()+"' name='course_"+node.getCourseId()+"_component_"+node.getId+"'/>");
				 sb.append("<span class='node_title'><img class='node_icon' src='"+folderOpen+"'/> " + node.getTitle() +"</span>");
				sb.append("<select name='course-"+node.getCourseId()+"_component-"+node.getId()+"_startweek' class='start_week' title='Start Week'>"+build_options_for_startweek(node.getDuration())+"</select>");
				sb.append("<select name='course-"+node.getCourseId()+"_component-"+node.getId()+"_startday' class='start_day' title='Start Day'><option value='1'>Sunday</option><option value='2' selected='selected'>Monday</option><option value='3'>Tuesday</option><option value='4'>Wednesday</option><option value='5'>Thruday</option><option value='6'>Friday</option><option value='7'>Saturday</option></select>");
				sb.append("<input type='text' value='' name='course-"+node.getCourseId()+"_component-"+node.getId()+"_duration' class='duration number' title='Duration in Days'/>");
				sb.append("<input type='text' value='' name='course-"+node.getCourseId()+"_component-"+node.getId()+"_starts_at' class='starts_at' title='Starts At'/>");
				sb.append("<input type='text' value='' name='course-"+node.getCourseId()+"_component-"+node.getId()+"_note' class='note' title='Note'/>"); 
				if (node.getContent() != null) {
					for (NestContentNode content : node.getContent()) {
						
				
					
						if (content.getContentType().equalsIgnoreCase(ContentType.VIDEO.getName())
								|| content.getContentType().equalsIgnoreCase(ContentType.ENHANCED_VIDEO.getName())) {
							
							sb.append("<div class='node_title'><span class='node_title'><img class='node_icon' src='"+videoIcon+"'/> " + content.getContentname()+"</span>");

						}else if (content.getContentType().equalsIgnoreCase(ContentType.AUDIO.getName())) {
							sb.append("<div class='node_title'><span class='node_title'><img class='node_icon' src='"+audioIcon+"'/> " + content.getContentname()+"</span>");

						}else if (content.getContentType().equalsIgnoreCase(ContentType.TEXTUAL.getName())) {
							sb.append("<div class='node_title'><span class='node_title'><img class='node_icon' src='"+noteIcon+"'/> " + content.getContentname()+"</span>");

						}else if (content.getContentType().equalsIgnoreCase(ContentType.PDF.getName())) {
							sb.append("<div class='node_title'><span class='node_title'><img class='node_icon' src='"+pdfIcon+"'/> " + content.getContentname()+"</span>");

						} else if (content.getContentType().equalsIgnoreCase(ContentType.DOC.getName())) {
							sb.append("<div class='node_title'><span class='node_title'><img class='node_icon' src='"+docIcon+"'/> " + content.getContentname()+"</span>");

						}else if (content.getContentType().equalsIgnoreCase(ContentType.PPT.getName())) {
							sb.append("<div class='node_title'><span class='node_title'><img class='node_icon' src='"+pptIcon+"'/> " + content.getContentname()+"</span>");

						}else if (content.getContentType().equalsIgnoreCase(ContentType.EXCEL.getName())) {
							sb.append("<div class='node_title'><span class='node_title'><img class='node_icon' src='"+excelIcon+"'/> " + content.getContentname()+"</span>");

						}else if (content.getContentType().equalsIgnoreCase(ContentType.IMAGE.getName())) {
							sb.append("<div class='node_title'><span class='node_title'><img class='node_icon' src='"+imageIcon+"'/> " + content.getContentname()+"</span>");

						}else if (content.getContentType().equalsIgnoreCase(ContentType.LINK.getName())) {
							sb.append("<div class='node_title'><span class='node_title'><img class='node_icon' src='"+linkIcon+"'/> " + content.getContentname()+"</span>");
						}
						
					//
							sb.append("<input type='text' style='display:none' value='' name='"+initialValue+"course-"+node.getCourseId()+"_component-"+node.getId()+"_content-"+content.getContentId()+"'/>");
							sb.append("<input type='hidden' value='course-"+node.getCourseId()+"_component-"+node.getId()+"_content-"+content.getContentId()+"' name='coursecontents'/>");
							//sb.append("<input type='hidden' value='"+content.getContentId()+"' name='course_"+node.getCourseId()+"_component_"+node.getId()+"_content_"+content.getContentId()+"'/>");
							 sb.append("<select name='course-"+node.getCourseId()+"_component-"+node.getId()+"_content-"+content.getContentId()+"_startweek' class='start_week' title='Start Week'>"+build_options_for_startweek(node.getDuration())+"</select>");
							sb.append("<select name='course-"+node.getCourseId()+"_component-"+node.getId()+"_content-"+content.getContentId()+"_startday' class='start_day' title='Start Day'><option value='1'>Sunday</option><option value='2' selected='selected'>Monday</option><option value='3'>Tuesday</option><option value='4'>Wednesday</option><option value='5'>Thruday</option><option value='6'>Friday</option><option value='7'>Saturday</option></select>");
							sb.append("<input type='text' value='' name='course-"+node.getCourseId()+"_component-"+node.getId()+"_content-"+content.getContentId()+"_duration' class='duration number' title='Duration in Days'/>");
							sb.append("<input type='text' value='' name='course-"+node.getCourseId()+"_component-"+node.getId()+"_content-"+content.getContentId()+"_starts_at' class='starts_at' title='Starts At'/>");
							sb.append("<input type='text' value='' name='course-"+node.getCourseId()+"_component-"+node.getId()+"_content-"+content.getContentId()+"_note' class='note' title='Note'/></div>");
					//
						 
					}
				}
			}
				if (node.getChildren() != null) {
				sb.append(printTree(node.getChildren()));
			}
			
			sb.append("</div>");
			System.out.println(sb.toString());
		}
		
		return sb.toString();

	}%>