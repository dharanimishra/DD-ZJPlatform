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
function updateTodo()
{
	
	 editupdate_todo_category = $('#update_todo_categories').val();
	 editupdate_todo_description = $('#todo_edit_description').val();
	 
	 if(editupdate_todo_description ==''){return false;}
	 
	 if(editupdate_todo_category.toLowerCase() == 'add_new_category'){editupdate_todo_category = '';}
	 console.log(editupdate_todo_category);
	 console.log(editupdate_todo_description);
	 console.log(selectedRowId);
				  $.post( '<c:url value='/ztodo/updatetodo'/>'
		        , {'todoItemId':selectedRowId,'category':editupdate_todo_category,'notificationContent':editupdate_todo_description}
		        , function( data )
		        {
		        
		        	 if(data == 'TODO UPDATED SUCCESSFULLY'){
		          	   
		          	   $('#todo_response_message').html(data.fontcolor("green"));
		          	   setTimeout(doRefreshCall,3000);

		             }
		             if(data == 'Todo Updation Failed'){
		          	   $('#todo_response_message').html(data);
		          	   setTimeout(doRefreshCall,3000);
		             }
		 
		        });  
	
	
}
 function addTodo()
 {
	 
	 todo_category = capitalize($('#todo_categories').val());
	 todo_description = $('#todo_description').val();
	
	 if(todo_description ==''){return false;}
	 
	 if(todo_category.toLowerCase() == 'add_new_category'){todo_category = '';}
	
	 

		$.post( '<c:url value='/ztodo/createtodo'/>'
        , {'category':todo_category,'notificationContent':todo_description}
        , function( data )
        {
        	
           if(data == 'TODO INSERTED SUCCESSFULLY'){
        	   
        	   $('#todo_response_message').html(data.fontcolor("green"));
        	   setTimeout(doRefreshCall,3000);

           }
           if(data == 'Insert query problem'){
        	   $('#todo_response_message').html(data);
        	   setTimeout(doRefreshCall,3000);
           }
 
        });           
	
	
	
	$('.add_todo_button').removeAttr('disabled');
 }
 function doRefreshCall(){
	 $('#todo_response_message').hide();
	 window.location.href = window.location.href;
	 
 }
 </script>
 <c:url var="closeicon" value="/resources/images/icons/close-icon.png" />
 <c:url var="deleteTodoUrl" value="/ztodo/deletetodo/" />
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
			$('#todo_response_message').html(data);
       	   setTimeout(doRefreshCall,3000);
			
		}
	});
	
	
	//}
}
function closeit(){
	parent.jQuery.fancybox.close();

	}
</script>
 <!-- TODO LIst -->
  <c:url var="todocategory" value="/ztodo/gettodocategory" />
 <c:url var="showmoretodo" value="/ztodo/showalltodo" />
 <c:url var="todo" value="../resources/images/icons/todo.png" />
  <script type="text/javascript">
