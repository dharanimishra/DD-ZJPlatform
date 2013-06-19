<%@ page language="java" contentType="text/xml" %>

<calendarlist>
	<calendarSize>${calendarSize}</calendarSize>	
	<c:forEach var="todo" items="${calendarList}">
			<calendar>
				 <c:set var="startDate" value="${todo.startDate}"></c:set>
				<c:set var="startDateTrim" value="${fn:substring(startDate, 11, 16)}"></c:set>
				 <startdate>${startDateTrim}</startdate>
				 <c:set var="endDate" value="${todo.endDate}"></c:set>
				<c:set var="endDateTrim" value="${fn:substring(endDate, 11, 16)}"></c:set> 
				
				<enddate>${endDateTrim}</enddate>
				<enddatse>${todo.endDate}</enddatse>
				<eventname>${todo.eventName}</eventname>
			</calendar>
	</c:forEach>

</calendarlist>
