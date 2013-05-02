package com.ziksana.ui
{
	import com.ziksana.events.GlobalEventDispatcher;
	import com.ziksana.events.ZEvent;
	import com.ziksana.util.XMLUtil;
	import flash.display.MovieClip;
	import flash.events.EventDispatcher;

	public class Configuration extends MovieClip
	{
		private var m_XMLUtil : XMLUtil = null;
		private var m_Parent : Object = null;
		private var m_XMLLoadEvent : ZEvent = null;
		private var m_UIConfigurationFileURL:String = null;

		public static const DEFAULT_CONFIGURATION_FILE_URL : String = "http://54.243.235.88/configuration.xml";
		
		public function Configuration(parentObj : Object)
		{
			m_XMLUtil = new XMLUtil(XMLUtil.TYPE_HTTP, DEFAULT_CONFIGURATION_FILE_URL);
			m_Parent = parentObj;
		}
		
		public function load() : void
		{
			if (m_XMLUtil)
			{
				//this.addEventListener(ZEvent.EVENT_CONFIGURATION_XML_PARSED, onConfigurationLoaded);
				GlobalEventDispatcher.instance.addGlobalListener(ZEvent.EVENT_CONFIGURATION_XML_PARSED, onConfigurationLoaded);
				m_XMLUtil.setCompletionEvent(ZEvent.EVENT_CONFIGURATION_XML_PARSED);
				m_XMLUtil.loadAndParse();
			}
		}
		
		private function onConfigurationLoaded (zEvent:ZEvent):void
		{
			var configurationFile:Object = m_XMLUtil.GetXMLParsedData();
			
			m_UIConfigurationFileURL = configurationFile.SKIN.ANNOTATOR_THEME;
			GlobalEventDispatcher.instance.dispatch(new ZEvent(ZEvent.EVENT_CONFIGURATION_LOADED,null));
		}
		
		public function set uiConfigurationURL(uiConfigurationFileURL:String):void 
		{
			m_UIConfigurationFileURL = uiConfigurationFileURL;
		}
		
		public function get uiConfigurationURL():String 
		{
			return m_UIConfigurationFileURL;
		}
	}
}