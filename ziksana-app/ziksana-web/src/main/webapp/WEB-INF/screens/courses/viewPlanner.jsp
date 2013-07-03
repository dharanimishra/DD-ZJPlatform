<%@ page language="java" contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.ziksana.domain.course.NestTreeNode"%>
<%@page import="com.ziksana.domain.course.NestContentNode"%>
<%@page import="com.ziksana.domain.course.ContentType"%>

<div class="navheadlp" style="padding-left: 20px;">
	<ul>
		<a href="/ziksana-web/zcourse/1/planner/${courseIds}" >
		<li style="margin-left: 40px; color: #f06c0b;"><span><img
				src="/ziksana-web/resources/images/navarrow.png"
				style="margin-right: 10px; height: 22px;"> </span>Define Planner</li></a>
		<li style=""><span><img
				src="/ziksana-web/resources/images/navarrowb.png"
				style="margin-right: 10px; height: 22px;"> </span>Review Playbook </li>
	

	</ul>

</div>
<div id="formcontainer">

<%-- 	<div class="page-header"
		style="padding-left: 0px !important; margin-bottom: 10px !important;">
		<div class="icon">
			<img
				src="${staticFileServer}resources/images/icons/information_icon.png"
				style="height: 25px;" />
		</div>
		<h1>Create Planner</h1>
	</div> --%>
	<div class="clearfix"></div>

	<input id="courseId" type='hidden' value='${courseIds}' name='course_id'/>
	<input id="course_duration_in_days" type="hidden" value="70" name="course_duration_in_days" />
	<div id="planner_error"></div>
	<div id="planner_container"> 
		<div class="planner_data planner-${courseIds}" id="planner_data">

		<div id="course-${courseIds}" >
			<div class='node_bar course_node' style=""><img class="node_icon" src="${courseIcon}"/> <span class="node_title">${coursename}</span></div>
		</div>
		
	<% List<NestTreeNode> list = (List<NestTreeNode>) request.getAttribute("parentList");
	 	if (list != null)
	 		out.println(printTree(list));
	 %> </div> 
	 </div>
	 <hr/>
	
</div>

<style type="text/css">

#planner_container {padding: .5em; border: 1px solid silver; width: 1000px; overflow: auto; }
#planner_data {
  background: url('/ziksana-web/resources/images/planner_bg_week.png') repeat scroll -24px 0 #fefefe; 
}
#planner_data div {
  margin: 1px 0;
  clear: both;
  position: relative;
}

