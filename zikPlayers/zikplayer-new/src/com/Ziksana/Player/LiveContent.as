package com.Ziksana.Player
{
	public class LiveContent extends Content
	{
		private var m_ContentURL : String;
		private var m_ConnectionMGR : ConnectionManager;
		private var m_ConnectionURL : String;
		
		public function LiveContent()
		{
			super.SetContentType(ContentType.CONTENT_TYPE_VIDEO);
			super.SetContentDescription("Video");
		}
		
		public override function Load(contentURL : String) : Boolean
		{
			try 
			{
				//super.Load();
				var retVal : Boolean = true;
				
				m_ContentURL = contentURL;
				
				//Need to establish connection here.
				//Get the live content.
				
				m_ConnectionMGR = new ConnectionManager();
				if (!m_ConnectionMGR)
				{
					return false;
				}
				
				retVal = m_ConnectionMGR.Connect(null, ConnectionType.CONNECTION_TYPE_RTMP);
				if (retVal)
					Logger.WriteMessage ("DocumentContent::DownloadImage ==> Successfully established connection to RTMP server.");
				else
					Logger.WriteMessage ("DocumentContent::DownloadImage ==> Failed toestablish connection to RTMP server.");
			}
			catch (errorCode : Error)
			{
				Logger.WriteMessage ("DocumentContent::Load ==> Error while calling function, Error Code : " + errorCode.errorID + " Error Description : " + errorCode.message)
				return false;
			}
			
			return true;
		}
		
		public override function Unload () : void
		{
			m_ConnectionMGR.Disconnect();
		}
		
		public override function GetData () : Object
		{
			//Need to get specific position data here.
			return null;
		}
		
		//Implement display methods too here.
		public function InitDisplay () : void
		{
			
		}
		
		public function DrawContent () : void
		{
		
		}
		
		public function ClearDrawArea () : void
		{
			
		}
		
		public function StartPlayback () : void
		{
			//Output container should be part of display stuff.
			//m_ConnectionMGR.AttachStreamOutputContainer();
			m_ConnectionMGR.StartPlayback(m_ContentURL);
		}
		
		public function StopPlayback () : void
		{
			m_ConnectionMGR.StopPlayback ();
		}
		
		//NAVIGATION STUFF
		public override function GetNumberOfPosition () : Number
		{
			//Need to get total time here.
			m_NumberOfPosition = m_ConnectionMGR.GetDuration();
			return m_NumberOfPosition;
		}
		
		public override function SetNumberOfPosition (numberOfPosition : Number) : void
		{
			//Set the total time here.
			m_NumberOfPosition = numberOfPosition;
		}
		
		public override function GetCurrentPosition () : Number
		{
			m_CurrentPosition = m_ConnectionMGR.GetCurrentPosition();
			return m_CurrentPosition;			
		}
		
		public override function SetCurrentPosition (currentPosition : Number) : void
		{
			if ((currentPosition >= 0) && (currentPosition < m_NumberOfPosition))
				m_CurrentPosition = currentPosition;
			
			//Move the current data pointer here.
			m_ConnectionMGR.SetCurrentPosition(m_CurrentPosition);
		}
	}
}
