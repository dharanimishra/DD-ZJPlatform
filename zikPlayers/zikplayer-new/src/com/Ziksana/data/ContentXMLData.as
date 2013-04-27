package com.ziksana.data
{
	import com.ziksana.events.EventData;
	
	public class ContentXMLData
	{
		private var m_StartTime : Number;
		private var m_TotalTime : Number;

		private var m_ImagePath : String;
		private var m_NumberOfImages : Number;
		
		private var m_StartSlideNumber : Number;
		
		private var m_NumberOfVideos : Number;
		private var m_NumberOfRecordedEvents : Number;
		
		private var m_EventsList:Array = new Array();
		private var m_VideoFileList:Array = new Array();
		protected var m_VideoEndTimesList:Array = new Array();
		
		public function ContentXMLData()
		{
		}
		
		public function GetStartTime () : Number
		{
			return m_StartTime;
		}
		
		public function SetStartTime (timeToSet : Number):void
		{
			m_StartTime = timeToSet;
		}
		
		public function GetTotalTime () : Number
		{
			return m_TotalTime;
		}
		
		public function SetTotalTime (timeToSet : Number):void
		{
			m_TotalTime = timeToSet;
		}
		
		public function GetImagePath () : String
		{
			return m_ImagePath;
		}
		
		public function SetImagePath (imagePath : String):void
		{
			m_ImagePath = imagePath;
		}
		
		public function GetNumberOfImages () : Number
		{
			return m_NumberOfImages;
		}
		
		public function SetNumberOfImages (numberOfImages : Number):void
		{
			m_NumberOfImages = numberOfImages;
		}
		
		public function GetStartSlideNumber () : Number
		{
			return m_StartSlideNumber;
		}
		
		public function SetStartSlideNumber (startSlideNumber : Number):void
		{
			m_StartSlideNumber = startSlideNumber;
		}
		
		public function GetNumberOfVideos () : Number
		{
			return m_NumberOfVideos;
		}
		
		public function SetNumberOfVideos (numberOfVideos : Number):void
		{
			m_NumberOfVideos = numberOfVideos;
		}
		
		public function GetNumberOfRecordedEvents () : Number
		{
			return m_NumberOfRecordedEvents;
		}
		
		public function SetNumberOfRecordedEvents (recordedEvents : Number):void
		{
			m_NumberOfRecordedEvents = recordedEvents;
		}
		
		public function GetVideoListData (videoIndex : Number) : String
		{
			if (videoIndex < m_VideoFileList.length)
				return m_VideoFileList[videoIndex];

			return null;
		}
		
		public function AddToVideoList (videoName : String) : void
		{
			m_VideoFileList[m_VideoFileList.length] = videoName;
		}
		
		public function GetVideoEndTime (videoETIndex : Number) : Number
		{
			if (videoETIndex < m_VideoEndTimesList.length)
				return m_VideoEndTimesList[videoETIndex];

			return null;
		}
		
		public function AddVideoEndTime (endTIme : Number) : void
		{
			m_VideoEndTimesList[m_VideoEndTimesList.length] = endTIme;
		}
		
		public function GetEvent (eventIndex : Number) : EventData 
		{
			if (eventIndex < m_EventsList.length)
				return m_EventsList[eventIndex] as EventData;
			
			return null;
		}

		public function AddEventToList (eventData : EventData) : void 
		{
			m_EventsList[m_EventsList.length] = eventData;
		}
	}
}