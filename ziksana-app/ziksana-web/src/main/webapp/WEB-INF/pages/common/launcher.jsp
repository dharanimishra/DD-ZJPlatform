<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="true"%>
<html>
<head>
<meta />
<title>Launcher</title>


<link href="../resources/css/styles.css" rel="stylesheet" type="text/css">
<link href="../resources/css/type-setting.css" rel="stylesheet" type="text/css">
<link href="../resources/css/effects.css" rel="stylesheet" type="text/css">
<link href="../resources/css/nav.css" rel="stylesheet" type="text/css">
<link href="../resources/css/launcher.css" rel="stylesheet" type="text/css">
 <link rel="stylesheet" type="text/css" href="../resources/css/jquery.fancybox.2.1.3.css"/>

<script src="../resources/js/jquery-1.7.2.min.js"></script>
<script src="../resources/js/jquery-ui-1.8.21.custom.min.js"></script>

<script type="text/javascript" src="../resources/js/custom/launcher.js"></script>
<script type="text/javascript"  src="../resources/js/jquery.hovercard.js"></script>
<script type="text/javascript"  src="../resources/js/date.js"></script>


<script src="../resources/js/cufon-yui.js" type="text/javascript"></script>
<script src="../resources/js/Bebas_400.font.js" type="text/javascript"></script>

<script src="/ziksana-web/resources/js/ui/jquery.mousewheel-3.0.4.pack.js"></script>
<script type="text/javascript" src="/ziksana-web/resources/fancybox/jquery.fancybox.js"></script>
<link rel="stylesheet" type="text/css" href="/ziksana-web/resources/fancybox/jquery.fancybox.css" media="screen" />

<!--<script type="text/javascript" src="../resources/js/custom.js"></script>-->
 <!--fancybox
 <link rel="stylesheet" type="text/css" href="../resources/css/custom-theme/jquery-ui-1.8.21.custom.css">
	<script type="text/javascript" src="../resources/js/ui/jquery.mousewheel-3.0.4.pack.js"></script>
	<script src="../resources/js/jquery.fancybox.pack.2.1.3.js"></script>
	
	
	-->
	<script type="text/javascript" src="../resources/js/jquery.tipsy.js"></script>
	<link href="../resources/css/news/newsticker.css" rel="stylesheet" type="text/css" />
	<link href="../resources/css/calender-launch.css" rel="stylesheet" type="text/css" />
   
     <script type="text/javascript">
	 $( document).ready(function(e) {
    
		$("a.lbx-calendar").fancybox({
				'width'				: 800,
				'height'			: 800,
				'autoScale'			: true,
				'transitionIn'		: 'elastic',
				'transitionOut'		: 'elastic',
				'type'				: 'iframe'
			});		
		
		$("a.lbx-70-50").fancybox({
				'width'				: 700,
				'height'			: 500,
				'autoScale'			: false,
				'transitionIn'		: 'elastic',
				'transitionOut'		: 'elastic',
				'type'				: 'iframe'
			});	

	
    });
	function quitsection()
	{
	var answer = confirm("Do you want to log off?");
	if (answer){
		
		parent.window.location.href = "login.jsp";
	}
	}
	function calleducator()
	{
	parent.window.location.href = "Reports/Educator_performance.html";
	}
	
	</script>
    
 <script src="../resources/js/custom.js" type="text/javascript"></script> 



