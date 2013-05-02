package com.ziksana.content
{
	public class ScribbleRecorder implements ContentGenerator
	{
		private var m_ScribbleContent : VideoContent = null;
		private var m_ScribbleData : Array = new Array ();
		
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