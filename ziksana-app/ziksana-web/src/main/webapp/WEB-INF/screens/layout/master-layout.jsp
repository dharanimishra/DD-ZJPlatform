

<!DOCTYPE html>
<html>
<head>
<meta content="text/html;charset=utf-8" http-equiv="Content-Type">
<meta content="utf-8" http-equiv="encoding">
<title><tiles:insertAttribute name="master_title" /></title>
<tiles:insertAttribute name="common_css" />
<tiles:insertAttribute name="common_js" />
</head>
<body>
<div id="background">
	<div id="wrapper">
		<section >
		
				<tiles:insertAttribute name="header" />
				
				<tiles:insertAttribute name="content" />
		
				<tiles:insertAttribute name="page_footer" />
		
		</section>
	</div>
</div>
</body>
</html>