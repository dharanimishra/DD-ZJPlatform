<%@ page language="java" contentType="text/xml"%>
<%@page import="java.util.*"%>
<%@page import="com.ziksana.domain.course.NestTreeNode"%>
<%@page import="com.ziksana.domain.course.NestContentNode"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<course><id>${courseIds}</id><name>${coursename}</name><nodes>
<node> 
	<id>COURSE_${courseIds}</id>
 	<parentId>-1</parentId>
 	<title>${coursename}</title>
	<icon>/ziksana-web/resources/images/tree_icons/course.png</icon>
	<expanded>true</expanded>
</node> 
<%
 	List<NestTreeNode> list = (List<NestTreeNode>) request.getAttribute("parentList");
 	if (list != null){
 		out.println(printTree(list));
 	}
 %>
<%!public String printTree(List<NestTreeNode> parents) {
		StringBuffer sb = new StringBuffer();
		String chapterIcon = "../../../../../../../../ziksana-web/resources/images/tree_icons/chapter.png";
		for (NestTreeNode node : parents) {
			if (node.getParentLearningComponentId() == 0) {
				sb.append("<node>");
				sb.append("<id>LCOMPONENT_"+node.getId()+"</id>");
				sb.append("<parentId>COURSE_"+node.getCourseId()+"</parentId>");
				sb.append("<title>"+node.getTitle()+"</title>");
				sb.append("<icon>"+chapterIcon+"</icon>");
				sb.append("<expanded>true</expanded>");
				sb.append("</node>");
			} else {
				sb.append("<node>");
				sb.append("<id>LCOMPONENT_"+node.getId()+"</id>");
				sb.append("<parentId>LCOMPONENT_"+node.getParentLearningComponentId()+"</parentId>");
				sb.append("<title>"+node.getTitle()+"</title>");
				sb.append("<icon>"+chapterIcon+"</icon>");
				sb.append("<expanded>true</expanded>");
				sb.append("</node>");	
			}
			if (node.getChildren() != null) {
				sb.append(printTree(node.getChildren()));
			}
		}	
	
		return sb.toString();

	}%>
	
