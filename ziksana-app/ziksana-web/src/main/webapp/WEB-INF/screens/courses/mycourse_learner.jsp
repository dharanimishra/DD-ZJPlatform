<script type="text/javascript"
	src="${staticFileServer}resources/js/lib/isotope/jquery.isotope.min.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/Dynamicjsonjs/mycourse_learner.js"></script> 

<script>
	$('#container4').isotope({

	/* itemSelector : '.element',
	 masonry : {
	   columnWidth : 120,
	  rowHeight: auto
	 },
	 masonryHorizontal : {
	   rowHeight: auto
	 },
	 cellsByRow : {
	   columnWidth : 240,
	   rowHeight : auto
	 },
	 cellsByColumn : {
	   columnWidth : 240,
	   rowHeight : auto
	 }*/
	});

	$(function() {

		var $container = $('#container4');

		$container
				.isotope({
					staightDown : {
						columnWidth : 120
					},
					sortBy : 'number',
					getSortData : {
						number : function($elem) {
							var number = $elem.hasClass('element') ? $elem
									.find('.number').text() : $elem
									.attr('data-number');
							return parseInt(number, 10);
						},
						alphabetical : function($elem) {
							var name = $elem.find('.name'), itemText = name.length ? name
									: $elem;
							return itemText.text();
						}
					}
				});

		var $optionSets = $('#options .option-set'), $optionLinks = $optionSets
				.find('a');

		$optionLinks
				.click(function() {
					var $this = $(this);
					// don't proceed if already selected
					if ($this.hasClass('selected')) {
						return false;
					}
					var $optionSet = $this.parents('.option-set');
					$optionSet.find('.selected').removeClass('selected');
					$this.addClass('selected');

					// make option object dynamically, i.e. { filter: '.my-filter-class' }
					var options = {}, key = $optionSet.attr('data-option-key'), value = $this
							.attr('data-option-value');
					// parse 'false' as false boolean
					value = value === 'false' ? false : value;
					options[key] = value;
					if (key === 'layoutMode'
							&& typeof changeLayoutMode === 'function') {
						// changes in layout modes need extra logic
						changeLayoutMode($this, options)
					} else {
						// otherwise, apply new options
						$container.isotope(options);
					}

					return false;
				});
	});

	$('#container4').isotope({
		filter : '.my-selector'
	}, function($items) {
		var id = this.attr('id'), len = $items.length;
		console.log('Isotope has filtered for ' + len + ' items in #' + id);
	});

	function showall() {
		$('#container4').isotope({
			filter : '.All'
		});
	}

	function showactive() {
		$('#container4').isotope({
			filter : '.Active'
		});
	}

	function showreview() {
		$('#container4').isotope({
			filter : '.Review'
		});
	}
</script>


<script language="javascript">
	$(document).ready(function(e) {
		$(".accordion-toggle").click(function(e) {
			$(".accordion-toggle").css('position', 'absolute');
			$(this).css('position', 'relative');
		});
	});
</script>
<div id="Zikbreadcrumbback" style="margin-left: 20px;">

	<div class="Zikbreadcrumb f-l">

		<div class="fifteen columns" id="page-title">
			<a style="margin-top: -3px;" class="back"
				href="javascript:history.back()"></a>
			<p class="page-title">
				<span style="color: #6bbde8;">Home</span> < My Course
			</p>

		</div>

	</div>
	<!--end of breadcrumb-->
</div>

<div class="Clearfix"></div>
<div class="announcementcontainer">
	<div class="headtag pull-left" style="margin-top: 10px;">My
		Course</div>

	<!--end of isotophead-->
	<div class="Clearfix"></div>
	<hr>
	<div class="announcementswrapper" style="margin-left: 50px;">
		<form>
			<input type="hidden" id="courses" value='${courseAsJSONString}' /> <input
				type="hidden" id="fileServerPath" value='${ms.uploadContent}' />

			<div id="container4" class="createcontent-mainwrapper isotopbody">
				<div id="createcontent-main" class="item All">

					<p class="createcontenthead">Science</p>
					<p class="createcontentimg">
						<img src="${staticFileServer}resources/images/preview/defaultcourse.png" />
					</p>
					<div class="description">

						<a href="/ziksana-web/unsecure/downloadPlayBook/488" class="pull-right"><img class="iconcc"
							title="View Playbook" src="${staticFileServer}resources/images/content/viewplaybook.svg"
							style="height: 35px; margin: 5px;" /></a> <a href="/ziksana-web/zcourse/1/mylearnercourse/488"
							class="pull-right"><img
							src="${staticFileServer}resources/images/content/observecourses.svg" title="Observe Course"
							style="height: 35px; margin: 5px;" /></a>
					</div>
					<div class="Clearfix"></div>
				</div>
				<!-- end of createcontent-main-->
				<!-- <div id="container4" class="createcontent-mainwrapper isotopbody"> -->

				</div>
				<div class="Clearfix"></div>
				<div id="pageNumbers" class="paginationbutton f-r"
					style="padding: 10px;"></div>

				<!--end of ann-mainwrapper-->
		</form>
	</div>
	<div class="Clearfix"></div>


</div>
</div>
<!--end of announcement container-->

<script
	src="${staticFileServer}resources/js/custom/table/breakpoints/breakpoints.js"></script>
<!-- ie8 fixes -->
<!--[if lt IE 9]>
	<script src="assets/js/excanvas.js"></script>
	<script src="assets/js/respond.js"></script>
	<![endif]-->

<script
	src="${staticFileServer}resources/js/custom/bootstrap/js/bootstrap.min.js"></script>
<!--  <script src="${staticFileServer}resources/js/custom/table/js/app.js"></script> -->
<!-- <script>
	jQuery(document).ready(function() {
		// initiate layout and plugins

		App.init();

	});
</script> -->
<style>
.createcontentimg>img {
	padding: 0;
}
</style>