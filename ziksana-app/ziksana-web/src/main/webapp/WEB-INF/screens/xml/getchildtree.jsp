<%@ page language="java" contentType="text/xml"%>

<%@page import="java.util.*"%>
<%@page import="com.ziksana.domain.course.NestTreeNode"%>
<%@page import="com.ziksana.domain.course.NestContentNode"%>
<%@page import="com.ziksana.domain.course.ContentType"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<?xml version='1.0' ?>
<tree id="0"> <item text="${coursename}" id="COURSE_${courseIds}"
	im0='${imagePathMap.get("courseIcon")}' im1='${imagePathMap.get("courseIcon")}' im2='${imagePathMap.get("courseIcon")}' call="1"
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

public String printTree(List<NestTreeNode> parents, Map<String, String> imagePathMap) {
		StringBuffer sb = new StringBuffer();

		for (NestTreeNode node : parents) {
			if (node.getParentLearningComponentId() == 0) {
				sb.append("<item text=\"" + node.getTitle() + "\" im0=\""
						+ imagePathMap.get("chapterIcon") + "\" im1=\"" + imagePathMap.get("chapterIcon") + "\" im2=\""
						+ imagePathMap.get("chapterIcon") + "\" id=\"COMPONENT_" + node.getId()
						+ "\" nodeid=\"COMPONENT_" + node.getId()
						+ "\"  parentId=\"COURSE_" + node.getCourseId() + "\">");
				if (node.getContent() != null) {
					for (NestContentNode content : node.getContent()) {
						if (content.getContentType().equalsIgnoreCase(ContentType.VIDEO.getName())
								|| content.getContentType().equalsIgnoreCase(ContentType.ENHANCED_VIDEO.getName())) {
							sb.append(getImagePath("videoIcon", node, content, imagePathMap));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.AUDIO.getName())) {
							sb.append(getImagePath("audioIcon", node, content, imagePathMap));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.TEXTUAL.getName())) {
							sb.append(getImagePath("noteIcon", node, content, imagePathMap));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.PDF.getName())) {
							sb.append(getImagePath("pdfIcon", node, content, imagePathMap));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.DOC.getName())) {
							sb.append(getImagePath("docIcon", node, content, imagePathMap));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.PPT.getName())) {
							sb.append(getImagePath("pptIcon", node, content, imagePathMap));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.EXCEL.getName())) {
							sb.append(getImagePath("excelIcon", node, content, imagePathMap));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.IMAGE.getName())) {
							sb.append(getImagePath("imageIcon", node, content, imagePathMap));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.LINK.getName())) {
							sb.append(getImagePath("linkIcon", node, content, imagePathMap));
						}
					}
				}
			} else {
				sb.append("<item text=\"" + node.getTitle() + "\" im0=\""
						+ imagePathMap.get("chapterIcon") + "\" im1=\"" + imagePathMap.get("chapterIcon") + "\" im2=\""
						+ imagePathMap.get("chapterIcon") + "\" id=\"COMPONENT_" + node.getId()
						+ "\" nodeid=\"COMPONENT_" + node.getId()
						+ "\"  parentId=\"COMPONENT_"
						+ node.getParentLearningComponentId() + "\">");
				if (node.getContent() != null) {
					for (NestContentNode content : node.getContent()) {
						if (content.getContentType().equalsIgnoreCase(ContentType.VIDEO.getName())
								|| content.getContentType().equalsIgnoreCase(ContentType.ENHANCED_VIDEO.getName())) {
							sb.append(getImagePath("videoIcon", node, content, imagePathMap));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.AUDIO.getName())) {
							sb.append(getImagePath("audioIcon", node, content, imagePathMap));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.TEXTUAL.getName())) {
							sb.append(getImagePath("noteIcon", node, content, imagePathMap));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.PDF.getName())) {
							sb.append(getImagePath("pdfIcon", node, content, imagePathMap));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.DOC.getName())) {
							sb.append(getImagePath("docIcon", node, content, imagePathMap));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.PPT.getName())) {
							sb.append(getImagePath("pptIcon", node, content, imagePathMap));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.EXCEL.getName())) {
							sb.append(getImagePath("excelIcon", node, content, imagePathMap));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.IMAGE.getName())) {
							sb.append(getImagePath("imageIcon", node, content, imagePathMap));
						} else if (content.getContentType().equalsIgnoreCase(ContentType.LINK.getName())) {
							sb.append(getImagePath("linkIcon", node, content, imagePathMap));
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
	
	
	private String getImagePath(String imageKey, NestTreeNode component, NestContentNode content, Map imagePathMap){
		StringBuffer sb = new StringBuffer(); 
		System.out.println(imageKey + " imagePathMap.get(imageKey) " + imagePathMap.get(imageKey));
		sb.append("<item text=\""
				+ content.getContentname() + "\" im0=\""
				+ imagePathMap.get(imageKey) + "\" im1=\"" + imagePathMap.get("chapterIcon")
				+ "\" im2=\"" + imagePathMap.get(imageKey)
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
