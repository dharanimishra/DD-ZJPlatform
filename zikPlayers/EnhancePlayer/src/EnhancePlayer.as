package
{
	import flash.display.Bitmap;
	import flash.display.BitmapData;
	import flash.display.Loader;
	import flash.display.MovieClip;
	import flash.display.Shape;
	import flash.display.Sprite;
	import flash.display.Stage;
	import flash.display.StageAlign;
	import flash.display.StageScaleMode;
	import flash.events.Event;
	import flash.events.MouseEvent;
	import flash.external.ExternalInterface;
	import flash.geom.Rectangle;
	import flash.media.Camera;
	import flash.media.Microphone;
	import flash.media.Video;
	import flash.net.URLRequest;
	import flash.system.Security;
	import flash.text.TextField;
	import flash.text.TextFormat;

	
	public class EnhancePlayer extends Sprite
	{
		[Embed(source='../icons/edit.png')]
		public static var HotspotIcon:Class;
		
		[Embed(source='../icons/record.png')]
		public static var RECORD:Class;

		[Embed(source='../icons/play.png')]
		public static var PLAY:Class;
		
		[Embed(source='../icons/stop.png')]
		public static var STOP:Class;
		
		[Embed(source="../icons/previous.png" )]
		public static var PREVIOUS:Class;
		
		[Embed(source='../icons/next.png')]
		public static var NEXT:Class;
		
		[Embed(source='../icons/eraser.png')]
		public static var ERASER:Class;
		
		[Embed(source='../icons/marker.png')]
		public static var MARKER:Class;
		
		[Embed(source='../icons/fullscreen.png')]
		public static var FULLSCREEN:Class;
		
		[Embed(source='../icons/optionEmpty.png')]
		public static var OPTIONEMPTY:Class;
		
		[Embed(source='../icons/optionTicked.png')]
		public static var OPTIONTICKED:Class;
		
		private static var _stage:Stage;

		private static var _playerState:String;
		protected var slider:MovieClip = new MovieClip();
		protected var strokes:MovieClip = new MovieClip();
		protected var videoCapture:MovieClip = new MovieClip();
		protected var controls:MovieClip = new MovieClip();
		
		protected var record:MovieClip = new MovieClip();
		protected var play:MovieClip = new MovieClip();
		protected var stop:MovieClip = new MovieClip();
		protected var previous:MovieClip = new MovieClip();
		protected var next:MovieClip = new MovieClip();
		protected var eraser:MovieClip = new MovieClip();
		protected var marker:MovieClip = new MovieClip();
		protected var fullscreen:MovieClip = new MovieClip();
		protected var videoCaptureMode:MovieClip = new MovieClip();
		
		protected var imageData:String;
		protected var sliderImages:Array = new Array();
		protected var sliderScaleFactor:Number;
		protected var sliderImageActualHeight:Number;
		protected var sliderImageActualWidth:Number;
		
		protected var strokesData:BitmapData;
		protected var strokesBmp:Bitmap;
		protected var strokeShape:Shape = new Shape();
		protected var md:Boolean = false;
		
		protected var toolSelected:String = "NONE";

		
		protected var videoContainer:Video = new Video(160, 120);
		protected var cam:Camera = Camera.getCamera();
		protected var mic:Microphone = Microphone.getMicrophone();
		
		public function EnhancePlayer()
		{
			addEventListener( Event.ADDED_TO_STAGE, DoAfterAddingToStage );
		}
		
		private function _onMouseDown (e:MouseEvent):void {
			if(toolSelected== "NONE") return;
			var c:uint = (!e.ctrlKey?0x000000:0x000000);
			strokeShape.graphics.lineStyle (10, c, 1);
			strokeShape.graphics.moveTo (e.localX,e.localY);
			md = true;
		}
		//
		private function _onMouseUp (e:MouseEvent):void {
			if(toolSelected== "NONE") return;
			md = false;
			if(toolSelected=="MARKER")
				strokesBmp.bitmapData.draw (strokeShape,null,null,(e.ctrlKey?"erase":"normal"));
			else if(toolSelected=="ERASER")
				strokesBmp.bitmapData.draw (strokeShape,null,null,"erase");
			strokeShape.graphics.clear ();
		}
		//
		private function _onMouseMove (e:MouseEvent):void {
			if(toolSelected== "NONE") return;
			if (md) {
				strokeShape.graphics.lineTo (e.localX,e.localY);
				if(e.ctrlKey || toolSelected=="ERASER")
				{
					strokesBmp.bitmapData.draw (strokeShape,null,null,"erase");
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
			trace("ENTERED INIT FUNCTION");
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
			

			
			AddSliderWindow();
			AddControls();
			AddVideoWindow();

			//LoadImages("../testdata/", 15);
			
			ExternalInterface.addCallback("player_set_image_data", myMethod);
			//addChild(tempTF);
		}
		
		private function LoadImages(path:String, numberOfImages:Number):void
		{
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
				if(i == numberOfImages-1) ldr.contentLoaderInfo.addEventListener(Event.COMPLETE, imageCompleteHandler);
				image.addChild(ldr);
				slider.addChild(image);
				sliderImages[i] = image;
			}
		}
		
		private function imageCompleteHandler(e:Event):void {
			var sX:Number = (_stage.stageWidth-20)/(sliderImages[0].width) ;
			var sY:Number = (_stage.stageHeight - 80)/(sliderImages[0].height) ;
			sliderImageActualHeight=sliderImages[0].height;
			sliderImageActualWidth=sliderImages[0].width;
			sliderScaleFactor = sX<sY?sX:sY;
			trace("slider.height" + sliderImages[0].height + "sliderScaleFactor" + (_stage.stageWidth - 80));
			for(var i:Number=0; i<sliderImages.length; i++)
			{
				sliderImages[i].scaleX = sliderScaleFactor;
				sliderImages[i].scaleY = sliderScaleFactor;
				if(sX>sY) 
				{
					sliderImages[i].x=(slider.width-sliderImages[i].width)/2;
				}
				else 	sliderImages[i].y=(slider.height-sliderImages[0].height)/2;
			}
			sliderImages[0].visible = true;
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
			
		}
		private function AddSliderWindow():void
		{
			trace("ADDSLIDERWINDWOS CALLED");
			slider.graphics.clear();
			slider.graphics.beginFill(0x555555, 0.8);
			slider.graphics.drawRoundRectComplex(10, 10, _stage.stageWidth-20, _stage.stageHeight - 70, 5, 5, 5, 5);
			slider.graphics.endFill();
			slider.width = _stage.stageWidth-20;
			slider.height = _stage.stageHeight - 100;
		}
		
		private function AddVideoWindow():void
		{
			videoCapture.graphics.beginFill(0xCCCCCC, 0.8);
			videoCapture.graphics.drawRoundRectComplex( _stage.stageWidth - 180 , 20, 160, 120, 5, 5, 5, 5);
			videoContainer.x = _stage.stageWidth - 180;
			videoContainer.y = 20;
			videoCapture.graphics.endFill();
			videoContainer.attachCamera(cam);
			videoCapture.addEventListener(MouseEvent.MOUSE_DOWN, StartDragging);
			videoCapture.addEventListener(MouseEvent.MOUSE_UP, StopDragging);
			videoCapture.addChild(videoContainer);
		}
		
		private function StartDragging(e:MouseEvent):void {
			trace("Starting Drag");
			var my_x:int=videoCapture.width - _stage.stageWidth + 30;
			var my_y:int= 0 - 10;
			
			//The height and width of the rectangle.
			var myWidth:int= 10-my_x ;
			var myHeight:int=_stage.stageHeight - 100 - videoCapture.height  ;
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
			for(var i:Number=0; i<sliderImages.length-1; i++)
				if(sliderImages[i].visible)
				{
					sliderImages[i].visible = false;
					sliderImages[i+1].visible = true;
					break;
				}
		}
		
		private function GotoPreviousImage(e:MouseEvent):void {
			for(var i:Number=1; i<sliderImages.length; i++)
				if(sliderImages[i].visible)
				{
					sliderImages[i].visible = false;
					sliderImages[i-1].visible = true;
					break;
				}
		}
		
		private function Record(e:MouseEvent):void {
			if(record.hasEventListener(MouseEvent.MOUSE_OUT))
			{
				record.removeEventListener(MouseEvent.MOUSE_OUT, decreaseOpacity );
				_playerState = "RECORDING";
			}
			else 
				record.addEventListener(MouseEvent.MOUSE_OUT, decreaseOpacity);
			
		}
		
		private function Play(e:MouseEvent):void {
			if(play.hasEventListener(MouseEvent.MOUSE_OUT))
				play.removeEventListener(MouseEvent.MOUSE_OUT, decreaseOpacity );
			else 
				play.addEventListener(MouseEvent.MOUSE_OUT, decreaseOpacity);			
		}
		
		private function Stop(e:MouseEvent):void {
			if(stop.hasEventListener(MouseEvent.MOUSE_OUT))
				stop.removeEventListener(MouseEvent.MOUSE_OUT, decreaseOpacity );
			else 
				stop.addEventListener(MouseEvent.MOUSE_OUT, decreaseOpacity);
		}
		
		private function Marker(e:MouseEvent):void {
			if(marker.hasEventListener(MouseEvent.MOUSE_OUT))
			{
				marker.removeEventListener(MouseEvent.MOUSE_OUT, decreaseOpacity );
				if( !eraser.hasEventListener(MouseEvent.MOUSE_OUT))
				{
					eraser.addEventListener(MouseEvent.MOUSE_OUT, decreaseOpacity );
					eraser.alpha = 0.4;
				}
				toolSelected = "MARKER";
			}
			else 
			{
				marker.addEventListener(MouseEvent.MOUSE_OUT, decreaseOpacity);
				toolSelected = "NONE";
			}
		}
		
		private function Eraser(e:MouseEvent):void {
			if(eraser.hasEventListener(MouseEvent.MOUSE_OUT))
			{
				eraser.removeEventListener(MouseEvent.MOUSE_OUT, decreaseOpacity );
				if( !marker.hasEventListener(MouseEvent.MOUSE_OUT))
				{
					marker.addEventListener(MouseEvent.MOUSE_OUT, decreaseOpacity );
					marker.alpha = 0.4;
				}
				toolSelected = "ERASER";
			}
			else 
			{
				eraser.addEventListener(MouseEvent.MOUSE_OUT, decreaseOpacity);
				toolSelected = "NONE";
			}
		}
		
		private function FullScreen(e:MouseEvent):void {
			if(fullscreen.hasEventListener(MouseEvent.MOUSE_OUT))
				fullscreen.removeEventListener(MouseEvent.MOUSE_OUT, decreaseOpacity );
			else 
				fullscreen.addEventListener(MouseEvent.MOUSE_OUT, decreaseOpacity);
		}
		
		private function AddControls():void
		{
			
			//controls.width=400;
			//controls.height=50;
			controls.x = (_stage.stageWidth - 450)/2
			controls.y = _stage.stageHeight - 50;
			var test:Bitmap = new RECORD();
			record.addChild(test);
			record.x = 0;
			record.alpha = 0.4;
			record.addEventListener(MouseEvent.MOUSE_OVER, increaseOpacity); 
			record.addEventListener(MouseEvent.MOUSE_OUT, decreaseOpacity); 
			record.addEventListener(MouseEvent.CLICK, Record);
			
			test = new PLAY();
			play.addChild(test);
			play.x = 50;
			play.alpha = 0.4;
			play.addEventListener(MouseEvent.MOUSE_OVER, increaseOpacity); 
			play.addEventListener(MouseEvent.MOUSE_OUT, decreaseOpacity); 
			play.addEventListener(MouseEvent.CLICK, Play);
			
			test = new STOP();
			stop.addChild(test);
			stop.x = 100;
			stop.alpha = 0.4;
			stop.addEventListener(MouseEvent.MOUSE_OVER, increaseOpacity); 
			stop.addEventListener(MouseEvent.MOUSE_OUT, decreaseOpacity); 
			stop.addEventListener(MouseEvent.CLICK, Stop);
			
			test = new PREVIOUS();
			previous.addChild(test);
			previous.x = 150;
			previous.alpha = 0.4;
			previous.addEventListener(MouseEvent.CLICK, GotoPreviousImage);
			previous.addEventListener(MouseEvent.MOUSE_OVER, increaseOpacity); 
			previous.addEventListener(MouseEvent.MOUSE_OUT, decreaseOpacity); 
			
			test = new NEXT();
			next.addChild(test);
			next.x = 200;
			next.alpha = 0.4;
			next.addEventListener(MouseEvent.CLICK, GotoNextImage);
			next.addEventListener(MouseEvent.MOUSE_OVER, increaseOpacity); 
			next.addEventListener(MouseEvent.MOUSE_OUT, decreaseOpacity); 
			
			test = new MARKER();
			marker.addChild(test);
			marker.x = 250;
			marker.alpha = 0.4;
			marker.addEventListener(MouseEvent.MOUSE_OVER, increaseOpacity); 
			marker.addEventListener(MouseEvent.MOUSE_OUT, decreaseOpacity);
			marker.addEventListener(MouseEvent.CLICK, Marker);
			
			test = new ERASER();
			eraser.addChild(test);
			eraser.x = 300;
			eraser.alpha = 0.4;
			eraser.addEventListener(MouseEvent.MOUSE_OVER, increaseOpacity); 
			eraser.addEventListener(MouseEvent.MOUSE_OUT, decreaseOpacity); 
			eraser.addEventListener(MouseEvent.CLICK, Eraser);
			
			test = new FULLSCREEN();
			fullscreen.addChild(test);
			fullscreen.x = 350;
			fullscreen.alpha = 0.4;
			fullscreen.addEventListener(MouseEvent.MOUSE_OVER, increaseOpacity); 
			fullscreen.addEventListener(MouseEvent.MOUSE_OUT, decreaseOpacity);
			fullscreen.addEventListener(MouseEvent.CLICK, FullScreen);
			
			test = new OPTIONTICKED();
			videoCaptureMode.addChild(test);
			var videoCaptureModeText:TextField = new TextField();
			videoCaptureModeText.defaultTextFormat =  new TextFormat("calibri", 12, 0xffffff);
			videoCaptureModeText.text = "View Webcam";
			videoCaptureModeText.x = 25;
			videoCaptureModeText.y = 10;
			videoCaptureMode.x=410;
			videoCaptureMode.addChild(videoCaptureModeText);
			videoCaptureMode.addEventListener(MouseEvent.CLICK, ChangeOptionMode);
			
			controls.addChild(record);
			controls.addChild(play);
			controls.addChild(stop);
			controls.addChild(previous);
			controls.addChild(next);
			controls.addChild(marker);
			controls.addChild(eraser);
			controls.addChild(fullscreen);
			controls.addChild(videoCaptureMode);
			
			trace(controls.width +"==="+controls.height);
			
		}
		
		private function ChangeOptionMode(e:MouseEvent):void {
			for(var i:Number=0; i<e.currentTarget.numChildren-1; i++)
			{
				if(e.currentTarget.getChildAt(i) is Bitmap)
					if(e.currentTarget.getChildAt(i) is OPTIONEMPTY)
					{
						e.currentTarget.removeChildAt(i);
						var test:Bitmap = new OPTIONTICKED();
						e.currentTarget.addChildAt(test, i);
						videoCapture.visible = true;
					}
					else
					{
						e.currentTarget.removeChildAt(i);
						var test:Bitmap = new OPTIONEMPTY();
						test.y= 8;
						e.currentTarget.addChildAt(test, i);
						videoCapture.visible = false;
					}
				
			}
		}
		
		private function myMethod(text:String):void
		{
			imageData = text;
		}
		

		
		private function resizeHandler(event:Event=null):void
		{
			this.graphics.clear();
			this.graphics.beginFill(0x000000, 1);
			this.graphics.drawRect(0, 0, _stage.stageWidth, _stage.stageHeight);
			this.graphics.endFill();
			controls.x = (_stage.stageWidth - 400)/2
			controls.y = _stage.stageHeight - 50;
			AddSliderWindow();
			var sX:Number = (_stage.stageWidth - 20)/(sliderImageActualWidth);
			var sY:Number = (_stage.stageHeight - 80)/(sliderImageActualHeight ) ;
			sliderScaleFactor = sX<sY?sX:sY;

			trace("slider.height" + slider.height + "sliderScaleFactor" + sliderScaleFactor);
			sliderImages[0].scaleX = sliderScaleFactor;
			sliderImages[0].scaleY = sliderScaleFactor;
		}

	}
}