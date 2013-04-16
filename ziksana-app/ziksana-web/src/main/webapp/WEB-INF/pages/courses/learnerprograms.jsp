<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<meta charset="utf-8">
    <!-- fix. IE 6-->
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" >
	<!-- fix. IE 6-->
	
	<!-- end fix. IE 6-->
	<title>My Courses</title>
	
	
	<script src="${staticFileServer}resources/js/jquery.isotope.min.js"></script>
<script type='text/javascript' src="${staticFileServer}resources/js/custom/myprogram.js"></script>

<!-- <script src="../resources/js/jquery_confirm/jquery.confirm.js"></script>
<link rel="stylesheet" href="../resources/js/jquery_confirm/jquery.confirm.css"/>



    <script src="../resources/js/jquery.isotope.min.js"></script>
    <script src="../resources/js/dropdown/hover-dropdown.min.js"></script>
    <script src="../resources/js/dropdown/tiwtter.js"></script>
    <script type='text/javascript' src="../resources/js/custom/mystudent.js"></script>
    <script src="../resources/js/ui/jquery.ui.core.js"></script>
	<script src="../resources/js/ui/jquery.ui.widget.js"></script>
	<script src="../resources/js/ui/jquery.ui.button.js"></script>
	<script src="../resources/js/ui/jquery.ui.progressbar.js"></script>
	<script src="../resources/js/ui/jquery.ui.tabs.js"></script>
    -->
	


	<script type="text/javascript">
			
		$(function() {
			$("#jDash").jDashboard({ columns: 1 ,columnWidth: 100 });
			
		});
		
		$(function() {
			$("#jDashright").jDashboard({ columns: 1 ,columnWidth: 100 });
			
		});
			
		$(function() {
			$("#jDashleft").jDashboard({ columns: 1 ,columnWidth: 100 });
				
		
		
			$('#foo1s').carouFredSel({
					width:910,
					align:'left',
					auto: false,
					prev: '#prev2',
					next: '#next2',
					pagination: "#pager2",
					mousewheel: true,
					swipe: {
						onMouse: true,
						onTouch: true
					}
				}); 

		
		});
		
		function showcourse()
		{
		$('.stdwrapper').css("visibility", "visible");
		$('.arrowdown').show('');
		}
		
			
	</script>
   
   <script>
   $(document).ready(function() {
   $('.js-activated').dropdownHover();
    });
  </script>   
  
		<!-- optionally include helper plugins -->
		
   
		
		<style type="text/css">
			
			body {
				background: #F9F9F9 url("/zisana-web/resources/images/grain-light.png");
			}
			
			#jDash {
	min-height: 500px;
	/* [disabled]background: white; */			
				
			}
			
	.demo1{
		border: 1px solid #ccc;
		margin-top: 10px;
		font-size: 12px;
	}
	.demo1 div div{
		padding: 10px;
		border-bottom: 1px solid #ccc;
	}

			
	
	/*slider */
	
	.image_carousel {
	width:952px;
	padding: 15px 0 15px 47px;
	position: relative;
	
	display:table;
}
.image_carousel img {
	
	background-color: white;
	padding: 9px;
	margin: 7px;
	display: block;
	float: left;
}
a.prev, a.next {
	background: url(/zisana-web/resources/images/miscellaneous_sprite.png) no-repeat transparent;
	width: 45px;
	height: 50px;
	display: block;
	position: absolute;
	top: 85px;
}
a.prev {			left: 2px;
					background-position: 0 0; }
a.prev:hover {		background-position: 0 -50px; }
a.prev.disabled {	background-position: 0 -100px !important;  }
a.next {			right: 2px;
					background-position: -50px 0; }
a.next:hover {		background-position: -50px -50px; }
a.next.disabled {	background-position: -50px -100px !important;  }
a.prev.disabled, a.next.disabled {
	cursor: default;
}

