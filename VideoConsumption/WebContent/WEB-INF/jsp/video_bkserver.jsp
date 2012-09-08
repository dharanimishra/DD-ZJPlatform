<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page session="true" %>
<%@ page import="com.springs.domain.FileVO" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
	<head>
	<title>Couse - Model Thinking</title>
<link rel="stylesheet" type="text/css" media="screen" href="css/basic-styles.css"/>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<!--Body Style sheet-->
<link href="css/styles.css" rel="stylesheet" type="text/css"/>
<link href="css/type-setting.css" rel="stylesheet" type="text/css"/>
<link href="css/effects.css" rel="stylesheet" type="text/css"/>
<link href="css/nav.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="css/custom-theme/jquery-ui-1.8.21.custom.css">
<link rel="stylesheet" type="text/css" href="css/custom-theme/old-jquery-ui-1.8.21.custom.css">
	<!--End Body Style sheet-->
<!-- fix. IE 6-->
<script>
  document.createElement('header');
  document.createElement('nav');
  document.createElement('section');
  document.createElement('article');
  document.createElement('aside');
  document.createElement('footer');
</script>
<script>
var coursevideo = true;
var MouseOver = false;
$(document).ready(function(){
	$('.tabContent').find('.tabss:eq(1)').css('display', 'block');
	$('.tabsTwo a').click(function(){
		var _loc_0 = ($(this).parent().index());
		$('.tabsTwo').find('a').each(function(){$(this).parent().removeClass('selected')});
		$(this).parent().addClass('selected');
		$('.tabContent').find('.tabss').each(function(){$(this).css('display', 'none');});
		$('.tabContent').find('.tabss:eq('+_loc_0+')').fadeIn('fast');
	});
	$('.imgLarge').click(function(){
		$(this).parent().hide();
		$(this).parent().prev().show();
	});
	$('.imgSmall').click(function(){
		$(this).parent().hide();
		$(this).parent().next().show();
	});
	$('.videoItem').click(function(){
		if($(this).find('div:eq(0)').hasClass("selected"))return;
		$(this).parent().find('.videoItem').each(function(){
			$(this).find('div:eq(0)').removeAttr("class").attr("class", "videoImg normal");
		})
		$(this).find('div:eq(0)').removeAttr("class").attr("class", "videoImg selected");
		$('#videoSection').empty();
		var _loc_0 = $(this).index();
	});
	$("#listen-text").hide();
	$("#listen").click(function(){jwplayer().play();$("#listen-text").toggle();});
});
$(function() {
	   $('a.link').click(function() {
	       $('a.link').removeClass('active');
	       $(this).addClass('active');
	   });
	});
function displayVideo(videoName, videoPath){
	//window.contextPath = (($.browser.mozilla && $.browser.version.slice(0,3) >= "1.9" ) || $.browser.msie) ? videoPath : "http://localhost:8080/UTD/" + videoPath;
	//jwplayer().load({file: contextPath + videoName, image:'thumbs/Video-1.jpg'}); 
	//jwplayer().play();
	jwplayer().load({file: "http://metest.in:8080/UTD/videos/" + videoName, image:'thumbs/Video-1.jpg'}); 
	jwplayer().play();
}

function displayExternalVideo(){
	jwplayer("videoSection").seek('3');
	jwplayer("videoSection").pause(true);
	jwplayer("videoSection").load({file: 'http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4', image:'thumbs/Video-1.jpg'}); 
	//jwplayer("videoSection").play();
}

function clean() {
	$('#description').val('');
	$("input#bookmarkTitle").val('');
	$('.textArea').attr('readonly', false);
	$("input#bookmarkTitle").attr('readonly', false);
	var imageHtml = '<div class="icons"><img src="images/pencil.png" width="16" height="16" /></div><div class="icons"><a href="#" onclick="doAjaxPost();"><img src="images/disk.png" width="16" height="16" /></a></div>';
	 $('.iconMain').html(imageHtml);

	
}

