package com.Ziksana.Player
{
	public class ConnectionManager
	{
		//Unused..But will be used for TestConnection
		public static const DEFAULT_CONNECTION_URL : String = "rtmp://video.beta.ziksana.com/oflaDemo";
				
		private var m_Connection : IConnection = null;
		
		public function ConnectionManager()
		{
			//Do some initialization here
		}
		
		public function Connect (connectionURL : String, typeOfConnection : int) : Boolean
		{
			if (typeOfConnection == ConnectionType.CONNECTION_TYPE_RTMP)
				m_Connection = new RTMPConnection();
			
			if (!m_Connection)
				return false;
			
			return m_Connection.Connect(connectionURL);
		}
		
		public function Disconnect() : void
		{
			if (!m_Connection)
				return;
			
			m_Connection.Disconnect();
		}
		
		public function StartPlayback (streamingURL : String) : Boolean
		{
			if (!m_Connection)
				return false;
			
			return m_Connection.StartPlayback(streamingURL);
		}
		
		public function StopPlayback () : void
		{
			if (!m_Connection)
				return;
			
			m_Connection.StopPlayback();
		}
		
		public function StartRecording (publishURL : String) : Boolean
		{
			if (!m_Connection)
				return false;
			
			return m_Connection.StartRecording (publishURL);
		}
		
		public function StopRecording () : void
		{
			if (!m_Connection)
				return;
			
			m_Connection.StopRecording();
		}
		
		public function GetDuration () : Number
		{
			return m_Connection.GetDuration();
		}
		
		public function GetCurrentPosition () : Number
		{
			if (!m_Connection)
				return 0;

			return (m_Connection.GetCurrentPosition());
		}
		
		public function SetCurrentPosition (nPosition : Number) : void
		{
			if (!m_Connection)
				return;

			m_Connection.SetPosition(nPosition);		
		}
		
		public function AttachStreamInputSource (streamInputSourceType : int, streamInputSource : Object) : void
		{
			if (!m_Connection)
				return;
			
			m_Connection.AttachStreamInputSource(streamInputSourceType, streamInputSource);
		}
		
		
		public function AttachStreamOutputContainer (streamOutputContainer : Object) : void
		{
			if (!m_Connection)
				return;
			
			m_Connection.AttachStreamOutputContainer (streamOutputContainer);
		}
	}
}