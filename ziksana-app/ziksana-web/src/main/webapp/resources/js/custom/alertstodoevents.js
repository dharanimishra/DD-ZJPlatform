// JavaScript Document
$(document).ready(function(e) {
$(".contentareaalrt").hide();
$(".contentareatodo").hide();
$(".contentareamanagetodo").hide(); 
$("#todotype").hide(); 
 $("#addtodorow").hide(); 
//$(".todocontainer").hide();




$(".addtodobtn").click(function(e) {
   // $("#addtodorow").toggle(200);
	$("#add_todo_fields_container").show();
});



$(".tagevent").click(function(e) {
	 $(".contentareaalrt").slideUp(200); 
	 $(".contentareatodo").slideUp(200);
	 $(".contentareamanagetodo").slideUp(500);
    $(".contentareaevent").slideDown(500); 
});

$(".tagtask").click(function(e) {
	 $(".contentareaalrt").slideUp(200); 
    $(".contentareaevent").slideUp(200);
	$(".contentareamanagetodo").slideUp(500);
	get_and_populate_todo();
	$(".contentareatodo").slideDown(500);
	
});

 

$(".managetodo").click(function(e) {
	 $(".contentareaalrt").slideUp(200); 
    $(".contentareaevent").slideUp(200);
	$(".contentareatodo").slideUp(200);
	get_and_populate_todo_value();
	$(".contentareamanagetodo").slideDown(500);
	});

	
$("#todocategoryddl").change(function(e) {
    if($("#todocategoryddl").val() == "Other")
	{
		$("#todocategoryddl").hide();
		$("#todotype").show();
		
	}
	
	
	});
	
	
if($("#todocategoryddl").val() == "University")
	{
		$("#todosave").click(function(e) {
            var val1 = $("#todocategoryddl").val();
			var val2 = $("#todotype").val();
			var val3 = $("#tododescription").val();
			if(val2 == "")
			{
				$(".eventdata").prepend(' <tr> <td><input type="checkbox" id="c1" name="cc" /> <label for="c1"><span></span></label></td> <td>'+val1+'</td><td>'+val3+'</td><td></td></tr>');
			}
			else
			{
				$(".eventdata").prepend(' <tr> <td><input type="checkbox" id="c1" name="cc" /> <label for="c1"><span></span></label></td> <td>'+val2+'</td><td>'+val3+'</td><td></td></tr>');
			}
        });
	}
		
	

});

