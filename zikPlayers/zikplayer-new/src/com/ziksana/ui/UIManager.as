package com.ziksana.ui
{
	import com.ziksana.content.DocumentContent;
	import com.ziksana.content.ScribbleContent;
	import com.ziksana.content.VideoContent;
	import com.ziksana.events.GlobalEventDispatcher;
	import com.ziksana.events.ZEvent;
	import com.ziksana.player.ContentViewer;
	import com.ziksana.player.DocumentViewer;
	import com.ziksana.player.ScribbleViewer;
	import com.ziksana.player.VideoViewer;
	import com.ziksana.skin.PlayerSkin;
	import com.ziksana.skin.SkinParser;
	import com.ziksana.util.Logger;
	import com.ziksana.util.XMLUtil;
	
	import flash.display.MovieClip;
	import flash.display.Sprite;
	import flash.display.Stage;
	import flash.display.StageAlign;
	import flash.display.StageScaleMode;
	import flash.events.Event;
	import flash.events.EventDispatcher;
	import flash.events.MouseEvent;
	
	public class UIManager
	{
		private var m_Stage : Stage;
		
		private var m_Contents : Array = new Array();
		private var m_ContentViewers : Array = new Array ();
		private var m_ContentMovieClip : Array = new Array ();
		
		private var m_NumberOfContents : int = 0;
		private var m_Background : MovieClip = null;
		private var m_NumberOfLayers : int = 0;
		
		private static const BACKGROUND_X : uint = 5;
		private static const BACKGROUND_Y : uint = 5;
		private var m_UIConfigurationFileURL: String = null;
		private var m_XMLUtil : XMLUtil = null;
		
		private static const CONTENT_ANNOTATOR:String = "CONTENT_ANNOTATOR";
		private static const ANNOTATED_CONTENT_RECORDER:String = "ANNOTATED_CONTENT_RECORDER";
		public function UIManager(uiConfigurationFileURL : String)
		{
			m_UIConfigurationFileURL = uiConfigurationFileURL;
		}
		
		public function Init (stage : Stage) : void
		{
			m_Stage = stage;
			m_Stage.align = StageAlign.TOP_LEFT;
			m_Stage.scaleMode = StageScaleMode.NO_SCALE;
			m_Stage.addEventListener(Event.RESIZE, OnResize);
			LoadXML(m_UIConfigurationFileURL);
		}
		
		private function InitUI (spec:Object) : void
		{
			
			var layers:Array = spec.LAYER as Array;
		
			for(var i:int = 0; i<layers.length; i++)
			{
				trace("i=="+i);
				m_ContentMovieClip[i] = new MovieClip();
				(m_ContentMovieClip[i] as MovieClip).x = new Number(layers[i].X.toString());
				(m_ContentMovieClip[i] as MovieClip).y = new Number(layers[i].Y.toString());
				(m_ContentMovieClip[i] as MovieClip).graphics.beginFill(0x006600, 0.2);
				(m_ContentMovieClip[i] as MovieClip).graphics.drawRect(0,0, (new Number(layers[i].WIDTH.toString())*m_Stage.stageWidth)/100, (new Number(layers[i].HEIGHT.toString())*m_Stage.stageHeight)/100);
				(m_ContentMovieClip[i] as MovieClip).graphics.endFill();
				(m_ContentMovieClip[i] as MovieClip).width = (new Number(layers[i].WIDTH.toString())*m_Stage.stageWidth)/100;
				(m_ContentMovieClip[i] as MovieClip).height =(new Number(layers[i].HEIGHT.toString())*m_Stage.stageHeight)/100;
				trace((m_ContentMovieClip[i] as MovieClip).height);
				trace (layers[i].CONTENTVIEWER.toString().toLowerCase());
				switch(layers[i].CONTENTVIEWER.toString().toLowerCase())
				{
					case "documentviewer":
					case "document-viewer":	
					case "document viewer":	
					case "document_viewer":
						m_Contents[i] = new DocumentContent();
						m_ContentViewers[i] = new DocumentViewer(m_Contents[i], m_ContentMovieClip[i]);
						
						break;
					case "scribbler":
						m_Contents[i] = new ScribbleContent();
						m_ContentViewers[i] = new ScribbleViewer(m_Contents[i], m_ContentMovieClip[i]);
						break;
					case "webcamrecorder":
						trace("WCRECO");
						m_Contents[i] = new VideoContent();
						m_ContentViewers[i] = new VideoViewer(m_Contents[i], m_ContentMovieClip[i]);
						break;
					default:
						break;
				}
				(m_ContentViewers[i] as ContentViewer).SetCoordinates((m_ContentMovieClip[i] as MovieClip).x,
					(m_ContentMovieClip[i] as MovieClip).y, (m_ContentMovieClip[i] as MovieClip).width,
					(m_ContentMovieClip[i] as MovieClip).height);
				(m_ContentViewers[i] as ContentViewer).Load();
			}

			for (var currentViewer : int = 0; currentViewer < i; currentViewer++)
				AddLayer (m_ContentMovieClip[currentViewer]);
		}
		
		private function OnMouseMove (mouseEvent : MouseEvent) : void 
		{
			Logger.instance.WriteMessage("DocumentViewer::OnMouseMove ==> " + "X = " + mouseEvent.localX + "Y = " + mouseEvent.localY);
			if (mouseEvent.localX <= 1)
				m_ContentViewers[2].SetVisible(true);
		}
		
		private function CreateContents () : void
		{
			//Create all contents here.
			m_Contents[0] = new DocumentContent();
			m_NumberOfContents++;
			m_Contents[1] = new VideoContent ();
			m_NumberOfContents++;
			m_Contents[2] = new ScribbleContent ();
			m_NumberOfContents++;
		}
		
		private function CreateContentContainer () : void
		{
			//Create all contents here.
			m_ContentMovieClip[0] = new MovieClip();
			m_ContentMovieClip[1] = new MovieClip ();
			m_ContentMovieClip[2] = new MovieClip ();
		}
		
		private function CreateContentViewers () : void
		{
			//Create all contents here.
			m_ContentViewers[0] = new DocumentViewer(m_Contents[0], m_ContentMovieClip[0]);
			m_ContentViewers[1] = new VideoViewer (m_Contents[1], m_ContentMovieClip[1]);
			m_ContentViewers[2] = new ScribbleViewer (m_Contents[2], m_ContentMovieClip[2]);
		}
		
		
		private function LoadViewers () : void
		{
			//Load Viewers here
			//Next add other layers
			for (var currentViewer : int = 0; currentViewer < m_NumberOfContents; currentViewer++)
				m_ContentViewers[currentViewer].Load();
		}
		
		private function AddBackgroundLayer () : void
		{
			m_Background = new MovieClip ();
			m_Background.x = BACKGROUND_X;
			m_Background.y = BACKGROUND_Y;
			
			AddLayer (m_Background);
		}
		
		private function AddLayer (movieClip : MovieClip) : void
		{
			m_Stage.addChildAt(movieClip, m_NumberOfLayers);
			m_NumberOfLayers++;
		}
		
		private function SetCoordinates () : void
		{
			var left : Number;
			var top : Number;
			var width : Number;
			var height : Number;
			
			//Set the Document Viewer Position
			left = 0;
			top = 0;
			width = (m_Stage.stageWidth * 70.0)/100.0;
			height = (m_Stage.stageHeight * 85.0)/100.0;
			
			m_ContentViewers[0].SetCoordinates(left, top, width, height);

			//Set the Video Player Position
			left = width - 320;
			top = height - 240;
			width = 320;
			height = 240;

			m_ContentViewers[1].SetCoordinates(left, top, width, height);
			
			//Set the Video Player Position
			left = 0;
			top = 0;
			width = 65;
			height = 410;
			
			m_ContentViewers[2].SetCoordinates(left, top, width, height);
		}
		
		private function GetPercentValue (actualValue : Number, percentageFactor : Number) : Number
		{
			return ((actualValue * percentageFactor) / 100.0);
		}
		
		public function OnResize (event : Event = null) : void
		{
			//Update width and height here.
		}
		private function LoadXML (xmlURL : String) : void
		{
			m_XMLUtil = new XMLUtil(XMLUtil.TYPE_HTTP, xmlURL);
			m_XMLUtil.setCompletionEvent(ZEvent.EVENT_ANNOTATOR_UI_XML_PARSED);
			GlobalEventDispatcher.instance.addGlobalListener(ZEvent.EVENT_ANNOTATOR_UI_XML_PARSED, onAnnotatorUIXMLParsed);
			
			m_XMLUtil.loadAndParse();
		}
		
		private function onAnnotatorUIXMLParsed (zEvent:ZEvent):void
		{
			var annotatorFileData:Object = m_XMLUtil.GetXMLParsedData();
			InitUI(annotatorFileData);
		}
		
	}
}