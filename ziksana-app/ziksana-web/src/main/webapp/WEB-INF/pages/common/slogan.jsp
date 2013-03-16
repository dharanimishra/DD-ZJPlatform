
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<!--slogen-->
<style>
.mnuclass{
 font-size: 12px;
 font-weight:normal;
 font-family:verdana;
 text-decoration:none;
 color: #2277BB;
 
}

</style>
<body>
<div class="slogen-container">
	<span class="text-size-px20 gray-777 bold font-Signika">Welcome
		back <c:out value="${member.firstName}" />!<br> <c:url
			var="htmlUrl_header1" value="/resources/popup/z-zini.html" /> <%-- A few <span><a href="${htmlUrl_header1}"
			class=" text-size-px20 font-Signika">recommendations</a></span> for you to
		save time and meet your goals today
	</span> --%> <c:url var="createlink" value="" />
	<c:if test="${member.roleType eq 'EDUCATOR'}">
		<div class="f-r">
			<a class=" light-gray light-blue mnuclass"  
				href="/ziksana-web/zcourse/createcourse">Create </a>|
				<a href="#" class="light-blue mnuclass" > Manage </a> | <a class="light-blue mnuclass"  href="#"> Publish</a>
			
			<c:url var="imageUrl_header2" value="/resources/images/plus.png" />
			<a href="#" class="light-blue"><img src="${imageUrl_header2}"
				alt="add more" width="12" height="12" class="light-blue add-more"></img></a>
		</div>
		</c:if>
		<c:if test="${member.roleType eq 'LEARNER'}">
		<div class="f-r">
		</div>
		</c:if>
</div>
</body>

<!--End slogen-->
