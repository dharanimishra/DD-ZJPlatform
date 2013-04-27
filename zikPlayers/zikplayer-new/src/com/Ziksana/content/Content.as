package com.ziksana.content
{
	import com.ziksana.events.CustomEvent;
	import com.ziksana.timeline.ITimeLinePosition;

	public class Content implements ITimeLinePosition
	{
		protected var m_ContentID : int;
		protected var m_ContentDescription : String;
		protected var m_ContentType : int;
		
		//Content specific
		protected var m_CurrentPosition : Number;
		protected var m_NumberOfPosition : Number;
		protected var m_CurrentTimeStamp : Number;
		protected var m_ContentLoadEvent : CustomEvent = null;

		//Todo : Need to see what type could be declared here.
		//m_ContentConfiguration : Object;
		
				
		public function Content()
		{
			m_ContentID = 0;
			m_ContentDescription = "";
			
			m_ContentType = ContentType.CONTENT_TYPE_UNKNOWN;
			m_CurrentPosition = 0;
			m_NumberOfPosition = 0;
			m_CurrentTimeStamp = 0;
			
		}
		
		public function Load(contentURL : String) : Boolean
		{
			return true;
		}
		
		public function Unload () : void
		{
		}
		
		public function GetContentID () : int
		{
			return m_ContentID;
		}
		
		public function SetContentID (contentID : int) : void
		{
			//Has to be set by the caller
			m_ContentID = contentID;
		}

		public function GetContentType () : int
		{
			return m_ContentType;
		}
		
		protected function SetContentType (contentType : int) : void
		{
			m_ContentType = contentType;
		}
		
		public function GetContentDescription () : String
		{
			return m_ContentDescription;
		}
		
		protected function SetContentDescription (contentDescription : String) : void
		{
			m_ContentDescription = contentDescription;
		}
		
		public function GetData () : Object
		{
			return null;
		}
		
		//POSITION STUFF
		public function GetNumberOfPosition () : Number
		{
			return 0;
		}
		
		public function SetNumberOfPosition (numberOfPosition : Number) : void
		{
		
		}
		
		public function GetCurrentPosition () : Number
		{
			return 0;			
		}
		
		public function SetCurrentPosition (currentPosition : Number) : void
		{
		}
		
		public function RegisterOnCompletionEvent (contentLoadEvent : CustomEvent) : void
		{
			m_ContentLoadEvent = contentLoadEvent;
		}
		
	}
}