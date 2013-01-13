<%@ page language="java" contentType="text/xml"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<?xml version='1.0' ?>
<tree id="0"> <item text="${coursename}" id="COURSE_${courseIds}" im0="${folderClosed}" im1="${folderOpen}" im2="${folderClosed}" call="1" open="1" select="1" parentId="0">
<c:forEach var="childtreenode" items="${treeList}">
	<item text="${childtreenode.title}" im0="book_titel.gif" im1="book.gif" im2="book_titel.gif" id="COMPONENT_${childtreenode.id}" nodeid="${childtreenode.id}" parentId="${courseIds}"></item>
</c:forEach>  	
</item> 
</tree>




