package com.ziksana.player
{
	import com.ziksana.content.Content;
	import com.ziksana.events.CustomEvent;
	
	import flash.display.MovieClip;
	import flash.events.MouseEvent;

	public class VideoViewer extends ContentViewer
	{
		private var m_VideoContainer : MovieClip = new MovieClip();
		private var m_ContentLoadEvent : CustomEvent = null;
		private static const ContentLoadEvent:String = "ON_VIDEO_CONTENT_LOAD";
		
		public function VideoViewer(contentObj : Content, contentDisplayObject : MovieClip)
		{
			super(contentObj, contentDisplayObject);
			
			m_ContentDisplayObject.addChild(m_VideoContainer);
			RegisterContentEvents ();
			m_Content.Load("http://54.243.235.88/1.flv");
		}
		
		
		private function RegisterContentEvents () : void
		{
			addEventListener(ContentLoadEvent, OnContentLoadEvent);
			m_ContentLoadEvent = new CustomEvent(ContentLoadEvent, this, this);
			m_Content.RegisterOnCompletionEvent(m_ContentLoadEvent);
			
			m_VideoContainer.addEventListener (MouseEvent.MOUSE_DOWN, OnPageContainerMouseDown);
			m_VideoContainer.addEventListener (MouseEvent.MOUSE_MOVE, OnPageContainerMouseMove);
			m_VideoContainer.addEventListener (MouseEvent.MOUSE_UP, OnPageContainerMouseUp);
			m_VideoContainer.addEventListener (MouseEvent.MOUSE_OUT, OnPageContainerMouseUp);
		}
		
		
		public function OnContentLoadEvent (contentLoadEvent : CustomEvent) : void
		{
			var param : Object = contentLoadEvent.GetEventParam();
		}
		
		private function OnPageContainerMouseDown (mouseEvent : MouseEvent) : void 
		{
			//Logger.WriteMessage("DocumentViewer::OnMouseDown ==> " + "X = " + mouseEvent.localX + "Y = " + mouseEvent.localY); 
		}
		
		private function OnPageContainerMouseUp (mouseEvent : MouseEvent) : void 
		{
			//Logger.WriteMessage("DocumentViewer::OnMouseUp ==> " + "X = " + mouseEvent.localX + "Y = " + mouseEvent.localY);
		}
		
		private function OnPageContainerMouseMove (mouseEvent : MouseEvent) : void 
		{
			//Logger.WriteMessage("DocumentViewer::OnMouseMove ==> " + "X = " + mouseEvent.localX + "Y = " + mouseEvent.localY);
		}
		
		
		public override function SetCoordinates (width : Number, height : Number) : void
		{
			
		}
	}
}