<script type="text/javascript">
            $(function() {
            	
            	
                //caching
				//next and prev buttons
				var $cn_next	= $('#cn_next');
				var $cn_prev	= $('#cn_prev');
				//wrapper of the left items
				var $cn_list 	= $('#cn_list');
				var $pages		= $cn_list.find('.cn_page');
				//how many pages
				var cnt_pages	= $pages.length;
				//the default page is the first one
				var page		= 1;
				//list of news (left items)
				var $items 		= $cn_list.find('.cn_item');
				//the current item being viewed (right side)
				var $cn_preview = $('#cn_preview');
				//index of the item being viewed. 
				//the default is the first one
				var current		= 1;
				
				/*
				for each item we store its index relative to all the document.
				we bind a click event that slides up or down the current item
				and slides up or down the clicked one. 
				Moving up or down will depend if the clicked item is after or
				before the current one
				*/
				$items.each(function(i){
					var $item = $(this);
					$item.data('idx',i+1);
					
					$item.bind('click',function(){
						var $this 		= $(this);
						$cn_list.find('.selected').removeClass('selected');
						$this.addClass('selected');
						var idx			= $(this).data('idx');
						var $current 	= $cn_preview.find('.cn_content:nth-child('+current+')');
						var $next		= $cn_preview.find('.cn_content:nth-child('+idx+')');
						
						if(idx > current){
							$current.stop().animate({'top':'-300px'},900,'',function(){
								$(this).css({'top':'310px'});
							});
							$next.css({'top':'310px'}).stop().animate({'top':'5px'},900,'');
						}
						else if(idx < current){
							$current.stop().animate({'top':'310px'},900,'',function(){
								$(this).css({'top':'310px'});
							});
							$next.css({'top':'-300px'}).stop().animate({'top':'5px'},900,'');
						}
						current = idx;
					});
				});
				
				/*
				shows next page if exists:
				the next page fades in
				also checks if the button should get disabled
				*/
				$cn_next.bind('click',function(e){
					var $this = $(this);
					$cn_prev.removeClass('disabled');
					++page;
					if(page == cnt_pages)
						$this.addClass('disabled');
					if(page > cnt_pages){ 
						page = cnt_pages;
						return;
					}	
					$pages.hide();
					$cn_list.find('.cn_page:nth-child('+page+')').fadeIn();
					e.preventDefault();
				});
				/*
				shows previous page if exists:
				the previous page fades in
				also checks if the button should get disabled
				*/
				$cn_prev.bind('click',function(e){
					var $this = $(this);
					$cn_next.removeClass('disabled');
					--page;
					if(page == 1)
						$this.addClass('disabled');
					if(page < 1){ 
						page = 1;
						return;
					}
					$pages.hide();
					$cn_list.find('.cn_page:nth-child('+page+')').fadeIn();
					e.preventDefault();
				});
				
            });
        </script>
</head>
<c:url var="closeicon" value="/resources/images/icons/close-icon.png" />
<c:url var="deleteAlertUrl" value="/zalert/deletealert/" />
 
 <c:url var="htmlUrl_alert" value="/zalert/alertpopuppage" />
 <c:url var="deleteTodoUrl" value="/ztodo/deletetodo/" />                          
  <c:url var="urgent" value='resources/images/icons/urgent.png' />                        
<c:url var="todoImageUrl" value="/resources/images/background-pattern.jpg" />
<c:url var="showAlertUrl" value="/zalert/getthreealerts" />
<c:url var="info"  value='/resources/images/icons/info.png' />
 <c:url var="htmlUrl_todo" value="/ztodo/gettodopopuppage" />
 <c:url var="todo" value="/resources/images/icons/todo.png" />
<c:url var="showTodoUrl" value="/ztodo/getthreetodo" />
<script type="text/javascript">
function deleteFunction(val){
	
	confirm_delete_alert = confirm('Are you sure you want to delete this item?');
	if(confirm_delete_alert == true){
		
		
	
	$.ajax({
	  	type: 'DELETE',
		url: '${deleteAlertUrl}'+val,
		
		success: function( data ) {
			
			$('#alert_'+val).remove();
			get_and_populate_alerts();
			
			
		}
	});
	
	
	}
}
$(document).ready(function() {
	setInterval(function() {
		get_and_populate_todo();
 
	}, 1*30*1000);	
	
	get_and_populate_todo();
	get_and_populate_alerts();
});


$(document).ready(function() {

var m_names = new Array("JAN", "FEB", "MAR", 
"APR", "MAY", "JUNE", "JUL", "AUG", "SEP", 
"OCT", "NOV", "DEC");

var d = new Date();
var curr_date = d.getDate();
var curr_month = d.getMonth();
var curr_year = d.getFullYear();
var mondate= m_names[curr_month] + "<br> " +curr_date + "";
$('.dmonth').html(mondate);

});
function fancyBoxCloseLogout(){
	
	
			$.fancybox.close();
			parent.window.location.href = "/ziksana-web/secure/logout";

		 
		//below code will be enabled once the conflict issues between pages/plugins are resolved.
		
		
	}

