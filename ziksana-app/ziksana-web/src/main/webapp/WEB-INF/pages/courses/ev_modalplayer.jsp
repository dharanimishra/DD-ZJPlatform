
<html>

<!-- <script type="text/javascript" src="js/video_player.js"></script> -->
<script type="text/javascript" src="/ziksana-web/resources/js/jquery-1.7.2.min.js"></script>

<script type="text/javascript" src="/ziksana-web/resources/js/custom/course_enrichment.js"></script>
<script type='text/javascript' src="/ziksana-web/resources/jwplayer/swfobject.js"></script>
<script type="text/javascript" src="/ziksana-web/resources/jwplayer/jwplayer.js"></script>


	<div id="video">
		<div id="flashContent"></div>

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
                "730px", "545px", 
                swfVersionStr, xiSwfUrlStr, 
                flashvars, params, attributes);
            // JavaScript enabled so display the flashContent div in case it is not replaced with a swf object.
            swfobject.createCSS("#flashContent", "display:block;text-align:left;");
            setTimeout('setUrl()', 4000);
		
				
			function ff_player_mode() { return "playback"; }
			//function ff_load_images() { return "http://54.243.235.88/zikload-xml/uploads"+"${content.thumbnailPicturePath}"+"|||"+"${content.numberOfThumbnails}"; }
			function ff_get_recorded_file(){ return "${ms.flashRecordingFolder}${content.contentUrl}"; }
			function  ff_get_flash_recorder() { return "${ms.flashRecordingScript}";};

        </script>


	</div>

</html>