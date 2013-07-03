<%@ page language="java" contentType="text/xml"%>

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
