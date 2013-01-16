package com.longtailvideo.jwplayer.view {
	import com.longtailvideo.jwplayer.events.GlobalEventDispatcher;
	import com.longtailvideo.jwplayer.events.IGlobalEventDispatcher;
	import com.longtailvideo.jwplayer.events.MediaEvent;
	import com.longtailvideo.jwplayer.events.PlayerEvent;
	import com.longtailvideo.jwplayer.events.PlayerStateEvent;
	import com.longtailvideo.jwplayer.events.PlaylistEvent;
	import com.longtailvideo.jwplayer.events.ViewEvent;
	import com.longtailvideo.jwplayer.model.Color;
	import com.longtailvideo.jwplayer.model.Model;
	import com.longtailvideo.jwplayer.player.IPlayer;
	import com.longtailvideo.jwplayer.player.PlayerState;
	import com.longtailvideo.jwplayer.player.PlayerV4Emulation;
	import com.longtailvideo.jwplayer.player.PlayerVersion;
	import com.longtailvideo.jwplayer.plugins.IPlugin;
	import com.longtailvideo.jwplayer.plugins.PluginConfig;
	import com.longtailvideo.jwplayer.utils.Animations;
	import com.longtailvideo.jwplayer.utils.Draw;
	import com.longtailvideo.jwplayer.utils.Logger;
	import com.longtailvideo.jwplayer.utils.RootReference;
	import com.longtailvideo.jwplayer.utils.Stretcher;
	import com.longtailvideo.jwplayer.view.interfaces.IPlayerComponent;
	import com.longtailvideo.jwplayer.view.interfaces.ISkin;
	import com.longtailvideo.jwplayer.view.Scrollbar;
	
	import flash.display.Bitmap;
	import flash.display.DisplayObject;
	import flash.display.DisplayObjectContainer;
	import flash.display.Loader;
	import flash.display.MovieClip;
	import flash.display.Sprite;
	import flash.display.Stage;
	import flash.display.StageAlign;
	import flash.display.StageDisplayState;
	import flash.display.StageScaleMode;
	import flash.events.ErrorEvent;
	import flash.events.Event;
	import flash.events.FocusEvent;
	import flash.utils.getTimer;
	import flash.events.IOErrorEvent;
	import flash.events.MouseEvent;
	import flash.events.TimerEvent;
	import flash.external.ExternalInterface;
	import flash.geom.Rectangle;
	import flash.net.URLRequest;
	import flash.system.LoaderContext;
	import flash.text.TextField;
	import flash.text.TextFormat;
	import flash.ui.Keyboard;
	import flash.utils.Timer;
	import spark.components.Button;
	import flash.external.ExternalInterface;    
	import flash.system.Security;	
	import flash.text.*;
  import flash.events.*;
  import spark.components.Button;

	public class View extends GlobalEventDispatcher {
		protected var _player:IPlayer;
		protected var _model:Model;
		protected var _skin:ISkin;
		protected var _components:IPlayerComponents;
		protected var _fullscreen:Boolean = false;
		protected var editNQMode:Number = -1;
		protected var TBSUpdateEnabled = false;
		protected var _preserveAspect:Boolean = false;
		protected var _normalScreen:Rectangle;
		protected var stage:Stage;
		protected var _root:MovieClip;

		protected var _maskedLayers:MovieClip;
		protected var _backgroundLayer:MovieClip;
		protected var _mediaLayer:MovieClip;
		protected var _mediaFade:Animations;
		protected var _imageLayer:MovieClip;
		protected var _imageFade:Animations;
		
		protected var _componentsLayer:MovieClip;
		protected var _pluginsLayer:MovieClip;
		protected var _plugins:Object;
		protected var _instreamLayer:MovieClip;
		protected var _instreamPlugin:IPlugin;
		protected var _instreamAnim:Animations;
		protected var _zikFullScreenUI:MovieClip;
		protected var _zikEnrichUI:MovieClip;
		
		protected var _displayMasker:MovieClip;
		public var NotesData:String;
		protected var _image:Loader;
		protected var _logo:Logo;
		
		protected var deployMode:String = "CONSUME";

		protected var layoutManager:PlayerLayoutManager;

		[Embed(source="../../../../../assets/flash/loader/loader.swf")]
		protected var LoadingScreen:Class;
		
		[Embed(source='../../../../../assets/addq.png')]
		public static var AddQ:Class;
		
		[Embed(source='../../../../../assets/notes.png')]
		public static var Notes:Class;
		
		[Embed(source='../../../../../assets/addn.png')]
		public static var AddN:Class;
		
		[Embed(source='../../../../../assets/toc.png')]
		public static var TOC:Class;
		
		[Embed(source='../../../../../assets/viewq.png')]
		public static var ViewQ:Class;
		
		[Embed(source='../../../../../assets/leftmenu.png')]
		public static var LeftMenu:Class;
		
		[Embed(source='../../../../../assets/nnqbox.png')]
		public static var NNQBox:Class;
		
		[Embed(source='../../../../../assets/tocbox.png')]
		public static var TOCBox:Class;
		
		[Embed(source='../../../../../assets/addquestionbox.png')]
		public static var AQBox:Class;
		
		[Embed(source='../../../../../assets/addnotebox.png')]
		public static var ANBox:Class;
		
		[Embed(source='../../../../../assets/editnq.png')]
		public static var EditNQ:Class;
		
		[Embed(source='../../../../../assets/deletenq.png')]
		public static var DeleteNQ:Class;
		
		[Embed(source='../../../../../assets/prof.png')]
		public static var Professor:Class;
		[Embed(source='../../../../../assets/reference.png')]
		public static var Reference:Class;
		[Embed(source='../../../../../assets/class.png')]
		public static var ClassNotes:Class;
		[Embed(source='../../../../../assets/books.png')]
		public static var Books:Class;
		
		[Embed(source='../../../../../assets/hotspot.png')]
		public static var HotspotIcon:Class;
		
		[Embed(source='../../../../../assets/hsdisplay.png')]
		public static var HSDisplay:Class;
		
		[Embed(source="../../../../../assets/flash/loader/error.swf")]
		protected var ErrorScreen:Class;
		
		[Embed(source='../../../../../assets/enote.png')]
		public static var ENOTEICON:Class;
		
		[Embed(source='../../../../../assets/etoc.png')]
		public static var ETOCICON:Class;
		
		[Embed(source='../../../../../assets/eref.png')]
		public static var EREFICON:Class;

		protected var loaderScreen:Sprite;
		protected var loaderAnim:DisplayObject;
		protected var currentLayer:Number = 0;
		
		// Keep track of the first tabIndex
		protected var firstIndex:Number = -1;
		// Keep track of the last seen tabIndex
		protected var lastIndex:Number = -1;

		// Delay between IDLE state and when the preview image is shown
		private var imageDelay:Timer = new Timer(100, 1);

		// Delay between non-IDLE state and when the media layer is shown
		private var mediaDelay:Timer = new Timer(100, 1);

		// Keep track of the last thumbnail image
		private var _lastImage:String;
		
		protected var addHotspotBox:MovieClip = new MovieClip();
		protected var addQuestion:MovieClip = new MovieClip();
		protected var addNotes:MovieClip = new MovieClip();
		protected var viewNotes:MovieClip = new MovieClip();
		protected var toc:MovieClip = new MovieClip();
		protected var leftMenu:MovieClip = new MovieClip();
		protected var addqBox:MovieClip = new MovieClip();
		protected var addnBox:MovieClip = new MovieClip();
		protected var nnqBox:MovieClip = new MovieClip();
		protected var qnqBox:MovieClip = new MovieClip();
		protected var tocBox:MovieClip = new MovieClip();
		protected var viewQuestion:MovieClip = new MovieClip();
		protected var classNotes:MovieClip = new MovieClip();
		protected var reference:MovieClip = new MovieClip();
		protected var professor:MovieClip = new MovieClip();
		protected var books:MovieClip = new MovieClip();
		protected var classNotesBox:MovieClip = new MovieClip();
		protected var referenceBox:MovieClip = new MovieClip();
		protected var professorBox:MovieClip = new MovieClip();
		protected var booksBox:MovieClip = new MovieClip();
		protected var hotspotIcon:MovieClip = new MovieClip();
		protected var hotspotDisplay:MovieClip = new MovieClip();
		protected var hotspotDetailsBox:MovieClip = new MovieClip();
		protected var eNoteIcon:MovieClip = new MovieClip();
		protected var eTocIcon:MovieClip = new MovieClip();
		protected var eRefIcon = new MovieClip();
		var myFirstTextBox:TextField = new TextField();   
		var hotspotTitle:TextField = new TextField();

		var descTextBox:TextField = new TextField(); 		
		private var OutputBox:TextField = new TextField(); 
		protected var QID:Array = new Array();
		protected var NID:Array = new Array();
		protected var Questions:Array = new Array();
		protected var QuestionsTBS:Array = new Array();
		protected var NotesTitle:Array = new Array();
		protected var NotesTitleTBS:Array = new Array();
		protected var QTime:Array = new Array();
		protected var NotesTime:Array = new Array();
		protected var NotesDesc:Array = new Array();
		protected var References:Array = new Array();
		protected var ReferencesTBS:Array = new Array();
		protected var RefLinks:Array = new Array();
		protected var RefTime:Array = new Array();
		protected var tocContent:Array = new Array();
		protected var tocTime:Array = new Array();
		protected var hotspotX:Array = new Array();
		protected var hotspotY:Array = new Array();
		protected var hotspotTitles:Array = new Array();
		protected var hotspotTime:Array = new Array();
		protected var hotspotDuration:Array = new Array();
		protected var hotspotMovieC:Array = new Array();
		protected var NoteData:String;
		protected var QuestionData:String;
		protected var EduRefData:String;
		protected var EduNoteData:String;
		protected var TOCData:String;
		protected var selectedTOC:String ="None";
		
		
		var myTimer:Timer = new Timer(1000);
			function findInArray(array:Array, str:String):int {
				for(var i:int = 0; i < array.length; i++){
					if(array[i] == str){
						trace("found it at index: " + i);
						return i;
					}
				}
				return -1; //If not found
			}
		
		public function View(player:IPlayer, model:Model) {
			_player = player;
			_model = model;
			//References[0] = "Aggregating Preferences in Multi-Issue Domains";
			//References[1] = "Preference Ordering";
			//References[2] = "Critical Concept";
			
			//RefLinks[0] = "http://citeseerx.ist.psu.edu/viewdoc/summary?doi=10.1.1.151.9419";
			//RefLinks[1] = "http://faculty.arts.ubc.ca/pbartha/p321f01/p321ovh2.pdf";
			//RefLinks[2] = "note:Make sure you understand this concept before proceeding. Please make use of the references provided or contact me to seek any clarifications.";
			
			//tocContent[0]= "Preference Ordering";
			//tocContent[1] = "Transitive Preferences";
			//tocContent[2]= "Collective Preferences";
			
			hotspotX[0] = "40";
			hotspotY[0] = "50";
			
			hotspotX[1] = "30";
			hotspotY[1] = "30";
		
			hotspotTitles[0] = "Test 1";
			hotspotTitles[1] = "Test 2";
		
			hotspotTime[0] = "5";hotspotTime[1] = "15";
			hotspotDuration[0] = 5;
			hotspotDuration[1]=10;
			//protected var hotspotDuration:Array = new Array();
			//tocTime[0] = "75";tocTime[1] = "248";tocTime[2] = "310";
			RootReference.stage.scaleMode = StageScaleMode.NO_SCALE;
			RootReference.stage.stage.align = StageAlign.TOP_LEFT;


			loaderScreen = new Sprite();
			loaderScreen.name = 'loaderScreen';
			loaderAnim = new LoadingScreen() as DisplayObject;
            loaderAnim.alpha = 0.8;
            loaderAnim.visible = false;
			loaderScreen.addChild(loaderAnim); 
	
			RootReference.stage.addChildAt(loaderScreen, 0);

			if (RootReference.stage.stageWidth > 0) {
				resizeStage();
			} else {
				RootReference.stage.addEventListener(Event.RESIZE, resizeStage);
				RootReference.stage.addEventListener(Event.ADDED_TO_STAGE, resizeStage);
			}

			_root = new MovieClip();
			_normalScreen = new Rectangle();
		}

		
		function timerListener (e:TimerEvent):void{
		//ExternalInterface.call("ff_display_console_message", "Timer is Triggered");
		var counter:Number = 0;
		var counterTBS:Number = 0;
		var time:String = ExternalInterface.call("ff_get_position") as String;
		while(counterTBS<=NotesTitle.length-1 && TBSUpdateEnabled)
		{
			if(new Number(NotesTime[counterTBS]) < new Number(time) && findInArray(NotesTitleTBS, ""+counterTBS)==-1)
			{
				NotesTitleTBS[NotesTitleTBS.length] = ""+counterTBS;
				
				var i:Number, j:Number;
				var t:String;

				  
				//ExternalInterface.call("ff_display_console_message", "Added Note"+NotesTitle[counterTBS] + NotesTitleTBS.length);
				if(nnqBox.visible==true)
				{
								  for(i = 0; i < NotesTitleTBS.length; i++){
				  for(j = 1; j < (NotesTitleTBS.length-i); j++){
				  if(new Number(NotesTime[new Number(NotesTitleTBS[j-1])]) > new Number(NotesTime[new Number(NotesTitleTBS[j])])){
				  t = NotesTitleTBS[j-1];
				  NotesTitleTBS[j-1]=NotesTitleTBS[j];
				  NotesTitleTBS[j]=t;
				  }
				  }
				  }
					updateNNQ();
				}
			}
			//ExternalInterface.call("ff_display_console_message", "CHECK");
			counterTBS++;
		}
		counterTBS=0;

		while(counterTBS<=Questions.length-1 && TBSUpdateEnabled)
		{
			if(new Number(QTime[counterTBS]) < new Number(time) && findInArray(QuestionsTBS, ""+counterTBS)==-1)
			{
				QuestionsTBS[QuestionsTBS.length] = ""+counterTBS;
				if(qnqBox.visible==true)
				updateQNQ();
			}
			counterTBS++;
		}
		counterTBS=0;
		while(counterTBS<=References.length-1 && TBSUpdateEnabled)
		{
			if(new Number(RefTime[counterTBS]) < new Number(time) && findInArray(ReferencesTBS, ""+counterTBS)==-1)
			{
				ReferencesTBS[ReferencesTBS.length] = ""+counterTBS;
				if(professorBox.visible==true)
				updateRef();
			}
			counterTBS++;
		}

		
		
		while(counter<hotspotDuration.length && _fullscreen)
			{	
				
				var timeN:Number = new Number(time);
				var hotspotTimeN:Number = new Number(hotspotTime[counter]);
				var hotspotDurationN:Number = new Number(hotspotDuration[counter]);
				//ExternalInterface.call("ff_display_console_message", hotspotTimeN +"--"+ hotspotDuration[counter] +"--"+ timeN +"--"+hotspotDurationN);
				if(hotspotTimeN<=timeN && (hotspotDuration[counter]=="999" || timeN<hotspotTimeN+hotspotDurationN))
				{
					//ExternalInterface.call("ff_display_console_message", hotspotX[counter] +"--"+ hotspotY[counter] +"--"+ timeN +"--"+hotspotDurationN);
					if(hotspotDuration[counter]=="999")
					hotspotMovieC[counter].addEventListener(MouseEvent.CLICK, setHSDuration);
							hotspotMovieC[counter].x = (hotspotX[counter] *RootReference.stage.stageWidth)/100;
							hotspotMovieC[counter].y = (hotspotY[counter] *RootReference.stage.stageHeight)/100;
							hotspotMovieC[counter].addEventListener(MouseEvent.MOUSE_OVER, over); 
							hotspotMovieC[counter].addEventListener(MouseEvent.MOUSE_OUT, out); 
				
					hotspotMovieC[counter].visible = true;
				}
				else if (hotspotMovieC[counter]) hotspotMovieC[counter].visible=false;
				counter++;
			}
		}
		
		var rectClip:Sprite = new Sprite();
		var rectClipNotes:Sprite = new Sprite();
		function out(myEvent:MouseEvent):void
		{
			rectClip.visible=false;
		}
		function over(myEvent:MouseEvent):void {

	rectClip = new Sprite();
		var rect:Sprite = new Sprite;
		rect.graphics.clear;
		rect.graphics.beginFill(0x000000, 1);
		rect.graphics.drawRect(0, 0, 100, 100);
		rect.graphics.endFill();
		//ExternalInterface.call("ff_display_console_message", "OVER CALLED");
		var tf:TextField = new TextField();
		tf.autoSize = "left";
		tf.textColor = 0xFFFFFF;
		var temp:MovieClip = null;
		 var tempTF:TextField = null;
			if(myEvent.currentTarget is MovieClip) temp = myEvent.currentTarget as MovieClip;
			if(myEvent.currentTarget is TextField) tempTF= myEvent.currentTarget as TextField;
			var counter:Number = 0;
			if(temp!=null)
				while(counter<hotspotDuration.length )
				{	
				
					if(hotspotMovieC[counter].x == temp.x)
					{
					//ExternalInterface.call("ff_display_console_message", "OVER CALLED");
					tf.text = hotspotTitles[counter];
					//_zikEnrichUI.addChild(rectClip);
					_zikFullScreenUI.addChild(rectClip);

					}
									counter++;
				}
			counter = 0;
			if(tempTF!=null)
			{
				while(counter<=NotesTitle.length-1)
				{
					if(tempTF.htmlText.indexOf(NotesTitle[counter])!=-1)
						
						{
						tf.text = NotesDesc[counter];
						
						}
								
						_zikFullScreenUI.addChild(rectClip);
						counter++;
				}
				counter=0;
				while(counter<=References.length-1)
				{
					if(tempTF.htmlText.indexOf(References[counter])!=-1)
						
						{
						//ExternalInterface.call("ff_play_position",NotesTime[counter]);
						
						var delim:Number = RefLinks[counter].indexOf(":");
						//ExternalInterface.call("ff_display_console_message", "REFLINK"+ RefLinks[counter].substr(delim));
						tf.text = RefLinks[counter].substr(delim);
						
						}
								
						_zikFullScreenUI.addChild(rectClip);
						counter++;
				}
			}
			rectClip.x = myEvent.stageX;
		rectClip.y = myEvent.stageY;
		if(temp!=null && deployMode == "ENRICH")
		{
							
					if(temp.x == hotspotIcon.x)
					{
					tf.text = "Add Hotspot";
					rectClip.x = hotspotIcon.x-50;
				rectClip.y = hotspotIcon.y +45;
					}
					else if(temp.x == eTocIcon.x)
					{
					tf.text = "Add TOC Item";
								rectClip.x = eTocIcon.x-12;
				rectClip.y = eTocIcon.y +45;
					}
					else if(temp.x == eRefIcon.x)
					{
					tf.text = "Add Reference";
								rectClip.x = eRefIcon.x-12;
				rectClip.y = eRefIcon.y +45;
					}
					else if(temp.x == eNoteIcon.x)
					{
					tf.text = "Add Note";
					rectClip.x = eNoteIcon.x-12;
					rectClip.y = eNoteIcon.y +45;
					}
					_zikEnrichUI.addChild(rectClip);
		}
		if(temp!=null && deployMode == "CONSUME")
		{
			if(temp.x == professor.x && temp.y == professor.y )
			{
				tf.text = "Educator Suggested References";
				rectClip.x = professor.x+50;
				rectClip.y = professor.y +25;
			}
			else if(temp.x == classNotes.x && temp.y == classNotes.y)
			{
				tf.text = "Class Notes";
				rectClip.x = classNotes.x+50;
				rectClip.y = classNotes.y +25;
			}
			else if(temp.x == reference.x && temp.y == reference.y)
			{
				tf.text = "Other References";
				rectClip.x = reference.x+50;
				rectClip.y = reference.y +25;
			}
			else if(temp.x == books.x && temp.y == books.y)
			{
				tf.text = "Books";
				rectClip.x = books.x+50;
				rectClip.y = books.y +25;
			}
			else if(temp.x == viewNotes.x)
			{
				tf.text = "View Notes";
				rectClip.x = viewNotes.x-50;
				rectClip.y = viewNotes.y +50;
			}
			else if(temp.x == viewQuestion.x)
			{
				tf.text = "View Questions";
				rectClip.x = viewQuestion.x-70;
				rectClip.y = viewQuestion.y +50;
			}
			else if(temp.x == addNotes.x)
			{
				tf.text = "Add a Note";
				rectClip.x = addNotes.x-50;
				rectClip.y = addNotes.y +50;
			}
			else if(temp.x == addQuestion.x)
			{
				tf.text = "Add a Question";
				rectClip.x = addQuestion.x-50;
				rectClip.y = addQuestion.y +50;
			}
			else if(temp.x == toc.x)
			{
				tf.text = "Table of Contents";
				rectClip.x = toc.x-50;
				rectClip.y = toc.y +50;
			}
			_zikFullScreenUI.addChild(rectClip);
		}
		
		rectClip.visible=true;
		

		rectClip.addChild(rect);
		rectClip.addChild(tf);
//ExternalInterface.call("ff_display_console_message", "Came here");
		rect.width = tf.textWidth + 12;
		rect.height = tf.textHeight + 12;
		tf.x = Math.round(rect.width/2 - tf.width/2);
		tf.y = Math.round(rect.height/2 - tf.height/2);
		}
		function setHSDuration(myEvent:MouseEvent):void{
			var temp:MovieClip = myEvent.currentTarget as MovieClip;
			var counter:Number = 0;
					while(counter<hotspotDuration.length)
			{	
				if(hotspotMovieC[counter].x == temp.x)
				{
					var time:String = ExternalInterface.call("ff_get_position") as String;
					var timeN:Number = new Number(time);
					hotspotDuration[counter] = timeN - new Number(hotspotTime[counter]) ;
					hotspotMovieC[counter].removeEventListener(MouseEvent.CLICK, setHSDuration);
					
				}
					counter++;
			}
		}
		
		protected function resizeStage(evt:Event=null):void {
			try {
				RootReference.stage.removeEventListener(Event.RESIZE, resizeStage);
				RootReference.stage.removeEventListener(Event.ADDED_TO_STAGE, resizeStage);
			} catch(err:Error) {
				Logger.log("Can't add stage resize handlers: " + err.message);
			}

			loaderScreen.graphics.clear();
			loaderScreen.graphics.beginFill(0, 0);
			loaderScreen.graphics.drawRect(0, 0, RootReference.stage.stageWidth, RootReference.stage.stageHeight);
			loaderScreen.graphics.endFill();
			loaderAnim.x = (RootReference.stage.stageWidth - loaderAnim.width) / 2;
			loaderAnim.y = (RootReference.stage.stageHeight - loaderAnim.height) / 2;
		}


		public function get skin():ISkin {
			return _skin;
		}


		public function set skin(skn:ISkin):void {
			_skin = skn;
		}


		public function setupView():void {
			RootReference.stage.addChildAt(_root, 0);
			_root.visible = false;

			setupLayers();
			setupComponents();

			RootReference.stage.addEventListener(Event.RESIZE, resizeHandler);
			RootReference.stage.addEventListener(FocusEvent.FOCUS_OUT, keyFocusOutHandler);
			RootReference.stage.addEventListener(FocusEvent.FOCUS_IN, keyFocusInHandler);
//			RootReference.stage.addEventListener(FocusEvent.KEY_FOCUS_CHANGE, keyFocusChanged);
			
			

			_model.addEventListener(MediaEvent.JWPLAYER_MEDIA_LOADED, mediaLoaded);
			_model.playlist.addEventListener(PlaylistEvent.JWPLAYER_PLAYLIST_ITEM, itemHandler);
			_model.playlist.addEventListener(PlaylistEvent.JWPLAYER_PLAYLIST_UPDATED, itemHandler);
			_model.addEventListener(PlayerStateEvent.JWPLAYER_PLAYER_STATE, stateHandler);

			layoutManager = new PlayerLayoutManager(_player);
			setupRightClick();

			stateHandler();

			redraw();
		}
		
		protected function keyFocusOutHandler(evt:FocusEvent):void {
			var button:Sprite = evt.target as Sprite;
			if (!button) { return; }

			if (evt.shiftKey && firstIndex >= 0 && button.tabIndex == firstIndex) {
				// User is tabbing backwards, and the button we're tabbing out of was the first tab index
				blurPlayer(evt);
			}
			lastIndex = button.tabIndex;
		}

		/** 
		 * Handles the loss of a button's focus.  
		 * The player attempts to blur Flash's focus on the page after the last tabbable 
		 * element so that keyboard users don't get stuck with their focus insideo of the player.   
		 **/
		protected function keyFocusInHandler(evt:FocusEvent):void {
			var button:Sprite = evt.target as Sprite;
			if (!button) { return; }

			if (!evt.shiftKey && firstIndex >= 0 && button.tabIndex == firstIndex && lastIndex > firstIndex) {
				// Tabbing forward and we've wrapped around to the first button.
				blurPlayer(evt);
			} else if (firstIndex < 0 || button.tabIndex < firstIndex) {
				firstIndex = button.tabIndex;
			}
		}
		
		/**
		 * Attempts to force the browser to blur the focus of the Flash player
		 **/
		protected function blurPlayer(evt:FocusEvent):void {
			// Prevent focus from wrapping to the first button
			evt.preventDefault();
			// Nothing should be focused now
			RootReference.stage.focus = null;
			// Try to blur the Flash object in the browser
			if (ExternalInterface.available) {
				ExternalInterface.call("(function() { try { document.getElementById('"+PlayerVersion.id+"').blur(); } catch(e) {} })"); 
			}
			lastIndex = firstIndex;
		}
		
		
		protected function setupRightClick():void {
			var menu:RightclickMenu = new RightclickMenu(_player, _root);
			menu.addGlobalListener(forward);
		}

		public function completeView(isError:Boolean=false, errorMsg:String=""):void {
			if (!isError) {
				_root.visible = true;
				loaderScreen.parent.removeChild(loaderScreen);
			} else {
				loaderScreen.removeChild(loaderAnim);
				var errorScreen:DisplayObject = new ErrorScreen() as DisplayObject;
				var errorMessage:TextField = new TextField();
				errorMessage.defaultTextFormat = new TextFormat("_sans", 12, 0xffffff);
				errorMessage.text = errorMsg;
				errorMessage.width = loaderScreen.width - 60;
				errorMessage.wordWrap = true;
				errorMessage.height = errorMessage.textHeight + 10;

				errorScreen.x = (loaderScreen.width - errorScreen.width) / 2;
				errorScreen.y = (loaderScreen.height - errorScreen.height - errorMessage.height - 10) / 2;
				errorMessage.x = (loaderScreen.width - errorMessage.width) / 2;
				errorMessage.y = errorScreen.y + errorScreen.height + 10;
				loaderScreen.addChild(errorScreen);
				loaderScreen.addChild(errorMessage);
			}
		}

var secondaryTF:TextFormat = new TextFormat();
		protected function setupLayers():void {
			_maskedLayers = setupLayer("masked", currentLayer++);
			
			_backgroundLayer = setupLayer("background", 0, _maskedLayers);
			setupBackground();
			myTimer.addEventListener(TimerEvent.TIMER, timerListener);
			myTimer.start();
								
					secondaryTF.color = 0xFFFFFF;
					secondaryTF.size = 14;
					secondaryTF.font = "Calibri";
					secondaryTF.align=TextFormatAlign.LEFT;
			_mediaLayer = setupLayer("media", 1, _maskedLayers);
			_mediaLayer.alpha = 0;
			_mediaFade = new Animations(_mediaLayer);

			_imageLayer = setupLayer("image", 1, _maskedLayers);
			_image = new Loader();
			_image.contentLoaderInfo.addEventListener(Event.COMPLETE, imageComplete);
			_image.contentLoaderInfo.addEventListener(IOErrorEvent.IO_ERROR, imageError);
			_imageLayer.addChild(_image);
			_imageLayer.alpha = 0;
			_imageFade = new Animations(_imageLayer);

			imageDelay.addEventListener(TimerEvent.TIMER_COMPLETE, showImage);
			mediaDelay.addEventListener(TimerEvent.TIMER_COMPLETE, showMedia);
			
			setupLogo();

			_componentsLayer = setupLayer("components", currentLayer++);
			
			_pluginsLayer = setupLayer("plugins", currentLayer++);
			_plugins = {};
			
			_instreamLayer = setupLayer("instream", currentLayer++);
			_instreamLayer.alpha = 0;
			_instreamLayer.visible = false;
			_instreamAnim = new Animations(_instreamLayer);
			_instreamAnim.addEventListener(Event.COMPLETE, instreamAnimationComplete);

			_zikFullScreenUI = setupLayer("zikFullScreenUI", currentLayer++);

			_zikFullScreenUI.alpha = 0.80;
			
			if(deployMode == "ENRICH") {
			_zikEnrichUI  = setupLayer("zikEnrichUI", currentLayer++);
			_zikEnrichUI.visible = true;
			hotspotIcon.buttonMode = true;
			hotspotIcon.useHandCursor = true;
			hotspotIcon.y=10;
			hotspotIcon.x= RootReference.stage.stageWidth - 50;
			var test:Bitmap = new HotspotIcon();
			hotspotIcon.addChild(test);
			hotspotIcon.addEventListener(MouseEvent.MOUSE_OVER, over); 
			hotspotIcon.addEventListener(MouseEvent.MOUSE_OUT, out); 
			
			
			eTocIcon.y=10;
			eTocIcon.x= RootReference.stage.stageWidth - 100;
			eTocIcon.buttonMode = true;
			eTocIcon.useHandCursor = true;
			var test:Bitmap = new ETOCICON();
			eTocIcon.addChild(test);
			eTocIcon.addEventListener(MouseEvent.MOUSE_OVER, over); 
			eTocIcon.addEventListener(MouseEvent.MOUSE_OUT, out); 
				
			
			eNoteIcon.y=10;
			eNoteIcon.x= RootReference.stage.stageWidth - 200;
			eNoteIcon.buttonMode = true;
			eNoteIcon.useHandCursor = true;
			var test:Bitmap = new ENOTEICON();
			eNoteIcon.addChild(test);
			eNoteIcon.addEventListener(MouseEvent.MOUSE_OVER, over); 
			eNoteIcon.addEventListener(MouseEvent.MOUSE_OUT, out); 
			
			eRefIcon.y=10;
			eRefIcon.x= RootReference.stage.stageWidth - 150;
			eRefIcon.buttonMode = true;
			eRefIcon.useHandCursor = true;
			eRefIcon.addEventListener(MouseEvent.MOUSE_OVER, over); 
			eRefIcon.addEventListener(MouseEvent.MOUSE_OUT, out); 
			
			var test:Bitmap = new EREFICON();
			eRefIcon.addChild(test);
			
			eNoteIcon.addEventListener(MouseEvent.CLICK, fAddENote);
			eRefIcon.addEventListener(MouseEvent.CLICK, fAddERef);
			eTocIcon.addEventListener(MouseEvent.CLICK, fAddEToc);
			
			_zikEnrichUI.addChild(hotspotIcon);
			_zikEnrichUI.addChild(eTocIcon);
			_zikEnrichUI.addChild(eNoteIcon);
			_zikEnrichUI.addChild(eRefIcon);
			_zikEnrichUI.alpha =0.8;
			_zikEnrichUI.addChild(addHotspotBox);
			addHotspotBox.visible=false;
			hotspotIcon.addEventListener(MouseEvent.CLICK, fAddHotspot);
			
			
			}
			addQuestion.addEventListener(MouseEvent.CLICK, fAddQuestions);
			
			// if you want a hand cursor
			addQuestion.buttonMode = true;
			addQuestion.useHandCursor = true;
			addQuestion.y=10;
			var test:Bitmap = new AddQ();
			addQuestion.addChild(test);
			addQuestion.addEventListener(MouseEvent.MOUSE_OVER, over); 
			addQuestion.addEventListener(MouseEvent.MOUSE_OUT, out); 

			addNotes.buttonMode = true;
			addNotes.useHandCursor = true;
			addNotes.y=10;
			var test:Bitmap = new AddN();
			addNotes.addChild(test);
			addNotes.addEventListener(MouseEvent.MOUSE_OVER, over); 
			addNotes.addEventListener(MouseEvent.MOUSE_OUT, out); 
			
			viewNotes.buttonMode = true;
			viewNotes.useHandCursor = true;
			viewNotes.y=10;
			var test:Bitmap = new Notes();
			viewNotes.addChild(test);
			viewNotes.addEventListener(MouseEvent.MOUSE_OVER, over); 
			viewNotes.addEventListener(MouseEvent.MOUSE_OUT, out); 
			
			toc.buttonMode = true;
			toc.useHandCursor = true;
			toc.y=10;
			var test:Bitmap = new TOC();
			toc.addChild(test);
			toc.addEventListener(MouseEvent.MOUSE_OVER, over); 
			toc.addEventListener(MouseEvent.MOUSE_OUT, out); 
			
			viewQuestion.buttonMode = true;
			viewQuestion.useHandCursor = true;
			viewQuestion.y=10;
			var test:Bitmap = new ViewQ();
			viewQuestion.addChild(test);
			viewQuestion.addEventListener(MouseEvent.MOUSE_OVER, over); 
			viewQuestion.addEventListener(MouseEvent.MOUSE_OUT, out); 
			
			leftMenu.useHandCursor = true;
			leftMenu.y=10;
			leftMenu.x=10;
			var test:Bitmap = new LeftMenu();
			leftMenu.addChild(test);
			
			professor.buttonMode = true;
			professor.useHandCursor = true;
			professor.x=25;
			professor.y=21;
			var test:Bitmap = new Professor();
			professor.addChild(test);
			professor.addEventListener(MouseEvent.MOUSE_OVER, over); 
			professor.addEventListener(MouseEvent.MOUSE_OUT, out); 

			classNotes.buttonMode = true;
			classNotes.useHandCursor = true;
			classNotes.x=25;
			classNotes.y=240;
			var test:Bitmap = new ClassNotes();
			classNotes.addChild(test);
			classNotes.addEventListener(MouseEvent.MOUSE_OVER, over); 
			classNotes.addEventListener(MouseEvent.MOUSE_OUT, out); 
			
			reference.buttonMode = true;
			reference.useHandCursor = true;
			reference.x=25;
			reference.y=95
			var test:Bitmap = new Reference();
			reference.addChild(test);
			reference.addEventListener(MouseEvent.MOUSE_OVER, over); 
			reference.addEventListener(MouseEvent.MOUSE_OUT, out); 
			
			books.buttonMode = true;
			books.useHandCursor = true;
			books.x=25;
			books.y=165;
			var test:Bitmap = new Books();
			books.addChild(test);
			books.addEventListener(MouseEvent.MOUSE_OVER, over); 
			books.addEventListener(MouseEvent.MOUSE_OUT, out); 
			
			leftMenu.addChild(professor);
			leftMenu.addChild(reference);
			leftMenu.addChild(classNotes);
			leftMenu.addChild(books);
			leftMenu.addChild(professor);

			//var test:Bitmap = new TOCBox();
			//tocBox.addChild(test);
			tocBox.visible=false;
			
			//var test:Bitmap = new NNQBox();
			//.addChild(test);	
			nnqBox.visible=false;			
			
			qnqBox.visible=false;

			//var test:Bitmap = new ANBox();
			//addnBox.addChild(test);
			addnBox.visible=false;
			// var buttonTest:Button = new Button();
			// buttonTest.label="submit";
			// buttonTest.x= 350;
			// buttonTest.y = 350;
			// addnBox.addChild(buttonTest);
			
			//var test:Bitmap = new AQBox();
			//addqBox.addChild(test);
			addqBox.visible=false;
			//var mc:MovieClip = new MovieClip();  
            professorBox.visible=false;
			classNotesBox.visible=false;
			booksBox.visible = false;
			referenceBox.visible=false;

			professor.addEventListener(MouseEvent.CLICK, fProfessor);
			//reference.addEventListener(MouseEvent.CLICK, fReference);
			//classNotes.addEventListener(MouseEvent.CLICK, fClassNotes);
			//books.addEventListener(MouseEvent.CLICK, fBooks);
			addNotes.addEventListener(MouseEvent.CLICK, fAddNote);
			viewNotes.addEventListener(MouseEvent.CLICK, fNnq);
			toc.addEventListener(MouseEvent.CLICK, fToc);
			viewQuestion.addEventListener(MouseEvent.CLICK, fQnq);
			
			
			professorBox.y = 10;
			professorBox.x = 90;
			classNotesBox.y = 10;
			classNotesBox.x = 90;
			booksBox.y = 10;
			booksBox.x = 90;
			referenceBox.y = 10;
			referenceBox.x = 90;
				
				
			_zikFullScreenUI.addChild(professorBox);
			_zikFullScreenUI.addChild(classNotesBox);
			_zikFullScreenUI.addChild(booksBox);
			_zikFullScreenUI.addChild(referenceBox);
			_zikFullScreenUI.addChild(addQuestion);
			_zikFullScreenUI.addChild(viewQuestion);
			_zikFullScreenUI.addChild(leftMenu);
			_zikFullScreenUI.addChild(addNotes);
			_zikFullScreenUI.addChild(viewNotes);
			_zikFullScreenUI.addChild(toc);
			_zikFullScreenUI.addChild(tocBox);
			_zikFullScreenUI.addChild(nnqBox);
			_zikFullScreenUI.addChild(qnqBox);
			_zikFullScreenUI.addChild(addnBox);
			//_zikFullScreenUI.addChild(addqBox);
			_zikFullScreenUI.visible = false;
			
		}
		
		function fAddHotspot(myEvent:MouseEvent=null) {
					ExternalInterface.call("ff_pause_player");
					addnBox.visible = false;
					addqBox.visible = false;
					nnqBox.visible = false;
					addHotspotBox = new MovieClip();
					
					addHotspotBox.visible=true;
					addHotspotBox.graphics.beginFill(0x555555);  
					addHotspotBox.graphics.drawRect( 0, 0, RootReference.stage.stageWidth, RootReference.stage.stageHeight );  
					addHotspotBox.graphics.endFill();  
					addHotspotBox.alpha= 0.4;
					addHotspotBox.addEventListener(MouseEvent.CLICK, fAddHotspotDetails);
					var t:TextField = new TextField();  
					//t.embedFonts = true;
					t.text = "Click on the point where you would like to add a HOTSPOT";
	
					var tf:TextFormat = new TextFormat();
					tf.color = 0xFFFFFF;
					tf.size = 18;
					tf.font = "Calibri";
					tf.align=TextFormatAlign.CENTER;
					t.setTextFormat(tf);
					t.width=500;
					t.y=RootReference.stage.stageHeight/2;
					t.x = (RootReference.stage.stageWidth - t.width)/2;
					addHotspotBox.addChild(t); 
					_zikEnrichUI.addChild(addHotspotBox);
					
			
		}
		
		function fAddHotspotDetails (myEvent:MouseEvent) {
				addHotspotBox.visible= false;
				var time:String = ExternalInterface.call("ff_get_position") as String;
				hotspotX[hotspotTitles.length] = (myEvent.stageX*100)/RootReference.stage.stageWidth;
				hotspotY[hotspotTitles.length] = (myEvent.stageY*100)/RootReference.stage.stageHeight;
				hotspotTime[hotspotTitles.length] = time;
				
				hotspotDetailsBox.graphics.clear();
				hotspotDetailsBox.visible=true;
				hotspotDetailsBox.x= (RootReference.stage.stageWidth - 300)/2;
				hotspotDetailsBox.y= (RootReference.stage.stageHeight - 170)/2;
				hotspotDetailsBox.graphics.beginFill(0x555555);  
					hotspotDetailsBox.graphics.drawRect( 0, 0, 300, 170 );  
					hotspotDetailsBox.graphics.endFill();  
								 
					var t:TextField = new TextField();  
					//t.embedFonts = true;
					t.text = "Enter HOTSPOT Title";

		
					var tf:TextFormat = new TextFormat();
					tf.color = 0xFFFFFF;
					tf.size = 18;
					tf.font = "Calibri";
					tf.align=TextFormatAlign.CENTER;
				
					t.setTextFormat(tf);
					t.x=50;
					t.y=20;
					t.width=200;
					hotspotDetailsBox.addChild(t);  
					hotspotTitle.type = TextFieldType.INPUT; 
					hotspotTitle.background = true; 
					hotspotDetailsBox.addChild(hotspotTitle); 
					hotspotTitle.x = 20;
					hotspotTitle.y=70;
					hotspotTitle.width=250;
					hotspotTitle.height = 20;
					hotspotTitle.text="Title";
					//myFirstTextBox.addEventListener(TextEvent.TEXT_INPUT, inputEventCapture);
					var button:TextField = new TextField();
					button.text = "Submit";
					button.x = 70;
					button.width =70;
					button.y = 115;
					button.height=35;
					button.border = true;
					button.addEventListener(MouseEvent.CLICK, AddHSTitle);
					button.setTextFormat(tf);
					hotspotDetailsBox.addChild(button);
					var button2:TextField = new TextField();
					button2.text = "Cancel";
					button2.x = 160;
					button2.width =70;
					button2.y = 115;
					button2.border = true;
					button2.height=35;
					button2.addEventListener(MouseEvent.CLICK, CancelHSTitle);
					button2.setTextFormat(tf);
					hotspotDetailsBox.addChild(button2);
					_zikEnrichUI.addChild(hotspotDetailsBox);
					

				
		}
		
		function initHotspot()
		{
		var HotspotInit:Number = 0;
		for ( HotspotInit =0; HotspotInit<hotspotMovieC.length; HotspotInit++)
			{
				hotspotMovieC[HotspotInit].visible=false;
			}
		HotspotInit = 0;
		//ExternalInterface.call("ff_display_console_message","HOTSPOT DURATION LENGTH"+hotspotDuration.length);
		for ( HotspotInit =0; HotspotInit<hotspotDuration.length; HotspotInit++)
			{
					
					hotspotMovieC[HotspotInit] = new MovieClip();
					var test:Bitmap = new HSDisplay();
					hotspotMovieC[HotspotInit].addChild(test);
					hotspotMovieC[HotspotInit].x=(new Number(hotspotX[HotspotInit])*RootReference.stage.stageWidth)/100;
					hotspotMovieC[HotspotInit].y=(new Number(hotspotY[HotspotInit])*RootReference.stage.stageHeight)/100;
					_zikFullScreenUI.addChild(hotspotMovieC[HotspotInit]);
					//ExternalInterface.call("ff_display_console_message", "HOTSPOT INIT"+"---"+hotspotMovieC[HotspotInit].x);
					hotspotMovieC[HotspotInit].visible=false;
			}
		}
		
		function AddHSTitle (myEvent:MouseEvent)
		{
			hotspotTitles[hotspotTitles.length]=hotspotTitle.text;
			//ExternalInterface.call("ff_display_console_message", hotspotX[hotspotTitles.length-1] +"-"+ hotspotY[hotspotTitles.length-1]+"-"+hotspotTitles[hotspotTitles.length-1]);
			hotspotDetailsBox.visible=false;

								hotspotMovieC[hotspotDuration.length] = new MovieClip();
					var test:Bitmap = new HSDisplay();
					hotspotMovieC[hotspotDuration.length].addChild(test);
					
					hotspotMovieC[hotspotDuration.length].x=(new Number(hotspotX[hotspotDuration.length])*RootReference.stage.stageWidth)/100;
					hotspotMovieC[hotspotDuration.length].y=(new Number(hotspotY[hotspotDuration.length])*RootReference.stage.stageHeight)/100;
					//ExternalInterface.call("ff_display_console_message", "Timer is Triggered"+hotspotMovieC[hotspotDuration.length].x + hotspotMovieC[hotspotDuration.length].y);
					//_zikEnrichUI.addChild(hotspotMovieC[hotspotDuration.length]);
					_zikFullScreenUI.addChild(hotspotMovieC[hotspotDuration.length]);
								hotspotDuration[hotspotDuration.length]="999";
			

			var inputString:String = hotspotTitle.text+"||("+hotspotX[hotspotTitles.length-1]+","+hotspotY[hotspotTitles.length-1]+")||"+hotspotTime[hotspotTitles.length-1];
			ExternalInterface.call("ff_add_hs",inputString );
			addnBox.visible=false;
			ExternalInterface.call("ff_play_position", hotspotTime[hotspotTitles.length-1]);
					
			
		}
		function CancelHSTitle(myEvent:MouseEvent) {
			hotspotDetailsBox.visible = false;
		}
		
		function updateRef()
		{
			professorBox.visible=false;
			fProfessor(null);
		}
		function fProfessor(myEvent:MouseEvent){
		
			while (professorBox.numChildren > 0) {
						professorBox.removeChildAt(0);
					}	
						referenceBox.visible=false;
						booksBox.visible=false;
						classNotesBox.visible=false;
						professorBox.graphics.clear();
						professorBox.x = leftMenu.width+10;		
				 var buttonMask:Sprite = new Sprite();

					rectClipNotes = new Sprite();
					var rect:Sprite = new Sprite;
					rect.graphics.beginFill(0x555555, 1);
					rect.graphics.drawRect(0, 0, 45,45);
					rect.graphics.endFill();
					var rectTitle:Sprite = new Sprite;
					rectTitle.graphics.beginFill(0x555555, 1);
					rectTitle.graphics.drawRect(0, 0, 45, 45);
					rectTitle.graphics.endFill();

					rectTitle.width = 300;
					professorBox.addChild(rectTitle);
					buttonMask      = new Sprite();
					buttonMask.graphics.beginFill( 0x000000 );  
					buttonMask.graphics.drawRect( 0 , 0 , 300 , 300 );
					buttonMask.y = 45;
					professorBox.addChild(buttonMask);
					rectClipNotes.mask = buttonMask;
					professorBox.addChild(rectClipNotes);
					rectClipNotes.addChild(rect);
					rectClipNotes.y=45;		 
						rectClipNotes.addEventListener(MouseEvent.MOUSE_WHEEL,handleMouseWheel);		 
					var t:TextField = new TextField();  
					//t.embedFonts = true;
					t.text = "Educator Suggestions";

		
					var tf:TextFormat = new TextFormat();
					tf.color = 0xFFFFFF;
					tf.size = 18;
					tf.font = "Calibri";
					tf.align=TextFormatAlign.CENTER;
				
					t.setTextFormat(tf);
					t.y=05;
					t.width=300;
					t.height=30;
					professorBox.addChild(t);  
					var counter:Number = ReferencesTBS.length-1;
					rect.width = 300;
					rect.height = 20;
					

					while(counter>=0)
					{
						var t1:TextField = new TextField();  
					//t.embedFonts = true;
						t1.htmlText = " <a href='event:null'><u>"+References[new Number(ReferencesTBS[counter])]+"</u></a>";
						t1.y=10+(References.length-1-counter)*25;
						t1.x=10;
						t1.multiline = false;
						t1.wordWrap = false;
						t1.width = 280;
						t1.height = 30;
						t1.autoSize = TextFieldAutoSize.LEFT;
						if (t1.width > 280)
						{
						t1.multiline = true;
						t1.wordWrap = true;
						t1.width = 280;
						}
						t1.setTextFormat(secondaryTF);
						rect.height = t1.y + t1.textHeight +10;
						if(RefLinks[counter].indexOf("note:")==-1)
						t1.addEventListener(MouseEvent.CLICK, gotoURL);
						else 
						{
						t1.addEventListener(MouseEvent.MOUSE_OVER, over);
						t1.addEventListener(MouseEvent.MOUSE_OUT, out);
						t1.addEventListener(MouseEvent.CLICK, playPositionRef);
						}
						rectClipNotes.addChild(t1);

						counter--;
					}
					
	
			if(professorBox.visible) professorBox.visible=false;
			else professorBox.visible=true;
			
						 
		}
		function playPositionRef(e:MouseEvent){
		
		var counter:Number = 0;
		var tempTF:TextField = e.currentTarget as TextField;
				while(counter<=References.length-1)
				{
					if(tempTF.htmlText.indexOf(References[counter])!=-1)
						
						{
							ExternalInterface.call("ff_play_position", RefTime[counter]);
						}
						counter++;
						
				}
				
				
		}
		function gotoURL(myEvent:MouseEvent){
		
		var temp:TextField = myEvent.currentTarget as TextField;
		
		var counter:Number=0;
		while(counter<=References.length-1){
		if(temp.htmlText.indexOf(References[counter])!=-1) {ExternalInterface.call("ff_navigate_to_url", RefLinks[counter]);
			ExternalInterface.call("ff_play_position", RefTime[counter]);}
		counter++;
		}
		}
		function fReference(myEvent:MouseEvent){
		
			Security.allowDomain("*");
						classNotesBox.visible=false;
						professorBox.visible=false;
						booksBox.visible=false;
			//if (ExternalInterface.available) 
			{
					referenceBox.graphics.beginFill(0x555555);  
					referenceBox.graphics.drawRect( 0, 0, 300, 302 );  
					referenceBox.graphics.endFill();  
					referenceBox.x = leftMenu.width+10;		 
					var t:TextField = new TextField();  
					//t.embedFonts = true;
					t.text = "Other References";

		
					var tf:TextFormat = new TextFormat();
					tf.color = 0xFFFFFF;
					tf.size = 18;
					tf.font = "Calibri";
					tf.align=TextFormatAlign.CENTER;
				
					t.setTextFormat(tf);

					t.y=20;
					t.width=200;
					referenceBox.addChild(t);  
	
					_zikFullScreenUI.addChild(referenceBox);
				
				 	if(referenceBox.visible) referenceBox.visible=false;
					else referenceBox.visible=true;
						 
			 // } else {

				

			}
		}
		
		function fClassNotes(myEvent:MouseEvent){
		
						Security.allowDomain("*");
							referenceBox.visible=false;
						professorBox.visible=false;
						booksBox.visible=false;
			//if (ExternalInterface.available) 
			{
					classNotesBox.graphics.beginFill(0x555555);  
					classNotesBox.graphics.drawRect( 0, 0, 300, 302 );  
					classNotesBox.graphics.endFill();  
					classNotesBox.x = leftMenu.width+10;		 
					var t:TextField = new TextField();  
					//t.embedFonts = true;
					t.text = "ClassNotes";

		
					var tf:TextFormat = new TextFormat();
					tf.color = 0xFFFFFF;
					tf.size = 18;
					tf.font = "Calibri";
					tf.align=TextFormatAlign.CENTER;
				
					t.setTextFormat(tf);

					t.y=20;
					t.width=200;
					classNotesBox.addChild(t);  
	
					_zikFullScreenUI.addChild(classNotesBox);
					try { //var retData:Object = ExternalInterface.call("JSFunc"); 
					}
					catch(error:Error){
						t.text= error.toString();
					}
				 	if(classNotesBox.visible) classNotesBox.visible=false;
					else classNotesBox.visible=true;
						 
			 // } else {

				

			}
		}
		
		function fBooks(myEvent:MouseEvent){
		
			Security.allowDomain("*");
						referenceBox.visible=false;
						professorBox.visible=false;
						classNotesBox.visible=false;
			//if (ExternalInterface.available) 
			{
					booksBox.graphics.beginFill(0x555555);  
					booksBox.graphics.drawRect( 0, 0, 300, 302 );  
					booksBox.graphics.endFill();  
					booksBox.x = leftMenu.width+10;		 
					var t:TextField = new TextField();  
					//t.embedFonts = true;
					t.text = "Books";

		
					var tf:TextFormat = new TextFormat();
					tf.color = 0xFFFFFF;
					tf.size = 18;
					tf.font = "Calibri";
					tf.align=TextFormatAlign.CENTER;
				
					t.setTextFormat(tf);

					t.y=20;
					t.width=200;
					booksBox.addChild(t);  
	
					_zikFullScreenUI.addChild(booksBox);
					try { //var retData:Object = ExternalInterface.call("JSFunc"); 
					}
					catch(error:Error){
						t.text= error.toString();
					}
				 	if(booksBox.visible) booksBox.visible=false;
					else booksBox.visible=true;
						 
			 // } else {

				

			}
		}
		
		function fAddQuestions(myEvent:MouseEvent){
			Security.allowDomain("*");
						addnBox.visible=false;
while (addqBox.numChildren > 0) {
						addqBox.removeChildAt(0);
					}	
addqBox.graphics.clear();					
			if (ExternalInterface.available) 
			{
					ExternalInterface.call("ff_pause_player");
					addqBox.graphics.beginFill(0x555555);  
					addqBox.graphics.drawRect( 0, 0, 300, 170 );  
					addqBox.graphics.endFill();  
								 
					var t:TextField = new TextField();  
					//t.embedFonts = true;
					if(editNQMode>-1)
					t.text = "Edit your Question";
					else
					t.text = "Enter Your Question";

		
					var tf:TextFormat = new TextFormat();
					tf.color = 0xFFFFFF;
					tf.size = 18;
					tf.font = "Calibri";
					tf.align=TextFormatAlign.CENTER;
				
					t.setTextFormat(tf);
					t.x=50;
					t.y=20;
					t.width=200;
					addqBox.addChild(t);  
					myFirstTextBox.type = TextFieldType.INPUT; 
					myFirstTextBox.background = true; 
					addqBox.addChild(myFirstTextBox); 
					myFirstTextBox.x = 20;
					myFirstTextBox.y=70;
					myFirstTextBox.width=250;
					myFirstTextBox.height = 20;
					if(editNQMode>-1)
					myFirstTextBox.text=Questions[editNQMode];
					else
					myFirstTextBox.text="Question?";
					myFirstTextBox.addEventListener(MouseEvent.CLICK, clearText);
					//myFirstTextBox.addEventListener(TextEvent.TEXT_INPUT, inputEventCapture);
					var button:TextField = new TextField();
					button.text = "Submit";
					button.x = 70;
					button.width =70;
					button.y = 115;
					button.height=30;
					button.border = true;
					button.addEventListener(MouseEvent.CLICK, AddQues);
					button.setTextFormat(tf);
					addqBox.addChild(button);
					var button2:TextField = new TextField();
					button2.text = "Cancel";
					button2.x = 160;
					button2.width =70;
					button2.y = 115;
					button2.border = true;
					button2.height=30;
					button2.addEventListener(MouseEvent.CLICK, CancelQ);
					button2.setTextFormat(tf);
					addqBox.addChild(button2);
					_zikFullScreenUI.addChild(addqBox);
					try { //var retData:Object = ExternalInterface.call("JSFunc"); 
					}
					catch(error:Error){
						t.text= error.toString();
					}
				 	if(addqBox.visible) addqBox.visible=false;
					else addqBox.visible=true;
						 
			 // } else {

				

			}
		}
		
		function sleep(ms:int):void {
    var init:int = getTimer();
    while(true) {
        if(getTimer() - init >= ms) {
            break;
        }
    }
}

		function AddQues(myEvent:MouseEvent)
		{
			//JS UPDATE CALL
			var time:String = ExternalInterface.call("ff_get_position") as String;
			var inputString:String = myFirstTextBox.text+"||"+time;
			if(editNQMode==-1)
			{
				Questions[Questions.length] = myFirstTextBox.text;
				QTime[QTime.length] = time;
				ExternalInterface.call("ff_add_question",inputString );
			}
			else 
			{
				Questions[editNQMode] = myFirstTextBox.text;
				ExternalInterface.call("ff_edit_lquestion",QID[editNQMode]+"||"+ Questions[editNQMode]+"||"+QTime[editNQMode]);
			}
			addqBox.visible=false;
			sleep(1000);
			if(editNQMode>-1)
			{
				//reload
				QuestionData = ExternalInterface.call("ff_load_question_data");
				Questions.splice(0);QTime.splice(0);QuestionsTBS.splice(0); QuestionsTBS.length=0;
				while(QuestionData!="")
				{
					var delimQ:Number = QuestionData.indexOf("|||");
					if(delimQ!=-1)
					var qTemp:String = QuestionData.substr(0,delimQ);
					else var qTemp:String = QuestionData.substr(0);
					var delim1:Number = qTemp.indexOf("||");
					QID[QID.length] = qTemp.substr(0,delim1);
					qTemp = qTemp.substr(delim1+2);
					var delim1:Number = qTemp.indexOf("||");
					Questions[Questions.length] = qTemp.substr(0,delim1);
					qTemp = qTemp.substr(delim1+2);
					QTime[QTime.length] = qTemp;
					ExternalInterface.call("ff_display_console_message", Questions[Questions.length -1 ] + "---" +QTime[QTime.length-1]+"---");
					if(delimQ != -1) QuestionData = QuestionData.slice(delimQ+3);
					else QuestionData="";
				}
			}
						
			editNQMode=-1;
		}
		
		function CancelQ(myEvent:MouseEvent)
		{
			addqBox.visible=false;
			var time:String = ExternalInterface.call("ff_get_position") as String;
			ExternalInterface.call("ff_play_position", time);
			editNQMode=-1;
		}




		function fAddNote(myEvent:MouseEvent){
						Security.allowDomain("*");
						addqBox.visible=false;	
						while (addnBox.numChildren > 0) {
						addnBox.removeChildAt(0);
					}
					addnBox.graphics.clear();
			
			if (ExternalInterface.available) 
			{
					ExternalInterface.call("ff_pause_player");
					addnBox.graphics.beginFill(0x555555);  
					addnBox.graphics.drawRect( 0, 0, 300, 210 );  
					addnBox.graphics.endFill();  
								 
					var t:TextField = new TextField();  
					//t.embedFonts = true;
					if(editNQMode >-1)
					t.text = "Edit Your Note";
					else 
					t.text = "Enter Your Note";
		
					var tf:TextFormat = new TextFormat();
					tf.color = 0xFFFFFF;
					tf.size = 18;
					tf.font = "Calibri";
					tf.align=TextFormatAlign.CENTER;
				
					t.setTextFormat(tf);
					t.x=50;
					t.y=20;
					t.width=200;
					addnBox.addChild(t);  
					myFirstTextBox.type = TextFieldType.INPUT; 
					myFirstTextBox.background = true; 
					addnBox.addChild(myFirstTextBox); 
					if(editNQMode>-1)
					myFirstTextBox.text=NotesTitle[editNQMode];
					else
					myFirstTextBox.text="Title";
					myFirstTextBox.x = 20;
					myFirstTextBox.y=70;
					myFirstTextBox.width=250;
					myFirstTextBox.height = 20;
					myFirstTextBox.addEventListener(MouseEvent.CLICK, clearText);
					descTextBox.type = TextFieldType.INPUT; 
					descTextBox.background = true; 
					addnBox.addChild(descTextBox); 
					if(editNQMode>-1)
					descTextBox.text=NotesDesc[editNQMode];
					else
					descTextBox.text="Description";
					descTextBox.x = 20;
					descTextBox.y=100;
					descTextBox.width=250;
					descTextBox.height = 20;
					descTextBox.addEventListener(MouseEvent.CLICK, clearText);
					//myFirstTextBox.addEventListener(TextEvent.TEXT_INPUT, inputEventCapture);
					var button:TextField = new TextField();
					button.text = "Submit";
					button.x = 70;
					button.width =70;
					button.y = 145;
					button.height=30;
					button.border = true;
					button.addEventListener(MouseEvent.CLICK, AddNote);
					button.setTextFormat(tf);
					addnBox.addChild(button);
					var button2:TextField = new TextField();
					button2.text = "Cancel";
					button2.x = 160;
					button2.width =70;
					button2.y = 145;
					button2.border = true;
					button2.height=30;
					button2.setTextFormat(tf);
					button2.addEventListener(MouseEvent.CLICK, CancelNote);
					addnBox.addChild(button2);

					_zikFullScreenUI.addChild(addnBox);
					try { //var retData:Object = ExternalInterface.call("JSFunc"); 
					}
					catch(error:Error){
						t.text= error.toString();
					}
				 	if(addnBox.visible) addnBox.visible=false;
					else addnBox.visible=true;
						 
			 // } else {

				

			}
		}
		
		
		
		function fAddENote(myEvent:MouseEvent){
						Security.allowDomain("*");
						addqBox.visible=false;	
						nnqBox.visible = false;
						while (addnBox.numChildren > 0) {
						addnBox.removeChildAt(0);
					}
					addnBox.graphics.clear();
			
			if (ExternalInterface.available) 
			{
					ExternalInterface.call("ff_pause_player");
					addnBox.graphics.beginFill(0x555555);  
					addnBox.graphics.drawRect( 0, 0, 400, 210 );  
					addnBox.graphics.endFill();  
					addnBox.x = (RootReference.stage.stageWidth-400)/2;
					addnBox.y = (RootReference.stage.stageHeight-210)/2;
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
					descTextBox.type = TextFieldType.INPUT; 
					descTextBox.background = true; 
					addnBox.addChild(descTextBox); 
					descTextBox.text="Enter a Note";
					descTextBox.x = 120;
					descTextBox.y=100;
					descTextBox.width=250;
					descTextBox.height = 20;
					//myFirstTextBox.addEventListener(TextEvent.TEXT_INPUT, inputEventCapture);
					var button:TextField = new TextField();
					button.text = "Submit";
					button.x = 130;
					button.width =70;
					button.y = 145;
					button.height=30;
					button.border = true;
					button.addEventListener(MouseEvent.CLICK, AddENote);
					button.setTextFormat(tf);
					addnBox.addChild(button);
					var button2:TextField = new TextField();
					button2.text = "Cancel";
					button2.x = 220;
					button2.width =70;
					button2.y = 145;
					button2.border = true;
					button2.height=30;
					button2.setTextFormat(tf);
					button2.addEventListener(MouseEvent.CLICK, CancelNote);
					addnBox.addChild(button2);

					_zikEnrichUI.addChild(addnBox);
				 	if(addnBox.visible) addnBox.visible=false;
					else addnBox.visible=true;
						 
			 // } else {

				

			}
		}
		
		
		function fAddEToc(myEvent:MouseEvent){
						Security.allowDomain("*");
						addqBox.visible=false;	
						addnBox.visible=false;
						while (nnqBox.numChildren > 0) {
						nnqBox.removeChildAt(0);
					}
					nnqBox.graphics.clear();
			
			if (ExternalInterface.available) 
			{
					ExternalInterface.call("ff_pause_player");
					nnqBox.graphics.beginFill(0x555555);  
					nnqBox.graphics.drawRect( 0, 0, 400, 210 );  
					nnqBox.graphics.endFill();  
					nnqBox.x = (RootReference.stage.stageWidth-400)/2;
					nnqBox.y = (RootReference.stage.stageHeight-210)/2;
					var t:TextField = new TextField();  
					//t.embedFonts = true;
					t.text = "Enter Content Title";

		
					var tf:TextFormat = new TextFormat();
					tf.color = 0xFFFFFF;
					tf.size = 18;
					tf.font = "Calibri";
					tf.align=TextFormatAlign.CENTER;
				
					t.setTextFormat(tf);
					t.x=50;
					t.y=20;
					t.width=300;
					nnqBox.addChild(t);  
					
					
					// Title TextBOX
					var titleText:TextField = new TextField();  
					//t.embedFonts = true;
					titleText.text = "TOC Title";

		
					var tf2:TextFormat = new TextFormat();
					tf2.color = 0xFFFFFF;
					tf2.size = 11;
					tf2.font = "Calibri";
					tf2.align=TextFormatAlign.LEFT;
				
					titleText.setTextFormat(tf2);
					titleText.x=10;
					titleText.y=70;
					titleText.width=50;
					nnqBox.addChild(titleText);  
					
					//Description TextBOX
					
					var descText:TextField = new TextField();  
					//t.embedFonts = true;
					descText.text = "Associate Item";
					descText.setTextFormat(tf2);
					descText.x=10;
					descText.y=100;
					descText.width=75;
					nnqBox.addChild(descText);  
					
					
					myFirstTextBox.type = TextFieldType.INPUT; 
					myFirstTextBox.background = true; 
					myFirstTextBox.text="Enter Toc Item";
					nnqBox.addChild(myFirstTextBox); 
					myFirstTextBox.x = 90;
					myFirstTextBox.y=70;
					myFirstTextBox.width=270;
					myFirstTextBox.height = 20;
					descTextBox.type = TextFieldType.INPUT; 
					descTextBox.background = true; 
					nnqBox.addChild(descTextBox); 
					descTextBox.text="Associate this as a subsection of previous TOC";
					descTextBox.x = 90;
					descTextBox.y=100;
					descTextBox.width=270;
					descTextBox.height = 20;
					dropdown.visible=false;
					descTextBox.addEventListener(MouseEvent.CLICK, fShowDropDown);
					var button:TextField = new TextField();
					button.text = "Associate TOC";
					button.x = 70;
					button.width =140;
					button.y = 145;
					button.height=30;
					button.border = true;
					button.addEventListener(MouseEvent.CLICK, AddEToc);
					button.setTextFormat(tf);
					nnqBox.addChild(button);
					var button2:TextField = new TextField();
					button2.text = "Cancel";
					button2.x = 220;
					button2.width =70;
					button2.y = 145;
					button2.border = true;
					button2.height=30;
					button2.setTextFormat(tf);
					button2.addEventListener(MouseEvent.CLICK, CancelToc);
					nnqBox.addChild(button2);

					_zikEnrichUI.addChild(nnqBox);
				 	if(nnqBox.visible) nnqBox.visible=false;
					else nnqBox.visible=true;
						 
			 // } else {

				

			}
		}
		protected var dropdown:Sprite = new Sprite();
		function fShowDropDown(myEvent:MouseEvent)
		{
		
			
					if(dropdown.visible == true) 
						dropdown.visible=false;
					else dropdown.visible=true;
			while (dropdown.numChildren > 0) {
						dropdown.removeChildAt(0);
					}
					var tf2:TextFormat = new TextFormat();
					tf2.color = 0xFFFFFF;
					tf2.size = 11;
					tf2.font = "Calibri";
					tf2.align=TextFormatAlign.LEFT;
				
			dropdown.x = descTextBox.x;
			dropdown.y = descTextBox.y+25;
			var rect:Sprite = new Sprite;
			rect.graphics.beginFill(0x555555, 1);
			rect.graphics.drawRect(0, 0, 100, 100);
			rect.graphics.endFill();
			
			nnqBox.addChild(dropdown);
			dropdown.addChild(rect);
						 
					 
			var t:TextField = new TextField();  
			rect.height = 20;
			rect.width = descTextBox.width;
			var counter:Number = 0;
			
			while(counter<=tocContent.length-1)
			{
				var t1:TextField = new TextField();  
			//t.embedFonts = true;
				t1.text= tocContent[counter];
				t1.y=10+counter*15;
				t1.x=10;
				t1.setTextFormat(tf2);
				//rect.width = t1.width+20;
				rect.height = t1.y + 20;
				t1.addEventListener(MouseEvent.CLICK, selectToc);
				dropdown.addChild(t1);
				counter++;
			}	
			
			
			
		}
		
		function selectToc(myEvent:MouseEvent)
		{
			var temp:TextField = myEvent.currentTarget as TextField;
			if(temp.text!="Associate this as a subsection of previous TOC") selectedTOC = temp.text;
			else selectedTOC ="None";
			descTextBox.text = selectedTOC;
			dropdown.visible=false;
		}
		
		function AddEToc(myEvent:MouseEvent)
		{
			//JS UPDATE CALL

			var time:String = ExternalInterface.call("ff_get_position") as String;
			var inputString:String = myFirstTextBox.text+"||"+selectedTOC+"||"+time;
			tocContent[tocContent.length] = myFirstTextBox.text;
			ExternalInterface.call("ff_add_toc",inputString );
			nnqBox.visible=false;
			ExternalInterface.call("ff_play_position", time);
		}
		

		
		function fAddERef(myEvent:MouseEvent){
						Security.allowDomain("*");
						addnBox.visible=false;	
						nnqBox.visible=false;
						while (addqBox.numChildren > 0) {
						addqBox.removeChildAt(0);
					}
					addqBox.graphics.clear();
			
			if (ExternalInterface.available) 
			{
					ExternalInterface.call("ff_pause_player");
					addqBox.graphics.beginFill(0x555555);  
					addqBox.graphics.drawRect( 0, 0, 400, 210 );  
					addqBox.graphics.endFill();  
					addqBox.x = (RootReference.stage.stageWidth-400)/2;
					addqBox.y = (RootReference.stage.stageHeight-210)/2;
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
					myFirstTextBox.background = true; 
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
					descTextBox.width=250;
					descTextBox.height = 20;
					//myFirstTextBox.addEventListener(TextEvent.TEXT_INPUT, inputEventCapture);
					var button:TextField = new TextField();
					button.setTextFormat(tf2);
					button.text = "Associate Reference";
					button.x = 70;
					button.width =160;
					button.y = 145;
					button.height=30;
					button.border = true;
					button.addEventListener(MouseEvent.CLICK, AddERef);
					button.setTextFormat(tf);
					addqBox.addChild(button);
					var button2:TextField = new TextField();
					button2.text = "Cancel";
					button2.x = 250;
					button2.width =70;
					button2.y = 145;
					button2.border = true;
					button2.height=30;
					button2.setTextFormat(tf);
					button2.addEventListener(MouseEvent.CLICK, CancelQ);
					addqBox.addChild(button2);

					_zikEnrichUI.addChild(addqBox);
				 	if(addqBox.visible) addqBox.visible=false;
					else addqBox.visible=true;
						 
			 // } else {

				

			}
		}
		
			
		function AddERef(myEvent:MouseEvent)
		{
			//JS UPDATE CALL
			var time:String = ExternalInterface.call("ff_get_position") as String;
			var inputString:String = myFirstTextBox.text+"||"+descTextBox.text+"||"+time;

			ExternalInterface.call("ff_add_reference",inputString );
			addqBox.visible=false;
			ExternalInterface.call("ff_play_position", time);
		}
		

		
		function AddENote(myEvent:MouseEvent)
		{
			//JS UPDATE CALL

			var time:String = ExternalInterface.call("ff_get_position") as String;
			var inputString:String = myFirstTextBox.text+"||"+descTextBox.text+"||"+time;
			ExternalInterface.call("ff_add_note",inputString );
			addnBox.visible=false;
			ExternalInterface.call("ff_play_position", time);
		}
		
		
		
		function AddNote(myEvent:MouseEvent)
		{
			//JS UPDATE CALL

			var time:String = ExternalInterface.call("ff_get_position") as String;
			var inputString:String = myFirstTextBox.text+"||"+descTextBox.text+"||"+time;
			
			if(editNQMode==-1)
			{
			ExternalInterface.call("ff_add_note",inputString );
			NotesTitle[NotesTitle.length] = myFirstTextBox.text;
			NotesDesc[NotesDesc.length] = descTextBox.text;
			NotesTime[NotesTime.length] = time;
			}
			else
			{
				NotesTitle[editNQMode] = myFirstTextBox.text;
				NotesDesc[editNQMode] = descTextBox.text;
				ExternalInterface.call("ff_edit_lnote",NID[editNQMode]+"||"+NotesTitle[editNQMode]+"||"+NotesDesc[editNQMode]+"||"+NotesTime[editNQMode]);
			}		
			addnBox.visible=false;
			ExternalInterface.call("ff_play_position", time);
			sleep(1000);
			//reload
			if(editNQMode > -1){
			NoteData = ExternalInterface.call("ff_load_note_data");
			NotesTitle.splice(0);NotesDesc.splice(0);NotesTime.splice(0);NotesTitleTBS.splice(0); NotesTitleTBS.length=0;
			while(NoteData!="")
			{
				var delimQ:Number = NoteData.indexOf("|||");
				if(delimQ!=-1)
				var noteTemp:String = NoteData.substr(0,delimQ);
				else var noteTemp:String = NoteData.substr(0);
				var delim1:Number = noteTemp.indexOf("||");
				NID[NID.length] = noteTemp.substr(0,delim1);
				noteTemp = noteTemp.substr(delim1+2);
				var delim1:Number = noteTemp.indexOf("||");
				NotesTitle[NotesTitle.length] = noteTemp.substr(0,delim1);
				noteTemp = noteTemp.substr(delim1+2);
				delim1 = noteTemp.indexOf("||");
				NotesDesc[NotesDesc.length] = noteTemp.substr(0,delim1);
				noteTemp = noteTemp.substr(delim1+2);
				NotesTime[NotesTime.length] = noteTemp;
				//ExternalInterface.call("ff_display_console_message", NotesTitle[NotesTitle.length -1 ] + "---" +NotesDesc[NotesDesc.length-1] + NotesTime[NotesTime.length-1]+"---");
				if(delimQ != -1) NoteData = NoteData.slice(delimQ+3);
				else NoteData="";
			}
			editNQMode=-1;
			}
		}

		function CancelToc(myEvent:MouseEvent)
		{
			nnqBox.visible=false;
		}
		
		function CancelNote(myEvent:MouseEvent)
		{
		var time:String = ExternalInterface.call("ff_get_position") as String;
			addnBox.visible=false;
			ExternalInterface.call("ff_play_position", time);
			editNQMode=-1;
		}
		
		function fToc(myEvent:MouseEvent){

			if(qnqBox.visible) qnqBox.visible=false;
			if(nnqBox.visible) nnqBox.visible=false;
			Security.allowDomain("*");
			
			
			Security.allowDomain("*");
			while (tocBox.numChildren > 0) {
						tocBox.removeChildAt(0);
					}
					tocBox.graphics.clear();
					var t:TextField = new TextField();  
					//t.embedFonts = true;
					t.text = "Table of Contents";
					var container:Sprite = new Sprite();
					var tf:TextFormat = new TextFormat();
					tf.color = 0xFFFFFF;
					tf.size = 18;
					tf.font = "Calibri";
					tf.align=TextFormatAlign.CENTER;
				
					t.setTextFormat(tf);

					t.y=20;
					t.width=300;
					
					var tf2:TextFormat = new TextFormat();
					tf2.color = 0xFFFFFF;
					tf2.size = 14;
					tf2.font = "Calibri";
					tf2.align=TextFormatAlign.LEFT;
				

			var rect:Sprite = new Sprite;
			rect.graphics.beginFill(0x555555, 1);
			rect.graphics.drawRect(0, 0, 100, 100);
			rect.graphics.endFill();
			rect.width = 280;
			tocBox.addChild(container);
			container.addChild(rect);
						 container.addChild(t);
					 
			
			var counter:Number = 0;
			rect.height=50;
			while(counter<=tocContent.length-1)
			{
				var t1:TextField = new TextField();  
			//t.embedFonts = true;
				t1.htmlText= "<u>"+tocContent[counter]+"</u>";
				t1.y=rect.height;
				t1.x=10;
				t1.setTextFormat(tf2);
				t1.width = 280;
				//rect.width = t1.width+20;
				rect.height = t1.y + 25;
				t1.addEventListener(MouseEvent.CLICK, playStartTOC);
				container.addChild(t1);
				counter++;
			}	
			
			
					_zikFullScreenUI.addChild(tocBox);
				 	if(tocBox.visible) tocBox.visible=false;
					else tocBox.visible=true;
		
		
		}
			function updateQNQ()
		{
			qnqBox.visible=false;
			fQnq(null);
		}
	function fQnq(myEvent:MouseEvent){
			
			 var buttonMask:Sprite = new Sprite();
			Security.allowDomain("*");
			if(tocBox.visible) tocBox.visible=false;
			if(nnqBox.visible) nnqBox.visible=false;				
			//if (ExternalInterface.available) 
			{
			while (qnqBox.numChildren > 0) {
						qnqBox.removeChildAt(0);
					}
					//qnqBox = new MovieClip();
					qnqBox.y = 70;
						qnqBox.x = RootReference.stage.stageWidth-280;
						rectClipNotes = new Sprite();
					var rect:Sprite = new Sprite;
					rect.graphics.beginFill(0x555555, 1);
					rect.graphics.drawRect(0, 0, 45,45);
					rect.graphics.endFill();
					var rectTitle:Sprite = new Sprite;
					rectTitle.graphics.beginFill(0x777777, 1);
					rectTitle.graphics.drawRect(0, 0, 45, 45);
					rectTitle.graphics.endFill();

					rectTitle.width = 270;
					qnqBox.addChild(rectTitle);
					buttonMask      = new Sprite();
					buttonMask.graphics.beginFill( 0x000000 );  
					buttonMask.graphics.drawRect( 0 , 0 , 280 , 200 );
					buttonMask.y = 45;
					qnqBox.addChild(buttonMask);
					rectClipNotes.mask = buttonMask;
					qnqBox.addChild(rectClipNotes);
					rectClipNotes.addChild(rect);
					rectClipNotes.y=45;		 
						rectClipNotes.addEventListener(MouseEvent.MOUSE_WHEEL,handleMouseWheel);		 
					var t:TextField = new TextField();  
					//t.embedFonts = true;
					t.text = "Questions";

		
					var tf:TextFormat = new TextFormat();
					tf.color = 0xFFFFFF;
					tf.size = 18;
					tf.font = "Calibri";
					tf.align=TextFormatAlign.CENTER;
				
					t.setTextFormat(tf);
					t.y=5;
					t.width=280;
					t.height=30;
					qnqBox.addChild(t);  
					var counter:Number = QuestionsTBS.length-1;
					rect.width = 270;
					rect.height = 20;
					while(counter>=0)
					{
						var t1:TextField = new TextField();  
					//t.embedFonts = true;
						t1.htmlText =  "<a href='event:null'>"+ Questions[new Number(QuestionsTBS[counter])] + "</a>";
						t1.y=10+(QuestionsTBS.length-1-counter)*25;
						t1.x=10;
						t1.height = 30;
						t1.multiline = false;
						t1.wordWrap = false;
						t1.autoSize = TextFieldAutoSize.LEFT;
						if (t1.width > 200)
						{
						t1.multiline = true;
						t1.width = 200;
						t1.wordWrap = true;
						}
						t1.setTextFormat(secondaryTF);
						rect.height = t1.y + t1.textHeight +10;
						t1.addEventListener(MouseEvent.CLICK, playStartQ);
						rectClipNotes.addChild(t1);
						var editNQ:MovieClip = new MovieClip();
						var test:Bitmap = new EditNQ();
						editNQ.addChild(test);
						editNQ.x = t1.x + 210+2;
						editNQ.y = t1.y;
						editNQ.alpha = 0.2;
						editNQ.visible = true;
						editNQ.addEventListener(MouseEvent.MOUSE_OVER, increaseOpacity); 
						editNQ.addEventListener(MouseEvent.MOUSE_OUT, decreaseOpacity); 
						editNQ.addEventListener(MouseEvent.CLICK, editQuestion); 
						var deleteNQ:MovieClip = new MovieClip();
						test = new DeleteNQ();
						deleteNQ.addChild(test);
						deleteNQ.x = t1.x + 210+26;
						deleteNQ.alpha = 0.2;
						ExternalInterface.call("ff_display_console_message",t1.x + t1.width+14);
						deleteNQ.y = t1.y;
						deleteNQ.visible = true;
						deleteNQ.addEventListener(MouseEvent.MOUSE_OVER, increaseOpacity); 
						deleteNQ.addEventListener(MouseEvent.MOUSE_OUT, decreaseOpacity); 
						deleteNQ.addEventListener(MouseEvent.CLICK, deleteQuestion); 
						rectClipNotes.addChild(editNQ);
						rectClipNotes.addChild(deleteNQ);
						
						counter--;
					}
					
	
			if(qnqBox.visible) qnqBox.visible=false;
			else qnqBox.visible=true;
						 


				

			}

		}
		function clearText(myEvent:MouseEvent) {
			var tempTF:TextField = myEvent.currentTarget as TextField;
			tempTF.text="";
			tempTF.removeEventListener(MouseEvent.CLICK, clearText);
		
		}
		
		function playStartNotes(myEvent:MouseEvent){
			ExternalInterface.call("ff_display_console_message", "Entered PlayStart");
			var counter:Number = 0;
			var tempTF:TextField = myEvent.currentTarget as TextField;
			while(counter<=NotesTime.length-1)
			{
				if(tempTF.htmlText.indexOf(NotesTitle[counter])!=-1)
					
					{
						ExternalInterface.call("ff_play_position",NotesTime[counter]+"");
						break;
					}
					counter++;
			}
		}
				function playStartTOC(myEvent:MouseEvent){
			
			var counter:Number = 0;
			var tempTF:TextField = myEvent.currentTarget as TextField;
			while(counter<=tocContent.length-1)
			{
				if(tempTF.htmlText.indexOf(tocContent[counter])!=-1)
					ExternalInterface.call("ff_play_position",tocTime[counter]+"");
					counter++;
			}
		}
		function playStartQ(myEvent:MouseEvent){
			
			var counter:Number = 0;
			var tempTF:TextField = myEvent.currentTarget as TextField;
							ExternalInterface.call("ff_display_console_message", "Entered PlayStart OUT");
			while(QTime.length!=0 && counter<=QTime.length-1)
			{
				ExternalInterface.call("ff_display_console_message", tempTF.text);
				ExternalInterface.call("ff_display_console_message", Questions[counter]);
				if(tempTF.htmlText.indexOf(Questions[counter])!=-1)
					ExternalInterface.call("ff_play_position",QTime[counter]+"");
					counter++;
			}
		}

var noteNumber:Number = 0;
var deltaMove:Number = 0;
// Create MouseWheel Event
public function handleMouseWheel(event:MouseEvent){
	var tempTF:Sprite = event.currentTarget as Sprite;
	if( (tempTF.y+event.delta*2)<(45) && (tempTF.height+tempTF.y+event.delta*2)>=240 )
	{
		tempTF.y+=event.delta*2;

	}
	ExternalInterface.call("ff_display_console_message", tempTF.y+"---"+event.delta +"---" +tempTF.height+tempTF.y );
}

// Add MouseWheel Listener
		function updateNNQ()
		{
			nnqBox.visible=false;
			fNnq(null);
		}
		function fNnq(myEvent:MouseEvent){
			 var buttonMask:Sprite = new Sprite();
			Security.allowDomain("*");
			if(tocBox.visible) tocBox.visible=false;
			if(qnqBox.visible) qnqBox.visible=false;				
			//if (ExternalInterface.available) 
			{
			while (nnqBox.numChildren > 0) {
						nnqBox.removeChildAt(0);
					}
					//nnqBox = new MovieClip();
					nnqBox.y = 70;
						nnqBox.x = RootReference.stage.stageWidth-280;
					rectClipNotes = new Sprite();
					var rect:Sprite = new Sprite;
					rect.graphics.beginFill(0x555555, 1);
					rect.graphics.drawRect(0, 0, 45,45);
					rect.graphics.endFill();
					var rectTitle:Sprite = new Sprite;
					rectTitle.graphics.beginFill(0x777777, 1);
					rectTitle.graphics.drawRoundRectComplex(0, 0, 280, 45, 20, 20, 0 , 0);
					rectTitle.graphics.endFill();

					rectTitle.width = 270;
					nnqBox.addChild(rectTitle);
					buttonMask      = new Sprite();
					buttonMask.graphics.beginFill( 0x000000 );  
					buttonMask.graphics.drawRect( 0 , 0 , 280 , 200 );
					buttonMask.y = 45;
					nnqBox.addChild(buttonMask);
					rectClipNotes.mask = buttonMask;
					nnqBox.addChild(rectClipNotes);
					rectClipNotes.addChild(rect);
					rectClipNotes.y=45;		 
						rectClipNotes.addEventListener(MouseEvent.MOUSE_WHEEL,handleMouseWheel);		 
					var t:TextField = new TextField();  
					//t.embedFonts = true;
					t.text = "Notes";

		
					var tf:TextFormat = new TextFormat();
					tf.color = 0xFFFFFF;
					tf.size = 18;
					tf.font = "Calibri";
					tf.align=TextFormatAlign.CENTER;
				
					t.setTextFormat(tf);
					t.y=05;
					t.width=280;
					t.height=30;
					nnqBox.addChild(t);  
					var counter:Number = NotesTitleTBS.length-1;
					rect.width = 270;
					rect.height = 20;
					while(counter>=0)
					{
						var t1:TextField = new TextField();  
					//t.embedFonts = true;
						t1.htmlText = "<a href='event:null'>"+NotesTitle[new Number(NotesTitleTBS[counter])]+ "</a>";
						t1.y=10+(NotesTitleTBS.length-1-counter)*25;
						t1.x=10;
						t1.multiline = false;
						t1.wordWrap = false;
						t1.setTextFormat(secondaryTF);
						t1.autoSize = TextFieldAutoSize.LEFT;
						if (t1.width > 200)
						{
						t1.wordWrap = true;
						t1.multiline = true;
						t1.width = 200;
						}
						rect.height = t1.y + t1.textHeight +10;
						ExternalInterface.call("ff_display_console_message",t1.text);
						t1.addEventListener(MouseEvent.MOUSE_OVER, over); 
						t1.addEventListener(MouseEvent.MOUSE_OUT, out); 
						t1.addEventListener(MouseEvent.CLICK, playStartNotes);
						rectClipNotes.addChild(t1);
						var editNQ:MovieClip = new MovieClip();
						var test:Bitmap = new EditNQ();
						editNQ.addChild(test);
						editNQ.x = t1.x + 210+2;
						editNQ.y = t1.y;
						editNQ.alpha = 0.2;
						editNQ.visible = true;
						editNQ.addEventListener(MouseEvent.MOUSE_OVER, increaseOpacity); 
						editNQ.addEventListener(MouseEvent.MOUSE_OUT, decreaseOpacity); 
						editNQ.addEventListener(MouseEvent.CLICK, editNotes); 
						var deleteNQ:MovieClip = new MovieClip();
						test = new DeleteNQ();
						deleteNQ.addChild(test);
						deleteNQ.x = t1.x + 210+26;
						deleteNQ.alpha = 0.2;
						ExternalInterface.call("ff_display_console_message",t1.x + t1.width+14);
						deleteNQ.y = t1.y;
						deleteNQ.visible = true;
						deleteNQ.addEventListener(MouseEvent.MOUSE_OVER, increaseOpacity); 
						deleteNQ.addEventListener(MouseEvent.MOUSE_OUT, decreaseOpacity); 
						deleteNQ.addEventListener(MouseEvent.CLICK, deleteNotes); 
						rectClipNotes.addChild(editNQ);
						rectClipNotes.addChild(deleteNQ);
						counter--;
					}
					
	
			if(nnqBox.visible) nnqBox.visible=false;
			else nnqBox.visible=true;
						 
			 // } else {

				

			}
		}

		function increaseOpacity(e:MouseEvent) {
		var tempMC:MovieClip = e.currentTarget as MovieClip;
		tempMC.alpha = 1;
		TBSUpdateEnabled=false;
		}
		
		
		function decreaseOpacity(e:MouseEvent) {
		var tempMC:MovieClip = e.currentTarget as MovieClip;
		tempMC.alpha = 0.2;
		TBSUpdateEnabled=true;
		}
		
		function editNotes(e:MouseEvent) {
		var tempMC:MovieClip = e.currentTarget as MovieClip;
		var targetY:Number = tempMC.y;
		
		for(var i=0; i<rectClipNotes.numChildren-1; i++)
		{
			if(rectClipNotes.getChildAt(i) is TextField && rectClipNotes.getChildAt(i).y == targetY)
			{
				var tempTF:TextField = rectClipNotes.getChildAt(i) as TextField;
				var counter:Number = 0;
				while(counter<=NotesTime.length-1)
				{
					if(tempTF.htmlText.indexOf(NotesTitle[counter])!=-1)
					{
						ExternalInterface.call("ff_display_console_message",NotesTitle[counter]+"||"+NotesTime[counter]);
						editNQMode=counter;
						fAddNote(null);
						break;
					}
					counter++;
				}
			}
		}
	}
	
	function editQuestion(e:MouseEvent) {
		var tempMC:MovieClip = e.currentTarget as MovieClip;
		var targetY:Number = tempMC.y;
		ExternalInterface.call("ff_display_console_message","Entered Edit Mode");
		for(var i=0; i<rectClipNotes.numChildren-1; i++)
		{
			if(rectClipNotes.getChildAt(i) is TextField && rectClipNotes.getChildAt(i).y == targetY)
			{
				var tempTF:TextField = rectClipNotes.getChildAt(i) as TextField;
				var counter:Number = 0;
				while(counter<=Questions.length-1)
				{
					if(tempTF.htmlText.indexOf(Questions[counter])!=-1)
					{
						//ExternalInterface.call("ff_edit_notes",NotesTitle[counter]+"||"+NotesTime[counter]);
						ExternalInterface.call("ff_display_console_message",Questions[counter]+"||"+QTime[counter]);
						editNQMode=counter;
						fAddQuestions(null);
						break;
					}
					counter++;
				}
			}
		}
	}
	
	function deleteQuestion(e:MouseEvent) {
		var tempMC:MovieClip = e.currentTarget as MovieClip;
		var targetY:Number = tempMC.y;
		
		for(var i=0; i<rectClipNotes.numChildren-1; i++)
		{
			if(rectClipNotes.getChildAt(i) is TextField && rectClipNotes.getChildAt(i).y == targetY)
			{
				var tempTF:TextField = rectClipNotes.getChildAt(i) as TextField;
				var counter:Number = 0;
				while(counter<=Questions.length-1)
				{
					if(tempTF.htmlText.indexOf(Questions[counter])!=-1)
					{
						ExternalInterface.call("ff_delete_lquestion",QID[counter]);
						ExternalInterface.call("ff_display_console_message",Questions[counter]+"||"+QTime[counter]);
						QTime[counter] = 99999;
						QuestionsTBS.splice(0);
						break;
					}
					counter++;
				}
			}
		}
	}
	
	function deleteNotes(e:MouseEvent) {
		var tempMC:MovieClip = e.currentTarget as MovieClip;
		var targetY:Number = tempMC.y;
		
		for(var i=0; i<rectClipNotes.numChildren-1; i++)
		{
			if(rectClipNotes.getChildAt(i) is TextField && rectClipNotes.getChildAt(i).y == targetY)
			{
				var tempTF:TextField = rectClipNotes.getChildAt(i) as TextField;
				var counter:Number = 0;
				while(counter<=NotesTime.length-1)
				{
					if(tempTF.htmlText.indexOf(NotesTitle[counter])!=-1)
					{
						//ExternalInterface.call("ff_edit_notes",NotesTitle[counter]+"||"+NotesTime[counter]);
						NotesTime[counter] = 99999;
						NotesTitleTBS.splice(0);
						ExternalInterface.call("ff_delete_lnote",NID[counter]);
						//ExternalInterface.call("ff_display_console_message",NotesTitle[counter]+"||"+NotesTime[counter]);
						break;
					}
					counter++;
				}
			}
		}
	}
		
		protected function setupLogo():void {
			_logo = new Logo(_player);
		}


		protected function setupLayer(name:String, index:Number, parent:DisplayObjectContainer=null):MovieClip {
			var layer:MovieClip = new MovieClip();
			parent ? parent.addChildAt(layer,index) : _root.addChildAt(layer, index);
			layer.name = name;
			layer.x = 0;
			layer.y = 0;
			return layer;
		}


		protected function setupBackground():void {
			var background:MovieClip = new MovieClip();
			background.name = "background";
			_backgroundLayer.addChild(background);
			
			var screenColor:Color;
			if (_model.config.screencolor) {
				screenColor = _model.config.screencolor;
			} else if (_model.config.pluginConfig('display').hasOwnProperty('backgroundcolor')) {
				screenColor = new Color(String(_model.config.pluginConfig('display')['backgroundcolor']));
			}
			
			background.graphics.beginFill(screenColor ? screenColor.color : 0x000000, screenColor ? 1 : 0);
			background.graphics.drawRect(0, 0, 1, 1);
			background.graphics.endFill();
		}


		protected function setupDisplayMask():void {
			_displayMasker = new MovieClip();
			_displayMasker.graphics.beginFill(0x000000, 1);
			_displayMasker.graphics.drawRect(0, 0, _player.config.width, _player.config.height);
			_displayMasker.graphics.endFill();

			_maskedLayers.mask = _displayMasker;
		}


		protected function setupComponents():void {
			var n:Number = 0;
			
			_components = new PlayerComponents(_player);

			setupComponent(_components.display, n++);
			setupComponent(_components.playlist, n++);
			setupComponent(_logo, n++);
			setupComponent(_components.controlbar, n++);
			setupComponent(_components.dock, n++);
		}


		protected function setupComponent(component:*, index:Number):void {
			if (component is IGlobalEventDispatcher) { (component as IGlobalEventDispatcher).addGlobalListener(forward); }
			if (component is DisplayObject) { _componentsLayer.addChildAt(component as DisplayObject, index); }
		}


		protected function resizeHandler(event:Event):void {
			_fullscreen = (RootReference.stage.displayState == StageDisplayState.FULL_SCREEN_INTERACTIVE);
			if (_model.fullscreen != _fullscreen) {
				dispatchEvent(new ViewEvent(ViewEvent.JWPLAYER_VIEW_FULLSCREEN, _fullscreen));
			}
			redraw();
			
			dispatchEvent(new ViewEvent(ViewEvent.JWPLAYER_RESIZE, {width: RootReference.stage.stageWidth, height: RootReference.stage.stageHeight}));
		}


		public function fullscreen(mode:Boolean=true):void {
			try {
				RootReference.stage.displayState = mode ? StageDisplayState.FULL_SCREEN_INTERACTIVE: StageDisplayState.NORMAL;
							//RootReference.stage.stage.displayState = StageDisplayState.FULL_SCREEN_INTERACTIVE;
			} catch (e:Error) {
				Logger.log("Could not enter fullscreen mode: " + e.message);
			}
		}


		/** Redraws the plugins and player components **/
		public function redraw():void {
			layoutManager.resize(RootReference.stage.stageWidth, RootReference.stage.stageHeight);

			_components.resize(_player.config.width, _player.config.height);
			if (!_fullscreen) {
				_normalScreen.width = _player.config.width;
				_normalScreen.height = _player.config.height;
			} 

			resizeBackground();
			resizeMasker();

			_imageLayer.x = _mediaLayer.x = _components.display.x;
			_imageLayer.y = _mediaLayer.y = _components.display.y;

			if (_preserveAspect) {
				if(!_fullscreen && _player.config.stretching != Stretcher.EXACTFIT) {
					_preserveAspect = false;
				}
			} else {
				if (_fullscreen && _player.config.stretching == Stretcher.EXACTFIT) {
					_preserveAspect = true;
				}
			}

			resizeImage(_player.config.width, _player.config.height);
			resizeMedia(_player.config.width, _player.config.height);
			if (_fullscreen)
			{
				if(deployMode=="ENRICH")
				{
									addqBox.x = (RootReference.stage.stageWidth-300)/2;
					addqBox.y = (RootReference.stage.stageHeight-210)/2;
										addnBox.x = (RootReference.stage.stageWidth-300)/2;
					addnBox.y = (RootReference.stage.stageHeight-210)/2;
					nnqBox.x = (RootReference.stage.stageWidth-300)/2;
					nnqBox.y = (RootReference.stage.stageHeight-210)/2;
				hotspotIcon.x= RootReference.stage.stageWidth - 50;
				eTocIcon.x= RootReference.stage.stageWidth - 100;
				eRefIcon.x= RootReference.stage.stageWidth - 150;
				eNoteIcon.x = RootReference.stage.stageWidth - 200;
				
				var counter:Number = 0;
					hotspotDetailsBox.x= (RootReference.stage.stageWidth - 300)/2;
				hotspotDetailsBox.y= (RootReference.stage.stageHeight - 170)/2;
				
				}
				if(deployMode == "CONSUME") 
				{
						initHotspot();
						_zikFullScreenUI.visible = true;
						viewQuestion.x= RootReference.stage.stageWidth-55;
						toc.x = RootReference.stage.stageWidth-55*2;
						viewNotes.x = RootReference.stage.stageWidth-55*3;
						addNotes.x = RootReference.stage.stageWidth-55*4;
						addQuestion.x = RootReference.stage.stageWidth-55*5; 
						addqBox.x= (RootReference.stage.stageWidth-300)/2;
						addqBox.y= (RootReference.stage.stageHeight-150)/2;
						addnBox.x= (RootReference.stage.stageWidth-300)/2;
						addnBox.y= (RootReference.stage.stageHeight-150)/2;
						tocBox.y = 70;
						tocBox.x = RootReference.stage.stageWidth-280;
						nnqBox.y = 70;
						nnqBox.x = RootReference.stage.stageWidth-280;
						qnqBox.y = 70;
						qnqBox.x = RootReference.stage.stageWidth-280;
						NoteData = ExternalInterface.call("ff_load_note_data");
						QuestionData = ExternalInterface.call("ff_load_question_data");
						EduRefData = ExternalInterface.call("ff_load_edu_references");
						EduNoteData = ExternalInterface.call("ff_load_edu_notes");
						TOCData = ExternalInterface.call("ff_load_toc_data");
						NotesTitle.splice(0);NotesDesc.splice(0);NotesTime.splice(0);NotesTitleTBS.splice(0); NotesTitleTBS.length=0;
						Questions.splice(0);QTime.splice(0);QuestionsTBS.splice(0); QuestionsTBS.length=0;
						References.splice(0); RefLinks.splice(0);ReferencesTBS.splice(0);ReferencesTBS.length=0;RefTime.splice(0);
						tocContent.splice(0); tocTime.splice(0);
						qnqBox.visible=false;
						nnqBox.visible=false;
						TBSUpdateEnabled = true;
						
						
						while(EduRefData!="")
						{
							var delimQ:Number = EduRefData.indexOf("|||");
							if(delimQ!=-1)
							var qTemp:String = EduRefData.substr(0,delimQ);
							else var qTemp:String = EduRefData.substr(0);
							var delim1:Number = qTemp.indexOf("||");
							References[References.length] = qTemp.substr(0,delim1);
							qTemp = qTemp.substr(delim1+2);
							delim1 = qTemp.indexOf("||");
							RefLinks[RefLinks.length] =  qTemp.substr(0,delim1);;
							qTemp = qTemp.substr(delim1+2);
							RefTime[RefTime.length] = qTemp;
							//ExternalInterface.call("ff_display_console_message", References[References.length -1 ] + "---" +RefLinks[RefLinks.length-1]+"---");
							if(delimQ != -1) EduRefData = EduRefData.slice(delimQ+3);
							else EduRefData="";
						}
						while(EduNoteData!="")
						{
							var delimQ:Number = EduNoteData.indexOf("|||");
							if(delimQ!=-1)
							var qTemp:String = EduNoteData.substr(0,delimQ);
							else var qTemp:String = EduNoteData.substr(0);
							var delim1:Number = qTemp.indexOf("||");
							References[References.length] = qTemp.substr(0,delim1);
							qTemp = qTemp.substr(delim1+2);
							delim1 = qTemp.indexOf("||");
							RefLinks[RefLinks.length] = qTemp.substr(0,delim1);
							qTemp = qTemp.substr(delim1+2);
							RefTime[RefTime.length] = qTemp;
							//ExternalInterface.call("ff_display_console_message", References[References.length -1 ] + "---" +RefLinks[RefLinks.length-1]+"---");
							if(delimQ != -1) EduNoteData = EduNoteData.slice(delimQ+3);
							else EduNoteData="";
						}

						while(NoteData!="")
						{
							var delimQ:Number = NoteData.indexOf("|||");
							if(delimQ!=-1)
							var noteTemp:String = NoteData.substr(0,delimQ);
							else var noteTemp:String = NoteData.substr(0);
							var delim1:Number = noteTemp.indexOf("||");
							NID[NID.length] = noteTemp.substr(0,delim1);
							noteTemp = noteTemp.substr(delim1+2);
							var delim1:Number = noteTemp.indexOf("||");
							NotesTitle[NotesTitle.length] = noteTemp.substr(0,delim1);
							noteTemp = noteTemp.substr(delim1+2);
							delim1 = noteTemp.indexOf("||");
							NotesDesc[NotesDesc.length] = noteTemp.substr(0,delim1);
							noteTemp = noteTemp.substr(delim1+2);
							NotesTime[NotesTime.length] = noteTemp;
							ExternalInterface.call("ff_display_console_message", NotesTitle[NotesTitle.length -1 ] + "---" +NotesDesc[NotesDesc.length-1] + NotesTime[NotesTime.length-1]+"---");
							if(delimQ != -1) NoteData = NoteData.slice(delimQ+3);
							else NoteData="";
						}

						while(QuestionData!="")
						{
							var delimQ:Number = QuestionData.indexOf("|||");
							if(delimQ!=-1)
							var qTemp:String = QuestionData.substr(0,delimQ);
							else var qTemp:String = QuestionData.substr(0);
							var delim1:Number = qTemp.indexOf("||");
							QID[QID.length] = qTemp.substr(0,delim1);
							qTemp = qTemp.substr(delim1+2);
							var delim1:Number = qTemp.indexOf("||");
							Questions[Questions.length] = qTemp.substr(0,delim1);
							qTemp = qTemp.substr(delim1+2);
							QTime[QTime.length] = qTemp;
							ExternalInterface.call("ff_display_console_message", Questions[Questions.length -1 ] + "---" +QTime[QTime.length-1]+"---");
							if(delimQ != -1) QuestionData = QuestionData.slice(delimQ+3);
							else QuestionData="";
						}
						
						while(TOCData!="")
						{
							var delimQ:Number = TOCData.indexOf("|||");
							if(delimQ!=-1)
							var qTemp:String = TOCData.substr(0,delimQ);
							else var qTemp:String = TOCData.substr(0);
							var delim1:Number = qTemp.indexOf("||");
							tocContent[tocContent.length] = qTemp.substr(0,delim1);
							qTemp = qTemp.substr(delim1+2);
							tocTime[tocTime.length] = qTemp;
							ExternalInterface.call("ff_display_console_message", tocContent[tocContent.length -1 ] + "---" +tocTime[tocTime.length-1]+"---");
							if(delimQ != -1) TOCData = TOCData.slice(delimQ+3);
							else TOCData="";
						}
				}
			}
			else {
					TBSUpdateEnabled=false;
			
					if(deployMode == "CONSUME") 
					{
						_zikFullScreenUI.visible = false;
					}
					if(deployMode=="ENRICH")
					{
					
					addqBox.x = (RootReference.stage.stageWidth-300)/2;
					addqBox.y = (RootReference.stage.stageHeight-210)/2;
					addnBox.x = (RootReference.stage.stageWidth-300)/2;
					addnBox.y = (RootReference.stage.stageHeight-210)/2;
					nnqBox.x = (RootReference.stage.stageWidth-300)/2;
					nnqBox.y = (RootReference.stage.stageHeight-210)/2;
					hotspotDetailsBox.x= (RootReference.stage.stageWidth - 300)/2;
					hotspotDetailsBox.y= (RootReference.stage.stageHeight - 170)/2;
				
						hotspotIcon.x= RootReference.stage.stageWidth - 50;
						eTocIcon.x= RootReference.stage.stageWidth - 100;
						eRefIcon.x= RootReference.stage.stageWidth - 150;
						eNoteIcon.x = RootReference.stage.stageWidth - 200;
						
					}
				}
			if (_logo) {
				_logo.x = _components.display.x;
				_logo.y = _components.display.y;
				_logo.resize(_player.config.width, _player.config.height);
			}

			for (var i:Number = 0; i < _pluginsLayer.numChildren; i++) {
				var plug:IPlugin = _pluginsLayer.getChildAt(i) as IPlugin;
				var plugDisplay:DisplayObject = plug as DisplayObject;
				if (plug && plugDisplay) {
					var cfg:PluginConfig = _player.config.pluginConfig(plug.id);
					if (cfg['visible']) {
						plugDisplay.visible = true;
						plugDisplay.x = cfg['x'];
						plugDisplay.y = cfg['y'];
						try {
							plug.resize(cfg.width, cfg.height);
						} catch (e:Error) {
							Logger.log("There was an error resizing plugin '" + plug.id + "': " + e.message);
						}
					} else {
						plugDisplay.visible = false;
					}
				}
			}

			PlayerV4Emulation.getInstance(_player).resize(_player.config.width, _player.config.height);
		}

		protected function resizeMedia(width:Number, height:Number):void {
			// Don't need to resize the media if width/height are 0 (i.e. player is hidden in the DOM)
			if (width * height == 0) return;
			
			if (_mediaLayer.numChildren > 0 && _model.media.display) {
				if (_preserveAspect && _model.media.stretchMedia) {
					if (_fullscreen && _player.config.stretching == Stretcher.EXACTFIT) {
						_model.media.resize(_normalScreen.width, _normalScreen.height);
						Stretcher.stretch(_mediaLayer, width, height, Stretcher.UNIFORM);
					} else {
						_model.media.resize(width, height);
						_mediaLayer.scaleX = _mediaLayer.scaleY = 1;
						_mediaLayer.x = _mediaLayer.y = 0;
					}
				} else {
					_model.media.resize(width, height);
					_mediaLayer.x = _mediaLayer.y = 0;
				}
				_mediaLayer.x += _components.display.x;
				_mediaLayer.y += _components.display.y;
			}
		}

		protected function resizeImage(width:Number, height:Number):void {
			if (_imageLayer.numChildren > 0) {
				try {
					_image.width = _image.contentLoaderInfo.width;
					_image.height = _image.contentLoaderInfo.height;
				} catch(e:Error) {
					// Resize image later
					return;
				}
				if (_preserveAspect) {
					if (_fullscreen && _player.config.stretching == Stretcher.EXACTFIT) {
						Stretcher.stretch(_image, _normalScreen.width, _normalScreen.height, _player.config.stretching);
						Stretcher.stretch(_imageLayer, width, height, Stretcher.UNIFORM);
					} else {
						Stretcher.stretch(_image, width, height, _player.config.stretching);
						Stretcher.stretch(_imageLayer, width, height, Stretcher.NONE);
						_imageLayer.x = _imageLayer.y = 0;
					}
				} else {
					Stretcher.stretch(_image, width, height, _player.config.stretching);
					_imageLayer.x = _imageLayer.y = 0;
				}
				_imageLayer.x += _components.display.x;
				_imageLayer.y += _components.display.y;
			}
			
		}

		protected function resizeBackground():void {
			var bg:DisplayObject = _backgroundLayer.getChildByName("background");
			bg.width = RootReference.stage.stageWidth;
			bg.height = RootReference.stage.stageHeight;
			bg.x = 0;
			bg.y = 0;
		}


		protected function resizeMasker():void {
			if (_displayMasker == null)
				setupDisplayMask();

			_displayMasker.graphics.clear();
			_displayMasker.graphics.beginFill(0, 1);
			_displayMasker.graphics.drawRect(_components.display.x, _components.display.y, _player.config.width, _player.config.height);
			_displayMasker.graphics.endFill();
		}


		public function get components():IPlayerComponents {
			return _components;
		}

		/** This feature, while not yet implemented, will allow the API to replace the built-in components with any class that implements the control interfaces. **/
		public function overrideComponent(newComponent:IPlayerComponent):void {
			dispatchEvent(new ErrorEvent(ErrorEvent.ERROR, false, false, "overrideComponent not implemented"));
		}


		public function addPlugin(id:String, plugin:IPlugin):void {
			try {
				var plugDO:DisplayObject = plugin as DisplayObject;
				if (!_plugins[id] && plugDO != null) {
					_plugins[id] = plugDO;
					_pluginsLayer.addChild(plugDO);
				}
				if (_player.config.pluginIds.indexOf(id) < 0) {
					_player.config.plugins += "," + id;
				}
			} catch (e:Error) {
				dispatchEvent(new ErrorEvent(ErrorEvent.ERROR, false, false, e.message));
			}
		}


		public function removePlugin(plugin:IPlugin):void {
			var id:String = plugin.id.toLowerCase();
			if (id && _plugins[id] is IPlugin) {
				_pluginsLayer.removeChild(_plugins[id]);
				delete _plugins[id];
			}
		}


		public function loadedPlugins():Array {
			var list:Array = [];
			for (var pluginId:String in _plugins) {
				if (_plugins[pluginId] is IPlugin) {
					list.push(pluginId);
				}
			}
			return list;
		}


		public function getPlugin(id:String):IPlugin {
			return _plugins[id] as IPlugin;
		}


		public function bringPluginToFront(id:String):void {
			var plugin:IPlugin = getPlugin(id);
			_pluginsLayer.setChildIndex(plugin as DisplayObject, _pluginsLayer.numChildren - 1);
		}


		protected function mediaLoaded(evt:MediaEvent):void {
			var disp:DisplayObject = _model.media.display;
			if (disp && disp.parent != _mediaLayer) {
				while (_mediaLayer.numChildren) {
					_mediaLayer.removeChildAt(0);
				}
				_mediaLayer.addChild(_model.media.display);
				resizeMedia(_player.config.width, _player.config.height);
			}
		}


		protected function itemHandler(evt:PlaylistEvent):void {
			if (_model.playlist.currentItem && _model.playlist.currentItem.image) {
				if (_lastImage != _model.playlist.currentItem.image) {
					_lastImage = _model.playlist.currentItem.image;
					loadImage(_lastImage);
				}
			}
		}


		protected function loadImage(url:String):void {
			_image.load(new URLRequest(url), new LoaderContext(true));
		}


		protected function imageComplete(evt:Event):void {
			if (_image) {
				resizeImage(_player.config.width, _player.config.height);
				try {
					Draw.smooth(_image.content as Bitmap);
				} catch (e:Error) {
					Logger.log('Could not smooth preview image: ' + e.message);
				}
				if (_model.state != PlayerState.PLAYING && _model.state != PlayerState.PAUSED) { 
					showImage();
				}
			}
		}


		protected function imageError(evt:ErrorEvent):void {
			Logger.log('Error loading preview image: '+evt.text);
		}

		
		protected function showImage(evt:TimerEvent=null):void {
			_imageLayer.alpha = 0;
			_imageFade.fade(1);
			_mediaFade.cancelAnimation();
			_mediaLayer.alpha = 0;
		}
		
		protected function hideImage():void {
			_imageFade.fade(0);
		}

		protected function showMedia(evt:TimerEvent):void {
			if (_model.media.display) {
				_mediaFade.fade(1);
				_imageFade.cancelAnimation();
				_imageLayer.alpha = 0;
			} else {
				_mediaFade.fade(0);
				_imageFade.fade(1);
			} 
		}
		
		protected function stateHandler(evt:PlayerStateEvent=null):void {
			imageDelay.reset();
			mediaDelay.reset();
			switch (_model.state) {
				case PlayerState.IDLE:
					imageDelay.start();
					break;
				case PlayerState.PLAYING:
				case PlayerState.PAUSED:
					mediaDelay.start();
					break;
			}
		}


		protected function forward(evt:Event):void {
			if (evt is PlayerEvent)
				dispatchEvent(evt);
		}
		
		public function setupInstream(instreamDisplay:DisplayObject, plugin:IPlugin):void {
			_instreamPlugin = plugin;
			if (instreamDisplay) {
				_instreamLayer.addChild(instreamDisplay);
			}
			try {
				var pluginDO:DisplayObject = plugin as DisplayObject;
				if (pluginDO) {
					_pluginsLayer.removeChild(pluginDO);
					_instreamLayer.addChild(pluginDO);
				}
			} catch(e:Error) {
				Logger.log("Could not add instream plugin to display stack");
			}
			
			_instreamAnim.fade(1);
		}
		
		public function destroyInstream():void {
			if (_instreamPlugin && _instreamPlugin is DisplayObject) {
				_pluginsLayer.addChild(_instreamPlugin as DisplayObject);
			}
			_instreamAnim.fade(0);
		}
		
		protected function instreamAnimationComplete(evt:Event):void {
			if (_instreamLayer.alpha == 0) {
				while(_instreamLayer.numChildren > 0) {
					_instreamLayer.removeChildAt(0);
				}
				_instreamPlugin = null;
			}
		}
		
	}
}