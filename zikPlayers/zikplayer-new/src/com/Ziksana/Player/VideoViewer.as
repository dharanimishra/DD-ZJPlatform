package com.ziksana.player
{
	import com.ziksana.content.Content;
	import com.ziksana.content.VideoContent;
	import com.ziksana.content.VideoRecorder;
	import com.ziksana.events.CustomEvent;
	import com.ziksana.events.EventsList;
	import com.ziksana.util.Logger;
	
	import flash.display.MovieClip;
	import flash.events.MouseEvent;
	import flash.media.Video;

	public class VideoViewer extends ContentViewer
	{
		private var m_VideoContainer : Video = new Video();
		private var m_ContentLoadEvent : CustomEvent = null;
		private var m_VideoRecorder : VideoRecorder = null;
		
		public function VideoViewer(contentObj : Content, contentDisplayObject : MovieClip)
		{
			super(contentObj, contentDisplayObject);
			
			m_VideoRecorder = new VideoRecorder();
			RegisterContentEvents ();
		}
		
		public override function Load () : void
		{
			//SetContent ();
			//m_Content.Load();
			m_VideoRecorder.Load();
		}
		
		public override function Unload () : void
		{
		}
		
		private function SetContent () : void
		{
			var m_VideoURLArray:Array = new Array ();

			m_VideoURLArray.push("http://54.243.235.88/3.flv");
			
			m_Content.SetContentURL(m_VideoURLArray);
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
			addEventListener(EventsList.CONTENT_TYPE_VIDEO_LOAD, OnContentLoadEvent);
			m_ContentLoadEvent = new CustomEvent(EventsList.CONTENT_TYPE_VIDEO_LOAD, this, this);
			
			m_VideoRecorder.RegisterOnCompletionEvent(m_ContentLoadEvent);
			//m_Content.RegisterOnCompletionEvent(m_ContentLoadEvent);
			
			m_ContentDisplayObject.addEventListener (MouseEvent.MOUSE_DOWN, OnPageContainerMouseDown);
			m_ContentDisplayObject.addEventListener (MouseEvent.MOUSE_MOVE, OnPageContainerMouseMove);
			m_ContentDisplayObject.addEventListener (MouseEvent.MOUSE_UP, OnPageContainerMouseUp);
			m_ContentDisplayObject.addEventListener (MouseEvent.MOUSE_OUT, OnPageContainerMouseUp);
		}
		
		
		public function OnContentLoadEvent (contentLoadEvent : CustomEvent) : void
		{
			var param : Object = contentLoadEvent.GetEventParam();
			
			UpdateUI();
			
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