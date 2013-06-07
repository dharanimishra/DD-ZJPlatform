// JavaScript Document
$(document).ready(function(e) {
$(".contentareaalrt").hide();
$(".contentareatodo").hide();
$(".contentareamanagetodo").hide(); 
$(".annnouncementpanel").hide();
$(".announcementwrapper").hide();
$("#annaouncementFooter").hide();
$("#todotype").hide(); 
 $("#addtodorow").hide();

//$(".todocontainer").hide();




$(".addtodobtn").click(function(e) {
   // $("#addtodorow").toggle(200);
	$("#add_todo_fields_container").show();
	document.getElementById("descriptionErrorMsg").innerHTML = '';
	for(var i=0;i<5;i++){
		   
		   $('#hideEditOption'+i+'').click();
	  
		 } 
	for(var i=0;i<4;i++){
		 $('#manageTodoErrorMsg'+i+'').html("");
		 }
	
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
	get_and_populate_todo(0);
	$(".contentareatodo").slideDown(500);
	
});

 

$(".managetodo").click(function(e) {
	 $(".contentareaalrt").slideUp(200); 
    $(".contentareaevent").slideUp(200);
	$(".contentareatodo").slideUp(200);
	get_and_populate_todo_value(0);
	$(".contentareamanagetodo").slideDown(500);
	});

	//Announcement Page
	$(".announcement_box").click(function(e){
		$("#announcementPagination").show();
		$(".contentareaalrt").hide();
		$(".contentareatodo").hide();
		$(".contentareamanagetodo").hide(); 
		$("#todotype").hide(); 
		$("#addtodorow").hide();
		 $(".contentareaevent").hide(); 
		 $(".panelhead").hide();
		$(".annnouncementpanel").show(); 
		$(".announcementwrapper").show();
		$("#annaouncementFooter").show();
		get_and_populate_announcements(0);
		
	});
	$(".Allbtn").click(function(e){
		get_and_populate_announcements(0);
	});
	$(".Universitybtn").click(function(e){
		get_and_populate_universityannouncements(0);
	});
	$(".Departmentbtn").click(function(e){
		get_and_populate_departmentannouncements(0);
	});
	$(".Coursebtn").click(function(e){
		get_and_populate_courseannouncements(0);
	});

});
//Close Announcements
function close_announcements(){
	$(".annnouncementpanel").hide(); 
	$(".announcementwrapper").hide();
	$("#announcementPagination").hide();
	$("#annaouncementFooter").hide();
	 $(".panelhead").show();
	 $(".contentareaalrt").slideUp(200); 
	 $(".contentareatodo").slideUp(200);
	 $(".contentareamanagetodo").slideUp(500);
    $(".contentareaevent").slideDown(500); 
}
//Announcement Ajax Call
function get_and_populate_announcements(val){
		$.ajax({
	  	type: 'GET',
		url: '/ziksana-web/zannouncements/1/getannouncements/'+val,
		dataType: 'xml',
		success: function( data ) {
			var announcement_all = '';
			var closeAnnouncement = '';
			var totalSize = 0;
			$(data).find("announcementsList").each(function(){
				if($(this).find("announcementSize").text()==0){
					
					announcement_all+="No New Announcements";
				}
				totalSize = $(this).find("announcementSize").text();
					paginationString ="";
					noOfPages = totalSize/3;
					console.log(noOfPages);
					for(var i=0;i<noOfPages;i++){
						
						paginationString+= "<span onclick='get_and_populate_announcements(calculatePage("+i+"))' id='pag_active"+i+"' class='pagination_bar'/>";
						
					}
				
					
				$(data).find("announcements").each(function(index){

					announcement_all+="<div id='announcement"+index+"' class='announcementhead'>";
					announcement_all+="<p class='announcementname pull-left'>"+ $(this).find("message").text()+"</p>";
					announcement_all+="<p class='announcementdate pull-right'>"+$(this).find("announcementDate").text()+"</p>";
					announcement_all+="<div class='Clearfix'> </div>";
					announcement_all+="<p class='announcementdate'>"+$(this).find("description").text()+"</p>";
					announcement_all+="<a class='accordion-toggle pull-right' data-toggle='collapse' data-parent='#accordion2' onclick='toggleSeemore($(this));' style='color:#fff'>Read More</a></div>";
					announcement_all+="<div class='Clearfix'> </div>";
					
				});
				
				$('#announcement_box_all').html(announcement_all);
				closeAnnouncement+= "<img  onclick='close_announcements()' id='sample_editable_1_new' class='addtodobtn' title='Close Announcement' style='height: 26px; margin-top: -2px;float:right;cursor:pointer' src='/ziksana-web/resources/images/icons/close.png'>";
				if(noOfPages > 1){
					$('#announcementPagination').html(paginationString);
				}else{
					$('#announcementPagination').html("");
				}
				$('#annaouncementFooter').html(closeAnnouncement);
				if(val == 0){					
					$('#pag_active0').addClass('pactive');
				}else if(val == 3){					
					$('#pag_active1').addClass('pactive');
				}else if(val == 6){
					$('#pag_active2').addClass('pactive');
				}
				
				$('#announcement1').addClass('nobgcolor');
				$('#announcement1').removeClass('announcementhead');
			});
			
		}
	});
		$('.Allbtn').addClass('announcement_tab');
		$('.Universitybtn').removeClass('announcement_tab');
		$('.Departmentbtn').removeClass('announcement_tab');
		$('.Coursebtn').removeClass('announcement_tab');

}
function calculatePage(val){
	if(val == 0){		
		return 0;
	}else if(val == 1){
		
		return 3;	
	}else if(val == 2){
	
		return 6;
	}
	
}
function get_and_populate_universityannouncements(val){
	$.ajax({
	  	type: 'GET',
		url: '/ziksana-web/zannouncements/1/getuniversityannouncements/'+val,
		dataType: 'xml',
		success: function( data ) {
			var announcement_all = '';
			var closeAnnouncement = '';
			var totalSize = 0;
			$(data).find("announcementsList").each(function(){
				if($(this).find("announcementSize").text()==0){
					console.log( $(this).find("announcementSize").text());
					announcement_all+="No New Announcements";
				}
				totalSize = $(this).find("announcementSize").text();
					paginationString ="";
					noOfPages = totalSize/3;
					for(var i=0;i<noOfPages;i++){
						
						paginationString+= "<span onclick='get_and_populate_announcements(calculatePage("+i+"))' id='pag_active"+i+"' class='pagination_bar'/>";
						
					}
				$(data).find("announcements").each(function(index){

					announcement_all+="<div id='announcement"+index+"' class='announcementhead'>";
					announcement_all+="<p class='announcementname pull-left'>"+ $(this).find("message").text()+"</p>";
					announcement_all+="<p class='announcementdate pull-right'>"+$(this).find("announcementDate").text()+"</p>";
					announcement_all+="<div class='Clearfix'> </div>";
					announcement_all+="<p class='announcementdate pull-right'>"+$(this).find("description").text()+"</p>";
					announcement_all+="<a class='accordion-toggle pull-right' data-toggle='collapse' data-parent='#accordion2' onclick='toggleSeemore($(this));' style='color:#fff'>Read More</a></div>";
					announcement_all+="<div class='Clearfix'> </div>";
					
				});
				
				$('#announcement_box_all').html(announcement_all);
				closeAnnouncement+= "<img  onclick='close_announcements()' id='sample_editable_1_new' class='addtodobtn' title='Close Announcement' style='height: 26px; margin-top: -2px;float:right;cursor:pointer' src='/ziksana-web/resources/images/icons/close.png'>";
				if(noOfPages > 1){
					$('#announcementPagination').html(paginationString);
				}else{
					$('#announcementPagination').html("");
				}
				$('#annaouncementFooter').html(closeAnnouncement);
				if(val == 0){					
					$('#pag_active0').addClass('pactive');
				}else if(val == 3){					
					$('#pag_active1').addClass('pactive');
				}else if(val == 6){
					$('#pag_active2').addClass('pactive');
				}
				$('#announcement1').addClass('nobgcolor');
				$('#announcement1').removeClass('announcementhead');
			});
			
		}
	});
	$('.Allbtn').removeClass('announcement_tab');
	$('.Universitybtn').addClass('announcement_tab');
	$('.Departmentbtn').removeClass('announcement_tab');
	$('.Coursebtn').removeClass('announcement_tab');

}
function get_and_populate_departmentannouncements(val){
	$.ajax({
	  	type: 'GET',
		url: '/ziksana-web/zannouncements/1/getdeptannouncements/'+val,
		dataType: 'xml',
		success: function( data ) {
			var announcement_all = '';
			var closeAnnouncement = '';
			var totalSize = 0;
			$(data).find("announcementsList").each(function(){
				if($(this).find("announcementSize").text()==0){
					console.log( $(this).find("announcementSize").text());
					announcement_all+="No New Announcements";
				}
				totalSize = $(this).find("announcementSize").text();
					paginationString ="";
					noOfPages = totalSize/3;
					for(var i=0;i<noOfPages;i++){
						
						paginationString+= "<span onclick='get_and_populate_announcements(calculatePage("+i+"))' id='pag_active"+i+"' class='pagination_bar'/>";
						
					}
				$(data).find("announcements").each(function(index){

					announcement_all+="<div id='announcement"+index+"' class='announcementhead'>";
					announcement_all+="<p class='announcementname pull-left'>"+ $(this).find("message").text()+"</p>";
					announcement_all+="<p class='announcementdate pull-right'>"+$(this).find("announcementDate").text()+"</p>";
					announcement_all+="<div class='Clearfix'> </div>";
					announcement_all+="<p class='announcementdate pull-right'>"+$(this).find("description").text()+"</p>";
					announcement_all+="<a class='accordion-toggle pull-right' data-toggle='collapse' data-parent='#accordion2' onclick='toggleSeemore($(this));' style='color:#fff'>Read More</a></div>";
					announcement_all+="<div class='Clearfix'> </div>";
					
				});
				
				$('#announcement_box_all').html(announcement_all);
				closeAnnouncement+= "<img  onclick='close_announcements()' id='sample_editable_1_new' class='addtodobtn' title='Close Announcement' style='height: 26px; margin-top: -2px;float:right;cursor:pointer' src='/ziksana-web/resources/images/icons/close.png'>";
				if(noOfPages > 1){
					$('#announcementPagination').html(paginationString);
				}else{
					$('#announcementPagination').html("");
				}
				$('#annaouncementFooter').html(closeAnnouncement);
				if(val == 0){					
					$('#pag_active0').addClass('pactive');
				}else if(val == 3){					
					$('#pag_active1').addClass('pactive');
				}else if(val == 6){
					$('#pag_active2').addClass('pactive');
				}
				$('#announcement1').addClass('nobgcolor');
				$('#announcement1').removeClass('announcementhead');
			});
			
		}
	});
	$('.Allbtn').removeClass('announcement_tab');
	$('.Universitybtn').removeClass('announcement_tab');
	$('.Departmentbtn').addClass('announcement_tab');
	$('.Coursebtn').removeClass('announcement_tab');

}
function get_and_populate_courseannouncements(val){
	$.ajax({
	  	type: 'GET',
		url: '/ziksana-web/zannouncements/1/getcourseannouncements/'+val,
		dataType: 'xml',
		success: function( data ) {
			var announcement_all = '';
			var closeAnnouncement = '';
			var totalSize = 0;
			$(data).find("announcementsList").each(function(){
				if($(this).find("announcementSize").text()==0){
					console.log( $(this).find("announcementSize").text());
					announcement_all+="No New Announcements";
				}
				totalSize = $(this).find("announcementSize").text();
					paginationString ="";
					noOfPages = totalSize/3;
					for(var i=0;i<noOfPages;i++){
						
						paginationString+= "<span onclick='get_and_populate_announcements(calculatePage("+i+"))' id='pag_active"+i+"' class='pagination_bar'/>";
						
					}
					
				$(data).find("announcements").each(function(index){

					announcement_all+="<div id='announcement"+index+"' class='announcementhead'>";
					announcement_all+="<p class='announcementname pull-left'>"+ $(this).find("message").text()+"</p>";
					announcement_all+="<p class='announcementdate pull-right'>"+$(this).find("announcementDate").text()+"</p>";
					announcement_all+="<div class='Clearfix'> </div>";
					announcement_all+="<p class='announcementdate pull-right'>"+$(this).find("description").text()+"</p>";
					announcement_all+="<a class='accordion-toggle pull-right' data-toggle='collapse' data-parent='#accordion2' onclick='toggleSeemore($(this));' style='color:#fff'>Read More</a></div>";
					announcement_all+="<div class='Clearfix'> </div>";
					
				});
				
				$('#announcement_box_all').html(announcement_all);
				closeAnnouncement+= "<img  onclick='close_announcements()' id='sample_editable_1_new' class='addtodobtn' title='Close Announcement' style='height: 26px; margin-top: -2px;float:right;cursor:pointer' src='/ziksana-web/resources/images/icons/close.png'>";
				if(noOfPages > 1){
					$('#announcementPagination').html(paginationString);
				}else{
					$('#announcementPagination').html("");
				}
				
				$('#annaouncementFooter').html(closeAnnouncement);
				if(val == 0){					
					$('#pag_active0').addClass('pactive');
				}else if(val == 3){					
					$('#pag_active1').addClass('pactive');
				}else if(val == 6){
					$('#pag_active2').addClass('pactive');
				}
				$('#announcement1').addClass('nobgcolor');
				$('#announcement1').removeClass('announcementhead');
			});
			
		}
	});
	$('.Allbtn').removeClass('announcement_tab');
	$('.Universitybtn').removeClass('announcement_tab');
	$('.Departmentbtn').removeClass('announcement_tab');
	$('.Coursebtn').addClass('announcement_tab');

}
$(function(){
   $('.accordion-toggle').click(function(e){
		p = $(this).prev('p');
		console.log(p);
		if(p.hasClass('show_more')){
			p.removeClass('show_more');
		} else {
			p.addClass('show_more');
		}
		
		return false;
		
	});

});

 
//TODO Ajax Call
var no_of_available_todo;
function get_and_populate_todo(val){
	
	$.ajax({
	  	type: 'GET',
		url: '/ziksana-web/ztodo/showtodobypagination/'+val,
		dataType: 'xml',
		success: function( data ) {
				
				var output_todo="";
				
				var indexValue = 0;
				
				
				$.get('/ziksana-web/ztodo/gettodosize', {}, function(size){ 
					no_of_available_todo = size;
					paginationString ="";
					noOfPages = size/5;
					for(var i=0;i<noOfPages;i++){
						
						paginationString+= "<span onclick='get_and_populate_todo(calculateTodoPage("+i+"))' id='pag_active"+i+"' class='pagination_bar'/>";
						
					}
										
					var ouputMoreTodo="";
			
					var ouputEmpty = "<span style='margin-left:250px;color:white;'>No To-Dos to display</span>";
					
					if(no_of_available_todo == 0){$('#todos_placeholder').html(ouputEmpty);} else{
					
						ouputMoreTodo+="<table id='todo_all_tablerows' class='table table-hover table-striped'>";
						ouputMoreTodo+="<tbody>";
						 $(data).find("todoitem").each(function(index){
							 ouputMoreTodo+="<tr id='todorow"+$(this).find('id').text()+"'><td style='width:50px'><input type='checkbox' id='c"+index +"' onchange='handleChange(this,"+$(this).find('id').text()+");' /> <label for='c"+index +"'><span></span></label></td><td style='width:175px'>"+$(this).find("categoryName").text()+"</td>";
							 ouputMoreTodo+="<td class='todoinfo-decription'><div class='todotip_container' >"+short_string($(this).find("subject").text())+"<div class='categortip' style='color:white;'>"+$(this).find("subject").text()+" </div></div></td></tr>";
						 });
						
						 ouputMoreTodo+="</tbody></table>";
						 if(noOfPages > 1){
						 ouputMoreTodo+="<div id='pagingControls' style='float:right;margin-right:50px;'>"+paginationString+"</div>";
						 }
						$('#todos_placeholder').html(ouputMoreTodo);
						if(val == 0){		
							$('#pag_active0').addClass('pactive');
						}else if(val == 5){
							$('#pag_active1').addClass('pactive');	
						}else if(val == 10){
							$('#pag_active2').addClass('pactive');
						}else if(val == 15){
							$('#pag_active3').addClass('pactive');
						}else if(val == 20){
							$('#pag_active4').addClass('pactive');
						}else if(val == 25){
							$('#pag_active5').addClass('pactive');
						}
						
					}
					
				});
		}	
	});
	
						  
} 
function calculateTodoPage(val){
	if(val == 0){		
		return 0;
	}else if(val == 1){
		
		return 5;	
	}else if(val == 2){
	
		return 10;
	}else if(val == 3){
	
		return 15;
	}else if(val == 4){
	
		return 20;
	}else if(val == 5){
	
		return 25;
	}
}