.node_bar {
	background: #7abcff;
	background: -moz-linear-gradient(top,  #7abcff 0%, #60abf8 44%, #4096ee 100%);
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#7abcff), color-stop(44%,#60abf8), color-stop(100%,#4096ee));
	background: -webkit-linear-gradient(top,  #7abcff 0%,#60abf8 44%,#4096ee 100%);
	background: -o-linear-gradient(top,  #7abcff 0%,#60abf8 44%,#4096ee 100%);
	background: -ms-linear-gradient(top,  #7abcff 0%,#60abf8 44%,#4096ee 100%);
	background: linear-gradient(to bottom,  #7abcff 0%,#60abf8 44%,#4096ee 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#7abcff', endColorstr='#4096ee',GradientType=0 );

  height: 20px;
  margin: 2px 0;
  color: white;
  display: inline-block;
  position: relative;
  border-radius: 2px;
  padding: 0 2.5px;
}
.node_bar.module_node {
background: #ffc578;
background: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPGxpbmVhckdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgeDE9IjAlIiB5MT0iMCUiIHgyPSIwJSIgeTI9IjEwMCUiPgogICAgPHN0b3Agb2Zmc2V0PSIwJSIgc3RvcC1jb2xvcj0iI2ZmYzU3OCIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjEwMCUiIHN0b3AtY29sb3I9IiNmYjlkMjMiIHN0b3Atb3BhY2l0eT0iMSIvPgogIDwvbGluZWFyR3JhZGllbnQ+CiAgPHJlY3QgeD0iMCIgeT0iMCIgd2lkdGg9IjEiIGhlaWdodD0iMSIgZmlsbD0idXJsKCNncmFkLXVjZ2ctZ2VuZXJhdGVkKSIgLz4KPC9zdmc+);
background: -moz-linear-gradient(top,  #ffc578 0%, #fb9d23 100%);
background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#ffc578), color-stop(100%,#fb9d23));
background: -webkit-linear-gradient(top,  #ffc578 0%,#fb9d23 100%);
background: -o-linear-gradient(top,  #ffc578 0%,#fb9d23 100%);
background: -ms-linear-gradient(top,  #ffc578 0%,#fb9d23 100%);
background: linear-gradient(to bottom,  #ffc578 0%,#fb9d23 100%);
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#ffc578', endColorstr='#fb9d23',GradientType=0 );

}
.node_bar.course_node {
background: #9dd53a;
background: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPGxpbmVhckdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgeDE9IjAlIiB5MT0iMCUiIHgyPSIwJSIgeTI9IjEwMCUiPgogICAgPHN0b3Agb2Zmc2V0PSIwJSIgc3RvcC1jb2xvcj0iIzlkZDUzYSIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjUwJSIgc3RvcC1jb2xvcj0iI2ExZDU0ZiIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjUxJSIgc3RvcC1jb2xvcj0iIzgwYzIxNyIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjEwMCUiIHN0b3AtY29sb3I9IiM3Y2JjMGEiIHN0b3Atb3BhY2l0eT0iMSIvPgogIDwvbGluZWFyR3JhZGllbnQ+CiAgPHJlY3QgeD0iMCIgeT0iMCIgd2lkdGg9IjEiIGhlaWdodD0iMSIgZmlsbD0idXJsKCNncmFkLXVjZ2ctZ2VuZXJhdGVkKSIgLz4KPC9zdmc+);
background: -moz-linear-gradient(top,  #9dd53a 0%, #a1d54f 50%, #80c217 51%, #7cbc0a 100%);
background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#9dd53a), color-stop(50%,#a1d54f), color-stop(51%,#80c217), color-stop(100%,#7cbc0a));
background: -webkit-linear-gradient(top,  #9dd53a 0%,#a1d54f 50%,#80c217 51%,#7cbc0a 100%);
background: -o-linear-gradient(top,  #9dd53a 0%,#a1d54f 50%,#80c217 51%,#7cbc0a 100%);
background: -ms-linear-gradient(top,  #9dd53a 0%,#a1d54f 50%,#80c217 51%,#7cbc0a 100%);
background: linear-gradient(to bottom,  #9dd53a 0%,#a1d54f 50%,#80c217 51%,#7cbc0a 100%);
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#9dd53a', endColorstr='#7cbc0a',GradientType=0 );

}

.node_bar span.node_title {
  position: absolute;
  word-break: break-all;
}

.tip {
  background: none repeat scroll 0 0 #222222;
  border-radius: 3px 3px 3px 3px;
  border: 2px solid white;
  color: white;
  min-width: 150px;
  padding: 0.5em;
  position: absolute;
  display: none;
  top: 20px;
  z-index: 999;
  box-shadow: 0 0 4px #222;
  opacity: 0.8;
  max-width: 300px;
}
.tip hr {margin: .5em 0; color: silver;}
.tip strong {color: sandybrown; }
.node_bar:hover .tip {display: inline-block;}

.node_icon {
  height: 18px;
  margin-right: 0.25em;
  vertical-align: top;
  width: 18px;
}




</style>
<script type="text/javascript">

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
						
						unique_id = node.nodeUniqueId;
						console.log('unique i'+unique_id);
						course_id = node.courseId;
						duration = node.duration;
						component_id = node.learningComponentId;
						content_id = node.learningContentId;
						note = node.note;
						start_day = node.startDay;
						start_week = node.startWeek;
						starts_at = node.startsAt;

						
						node_div = $('#'+unique_id);
						node_bar = node_div.find('> .node_bar');
						node_title = node_bar.find('.node_title').text();
						
						
						node_bar_width = ((duration * square_pixel)-5)+'px';
						node_bar_left_margin = ((starts_at * square_pixel)-square_pixel)+'px';
						

						
						tooltip_html = '<span class="tip">';
						tooltip_html += '<strong>'+node_title+'</strong><hr/>';
						tooltip_html += '<strong>Start Week: </strong>'+start_week;
						tooltip_html += '<br/><strong>Start Day: </strong>'+start_day;
						tooltip_html += '<br/><strong>Duration: </strong>'+duration+'days ('+Math.floor(duration/7)+' weeks)';
						tooltip_html += '<br/><strong>Note: </strong>'+note;
						
						tooltip_html += '</span>';
						node_bar.append(tooltip_html).css({'width': node_bar_width, 'left': node_bar_left_margin});;
						
						
				
				}//end of for loop
				
			$('#planner_data').css({'width': course_pixellength});	
			$('.node_bar').first().css({'width': course_pixellength});
			
			}//end of ajax success function

		});
}


function create_node_unique_id(course_id, component_id, content_id){
	var id = '';
	if(course_id != ''){ id += 'course-'+course_id; }
	if(component_id != ''){ id += '_component-'+component_id; }
	if(content_id != ''){ id += '_content-'+content_id; }
	return id;
}

$(function(){
	$( document ).tooltip(); //enable tooltip
	
	get_and_populate_planner_data($('#courseId').val());
//reset planner node values
$('.start_week, .start_day').val('0');
$('.duration:not(#course_duration_in_days), .starts_at').val('');
	
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


// Duration Validation
$('.duration').change(function(){
    duration_input = $(this);
    
    $('#planner_error').html('');
    		
    duration_input.removeClass('duration_error');
    duration = parseInt(duration_input.val());
    parent_duration = parseInt(duration_input.parent('div').parent('div').find('> .duration').val());
    console.log(duration_input);
    console.log('duration :'+ duration);
    console.log('parend duration: '+ parent_duration);
    
    course_duration = parseInt($('#course_duration_in_days').val());
    if(duration > parent_duration){
        duration_input.addClass('duration_error');
        $('#planner_error').html('The node duration <strong>'+duration+'</strong> exceeds its parent node duration of <strong>'+parent_duration+'</strong> Days.').focus();
    } 
    
    
});
//end of duration validation


});// end of doc ready









</script>
<%!
	public String build_options_for_startweek(){
	String option_html = "";
	int total_no_of_weeks = 35;
	option_html += "<option value='' selected='selected'>Start Week</option>";
	for(int i=1; i<=total_no_of_weeks; i++){
		option_html += "<option value='"+i+"'>Week "+i+"</option>";
	}
	return option_html;
}


%>

<%!public String printTree(List<NestTreeNode> parents) {
		StringBuffer sb = new StringBuffer();
	
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
				//node_unique_id += "course-"+course_id
				sb.append("<div id='course-"+node.getCourseId()+"_component-"+node.getId()+"'>");
				sb.append("<div class='node_bar module_node'><img class='node_icon' src='"+folderOpen+"'/> <span class='node_title'>" + node.getTitle() +"</span></div>");

				if (node.getContent() != null) {
					for (NestContentNode content : node.getContent()) {
						
						sb.append("<div id='course-"+node.getCourseId()+"_component-"+node.getId()+"_content-"+content.getContentId()+"'>");
						
						String icon = "";
						
						if (content.getContentType().equalsIgnoreCase(ContentType.VIDEO.getName()) || content.getContentType().equalsIgnoreCase(ContentType.ENHANCED_VIDEO.getName())) {
							
							icon = videoIcon;

						}else if (content.getContentType().equalsIgnoreCase(ContentType.AUDIO.getName())) {
							icon = audioIcon;
						}else if (content.getContentType().equalsIgnoreCase(ContentType.TEXTUAL.getName())) {
							icon = noteIcon;

						}else if (content.getContentType().equalsIgnoreCase(ContentType.PDF.getName())) {
							icon = pdfIcon;

						} else if (content.getContentType().equalsIgnoreCase(ContentType.DOC.getName())) {
							icon = docIcon;

						}else if (content.getContentType().equalsIgnoreCase(ContentType.PPT.getName())) {
							icon = pptIcon;

						}else if (content.getContentType().equalsIgnoreCase(ContentType.EXCEL.getName())) {
							icon = excelIcon;

						}else if (content.getContentType().equalsIgnoreCase(ContentType.IMAGE.getName())) {
							icon = imageIcon;
						}else if (content.getContentType().equalsIgnoreCase(ContentType.LINK.getName())) {
							icon = linkIcon;
						}
						
						//    
							sb.append("<div class='node_bar'><img class='node_icon' src='"+icon+"'/> <span class='node_title'>" + content.getContentname()+"</span></div>");
							sb.append("</div>");
						//
							

						
					}
				}
			}else{
				sb.append("<div id='course-"+node.getCourseId()+"_component-"+node.getId()+"'>");
				sb.append("<div class='node_bar module_node'><img class='node_icon' src='"+folderOpen+"'/> <span class='node_title'>" + node.getTitle() +"</span></div>");

				if (node.getContent() != null) {
					for (NestContentNode content : node.getContent()) {
						
				
						sb.append("<div id='course-"+node.getCourseId()+"_component-"+node.getId()+"_content-"+content.getContentId()+"'>");
String icon = "";
						
						if (content.getContentType().equalsIgnoreCase(ContentType.VIDEO.getName()) || content.getContentType().equalsIgnoreCase(ContentType.ENHANCED_VIDEO.getName())) {
							
							icon = videoIcon;

						}else if (content.getContentType().equalsIgnoreCase(ContentType.AUDIO.getName())) {
							icon = audioIcon;
						}else if (content.getContentType().equalsIgnoreCase(ContentType.TEXTUAL.getName())) {
							icon = noteIcon;

						}else if (content.getContentType().equalsIgnoreCase(ContentType.PDF.getName())) {
							icon = pdfIcon;

						} else if (content.getContentType().equalsIgnoreCase(ContentType.DOC.getName())) {
							icon = docIcon;

						}else if (content.getContentType().equalsIgnoreCase(ContentType.PPT.getName())) {
							icon = pptIcon;

						}else if (content.getContentType().equalsIgnoreCase(ContentType.EXCEL.getName())) {
							icon = excelIcon;

						}else if (content.getContentType().equalsIgnoreCase(ContentType.IMAGE.getName())) {
							icon = imageIcon;
						}else if (content.getContentType().equalsIgnoreCase(ContentType.LINK.getName())) {
							icon = linkIcon;
						}
						
						//    
							sb.append("<div class='node_bar'><img class='node_icon' src='"+icon+"'/> <span class='node_title'>" + content.getContentname()+"</span></div>");
							sb.append("</div>");
						 
					}
				}
			}
				if (node.getChildren() != null) {
				sb.append(printTree(node.getChildren()));
			}
			
			sb.append("</div>");
			
		}
		return sb.toString();

	}%>