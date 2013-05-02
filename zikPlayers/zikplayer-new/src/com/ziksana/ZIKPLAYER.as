package com.ziksana
{
	import com.ziksana.events.GlobalEventDispatcher;
	import com.ziksana.events.ZEvent;
	import com.ziksana.ui.Configuration;
	import com.ziksana.ui.UIManager;
	import com.ziksana.util.Logger;
	
	import flash.display.Sprite;
	import flash.display.Stage;
	import flash.events.Event;
	
		
	public class ZIKPLAYER extends Sprite
	{
		private static var m_Stage : Stage;
		private var m_UIManager : UIManager = null;
		private var m_Configuration : Configuration = null;
		private var m_XMLLoadEvent : ZEvent = null;
		private var m_AppState:Number = ApplicationState.APP_STATE_STARTED;
		
		public function ZIKPLAYER()
		{
			m_Configuration = new Configuration (this);
			GlobalEventDispatcher.instance.addGlobalListener(ZEvent.EVENT_CONFIGURATION_LOADED, onConfigurationLoaded);
			//
			// Know the contents.
			addEventListener(Event.ADDED_TO_STAGE, onAddedToStage);
		}
		
		private function onConfigurationLoaded (zEvent:ZEvent):void
		{
			if (zEvent.GetEventName() == ZEvent.EVENT_CONFIGURATION_LOADED)
			{
				m_AppState += ApplicationState.APP_STATE_CONFIGURED;
				m_UIManager = new UIManager(m_Configuration.uiConfigurationURL);		
				m_UIManager.Init(this.stage);
			}
		}
		
		private function onAddedToStage (event : Event = null) : void
		{
			this.stage.addEventListener (Event.RESIZE, OnResize);
			m_Configuration.load();
		}
		
		private function OnResize (event : Event = null) : void
		{
			//Just the redirection
			m_UIManager.OnResize (event);
		}
	}
}