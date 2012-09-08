<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page session="true"%>
<%@ page import="com.springs.domain.FileVO"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<title>Couse - Model Thinking</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="css/basic-styles.css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type='text/javascript' src='jwplayer/swfobject.js'></script>
<!--Body Style sheet-->
<link href="css/styles.css" rel="stylesheet" type="text/css" />
<link href="css/type-setting.css" rel="stylesheet" type="text/css" />
<link href="css/effects.css" rel="stylesheet" type="text/css" />
<link href="css/nav.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="css/tipsy.css"/>
<link rel="stylesheet" type="text/css"
	href="css/custom-theme/jquery-ui-1.8.21.custom.css">
	<link rel="stylesheet" type="text/css"
		href="css/custom-theme/old-jquery-ui-1.8.21.custom.css">
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
			$(document)
					.ready(
							function() {
								$("#listen-text-bookmark").hide();
								//$("#enrich_note").hide();
								$('.tabContent').find('.tabss:eq(1)').css(
										'display', 'block');
								$('.tabsTwo a')
										.click(
												function() {
													var _loc_0 = ($(this)
															.parent().index());
													$('.tabsTwo')
															.find('a')
															.each(
																	function() {
																		$(this)
																				.parent()
																				.removeClass(
																						'selected')
																	});
													$(this).parent().addClass(
															'selected');
													$('.tabContent')
															.find('.tabss')
															.each(
																	function() {
																		$(this)
																				.css(
																						'display',
																						'none');
																	});
													$('.tabContent').find(
															'.tabss:eq('
																	+ _loc_0
																	+ ')')
															.fadeIn('fast');
												});
								$('.imgLarge').click(function() {
									$(this).parent().hide();
									$(this).parent().prev().show();
								});
								$('.imgSmall').click(function() {
									$(this).parent().hide();
									$(this).parent().next().show();
								});
								$('.videoItem')
										.click(
												function() {
													if ($(this).find(
															'div:eq(0)')
															.hasClass(
																	"selected"))
														return;
													$(this)
															.parent()
															.find('.videoItem')
															.each(
																	function() {
																		$(this)
																				.find(
																						'div:eq(0)')
																				.removeAttr(
																						"class")
																				.attr(
																						"class",
																						"videoImg normal");
																	})
													$(this)
															.find('div:eq(0)')
															.removeAttr("class")
															.attr("class",
																	"videoImg selected");
													$('#videoSection').empty();
													var _loc_0 = $(this)
															.index();
												});
								$("#listen-text").hide();
								//$("#enrich_note").hide();
							});
			$(function() {
				getPlayList();
				$('a.link').click(function() {
					$('a.link').removeClass('active');
					$(this).addClass('active');
				});
			});

			function displayExternalVideo() {
				jwplayer("videoSection").seek('3');
				jwplayer("videoSection").pause(true);
				jwplayer("videoSection").load({
					file : 'http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4',
					image : 'thumbs/Video-1.jpg'
				});
				//jwplayer("videoSection").play();
			}
			function enableEditButton() {
				/*$("#listen").click(function() {
					jwplayer().play();
					$("#listen-text").toggle();
				});*/
			}

			function displayBookMarkSection() {
				$("#listen-text-bookmark").toggle();
				$('#bookmarklabel').val('');
				jwplayer().play();
			}
			function disableEditButton() {
				//$("#listen").click();
			}
			
			//Clean function is replaced by showVideoNoteForm();
			/*function clean() {
				$('#description').val('');
				$("input#bookmarkTitle").val('');
				$('.textArea').attr('readonly', false);
				$("input#bookmarkTitle").attr('readonly', false);
				var imageHtml = '<div class="icons"><img src="images/pencil.png" width="16" height="16" /></div><div class="icons"><a href="#" onclick="doAjaxPost();"><img src="images/disk.png" width="16" height="16" /></a></div>';
				$('.iconMain').html(imageHtml);
			}*/
			
			function showVideoNoteForm(){
				jwplayer().pause();
				$('#listen-text').fadeIn(); //show the form
				$('#listen-text').find('textarea, input[type="text"]').val('').removeAttr('readonly');
				$('#videoIdHid, #timeHid').val('');
				//collect time and video id.
				
			}

			  function showEnrichmentNoteForm(){
				 // alert("showEnrichmentNoteForm");
					jwplayer().pause();
					$('#enrich_note').fadeIn(); //show the form
					$('#enrich_note').find('input[type="text"]').val('').removeAttr('readonly');
					$('#videoIdHid, #timeHid').val('');
			  }

			  
			function onDeleteNotes(videoId,time,videoName) {
				jwplayer().pause();
				//alert("inside deleteNotesmethod");
				//alert("video length2 : " + videoId.trim().length);
				//alert( "videoId=" + videoId + " &time=" + time+" &videoName=" + videoName);
				var videoNameVal = $('#videoNameHid').val();
				//alert("videoNameVal : "+videoNameVal);
				var dataString = "";
				
				if(videoName!=null && videoName!=""){
					dataString="videoId=" + videoId + "&videoName=" + videoName + "&deleteBookmark=" + "deleteBookmark";
				}else{
					dataString="videoId=" + videoId + "&time=" + time + "&deleteNote=" + "deleteNote";
				}
				
				$.ajax({
					type : "POST",
					url : "/VideoConsumption/video.htm",
					data : dataString,
					error : function(e) {
						//alert("Error on delete Notes");
						//$('#textArea').val('');
						//$("input#bookmarkTitle").val('');
					}
				});
				jwplayer().play();
			}
			
			function onDeleteBookmark(videoId,time,videoName) {
				jwplayer().pause();
				//alert("inside onDeleteBookmark");
				//alert("video length2 : " + videoId.trim().length);
				//alert( "videoId=" + videoId + " &time=" + time+" &videoName=" + videoName);
				var videoNameVal = $('#videoNameHid').val();
				//alert("videoNameVal : "+videoNameVal);
				var dataString = "";
				$.ajax({
					type : "POST",
					url : "/VideoConsumption/video.htm",
					data : "videoId=" + videoId + "&videoName=" + videoNameVal + "&deleteBookmark=" + "deleteBookmark",
					error : function(e) {
						//alert("Error on delete Notes");
					}
				});
				jwplayer().play();
			}
			
			function doAjaxPost() {
				//alert("inside ajax post");
				// get the form values
				var name = (jwplayer().getPlaylistItem()["file"])
						.split("videos/")[1];
				var description = String($('#textArea').val());
				var videoId = String($('#videoIdHid').val());
				var time = jwplayer().getPosition();

				var bookmarkTitle = String($("input#bookmarkTitle").val());
				
				//console.log("Time: "+ time);
				//console.log("Video Length: "+ videoId.length);
				//return false;
				
				
				var dataString = "";
				if (videoId != null && videoId != "") {
					time = String($('#timeHid').val());
					
					//alert("video id not n ull111");
					//alert("video id not nulltime "+time);
					dataString = "videoId=" + videoId + "&time=" + time
							+ "&name=" + name + "&description=" + description
							+ "&bookmarkTitle=" + bookmarkTitle + "&update="
							+ "update";
				} else {
					//alert("video id  null");
					dataString = "time=" + time + "&name=" + name
							+ "&description=" + description + "&bookmarkTitle="
							+ bookmarkTitle;
				}
				//alert("dataString : "+dataString);
				$.ajax({
					type : "POST",
					url : "/VideoConsumption/video.htm",
					data : dataString,
					error : function(e) {
						$('#textArea').val('');
						$("input#bookmarkTitle").val('');
					}
				});
				$('#videoId').val('');
				document.getElementById("videoIdHid").value = "";
				jwplayer().play();
				document.getElementById("videoIdHid").value = "";

				

			}

			function doBookMarkPost() {
				// get the form values
				var videoName = (jwplayer().getPlaylistItem()["file"])
						.split("videos/")[1];
				var time = jwplayer().getPosition();
				var title = String($("input#bookmarklabel").val());
				$.ajax({
					type : "POST",
					url : "/VideoConsumption/video.htm",
					data : "time=" + time + "&title=" + title + "&videoName="
							+ videoName + "&bookmark=" + "bookmark",
					error : function(e) {
						$("input#title").val('');
					}
				});
				jwplayer().play();
			}

			function displayBookMarkNotes(time) {
				if (time != null) {
					jwplayer().seek(time);
					jwplayer().pause(true);
				}
			};

			function getBookMarkList(name) {
				$
						.getJSON(
								"<c:url value="/video.htm" />",
								{
									"bookamrklist" : 'bookamrklist',
									"videoName" : name
								},
								function(data) {
									var link = null;
									for ( var i = 0; i < data.length; i++) {
										var timeValue = getAssignedTime(data[i].time
												.split(":"));
										if (i == 0) {
											link = '<tr><td width="30"><img src="images/orgstar.gif" width="11" height="11" id="image' +i +'"/></td><td width="400"><a href="#" id='
													+ i
													+ '  onclick="displayBookMarkNotes(\''
													+ timeValue
													+ '\');" style="left: 5em;">'
													+ data[i].title
													+ '</a></td>'
													+'<td ><img type="button" src="images/delete.jpg" width="11" height="11" onclick="onDeleteBookmark(\''
													+ data[i].videoId
													+ '\',\''
													+ ""
													+ '\',\''
													+ data[i].videoName
													+ '\');" id="image' +i +'"/></td></tr>';
										} else {
											link = link
													+ '<tr><td width="30"><img src="images/orgstar.gif" width="11" height="11" id="image' +i +'"/></td><td width="400"><a href="#" id='
													+ i
													+ '  onclick="displayBookMarkNotes(\''
													+ timeValue
													+ '\');" style="left: 5em;">'
													+ data[i].title
													+ '</a></td>'
													+'<td ><img type="button" src="images/delete.jpg" width="11" height="11" onclick="onDeleteBookmark(\''
													+ data[i].videoId
													+ '\',\''
													+ ""
													+ '\',\''
													+ data[i].videoName
													+ '\');" id="image' +i +'"/></td></tr>';
										}
										;
									}
									;
									if (link != null) {
										$("#myBookMarkContent").html(link);
									} else {
										$("#myBookMarkContent").html(null);
									}
								});
			}

			function getPlayList() {
				//alert("init");
				$
						.getJSON(
								"<c:url value="/video.htm" />",
								{
									"displayList" : 'displayList'
								},
								function(data) {

									var playlist_items = "";
									for ( var i = 0; i < data.length; i++) {
										if (i == 0) {
											playlist_items = '<li id='+i+'><a id='
													+ i
													+ '  onclick="displayVideo(\''
													+ data[i].fileName
													+ '\',\''
													+ data[i].filePath
													+ '\');" ><div class="lar-patt"><div class="zicons l1 vedeo f-l"></div><div class="p-items-for-today f-ls">'
													+ data[i].fileName
													+ '</div></div></a></li>';
										} else {
											playlist_items = playlist_items
													+ '<li id='+i+'><a id='
													+ i
													+ ' onclick="displayVideo(\''
													+ data[i].fileName
													+ '\',\''
													+ data[i].filePath
													+ '\');" ><div class="lar-patt"><div class="zicons l1 vedeo f-l"></div><div class="p-items-for-today f-ls">'
													+ data[i].fileName
													+ '</div></div></a></li>';
										}
										
									}

									if (data.length == 0) { //there are no items in the playlist. 
										playlist_items = "<p><img src='images/icons/icon_info.png' style='vertical-align: middle;'/> There are no items in the playlist.</p>";
									}
									$("#my_playlist_items")
											.html(playlist_items);

								});
			}
			
			
			
			function getTreeData() {
				
				//var paramStr = 'displayTree';
				
				$("#dashboard_course_tree").jstree({
					
					
					        "json_data" : {
					
					            "ajax" : {
					
					                "url" : "<c:url value="/video.htm?displayTree=ccc" />",
					
					                "data" : function (data) {
					                    
					                	
					                	//console.log(" callback called in jstree");
					                    //console.log("data is "+data.d);
					                    
					                    return { id : data.attr ? data.attr("id") : 0 };
					
					                }
					
					            }
					
					        },
					
					        "plugins" : [ "themes", "json_data" ]
					
					    });
					
					}
			
			

			function displayEnrichVideo(enrichmentid,videoid,starttime,endtime){
				//alert("inside disdf method");
			}


				function doPlayListPost() {
				// get the form values
				var name = (jwplayer().getPlaylistItem()["file"])
						.split("videos/")[1];
				var path = "videos/";
				$.ajax({
					type : "POST",
					url : "/VideoConsumption/video.htm",
					data : "fileName=" + name + "&filePath=" + path
							+ "&playlist=" + "playlist",
					error : function(e) {
					}
				});

				getPlayList();
			}

			function doUpdatePost(videoId, description, bookmarkTitle) {
				//alert(":::videoId "+videoId+": description "+description+" : bookmarkTitle "+bookmarkTitle);
				var name = (jwplayer().getPlaylistItem()["file"])
						.split("videos/")[1];
				var description = String($('#textArea').val());
				var bookmarkTitle = String($("input#bookmarkTitle").val());
				//alert(":::name "+name+": description "+description+" : bookmarkTitle "+bookmarkTitle);
				$.ajax({
					type : "POST",
					url : "/VideoConsumption/video.htm",
					data : "videoId=" + videoId + "&name=" + name
							+ "&description=" + description + "&bookmarkTitle="
							+ bookmarkTitle + "&update=" + "update",
					error : function(e) {
						$('#textArea').val('');
						$("input#bookmarkTitle").val('');
					}
				});
				jwplayer().play();
			}
		</script>


		<link rel="stylesheet" type="text/css"
			href="css/custom-theme/old-jquery-ui-1.8.21.custom.css">
			<link rel="stylesheet" type="text/css"
				href="css/custom-theme/jquery-ui-1.8.21.custom.css">
				<script src="development-bundle/jquery-1.7.2.js"></script>
				<script src="development-bundle/ui/jquery.ui.core.js"></script>
				<script src="development-bundle/ui/jquery.ui.widget.js"></script>
				<script src="development-bundle/ui/jquery.ui.button.js"></script>
				<script src="development-bundle/ui/jquery.ui.progressbar.js"></script>
				<!--end jquery UI-->

				<script src="js/jquery.verticalscrollplus-1.0.js"></script>

				<script src="js/login/jquery.tipsy.js" type="text/javascript"></script>
				<script src="js/custom.js" type="text/javascript"></script>
				<script src="js/jquery.cookie.js"></script>
				<script src="js/jquery.collapse.js"></script>
 				<script  src="js/jstree/jquery.jstree.js"></script>
				<script>
					$(function() {
						//Initialize buttonset
						$("#format").buttonset();
						//Initialize progress bar
						$("#progressbar").progressbar({
							value : 37
						});
						
						//Initialize jstree for the first time on page load. Gets data via ajax
						getTreeData();
						
					});
				</script>