a.prev span, a.next span {
	display: none;
}
.pagination {
	text-align: center;
}
.pagination a {
	background: url(/zisana-web/resources/images/miscellaneous_sprite.png) 0 -300px no-repeat transparent;
	width: 15px;
	height: 15px;
	margin: 0 5px 0 0;
	display: inline-block;
}
.pagination a.selected {
	background-position: -25px -300px;
	cursor: default;
}
.pagination a span {
	display: none;
}
.clearfix {
	float: none;
	clear: both;
}
	
.stdwrapper
{
padding:10px;

}
		
.stdbox
{
width:auto;
margin-top:4px;
padding-bottom:4px;
border:1px solid #ccc;	
-webkit-border-radius: 3px;
-moz-border-radius: 3px;
border-radius: 3px;
background: rgb(249,252,247); /* Old browsers */
/* IE9 SVG, needs conditional override of 'filter' to 'none' */
background: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPGxpbmVhckdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgeDE9IjAlIiB5MT0iMCUiIHgyPSIwJSIgeTI9IjEwMCUiPgogICAgPHN0b3Agb2Zmc2V0PSIwJSIgc3RvcC1jb2xvcj0iI2Y5ZmNmNyIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjEwMCUiIHN0b3AtY29sb3I9IiNmNWY5ZjAiIHN0b3Atb3BhY2l0eT0iMSIvPgogIDwvbGluZWFyR3JhZGllbnQ+CiAgPHJlY3QgeD0iMCIgeT0iMCIgd2lkdGg9IjEiIGhlaWdodD0iMSIgZmlsbD0idXJsKCNncmFkLXVjZ2ctZ2VuZXJhdGVkKSIgLz4KPC9zdmc+);
background: -moz-linear-gradient(top,  rgba(249,252,247,1) 0%, rgba(245,249,240,1) 100%); /* FF3.6+ */
background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(249,252,247,1)), color-stop(100%,rgba(245,249,240,1))); /* Chrome,Safari4+ */
background: -webkit-linear-gradient(top,  rgba(249,252,247,1) 0%,rgba(245,249,240,1) 100%); /* Chrome10+,Safari5.1+ */
background: -o-linear-gradient(top,  rgba(249,252,247,1) 0%,rgba(245,249,240,1) 100%); /* Opera 11.10+ */
background: -ms-linear-gradient(top,  rgba(249,252,247,1) 0%,rgba(245,249,240,1) 100%); /* IE10+ */
background: linear-gradient(to bottom,  rgba(249,252,247,1) 0%,rgba(245,249,240,1) 100%); /* W3C */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f9fcf7', endColorstr='#f5f9f0',GradientType=0 ); /* IE6-8 */
}

.stdphoto
{
width:14%;
float:left;
/*border:1px solid #ccc;*/
margin-right:5px;
padding:5px;
margin-top:5px;
}
	
.stddetails
{
width:60%;
float:left;
/*border:1px solid #ccc;	*/
	
padding:5px;
}

.stdlinks
{
width:10;
float:left;
/*border:1px solid #ccc;*/
padding:5px;
margin-top:5px;
	
}

.stdtbl
{
overflow:scroll;
overflow-x: hidden;
height:100px;
}


.stdsrt
{
margin:6px;		
}

.stdsrthead
{
font-size:12px;
font-family:Verdana;
color:#27b;
font-weight:bold;

}

.stdsrtdtl
{
font-size:12px;
font-family:Verdana;
color:#666;
			
}
.titles-info1 {
    background-color: rgba(218, 216, 216, 0.17);
    border-bottom: 1px solid #CCCCCC;
    border-radius: 3px 3px 0 0;
    display: block;
    margin: 1px 0 10px;
    padding: 7.5px 10px;
    position: relative;
}
		</style>
  
        