function doAjaxPost() {
	        // get the form values
	        var name = (jwplayer().getPlaylistItem()["file"]).split("videos/")[1];
	        var description = String($('#textArea').val());
	        var time = jwplayer().getPosition();
	        var bookmarkTitle = String($("input#bookmarkTitle").val());
	        $.ajax({
	        type: "POST",
	        url: "/UTD/video.htm",
	        data: "name=" + name + "&description=" + description + "&time=" + time + "&bookmarkTitle=" + bookmarkTitle ,
	        error: function(e){
	        	$('#textArea').val('');
	        	$("input#bookmarkTitle").val('');
	        }
	        });
	        jwplayer().play();
 }

function doUpdatePost(videoId, description, time, bookmarkTitle) {
	 var name = (jwplayer().getPlaylistItem()["file"]).split("videos/")[1];
     var description = String($('#textArea').val());
     var bookmarkTitle = String($("input#bookmarkTitle").val());
     $.ajax({
     type: "POST",
     url: "/UTD/video.htm",
     data: "videoId=" + videoId + "&name=" + name + "&time=" + time + "&description=" + description + "&bookmarkTitle=" + bookmarkTitle  + "&update=" + "update",
     error: function(e){
     	$('#textArea').val('');
     	$("input#bookmarkTitle").val('');
     }
     });
     jwplayer().play();
}
</script>

<!-- end fix. IE 6-->
<!--jquery UI-->
<link rel="stylesheet" type="text/css" href="css/custom-theme/old-jquery-ui-1.8.21.custom.css">
    <link rel="stylesheet" type="text/css" href="css/custom-theme/jquery-ui-1.8.21.custom.css">
	<script src="development-bundle/jquery-1.7.2.js"></script>
	<script src="development-bundle/ui/jquery.ui.core.js"></script>
	<script src="development-bundle/ui/jquery.ui.widget.js"></script>
	<script src="development-bundle/ui/jquery.ui.button.js"></script>
    <script src="development-bundle/ui/jquery.ui.progressbar.js"></script>
<!--end jquery UI-->

	<script src="js/login/jquery.tipsy.js" type="text/javascript"></script>
    <script src="js/custom.js" type="text/javascript"></script>
    <script src="js/jquery.cookie.js"></script>
    <script src="js/jquery.collapse.js"></script>

	<script>
	$(function() {
		$( "#format" ).buttonset();
	});

	$(function() {
		$( "#progressbar" ).progressbar({
			value: 37
		});
	});
	</script>

	<!-- <script type="text/javascript">
	$(document).ready(function(){
	$("#listen").click(function () {
	$("#listen-text").toggle();
});
});