<%
 	List<NestTreeNode> childlist = (List<NestTreeNode>) request.getAttribute("parentList");
 	
	if (childlist != null){
 		out.println(childTree(childlist));
 	}
 %>
	
	<%!public String childTree(List<NestTreeNode> parents) {
		StringBuffer sb = new StringBuffer();
		String chapterIcon = "../../../../../../../../ziksana-web/resources/images/tree_icons/chapter.png";
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
		String wordIcon = "../../../../../../../../ziksana-web/resources/images/tree_icons/word.png";
		
	
		for (NestTreeNode node : parents) {	
				if (node.getContent() != null) {
					for (NestContentNode content : node.getContent()) {
						if (content.getContentType().equals("1")
								|| content.getContentType().equals("11")) {	
							sb.append("<node>");
							sb.append("<id>LCONTENT_"+content.getContentType()+"_"+node.getNestLearningComponentId()+"_"+content.getContentId()+"</id>");
							sb.append("<parentId>LCOMPONENT_"+node.getNestLearningComponentId()+"</parentId>");
							sb.append("<title>"+content.getContentname()+"</title>");
							sb.append("<icon>"+videoIcon+"</icon>");
							sb.append("<expanded>true</expanded>");
							sb.append("</node>");

						} else if (content.getContentType().equals("2")) {
							sb.append("<node>");
							sb.append("<id>LCONTENT_"+content.getContentType()+"_"+node.getNestLearningComponentId()+"_"+content.getContentId()+"</id>");
							sb.append("<parentId>LCOMPONENT_"+node.getNestLearningComponentId()+"</parentId>");
							sb.append("<title>"+content.getContentname()+"</title>");
							sb.append("<icon>"+audioIcon+"</icon>");
							sb.append("<expanded>true</expanded>");
							sb.append("</node>");
						} else if (content.getContentType().equals("3")) {
							sb.append("<node>");
							sb.append("<id>LCONTENT_"+content.getContentType()+"_"+node.getNestLearningComponentId()+"_"+content.getContentId()+"</id>");
							sb.append("<parentId>LCOMPONENT_"+node.getNestLearningComponentId()+"</parentId>");
							sb.append("<title>"+content.getContentname()+"</title>");
							sb.append("<icon>"+noteIcon+"</icon>");
							sb.append("<expanded>true</expanded>");
							sb.append("</node>");
						} else if (content.getContentType().equals("4")) {
							sb.append("<node>");
							sb.append("<id>LCONTENT_"+content.getContentType()+"_"+node.getNestLearningComponentId()+"_"+content.getContentId()+"</id>");
							sb.append("<parentId>LCOMPONENT_"+node.getNestLearningComponentId()+"</parentId>");
							sb.append("<title>"+content.getContentname()+"</title>");
							sb.append("<icon>"+pdfIcon+"</icon>");
							sb.append("<expanded>true</expanded>");
							sb.append("</node>");
						} else if (content.getContentType().equals("5")) {
							sb.append("<node>");
							sb.append("<id>LCONTENT_"+content.getContentType()+"_"+node.getNestLearningComponentId()+"_"+content.getContentId()+"</id>");
							sb.append("<parentId>LCOMPONENT_"+node.getNestLearningComponentId()+"</parentId>");
							sb.append("<title>"+content.getContentname()+"</title>");
							sb.append("<icon>"+wordIcon+"</icon>");
							sb.append("<expanded>true</expanded>");
							sb.append("</node>");
						} else if (content.getContentType().equals("6")) {
							sb.append("<node>");
							sb.append("<id>LCONTENT_"+content.getContentType()+"_"+node.getNestLearningComponentId()+"_"+content.getContentId()+"</id>");
							sb.append("<parentId>LCOMPONENT_"+node.getNestLearningComponentId()+"</parentId>");
							sb.append("<title>"+content.getContentname()+"</title>");
							sb.append("<icon>"+pptIcon+"</icon>");
							sb.append("<expanded>true</expanded>");
							sb.append("</node>");

						} else if (content.getContentType().equals("7")) {
							sb.append("<node>");
							sb.append("<id>LCONTENT_"+content.getContentType()+"_"+node.getNestLearningComponentId()+"_"+content.getContentId()+"</id>");
							sb.append("<parentId>LCOMPONENT_"+node.getNestLearningComponentId()+"</parentId>");
							sb.append("<title>"+content.getContentname()+"</title>");
							sb.append("<icon>"+excelIcon+"</icon>");
							sb.append("<expanded>true</expanded>");
							sb.append("</node>");
						} else if (content.getContentType().equals("8")) {
							sb.append("<node>");
							sb.append("<id>LCONTENT_"+content.getContentType()+"_"+node.getNestLearningComponentId()+"_"+content.getContentId()+"</id>");
							sb.append("<parentId>LCOMPONENT_"+node.getNestLearningComponentId()+"</parentId>");
							sb.append("<title>"+content.getContentname()+"</title>");
							sb.append("<icon>"+imageIcon+"</icon>");
							sb.append("<expanded>true</expanded>");
							sb.append("</node>");
						} else if (content.getContentType().equals("9")) {
							sb.append("<node>");
							sb.append("<id>LCONTENT_"+content.getContentType()+"_"+node.getNestLearningComponentId()+"_"+content.getContentId()+"</id>");
							sb.append("<parentId>LCOMPONENT_"+node.getNestLearningComponentId()+"</parentId>");
							sb.append("<title>"+content.getContentname()+"</title>");
							sb.append("<icon>"+linkIcon+"</icon>");
							sb.append("<expanded>true</expanded>");
							sb.append("</node>");
						}else{
							sb.append("<node>");
							sb.append("<id>LCONTENT_"+content.getContentType()+"_"+node.getNestLearningComponentId()+"_"+content.getContentId()+"</id>");
							sb.append("<parentId>LCOMPONENT_"+node.getNestLearningComponentId()+"</parentId>");
							sb.append("<title>"+content.getContentname()+"</title>");
							sb.append("<icon>"+imageIcon+"</icon>");
							sb.append("<expanded>true</expanded>");
							sb.append("</node>");
						}		
				}
			}
			if (node.getChildren() != null) {
				sb.append(childTree(node.getChildren()));
			}
		}
		return sb.toString();
	}%> 
</nodes> 
</course>