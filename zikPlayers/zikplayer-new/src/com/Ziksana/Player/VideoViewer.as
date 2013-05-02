package com.ziksana.player
{
	import flash.display.MovieClip;
	import flash.events.MouseEvent;
	import flash.media.Video;

	import com.ziksana.content.Content;
	import com.ziksana.content.VideoContent;
	import com.ziksana.content.VideoRecorder;
	import com.ziksana.events.ZEvent;
	import com.ziksana.events.GlobalEventDispatcher;
	import com.ziksana.util.Logger;

	public class VideoViewer extends ContentViewer
	{
		private var m_VideoContainer : Video = new Video(320, 240);
		private var m_ContentLoadEvent : ZEvent = null;
		private var m_VideoRecorder : VideoRecorder = null;
		//public static const DEFAULT_CONNECTION_URL : String = "rtmp://video.beta.ziksana.com/oflaDemo";
		public static const DEFAULT_CONNECTION_URL : String = "rtmp://54.243.235.88/oflaDemo";
		
		public function VideoViewer(contentObj : Content, contentDisplayObject : MovieClip)
		{
			super(contentObj, contentDisplayObject);
			
			m_VideoRecorder = new VideoRecorder();
			RegisterContentEvents ();
		}
		
		public override function Load () : void
		{
			UpdateUI();
			
			SetContent ();
			//m_Content.Load();
			m_VideoRecorder.Load();
		}
		
		public override function Unload () : void
		{
		}
		
		private function SetContent () : void
		{
			var m_VideoURLArray:Array = new Array ();
			m_VideoURLArray.push(DEFAULT_CONNECTION_URL);

			//m_VideoURLArray.push("http://54.243.235.88/3.flv");
			//m_VideoURLArray.push("d:\\3.flv");
			
			//m_Content.SetContentURL(m_VideoURLArray);
			m_VideoRecorder.SetContentURL(m_VideoURLArray);
		}

		private function UpdateUI():void
		{
			
			m_ContentDisplayObject.addChild(m_VideoContainer);
			
			m_VideoContainer.x = m_Left;
			m_VideoContainer.y = m_Top;
		}
		
		private function RegisterContentEvents () : void
		{
			GlobalEventDispatcher.instance.addGlobalListener(ZEvent.EVENT_CONTENT_VIDEO_LOADED, OnContentLoadEvent);
			m_VideoRecorder.RegisterOnCompletionEvent(ZEvent.EVENT_CONTENT_VIDEO_LOADED);
			//m_Content.RegisterOnCompletionEvent(ZEvent.EVENT_CONTENT_VIDEO_LOADED);
			
			m_ContentDisplayObject.addEventListener (MouseEvent.MOUSE_DOWN, OnPageContainerMouseDown);
			m_ContentDisplayObject.addEventListener (MouseEvent.MOUSE_MOVE, OnPageContainerMouseMove);
			m_ContentDisplayObject.addEventListener (MouseEvent.MOUSE_UP, OnPageContainerMouseUp);
			m_ContentDisplayObject.addEventListener (MouseEvent.MOUSE_OUT, OnPageContainerMouseUp);
		}
		
		
		public function OnContentLoadEvent (contentLoadEvent : ZEvent) : void
		{
			m_VideoRecorder.AttachStreamOutputContainer(m_VideoContainer);
			
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