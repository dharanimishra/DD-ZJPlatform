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
		private var m_ConnectionMGR : ConnectionFactory;
		private var m_VideoContent : VideoContent = null;
		private var m_Connection : IConnection;
		private var m_VideoConnectionEvent : CustomEvent = null;
		private var m_VideoStreamConnectionEvent : CustomEvent = null;
		protected var m_Camera : Camera = Camera.getCamera();
		protected var m_Microphone : Microphone;
		private var m_ContentLoadEvent : CustomEvent;
		
		public function VideoRecorder()
		{
			m_VideoContent = new VideoContent();
			m_Camera = Camera.getCamera();
			m_Microphone = Microphone.getMicrophone();
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
				
				addEventListener(EventsList.VIDEO_STREAM_CONNECTION_EVENT, OnVideoStreamConnectionEvent);
				m_VideoStreamConnectionEvent = new CustomEvent(EventsList.VIDEO_STREAM_CONNECTION_EVENT, this, this);
				m_Connection.RegisterOnStreamStatusEvent(m_VideoConnectionEvent);
				
				retVal = m_Connection.Connect(null);
				if (retVal)
					Logger.WriteMessage ("DocumentContent::DownloadImage ==> Successfully established connection to RTMP server.");
				else
					Logger.WriteMessage ("DocumentContent::DownloadImage ==> Failed to establish connection to RTMP server.");
			}
			catch (errorCode : Error)
			{
				Logger.WriteMessage ("DocumentContent::Load ==> Error while calling function, Error Code : " + errorCode.errorID + " Error Description : " + errorCode.message)
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
				
				m_Connection.AttachStreamInputSource(StreamSourceType.STREAM_SOURCE_TYPE_VIDEO, m_Camera);
				m_Connection.AttachStreamInputSource(StreamSourceType.STREAM_SOURCE_TYPE_AUDIO, m_Microphone);
				
				m_Connection.StartRecording(recordingFileName);
				
				if (m_ContentLoadEvent)
					m_ContentLoadEvent.DispatchEvent();
			}
		}
		
		public function OnVideoStreamConnectionEvent (contentLoadEvent : CustomEvent) : void
		{
			var param : Object = contentLoadEvent.GetEventParam();
		}
		
		public function AttachStreamOutputContainer (streamOutputContainer : Object) : void
		{
			//if (m_Connection)
			//	m_Connection.AttachStreamOutputContainer(streamOutputContainer);
			streamOutputContainer.attachCamera(m_Camera);
		}
		
		public function RegisterOnCompletionEvent (contentLoadEvent : CustomEvent) : void
		{
			m_ContentLoadEvent = contentLoadEvent;
		}
	}
}