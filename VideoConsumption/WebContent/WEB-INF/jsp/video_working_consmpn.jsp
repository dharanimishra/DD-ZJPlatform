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
							});
			$(function() {
				getPlayList();
				$('a.link').click(function() {
					$('a.link').removeClass('active');
					$(this).addClass('active');
				});
			});
			function displayVideo(videoName, videoPath) {
				//window.contextPath = (($.browser.mozilla && $.browser.version.slice(0,3) >= "1.9" ) || $.browser.msie) ? videoPath : "http://localhost:8080/UTD/" + videoPath;
				//jwplayer().load({file: contextPath + videoName, image:'thumbs/Video-1.jpg'}); 
				//jwplayer().play();
				document.getElementById("videoNameHid").value=videoName;
				jwplayer().load(
						{
							file : "http://localhost:8080/UTD/" + videoPath
									+ videoName,
							image : 'thumbs/Video-1.jpg'
						});
				jwplayer().play(true);
			}

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
					url : "/UTD/video.htm",
					data : dataString,
					error : function(e) {
						alert("Error on delete Notes");
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
					url : "/UTD/video.htm",
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
				
				console.log("Time: "+ time);
				console.log("Video Length: "+ videoId.length);
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
					url : "/UTD/video.htm",
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
					url : "/UTD/video.htm",
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
				//alert("inside getBookMarkList  : "+name);
				$.getJSON(
								"<c:url value="/video.htm" />",
								{
									"bookamrklist" : 'bookamrklist',
									"videoName" : name
								},
								function(data) {
									var link = null;
									//alert("inside getBookMarkList data.length  : "+ data.length);
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
										;
									}
									;

									if (data.length == 0) { //there are no items in the playlist. 
										playlist_items = "<p><img src='images/icons/icon_info.png' style='vertical-align: middle;'/> There are no items in the playlist.</p>";
									}
									$("#my_playlist_items")
											.html(playlist_items);

								});
			}
			function doPlayListPost() {
				// get the form values
				var name = (jwplayer().getPlaylistItem()["file"])
						.split("videos/")[1];
				var path = "videos/";
				$.ajax({
					type : "POST",
					url : "/UTD/video.htm",
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
					url : "/UTD/video.htm",
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

				<script>
					$(function() {
						$("#format").buttonset();
					});

					$(function() {
						$("#progressbar").progressbar({
							value : 37
						});
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
		<section>
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
								//alert("inside method : "+videoId);
								if (videoId != null) {
									document.getElementById("videoIdHid").value = videoId;
									document.getElementById("timeHid").value = time;
									//alert("inside not null");
									$("#listen-text").show();
									$('.textArea').val(description);
									$('#bookmarkTitle').val(bookmarkTitle);
									$('.textArea').attr('readonly', true);
									$("input#bookmarkTitle").attr('readonly',
											true);
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
												if (time == "0.50") {
													maxPosition = "1";
												} else {
													maxPosition = time + ".20";
												}
												if (jwplayer().getPosition() >= time
														&& jwplayer()
																.getPosition() <= maxPosition
														&& oldTime != time) {
													displayBookMark(videoID,
															description, time,
															bookmarkTitle);
													oldTime = time;
												} else {

													$("#listen-text").hide();
													$('.textArea').val('');
												}
											});
							jwplayer("videoSection")
									.onPlaylistItem(
											function(event) {
												var playListArray = jwplayer(
														"videoSection")
														.getPlaylist();
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
							jwplayer("videoSection")
									.onPlay(
											function() {
												//alert("playing");
												$("#listen-text-bookmark")
														.hide();
												getPlayList();
												enableEditButton();
												name = (jwplayer()
														.getPlaylistItem()["file"])
														.split("videos/")[1];
												$
														.getJSON(
																"<c:url value="/video.htm" />",
																{
																	"name" : name
																},
																function(data) {
																	if (jwplayer()
																			.getPosition() == 0) {
																		counter = 0;
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
																	}
																	;
																	if (link != null) {
																		$(
																				"#myworkcontent")
																				.html(
																						link);
																	} else {
																		$(
																				"#myworkcontent")
																				.html(
																						null);
																		videoID = null;
																	}
																	for ( var i = counter; i < data.length; i++) {
																		var timeSplit = data[i].time
																				.split(":");
																		if (data[i].name == name) {
																			time = getAssignedTime(timeSplit);
																			videoID = data[i].videoId;
																			description = data[i].description;
																			bookmarkTitle = data[i].bookmarkTitle;
																			counter++;
																			break;
																		}
																	}
																	;
																});
												getBookMarkList(name);
											});

							jwplayer("videoSection")
									.onReady(
											function() {
												name = (jwplayer()
														.getPlaylistItem()["file"])
														.split("videos/")[1];
												addVideo();
												$("#listen-text-bookmark")
														.hide();
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
							<img type="button" title="Make a Note"
								src="images/icons/icon_note.png" id="listen"
								onclick="showVideoNoteForm();" /> <img type="button"
								title="Add Bookmark" src="images/icons/icon_star.png"
								onclick="displayBookMarkSection();" id="bookmarkicon" /> <img
								type="button" title="Add to Playlist"
								src="images/icons/icon_playlist.png" onclick="doPlayListPost();" />
						</div>
						<form:form commandName="file" action="/UTD/video.htm"
							id="fileForm">
							<!-- <input type="hidden" id="videoId"/> -->
							<div id="listen-text">
								<div id="editbox">
									<b>Note Title:</b>
									<form:input path="bookmarkTitle"
										class="password-strength-title" />
									<br /> <br /> <b>Note Description:</b>
									<div class="textArea">
										<form:textarea path="description" id="textArea" cols="70"
											class="textArea note_description" />
									</div>

								</div>

								<div id="video_note_actions">
									<img src="images/pencil.png" width="16" height="16"
										onclick="$('#bookmarkTitle, .note_description').removeAttr('readonly');" />
									<img type="button" src="images/disk.png" width="16" height="16"
										onclick="doAjaxPost();" /> <img src="images/cross.png"
										onclick="$('#listen-text').fadeOut(); $('#videoNoteIcon').show();" />
								</div>
								<div id="dtext">
									<div class="textArea" id="savetext"></div>
								</div>
							</div>
							<input type="hidden" id="videoIdHid" />
							<input type="hidden" id="timeHid" />
							<input type="hidden" id="videoNameHid" />
						</form:form>
						<form name="bookamrk" method="post" action="/UTD/video.htm">
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
					<%--  <form:form commandName="video" >
							<ul id="vertical-ticker">
									<!-- p class="document-icon"-->
									<c:forEach var="file" items="${playLists}" varStatus="counter">
										<li id="${playListItemCounter.index}">
											<a href="#"
												onclick="displayVideo('${file.fileName}','${file.filePath}');enableEditButton();"
													style="margin-left: 5em;">
												<div class="lar-patt">
													<div class="zicons l1 vedeo"></div>
													<div class="p-items-for-today">${file.fileName}</div>
												</div>
											</a>
										</li>
									</c:forEach>
								</ul>
							</form:form>
							<!-- end here -->
						<p>
							<a href="#" id="ticker-previous2" class="zicons"></a> <a href="#"
								id="ticker-next2" class="zicons"></a>
						</p>
 --%>

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
					<div class="btn-set">
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

						<!--  tbody id="myworkcontent">
						</tbody>
						<tbody id="myBookMarkContent">
							<img type="button" src="images/led/delete.jpg"
								onclick="deleteContent()">
						</tbody-->
					</table>
					<p class="titles-info font-Signika text-size-px18 light-gray">Educator
						Suggested Reading</p>

					<div class="btn-set">
						<input type="checkbox" id="check4" /> <label for="check4">Ref
							Material</label> <input type="checkbox" id="check5" checked /> <label
							for="check5">Notes</label> <input type="checkbox" id="check6" />
						<label for="check6">Hot Spots</label> <input type="checkbox"
							id="check7" /> <label for="check7">All</label>
					</div>
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
