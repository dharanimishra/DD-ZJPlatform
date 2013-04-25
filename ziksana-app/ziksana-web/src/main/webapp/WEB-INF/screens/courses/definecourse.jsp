<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Define Course</title>
<!--Body Style sheet-->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script type="text/javascript" src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<link href="../css/main/styles.css" rel="stylesheet" type="text/css"/>
<link href="../css/main/type-setting.css" rel="stylesheet" type="text/css"/>
<link href="../css/main/effects.css" rel="stylesheet" type="text/css"/>
<link href="../css/main/nav.css" rel="stylesheet" type="text/css"/>
<link href="../css/main/coursecreationnav.css" rel="stylesheet" type="text/css"/>
<link href="../css/common/wizard/wizardstylesheet.css" rel="stylesheet" type="text/css"/>
<link href="../css/common/spinner/smartspinner.css" rel="stylesheet" type="text/css"/>
<link href="../css/common/tags/superbly-tagfield.css" rel="stylesheet" type="text/css"/>
<link href="../css/common/search/search.css" rel="stylesheet" type="text/css"/> 
<link href="../css/common/validation/validation.css" rel="stylesheet" type="text/css"/>
<link href="../js/ui/jquery.fancybox-1.3.4.css" media="screen"  rel="stylesheet" type="text/css" />
<link href="../js/tree/styles/styleTree.css" rel="stylesheet" type="text/css" /> 
<!-- for the layout of the tree -->
<!--End Body Style sheet-->
<script type="text/javascript" src="../js/ziksana/jquerylibrary/main/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="../Dynamicjsonjs/Addmoduledynamicjson.js"></script>
<script type="text/javascript" src="../js/ziksana/jquerylibrary/common/table/tablerow.js"></script> 
<script type="text/javascript" src="../js/ziksana/jquerylibrary/common/search/search.js"></script>
<script type="text/javascript" src="../js/ziksana/ckeditor/adapters/jquery.js"></script>
<script type="text/javascript" src="../js/ziksana/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="../js/ziksana/jquerylibrary/common/spinner/smartspinner.js"></script>
<script type="text/javascript" src="../js/ziksana/coursecreation/define.js"></script>
<!-- scripts for tree -->   

<!-- End tree -->
<script src="../js/ui/jquery.mousewheel-3.0.4.pack.js" type="text/javascript" ></script>
<!-- <script src="../js/ui/jquery.fancybox-1.3.4.pack.js" type="text/javascript"></script> -->
<script src="../js/custom/libraryfunction.js" type="text/javascript"></script>
<script src="../js/ziksana/jquerylibrary/common/tags/superbly-tagfield.min.js"  type="text/javascript"></script>
<script src="../js/ziksana/validation/jquery.validationen.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/ziksana/validation/jquery.validation.js" type="text/javascript" charset="utf-8"></script>

   <!--fancybox-->
  <link rel="stylesheet" type="text/css" href="../fancybox/jquery.fancybox.css" media="screen" />
  <script type="text/javascript" src="../fancybox/jquery.fancybox.pack.js"></script>
  <!--fancybox end--> 

<script src="../js/custom/z_plugins.js"></script>
<script src="../js/custom/z_common.js"></script>
<script src="../launcher_resources/custom.js" type="text/javascript"></script> 


<style>

.selectedTreeRow
{
border-color:#27b; background: #6D9EC5; color:#fff;
font-weight:bold;
-moz-border-radius: 3px;
-webkit-border-radius: 3px;
border-radius: 3px;	
padding-top:-2px;
padding-bottom:-2px;
padding-left:3px;
padding-right:3px;
}


span.standartTreeRow:hover
{
background: rgba(85, 142, 187, 0.63);
color:#fff;	
-moz-border-radius: 3px;
-webkit-border-radius: 3px;
border-radius: 3px;
padding:3px;
}

.definecontainer
{
width: 925px;
padding: 0;
margin: auto;
padding-bottom:15px;
}

</style>
</head>

<body onLoad="self.scrollTo(0,0)">
	
