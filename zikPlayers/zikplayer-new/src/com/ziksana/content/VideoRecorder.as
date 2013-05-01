package com.ziksana.content
{
	import com.ziksana.connection.ConnectionFactory;
	import com.ziksana.connection.ConnectionType;
	import com.ziksana.connection.IConnection;
	import com.ziksana.connection.StreamSourceType;
	import com.ziksana.events.CustomEvent;
	import com.ziksana.events.EventsList;
	import com.ziksana.util.Logger;
	import com.ziksana.util.Util;
	
	import flash.events.EventDispatcher;
	import flash.media.Camera;
	import flash.media.Microphone;

	public class VideoRecorder  extends EventDispatcher implements ContentGenerator
	{
		private var m_Connection : IConnection;
		private var m_VideoContent : VideoContent = null;
		
		private var m_VideoConnectionEvent : CustomEvent = null;
		private var m_VideoConnectionParentNotifyEvent : CustomEvent;
		
		private var m_VideoCamera : Camera = null;
		private var m_Microphone : Microphone = null;
		
		public function VideoRecorder()
		{
			m_VideoContent = new VideoContent();
			m_VideoCamera = Camera.getCamera();
			m_Microphone = Microphone.getMicrophone();
			
			//For now use best quality and 320, 240 resolution
			m_VideoCamera.setQuality(0, 100);
			m_VideoCamera.setMode(320, 240, 30);
		}

		public function Load () : Boolean
		{
			try 
			{
				//super.Load();
				var retVal : Boolean = true;
				m_Connection = ConnectionFactory.CreateConnection(ConnectionType.CONNECTION_TYPE_RTMP);
				if (!m_Connection)
				{
					return false;
				}
				
				addEventListener(EventsList.VIDEO_CONNECTION_EVENT, OnVideoConnectionEvent);
				m_VideoConnectionEvent = new CustomEvent(EventsList.VIDEO_CONNECTION_EVENT, this, this);
				m_Connection.RegisterOnConnectionStatusEvent(m_VideoConnectionEvent);
				
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
		
		public function Unload () : void
		{
			m_Connection.Disconnect();
		}
		
		public function SetContentURL (contentURLArray : Array) : void
		{
			m_VideoContent.SetContentURL(contentURLArray);
		}
		
		public function GetContent () : Content
		{
			return m_VideoContent;
		}
		
		public function OnVideoConnectionEvent (contentLoadEvent : CustomEvent) : void
		{
			var param : Object = contentLoadEvent.GetEventParam();
			
			if (m_Connection)
			{
				var recordingFileName : String;
				recordingFileName = Util.GenerateRecordingFileName();
				
				m_Connection.AttachStreamInputSource(StreamSourceType.STREAM_SOURCE_TYPE_VIDEO, m_VideoCamera);
				m_Connection.AttachStreamInputSource(StreamSourceType.STREAM_SOURCE_TYPE_AUDIO, m_Microphone);
				
				m_Connection.StartRecording(recordingFileName);
				
				//Notify parent that we have started video recording.
				if (m_VideoConnectionParentNotifyEvent)
					m_VideoConnectionParentNotifyEvent.DispatchEvent();
			}
		}
		
		public function AttachStreamOutputContainer (streamOutputContainer : Object) : void
		{
			//if (m_Connection)
			//	m_Connection.AttachStreamOutputContainer(streamOutputContainer);
			streamOutputContainer.attachCamera(m_VideoCamera);
		}
		
		public function RegisterOnCompletionEvent (contentLoadEvent : CustomEvent) : void
		{
			m_VideoConnectionParentNotifyEvent = contentLoadEvent;
		}
	}
}