function get_and_populate_alerts(){
	var images = new Array();
	images[0] = "<c:url  value='../resources/images/icons/urgent.png' />";
	images[1] = "<c:url  value='../resources/images/icons/warning.png' />";
	images[2] = "<c:url  value='../resources/images/icons/info.png' />";

	$.ajax({
	  	type: 'GET',
		url: '${showAlertUrl}',
		dataType: 'xml',
		success: function( data ) {
			
				var no_of_available_alerts;
				
				$.get('/ziksana-web/zalert/getalertsize', {}, function(size){
				
					no_of_available_alerts = size;
				
				
				
				
				
				var output="";
				var outputAlertEmpty="";
				outputAlertEmpty+="<div  class='alerts'>";
				outputAlertEmpty+="<span class='titles-info font-Signika text-size-px18 light-gray'>Alerts</span>";
				outputAlertEmpty+="<b>No Alerts Found</b></div>";
				
				console.log('No of avaliable alerts: '+no_of_available_alerts);
				if(no_of_available_alerts == 0){$('#alerts_placeholder').html(outputAlertEmpty);} else{
					
					
				if(no_of_available_alerts > 3){
					
					//populate the three with more button.
					
					output+="<div  class='alerts'>";
					output+="<span class='titles-info font-Signika text-size-px18 light-gray'>Alerts</span>";
					
					$(data).find("alertitem").each(function(index){
						
					
						
						output+="<div id='alert_"+$(this).find("id").text()+"' class='alertcontainer' style='border:1px solid #F5F5F5;' id='conalert3'>";
						output+="<div class='alertinfo' style='height:28px;padding:5px;'>";
						output+="<div class='alertinfo-icon' style='float:left;display:inline; margin-right:10px;'>";
						 
						output+="<a href='#linkurl' rel='tipsy'  style='cursor:default;' > <img id='exp' src='"+images[index]+"' alt='INFO' /> </a></div>";
						output+="<div class='alertinfo-category todotip_container' style='display:inline;' >"+short_string_category($(this).find("category").text())+"<div class='categorytip'>"+$(this).find("category").text()+" </div></div>";
						
						output+="<div class='todotip_container' id='demo-basic"+$(this).find("id").text()+"' style='font-weight:lighter;clear:both;display:inline; margin-left:10px; cursor:pointer;'>"+short_string($(this).find('description').text())+"</a><div class='todotip'>"+$(this).find("description").text()+" </div></div><a href='#' onclick='deleteFunction("+$(this).find('id').text()+")'  title='Delete' style='float:right; id='btalert3' rel='tipsy' title='Close'> <img src='${closeicon}' height='15' width='15'/> </a></div>";
						
						output+="</div>";						
									
					});
					output+="</div>";
					output+="<div  style='height:30px; float:right;'> <a class='text-size-px11  alert_fancybox' href='${htmlUrl_alert}' >More</a></div>";
					$('#alerts_placeholder').html( output);
				} else {
					//populate the three without more button
					output+="<div  class='alerts'>";
					output+="<span class='titles-info font-Signika text-size-px18 light-gray'>Alerts</span>";
	
					$(data).find("alertitem").each(function(index){
					output+="<div id='alert_"+$(this).find("id").text()+"' class='alertcontainer' style='border:1px solid #F5F5F5;' id='conalert3'>";
					output+="<div class='alertinfo' style='height:28px;padding:5px;'>";
					output+="<div class='alertinfo-icon' style='float:left;display:inline; margin-right:10px;'>";
					 
					output+="<a href='#linkurl' rel='tipsy'  style='cursor:default;' > <img id='exp' src='"+images[index]+"' alt='INFO' /> </a></div>";
					output+="<div class='alertinfo-category todotip_container' style='display:inline;' >"+short_string_category($(this).find("category").text())+"<div class='categorytip'>"+$(this).find("category").text()+" </div></div>";
					
					output+="<div class='todotip_container' id='demo-basic"+$(this).find("id").text()+"' style='font-weight:lighter;clear:both;display:inline; margin-left:10px; cursor:pointer;'>"+short_string($(this).find('description').text())+"</a><div class='todotip'>"+$(this).find("description").text()+" </div></div><a href='#' onclick='deleteFunction("+$(this).find('id').text()+")'  title='Delete' style='float:right; id='btalert3' rel='tipsy' title='Close'> <img src='${closeicon}' height='15' width='15'/> </a></div>";
					
					output+="</div>";
					
						});
					output+="</div>";
					$('#alerts_placeholder').html( output);
				}
							

				
				}//end if not zero.
			

				
				}

/////////////
				);
				

		}
});
	
}

