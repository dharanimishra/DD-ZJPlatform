<%@ page language="java" contentType="text/html"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<ziksana-message>

  <header>
  			
			<controller>${recommendations.getHeader().controllerName}</controller>
			<token>${recommendations.getHeader().token}</token> 
			 
  </header>

<body>
	<recommendations>
	 <c:forEach var="recommend"	items="${recommendations.getContent()}">
		<recommendation recomendId="${category}">
		<title>${recommend.title}</title>
		<description>${recommend.description}</description> 
		</recommendation>
	</c:forEach> 
	</recommendations>
</body>
</ziksana-message>
