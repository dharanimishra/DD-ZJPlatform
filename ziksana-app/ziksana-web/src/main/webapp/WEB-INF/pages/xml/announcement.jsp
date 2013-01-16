\<%@ page language="java" contentType="text/html"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>










<html>
	<HEAD>
	<SCRIPT type="text/javascript">
		function closeit(){
		parent.jQuery.fancybox.close();

		}
	</SCRIPT>
	<style>
.btn-info {
    background-color: #49AFCD;
    background-image: linear-gradient(to bottom, #5BC0DE, #2F96B4);
    background-repeat: repeat-x;
    border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
    color: #FFFFFF;
    text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
}

</style>
	</HEAD>
	<body>
	
	<div style="width:650px; height:300px; background-color:#ffffff;">
	<div><b><u><c:out value="${announcements.message}"></c:out></u></b>
	<BR/>
	<BR/>
	
	<c:out value="${announcements.announcementDate}"></c:out>
	</div>
	<BR/>
	<div>
	<c:out value="${announcements.description}"></c:out></div>
	
	<hr/><button style='float:right;height:30px;' class='btn-info' onclick='closeit()'> Return </button>
	</div>
	</body>
</html>
