
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>zAnnouncements</title>

<link rel="stylesheet" href="../resources/css/zCss.css" type="text/css"/>
<link type="text/css" href="../resources/css/jquery-ui-1.8.23.custom.css" rel="stylesheet" />
<link rel="stylesheet" href="../resources/css/bootstrap.css" />
<link href="../resources/css/jquery.mCustomScrollbar.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="../resources/css/zeni/zeni2.css" />
</head>
<script type="text/javascript" src="../resources/js/tree/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="../resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../resources/js/jquery-ui-1.8.21.custom.min.js"></script>
<script src="../resources/js/bootstrap.min.js"></script>
   <script src="../resources/js/bootstrap.js"></script>
<script type="text/javascript" src="../resources/js/jquery.js"></script>
<script type="text/javascript" src="../resources/js/zGroup.js"></script>
<script type="text/javascript" src="../resources/js/tablerow.js"></script>
<!--<script src="js/isotope/jquery-1.7.2.min.js"></script>-->
<script type="text/javascript" src="../resources/js/jquery-1.8.0.min.js"></script>
		<script type="text/javascript" src="../resources/js/jquery-ui-1.8.23.custom.min.js"></script>
		<script type="text/javascript">
			$(function(){
				// Datepicker
				$( ".datepicker" ).datepicker();			

			});
function details(asd)
{

var val= $('#'+asd).html();
$("#linksMeeting").fadeIn();
$("#linksdetails").html(val);
}			
			
function closeit()
{
$.fancybox.close();
}	
			
		</script>

<!-- Announcement  -->

<body>

<div class="zannouncementwrapper">
	<!-- Main container -->
	<div id="zAnnouncement">
    	
        <div class="helptext">
        	Help text describing the page
        </div>
        <div id="error">
        	<span id="_required">Enter a date *</span>
        </div>
        <div id="contentGroup">
        	<select name="zCategory"  id="zCategory">
                    <option value="Category">Category</option> 
                     <option value="Category">University</option> 
                      <option value="Category">Department</option> 
                       <option value="Category">Course</option>                
              </select>
              
        	
                    <label value="Period" style="display:inline;">Start Period</label> 
             
            <input type="text" id="vDate" class="datepicker" title="Date Required" value="Value (Date)"/> 
            
                    <label value="Period" style="display:inline;">End Period</label> 
                                  
             
			  <input type="text" id="EDate" class="datepicker" title="Date Required" value="Value (Date)"/> 
            <a id="_go" class="aClass">Go</a>
        </div>
        <!-- end contentGroup -->
        <div id="showGroup" class="zAnn">
              
                <div id="tblGroup">
               <table class="table reviewtable">
                        <thead style="font-size:12px; font-family:tahoma; font-style:normal; color:#666;">
                    <tr>
                    	<th>Announcement</th><th>Status</th>
                    </tr>
                    </thead>
                     <tbody>
                    <tr>
                    	<td style=" width:350px;"><div id="data1" onclick="details('data1')">Assignment-1 is closing today</div></td>
                        <td>aa</td>
                        
                    </tr>
                     <tr>
                    	<td><div id="data2" onclick="details('data2')">Chapter-1 is open for pre study</div></td>
                        <td>bb</td>
                        
                    </tr>
                    
                      <tr>
                    	<td style=" width:350px;"><div id="data3" onclick="details('data3')">Assignment-2 is closing today</div></td>
                        <td>aa</td>
                        
                    </tr>
                     <tr>
                    	<td><div id="data4" onclick="details('data4')">Chapter-2 is open for pre study</div></td>
                        <td>bb</td>
                        
                    </tr>
                    
                      <tr>
                    	<td style=" width:350px;"><div id="data5" onclick="details('data5')">Assignment-3 is closing today</div></td>
                        <td>aa</td>
                        
                    </tr>
                     <tr>
                    	<td><div id="data6" onclick="details('data6')">Chapter-3 is open for pre study</div></td>
                        <td>bb</td>
                        
                    </tr>
                    
                      <tr>
                    	<td style=" width:350px;"><div id="data7" onclick="details('data7')">Assignment-4 is closing today</div></td>
                        <td>aa</td>
                        
                    </tr>
                     <tr>
                    	<td><div id="data8" onclick="details('data8')">Chapter-4 is open for pre study</div></td>
                        <td>bb</td>
                        
                    </tr>
                     </tbody>                             
                </table>
                </div>
				<div id="linksMeeting" style=" display:none; border-top:1px solid grey">
            	<br/>
               <b> Details of the select Row in the table should be displayed here</b>
           		<br/>
				<br/>
          <div id="linksdetails">
		  </div>
            
            </div>
            <!-- linksMeeting -->
                <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
	<script>!window.jQuery.ui && document.write(unescape('%3Cscript src="../resources/jquery/jquery-ui-1.8.21.custom.min.js"%3E%3C/script%3E'))</script>
	<!-- mousewheel plugin -->
	<script src="../resources/js/scrollbar/jquery.mousewheel.min.js"></script>
	<!-- custom scrollbars plugin -->
	<script src="../resources/js/scrollbar/jquery.mCustomScrollbar.js"></script>
	<script>
		(function($){
			$(window).load(function(){
				$("#tblGroup").mCustomScrollbar({
					scrollButtons:{
						enable:true
					}
				});
			});
		})(jQuery);
	</script> 
               <!-- end tblGroup -->
            </div>
             <!-- end tblGroup -->
           
   
   <div id="zReturn" style="margin-top:5px; height:30px;">    		 
 <input type="button" class="btn btn-info" id="btn_return" onclick="closeit()" name="btn_return" value="Return"/>
        	</div>
            <!-- end zReturn -->
             
    </div>
    <!-- end zAnnouncement -->

</div>
</body>
</html>
