<%@ page language="java" contentType="text/xml"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<servers>
	<mediaserver>
		<url>${mediaItems.url}</url>
		<uploadscript>${mediaItems.uploadScript}</uploadscript>
		<uploadcontent>${mediaItems.uploadContent}</uploadcontent>
	</mediaserver>
</servers>