</head>
<body>

	<div id="wrapper">
		<!--Header Container-->
		<header class="bottom-box-shadow bckground-wihte">
		<div class="topheader">
			<!--logo container-->
			<div class="logo">
				<a href="#"><img src="images/logo.jpg" width="189" height="50"></a>
			</div>
			<!--end logo container-->
			<div class="status-container">
				<div id="status-icons"
					class="bottom-box-shadow two-bottom-rounded-box">
					<ul>
						<li><a href="#" class="email-icon" rel="tipsy"
							title="3 New emails"><span class="wite-title">3</span></a></li>
						<li><a href="#" class="alart-icon orange-bc" rel="tipsy"
							title="1 Circle Invite"><span class="wite-title">1</span></a></li>
						<li><a href="#" class=" amount-icon blue-bc" rel="tipsy"
							title="Ziks available"><span class="wite-title">355500</span></a></li>
						<li><a href="#" class="peoples-icon orange-bc" rel="tipsy"
							title="5 Contact requests"><span class="wite-title">5</span></a></li>
					</ul>
					<div></div>
				</div>
				<div class="account-container two-bottom-rounded-box">
					<div class="container">
						<div class="topnav">
							<a href="#" class="signin wite bold"><span
								class="text-size-px12 wite bold">My Account</span></a>
						</div>
						<fieldset id="signin_menu">
							<ul>
								<li><a href="#">Preferences</a></li>
								<li><a href="#">Privacy</a></li>
								<li><a href="#">Sign Out</a></li>
							</ul>
						</fieldset>
					</div>
				</div>
			</div>
		</div>
		<nav> <!--menu-->
		<div class="menu">
			<ul>
				<li><a href="#" class="current">Dashboard</a>
					<div class="nav-line"></div></li>
				<li><a href="courses.html">Courses</a>
					<div class="nav-line"></div></li>
				<li><a href="#">Grades</a>
					<div class="nav-line"></div></li>
				<li><a href="#">Locker</a></li>
			</ul>
		</div>
		<!--End menu-->
		<div class="searchpanel">
			<form name="form1" method="post" action="">
				<input type="text" name="search" id="search" placeholder="Search..."
					title="Search..." autosave="unique"
					class="two-left-rounded-box two-right-rounded-box"> <input
					id="submit" type="submit" value="Submit">
			</form>
		</div>
		<div class="searchoptions">
			<ul>
				<li class="srch-op-a"><a href="#"></a></li>
				<li class="srch-op-b"><a href="#"></a></li>
				<li class="srch-op-c"><a href="#"></a></li>
			</ul>
		</div>
		</nav> </header>
		<!--End Header Container-->
		<!--slogen-->
		<div class="sub-nav">
			<div class="f-l">
				<strong class="a-b"><a href="#">Course Name </a> </strong><strong
					class="a-b, light-blue">1. Model Thinking </strong>
			</div>
			<div class="f-r">
				<strong class="a-b">|<a href="#"> Course Blog</a> | <a
					href="#">Tasks & assignments</a> | <a href="#">Grades</a> | <a
					href="#">Calendar</a> | <a href="#">Playbook</a></strong>
			</div>
		</div>
		<!--End slogen-->
		<!--Main Content-->
		<section style="position: relative;">
		<div id="book-container">

			<div id="book-chapter">
				<div id="book-index">
					<p class="titles-info1">Chapters</p>
					<br />
					<p class="user-name-w1">1. MODEL THINKING</p>

					<ul id="nav">
						<li class="user-name-w2">1.1 Why Model Thinking
							<ul class="user-name-w2" id="chapter">
								<li><a href="#"
									onclick="displayVideo('Why_Model.mp4','videos/');">1.1.1
										Why Model</a></li>
								<li><a href="#"
									onclick="displayVideo('Intelligent_Citizens.mp4','videos/');">1.1.2
										Intelligent Citizens of the World</a></li>
							</ul>
						</li>
						<br />
						<li class="user-name-w2" id="chapter">1.2 Aggregation
							<ul class="user-name-w2">
								<li><a href="#"
									onclick="displayVideo('Aggregation.mp4','videos/');">1.2.1
										Aggregation</a></li>
								<li><a href="#"
									onclick="displayVideo('Six_Sigma.mp4','videos/');">1.2.2
										Six Sigma</a></li>

							</ul>
						</li>
						<br />
						<li class="user-name-w2" id="chapter">1.3 Decission Models
							<ul class="user-name-w2">
								<li><a href="#"
									onclick="displayVideo('Intro_Decision_Making.mp4','videos/');">1.3.1
										Introduction to Decission Making</a></li>
								<li><a href="#"
									onclick="displayVideo('Probability.mp4','videos/');">1.3.2
										Probability: The Basics</a></li>
							</ul>
						</li>
						<br />
					</ul>
				</div>
				<div id="book-vedio">
					<div id="play-vedio">
						<div id="videoSection">
							<!-- START OF THE PLAYER EMBEDDING TO COPY-PASTE -->
						</div>
						<script type="text/javascript">
							var player = null;
							function playerReady(obj) {
								var link = <img src="images/disk.png" width="16" height="16"/>;
								player = document.getElementById(obj['id']);
								player.setOverlay('overlay1', link, 'l,t');
								player.sendEvent('REDRAW');
							};

							function editBookMark(videoId, description,
									bookmarkTitle) {
								//alert("inside editbookmark method ");
								$('.textArea').attr('readonly', false);
								$("input#bookmarkTitle")
										.attr('readonly', false);
								//alert("videoId "+videoId+": description "+description+" : bookmarkTitle "+bookmarkTitle);
								var imageHtml = '<div class="icons"><img src="images/pencil.png" width="16" height="16" /></div><div class="icons"><a href="#" onclick="doUpdatePost(\''
										+ videoId
										+ '\',\''
										+ description
										+ '\', \''
										+ bookmarkTitle
										+ '\');"><img src="images/disk.png" width="16" height="16" /></a></div>';
								$('.iconMain').html(imageHtml);
							};
							

							function displayBookMark(videoId, description,
									time, bookmarkTitle) {
								//alert("inside method ");
								//alert("time :"+time+" :: videoId : "+videoId+" :: description : "+description+" :: bookmarkTitle : "+bookmarkTitle);
								if (videoId != null) {
									document.getElementById("videoIdHid").value = videoId;
									document.getElementById("timeHid").value = time;
									//alert("inside not null");
									$("#listen-text").show();
									$('.textArea').val(description);
									$('#bookmarkTitle').val(bookmarkTitle);
									$('.textArea').attr('readonly', true);
									$("input#bookmarkTitle").attr('readonly',true);
									var imageHtml = '<div class="icons"><a href="#" onclick="editBookMark(\''
											+ videoId
											+ '\',\''
											+ description
											+ '\', \''
											+ bookmarkTitle
											+ '\');"><img src="images/pencil.png" width="16" height="16"/></a></div><div class="icons"><img src="images/disk.png" width="16" height="16"/></div>';
											
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
							var playListItemCounter = 0;
							jwplayer("videoSection").setup({
								flashplayer : "jwplayer/player.swf",
								playlist : [ {
									"file" : '${videoList[0]}',
									"provider" : "http"
								} ],
								image : 'thumbs/Video-1.jpg',
								repeat : "list",
								'stretching' : 'fill',
								'controlbar' : 'over',
								'width' : '550',
								'height' : '335',
								'plugins' : {
									"captions-2" : {
										file : "videos/captions.srt",
										back : true
									}
								},
								'provider' : 'http',
								'http.startparam' : 'starttime'
							});
							var checkStatus = "true";
							var refStatus  = "yes";

							function displayVideo(videoName, videoPath) {
								//window.contextPath = (($.browser.mozilla && $.browser.version.slice(0,3) >= "1.9" ) || $.browser.msie) ? videoPath : "http://localhost:8080/VideoConsumption/" + videoPath;
								//jwplayer().load({file: contextPath + videoName, image:'thumbs/Video-1.jpg'}); 
								//jwplayer().play();
								checkStatus = "true";
								document.getElementById("videoNameHid").value=videoName;				
								jwplayer().load(
										{
											file : "http://localhost:8080/VideoConsumption/" + videoPath
													+ videoName,
											image : 'thumbs/Video-1.jpg'
										});
								jwplayer().play(true);
							}

							function displayEnrichmentNote(videoId,time){
								
								//alert("inside method : "+videoId);
								$("#enrichment_list").html('');

								//alert("inside method :time "+time);
								$('input[name="enrich-set"][value="all"]').attr('checked',false);
								
								if (videoId != null) {
									document.getElementById("videoIdHid").value = videoId;
									document.getElementById("timeHid").value = time;
									//alert("time is : "+time);
									$("#enrichment_list").html(''); //empties table#enrichment_list
									$.getJSON(
											"<c:url value="/video.htm" />",
											{
												"enrichItem" : 'enrichItem',
												"videoid" : videoId,
												"starttime" : time
											},
											function(data) {
												var enrichment_list_items = null;
												//alert("data length : "+data.length); 
												//data.each(function(){console.log($(this).enrichmentid)});
												enrichment_list_items = '<tr class="'+data[0].componentType+' '+data[0].enrichmentid+'"><td width="150"><a href="#" id='
															+ '  onclick="displayEnrichVideo(\''
															+ data[0].enrichmentid
															+ '\',\''
															+ data[0].videoid
															+ '\',\''
															+ data[0].starttime
															+ '\', \''
															+ data[0].endtime
															+ '\');" style="left: 5em;">'
															+ data[0].componetType
															+ '</a></td>'
															+ '<td width="100">'+data[0].title+'</td>'
															+'<td width="40">'+data[0].starttime+'</td>'
															+'<td width="40">'+data[0].endtime+'</td>'
															+'</tr>';
												$("#enrichment_list").html(enrichment_list_items);
												
												if(data[0].componetType=="Notes"){
													refStatus = false;
													$('input[name="enrich-set"][value="notes"]').attr('checked',true);
													$('#enrich-filter').buttonset({option:1});
												}if(data[0].componetType=="Reference Material"){
													$('input[name="enrich-set"][value="refmaterial"]').attr('checked',true);
													$('#enrich-filter').buttonset({option:0});
												}
												document.getElementById("checkAllStatus").value = "false";
												checkStatus = "false";
										}
									);
									jwplayer().seek(time);
									jwplayer().pause(true);
								}
							}
							
							function displayEnrichAll(){
								$('input[name="enrich-set"][value="refmaterial"]').attr('checked',true);
								$('#enrich-filter').buttonset({option:0});

								
								$('input[name="enrich-set"][value="notes"]').attr('checked',true);
								$('#enrich-filter').buttonset({option:1});

								checkStatus = "true";
								getEnrichmentList(name);
								
							}
							var sizeOfRec = 0;
							var noteArray = new Array();
							var enrichArray=new Array();
							var noteTime=0;
							var enrichTime=0;
							function getEnrichmentList(name) {
								
								//alert("init getEnrichmentList");	
								//alert("check statu s : "+checkStatus);
								//alert("ref status : "+refStatus);
									
									$.getJSON(
													"<c:url value="/video.htm" />",
													{
														"enrichList" : 'enrichList',
														"videoName" : name
													},
													function(data) {
														var newCounter = counter;
														if (jwplayer()
																.getPosition() == 0) {
															counter = 0;
															//alert("position and counter zero in enrich");
															//counter = 0+sizeOfRec;
															//alert("counter : "+counter);
														}else{
															
															counter = newCounter;
															//alert("new counter :"+counter);
														}
														var enrichment_list_items = null;
														for ( var j = 0; j < data.length; j++) {
															if (j == 0) {
																enrichment_list_items = '<tr class="component_type_'+data[j].componenttypeid+' '+data[j].enrichmentid+'"><td width="150"><a href="#" id='
																	+ j
																	+ '  onclick="displayEnrichVideo(\''
																	+ data[j].enrichmentid
																	+ '\',\''
																	+ data[j].videoid
																	+ '\',\''
																	+ data[j].starttime
																	+ '\', \''
																	+ data[j].endtime
																	+ '\');" style="left: 5em;">'
																	+ data[j].componetType
																	+ '</a></td>'
																	+ '<td width="100">'+data[j].title+'</td>'
																	+'<td width="40">'+data[j].starttime+'</td>'
																	+'<td width="40">'+data[j].endtime+'</td>'
																	+'</tr>';

															} else {
																enrichment_list_items =  enrichment_list_items + '<tr class="component_type_'+data[j].componenttypeid+' '+data[j].enrichmentid+'"><td width="150"><a href="#" id='
																	+ j
																	+ '  onclick="displayEnrichVideo(\''
																	+ data[j].enrichmentid
																	+ '\',\''
																	+ data[j].videoid
																	+ '\',\''
																	+ data[j].starttime
																	+ '\', \''
																	+ data[j].endtime
																	+ '\');" style="left: 5em;">'
																	+ data[j].componetType
																	+ '</a></td>'
																	+'<td width="100">'+data[j].title+'</td>'
																	+'<td width="40">'+data[j].starttime+'</td>'
																	+'<td width="40">'+data[j].endtime+'</td>'
																	+'</tr>';
															}
														}
														if (data.length == 0) { //there are no items in the playlist. 
															enrichment_list_items = "<p><img src='images/icons/icon_info.png' style='vertical-align: middle;'/> There are no items in the Enrichment.</p>";
														}
														if(checkStatus=="true"){
															//alert("all selected");
															$("#enrichment_list").html(enrichment_list_items);
															$('input[name="enrich-set"][value="all"]').attr('checked',true);
															$('#enrich-filter').buttonset({option:2});
															document.getElementById("checkAllStatus").value = "true";
														}else{
															
															//alert("others selected");
															if(refStatus=="yes"){
																$('input[name="enrich-set"][value="refmaterial"]').attr('checked',true);
																$('#enrich-filter').buttonset({option:0});
																document.getElementById("checkAllStatus").value = "false";
															}else{
																$('input[name="enrich-set"][value="notes"]').attr('checked',true);
																$('#enrich-filter').buttonset({option:1});
																document.getElementById("checkAllStatus").value = "false";
															}
														}
														for ( var j = counter; j < data.length; j++) {
															//alert("time in enrich : "+data[j].starttime);
															var timeSplit = data[j].starttime
																	.split(":");
															//alert("enrich timeSplit : "+name);
															//alert("enrich timeSplit : "+data[j].videoName);
															if (data[j].videoName == name) {
																
																//alert("inside loop");
																time = getAssignedTime(timeSplit);
																enrichArray[j]=time;
																enrichTime = time;
																//alert("inside loop enrich time : "+time);
																videoID = data[j].videoid;
																counter++;
																break;
															}
														}
													});
								}
							function addVideo() {
								var playlist = jwplayer().getPlaylist();
								<c:forEach items="${videoList}" var="oneName" varStatus="status">
								if ('${status.index}' != '0') {
									var newItem = {
										file : '${oneName}'
									};
									playlist.push(newItem);
								}
								</c:forEach>
								jwplayer().load(playlist);
							}

							jwplayer("videoSection")
									.onTime(
											function() {
												var maxPosition;
												if(noteTime!=null && noteTime!=""){
//													//alert("inside note time :"+noteTime);
													if (noteTime == "0.50") {
														maxPosition = "1";
													} else {
														maxPosition = noteTime + ".20";
													}
//													alert("max position : "+maxPosition+"  jwplayer().getPosition() : "+jwplayer().getPosition()+"  old time : "+oldTime+"     note time :"+noteTime);
													
													if (jwplayer().getPosition() >= noteTime
															&& jwplayer()
																	.getPosition() <= maxPosition
															&& oldTime != noteTime) {
//														alert("time with split : "+noteTime);
														
														for(var k = 0;k<noteArray.length;k++){
															//alert("ArrayTime : "+noteArray[k]+" time : "+noteTime);
															if(noteArray[k] == noteTime){
																//alert("ddd")
																displayBookMark(videoID,
																		description, noteTime,
																		bookmarkTitle);
															}	
														}
														oldTime = noteTime;
													} else {
														//alert("alternate");

														//$("#listen-text").hide();
														//$("#enrich_note").hide();
														$('.textArea').val('');
													}
													
												}
												if(enrichTime!=null && enrichTime!="undefined" && enrichTime!=0){
//													alert("inside enrichTime :"+enrichTime);
													if (enrichTime == "0.50") {
														maxPosition = "1";
													} else {
														maxPosition = enrichTime + ".20";
													}
													if (jwplayer().getPosition() >= enrichTime
															&& jwplayer()
																	.getPosition() <= maxPosition
															&& oldTime != enrichTime) {
														
														//alert("time with split : "+enrichTime);
														
														//alert("enrichArray : "+enrichArray.length);

														for(var l = 0;l<enrichArray.length;l++){
															//alert("ArrayTime : "+enrichArray[l]+" time : "+enrichTime);
															if(enrichArray[l] == enrichTime){
																displayEnrichmentNote(videoID,enrichTime);
															}	
															
														}
														oldTime = enrichTime;
													} else {

														//$("#listen-text").hide();
														//$("#enrich_note").hide();
														$('.textArea').val('');
													}
												}
											});
							jwplayer("videoSection")
									.onPlaylistItem(
											function(event) {
												var playListArray = jwplayer(
														"videoSection")
														.getPlaylist();
												checkStatus="true";
												for ( var i = 0; i < playListArray.length; i++) {
													if (i != event.index
															|| playListItemCounter > playListArray.length) {
														document
																.getElementById(i).style.backgroundImage = '';
													} else {
														document
																.getElementById(i).style.width = '229px';
														document
																.getElementById(i).style.backgroundRepeat = 'no-repeat';
														document
																.getElementById(i).style.textDecoration = 'none';
														document
																.getElementById(i).style.backgroundImage = 'url(images/selected1.jpg)';
													}
												}
												playListItemCounter++;
											});
							
							function getNoteList(name){
								$.getJSON("<c:url value="/video.htm" />",
												{
													"name" : name
												},
												function(data) {
													if (jwplayer()
															.getPosition() == 0) {
														counter = 0;
														//alert("position and counter zero in note");
													}
													var link = null;
													for ( var i = 0; i < data.length; i++) {
														var timeValue = getAssignedTime(data[i].time
																.split(":"));
														time = timeValue;
														if (i == 0) {
															link = '<tr><td width="30"><img src="images/pencil.png" width="11" height="11" id="image' +i +'"/></td><td width="400"><a href="#" id='
																	+ i
																	+ '  onclick="displayBookMark(\''
																	+ data[i].videoId
																	+ '\',\''
																	+ data[i].description
																	+ '\',\''
																	+ data[i].time
																	+ '\', \''
																	+ data[i].bookmarkTitle
																	+ '\');" style="left: 5em;">'
																	+ data[i].bookmarkTitle
																	+ '</a></td>'
																	+'<td><img type="button" src="images/delete.jpg" width="11" height="11" onclick="onDeleteNotes(\''
																	+ data[i].videoId
																	+ '\',\''
																	+ data[i].time
																	+ '\',\''
																	+ ""
																	+ '\');" id="image' +i +'"/></td></tr>';
														} else {
															link = link
																	+ '<tr><td width="30"><img src="images/pencil.png" width="11" height="11" id="image' +i +'"/></td><td width="400"><a href="#" id='
																	+ i
																	+ '  onclick="displayBookMark(\''
																	+ data[i].videoId
																	+ '\',\''
																	+ data[i].description
																	+ '\',\''
																	+ data[i].time
																	+ '\',  \''
																	+ data[i].bookmarkTitle
																	+ '\');" style="left: 5em;">'
																	+ data[i].bookmarkTitle
																	+ '</a></td>'
																	+'<td><img type="button" src="images/delete.jpg" width="11" height="11" onclick="onDeleteNotes(\''
																	+ data[i].videoId
																	+ '\',\''
																	+ data[i].time
																	+ '\',\''
																	+ ""
																	+ '\');" id="image' +i +'"/></td></tr>';
														}
													};
													sizeOfRec = data.length;
													for ( var i = counter; i < data.length; i++) {
														//alert("time : "+data[i].time);
														var timeSplit = data[i].time
																.split(":");
														//alert("timeSplit : "+timeSplit);
														if (data[i].name == name) {
															time = getAssignedTime(timeSplit);
															noteArray[i]=time;
															noteTime = time;
															//alert("inside loop time : "+time);
															videoID = data[i].videoId;
															description = data[i].description;
															bookmarkTitle = data[i].bookmarkTitle;
															counter++;
															break;
														}
													}
													if (link != null) {
														$("#myworkcontent")
																.html(link);
													} else {
														$("#myworkcontent")
																.html(null);
														videoID = null;
													}
													;
												});
							}
							jwplayer("videoSection")
									.onPlay(

											function() {
												$("#listen-text-bookmark").hide();
												getPlayList();
												enableEditButton();
												
												name = (jwplayer()
														.getPlaylistItem()["file"])
														.split("videos/")[1];

												getNoteList(name);
												
												getEnrichmentList(name);

												//alert("outside loop time : "+time);
												getBookMarkList(name);		
												//alert("before call");
												$('input[name="enrich-set"][value="all"]').attr('checked',true);
/* 												alert("hid status :  "+document.getElementById("checkAllStatus").value);
 */												
												$('#enrich-filter').buttonset({option:2});
												//getEnrichmentList(name);
												document.getElementById("vidNameHid").value = name;
											});

							jwplayer("videoSection")
									.onReady(
											function() {
												name = (jwplayer()
														.getPlaylistItem()["file"]).split("videos/")[1];
												addVideo();
												$("#listen-text-bookmark").hide();
												//$("#enrichment_list").hide();
												
											});
							jwplayer("videoSection").onComplete(function() {
								oldTime = 0;
							});
							function getAssignedTime(timesplit) {
								var timeValue;
								if (timesplit[0] != "00") {
									timeValue = timesplit[0] + ".";
								}
								if (timesplit[1] != "00") {
									timeValue = timesplit[1] + ".";
								}
								if (timesplit[2] != "00") {
									timeValue = timesplit[2];
								}
								if (timesplit[2] == "00") {
									timeValue = "0.50";
								}
								return timeValue;
							}

							  function showEnrichmentTopicForm(){
								 // alert("showEnrichmentTopicForm");
							  }
							  function showEnrichRefMaterialForm(){
								  //alert("showEnrichRefMaterialForm");
							  }

    						  function doEnrichPost(){
								// get the form values
								var videoName = $("#vidNameHid").val();
								
								var starttime = jwplayer().getPosition();
								//alert("starttime : "+starttime);
								var endtime  =  jwplayer().getPosition()+30;
								//alert("end time : "+endtime);
								var title = String($("input#title").val());
								var componetType = String($("input#componetType").val());
								
								//alert("videoName=" + videoName + "&title=" + title + "&componetType="
								//		+ componetType);
								$.ajax({
									type : "POST",
									url : "/VideoConsumption/video.htm",
									data : "videoName=" + videoName + "&starttime="+starttime+"&endtime="+endtime+"&title=" + title + "&componetType="
											+ componetType + "&postEnrich=" + "postEnrich",
									error : function(e) {
										$("input#title").val('');
										$("input#componetType").val('');
									}
								});
								jwplayer().play();

							  }

						</script>

						<!-- 	<div id="captions1"></div>

<script type="text/javascript">


   // replace "{USE_YOUR_VIDEO_OBJECT_ID}" with the player ID from your video embed.
   // set player_type to the player type you are using.

window.p3_async_init = function(){
    P3.init({
     "videoSection" : {
      "player_type": "jw",
      "file_id": 80403,
      "captions": {
         "skin": "dark",
         "overlay": true,
         "overlay_draggable": false,
         "minimize_onload": false,
         "searchbar": true,
         "width": "360px",
         "target": "captions1",
         "overlay_offset_y": -30,
         "overlay_minimized_offset_y": -16
        }
      }
    },"W8zIL3450dFPjh67MyahNT_edwABO");
  }
  
  
</script> -->
						<!-- <script type="text/javascript" src="http://p3.3playmedia.com/p3.js"></script> -->
						<!-- End 3Play Media Embed -->
						<!-- END OF THE PLAYER EMBEDDING -->
						<div id="video_actions">
<!-- 							<img type="button" title="Make a Enrichment Note"
								src="images/led/note.png" id="enrichnote"
								onclick="showEnrichmentNoteForm();" />
							<img type="button" title="Add Enrich Topic"
								src="images/topic.png" id="enrichtopic"
								onclick="showEnrichmentTopicForm();" />
							<img type="button" title="Add Enrich Ref Material"
								src="images/refmaterial.jpg" id="enrichrefmaterial"
								onclick="showEnrichRefMaterialForm();" />
 -->								
							<img type="button" title="Make a Note"
								src="images/icons/icon_note.png" id="listen"
								onclick="showVideoNoteForm();" /> <img type="button"
								title="Add Bookmark" src="images/icons/icon_star.png"
								onclick="displayBookMarkSection();" id="bookmarkicon" /> <img
								type="button" title="Add to Playlist"
								src="images/icons/icon_playlist.png" onclick="doPlayListPost();" />
						</div>
<%-- 						<form name="enrichment" method="post" action="/VideoConsumption/video.htm">
							<div id="enrich_note" style="border:2px solid #D3D3D3;">
								<div id="editbox" style="width:80%; margin-bottom:10px;">
									<input type="text"  class='text' name="enrichnotetitle"
										id="title" placeholder="Enter title for the Component Type"  /> 
										<br /> <br/> 
									<input type="text"  class='text' name="enrichcomptype"
										id="componetType" placeholder="Enter the Component Type"  /> <br></br>	
								</div>
								<div id="video_note_actions">
									<input type="button" value="Submit" onclick="doEnrichPost();"/>
									<input type="button" value="Close" onclick="$('#enrich_note').fadeOut();" />	
								</div>	
							</div>
							<input type="hidden" id="vidNameHid" />
						</form>
 --%>							
						
						<form:form commandName="file" action="/VideoConsumption/video.htm"
							id="fileForm">
							<!-- <input type="hidden" id="videoId"/> -->
							<div id="listen-text">
								<div id="editbox">
									<b>Note Title:</b>
									<form:input path="bookmarkTitle"
										class="password-strength-title" />
									<br /> <br /> <b>Note Description:</b>
									<div class="textArea" >
										<form:textarea path="description" id="textArea" cols="70"
											class="textArea note_description" />
									</div>

								</div>

								<div id="video_note_actions">
									<img src="images/pencil.png" width="16" height="16"
										onclick="$('#bookmarkTitle, .note_description').removeAttr('readonly');" />
									<img type="button" src="images/disk.png" width="16" height="16"
										onclick="doAjaxPost();" /> <img src="images/cross.png"
										onclick="$('#listen-text').fadeOut(); $('#').show();$('#enrich_note').fadeOut();" />
								</div>
								<div id="dtext">
									<div class="textArea" id="savetext"></div>
								</div>
							</div>
							
							<input type="hidden" id="videoIdHid" />
							<input type="hidden" id="timeHid" />
         					<input type="hidden" id="videoNameHid" />							
						</form:form>
						<form name="bookamrk" method="post" action="/VideoConsumption/video.htm">
							<div id="listen-text-bookmark">
								<div id="editbox">
									<b>Bookmark Title:</b> <input type="text" name="bookmarklabel"
										id="bookmarklabel" class="password-strength-title" /> <a
										href="#" onclick="doBookMarkPost();"><img
										style="padding: .25em; background: white; vertical-align: middle; border-radius: 3px;"
										type="button" src="images/disk.png" width="16" height="16" /></a>
								</div>

								<div id="dtext">
									<div class="textArea" id="savetext"></div>
								</div>
							</div>
						</form>

					</div>

					<div id="lect-img">
						<img src="images/professor.jpg">
							<p class="user-name-w2">
								Chritopher Bremner<br />Assistant Professor

							</p>
							<div id="myworkholder">

								<div />
							</div>
					</div>
				</div>
			</div>



			<!--  bottom portion to be inserted here -->
			<div id="dashboard_course_tree" class="demo">	</div>
			<!--<div class="section">  -->

			<!--Left column-->
			<div class="col-lft border-right">
				<div class="user-insight">
					<p class="titles-info font-Signika text-size-px18 light-gray">Items
						For Today</p>

					<div class="items-for-today">
						<!-- added by sundip shah -->
						<ul id="ticker_items_for_today">
							<!-- p class="document-icon"-->
							<c:forEach var="file" items="${files}" varStatus="counter">
								<li id="${counter.index}"><a href="#"
									onclick="displayVideo('${file.fileName}','${file.filePath}');enableEditButton();">
										<div class="lar-patt">
											<div class="zicons l1 audio"></div>
											<div class="p-items-for-today">${file.title}</div>
										</div>
								</a></li>
							</c:forEach>
						</ul>
						<p>
							<a id="ticker-previous" class="zicons"></a> <a id="ticker-next"
								class="zicons"></a>
						</p>




						<!-- end here -->
					</div>



					<p class="txt-r" style="padding-right: 20px;">
						<a href="#" class="icon-cal">Calendar</a>
					</p>

					<!-- 				
	 -->

					<p class="titles-info font-Signika text-size-px18 light-gray">My
						PlayList</p>

					</p>
					<div id="my_playlist" class="items-for-today">
						<!-- added by sundip shah -->

						<ul id="my_playlist_items">
							<!-- The content here will be dynamically populated.-Arun. -->
						</ul>
						<p>
							<a id="ticker-previous2" class="zicons"></a> <a id="ticker-next2"
								class="zicons"></a>
						</p>


					</div>

					<div class="user-contacts">
						<span class="titles-info">Contacts</span>
						<ul class="contact-list">
							<li class="member">
								<div class="grey-out ">
									<div class="white-in contact-pic"
										style="background: url(images/user/2my-photo.png);">
										<a href="#"></a>
									</div>
								</div>
							</li>
							<li class="member">
								<div class="grey-out ">
									<div class="white-in contact-pic"
										style="background: url(images/user/2my-photo.png);">
										<a href="#"></a>
									</div>
								</div>
							</li>
							<li class="member">
								<div class="grey-out ">
									<div class="white-in contact-pic"
										style="background: url(images/user/2my-photo.png);">
										<a href="#"></a>
									</div>
								</div>
							</li>
							<li class="member">
								<div class="grey-out ">
									<div class="white-in contact-pic"
										style="background: url(images/user/2my-photo.png);">
										<a href="#"></a>
									</div>
								</div>
							</li>
							<li class="member">
								<div class="grey-out ">
									<div class="white-in contact-pic"
										style="background: url(images/user/2my-photo.png);">
										<a href="#"></a>
									</div>
								</div>
							</li>
							<li class="member">
								<div class="grey-out ">
									<div class="white-in contact-pic"
										style="background: url(images/user/2my-photo.png);">
										<a href="#"></a>
									</div>
								</div>
							</li>
							<li class="member">
								<div class="grey-out ">
									<div class="white-in contact-pic"
										style="background: url(images/user/2my-photo.png);">
										<a href="#"></a>
									</div>
								</div>
							</li>
							<li class="member">
								<div class="grey-out ">
									<div class="white-in contact-pic"
										style="background: url(images/user/2my-photo.png);">
										<a href="#"></a>
									</div>
								</div>
							</li>
						</ul>
						<p class="txt-r" style="padding-right: 20px;">
							<button class="search">People Search</button>
						</p>
					</div>
				</div>
			</div>
			<!--End Left column-->
			<!--Center Container-->
			<div class="center for-rounded-box all-box-shadow">
				<p class="titles-info font-Signika text-size-px18 light-gray">
					Notes &amp; BookMarks
					<div class="btn-set" >
						<input type="checkbox" id="check1" /> <label for="check1">Mine</label>
						<input type="checkbox" id="check2" checked /> <label for="check2">Class</label>
						<input type="checkbox" id="check3" /> <label for="check3">All</label>
					</div>
					<table class="alt-table-white">
						<thead>
							<tr>
								<th>Label</th>
								<th></th>
							</tr>
						</thead>
						<tr>
							<td id="myworkcontent"></td>
						</tr>
						<tr>
							<td id="myBookMarkContent"></td>
						</tr>
					</table>
					<p class="titles-info font-Signika text-size-px18 light-gray">Educator
						Suggested Reading</p>

					<div class="btn-set" id="enrich-filter">
							<input type="radio" name="enrich-set" id="check4" value="refmaterial"/> 
							<label for="check4" >Ref	Material</label> 
							<input type="radio" name="enrich-set" id="check5" value="notes"/> 
							<label for="check5">Notes</label>  
							<input type="radio" name="enrich-set" id="check7"  value="all" onclick="displayEnrichAll();"/> <label for="check7">All</label>
					</div>
					<table class="alt-table-white" id="enrichment_list">
						<tr>
							<td>Contents will be dynamically populated.</td>
						</tr>
					</table>
					
				</p>
				<div class="class-talk">
					<p class="titles-info">
						Class talk<span class="rightof-title-info blue">Show only</span>
					</p>
					<img src="images/user/2my-photo.png" width="38" height="40"
						align="left" class="img">
						<p class="user-p">
							<span class="blok-title-L">Jason Dechamp</span>Check out the blog
							'<span class="blue">Innovative Educational Technology</span>',
							its gives good ideas for our projects...gives good ideas for our
							projects...gives good ideas for our projects...
						</p>
						<div class="dash-bord">
							<div class="dash-bord-icon"></div>
							<div class="dash-bord-bar">
								<input id="btn_comment" name="btn_comment" type="button"
									value="+" style="float: right;" />
								<!-- added by sundip shah -->
							</div>
							<textarea id="new_comment" name="new_comment" cols="43" rows="4"></textarea>
							<div class="comments-container">
								<img src="images/user/cocntacts-users.jpg" width="40"
									height="42" align="left" class="img2">
									<p class="user-p">
										<span class="blok-title-L">Jason Dechamp</span>Check out the
										blog '<span class="blue">Innovative Educational
											Technology</span>', its gives good ideas for our projects...
									</p>
							</div>
						</div>
				</div>
			</div>
			<!--End Center Container-->
			<!--Right column-->
			<div class="col-right">
				<div class="col-right-container for-rounded-box all-box-shadow">
					<p class="titles-info font-Signika text-size-px18 light-gray">Progress</p>
					<div id="progressbar"
						class="ui-progressbar ui-widget ui-widget-content ui-corner-all"
						role="progressbar" aria-valuemin="0" aria-valuemax="100"
						aria-valuenow="59">
						<div class="ui-progressbar-value ui-widget-header ui-corner-left"
							style="width: 59%;"></div>
					</div>

					<div id="progressbar"></div>
					<span class="light-blue">37% complete</span>
					<div class="Performance-chart">
						<p class="titles-info font-Signika text-size-px18 light-gray">
							Course Grades<br>
						</p>
						<p class="blok-title-b">
							<em><a href="#">Assignment 10</a></em>
							<p class="zicons ls g-a-m "></p>
						</p>
						<p class="blok-title-w">
							<em><a href="#">Assignment 10</a></em><strong class="completed">A</strong>
						</p>
						<p class="blok-title-b">
							<em><a href="#">Test10</a></em><strong class="completed">A-</strong>
						</p>
						<p class="blok-title-w">
							<em><a href="#">Assignment 10</a></em><strong class="completed">A</strong>
						</p>
						<p class="titles-info font-Signika text-size-px18 light-gray">
							Tests and assignments<br>
						</p>
						<p class="blok-title-b">
							<em><a href="#">Assignment 10</a></em><strong class="completed">Completed</strong>
						</p>
						<p class="blok-title-w">
							<em><a href="#">Assignment 10</a></em><strong class="date-time">06/26/12</strong>
						</p>
						<p class="blok-title-b">
							<em><a href="#">Test10</a></em><strong class="test-time">06/26/12</strong>
						</p>
						<p class="blok-title-w">
							<em><a href="#">Assignment 10</a></em><strong class="completed">06/26/12</strong>
						</p>

						<p class="titles-info">
							Alerts and reminders <a href="#" class="icon-cal">Calendar</a>
						</p>
						<p class="blok-title-b">
							<em><a href="#">Calendar event</a></em><strong class="completed">06/26/12</strong>
						</p>
						<p class="blok-title-w">
							<em><a href="#">Auto generated alert</a></em><strong
								class="completed">06/26/12</strong>
						</p>
						<p class="blok-title-b">
							<em><a href="#">Class meetup</a></em><strong class="completed">06/26/12</strong>
						</p>
					</div>
				</div>
			</div>
		</div>
	<input type="hidden" id="checkAllStatus"/>

		<!--End Right column--> <!-- </div> --> </section>

		<!--End Main Content-->
		<!--Current Progress-->
		<div class="col , border-top">
			<div class="collapse">
				<h3 class="border-left , border-right , border-top">Your
					current progress [ Starting ... ]</h3>
				<div>
					<p>
						<code>N1</code>
					</p>
					<p>
						<code>N2</code>
					</p>
					<p>
						<code>N3</code>
					</p>
					<p>
						<code>N4</code>
					</p>
				</div>
			</div>
		</div>
		<script>
			$(".collapse").collapse({
				show : function() {
					this.animate({
						opacity : 'toggle',
						height : 'toggle'
					}, 300);
				},
				hide : function() {

					this.animate({
						opacity : 'toggle',
						height : 'toggle'
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
