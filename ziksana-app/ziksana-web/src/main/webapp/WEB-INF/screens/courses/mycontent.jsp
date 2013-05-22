<script type="text/javascript"
	src="${staticFileServer}resources/js/lib/isotope/jquery.isotope.min.js"></script>
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



<div class="announcementcontainer">
	<div class="headtag pull-left" style="margin-top: 10px;">My
		Content</div>

	<div class="isotophead pull-right">
		<div class="isotoplinks">

			<a href="#linkurl" data-option-value="straightDown"
				style="padding: 5px;" onclick="showall()">All </a> <a
				href="#linkurl" data-option-value="straightDown"
				style="padding: 5px;" onclick="showactive()">Video</a> <a
				href="#linkurl" data-option-value="straightDown"
				style="padding: 5px;" onclick="showreview()">Weblinks </a> <a
				href="#linkurl" data-option-value="straightDown"
				style="padding: 5px;" onclick="showreview()">Others </a>

		</div>
	</div>
	<!--end of isotophead-->


	<div class="Clearfix"></div>


	<hr>


	<div class="announcementswrapper" style="margin-left: 50px;">


		<div id="container4" class="createcontent-mainwrapper isotopbody">


			<div id="createcontent-main" class="item All">

				<p class="createcontenthead">Science</p>
				<p class="createcontentimg">
					<img
						src="${staticFileServer}resources/images/genetics.jpg" />
				</p>
				<div class="description">

					<a href="#linkurl" class="pull-right"><img class="iconcc"
						src="${staticFileServer}resources/images/content/deleteicon.png"
						style="height: 35px;" /></a> <a href="#linkurl" class="pull-right"><img
						src="${staticFileServer}resources/images/content/view-content.png"
						style="height: 35px;" /></a>

				</div>

				<div class="Clearfix"></div>
			</div>
			<!-- end of createcontent-main-->

		</div>
		<!--end of ann-mainwrapper-->
	</div>
	<div class="annprogressbar pull-right"
		style="margin: 20px; margin-right: 30px;">

		<div class="timer">
			<div class="progress" style="width: 100%; overflow: hidden;"></div>
		</div>

		<div class="timer">
			<div class="progress" style="width: 100%; overflow: hidden;"></div>
		</div>


		<div class="timer">
			<div class="progress" style="width: 100%; overflow: hidden;"></div>
		</div>
	</div>
	<!--end of annprogressbar-->

	<div class="Clearfix"></div>


</div>
<!--end of announcement container-->