<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="createcourselink" value="/secure/createcourse" />
<c:url var="associatecontentlink" value="/secure/associatecontent" />
<c:url var="enrichcontentlink" value="/secure/enrichcontent" />
<c:url var="assignmentlink" value="/secure/createassignment" />

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Define Assignment</title>
<!--Body Style sheet-->
 <link rel="stylesheet" type="text/css" href="../resources/css/dropdown.css" />
<link href="../resources/css/styles.css" rel="stylesheet" type="text/css">
<link href="../resources/css/type-setting.css" rel="stylesheet" type="text/css">
<link href="../resources/css/effects.css" rel="stylesheet" type="text/css">
<link href="../resources/css/nav.css" rel="stylesheet" type="text/css">
<link href="../resources/css/wizard/wizardstylesheet.css" rel="stylesheet" type="text/css">
<link href="../resources/css/spinner/smartspinner.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="../resources/css/chosen/superbly-tagfield.css" />
<link href="../resources/css/assignment.css" rel="stylesheet" type="text/css">
<link rel='stylesheet' type='text/css' href='../resources/css/socialize/socialize.css' />
<link rel='stylesheet' type='text/css' href="../resources/css/nav.css" />
<link type="text/css" href="../resources/css/autocomplete/humanity/jquery-ui-1.8.23.custom.css" rel="stylesheet" />

<!--End Body Style sheet-->

<script src="../resources/js/jquery-1.7.2.min.js"></script>
	 
<!-- for a temporary planner -->
<link rel='stylesheet' type='text/css' href='../resources/css/fullcalendar.css' />
<script type='text/javascript' src='../resources/js/fullcalendar.min.js'></script>

<script type="text/javascript" src="../resources/js/ckeditor/adapters/jquery.js"></script>
<script type="text/javascript" src="../resources/js/ckeditor/ckeditor.js"></script>

 <script type='text/javascript' src='../resources/js/enrich.js'></script>
  <script src="../resources/js/custom.js" type="text/javascript"></script> 
<script type='text/javascript' src='jwplayer/swfobject.js'></script>
<script type="text/javascript" src="jwplayer/jwplayer.js"></script>
<script type='text/javascript' src="../resources/js/socialize/jquery_socialize.js"></script>
<script type='text/javascript' src="../resources/js/autocomplete/jquery-ui-1.8.23.custom.min.js"></script>
<script type='text/javascript' src="../resources/js/socialize/soc.js"></script>

  <!-- css for tree -->
    <link rel="stylesheet" href="../resources/js/tree/styles/styleTree.css" type="text/css" /> <!-- for the layout of the tree -->
    
    <!-- scripts for tree -->
    <script type="text/javascript" src="../resources/js/tree/gettheme.js"></script> 
    <script type="text/javascript" src="../resources/js/tree/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="../resources/js/tree/core.js"></script>
    <script type="text/javascript" src="../resources/js/tree/buttons.js"></script>
    <script type="text/javascript" src="../resources/js/tree/scrollbar.js"></script>
    <script type="text/javascript" src="../resources/js/tree/panel.js"></script>
    <script type="text/javascript" src="../resources/js/tree/dragdrop.js"></script>
    <script type="text/javascript" src="../resources/js/tree/tree.js"></script>
    <script type="text/javascript" src="../resources/js/tree/menu.js"></script>
    <script type="text/javascript" src="../resources/js/tree/myTreeAssignment.js"></script>  
    <script type="text/javascript" src="../resources/js/tree/splitter.js"></script>
<!-- End tree -->
<link rel="stylesheet" type="text/css" href="../resources/js/ui/jquery.fancybox-1.3.4.css" media="screen" />
<script type="text/javascript" src="../resources/js/ui/jquery.mousewheel-3.0.4.pack.js"></script>
<script type="text/javascript" src="../resources/js/ui/jquery.fancybox-1.3.4.pack.js"></script>
<script type='text/javascript' src="../resources/js/custom/libraryfunction.js"></script>
<!-- scripts for number spinner -->
    <script type="text/javascript" src="../resources/js/chosen/superbly-tagfield.min.js"></script>
    
<!-- end for number spinner -->
  
  <script src="../resources/js/dropdown/hover-dropdown.min.js"></script>
       <script src="../resources/js/dropdown/tiwtter.js"></script>
   <script>
    
    $(document).ready(function() {
      $('.js-activated').dropdownHover();
    });
  </script>   


</head>

<body>
	
