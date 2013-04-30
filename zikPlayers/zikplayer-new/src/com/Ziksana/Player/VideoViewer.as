package com.ziksana.player
{
	import com.ziksana.content.Content;
	import com.ziksana.content.VideoContent;
	import com.ziksana.events.CustomEvent;
	import com.ziksana.util.Logger;
	
	import flash.display.MovieClip;
	import flash.events.MouseEvent;
	import flash.media.Video;

	public class VideoViewer extends ContentViewer
	{
		public var m_VideoContainer : Video = new Video();
		private var m_ContentLoadEvent : CustomEvent = null;
		private static const ContentLoadEvent:String = "ON_VIDEO_CONTENT_LOAD";
		
		public function VideoViewer(contentObj : Content, contentDisplayObject : MovieClip)
		{
			super(contentObj, contentDisplayObject);
			
			RegisterContentEvents ();
		}
		
		public override function Load () : void
		{
			//m_Content.Load("http://54.243.235.88/1.flv");
			//m_Content.Load("http://54.243.235.88/Real Madrid HD.mp4");
			m_Content.Load("http://54.243.235.88/3.flv");
			//m_Content.Load("d:\\3.flv");
		}
		
		public override function Unload () : void
		{
		}

		private function UpdateUI():void
		{
			m_ContentDisplayObject.graphics.clear();
			m_ContentDisplayObject.graphics.beginFill(0x999999, 0.8);
			m_ContentDisplayObject.graphics.drawRoundRectComplex(m_Left, m_Top, m_Width, m_Height, 0, 0, 0, 0);
			
			m_VideoContainer.x = m_Left;
			m_VideoContainer.y = m_Top;
			
			m_ContentDisplayObject.graphics.endFill();
			
			m_ContentDisplayObject.addChild(m_VideoContainer);
		}
		
		private function RegisterContentEvents () : void
		{
			addEventListener(ContentLoadEvent, OnContentLoadEvent);
			m_ContentLoadEvent = new CustomEvent(ContentLoadEvent, this, this);
			m_Content.RegisterOnCompletionEvent(m_ContentLoadEvent);
			
			m_ContentDisplayObject.addEventListener (MouseEvent.MOUSE_DOWN, OnPageContainerMouseDown);
			m_ContentDisplayObject.addEventListener (MouseEvent.MOUSE_MOVE, OnPageContainerMouseMove);
			m_ContentDisplayObject.addEventListener (MouseEvent.MOUSE_UP, OnPageContainerMouseUp);
			m_ContentDisplayObject.addEventListener (MouseEvent.MOUSE_OUT, OnPageContainerMouseUp);
		}
		
		
		public function OnContentLoadEvent (contentLoadEvent : CustomEvent) : void
		{
			var param : Object = contentLoadEvent.GetEventParam();
			
			UpdateUI();
			VideoContent(m_Content).AttachStreamOutputContainer(m_VideoContainer);
			VideoContent(m_Content).StartPlayback();
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
	}
}