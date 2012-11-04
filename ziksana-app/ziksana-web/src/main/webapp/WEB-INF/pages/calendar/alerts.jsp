<%@ page language="java" contentType="text/xml" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<alerts>
	<c:forEach var="alert" items="${alerts}">
		<alertitem  memberId="${memberId}">
				
				<description>${alert.description}</description>
			</alertitem>
	</c:forEach>
</alerts>