<div id="wrapper"> 
        <!--Header Container-->
        	<header class="bottom-box-shadow bckground-wihte">
            	<div class="topheader"> 
          <!--logo container-->
          <div class="logo"><p><a href="#"><img height="73" width="189" src="../resources/images/logo.jpg"/></a></p></div>
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
                <!--menu-->
                    <div class="menu">
                      <ul>
                        <li><a href="educatorHomepage.html" class="current">My Home</a><div class="nav-line"></div></li>
                        <li><a href="myprograms.html">My Programs</a><div class="nav-line"></div></li>
                        <li><a href="#">My Students</a><div class="nav-line"></div></li>
                        <li><a href="#" style="margin-left:-10px;">My Locker</a></li>
                      </ul>
                    </div>
                    <!--End menu-->
       	   	  		<div class="searchpanel">
       	   	  		 <div>
                      <form id="ui_element" class="sb_wrapper">
                       <span class="sb_down"></span>
                   <input type="text" name="search" id="search" placeholder="Search..." title="Search..." autosave="unique" class="two-left-rounded-box two-right-rounded-box">
   	   	  		        <input id="submit" type="submit" value="Submit">
                         
                     <ul class="sb_dropdown" style="display:none;">
					   <li class="sb_filter">Filter your search</li>
						<li><input type="checkbox"/><label for="all"><strong>All Categories</strong></label></li>
						<li><input type="checkbox"/><label for="Automotive">Students</label></li>
						<li><input type="checkbox"/><label for="Baby">Locker</label></li>
						<li><input type="checkbox"/><label for="Beauty">Program</label></li>
                       
					</ul>
       	   	  		  </form>
              </div>
       	   	  		</div>
   	   	  	  		
                    
                    <div class="searchoptions">
                   	 
     
                     
                      <ul class="dropdown nav">
                   	    <li ><a href="#linkurl" title="Help"><span class="srch-op-a"></a></li>
                        
                        
                   	    <li class="dropdown"><a href="#linkurl" class="dropdown-toggle js-activated"  title="ZInformation"><span class="srch-op-b"></a>
                        <ul class="dropdown-menu" >
                <li style="float:left;"><a tabindex="-1" class="lbx-zeni" href="../resources/zeni/zMessage.html">zAnnouncements</a></li>
                <li style="float:left;"><a tabindex="-1" class="lbx-zeni" href="../resources/zeni/zMeetings.html">zNews</a></li>
                <li style="float:left;"><a tabindex="-1" class="lbx-zeni" href="">zPoll</a></li>
            
              </ul>
                       </li>
                    	              
                      <li><a href="#"  title="ZGoods"><span class="srch-op-e"> </span></a></li>
                      
                      <li class="dropdown"><a href="#linkurl" class="dropdown-toggle js-activated"  title="ToolZ"><span class="srch-op-d"> </span></a>
                      <ul class="dropdown-menu" >
                <li style="float:left;"><a tabindex="-1" class="lbx-zeni" href="../resources/zeni/zMessage.html">zMessage</a></li>
                <li style="float:left;"><a tabindex="-1" class="lbx-zeni" href="../resources/zeni/zMeetings.html">zMeetings</a></li>
                <li style="float:left;"><a tabindex="-1" class="lbx-zeni" href="">zAlerts</a></li>
             <li style="float:left;"><a tabindex="-1" class="lbx-zeni" href="#linkurl">To Do list</a></li>
             <li style="float:left;"><a tabindex="-1" class="lbx-zeni" href="#linkurl">zSteps</a></li>
             <li style="float:left;"><a tabindex="-1" class="lbx-zeni" href="../resources/zeni/zGroups.html">zGroups</a></li>
             <li style="float:left;"><a tabindex="-1" class="lbx-zeni" href="../resources/zeni/zCollege.html">zCollage</a></li>
             <li style="float:left;"><a tabindex="-1" class="lbx-zeni" href="../resources/zeni/zDelegate.html">zDelegate</a></li>
             <li style="float:left;"><a tabindex="-1" class="lbx-zeni" href="#linkurl">zQuestion Bank</a></li>
             <li style="float:left;"><a tabindex="-1" class="lbx-zeni" href="../resources/zeni/zLibrary.html">zLibrary</a></li>
             <li style="float:left;"><a tabindex="-1" href="#linkurl">zHealthcheck</a></li>
             
             
             
              </ul>
                </li>                              
                  	  <li class="dropdown"><a href="#linkurl" class="dropdown-toggle js-activated" title="Zeni"><span class="srch-op-c"> </span></a>
                       <ul class="dropdown-menu" >
                <li style="float:left;"><a tabindex="-1" class="lbx-zeni" href="../resources/zeni/zRecommend.html">zRecommends</a></li>
                <li style="float:left;"><a tabindex="-1" class="lbx-zeni" href="../resources/zeni/zReward.html">Rewardz</a></li>
                <li style="float:left;"><a tabindex="-1" class="lbx-zeni" href="../resources/zeni/zStats.html">zStats</a></li>
                <li style="float:left;"><a tabindex="-1" class="lbx-zeni" href="../resources/zeni/zAsk.html">Askz</a></li>
                <li style="float:left;"><a tabindex="-1" class="lbx-zeni" href="../resources/zeni/zCards.html">zcard</a></li>
                <li style="float:left;"><a tabindex="-1" class="lbx-zeni" href="../resources/zeni/zStrate.html">Stratez</a></li>
                 <li style="float:left;"><a tabindex="-1" class="lbx-zeni" href="../resources/zeni/zClass.html">zClass</a></li>
              </ul>
                      
                      </li>
                     
                      </ul>
   	   	  	  		</div>
              
              </nav>
            </header>
        <!--End Header Container-->
  <div class="sub-nav">
    <div class="f-l"><strong class="text-size-px12 font-Signika blue"><a href="#">My Courses </a> > </strong><strong class="light-gray text-size-px12">Create New Course </strong></div>
   
   <div id="createnav">
    <ul class="dropdown nav">
     <li style="border-right:none; margin-top:-5px;"><a href="#" class="light-blue"><img width="10" height="10" alt="add more" src="../resources/images/plus.png"></a> </li>   
    <li><a href="publish.html">Publish</a> </li> 
  <li><a href="defineengagement.html">Manage</a></li>  

