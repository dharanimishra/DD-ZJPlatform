package com.ziksana.ui
{
	import com.ziksana.events.CustomEvent;
	import com.ziksana.events.EventsList;
	import com.ziksana.util.Logger;
	
	import flash.display.Sprite;
	import flash.display.Stage;
	import flash.events.Event;
		
	public class ZIKPLAYER extends Sprite
	{
		private static var m_Stage : Stage;
		private var m_UIManager : UIManager = null;
		private var m_Configuration : Configuration = null;
		private var m_XMLLoadEvent : CustomEvent = null;
		
		public function ZIKPLAYER()
		{
			addEventListener(Event.ADDED_TO_STAGE, OnAddStage);
			m_Configuration = new Configuration (this);
			m_UIManager = new UIManager();
		}
		
		private function OnAddStage (event : Event = null) : void
		{
			this.stage.addEventListener (Event.RESIZE, OnResize);
			
			registerOnCompletionEvent();
			m_Configuration.load();
			
			//Init our UI here..
			m_UIManager.Init(this.stage);
		}
		
		private function OnResize (event : Event = null) : void
		{
			//Just the redirection
			m_UIManager.OnResize (event);
		}
		
		public function registerOnCompletionEvent () : void
		{
			addEventListener(EventsList.XML_LOAD_EVENT, OnXMLLoadCompletion);
			m_XMLLoadEvent = new CustomEvent(EventsList.XML_LOAD_EVENT, this, this);
			m_Configuration.registerOnCompletionEvent(m_XMLLoadEvent);
		}
		
		public function OnXMLLoadCompletion (xmlEvent : CustomEvent) : void
		{
			Logger.instance.WriteMessage("XML Loaded successfully");
		}
	}
}