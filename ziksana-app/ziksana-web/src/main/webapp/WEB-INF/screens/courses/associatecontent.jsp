

<script type="text/javascript"
	src="${staticFileServer}resources/Dynamicjsonjs/z_message.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/Dynamicjsonjs/z_simulation_message.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/Dynamicjsonjs/Addmoduledynamicjson.js"></script>
<script type='text/javascript'
	src='${staticFileServer}resources/js/lib/jquery/jquery-1.9.1.min.js'></script>

<script type='text/javascript'
	src='${staticFileServer}resources/js/lib/jquery/jquery-ui-1.10.1.custom.min.js'></script>
<!--Script for the Tree -->
<script src="${staticFileServer}resources/js/lib/tree/Common/common.js"></script>
<script src="${staticFileServer}resources/js/lib/tree/Common/dtree.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/lib/tree/Menu/menu.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/lib/tree/Menu/menu_ext.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/lib/tree/associate-content-treedata.js"></script>
	

<!-- Added JS FILE  -->

<%-- <script type="text/javascript"
	src="${staticFileServer}resources/js/ziksana/coursecreation/define.js"></script> --%>
<!-- scripts for tree -->
<script type="text/javascript"
	src="${staticFileServer}resources/js/tree/gettheme.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/tree/core.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/tree/buttons.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/tree/scrollbar.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/tree/panel.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/tree/dragdrop.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/tree/tree.js"></script>

<script type="text/javascript"
	src="${staticFileServer}resources/js/tree/tooltip.js"></script>

<script type="text/javascript"
	src="${staticFileServer}resources/js/tree/menujq.js"></script>
<%-- <script type="text/javascript"
	src="${staticFileServer}resources/js/tree/myTree.js"></script> --%>
<%-- <script type="text/javascript"
	src="${staticFileServer}resources/js/tree/splitter.js"></script> --%>
<script type="text/javascript"
	src="${staticFileServer}resources/js/tree/jqxexpander.js"></script>
<link rel="stylesheet" type="text/css"
	href="${staticFileServer}resources/css/common/tree/menu.css" />

<link rel="stylesheet" type="text/css"
	href="${staticFileServer}resources/js/lib/splitter/splitter.css" />

<link rel="stylesheet" type="text/css"
	href="${staticFileServer}resources/css/associatecontent.css" />

<script type="text/javascript"
	src="${staticFileServer}resources/js/lib/splitter/jquery-1.4.3.min.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/lib/splitter/splitter.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/ziksana/associate-content/associate-content.js"></script>


<script type="text/javascript">
	$(document).ready(function() {
		$("#splitterContainer").splitter({
			minAsize : 100,
			maxAsize : 800,
			splitVertical : true,
			A : $('#leftPane'),
			B : $('#rightPane'),
			slave : $("#rightSplitterContainer"),
			closeableto : 0
		});
	});
