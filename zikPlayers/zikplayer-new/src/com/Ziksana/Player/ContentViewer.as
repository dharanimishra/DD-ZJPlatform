package com.ziksana.player
{
	import flash.display.MovieClip;
	import flash.events.EventDispatcher;
	import com.ziksana.content.Content;
	
	public class ContentViewer extends EventDispatcher
	{
		protected var m_Content : Content;
		protected var m_ContentDisplayObject : MovieClip;
		
		public function ContentViewer(contentObj : Content, contentDisplayObject : MovieClip)
		{
			m_Content = contentObj;
			m_ContentDisplayObject = contentDisplayObject;
			RegisterEvents ();
		}
		
		private function RegisterEvents () : void
		{
		}
		
		public function SetCoordinates (width : Number, height : Number) : void
		{
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
		
	}
}