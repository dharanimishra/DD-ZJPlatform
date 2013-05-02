package com.ziksana.data
{
	public class EnhanceData
	{
		public var m_ContentType : uint;
		public var m_ContentURL : String;
		public var m_NumContentPages : Number;
		public var m_VideoFileURL : String;
		public var m_VideoFileDuration : Number;
		
		public var m_ContentPageDataList : Array = new Array ();
		
		public function EnhanceData(contentType : uint, contentURL : String, numContentPages : Number, videoFileURL : String, 
									videoFileDuration : Number)
		{
			m_ContentType = contentType;
			m_ContentURL = contentURL;
			m_NumContentPages = numContentPages;
			m_VideoFileURL = videoFileURL;
			m_VideoFileDuration = videoFileDuration;
		}
		
		public function Add (contentPageData : ContentPageData) : void
		{
			m_ContentPageDataList.push(contentPageData);
		}
		
		public function Remove (index : Number) : void
		{
			m_ContentPageDataList.splice(index, 1);
		}
	}
}