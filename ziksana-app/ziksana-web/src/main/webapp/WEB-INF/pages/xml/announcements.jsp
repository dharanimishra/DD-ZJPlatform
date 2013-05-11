<%@ page language="java" contentType="text/xml"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<announcementsList>
	<announcementSize>${announcementSize}</announcementSize>
	<c:forEach var="announce" items="${announcements}"> 
		<announcements memberRoleId="${memberRoleId}">
			<announcementid>${announce.announcementId}</announcementid>
			<message>${announce.message}</message>
			<announcementDate>${announce.announcementDate}</announcementDate>
			<validUntil>${announce.validUntil}</validUntil>
			<description>${announce.description}</description>
		</announcements> 
	</c:forEach>
</announcementsList>
