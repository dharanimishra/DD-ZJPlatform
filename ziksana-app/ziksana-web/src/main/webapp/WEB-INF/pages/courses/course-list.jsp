
<%@ page language="java" contentType="text/xml" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%--
// Hardcoding XML schema provides flexibility in creating any number of custom schemas.
// Unlike use of JAXB where the entire object is marshalled.
--%>

<courses>
	<c:forEach var="course" items="${courseList}">
	<course id="${course.courseId}">
		<title>${course.courseName}"</title>
		<image>${course.courseImageName}</image>
		<educator>${course.educatorFullName}</educator>
	</course>
	</c:forEach>
</courses>