</script>
<style>
.ds {
	margin-left: 40px;
	color: #0a91ac !important;
}
</style>
<script type="text/javascript">
	/* function showrich() {
		$('._richTextShow').css("display", "none");
		$('#richText').css("display", "none");
		$('._plainTextShow').show();
		$('#plainText').css("display", "block");
	}
	function showplain() {

		$('._richTextShow').css("display", "block");
		$('#richText').css("display", "block");
		$('._plainTextShow').css("display", "none");
		$('#plainText').css("display", "none");
	} */
	function getArea() {

		$
				.get(
						'/ziksana-web/zcourse/getsubjectarea',
						{},
						function(data) {
							options = data;
							var option_string = '';
							for (i in options) {
								label = options[i].label;
								value = options[i].value;
								if (i == 0) {
									option = '<option selected="selected" value="' + value
						+ '">'
											+ label + '</option>';
								} else
									option = '<option value="' + value + '">'
											+ label + '</option>';

								option_string += option;
							}
							$('#Cmoduleareaddl').html(option_string);

						});

		$("#Cmoduleareaddl")
				.change(
						function(e) {
							token = '';
							request_type = 'GET';
							uri = '/ziksana-web/zcourse/getsubject';

							var Course_Area = '';
							Course_Area = $('#Cmoduleareaddl').val();
							$
									.get(
											uri,
											{
												'Course_Area' : Course_Area
											},
											function(data) {
												options = data;
												var option_string = '';
												var area_string = '<option selected="selected" value='+Course_Area+'>'
														+ Course_Area
														+ '</option>';
												option_string += '<option selected="selected" value="Select Subject">Select Subject</option>';
												for (i in options) {
													label = options[i].label;
													value = options[i].value;
													if (i == 0) {
														option = '<option  value="'
										+ value
										+ '">'
																+ label
																+ '</option>';
													} else

														option = '<option value="'
										+ value
										+ '">'
																+ label
																+ '</option>';

													option_string += option;
												}

												$('#Cmoduleareaddl').html(
														area_string);
												$('#Cmodulesubjectddl').html(
														option_string);

											});
							var topic = '<option value="Select Topic">Select Topic</option>';
							$('#Cmoduletopicddl').html(topic);
						});

		$("#Cmodulesubjectddl")
				.change(
						function(e) {
							console.log("Inside subject change handler");
							uri = '/ziksana-web/zcourse/gettopic';
							token = '';
							request_type = 'GET';
							var Course_Subject = $('#Cmodulesubjectddl').val();
							var parameters = {
								"Course_Subject" : Course_Subject
							};

							$
									.get(
											uri,
											{
												'Course_Subject' : Course_Subject
											},
											function(data) {
												options = data;
												var option_string = '';
												option_string += '<option selected="selected" value="Select Topic">Select Topic</option>';
												for (i in options) {
													label = options[i].label;
													value = options[i].value;
													if (i == 0) {
														option = '<option value="'
										+ value
										+ '">'
																+ label
																+ '</option>';
													} else

														option = '<option value="'
										+ value
										+ '">'
																+ label
																+ '</option>';

													option_string += option;
												}

												$('#Cmoduletopicddl').html(
														option_string);

											});

						});
	} // End getArea()
</script>
<style>
#splitter {
	width: 100%;
	height: auto;
}

#jqxTree {
	height: auto;
	width: auto;
}
</style>


<div class="navheadlp" style="padding-left: 151px;">
	<ul>
		<li style="margin-left: 40px;"><span><img
				src="/ziksana-web/resources/images/navarrowb.png"
				style="margin-right: 10px; height: 22px;"> </span> Describe Course</li>
		<li style="color: #f06c0b;"><span><img
				src="/ziksana-web/resources/images/navarrow.png"
				style="margin-right: 10px; height: 22px;"> </span> Define Structure</li>
		<li><span><img
				src="/ziksana-web/resources/images/navarrowb.png"
				style="margin-right: 10px; height: 22px;"> </span> Associate Content</li>
		<li><span><img
				src="/ziksana-web/resources/images/navarrowb.png"
				style="margin-right: 10px; height: 22px;"> </span> Define Assignment</li>

	</ul>

</div>
<div id="formcontainer">

	<div class="page-header"
		style="padding-left: 0px !important; margin-bottom: 0px !important;">
		<div class="icon">
			<img
				src="${staticFileServer}resources/images/icons/information_icon.png"
				style="height: 25px;" />
		</div>
		<h1>Organize your course into course modules/chapters</h1>
	</div>
	<!--End of page-header -->

	<div class="clearfix"></div>

	<div>

		<!-- BEGIN FORM-->
		<div id="splitterContainer">
			<div id="leftPane">
				<div id="treeboxbox_tree"
					style="overflow: scroll; overflow-y: hidden;" class="dhtmlxTree"
					setImagePath="${staticFileServer}resources/js/ziksana/jquerylibrary/tree/treeimages/csh_bluebooks/">
				</div>
			</div>
			<!-- #leftPane -->
			<div id="rightPane">
				<div class="definecontainer" id="definetab">
				<form onload="getAllLearningContents()">
					<input type="hidden" id="courseid" value="${courseId}" /> 
					<input type="hidden" id="courseLearningComponentId" value=""/> 
					<input type="hidden" id="parentLearningComponentId" value="" /> 
					<input type="hidden" id="learningComponentId" value="" />
					<!--
					<input type="hidden" id="learingContents" value='{"learningContents": [{"id": "1", "contentType": "2", "contentPath": "/document/f1358616560/f1358616560.pdf", "contentName": "test1","ContentDescription": "this is a test", "ThumbnailPicturePath": "document/f1358616560/thumbnails/"},{"id": "2", "contentType": "1", "contentPath": "/document/f1358616560/f1358616560.pdf", "contentName": "test2", "ContentDescription": "test2", "ThumbnailPicturePath": "document/f1358616560/thumbnails/"},{"id": "3", "contentType": "3", "contentPath": "/document/f1358616560/f1358616560.pdf", "contentName": "test3", "ContentDescription": "test3", "ThumbnailPicturePath": "document/f1358616560/thumbnails/"}]}' />
					-->
					<input type="hidden" id="learingContents" value='${learningContentAsJSONString}'/>
					<style>
