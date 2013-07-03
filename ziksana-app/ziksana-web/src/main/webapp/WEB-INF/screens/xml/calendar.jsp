<%@ page language="java" contentType="text/xml" %>

<calendarlist>
	<calendarSize>${calendarSize}</calendarSize>	
	<c:forEach var="todo" items="${calendarList}">
			<calendar>
				 <c:set var="startDate" value="${todo.startDate}"></c:set>
				<c:set var="startDateTrim" value="${fn:substring(startDate, 11, 16)}"></c:set>
				
				<c:if test="${fn:startsWith(startDateTrim, '00') or fn:startsWith(startDateTrim, '01') or fn:startsWith(startDateTrim, '02') or fn:startsWith(startDateTrim, '03') or fn:startsWith(startDateTrim, '04') or fn:startsWith(startDateTrim, '05') or fn:startsWith(startDateTrim, '06') or fn:startsWith(startDateTrim, '07') or fn:startsWith(startDateTrim, '08') or fn:startsWith(startDateTrim, '09') or fn:startsWith(startDateTrim, '10') or fn:startsWith(startDateTrim, '11')}">
					<startdate>${startDateTrim} AM</startdate>
				</c:if>
				 <c:if test="${fn:startsWith(startDateTrim, '12') or fn:startsWith(startDateTrim, '13') or fn:startsWith(startDateTrim, '14') or fn:startsWith(startDateTrim, '15') or fn:startsWith(startDateTrim, '16') or fn:startsWith(startDateTrim, '17') or fn:startsWith(startDateTrim, '18') or fn:startsWith(startDateTrim, '19') or fn:startsWith(startDateTrim, '20') or fn:startsWith(startDateTrim, '21') or fn:startsWith(startDateTrim, '22') or fn:startsWith(startDateTrim, '23')}">
					<startdate>${startDateTrim} PM</startdate>
				</c:if>
				 <c:set var="endDate" value="${todo.endDate}"></c:set>
				<c:set var="endDateTrim" value="${fn:substring(endDate, 11, 16)}"></c:set> 
				<c:if test="${fn:startsWith(endDateTrim, '00') or fn:startsWith(endDateTrim, '01') or fn:startsWith(endDateTrim, '02') or fn:startsWith(endDateTrim, '03') or fn:startsWith(endDateTrim, '04') or fn:startsWith(endDateTrim, '05') or fn:startsWith(endDateTrim, '06') or fn:startsWith(endDateTrim, '07') or fn:startsWith(endDateTrim, '08') or fn:startsWith(endDateTrim, '09') or fn:startsWith(endDateTrim, '10') or fn:startsWith(endDateTrim, '11')}">
					<enddate>${endDateTrim} AM</enddate>
				</c:if>
				 <c:if test="${fn:startsWith(endDateTrim, '12') or fn:startsWith(endDateTrim, '13') or fn:startsWith(endDateTrim, '14') or fn:startsWith(endDateTrim, '15') or fn:startsWith(endDateTrim, '16') or fn:startsWith(endDateTrim, '17') or fn:startsWith(endDateTrim, '18') or fn:startsWith(endDateTrim, '19') or fn:startsWith(endDateTrim, '20') or fn:startsWith(endDateTrim, '21') or fn:startsWith(endDateTrim, '22') or fn:startsWith(endDateTrim, '23')}">
					<enddate>${endDateTrim} PM</enddate>
				</c:if>
				<enddatse>${todo.endDate}</enddatse>
				<eventname>${todo.eventName}</eventname>
			</calendar>
	</c:forEach>

</calendarlist>
