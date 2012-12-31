<%@ page language="java" contentType="text/xml" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<pollquestionresult>
	<c:forEach var="qr" items="${questions}">
		<c:if test="${qr.pollQuestion == null}">
			<questionresultpair memberId="${memberId}">
				<pollQuestion>
					<id>${qr.pollResult.question.ID}</id>
					<isNull>true</isNull>
					<c:choose>
						<c:when test="${qr.pollResult.question.active}">
							<active>true</active>
						</c:when>
						<c:otherwise>
							<active>false</active>
						</c:otherwise>
					</c:choose>
					
				</pollQuestion>
				<pollResult>
					<isNull>false</isNull>
					<options>
					 <c:forEach var="option" items="${qr.pollQuestion.allOptions}">
							<option index="${option.index}">${option.HTML}</option>
						</c:forEach>
					</options>
					 <answer1count>${qr.pollResult.answer1Count}</answer1count>
				</pollResult>				
			</questionresultpair>
		</c:if>
		<c:if test="${qr.pollResult == null}">
			<questionresultpair memberId="${memberId}">
				<pollQuestion>
					<id>${qr.pollQuestion.ID}</id>
					<isNull>false</isNull>
					<c:choose>
						<c:when test="${qr.pollQuestion.active}">
							<active>true</active>
						</c:when>
						<c:otherwise>
							<active>false</active>
						</c:otherwise>
					</c:choose>
					<questionText>${qr.pollQuestion.questionText}</questionText>
					<options>
						<c:forEach var="option" items="${qr.pollQuestion.allOptions}">
							<option index="${option.index}">${option.HTML}</option>
						</c:forEach>
					</options>
				</pollQuestion>
				<pollResult>
					<isNull>true</isNull>
					<options>
						<!-- <c:forEach var="option" items="${qr.pollQuestion.allOptions}">
							<option index="${option.index}" optionTotal="${option.optionTotal}">${option.HTML}</option>
						</c:forEach> -->
					</options>
				</pollResult>				
			</questionresultpair>
		</c:if>
		<c:if test="${qr.pollQuestion != null && qr.pollResult != null}">
			<questionresultpair memberId="${memberId}">
				<pollQuestion>
					<id>${qr.pollResult.question.ID}</id>
					<isNull>false</isNull>
					<c:choose>
						<c:when test="${qr.pollResult.question.active}">
							<active>true</active>
						</c:when>
						<c:otherwise>
							<active>false</active>
						</c:otherwise>
					</c:choose>
					<questionText>${qr.pollResult.question.questionText}</questionText>
					<options>
						<c:forEach var="option" items="${qr.pollResult.question.allOptions}">
							<option index="${option.index}">${option.HTML}</option>
						</c:forEach>
					</options>
				</pollQuestion>
				<pollResult>
					<isNull>false</isNull>
					<options>
						<!-- <c:forEach var="option" items="${qr.pollResult.question.allOptions}">
							<option index="${option.index}" optionTotal="${option.optionTotal}">${option.HTML}</option>
						</c:forEach> -->
					</options>
					<answer1count>${qr.pollResult.answer1Count}</answer1count>
				</pollResult>				
			</questionresultpair>
		</c:if>
	</c:forEach>
</pollquestionresult>
