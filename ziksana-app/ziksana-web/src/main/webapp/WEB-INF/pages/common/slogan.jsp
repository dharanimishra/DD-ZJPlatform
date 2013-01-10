<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<!--slogen-->
<div class="slogen-container">
	<span class="text-size-px20 gray-777 bold font-Signika">Welcome
		back <c:out value="${member.firstName}" />!<br> <c:url
			var="htmlUrl_header1" value="/resources/popup/z-zini.html" /> <%-- A few <span><a href="${htmlUrl_header1}"
			class=" text-size-px20 font-Signika">recommendations</a></span> for you to
		save time and meet your goals today
	</span> --%> <c:url var="createlink" value="/secure/createcourse" />
		<div class="f-r">
			<strong class="text-size-px16 light-gray"> <a
				href="${createlink}" class="light-blue">Create </a><strong>|</strong>
				<a href="#">Publish</a> <strong>|</strong> <a href="#">Manage</a>
			</strong>
			<c:url var="imageUrl_header2" value="/resources/images/plus.png" />
			<a href="#" class="light-blue"><img src="${imageUrl_header2}"
				alt="add more" width="4" height="6" class="light-blue add-more"></img></a>
		</div>
</div>
<!--End slogen-->