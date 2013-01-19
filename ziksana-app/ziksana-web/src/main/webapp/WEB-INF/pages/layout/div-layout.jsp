<!-- test for github troubleshooting-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--HTML head Container start -->
		<tiles:insertAttribute name="head_static" />
<!--HTML head Container end -->
<body>
<div id="wrapper">
        <!--Header Container-->
		<tiles:insertAttribute name="header" />
        <!--End Header Container-->
        <!--Slogan Container-->
		<tiles:insertAttribute name="slogan" />
        <!--End Slogan Container-->
  <!--Main Content-->
     		<section>
           	  <div class="section">
              <!--Left column-->
				<tiles:insertAttribute name="left" />
              <!--End Left column-->
              <!--Center Container-->
				<tiles:insertAttribute name="body" />
              <!--End Center Container-->
              <!--Right column-->
 				<tiles:insertAttribute name="right" />
              <!--End Right column-->
              </div>
  			</section>
        <!--End Main Content-->
        <!--Current Progress-->
        <tiles:insertAttribute name="footer" />
  		<!--End Current Progress-->
        <!--Footer Container-->
        <!--End Footer Container-->
	</div>
	<!--Footer static start-->
        <tiles:insertAttribute name="footer_static" />
  	<!--Footer static end-->
</body>
</html>