<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
    
<!DOCTYPE html>

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
	<title>My Programs</title>
	<!--Body Style sheet-->
	 <link rel="stylesheet" type="text/css" href="../resources/css/dropdown.css" />
    <link href="../resources/css/styles.css" rel="stylesheet" type="text/css">
	<link href="../resources/css/type-setting.css" rel="stylesheet" type="text/css">
	<link href="../resources/css/effects.css" rel="stylesheet" type="text/css">
	<link href="../resources/css/nav.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="../resources/css/tag/tagit-simple-blue.css">
    <link rel="stylesheet" href="../resources/css/tipsy.css" type="text/css" />
   
     <link href="../resources/css/news/newsticker.css" rel="stylesheet" type="text/css" />
     
      <link rel="stylesheet" href="../resources/zeni/css/zeni/zeni2.css" />
	
	<script src="../resources/js/jquery-1.7.2.min.js"></script>
	
	<script src="../resources/js/custom/z_plugins.js"></script>
<script src="../resources/js/custom/z_common.js"></script>
<script src="../resources/js/jquery_confirm/jquery.confirm.js"></script>
<link rel="stylesheet" href="../resources/js/jquery_confirm/jquery.confirm.css"/>


     <script src="../resources/js/jquery.isotope.min.js"></script>
    <script src="../resources/js/dropdown/hover-dropdown.min.js"></script>
       <script src="../resources/js/dropdown/tiwtter.js"></script>
  
    <script type='text/javascript' src="../resources/js/custom/myprogram.js"></script>
	<script src="../resources/js/ui/jquery.ui.core.js"></script>
	<script src="../resources/js/ui/jquery.ui.widget.js"></script>
	<script src="../resources/js/ui/jquery.ui.button.js"></script>
	<script src="../resources/js/ui/jquery.ui.progressbar.js"></script>
	<script src="../resources/js/ui/jquery.ui.tabs.js"></script>
    <!--fancybox-->
	<script type="text/javascript" src="../resources/js/ui/jquery.mousewheel-3.0.4.pack.js"></script>
	     <script src="../resources/js/jquery.fancybox.pack.2.1.3.js"></script>
	 <link rel="stylesheet" type="text/css" href="../resources/css/jquery.fancybox.2.1.3.css"/>
	<!--fancybox end-->
	   
   <style>
	.ui-progressbar .ui-progressbar-value { background-image: url(images/pbar-ani.gif); }	
   </style>
	<script>
	$(function() {
		$( "#progressbar" ).progressbar({
			value: 65
		});
	});
	
	</script>
    <script type='text/javascript' src='../resources/js/jquery.tipsy.js'></script>
	<script src="../resources/js/jquery.collapse.js"></script>
	<script src="../resources/js/ui/jquery.raty.min.js"></script>    
    <script src="../resources/js/custom.js" type="text/javascript"></script> 
   
   <link rel="stylesheet" type="text/css" href="../resources/jdashboard/jdashboard.css" />
		
		<style type="text/css">
			
			body {
				background: #F9F9F9 url("../resources/images/grain-light.png");
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

.demo_message_container1{position: relative;}
.demo_message_container1:hover .demo_message1 {
  display: block !important;
  padding-top: 22% !important;
}
.demo_message1 {
  background: none repeat scroll 0 0 rgba(0, 0, 0, 0.8);
  bottom: 0;
  color: white;
  display:none;
  font-size: 10px;
  left: 0;
  padding: 1em;
  position: absolute;
  right: 0;
  top: 0;
text-align: center;
vertical-align:middle;
z-index: 99;
}
.hover-btn
{   
    color: #000000;
    text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
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
.marginl{
margin-left:-80px;
}			
			
			
		</style>
		
	<script type="text/javascript">
function getQval(n) {
if(typeof n !== 'string'){
return null;
}
var r = new RegExp('[?&;]' + n + '=([^&;#]*)'), m = location.search;
return (m = r.exec(m))? unescape(m[1]) : null;
}

if(getQval('var1')){
activecall();
}
function myfunction()
{
$('._cklo').show('');	
			$('._cklp').show('');	
			$('._cklc').show('');
			$('._ckcourse').css('display','block');
			
			
			$('._course').hide('');	
			$('._lc').hide('');
			$('#_lp').hide('');
			$('._lo').hide('');
			
		

}
</script>	
		<script type="text/javascript" src="../resources/jdashboard/jdashboard.min.js"></script>
		<script type="text/javascript">
			
			$(function() {
				$("#jDash").jDashboard({ columns: 1 ,columnWidth: 100 });
				
			});
			
			$(function() {
				$("#jDashright").jDashboard({ columns: 1 ,columnWidth: 100 });
				
			});
			
			$(function() {
				$("#jDashleft").jDashboard({ columns: 1 ,columnWidth: 100 });
				
			});
			function coursedel(courseid,asd)
			{
			
			var con=confirm("Do You Realy Want to Delete the Course' " +asd+"'?");
			if (con==true)
			{
			$('#'+courseid).hide();
			alert("The Course '"+asd+" 'is Successfully  Deleted");
			}
			}
		</script>
        <script>
    
    $(document).ready(function() {
	
      $('.js-activated').dropdownHover();
    });
  </script>   
             
 
  
        
        
</head>
<body onload="draftcall()">
<div id="wrapper">
        <!--Header Container-->
        	<!--Header Container-->
        	 <c:url var="launcherPage" value="/secure/launcher"/>
		<p><a><img data-launcher data-launchpage="${launcherPage}" src="../resources/images/ziksana_button_logo.png" width=120px height=120px style="position: absolute;top:3px;left:30px; margin-left:0px;  "/></a></p>
        	<header class="bottom-box-shadow bckground-wihte">
			
            	<div class="topheader"> 
          <!--logo container-->
          
          <!--end logo container-->
		    
 
        </div>
            <nav>
			<div class="menu" style=" margin-left:0px;">
                      <ul>
                        <li><a href="/ziksana-web/secure/educatordashboard" >My Home</a><div class="nav-line"></div></li>
                        <li><a href="/ziksana-web/secure/showMyPrograms" class="current">My Programs</a><div class="nav-line"></div></li>
                        <li><a href="#">My Students</a><div class="nav-line"></div></li>
                        <li><a href="#" style="margin-left:-10px;">&nbsp;&nbsp;My Locker</a></li>
                      </ul>
                    </div>
					
                       <div class="status-container">
		
            <div id="status-icons" class="bottom-box-shadow two-bottom-rounded-box ">
			
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

                   <li><a href="/ziksana-web/secure/logout">Sign Out</a></li></ul>

                </fieldset>
              </div>
            </div>
          </div>
              </nav>
            </header>
        <!--End Header Container-->
        <!--End Header Container-->
        <!--slogen-->
  
 
  <!--End slogen-->
  <!--Main Content-->
     		<section>
           	  <div class="section">
              <!--Left column-->
              
                	<!--End Left column-->
                    <!--Center Container-->
                <div class="center for-rounded-box all-box-shadow"  style="width:881px;  padding-left:100px;">
                
               <!-- learning programs-->
			   
                <div class="col-lft _cklp demo_message_container1" style="border:1px solid #ccc;">
					<div class="demo_message1" style="font-size:14px;">
				For Demonstration Only. Functionality to be available in subsequent Playpens
					</div>
              <div class="bckground-wihte for-rounded-box all-box-shadow creat-boxhover">

                <p class="titles-info1 text-size-px18 font-Signika blue uppercase">Learning Program</p>
                <p class="p-p create-box-width f-l" style="margin-bottom:5px; margin-left:3px; margin-top:-4px;">
				<span style="font-weight:bold;"> Learning Programs </span> Defines the Curriculum necessary to meet the Learning Objectives..</p>
                <span class="number-creat-box f-r font-Signika bold for-rounded-box" style=" margin-top:-4px;font-size:18px;color:#fff;">8<span style="font-size:14px;"> Learning Programs</span> </span>
				
                <div class="icons-list">
                  <a href="#linkurl" rel="tipsy" title="List View" class="Icon-listp icons-right" ></a>
				  
                  
                </div>              
              </div>
    </div>
           <!--end of learning programs -->
            
          <!--course-->
          <div class="col-lft _cklp" style="width:10px;">
		  </div>
              <div id="course1" class="col-lft _ckcourse" style="border:1px solid #ccc;">
              
              <div class="bckground-wihte for-rounded-box all-box-shadow creat-boxhover">
                <p class="titles-info1 text-size-px18 font-Signika blue uppercase">Course</p>

                <p class="p-p create-box-width f-l" style="margin-bottom:5px; margin-left:3px; margin-top:-4px;">
				<span style="font-weight:bold;">Course </span> is a Learning Unit that Helps in Achieving the Learning Objectives of the Learning Program..</p>
              <p class="number-creat-box f-r font-Signika bold for-rounded-box" style=" margin-top:-4px;font-size:20px;color:#fff;">${courseCount} <span style="font-size:15px;">Courses</span></span></p>
				
                <div class="icons-list">
                  <a href="#linkurl"  rel="tipsy" title="List View" class="Icon-listp icons-right" ></a>
                  <img src="../resources/images/nav-arow.png" class="arrowdown"style="padding-top:35px; padding-left:95px; display:none;">	
                </div> 
			
              </div>
			  
    </div>   
                
         <!-- end of course -->     
                
            <!--learning objects-->
            <div class="col-lft _cklp" style="width:10px;">
		  </div>
               <div class="col-lft _cklo demo_message_container1" style="border:1px solid #ccc;">
              	<div class="demo_message1" style="font-size:14px;">
				For Demonstration Only. Functionality to be available in subsequent Playpens
					</div>
              <div class="bckground-wihte for-rounded-box all-box-shadow creat-boxhover">

                <p class="titles-info1 text-size-px18 font-Signika blue uppercase">Learning object</p>
                <p class="p-p create-box-width f-l" style="margin-bottom:5px; margin-left:3px; margin-top:-4px;">
				<span style="font-weight:bold;">Learning Object  </span> is an Learning Unit that can be used as a building block for creating a course..</p>
                      <p class="number-creat-box f-r font-Signika bold for-rounded-box" style="margin-top:-4px;font-size:18px;color:#fff;">4<span style="font-size:14px;"> Learning Objects</span></p>
				
                <div class="icons-list">
                   <a href="#linkurl" rel="tipsy" title="List View" class="Icon-listp icons-right" ></a>
                 
                </div>              
              </div>
    </div>   
            
         <!--end of learning objects-->   
            
                        <!--Courses container-->
               
   <div class="center for-rounded-box all-box-shadow _course" style="width:973px; margin-left:-98px;border:1px solid #a9a5a5; background:#e2dbdb;">
                <div style="margin-left:850px;disply:table; top:-100">


					 <div class="createnew" style="display:table-cell;width:100px;"><a href="/ziksana-web/secure/createcourse"><img src="../resources/images/plus.png" width=12px, height=12px >&nbsp;Create New</a> 

					</div>
					<div style="display:table-cell; padding-left:20px;">
					<a href="#">  
                   <img src="../resources/images/cross.png" onclick="closeactive()"></a>
				   </div>
                   </div>
                   <div class="programisotope" id="mnuiso" style="height: 40px;margin-top: -20px; margin-right: 800px; width: 250px;">
                  
                    <li> <a class="btn btn-info" href="#linkurl" id="activec" onClick="showactivec()" style="float:right;">Active</a></li>
                      <li> <a class="btn btn-info" href="#linkurl" id="reviewc" onClick="showreviewc()" style="float:right;">Review</a></li>
                    <li><a class="btn btn-info" href="#linkurl" id="draftc" onclick="showdraftc()" style="float:right;">Draft</a></li>
                   
                    
                    <li><a class="btn btn-info" href="#linkurl" id="allc" onclick="showallc()" style="float:right;">All</a> </li>
                                      
                                      
                    
                    </div>  <!--end of zeni isotope--> 
					
                  
                
                
                <div id="_isocourse" style="margin-left:30px;">
              
               
                
            <!--learning objects-->
                 <c:forEach var="course" items="${courses}">
                 
              <div class="col-lft li-1 All Draft" id="courseModel_${course.coursesId}" style="border:1px solid #ccc; width:170px;">
              
              <div class="bckground-wihte for-rounded-box all-box-shadow creat-boxhover">

                <p style="height:30px;"class="titles-info1 text-size-px14 font-Signika blue uppercase"><c:out value="${course.name}"/></p>
                <p class="p-p create-box-width f-l" style="margin-bottom:5px; margin-left:3px; margin-top:-4px;"> <img src="../resources/images/programs/ECourse.jpg" width="148" height="97"/>
				</p>
                <div class="icons-list">
                  
                 
                 <a href="/ziksana-web/secure/createcourse/courseid_${course.coursesId}" rel="tipsy" title="Edit" class="Icon-edit icons-right" style="margin-right:-6px;"></a>

                     
                     
                     
               <a  onclick="delete_coursebycourseid(${course.coursesId})" rel="tipsy" title="Delete" class="Icon-delete icons-right" style="margin-right:-6px;"></a>
                </div>              
              </div>
                </div>
             </c:forEach> 
  
    
                
                  </div> <!--end of isotope-->
                
                </div>  <!--end of Course container-->       
                
                  <!--learning content-->
				  
            
               <div class="col-lft _cklc demo_message_container1" style="border:1px solid #ccc;">
              <div class="demo_message1" style="font-size:14px;">
				For Demonstration Only. Functionality to be available in subsequent Playpens
					</div>
              <div class="bckground-wihte for-rounded-box all-box-shadow creat-boxhover">

                <p class="titles-info1 text-size-px18 font-Signika blue uppercase">Learning Content</p>
                <p class="p-p create-box-width f-l" style="margin-bottom:5px; margin-left:3px; margin-top:-4px;">
				<span style="font-weight:bold;">Learning Contents </span> are  materials that can be associated to a course or a  to meet the Objectives..</p>
                <p class="number-creat-box f-r font-Signika bold for-rounded-box" style="margin-top:-4px;font-size:18px;color:#fff;">3 <span style="font-size:14px;"> Learning Contents</span></p>
				
                <div class="icons-list">
                  <a href="#linkurl" rel="tipsy" title="List View" class="Icon-listp icons-right" ></a>
				 
                  
                </div>              
              </div>
    </div>   
            
         <!--end of learning content-->   
                
                
                
                
                	
                    
                     
                    
                    
                </div>
                
               
               <!--learning programs container-->
             <div style=" height:500px;"><!--This div is for giving a gap between footer and content-->
			 
			  
                <div class="center for-rounded-box all-box-shadow" id="_lp" style="width:973px; padding-left:10px; padding-right:-10px;">
                <div class="programisotope" style="height:40px;margin-right:800px;width:973px; float:left; ">
                  
                    
                  
                    <li> <a class="btn btn-info" href="#linkurl" onClick="showreview()" style="float:right;">Review</a></li>
                    <li><a class="btn btn-info" href="#linkurl" onclick="showdraft()" style="float:right;">Draft</a></li>
                    <li><a class="btn btn-info" href="#linkurl" onclick="showall()" style="float:right;">All</a> </li>
            
			
			 
                    </div>  <!--end of zeni isotope-->
                <a href="#">  
                   <img src="../resources/images/cross.png" onclick="closeactive()"  style="margin-left:900px; "></a>
                    <br>
                    
                
                <!--end of isotope-->
                
                </div>  <!--end of for learning programs container-->
                
    
    
    
      

                      
                </div>  <!--learning object container-->
                
       
          </div>   

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
     
    <script type="text/javascript" src="../resources/js/widget/jquery-ui-personalized-1.6rc2.min.js"></script>
   
</body>
</html>