<div id="wrapper"> 
        <!--Header Container-->
		<p><a><img data-launcher="" src="../images/ziksana_button_logo.png" width=120px height=120px style="position: absolute;top:3px;  left:30px; margin-left:0px;  "/></a></p>
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
                <div class="topnav" ><a href="#" class="signin wite bold"><span class="text-size-px9 wite bold">My Account</span></a> </div>
                <fieldset id="signin_menu">
                 <ul>
                   <li><a href="#">Preferences</a></li>
                   <li><a href="#">Privacy</a></li>
                   <li><a href="../login/login.html">Sign Out</a></li></ul>
                </fieldset>
              </div>
            </div>
          </div>
        </div>
            <nav>
			<div class="menu" style=" margin-left:-175px;">
                      <ul>
                        <li><a href="../educatorHomepage.html" class="current">My Home</a><div class="nav-line"></div></li>
                        <li><a href="../mylearningprogram.html">My Programs</a><div class="nav-line"></div></li>
                        <li><a href="#">My Students</a><div class="nav-line"></div></li>
                        <li><a href="../locker/lockerindex.html" style="margin-left:-10px;">My Locker</a></li>
                      </ul>
                    </div>
					
                
              </nav>
            </header>
        <!--End Header Container-->
  <div class="sub-nav">
    <div class="f-l"><strong class="text-size-px12 font-Signika blue"><a href="#">My Courses </a> > </strong><strong class="light-gray text-size-px12">Create New Course </strong></div>
    <div class="f-r"><strong class="text-size-px14 light-gray"><a href="#">Publish</a> | <a href="#">Manage</a></strong><a class="light-blue" href="#"><img width="12" height="12" alt="add more" src="../images/plus.png"> </a></div>
  </div>
  <!--Main Content-->
 
  <section>
    <div class="section"> 
    
		

      <div class="col-create" style="width:1000px;">
              <div  class="for-rounded-box  all-box-shadow white-bg">
         
         
 
	<!--Wizard start-->
<div id="page-wrap">

	<div id="uplpcontainer" class="all-box-shadow">
     
 
     
          <div id="lpcontainer">
       
     <div class="bordertop"> </div> <!--end of bordertop-->
       <div id="buildtab" class="lpboxtab1 all-box-shadow dummy" style="border-bottom-color:#c60; border-bottom-width:2px;">  
   
      <div class="tbboxhead dummy" >
      
    <p class="dummy"> <img src="../images/icons/toola.png" class="tbboximg"/><span class="tbboxheadfnt dummy"> Define </span>  </p>
      
      </div> <!--end of tbboxhead  -->   
         
     <div class="tbboxnum dummy">
   
      <span class="badge1 badge-warning dummy" style="font-size:20px;"> 1. </span>
      </div> 
      <!--end of tbboximg  --> 
       
     <div class="tbboxdesc dummy">
      
    <p class="dummy">Create the course structure and course content </p>
      
      </div> <!--end of tbboxdesc  -->      
           
          
               </div> 
          <!--end of lptab1-->
         
        
        
        <div id="enrichtab" class="lpboxtab1">
           
   
      <div class="tbboxheadds">
      
    <p> <img src="../images/icons/review.png" class="tbboximgds"/><span class="tbboxheadfntds"> Enrich </span>  </p>
      
      </div> <!--end of tbboxhead  -->   
   
       
     <div class="tbboxnumds">
   
      <span class="badge1ds" style="font-size:20px;"> 2. </span>
      </div> 
      <!--end of tbboximg  --> 
      
   
     
     <div class="tbboxdescds">
      
    <p>Personalize and enrich your content </p>
      
      </div> <!--end of tbboxdesc  -->      
           
               </div> 
          <!--end of lptab1-->
          
          
       <div id="publishtab" class="lpboxtab1">
      
      <div class="tbboxheadds">
      
    <p> <img src="../images/icons/publish1.png" class="tbboximgds" /><span class="tbboxheadfntds"> Publish </span>  </p>
      
      </div> <!--end of tbboxhead  -->   
   
       
     <div class="tbboxnumds">
   
      <span class="badge1ds badge-warningds" style="font-size:20px;"> 3. </span>
      </div> 
      <!--end of tbboximg  --> 
        
     <div class="tbboxdescds">
     <p>Publish the course created </p>
      
      </div> <!--end of tbboxdesc  -->      
           
               </div> 
          <!--end of lptab1-->
       
       
     
             </div> 
          <!--end of lpcontainer-->
          
     </div>   <!--end of uplpcontainer-->
     
          
     <div class="ClearFix"> </div>   
  
  
  
  
  
  
  	


      <div class="arrow1"> </div>
      
      
      <div id="subnavlink">


