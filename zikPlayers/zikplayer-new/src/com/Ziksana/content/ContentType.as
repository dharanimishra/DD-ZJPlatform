package com.ziksana.content
{
	public final class ContentType
	{
		public static const CONTENT_TYPE_UNKNOWN:int = 0;
		public static const CONTENT_TYPE_DOCUMENT:int = 1; 
		public static const CONTENT_TYPE_VIDEO:int = 2;
		public static const CONTENT_TYPE_SCRIBBLEDATA:int = 3;
		public static const CONTENT_TYPE_USERDATA:int = 4;
		
		
		public static const CONTENT_TYPE_UNKNOWN_STRING : String = "";
		public static const CONTENT_TYPE_DOCUMENT_STRING : String = "Document";
		public static const CONTENT_TYPE_VIDEO_STRING : String = "Video";
		public static const CONTENT_TYPE_SCRIBBLEDATA_STRING : String = "ScribbleData";
		public static const CONTENT_TYPE_USERDATA_STRING : String = "UserData";
		
		
		public function ContentType(contentType:int)
		{
			
		}
	}
}