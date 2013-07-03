<script type="text/javascript"
	src="${staticFileServer}resources/js/lib/isotope/jquery.isotope.min.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/Dynamicjsonjs/mycontent.js"></script>

<script>
	$('#container4').isotope({

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
<script>
$(document).ready(function(){
        $('.isotoplinks li').click(function () {
            $('.isotoplinks li').removeClass('current').addClass('link');
            $(this).removeClass('link').addClass('current');
            var divname= this.name;
            $("#"+divname).show("fast").siblings().hide("fast");
        });
    });
</script>
<script>
$(document).ready(function() { // On page load
  $("#navstudent").addClass("active");  
 
});
</script>
<div id="Zikbreadcrumbback" style="margin-left: 20px;">

	<div class="Zikbreadcrumb f-l">

		<div class="fifteen columns" id="page-title">
			<a style="margin-top: -3px;" class="back"
				href="javascript:history.back()"></a>
			<p class="page-title">
				<a href="/ziksana-web/secure/1/homepage"><fmt:message key="home.hometext"/></a></span> < <fmt:message key="nav.mycontent"/>
			</p>

		</div>

	</div>
	<!--end of breadcrumb-->
</div>

<div class="Clearfix"></div>
<div class="announcementcontainer">
	<div class="headtag pull-left" style="margin-top: 10px;"><fmt:message key="nav.mycontent"/></div>
<div class="Clearfix"> </div>
 <div class="pull-left" style="margin-top: 20px;text-align: right;width:100%;">
<a href="/ziksana-web/zcourse/1/createcontent" style="line-height: 41px;margin-right: 4px;font-weight:bold"><fmt:message key="Create.New.Content"/> </a>
 
	<div class="isotophead pull-right" style="width: 306px;" id="content_type_filter">
		<div class="isotoplinks">
			 <ul><li class="current">
			 <a onclick="getAllLearningContents()"><fmt:message key="home.all"/></a></li>
			<li><a onclick="getLearningContentsByType('VIDEO')"><fmt:message key="Video.txt"/></a></li>
			<li><a onclick="getLearningContentsByType('LINK')"><fmt:message key="web.link"/></a></li>
			<li><a onclick="getOtherLearningContents('Others')"><fmt:message key="other.txt"/></a>
		</li>
			</ul> 
		</div>
	</div></div>
	<!--end of isotophead-->


	<div class="Clearfix"></div>
	<hr style="margin-top:0px">
		<div class="announcementswrapper" style="margin-left: 50px;min-height:350px">
		<form>
			<input type="hidden" id="learingContents"
				value='${learningContentAsJSONString}' />
				<input type="hidden" id="fileServerPath" value='${ms.uploadContent}'/>
				<c:if test="${message != null}">
    				<div class="sucessmssg" ><p>${message}</p></div>
				</c:if>
				<script>setTimeout( "jQuery('.sucessmssg').hide();",5000 );</script>
			<div id="noContentFound" style="margin: auto; text-align: center; color:#000; font-weight: bold; font-size: 15px; ">						
			</div>
			<div id="container4" class="createcontent-mainwrapper isotopbody">
				
			</div>
			
			<div class="Clearfix"></div>
			<div id="pageNumbers" class="paginationbutton f-r" style="padding:10px;">
			</div>
	
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
<%-- <script src="${staticFileServer}resources/js/custom/table/js/app.js"></script>
<script>
	jQuery(document).ready(function() {
		// initiate layout and plugins

		App.init();

	});
</script> --%>
<style>
.createcontentimg > img {
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
 .sucessmssg {
   
  color: green;
  margin-top: -52px;
  position: absolute;
  text-align: center;
  width: 70%;
}
.sucessmssg > p {
  background: none repeat scroll 0 0 green;
  
  color: #FFFFFF;
  margin: auto;
  padding: 4px;
  width: 260px;
  border-radius: 6px;
}
</style>