<!--<div class="linkinside">-->


<div class="navheadlp">
 
 <ul>
 <li style="margin-left:40px; color: #0a91ac;"> Describe Course </li>
 <li> Define Structure </li>
 <li> Associate Content </li>
 <li> Define Assignment </li>
 
 </ul>
 
 </div> <!--end of navheadlp-->
 
 
 <div class="ClearFix"> </div>


<input type="radio" class="radio" name="progress" value="five" id="five" checked>
    
    <div class="progress">
      <div class="progress-bar"></div>
    </div>
    
    
  
 
  <div class="ClearFix"> </div>      

 <div class="navnumber">
 
 <ul>
   
   <li>
    <div class="circle-outer1">
    <a class="circle orange1" href="definecourse.html">1</a>
    </div><!--circle-outer ends here-->
    
    </li>
   
   <li>
    <div class="circle-outer">
    <a class="circle orange" href="definestructure.html">2</a>
    </div><!--circle-outer ends here-->

   </li>
   
   <li>
    <div class="circle-outer">
    <a class="circle orange" href="associatecontent.html">3</a>
    </div><!--circle-outer ends here-->

   </li>
   
    <li>
    <div class="circle-outer">
    <a class="circle orange" href="defineassignment.html">4</a>
    </div><!--circle-outer ends here-->

   </li>


</ul>
 </div> <!--end of navnumber-->
 
 <div class="ClearFix"> </div>
 
 
 
 
</div>
      
      <!--End of the Navigation-->
	<div class="headlp">
   
     <p class="lpfrmhead">  <img src="../images/icons/helpicon.png" align="left"															      style="padding-left:5px; margin-right:4px; margin-top:-8px;" />  Provide Course Details</p> 
     
    </div>
	
</div>
<!--Wizard end  -->    
 
<!--start of first Tab -->
      
     <input type="hidden" id="firstformcourseid" /> 
<div class="definecontainer all-box-shadow" id="definetab">



			<form id="DegineCourse" class="form-horizontal formular" action="definestructure.html" style="margin-bottom:0;">
            
			 <br />
		
<!--		<div class="definehelp" style="width:900px; font-family:Helvetica; font-weight:bold; color:#125F92;">Provide Course Details</div>
-->
<!----------------- start of first container --------------->
		<div class="_coursename">
       	<div class="control-group">
         		
 <label class="control-label labelclass " for="CourseName" style="margin-top:-4px; font-weight:bold; ">Course Name :</label>
     	<div class="controls">
      <input type="text" autofocus class="defaultvaluem treeRoot validate[required,custom[onlytree]] "  id="defaultvalue" style="width:240px; margin-left:10px; color:#666;" tabindex="1" placeholder="Model Thinking" />
    	</div>
        
<br />
<label for="coursedescription"  class="labelclass" style="font-weight:bold;"><b>Course Description :</b></label>
<a class="f-r _plainText"  href="#linkurl" style="text-decoration:none;">Plain Text Editor</a>
<a class="f-r _richText"  href="#linkurl" style="text-decoration:none;">Rich Text Editor</a>
<textarea cols="124" rows="8" id="Cdescription" class="_plainTextShow defaultvaluem labelclass validate[required]"  style="width: 880px; color:#666;">We live in a complex world with diverse people, firms, and governments whose behaviors aggregate to produce novel, unexpected phenomena. We see political uprisings, market crashes, and a never ending array of social trends. How do we make sense of it?
Models. Evidence shows that people who think with models consistently outperform those who don t. And, moreover people who think with lots of models outperform people who use only one.
Why do models make us better thinkers?
Models help us to better organize information  to make sense of that fire hose or hairball of data (choose your metaphor) available on the Internet. Models improve our abilities to make accurate forecasts. They help us make better decisions and adopt more effective strategies. They even can improve our ability to design institutions and procedures. In this class, I present a starter kit of models: I start with models of tipping points. I move on to cover models explain the wisdom of crowds, models that show why some countries are rich and some are poor, and models that help unpack the strategic decisions of firm and politicians.
</textarea>
<br/>
<div class="_richTextShow"><textarea id="Cdescriptionrte" name="editor1pageload" class="defaultvalue _focus validate[required]" ><b>Describe the Course being created</b></textarea></div>
   <script type="text/javascript">
	CKEDITOR.replace( 'Cdescriptionrte' );
	</script>
	
    	</div>   <!-- end of coursename--->
		</div>    <!-- end of control group--->

