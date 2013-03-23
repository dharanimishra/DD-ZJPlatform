<%@ page language="java" contentType="text/xml" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<todolist>
<c:if test="${empty errorResponse }">

	<todoSize>${todoSize}</todoSize>
	<c:forEach var="todo" items="${todoItems}">
			<todoitem>
				<id>${todo.id}</id>
				 <categoryName>${todo.category}</categoryName>
				<subject>${todo.notificationContent}</subject>
			</todoitem>
	</c:forEach>

</c:if>
</todolist>
<c:if test="${not empty errorResponse}">
	<todoEmptyList>${errorResponse}</todoEmptyList>
</c:if>