<div id="wrapper">
       <!--Header Container-->
        
        <!--slogen-->
 
 
  <!--End slogen-->
  <!--Main Content-->
     		<section>
           	  <div class="section">
              <!--Left column-->
      
                	<!--End Left column-->
                    <!--Center Container-->
                <div class="center for-rounded-box all-box-shadow"  style="width:1000px; margin-top:10px; margin-right:-10px; margin-left:0px;">
                
          
       
     
		 	
		
        
        
        <div class="image_carousel" style="background-color:#ffffff; ">
	
    
    
		<div class="col-stud" style="border:1px solid #ccc; width:240px; display:table-cell;">
              <div class="bckground-wihte for-rounded-box all-box-shadow creat-boxhover">
                <p class="titles-info1 text-size-px18 font-Signika blue uppercase">${program}</p>
                <p class="p-p create-box-width f-l" style="margin-bottom:5px; margin-left:3px; margin-top:-4px;">
				<span style="font-weight:bold;"> Learning Programs </span> Defines the Curriculum necessary to meet the Learning Objectives..</p>
               <!--  <p class="number-creat-boxs f-r font-Signika bold for-rounded-box" style="margin-top:10px;"><span style="font-size:15px;">${learnerCourseSize}Course</span>  </p>-->
                <p class="number-creat-box f-r font-Signika bold for-rounded-box" style=" margin-top:-4px;font-size:20px;color:#fff;">${learnerCourseSize}<br/> <span style="font-size:15px;">Course</span></p>
				<div class="icons-list" >
                  <a onclick="showcourse()" rel="tipsy" title="List Courses" class="Icon-listp icons-right"> </a>
				 	<img src="../resources/images/nav-arow.png" class="arrowdown" style="padding-top:0px; margin-top:36px; position:absolute; margin-left:73px; display:none;"> 
				</div>
			
              </div>
			  
     </div>
	
    <br/>
    
		<!-- <div class="col-stud" style="border:1px solid #ccc;width:210px;display:table-cell;" >
              
              <div class="bckground-wihte for-rounded-box all-box-shadow creat-boxhover">
                <p class="titles-info1 text-size-px18 font-Signika blue uppercase">Learning Program 2</p>
                <p class="p-p create-box-width f-l" style="margin-bottom:5px; margin-left:3px; margin-top:-4px;">
				<span style="font-weight:bold;"> Learning Programs </span> Defines the Curriculum necessary to meet the Learning Objectives..</p>
                <p class="number-creat-boxs f-r font-Signika bold for-rounded-box" style="margin-top:10px;">8</p>
				
                <div class="icons-list">
                  
                 
				   <a onclick="showcourse()" rel="tipsy" title="List Courses" class="Icon-listp icons-left"> </a>
				  
                </div>              
              </div>
    </div> -->
		
        
      <br>

       
    
		<!-- <div class="col-stud" style="border:1px solid #ccc;width:210px;display:table-cell;" >
              
              <div class="bckground-wihte for-rounded-box all-box-shadow creat-boxhover">
                <p class="titles-info1 text-size-px18 font-Signika blue uppercase">Learning Program 3</p>
                <p class="p-p create-box-width f-l" style="margin-bottom:5px; margin-left:3px; margin-top:-4px;">
				<span style="font-weight:bold;"> Learning Programs </span> Defines the Curriculum necessary to meet the Learning Objectives..</p>
                <p class="number-creat-boxs f-r font-Signika bold for-rounded-box" style="margin-top:10px;">8</p>
				
                <div class="icons-list">
                  
                 
				   <a onclick="showcourse()" rel="tipsy" title="List Courses" class="Icon-listp icons-left"> </a>
				  
                </div>              
              </div>
    </div> -->
       
   

   
    
   
   
   
    
	
    
    
 
	
	
	
	<div class="clearfix"></div>
	<a class="prev" id="prev2" href="#"><span>prev</span></a>
	<a class="next" id="next2" href="#"><span>next</span></a>
	<div id="foo2_pag"></div>
    
     </div><!-- end of slider-->
    
        
        
     <div class="stdwrapper" style=" margin-left:60px;  visibility:hidden; text-align:center;" >
     
	 
	
	 
	 
     <div class="stdnavlink" >
	 <!--
	   <div class="programisotope" style="height:40px;">
                
                 <li><a class="btn btn-info" href="#linkurl" onclick="showall()" >All</a> </li> 
                  <li><a class="btn btn-info" href="#linkurl" onclick="showtperformer()" >Top Performer</a></li> 
                  
                   <li><a class="btn btn-info" href="#linkurl" onclick="showaverage()" >Average</a></li>
                     
                   <li> <a class="btn btn-info" href="#linkurl" onClick="showbaverage()">Below Average</a></li>
                   
                </div> --> <!--end of programisotope--> 
	
	  
				<c:forEach var="course" items="${courses}">
				 <div class="col-lft li-1 All" style="border:1px solid #ccc; width:205px;">
            
              <div class="bckground-wihte for-rounded-box all-box-shadow creat-boxhover">
                <p class="titles-info1 text-size-px14 font-Signika blue uppercase"><c:out value="${course.name}"/></p>
                <p class="p-p create-box-width f-l" style="margin-bottom:5px; margin-left:12px; margin-top:-4px;"> <img src="../resources/images/programs/ECourse.jpg" width="162" height="97"/>
				</p>
				<div class="course_progress_bar_container" ><a href="#" rel="tipsy"  title="80%">
					<div class="course_progress_bar" style="width: 80%" > </div></a>
				</div>
                <div class="icons-list">
				
					<a href="/ziksana-web/zcourse/course/${course.coursesId}" rel="tipsy" title="Observe Course" class="Icon-course icons-right"></a>
				    <a href="#" rel="tipsy" title="View Playbook" class="Icon-Strategy icons-right"></a>
				   <a href="#" rel="tipsy" title="View Assignments  " class="Icon-view icons-left" style="margin-right:-2px;"></a>
                 <a href="#" rel="tipsy" title="List View Calendar" class="Icon-Calendar3 icons-right"></a>
                
                
               
				</div>              
              </div>
              
              
			</div>  
			
			</c:forEach>
	
			
              
              
			</div>  
		 
	
              
              
    </div>  
	 
	 
	 
	 
	 
    
    
   
   
   
   
   
   
   
   
   
   
     </div> <!--end of stdnavinks-->
     
    
     <div id="_isostd">
     
    				 
                       
 
   
    
   
     
     </div> <!--end of isostd-->
     
     
     
        </div> <!--end of stddetails --> 
        
        
        
      
       
		
	
       
  
  
  
  
          
          
          
          
          
          
                           
                </div>
                  <!--End Center Container-->
           	  <!--Right column--></div>
               <!--End Right column-->
  			</section>
        <!--End Main Content-->
        <!--Current Progress-->
