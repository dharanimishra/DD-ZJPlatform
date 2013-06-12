<%@ page language="java" contentType="text/xml"%>

<%@page import="java.util.*"%>
<%@page import="com.ziksana.domain.course.NestTreeNode"%>
<%@page import="com.ziksana.domain.course.NestContentNode"%>
<%@page import="com.ziksana.domain.course.ContentType"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<?xml version='1.0' ?>
<tree id="0"> <item text="${coursename}" id="COURSE_${courseIds}"
	im0="${courseIcon}" im1="${courseIcon}" im2="${courseIcon}" call="1"
	open="1" select="1" parentId="0"> <%
 	List<NestTreeNode> list = (List<NestTreeNode>) request
 			.getAttribute("parentList");
 	Map<String, String> imagePathMap = (Map<String, String>) request
 			.getAttribute("imagePathMap");
 	if (list != null)
 		out.println(printTree(list, imagePathMap));
 %> </item> </tree>

<%--
static String chapterIcon;
static String videoIcon;
static 	String audioIcon;
static 	String folderClosed;
static String folderOpen;
static String pptIcon;
static String docIcon;
static String excelIcon;
static String pdfIcon;
static String imageIcon;
static String noteIcon;
static String linkIcon;


	chapterIcon = (String) request.getAttribute("chapterIcon");
	videoIcon = (String) request.getAttribute("videoIcon");
	audioIcon = (String) request.getAttribute("audioIcon");
	folderClosed = (String) request.getAttribute("folderClosed");
	folderOpen = (String) request.getAttribute("folderOpen");
	pptIcon = (String) request.getAttribute("pptIcon");
	docIcon = (String) request.getAttribute("docIcon");
	excelIcon = (String) request.getAttribute("excelIcon");
	pdfIcon = (String) request.getAttribute("pdfIcon");
	imageIcon = (String) request.getAttribute("imageIcon");
	noteIcon = (String) request.getAttribute("noteIcon");
	linkIcon = (String) request.getAttribute("linkIcon");
--%>
	
<%!
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

public String printTree(List<NestTreeNode> parents, Map<String, String> imagePathMap) {
		StringBuffer sb = new StringBuffer();

		for (NestTreeNode node : parents) {
			if (node.getParentLearningComponentId() == 0) {
				sb.append("<item text=\"" + node.getTitle() + "\" im0=\""
						+ chapterIcon + "\" im1=\"" + chapterIcon + "\" im2=\""
						+ chapterIcon + "\" id=\"COMPONENT_" + node.getId()
						+ "\" nodeid=\"COMPONENT_" + node.getId()
						+ "\"  parentId=\"COURSE_" + node.getCourseId() + "\">");
				if (node.getContent() != null) {
					for (NestContentNode content : node.getContent()) {
						if (content.getContentType().equalsIgnoreCase(ContentType.VIDEO.getName())
								|| content.getContentType().equalsIgnoreCase(ContentType.ENHANCED_VIDEO.getName())) {
							sb.append(getImagePath(imagePathMap.get("videoIcon"), node, content));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.AUDIO.getName())) {
							sb.append(getImagePath(imagePathMap.get("audioIcon"), node, content));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.TEXTUAL.getName())) {
							sb.append(getImagePath(imagePathMap.get("noteIcon"), node, content));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.PDF.getName())) {
							sb.append(getImagePath(imagePathMap.get("pdfIcon"), node, content));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.DOC.getName())) {
							sb.append(getImagePath(imagePathMap.get("docIcon"), node, content));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.PPT.getName())) {
							sb.append(getImagePath(imagePathMap.get("pptIcon"), node, content));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.EXCEL.getName())) {
							sb.append(getImagePath(imagePathMap.get("excelIcon"), node, content));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.IMAGE.getName())) {
							sb.append(getImagePath(imagePathMap.get("imageIcon"), node, content));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.LINK.getName())) {
							sb.append(getImagePath(imagePathMap.get("linkIcon"), node, content));
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
						if (content.getContentType().equalsIgnoreCase(ContentType.VIDEO.getName())
								|| content.getContentType().equalsIgnoreCase(ContentType.ENHANCED_VIDEO.getName())) {
							sb.append(getImagePath(videoIcon, node, content));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.AUDIO.getName())) {
							sb.append(getImagePath(audioIcon, node, content));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.TEXTUAL.getName())) {
							sb.append(getImagePath(noteIcon, node, content));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.PDF.getName())) {
							sb.append(getImagePath(pdfIcon, node, content));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.DOC.getName())) {
							sb.append(getImagePath(docIcon, node, content));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.PPT.getName())) {
							sb.append(getImagePath(pptIcon, node, content));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.EXCEL.getName())) {
							sb.append(getImagePath(excelIcon, node, content));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.IMAGE.getName())) {
							sb.append(getImagePath(imageIcon, node, content));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.LINK.getName())) {
							sb.append(getImagePath(linkIcon, node, content));
						}
					}
				}
			}
			if (node.getChildren() != null) {
				sb.append(printTree(node.getChildren(), imagePathMap));
			}
			sb.append("</item>");
		}
		return sb.toString();

	}
	
	
	private String getImagePath(String baseImagePath, NestTreeNode component, NestContentNode content){
		StringBuffer sb = new StringBuffer(); 
		sb.append("<item text=\""
				+ content.getContentname() + "\" im0=\""
				+ baseImagePath + "\" im1=\"" + chapterIcon
				+ "\" im2=\"" + baseImagePath
				+ "\" id=\"CONTENT_"
				+ content.getContentId()
				+ "\" nodeid=\"CONTENT_"
				+ content.getContentId() + "\"  parentId=\"COMPONENT_"
				+ component.getNestLearningComponentId()
				+ "\"  decorationType=\""
				+ content.getDecorationType()
				+ "\"></item>");

		return sb.toString();		
	}
	
	
	%>