<!----------------- start of second container --------------->
		<div class="_secondcontainer">
		<div class="control-group">
<div>
<label class="labelclass" style="font-weight:bold;"> Course Area : </label>
<label class="labelclass" style="margin-left:120px; font-weight:bold; "> Course Subject: </label>
<label class="labelclass" style="margin-left:100px; font-weight:bold;"> Course Topic: </label>
</div>
		<div class="moduleselection">
<select name="Careaddl" id="Careaddl"  class="defaultvalue labelclass validate[required]" style="margin-right:15px; width:200px;"> 
<option value="">Science </option>
<option value="Computer science">Computer science </option> 
<option value="information and general works ">information and general works </option>
<option value="Philosophy and psychology">Philosophy and psychology </option>
<option value="Religion">Religion </option>
<option value="Social sciences">Social sciences </option>
<option value="Language">Language </option>
<option value="Technology and applied science">Technology and applied science </option>
<option value="Arts and recreation">Arts and recreation </option>
<option value="Literature">Literature </option>
<option value="History and geography">History and geography</option></select> 
<select name="Csubjectddl" id="Csubjectddl"  class="defaultvalue labelclass validate[required]" style="margin-right:15px; width:200px;"> 
<option value=""> Science </option>
<option value="mathematics">mathematics </option> 
<option value="Astronomy & Allied Sciences">Astronomy & Allied Sciences </option>
<option value="Physics">Physics </option>
<option value="Chemistry & Allied Sciences ">Chemistry & Allied Sciences </option>
<option value="Earth Sciences">Earth Sciences </option>
<option value="Paleontology; Paleozoology">Paleontology; Paleozoology </option> 
<option value="Life sciences">Life sciences </option>
<option value="Plants">Plants </option>
<option value="Zoological sciences/Animals">Zoological sciences/Animals </option></select>  
<select name="Ctopicddl" id="Ctopicddl"  class="defaultvalue labelclass validate[required]"style="width:200px;"> 
<option value="">Theory and Research </option>
<option value="Physiology">Physiology </option>
<option value="Biochemistry ">Biochemistry </option>
<option value="Physiological systems of animals">Physiological systems of animals </option>
<option value="Not assigned or no longer used">Not assigned or no longer used </option>
<option value="Physiological systems of plants">Physiological systems of plants </option>
<option value="Genetics and evolution ">Genetics and evolution </option>
<option value="Ecology">Ecology </option>
<option value="Natural history of organisms">Natural history of organisms </option>
<option value="Microorganisms">Microorganisms </option>
<option value="fungi ">fungi </option>
<option value="algae">algae </option>
</select>   
		</div>  <!-- end of moduleselection--->

		<div class="coursetags">
<br />
<label class="control-label labelclass" for="coursetags" style="margin-top:-2px; font-weight:bold;">Specify any tags : </label>
  <input type="text" autofocus class="defaultvaluem treeRoot"  id="defaultvalue" style="width:240px; margin-left:10px; color:#666;" tabindex="1" value="Model Thinking, Decision Models" />
 <br />
	<br />
		</div> <!-- end of coursetags--->

		<div class="coursecredits">
<label for="coursetags" class="labelclass" style="font-weight:bold;">Specify Course Credits :</label>
<input type="text" id="Credits" class="smartspinner validate[required]"   style="margin-left:18px;" />  
<script type="text/javascript" src="../js/spinner/smartspinner.js"></script>
<script type="text/javascript">
        $(document).ready(function() {
            var s =  $('#Credits').spinit({ height: 20, width: 30, min: null, placeholder:null, initValue:10, max: 20,  });        

        });
    </script>
