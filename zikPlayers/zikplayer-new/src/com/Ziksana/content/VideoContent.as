package com.ziksana.content
{
	import com.ziksana.connection.ConnectionFactory;
	import com.ziksana.connection.ConnectionType;
	import com.ziksana.connection.IConnection;
	import com.ziksana.events.CustomEvent;
	import com.ziksana.util.Logger;
	import com.ziksana.events.EventsList;

	public class VideoContent extends Content
	{
		private var m_Connection : IConnection;
		private var m_ConnectionURL : String;
		
		private var m_VideoConnectionEvent : CustomEvent = null;
		private var m_VideoStreamConnectionEvent : CustomEvent = null;
		private var m_ContentLoadEvent : CustomEvent = null;
		
		public function VideoContent()
		{
			super.SetContentType(ContentType.CONTENT_TYPE_VIDEO);
			super.SetContentDescription(ContentType.CONTENT_TYPE_VIDEO_STRING);
		}
		
		public override function Load() : Boolean
		{
			try 
			{
				//super.Load();
				var retVal : Boolean = true;
				
				//Establish connection here. Get the live content.
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
		
		
		public function OnVideoConnectionEvent (contentLoadEvent : CustomEvent) : void
		{
			var param : Object = contentLoadEvent.GetEventParam();
			if (m_ContentLoadEvent)
				m_ContentLoadEvent.DispatchEvent();
		}
		
		public function OnVideoStreamConnectionEvent (contentLoadEvent : CustomEvent) : void
		{
			var param : Object = contentLoadEvent.GetEventParam();
			if (m_ContentLoadEvent)
				m_ContentLoadEvent.DispatchEvent();
		}
		
		public function AttachStreamOutputContainer (streamOutputContainer : Object) : void
		{
			if (m_Connection)
				m_Connection.AttachStreamOutputContainer(streamOutputContainer);
		}
		
		public override function GetData () : Object
		{
			//Need to get specific position data here.
			return null;
		}
		
		public function StartPlayback () : void
		{
			//Output container should be part of display stuff.
			if (m_ContentURLArray.length > 0)
				m_Connection.StartPlayback(m_ContentURLArray[0]);
		}
		
		public function StopPlayback () : void
		{
			m_Connection.StopPlayback ();
		}
		
		public function PausePlayback () : void
		{
			m_Connection.PausePlayback ();
		}
		
		//NAVIGATION STUFF
		public override function GetNumberOfPosition () : Number
		{
			//Need to get total time here.
			m_NumberOfPosition = m_Connection.GetDuration();
			return m_NumberOfPosition;
		}
		
		public override function SetNumberOfPosition (numberOfPosition : Number) : void
		{
			//Set the total time here.
			m_NumberOfPosition = numberOfPosition;
		}
		
		public override function GetCurrentPosition () : Number
		{
			m_CurrentPosition = m_Connection.GetCurrentPosition();
			return m_CurrentPosition;			
		}
		
		public override function SetCurrentPosition (currentPosition : Number) : void
		{
			if ((currentPosition >= 0) && (currentPosition < m_NumberOfPosition))
				m_CurrentPosition = currentPosition;
			
			//Move the current data pointer here.
			m_Connection.SetPosition(m_CurrentPosition);
		}
	}
}
