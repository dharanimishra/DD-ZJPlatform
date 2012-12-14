<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script type="text/javascript" src="../resources/js/tree/jquery-1.8.0.min.js"></script>
<link href="../resources/css/styles.css" rel="stylesheet" type="text/css">
	<link href="../resources/css/type-setting.css" rel="stylesheet" type="text/css">
	<link href="../resources/css/effects.css" rel="stylesheet" type="text/css">
	<link href="../resources/css/nav.css" rel="stylesheet" type="text/css">
   	
	 <script src="../resources/js/jquery-1.7.2.min.js"></script>
	 <script src="../resources/js/ui/jquery.ui.core.js"></script>
	 <script src="../resources/js/ui/jquery.ui.widget.js"></script>
	 <script src="../resources/js/ui/jquery.ui.button.js"></script>
	 <script src="../resources/js/ui/jquery.ui.progressbar.js"></script>
	 <script src="../resources/js/ui/jquery.ui.tabs.js"></script>
     <script src="../resources/js/jquery.hovercard.js"></script>
     <script src="../resources/js/todo.js" type="text/javascript"></script> 
     <script language="javascript" type="text/javascript" src="../resources/js/custom/Todoalertshovercard.js"></script>
<html>
<head>
<script type="text/javascript">
function home(){
	window.opener.close();
	
}
</script>

<script type="text/javascript">
 function createNewAnswer()
 {
	 
	 todo_category = $('#Todocategory').val();
	 todo_notificationContent = $('#tododescriptionvalue').val();
	if(todo_notificationContent != null)
		
		   $.post( '<c:url value='/secure/createtodo'/>'
        , {'category':todo_category,'notificationContent':todo_notificationContent}
        , function( data )
        {
        

        }
		, 'json' );           
	
	else
		
		alert("Enter the Category Content value");
		
	
 }
 </script>
 
 <!-- TODO LIst -->
 <c:url var="showmoretodo" value="/secure/showmytodo/111111" />
 <c:url var="todo" value="../resources/images/icons/todo.png" />
  <script type="text/javascript">
$(document).ready(function() {
	$.ajax({
		  	type: 'GET',
			url: '${showmoretodo}',
			dataType: 'xml',
			success: function( data ) {
					if (console && console.log){
								console.log( 'todo of data:', data);
					}
					var output="";
					
					
					$(data).find("todoitem").each(function(index){
						output+="<table class='todo' id='todotable' >";
							output+="<tbody id='todobody' style='border-bottom:1px solid #F5F5F5;' >";
							output+="<tr width='100%' class='todocontainer todoinfo' style='height:28px;padding:5px;border:1px solid green;' id='contodo1' >";
							output+="<td width='20px' class='todoinfo-icon' style='padding-right:10px;'>";
							output+="<img src=${todo} alt='Info'  /> </td>";
							output+="<td width='' class='todoinfo-category' style='margin-top:7px; padding-right:10px;' >"+$(this).find("categoryName").text()+"</td>";
							output+="<td class='todoinfo-decription' style='margin-top:7px;' >";
							output+="<span width='200px' id='demo-basictodo1' style='font-weight:lighter; cursor:pointer;'>"+$(this).find("subject").text()+"</span></td>";
							output+="<td width='20px' class='todoinfo-button' style='padding-top:7px;' >";
							output+="<a href='#linkurl' rel='tipsy' title='Complete'><input type='checkbox' id='cktodo1'> </a>";
							output+="</td></tr></tbody></table>";
						
												
					});
					
					output+="<form id='newForm' name='newForm' action='/secure/createtodo' onsubmit='return false;' method='post'>";
					output+="<table><tbody>";
					output+="<tr width='100%' class='todocontainer todoinfo' style='height:30px; padding:5px;' id='contodo4'>";
					output+="<td width='20px' class='todoinfo-icon' style='float:left; margin-top:7px;'>";
					output+="<img src='../images/icons/todo.png' alt='Info' /> </td>";
					output+="<td width='60px' style='margin-top:7px; padding-right:60px; float:left;' >";
					output+="<select name='Todocategory' id='Todocategory' class='defaultvalue labelclass'>";
					output+="<option id='todo1'>Courses</option><option id='todo2'>Assignment</option><option id='todo3'>Grading</option> <option id='todo4'>Others</option></select></td>";
					output+="<td class='todoinfo-decription' style='margin-top:7px;' >";
					output+="<span width='200px' id='demo-basictodo3' style='font-weight:lighter; cursor:pointer;'>";
					output+="<input type='text' autofocus class='defaultvalue treeRoot' id='tododescriptionvalue' placeholder='Enter the New To Do' style='width:280px; margin-left:10px; color:#666;' value=''>";
					output+="</span></td></tr></tbody></table>";
					output+="<div style='height:60px; margin-right:80px; margin-top:20px; clear:both;' >";
					output+="<a class='btn btn-info f-r' href='JavaScript:window.close()'> Return </a>";
					output+="<a class='btn btn-info f-r' onclick='createNewAnswer()'  href='' style='margin-right:10px;'> Add TODO </a> ";
					output+="</div></form>";
					$('#addtodo').html(output);

					console.log("TODO: " + output);
				
					
					
					
			}
	});
	
});
</script>
 <!-- End -->
<title>Todo List</title>
<body  style="background-image:none;"">
<div width="270px;" class="titles-info font-Signika text-size-px18 light-gray"> My To Do's</div>
<div id = "addtodo" class="addtodo" style="width:650px; background-color:#eeeeee;">



</div> <!--end of container -->  
 
</body>
</html>