</script> -->
	<!-- End Login -->
	</head>
	<body>
    <div id="wrapper"> 
     
      <!--End Header Container--> 
	 <!--Header Container-->
      <header class="bottom-box-shadow">
        <div id="topheader"> 
          <!--logo container-->
          <div id="logo"><a href="#"><img src="images/logo.jpg" width="189" height="50"></a></div>
          <!--end logo container-->
          <div id="status-container">
            <div id="status-icons" class="bottom-box-shadow , two-bottom-rounded-box">
              <ul>
                <li><a href="#" id="email-icon"><span class="wite-title">333333</span></a></li>
                <li><a href="#" id="alart-icon" class="orange-bc"><span class="wite-title">344444</span></a></li>
                <li><a href="#" id="amount-icon" class="blue-bc"><span class="wite-title">355500</span></a></li>
                <li><a href="#" id="peoples-icon" class="orange-bc"><span class="wite-title">3333333</span></a></li>
              </ul>
              <div > </div>
            </div>
            <div id="account-container" class="two-bottom-rounded-box">
              <div id="container">
                <div id="topnav" class="topnav"><a href="login" class="signin"><span class="wite-title2">My Account</span></a> </div>
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
          <div id="menu" >
            <ul>
              <li><a href="#">Tackboard</a>
                <div class="nav-line"></div>
              </li>
              <li><a href="#" class="current">Courses</a>
                <div class="nav-line"></div>
              </li>
              <li><a href="#">Grades</a>
                <div class="nav-line"></div>
              </li>
              <li><a href="#">Locker</a></li>
            </ul>
          </div>
          <!--End menu-->
          <div id="searchpanel">
            <form name="form1" method="post" action="">
              <input type="text" name="search" id="search" placeholder="Search..." autosave="unique" class="two-left-rounded-box , two-right-rounded-box">
              <input id="search-submit" type="submit" value="Submit">
            </form>
          </div>
          <div id="searchoptions">
            <ul>
              <li id="srch-op-a"><a href="#"></a></li>
              <li id="srch-op-b"><a href="#"></a></li>
              <li id="srch-op-c"><a href="#"></a></li>
            </ul>
          </div>
        </nav>
      </header>
      <!--slogen-->
      <div id="sub-nav" >
        <div class="f-l"><strong class="a-b"><a href="#">Course Name </a> </strong><strong class="a-b, light-blue">1. Model Thinking </strong></div>
        <div class="f-r"><strong class="a-b">|<a href="#"> Course Blog</a> |   <a href="#">Tasks  & assignments</a> |   <a href="#">Grades</a> |   <a href="#">Calendar</a> |   <a href="#">Playbook</a></strong> </div>
      </div>
      <!--End slogen--> 
      <!--Main Content-->

      <section>      
		
		<div id="book-container"> 
	
				<div id="book-chapter"> 
					<div id="book-index">
					 <p class="titles-info1">Chapters</p>
					 <br/>
					 <p class="user-name-w1">1. MODEL THINKING</p>

					 <ul>
							<li class="user-name-w2">1.1 Why Model Thinking
								<ul class="user-name-w2" id="chapter" >
									<li><a href="#" onclick="displayVideo('Why_Model.mp4','videos/');">1.1.1 Why Model</a></li>
									<li><a href="#" onclick="displayVideo('Intelligent_Citizens.mp4','videos/');">1.1.2 Intelligent Citizens of the World</a></li>
								</ul>
							</li><br/>
							<li class="user-name-w2" >1.2 Aggregation
								<ul class="user-name-w2" id="chapter">
									<li><a href="#" onclick="displayVideo('Aggregation.mp4','videos/');">1.2.1 Aggregation</a></li>
									<li><a href="#" onclick="displayVideo('Six_Sigma.mp4','videos/');">1.2.2 Six Sigma</a></li>						
								</ul>
							</li><br/>
							<li class="user-name-w2" >1.3 Decission Models
								<ul class="user-name-w2" id="chapter">
									<li><a href="#" onclick="displayVideo('Intro_Decision_Making.mp4','videos/');">1.3.1 Introduction to Decission Making</a></li>
									<li><a href="#" onclick="displayVideo('Probability.mp4','videos/');">1.3.2 Probability: The Basics</a></li>			
								</ul>
							</li><br/>
						</ul>
					</div>
					<div id="book-vedio">
						<div id="play-vedio">
							<div  id="videoSection">
    <!-- START OF THE PLAYER EMBEDDING TO COPY-PASTE -->
	</div>
	 <script type="text/javascript">
		var player  = null;
		function playerReady(obj) 
		{
			player = document.getElementById(obj['id']);
			player.setOverlay('overlay1', 'UT DALLAS', 'l,t');
			player.sendEvent('REDRAW');
		};
		
		function editBookMark(videoId, description, time, bookmarkTitle) {
			 $('.textArea').attr('readonly', false);
        	 $("input#bookmarkTitle").attr('readonly', false);
        	 var imageHtml = '<div class="icons"><img src="images/pencil.png" width="16" height="16" /></div><div class="icons"><a href="#" onclick="doUpdatePost(\''+videoId+'\',\''+description+'\',\''+time+'\' , \''+bookmarkTitle+'\');"><img src="images/disk.png" width="16" height="16" /></a></div>';
        	 $('.iconMain').html(imageHtml);
		};
		
		function  displayBookMark(videoId, description, time, bookmarkTitle) {
			if(videoId != null && time != null) {
				$("#listen-text").show();
				$('.textArea').val(description);
				$('#bookmarkTitle').val(bookmarkTitle);
				 $('.textArea').attr('readonly', true);
	        	 $("input#bookmarkTitle").attr('readonly', true);
	        	 var imageHtml = '<div class="icons"><a href="#" onclick="editBookMark(\''+videoId+'\',\''+description+'\',\''+time+'\' , \''+bookmarkTitle+'\');"><img src="images/pencil.png" width="16" height="16"/></a></div><div class="icons"><img src="images/disk.png" width="16" height="16"/></div>';
	        	 $('.iconMain').html(imageHtml);
	        	 jwplayer().seek(time);
				jwplayer().pause(true);
			}
		};
    </script>
	<script type="text/javascript" src="jwplayer/jwplayer.js"></script>
	<script type="text/javascript">
	 var description;
	 var time;
	 var name;
	 var bookmarkTitle;
	 var videoID;
	 var counter = 0;
	 var oldTime = 0;
	 
	 jwplayer("videoSection").setup({
			flashplayer: "jwplayer/player.swf",
			file: '${files[0].filePath}'+'${files[0].fileName}',
			image:'thumbs/Video-1.jpg',
			'stretching': 'fill',
			'controlbar': 'over',
			'width': '550',
			'height': '335',
			'plugins': 'jwplayer/Textmark.swf' 
		});
	 	  
	  jwplayer("videoSection").onTime(function() {
				var maxPosition;
				if(time == "0.50") {
					maxPosition = "1";
				} else {
					maxPosition = time + ".20";
				}
				if(jwplayer().getPosition() >= time && jwplayer().getPosition() <= maxPosition && oldTime != time) {
					displayBookMark(videoID, description, time, bookmarkTitle);
					oldTime = time;
				} else {
					$("#listen-text").hide();
					$('.textArea').val('');
				}
			});
		  
	 	  jwplayer("videoSection").onPlay(function() {  
			  name = (jwplayer().getPlaylistItem()["file"]).split("videos/")[1]; 
			  $.getJSON("<c:url value="/video.htm" />",{"name":name}, function(data) { 
			 if(jwplayer().getPosition() == 0){
				 counter = 0;
			 }
			 var link = null;
			 for ( var i = 0; i < data.length; i++) {
				 var timeValue = getAssignedTime(data[i].time.split(":"));
				 time = timeValue;
				 if(i == 0) {
					 link = '<a href="#" id=' +i +'  onclick="displayBookMark(\''+data[i].videoId+'\',\''+data[i].description+'\','+timeValue+' , \''+data[i].bookmarkTitle+'\');" style="margin-left: 5em;">'+data[i].bookmarkTitle+'</a><br/>';
				 } else {
					 link = link + '<a href="#" id=' +i +'  onclick="displayBookMark(\''+data[i].videoId+'\',\''+data[i].description+'\', '+timeValue+', \''+data[i].bookmarkTitle+'\');" style="margin-left: 5em;">'+data[i].bookmarkTitle+'</a><br/>';
				 }
			 };
			 if (link != null) {
				 $("#myworkcontent").html(link);
			 } else {
				 $("#myworkcontent").html(null);
				 videoID = null;
			 }
     	      for ( var i = counter; i < data.length; i++) {
		    	  	var timeSplit = data[i].time.split(":");
			         if(data[i].name == name) {
		        		 time = getAssignedTime(timeSplit);
			        	 videoID = data[i].videoId;
			        	 description = data[i].description;
			        	 bookmarkTitle = data[i].bookmarkTitle;
			        	 counter++;
			        	break;
			         }
			      };
			    }); });
	      
		 jwplayer("videoSection").onReady(function() { 
			 name = (jwplayer().getPlaylistItem()["file"]).split("videos/")[1]; 
			 }); 
		 jwplayer("videoSection").onComplete(function() { 
			 oldTime = 0;
		 });
		 function getAssignedTime(timesplit) {
			 var timeValue;
			 if(timesplit[0] != "00" ) {
				 timeValue = timesplit[0] + ".";
        	 }
        	 if(timesplit[1] != "00" ) {
        		 timeValue = timesplit[1] + ".";
        	 }
        	 if(timesplit[2] != "00" ) {
        		 timeValue = timesplit[2];
        	 }
        	 if(timesplit[2] == "00" ) {
        		 timeValue = "0.50";
        	 }
        	 return timeValue;
		 }
	</script>
	<!-- END OF THE PLAYER EMBEDDING -->
							<div id="write-listen"><img type="button" src="images/pencil1.jpg" id="listen" onclick="clean();"/>
							<img type="button" src="images/mike.jpg" onclick=""/>
					
							</div>
									<form:form commandName="file" action="/UTD/video.htm" id="fileForm">
								<div id="listen-text" >
									<div id="editbox">
									<b>Title:</b>
									<form:input path="bookmarkTitle" class="password-strength-title"/><br/><br/>
									<b>Notes:</b>
									<div class="textArea"><form:textarea path="description" id="textArea" cols="70" class="textArea" /></div>
								
									</div>
									
									<div id="Icondiv"> 
																												
											<div class="iconArea">
												<div class="iconMain">
													<div class="icons"><img src="images/pencil.png" width="16" height="16"/></div>
													<div class="icons"><a href="#" onclick="doAjaxPost();"><img type="button" src="images/disk.png" width="16" height="16"/></a></div>
												</div>
											</div>
										
									</div>

								<div id="dtext">
                        <div class="textArea" id="savetext" >
                          
                        </div>
								</div>

						
								</div>
								 </form:form>

						</div>

						<div id="lect-img"> <img src="images/professor.jpg">
						<p class="user-name-w2">
						Chritopher Bremner<br/>Assistant Professor

						</p>
						<div id="myworkholder">

						<div id="myworkcontent" />
						</div>
						</div>
					</div>
				</div>
		
		</div>
		<div id="section"> 
          <!--Left column-->
          <div id="col-lft" class="border-right">
            <p class="user-name"><a href="#">View Syllabus (TOC)</a></p>
            <p class="user-name"><a href="#">View My Notes</a></p>
            <div id="user-insight">
              <p class="titles-info">Items for today</p>
              <p class="document-icon"><a href="#" onclick="displayVideo('Game_of_Life.mp4','videos/');">Game Of Life</a></p>
              <p class="txt-r" style="padding-right:20px;"> <a href="#" class="icon-cal">Calendar</a></p>
              <p class="titles-info">Reference Material</p>
              <p class="document-icon"><a href="docs/Slides_L1.2.pdf" target="_blank">Material 1</a></p>
              <p class="document-icon"><a href="docs/Slides_L1.2.pdf" target="_blank">Material 2</a></p>
              <p class="titles-info">Related Videos</p>
              <p class="video-icon"><a href="#" onclick="displayVideo('Game_of_Life.mp4','videos/');">Game of life</a></p>
              <div id="user-contacts"> <span class="titles-info">Contacts</span> 
              <ul class="contact-list">
            <li class="member">
                  <div class="grey-out ">
                <div class="white-in contact-pic" style="background:url(images/user/2my-photo.png);"><a href="#"></a></div>
              </div>
                </li>
            <li class="member">
                  <div class="grey-out ">
                <div class="white-in contact-pic" style="background:url(images/user/2my-photo.png);"><a href="#"></a></div>
              </div>
                </li>
            <li class="member">
                  <div class="grey-out ">
                <div class="white-in contact-pic" style="background:url(images/user/2my-photo.png);"><a href="#"></a></div>
              </div>
                </li>
            <li class="member">
                  <div class="grey-out ">
                <div class="white-in contact-pic" style="background:url(images/user/2my-photo.png);"><a href="#"></a></div>
              </div>
                </li>
                    <li class="member">
                  <div class="grey-out ">
                <div class="white-in contact-pic" style="background:url(images/user/2my-photo.png);"><a href="#"></a></div>
              </div>
                </li>
                    <li class="member">
                  <div class="grey-out ">
                <div class="white-in contact-pic" style="background:url(images/user/2my-photo.png);"><a href="#"></a></div>
              </div>
                </li>
                    <li class="member">
                  <div class="grey-out ">
                <div class="white-in contact-pic" style="background:url(images/user/2my-photo.png);"><a href="#"></a></div>
              </div>
                </li>
          </ul>
           <p class="txt-r" style="padding-right:20px;"> <button class="search">People Search </button></p>
               </div>
            </div>
          </div>
          <!--End Left column--> 
          <!--Center Container-->
          
          <div id="center" class="for-rounded-box , all-box-shadow">
            <p class="titles-info">Notes and bookmarks 
            <div id="format">
              <input type="checkbox" id="check1" />
              <label for="check1">Mine</label>
              <input type="checkbox" id="check2" />
              <label for="check2">Educators</label>
              <input type="checkbox" id="check3" />
              <label for="check3">Everyones</label>
              </div>
