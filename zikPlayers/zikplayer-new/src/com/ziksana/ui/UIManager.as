package com.ziksana.ui
{
	import com.ziksana.content.DocumentContent;
	import com.ziksana.content.ScribbleContent;
	import com.ziksana.content.VideoContent;
	import com.ziksana.player.DocumentViewer;
	import com.ziksana.player.ScribbleViewer;
	import com.ziksana.player.VideoViewer;
	import com.ziksana.skin.PlayerSkin;
	import com.ziksana.skin.SkinParser;
	import com.ziksana.util.Logger;
	
	import flash.display.MovieClip;
	import flash.display.Stage;
	import flash.display.StageAlign;
	import flash.display.StageScaleMode;
	import flash.events.Event;
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
		
		public function UIManager()
		{
		}
		
		public function Init (stage : Stage) : void
		{
			m_Stage = stage;

			//Logger ("UIManager::InitUI ==> Stage Width = " + m_Stage.stageWidth + " Height =" + m_Stage.stageHeight);
			m_Stage.align = StageAlign.TOP_LEFT;
			m_Stage.scaleMode = StageScaleMode.NO_SCALE;
			
			//Add a resize handler here
			m_Stage.addEventListener(Event.RESIZE, OnResize);
			
			CreateContents ();
			CreateContentContainer();
			CreateContentViewers ();
			
			//First add the background layer
			AddBackgroundLayer();
			
			PlayerSkin.DrawRectangle(m_Background, SkinParser.GetBackgroundColor(), 0, 0, m_Stage.stageWidth, m_Stage.stageHeight);
			
			//Next add other layers
			for (var currentViewer : int = 0; currentViewer < m_NumberOfContents; currentViewer++)
				AddLayer (m_ContentMovieClip[currentViewer]);
			
			SetCoordinates();
			
			LoadViewers();
			
			m_Stage.addEventListener (MouseEvent.MOUSE_MOVE, OnMouseMove);
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
	}
}