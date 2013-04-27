package com.ziksana.ui
{
	import flash.display.Sprite;
	import flash.display.Stage;
	import flash.events.Event;

	//import flash.events.Event;
		
	public class ZIKPLAYER extends Sprite
	{
		private static var m_Stage : Stage;
		private var m_UIMgr:UIManager = null;
		
		public function ZIKPLAYER()
		{
			addEventListener(Event.ADDED_TO_STAGE, OnAddStage);
			m_UIMgr = new UIManager();
		}
		
		private function OnAddStage (event : Event = null) : void
		{
			this.stage.addEventListener (Event.RESIZE, OnResize);
			
			//Init our UI here..
			m_UIMgr.InitUI(this.stage);
		}
		
		private function OnResize (event : Event = null) : void
		{
			//Just the redirection
			m_UIMgr.OnResize (event);
		}
	}
}