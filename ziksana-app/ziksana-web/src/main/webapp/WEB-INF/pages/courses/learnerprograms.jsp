<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
	<head>
	<meta charset="utf-8">
    <!-- fix. IE 6-->
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" >
	<!-- fix. IE 6-->
	<script>
	  document.createElement('header');
	  document.createElement('nav');
	  document.createElement('section');
	  document.createElement('article');
	  document.createElement('aside');
	  document.createElement('footer');
	</script>
	<!-- end fix. IE 6-->
	<title>My Courses</title>
	<!--Body Style sheet-->
	 <link rel="stylesheet" type="text/css" href="css/dropdown.css" />
    <link href="css/styles.css" rel="stylesheet" type="text/css">
	<link href="css/type-setting.css" rel="stylesheet" type="text/css">
	<link href="css/effects.css" rel="stylesheet" type="text/css">
	<link href="css/nav.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="css/tag/tagit-simple-blue.css">
    <link rel="stylesheet" href="css/tipsy.css" type="text/css" />
    <link rel="stylesheet" href="zeni/css/zeni/zeni2.css" />
    <link rel="stylesheet" type="text/css" href="jdashboard/jdashboard.css" />
	
	<script src="js/jquery-1.7.2.min.js"></script>
	
	<script src="js/custom/z_plugins.js"></script>