//TODO Ajax Call
var no_of_available_todo;
function get_and_populate_todo(){
	$.ajax({
	  	type: 'GET',
		url: '/ziksana-web/ztodo/showalltodo',
		dataType: 'xml',
		success: function( data ) {
				
				var output_todo="";
				
				var indexValue = 0;
				
			
				
				
				$.get('/ziksana-web/ztodo/gettodosize', {}, function(size){ 
					no_of_available_todo = size;
				
					var ouputEmptyTodo="";
					
					
					if(no_of_available_todo == 0){$('#todos_placeholder').html(ouputEmptyTodo);} else{
					
						ouputEmptyTodo+="<table class='table table-hover table-striped'>";
						ouputEmptyTodo+="<tbody>";
						 $(data).find("todoitem").each(function(index){
							 ouputEmptyTodo+="<tr id='todorow"+$(this).find('id').text()+"'><td style='width:50px'><input type='checkbox' id='c"+index +"' onchange='handleChange(this,"+$(this).find('id').text()+");' /> <label for='c"+index +"'><span></span></label></td><td>"+$(this).find("categoryName").text()+"</td>";
							 ouputEmptyTodo+="<td  class='todoinfo-decription' ><span  width='200px' id='demo-basic' style='cursor: pointer; margin-bottom: 6px;'>"+short_string($(this).find("subject").text())+"</span></tr>";
							 
						 });
						 ouputEmptyTodo+="</tbody></table>";
						
						 
						$('#todos_placeholder').html(ouputEmptyTodo);
						
						
					}
					
				});
		}	
	});
						  
}
function get_and_populate_todo_value(){
	$.ajax({
	  	type: 'GET',
		url: '/ziksana-web/ztodo/showalltodo',
		dataType: 'xml',
		success: function( data ) {
				
				var output_todo="";
				
				var indexValue = 0;
				
			
				
				
				$.get('/ziksana-web/ztodo/gettodosize', {}, function(size){ 
					no_of_available_todo = size;
				
					var ouputEmptyTodo="";
					var updateEditValue="";
					
					if(no_of_available_todo == 0){$('#todos_placeholder_more').html(ouputEmptyTodo);} else{
					
						ouputEmptyTodo+="<table class='table table-hover table-striped' >";
						ouputEmptyTodo+="<tbody>";
						 $(data).find("todoitem").each(function(index){
							 ouputEmptyTodo+="<tr id='moretodorow"+$(this).find('id').text()+"' style='height:50px;'>";
							 ouputEmptyTodo+="<td><div ><input type='checkbox' id='c"+index+2 +"' onchange='handle(this,"+$(this).find('id').text()+");' /> <label for='c"+index+2 +"'><span></span></label></td><td><div id='category_value"+$(this).find("id").text()+"'>"+$(this).find("categoryName").text()+" </div></td>";
							 ouputEmptyTodo+="<td><span id='categoryDescription"+$(this).find("id").text()+"' class='todoinfo-decription' id='demo-basic' style='cursor: pointer; margin-bottom: 6px;background-color:transparent!important;'>"+short_string($(this).find("subject").text())+"</span></td><td><a onclick='edit_todorow_and_update("+$(this).find("id").text()+")' style='margin-left:30px;color:white;'>Edit</a></td></div>";
							 ouputEmptyTodo+="</tr>";
							 ouputEmptyTodo+="<tr id = 'update_todo_form_container"+$(this).find('id').text()+"' style='height:50px;display:none;'>";
							 ouputEmptyTodo+="<div class='updatetodo'>";
							 
							 ouputEmptyTodo+="<td></td><td><select onblur='updateSelectChange("+$(this).find('id').text()+")' id='update_todo_categories"+$(this).find('id').text()+"'' style='margin-left:40px;width:150px;'><optgroup><option style='color: white; font-weight: bold; padding: 0px; margin-top: 0.5em; cursor: pointer; background: seagreen !important;' onclick='show_add_category_form("+$(this).find('id').text()+");' value='add_new_category'>Add New Category</option></optgroup>'</select></td>";
							
							 ouputEmptyTodo+="<td><span id='add_new_edit_category_form"+$(this).find('id').text()+"' style='display:none;'><input onblur='updateTextBoxChange("+$(this).find('id').text()+");' id='update_todo_category_name"+$(this).find('id').text()+"'/></span></td>";
							
							 ouputEmptyTodo+="<td><input id='todo_edit_description"+$(this).find('id').text()+"' style='width:200px;height:28px;'/></td><td><a onclick='saveRow_hideEdit("+$(this).find('id').text()+")' style='margin-left:30px;color:white;'>Update</a></td><td><a onclick='showRow_hideEdit("+$(this).find('id').text()+")' style='margin-left:30px;color:white;'>Cancel</a></td></div>";
							 ouputEmptyTodo+="</tr>";
							
						 });
						 ouputEmptyTodo+="</tbody></table>";
					
						$('#todos_placeholder_more').html(ouputEmptyTodo);
						
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
						option_string ='<option selected="selcted" value="Select a Category">Select a Category</option>';
						function construct_options(element, index, array){
							option_string+= '<option value="'+capitalize(element)+'">'+capitalize(element)+'</option>';
						}
						
						//console.log(unique_select_option_array);
						
						unique_select_option_array.forEach(construct_options);
	
						select = '<option value="">&nbsp;</option>'+option_string + '<optgroup><option style="color: white; font-weight: bold; padding: 0px; margin-top: 0.5em; cursor: pointer; background: seagreen !important;" onclick="show_category_form();" value="add_new_category">Add New Category</option></optgroup>';
						
						updateselect = '<option value="">&nbsp;</option>'+option_string + '';//
						
						$('select#todo_categories').html(select);
						$(data).find("todoitem").each(function(index){
						$('select#update_todo_categories'+$(this).find('id').text()+'').prepend(updateselect);
						});
					}
					
				});
		}	
	});
}
function updateSelectChange(b){

	$('select#update_todo_categories'+b+'').change(function(){if($(this).val() == 'add_new_category'){ show_add_category_form(b); }});

}