function get_and_populate_selecttag(){
	$.ajax({
	  	type: 'GET',
		url: '/ziksana-web/ztodo/showalltodo',
		dataType: 'xml',
		success: function( data ) {
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
			option_string ='<option selected="selected" value="add_new_category">Select a Category</option>';
			function construct_options(element, index, array){
				option_string+= '<option value="'+capitalize(element)+'">'+capitalize(element)+'</option>';
			}
			
			//console.log(unique_select_option_array);
			
			unique_select_option_array.forEach(construct_options);

			select = '<option value="">&nbsp;</option>'+option_string + '<optgroup><option style="color: white; font-weight: bold; padding: 0px; margin-top: 0.5em; cursor: pointer; background: seagreen !important;" onclick="show_category_form();" value="add_new_category">Add New Category</option></optgroup>';
			
			updateselect = '<option value="">&nbsp;</option>'+option_string + '';
			
			$('select#todo_categories').html(select);
			$(data).find("todoitem").each(function(index){
				$('select#update_todo_categories'+$(this).find('id').text()+'').html(updateselect);
			});
		}
	});
}
function get_and_populate_todo_value(val){
	
	$.ajax({
	  	type: 'GET',
		url: '/ziksana-web/ztodo/showtodobypagination/'+val,
		dataType: 'xml',
		success: function( data ) {
				
				var output_todo="";
				
				var indexValue = 0;
			
				$.get('/ziksana-web/ztodo/gettodosize', {}, function(size){ 
					no_of_available_todo = size;
					noOfPages = size/5;
					paginationMoreString ="";
					for(var i=0;i<noOfPages;i++){
						
						paginationMoreString+= "<span onclick='get_and_populate_todo_value(calculateTodoPage("+i+"))' id='pag_active_more"+i+"' class='pagination_bar'/>";
						
					}
					
					
					var ouputEmptyTodo="";
					var updateEditValue="";
					var ouputEmpty = "<span style='margin-left:250px;color:white;'>No To-Dos to display</span>";
					if(no_of_available_todo == 0){$('#todos_placeholder_more').html(ouputEmpty);} else{
					
						ouputEmptyTodo+="<table id='todo_all_tablerows' class='table table-hover table-striped' >";
						ouputEmptyTodo+="<tbody>";
						 $(data).find("todoitem").each(function(index){
							
							 ouputEmptyTodo+="<tr id='moretodorow"+$(this).find('id').text()+"' style='height:40px;'>";
							 ouputEmptyTodo+="<td width='50px'><div ><input type='checkbox' id='c"+index+2 +"' onchange='handle(this,"+$(this).find('id').text()+");' /> <label for='c"+index+2 +"'><span></span></label></td><td width='175px'><div id='category_value"+$(this).find("id").text()+"'>"+$(this).find("categoryName").text()+"</div></td>";
							//" <td class='todoinfo-decription'><div class='todotip_container' >"+short_string($(this).find("subject").text())+"<div class='categortip' style='color:white;'>"+$(this).find("subject").text()+" </div></div></td></tr>"
							 ouputEmptyTodo+="<td class='todoinfo-decription' width='225px'><div class='todotip_container' ><div class='categortip' style='color:white;'>"+$(this).find("subject").text()+" </div><span id='categoryDescription"+$(this).find("id").text()+"' id='demo-basic' style='cursor: pointer; margin-bottom: 6px;background-color:transparent!important;'>"+short_managestring($(this).find("subject").text())+"</span></td></div><td width='75px'><a id='todoEdithyperlink"+index+"' onclick='edit_todorow_and_update("+$(this).find("id").text()+")' style='cursor:pointer;margin-left:30px;color:white;'>Edit</a></td><td width='75px'></td></div>";
							 
							 ouputEmptyTodo+="</tr>";
							 ouputEmptyTodo+="<tr style='display:none;'><td></td></tr>";
							 
							 ouputEmptyTodo+="<tr id = 'update_todo_form_container"+$(this).find('id').text()+"' style='height:40px;display:none;'>";
							 ouputEmptyTodo+="<div class='updatetodo'>";
							 
							 ouputEmptyTodo+="<td width='50px'></td><td width='200px'><select onblur='updateSelectChange("+$(this).find('id').text()+")' id='update_todo_categories"+$(this).find('id').text()+"'' style='margin-left:10px;width:190px;'><optgroup><option style='color: white; font-weight: bold; padding: 0px; margin-top: 0.5em; cursor: pointer; background: seagreen !important;' onclick='show_add_category_form("+$(this).find('id').text()+");' value='add_new_category'>Add New Category</option></optgroup>'</select><span id='add_new_edit_category_form"+$(this).find('id').text()+"' style='display:none;'><input onblur='updateTextBoxChange("+$(this).find('id').text()+");' id='update_todo_category_name"+$(this).find('id').text()+"'/></span></td>";
							
							 ouputEmptyTodo+="<td width='200px'><input onclick='clearManageTodoBox()' id='todo_edit_description"+$(this).find('id').text()+"' style='width:200px;height:28px;'/><span onclick='clearManageTodoBox()' style='color:red;left:290px;position:absolute;' id='manageTodoErrorMsg"+index+"'></span></td><td width='75px'><a onclick='saveRow_hideEdit("+$(this).find('id').text()+")' style='cursor:pointer;margin-left:30px;color:white;'>Update</a></td><td width='75px'><a id='hideEditOption"+index+"' onclick='showRow_hideEdit("+$(this).find('id').text()+")' style='cursor:pointer;margin-left:30px;color:white;'>Cancel</a></td></div>";
							 ouputEmptyTodo+="</tr></div>";
							
						 });
						 ouputEmptyTodo+="</tbody></table>";
						 if(noOfPages > 1){
						 ouputEmptyTodo+="<div id='pagingControlsMore' style='float:right;margin-right:50px;'>"+paginationMoreString+"</div>";
						 }
						$('#todos_placeholder_more').html(ouputEmptyTodo);
						
						if(val == 0){		
							$('#pag_active_more0').addClass('pactive');}else if(val == 5){$('#pag_active_more1').addClass('pactive');	
						}else if(val == 10){
							$('#pag_active_more2').addClass('pactive');
						}else if(val == 15){
							$('#pag_active_more3').addClass('pactive');
						}else if(val == 20){
							$('#pag_active_more4').addClass('pactive');
						}else if(val == 25){
							$('#pag_active_more5').addClass('pactive');
						}
						
						get_and_populate_selecttag();
						
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
function short_managestring(string){
	
	if(string.length > 40){
		return string.substring(0,40)+'...';
	} else {
		return string;
	}	
} 
function short_announcement(string){
	
	if(string.length > 140){
		return string.substring(0,140)+'...';
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
	
	
	 
	 if(todo_category.toLowerCase() == 'add_new_category'){todo_category = '';}
	
	
	 if(todo_description ==''){
		
		 $('#descriptionErrorMsg').html("Enter Description");
		
		 return false;
		 }else{
		$.post( '/ziksana-web/ztodo/createtodo'
       , {'category':todo_category,'notificationContent':todo_description}
       , function( data )
       {
       	
          if(data == 'TODO INSERTED SUCCESSFULLY'){
        	  
        	  $(".managetodo").click();
        	 $('input:text').val('');
          }
          if(data == 'Insert query problem'){
        	  console.log(data);
          }

       });           
	
	 }
}

function saveRow_hideEdit(v)
{
	 editupdate_todo_category = $('#update_todo_categories'+v+'').val();
	 editupdate_todo_description = $('#todo_edit_description'+v+'').val() ;
	 selectedRowId = v;
	 console.log(editupdate_todo_category);
	 console.log( editupdate_todo_description );
	 console.log(selectedRowId);
	// if(editupdate_todo_description ==''){return false;}
	 
	 if(editupdate_todo_category.toLowerCase() == 'add_new_category'){editupdate_todo_category = '';}
	 if(editupdate_todo_description ==''){
		 for(var i=0;i<4;i++){
		 $('#manageTodoErrorMsg'+i+'').html("Enter Description");
		 }
		 return false;
		 }else{
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

	$('#add_new_category_form').hide();
	$('#todo_categories').show();
	$('#add_todo_fields_container').hide();
	$('input:text').val('');
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
	$('#add_todo_fields_container').hide();
	for(var i=0;i<5;i++){
		   
		   $('#todoEdithyperlink'+i+'').removeAttr('onclick');
		   $('#todoEdithyperlink'+i+'').css('color','#000');
		  
		 }
	selectedRowId = rowId;
	
	$('#moretodorow'+rowId+'').hide();
	$('#update_todo_form_container'+rowId+'').show();
	var categorySelectedValue = $('#category_value'+rowId+'').text();
	console.log('Category value: '+categorySelectedValue); 


		
	$('select#update_todo_categories'+rowId).val(categorySelectedValue);
	
	var cateDescriptionSelectedValue = $('#categoryDescription'+rowId+'').text();
	console.log(cateDescriptionSelectedValue);
	$('#todo_edit_description'+rowId+'').val(cateDescriptionSelectedValue);
	
	

}
function showRow_hideEdit(val){
	
	$('#moretodorow'+val+'').show();
	$('#update_todo_form_container'+val+'').hide();
	
	$('#add_new_edit_category_form'+val+'').hide();
	$('select#update_todo_categories'+val+'').show();
	$(".managetodo").click();
	
}