<script src="js/custom/z_common.js"></script>
<script src="js/jquery_confirm/jquery.confirm.js"></script>
<link rel="stylesheet" href="js/jquery_confirm/jquery.confirm.css"/>



    <script src="js/jquery.isotope.min.js"></script>
    <script src="js/dropdown/hover-dropdown.min.js"></script>
    <script src="js/dropdown/tiwtter.js"></script>
    <script type='text/javascript' src="js/custom/mystudent.js"></script>
    <script src="js/ui/jquery.ui.core.js"></script>
	<script src="js/ui/jquery.ui.widget.js"></script>
	<script src="js/ui/jquery.ui.button.js"></script>
	<script src="js/ui/jquery.ui.progressbar.js"></script>
	<script src="js/ui/jquery.ui.tabs.js"></script>
    <!--fancybox-->
	<script type="text/javascript" src="js/ui/jquery.mousewheel-3.0.4.pack.js"></script>
	<script type="text/javascript" src="js/ui/jquery.fancybox-1.3.4.pack.js"></script>

	<link rel="stylesheet" type="text/css" href="js/ui/jquery.fancybox-1.3.4.css" media="screen" />
	<!--fancybox end-->
	
	<script type='text/javascript' src='js/jquery.tipsy.js'></script>
	<script src="js/jquery.collapse.js"></script>
	<script src="js/ui/jquery.raty.min.js"></script>    
    <script src="js/custom.js" type="text/javascript"></script> 
  	<script type="text/javascript" src="jdashboard/jdashboard.min.js"></script>
	<script type="text/javascript">
			
		$(function() {
			$("#jDash").jDashboard({ columns: 1 ,columnWidth: 100 });
			
		});
		
		$(function() {
			$("#jDashright").jDashboard({ columns: 1 ,columnWidth: 100 });
			
		});
			
		$(function() {
			$("#jDashleft").jDashboard({ columns: 1 ,columnWidth: 100 });
				
		
		
			$('#foo2').carouFredSel({
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
		}
		
			
	</script>
   
   <script>
   $(document).ready(function() {
   $('.js-activated').dropdownHover();
    });
  </script>   
   <script type="text/javascript" language="javascript" src="js/easyslider/jquery.carouFredSel-6.1.0-packed.js"></script>

		<!-- optionally include helper plugins -->
		<script type="text/javascript" language="javascript" src="js/easyslider/jquery.mousewheel.min.js"></script>
		<script type="text/javascript" language="javascript" src="js/easyslider/jquery.touchSwipe.min.js"></script>
		<script type="text/javascript" language="javascript" src="js/easyslider/jquery.ba-throttle-debounce.min.js"></script>          
   
		
		<style type="text/css">
			
			body {
				background: #F9F9F9 url("images/grain-light.png");
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
	padding: 15px 0 15px 47px;
	position: relative;
}
.image_carousel img {
	border: 1px solid #ccc;
	background-color: white;
	padding: 9px;
	margin: 7px;
	display: block;
	float: left;
}
a.prev, a.next {
	background: url(images/miscellaneous_sprite.png) no-repeat transparent;
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
	background: url(images/miscellaneous_sprite.png) 0 -300px no-repeat transparent;
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
		</style>
  
        
        
</head>
<body>
<div id="wrapper">
       <!--Header Container-->
        	<!--Header Container-->
		<p><a><img data-launcher src="images/ziksana_button_logo.png" width=120px height=120px style="position: absolute;top:3px;left:30px; margin-left:0px;  "/></a></p>
        	<header class="bottom-box-shadow bckground-wihte">
			<p>&nbsp;&nbsp;</p>
            	<div class="topheader"> 
          <!--logo container-->
          
          <!--end logo container-->
		    
          <div class="status-container">
		
            <div id="status-icons" class="bottom-box-shadow two-bottom-rounded-box">
              <ul>
                <li><a href="#" class="email-icon" rel="tipsy" title="3 New Messages"><span class="wite-title">3</span></a></li>
                 <li><a href="#" class="peoples-icon orange-bc" rel="tipsy" title="5 Contact requests"><span class="wite-title">5</span></a></li>
                <li><a href="#" class="alart-icon orange-bc" rel="tipsy" title="1 Connect Request"><span class="wite-title">1</span></a></li>
                <li><a href="#" class="announcement-icon orange-bc" rel="tipsy" title="3 New Announcement"><span class="wite-title">3</span></a></li>
                 <li><a href="#" class=" amount-icon blue-bc"  rel="tipsy" title="Ziks available"><span class="wite-title">355500</span></a></li>
               
              </ul>
              <div > </div>
            </div>
             <div class="account-container two-bottom-rounded-box">
              <div class="container">
                <div class="topnav" ><a href="#" class="signin wite bold"><span class="text-size-px12 wite bold">My Account</span></a> </div>
                <fieldset id="signin_menu">
                 <ul>
                   <li><a href="#">Preferences</a></li>
                   <li><a href="#">Privacy</a></li>
                   <li><a href="#">Sign Out</a></li></ul>
                </fieldset>
              </div>
            </div>
          </div>
        </div>
            <nav>
			<div class="menu" style=" margin-left:-170px;">
                      <ul>
                        <li><a href="educatorHomepage.html" class="current">My Home</a><div class="nav-line"></div></li>
                        <li><a href="myprograms.html">My Programs</a><div class="nav-line"></div></li>
                        <li><a href="#">My Students</a><div class="nav-line"></div></li>
                        <li><a href="#" style="margin-left:-10px;">My Locker</a></li>
                      </ul>
                    </div>
					
              
              </nav>
            </header>
        <!--End Header Container-->
        <!--slogen-->
 
 
  <!--End slogen-->
  <!--Main Content-->
     		<section>
           	  <div class="section">
              <!--Left column-->
      
                	<!--End Left column-->
                    <!--Center Container-->
                <div class="center for-rounded-box all-box-shadow"  style="width:1000px; margin-top:10px; margin-right:-10px; margin-left:0px;">
                
          
       
     
		 	
		
        
        
        <div class="image_carousel" style="background-color:#FCF9F5; ">
	<div id="foo2">
    
    
		<div class="col-stud" style="border:1px solid #ccc;">
              
              <div class="bckground-wihte for-rounded-box all-box-shadow creat-boxhover">
                <p class="titles-info text-size-px18 font-Signika blue uppercase">${program}</p>
                <p class="p-p create-box-width f-l" style="margin-bottom:5px; margin-left:3px; margin-top:-4px;">
				<span style="font-weight:bold;"> Learning Programs </span> Defines the Curriculum necessary to meet the Learning Objectives..</p>
                <p class="number-creat-boxs f-r font-Signika bold for-rounded-box" style="margin-top:10px;">3</p>
				
                <div class="icons-list" >
                  
                 
				   <a onclick="showcourse()" rel="tipsy" title="List Courses" class="Icon-listp icons-left"> </a>
				  
                </div>              
              </div>
    </div>
	
    <div class="col-stud" style="width:115px">
	</div>
    
		<div class="col-stud" style="border:1px solid #ccc;">
              
              <div class="bckground-wihte for-rounded-box all-box-shadow creat-boxhover">
                <p class="titles-info text-size-px18 font-Signika blue uppercase">Learning Program 2</p>
                <p class="p-p create-box-width f-l" style="margin-bottom:5px; margin-left:3px; margin-top:-4px;">
				<span style="font-weight:bold;"> Learning Programs </span> Defines the Curriculum necessary to meet the Learning Objectives..</p>
                <p class="number-creat-boxs f-r font-Signika bold for-rounded-box" style="margin-top:10px;">8</p>
				
                <div class="icons-list">
                  
                 
				   <a onclick="showcourse()" rel="tipsy" title="List Courses" class="Icon-listp icons-left"> </a>
				  
                </div>              
              </div>
    </div>
		
        
      <div class="col-stud" style="width:120px">
	</div>  
        
        <div class="col-stud" style="border:1px solid #ccc;">
              
              <div class="bckground-wihte for-rounded-box all-box-shadow creat-boxhover">
                <p class="titles-info text-size-px18 font-Signika blue uppercase">Learning Programs 3</p>
                <p class="p-p create-box-width f-l" style="margin-bottom:5px; margin-left:3px; margin-top:-4px;">
				<span style="font-weight:bold;"> Learning Programs </span> Defines the Curriculum necessary to meet the Learning Objectives..</p>
                <p class="number-creat-boxs f-r font-Signika bold for-rounded-box" style="margin-top:10px;">8</p>
				
                <div class="icons-list">
                 
                  
				   <a onclick="showcourse()" rel="tipsy" title="List Courses" class="Icon-listp icons-left"> </a>
				  
           </div>              
        </div>
   
   </div>
       
     <!--  
        <div class="col-stud" style="border:1px solid #ccc;">
              
              <div class="bckground-wihte for-rounded-box all-box-shadow creat-boxhover">
                <p class="titles-info text-size-px18 font-Signika blue uppercase">Learning Program</p>
                <p class="p-p create-box-width f-l" style="margin-bottom:5px; margin-left:3px; margin-top:-4px;">
				<span style="font-weight:bold;"> Learning Programs </span> Defines the Curriculum necessary to meet the Learning Objectives..</p>
                <p class="number-creat-boxs f-r font-Signika bold for-rounded-box" style="margin-top:10px;">8</p>
				
                <div class="icons-list">
                  <a href="#linkurl" rel="tipsy" title="List View" class="Icon-listp icons-right" ></a>
                  <a href="learningprograms.html" rel="tipsy" title="Create New" class="Icon-create icons-right"> </a>
           </div>              
        </div>
   
   </div>
   
  --> 
   
    
   
   
   
    
	
    
    
    </div>
	<div class="clearfix"></div>
	<a class="prev" id="prev2" href="#"><span>prev</span></a>
	<a class="next" id="next2" href="#"><span>next</span></a>
	<div id="foo2_pag"></div>
    
     </div><!-- end of slider-->
    
        
        
     <div class="stdwrapper" style=" height:250px; visibility:hidden;" >
     
	 
	
	 
	 
     <div class="stdnavlink">
	 <!--
	   <div class="programisotope" style="height:40px;">
                
                 <li><a class="btn btn-info" href="#linkurl" onclick="showall()" >All</a> </li> 
                  <li><a class="btn btn-info" href="#linkurl" onclick="showtperformer()" >Top Performer</a></li> 
                  
                   <li><a class="btn btn-info" href="#linkurl" onclick="showaverage()" >Average</a></li>
                     
                   <li> <a class="btn btn-info" href="#linkurl" onClick="showbaverage()">Below Average</a></li>
                   
                </div> --> <!--end of programisotope--> 
	
	 <div class="col-lft li-1 All" style=" width:30px;">
              
              
			</div>  
	
				 <div class="col-lft li-1 All" style="border:1px solid #ccc; width:205px;">
              
              <div class="bckground-wihte for-rounded-box all-box-shadow creat-boxhover">
                <p class="titles-info text-size-px14 font-Signika blue uppercase">Model thinking</p>
                <p class="p-p create-box-width f-l" style="margin-bottom:5px; margin-left:12px; margin-top:-4px;"> <img src="images/programs/Model Thinking.jpg" width="162" height="97"/>
				</p>
				<div class="course_progress_bar_container" ><a href="#" rel="tipsy"  title="80%">
					<div class="course_progress_bar" style="width: 80%" > </div></a>
				</div>
                <div class="icons-list">
				
					<a href="ContentConsumption/index.html" rel="tipsy" title="Observe Course" class="Icon-course icons-right"></a>
				    <a href="#" rel="tipsy" title="View Playbook" class="Icon-Strategy icons-right"></a>
				   <a href="#linkurl" rel="tipsy" title="View Assignments  " class="Icon-view icons-left" style="margin-right:-2px;"></a>
                 <a href="#linkurl" rel="tipsy" title="List View Calendar" class="Icon-Calendar3 icons-right"></a>
                
                
               
				</div>              
              </div>
			</div>  
	 <div class="col-lft li-1 All" style=" width:110px;">
              
              
			</div>  
			<div class="col-lft li-1 All" style="border:1px solid #ccc; width:205px;">
              
              <div class="bckground-wihte for-rounded-box all-box-shadow creat-boxhover">
                <p class="titles-info text-size-px14 font-Signika blue uppercase">Dynamics of Creativity</p>
                <p class="p-p create-box-width f-l" style="margin-bottom:5px; margin-left:12px; margin-top:-4px;"> <img src="images/programs/Dynamics of Creativity.jpg" width="162" height="97"/>
				</p>
				<div class="course_progress_bar_container" ><a href="#" rel="tipsy"  title="5%">
					<div class="course_progress_bar" style="width: 5%" > </div></a>
				</div>
                <div class="icons-list">
				
                <a href="#" rel="tipsy" title="Observe Course" class="Icon-course icons-right"></a>
				    <a href="#" rel="tipsy" title="View Playbook" class="Icon-Strategy icons-right"></a>
				   <a href="#linkurl" rel="tipsy" title="View Assignments  " class="Icon-view icons-left" style="margin-right:-2px;"></a>
                 <a href="#linkurl" rel="tipsy" title="List View Calendar" class="Icon-Calendar3 icons-right"></a>
                
                
               
				</div>               
              </div>
			</div>  
			<div class="col-lft li-1 All" style=" width:120px;">
              
              
			</div>  
	<div class="col-lft li-1 All" style="border:1px solid #ccc; width:205px;">
              
              <div class="bckground-wihte for-rounded-box all-box-shadow creat-boxhover">
                <p class="titles-info text-size-px14 font-Signika blue uppercase">Behavioural Models</p>
                <p class="p-p create-box-width f-l" style="margin-bottom:5px; margin-left:12px; margin-top:-4px;"> <img src="images/programs/Behavioural Models.jpg" width="162" height="97"/>
				</p>
				<div class="course_progress_bar_container" ><a href="#" rel="tipsy"  title="5%">
					<div class="course_progress_bar" style="width: 5%" > </div></a>
				</div>
                <div class="icons-list">
				
                <a href="#" rel="tipsy" title="Observe Course" class="Icon-course icons-right"></a>
				    <a href="#" rel="tipsy" title="View Playbook" class="Icon-Strategy icons-right"></a>
				   <a href="#linkurl" rel="tipsy" title="View Assignments " class="Icon-view icons-left" style="margin-right:-2px;"></a>
                 <a href="#linkurl" rel="tipsy" title="List View Calendar" class="Icon-Calendar3 icons-right"></a>
                
                
               
				</div>                
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
					path:'images/img/',
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
     
   <script type="text/javascript" src="js/widget/jquery-ui-personalized-1.6rc2.min.js"></script>
   
   <style type="text/css">
	.course_progress_bar_container{background: #EE5023; clear: both;}
	.course_progress_bar {background: seagreen; display: block; height: 5px;}
   </style>
  
</body>
</html>