function updateTextBoxChange(v){
	console.log("Textbox"+v);

		console.log("add_new_category_item_update"+v);
		new_update_category_option = '<option value="'+capitalize($('#update_todo_category_name'+v+'').val())+'">'+capitalize($('#update_todo_category_name'+v+'').val())+'</option>';
		$('select#update_todo_categories'+v+'').prepend(new_update_category_option);
		$('#add_new_edit_category_form'+v+'').hide();
		$('select#update_todo_categories'+v+'').show();
		$('select#update_todo_categories'+v+'').val(capitalize($('#update_todo_category_name'+v+'').val()));
	
}

function short_string(string){
	
	if(string.length > 50){
		return string.substring(0,50)+'...';
	} else {
		return string;
	}	
} 


function handleChange(a,cb) {
	  var i = $('#c'+cb+'').val();
	  if(a.checked == true){
		  $('#todorow'+cb+'').addClass('closedtodo');
		  $.ajax({
			  	type: 'DELETE',
				url: '/ziksana-web/ztodo/deletetodo/'+cb,
				//dataType: 'json',
				success: function( data ) {
					$(".tagtask").click();
					
				}
			});

	  }else{
		 
		  $('#todorow'+cb+'').removeClass('closedtodo');
		
	  }
}

function handle(a,cb) {
	  var i = $('#checkstatus'+cb+'').val();

	  if(a.checked == true){
		  
		 
			        	 $('#moretodorow'+cb+'').addClass('closedtodo');
			        	 if(a.checked == true){
			       		  $('#todorow'+cb+'').addClass('closedtodo');
			       		  $.ajax({
			       			  	type: 'DELETE',
			       				url: '/ziksana-web/ztodo/deletetodo/'+cb,
			       				//dataType: 'json',
			       				success: function( data ) {
			       					 $(".managetodo").click();
			       					
			       				}
			       			});

			       	  }else{
			       		 
			       		  $('#todorow'+cb+'').removeClass('closedtodo');
			       		
			       	  }

	  }else{
		  $('#moretodorow'+cb+'').removeClass('closedtodo');
		
	  }
}


function capitalize(s){
    return s.toLowerCase().replace( /\b./g, function(a){ return a.toUpperCase(); } );
};

//***********************************

function show_category_form(){
	$('#add_new_category_form').show(); $('select#todo_categories').hide();
}
function add_new_category_item(){
	new_category_option = '<option value="'+capitalize($('#todo_category_name').val())+'">'+capitalize($('#todo_category_name').val())+'</option>';
	$('select#todo_categories').prepend(new_category_option);
	$('#add_new_category_form').hide();
	$('select#todo_categories').show();
	$('select#todo_categories').val(capitalize($('#todo_category_name').val()));
}

function addTodo()
{
	 
	 todo_category = capitalize($('#todo_categories').val());
	 todo_description = $('#todo_description').val();
	
	 if(todo_description ==''){return false;}
	 
	 if(todo_category.toLowerCase() == 'add_new_category'){todo_category = '';}
	
	 

		$.post( '/ziksana-web/ztodo/createtodo'
       , {'category':todo_category,'notificationContent':todo_description}
       , function( data )
       {
       	
          if(data == 'TODO INSERTED SUCCESSFULLY'){
        	  console.log(data);
        	  $(".managetodo").click();

          }
          if(data == 'Insert query problem'){
        	  console.log(data);
          }

       });           
	

}

