<%@ page language="java" contentType="text/xml"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="com.ziksana.domain.course.NestTreeNode"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<?xml version='1.0' ?>
<tree id="0"> <item text="${coursename}" id="COURSE_${courseIds}"
	im0="${courseIcon}" im1="${courseIcon}" im2="${courseIcon}" call="1"
	open="1" select="1" parentId="0"> 
<%
 	List<NestTreeNode> list = (List<NestTreeNode>) request.getAttribute("parentList");
 	if (list != null)
 		out.println(printTree(list));
 %> </item> </tree>

<%!public String printTree(List<NestTreeNode> parents) {
		StringBuffer sb = new StringBuffer();
		String chapterIcon = "../../../../../../../../ziksana-web/resources/images/tree_icons/chapter.png";
		
		for (NestTreeNode node : parents) {
			if (node.getParentLearningComponentId() == 0)
				sb.append("<item text=\"" + node.getTitle() + "\" im0=\""
						+ chapterIcon + "\" im1=\"" + chapterIcon + "\" im2=\""
						+ chapterIcon + "\" id=\"COMPONENT_" + node.getId()
						+ "\" nodeid=\"COMPONENT_" + node.getId()
						+ "\"  parentId=\"COURSE_" + node.getCourseId() + "\">");
			else
				sb.append("<item text=\"" + node.getTitle() + "\" im0=\""
						+ chapterIcon + "\" im1=\"" + chapterIcon + "\" im2=\""
						+ chapterIcon + "\" id=\"COMPONENT_" + node.getId()
						+ "\" nodeid=\"COMPONENT_" + node.getId()
						+ "\"  parentId=\"COMPONENT_"
						+ node.getParentLearningComponentId() + "\">");
			if (node.getChildren() != null) {
				sb.append(printTree(node.getChildren()));
			}
			sb.append("</item>");
		}
		return sb.toString();

	}%>











