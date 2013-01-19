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
      <link rel="stylesheet" href="../resources/css/zCss.css" type="text/css"/>
	 <link rel="stylesheet" href="../resources/css/zeni/zeni2.css" type="text/css"/>
     <script language="javascript" type="text/javascript" src="../resources/js/custom/Todoalertshovercard.js"></script>
<html>

<head>
<style type="text/css">
body {
    background: #FFFFFF url("images/grain-light.png");
   }
.todoWrap
{
width:750px;

background-color:#ffffff;
}
</style>

<script type="text/javascript">
 function addTodo()
 {
	 
	 todo_category = capitalize($('#todo_categories').val());
	 todo_description = $('#todo_description').val();
	 
	 if(todo_description ==''){return false;}
	
		
		$.post( '<c:url value='/secure/createtodo'/>'
        , {'category':todo_category,'notificationContent':todo_description}
        , function( data )
        {
        
        	//refresh the page
        	window.location.href = window.location.href;
 
        }
		, 'xml' );           
	
	
	
	$('.add_todo_button').removeAttr('disabled');
 }
 </script>
 <c:url var="closeicon" value="/resources/images/icons/close-icon.png" />
 <c:url var="deleteTodoUrl" value="/secure/deletetodo/" />
<script type="text/javascript">

//function checkonTodoItem(val){ deleteTodoFunction(val);}

function deleteTodoItem(val){
	
	
	// confirm_delete_alert = confirm('Are you sure you want to delete this item?');
	//if(confirm_delete_alert == true){
		
		
	
	$.ajax({
	  	type: 'DELETE',
		url: '${deleteTodoUrl}'+val,
		//dataType: 'json',
		success: function( data ) {
			
			$('#todoid'+val).remove();
			
		}
	});
	
	
	//}
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
	
	
	
	$('select#todo_categories').change(function(){
		
		if($(this).val() == 'Add_new_category'){ alert($(this).val()); show_category_form(); }
	});
	
	
	//setTimeout('console.log("hello");', 300);
	
	$.ajax({
		  	type: 'GET',
			url: '${showmoretodo}',
			dataType: 'xml',
			success: function( data ) {

					
					var output="";
					
					var indexValue = 0;
					$(data).find("todoitem").each(function(index){
					
						indexValue = index;
						
						output+="<div id='todoid"+$(this).find("id").text()+"' class='todocontainer' style='border:1px solid #F5F5F5;' id='contodo1'>";
						output+="<div class='todoinfo' style='height:28px;padding:5px;'>";
						output+="<div id='todo-row' class='todoinfo-icon' style='float:left;display:inline; margin-right:10px;'>";
						 
						output+="<img src='${todo}' alt='Info' /></div>";
						output+="<div class='todoinfo-category todotip_container'style='display:inline;' >"+short_string_category($(this).find("categoryName").text())+"<div class='categorytip'>"+$(this).find("categoryName").text()+" </div></div>";
						
						output+="<div class='todotip_more_container' id='demo-basic"+$(this).find("id").text()+"' style='font-weight:lighter;clear:both;display:inline;text-decoration:none; margin-left:10px; cursor:pointer;'><a rel='tipsy'  style='cursor:default;' >"+short_string($(this).find('subject').text())+"</a><div class='todomoretip'>"+$(this).find("subject").text()+" </div></div><input type='checkbox' onChange='deleteTodoItem("+$(this).find("id").text()+")' id='cktodo1' style='float:right;'></div>";
						
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
					
					select_option_array = [];
					unique_select_option_array = [];
					
					
					$(data).find("todoitem").each(function(index){
						
						select_option_array.push(capitalize($(this).find("categoryName").text()));
																		
					});
					
					$.each(select_option_array, function(i, el){
						if(el !=''){
					    	if($.inArray(el, unique_select_option_array) === -1) unique_select_option_array.push(el);
						}
					});
					
					
					option_string ='';
					function construct_options(element, index, array){
						option_string+= '<option value="'+capitalize(element)+'">'+capitalize(element)+'</option>';
					}
					
	//console.log(unique_select_option_array);
					
					unique_select_option_array.forEach(construct_options);
					
					

					
					
					select = '<option value="">&nbsp;</option>'+option_string + '<optgroup><option style="color: white; font-weight: bold; padding: 0px; margin-top: 0.5em; cursor: pointer; background: seagreen !important;" onclick="show_category_form();" value="add_new_category">Add New Category</option></optgroup>';
					$('select#todo_categories').html(select);
	
					
					
			}
	});	
	
});


function show_category_form(){
	$('#add_new_category_form').show(); $('select#todo_categories').hide();
}

function displayToolTip(val){
	
	$(this).find('div.tip').show();
}

function add_new_category_item(){
	new_category_option = '<option value="'+capitalize($('#todo_category_name').val())+'">'+capitalize($('#todo_category_name').val())+'</option>';
	$('select#todo_categories').prepend(new_category_option);
	$('#add_new_category_form').hide();
	$('select#todo_categories').show();
	$('select#todo_categories').val(capitalize($('#todo_category_name').val()));
}
/// TODO: move this function to a common js file later
function short_string(string){
	
	if(string.length > 65){
		return string.substring(0,65)+'...';
	} else {
		return string;
	}	
} 
function short_string_category(value){
	if(value.length > 9){
		return value.substring(0,9)+'...';
	} else {
		return value;
	}	
}
function capitalize(s){
    return s.toLowerCase().replace( /\b./g, function(a){ return a.toUpperCase(); } );
};
///
</script>
 <!-- End -->
<title>Todo List</title>
<body style="background-color:#FFFFFF;">
<div class="todoWrap" style="background-color:#FFFFFF;">
<!-- <div width="270px;" class="titles-info font-Signika text-size-px18 light-gray"> My To Do's</div> -->
<div class="helptext">
        	My To Do's
        </div>
<hr/>
<div id = "todo_form_container" class="addtodo" style=" width:650px; background-color:#FFFFFF;">


<div id="add_todo_fields_container" style="display:none;">
	Category: 
	
	<select id="todo_categories">
		
	</select>
	<span id="add_new_category_form" style="display:none;">
	 <input id="todo_category_name"/><!-- <button onclick="add_new_category_item();">Add</button> -->
	</span>
	Description: <input id="todo_description" style="width:330px">
</div>
	

</div> <!--end of container -->  
	<hr/>
<a class='btn btn-info f-r' style='margin-right:70px;' onclick='closeit()'> Return </a> 
<a class='btn btn-info f-r add_todo_button' onclick='$("#add_todo_fields_container").show(); $(this).attr("disabled",true);' style='margin-right:10px;'> Add To DO </a>
</div>

</body>
</html>