$(document).ready(function() {
	//ADD NEW CATEGORY
	$('#todo_category_name').focusout(function(){add_new_category_item();});
	$('#todo_description').keypress(function(event) {
	    var keycode = (event.keyCode ? event.keyCode : event.which);
	    if(keycode == '13') {
	        addTodo();  
	    }
	});
	//$('#todo_description').focusout(function(){addTodo();});
	//UPDATE ADD NEW CATEGORY
	$('#update_todo_category_name').focusout(function(){add_new_category_item_update();});
	
	
	//ADD TODO
	$('select#todo_categories').change(function(){
		
		//if($(this).val().toLowerCase() == 'add_new_category'){}
		if($(this).val() == 'add_new_category'){ show_category_form(); }
	});
	
	//UPDATE TODO
	$('select#update_todo_categories').change(function(){
				
		if($(this).val() == 'add_new_category'){ show_add_category_form(); }
	});
	
	
	
	$.ajax({
		  	type: 'GET',
			url: '${showmoretodo}',
			dataType: 'xml',
			success: function( data ) {

					
					var output="";
					
					var indexValue = 0;
					$(data).find("todolist").each(function(){
						if($(this).find("todoSize").text()==0){
							output+="<div STYLE='font-family: Arial Black;font-size: 18px; color: Green;text-align:center;'>No To-Dos Found</div>";
						}
					$(data).find("todoitem").each(function(index){
					
						indexValue = index;
						
						output+="<div ondblclick='edit_todorow_and_update("+$(this).find("id").text()+")' id='todo-row-update"+$(this).find("id").text()+"'>";
					
						output+="<div id='todoid"+$(this).find("id").text()+"' class='todocontainer' style='border:1px solid #F5F5F5;' id='contodo1'>";
						output+="<div  class='todoinfo' style='height:28px;padding:5px;'>";
						
						output+="<div  id='todo-row"+$(this).find("id").text()+"' class='todoinfo-icon' style='float:left;display:inline; margin-right:10px;'>";
						 
						output+="<img src='${todo}' alt='Info' /></div>";
						output+="<div class='todoinfo-category todotip_container'style='display:inline;' >"+short_string_category($(this).find("categoryName").text())+"<div id='category_value"+$(this).find("id").text()+"' class='categorytip'>"+$(this).find("categoryName").text()+" </div></div>";
						
						output+="<div class='todotip_more_container' id='demo-basic"+$(this).find("id").text()+"' style='font-weight:lighter;clear:both;display:inline;text-decoration:none; margin-left:10px; cursor:pointer;'><a rel='tipsy'  style='cursor:default;' >"+short_string($(this).find('subject').text())+"</a><div id='categoryDescription"+$(this).find("id").text()+"' class='todomoretip'>"+$(this).find("subject").text()+" </div></div><input type='checkbox' onChange='deleteTodoItem("+$(this).find("id").text()+")' id='cktodo1' style='float:right;'></div>";
						
						output+="</div></div>";
						
												
					});
					});
					
					
					output+="<form id='newForm' name='newForm' action='/secure/createtodo' onsubmit='return false;' method='post'>";
					output+="<div id='todo_response_message' style='height:30px; padding:5px;color:red';align:center;></div>";
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
					
					

					
					updateselect = '<option value="">&nbsp;</option>'+option_string + '<optgroup><option style="color: white; font-weight: bold; padding: 0px; margin-top: 0.5em; cursor: pointer; background: seagreen !important;" onclick="show_add_category_form();" value="add_new_category">Add New Category</option></optgroup>';
					select = '<option value="">&nbsp;</option>'+option_string + '<optgroup><option style="color: white; font-weight: bold; padding: 0px; margin-top: 0.5em; cursor: pointer; background: seagreen !important;" onclick="show_category_form();" value="add_new_category">Add New Category</option></optgroup>';
					$('select#todo_categories').html(select);
					//update
					$('select#update_todo_categories').html(select);
					
					
			}
	});	
	
	$('#todo_edit_description').keypress(function(event) {
	    var keycode = (event.keyCode ? event.keyCode : event.which);
	    if(keycode == '13') {
	        updateTodo();  
	    }
	});
		
	
	
});


function show_category_form(){
	$('#add_new_category_form').show(); $('select#todo_categories').hide();
}
function show_add_category_form(){
	$('#add_new_edit_category_form').show(); $('select#update_todo_categories').hide();
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
function add_new_category_item_update(){
	new_update_category_option = '<option value="'+capitalize($('#update_todo_category_name').val())+'">'+capitalize($('#update_todo_category_name').val())+'</option>';
	$('select#update_todo_categories').prepend(new_update_category_option);
	$('#add_new_edit_category_form').hide();
	$('select#update_todo_categories').show();
	$('select#update_todo_categories').val(capitalize($('#update_todo_category_name').val()));
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
function edit_todorow_and_update(rowId){
	selectedRowId = rowId;
	$('#update_todo_fields_container').show();
	var categorySelectedValue = $('#category_value'+rowId+'').text();
	console.log(categorySelectedValue); 
	var value = categorySelectedValue.substring(0, categorySelectedValue.length - 1);
	console.log(value);
	var vals = [value,value]; 
	console.log(vals);
	$('select#update_todo_categories').each(function(){
		$('option').each(function(){
			   var $t = $(this);

			   for (var n=vals.length; n--; )
			      if ($t.text() == vals[n]){            // method used is different
			         $t.prop('selected', true);
			         return;
			      }
			});
	   
	});
	var cateDescriptionSelectedValue = $('#categoryDescription'+rowId+'').text();
	console.log(cateDescriptionSelectedValue);
	$('#todo_edit_description').val(cateDescriptionSelectedValue);
	$('.add_todo_button').hide();
}



</script>
 <!-- End -->
<title>Todo List</title>
<body style="background-color:#FFFFFF;">
<div class="todoWrap" style="background-color:#FFFFFF;height:450;">
<!-- <div width="270px;" class="titles-info font-Signika text-size-px18 light-gray"> My To Do's</div> -->
<div class="helptext">
        	My To Do's
        </div>
<hr/>
<div id ="todo_form_container" class="addtodo" style=" width:650px; background-color:#FFFFFF;">


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

<div id = "update_todo_form_container"  class="updatetodo" style=" width:650px;  background-color:#FFFFFF;">

	<div id="update_todo_fields_container" style="display:none;">
	Category: 
	
	<select id="update_todo_categories">
		
	</select>
	<span id="add_new_edit_category_form" style="display:none;">
	 	<input id="update_todo_category_name"/>
	</span>
	Description: <input id="todo_edit_description" style="width:330px">
</div>
</div>

 
	<hr/>
<a class='btn btn-info f-r' style='margin-right:70px;' onclick='closeit()'> Return </a> 
<a class='btn btn-info f-r add_todo_button' onclick='$("#add_todo_fields_container").show(); $(this).attr("disabled",true);' style='margin-right:10px;'> Add To DO </a>
</div>

</body>
</html>