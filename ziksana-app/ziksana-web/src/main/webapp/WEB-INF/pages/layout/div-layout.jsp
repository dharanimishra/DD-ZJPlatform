<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html>
<head>
<title><tiles:insertAttribute name="page_title" /></title>
<tiles:insertAttribute name="common_css" />
<tiles:insertAttribute name="page_css" />
<tiles:insertAttribute name="common_js" />
<tiles:insertAttribute name="page_js" />
</head>
<body class="<tiles:insertAttribute name="page_class" />">
	<div id="wrapper">
		<header class="bottom-box-shadow bckground-wihte">

			<div class="topheader">
				<p><a><img data-launcher data-launchpage="/ziksana-web/secure/launcher" src="/ziksana-web/resources/images/logo_ziksana_100.png" style="margin-left: 0px; position: absolute; z-index: 1; top: -12px; left: 175px;" /></a></p>
			</div>

			<tiles:insertAttribute name="main_menu" />
			
		</header>

		<tiles:insertAttribute name="slogan" />

		<!--Main Content-->
		<section>
			<div class="section">

				<tiles:insertAttribute name="left" />
				<tiles:insertAttribute name="body" />
				<tiles:insertAttribute name="right" />

			</div>
		</section>

		<tiles:insertAttribute name="page_footer" />

	</div>


</body>
<!-- ${pageContext.session.maxInactiveInterval}; -->
<script type="text/javascript">
$(document).ready(function() {
	

setInterval(function() {
	var secondsBeforeExpire =${pageContext.session.maxInactiveInterval};
	var timeToDecide = 60;
	var timeEstimate = (secondsBeforeExpire - timeToDecide);
	console.log("secondsBeforeExpire = " + timeEstimate);	
	
	setTimeout(function(){
		startCount();
		},timeEstimate*1000);
	
});
});
</script>
</html>