function saveRow_hideEdit(v)
{
	
	 editupdate_todo_category = $('#update_todo_categories'+v+'').val();
	 editupdate_todo_description = $('#todo_edit_description'+v+'').val();
	 selectedRowId = v;
	 console.log(editupdate_todo_category);
	 console.log(editupdate_todo_description);
	 console.log(selectedRowId);
	 if(editupdate_todo_description ==''){return false;}
	 
	 if(editupdate_todo_category.toLowerCase() == 'add_new_category'){editupdate_todo_category = '';}

				$.post( '/ziksana-web/ztodo/updatetodo'
		        , {'todoItemId':selectedRowId,'category':editupdate_todo_category,'notificationContent':editupdate_todo_description}
		        , function( data )
		        {
		        
		        	 if(data == 'TODO UPDATED SUCCESSFULLY'){

			          	$('#moretodorow'+v+'').show();
			        	$('#update_todo_form_container'+v+'').hide();
			        	
			        	$('#add_new_edit_category_form'+v+'').hide();
			        	$('select#update_todo_categories'+v+'').show();
			        	 $(".managetodo").click();
		             }
		             if(data == 'Todo Updation Failed'){
		          	  console.log(data);
		             }
		 
		        });  
	
	
}
	



$(document).ready(function() {
	//ADD NEW CATEGORY
	$('#todo_category_name').focusout(function(){add_new_category_item();});
	$('#todo_description').keypress(function(event) {
	    var keycode = (event.keyCode ? event.keyCode : event.which);
	    if(keycode == '13') {
	        addTodo();  
	    }
	});
	
	//ADD TODO
	$('select#todo_categories').change(function(){
		
		//if($(this).val().toLowerCase() == 'add_new_category'){}
		if($(this).val() == 'add_new_category'){ show_category_form(); }
	});
	
	
	
	
	
	
});



function hideTodoAdd(){
	$('#add_todo_fields_container').hide();
}
//######Edit and UPDATE

function show_add_category_form(val){
	console.log(val);
	$('#add_new_edit_category_form'+val+'').show(); $('select#update_todo_categories'+val+'').hide();
}
//UPDATE ADD NEW CATEGORY


function add_new_category_item_update(v){
	console.log("add_new_category_item_update"+v);
	new_update_category_option = '<option value="'+capitalize($('#update_todo_category_name'+v+'').val())+'">'+capitalize($('#update_todo_category_name'+v+'').val())+'</option>';
	$('select#update_todo_categories'+v+'').prepend(new_update_category_option);
	$('#add_new_edit_category_form'+v+'').hide();
	$('select#update_todo_categories'+v+'').show();
	$('select#update_todo_categories'+v+'').val(capitalize($('#update_todo_category_name').val()));
}
function edit_todorow_and_update(rowId){
	selectedRowId = rowId;
	$('#moretodorow'+rowId+'').hide();
	$('#update_todo_form_container'+rowId+'').show();
	var categorySelectedValue = $('#category_value'+rowId+'').text();
	console.log(categorySelectedValue); 
	var value = categorySelectedValue.substring(0, categorySelectedValue.length - 1);
	console.log(value);
	var vals = [value,value]; 
	console.log(vals);
	var a = $('select#update_todo_categories'+rowId+'').val();
	console.log(a);
	
	$('select#update_todo_categories'+rowId+'').each(function(){
		$('option').each(function(){
			   var $t = $(this);

			   for (var n=vals.length; n--; )
				   if ($t.text() == vals[n]){            // method used is different
				         $t.prop('selected', true);
				         console.log($t.text());
				         return;
				      }        // method used is different
			         console.log($t.text());
			      
			});
	   
	});
	
	var cateDescriptionSelectedValue = $('#categoryDescription'+rowId+'').text();
	console.log(cateDescriptionSelectedValue);
	$('#todo_edit_description'+rowId+'').val(cateDescriptionSelectedValue);
	

}
function showRow_hideEdit(val){
	$('#moretodorow'+val+'').show();
	$('#update_todo_form_container'+val+'').hide();
	
	$('#add_new_edit_category_form'+val+'').hide();
	$('select#update_todo_categories'+val+'').show();
}