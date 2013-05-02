package com.ziksana.data
{
	public class ContentPageData
	{
		public var m_PageID : uint;
		public var m_PageURL : String;
		public var m_PageAnnotationData : Array = new Array ();
		public function ContentPageData(pageID : uint, pageURL : String)
		{
			m_PageID = pageID;
			m_PageURL = pageURL;
		}
		
		public function Add (annotationData : AnnotationData) : void
		{
			m_PageAnnotationData.push(annotationData);
		}
		
		public function Remove (index : Number) : void
		{
			m_PageAnnotationData.splice(index, 1);
		}
	}
}