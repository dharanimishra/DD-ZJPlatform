<%@ page language="java" contentType="text/xml"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<course> 
<id>${courseIds}</id> <name>${coursename}</name>
<nodes>
 <c:forEach var="treenode" items="${treeList}">
	<node> 
	<id>${treenode.id}</id> 
	<parentId>${treenode.parentId}</parentId> 
	<title>${treenode.title}</title> 
	<nodeType>${treenode.contentname}</nodeType>
	<contentId>${treenode.contentId}</contentId>
	<contentType>${treenode.contentType}</contentType>
	<icon>${treenode.icon}</icon>
	<expanded>${treenode.expanded}</expanded> 
	</node>
</c:forEach> 
</nodes> 
</course>
