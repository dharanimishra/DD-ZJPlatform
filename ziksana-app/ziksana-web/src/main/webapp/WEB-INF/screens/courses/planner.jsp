<%@ page language="java" contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.ziksana.domain.course.NestTreeNode"%>
<%@page import="com.ziksana.domain.course.NestContentNode"%>
<%@page import="com.ziksana.domain.course.ContentType"%>

<div class="navheadlp" style="padding-left: 151px;">
	<ul>
		<li style="margin-left: 40px;"><span><img
				src="/ziksana-web/resources/images/navarrowb.png"
				style="margin-right: 10px; height: 22px;"> </span> Describe Planner</li>
		<li style="color: #f06c0b;"><span><img
				src="/ziksana-web/resources/images/navarrow.png"
				style="margin-right: 10px; height: 22px;"> </span> Planner </li>
	

	</ul>

</div>
<div id="formcontainer">

	<div class="page-header"
		style="padding-left: 0px !important; margin-bottom: 10px !important;">
		<div class="icon">
			<img
				src="${staticFileServer}resources/images/icons/information_icon.png"
				style="height: 25px;" />
		</div>
		<h1>Organize your planner for course </h1>
	</div>
	<div class="clearfix"></div>
<form onsubmit="callFunction()">
	<div id="0"> 
		<div text="${coursename}" class="planner_data" id="COURSE_${courseIds}"
		im0="${courseIcon}" im1="${courseIcon}" im2="${courseIcon}" call="1"
		open="1" select="1" parentId="0">
		<div>
		<input type='hidden' value='COURSE_${coursename}' name='node_type[]'/><input type='hidden' value='COURSE_${courseIds}' name='node_id[]'/>
		<span class='node_title'>${coursename}</span>
		<input type='text' value="" disabled="disabled" class="duration course_duration">
		<input type="text" class="start_week" placeholder="SW" disabled="disabled">
		<select disabled="disabled"><option>SDay</option></select>
		<input type="text" class="end_week" placeholder="EW" disabled="disabled">
		<select disabled="disabled"><option>EDay</option></select>
		<input type="text" class="note" placeholder="Note" disabled="disabled"/>
		</div>
		
	<%
	 	List<NestTreeNode> list = (List<NestTreeNode>) request.getAttribute("parentList");
	 	if (list != null)
	 		out.println(printTree(list));
	 %> </div> 
	 </div>
	 <hr/>
	 <div class="textAlignRight">
 	<button type="submit" class="btn blue">Save/Update</button> <button class="btn blue">Generate</button>
 	</div>
 	<hr/>
 </form>	
</div>

<style type="text/css">

.planner_data {
  background: none repeat scroll 0 0 #E5E5E5;
  padding: 0.5em;
  width: 1028px;
}
.planner_data div {
  background: none repeat scroll 0 0 #eee;
  margin: 0.75em 0;
  padding-left: 10px;
  text-align: right; 
  clear: both;
}
.planner_data > div {
  border-radius: 3px 3px 3px 3px;
  box-shadow: 0 0 2px #999999 inset;
  padding: 0.5em;
}
.planner_data > div  div { padding-left: 15px;}
.planner_data div span.node_title {
  float: left;
}
.planner_data > div > span.node_title {
  color: steelblue;
  font-weight: bold;
}
.planner_data select, .planner_data input {
  border: 1px solid #CECECE;
  font-size: 12px;
  height: 24px;
  margin: 0 0.25em;
  padding: 2px;
  text-align: left;
}
.planner_data div select {
  width: 55px;
}

.start_week, .end_week, .duration {
  width: 32px;
}

</style>
<script type="text/javascript">
function callFunction(){
	alert("Hi");
}
</script>