function get_and_populate_todo(){
/* Todo	 */
$.ajax({
  	type: 'GET',
	url: '${showTodoUrl}',
	dataType: 'xml',
	success: function( data ) {
			
			var output_todo="";
			
			var indexValue = 0;
			
			//get All Todo size
			var no_of_available_todo;
			
			$.get('/ziksana-web/ztodo/gettodosize', {}, function(size){ 
				no_of_available_todo = size;
			
				var ouputEmptyTodo="";
				ouputEmptyTodo+="<div  class='Todo's'>";
				ouputEmptyTodo+="<span class='titles-info font-Signika text-size-px18 light-gray'>To-Dos</span>";
				ouputEmptyTodo+="<strong>No Todos Found</strong>";
				ouputEmptyTodo+="<div style='height:30px;margin-right:50px; float: right;'><a class='todo_fancybox text-size-px11 text-size-px11' href='${htmlUrl_todo}' >More</a><div>";
				ouputEmptyTodo+='</div>';
				
				if(no_of_available_todo == 0){$('#todos_placeholder').html(ouputEmptyTodo);} else{
					
					  
				  
							output_todo+="<div  class='Todo's'>";
						output_todo+="<span class='titles-info font-Signika text-size-px18 light-gray'>To-Dos</span>";
						
						
					  $(data).find("todoitem").each(function(index){
							output_todo+="<div id='todoid"+$(this).find("id").text()+"' class='todocontainer' style='border:1px solid #F5F5F5;' id='contodo1'>";
							output_todo+="<div class='todoinfo' style='height:28px;padding:5px;'>";
							output_todo+="<div id='todo-row' class='todoinfo-icon' style='float:left;display:inline; margin-right:10px;'>";
							 
							output_todo+="<img src='${todo}' alt='Info' /></div>";
							output_todo+="<div class='todoinfo-category todotip_container'style='display:inline;' >"+short_string_category($(this).find("categoryName").text())+"<div class='categorytip'>"+$(this).find("categoryName").text()+" </div></div>";
							
							output_todo+="<div class='todotip_container' id='demo-basic"+$(this).find("id").text()+"' style='font-weight:lighter; clear:both;display:inline; text-decoration:none; margin-left:10px; cursor:pointer;'>"+short_string($(this).find('subject').text())+"</a><div class='todotip'>"+$(this).find("subject").text()+"</div></div><input type='checkbox' onChange='checkonTodoItem("+$(this).find("id").text()+")' id='cktodo1' style='float:right;'></div>";
							
							output_todo+="</div>";						
											
						});
												
							
							output_todo+="<div  style='height:30px;margin-right:0px; float:right;'><a class='todo_fancybox text-size-px11' href='${htmlUrl_todo}' >More</a><div>";
							$('#todos_placeholder').html(output_todo);
						output_todo+="</div>";	
				}
			
			
			
			
		});
			
			
	}
});
	
}



function checkonTodoItem(val){
	$.ajax({
	  	type: 'DELETE',
		url: '${deleteTodoUrl}'+val,
		dataType: 'json',
		success: function( data ) {
			console.log('delete alert fired');
			$('#todoid'+val).remove();
			get_and_populate_todo();
			
		}
	});
	
	$('#todoid'+val).hide();
	get_and_populate_todo();
	
}

