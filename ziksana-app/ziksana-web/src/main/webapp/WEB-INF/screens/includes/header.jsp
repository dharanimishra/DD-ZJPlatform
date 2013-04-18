<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
	<head>
		<meta charset="utf-8">
    	<meta name="viewport" content="target-densitydpi=device-dpi, width=device-width, initial-scale=1.0, maximum-scale=1">	
		
	
			
		    <link href="/ziksana-web/resources/assets/stylesheets/modern.css" rel="stylesheet"/>
		    <link href="/ziksana-web/resources/assets/stylesheets/modern-responsive.css" rel="stylesheet">
		    <link href="/ziksana-web/resources/assets/stylesheets/site.css" rel="stylesheet" type="text/css">
		     <link href="/ziksana-web/resources/assets/stylesheets/common/application.css" rel="stylesheet" type="text/css">
		    <link href="/ziksana-web/resources/assets/stylesheets/google-code-prettify/prettify.css" rel="stylesheet" type="text/css">
		    
		
		    <script type="text/javascript" src="/ziksana-web/resources/assets/javascripts/assets/jquery-1.9.0.min.js"></script>
		    <script type="text/javascript" src="/ziksana-web/resources/assets/javascripts/assets/jquery.mousewheel.min.js"></script>
		    <script type="text/javascript" src="/ziksana-web/resources/assets/javascripts/assets/moment.js"></script>
		    <script type="text/javascript" src="/ziksana-web/resources/assets/javascripts/assets/moment_langs.js"></script>
		
		    <script type="text/javascript" src="/ziksana-web/resources/assets/javascripts/modern/dropdown.js"></script>
		    <script type="text/javascript" src="/ziksana-web/resources/assets/javascripts/modern/accordion.js"></script>
		    <script type="text/javascript" src="/ziksana-web/resources/assets/javascripts/modern/buttonset.js"></script>
		    <script type="text/javascript" src="/ziksana-web/resources/assets/javascripts/modern/carousel.js"></script>
		    <script type="text/javascript" src="/ziksana-web/resources/assets/javascripts/modern/input-control.js"></script>
		    <script type="text/javascript" src="/ziksana-web/resources/assets/javascripts/modern/pagecontrol.js"></script>
		    <script type="text/javascript" src="/ziksana-web/resources/assets/javascripts/modern/rating.js"></script>
		    <script type="text/javascript" src="/ziksana-web/resources/assets/javascripts/modern/slider.js"></script>
		    <script type="text/javascript" src="/ziksana-web/resources/assets/javascripts/modern/tile-slider.js"></script>
		    <script type="text/javascript" src="/ziksana-web/resources/assets/javascripts/modern/tile-drag.js"></script>
		    <script type="text/javascript" src="/ziksana-web/resources/assets/javascripts/modern/calendar.js"></script>
			<script type="text/javascript" src="/ziksana-web/resources/assets/javascripts/common/application.js"></script>
			
			<%@include file="common_css.jsp" %>
			<%@include file="common_js.jsp" %>
		

			<title><c:out value="${pageTitle}"/></title>
	</head>	
	<body class="metrouicss" onload="prettyPrint()">

<%@include file="navigation.jsp" %>