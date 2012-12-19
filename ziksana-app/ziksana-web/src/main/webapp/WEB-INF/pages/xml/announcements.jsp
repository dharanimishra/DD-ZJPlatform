<%@ page language="java" contentType="text/xml"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<announcementsList>
	<c:forEach var="announce" items="${announcements}"> 
		<announcements memberRoleId="${memberRoleId}">
			
			<message>${announce.message}</message>
			<validUntil>${announce.validUntil}</validUntil>
		</announcements> 
	</c:forEach>
</announcementsList>
