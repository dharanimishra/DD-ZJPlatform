package com.ziksana.events
{
	public class EventsList
	{
		public static const CONTENT_TYPE_IMAGE_LOAD:String = "ON_CONTENT_TYPE_IMAGE_LOAD";
		public static const CONTENT_TYPE_VIDEO_LOAD:String = "ON_CONTENT_TYPE_VIDEO_LOAD";
		public static const CONTENT_TYPE_VIDEO_RECORD:String = "ON_CONTENT_TYPE_VIDEO_RECORD";
		
		public static const VIDEO_CONNECTION_EVENT:String = "ON_VIDEO_CONNECTION";
		public static const VIDEO_STREAM_CONNECTION_EVENT:String = "ON_VIDEO_STREAM_CONNECTION";
		
		public static const XML_LOAD_EVENT:String = "ON_XML_LOAD";
		
		public static const CONTENT_TYPE_UNKNOWN:int = 0;
		public static const CONTENT_TYPE_DOCUMENT:int = 1; 
		public static const CONTENT_TYPE_VIDEO:int = 2;
		public static const CONTENT_TYPE_SCRIBBLEDATA:int = 3;
		public static const CONTENT_TYPE_USERDATA:int = 4;
		
		public function EventsList()
		{
		}
	}
}