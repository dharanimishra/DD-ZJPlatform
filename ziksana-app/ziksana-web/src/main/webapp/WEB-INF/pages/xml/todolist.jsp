<%@ page language="java" contentType="text/xml" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:if test="${empty errorResponse }">
<todolist>
	<c:forEach var="todo" items="${todoItems}">
			<todoitem>
				<id>${todo.id}</id>
				 <categoryName>${todo.category}</categoryName>
				<subject>${todo.notificationContent}</subject>
			</todoitem>
	</c:forEach>
</todolist>
</c:if>

<c:if test="${not empty errorResponse}">
	<todoEmptyList>${errorResponse}</todoEmptyList>
</c:if>