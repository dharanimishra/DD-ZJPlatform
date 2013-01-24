<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%--
// Hardcoding XML schema provides flexibility in creating any number of custom schemas.
// Unlike use of JAXB where the entire object is marshalled.
--%>

<div class="user-contacts all-box-shadow pad demo_message">

	<div class="demo_message" class="_blogMain  demo_message_container">

		<p>
			For Demonstration Only.<br /> Functionality to be available in
			subsequent Playpens

		</p>

	</div>

	<div class="demo_message_container">
		<span class="jdash-head-title titles-info ">Recent
			Blog Posts</span>

		<div>
			<ol>
				<c:choose>
					<c:when test="${not empty blogList}">
						<blogs>
						
						<c:forEach var="bloglist" items="${blogList}" varStatus="status">
						<li class="_blogs" style='padding:0px 10px 0px 0px;'>
						<blog id="${bloglist.blogPostId.displayID}">
								<span class="_postD text-size-px9">
								<c:set var="blogDate" value="${bloglist.createDate}"></c:set>
								<c:set var="blogDateTrim" value="${fn:substring(blogDate, 4, 10)}"></c:set>
									<date><c:out value="${blogDateTrim}"></c:out></date>
									
								</span><br>
								<b><a href=""><blogtitle>${bloglist.title}</blogtitle></a></b>
								<br />
								<p class="_postP">
									<detail>${bloglist.content}</detail>
								</p>
								
								<p class="_postT">
									(Tags:
						
									<c:forEach items="${bloglist.tags}" var="items"
										varStatus="loop">
										<a class="text-size-px11" href="#"><tag>${items.name}</tag></a>
									</c:forEach>
									)
							
									</p>
									</li>
						</blog>
						
						</c:forEach>
						
						</blogs>
					</c:when>
					<c:when test="${empty bogList }">
	 	No Blogs published ...
	 </c:when>
				</c:choose>
			</ol>
		</div>
		<p class="txt-r" style="padding-right: 10px; clear: both;">
			<a href="">More</a>
		</p>
		<div class="demo_message" class="_blogMain  demo_message_container">

			<p>
				For Demonstration Only.<br /> Functionality to be available in
				subsequent Playpens

			</p>

		</div>

	</div>

<style>
.jdash-head-title {
	font-size:18px;
	font-family:signika;  
	cursor: move;
	color: #666;
}
.jdash-head-title:hover { color: #ccc; }
.jdash-head-title:hover span.sub-title { color: #666666; }
</style>

</div>
