<script type="text/javascript"
	src="${staticFileServer}resources/js/lib/isotope/jquery.isotope.min.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/Dynamicjsonjs/mycourse.js"></script>

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
				<a href="/ziksana-web/secure/1/homepage"><fmt:message key="home.hometext"/></a></span> < <fmt:message key="home.mycourselearner"/>
			</p>

		</div>

	</div>
	<!--end of breadcrumb-->
</div>

<div class="Clearfix"></div>
<div class="announcementcontainer">
	<div class="headtag pull-left" style="margin-top: 10px;"><fmt:message key="home.mycourselearner"/></div>
	<div class="Clearfix"> </div>
	 <div class="pull-left" style="margin-left: 55px;margin-top: 20px;text-align: right;width: 77%;">
		<a href="/ziksana-web/zcourse/createcourse" style="width:150px;margin-top:6px;font-weight:bold"><fmt:message key="Create.New.Course"/> </a>
 </div>

	<div class="isotophead pull-right">
		<div class="isotoplinks">
			<a href="#" class="active_filter" onclick="getAllCourse()"><fmt:message key="home.all"/></a>|<a href="#"
				onclick="getAllCourse()"><fmt:message key="draft.txt"/></a>|<a
				href="#" onclick="getActiveCourse('ACTIVE')"><fmt:message key="active.txt"/></a>|<a href="#"
				onclick="getReviewCourse('REVIEW')"><fmt:message key="review.txt"/></a>

		</div>
	</div>
	<!--end of isotophead-->


	<div class="Clearfix"></div>
	<hr>
	<div class="announcementswrapper" style="margin-left: 50px;">
		<form>
			<input type="hidden" id="courses" value='${courseAsJSONString}' /> <input
				type="hidden" id="fileServerPath" value='${ms.uploadContent}' />
			<div id="container4" class="createcontent-mainwrapper isotopbody">
		
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
a.remove_this {
  border: 2px solid white;
  border-radius: 60px 60px 60px 60px;
  color: white;
  cursor: pointer;
  display: inline-block;
  font-size: 11px !important;
  height: 25px;
  line-height: 21px;
  margin-right: 2px;
  margin-top: 5px;
  text-align: center;
  text-decoration: none;
  width: 25px;
}

a.remove_this:hover {
	color: red!important;
	border-color: red;
	text-decoration: none;
}
</style>