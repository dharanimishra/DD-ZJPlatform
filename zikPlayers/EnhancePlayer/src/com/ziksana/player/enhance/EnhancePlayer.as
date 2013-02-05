package com.ziksana.player.enhance
{
	import flash.display.Bitmap;
	import flash.display.BitmapData;
	import flash.display.DisplayObject;
	import flash.display.Loader;
	import flash.display.MovieClip;
	import flash.display.Shape;
	import flash.display.Sprite;
	import flash.display.Stage;
	import flash.display.StageAlign;
	import flash.display.StageDisplayState;
	import flash.display.StageScaleMode;
	import flash.events.Event;
	import flash.events.HTTPStatusEvent;
	import flash.events.IEventDispatcher;
	import flash.events.IOErrorEvent;
	import flash.events.MouseEvent;
	import flash.events.NetStatusEvent;
	import flash.events.ProgressEvent;
	import flash.events.SecurityErrorEvent;
	import flash.external.ExternalInterface;
	import flash.geom.Rectangle;
	import flash.media.Camera;
	import flash.media.Microphone;
	import flash.media.SoundTransform;
	import flash.media.Video;
	import flash.net.NetConnection;
	import flash.net.NetStream;
	import flash.net.URLLoader;
	import flash.net.URLRequest;
	import flash.net.URLRequestMethod;
	import flash.system.Security;
	import flash.text.TextField;
	import flash.text.TextFieldType;
	import flash.text.TextFormat;
	import flash.text.TextFormatAlign;
	import flash.utils.clearTimeout;
	import flash.utils.getTimer;
	import flash.utils.setTimeout;
	import flash.display.LoaderInfo;

	
	
	public class EnhancePlayer extends Sprite
	{
		[Embed(source='../../../../../icons/edit.png')]
		public static var HotspotIcon:Class;
		
		[Embed(source='../../../../../icons/record.png')]
		public static var RECORD:Class;
		
		[Embed(source='../../../../../icons/rerecord.png')]
		public static var RERECORD:Class;
		
		[Embed(source='../../../../../icons/save.png')]
		public static var SAVE:Class;
		
		[Embed(source='../../../../../icons/play.png')]
		public static var PLAY:Class;
		
		[Embed(source='../../../../../icons/pause.png')]
		public static var PAUSE:Class;
		
		[Embed(source='../../../../../icons/stop.png')]
		public static var STOP:Class;
		
		[Embed(source="../../../../../icons/previous.png" )]
		public static var PREVIOUS:Class;
		
		[Embed(source='../../../../../icons/next.png')]
		public static var NEXT:Class;
		
		[Embed(source='../../../../../icons/eraser.png')]
		public static var ERASER:Class;
		
		[Embed(source='../../../../../icons/marker.png')]
		public static var MARKER:Class;
		
		[Embed(source='../../../../../icons/fullscreen.png')]
		public static var FULLSCREEN:Class;
		
		[Embed(source='../../../../../icons/optionEmpty.png')]
		public static var OPTIONEMPTY:Class;
		
		[Embed(source='../../../../../icons/webcam.png')]
		public static var WEBCAM:Class;
		
		[Embed(source='../../../../../icons/enote.png')]
		public static var ENOTEICON:Class;
		
		[Embed(source='../../../../../icons/etoc.png')]
		public static var ETOCICON:Class;
		
		[Embed(source='../../../../../icons/eref.png')]
		public static var EREFICON:Class;

		[Embed(source='../../../../../icons/hotspot.png')]
		public static var HOTSPOTICON:Class;
		
		[Embed(source='../../../../../icons/loading11.swf')]
		public static var LOADING:Class;
		
		private static var _stage:Stage;
		private var fileNameRecorded:String = '';
		private static var _playerState:String = "STOPPED";
		protected var slider:MovieClip = new MovieClip();
		protected var strokes:MovieClip = new MovieClip();
		protected var videoCapture:MovieClip = new MovieClip();
		protected var controls:MovieClip = new MovieClip();
		protected var enrichUI:MovieClip = new MovieClip();
		protected var loadingGifDO:DisplayObject;
		protected var loadingGif:MovieClip = new MovieClip();
		
		protected var record:MovieClip = new MovieClip();
		protected var play:MovieClip = new MovieClip();
		protected var pause:MovieClip = new MovieClip();
		protected var stop:MovieClip = new MovieClip();
		protected var previous:MovieClip = new MovieClip();
		protected var next:MovieClip = new MovieClip();
		protected var eraser:MovieClip = new MovieClip();
		protected var marker:MovieClip = new MovieClip();
		protected var fullscreen:MovieClip = new MovieClip();
		protected var seekBar:MovieClip = new MovieClip();
		protected var seekBarIndicator:Sprite = new Sprite();
		protected var seekBarText:TextField = new TextField;
		protected var videoCaptureMode:MovieClip = new MovieClip();
		protected var deployMode:String = "enhance";
		protected var contentLoaded:Boolean = false;
		protected var serverConnected:Boolean = false;
		protected var presentSlideStrokes:Array = new Array();
		protected var save:MovieClip = new MovieClip();
		protected var editVideo:MovieClip = new MovieClip();

		
		
		//ENRICH
		protected var hotspotIcon:MovieClip = new MovieClip();
		protected var eNoteIcon:MovieClip = new MovieClip();
		protected var eTocIcon:MovieClip = new MovieClip();
		protected var eRefIcon = new MovieClip();
		 
		protected var imageData:String;
		protected var sliderImages:Array = new Array();
		protected var sliderScaleFactor:Number;
		protected var sliderImageActualHeight:Number;
		protected var sliderImageActualWidth:Number;
		protected var recordingData:RecordingData = new RecordingData();
		protected var dataPath:String;
		protected var numberOfImages:Number;
		protected var resizing:Boolean = false;
		
		protected var strokesData:BitmapData;
		protected var strokesBmp:Bitmap;
		protected var strokeShape:Shape = new Shape();
		protected var md:Boolean = false;
		protected const TOOL_NONE:uint = 0;
		protected const TOOL_MARKER:uint = 1;
		protected const TOOL_ERASER:uint = 2;
		
		private var popUpID:Number = -1;
		private var popUp:Sprite = new Sprite();
		
		private var currentlyPlayingEvent:Number = 0;
		private var currentlyPlayingTime:Number = 0;
		
		protected var toolSelected:uint = TOOL_NONE;
		
		protected var videoContainer:Video = new Video(160, 120);
		protected var cam:Camera = Camera.getCamera();
		protected var mic:Microphone = Microphone.getMicrophone();
		private var ns:NetStream = null;
		private var ns2:NetStream = null;
		private var presentNS:NetStream = null;
		private var currentlyPlayingVideo:Number = 0;
		protected var presentSlide:Number = -1;
		private var nc:NetConnection = new NetConnection();
		private var nc2:NetConnection = new NetConnection();
		private var videoRecordName:String;
		private const SLIDER_LENGTH = 280;
		private var nsStopped:Boolean = false;
		
		private var strokesRecording:XML=<RECORD_EVENTS></RECORD_EVENTS>;
	
		public function EnhancePlayer()
		{
			nc.connect("rtmp://video.beta.ziksana.com/oflaDemo");
			nc2.connect("rtmp://video.beta.ziksana.com/oflaDemo");
			deployMode = ExternalInterface.call("ff_player_mode"); //"enrich" "enhance" "playback" "consumption"
			addEventListener( Event.ADDED_TO_STAGE, DoAfterAddingToStage );
			nc.addEventListener(NetStatusEvent.NET_STATUS, NSConnectHandler);
			nc2.addEventListener(NetStatusEvent.NET_STATUS, NSConnectHandler2);
			nc.client = { onBWDone: function():void{ } };
			nc2.client = { onBWDone: function():void{ } };
		}
		
		private function NSConnectHandler(event:NetStatusEvent):void {
			trace("EVENT INFO CODE"+event.info.code);
			switch (event.info.code) {
				case "NetConnection.Connect.Success":
					if(!contentLoaded)
					ShowPopUp("Video server connected! Loading content...", 10000);
					else {
						ShowPopUp("Loading Complete.");
						loadingGif.visible=false;
					}
					serverConnected = true;
					if(ns==null) {
						trace("trying to allocate NS");
						ns = new NetStream(nc);	

						ns.addEventListener(NetStatusEvent.NET_STATUS, statusHandler);
						ns.soundTransform = new SoundTransform(1); 
						ns.client = { onStatus:function():void{}};
					}
					//if(pendingStartRecording) { StartRecording(); pendingStartRecording = false; }
					break;
				case "NetConnection.Connect.Failed":
					ShowPopUp("Video Server Connection Failed: Application cannot be used", 10000);
					loadingGif.visible=false;
					break;
				case "NetStream.Play.Stop": 
					trace("Stop [" + ns.time.toFixed(3) + " seconds]"); 
					nsStopped = true;
					break; 
				default:
					for (var prop in event) {
						trace("\t"+prop+":\t"+event[prop]);
					}
					break;
			}
		}
		
		
		private function NSConnectHandler2(event:NetStatusEvent):void {
			trace("EVENT INFO CODE2"+event.info.code);
			switch (event.info.code) {
				case "NetConnection.Connect.Success":

					if(ns2==null) {
						trace("trying to allocate NS2");
						ns2 = new NetStream(nc2);	
						
						ns2.addEventListener(NetStatusEvent.NET_STATUS, statusHandler);
						ns2.soundTransform = new SoundTransform(1); 
						ns2.client = { onStatus:function():void{}};
					}
					//if(pendingStartRecording) { StartRecording(); pendingStartRecording = false; }
					break;
				case "NetConnection.Connect.Failed":
					ShowPopUp("Video Server Connection Failed: Application cannot be used2", 10000);
					loadingGif.visible=false;
					break;
				case "NetStream.Play.Stop": 
					trace("2 [" + ns.time.toFixed(3) + " seconds]"); 
					nsStopped = true;
					break; 
				default:
					for (var prop in event) {
						trace("\t2"+prop+":\t"+event[prop]);
					}
					break;
			}
		}

		private function statusHandler(event:NetStatusEvent):void {
		switch (event.info.code) 
		{ 
			case "NetStream.Play.Start": 
				//trace("Start [" + ns.time.toFixed(3) + " seconds]"); 
				break; 
			case "NetStream.Play.Stop": 
				//trace("Stop [" + ns.time.toFixed(3) + " seconds]"); 
				nsStopped = true;
				break; 
		} 
		}
		
		public function sendDataToPHP():void {
			var loader:URLLoader = new URLLoader();
			configureListeners(loader);
			
			var recorderPHP:String = ExternalInterface.call("ff_get_flash_recorder");
			var request : URLRequest = new URLRequest(recorderPHP);  
			//var request : URLRequest = new URLRequest("https://video.beta.ziksana.com/zikload/flashrecording/FlashRecordingTest.php");  
			request.data = strokesRecording;
			request.contentType = "text/xml";
			request.method = URLRequestMethod.POST;  
			try {
				loader.load(request);
			} catch (error:Error) {
				trace("Unable to load requested document.");
			}
		}
		
		private function configureListeners(dispatcher:IEventDispatcher):void {
			dispatcher.addEventListener(Event.COMPLETE, completeHandler);
			dispatcher.addEventListener(Event.OPEN, openHandler);
			dispatcher.addEventListener(ProgressEvent.PROGRESS, progressHandler);
			dispatcher.addEventListener(SecurityErrorEvent.SECURITY_ERROR, securityErrorHandler);
			dispatcher.addEventListener(HTTPStatusEvent.HTTP_STATUS, httpStatusHandler);
			dispatcher.addEventListener(IOErrorEvent.IO_ERROR, ioErrorHandler);
		}
		
		private function completeHandler(event:Event):void {
			var loader:URLLoader = URLLoader(event.target);
			trace("completeHandler: " + loader.data);
			ExternalInterface.call("ff_recording_save_path",loader.data); 
		}
		
		private function openHandler(event:Event):void {
			trace("openHandler: " + event);
		}
		
		private function progressHandler(event:ProgressEvent):void {
			trace("progressHandler loaded:" + event.bytesLoaded + " total: " + event.bytesTotal);
		}
		
		private function securityErrorHandler(event:SecurityErrorEvent):void {
			trace("securityErrorHandler: " + event);
		}
		
		private function httpStatusHandler(event:HTTPStatusEvent):void {
			trace("httpStatusHandler: " + event);
		}
		
		private function ioErrorHandler(event:IOErrorEvent):void {
			trace("ioErrorHandler: " + event);
		}
		
		public function StartRecording():void
		{
			ns.attachCamera(cam);
			ns.attachAudio(mic);
			var myDate:Date = new Date();
			var unixTime:Number = Math.round(myDate.getTime()/1000);
			// create a random number to store a unique name
			videoRecordName = "red5RecordDemo_" + unixTime;
			ns.publish(videoRecordName, "record");
		}
		
		public function StopRecording():void
		{
			//trace(strokesRecording);
			ns.close();
			//sendDataToPHP();
		}
		
		public function PlayRecording(time:Number = 0):void
		{
			// attach the netStream object to the video object
			videoContainer.attachNetStream(ns);	
			// play back the recorded stream
			nsStopped = false;
			currentlyPlayingVideo=0;
			ns.play(recordingData.getVideoFeed(0));
			if(recordingData.getVideoFeed(1))
				{
					ns2.play(recordingData.getVideoFeed(1));
					ns2.pause();
				}
			if(time>0) ns.seek(time);
			presentNS = ns;
		}
		private function ShowPopUp(text:String, time:Number=1700):void
		{
			if(popUpID!=-1) clearTimeout(popUpID);
			while (popUp.numChildren > 0) {
				popUp.removeChildAt(0);
			}	
			popUp.alpha = 0.6;
			var rect:Sprite = new Sprite();
			rect.graphics.clear;
			rect.graphics.beginFill(0x000000, 1);
			rect.graphics.drawRoundRectComplex(0,0,200,50,5,5,5,5);
			rect.graphics.endFill();
			
			var tf:TextField = new TextField();
			tf.autoSize = "left";
			tf.textColor = 0xFFFFFF;
			tf.text = text;
			rect.width = tf.textWidth + 12;
			rect.height = tf.textHeight + 12;
			tf.x = Math.round(rect.width/2 - tf.width/2);
			tf.y = Math.round(rect.height/2 - tf.height/2);
			popUp.addChild(tf);
			popUp.addChildAt(rect, 0);
			popUp.visible = true;
			popUp.x=(_stage.stageWidth-popUp.width)/2;
			popUp.y=_stage.stageHeight - 100;
			popUpID=setTimeout(HidePopUp, time);
			
		}
		
		private function HidePopUp():void
		{
			popUp.visible=false;
			//popUpTimer.stop();
		}
		
		private function _onMouseDown (e:MouseEvent):void {

			var time:Number = getTimer();
			presentSlideStrokes[presentSlideStrokes.length]=new RecordEvent(RecordEvent.MOUSE_DOWN, e.localX/strokesData.width, e.localY/strokesData.height, e.ctrlKey, toolSelected,time);
			if(_playerState=="RECORDING")
			{
				recordingData.AddEvent(new RecordEvent(RecordEvent.MOUSE_DOWN, e.localX/strokesData.width, e.localY/strokesData.height, e.ctrlKey, toolSelected,time));
				
				/*var revent:XML=<RECORD_EVENT>
						<TYPE> {RecordEvent.MOUSE_DOWN} </TYPE>
						<X> {e.localX} </X>
						<Y> {e.localY} </Y>
						<CTRLKEY> {e.ctrlKey}</CTRLKEY>
						<TOOL>{toolSelected}</TOOL>
						<TIME>{time}</TIME>
						</RECORD_EVENT>;
				strokesRecording.appendChild(revent); */
			}
			if(toolSelected== TOOL_NONE) return;
			var c:uint = (!e.ctrlKey?0x000000:0x000000);
			strokeShape.graphics.lineStyle (10, c, 1);
			strokeShape.graphics.moveTo (e.localX,e.localY);
			md = true;
		}
		//
		private function _onMouseUp (e:MouseEvent):void {
			var time:Number = getTimer();
			presentSlideStrokes[presentSlideStrokes.length]=new RecordEvent(RecordEvent.MOUSE_UP, e.localX/strokesData.width, e.localY/strokesData.height, e.ctrlKey, toolSelected,time);
			if(_playerState=="RECORDING")
			{
				recordingData.AddEvent(new RecordEvent(RecordEvent.MOUSE_UP, e.localX/strokesData.width, e.localY/strokesData.height, e.ctrlKey, toolSelected,time));
				/*var revent:XML=<RECORD_EVENT>
										<TYPE> {RecordEvent.MOUSE_UP} </TYPE>
										<X> {e.localX} </X>
										<Y> {e.localY} </Y>
										<CTRLKEY> {e.ctrlKey}</CTRLKEY>
										<TOOL>{toolSelected}</TOOL>
										<TIME>{time}</TIME>
								</RECORD_EVENT>;
				strokesRecording.appendChild(revent);*/
			}
			if(toolSelected== TOOL_NONE) return;
			md = false;
			if(toolSelected==TOOL_MARKER)
				strokesData.draw (strokeShape,null,null,(e.ctrlKey?"erase":"normal"));
			else if(toolSelected==TOOL_ERASER)
				strokesData.draw (strokeShape,null,null,"erase");
			strokeShape.graphics.clear ();
		}
		//
		private function _onMouseMove (e:MouseEvent):void {
			var time:Number = getTimer();
			presentSlideStrokes[presentSlideStrokes.length]=new RecordEvent(RecordEvent.MOUSE_MOVE, e.localX/strokesData.width, e.localY/strokesData.height, e.ctrlKey, toolSelected,time);
			if(_playerState=="RECORDING")
			{
				recordingData.AddEvent(new RecordEvent(RecordEvent.MOUSE_MOVE, e.localX/strokesData.width, e.localY/strokesData.height, e.ctrlKey, toolSelected, time));
					/*var revent:XML =<RECORD_EVENT>
										<TYPE> {RecordEvent.MOUSE_MOVE} </TYPE>
										<X> {e.localX} </X>
										<Y> {e.localY} </Y>
										<CTRLKEY> {e.ctrlKey}</CTRLKEY>
										<TOOL>{toolSelected}</TOOL>
										<TIME>{time}</TIME>
								</RECORD_EVENT>;
					strokesRecording.appendChild(revent);*/
			}
			if(toolSelected== TOOL_NONE) return;
			if (md) {
				strokeShape.graphics.lineTo (e.localX,e.localY);
				if(e.ctrlKey || toolSelected==TOOL_ERASER)
				{
					strokesData.draw (strokeShape,null,null,"erase");
					strokeShape.graphics.clear ();
					var c:uint = (!e.ctrlKey?0xffffff:0x000000);
					strokeShape.graphics.lineStyle (10, c, 1);
					strokeShape.graphics.moveTo (e.localX,e.localY);
				}
			}
		}
		
		
		
		private function DoAfterAddingToStage(event:Event=null):void
		{
			Security.allowDomain("*");
			_stage = this.stage;
			_stage.align = StageAlign.TOP_LEFT;
			_stage.scaleMode = StageScaleMode.NO_SCALE;
			_stage.addEventListener(Event.RESIZE, resizeHandler);
			trace(_stage.stageWidth + "====" + _stage.stageHeight);
			this.graphics.beginFill(0x000000, 1);
			this.graphics.drawRect(0, 0, _stage.stageWidth, _stage.stageHeight);
			this.graphics.endFill();
			
			//SLIDER LAYER - BOTTOM of ALL
			this.addChildAt(slider, 0);
			this.addChildAt(strokes, 1);
			
			//VIDEO CAPTURE WINDOW - Layer Above Slider
			this.addChildAt(videoCapture, 2);
			
			//CONTROLS LAYER
			this.addChildAt(controls, 3);
			
			this.addChildAt(enrichUI, 4);
			
			this.addChildAt(popUp, 5);
			

			
			
			loadingGifDO = new LOADING() as DisplayObject ;
			loadingGifDO.alpha = 0.8;
			loadingGifDO.visible = true;
			loadingGifDO.width = 65;
			loadingGifDO.height = 65;
			loadingGif.graphics.beginFill(0x000000, 0.8);
			loadingGif.graphics.drawRect( (stage.stageWidth - 84) / 2, (stage.stageHeight - 84) / 2, 65,65);
			loadingGif.graphics.endFill();
			loadingGif.addChild(loadingGifDO); 
			enrichUI.addChild(loadingGif);
			ShowPopUp("...Connecting to Video Server...", 10000);

			loadingGifDO.x = (stage.stageWidth - loadingGifDO.width) / 2;
			loadingGifDO.y = (stage.stageHeight - loadingGifDO.height) / 2;

			
			AddSliderWindow();
			AddControls();
			AddVideoWindow();
			videoCapture.visible= false;
			//TESTING
			//LoadImages("http://54.243.235.88/zikload-xml/uploads/document/f1359221827/thumbnails/", 7);
			if(deployMode=="playback" || deployMode=="enrich")
			{
				//var rFilePath:String = "https://video.beta.ziksana.com/zikload/flashrecording/dataTesting1.ecxml";
				var rFilePath:String = ExternalInterface.call("ff_get_recorded_file");
				var start:Number = rFilePath.lastIndexOf("/data");
				fileNameRecorded = rFilePath.substr(start+1);
				var myLoader:URLLoader = new URLLoader();
				myLoader.load(new URLRequest(rFilePath));
				myLoader.addEventListener(Event.COMPLETE, processXML);
			}
			else if (deployMode == "enhance")
			{
				var imagePath:String= ExternalInterface.call("ff_load_images");
				LoadImagesJS(imagePath); /// "Http://54.243.235.88/zikload-xml/uploads/doc/thumbnails|||10"
			}
			ChangeOptionMode(null);
			videoCaptureMode.alpha=0.4;
			
			//var myLoader:URLLoader = new URLLoader();
			//myLoader.load(new URLRequest("http://54.243.235.88/data.xml"));
			//myLoader.addEventListener(Event.COMPLETE, processXML);
			//ExternalInterface.addCallback("load_images_js", LoadImagesJS);
			//addChild(tempTF);
		}
		
		private function processXML(e:Event):void {
			var myXML:XML = new XML(e.target.data);
			initiateRecordingData(myXML);
		}
		
		private function initiateRecordingData(xmlData:XML):void
		{
			recordingData.startRecording(xmlData.INIT[0].TIME);
			recordingData.startSlide(xmlData.INIT[0].STARTSLIDE);
			recordingData.ImagePath(xmlData.INIT[0].IMAGEPATH);
			recordingData.NumberOfImages(xmlData.INIT[0].NUMBEROFIMAGES);
			var totalTime:Number = new Number(xmlData.INIT[0].TOTALTIME);
			LoadImages(xmlData.INIT[0].IMAGEPATH, new Number(xmlData.INIT[0].NUMBEROFIMAGES));
			var numberOfVideos:Number = xmlData.VIDEO.length();
			for (var i=0; i<numberOfVideos; i++)
			{
				recordingData.addVideoFeed(xmlData.VIDEO[i]);
			}
			videoRecordName = xmlData.VIDEO[0];
			//StartRecording();
			var numberOfEvents:Number = xmlData.RECORD_EVENT.length();
			trace(xmlData.INIT[0].IMAGEPATH +"---"+ numberOfEvents);
			for (var i=0; i<numberOfEvents; i++)
			{
				var ctrlKey:Boolean = (xmlData.RECORD_EVENT[i].CTRLKEY=="TRUE")? true: false;
				recordingData.AddEventFromFile(new RecordEvent(xmlData.RECORD_EVENT[i].TYPE,xmlData.RECORD_EVENT[i].X,xmlData.RECORD_EVENT[i].Y, ctrlKey, xmlData.RECORD_EVENT[i].TOOL,xmlData.RECORD_EVENT[i].TIME));
			}
			recordingData.stopRecordingFromFile(totalTime);
		}
		
		private function LoadImagesJS(path:String):void
		{
			var delim:Number = path.indexOf("|||");
			dataPath=path.substr(0,delim); 
			numberOfImages = new Number(path.substr(delim+3));
			LoadImages(dataPath, numberOfImages);
		}
		private function LoadImages(path:String, noi:Number):void
		{
			dataPath=path;
			numberOfImages = noi;
			for(var i:Number=0; i<numberOfImages; i++)
			{
				var image:MovieClip = new MovieClip();
				image.visible = false;
				var ldr:Loader = new Loader();
				image.x=10;
				image.y=15;
				var urlReq:URLRequest = new URLRequest(path+"img"+i+".jpg");
				trace("loading image: " + path+"img"+i+".jpg");
				ldr.load(urlReq);
				ldr.contentLoaderInfo.addEventListener(Event.COMPLETE, imageCompleteHandler);

				image.addChild(ldr);
				slider.addChild(image);
				sliderImages[i] = image;
			}
		}
		private var URLS:Array = new Array();
		private function imageCompleteHandler(e:Event):void {
			trace (e.target);
			var li:LoaderInfo = LoaderInfo(e.target);
			URLS.push(li.loaderURL);
			if(URLS.length==numberOfImages)
				loadOnScreen();
		}
		private function loadOnScreen():void {
			var sX:Number = (_stage.stageWidth-20)/(sliderImages[0].width) ;
			var sY:Number = (_stage.stageHeight - 70)/(sliderImages[0].height) ;
			sliderImageActualHeight=sliderImages[0].height;
			sliderImageActualWidth=sliderImages[0].width;
			sliderScaleFactor = sX<sY?sX:sY;
			
			sliderImages[0].scaleX = sliderScaleFactor;
			sliderImages[0].scaleY = sliderScaleFactor;
			if(sX>sY) 
			{
				sliderImages[0].x=(_stage.stageWidth-20-sliderImages[0].width)/2;
			}
			else 	sliderImages[0].y=(_stage.stageHeight -60-sliderImages[0].height)/2;
			//ShowPopUp(sliderImages[0].x +" ||| "+ _stage.stageWidth );
			for(var i:Number=1; i<sliderImages.length; i++)
			{
				sliderImages[i].scaleX = sliderScaleFactor;
				sliderImages[i].scaleY = sliderScaleFactor;
				if(sX>sY) 
				{
					sliderImages[i].x=sliderImages[0].x;
				}
				else 	sliderImages[i].y=sliderImages[0].y;
			}
			sliderImages[0].visible = true;
			presentSlide = 0;
			strokes.x = sliderImages[0].x;
			strokes.y = sliderImages[0].y;
			
			strokesData = new BitmapData(sliderImages[0].width,sliderImages[0].height,true,0);
			strokesBmp = new Bitmap(strokesData);
			trace(strokes.width + "++++" + strokes.visible);
			strokes.addChild (strokesBmp);
			// shape temporanea
			strokes.addChild (strokeShape);
			strokes.addEventListener (MouseEvent.MOUSE_DOWN, _onMouseDown);
			strokes.addEventListener (MouseEvent.MOUSE_MOVE, _onMouseMove);
			strokes.addEventListener (MouseEvent.MOUSE_UP, _onMouseUp);
			strokes.addEventListener (MouseEvent.MOUSE_OUT, _onMouseUp);
			contentLoaded=true;
			if(!serverConnected)
				ShowPopUp("Content Loaded , Connecting to Video Server..", 10000);
			else {
				ShowPopUp("Loading Complete");
				loadingGif.visible=false;
			}
		}
		private function AddSliderWindow():void
		{
			trace("ADDSLIDERWINDWOS CALLED");
			slider.graphics.clear();
			slider.graphics.beginFill(0x555555, 0.8);
			slider.graphics.drawRoundRectComplex(10, 10, _stage.stageWidth-20, _stage.stageHeight - 60, 5, 5, 5, 5);
			slider.graphics.endFill();
			slider.width = _stage.stageWidth-20;
			slider.height = _stage.stageHeight - 70;
		}
		
		private function AddVideoWindow():void
		{
			videoCapture.graphics.clear();
			videoCapture.graphics.beginFill(0xCCCCCC, 0.8);
			videoCapture.graphics.drawRoundRectComplex( _stage.stageWidth - 180 , 20, 160, 120, 5, 5, 5, 5);
			videoContainer.x = _stage.stageWidth - 180;
			videoContainer.y = 20;
			videoCapture.graphics.endFill();
			if(videoCapture.hasEventListener(MouseEvent.MOUSE_DOWN))
			{
				videoCapture.removeEventListener(MouseEvent.MOUSE_DOWN, StartDragging);
				videoCapture.removeEventListener(MouseEvent.MOUSE_UP, StopDragging);
			}
			//videoContainer.attachCamera(cam);
			videoCapture.addEventListener(MouseEvent.MOUSE_DOWN, StartDragging);
			videoCapture.addEventListener(MouseEvent.MOUSE_UP, StopDragging);
			var buttonMask:Sprite      = new Sprite();
			buttonMask.graphics.beginFill( 0x00ff00, 0 );  
			buttonMask.graphics.drawRoundRectComplex(0, 0, 160, 120, 6, 6, 6, 6);
			buttonMask.x = _stage.stageWidth - 180;
			buttonMask.y = 20;
			videoCapture.addChild(buttonMask);
			videoContainer.mask = buttonMask;
			videoCapture.addChild(videoContainer);
			videoCapture.y=100;

		}
		
		private function StartDragging(e:MouseEvent):void {
			var my_x:int= -stage.stageWidth + 190;
			var my_y:int= 0 - 10;
			
			//The height and width of the rectangle.
			var myWidth:int= 10-my_x ;
			var myHeight:int=stage.stageHeight - 70 - videoCapture.height  ;
			var boundArea:Rectangle=new Rectangle(my_x, my_y, myWidth ,myHeight);
			e.currentTarget.startDrag(false, boundArea);
		}
		
		private function StopDragging(e:MouseEvent):void {
			e.currentTarget.stopDrag();
		}
		
		private function increaseOpacity(e:MouseEvent):void {
			var tempMC:MovieClip = e.currentTarget as MovieClip;
			tempMC.alpha = 1;
		}
		
		
		private function decreaseOpacity(e:MouseEvent):void  {
			var tempMC:MovieClip = e.currentTarget as MovieClip;
			tempMC.alpha = 0.4;
		}
		
		private function GotoNextImage(e:MouseEvent):void {
			var i:Number;
			presentSlideStrokes.splice(0);
			presentSlideStrokes.length=0;
			for(i=0; i<sliderImages.length-1; i++)
				if(sliderImages[i].visible)
				{
					strokesData.dispose();
					sliderImages[i].visible = false;
					sliderImages[i+1].visible = true;
					presentSlide = i+1;
					ShowPopUp(presentSlide+1+"");
					if(_playerState=="RECORDING")
					{
						var time:Number = getTimer();
						recordingData.AddEvent(new RecordEvent(RecordEvent.SLIDE_NEXT, presentSlide, 0, false, 0, time));
					}
					strokesData = new BitmapData(sliderImages[i+1].width,sliderImages[i+1].height,true,0);
					strokesBmp = new Bitmap(strokesData);
					strokes.addChild (strokesBmp);
					break;
				}
			if(i==sliderImages.length-1) ShowPopUp("You have reached the final slide");
		}
		
		private function GotoPreviousImage(e:MouseEvent):void {
			presentSlideStrokes.splice(0);
			presentSlideStrokes.length=0;
			if(sliderImages[0].visible)
			{
				ShowPopUp("You are at the first slide");
				return;
			}
			for(var i:Number=1; i<sliderImages.length; i++)
				if(sliderImages[i].visible)
				{
					strokesData.dispose();
					sliderImages[i].visible = false;
					sliderImages[i-1].visible = true;
					presentSlide = i-1;
					ShowPopUp(presentSlide+1+"");
					if(_playerState=="RECORDING")
					{
						var time:Number = getTimer();
						recordingData.AddEvent(new RecordEvent(RecordEvent.SLIDE_PREV, presentSlide, 0, false, 0, time));
						/*var revent:XML =<RECORD_EVENT>
																<TYPE> {RecordEvent.SLIDE_PREV} </TYPE>
																<X> {presentSlide} </X>
																<Y> 0 </Y>
																<CTRLKEY> false</CTRLKEY>
																<TOOL>0</TOOL>
																<TIME>{time}</TIME>
														</RECORD_EVENT>;
						strokesRecording.appendChild(revent);*/
					}
					strokesData = new BitmapData(sliderImages[i-1].width,sliderImages[i-1].height,true,0);
					strokesBmp = new Bitmap(strokesData);
					strokes.addChild (strokesBmp);
					break;
				}
		}
		
		private function Record(e:MouseEvent):void {
			if(record.hasEventListener(MouseEvent.MOUSE_OUT))
			{
				record.removeEventListener(MouseEvent.MOUSE_OUT, increaseOpacity );

				if(!recordingData.isRecording && !recordingData.hasRecordingData)
				{
					var time:Number = getTimer();
					recordingData.startRecording(time);
					recordingData.startSlide(presentSlide);
					recordingData.ImagePath(dataPath);
					recordingData.NumberOfImages(numberOfImages);
					StartRecording();
					recordingData.addVideoFeed(videoRecordName);
					play.removeEventListener(MouseEvent.CLICK, Play);
					strokes.addEventListener (MouseEvent.MOUSE_DOWN, _onMouseDown);
					strokes.addEventListener (MouseEvent.MOUSE_MOVE, _onMouseMove);
					strokes.addEventListener (MouseEvent.MOUSE_UP, _onMouseUp);
					strokes.addEventListener (MouseEvent.MOUSE_OUT, _onMouseUp);

					/*var revent:XML =<INIT>
											<STARTSLIDE> {presentSlide} </STARTSLIDE>
											<IMAGEPATH> {dataPath} </IMAGEPATH>
											<NUMBEROFIMAGES> {numberOfImages} </NUMBEROFIMAGES>
											<TIME> {time}</TIME>
											<Video> {videoRecordName} </Video>
									</INIT>;
					strokesRecording.appendChild(revent);*/
				}
				else if(recordingData.hasRecordingData && !recordingData.isRecording && (currentlyPlayingTime!=0 && _playerState!="PAUSED"))
					{
						ShowPopUp("Please Pause and press ReRecord");
						return;
					}
				else if(recordingData.hasRecordingData && !recordingData.isRecording && (currentlyPlayingTime!=0 && _playerState=="PAUSED"))
				{
					//GOING TO RERECORD MODE
					if(currentlyPlayingEvent ==0 || currentlyPlayingTime==0) 
					{
						ShowPopUp("Unable to handle request. Choose another point to start recording");
						return;
					}
					var timeOfSwitch:Number = lastSwitchTime + presentNS.time*1000;
					var endTime = presentNS.time;
					_playerState == "PAUSED";
					presentNS.pause();
					
					presentNS.close();
					trace("RE-RECORDING");
					strokes.addEventListener (MouseEvent.MOUSE_DOWN, _onMouseDown);
					strokes.addEventListener (MouseEvent.MOUSE_MOVE, _onMouseMove);
					strokes.addEventListener (MouseEvent.MOUSE_UP, _onMouseUp);
					strokes.addEventListener (MouseEvent.MOUSE_OUT, _onMouseUp);

					videoContainer.attachCamera(cam);
					seekBar.visible=false;
					//pendingStartRecording=true;
					StartRecording();
					var addedVideoNumber:Number = recordingData.addVideoFeed(videoRecordName);
					recordingData.addEndTime(endTime);
					recordingData.reRecordFrom(currentlyPlayingEvent, timeOfSwitch, getTimer());
					currentlyPlayingEvent = 0;
					_playerState = "RECORDING";
					recordingData.AddEvent(new RecordEvent(RecordEvent.VIDEO_SWITCH, addedVideoNumber, 0, false, 0,getTimer()+1));
				}
				else if(recordingData.hasRecordingData && !recordingData.isRecording && (currentlyPlayingTime==0 && _playerState=="PAUSED"))
				{
					strokes.addEventListener (MouseEvent.MOUSE_DOWN, _onMouseDown);
					strokes.addEventListener (MouseEvent.MOUSE_MOVE, _onMouseMove);
					strokes.addEventListener (MouseEvent.MOUSE_UP, _onMouseUp);
					strokes.addEventListener (MouseEvent.MOUSE_OUT, _onMouseUp);
					
					//videoContainer.attachCamera(cam);
					seekBar.visible=false;
					ns.resume();
					recordingData.resumeRecording();
				}
				_playerState = "RECORDING";
				ShowPopUp("Recording now...");
				if( !play.hasEventListener(MouseEvent.MOUSE_OUT))
				{
					play.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity );
					play.alpha = 1;
				}
				if( !stop.hasEventListener(MouseEvent.MOUSE_OUT))
				{
					stop.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity );
					stop.alpha = 1;
				}
				if( !pause.hasEventListener(MouseEvent.MOUSE_OUT))
				{
					pause.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity );
					pause.alpha = 1;
				}				
			}
			else 
			{
				if(recordingData.isRecording)
				{
					ShowPopUp("Stopping Record. You can now play it back!");
					recordingData.stopRecording();
					StopRecording();
				}
				else 
					ShowPopUp("Stopped.");
				
				_playerState = "STOPPED";
				
				record.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity);
			}
			
		}
		
		private function Play(e:MouseEvent):void {
			if(_playerState=="RECORDING")
			{
				ShowPopUp("Recording in Progress");
				return;
			}
			if(play.hasEventListener(MouseEvent.MOUSE_OUT))
			{
				if(_playerState=="PAUSED")
				{
					_playerState = "PLAYING";
					SimulateEvents(200);
					ns.resume();
				}
				else if(recordingData.hasRecordingData)
				{
					_playerState = "PLAYING";
					PlayRecording();
					ShowPopUp("Playback");
					PlayBack();
				}
				else {
					ShowPopUp("Nothing recorded to be played back");
					return;
				}
				play.removeEventListener(MouseEvent.MOUSE_OUT, increaseOpacity );
				if( !record.hasEventListener(MouseEvent.MOUSE_OUT))
				{
					record.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity );
					record.alpha = 1;
				}
				if( !stop.hasEventListener(MouseEvent.MOUSE_OUT))
				{
					stop.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity );
					stop.alpha = 1;
				}
				if( !pause.hasEventListener(MouseEvent.MOUSE_OUT))
				{
					pause.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity );
					pause.alpha = 1;
				}
			}
			else 
			{
				_playerState = "STOPPED";
				ShowPopUp("Stopped.");
				play.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity);
			}
		}
		
		//RECORDED PLAYBACK
		
		private function RecordMouseDown (e:RecordEvent):void {
			if(!resizing) presentSlideStrokes[presentSlideStrokes.length]=e;
			if(toolSelected== TOOL_NONE) return;
			var c:uint = (!e.ctrlKeyPressed?0x000000:0x000000);
			strokeShape.graphics.lineStyle (7, c, 1);
			strokeShape.graphics.moveTo (e.eventX*strokesData.width,e.eventY*strokesData.height);
			md = true;
			//ShowPopUp("MD IS TRUE");
		}
		//
		private function RecordMouseUp (e:RecordEvent):void {
			if(!resizing) presentSlideStrokes[presentSlideStrokes.length]=e;
			if(toolSelected== TOOL_NONE) return;
			md = false;
			if(toolSelected==TOOL_MARKER	)
				strokesData.draw (strokeShape,null,null,(e.ctrlKeyPressed?"erase":"normal"));
			else if(toolSelected==TOOL_ERASER)
				strokesData.draw (strokeShape,null,null,"erase");
			strokeShape.graphics.clear ();
		}
		//
		private function RecordMouseMove (e:RecordEvent):void {
			if(!resizing)  presentSlideStrokes[presentSlideStrokes.length]=e;
			if(toolSelected== TOOL_NONE) return;
			if (md) {
				strokeShape.graphics.lineTo (e.eventX*strokesData.width,e.eventY*strokesData.height);
				if(e.ctrlKeyPressed || toolSelected==TOOL_ERASER)
				{
					strokesData.draw (strokeShape,null,null,"erase");
					strokeShape.graphics.clear ();
					var c:uint = (!e.ctrlKeyPressed?0xffffff:0x000000);
					strokeShape.graphics.lineStyle (7, c, 1);
					strokeShape.graphics.moveTo (e.eventX*strokesData.width,e.eventY*strokesData.height);
				}
			}
		}
		
		private function PlayBack(time:Number = 0):void {
			strokes.removeEventListener (MouseEvent.MOUSE_DOWN, _onMouseDown);
			strokes.removeEventListener (MouseEvent.MOUSE_MOVE, _onMouseMove);
			strokes.removeEventListener (MouseEvent.MOUSE_UP, _onMouseUp);
			strokes.removeEventListener (MouseEvent.MOUSE_OUT, _onMouseUp);
			presentSlideStrokes.splice(0);
			strokesData.dispose();
			sliderImages[presentSlide].visible = false;
			sliderImages[recordingData.startSlideNumber].visible = true;
			presentSlide = recordingData.startSlideNumber;
			strokesData = new BitmapData(sliderImages[0].width,sliderImages[0].height,true,0);
			strokesBmp = new Bitmap(strokesData);
			strokes.addChild (strokesBmp);
			seekBar.visible = true;
			currentlyPlayingEvent = 0;
			currentlyPlayingTime = 0;
			SimulateEvents(200, time);
			
		}
		private function SwitchNetStream(videoName:String):void{
			trace("SWITCH STREAM");
			//videoContainer.attachNetStream(null);
			if(currentlyPlayingVideo%2==0){	
				presentNS = ns2;
				ns.close();
				currentlyPlayingVideo++;
				if(recordingData.getVideoFeed(currentlyPlayingVideo+1)!=null)
				{
					ns.play(recordingData.getVideoFeed(currentlyPlayingVideo+1));
					ns.pause();
				}
				videoContainer.attachNetStream(presentNS);
				//presentNS.seek(0);
				presentNS.resume();
			}
			else {
				presentNS = ns;
				ns2.close();
				currentlyPlayingVideo++;
				if(recordingData.getVideoFeed(currentlyPlayingVideo+1)!=null)
				{
					ns2.play(recordingData.getVideoFeed(currentlyPlayingVideo+1));
					ns2.pause();
				}
					videoContainer.attachNetStream(presentNS);
				//presentNS.seek(0);
				presentNS.resume();
			}
		}
		var lastSwitchTime:Number = 0;
		private function SimulateEvents(time:Number, seekLevel:Number = 0):void {
			var seekDone:Boolean = false;
			
			while(!seekDone && seekLevel!=0)
			{
				_playerState = "SEEKING";
				while (!seekDone && recordingData.getEvent(currentlyPlayingEvent)!=null  )
				{
					var currentRecordEvent:RecordEvent = recordingData.getEvent(currentlyPlayingEvent);
					//ShowPopUp(currentRecordEvent.eventTool+"");
					toolSelected = currentRecordEvent.eventTool;
					if(currentRecordEvent.eventType == RecordEvent.MOUSE_DOWN)
						RecordMouseDown(currentRecordEvent);
					else if (currentRecordEvent.eventType == RecordEvent.MOUSE_MOVE)
						RecordMouseMove(currentRecordEvent);
					else if (currentRecordEvent.eventType == RecordEvent.MOUSE_UP)
						RecordMouseUp(currentRecordEvent);
					else if(currentRecordEvent.eventType == RecordEvent.SLIDE_NEXT)
						GotoNextImage(null);
					else if (currentRecordEvent.eventType == RecordEvent.SLIDE_PREV)
						GotoPreviousImage(null);
					else if (currentRecordEvent.eventType == RecordEvent.VIDEO_SWITCH)
					{
						SwitchNetStream(recordingData.getVideoFeed(currentRecordEvent.eventX));
						lastSwitchTime += presentNS.time *1000;
					}
					if (recordingData.getEvent(currentlyPlayingEvent).eventTime>seekLevel) seekDone=true;
					currentlyPlayingEvent++;
				}
			}
			if(seekDone && seekLevel>0) 
			{
				_playerState="PLAYING";
				currentlyPlayingTime=seekLevel;
				presentNS.seek((seekLevel-lastSwitchTime)/1000);
			}
			if(_playerState == "SEEKING" || _playerState == "PAUSED" ) 
			{
				return;
			}
			if(_playerState == "STOPPED")
			{
				presentSlideStrokes.splice(0);
				strokesData.dispose();
				sliderImages[presentSlide].visible = false;
				sliderImages[recordingData.startSlideNumber].visible = true;
				presentSlide = recordingData.startSlideNumber;
				strokesData = new BitmapData(sliderImages[0].width,sliderImages[0].height,true,0);
				strokesBmp = new Bitmap(strokesData);
				strokes.addChild (strokesBmp);
				seekBar.visible = true;
				currentlyPlayingEvent = 0;
				currentlyPlayingTime = 0;
				seekBarIndicator.x = SLIDER_LENGTH * (currentlyPlayingTime/recordingData.totalTime);
				seekBarText.text = Math.floor(currentlyPlayingTime/60000) + ":"+ Math.floor((currentlyPlayingTime%60000)/1000);
				lastSwitchTime = 0;
				return;
			}
			
			currentlyPlayingTime+=time;
			seekBarIndicator.x = SLIDER_LENGTH * ((presentNS.time*1000+lastSwitchTime)/recordingData.totalTime);
			seekBarText.text = Math.floor((presentNS.time+lastSwitchTime/1000)/60) + ":"+ Math.floor((presentNS.time+lastSwitchTime/1000)%60);
			while (recordingData.getEvent(currentlyPlayingEvent)!=null && recordingData.getEvent(currentlyPlayingEvent).eventTime  < lastSwitchTime+(presentNS.time*1000) )
			{
			//ShowPopUp(recordingData.getEvent(currentlyPlayingEvent).eventType + "");
			
			var currentRecordEvent:RecordEvent = recordingData.getEvent(currentlyPlayingEvent);
			//ShowPopUp(currentRecordEvent.eventTool+"");
			toolSelected = currentRecordEvent.eventTool;
			if(currentRecordEvent.eventType == RecordEvent.MOUSE_DOWN)
				RecordMouseDown(currentRecordEvent);
			else if (currentRecordEvent.eventType == RecordEvent.MOUSE_MOVE)
				RecordMouseMove(currentRecordEvent);
			else if (currentRecordEvent.eventType == RecordEvent.MOUSE_UP)
				RecordMouseUp(currentRecordEvent);
			else if(currentRecordEvent.eventType == RecordEvent.SLIDE_NEXT)
				GotoNextImage(null);
			else if (currentRecordEvent.eventType == RecordEvent.SLIDE_PREV)
				GotoPreviousImage(null);
			else if (currentRecordEvent.eventType == RecordEvent.VIDEO_SWITCH)
			{
				lastSwitchTime += presentNS.time *1000;
				trace("LAST SWITCH TIME:" + lastSwitchTime);
					SwitchNetStream(recordingData.getVideoFeed(currentRecordEvent.eventX));
			}
			currentlyPlayingEvent++;
			
				if(_playerState == "SEEKING" || _playerState == "PAUSED" ) 
				{
					return;
				}
				if(_playerState == "STOPPED")
				{
					presentSlideStrokes.splice(0);
					strokesData.dispose();
					sliderImages[presentSlide].visible = false;
					sliderImages[recordingData.startSlideNumber].visible = true;
					presentSlide = recordingData.startSlideNumber;
					strokesData = new BitmapData(sliderImages[0].width,sliderImages[0].height,true,0);
					strokesBmp = new Bitmap(strokesData);
					strokes.addChild (strokesBmp);
					seekBar.visible = true;
					currentlyPlayingEvent = 0;
					currentlyPlayingTime = 0;
					seekBarIndicator.x = SLIDER_LENGTH * ((presentNS.time*1000+lastSwitchTime)/recordingData.totalTime);
					seekBarText.text = Math.floor((presentNS.time+lastSwitchTime/1000)/60) + ":"+ Math.floor((presentNS.time+lastSwitchTime/1000)%60);
					lastSwitchTime =0;
					return;
				}
			}
			//trace(recordingData.getEvent(currentlyPlayingEvent)!=null); && (recordingData.getEvent(currentlyPlayingEvent)).eventTime<ns.time*1000
			if((recordingData.getEvent(currentlyPlayingEvent)!=null || currentlyPlayingTime<recordingData.totalTime  ) )
			setTimeout(function(){SimulateEvents(200);}, time);
			else {
				trace("NS:==== REC TOTAL:"+ recordingData.totalTime );
				play.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity);
				play.alpha = 1;
				currentlyPlayingEvent = 0;
				currentlyPlayingTime = 0;
				lastSwitchTime = 0;
				return;
			}
		}
		
		private function Stop(e:MouseEvent):void {
			if(_playerState=="STOPPED") return;
			strokes.removeEventListener (MouseEvent.MOUSE_DOWN, _onMouseDown);
			strokes.removeEventListener (MouseEvent.MOUSE_MOVE, _onMouseMove);
			strokes.removeEventListener (MouseEvent.MOUSE_UP, _onMouseUp);
			strokes.removeEventListener (MouseEvent.MOUSE_OUT, _onMouseUp);
			
			if(stop.hasEventListener(MouseEvent.MOUSE_OUT))
			{
				if(_playerState=="PLAYING") {
					presentNS.close();
					presentSlideStrokes.splice(0);
					strokesData.dispose();
					sliderImages[presentSlide].visible = false;
					sliderImages[recordingData.startSlideNumber].visible = true;
					presentSlide = recordingData.startSlideNumber;
					strokesData = new BitmapData(sliderImages[0].width,sliderImages[0].height,true,0);
					strokesBmp = new Bitmap(strokesData);
					strokes.addChild (strokesBmp);
					seekBar.visible = true;
					currentlyPlayingEvent = 0;
					currentlyPlayingTime = 0;
					seekBarIndicator.x = SLIDER_LENGTH * (currentlyPlayingTime/recordingData.totalTime);
					seekBarText.text = Math.floor(currentlyPlayingTime/60000) + ":"+ Math.floor((currentlyPlayingTime%60000)/1000);
					lastSwitchTime = 0;
				}
				stop.removeEventListener(MouseEvent.MOUSE_OUT, increaseOpacity );
				_playerState = "STOPPED";
				
				if(recordingData.isRecording)
				{
					ShowPopUp("You can play the recording or ReRecord!");
					record.removeChildAt(0);
					var test:Bitmap = new RERECORD();
					record.addChild(test);
					var endTime = ns.time; 
					recordingData.addEndTime(-1);
					recordingData.stopRecording();
					StopRecording();
					play.addEventListener(MouseEvent.CLICK, Play);
					lastSwitchTime =0;
				} else ShowPopUp("Stopped.");
				
				if( !record.hasEventListener(MouseEvent.MOUSE_OUT))
				{
					record.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity );
					record.alpha = 1;
				}
				if( !play.hasEventListener(MouseEvent.MOUSE_OUT))
				{
					play.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity );
					play.alpha = 1;
				}
				if( !pause.hasEventListener(MouseEvent.MOUSE_OUT))
				{
					pause.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity );
					pause.alpha = 1;
				}
			}
			else 
			{
				_playerState = "STOPPED";
				stop.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity);
			}
		}
		
		private function Pause(e:MouseEvent):void {
			if(_playerState=="STOPPED" || _playerState=="PAUSED") return;
			strokes.removeEventListener (MouseEvent.MOUSE_DOWN, _onMouseDown);
			strokes.removeEventListener (MouseEvent.MOUSE_MOVE, _onMouseMove);
			strokes.removeEventListener (MouseEvent.MOUSE_UP, _onMouseUp);
			strokes.removeEventListener (MouseEvent.MOUSE_OUT, _onMouseUp);
			
			if(pause.hasEventListener(MouseEvent.MOUSE_OUT))
			{
				pause.removeEventListener(MouseEvent.MOUSE_OUT, increaseOpacity );
				if(recordingData.isRecording)
				{
					recordingData.pauseRecording();
					ns.pause();
				}
				if(_playerState=="PLAYING")
				{
					_playerState == "PAUSED";
						presentNS.pause();
					ShowPopUp("Paused.");
				}
				_playerState = "PAUSED";				
				if( !record.hasEventListener(MouseEvent.MOUSE_OUT))
				{
					record.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity );
					record.alpha = 1;
				}
				if( !play.hasEventListener(MouseEvent.MOUSE_OUT))
				{
					play.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity );
					play.alpha = 1;
				}
				if( !stop.hasEventListener(MouseEvent.MOUSE_OUT))
				{
					stop.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity );
					stop.alpha = 1;
				}
			}
			else 
			{
				_playerState = "PAUSED";
				pause.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity);
			}	
		}
		
		private function Marker(e:MouseEvent):void {
			if(marker.hasEventListener(MouseEvent.MOUSE_OUT))
			{
				marker.removeEventListener(MouseEvent.MOUSE_OUT, increaseOpacity );
				if( !eraser.hasEventListener(MouseEvent.MOUSE_OUT))
				{
					eraser.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity );
					eraser.alpha = 1;
				}
				toolSelected = TOOL_MARKER;
				ShowPopUp("You have selected Marker tool");
			}
			else 
			{
				marker.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity);
				toolSelected = TOOL_NONE;
				ShowPopUp("No drawing tools selected");
			}
		}
		
		private function Eraser(e:MouseEvent):void {
			if(eraser.hasEventListener(MouseEvent.MOUSE_OUT))
			{
				eraser.removeEventListener(MouseEvent.MOUSE_OUT, increaseOpacity );
				if( !marker.hasEventListener(MouseEvent.MOUSE_OUT))
				{
					marker.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity );
					marker.alpha = 1;
				}
				toolSelected = TOOL_ERASER;
				ShowPopUp("You have selected the eraser tool");
			}
			else 
			{
				eraser.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity);
				toolSelected = TOOL_NONE;
				ShowPopUp("No drawing tools selected");
			}
		}
		
		private function Save(e:MouseEvent):void{
			loadingGif.visible=true;
			ShowPopUp("Saving...",20000);
			var data:String =fileNameRecorded;
			if(deployMode=="playback")
			{
				var revent:XML =<INIT>
									<FILE>{data}</FILE>
									<STARTSLIDE> {recordingData.startSlideNumber} </STARTSLIDE>
									<IMAGEPATH> {dataPath} </IMAGEPATH>
									<NUMBEROFIMAGES> {numberOfImages} </NUMBEROFIMAGES>
									<TIME> {recordingData.StartTime}</TIME>
									<TOTALTIME>{recordingData.totalTime}</TOTALTIME>
							</INIT>;
			}
			else var revent:XML =<INIT>
									<STARTSLIDE> {recordingData.startSlideNumber} </STARTSLIDE>
									<IMAGEPATH> {dataPath} </IMAGEPATH>
									<NUMBEROFIMAGES> {numberOfImages} </NUMBEROFIMAGES>
									<TIME> {recordingData.StartTime}</TIME>
									<TOTALTIME>{recordingData.totalTime}</TOTALTIME>
							</INIT>;
			strokesRecording.appendChild(revent);
			
			
			var i:Number = 0;
			while(recordingData.getVideoFeed(i)!=null)
			{
				var revent:XML = <VIDEO>{recordingData.getVideoFeed(i)}</VIDEO>;
				strokesRecording.appendChild(revent);
				i++;
			}
			i=0;
			var currentEvent:RecordEvent;
			while(recordingData.getEvent(i)!=null  )
			{
				currentEvent = recordingData.getEvent(i);
				var revent:XML =<RECORD_EVENT>
														<TYPE> {currentEvent.eventType} </TYPE>
														<X> {currentEvent.eventX} </X>
														<Y> {currentEvent.eventY} </Y>
														<CTRLKEY> {currentEvent.ctrlKeyPressed}</CTRLKEY>
														<TOOL>{currentEvent.eventTool}</TOOL>
														<TIME>{currentEvent.eventTime}</TIME>
												</RECORD_EVENT>;
				strokesRecording.appendChild(revent);	
				i++;
			}
			sendDataToPHP();
			ShowPopUp("Saved Successfully!");
			loadingGif.visible = false;
		}
		
		private function FullScreen(e:MouseEvent):void {
			//ShowPopUp("Fullscreen mode DISABLED in this release.");
			if(loadingGif.visible == true) { ShowPopUp("Please try after Loadin/Processing completes."); return; }
			if(_stage.displayState != StageDisplayState.FULL_SCREEN)
			{
				_stage.displayState = StageDisplayState.FULL_SCREEN
			}
			else _stage.displayState = StageDisplayState.NORMAL;
		}
		public function seekUpdate(e:MouseEvent):void {
			_playerState = "SEEKING";
			seekBarIndicator.x = e.localX;
			var seekLevel:Number = seekBarIndicator.x/SLIDER_LENGTH * recordingData.totalTime;
			PlayRecording();
			//PlayBack(seekLevel);	
			seekBarText.text = Math.floor(seekLevel/60000) + ":"+ Math.floor((seekLevel%60000)/1000);
		}
		private function AddControls():void
		{
			//controls.width=400;
			//controls.height=50;
			controls.x = (_stage.stageWidth - SLIDER_LENGTH)/2;
			controls.y = _stage.stageHeight - 35;
			
			seekBarText.textColor = 0xFFFFFF;
			seekBarText.text = "00:00";

			seekBarText.x =  SLIDER_LENGTH + 15;;
			seekBarText.y = -5;
			seekBarText.width=100;
			
			var seekBarRectangle:Sprite = new Sprite();
			seekBarRectangle.graphics.beginFill(0xFFFFFF, 0.7);
			seekBarRectangle.graphics.drawRoundRectComplex(0,0,SLIDER_LENGTH,4,2,2,2,2);
			seekBarRectangle.graphics.endFill();
			seekBar.addChild(seekBarRectangle);
			//seekBarRectangle.addEventListener(MouseEvent.CLICK,seekUpdate);
			
			seekBarIndicator.graphics.beginFill(0xFFFFFF, 1);
			seekBarIndicator.graphics.drawCircle(0,0,6);
			seekBarIndicator.graphics.endFill();	
			seekBarIndicator.x = 5;
			seekBarIndicator.y = 1;
			seekBar.addChild(seekBarIndicator);
			seekBar.addChild(seekBarText);
			seekBar.x = 0;
			seekBar.y = -15;
			var test:Bitmap;
			//if(deployMode!="playback" && deployMode!="enrich")
			{
			seekBar.visible=false;
			
			test = new RECORD();
			record.addChild(test);
			record.x = 0;
			record.alpha = 1;
			record.addEventListener(MouseEvent.MOUSE_OVER, decreaseOpacity); 
			record.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity); 
			record.addEventListener(MouseEvent.CLICK, Record);
			}
			test = new PLAY();
			play.addChild(test);
			play.x = 35;
			play.alpha = 1;
			play.addEventListener(MouseEvent.MOUSE_OVER, decreaseOpacity); 
			play.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity); 
			play.addEventListener(MouseEvent.CLICK, Play);
			
			editVideo.graphics.beginFill(0xFFFFFF, 0.8);
			editVideo.graphics.drawRoundRectComplex(0,0,60,30, 4,4,4,4);
			editVideo.graphics.endFill();
			editVideo.x = -120;
			var textF:TextField = new TextField();
			textF.text = "EDIT";
			textF.x = 14;
			textF.y = 5;
			textF.textColor = 0x000000;
			editVideo.addChild(textF);
			editVideo.addEventListener(MouseEvent.CLICK, EditVideo);
			
			test = new PAUSE();
			pause.addChild(test);
			pause.x = 70;
			pause.alpha = 1;
			pause.addEventListener(MouseEvent.MOUSE_OVER, decreaseOpacity); 
			pause.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity); 
			pause.addEventListener(MouseEvent.CLICK, Pause);
			
			
			test = new STOP();
			stop.addChild(test);
			stop.x = 105;
			stop.alpha = 1;
			stop.addEventListener(MouseEvent.MOUSE_OVER, decreaseOpacity); 
			stop.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity); 
			stop.addEventListener(MouseEvent.CLICK, Stop);
			if(deployMode=="enrich")
			{
				hotspotIcon.buttonMode = true;
				hotspotIcon.useHandCursor = true;
				hotspotIcon.y=10;
				hotspotIcon.x= stage.stageWidth - 50;
				var test:Bitmap = new HOTSPOTICON();
				hotspotIcon.addChild(test);
				enrichUI.addChild(hotspotIcon);
				trace("ADDIONG HOTSPOT ICON");
				
				eTocIcon.y=10;
				eTocIcon.x= stage.stageWidth - 100;
				eTocIcon.buttonMode = true;
				eTocIcon.useHandCursor = true;
				var test:Bitmap = new ETOCICON();
				eTocIcon.addChild(test);
				enrichUI.addChild(eTocIcon);
				
				eNoteIcon.y=10;
				eNoteIcon.x= stage.stageWidth - 200;
				eNoteIcon.buttonMode = true;
				eNoteIcon.useHandCursor = true;
				var test:Bitmap = new ENOTEICON();
				eNoteIcon.addChild(test);
				enrichUI.addChild(eNoteIcon);
				eNoteIcon.addEventListener(MouseEvent.CLICK, fAddENote);
				
				eRefIcon.y=10;
				eRefIcon.x= stage.stageWidth - 150;
				eRefIcon.buttonMode = true;
				eRefIcon.useHandCursor = true;
				var test:Bitmap = new EREFICON();
				eRefIcon.addChild(test);
				enrichUI.addChild(eRefIcon);
				eRefIcon.addEventListener(MouseEvent.CLICK, fAddERef);
				
				
				
			}
			//if(deployMode!="playback" && deployMode!="enrich")
			{
			test = new PREVIOUS();
			previous.addChild(test);
			previous.x = - controls.x + 20;
			previous.y = -(controls.y - 30)/2;
			previous.alpha = 1;
			previous.addEventListener(MouseEvent.CLICK, GotoPreviousImage);
			previous.addEventListener(MouseEvent.MOUSE_OVER, decreaseOpacity); 
			previous.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity); 
			
			test = new NEXT();
			next.addChild(test);
			trace("Controls Width:"+ controls);
			next.x = (SLIDER_LENGTH + controls.x)-50;
			next.y =  -(controls.y-30)/2;
			next.alpha = 1;
			next.addEventListener(MouseEvent.CLICK, GotoNextImage);
			next.addEventListener(MouseEvent.MOUSE_OVER, decreaseOpacity); 
			next.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity); 
			
			test = new MARKER();
			marker.addChild(test);
			marker.x = 140;
			marker.alpha = 1;
			marker.addEventListener(MouseEvent.MOUSE_OVER, decreaseOpacity); 
			marker.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity);
			marker.addEventListener(MouseEvent.CLICK, Marker);
			
			test = new ERASER();
			eraser.addChild(test);
			eraser.x = 175;
			eraser.alpha = 1;
			eraser.addEventListener(MouseEvent.MOUSE_OVER, decreaseOpacity); 
			eraser.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity); 
			eraser.addEventListener(MouseEvent.CLICK, Eraser);
			}
			test = new FULLSCREEN();
			fullscreen.addChild(test);
			fullscreen.x = 210;
			fullscreen.alpha = 1;
			fullscreen.addEventListener(MouseEvent.MOUSE_OVER, decreaseOpacity); 
			fullscreen.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity);
			fullscreen.addEventListener(MouseEvent.CLICK, FullScreen);
			
			test = new WEBCAM();
			videoCaptureMode.addChild(test);
			videoCaptureMode.addEventListener(MouseEvent.MOUSE_OVER, decreaseOpacity); 
			videoCaptureMode.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity);
			videoCaptureMode.addEventListener(MouseEvent.CLICK, ChangeOptionMode);
			videoCaptureMode.x=245;
			//videoCaptureMode.addChild(videoCaptureModeText);

			test = new SAVE();
			save.addChild(test);
			trace("Controls Width:"+ controls);
			save.x = (SLIDER_LENGTH + controls.x)-50;
			save.alpha = 1;
			save.addEventListener(MouseEvent.CLICK, Save);
			next.addEventListener(MouseEvent.MOUSE_OVER, decreaseOpacity); 
			next.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity); 
			
			controls.addChild(play);
			controls.addChild(stop);
			if(deployMode!="playback" && deployMode!="enrich")
			{
				controls.addChild(record);
				controls.addChild(save);
				controls.addChild(previous);
				controls.addChild(next);
				controls.addChild(marker);
				controls.addChild(eraser);
			}
			if(deployMode=="playback")
				controls.addChild(editVideo);
			
			controls.addChild(fullscreen);
			controls.addChild(videoCaptureMode);
			controls.addChild(seekBar);
			controls.addChild(pause);
			
			//trace(controls.width +"==="+controls.height);
		}
		
		protected function EditVideo(event:MouseEvent):void
		{
			// TODO Auto-generated method stub
			editVideo.visible= false;
			controls.addChild(record);
			controls.addChild(save);
			controls.addChild(previous);
			controls.addChild(next);
			controls.addChild(marker);
			controls.addChild(eraser);
			var test:Bitmap = new RERECORD();
			record.addChild(test);
			marker.visible = true;
			
		}		
		
		private function ChangeOptionMode(e:MouseEvent):void {
			if(videoCaptureMode.hasEventListener(MouseEvent.MOUSE_OUT))
			{
				videoCaptureMode.removeEventListener(MouseEvent.MOUSE_OUT, increaseOpacity);
				trace("DEPLOYMODE:"+deployMode+"isRecording:"+recordingData.isRecording+"recordingData?"+recordingData.hasRecordingData+"PLAYERSTATE"+_playerState);
				if(deployMode=="enhance" && !recordingData.isRecording && !recordingData.hasRecordingData && _playerState=="STOPPED") videoContainer.attachCamera(cam);
				if(_playerState=="PLAYING" || currentlyPlayingTime>200) videoContainer.attachNetStream(presentNS);
				videoCapture.visible= true;
			}
			else {
				videoCaptureMode.addEventListener(MouseEvent.MOUSE_OUT, increaseOpacity);
				if((videoContainer.videoHeight>0)){
					videoContainer.attachNetStream(null); 
				}
				videoCapture.visible= false;
			}
		}
		
		private function myMethod(text:String):void
		{
			imageData = text;
		}
		

		
		private function resizeHandler(event:Event=null):void
		{
			resizing = true;
			this.graphics.clear();
			this.graphics.beginFill(0x000000, 1);
			this.graphics.drawRect(0, 0, _stage.stageWidth, _stage.stageHeight);
			this.graphics.endFill();
			controls.x = (_stage.stageWidth - SLIDER_LENGTH)/2
			controls.y = _stage.stageHeight - 35;
			var sX:Number = (_stage.stageWidth - 20)/(sliderImageActualWidth);
			var sY:Number = (_stage.stageHeight - 70)/(sliderImageActualHeight ) ;
			sliderScaleFactor = sX<sY?sX:sY;
			//PREVIOUS AND NEXT BUTTONS
			previous.x = - controls.x + 20;
			previous.y = -(controls.y - 30)/2;
			next.x = (SLIDER_LENGTH + controls.x)-50;
			next.y =  -(controls.y-30)/2;
			
			trace("slider.height" + slider.height + "sliderScaleFactor" + sliderScaleFactor);
			
			for(var i:Number=0; i<sliderImages.length; i++)
			{
				sliderImages[i].scaleX = sliderScaleFactor;
				sliderImages[i].scaleY = sliderScaleFactor;
			}
			//POSITION IMAGES
			if(sX>sY) 
			{
				sliderImages[0].x=(_stage.stageWidth-20-sliderImages[0].width)/2;
			}
			else 	sliderImages[0].y=(_stage.stageHeight -60-sliderImages[0].height)/2;
			//ShowPopUp(sliderImages[0].x +" ||| "+ _stage.stageWidth );
			for(var i:Number=1; i<sliderImages.length; i++)
			{
				sliderImages[i].scaleX = sliderScaleFactor;
				sliderImages[i].scaleY = sliderScaleFactor;
				if(sX>sY) 
				{
					sliderImages[i].x=sliderImages[0].x;
				}
				else 	sliderImages[i].y=sliderImages[0].y;
			}
			//POSITION VIDEOCONTAINER
			AddVideoWindow();
			strokes.x = sliderImages[0].x;
			strokes.y = sliderImages[0].y;
			AddSliderWindow();
			strokesData.dispose();
			strokesData = new BitmapData(sliderImages[0].width,sliderImages[0].height,true,0);
			strokesBmp = new Bitmap(strokesData);
			strokes.addChild (strokesBmp);
			var counter:Number = 0;
			trace("LENGTH PSS:"+ presentSlideStrokes.length);
			while (counter<presentSlideStrokes.length)
			{
				var currentRecordEvent:RecordEvent = presentSlideStrokes[counter];
				//ShowPopUp(currentRecordEvent.eventTool+"");
				//trace("OUT OF THIS NOT");
				if(currentRecordEvent.eventType == RecordEvent.MOUSE_DOWN)
					RecordMouseDown(currentRecordEvent);
				else if (currentRecordEvent.eventType == RecordEvent.MOUSE_MOVE)
					RecordMouseMove(currentRecordEvent);
				else if (currentRecordEvent.eventType == RecordEvent.MOUSE_UP)
					RecordMouseUp(currentRecordEvent);
				else if(currentRecordEvent.eventType == RecordEvent.SLIDE_NEXT)
				{
					trace("ERROR");
					GotoNextImage(null);
				}
				else if (currentRecordEvent.eventType == RecordEvent.SLIDE_PREV)
				{
					trace("ERROR");
					GotoPreviousImage(null);
				}
				counter++;
				//trace(counter);
			}
			trace("OUT OF THIS");
			//LOADER RESPOSITION
			loadingGif.graphics.clear();
			loadingGif.graphics.beginFill(0x000000, 0.8);
			loadingGif.graphics.drawRect( (stage.stageWidth - 84) / 2, (stage.stageHeight - 84) / 2, 65,65);
			loadingGif.graphics.endFill();			
			loadingGifDO.x = (stage.stageWidth - loadingGifDO.width) / 2;
			loadingGifDO.y = (stage.stageHeight - loadingGifDO.height) / 2;

			resizing = false;
			
		}
		
		
		protected var addqBox:MovieClip = new MovieClip();
		protected var addnBox:MovieClip = new MovieClip();
		protected var nnqBox:MovieClip = new MovieClip();
		protected var myFirstTextBox:TextField = new TextField();   
		protected var descTextBox:TextField = new TextField(); 	
		
		
		//ENRICH FUNCTIONS
		private function fAddENote(myEvent:MouseEvent):void {
			Security.allowDomain("*");
			addqBox.visible=false;	
			nnqBox.visible = false;
			while (addnBox.numChildren > 0) {
				addnBox.removeChildAt(0);
			}
			addnBox.graphics.clear();
			
			if (ExternalInterface.available) 
			{
				//ExternalInterface.call("ff_pause_player");
				addnBox.graphics.beginFill(0x555555);  
				addnBox.graphics.drawRect( 0, 0, 400, 210 );  
				addnBox.graphics.endFill();  
				addnBox.x = (stage.stageWidth-400)/2;
				addnBox.y = (stage.stageHeight-210)/2;
				var t:TextField = new TextField();  
				//t.embedFonts = true;
				t.text = "Enter Your Note";
				
				
				var tf:TextFormat = new TextFormat();
				tf.color = 0xFFFFFF;
				tf.size = 18;
				tf.font = "Calibri";
				tf.align=TextFormatAlign.CENTER;
				
				t.setTextFormat(tf);
				t.x=50;
				t.y=20;
				t.width=300;
				addnBox.addChild(t);  
				
				// Title TextBOX
				var titleText:TextField = new TextField();  
				//t.embedFonts = true;
				titleText.text = "Note Title";
				
				
				var tf2:TextFormat = new TextFormat();
				tf2.color = 0xFFFFFF;
				tf2.size = 13;
				tf2.font = "Calibri";
				tf2.align=TextFormatAlign.LEFT;
				
				titleText.setTextFormat(tf2);
				titleText.x=10;
				titleText.y=70;
				titleText.width=100;
				addnBox.addChild(titleText);  
				
				//Description TextBOX
				
				var descText:TextField = new TextField();  
				//t.embedFonts = true;
				descText.text = "Note Detail";
				descText.setTextFormat(tf2);
				descText.x=10;
				descText.y=100;
				descText.width=100;
				addnBox.addChild(descText);  
				
				myFirstTextBox.type = TextFieldType.INPUT; 
				myFirstTextBox.background = true; 
				addnBox.addChild(myFirstTextBox); 
				myFirstTextBox.x = 120;
				myFirstTextBox.text="Enter the title for the Note";
				myFirstTextBox.y=70;
				myFirstTextBox.width=250;
				myFirstTextBox.height = 20;
				myFirstTextBox.tabEnabled=true;
				myFirstTextBox.tabIndex=1;
				myFirstTextBox.addEventListener(MouseEvent.CLICK, clearText);
				descTextBox.type = TextFieldType.INPUT; 
				descTextBox.background = true; 
				addnBox.addChild(descTextBox); 
				descTextBox.text="Enter a Note";
				descTextBox.x = 120;
				descTextBox.y=100;
				descTextBox.width=250;
				descTextBox.height = 20;
				descTextBox.tabEnabled=true;
				descTextBox.tabIndex=2;
				descTextBox.addEventListener(MouseEvent.CLICK, clearText);
				//myFirstTextBox.addEventListener(TextEvent.TEXT_INPUT, inputEventCapture);
				var button:TextField = new TextField();
				button.htmlText = "<a href='event:null'>Associate Note</a>";
				button.x = 70;
				button.width =130;
				button.y = 145;
				button.height=30;
				button.border = true;
				button.addEventListener(MouseEvent.CLICK, AddENote);
				button.setTextFormat(tf);
				addnBox.addChild(button);
				var button2:TextField = new TextField();
				button2.htmlText = "<a href='event:null'>Cancel</a>";
				button2.x = 220;
				button2.width =70;
				button2.y = 145;
				button2.border = true;
				button2.height=30;
				button2.setTextFormat(tf);
				button2.addEventListener(MouseEvent.CLICK, CancelNote);
				addnBox.addChild(button2);
				
				enrichUI.addChild(addnBox);
				if(addnBox.visible) addnBox.visible=false;
				else addnBox.visible=true;
			}
		}
		
		private function AddENote(myEvent:MouseEvent):void
		{
			//JS UPDATE CALL
			var time:Number = ns.time;
			var inputString:String = myFirstTextBox.text+"||"+descTextBox.text+"||"+time;
			ExternalInterface.call("ff_add_note",inputString );
			addnBox.visible=false;
		}
		
		
		private function CancelNote(myEvent:MouseEvent):void
		{
			addnBox.visible=false;
		}
		
		private function clearText(myEvent:MouseEvent) {
			var tempTF:TextField = myEvent.currentTarget as TextField;
			tempTF.text="";
			tempTF.removeEventListener(MouseEvent.CLICK, clearText);
		}
		
		private function fAddERef(myEvent:MouseEvent):void{
			Security.allowDomain("*");
			addnBox.visible=false;	
			nnqBox.visible=false;
			while (addqBox.numChildren > 0) {
				addqBox.removeChildAt(0);
			}
			addqBox.graphics.clear();
			
			if (ExternalInterface.available) 
			{
				//ExternalInterface.call("ff_pause_player");
				addqBox.graphics.beginFill(0x555555);  
				addqBox.graphics.drawRect( 0, 0, 400, 210 );  
				addqBox.graphics.endFill();  
				addqBox.x = (stage.stageWidth-400)/2;
				addqBox.y = (stage.stageHeight-210)/2;
				var t:TextField = new TextField();  
				//t.embedFonts = true;
				t.text = "Enter Your Reference";
				
				
				var tf:TextFormat = new TextFormat();
				tf.color = 0xFFFFFF;
				tf.size = 18;
				tf.font = "Calibri";
				tf.align=TextFormatAlign.CENTER;
				
				t.setTextFormat(tf);
				t.x=50;
				t.y=20;
				t.width=300;
				addqBox.addChild(t);  
				
				
				
				// Title TextBOX
				var titleText:TextField = new TextField();  
				//t.embedFonts = true;
				titleText.text = "Reference Name";
				
				
				var tf2:TextFormat = new TextFormat();
				tf2.color = 0xFFFFFF;
				tf2.size = 13;
				tf2.font = "Calibri";
				tf2.align=TextFormatAlign.LEFT;
				
				titleText.setTextFormat(tf2);
				titleText.x=10;
				titleText.y=70;
				titleText.width=100;
				addqBox.addChild(titleText);  
				
				//Description TextBOX
				
				var descText:TextField = new TextField();  
				//t.embedFonts = true;
				descText.text = "Http Address";
				descText.setTextFormat(tf2);
				descText.x=10;
				descText.y=100;
				descText.width=100;
				addqBox.addChild(descText);  
				
				myFirstTextBox.type = TextFieldType.INPUT; 
				myFirstTextBox.addEventListener(MouseEvent.CLICK, clearText);
				myFirstTextBox.background = true; 
				myFirstTextBox.tabEnabled=true;
				myFirstTextBox.tabIndex=1;
				addqBox.addChild(myFirstTextBox); 
				myFirstTextBox.text="";
				myFirstTextBox.x = 120;
				myFirstTextBox.y=70;
				myFirstTextBox.width=250;
				myFirstTextBox.height = 20;
				descTextBox.type = TextFieldType.INPUT; 
				descTextBox.background = true; 
				addqBox.addChild(descTextBox); 
				descTextBox.text="http://";
				descTextBox.x = 120;
				descTextBox.y=100;
				descTextBox.tabEnabled=true;
				descTextBox.tabIndex=2;
				descTextBox.width=250;
				descTextBox.height = 20;
				descTextBox.addEventListener(MouseEvent.CLICK, clearText);
				//myFirstTextBox.addEventListener(TextEvent.TEXT_INPUT, inputEventCapture);
				var button:TextField = new TextField();
				button.setTextFormat(tf2);
				button.htmlText = "<a href='event:null'>Associate Reference</a>";
				button.x = 70;
				button.width =160;
				button.y = 145;
				button.height=30;
				button.border = true;
				button.addEventListener(MouseEvent.CLICK, AddERef);
				button.setTextFormat(tf);
				addqBox.addChild(button);
				var button2:TextField = new TextField();
				button2.htmlText = "<a href='event:null'>Cancel</a>";
				button2.x = 250;
				button2.width =70;
				button2.y = 145;
				button2.border = true;
				button2.height=30;
				button2.setTextFormat(tf);
				button2.addEventListener(MouseEvent.CLICK, CancelQ);
				addqBox.addChild(button2);
				
				enrichUI.addChild(addqBox);
				if(addqBox.visible) addqBox.visible=false;
				else addqBox.visible=true;
				
				// } else {
				
				
				
			}
		}
		
		private function AddERef (myEvent:MouseEvent):void
		{
			//JS UPDATE CALL
			var time:Number = ns.time/1000;
			var inputString:String = myFirstTextBox.text+"||"+descTextBox.text+"||"+time;
			ExternalInterface.call("ff_add_reference",inputString );
			addqBox.visible=false;
		}
		private function CancelQ(myEvent:MouseEvent)
		{
			addqBox.visible=false;
		}



	}
}