/// TODO: move this function to a common js file later
function short_string(string){
	
	if(string.length > 50){
		return string.substring(0,50)+'...';
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



function hidecalender1()
{
$("#calenderdiv").hide();
$("#datepara").hide();
$("#alerts_placeholder").hide();
$("#todosdiv").show();
}
function hidecalender()
{
$("#calenderdiv").hide();
$("#datepara").hide();
$("#todosdiv").hide();
$("#alerts_placeholder").show();
}
function showcalender()
{
$("#calenderdiv").show();
$("#alerts_placeholder").hide();
$("#todosdiv").hide();
$("#datepara").show();
}

</script>
<body  style="background-image:none;" >


		<div class="lnchwrapper">

   
 		<div class="maincontainer">  
   
     				<div class="navcontainer">
     
     
    		 <div class="navlinks">
    			 
     
                    <div class="lnchaccount">
                    
                    
        			
               <div class="lnchaccountleft">
               
              
   			<c:url var="imageUrl_profile1" value="${member.picturePath}" />   
   			                    
                  
                <!--  <div class="lnchimage">-->
                   <a href="#linkurl"> <img src="${imageUrl_profile1}" width=40px height=40px alt="" align="left"/> 
                  <!--  </div> end of -->
                    
                   <span style="line-height:35px; padding-left:10px; color:#fff; font-weight:bold;"> <c:out value="${member.firstName}"/> <c:out value="${member.lastName}"/> </span> </a>    
                     
          
          </div><!-- end of lnchaccountleft-->  
          
          
          <div class="lnchaccountright">
          
        
               
                <div class="account-container two-bottom-rounded-box" style="border:none;">
              <div class="container">
                <div class="topnav" style="width:145px;" ><a href="#" class="signin wite bold" style="line-height:35px;"><span class="text-size-px12 wite bold">Account</span></a> </div>
                <fieldset id="signin_menu">
                 <ul>
                   <li><a href="#">Preferences</a></li>
                   <li><a href="#">Privacy</a></li>
                   <li><a onclick="fancyBoxCloseLogout()" >Sign Out</a></li>
                   </ul>
                </fieldset>
              </div>
            </div>  
          
          
              </div> 
          
          <div class="clearfix"> </div>
          
                  
               </div> <!--end of lncaccount-->
     
    	<div class="clearfix"> </div>


	   </div> <!-- end of  navlinks-->
     <c:url var="educatorPage" value="/secure/homepage"></c:url>
      <c:if test="${member.roleType eq 'EDUCATOR'}">
       <div class="navsublinks" style="margin-right:23px;padding-top:35px;">

 						<ul>
                        <li><a href="${educatorPage}" target="_parent">Home</a></li>
                        <li><a href="/ziksana-web/resources/analytics/Educator_performance.html" target="_parent">Analytics</a></li>
                        <li><a href="#">Locker</a></li>
						</ul>

   				</div> <!--end of navsublinks-->
     </c:if>
      <c:if test="${member.roleType eq 'LEARNER'}">
       <div class="navsublinks" style="margin-right:23px;padding-top:35px;">

 						<ul>
                        <li><a href="${educatorPage}" target="_parent">Home</a></li>
                        <li><a href="/ziksana-web/resources/analytics/students_performance.html" target="_parent">Analytics</a></li>
                        <li><a href="#">Locker</a></li>
						</ul>

   				</div> <!--end of navsublinks-->
     </c:if>
     <div class="clearfix"> </div>
     
     </div> <!--end of navcontainer-->


   <!--  <div class="lnchcontent">-->
   
                           <div class="lnchelement">
                           
      <div id="shadimage">
       <div data-tabpane_contianer>	
        <div class="alert_todo" style="display:none;" data-tabpane="alerts">
                   
                    
                   		<div id ="alerts_placeholder" class="alerts" >
         
                        
                        </div> <!--end of alert-->
                        
                        </div>
                         <div class="todos" id="todosdiv" style="display:none; margin-top: 22px;" data-tabpane="todos">
                        	 <div id="todos_placeholder"></div>
                            
                        </div>
     
    <div class="  demo_message_container"  id= "calenderdiv" style=""> 				
	<div class="cn_wrapper calendar"   style="">
			<!--  <div class="demo_message" style="font-size:18px;">
					   For Demonstration Only. Functionality to be available in subsequent Playpens
			</div>-->
            
                  <div id="binder">
           
           </div>
            
            <div id="cn_preview" class="cn_preview">
				<div class="cn_content" style="top: 5px;">
					
					<span class="eventhead">Lecture - Critical Thinking</span>
					<br>	
                    <br>				
				  <p style="font-size:12px; font-weight:bold; font-family:Verdana, Geneva, sans-serif; margin-top:5px; line-height:18px; color:#993300;"></p>
                     <br>	
                    <br>
                  <p style="margin-bottom:7px; color:#993300; font-weight:bold; "><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;">Place: </span>  Building A, Room 1A  </p>  
                  <p style="margin-bottom:7px; color:#993300; font-weight:bold; "><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;">Time: </span>  9:00 am - 10:30 am</p>
                  <p style="margin-bottom:7px; color:#993300; font-weight:bold; "><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;">Contact: </span>(680) 231 6899  </p>   
					
				</div>
				<div class="cn_content" style="top: 310px;">
						
					<span class="eventhead">Students Meet</span>
					<br>	
                    <br>				
					<p style="font-size:12px; font-weight:bold; font-family:Verdana, Geneva, sans-serif; margin-top:5px; line-height:18px; color:#993300;"></p>
                     <br>	
                    <br>
                  <p style="margin-bottom:7px; color:#993300; font-weight:bold; "><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;">Place: </span> Cafeteria  </p>  
                  <p style="margin-bottom:7px; color:#993300; font-weight:bold; "><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;">Time: </span>  12:00 pm - 1:30 pm </p>
                  <p style="margin-bottom:7px; color:#993300; font-weight:bold; "><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;">Contact: </span>(680) 231 2413  </p>   
					
				</div>
				<div class="cn_content" style="top: 310px;">
						
					<span class="eventhead">Lecture - Model Thinking</span>
					<br>	
                    <br>				
					<p style="font-size:12px; font-weight:bold; font-family:Verdana, Geneva, sans-serif; margin-top:5px; line-height:18px; color:#993300;"></p>
                     <br>	
                    <br>
                  <p style="margin-bottom:7px; color:#993300; font-weight:bold;"><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;">Place: </span>  Building C, Room 3C </p>  
                  <p style="margin-bottom:7px; color:#993300; font-weight:bold; "><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;">Time: </span>  9:00 am - 10:30 am </p>
                  <p style="margin-bottom:7px; color:#993300; font-weight:bold;"><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;"> </span> </p>   
					
				</div>
				<div class="cn_content" style="top: 310px;">
					
					<span class="eventhead">Lecture - Think Mental Models</span>
					<br>	
                    <br>				
					<p style="font-size:12px; font-weight:bold; font-family:Verdana, Geneva, sans-serif; margin-top:5px; line-height:18px; color:#993300;"></p>
                     <br>	
                    <br>
                  <p style="margin-bottom:7px; color:#993300; font-weight:bold; "><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;">Place: </span>  Building C, Room 3C  </p>  
                  <p style="margin-bottom:7px; color:#993300; font-weight:bold; "><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;">Time: </span> 2:00 pm - 3:30 pm</p>
                  <p style="margin-bottom:7px; color:#993300; font-weight:bold; "><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;"> </span> </p>   
					
				</div>
			 
				<div class="cn_content">
						
					<span class="eventhead">Seminar on Artificial Intelligence</span>
					<br>	
                    <br>				
					<p style="font-size:12px; font-weight:bold; font-family:Verdana, Geneva, sans-serif; margin-top:5px; line-height:18px; color:#993300;">Preview and discuss current Ziksana Course Creation Model and related functionality</p>
                     <br>	
                    <br>
                     <p style="margin-bottom:7px; color:#993300; font-weight:bold; letter-spacing:1px;"><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;">Place: </span>  UTD Building  </p>  
                     <p style="margin-bottom:7px; color:#993300; font-weight:bold; letter-spacing:1px;"><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;">Time: </span>  1:00 pm - 4:00 pm </p>
                    <p style="margin-bottom:7px; color:#993300; font-weight:bold; letter-spacing:1px;"><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;">Contact: </span>(690) 231-9666  </p>   
					
				</div>
					<!-- 
				<div class="cn_content">
					
					<span class="eventhead">Seminar on Artificial Intelligence</span>
					<br>	
                    <br>				
					<p style="font-size:12px; font-weight:bold; font-family:Verdana, Geneva, sans-serif; margin-top:5px; line-height:18px; color:#993300;">Preview and discuss current Ziksana Course Creation Model and related functionality</p>
                     <br>	
                    <br>
                     <p style="margin-bottom:7px; color:#993300; font-weight:bold; letter-spacing:1px;"><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;">Place: </span>  UTD Building  </p>  
                     <p style="margin-bottom:7px; color:#993300; font-weight:bold; letter-spacing:1px;"><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;">Time: </span>  1:00 pm - 4:00 pm </p>
                    <p style="margin-bottom:7px; color:#993300; font-weight:bold; letter-spacing:1px;"><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;">Contact: </span>(690) 231-9666  </p>   
					
				</div>
				<div class="cn_content">
						
					<span class="eventhead">Seminar on Artificial Intelligence</span>
					<br>	
                    <br>				
					<p style="font-size:12px; font-weight:bold; font-family:Verdana, Geneva, sans-serif; margin-top:5px; line-height:18px; color:#993300;">Preview and discuss current Ziksana Course Creation Model and related functionality</p>
                     <br>	
                    <br>
                     <p style="margin-bottom:7px; color:#993300; font-weight:bold; letter-spacing:1px;"><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;">Place: </span>  UTD administrative Building  </p>  
                     <p style="margin-bottom:7px; color:#993300; font-weight:bold; letter-spacing:1px;"><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;">Time: </span>  9:00 am - 12:00 pm </p>
                    <p style="margin-bottom:7px; color:#993300; font-weight:bold; letter-spacing:1px;"><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;">Contact: </span>(690) 231-9666  </p>   
					
				</div>
				<div class="cn_content">
						
					<span class="eventhead">Seminar on Artificial Intelligence</span>
					<br>	
                    <br>				
					<p style="font-size:12px; font-weight:bold; font-family:Verdana, Geneva, sans-serif; margin-top:5px; line-height:18px; color:#993300;">Preview and discuss current Ziksana Course Creation Model and related functionality</p>
                     <br>	
                    <br>
                     <p style="margin-bottom:7px; color:#993300; font-weight:bold; letter-spacing:1px;"><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;">Place: </span>  UTD Building  </p>  
                     <p style="margin-bottom:7px; color:#993300; font-weight:bold; letter-spacing:1px;"><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;">Time: </span>  1:00 pm - 4:00 pm </p>
                    <p style="margin-bottom:7px; color:#993300; font-weight:bold; letter-spacing:1px;"><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;">Contact: </span>(690) 231-9666  </p>   
					
				</div>
				<div class="cn_content">
					
					<span class="eventhead">Seminar on Artificial Intelligence</span>
					<br>	
                    <br>				
					<p style="font-size:12px; font-weight:bold; font-family:Verdana, Geneva, sans-serif; margin-top:5px; line-height:18px; color:#993300;">Preview and discuss current Ziksana Course Creation Model and related functionality</p>
                     <br>	
                    <br>
                     <p style="margin-bottom:7px; color:#993300; font-weight:bold; letter-spacing:1px;"><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;">Place: </span>  UTD Building  </p>  
                     <p style="margin-bottom:7px; color:#993300; font-weight:bold; letter-spacing:1px;"><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;">Time: </span>  1:00 pm - 4:00 pm </p>
                    <p style="margin-bottom:7px; color:#993300; font-weight:bold; letter-spacing:1px;"><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;">Contact: </span>(690) 231-9666  </p>   
					
				</div>
				<div class="cn_content">
					
					<span class="eventhead">Seminar on Artificial Intelligence</span>
					<br>	
                    <br>				
					<p style="font-size:12px; font-weight:bold; font-family:Verdana, Geneva, sans-serif; margin-top:5px; line-height:18px; color:#993300;">Preview and discuss current Ziksana Course Creation Model and related functionality</p>
                     <br>	
                    <br>
                     <p style="margin-bottom:7px; color:#993300; font-weight:bold; letter-spacing:1px;"><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;">Place: </span>  UTD Building  </p>  
                     <p style="margin-bottom:7px; color:#993300; font-weight:bold; letter-spacing:1px;"><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;">Time: </span>  1:00 pm - 4:00 pm </p>
                    <p style="margin-bottom:7px; color:#993300; font-weight:bold; letter-spacing:1px;"><span style="font-weight:bold; font-family:Verdana, Geneva, sans-serif; color:#000;">Contact: </span>(690) 231-9666  </p>   
					
				</div>
				-->
			</div>
           
           
     
           
           
            <div id="cnlistimage" style="background-image:url(../resources/images/calender/cal-left1.png); background-repeat:no-repeat; height:258px; margin-left:-5px; background-color:#fff; 
border-radius: 5px;
background-origin: content-box;
padding: 5px;">
            
            
			<div id="cn_list" class="cn_list">
				<div class="cn_page" style="display:block;">
					<div class="cn_item">
						<span class=" selected cal dmonth ">  </span><span class="eventtext">Lecture - Critical Thinking</span>
						
					</div>
					<div class="cn_item">
						<span class="cal"> FEB <br>15 </span><span class="eventtext">Students Meet</span>
					</div>
					<div class="cn_item">
						<span class="cal"> FEB <br>16 </span><span class="eventtext">Lecture - Model Thinking </span>
					</div>
					<div class="cn_item ">
						<span class="cal"> FEB <br>17 </span><span class="eventtext">Lecture - Think Mental Models</span>
					</div>
				</div>
				<div class="cn_page">
					<div class="cn_item">
						<span class="cal"> FEB <br>18 </span><span class="eventtext">Upcoming Event</span>
					</div>
					
				</div>
                
               
				<!--<div class="cn_nav">
					<a id="cn_prev" class="cn_prev disabled"></a>
					<a id="cn_next" class="cn_next"></a>
				</div>-->
			
           </div> 
           
         
           
            </div>
            	
		</div>
	<span style="margin-left:470px;margin-top:5px;"><a href="#">More</a></span> 
       </div> 
        
        
         <!-- Start of Alerts -->
             		          <div class="alert_todo" style="display: none;">
                   
                    
 <!--end of alert-->
                        
                        </div>
                       <!-- end of Alerts -->
      
      
      
     <!-- start of todo  -->
     
     <!-- Start of Alerts -->

                       <!-- end of Alerts -->
        
        
         
           </div> 
<div class="clearfix"> </div>
                         
<br />
                         <!--end of elementlinks-->
                         
                       
                  </div>        
                    <div class="elementlinks" >
 						<ul>
                        <li><a id="alertlink" onclick="hidecalender()" data-tab="alerts">Alerts</a></li>
                        <li><a id="todolink" onclick="hidecalender1()" data-tab="todos">To Dos</a></li>
                        <li><a id="calendarlink"onclick="showcalender()" data-tab="calendar">Calendar</a></li>
                        </ul>
  			       </div>        
                           
                           
                           </div> <!--end of lnchelement-->
   
     
    
     
   <div class="lnchrightnavlinks">
  <!-- <p> Launch </p>-->
 						<!--<ul>
                        <li><a href="#linkurl"><img src="images/icons/course.png" alt="" width="40" height="42" align="left"/>Create Course</a></li>
                        <li><a href="#linkurl"><img src="images/icons/course.png" alt="" width="40" height="42" align="left"/>Publish Course</a></li>
                        <li><a href="#linkurl"><img src="images/icons/course.png" alt="" width="40" height="42" align="left"/>Manage Course</a></li>
                        <li><a href="#linkurl"><img src="images/icons/course.png" alt="" width="40" height="42" align="left"/>Grade Student</a></li>
                       
					</ul>-->
                    
     <section class="slide-up-boxes">
     <script language="javascript">

	 </script>
    <c:if test="${member.roleType eq 'EDUCATOR'}">
			<a class="fancyboxclose" href="/ziksana-web/zcourse/createcourse" target="_parent" >
				
				
				<h5><img src='/ziksana-web/resources/images/icons/course-create.png'><br/>Create</h5>
				<div >Create a course in 7 easy steps </div>				
			</a>
			
			<a class="fancyboxclose" href="/ziksana-web/zcourse/myprogramsdraft" target="_parent">
				<h5><img src='/ziksana-web/resources/images/icons/course-draft.png'><br/>Draft</h5>
				<div >Edit your draft courses</div>					
			</a>
				
			<a class="fancyboxclose" href="#linkurl">
				<h5><img src='/ziksana-web/resources/images/icons/course-manage.png'><br/>Manage</h5>
				<div>To be released in next Playpen.</div>					
			</a>
			
			<a class="fancyboxclose" href="#linkurl">
				
                <h5><img src='/ziksana-web/resources/images/icons/course-publish.png'><br/>Publish</h5>
				<div >To be released in next Playpen.</div>			
			</a>

            <a class="fancyboxclose" href="#linkurl">
				<h5><img src='/ziksana-web/resources/images/icons/course-grade.png'><br/>Grade</h5>
				<div >To be released in next Playpen.</div>				
			</a>
	</c:if>
	 <c:if test="${member.roleType eq 'LEARNER'}">
	 <a class="fancyboxclose" href="/ziksana-web/zcourse/myprograms" target="_parent" >
				<h5><img src='/ziksana-web/resources/images/icons/course-view.png'><br/>Course</h5>
				<div>Study the courses you  subcribed  </div>				
			</a>
				
			<a class="fancyboxclose" href="#linkurl">
				<h5><img src='/ziksana-web/resources/images/icons/tutorial.png'><br/>Tutorial</h5>
				<div style=" background: #000000" >To be released in next Playpen.</div>					
			</a>
			
			<a class="fancyboxclose" href="#linkurl">
				
                <h5><img src='/ziksana-web/resources/images/icons/course-assignment.png'><br/>Assignments</h5>
				<div >To be released in next Playpen.</div>					
			</a>

            <a class="fancyboxclose" href="#linkurl">
				<h5><img src='/ziksana-web/resources/images/icons/performance.png'><br/>Performance</h5>
				<div >To be released in next Playpen.</div>					
			</a>
	 </c:if>
		</section>               
                    

   
    </div><!-- end of lnchrightnavlinks-->
     
     <div class="lnchbottom" style=" float: right; margin-right: 200px; margin-top: -25px;z-index: 1000;position: relative;">

	
   <a id="calendarlink" class="navquit" onclick="window.parent.confirmFancyboxClose()">Quit</a>
   </div>
     
    

	 

     <!--   </div>--> <!--end of lnchcontent-->



<!--end of lnchbottom-->






              </div> <!--end of mainconatiner-->

			       	</div><!-- end of lwrapper-->

<script type="text/javascript">
$(function(){
	// TABS
 $('[data-tab]').on'click',function(){  
  tab_trigger = $(this);
  tab_trigger.addClass('hover_state').siblings('[data-tab]').removeClass('hover_state');
  tab_name = tab_trigger.attr('data-tab');
  tab_pane = $('[data-tabpane="'+tab_name+'"]');
  tab_pane.siblings('[data-tabpane]').hide();
  tab_pane.show();
  
 });
 // END TABS
}); //end of docready
</script>
					
					
</body>
</html>
