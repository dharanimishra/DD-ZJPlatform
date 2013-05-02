package com.ziksana.data
{
	public class AnnotationEventData
	{
		public static const ANOTATION_EVENT_MOUSE_DOWN : uint = 0;
		public static const ANNOTATION_EVENT_MOUSE_MOVE : uint = 1;
		public static const ANNOTATION_EVENT_MOUSE_UP : uint = 2;
		public static const ANNOTATION_EVENT_ZOOM_IN : uint = 3;
		public static const ANNOTATION_EVENT_ZOOM_OUT : uint = 4;
		
		public var m_EventType: uint;
		public var m_EventX : Number;
		public var m_EventY : Number;
		public var m_CtrlKeyPressed : Boolean;
		public var m_ScribbleTool : uint;
		public var m_EventTime : Number;
		
		public function AnnotationEventData (eventType : uint,  xLocation : Number,  yLocation : Number, ctrlKeyPressed : Boolean, scribbleTool : uint, eventTime : Number)
		{
			m_EventType = eventType;
			m_EventX = xLocation;
			m_EventY = yLocation;
			m_CtrlKeyPressed = ctrlKeyPressed;
			m_ScribbleTool = scribbleTool;
			m_EventTime = eventTime;			
		}
	}
}