<table  class="alt-table">
<thead>
            <tr>
                <th style="width:15%">Time</th>
                <th>Label</th>
            </tr>
        </thead>
        <tbody>
  <tr>
    <td >3:00</td>
    <td><a href="#">Take note of the functionality</a></td>
  </tr>
  <tr>
    <td >4:10</td>
    <td><a href="#">Something else</a></td>
  </tr>

  <tr>
    <td >5:09</td>
    <td><a href="#">Something else</a></td>
  </tr>
        </tbody>
</table>

              </p>
            <div id="class-talk">
              <p class="titles-info">Class talk<span class="rightof-title-info , blue">Show only</span></p>
              <img src="images/user/2my-photo.png" width="38" height="40" align="left" class="img">
              <p class="user-p"><span class="user-name">Jason Dechamp</span>Check out the blog '<span class="blue">Innovative Educational Technology</span>', its gives good ideas for our projects...gives good ideas for our projects...gives good ideas for our projects...</p>
              <div id="dash-bord">
                <div id="dash-bord-icon"> </div>
                <div id="dash-bord-bar"> </div>
                <div id="comments-container"> <img src="images/user/cocntacts-users.jpg" width="40" height="42" align="left" class="img2">
                  <p class="user-p"><span class="user-name">Jason Dechamp</span>Check out the blog '<span class="blue">Innovative Educational Technology</span>', its gives good ideas for our projects...</p>
                </div>
              </div>
            </div>
          </div>
          <!--End Center Container--> 
          <!--Right column-->
          <div id="col-right">
            <div id="col-right-container" class="for-rounded-box , all-box-shadow">
              <p class="titles-info">Progress</p>
          
	<div id="progressbar" class="ui-progressbar ui-widget ui-widget-content ui-corner-all" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="37">
