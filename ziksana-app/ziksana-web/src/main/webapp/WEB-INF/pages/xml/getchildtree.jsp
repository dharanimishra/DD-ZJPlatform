<%@ page language="java" contentType="text/xml"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<tree id="0"> 
	<item text="${coursename}" id="COURSE_${courseIds}" im0="${courseIcon}" im1="${courseIcon}" im2="${courseIcon}" call="1" open="1" select="1" parentId="0">
	<c:forEach var="childtreenode" items="${parentList}">
		<item text="${childtreenode.title}" im0="${chapterIcon}" im1="${chapterIcon}" im2="${chapterIcon}" id="COMPONENT_${childtreenode.id}" nodeid="COMPONENT_${childtreenode.id}" parentId="COURSE_${courseIds}">	
			<c:forEach var="contenttreenode" items="${childList}">		
				<c:if test="${childtreenode.id  == contenttreenode.parentId}">	
					<c:if test="${contenttreenode.contentType eq  '1' }">
						<item text="${contenttreenode.title}" im0="${videoIcon}" im1="${videoIcon}" im2="${videoIcon}" id="CONTENT_${contenttreenode.contentId}" nodeid="CONTENT_${contenttreenode.contentId}" parentId="COMPONENT_${childtreenode.id}"></item>	
					</c:if>
					<c:if test="${contenttreenode.contentType eq  '11' }">
						<item text="${contenttreenode.title}" im0="${videoIcon}" im1="${videoIcon}" im2="${videoIcon}" id="CONTENT_${contenttreenode.contentId}" nodeid="CONTENT_${contenttreenode.contentId}" parentId="COMPONENT_${childtreenode.id}"></item>	
					</c:if>									
					<c:if test="${contenttreenode.contentType eq  '2' }">
						<item text="${contenttreenode.title}" im0="${audioIcon}" im1="${audioIcon}" im2="${audioIcon}" id="CONTENT_${contenttreenode.contentId}" nodeid="CONTENT_${contenttreenode.contentId}" parentId="COMPONENT_${childtreenode.id}"></item>	
					</c:if>
									
					<c:if test="${contenttreenode.contentType eq  '3'}">
						<item text="${contenttreenode.title}" im0="${noteIcon}" im1="${noteIcon}" im2="${noteIcon}" id="CONTENT_${contenttreenode.contentId}" nodeid="CONTENT_${contenttreenode.contentId}" parentId="COMPONENT_${childtreenode.id}"></item>	
					</c:if>
									
					<c:if test="${contenttreenode.contentType eq  '4'}">
						<item text="${contenttreenode.title}" im0="${pdfIcon}" im1="${pdfIcon}" im2="${pdfIcon}" id="CONTENT_${contenttreenode.contentId}" nodeid="CONTENT_${contenttreenode.contentId}" parentId="COMPONENT_${childtreenode.id}"></item>	
					</c:if>
									
					<c:if test="${contenttreenode.contentType eq  '5'}">
						<item text="${contenttreenode.title}" im0="${docIcon}" im1="${docIcon}" im2="${docIcon}" id="CONTENT_${contenttreenode.contentId}" nodeid="CONTENT_${contenttreenode.contentId}" parentId="COMPONENT_${childtreenode.id}"></item>	
					</c:if>
									
					<c:if test="${contenttreenode.contentType eq  '6'}">
						<item text="${contenttreenode.title}" im0="${pptIcon}" im1="${pptIcon}" im2="${pptIcon}" id="CONTENT_${contenttreenode.contentId}" nodeid="CONTENT_${contenttreenode.contentId}" parentId="COMPONENT_${childtreenode.id}"></item>	
					</c:if>
									
					<c:if test="${contenttreenode.contentType eq  '7'}">
						<item text="${contenttreenode.title}" im0="${excelIcon}" im1="${excelIcon}" im2="${excelIcon}" id="CONTENT_${contenttreenode.contentId}" nodeid="CONTENT_${contenttreenode.contentId}" parentId="COMPONENT_${childtreenode.id}"></item>	
					</c:if>
									
					<c:if test="${contenttreenode.contentType eq  '8'}">
						<item text="${contenttreenode.title}" im0="${imageIcon}" im1="${imageIcon}" im2="${imageIcon}" id="CONTENT_${contenttreenode.contentId}" nodeid="COMPONENT_${contenttreenode.id}" parentId="COMPONENT_${childtreenode.id}"></item>	
					</c:if>
					
					<c:if test="${contenttreenode.contentType eq  '9'}">
						<item text="${contenttreenode.title}" im0="${linkIcon}" im1="${linkIcon}" im2="${linkIcon}" id="CONTENT_${contenttreenode.contentId}" nodeid="COMPONENT_${contenttreenode.id}" parentId="COMPONENT_${childtreenode.id}"></item>	
					</c:if>
				</c:if>
			</c:forEach>
		</item>
	</c:forEach>	
	</item> 
</tree>
