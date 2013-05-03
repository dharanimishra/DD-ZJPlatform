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
	import com.ziksana.recorder.ContentRecorder;
	import com.ziksana.recorder.CameraRecorder;
	import com.ziksana.recorder.ScribbleRecorder;
	
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
		private var m_ContentRecorders : Array = new Array ();
		private var m_ContentMovieClip : Array = new Array ();
		
		private var m_NumberOfContents : int = 0;
		private var m_Background : MovieClip = null;
		private var m_NumberOfLayers : int = 0;
		
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
				m_ContentMovieClip[i] = new MovieClip();
				(m_ContentMovieClip[i] as MovieClip).x = new Number(layers[i].X.toString());
				(m_ContentMovieClip[i] as MovieClip).y = new Number(layers[i].Y.toString());
				(m_ContentMovieClip[i] as MovieClip).graphics.beginFill(0x006600, 0);
				(m_ContentMovieClip[i] as MovieClip).graphics.drawRect(0,0, (new Number(layers[i].WIDTH.toString())*m_Stage.stageWidth)/100, (new Number(layers[i].HEIGHT.toString())*m_Stage.stageHeight)/100);
				(m_ContentMovieClip[i] as MovieClip).graphics.endFill();
				(m_ContentMovieClip[i] as MovieClip).width = (new Number(layers[i].WIDTH.toString())*m_Stage.stageWidth)/100;
				(m_ContentMovieClip[i] as MovieClip).height =(new Number(layers[i].HEIGHT.toString())*m_Stage.stageHeight)/100;
				
				
				trace("Layer : = " + i);
				trace("Width : " + (m_ContentMovieClip[i] as MovieClip).width);
				trace("Height : " + (m_ContentMovieClip[i] as MovieClip).height);
				trace (layers[i].CONTENTVIEWER.toString().toLowerCase());
				
				switch(layers[i].CONTENTVIEWER.toString().toLowerCase())
				{
					case "documentviewer":
					case "document-viewer":	
					case "document viewer":	
					case "document_viewer":
						m_Contents[i] = new DocumentContent();
						m_ContentViewers[i] = new DocumentViewer(m_Contents[i], m_ContentMovieClip[i]);
						(m_ContentMovieClip[i] as MovieClip).graphics.beginFill(0x006600, 1);
						(m_ContentMovieClip[i] as MovieClip).graphics.drawRect(0,0, (new Number(layers[i].WIDTH.toString())*m_Stage.stageWidth)/100, (new Number(layers[i].HEIGHT.toString())*m_Stage.stageHeight)/100);
						(m_ContentMovieClip[i] as MovieClip).graphics.endFill();
						(m_ContentViewers[i] as ContentViewer).SetCoordinates(0, 0, (m_ContentMovieClip[i] as MovieClip).width,
							(m_ContentMovieClip[i] as MovieClip).height);
						(m_ContentViewers[i] as ContentViewer).Load();
						break;
					case "scribbler":
						//(m_ContentMovieClip[i] as MovieClip).mouseChildren=false;
						//(m_ContentMovieClip[i] as MovieClip).mouseEnabled=false;
						m_ContentRecorders[i] = new ScribbleRecorder(m_ContentMovieClip[i]);
						(m_ContentRecorders[i] as ContentRecorder).SetCoordinates(0, 0, (m_ContentMovieClip[i] as MovieClip).width,
							(m_ContentMovieClip[i] as MovieClip).height);
						(m_ContentRecorders[i] as ContentRecorder).Load();
						break;
					case "webcamrecorder":
						trace("WCRECO");
						(m_ContentMovieClip[i] as MovieClip).mouseChildren=false;
						(m_ContentMovieClip[i] as MovieClip).mouseEnabled=false;
						m_ContentRecorders[i] = new CameraRecorder(m_ContentMovieClip[i]);
						(m_ContentRecorders[i] as ContentRecorder).SetCoordinates(0, 0, (m_ContentMovieClip[i] as MovieClip).width,
							(m_ContentMovieClip[i] as MovieClip).height);
						(m_ContentRecorders[i] as ContentRecorder).Load();
						break;
					default:
						break;
				}
			}

			for (var currentViewer : int = 0; currentViewer < i; currentViewer++)
				AddLayer (m_ContentMovieClip[currentViewer]);
		}
		
		private function OnMouseMove (mouseEvent : MouseEvent) : void 
		{
			Logger.instance.WriteMessage("DocumentViewer::OnMouseMove ==> " + "X = " + mouseEvent.localX + "Y = " + mouseEvent.localY);
		}
		
		private function AddLayer (movieClip : MovieClip) : void
		{
			m_Stage.addChildAt(movieClip, m_NumberOfLayers);
			m_NumberOfLayers++;
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