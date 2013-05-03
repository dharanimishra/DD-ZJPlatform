package com.ziksana.player
{
	import flash.display.MovieClip;
	import flash.events.MouseEvent;
	import flash.media.Video;

	import com.ziksana.content.Content;
	import com.ziksana.content.VideoContent;
	import com.ziksana.recorder.CameraRecorder;
	import com.ziksana.events.ZEvent;
	import com.ziksana.events.GlobalEventDispatcher;
	import com.ziksana.util.Logger;

	public class VideoViewer extends ContentViewer
	{
		private var m_VideoContainer : Video = null;
		private var m_ContentLoadEvent : ZEvent = null;
		
		public function VideoViewer(contentObj : Content, contentDisplayObject : MovieClip)
		{
			super(contentObj, contentDisplayObject);
			
			//m_VideoContainer = new Video(contentDisplayObject.width as int, contentDisplayObject.height as int);
			RegisterContentEvents ();
		}
		
		public override function Load () : void
		{
			//m_Content.Load();
		}
		
		public override function Unload () : void
		{
		}
		
		
		private function RegisterContentEvents () : void
		{
			//m_Content.RegisterOnCompletionEvent(ZEvent.EVENT_CONTENT_VIDEO_LOADED);
			
			m_ContentDisplayObject.addEventListener (MouseEvent.MOUSE_DOWN, OnPageContainerMouseDown);
			m_ContentDisplayObject.addEventListener (MouseEvent.MOUSE_MOVE, OnPageContainerMouseMove);
			m_ContentDisplayObject.addEventListener (MouseEvent.MOUSE_UP, OnPageContainerMouseUp);
			m_ContentDisplayObject.addEventListener (MouseEvent.MOUSE_OUT, OnPageContainerMouseUp);
		}
		
		
		public function OnContentLoadEvent (contentLoadEvent : ZEvent) : void
		{
			//VideoContent(m_Content).AttachStreamOutputContainer(m_VideoContainer);
			//VideoContent(m_Content).StartPlayback();
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