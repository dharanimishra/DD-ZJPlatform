<%@ page language="java" contentType="text/html" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<recommendations>	
		<recommenditem recomendId="${category}">
				 <title>${recommendItem.title}</title>
				<description>${recommendItem.description}</description>
		</recommenditem>
</recommendations>	

	