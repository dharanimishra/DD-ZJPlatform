package com.ziksana.application
{
	import com.ziksana.events.GlobalEventDispatcher;
	import com.ziksana.events.ZEvent;
	import com.ziksana.ui.UIManager;
	
	import flash.display.Sprite;
	import flash.display.Stage;
	import flash.events.Event;
		
	public class ZIKPLAYER extends Sprite
	{
		private static var m_Stage : Stage;
		private var m_UIManager : UIManager = null;
		private var m_ApplicationConfiguration : ApplicationConfiguration = null;
		private var m_ApplicationStage : Number = ApplicationState.APP_STATE_STARTED;
		private static const DEFAULT_CONFIGURATION_FILE_URL : String = "http://54.243.235.88/configuration.xml";
		
		public function ZIKPLAYER()
		{
			m_ApplicationConfiguration = new ApplicationConfiguration (DEFAULT_CONFIGURATION_FILE_URL);
			GlobalEventDispatcher.instance.addGlobalListener(ZEvent.EVENT_CONFIGURATION_LOADED, OnConfigurationLoaded);

			addEventListener(Event.ADDED_TO_STAGE, OnAddedToStage);
		}
		
		private function OnConfigurationLoaded (zEvent:ZEvent):void
		{
			if (zEvent.GetEventName() == ZEvent.EVENT_CONFIGURATION_LOADED)
			{
				m_ApplicationStage += ApplicationState.APP_STATE_CONFIGURED;
				m_UIManager = new UIManager(m_ApplicationConfiguration.AnnotatorFile);		
				m_UIManager.Init(this.stage);
			}
		}
		
		private function OnAddedToStage (event : Event = null) : void
		{
			this.stage.addEventListener (Event.RESIZE, OnResize);
			m_ApplicationConfiguration.Load();
		}
		
		private function OnResize (event : Event = null) : void
		{
			m_UIManager.OnResize (event);
		}
		
		public function get AppConfiguration () : ApplicationConfiguration
		{
			return m_ApplicationConfiguration;
		}
	}
}