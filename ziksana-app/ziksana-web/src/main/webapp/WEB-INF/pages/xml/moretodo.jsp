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
 function addTodo()
 {
	 
	 todo_category = $('#todo_categories').val();
	 todo_description = $('#todo_description').val();
	 
	 if(todo_category =='' || todo_description ==''){return false;}
	if(todo_description != null)
		
		   $.post( '<c:url value='/secure/createtodo'/>'
        , {'category':todo_category,'notificationContent':todo_description}
        , function( data )
        {
        

        }
		, 'json' );           
	
	else
		
		alert("Enter the Category Content value");
		
	
 }
 </script>
 <c:url var="closeicon" value="/resources/images/icons/close-icon.png" />
 <c:url var="deleteTodoUrl" value="/secure/deletetodo/1111111" />
<script type="text/javascript">
function deleteTodoFunction(val){
	
	
	 confirm_delete_alert = confirm('Are you sure you want to delete this item?');
	if(confirm_delete_alert == true){
		
		
	
	$.ajax({
	  	type: 'DELETE',
		url: '${deleteTodoUrl}'+val,
		dataType: 'json',
		success: function( data ) {
			//console.log('delete alert fired');
			//delete the alert div
			
			
		}
	});
	$('#todoid'+val).remove();
	
	}
}
function closeit(){
	parent.jQuery.fancybox.close();

	}
</script>
 <!-- TODO LIst -->
  <c:url var="todocategory" value="/secure/gettodocategory/111111" />
 <c:url var="showmoretodo" value="/secure/showmytodo/111111" />
 <c:url var="todo" value="../resources/images/icons/todo.png" />
  <script type="text/javascript">
$(document).ready(function() {
	
	$('#todo_category_name').focusout(function(){add_new_category_item();});
	$('#todo_description').focusout(function(){addTodo();});
	
	
	setTimeout('console.log("hello");', 300);
	
	$.ajax({
		  	type: 'GET',
			url: '${showmoretodo}',
			dataType: 'xml',
			success: function( data ) {
					if (console && console.log){
								console.log( 'todo of data:', data);
					}
					
					var output="";
					
					var indexValue = 0;
					$(data).find("todoitem").each(function(index){
					
						indexValue = index;
						
						output+="<div id='todoid"+$(this).find("id").text()+"' class='todocontainer' style='border:1px solid #F5F5F5;' id='contodo1'>";
						output+="<div class='todoinfo' style='height:28px;padding:5px;'>";
						output+="<div id='todo-row' class='todoinfo-icon' style='float:left;display:inline; margin-right:10px;'>";
						 
						output+="<a href='#' rel='tipsy'  style='cursor:default;' ><img src='${todo}' alt='Info' /></div>";
						output+="<div class='todoinfo-category'style='display:inline;' >"+$(this).find("categoryName").text()+"</div>";
						
						output+="<div title='"+$(this).find("subject").text()+"' id='demo-basic2'  style='font-weight:lighter;clear:both;display:inline;text-decoration:none; margin-left:10px; cursor:pointer;'>"+$(this).find("subject").text()+"</div><input type='checkbox' onChange='checkonTodoItem("+$(this).find("id").text()+")' id='cktodo1' style='float:right;'></div>";
						
						output+="</div></div>";
						
												
					});
					
					
					
					output+="<form id='newForm' name='newForm' action='/secure/createtodo' onsubmit='return false;' method='post'>";
					output+="<table><tbody>";
					output+="<tr width='100%' class='todocontainer todoinfo' style='height:30px; padding:5px;' id='contodo4'>";
					output+="<td width='20px' class='todoinfo-icon' style='float:left; margin-top:7px;'></td>";
					
					output+="</tr></tbody></table>";
					
					output+="</div></form>";
					$('#todo_form_container').prepend(output);

					
					select_options = "";
					$(data).find("todoitem").each(function(index){
	

						select_options+="<option value='"+$(this).find("categoryName").text()+"'>"+$(this).find("categoryName").text()+"</option>";

						
												
					});
					
					select = select_options + '<optgroup><option style="color: white; font-weight: bold; padding: 0px; margin-top: 0.5em; cursor: pointer; background: seagreen !important;" onclick="$(\'#add_new_category_form\').show(); $(\'select#todo_categories\').hide();">Add a New Category</option></optgroup>';
					$('select#todo_categories').html(select);
	
					
					
			}
	});
	
});

function add_new_category_item(){
	new_category_option = '<option value="'+$('#todo_category_name').val()+'">'+$('#todo_category_name').val()+'</option>';
	$('select#todo_categories').prepend(new_category_option);
	$('#add_new_category_form').hide();
	$('select#todo_categories').show();
	$('select#todo_categories').val($('#todo_category_name').val());
}
function checkonTodoItem(val){
	$('#todoid'+val).remove();
}
</script>
 <!-- End -->
<title>Todo List</title>
<body  style="background-image:none;"">
<div width="270px;" class="titles-info font-Signika text-size-px18 light-gray"> My To Do's</div>
<div id = "todo_form_container" class="addtodo" style="width:650px; background-color:#eeeeee;">
	<strong>Add New ToDo</strong><hr/>Category: 
	
	<select id="todo_categories">
		
	</select>
	<span id="add_new_category_form" style="display:none;">
	<input id="todo_category_name" placeholder="Type New Category"/><button onclick="add_new_category_item();">Add</button>
	</span>
	Description: <input id="todo_description" style="width:350px">
	
	<hr/>
	<a class='btn btn-info f-r' onclick='closeit()'> Return </a>
	<a class='btn btn-info f-r' onclick='addTodo()'  href='' style='margin-right:10px;'> Add TODO </a>


</div> <!--end of container -->  

</body>
</html>