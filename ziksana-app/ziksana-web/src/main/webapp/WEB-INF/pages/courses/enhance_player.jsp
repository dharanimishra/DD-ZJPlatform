
<!-- <script type="text/javascript" src="js/video_player.js"></script> -->
<script type="text/javascript"
	src="/ziksana-web/resources/js/custom/course_enrichment.js"></script>
<script type='text/javascript'
	src="/ziksana-web/resources/jwplayer/swfobject.js"></script>
<script type="text/javascript"
	src="/ziksana-web/resources/jwplayer/jwplayer.js"></script>



<script type="text/javascript">
            // For version detection, set to min. required Flash Player version, or 0 (or 0.0.0), for no version detection. 
            var swfVersionStr = "11.4.0";
            // To use express install, set to playerProductInstall.swf, otherwise the empty string. 
            var xiSwfUrlStr = "playerProductInstall.swf";
            var flashvars = {};
            var params = {};
            params.quality = "high";
            params.bgcolor = "#ffffff";
            params.allowscriptaccess = "always";
            params.allowfullscreen = "true";
            var attributes = {};
            attributes.id = "EnhancePlayer";
            attributes.name = "EnhancePlayer";
            attributes.align = "middle";
            swfobject.embedSWF(
                "/ziksana-web/resources/jwplayer/EnhancePlayer.swf", "flashContent", 
                "700px", "500px", 
                swfVersionStr, xiSwfUrlStr, 
                flashvars, params, attributes);
            // JavaScript enabled so display the flashContent div in case it is not replaced with a swf object.
            swfobject.createCSS("#flashContent", "display:block;text-align:left;");
            setTimeout('setUrl()', 4000);
/* 				var setUrl = function()
				{
					var fl = document.getElementById('EnhancePlayer');
					fl.load_images_js("http://54.243.235.88/zikload-xml/uploads"+"${content.thumbnailPicturePath}"+"|||"+"${content.numberOfThumbnails}");
				} */			
				
			function ff_player_mode() { return "enhance"; }
			function ff_load_images() { 
			return "${ms.url}"+"${content.thumbnailPicturePath}"+"|||"+"${content.numberOfThumbnails}";}
			function ff_recording_save_path(path) {
				console.log(path);
				enhanced_video_path = path;
				window.parent.assoicateEnhancedVideo('${courseId}', '${componentId}', '${contentId}', enhanced_video_path,'${enhanced_video_name}');
			}
			function  ff_get_flash_recorder() { return '${ms.flashRecordingScript}';};

        </script>
</head>
<body>
	<!-- SWFObject's dynamic embed method replaces this alternative HTML content with Flash content when enough 
             JavaScript and Flash plug-in support is available. The div is initially hidden so that it doesn't show
             when JavaScript is disabled.
        -->
	<div id="flashContent">
		<p>To view this page ensure that Adobe Flash Player version 11.4.0
			or greater is installed.</p>
		<script type="text/javascript"> 
                var pageHost = ((document.location.protocol == "https:") ? "https://" : "http://"); 
                document.write("<a href='http://www.adobe.com/go/getflashplayer'><img src='" 
                                + pageHost + "www.adobe.com/images/shared/download_buttons/get_flash_player.gif' alt='Get Adobe Flash player' /></a>" ); 

			</script>


	</div>


</body>