<%!public String printTree(List<NestTreeNode> parents) {
		StringBuffer sb = new StringBuffer();
	
		String videoIcon = "../../../../../../../../ziksana-web/resources/images/tree_icons/video.png";
		String audioIcon = "../../../../../../../../ziksana-web/resources/images/tree_icons/audio.png";
		String folderClosed = "../../../../../../../../ziksana-web/resources/images/tree_icons/folderClosed.gif";
		String folderOpen = "../../../../../../../../ziksana-web/resources/images/tree_icons/folderOpen.gif";
		String pptIcon = "../../../../../../../../ziksana-web/resources/images/tree_icons/powerpoint.png";
		String docIcon = "../../../../../../../../ziksana-web/resources/images/tree_icons/word.png";
		String excelIcon = "../../../../../../../../ziksana-web/resources/images/tree_icons/excel.png";
		String pdfIcon = "../../../../../../../../ziksana-web/resources/images/tree_icons/pdf.png";
		String imageIcon = "../../../../../../../../ziksana-web/resources/images/tree_icons/image.png";
		String noteIcon = "../../../../../../../../ziksana-web/resources/images/tree_icons/note.png";
		String linkIcon = "../../../../../../../../ziksana-web/resources/images/tree_icons/link.png";
		String chapterIcon = "../../../../../../../../ziksana-web/resources/images/tree_icons/chapter.png";
		
		for (NestTreeNode node : parents) {
			if (node.getParentLearningComponentId() == 0){
				sb.append("<div text=\"" + node.getTitle() + "\" im0=\""
						+ chapterIcon + "\" im1=\"" + chapterIcon + "\" im2=\""
						+ chapterIcon + "\" id=\"COMPONENT_" + node.getId()
						+ "\" nodeid=\"COMPONENT_" + node.getId()
						+ "\"  parentId=\"COURSE_" + node.getCourseId() + "\">");
				sb.append("<input type='hidden' value='' name='node_type[]'/><input type='hidden' value='"+ node.getId()+"' name='node_id[]'/>");
				sb.append("<span class='node_title'>" + node.getTitle() +"</span>");
				sb.append("<input type='text' value='' name='duration[]' class='duration' title='Duration in Weeks'/>");
				sb.append("<input type='text' value='' name='start_week[]' class='start_week' title='Start Week'/>");
				sb.append("<select name='start_day' title='Start Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
				sb.append("<input type='text' value='' name='end_week[]' class='end_week' title='End Week'/>");
				sb.append("<select name='end_day' title='End Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
				sb.append("<input type='text' value='' name='note[]' class='note' title='Note'/>");
				if (node.getContent() != null) {
					for (NestContentNode content : node.getContent()) {
				
						if (content.getContentType().equalsIgnoreCase(ContentType.VIDEO.getName())
								|| content.getContentType().equalsIgnoreCase(ContentType.ENHANCED_VIDEO.getName())) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ videoIcon + "\" im1=\"" + chapterIcon
									+ "\" im2=\"" + videoIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId() + "\"  parentId=\"COMPONENT_"
									+ node.getNestLearningComponentId()
									+ "\"></item>");
							sb.append("<div class='node_title'><span class='node_title'>" + content.getContentname()+"</span>");
							sb.append("<input type='text' value='' name='duration[]' class='duration' title='Duration in Weeks'/>");
							sb.append("<input type='text' value='' name='start_week[]' class='start_week' title='Start Week'/>");
							sb.append("<select name='start_day' title='Start Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='end_week[]' class='end_week' title='End Week'/>");
							sb.append("<select name='end_day' title='End Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='note[]' class='note' title='Note'/></div>");

						} else if (content.getContentType().equalsIgnoreCase(ContentType.AUDIO.getName())) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ videoIcon + "\" im1=\"" + audioIcon
									+ "\" im2=\"" + audioIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getNestLearningComponentId()
									+ "\"></item>");
							sb.append("<div class='node_title'><span class='node_title'>" + content.getContentname()+"</span>");
							sb.append("<input type='text' value='' name='duration[]' class='duration' title='Duration in Weeks'/>");
							sb.append("<input type='text' value='' name='start_week[]' class='start_week' title='Start Week'/>");
							sb.append("<select name='start_day' title='Start Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='end_week[]' class='end_week' title='End Week'/>");
							sb.append("<select name='end_day' title='End Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='note[]' class='note' title='Note'/></div>");

						} else if (content.getContentType().equalsIgnoreCase(ContentType.TEXTUAL.getName())) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ noteIcon + "\" im1=\"" + noteIcon
									+ "\" im2=\"" + noteIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getNestLearningComponentId()
									+ "\"></item>");
							sb.append("<div class='node_title'><span class='node_title'>" + content.getContentname()+"</span>");
							sb.append("<input type='text' value='' name='duration[]' class='duration' title='Duration in Weeks'/>");
							sb.append("<input type='text' value='' name='start_week[]' class='start_week' title='Start Week'/>");
							sb.append("<select name='start_day' title='Start Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='end_week[]' class='end_week' title='End Week'/>");
							sb.append("<select name='end_day' title='End Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='note[]' class='note' title='Note'/></div>");

						} else if (content.getContentType().equalsIgnoreCase(ContentType.PDF.getName())) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ pdfIcon + "\" im1=\"" + pdfIcon
									+ "\" im2=\"" + pdfIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getNestLearningComponentId()
									+ "\"></item>");
							sb.append("<div class='node_title'><span class='node_title'>" + content.getContentname()+"</span>");
							sb.append("<input type='text' value='' name='duration[]' class='duration' title='Duration in Weeks'/>");
							sb.append("<input type='text' value='' name='start_week[]' class='start_week' title='Start Week'/>");
							sb.append("<select name='start_day' title='Start Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='end_week[]' class='end_week' title='End Week'/>");
							sb.append("<select name='end_day' title='End Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='note[]' class='note' title='Note'/></div>");

						} else if (content.getContentType().equalsIgnoreCase(ContentType.DOC.getName())) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ docIcon + "\" im1=\"" + docIcon
									+ "\" im2=\"" + docIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getNestLearningComponentId()
									+ "\"></item>");
							sb.append("<div class='node_title'><span class='node_title'>" + content.getContentname()+"</span>");
							sb.append("<input type='text' value='' name='duration[]' class='duration' title='Duration in Weeks'/>");
							sb.append("<input type='text' value='' name='start_week[]' class='start_week' title='Start Week'/>");
							sb.append("<select name='start_day' title='Start Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='end_week[]' class='end_week' title='End Week'/>");
							sb.append("<select name='end_day' title='End Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='note[]' class='note' title='Note'/></div>");

						} else if (content.getContentType().equalsIgnoreCase(ContentType.PPT.getName())) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ pptIcon + "\" im1=\"" + pptIcon
									+ "\" im2=\"" + pptIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getNestLearningComponentId()
									+ "\"></item>");
							sb.append("<div class='node_title'><span class='node_title'>" + content.getContentname()+"</span>");
							sb.append("<input type='text' value='' name='duration[]' class='duration' title='Duration in Weeks'/>");
							sb.append("<input type='text' value='' name='start_week[]' class='start_week' title='Start Week'/>");
							sb.append("<select name='start_day' title='Start Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='end_week[]' class='end_week' title='End Week'/>");
							sb.append("<select name='end_day' title='End Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='note[]' class='note' title='Note'/></div>");

						} else if (content.getContentType().equalsIgnoreCase(ContentType.EXCEL.getName())) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ excelIcon + "\" im1=\"" + excelIcon
									+ "\" im2=\"" + excelIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getNestLearningComponentId()
									+ "\"></item>");
							sb.append("<div class='node_title'><span class='node_title'>" + content.getContentname()+"</span>");
							sb.append("<input type='text' value='' name='duration[]' class='duration' title='Duration in Weeks'/>");
							sb.append("<input type='text' value='' name='start_week[]' class='start_week' title='Start Week'/>");
							sb.append("<select name='start_day' title='Start Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='end_week[]' class='end_week' title='End Week'/>");
							sb.append("<select name='end_day' title='End Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='note[]' class='note' title='Note'/></div>");

						} else if (content.getContentType().equalsIgnoreCase(ContentType.IMAGE.getName())) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ imageIcon + "\" im1=\"" + imageIcon
									+ "\" im2=\"" + imageIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getNestLearningComponentId()
									+ "\"></item>");
							sb.append("<div class='node_title'><span class='node_title'>" + content.getContentname()+"</span>");
							sb.append("<input type='text' value='' name='duration[]' class='duration' title='Duration in Weeks'/>");
							sb.append("<input type='text' value='' name='start_week[]' class='start_week' title='Start Week'/>");
							sb.append("<select name='start_day' title='Start Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='end_week[]' class='end_week' title='End Week'/>");
							sb.append("<select name='end_day' title='End Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='note[]' class='note' title='Note'/></div>");

						} else if (content.getContentType().equalsIgnoreCase(ContentType.LINK.getName())) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ linkIcon + "\" im1=\"" + linkIcon
									+ "\" im2=\"" + linkIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getNestLearningComponentId()
									+ "\"></item>");
							sb.append("<div class='node_title'><span class='node_title'>" + content.getContentname()+"</span>");
							sb.append("<input type='text' value='' name='duration[]' class='duration' title='Duration in Weeks'/>");
							sb.append("<input type='text' value='' name='start_week[]' class='start_week' title='Start Week'/>");
							sb.append("<select name='start_day' title='Start Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='end_week[]' class='end_week' title='End Week'/>");
							sb.append("<select name='end_day' title='End Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='note[]' class='note' title='Note'/></div>");

						}
					}
				}
			}else{
				sb.append("<div text=\"" + node.getTitle() + "\" im0=\""
						+ chapterIcon + "\" im1=\"" + chapterIcon + "\" im2=\""
						+ chapterIcon + "\" id=\"COMPONENT_" + node.getId()
						+ "\" nodeid=\"COMPONENT_" + node.getId()
						+ "\"  parentId=\"COMPONENT_"
						+ node.getParentLearningComponentId() + "\">");
				sb.append("<input type='hidden' value='' name='node_type[]'/><input type='hidden' value='"+ node.getId()+"' name='node_id[]'/>");
				sb.append("<span class='node_title'>" + node.getTitle() +"</span>");
				sb.append("<input type='text' value='' name='duration[]' class='duration' title='Duration in Weeks'/>");
				sb.append("<input type='text' value='' name='start_week[]' class='start_week' title='Start Week'/>");
				sb.append("<select name='start_day' title='Start Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
				sb.append("<input type='text' value='' name='end_week[]' class='end_week' title='End Week'/>");
				sb.append("<select name='end_day' title='End Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
				sb.append("<input type='text' value='' name='note[]' class='note' title='Note'/>");
				if (node.getContent() != null) {
					for (NestContentNode content : node.getContent()) {
						
						if (content.getContentType().equalsIgnoreCase(ContentType.VIDEO.getName())
								|| content.getContentType().equalsIgnoreCase(ContentType.ENHANCED_VIDEO.getName())) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ videoIcon + "\" im1=\"" + chapterIcon
									+ "\" im2=\"" + videoIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId() + "\"  parentId=\"COMPONENT_"
									+ node.getNestLearningComponentId()
									+ "\"></item>");
							sb.append("<div class='node_title'><span class='node_title'>" + content.getContentname()+"</span>");
							sb.append("<input type='text' value='' name='duration[]' class='duration' title='Duration in Weeks'/>");
							sb.append("<input type='text' value='' name='start_week[]' class='start_week' title='Start Week'/>");
							sb.append("<select name='start_day' title='Start Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='end_week[]' class='end_week' title='End Week'/>");
							sb.append("<select name='end_day' title='End Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='note[]' class='note' title='Note'/></div>");

						} else if (content.getContentType().equalsIgnoreCase(ContentType.AUDIO.getName())) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ videoIcon + "\" im1=\"" + audioIcon
									+ "\" im2=\"" + audioIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getNestLearningComponentId()
									+ "\"></item>");
							sb.append("<div class='node_title'><span class='node_title'>" + content.getContentname()+"</span>");
							sb.append("<input type='text' value='' name='duration[]' class='duration' title='Duration in Weeks'/>");
							sb.append("<input type='text' value='' name='start_week[]' class='start_week' title='Start Week'/>");
							sb.append("<select name='start_day' title='Start Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='end_week[]' class='end_week' title='End Week'/>");
							sb.append("<select name='end_day' title='End Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='note[]' class='note' title='Note'/></div>");

						} else if (content.getContentType().equalsIgnoreCase(ContentType.TEXTUAL.getName())) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ noteIcon + "\" im1=\"" + noteIcon
									+ "\" im2=\"" + noteIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getNestLearningComponentId()
									+ "\"></item>");
							sb.append("<div class='node_title'><span class='node_title'>" + content.getContentname()+"</span>");
							sb.append("<input type='text' value='' name='duration[]' class='duration' title='Duration in Weeks'/>");
							sb.append("<input type='text' value='' name='start_week[]' class='start_week' title='Start Week'/>");
							sb.append("<select name='start_day' title='Start Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='end_week[]' class='end_week' title='End Week'/>");
							sb.append("<select name='end_day' title='End Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='note[]' class='note' title='Note'/></div>");

						} else if (content.getContentType().equalsIgnoreCase(ContentType.PDF.getName())) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ pdfIcon + "\" im1=\"" + pdfIcon
									+ "\" im2=\"" + pdfIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getNestLearningComponentId()
									+ "\"></item>");
							sb.append("<div class='node_title'><span class='node_title'>" + content.getContentname()+"</span>");
							sb.append("<input type='text' value='' name='duration[]' class='duration' title='Duration in Weeks'/>");
							sb.append("<input type='text' value='' name='start_week[]' class='start_week' title='Start Week'/>");
							sb.append("<select name='start_day' title='Start Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='end_week[]' class='end_week' title='End Week'/>");
							sb.append("<select name='end_day' title='End Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='note[]' class='note' title='Note'/></div>");

						} else if (content.getContentType().equalsIgnoreCase(ContentType.DOC.getName())) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ docIcon + "\" im1=\"" + docIcon
									+ "\" im2=\"" + docIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getNestLearningComponentId()
									+ "\"></item>");
							sb.append("<div class='node_title'><span class='node_title'>" + content.getContentname()+"</span>");
							sb.append("<input type='text' value='' name='duration[]' class='duration' title='Duration in Weeks'/>");
							sb.append("<input type='text' value='' name='start_week[]' class='start_week' title='Start Week'/>");
							sb.append("<select name='start_day' title='Start Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='end_week[]' class='end_week' title='End Week'/>");
							sb.append("<select name='end_day' title='End Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='note[]' class='note' title='Note'/></div>");

						} else if (content.getContentType().equalsIgnoreCase(ContentType.PPT.getName())) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ pptIcon + "\" im1=\"" + pptIcon
									+ "\" im2=\"" + pptIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getNestLearningComponentId()
									+ "\"></item>");
							sb.append("<div class='node_title'><span class='node_title'>" + content.getContentname()+"</span>");
							sb.append("<input type='text' value='' name='duration[]' class='duration' title='Duration in Weeks'/>");
							sb.append("<input type='text' value='' name='start_week[]' class='start_week' title='Start Week'/>");
							sb.append("<select name='start_day' title='Start Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='end_week[]' class='end_week' title='End Week'/>");
							sb.append("<select name='end_day' title='End Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='note[]' class='note' title='Note'/></div>");

						} else if (content.getContentType().equalsIgnoreCase(ContentType.EXCEL.getName())) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ excelIcon + "\" im1=\"" + excelIcon
									+ "\" im2=\"" + excelIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getNestLearningComponentId()
									+ "\"></item>");
							sb.append("<div class='node_title'><span class='node_title'>" + content.getContentname()+"</span>");
							sb.append("<input type='text' value='' name='duration[]' class='duration' title='Duration in Weeks'/>");
							sb.append("<input type='text' value='' name='start_week[]' class='start_week' title='Start Week'/>");
							sb.append("<select name='start_day' title='Start Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='end_week[]' class='end_week' title='End Week'/>");
							sb.append("<select name='end_day' title='End Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='note[]' class='note' title='Note'/></div>");

						} else if (content.getContentType().equalsIgnoreCase(ContentType.IMAGE.getName())) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ imageIcon + "\" im1=\"" + imageIcon
									+ "\" im2=\"" + imageIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getNestLearningComponentId()
									+ "\"></item>");
							sb.append("<div class='node_title'><span class='node_title'>" + content.getContentname()+"</span>");
							sb.append("<input type='text' value='' name='duration[]' class='duration' title='Duration in Weeks'/>");
							sb.append("<input type='text' value='' name='start_week[]' class='start_week' title='Start Week'/>");
							sb.append("<select name='start_day' title='Start Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='end_week[]' class='end_week' title='End Week'/>");
							sb.append("<select name='end_day' title='End Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='note[]' class='note' title='Note'/></div>");

						} else if (content.getContentType().equalsIgnoreCase(ContentType.LINK.getName())) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ linkIcon + "\" im1=\"" + linkIcon
									+ "\" im2=\"" + linkIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getNestLearningComponentId()
									+ "\"></item>");
							sb.append("<div class='node_title'><span class='node_title'>" + content.getContentname()+"</span>");
							sb.append("<input type='text' value='' name='duration[]' class='duration' title='Duration in Weeks'/>");
							sb.append("<input type='text' value='' name='start_week[]' class='start_week' title='Start Week'/>");
							sb.append("<select name='start_day' title='Start Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='end_week[]' class='end_week' title='End Week'/>");
							sb.append("<select name='end_day' title='End Day'><option value='0'>SUN</option><option value='1'>MON</option><option value='2'>TUE</option><option value='3'>WED</option><option value='4'>THU</option><option value='5'>FRI</option><option value='6'>SAT</option></select>");
							sb.append("<input type='text' value='' name='note[]' class='note' title='Note'/></div>");

						}
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