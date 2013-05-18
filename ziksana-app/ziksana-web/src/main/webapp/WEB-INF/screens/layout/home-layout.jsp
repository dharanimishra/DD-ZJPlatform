
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
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