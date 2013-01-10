<%@ page language="java" contentType="text/html" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<recommendations>	
	<c:forEach var="recomend" items="${recommendations}">
		<recommenditem recomendId="${category}">
				 <recommendationId>${recomend.ID}</recommendationId>
				 <category>${recomend.category}</category>
				 <title>${recomend.title}</title>
				<description>${recomend.description}</description>
				<ignorecount>${recomend.ignoreCount}</ignorecount>
		</recommenditem>
	</c:forEach>
</recommendations>	

	