<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
	src="${staticFileServer}resources/js/lib/tree/treedata.js"></script>

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

<script type="text/javascript"
	src="${staticFileServer}resources/js/lib/splitter/jquery-1.4.3.min.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/lib/splitter/splitter.js"></script>


<script type="text/javascript">
	$(document).ready(function() {
		$("#splitterContainer").splitter({
			minAsize : 100,
			maxAsize : 800,
			splitVertical : true,
			A : $('#leftPane'),
			B : $('#rightPane'),
			//slave : $("#rightSplitterContainer"),
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
	function showrich() {
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
	}
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

	<div class="contentarea">

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
				<div class="Addmodulecontainer" id="Addmodulecontainer"
					style="padding: 10px;">
					<form id="AddModule" method="post" class="form-horizontal">
						<input type="hidden" id="courseid" value="${courseId}" /> <input
							type="hidden" id="courseLearningComponentId" value="" /> <input
							type="hidden" id="parentLearningComponentId" value="" /> <input
							type="hidden" id="learningComponentId" value="" />
						<!--module form-->
						<!--Course Name-->
						<div class="control-group">
							<label class="control-label nexaf" for="Course Name">Module
								Name :</label>
							<div class="controls">
								<input type="text" class="span6" id="Course_Module"
									placeholder="Course Name" style="margin-left: -45px;" />
							</div>
						</div>

						<!--end of course name-->

						<br /> <label for="Course Description" class="labelclass"
							style="font-weight: bold;"><b>Course Description :</b></label> <a
							class="f-r _plainText" id="plainText" href="#"
							style="text-decoration: none;" onclick="showplain()">Rich
							Text Editor</a> <a class="f-r _richText" id="richText" href="#"
							style="text-decoration: none; display: none;"
							onclick="showrich()">Plain Text Editor</a>
						<textarea cols="124" rows="8" id="Module_Description"
							class="_plainTextShow defaultvaluem labelclass"
							style="width: 98%; color: #666;"> 
											</textarea>
						<br />
						<div class="_richTextShow" style="display: none;">
							<textarea id="Cmoduledescrte" name="editor1pageload"
								class="defaultvalue _focus">
													<b>Describe the Module being created</b>
												</textarea>
						</div>
						<script type="text/javascript">
							CKEDITOR.replace('Cmoduledescrte');
						</script>
						<div class="control-group" style="margin-top: 20px;">
							<div>
								<label class="labelclass nexaf f-l"> Module Area : </label> <label
									class="labelclass nexaf f-l" style="margin-left: 130px;">
									Module Subject: </label> <label class="labelclass nexaf f-l"
									style="margin-left: 110px;"> Module Topic: </label>
							</div>
							<div class="clearfix"></div>
							<div class="moduleselection">
								<select name="s_example" id="Careaddl" class="select"
									onclick="getArea();">
									<option value="0">choose a option...</option>
								</select> <select name="s_example" class="select" id="Csubjectddl">
									<option value="0">choose a option...</option>
								</select><select name="s_example" class="select" id="Ctopicddl">
									<option value="0">choose a option...</option>
								</select>
							</div>
							<!-- <div class="moduleselection">
								<select name="Cmoduleareaddl" id="Cmoduleareaddl"
									class="defaultvalue labelclass" onclick="getArea();">
									<option value="0">choose a option...</option>
								</select> <select name="Cmodulesubjectddl" id="Cmodulesubjectddl"
									class="defaultvalue labelclass" style="margin-right: 30px;">
									<option value="0">choose a option...</option>
								</select> <select name="Cmoduletopicddl" id="Cmoduletopicddl"
									class="defaultvalue labelclass" style="margin-right: 0px;">
									<option value="0">choose a option...</option>
								</select>

							</div> -->
							<!-- end of moduleselection--->

						</div>
						<!--end of Subject Selection-->
						<!--<div class="control-group" style="width: 69%">
												<label class="control-label nexaf" for="Specify Tags">Specify
													Tags :</label>
												<div class="controls">
													<input id="Ctagfield_e" type="text" class="tags"
														value="Computer Science, Literature, History" />
												</div>
											</div> -->
						<button class="btn f-r" type="button" style="margin-right: 10px;">Cancel</button>
						<button class="btn f-r" type="button"
							onClick="getaddmodulesave();return false;"
							style="margin-right: 20px;">Submit</button>

						<div class="Clearfix"></div>

						<!--module form-->
					</form>
				</div>
			</div>
			<!-- #rightPane -->
		</div>
		<div class="Clearfix"></div>
		<button class="btn f-r" type="button" style="margin-right: 30px;">Save
			and Continue</button>
		<!-- <div id='jqxWidget' style='display: none;'>
								<div id="splitter" style='clear: both;'>

									Start of Tree
									

									End of Tree

									<div class="splitter-panel">
										
										End of Add Module

									</div>
									End of splitter-panel

								</div>
								End of splitter
							</div> -->
		<!--End of jqxWidget-->
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