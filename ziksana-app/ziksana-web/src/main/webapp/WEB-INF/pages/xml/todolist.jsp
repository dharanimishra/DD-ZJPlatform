<%@ page language="java" contentType="text/xml" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<todolist>
	<c:forEach var="todo" items="${todoItems}">
		<todoitem memberId="${memberId}">
				<id>${todo.ID}</id>
				<categoryName>${todo.category.name}</categoryName>
				<subject>${todo.todoText}</subject>
			</todoitem>
	</c:forEach>
</todolist>
