package com.ziksana.events
{
	import flash.events.Event;
	import flash.events.EventDispatcher;
	
	public class ZEvent extends Event
	{
		private var m_EventNameToRegister : String;
		private var m_EventParam : Object;
		
		//EVENT CONTENT
		public static const EVENT_CONTENT_IMAGE_LOADED :String = "EVENT_CONTENT_IMAGE_LOADED";
		public static const EVENT_CONTENT_VIDEO_LOADED : String = "EVENT_CONTENT_VIDEO_LOADED";
		public static const EVENT_VIDEO_RECORD_STARTED : String = "EVENT_VIDEO_RECORD_STARTED";
		
		//VIDEO CONNECTION EVENTS
		public static const EVENT_VIDEO_SERVER_CONNECTED :String = "EVENT_VIDEO_SERVER_CONNECTED";
		public static const EVENT_VIDEO_STREAM_CONNECTED :String = "EVENT_VIDEO_STREAM_CONNECTED";
		
		
		//CONFIGURATION EVENTS
		public static const EVENT_CONFIGURATION_LOADED:String = "EVENT_CONFIGURATION_LOADED";
		
		//XML EVENTS
		public static const EVENT_XML_LOAD:String = "EVENT_XML_LOAD";
		public static const EVENT_CONFIGURATION_XML_PARSED:String = "EVENT_CONFIGURATION_XML_PARSED";
		public static const EVENT_ANNOTATOR_UI_XML_PARSED:String = "EVENT_ANNOTATOR_UI_XML_PARSED";
		
		public function ZEvent(eventNameToRegister : String, eventParam : Object = null)
		{
			super(eventNameToRegister, false, false);
			
			m_EventNameToRegister = eventNameToRegister;
			m_EventParam = eventParam;
		}
		
		public function GetEventName () : String
		{
			return m_EventNameToRegister;
		}
		
		public function GetEventParam () : Object
		{
			return m_EventParam;
		}
	}
}