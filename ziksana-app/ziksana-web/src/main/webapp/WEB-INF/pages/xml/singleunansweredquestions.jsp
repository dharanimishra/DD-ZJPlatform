<%@ page language="java" contentType="text/xml" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<unansweredquestions>
	<c:forEach var="unanswered" items="${unansweredquesList}">
		<unanswered>	
				<Questions>			
				<Question>${unanswered.text}</Question>
				<questiobankid>${unanswered.questionId}</questiobankid>		
					<options>	
								
						<c:forEach var="choice" items="${unanswered.choices}">
							<memberpsttestid>${choice.memPstTestId}</memberpsttestid>
							<option index="${choice.index}">${choice.text}</option>					
						</c:forEach>
					</options>					
				</Questions>
		</unanswered>
	</c:forEach>
</unansweredquestions>