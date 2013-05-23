<script type='text/javascript'
	src="${staticFileServer}resources/js/lib/plupload/previewupload.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/custom/createcontent/addweblink.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/Dynamicjsonjs/weblinkcontentjson.js"></script>
<style>
.tileheadaa {
	margin-left: 20px;
	font-size: 20px;
	font-size: 30px;
}

table tr th {
	color: #fff;
	font-size: 18px;
	border: none !important;
}

table tr td {
	color: #fff;
	font-size: 18px;
	border: none !important;
}

.table-hover tbody tr:hover td,.table-hover tbody tr:hover th {
	background-color: rgba(206, 204, 204, 0.27);
}
</style>

<div id="Zikbreadcrumbback" style="margin-left: 20px;">
	<div class="Zikbreadcrumb f-l">
		<div class="fifteen columns" id="page-title">
			<a style="margin-top: -3px;" class="back"
				href="javascript:history.back()"></a>
			<p class="page-title">
				<span style="font-size: 13px; color: #6bbde8;">Home</span> < Create
				Content
			</p>
		</div>
	</div>
	<!--end of breadcrumb-->
</div>

<div class="Clearfix"></div>
<div id="contentpanel">
	<div class="tilecontainer pull-left"
		style="margin-top: 40px; width: 140px;">
		<div class="tile bg-color-orange icon" id="uploadbtn" style="">
			<div class="tile-content">
				<img src="${staticFileServer}resources/images/content/upload.png" />
			</div>
			<div class="brand">
				<h3 style="margin-left: 10px; font-size: 16px; width: 160px;">
					<a href="/ziksana-web/zcourse/1/createcontent"></a>Upload Content
				</h3>
			</div>
		</div>


		<div class="tile bg-color-grayDark icon" id="addweblinkbtn" style="">
			<div class="tile-content">
				<img src="${staticFileServer}resources/images/content/link.png" />
			</div>
			<div class="brand">
				<h3 style="margin-left: 10px; font-size: 16px; width: 160px;">
					<a href="/ziksana-web/zcourse/1/weblinkcontent"></a>Add Web Link
				</h3>
			</div>
		</div>



		<div class="Clearfix"></div>


	</div>
	<!--end of tiles container-->

	<div class="contentarea pull-right" style="width: 940px;">
		<div class="createcontentwrapper">
			<form id="createweblinkform" method="post">
				<div class="addweblink">
					<div class="createcontentpanelhead">
						Add Web Link
						<div class="addmpre pull-right">

							<a class="adlink" id="weblink"><img
								src="${staticFileServer}resources/images/content/plus.png"
								style="height: 30px;" /></a>

						</div>
						<!--end of add more-->
						<div class="Clearfix"></div>
					</div>
					<!--end of panel head-->
					<div class="weblinkcontainer">
						<div class="uploadroweven" style="padding: 10px;">
							<div class="uploadphoto pull-left" style="width: 350px">
								<div style="width: 100%">
									<div class="fileupload fileupload-new"
										data-provides="fileupload">
										<div class="fileupload-new thumbnail"
											style="width: 80px; height: 80px; float: left">
											<img src="http://www.placehold.it/80x80/EFEFEF/AAAAAA" />
										</div>
										<div class="fileupload-preview fileupload-exists thumbnail"
											style="width: 80px; height: 80px; float: left"></div>
										<div class="btn btn-file"
											style="float: left; margin-top: 25px; margin-left: 4px">
											<span class="fileupload-new">Upload image</span> <span
												class="fileupload-exists" style="margin-right: 4px">Change</span><input
												type="file" />
										</div>
										<a href="#" class="btn fileupload-exists"
											data-dismiss="fileupload"
											style="margin-top: 25px; margin-left: 3px">Remove</a>
									</div>
								</div>

							</div>
							<!--end of uploadphoto-->
							<div class="rowfields pull-left">
								<ul>
									<li><input type="text" placeholder="Enter Name"
										id="linkname"
										style="height: 25px; margin-top: 15px; width: 170px;" /></li>
									<li><input type="text" placeholder="htttp://" id="linkurl"
										style="height: 25px; margin-top: 15px; width: 170px;" /></li>
									<li><a href="#" class="editdetailsweblink">Edit
											Details</a></li>
								</ul>
							</div>
							<!--end of rowfields-->
							<div class="clearfix"></div>
							<div class="editslide pull-left">
								<textarea rows="4" cols="12"
									style="width: 374px; margin-bottom: 10px;">Details for the Web link </textarea>
							</div>
							<div class="editslide pull-left" style="margin-left: 5px;">
								<input type="text" placeholder="Specify Tags"
									style="height: 30px; margin-right: 12px; width: 233px;">
								<select id="Careaddl" class="select">
									<option>Specify Subject</option>
								</select> <br> <select class="select" id="Csubjectddl">
									<option>Specify Subject</option>
								</select> <select class="select" id="Ctopicddl">
									<option>Specify Subject</option>
								</select>
							</div>
							<div class="clearfix"></div>
						</div>
						<!-- end of uploadrow-->

					</div>
					<!--End of weblink container -->
					<div class="createcontentpanelhead" style="margin-top: 4px;">
						<a class="btn pull-right saveup1" type="button"
							onClick="webLinkContent();return false;"> Add Web link </a>
						<div class="clearfix"></div>
					</div>
					<!--end of panel head-->
				</div>
			</form>
			<!--end of weblink-->
		</div>
		<!--end of image wrapper -->
	</div>
	<!--end of contentarea-->

</div>
<!--end of contentpanel-->

<div class="Clearfix"></div>

<!--end of body wrapper-->

<div class="Clearfix"></div>
</div>

<style>
.select2-container {
	margin-right: 10px !important;
	width: 235px;
}

.rowfields ul {
	margin-left: 10px
}

.rowfields li {
	padding: 10px
}

.rowfields li a {
	float: left;
	margin-top: 16px;
}
</style>
<%-- <script type="text/javascript"
	src="${staticFileServer}resources/js/custom/createcontent/filedrag.js"></script> --%>
