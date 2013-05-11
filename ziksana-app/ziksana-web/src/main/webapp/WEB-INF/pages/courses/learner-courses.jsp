<%@ page language="java" contentType="text/xml" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%--
// Hardcoding XML schema provides flexibility in creating any number of custom schemas.
// Unlike use of JAXB where the entire object is marshalled.
--%>

<courses>
	
	<learnercourses>
	<c:forEach var="course" items="${courses}">
		<course id="${course.coursesId}">
			<title>${course.name}</title>
			<progress>${course.courseProgress}</progress>
		</course>
	</c:forEach>
	</learnercourses>
</courses>