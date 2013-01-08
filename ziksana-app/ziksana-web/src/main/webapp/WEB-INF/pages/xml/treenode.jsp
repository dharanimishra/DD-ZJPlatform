<%@ page language="java" contentType="text/xml"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<course> <id>${courseIds}</id> <name>${coursename}</name> <nodes>
<node> <id>COURSE_${courseIds}</id> <parentId>-1</parentId> <title>${coursename}</title>
<icon>../resources/images/tree_icons/course.png</icon> <expanded>true</expanded>
</node> <c:forEach var="treenode" items="${treeList}">
	<node> <id>LCOMPONENT_${treenode.id}</id> <parentId>COURSE_${courseIds}</parentId>
	<title>${treenode.title}</title> <icon>${parentIcon}</icon> <expanded>${treenode.expanded}</expanded>
	</node>
</c:forEach> <c:forEach var="childtreenode" items="${childList}">
	<node> <id>LCONTENT_${childtreenode.contentType}_${childtreenode.parentId}_${childtreenode.id}</id>
	<parentId>LCOMPONENT_${childtreenode.parentId}</parentId> <title>${childtreenode.contentname}</title>

	<!--  we need to check the content type..and populate the icon based on the content type  -->

	<c:choose>
		<c:when test="${childtreenode.contentType == 1}">
			<icon>${videoIcon}</icon>
		</c:when>
		<c:when test="${childtreenode.contentType == 2}">
			<icon>${audioIcon}</icon>
		</c:when>
		<c:when test="${childtreenode.contentType == 3}">
			<icon>${pdfIcon}</icon>
		</c:when>
		<c:when test="${childtreenode.contentType == 4}">
			<icon>${wordIcon}</icon>
		</c:when>
		<c:when test="${childtreenode.contentType == 5}">
			<icon>${pptIcon}</icon>
		</c:when>

		<c:otherwise>
			<icon>${docIcon}</icon>
		</c:otherwise>
	</c:choose> 
	<!--   <icon>${docIcon}</icon> -->  
	<expanded>${childtreenode.expanded}</expanded>
	</node>
</c:forEach> 
</nodes> 
</course>


