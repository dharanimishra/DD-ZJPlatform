<html>
<head>
<script type='text/javascript' src='/ziksana-web/resources/js/lib/jquery/jquery-1.9.1.min.js'></script>
<script type="text/javascript" src="/ziksana-web/resources/js/jwplayer/jwplayer.js"></script>
<style type="text/css">
body{min-width:900px; min-height: 270px; background: white; overflow:hidden !important;}
</style>
	<script type="text/javascript">
		function getQueryVariable(variable) {
		    var query = window.location.search.substring(1);
		    var vars = query.split('&');
		    for (var i = 0; i < vars.length; i++) {
		        var pair = vars[i].split('=');
		        if (decodeURIComponent(pair[0]) == variable) {
		            return decodeURIComponent(pair[1]);
		        }
		    }
		    console.log('Query variable %s not found', variable);
		}
		$(function(){
			
			jwplayer("lbmediaplayer").setup({
				flashplayer: "/ziksana-web/resources/jwplayer/player.swf",
				height: 480,//385
				width: 853,//640
				file: '${ms.url}/video/'+'${content.contentUrl}/'+'${content.contentUrl}'
			}).play('true');		
			
		});

	</script>

	

</head>
<body style="min-width:900px;">
		<div id="lbmediaplayer">JW Player goes here</div>


	<script type="text/javascript">

	</script>






</body>
</html>