</ul>  
  </div>
  </div>
  <!--Main Content-->
  <section>
    <div class="section"> 
   

      <div class="col-create" style="width:1000px;">
              <div  class="for-rounded-box  all-box-shadow white-bg">
     
         
 
	<!--Wizard start-->
<div id="page-wrap">

	  <ul class="breadcrumb" style="padding:1px;">
	    <li><a  href="${createcourselink}" style="width:120px; text-align:center; "><span>1. </span> Define Course</a></li>
			<li><a href="${associatecontentlink}" style="text-align:center;  ">2. Associate Content</a></li>
			<li><a href="${enrichcontentlink}" style=" width:120px; text-align:center;">3. Enrich Content</a></li>
			<li><a  href="${assignmentlink}" style=" width:130px; text-align:center; color:#960;">4. Define Assignment</a></li>
			<li><a href="defineplanner.html" style=" text-align:center;">5. Define Planner</a></li>
			<li><a href="defineplaybook.html"  style="text-align:center;">6. Define Playbook</a></li>
			<li><a href="definesocialize.html" style="width:120px; text-align:center;">7. Socialize Course</a></li>
			<li></li>
           <!--<li><a href="#">Hidden</a></li>-->
	  </ul>
	
</div>
<!--Wizard end  -->    
 
<!------------------------------------------------------Assignment.Test ------------------------------->

 <div class="assignment"  style="min-height: 1050px;">

 <div class="definecontainer" style=" float:left;">
    <p><b>Right click menu / keyboard navigation / Drag n drop / add / delete / Tooltip / events on right panel</b></p>
          
     <div id="splitter" style='clear:both; width:915px;'>
   
    <div id='jqxWidget' >
        
        <div id='jqxTree' style='float: left;'>
           <ul>
                <li id="rootLi"><img style='float: left; margin-right: 5px;' src='../resources/images/tree.png' id="imgRoot" />Assignment</li>
            </ul>
        </div>
        
         <div id='jqxMenu'>
            <ul>
                <li><img src="../resources/images/plus.png" alt="Add" height="10" width="10"  style=" margin-right:5px;  margin-left:-5px;" />Define Assignment</li>
                  <li><img src="../resources/images/define.png" alt="Define" height="10" width="10"  style=" margin-right:5px;  margin-left:-5px;"/>View Assignment</li>
                   <li><img src="../resources/images/edit.png" alt="Edit" height="10" width="10"  style=" margin-right:5px;  margin-left:-5px;"/>Add Test</li>
                    <li><img src="../resources/images/plus.png" alt="Delete" height="10" width="10" style=" margin-right:5px; margin-left:-5px;"/>Associate Question</li>
                      	 <li><img src="../resources/images/cross.png" alt="Delete" height="10" width="10" style=" margin-right:5px; margin-left:-5px;"/>Delete Assignment</li>
             </ul>
        </div>     
        
       
       </div> 
       
       <div id="ContentPanel" style=" font-size:11px;">
       <br>
        </div>
    
    </div>  <!-- end tree function -->
    <br/>
    <br/>
   <a class="btn btn-info f-r"  id="saveBottomAssociate" style=" margin-right:-250px;" >Save and Continue</a>  
        
   </div>  
 
</div>



         
    
<!--End Center Container--> 
      
  </div>
    </div>
    </div>
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
</body>
</html>
