
<script type='text/javascript'
	src="${staticFileServer}resources/js/lib/plupload/previewupload.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/custom/createcontent/addweblink.js"></script>

<style>
.tileheada {
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
		style="margin-top: 40px; width: 240px;">
		<div class="tile bg-color-blueDark icon" id="uploadbtn"
			style="width: 300px; height: 140px;">
			<div class="tile-content">
				<img src="${staticFileServer}resources/images/content/upload.png" />
			</div>
			<div class="brand">
				<h3 style="margin-left: 10px; font-size: 18px; width: 160px;">
					<a href="/ziksana-web/zcourse/createcontent"></a>Upload Content
				</h3>
			</div>
		</div>


		<div class="tile bg-color-grayDark icon" id="addweblinkbtn"
			style="width: 300px; height: 140px;">
			<div class="tile-content">
				<img src="${staticFileServer}resources/images/content/link.png" />
			</div>
			<div class="brand">
				<h3 style="margin-left: 10px; font-size: 18px; width: 160px;">
					<a href="/ziksana-web/zcourse/weblinkcontent"></a>Add Web Link
				</h3>
			</div>
		</div>
		<div class="Clearfix"></div>
	</div>
	<!--end of tiles container-->

	<div class="contentarea pull-right" style="width: 650px;">
		<div class="createcontentwrapper">
			<div class="uploadcontent2">
				<div class="createcontentpanelhead">Upload Content</div>
				<!--end of panel head-->

				<div class="Clearfix"></div>

				<div class="uploadroweven">
					<div class="uploadphoto pull-left">
						<div class="fileupload fileupload-new" data-provides="fileupload">
							<div class="fileupload-new thumbnail"
								style="width: 80px; height: 80px;">
								<img src="http://www.placehold.it/80x80/EFEFEF/AAAAAA" />
							</div>
							<div class="Clearfix"></div>
							<div class="fileupload-preview fileupload-exists thumbnail"
								style="width: 120px; height: 100px;"></div>
							<div class="Clearfix"></div>
							<span class="btn btn-file"><span class="fileupload-new">Upload
									image</span><span class="fileupload-exists">Change</span><input
								type="file" /></span> <a href="#" class="btn fileupload-exists"
								data-dismiss="fileupload">Remove</a>
						</div>
					</div>
					<!--end of uploadphoto-->

					<div class="rowfields pull-left">

						<ul>
							<li style="padding-right: 30px;">File Name</li>
							<li style="padding-right: 30px;"><a href="#linkurl">Edit
									Name</a></li>
							<li><a href="#linkurl" class="editdetailsweblink">Edit
									Details</a></li>

						</ul>
					</div>
					<div class="clearfix"></div>

					<div class="editslideup1">

						<div class="editslide pull-left">
							<textarea rows="4" cols="12"
								style="width: 374px; margin-bottom: 10px;">Details for the upload image </textarea>
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
					</div>
					<!--end of continaer-->
					<div class="clearfix"></div>
				</div>
				<!-- end of uploadrow-->
				<div class="createcontentpanelhead" style="margin-top: 4px;">
					<a href="#linkurl" class="btn pull-right saveup1"
						style="margin-left: 10px;"> Add Content </a> <a href="#linkurl"
						class="btn pull-right" style="margin-left: 10px;"> Save </a> <a
						href="#linkurl" class="btn pull-right saveup1"
						style="margin-left: 10px;"> Previous </a>

					<div class="clearfix"></div>
				</div>
				<!--end of panel head-->
			</div>
			<!--end of uploadcontent2-->
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