<div class="col border-top">
  <div class="collapse">
     <h3 class="border-left border-right border-top">Your current progress  [ Starting ... ]</h3>
         <div>
        <p class="caption text-size-px18">Your progress this session... </p>
      </div>
    </div>
  </div>
            
  <script>
            $(".collapse").collapse({show: function(){
                    this.animate({
                        opacity: 'toggle', 
                        height: 'toggle'
                    }, 300);
                },
                hide : function() {
                    
                    this.animate({
                        opacity: 'toggle', 
                        height: 'toggle'
                    }, 300);
                }
            });
        
//rating-star	
$('#edu-star').raty({
					
					click		: function(score, evt) {
						$(this).fadeOut(function() { $(this).fadeIn(); });
					},
					targetKeep	: true,
					path:'../resources/images/img/',
					score		: 4,
					cancel: true
				});
        
        
        </script> 


  <!--End Current Progress-->
        <!--Footer Container-->
	 		<footer>
      		</footer>
        <!--End Footer Container-->
</div>
     
   <script type="text/javascript" src="../resources/js/widget/jquery-ui-personalized-1.6rc2.min.js"></script>
   
   <style type="text/css">
	.course_progress_bar_container{background: #EE5023; clear: both;}
	.course_progress_bar {background: seagreen; display: block; height: 5px;}
   </style>
  


