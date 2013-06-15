<!DOCTYPE html>
<html>
<head>
<title>Content Viewer</title>

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="https://raw.github.com/brandonaaron/jquery-mousewheel/master/jquery.mousewheel.js"></script>
<script type="text/javascript"
	src="${staticFileServer}resources/js/panzoom/jquery-panzoom.js"></script>

<script type="text/javascript"
	src="${staticFileServer}resources/js/panzoom/interface.js"></script>

<link rel="stylesheet" type="text/css" media="screen"
	href="${staticFileServer}resources/css/panzoom_style.css" />

<script type="text/javascript">
	function initPanZoom() {
		$('#pan img').panZoom({
			'zoomIn' : $('#zoomin'),
			'zoomOut' : $('#zoomout'),
			'panUp' : $('#panup'),
			'panDown' : $('#pandown'),
			'panLeft' : $('#panleft'),
			'panRight' : $('#panright'),
			'fit' : $('#fit'),
			'destroy' : $('#destroy'),
			'out_x1' : $('#x1'),
			'out_y1' : $('#y1'),
			'out_x2' : $('#x2'),
			'out_y2' : $('#y2'),
			'directedit' : true,
			'debug' : false
		});
	};
	$(document).ready(function() {

		initPanZoom();

		// init the image switcher
		// $('#images img').bind('click', function () {
		//   $('#pan img').attr('src', $(this).attr('src'));
		//   $('#fit').click(); //fit initally.
		// });
		$('a.dock-item2').bind('click', function() {
			thumbnail_anchor = $(this);
			thumbnail = $(this).find('img');
			$('#pan img').attr('src', thumbnail.attr('data-src'));
			$('#fit').click(); //fit initally.
			thumbnail_anchor.addClass('current');
			thumbnail_anchor.siblings().removeClass('current');

		});

		// init the init button (for testing destroy/recreate)
		$('#reinit').bind('click', function(event) {
			if ($('#pan img').data('panZoom')) {
				alert('Click destroy before trying to re-initialise panZoom');
				return;
			}
			event.preventDefault();
			initPanZoom();
		});

		$('#controls').draggable({
			containment : "parent",
			cursor : "move"
		});

		//Next Pevious Buttons
		$("#thumb_next").click(function() {
			current_thumbnail = $('a.current');
			current_thumbnail.next('a').click();
		});
		$("#thumb_previous").click(function() {
			current_thumbnail = $('a.current');
			current_thumbnail.prev('a').click();
		});
		  $('.dock-item2').first().click();
	});
</script>


<!--dock menu JS options -->
<script type="text/javascript">
	$(document).ready(function() {
		$('#dock2').Fisheye({
			maxWidth : 60,
			items : 'a',
			itemsText : 'span',
			container : '.dock-container2',
			itemWidth : 40,
			proximity : 80,
			alignment : 'left',
			valign : 'bottom',
			halign : 'center'
		})
	});
</script>
</head>

<body>
	<div class="wrapper">

		<!--bottom dock -->
		<div class="dock" id="dock2">
			<div class="dock-container2">
				<!--   <a class="dock-item2" href="#"><span>1</span><img src="sample2.png" /></a> 
  <a class="dock-item2" href="#"><span>2</span><img src="sample2.png" /></a> 
  <a class="dock-item2" href="#"><span>3</span><img src="sample2.png" /></a>  -->

				<c:choose>
					<c:when test="${content.contentTypeString == 'IMAGE'}">
						<a class="dock-item2" href="#"><span></span><img
							src="${ms.url}/image/${content.contentUrl}/${content.contentUrl}.jpg" /></a>
					</c:when>
					<c:when test="${content.numberOfThumbnails == -1}">
						<a class="dock-item2" href="#"><span></span><img src="" /></a>
					</c:when>
					<c:otherwise>
						<c:forEach var="i" begin="0" end="${content.numberOfThumbnails-1}"
							step="1" varStatus="status">
							<a class="dock-item2" href="#"><span>${i}</span>
							<img data-src="${ms.url}${content.thumbnailPicturePath}img_<c:out value="${i}" />.jpg" src="${ms.url}${content.thumbnailPicturePath}thumb_<c:out value="${i}" />.jpg" /></a>
						</c:forEach>
					</c:otherwise>
				</c:choose>


			</div>
		</div>
		<a id="thumb_next">></a> <a id="thumb_previous"></a>
		<div id="controls" title="Drag to move the control bar">
			<table>
				<tr>
					<td><a id="zoomin" href="#" title="Zoom In"><img
							src="${staticFileServer}resources/images/panzoom/zoom_in.png"></a></td>
					<td><a id="panup" href="#" title="Pan Up"><img
							src="${staticFileServer}resources/images/panzoom/arrow_up.png"></a></td>
					<td><a id="zoomout" href="#" title="Zoom Out"><img
							src="${staticFileServer}resources/images/panzoom/zoom_out.png"></a></td>
				</tr>
				<tr>
					<td><a id="panleft" href="#" title="Pan Left"><img
							src="${staticFileServer}resources/images/panzoom/arrow_left.png"></a></td>
					<td><a id="fit" href="#" title="fit/reset"><img
							src="${staticFileServer}resources/images/panzoom/arrow_out.png"></a></td>
					<td><a id="panright" href="#" title="Pan Right"><img
							src="${staticFileServer}resources/images/panzoom/arrow_right.png"></a></td>
				</tr>
				<tr>
					<td></td>
					<td><a id="pandown" href="#" title="Pan Down"><img
							src="${staticFileServer}resources/images/panzoom/arrow_down.png"></a></td>
					<td></td>
				</tr>
			</table>
		</div>

		<div id="pan">
			<img src="">
		</div>

	</div>

</body>
</html>