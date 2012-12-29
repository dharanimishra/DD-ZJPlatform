<%@ page language="java" contentType="text/xml"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<course> <c:forEach var="course" items="${course}">
	<id>${course.courseid}</id>
		<name>${course.name}</name>
	<name>7</name>
</c:forEach> <nodes> <c:forEach var="treenode" items="${treeNodeList}">
	<node> <id>${treenode.id}</id> <parentId>7</parentId> <title>Introduction
	to Decision Making</title> <nodeType>chapter</nodeType> <icon>images/tree_icons/pdf.png</icon>
	<expanded></expanded> </node>
</c:forEach> </nodes></course>
