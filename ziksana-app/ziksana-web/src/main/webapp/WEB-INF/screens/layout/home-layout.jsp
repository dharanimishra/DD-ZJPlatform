
<%@ page session="true"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="text/html;charset=utf-8" http-equiv="Content-Type">
<meta content="utf-8" http-equiv="encoding">
<title><tiles:insertAttribute name="master_title" /></title>
<tiles:insertAttribute name="common_css" />
<tiles:insertAttribute name="common_js" />
</head>
<body class="metrouicss">
	<div id="background"  >
		<div id="wrapper">
				<section >
					<tiles:insertAttribute name="menu" />			
				</section>
				
				<section>	
				
					<div id="leftpanel">
						<tiles:insertAttribute name="header" />		
						<tiles:insertAttribute name="content" />
						<tiles:insertAttribute name="page_footer" />
					</div>
					
				</section>
							 
				
		 </div>
		
			
</div>

</body>
</html>