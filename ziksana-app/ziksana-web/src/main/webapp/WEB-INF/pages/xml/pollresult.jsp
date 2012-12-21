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
					 <c:forEach var="option" items="${qr.pollResult.question.allOptions}">
							<option index="${option.index}"> 
							   <optiontext>
							     ${option.HTML}
							    </optiontext>
							    <c:choose>
						<c:when test="${option.index == 0}">
							<count>
							      ${qr.pollResult.answer1Count} 
							    </count>  
						</c:when>
						<c:when test="${option.index == 1}">
							<count>
							      ${qr.pollResult.answer2Count} 
						   </count>  
						</c:when>
						
						<c:when test="${option.index == 2}">
							<count>
							      ${qr.pollResult.answer3Count} 
							</count>  
						</c:when>
						<c:when test="${option.index == 3}">
							<count>
							      ${qr.pollResult.answer4Count} 
						</count>  
						</c:when>
						<c:when test="${option.index == 4}">
							<count>
							      ${qr.pollResult.answer5Count} 
						</count>  
						</c:when>
					</c:choose>
							    
							    
							</option>
						</c:forEach>
					</options>
					 <answer1count>${qr.pollResult.answer1Count}</answer1count>
					 <answer2count>${qr.pollResult.answer2Count}</answer2count>
					 <answer3count>${qr.pollResult.answer3Count}</answer3count>
					 <answer4count>${qr.pollResult.answer4Count}</answer4count>
					 <answer5count>${qr.pollResult.answer5Count}</answer5count>
					 
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
