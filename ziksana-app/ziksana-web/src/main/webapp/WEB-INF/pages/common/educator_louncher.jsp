<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="true"%>
<html>
<head>
<meta />
<title>EducatorLauncher</title>


<link href="../resources/css/styles.css" rel="stylesheet" type="text/css">
	<link href="../resources/css/type-setting.css" rel="stylesheet" type="text/css">
	<link href="../resources/css/effects.css" rel="stylesheet" type="text/css">
	<link href="../resources/css/nav.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="../resources/css/jquery.fancybox.2.1.3.css"/>

<script src="../resources/js/jquery-1.7.2.min.js"></script>
<script src="../resources/js/jquery-ui-1.8.21.custom.min.js"></script>

<script type="text/javascript" src="../resources/js/custom/launcher.js"></script>
<script type="text/javascript"  src="../resources/js/jquery.hovercard.js"></script>
<script type="text/javascript"  src="../resources/js/date.js"></script>

<!--<script type="text/javascript" src="../resources/js/custom.js"></script>-->
 <!--fancybox-->
 <link rel="stylesheet" type="text/css" href="../resources/css/custom-theme/jquery-ui-1.8.21.custom.css">
	<script type="text/javascript" src="../resources/js/ui/jquery.mousewheel-3.0.4.pack.js"></script>
	<script src="../resources/js/jquery.fancybox.pack.2.1.3.js"></script>
	<script type="text/javascript" src="../resources/js/jquery.tipsy.js"></script>
	<link href="../resources/css/news/newsticker.css" rel="stylesheet" type="text/css" />
	<!--fancybox end-->
   
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


<style>
.lnchwrapper
{
height:490px;	

}

.maincontainer
{
width: 1000px;
margin-right: auto;
margin-left: auto;	


}

.navcontainer
{
width: 1000px;
margin-bottom:20px;	
/*border-bottom:1px solid #ccc;*/
/*moz-box-shadow: 3px 4px 4px -3px #D9D9D9;
-webkit-box-shadow: 3px 4px 4px -3px #D9D9D9;
box-shadow: 3px 4px 4px -3px #D9D9D9;*/
/*border:1px solid #ccc;*/
}

.lnchlogo
{
	float:left;
}

.lnchaccount
{
float:right;
background-color: #6D9EC5;	
margin-right:22px;
}

.lnchaccountleft
{
float:left;	
}

.lnchaccountright
{
float:right;

}



.navlinks
{
		
/*border:1px solid #ccc;*/
}

.navsublinks
{
float:right;	
/*border:1px solid #ccc;*/

font-family: 'Signika', sans-serif;
font-weight: 600;
font-size: 18px;
color: #666;

}
.navquit
{
font-family: 'Signika', sans-serif;
font-weight: 600;
font-size: 20px;
color:grey;

}
.navsublinks a
{
font-family: 'Signika', sans-serif;
font-weight: 600;
font-size: 18px;
color:#5B809E;

}


.navsublinks ul
{
list-style:none;	
}

.navsublinks li
{
	display:inline;
	padding-right:10px;
	/*border-right:2px solid #ccc;*/
	padding-left:10px;
}

.lnchcontent
{
/*border:1px solid #ccc;*/
margin-bottom:20px;
}

.lnchelement
{
	width:530px;
	float:left;
   /* border:1px solid #ccc;*/
	margin-left:20px;	
}



.elementlinks
{
	float:right;
	margin-right:30px;
	
}

.elementlinks ul
{
list-style:none;	
}

.elementlinks li
{
	display:inline;
	padding-left:10px;
	
}


.lnchrightnavlinks
{
	float:right;
	width:380px;
	margin-top:20px;
	margin-right:20px;
	/*border:1px solid #ccc;*/
	
}

.lnchrightnavlinks P
{
	font-size:18px;
	font-weight:bold;
	color:#fff;
	border-bottom:1px dashed #6D9EC5;
	background-color:#5B809E;
	padding:5px;
	border: 1px solid rgba(204, 204, 204, 0.58);
	margin-bottom:10px;
	
	
}

.lnchrightnavlinks ul
{
	padding-top:10px;
}

.lnchrightnavlinks li
{
	padding:10px;
	
	
}

.lnchrightnavlinks li a img
{

  padding-right:15px;
}