#splitter {
	width: 100%;
	height: auto;
}

#jqxTree {
	height: auto;
	width: auto;
}
</style>

					<div id="gggg" style="font-size: 10px; margin-bottom: 10px;">
						<div id="splitter" style='clear: both;'>

							<!-- Start of Tree -->
							<div id="treeboxbox_tree" style="padding: 5px;"
								class="dhtmlxTree"
								setImagePath="js/ziksana/jquerylibrary/tree/treeimages/csh_bluebooks/">
							</div>


							<!-- End of Tree -->

							<div id="ContentPanel2"
								style="font-size: 11px; background-image: none; margin-left: 15px;">


								<!--start of associate content container-->

								<div id="associatewrapper">

									<div id="associateul">
										<div id="content_type_filter">
											<a href="#" class="active_filter" onclick="getAllLearningContents()">All</a><a href="#" onclick="getLearningContentsByType('VIDEO')">Video
												Contents</a><a href="#" onclick="getLearningContentsByType('LINK')">Web Link Contents</a><a href="#" onclick="getOtherLearningContents('Others')">Others</a>
										</div>
										<!--  <p style="font-size:14px; color:#0a91ac; cursor:pointer; text-align: right; "><a href="#linkurl" id="cereatecontent"> Create Content </a></p>
 <p class="associatecategory">Sort by : <a href="#linkurl">Tag</a>/<a href="#linkurl">Category</a>/<a href="#linkurl">Name </a></p>
<p class="associatesearch"> 
 <form method="get" action="/search" id="search" style="margin-bottom:0;">
 <input type="text" id="field" name="q" placeholder="Search" />
 <div id="delete"><span id="x">x</span></div>
 </form>
 </p>  -->

										<div class="ClearFix"></div>

									</div>
									<!--end of associateul-->



									<div id="page1">


									</div>
									<!--end of page 1-->
									<div class="paginationbutton f-r" style="margin-top: -15px;">
										<!-- <a class="cancel" href="associatecontent.html">Cancel</a> -->
										<a href="#linkurl" id="btnpg1" class="swShowPage"
											style="background-color: rgb(41, 147, 221);"></a> <a
											href="#linkurl" id="btnpg2" class="swShowPage"></a> <a
											href="#linkurl" id="btnpg3" class="swShowPage"></a>

									</div>
									<!--end of paginationbutton-->

									<p style="text-align: right; clear: both;">
										<a target="" style="" href="associatecontent.html"
											class="btn btn-info">Associate Content</a> <a target=""
											style="" href="associatecontent.html" class="btn btn-danger">Cancel</a>
									</p>
								</div>
								<!--end of associatewrapper-->



								<div class="ClearFix"></div>
							</div>
							<!-- Content Panel End -->
						</div>
						<!-- end of definecontainer--->
						<div class="ClearFix"></div>



						<!------------------------------- end of first Tab ---------------------------------------------->

						<!--End Center Container-->

					</div>
					</form>
				</div>
			</div>
			<!-- #rightPane -->
		</div>
		<div class="Clearfix"></div>
		<!-- END FORM -->

	</div>
	<!--End of contentarea -->

</div>
<!--End of definestructureformcontainer -->

</div>
<!--end of contentpanel-->


</div>
</section>
</div>
<div class="Clearfix"></div>
<div class="Clearfix"></div>
</div>