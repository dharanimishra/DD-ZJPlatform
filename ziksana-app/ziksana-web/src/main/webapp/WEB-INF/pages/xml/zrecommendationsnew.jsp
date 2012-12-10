<%@ page language="java" contentType="text/html"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<ziksana-message>

  <header>
  			
			<controller>${recommendItem.getHeader().controllerName}</controller>
			<token>${recommendItem.getHeader().token}</token> 
			 
  </header>

<body>
	<recommendations>
	 <c:forEach var="recomend"	items="${recommendItem.getContent()}">
		<recommenditem recomendId="${category}">
		<title>${recomend.title}</title>
		<description>${recomend.description}</description> 
		</recommenditem>
	</c:forEach> 
	</recommendations>
</body>
</ziksana-message>
