<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title><tiles:getAsString name="title" /></title>
<script type="text/javascript" src="/resources/js/ziks.js"></script>
</head>
<body>

	<table style="border-collapse: collapse;" align="center" border="1"
		cellpadding="2" cellspacing="2" width="800">
		<tbody>
			<tr>
				<td colspan="2" height="30">
					<tiles:insertAttribute name="header" />
				</td>
			</tr>
			<tr>
				<td colspan="2" height="30">
					<tiles:insertAttribute name="menu" />
				</td>
			</tr>
			<tr>
				<td height="450" valign="top" width="150">
					<tiles:insertAttribute name="left-section" />
				</td>
				<td valign="top" width="650">
					<tiles:insertAttribute name="body" />
				</td>
			</tr>
			<tr>
				<td colspan="2" height="30">
					<tiles:insertAttribute name="footer" />
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
