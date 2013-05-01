package com.ziksana.player
{
	import com.ziksana.content.Content;
	
	import flash.display.MovieClip;
	import flash.events.EventDispatcher;
	
	public class ContentViewer extends EventDispatcher
	{
		protected var m_Content : Content;
		protected var m_ContentDisplayObject : MovieClip;
		protected var m_Top : Number = 0;
		protected var m_Left : Number = 0;
		protected var m_Width : Number = 0;
		protected var m_Height : Number = 0;
		
		public function ContentViewer(contentObj : Content, contentDisplayObject : MovieClip)
		{
			m_Content = contentObj;
			m_ContentDisplayObject = contentDisplayObject;
			RegisterEvents ();
		}
		
		public function RegisterEvents () : void
		{
		}
		
		public function Load () : void
		{
		}
		
		public function Unload () : void
		{
		}

		public function SetCoordinates (left: Number, top : Number, width : Number, height : Number) : void
		{
			m_Left = left;
			m_Top = top;
			m_Width = width;
			m_Height = height;
		}
		
		public function MoveToPreviousPosition () : void		
		{
			m_Content.SetCurrentPosition (m_Content.GetCurrentPosition() - 1);
		}
		
		public function MoveToNextPosition () : void
		{
			m_Content.SetCurrentPosition (m_Content.GetCurrentPosition() + 1);
		}
		
		public function MoveToFirstPosition () : void
		{
			m_Content.SetCurrentPosition (0);
		}
		
		public function MoveToLastPosition () : void
		{
			m_Content.SetCurrentPosition (m_Content.GetCurrentPosition() - 1);
		}
		
		public function SetVisible (visible : Boolean) : void
		{
		}
	}
}