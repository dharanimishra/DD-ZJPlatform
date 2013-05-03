package com.ziksana.recorder
{
	import com.ziksana.application.ApplicationConfiguration;
	import com.ziksana.application.ZIKPLAYER;
	import com.ziksana.connection.ConnectionFactory;
	import com.ziksana.connection.ConnectionType;
	import com.ziksana.connection.IConnection;
	import com.ziksana.connection.StreamSourceType;
	import com.ziksana.content.Content;
	import com.ziksana.content.VideoContent;
	import com.ziksana.events.GlobalEventDispatcher;
	import com.ziksana.events.ZEvent;
	import com.ziksana.util.Logger;
	import com.ziksana.util.Util;
	
	import flash.display.MovieClip;
	import flash.media.Camera;
	import flash.media.Microphone;
	import flash.media.Video;

	public class CameraRecorder extends ContentRecorder
	{
		private var m_Container : Video = null;
		private var m_Connection : IConnection;
		
		private var m_VideoContent : VideoContent = null;
		private var m_VideoCamera : Camera = null;
		private var m_Microphone : Microphone = null;
		
		private var m_VideoConnectionParentNotifyEvent : String = null;
		
		public static const DEFAULT_CONNECTION_URL : String = "rtmp://54.243.235.88/oflaDemo";

		
		public function CameraRecorder(contentDisplayObject : MovieClip)
		{
			super (contentDisplayObject);
			
			m_VideoContent = new VideoContent();
			m_VideoCamera = Camera.getCamera();
			m_Microphone = Microphone.getMicrophone();
			
			//For now use best quality and 320, 240 resolution
			m_VideoCamera.setQuality(0, 100);
			
			//m_VideoCamera.setMode(contentDisplayObject.width as int, contentDisplayObject.height as int, 30);
			//m_Container = new Video(contentDisplayObject.width as int, contentDisplayObject.height as int);
			m_Container = new Video(160, 120);
			m_VideoCamera.setMode(160, 120, 30);
		}

		private function SetContent () : void
		{
			//var appConfigration : ApplicationConfiguration;
			//var rtmpHost : String = ZIKPLAYER.
			
			//Test code
			var m_VideoURLArray:Array = new Array ();
			m_VideoURLArray.push(DEFAULT_CONNECTION_URL);
			
			//m_VideoURLArray.push("http://54.243.235.88/3.flv");
			//m_VideoURLArray.push("d:\\3.flv");
			
			SetContentURL(m_VideoURLArray);
		}

		private function RegisterContentEvents () : void
		{
			RegisterOnCompletionEvent(ZEvent.EVENT_CONTENT_VIDEO_LOADED);
		}
		
		
		public override function Load () : Boolean
		{
			try 
			{
				UpdateUI();
				
				//Test code only
				SetContent ();

				//super.Load();
				var retVal : Boolean = true;
				m_Connection = ConnectionFactory.CreateConnection(ConnectionType.CONNECTION_TYPE_RTMP);
				if (!m_Connection)
				{
					return false;
				}
				
				GlobalEventDispatcher.instance.addGlobalListener(ZEvent.EVENT_VIDEO_SERVER_CONNECTED, OnVideoConnectionEvent);
				m_Connection.RegisterOnConnectionStatusEvent(ZEvent.EVENT_VIDEO_SERVER_CONNECTED);
				
				retVal = m_Connection.Connect(m_VideoContent.GetContentURL(0));
				if (retVal)
					Logger.instance.WriteMessage ("DocumentContent::DownloadImage ==> Successfully established connection to RTMP server.");
				else
					Logger.instance.WriteMessage ("DocumentContent::DownloadImage ==> Failed to establish connection to RTMP server.");
			}
			catch (errorCode : Error)
			{
				Logger.instance.WriteMessage ("DocumentContent::Load ==> Error while calling function, Error Code : " + errorCode.errorID + " Error Description : " + errorCode.message)
				return false;
			}
			
			return true;
		}
		
		public override function Unload () : void
		{
			m_Connection.Disconnect();
		}
		
		
		private function UpdateUI():void
		{
			m_ContentDisplayObject.addChild(m_Container);
			m_Container.x = m_Left;
			m_Container.y = m_Top;
		}

		public function SetContentURL (contentURLArray : Array) : void
		{
			m_VideoContent.SetContentURL(contentURLArray);
		}
		
		public override function GetContent () : Content
		{
			return m_VideoContent;
		}
		
		public function OnVideoConnectionEvent (contentLoadEvent : ZEvent) : void
		{
			var param : Object = contentLoadEvent.GetEventParam();
			
			if (m_Connection)
			{
				var recordingFileName : String;
				recordingFileName = Util.GenerateRecordingFileName();
				
				AttachStreamOutputContainer(m_Container);

				m_Connection.AttachStreamInputSource(StreamSourceType.STREAM_SOURCE_TYPE_VIDEO, m_VideoCamera);
				m_Connection.AttachStreamInputSource(StreamSourceType.STREAM_SOURCE_TYPE_AUDIO, m_Microphone);
				
				m_Connection.StartRecording(recordingFileName);
				
				//Notify parent that we have started video recording.
				if (m_VideoConnectionParentNotifyEvent)
				{
					GlobalEventDispatcher.instance.dispatch (new ZEvent(m_VideoConnectionParentNotifyEvent, null));
				}
			}
		}
		
		public function AttachStreamOutputContainer (streamOutputContainer : Object) : void
		{
			//if (m_Connection)
			//	m_Connection.AttachStreamOutputContainer(streamOutputContainer);
			streamOutputContainer.attachCamera(m_VideoCamera);
		}
		
		public override function RegisterOnCompletionEvent (eventName : String) : void
		{
			m_VideoConnectionParentNotifyEvent = eventName;
		}
	}
}