.lnchrightnavlinks li a
{
  font-size:15px;
  line-height:35px;
}

.lnchrightnavlinks li a:hover
{

  color:#ec4d23;
  text-decoration:none;
  
}




.clearfix {
	float: none;
	clear: both;
}


	.slide-up-boxes a { 
			display: block; 
			height: 130px; 
			margin: 0 0 10px 0; 
			background: rgba(215, 215, 215, 0.5); 
			border: 1px solid #ccc; 
			height: 45px; 
			overflow: hidden; 
			text-decoration:none;
		}
		
		.slide-up-boxes h5 { 
			color: #2A659B; 
			text-align:center;
			height:65px; 
			font:18px/45px Georgia, Serif;    /* Vertically center text by making line height equal to height */
			 
			 opacity: 1;
			 -webkit-transition: all 0.2s linear; 
			 -moz-transition: all 0.2s linear; 
			 -o-transition: all 0.2s linear;
		}
		
		.slide-up-boxes a:hover h5 { 
			margin-top: -65px; 
			opacity: 0; 
		}
		
		.slide-up-boxes div { 
			position: relative; 
			color: white; 
			font: 12px/14px Georgia, Serif;
			height: 45px; 
			padding: 10px; 
			opacity: 0; 
			/*-webkit-transform: rotate(6deg); 
			-webkit-transition: all 0.4s linear; 
			-moz-transform: rotate(6deg); 
			-moz-transition: all 0.4s linear; 
			-o-transform: rotate(6deg); 
			-o-transition: all 0.4s linear; */
		}
		.slide-up-boxes a:hover div { 
			opacity: 1; 
			-webkit-transform: rotate(0); 
			-moz-transform: rotate(0); 
			-o-transform: rotate(0); 
		}
		.slide-up-boxes a:nth-child(2) div { background: #367db2 url(images/icons/createcourse.png) 5px 5px no-repeat; padding-left: 60px; }
		.slide-up-boxes a:nth-child(3) div { background: #367db2 url(images/icons/manage.png) 5px 5px no-repeat; padding-left: 60px; }
		.slide-up-boxes a:nth-child(4) div { background: #367db2 url(images/icons/publish.png) 5px 5px no-repeat; padding-left: 60px; }
		.slide-up-boxes a:nth-child(5) div { background: #367db2 url(images/icons/grade.png) 5px 5px no-repeat; padding-left: 60px; }

</style>

</head>
<c:url var="deleteAlertUrl" value="/secure/deletealert/111111/" />
 <c:url var="closeicon" value="/resources/images/icons/close-icon.png" />
 <c:url var="htmlUrl_alert" value="/secure/getalertpopupwindow" />
 <c:url var="deleteTodoUrl" value="/secure/deletetodo/" />                          
  <c:url var="urgent" value='resources/images/icons/urgent.png' />                        
<c:url var="todoImageUrl" value="/resources/images/background-pattern.jpg" />
<c:url var="showAlertUrl" value="/secure/showalert/111111" />
<c:url var="info"  value='/resources/images/icons/info.png' />
 <c:url var="htmlUrl_todo" value="/secure/gettodopopupwindow" />
 <c:url var="todo" value="/resources/images/icons/todo.png" />
<c:url var="showTodoUrl" value="/secure/showtodo/111111" />
<script type="text/javascript">
function deleteFunction(val){
	/* alert('${deleteAlertUrl}'+val); */
	
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
var mondate=curr_date + "- " + m_names[curr_month] 
+ "";
$('.dmonth').html(mondate);

});
function fancyBoxCloseLogout(){
	
	
			$.fancybox.close();
			parent.window.location.href = "/ziksana-web/secure/logout";

		 
		//below code will be enabled once the conflict issues between pages/plugins are resolved.
		
		
	}

function get_and_populate_alerts(){


	$.ajax({
	  	type: 'GET',
		url: '${showAlertUrl}',
		dataType: 'xml',
		success: function( data ) {
			
				var no_of_available_alerts;
				
				$.get('/ziksana-web/secure/getalertsize/111111', {}, function(size){
////////////////////////////////////////				
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
						 
						output+="<a href='#linkurl' rel='tipsy'  style='cursor:default;' > <img id='exp' src='${info}' onload='changeImage("+$(this).find("priority").text()+")' alt='INFO' /> </a></div>";
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
					 
					output+="<a href='#linkurl' rel='tipsy'  style='cursor:default;' > <img id='exp' src='${info}' onload='changeImage("+$(this).find("priority").text()+")' alt='INFO' /> </a></div>";
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
			
			$.get('/ziksana-web/secure/getmytodosize/111111', {}, function(size){ 
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

</script>


<script type="text/javascript">

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

</script>
<script type="text/javascript">
function changeImage(a){
	
	var images = new Array();
	images[0] = "<c:url  value='../resources/images/icons/urgent.png' />";
	images[1] = "<c:url  value='../resources/images/icons/warning.png' />";
	images[2] = "<c:url  value='../resources/images/icons/info.png' />";
	
	 var comic = document.getElementById("exp").src;
	 if(a==1000){
		  $("#exp").attr('src', images[0]);
	 }else if(a==1001){
		 $("#exp").attr('src', images[1]);
	 }else if(a==1002){
		 $("#exp").attr('src', images[2]);
	 }
	 
	  
}
function hidecalender()
{
$("#calenderdiv").hide();
$("#datepara").hide();
}
function showcalender()
{
$("#calenderdiv").show();
$("#datepara").show();
}

</script>
<body style="background-image:none;" >

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
                <div class="topnav" style="width:145px;" ><a href="#" class="signin wite bold" style="line-height:35px;"><span class="text-size-px12 wite bold">My Account</span></a> </div>
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
     <c:url var="educatorPage" value="/secure/educatordashboard"></c:url>
       <div class="navsublinks" style="margin-right:23px;padding-top:35px;">

 						<ul>
                        <li><a href="${educatorPage}" target="_parent">My Home</a></li>
                        <li><a href="#">Analytics</a></li>
                        <li><a href="#">Locker</a></li>
						</ul>

   				</div> <!--end of navsublinks-->
     
     <div class="clearfix"> </div>
     
     </div> <!--end of navcontainer-->


   <div class="lnchcontent">
   
                           <div class="lnchelement">
                           
                    <div class="_cMain">
                    
                    	
                       <div data-tabpane_contianer>
                        <!-- Start of Alerts -->
             		          <div class="alert_todo" style="display:none;" data-tabpane="alerts">
                   
                    
                   		<div id ="alerts_placeholder" class="alerts" >
         
                        
                        </div> <!--end of alert-->
                        
                        </div>
                       <!-- end of Alerts -->
                       
                       
                        <!-- Start of Todo -->
                        <div class="todos" style="display:none; margin-top: 22px;" data-tabpane="todos">
                        	 <div id="todos_placeholder"></div>
                            
                        </div>
                       <!-- end of Todo -->
                       
                   
				<div class="calendar demo_message_container ">
				<div class="">
				                	 <div class="demo_message" style="font-size:18px;height:100px; width:430px;">
					   
					            For Demonstration Only. Functionality to be available in subsequent Playpens
					            
					            
					
					</div>
               <c:url var="htmlUrl_planner" value="/calendar" />     	
                       
<div id= datepara style=" float:left;"><p> 
<c:set var="now" value="<%=new java.util.Date()%>" />

                    	<fmt:formatDate type="date" pattern="EEE, MMM d, ''yy" value="${now}"  /> 
						</p></div>
                        <div id= calenderdiv style=" float:left; margin-left: 5px; margin-top:5px;"><a class="icon-cal text-size-px11 lbx-calendar" data-tab="calendar">Calendar</a></div>
                       
                        <div class="_cLeft all-box-shadow" style="">
                        

                            
                            <div class="_upcoming _up1">
                            	<div class="_cDate" style="color:#A80000;">
                                	<span class="dmonth"></span><br> <b>09.00 AM</b>
                                </div>
                                
                                <div class="_uevent" style="">
                                	Recap on Ziksana.
                                </div>
                            </div>
                            
                            <div class="_upcoming _up1">
                            	<div class="_uDate">
                                	<b>26-JAN</b><br> <b>12.00 PM</b> 
                                </div>
                                
                                <div class="_uevent">
                                	Lunch with Ziksana
                                </div>
                            </div>
                            
                            <div class="_upcoming _up2">
                            	<div class="_uDate">
                                	<b>26-JAN</b><br> <b>02.00 PM</b> 
                                </div>
                                
                                <div class="_uevent" style="padding-top:2px; text-align:middle;">
                                	Experiment with<br/> Playpen
                                </div>
                            </div>
                            

                            
                        	
                        </div>
                        
                        <div class="_cRight all-box-shadow">
                        	<div class="_e1">
                            	<div style="margin-top:9px; padding-bottom: 9px; padding-left: 5px;"><span class="bold text-size-px12 orange ehead">26-JAN - Recap on Ziksana Capability</span></div>

								<div><i class=" bold">Place: </i>UTD Administrative Building
								<i class=" bold"><br>Time: </i>9:00 am - 12:00 pm </div>
                            </div>
                            
                            <div class="_e2" style="display: none;">
                            <div style="margin-top:9px; padding-bottom: 9px; padding-left: 5px;"><span class="bold text-size-px12 ehead">26-JAN - Lunch with Ziksana</span></div>
						      <div><i class=" bold">Place: </i><br>
						<i class=" bold">Time: </i>12:00 pm - 1:30 pm<br>
                            </div>
                            </div>
                            
                            <div class="_e3" style="display: none;">
                             <div style="margin-top:9px; padding-bottom: 9px; padding-left: 5px;"><span class="bold text-size-px12 ehead"><span class="dmonth"></span> - Experiment with Playpen</span></div>
                            	
							<div><i class=" bold">Place: </i><br>
							<i class=" bold">Time: </i> 2:00 pm</div>
                            </div>
                        </div>
                    
						</div>
						</div>
						</div>
					</div>
<div class="clearfix"> </div>
                         
<br />
                         <!--end of elementlinks-->
                         
                       <div class="elementlinks" style="margin:20px;">
 						<ul>
                        <li><a id="alertlink" onclick="hidecalender()" data-tab="alerts">Alerts</a></li>
                        <li><a id="todolink" onclick="hidecalender()" data-tab="todos">To Dos</a></li>
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
			<a class="fancyboxclose" href="mylearningprogram.html" target="_parent" >
				<h5>Create Course</h5>
				<div>Create your course with an easy 7 step process </div>				
			</a>
				
			<a class="fancyboxclose" href="#linkurl">
				<h5>Manage Course</h5>
				<div style="text-align:center;">To be released in next Playpen.</div>					
			</a>
			
			<a class="fancyboxclose" href="#linkurl">
				
                <h5>Publish Course</h5>
				<div style="text-align:center;">To be released in next Playpen.</div>			
			</a>

            <a class="fancyboxclose" href="#linkurl">
				<h5>Grade Students</h5>
				<div style="text-align:center;">To be released in next Playpen.</div>				
			</a>
	</c:if>
	 <c:if test="${member.roleType eq 'LEARNER'}">
	 <a class="fancyboxclose" href="mylearningprogram.html" target="_parent" >
				<h5>Course</h5>
				<div>Study the courses that you have subcribed to </div>				
			</a>
				
			<a class="fancyboxclose" href="#linkurl">
				<h5>Tutorial</h5>
				<div style="text-align:center;">To be released in next Playpen.</div>					
			</a>
			
			<a class="fancyboxclose" href="#linkurl">
				
                <h5>Assignments</h5>
				<div style="text-align:center;">To be released in next Playpen.</div>					
			</a>

            <a class="fancyboxclose" href="#linkurl">
				<h5>Performance</h5>
				<div style="text-align:center;">To be released in next Playpen.</div>					
			</a>
	 </c:if>
		</section>               
                    

   
    </div><!-- end of lnchrightnavlinks-->
     
     
     
     <div class="clearfix"> </div>

	 

      </div> <!--end of lnchcontent-->



<div class="lnchbottom" style="float: right; margin-right: 200px; margin-top: -60px;z-index: 1000;position: relative;">

	
   <a id="calendarlink" class="navquit" onclick="window.parent.confirmFancyboxClose()">Quit</a>
   </div><!--end of lnchbottom-->

<div class="clearfix"> </div>




              </div> <!--end of mainconatiner-->

			       	</div><!-- end of lwrapper-->

<script type="text/javascript">
$(function(){
	// TABS
 $('[data-tab]').live('click',function(){  
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
