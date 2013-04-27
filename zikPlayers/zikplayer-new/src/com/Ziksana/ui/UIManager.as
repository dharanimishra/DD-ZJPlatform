package com.ziksana.ui
{
	import com.ziksana.content.DocumentContent;
	import com.ziksana.content.VideoContent;
	import com.ziksana.player.DocumentViewer;
	import com.ziksana.player.VideoViewer;
	
	import flash.display.MovieClip;
	import flash.display.Stage;
	import flash.display.StageAlign;
	import flash.display.StageScaleMode;
	import flash.events.Event;
	import com.ziksana.skin.PlayerSkin;
	import com.ziksana.skin.SkinParser;
	
	public class UIManager
	{
		private var m_Stage : Stage;
		
		//private var m_DocumentContent : Content = null;
		//private var m_LiveContent : Content = null;
		private var m_Contents : Array = new Array();
		private var m_ContentViewers : Array = new Array ();
		private var m_ContentMovieClip : Array = new Array ();
		private var m_NumberOfContents : int = 0;
		private var m_Background : MovieClip = null;
		private var m_NumberOfLayers : int = 0;
		
		//private var m_PlayerSkin : PlayerSkin = new PlayerSkin ();
		
		public function UIManager()
		{
		}
		
		public function InitUI (stage : Stage) : void
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
			
			UpdateDisplay();
		}
		
		private function CreateContents () : void
		{
			//Create all contents here.
			m_Contents[0] = new DocumentContent();
			m_NumberOfContents++;
			m_Contents[1] = new VideoContent ();
			m_NumberOfContents++;
		}
		
		private function CreateContentContainer () : void
		{
			//Create all contents here.
			m_ContentMovieClip[0] = new MovieClip();
			m_ContentMovieClip[1] = new MovieClip ();
		}
		
		private function CreateContentViewers () : void
		{
			//Create all contents here.
			m_ContentViewers[0] = new DocumentViewer(m_Contents[0], m_ContentMovieClip[0]);
			m_ContentViewers[1] = new VideoViewer (m_Contents[1], m_ContentMovieClip[1]);
		}
		
		private function AddBackgroundLayer () : void
		{
			m_Background = new MovieClip ();
			AddLayer (m_Background);
		}
		
		private function AddLayer (movieClip : MovieClip) : void
		{
			if(m_NumberOfLayers==1) {
				movieClip.x=5;
				movieClip.y=5;
			}
			m_Stage.addChildAt(movieClip, m_NumberOfLayers);
			m_NumberOfLayers++;
		}
		
		private function UpdateDisplay () : void
		{
			for (var currentViewer : int = 0; currentViewer < m_NumberOfContents; currentViewer++)
			{
				m_ContentViewers[currentViewer].SetCoordinates(
					(m_Stage.stageWidth * 70.0)/100.0,
					(m_Stage.stageHeight * 85)/100.0);
			}
		}
		
		private function GetPercentValue (actualValue : Number, percentageFactor : Number) : Number
		{
			return ((actualValue * percentageFactor) / 100.0);
		}
		
		public function OnResize (event : Event = null) : void
		{
			//Update width and height here.
		}
		
		public function ShowPopup (text:String, timeOutInMS : Number = 1700) : void
		{
			
		}
		
		public function HidePopup () : void
		{
			
		}
	}
}