<%@ page language="java" contentType="text/xml" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<answeredquestions>
	<c:forEach var="answered" items="${answeredquesList}">
		<answered>
				<questions>
					<questiobankid>${answered.question.questionId}</questiobankid>
					<question>${answered.question.text}</question>		
					<responsedate>${answered.question.responseDate}</responsedate>		
					<answers>	
						<memberpersonalitytestid>${answered.choice.memPstTestId}</memberpersonalitytestid>
						<answerid>${answered.choice.index}</answerid>					
						<answer>${answered.choice.text}</answer>
						
					</answers>				
				</questions>
		</answered>
	</c:forEach>
</answeredquestions>