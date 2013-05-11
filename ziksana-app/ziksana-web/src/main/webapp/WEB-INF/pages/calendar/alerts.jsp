<%@ page language="java" contentType="text/xml" %>


<alerts>
	
		<c:forEach var="alert" items="${alerts}">
			<alertitem  memberId="${memberId}">
					<id>${alert.id.displayID}</id>				
					<category>${alert.category}</category>
					<description>${alert.description}</description>
					<priority>${alert.priority}</priority>
				</alertitem>
		</c:forEach>

</alerts>

