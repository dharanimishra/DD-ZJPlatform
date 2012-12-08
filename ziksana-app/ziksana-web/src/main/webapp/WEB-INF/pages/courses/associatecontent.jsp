<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="createcourselink" value="/secure/createcourse" />
<c:url var="associatecontentlink" value="/secure/associatecontent" />
<c:url var="enrichcontentlink" value="/secure/enrichcontent" />


<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Associate Content</title>

<!--Body Style sheet-->
<link rel="stylesheet" type="text/css" href="../resources/css/dropdown.css" />
<link href="../resources/css/styles.css" rel="stylesheet" type="text/css">
<link href="../resources/css/type-setting.css" rel="stylesheet" type="text/css">
<link href="../resources/css/effects.css" rel="stylesheet" type="text/css">
<link href="../resources/css/nav.css" rel="stylesheet" type="text/css">
<link href="../resources/css/wizard/wizardstylesheet.css" rel="stylesheet"
	type="text/css">
<link href="../resources/css/spinner/smartspinner.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" href="../resources/css/chosen/superbly-tagfield.css" />
<link rel='stylesheet' type='text/css' href="../resources/css/nav.css" />
<link href="../resources/css/search.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="../resources/css/chosen/superbly-tagfield.css" />

<!--End Body Style sheet-->
<script type="text/javascript" src="../resources/js/jquery-1.7.1.min.js"></script>
<script type='text/javascript' src='../resources/js/enrich.js'></script>
<script type="text/javascript" src="../resources/js/video_player.js"></script>
<script type='text/javascript' src="../resources/jwplayer/swfobject.js"></script>
<script type="text/javascript" src="../resources/jwplayer/jwplayer.js"></script>
<script type="text/javascript" src="../resources/js/tree/opentree.js"></script>
<script type="text/javascript" src="../resources/js/tablerow.js"></script>
<script type="text/javascript" src="../resources/js/search.js"></script>
<script type="text/javascript" src="../resources/js/ckeditor/adapters/jquery.js"></script>
<script type="text/javascript" src="../resources/js/ckeditor/ckeditor.js"></script>

<link rel="stylesheet" href="../resources/js/tree/styles/styleTree.css"
	type="text/css" />
<!-- for the layout of the tree -->

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
<script type="text/javascript" src="../resources/js/tree/myTreeAssociate.js"></script>
<script type="text/javascript" src="../resources/js/tree/splitter.js"></script>
<script type="text/javascript" src="../resources/js/tree/jqxexpander.js"></script>

<!-- End tree -->
<link rel="stylesheet" type="text/css"
	href="../resources/js/ui/jquery.fancybox-1.3.4.css" media="screen" />
<script type="text/javascript"
	src="../resources/js/ui/jquery.mousewheel-3.0.4.pack.js"></script>
<script type="text/javascript" src="../resources/js/ui/jquery.fancybox-1.3.4.pack.js"></script>
<script type='text/javascript' src="../resources/js/custom/libraryfunction.js"></script>
<script type="text/javascript" src="../resources/js/custom/RTE.js"></script>
<script type="text/javascript" src="../resources/js/chosen/superbly-tagfield.min.js"></script>
<!-- end for number spinner -->
<script src="../resources/js/dropdown/hover-dropdown.min.js"></script>
<script src="../resources/js/dropdown/tiwtter.js"></script>
<script>
	$(document).ready(function() {
		$('.js-activated').dropdownHover();
	});
</script>

<style>
.Videocontent {
	padding: 10px;
}

.Videobuttons {
	position: absolute;
	margin-left: 320px;
	color: #FFF;
	left: -195px;
	top: 38px;
	width: 244px;
	z-index: 998;
}

.Videobuttons ul {
	list-style: none;
}

.Videobuttons li {
	display: inline;
	padding-left: 5px;
}

.Videobuttons li a {
	text-decoration: none;
}

.Videocontent {
	position: absolute;
	margin-left: 320px;
	color: #FFF;
	left: -311px;
	top: 106px;
	width: 482px;
	height: 186px;
	background-color: rgba(7, 7, 7, 0);
}

.Videocontentslide {
	position: absolute;
	margin-left: 320px;
	color: #FFF;
	left: -206px;
	top: 143px;
	width: 482px;
	height: 186px;
}

.sublinknavbutton {
	background-color: rgba(7, 7, 7, 0);
	border: none;
	color: #666;
	font-size: 12px;
	text-decoration: none;
	font-family: verdana;
	padding: 5px;
	margin-right: 15px;
}

.sublinknavclosebutton {
	border: none;
	color: #666;
	text-decoration: none;
	padding: 5px;
	margin-right: 15px;
}

.sublinknavbutton:hover {
	background-color: rgba(7, 7, 7, 0) l border:none;
	color: #999;
	font-size: 12px;
	text-decoration: none;
	font-family: verdana;
	padding: 5px;
	margin-right: 15px;
}

.breadcrumb li:nth-child(2) a {
	background: hsla(34, 85%, 25%, 1);
	color: #ccc;
	text-shadow: 1px 1px 2px rgba(34, 29, 29, 1);
}

.breadcrumb li:nth-child(2) a:after {
	border-left-color: hsla(34, 85%, 25%, 1) !important;
}
</style>
</head>

