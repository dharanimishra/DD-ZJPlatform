<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="createcourselink" value="/secure/createcourse" />
<c:url var="associatecontentlink" value="/secure/associatecontent" />
<c:url var="enrichcontentlink" value="/secure/enrichcontent" />
<c:url var="assignmentlink" value="/secure/createassignment" />


<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>Enrich Content</title>
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
<link href="../resources/css/assignment.css" rel="stylesheet" type="text/css">
<link rel='stylesheet' type='text/css' href="../resources/css/nav.css" />
<!--End Body Style sheet-->

<script type="text/javascript" src="../resources/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="../resources/js/ckeditor/adapters/jquery.js"></script>
<script type="text/javascript" src="../resources/js/ckeditor/ckeditor.js"></script>
<script src="../resources/js/custom.js" type="text/javascript"></script>
<script type="text/javascript" src="../resources/js/video_player.js"></script>
<script type='text/javascript' src="jwplayer/swfobject.js"></script>
<script type="text/javascript" src="jwplayer/jwplayer.js"></script>
<!-- css for tree -->
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
<script type="text/javascript" src="../resources/js/tree/myTreeEnrich.js"></script>
<script type="text/javascript" src="../resources/js/tree/splitter.js"></script>
<script type="text/javascript" src="../resources/js/tree/jqxexpander.js"></script>

<!-- End tree -->
<link rel="stylesheet" type="text/css"
	href="../resources/js/ui/jquery.fancybox-1.3.4.css" media="screen" />
<script type="text/javascript"
	src="../resources/js/ui/jquery.mousewheel-3.0.4.pack.js"></script>
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

.breadcrumb li:nth-child(3) a {
	background: hsla(34, 85%, 25%, 1);
	color: #ccc;
	text-shadow: 1px 1px 2px rgba(34, 29, 29, 1);
}

.breadcrumb li:nth-child(3) a:after {
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
								class="srch-op-b"></a>
							<ul class="dropdown-menu">
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="zeni/zMessage.html">zAnnouncements</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="zeni/zMeetings.html">zNews</a></li>
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
									href="zeni/zMessage.html">zMessage</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="zeni/zMeetings.html">zMeetings</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="">zAlerts</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="#linkurl">To Do list</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="#linkurl">zSteps</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="zeni/zGroups.html">zGroups</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="zeni/zCollege.html">zCollage</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="zeni/zDelegate.html">zDelegate</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="#linkurl">zQuestion Bank</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="zeni/zLibrary.html">zLibrary</a></li>
								<li style="float: left;"><a tabindex="-1" href="#linkurl">zHealthcheck</a></li>



							</ul></li>
						<li class="dropdown"><a href="#linkurl"
							class="dropdown-toggle js-activated" title="Zeni"><span
								class="srch-op-c"> </span></a>
							<ul class="dropdown-menu">
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="zeni/zRecommend.html">zRecommends</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="zeni/zReward.html">Rewardz</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="zeni/zStats.html">zStats</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="zeni/zAsk.html">Askz</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="zeni/zCards.html">zcard</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="zeni/zStrate.html">Stratez</a></li>
								<li style="float: left;"><a tabindex="-1" class="lbx-zeni"
									href="zeni/zClass.html">zClass</a></li>
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
		<section>
			<div class="section">
				<div class="col-create"
					style="width: 1000px; background-color: #FFFFFF;">
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
								<li><a href="${assignmentlink}"
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
									style="width: 965px; padding: 5px; font-family: Helvetica; font-weight: bold; font-size: 18px; color: #125F92;">
									<img src="../resources/images/icons/helpicon.png" align="left"
										style="padding-left: 5px; margin-right: 4px; line-height: 28px;" /><b>You
										can enrich your Video content by associating related
										materials/notes at different points in the video timeline. <br>
										Right Click over the Course Content to enrich it.
									</b>
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
															style="display: inline-block; -webkit-user-select: none; font-size: 11px; font-weight: bold;"
															class="jqx-rc-all draggable jqx-tree-item jqx-item jqx-draggable"
															id="jqx-draggable-1" unselectable="on">
															<img style="float: left; margin-right: 5px;"
																src="../resources/images/tree.png" id="imgRoot">Model Thinking
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
																				src='../resources/images/icons/enhance.png' id="imgRoot"
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



										<div id='jqxMenu' class="jqxMenu3">
											<ul>
												<li id="videocontainer2"><img src="../resources/images/view.png"
													alt="View" height="10" width="10"
													style="margin-right: 5px; margin-left: -5px;" /> Enrich
													Content</li>
											</ul>
										</div>


									</div>

									<div id="ContentPanel"
										style="font-size: 11px; margin-left: 85px;"></div>
									<!-- End of Content Panel -->

								</div>
								<!-- end tree function -->
								<br /> <br /> <a class="btn btn-info f-r"
									id="saveBottomAssociate" style="margin-right: -250px;">Save
									and Continue</a>

							</div>

						</div>

						<!----------------end of associate ------------------------->



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



</body>
</html>