<label for="coursetags" class="labelclass" style="margin-left:20px; font-weight:bold;">Specify Course Extra Credits :</label>
<input type="text" id="ExtraCredits"  class="defaultvalue validate[required]" style="width:30px; margin-left:10px;" />
<script type="text/javascript">
        $(document).ready(function() {
            var s =  $('#ExtraCredits').spinit({ height: 20, width: 30, min: null, initValue:0, max: 20,  });        

        });
    </script>
		</div> <!-- end of coursecredits--->

		<div class="courseduration">
<br />
<label for="coursetags" class="labelclass" style="font-weight:bold;">Specify Course Duration :</label>
<input type="text" id="Duration" style="width:30px; margin-left:9px;" class="defaultvalue validate[required]"  />
<script type="text/javascript">
        $(document).ready(function() {
            var s =  $('#Duration').spinit({ height: 20, width: 30, min: null, initValue:15, max: 20,  });        

        });
    </script>
<select name="SelectArea" id="Cdurationtype" class="defaultvalue" style="margin-left:20px;"> 
     <option value="week">Weeks</option>
      <option value="month">Months</option>
      <option value="day">Days</option>
         
</select>
 
		</div> <!-- end of courseduration--->

		<div class="addinformation">
<a class="lbx-addnew" id="_addNewInfo"  href="../library/AddNewInformation.html">Add New Information </a>
		</div>
		</div> <!-- end of secondcontainer--->
		</div> <!-- end of control group--->


<!----------------- start of third container --------------->
		<div class="_thirdcontainer">
		<div class="contentsecurity">

             <img id="aSide" src="../images/tipsy-east.gif" align="left" style=" height:10px; width:10px; margin-top:5px; cursor:pointer;" title="View Requirements"/>
             <img id="aDown" src="../images/tipsy-south.gif" align="left" style=" height:10px; width:10px; margin-top:5px; cursor:pointer;" title="Hide Requirements"/>
             <p class="labelclass" style=" margin-left:15px; font-weight:bold;"> Define Video Content Security requirements </p>
            <br>
            <div id="showSecurity">
                <input type="checkbox" name="Chksecuritylogo" id="Chksecuritylogo" class="labelclass" value="Institution Logo"  style="margin-left:20px;" /> <span class="labelclass" style="padding-left:5px;">Institution Logo? </span>
                <input type="checkbox" class="labelclass" name="Chksecuritysignature" id="Chksecuritysignature" value="your Signature"   style="margin-left:20px;"/><span class="labelclass" style="padding-left:5px;">Your Signature? </span>
                <input type="checkbox" name="Chksecuritywatermark" id="Chksecuritywatermark" class="labelclass" value="Floating Watermark"   style="margin-left:20px;" ><span class="labelclass" id="watermarktxt" style="padding-left:5px;">Floating Watermark? </span></input>
                
			</div>
       
		</div> <!-- end of contentsecurty--->
		

		
		<div class="associateimage" style=" margin-top:30px;">
        
      <p class="labelclass" style="font-weight:bold;">Associate an Image for your Course </p> <br/>
              
       		     
      
<img src="../images/modelthinking.png" alt="Modelthinking" width="94" height="94" border="3"  style="border:2px solid #ccc;"/>


<input type="file" id="Cimageupl" style="margin-left:20px;" />
<a href="#linkurl" id="cancellink"><img src="../images/delete.jpg"/>Cancel</a>

<!--<script language="javascript">
 $(document).ready(function() {
$("#cancellink").click(function (event) {
	window.location.href = "modelthinking.html";
});
	
	 });

</script>-->

<div id="tempdiv">
</div>


</div> <!-- end of associateimage--->
	
    </div> <!-- end of third container--->
    
    <div class="sbtbtn">	
<a href="definestructure.html" class="btn btn-info f-r" >Save and Continue</a>
</div><!--End of sbtbtn -->
<div class="ClearFix"></div>
</form>
 
    </div>
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
    
  
</body>
</html>