<body>

	<div id="wrapper">
		<!--Header Container-->
		<header class="bottom-box-shadow bckground-wihte">
			<div class="topheader">
				<!--logo container-->
				<div class="logo">
					<p>
						<a href="#"><img height="73" width="189" src="../resources/images/logo.jpg" /></a>
					</p>
				</div>
				<!--end logo container-->
				<div class="status-container">
					<div id="status-icons"
						class="bottom-box-shadow two-bottom-rounded-box">
						<ul>
							<li><a href="#" class="email-icon" rel="tipsy"
								title="3 New Messages"><span class="wite-title">3</span></a></li>
							<li><a href="#" class="peoples-icon orange-bc" rel="tipsy"
								title="5 Contact requests"><span class="wite-title">5</span></a></li>
							<li><a href="#" class="alart-icon orange-bc" rel="tipsy"
								title="1 Connect Request"><span class="wite-title">1</span></a></li>
							<li><a href="#" class="announcement-icon orange-bc"
								rel="tipsy" title="3 New Announcement"><span
									class="wite-title">3</span></a></li>
							<li><a href="#" class=" amount-icon blue-bc" rel="tipsy"
								title="Ziks available"><span class="wite-title">355500</span></a></li>

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
			<nav>
				<!--menu-->
				<div class="menu">
					<ul>
						<li><a href="educatorHomepage.html" class="current">My
								Home</a>
							<div class="nav-line"></div></li>
						<li><a href="myprograms.html">My Programs</a>
							<div class="nav-line"></div></li>
						<li><a href="#">My Students</a>
							<div class="nav-line"></div></li>
						<li><a href="#" style="margin-left: -10px;">My Locker</a></li>
					</ul>
				</div>
				<!--End menu-->
				<div class="searchpanel">
					<div>
						<form id="ui_element" class="sb_wrapper">
							<span class="sb_down"></span> <input type="text" name="search"
								id="search" placeholder="Search..." title="Search..."
								autosave="unique"
								class="two-left-rounded-box two-right-rounded-box"> <input
								id="submit" type="submit" value="Submit">

							<ul class="sb_dropdown" style="display: none;">
								<li class="sb_filter">Filter your search</li>
								<li><input type="checkbox" /><label for="all"><strong>All
											Categories</strong></label></li>
								<li><input type="checkbox" /><label for="Automotive">Students</label></li>
								<li><input type="checkbox" /><label for="Baby">Locker</label></li>
								<li><input type="checkbox" /><label for="Beauty">Program</label></li>

							</ul>
						</form>
					</div>
				</div>
				<div class="searchoptions">
					<ul class="dropdown nav">
						<li><a href="#linkurl" title="Help"><span
								class="srch-op-a"></span></a></li>


						<li class="dropdown"><a href="#linkurl"
							class="dropdown-toggle js-activated" title="ZInformation"><span
								class="srch-op-b"></span></a>
							<ul class="dropdown-menu">
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zMessage.html">zAnnouncements</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zMeetings.html">zNews</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="">zPoll</a></li>

							</ul></li>

						<li><a href="#" title="ZGoods"><span class="srch-op-e">
							</span></a></li>

						<li class="dropdown"><a href="#linkurl"
							class="dropdown-toggle js-activated" title="ToolZ"><span
								class="srch-op-d"> </span></a>
							<ul class="dropdown-menu">
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zMessage.html">zMessage</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zMeetings.html">zMeetings</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="">zAlerts</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="#linkurl">To Do list</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="#linkurl">zSteps</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zGroups.html">zGroups</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zCollege.html">zCollage</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zDelegate.html">zDelegate</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="#linkurl">zQuestion Bank</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zLibrary.html">zLibrary</a></li>
								<li style="float: left;"><a tabindex="-1" href="#linkurl">zHealthcheck</a></li>



							</ul></li>
						<li class="dropdown"><a href="#linkurl"
							class="dropdown-toggle js-activated" title="Zeni"><span
								class="srch-op-c"> </span></a>
							<ul class="dropdown-menu">
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zRecommend.html">zRecommends</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zReward.html">Rewardz</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zStats.html">zStats</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zAsk.html">Askz</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zCards.html">zcard</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zStrate.html">Stratez</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="../resources/zeni/zClass.html">zClass</a></li>
							</ul></li>

					</ul>
				</div>
			</nav>
		</header>
		<!--End Header Container-->
		<div class="sub-nav">
			<div class="f-l">
				<strong class="text-size-px12 font-Signika blue"><a
					href="#">My Courses </a> > </strong><strong
					class="light-gray text-size-px12">Create New Course </strong>
			</div>
			<div class="f-r">
				<strong class="text-size-px14 light-gray"><a
					href="publish.html">Publish</a> | <a href="defineengagement.html">Manage</a></strong><a
					class="light-blue" href="#"><img width="12" height="12"
					alt="add more" src="../resources/images/plus.png"> </a>
			</div>
		</div>
		<!--Main Content-->
		<span class="for-rounded-box all-box-shadow white-bg"></span>
		<style>
#splitter {
	width: 975px;
	height: auto;
}

#jqxTree {
	height: auto;
	width: auto;
}

