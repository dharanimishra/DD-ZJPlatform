<%@ page language="java" contentType="text/xml" %>

<todolist>
<c:if test="${empty errorResponse }">

	<todoSize>${todoSize}</todoSize>
	<c:forEach var="todo" items="${todoItems}">
			<todoitem>
				<id>${todo.id}</id>
				 <categoryName>${todo.category}</categoryName>
				<subject>${todo.notificationContent}</subject>
				<status>${todo.status}</status>
			</todoitem>
	</c:forEach>

</c:if>
</todolist>
<c:if test="${not empty errorResponse}">
	<todoEmptyList>${errorResponse}</todoEmptyList>
</c:if>