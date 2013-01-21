<%@ page language="java" contentType="text/xml"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<?xml version='1.0' ?>
<tree id="0"> <item text="${coursename}" id="COURSE_${courseIds}" im0="${courseIcon}" im1="${courseIcon}" im2="${courseIcon}" call="1" open="1" select="1" parentId="0">
<c:forEach var="childtreenode" items="${parentList}">
	<item text="${childtreenode.title}" im0="${chapterIcon}" im1="${chapterIcon}" im2="${chapterIcon}" id="COMPONENT_${childtreenode.id}" nodeid="COMPONENT_${childtreenode.id}" parentId="COURSE_${courseIds}">
</item>
</c:forEach>  	
</item> 
</tree>








