package com.ziksana.recorder
{
	import com.ziksana.content.Content;
	
	import flash.display.MovieClip;

	public class ContentRecorder
	{
		protected var m_ContentDisplayObject : MovieClip;
		protected var m_Top : Number = 0;
		protected var m_Left : Number = 0;
		protected var m_Width : Number = 0;
		protected var m_Height : Number = 0;
		
		public function ContentRecorder(contentDisplayObject : MovieClip)
		{
			m_ContentDisplayObject = contentDisplayObject;
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
			return null;
		}
		
		public function SetVisible (visible : Boolean) : void
		{
		}
		
		public function SetCoordinates (left: Number, top : Number, width : Number, height : Number) : void
		{
			m_Left = left;
			m_Top = top;
			m_Width = width;
			m_Height = height;
		}

		public function RegisterOnCompletionEvent (eventName : String) : void
		{
		}
	}
}