<div class="ui-progressbar-value ui-widget-header ui-corner-left" style="width: 37%;"></div>
</div>
<span class="light-blue">37% complete</span>
              <div id="Performance">
          
                <p class="titles-info">Tests and assignments<br>
                </p>
                <div id="Performance-chart">
                  <p class="user-name-l"><em><a href="#">Assignment 10</a></em><strong class="completed">Completed</strong></p>
                  <p class="user-name-w"><em><a href="#">Assignment 10</a></em><strong class="date-time">06/26/12</strong></p>
                  <p class="user-name-l"><em><a href="#">Test10</a></em><strong class="test-time">06/26/12</strong></p>
                  <p class="user-name-w"><em><a href="#">Assignment 10</a></em><strong class="completed">06/26/12</strong></p>
                  <p class="titles-info">Alerts and reminders<br>
                  </p>
                  <p class="user-name-l"><em><a href="#">Calendar event</a></em><strong class="completed">06/26/12</strong></p>
                  <p class="user-name-w"><em><a href="#">Auto generated alert</a></em><strong class="completed">06/26/12</strong></p>
                  <p class="user-name-l"><em><a href="#">Class meetup</a></em><strong class="completed">06/26/12</strong> </p>
                </div>
              </div>
            </div>
          </div>
          <!--End Right column--> 
        </div>
      </section>
      <!--End Main Content--> 
      <!--Current Progress-->
      <div class="col , border-top">
        <div class="collapse">
          <h3 class="border-left , border-right , border-top">Your current progress  [ Starting ... ]</h3>
          <div>
            <p><code>N1</code></p>
            <p><code>N2</code></p>
            <p><code>N3</code></p>
            <p><code>N4</code></p>
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
			

        </script> 
      
      <!--End Current Progress--> 
      <!--Footer Container-->
      <footer> </footer>
      <!--End Footer Container--> 
    </div>
</body>
</html>
