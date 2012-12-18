
<%@ page language="java" contentType="text/xml" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%--
// Hardcoding XML schema provides flexibility in creating any number of custom schemas.
// Unlike use of JAXB where the entire object is marshalled.
--%>

<courses>
	
	<draftedcourses>
	<c:forEach var="course" items="${DRAFTED_COURSES}">
	<course id="${course.courseId.storageID}">
		<title>${course.name}</title>
		
	</course>
	</c:forEach>
	</draftedcourses>
	
	
	<reviewedcourses>
	    
	   <c:forEach var="course" items="${REVIEWED_COURSES}">
	<course id="${course.courseId.storageID}">
		<title>${course.name}</title>
		
	</course>
	</c:forEach>
	
	</reviewedcourses>
	
	<activecourses>
	    <c:forEach var="course" items="${ACTIVE_COURSES}">
	    <course id="${course.courseId}">
		<title>${course.name}</title>
		
	</course>
	</c:forEach>
	</activecourses>
	
	
</courses>
