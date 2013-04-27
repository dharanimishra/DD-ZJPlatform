<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>
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