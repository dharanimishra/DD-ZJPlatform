<%@ page language="java" contentType="text/xml" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<QuestionsAnswersList>

		<c:forEach var="answers" items="${pollQuestionsAnswersList}">
		
			<questionId>${answers.questionId}</questionId>
			<questionName>${answers.question}</questionName>
			<answer1>${answers.answer1}</answer1>
			<answer2>${answers.answer2}</answer2>
			<answer3>${answers.answer3}</answer3>
			<answer4>${answers.answer4}</answer4>
			<answer5>${answers.answer5}</answer5>
			
		</c:forEach>

</QuestionsAnswersList>