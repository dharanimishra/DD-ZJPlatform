

<!DOCTYPE html>
<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title><tiles:insertAttribute name="master_title" /></title>
<tiles:insertAttribute name="common_css" />
<tiles:insertAttribute name="common_js" />
</head>
<body>
	<div id="background">
		<div id="wrapper">
			<section>
				<tiles:insertAttribute name="coursenav" />

				<tiles:insertAttribute name="header" />

				<tiles:insertAttribute name="content" />


			</section>
		</div>
	</div>
</body>
</html>