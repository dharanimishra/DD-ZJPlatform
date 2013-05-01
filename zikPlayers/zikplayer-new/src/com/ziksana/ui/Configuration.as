package com.ziksana.ui
{
	import com.ziksana.events.CustomEvent;
	import com.ziksana.events.EventsList;
	import com.ziksana.util.Logger;
	import com.ziksana.util.XMLUtil;
	
	import flash.events.EventDispatcher;

	public class Configuration extends EventDispatcher
	{
		private var m_XML : XMLUtil = null;
		private var m_Parent : Object = null;
		private var m_XMLLoadEvent : CustomEvent = null;

		public static const DEFAULT_CONFIGURATION_FILE_URL : String = "http://54.243.235.88/configuration.xml";
		
		public function Configuration(parentObj : Object)
		{
			m_XML = new XMLUtil(XMLUtil.TYPE_HTTP, DEFAULT_CONFIGURATION_FILE_URL);
			m_Parent = parentObj;
		}
		
		public function registerOnCompletionEvent (xmlLoadEvent : CustomEvent) : void
		{
			m_XMLLoadEvent = xmlLoadEvent;
		}
		
		public function load() : void
		{
			if (m_XML)
			{
				m_XML.registerOnCompletionEvent(m_XMLLoadEvent);
				m_XML.loadAndParse();
			}
		}
	}
}