<script type='text/javascript'
	src="${staticFileServer}resources/js/lib/plupload/previewupload.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/custom/createcontent/addweblink.js"></script>

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
				<h3 style="margin-left: 10px; font-size: 16px; width: 160px;">Upload
					Content</h3>
			</div>
		</div>


		<div class="tile bg-color-grayDark icon" id="addweblinkbtn" style="">
			<div class="tile-content">
				<img src="${staticFileServer}resources/images/content/link.png" />
			</div>
			<div class="brand">
				<h3 style="margin-left: 10px; font-size: 16px; width: 160px;">Add
					Web Link</h3>
			</div>
		</div>



		<div class="Clearfix"></div>


	</div>
	<!--end of tiles container-->

	<div class="contentarea pull-right" style="width: 940px;">
		<div class="createcontentwrapper">
			<div class="addweblink">
				<div class="createcontentpanelhead">
					Add Web Link
					<div class="addmpre pull-right">

						<a href="#linkurl" class="adlink" id="weblink"><img
							src="${staticFileServer}resources/images/content/plus.png"
							style="height: 30px;" /></a>

					</div>
					<!--end of add more-->
					<div class="Clearfix"></div>
				</div>
				<!--end of panel head-->
				<div class="weblinkcontainer">
					<div class="uploadroweven">
						<div class="uploadphoto pull-left">
							<div class="fileupload fileupload-new" data-provides="fileupload">
								<div class="fileupload-new thumbnail"
									style="width: 80px; height: 80px;">
									<img src="http://www.placehold.it/80x80/EFEFEF/AAAAAA" />
								</div>
								<div class="fileupload-preview fileupload-exists thumbnail"
									style="width: 120px; height: 100px;"></div>
								<span class="btn btn-file"><span class="fileupload-new">Upload
										image</span><span class="fileupload-exists">Change</span><input
									type="file" /></span> <a href="#" class="btn fileupload-exists"
									data-dismiss="fileupload">Remove</a>
							</div>
						</div>
						<!--end of uploadphoto-->
						<div class="rowfields pull-left">
							<ul>
								<li><input type="text" placeholder="Enter Name"
									style="height: 25px; margin-top: 15px; width: 150px;" /></li>
								<li><input type="text" placeholder="Htttp://"
									style="height: 25px; margin-top: 15px; width: 150px;" /></li>
								<li><a href="#linkurl" class="editdetailsweblink">Edit
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
								style="height: 30px; margin-top: 7px; width: 220px;"> <select>
								<option>Specify Subject</option>
							</select> <br> <select>
								<option>Specify Subject</option>
							</select> <select>
								<option>Specify Subject</option>
							</select>

						</div>
						<div class="clearfix"></div>
					</div>
					<!-- end of uploadrow-->

				</div>
				<!--End of weblink container -->
				<div class="createcontentpanelhead" style="margin-top: 4px;">
					<a href="#linkurl" class="btn pull-right saveup1"> Add Web link
					</a>
					<div class="clearfix"></div>
				</div>
				<!--end of panel head-->
			</div>
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


<%-- <script type="text/javascript"
	src="${staticFileServer}resources/js/custom/createcontent/filedrag.js"></script> --%>