#jqxExpander {
	width: 320px;
	height: auto;
}
</style>

		<section>
			<div class="section">
				<div class="col-create"
					style="width: 1000px; background-color: #FFF;">
					<div class="for-rounded-box  all-box-shadow white-bg">



						<!--Wizard start-->
						<div id="page-wrap">

							<ul class="breadcrumb" style="padding: 1px;">
								<li><a href="${createcourselink}"
									style="width: 100px; text-align: center;"><span
										class="bcumb">1.</span> Define Course</a></li>
								<li><a href="${associatecontentlink}"
									style="text-align: center;">2. Associate Content</a></li>
								<li><a href="${enrichcontentlink}"
									style="width: 124px; text-align: center;">3. Enrich Content</a></li>
								<li><a href="modelthinkingdefineassignment.html"
									style="width: 130px; text-align: center;">4. Define
										Assignment</a></li>
								<li><a href="modelthinkingdefineplanner.html"
									style="text-align: center;">5. Define Planner</a></li>
								<li><a href="modelthinkingdefineplaybook.html"
									style="text-align: center;">6. Define Playbook</a></li>
								<li><a href="modelthinkingdefinesocialize.html"
									style="width: 120px; text-align: center;">7. Socialize
										Course</a></li>
								<li></li>
								<!--<li><a href="#">Hidden</a></li>-->
							</ul>

						</div>
						<!--Wizard end  -->


						<!------------------------------------------------------Associate ------------------------------->
						<div class="associate">
							<div class="definecontainer" style="float: left;">
								<p class="definehelp all all-box-shadow"
									style="width: 965px; padding: 5px; font-family: Helvetica; font-weight: bold; font-size: 18px; color: #125F92; height: 30px;">
									<img src="../resources/images/icons/helpicon.png" align="left"
										style="padding-left: 5px; margin-right: 4px; line-height: 28px;" /><b>Right
										Click over the Course Section to Associate Contents to it. </b>
								</p>

								<div id="splitter" style='clear: both;'>

									<div id='jqxWidget'>
										<div id='jqxExpander'>
											<div
												style="background-color: #FFFFFF; border: none; display: none;"></div>
											<div id='jqxTree' style='float: left;'>
												<ul class="jqx-tree-dropdown-root">
													<li item-expanded="true" id="rootLi"
														class="jqx-tree-item-li jqx-disableselect"
														style="float: none;"><span
														style="height: 17px; border: none; background-color: transparent; float: left; width: 16px; margin-top: 3px;"
														id="arrowrootLi" class="jqx-disableselect"></span>
														<div
															style="display: inline-block; -webkit-user-select: none; font-size: 12px; font-weight: bold;"
															class="jqx-rc-all draggable jqx-tree-item jqx-item jqx-draggable"
															id="jqx-draggable-1" unselectable="on">
															<img style="float: left; margin-right: 5px;"
																src="../resources/images/tree.png" id="imgRoot" />Model Thinking
														</div>
														<ul class="jqx-tree-dropdown"
															style="overflow: hidden; display: block;">
															<li item-expanded="true"
																class="jqx-tree-item-li jqx-disableselect"
																style="float: none;"><span
																style="height: 17px; border: none; background-color: transparent; float: left; width: 16px; margin-top: 2px;"></span>
																<div
																	style="display: inline-block; -webkit-user-select: none; font-size: 11px; font-weight: bold;"
																	class="jqx-rc-all draggable jqx-tree-item jqx-item jqx-draggable 
                   jqx-tree-item-selected"
																	id="jqx-draggable-3" unselectable="on">
																	<img style='float: left; margin-right: 5px;'
																		src='../resources/images/led/note.png' id="imgRoot" />Why Model
																	Thinking
																</div>
																<ul class="jqx-tree-dropdown"
																	style="overflow: hidden; display: none;">
																	<li id="menu2" item-expanded="true"
																		class="jqx-tree-item-li jqx-disableselect"
																		style="float: none;"><span
																		style="height: 17px; border: none; background-color: transparent; float: left; width: 16px; visibility: hidden;"
																		class="jqx-disableselect"></span>
																		<div style="display: inline-block; font-size: 10px;"
																			class="righturl jqx-rc-all draggable jqx-tree-item 
       jqx-item jqx-draggable"
																			id="jqx-draggable-8">
																			<a href="treelinks/Why Model.pptx"
																				style="font-size: 10px;"> <img
																				style='float: left; margin-right: 5px;'
																				src='../resources/images/icons/ppt-icon.png' id="imgRoot"
																				height="24" width="24" /> Why Model
																			</a>
																		</div></li>
																	<li id="menu2" item-expanded="true"
																		class="jqx-tree-item-li jqx-disableselect"
																		style="float: none;"><span
																		style="height: 17px; border: none; background-color: transparent; float: left; width: 16px; visibility: hidden;"
																		class="jqx-disableselect"></span>
																		<div style="display: inline-block; font-size: 10px;"
																			class="righturl jqx-rc-all draggable jqx-tree-item jqx-item jqx-draggable"
																			id="jqx-draggable-9">
																			<a class="lbx-70-50"
																				href="treelinks/intelligentcitizen.pdf"
																				style="font-size: 10px;"> <img
																				style='float: left; margin-right: 5px;'
																				src='../resources/images/icons/pdf-icon.png' id="imgRoot"
																				height="24" width="24" /> Intelligent Citizens of <br />the
																				World
																			</a>
																		</div></li>
																</ul></li>
															<li item-expanded="true"
																class="jqx-tree-item-li jqx-disableselect"
																style="float: none;"><span
																style="height: 17px; border: none; background-color: transparent; float: left; width: 16px; margin-top: 2px;"></span>
																<div
																	style="display: inline-block; -webkit-user-select: text; font-size: 11px; font-weight: bold;"
																	class="jqx-rc-all draggable jqx-tree-item jqx-item jqx-draggable"
																	id="jqx-draggable-2" unselectable="off">
																	<img style='float: left; margin-right: 5px;'
																		src='../resources/images/led/note.png' id="imgRoot" /> Aggregation
																</div>
																<ul class="jqx-tree-dropdown"
																	style="overflow: hidden; display: none;">
																	<li id="menu2" item-expanded="true"
																		class="jqx-tree-item-li jqx-disableselect"
																		style="float: none;"><span
																		style="height: 17px; border: none; background-color: transparent; float: left; width: 16px; visibility: hidden;"
																		class="jqx-disableselect"></span>
																		<div style="display: inline-block; font-size: 10px;"
																			class="jqx-rc-all draggable jqx-tree-item jqx-item 
                  jqx-draggable"
																			id="jqx-draggable-5">
																			<a href="treelinks/Aggregation.docx"
																				style="font-size: 10px;"> <img
																				style='float: left; margin-right: 5px;'
																				src='../resources/images/icons/docx-icon.png' id="imgRoot"
																				height="24" width="24" /> Aggregation
																			</a>
																		</div></li>
																	<li item-expanded="true"
																		class="jqx-tree-item-li jqx-disableselect"
																		style="float: none;"><span
																		style="height: 17px; border: none; background-color: transparent; float: left; width: 16px; visibility: hidden;"
																		class="jqx-disableselect"></span>
																		<div style="display: inline-block; font-size: 10px;"
																			class="jqx-rc-all draggable jqx-tree-item 
                     jqx-item jqx-draggable"
																			id="jqx-draggable-6">
																			<img style='float: left; margin-right: 5px;'
																				src='../resources/images/icons/movies.png' id="imgRoot"
																				height="24" width="24" />Six Sigma
																		</div></li>
																	<li item-expanded="true"
																		class="jqx-tree-item-li jqx-disableselect"
																		style="float: none;"><span
																		style="height: 17px; border: none; background-color: transparent; float: left; width: 16px; visibility: hidden;"
																		class="jqx-disableselect"></span>
																		<div style="display: inline-block; font-size: 10px;"
																			class="jqx-rc-all draggable jqx-tree-item jqx-item 
           jqx-draggable"
																			id="jqx-draggable-7">
																			<a href="treelinks/Preference Aggregation.pptx"
																				style="font-size: 10px;"><img
																				style='float: left; margin-right: 5px;'
																				src='../resources/images/icons/ppt-icon.png' id="imgRoot"
																				height="24" width="24" /> Preference Aggregation</a>
																		</div></li>
																</ul></li>
															<li id="menu2" item-expanded="true"
																class="jqx-tree-item-li jqx-disableselect"
																style="float: none;"><span
																style="height: 17px; border: none; background-color: transparent; float: left; width: 16px; margin-top: 2px;"></span>
																<div
																	style="display: inline-block; -webkit-user-select: none; font-size: 11px; font-weight: bold;"
																	class="jqx-rc-all draggable jqx-tree-item jqx-item jqx-draggable"
																	id="jqx-draggable-4" unselectable="on">
																	<img style='float: left; margin-right: 5px;'
																		src='../resources/images/led/note.png' id="imgRoot" />Decision
																	models
																</div>
																<ul class="jqx-tree-dropdown"
																	style="overflow: hidden; display: none;">
																	<li id="menu2" item-expanded="true"
																		class="jqx-tree-item-li jqx-disableselect"
																		style="float: none;"><span
																		style="height: 17px; border: none; background-color: transparent; float: left; width: 16px; visibility: hidden;"
																		class="jqx-disableselect"></span>
																		<div style="display: inline-block; font-size: 10px;"
																			class="jqx-rc-all draggable jqx-tree-item jqx-item 
              jqx-draggable"
																			id="jqx-draggable-10">
																			<a
																				href="http://en.wikipedia.org/wiki/Decision_making"
																				style="font-size: 10px;"><img
																				style='float: left; margin-right: 5px;'
																				src='../resources/images/icons/weblink.png' id="imgRoot"
																				height="24" width="24" /> Introduction to Decision
																				Making</a>
																		</div></li>
																	<li item-expanded="true"
																		class="jqx-tree-item-li jqx-disableselect"
																		style="float: none;"><span
																		style="height: 17px; border: none; background-color: transparent; float: left; width: 16px; visibility: hidden;"
																		class="jqx-disableselect"></span>
																		<div style="display: inline-block; font-size: 10px;"
																			class="jqx-rc-all draggable jqx-tree-item jqx-item 
              jqx-draggable"
																			id="jqx-draggable-11">
																			<img style='float: left; margin-right: 5px;'
																				src='../resources/images/icons/movies.png' id="imgRoot"
																				height="24" width="24" />Probability:The Basics
																		</div></li>
																</ul></li>
														</ul></li>

												</ul>
											</div>
										</div>


										<div id='jqxMenu' class="jqxMenu1">
											<ul>
												<li><img src="../resources/images/plus.png" alt="Add" height="10"
													width="10" style="margin-right: 5px; margin-left: -5px;" />Associate
													Content</li>
												<li><img src="../resources/images/find.png" alt="Find" height="10"
													width="10" style="margin-right: 5px; margin-left: -5px;" />Search
													and Associate Content</li>
												<!-- <li><img src="../resources/images/define.png" alt="Define" height="10" width="10"  style=" margin-right:5px;  margin-left:-5px;"/>View Content</li>
                   <li><img src="../resources/images/edit.png" alt="Edit" height="10" width="10"  style=" margin-right:5px;  margin-left:-5px;"/>Edit Content</li>
                	 <li><img src="../resources/images/cross.png" alt="Delete" height="10" width="10" style=" margin-right:5px; margin-left:-5px;"/>Delete Content</li>-->
											</ul>
										</div>


										<div id='jqxMenu' class="jqxMenu2">
											<ul>
												<li><img src="../resources/images/define.png" alt="Define"
													height="10" width="10"
													style="margin-right: 5px; margin-left: -5px;" />View
													Content</li>
												<li><img src="../resources/images/edit.png" alt="Edit" height="10"
													width="10" style="margin-right: 5px; margin-left: -5px;" />Edit
													Content</li>
												<li><img src="../resources/images/cross.png" alt="Delete"
													height="10" width="10"
													style="margin-right: 5px; margin-left: -5px;" />Delete
													Content</li>
												<li id="videolink2"><a href="enrichcontent2.html"
													class="lbx-video" style="font-size: 10px;"><img
														src="../resources/images/view.png" alt="View" height="10" width="10"
														style="margin-right: 5px; margin-left: -5px;" /> Enhance
														Content</a></li>
											</ul>
										</div>

										<div id='jqxMenu' class="jqxMenu4">
											<ul>
												<li><img src="../resources/images/plus.png" alt="Add" height="10"
													width="10" style="margin-right: 5px; margin-left: -5px;" />Associate
													Content</li>
												<li><img src="../resources/images/find.png" alt="Find" height="10"
													width="10" style="margin-right: 5px; margin-left: -5px;" />Search
													and Associate Content</li>

											</ul>
										</div>


										<div id='jqxMenu' class="jqxMenu3">
											<ul>
												<li><img src="../resources/images/define.png" alt="Define"
													height="10" width="10"
													style="margin-right: 5px; margin-left: -5px;" />View
													Content</li>
												<li><img src="../resources/images/edit.png" alt="Edit" height="10"
													width="10" style="margin-right: 5px; margin-left: -5px;" />Edit
													Content</li>
												<li><img src="../resources/images/cross.png" alt="Delete"
													height="10" width="10"
													style="margin-right: 5px; margin-left: -5px;" />Delete
													Content</li>
												<li><img src="../resources/images/view.png" alt="View" height="10"
													width="10" style="margin-right: 5px; margin-left: -5px;" />
													Enhance Content</li>

											</ul>
										</div>

										<div id='jqxMenu' class="jqxMenu5">
											<ul>
												<li><img src="../resources/images/define.png" alt="Define"
													height="10" width="10"
													style="margin-right: 5px; margin-left: -5px;" />View
													Content</li>
												<li><img src="../resources/images/edit.png" alt="Edit" height="10"
													width="10" style="margin-right: 5px; margin-left: -5px;" />Edit
													Content</li>
												<li><img src="../resources/images/cross.png" alt="Delete"
													height="10" width="10"
													style="margin-right: 5px; margin-left: -5px;" />Delete
													Content</li>
												<li id="videolink3"><a href="enrichcontent3.html"
													class="lbx-video" style="font-size: 10px;"><img
														src="../resources/images/view.png" alt="View" height="10" width="10"
														style="margin-right: 5px; margin-left: -5px;" /> Enhance
														Content</a></li>
											</ul>
										</div>

										<div id='jqxMenu' class="jqxMenu6">
											<ul>
												<li><img src="../resources/images/define.png" alt="Define"
													height="10" width="10"
													style="margin-right: 5px; margin-left: -5px;" />View
													Content</li>
												<li><img src="../resources/images/edit.png" alt="Edit" height="10"
													width="10" style="margin-right: 5px; margin-left: -5px;" />Edit
													Content</li>
												<li><img src="../resources/images/cross.png" alt="Delete"
													height="10" width="10"
													style="margin-right: 5px; margin-left: -5px;" />Delete
													Content</li>
												<li id="videolink2"><a
													href="http://54.243.235.88/ZikDemo/Associate_Content/"
													class="lbx-asso" style="font-size: 10px;"><img
														src="../resources/images/view.png" alt="View" height="10" width="10"
														style="margin-right: 5px; margin-left: -5px;" /> Enhance
														Content</a></li>
											</ul>
										</div>

									</div>
									<!-- Start of content Panel -->
									<div id="ContentPanel"
										style="font-size: 11px; background-image: none;">

										<!-- Start of Default Instruction -->

										<div id="instruction"
											style="padding: 10px; margin-left: 25px;">
											<img src="../resources/images/instruction.png" alt="instructions"
												title="Key-Board instruction" width="660"
												style="border: 1px solid #ccc; padding: 5px;">
										</div>

										<!-- End of Default Instruction  -->


										<br />
										<!-- Start of Associate Content associatedefinecontainer -->
										<div class="definecontainer" id="associatedefinecontainer"
											style="margin-top: -30px;">

											<br />
											<div class="definehelp"
												style="width: 680px; font-family: Helvetica; font-weight: bold; color: #125F92; line-height: 20px;">
												<img src="../resources/images/icons/helpicon.png" align="left"
													style="margin-right: 5px;" />Create new content by either
												uploading an already available content, <br /> providing an
												URL reference or by Creating a document as your content.
											</div>

											<form id="AddModule" class="form-horizontal">
												<!----------------- start of first container --------------->
												<div class="coursename">
													<div class="control-group">
														<label class="control-label labelclass" for="Content Name"
															style="margin-top: -4px;">Content Name:</label>
														<div class="controls">
															<input type="text" id="defaultvalue" class="defaultvalue"
																autofocus placeholder="Specify the name of the Content"
																tabindex="1" style="width: 240px; margin-left: 10px;" />
														</div>

														<br /> <label for="moduledescription" class="labelclass">Content
															Description :</label> <a class="f-r _richText"
															id="associatecontentrichtext" href="#linkurl"
															style="text-decoration: none;">Rich Text Editor</a> <a
															class="f-r _plainText" href="#linkurl"
															style="text-decoration: none;">Plain Text Editor</a>
														<textarea class="_plainTextShow labelclass defaultvalue"
															cols="90" rows="7" style="resize: none;"
															placeholder="Describe the Content being created"></textarea>
														<br />
														<div class="_richTextShow">
															<textarea id="editor1" name="editor1"
																class="defaultvalue _focus" tabindex="2">Describe the Content being created</textarea>
														</div>

													</div>
													<!-- end of coursename--->
												</div>
												<!-- end of control group--->

												<!----------------- start of second container --------------->
												<div class="secondcontainer">
													<div class="control-group">
														<div>
															<label class="labelclass"> Subject Area : </label> <label
																class="labelclass" style="margin-left: 120px;">
																Subject: </label> <label class="labelclass"
																style="margin-left: 155px;"> Topic: </label>
														</div>
														<div class="moduleselection">
															<select name="SelectArea" tabindex="3"
																class="defaultvalue labelclass"
																style="margin-right: 15px; width: 200px;">
																<option>Science</option>
																<option>Computer science</option>
																<option>information and general works</option>
																<option>Philosophy and psychology</option>
																<option>Religion</option>
																<option>Social sciences</option>
																<option>Language</option>
																<option>Technology and applied science</option>
																<option>Arts and recreation</option>
																<option>Literature</option>
																<option>History and geography</option>
															</select> <select name="SelectArea" tabindex="4"
																class="defaultvalue labelclass"
																style="margin-right: 15px; width: 200px;">
																<option>Science</option>
																<option>mathematics</option>
																<option>Astronomy & Allied Sciences</option>
																<option>Physics</option>
																<option>Chemistry & Allied Sciences</option>
																<option>Earth Sciences</option>
																<option>Paleontology; Paleozoology</option>
																<option>Life sciences</option>
																<option>Plants</option>
																<option>Zoological sciences/Animals</option>
															</select> <select name="SelectArea" tabindex="5"
																class="defaultvalue labelclass" style="width: 200px;">
																<option>Theory and Research</option>
																<option>Physiology</option>
																<option>Biochemistry</option>
																<option>Physiological systems of animals</option>
																<option>Not assigned or no longer used</option>
																<option>Physiological systems of plants</option>
																<option>Genetics and evolution</option>
																<option>Ecology</option>
																<option>Natural history of organisms</option>
																<option>Microorganisms</option>
																<option>fungi</option>
																<option>algae</option>
															</select>
														</div>
														<!-- end of moduleselection--->

														<div class="coursetags">
															<br /> <label class="control-label labelclass"
																for="contenttags" style="margin-top: -2px;">Specify
																any tags : </label> <input id="tagfield2" type="text"
																tabindex="6" style="margin-left: 290px;"></input> <br />
														</div>
														<!-- end of coursetags--->
														<img src="../resources/images/icons/upload.png" align="left" /><label
															class="control-label labelclass" for="uploadimage"
															style="margin-top: -2px;">Upload any Image for
															the Content : </label> <input type="file" class="labelclass"
															tabindex="9" />
													</div>
													<!-- end of secondcontainer--->
												</div>
												<!-- end of control group--->


												<div class="forthcontainer">
													<!-- start of forth container--->

													<div class="moduleselection">
														<select name="SelectArea2" tabindex="3"
															class="defaultvalue labelclass" id="q_type"
															style="margin-right: 15px; width: 410px;">
															<option value="Selected">Select how would you
																like to add Content</option>
															<option value="Upload Content">Upload Content</option>

															<option value="External WebPage">Associate URL
																of the Content</option>

															<option value="Create Content">Create Content</option>
														</select>
													</div>
													<!-- end of moduleselection--->
													<br />
													<div id="type-1">
														<img src="../resources/images/icons/upload.png" align="left" /><label
															class="control-label labelclass" for="uploadimage"
															style="margin-top: -2px;">Upload any Image for
															the Content : </label> <input type="file" class="labelclass"
															tabindex="9" />
													</div>
													<!----- end of type=1 --->

													<div id="type-2">
														<label class="control-label labelclass" for="uploadimage"
															style="margin-top: -2px;">Associate URL: </label> <input
															type="text" id="defaultvalue" class="defaultvalue"
															placeholder="Provide the full URL/Web Address including HTTP://"
															tabindex="1" style="width: 310px; margin-left: 10px;" />
													</div>
													<!----- end of type=2 --->

													<div id="type-3">
														<label for="moduledescription" class="labelclass">Content
															Description :</label> <br /> <br />
														<textarea id="editor2" name="editor2" class="defaultvalue">Type the Content Here</textarea>
														<!--<script type="text/javascript">
	CKEDITOR.replace( 'editor2' );
	</script>-->
													</div>
													<!----- end of type=2 --->

												</div>
												<!-- end of forth container--->

												<div class="buttonassoc" style="height: 20px;">
													<a class="cancellinkassociatecontent btn btn-info"
														href="#linkurl"
														style="float: right; margin-right: 20px; text-decoration: none;">
														Cancel </a> <a class="btn btn-info lbx-70-50"
														href="Search& Associate Qualifier.html"
														style="float: right; margin-right: 20px; text-decoration: none;">
														Associate Content </a>

												</div>
											</form>
										</div>
										<!-- End of Associate Content associatedefinecontainer -->




										<!-- Start of Search & Associate Content -->

										<div class="searchassociatecontainer"
											id="Associatecontentsearch"
											style="margin-left: 15px; margin-top: -15px;">
											<br />

											<div class="definehelp"
												style="font-size: 12px; width: 680px; font-family: Helvetica; font-weight: bold; color: #125F92; line-height: 20px;">
												<img src="../resources/images/icons/helpicon.png" align="left"
													style="margin-right: 5px; margin-top: -5px;" />You can
												search for Content that was created by you or others with
												share permission.
											</div>

											<div class="secondcontainer" style="height: 50px;">

												<form id="ui_search" class="sb_qualifier">

													<span class="sb_downq"></span> <input class="sb_inputq"
														type="text"
														placeholder="Provide Name of the Content being searched"
														style="font-size: 13px; width: 305px;" /> <input
														class="sb_searchq" value="" id="btnsearch"
														style="height: -30px;" /> <span><a href="#linkurl"
														class="btn"
														style="margin-top: 4px; margin-left: 2px; height: 18px; text-decoration: none;"
														id="_btnadvanced"> Advanced </a> </span>
													<!--<input   type="submit" value="Advanced" class="btn" style="float:left; margin-top:2px;"/> -->

													<ul class="sb_dropdownq" style="display: none;">
														<li class="sb_filterq">Filter your search</li>
														<li style="padding-right: 90px;"><input
															type="checkbox" /><label for="All">All</label></li>
														<li><input type="checkbox" /><label for="Owned">Owned/Customized
																Content</label></li>
														<br />
														<br />
														<br />
														<li style="padding-right: 5px;"><input
															type="checkbox" /><label for="Institution Specified">Shared
																Content</label></li>
														<li><input type="checkbox" /><label
															for="Institution Specified">Library Content </label></li>

													</ul>
												</form>

												<br /> <br />
											</div>
											<!-- end of secondcontainer--->








											<!----------------- start of first container --------------->
											<div class="coursename" div id="_advanced">
												<div class="control-group">

													<form id="AddModule" class="form-horizontal">
														<legend
															style="font-size: 16px; font-weight: bold; color: #6D9EC5">
															Advanced Search Options</legend>
														<br /> <label class="control-label labelclass"
															for="Content Name" style="margin-top: -4px;">Content
															Name:</label>
														<div class="controls">
															<input type="text" id="defaultvalue" class="defaultvalue"
																autofocus
																placeholder="Provide Name of the Content being searched"
																tabindex="1" style="width: 530px; margin-left: 10px;" />
														</div>

														<br />

														<div>
															<label class="labelclass"> Content Type: </label> <label
																class="labelclass" style="margin-left: 130px;">
																Content Source:</label>
														</div>
														<div class="moduleselection">
															<select name="SelectArea" tabindex="3"
																class="defaultvalue labelclass"
																style="margin-right: 15px; width: 210px;">
																<option>Select type of Content</option>
																<option value="Presentation">Presentation</option>
																<option value="Presentation">Video</option>
																<option value="Presentation">Audio</option>
																<option value="Presentation">Image</option>
																<option value="Presentation">Document</option>
																<option value="Presentation">Others</option>
															</select> <select name="SelectArea" tabindex="4"
																class="defaultvalue labelclass"
																style="margin-right: 15px; width: 210px;">
																<option>Select Source of Content</option>
																<option value="Library">Presentation</option>
																<option value="Owned/Customized">Owned/Customized
																</option>
																<option value="Shared">Shared</option>
																<option value="Locker">Locker</option>
															</select>
														</div>
														<!-- end of moduleselection--->

														<br />

														<div>
															<label class="labelclass"> Content Area: </label> <label
																class="labelclass" style="margin-left: 130px;">
																Content Subject:</label> <label class="labelclass"
																style="margin-left: 110px;"> Content Topic:</label>
														</div>
														<div class="moduleselection">
															<select name="SelectArea" tabindex="3"
																class="defaultvalue labelclass"
																style="margin-right: 15px; width: 210px;">
																<option>Select Content Area</option>
															</select> <select name="SelectArea" tabindex="4"
																class="defaultvalue labelclass"
																style="margin-right: 15px; width: 210px;">
																<option>Select Content Subject</option>
															</select> <select name="SelectArea" tabindex="5"
																class="defaultvalue labelclass" style="width: 210px;">
																<option>Select Content Topic</option>
															</select>
														</div>
														<!-- end of moduleselection--->

														<div class="coursetags">
															<br /> <label class="control-label labelclass"
																for="contenttags" style="margin-top: -2px;">Specify
																any tags: </label> <input id="tagfield3" type="text"
																tabindex="6" style="margin-left: 290px;"></input>
														</div>
														<!-- end of coursetags--->

														<input type="button" class="btn btn-info" value="Search"
															style="float: right; margin-right: 20px;"
															id="btnadvsearch"> <br />
													</form>
												</div>
												<!-- end of coursename--->
											</div>
											<!-- end of control group--->



											<!----------------- start of second container --------------->
											<div class="secondcontainer" id="showsearchcontainer">
												<div class="control-group">

													<form id="search results" class="form-horizontal">
														<fieldset>
															<legend
																style="font-size: 16px; font-weight: bold; font-family: Verdana; color: #6D9EC5; margin-bottom: 8px;">
																Search Results</legend>
															<table align="center" id="tblqualifier"
																class="table reviewtable">
																<thead>
																	<tr style="background-color: #E1E8F0;">
																		<th></th>
																		<th>Defined by</th>
																		<th>Type</th>
																		<th>Name</th>
																		<th>Course/LO</th>
																		<th>Usage Permissions</th>
																		<th>Ziks</th>
																		<th>Description</th>
																		<th></th>
																	</tr>
																</thead>
																<tbody>
																	<tr>
																		<td><input type="checkbox" /></td>
																		<td>Author's Name</td>
																		<td>Video</td>
																		<td><a class="lbx-70-50" href="#linkurl">Intro
																				to Trigonometry </a></td>
																		<td>------</td>
																		<td>Can Edit</td>
																		<td>10</td>
																		<td>All Concepts of Trigonometry</td>
																		<td><a title="View" class="lbx-70-50"
																			href="#linkurl"><img
																				src="../resources/images/led/application_osx.png" /></a></td>


																	</tr>
																	<tr>
																		<td><input type="checkbox" /></td>
																		<td>Me</td>
																		<td>Document</td>
																		<td><a class="lbx-70-50" title="View"
																			href="#linkurl">Basics of Algebra </a></td>
																		<td>Maths 101</td>
																		<td>Owner</td>
																		<td>--</td>
																		<td>Basic concepts of Algebra..</td>
																		<td><a title="View" class="lbx-70-50"
																			href="#linkurl"><img
																				src="../resources/images/led/application_osx.png" /></a></td>
																	</tr>

																</tbody>
															</table>




															<a class="cancellinkassociatecontent btn btn-info"
																href="#linkurl"
																style="float: right; margin-right: 20px; text-decoration: none;">
																Cancel </a> <a class="btn btn-info lbx-70-50"
																href="Search& Associate Qualifier.html"
																style="float: right; margin-right: 20px; text-decoration: none;">
																Associate Content </a>
														</fieldset>
													</form>

												</div>
												<!-- end of secondcontainer--->
											</div>
											<!-- end of control group--->


										</div>

										<!-- End of Search & Associate Content -->
									</div>
									<!-- end of Content Panel -->

								</div>
								<!-- end tree function -->
								<br /> <br /> <a class="btn btn-info f-r"
									id="saveBottomAssociate" style="margin-right: -250px;">Save
									and Continue</a>

							</div>

						</div>

						<!----------------end of associate content ------------------------->



						<!--End Center Container-->
					</div>
				</div>
			</div>
		</section>
		<!--End Main Content-->
		<!--Current Progress-->
		<div class="col border-top">
			<div class="collapse">
				<h3 class="border-left border-right border-top">Your current
					progress [ Starting ... ]</h3>
				<div>
					<p class="caption text-size-px18">Your progress this session...
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

			//rating-star	
			$('#edu-star').raty({

				click : function(score, evt) {
					$(this).fadeOut(function() {
						$(this).fadeIn();
					});
				},
				targetKeep : true,
				path : '../resources/images/img/',
				score : 4,
				cancel : true
			});
		</script>


		<!--End Current Progress-->
		<!--Footer Container-->
		<footer> </footer>
		<!--End Footer Container-->
	</div>
    
     
    <script type="text/javascript" src="../resources/js/widget/jquery-ui-personalized-1.6rc2.min.js"></script>
</body>
</html>
