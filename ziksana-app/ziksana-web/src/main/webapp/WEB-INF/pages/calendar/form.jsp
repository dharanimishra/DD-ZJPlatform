<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
</head>

<body>

 <c:url var="eventEditUrl" value="/calendar/updateevent" />
 <c:url var="eventEditUrl" value="/calendar/deleteevent" />
 
<form>
<table>
	<tr>
        <td>start :</td>
        <td><input name="title" type="text" /></td>
    </tr>
    <tr>
        <td>end :</td>
        <td><input name="details" type="text" /></td>
    </tr>
    <tr>
        <td>event :</td>
        <td><textarea name="" cols="14" rows="3" style=" resize:none;"></textarea></td>
    </tr>
    <tr>
        <td></td>
        <td><input name="" type="button" value="save" />&nbsp;<input name="" type="button" value="delete" /></td>
    </tr>
</table>


</form>
</body>
</html>
