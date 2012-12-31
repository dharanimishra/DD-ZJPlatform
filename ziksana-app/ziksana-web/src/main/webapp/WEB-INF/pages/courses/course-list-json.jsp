
<%@ page language="java" contentType="application/json" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%--
// Hardcoding JSON message format provides flexibility in creating any number of custom messages.
// Unlike use of JSON converters where entire object (non-transient) is converted.
--%>

<!-- Code to be updated to not include comma after the last course-item in the list below -->

{ "courses" : [
	<c:forEach var="course" items="${courseList}">
	{
		"courseId" : "${course.courseId}",
		"courseName" : "${course.courseName}",
		"courseLogo" : "${course.courseImageName}",
		"educator" : "${course.educatorFullName}"
	},
	</c:forEach>
	]
}
