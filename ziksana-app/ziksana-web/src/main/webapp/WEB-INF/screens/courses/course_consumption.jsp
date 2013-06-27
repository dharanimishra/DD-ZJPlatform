

<script type="text/javascript"
	src="${staticFileServer}resources/Dynamicjsonjs/z_message.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/Dynamicjsonjs/z_simulation_message.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/Dynamicjsonjs/Addmoduledynamicjson.js"></script>



<!--Script for the Tree -->
<script src="${staticFileServer}resources/js/lib/tree/Common/common.js"></script>
<script src="${staticFileServer}resources/js/lib/tree/Common/dtree.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/lib/tree/Menu/menu.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/lib/tree/Menu/menu_ext.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/lib/tree/content-consumption-treedata.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/ziksana/common/session-storage/main.js"></script>

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
<script type="text/javascript"
	src="${staticFileServer}resources/js/tree/jqxexpander.js"></script>
<link rel="stylesheet" type="text/css"
	href="${staticFileServer}resources/css/common/tree/menu.css" />

<link rel="stylesheet" type="text/css"
	href="${staticFileServer}resources/js/lib/splitter/splitter.css" />

<link rel="stylesheet" type="text/css"
	href="${staticFileServer}resources/css/associatecontent.css" />


<script type="text/javascript"
	src="${staticFileServer}resources/js/ziksana/content-consumption/content-consumption.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/ziksana/common/session-storage/main.js"></script>
	


 <style>
.tbboxheadfnt {
    color: #8B8B8B;}
.tbboxdesc p {
    color: #B1B1B1;
    font-family: 'segoe ui',sans-serif;
    font-size: 14px!important;
    font-weight: 100;
}
.tbboxdesc {
    float: none;
    margin-top: 0;
    width: 328px;
}
.tbboxheadfntds {
    color: #4BB1CF;}
.tbboxdescds p {
    color: #4BB1CF;
    font-family: 'Segoe UI Light','Open Sans',Verdana,Arial,Helvetica,sans-serif;
    font-size: 13px!important;
}
.badge-warning{background-color: #999999;}
#enrichtab .badge1{background-color: #F89406}
</style> 
<style>
.ds {
	margin-left: 40px;
	color: #0a91ac !important;
}
#splitterContainer { /* Main splitter element */
	overflow-x:hidden;
}
 
</style>
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

<div id="formcontainer">

	<div id="page-header-div" class="page-header"
		style="padding-left: 0px !important; margin-bottom: 0px !important;">
		<div class="icon">
			<img
				src="${staticFileServer}resources/images/icons/information_icon.png"
				style="height: 25px;" />
		</div>
		<h1>Course consumption for Learner</h1>
	</div>
	<!--End of page-header -->

	<div class="clearfix"></div>

	<div style="min-height: 400px;">

		<!-- BEGIN FORM-->
		<div id="splitterContainer">
			<div id="leftPane">
				<div id="treeboxbox_tree" style="width: 250px;" class="dhtmlxTree"
					setImagePath="${staticFileServer}resources/js/ziksana/jquerylibrary/tree/treeimages/csh_bluebooks/">
				</div>
			</div>
			<div id="splitbarV" class="splitbarV"> </div>
			 
			<!-- #leftPane -->
			<div id="rightPane">
				<div id="recorded_content_container" style="display:none;width:100%">
					<iframe src="" width="1050" height="591"></iframe>
				</div>
				<div class="definecontainer" id="definetab">
				<form onload="" id="contentConsuptionForm" action="/ziksana-web/zcourse/1/contentconsuption" method="POST">
					<input type="hidden" id="courseid" value="${courseId}" /> 
					<input type="hidden" id="itemsToBeDisplayedPerPage" value="${itemsPerPage}" /> 
					<input type="hidden" id="courseLearningComponentId" value=""/> 
					<input type="hidden" id="parentLearningComponentId" value="" /> 
					<input type="hidden" id="learningComponentId" value="" />
					<input type="hidden" id="selectedLearningComponentId" value="" />
					<input type="hidden" id="selectedLearningContentList" value="" />
					<input type="hidden" id="learingContents" value='${learningContentAsJSONString}'/>
					<input type="hidden" id="staticFileServer" value='${staticFileServer}'/>
					<input type="hidden" id="fileServerPath" value='${ms.uploadContent}'/>
					<!--
					<input type="hidden" id="learingContents" value='{"learningContents": [{"id": "1", "contentType": "2", "contentPath": "/document/f1358616560/f1358616560.pdf", "contentName": "test1","ContentDescription": "this is a test", "ThumbnailPicturePath": "document/f1358616560/thumbnails/"},{"id": "2", "contentType": "1", "contentPath": "/document/f1358616560/f1358616560.pdf", "contentName": "test2", "ContentDescription": "test2", "ThumbnailPicturePath": "document/f1358616560/thumbnails/"},{"id": "3", "contentType": "3", "contentPath": "/document/f1358616560/f1358616560.pdf", "contentName": "test3", "ContentDescription": "test3", "ThumbnailPicturePath": "document/f1358616560/thumbnails/"}]}' />
					<input type="hidden" id="learingContents" value='${learningContentAsJSONString}'/>
					-->
					 

					<div id="gggg" style="font-size: 10px; margin-bottom: 10px;">
						 
 
							<div id="ContentPanel2"
								style="font-size: 11px; background-image: none; margin-left: 15px;display:none">


								<!--start of associate content container-->

								<div id="associatewrapper">
									<div id="associateul">
										<div class="ClearFix"></div>

									</div>
									<!--end of associateul-->

									<div id="noContentFound" style="margin: auto; text-align: center; color: rgb(255, 255, 255); font-weight: bold; font-size: 15px; padding: 20px;">										
									</div>
									<div id="page1">
									</div>
									<!--end of page 1-->
									<div id="pageNumbers" class="paginationbutton f-r" style="padding:10px">
									</div>
									<!--end of paginationbutton-->

								</div>
								<!--end of associatewrapper-->



								<div class="ClearFix"></div>

							</div>
							<!-- Content Panel End -->
						 
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

	<script>
		//var abc = '${learningContentAsJSONString}';
		//alert("abc " + abc);
		//sessionStorage.setItem('contentList',  abc );
		//alert("got the value " + sessionStorage.getItem('contentList'));
		//var someText = sessionStorage.getItem('contentList');
		//alert("test length is " + jQuery.parseJSON(someText).length);
		// do not delete this right now storing in session but while getting back throws error because of special characters
   </script>
    
   <script>
 $(function(){
	$('#splitbarV').click(function(){
		//console.log("hello");
		leftpane = $('#leftPane');
		if(leftpane.hasClass('hidden')){
			leftpane.removeClass('hidden').show();
		} else {
			leftpane.addClass('hidden').hide();
		}
	});
	});
 </script>
 <style>
 #treeboxbox_tree{overflow:auto!important}
 </style>