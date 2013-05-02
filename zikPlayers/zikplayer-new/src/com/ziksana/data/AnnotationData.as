package com.ziksana.data
{
	public class AnnotationData
	{
		public var m_AnnotationID : uint;
		public var m_AnnotationText : String;
		public var m_AnnotationTool : uint;
		public var m_ScriptData : String;
		public var m_AnnotationEventData : Array = new Array ();
		
		public function AnnotationData(annotationID : uint, annotationText : String, annotationTool : uint, scriptData : String)
		{
			m_AnnotationID = annotationID;
			m_AnnotationText = annotationText;
			m_AnnotationTool = annotationTool;
			m_ScriptData = scriptData;
		}
		
		public function Add (annotationEventData : AnnotationEventData) : void
		{
			m_AnnotationEventData.push(annotationEventData);
		}
		
		public function Remove (index : Number) : void
		{
			m_AnnotationEventData.splice(index, 1);
		}
	}
}