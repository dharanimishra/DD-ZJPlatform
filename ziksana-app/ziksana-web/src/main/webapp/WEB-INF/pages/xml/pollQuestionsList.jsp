<%@ page language="java" contentType="text/xml" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<QuestionsList>

		<c:forEach var="questions" items="${pollQuestionsList}">
			<Questions>
			<questionId>${questions.ID}</questionId>
			<questionDate>${questions.pollDate}</questionDate>
			<questionName>${questions.questionText}</questionName>
			</Questions>
		</c:forEach>

</QuestionsList>