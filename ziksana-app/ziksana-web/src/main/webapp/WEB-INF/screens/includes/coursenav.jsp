
<div id="Nav_bar">
	<ul>
		<li class="navhome active"><a href="/ziksana-web/secure/1/homepage"><fmt:message key="nav.myhome"></fmt:message></a></li>

		<li class="navcourse "><a href="/ziksana-web/zcourse/1/mycourse"><fmt:message key="nav.mycourse"></fmt:message></a></li>

		<li class="navstudent"><a href="/ziksana-web/zcourse/1/mycontent"><fmt:message key="nav.mycontent"></fmt:message></a></li>

		<li class="navanalytic"><a href="#"> <fmt:message key="nav.Analytics"></fmt:message></a></li>

	</ul>

</div>
<script>
$(document).ready(function(){
	var str=location.href.toLowerCase();
	$("#Nav_bar li a").each(function() {
	if (str.indexOf(this.href.toLowerCase()) > -1) {
	$("li.active").removeClass("active");
	$(this).parent().addClass("active");
	}
	});
	$("li.active").parents().each(function(){
	if ($(this).is("li")){
	$(this).addClass("active");
	}
	});
	})

</script>