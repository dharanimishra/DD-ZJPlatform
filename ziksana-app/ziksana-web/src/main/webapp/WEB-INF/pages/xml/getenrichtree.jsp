<%@ page language="java" contentType="text/xml"%>

<%@page import="java.util.*"%>
<%@page import="com.ziksana.domain.course.NestTreeNode"%>
<%@page import="com.ziksana.domain.course.NestContentNode"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<?xml version='1.0' ?>
<tree id="0"> <item text="${coursename}" id="COURSE_${courseIds}"
	im0="${courseIcon}" im1="${courseIcon}" im2="${courseIcon}" call="1"
	open="1" select="1" parentId="0"> <%
 	List<NestTreeNode> list = (List<NestTreeNode>) request
 			.getAttribute("parentList");
 	if (list != null)
 		out.println(printTree(list));
 %> </item> </tree>

<%!public String printTree(List<NestTreeNode> parents) {
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

		for (NestTreeNode node : parents) {
			if (node.getParentLearningComponentId() == 0) {
				sb.append("<item text=\"" + node.getTitle() + "\" im0=\""
						+ chapterIcon + "\" im1=\"" + chapterIcon + "\" im2=\""
						+ chapterIcon + "\" id=\"COMPONENT_" + node.getId()
						+ "\" nodeid=\"COMPONENT_" + node.getId()
						+ "\"  parentId=\"COURSE_" + node.getCourseId() + "\">");
				if (node.getContent() != null) {
					for (NestContentNode content : node.getContent()) {
						if (content.getContentType().equals("1")
								|| content.getContentType().equals("11")) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ videoIcon + "\" im1=\"" + chapterIcon
									+ "\" im2=\"" + videoIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()+"_"+content.getContentType()
									+ "\" nodeid=\"CONTENT_"+ content.getContentId()
									+ " parentId=\"COMPONENT_"+ node.getParentLearningComponentId()
									+ "\"></item>");
							
						} else if (content.getContentType().equals("2")) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ videoIcon + "\" im1=\"" + audioIcon
									+ "\" im2=\"" + audioIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()+"_"+content.getContentType()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getParentLearningComponentId()
									+ "\"></item>");

						} else if (content.getContentType().equals("3")) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ noteIcon + "\" im1=\"" + noteIcon
									+ "\" im2=\"" + noteIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()+"_"+content.getContentType()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getParentLearningComponentId()
									+ "\"></item>");

						} else if (content.getContentType().equals("4")) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ pdfIcon + "\" im1=\"" + pdfIcon
									+ "\" im2=\"" + pdfIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()+"_"+content.getContentType()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getParentLearningComponentId()
									+ "\"></item>");

						} else if (content.getContentType().equals("5")) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ docIcon + "\" im1=\"" + docIcon
									+ "\" im2=\"" + docIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()+"_"+content.getContentType()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getParentLearningComponentId()
									+ "\"></item>");

						} else if (content.getContentType().equals("6")) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ pptIcon + "\" im1=\"" + pptIcon
									+ "\" im2=\"" + pptIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()+"_"+content.getContentType()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getParentLearningComponentId()
									+ "\"></item>");

						} else if (content.getContentType().equals("7")) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ excelIcon + "\" im1=\"" + excelIcon
									+ "\" im2=\"" + excelIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()+"_"+content.getContentType()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getParentLearningComponentId()
									+ "\"></item>");

						} else if (content.getContentType().equals("8")) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ imageIcon + "\" im1=\"" + imageIcon
									+ "\" im2=\"" + imageIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()+"_"+content.getContentType()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getParentLearningComponentId()
									+ "\"></item>");

						} else if (content.getContentType().equals("9")) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ linkIcon + "\" im1=\"" + linkIcon
									+ "\" im2=\"" + linkIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()+"_"+content.getContentType()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getParentLearningComponentId()
									+ "\"></item>");

						}
					}
				}
			} else {
				sb.append("<item text=\"" + node.getTitle() + "\" im0=\""
						+ chapterIcon + "\" im1=\"" + chapterIcon + "\" im2=\""
						+ chapterIcon + "\" id=\"COMPONENT_" + node.getId()
						+ "\" nodeid=\"COMPONENT_" + node.getId()
						+ "\"  parentId=\"COMPONENT_"
						+ node.getParentLearningComponentId() + "\">");
				if (node.getContent() != null) {
					for (NestContentNode content : node.getContent()) {
						if (content.getContentType().equals("1")
								|| content.getContentType().equals("11")) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ videoIcon + "\" im1=\"" + chapterIcon
									+ "\" im2=\"" + videoIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()+"_"+content.getContentType()
									+ "\" nodeid=\"CONTENT_"+ content.getContentId()+"_"+content.getContentType()+"\"  parentId=\"COMPONENT_"
									+ node.getParentLearningComponentId()
									+ "\"></item>");
						} else if (content.getContentType().equals("2")) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ videoIcon + "\" im1=\"" + audioIcon
									+ "\" im2=\"" + audioIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()+"_"+content.getContentType()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getParentLearningComponentId()
									+ "\"></item>");

						} else if (content.getContentType().equals("3")) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ noteIcon + "\" im1=\"" + noteIcon
									+ "\" im2=\"" + noteIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()+"_"+content.getContentType()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getParentLearningComponentId()
									+ "\"></item>");

						} else if (content.getContentType().equals("4")) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ pdfIcon + "\" im1=\"" + pdfIcon
									+ "\" im2=\"" + pdfIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()+"_"+content.getContentType()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getParentLearningComponentId()
									+ "\"></item>");

						} else if (content.getContentType().equals("5")) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ docIcon + "\" im1=\"" + docIcon
									+ "\" im2=\"" + docIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()+"_"+content.getContentType()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getParentLearningComponentId()
									+ "\"></item>");

						} else if (content.getContentType().equals("6")) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ pptIcon + "\" im1=\"" + pptIcon
									+ "\" im2=\"" + pptIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()+"_"+content.getContentType()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getParentLearningComponentId()
									+ "\"></item>");

						} else if (content.getContentType().equals("7")) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ excelIcon + "\" im1=\"" + excelIcon
									+ "\" im2=\"" + excelIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()+"_"+content.getContentType()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getParentLearningComponentId()
									+ "\"></item>");

						} else if (content.getContentType().equals("8")) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ imageIcon + "\" im1=\"" + imageIcon
									+ "\" im2=\"" + imageIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()+"_"+content.getContentType()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getParentLearningComponentId()
									+ "\"></item>");

						} else if (content.getContentType().equals("9")) {
							sb.append("<item text=\""
									+ content.getContentname() + "\" im0=\""
									+ linkIcon + "\" im1=\"" + linkIcon
									+ "\" im2=\"" + linkIcon
									+ "\" id=\"CONTENT_"
									+ content.getContentId()+"_"+content.getContentType()
									+ "\" nodeid=\"CONTENT_"
									+ content.getContentId()
									+ "\"  parentId=\"COMPONENT_"
									+ node.getParentLearningComponentId()
									+ "\"></item>");

						}
					}
				}
			}
			if (node.getChildren() != null) {
				sb.append(printTree(node.getChildren()));
			}
			sb.append("</item>");
		}
		return sb.toString();

	}%>
