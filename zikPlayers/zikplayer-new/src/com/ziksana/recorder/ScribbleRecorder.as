package com.ziksana.recorder
{
	import com.ziksana.content.Content;
	import com.ziksana.content.ScribbleContent;
	import com.ziksana.data.EnhanceData;
	import com.ziksana.data.AnnotationEventData;

	public class ScribbleRecorder implements ContentGenerator
	{
		private var m_ScribbleContent : ScribbleContent = null;
		private var m_SelectedScribbleTool : uint = 0;
		private var m_EnhanceData : EnhanceData = null;
		private var m_VideoFileURL : String = null;
		private var m_VideoFileDuration : Number = 0;
		
		
		public function ScribbleRecorder()
		{
		}
		
		public function Load () : Boolean
		{
			return true;
		}
		
		public function Unload () : void
		{
		}
		
		private function SetEnhanceData () : void
		{
			//Todo : Need to set number of pages here (should be equal to document pages)
			
			//Todo : Need to set position here.
			//Todo : Need to pass the video file url and duration too
			
			/*m_EnhanceData = new EnhanceData(m_ScribbleContent.GetContentType(),
				m_ScribbleContent.GetContentURL(0),
				m_ScribbleContent.GetNumberOfPosition(),
				m_VideoFileURL, m_VideoFileDuration);
			*/
			
			//m_EnhanceData.Add();
		}
		
		
		private function AddAnnotationEvent (eventType : uint, xLocation : Number, yLocation : Number, ctrlKeyPressed : Boolean) : void
		{
			var eventTime : Number = 0;
			var annotationEventData : AnnotationEventData;
			annotationEventData = new AnnotationEventData (eventType, xLocation, yLocation, ctrlKeyPressed, eventTime, m_SelectedScribbleTool);
		}
		
		
		public function GetContent () : Content
		{
			return m_ScribbleContent;
		}
		
		public function RegisterOnCompletionEvent (eventName : String) : void
		{
		}
		
		private function GenerateXML (xmlFileName : String) : Boolean
		{
			return true;
		}
		
	}
}