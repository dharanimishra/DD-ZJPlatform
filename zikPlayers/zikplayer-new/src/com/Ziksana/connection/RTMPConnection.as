package com.ziksana.connection
{
	import com.ziksana.events.CustomEvent;
	
	import flash.events.NetStatusEvent;
	import flash.events.SecurityErrorEvent;
	import flash.media.Camera;
	import flash.media.Microphone;
	import flash.media.SoundTransform;
	import flash.media.Video;
	import flash.net.NetConnection;
	import flash.net.NetStream;
	
	
	public class RTMPConnection implements IConnection
	{
		private var m_NetStream : NetStream = null;
		private var m_NetConnection : NetConnection = null;
		private var m_CurrentPosition : Number = 0;
		
		private var m_Duration : Number = 0;
		private var m_FrameRate : Number = 0;

		//Stream Configuration Parameters
		private var m_EnableAudio : Boolean = true;
		private var m_AudioGain : Boolean = true;
		
		//PUBLISH TYPE
		private var PUBLISH_URL_TYPE_RECORD : String = "record";
		
		private static const OnConnectionStatusEvent:String = "ON_CONNECTION_EVENT";
		private static const OnStreamStatusEvent:String = "ON_STREAM_EVENT";
		
		private var m_OnConnectionStatusEvent : CustomEvent = null;
		private var m_OnStreamStatusEvent : CustomEvent = null;
		
		
		public function RTMPConnection()
		{
			//Do some initialization here
			InitNetConnection();
		}
		
		//// NET CONNECTION ///////
		/**
		 * InitConection Method
		 * This function initiates the NetConnection object
		 *
		 * @param param1 None
		 *
		 * @return Success or failure Boolean
		 *
		 * @see RegisterNetConnectionEvents
		 */

		private function InitNetConnection () : Boolean
		{
			if (m_NetConnection)
				return true;
			
			//Create the netconnection object here
			m_NetConnection = new NetConnection ();
			if (!m_NetConnection)
				return false;

			RegisterNetConnectionEvents();
			
			return true;
		}
				
		private function IsConnected () : Boolean
		{
			if (!m_NetConnection)
				return false;
			
			return m_NetConnection.connected;
		}
		
		
		private function RegisterNetConnectionEvents () : Boolean
		{
			//Register net connection status events here
			m_NetConnection.addEventListener (NetStatusEvent.NET_STATUS, NetConnectionStatusHandler);
			m_NetConnection.addEventListener(SecurityErrorEvent.SECURITY_ERROR, securityErrorHandler);
			m_NetConnection.client = { onBWDone: function():void{ } };
			return true;
		}
		
		//PUBLIC METHODS:
		public function Connect (connectionURL : String) : Boolean
		{
			//Remember : for now commented out
			//Check the URL here
			//if (connectionURL.length == 0)
			//	return false;
			
			try 
			{
				//Try to connect here
				m_NetConnection.connect(connectionURL);
			
			}
			catch (error : ArgumentError) 
			{
				trace ("RTMPConnection::Connect ==> Connection Failure !!! Invalid connection URL.");
				return false;
			}
						
			return true;
		}
		
		public function Disconnect () : void
		{
			//Close only if its connected
			if (IsConnected())
			{
				m_NetConnection.close();
				m_NetConnection.removeEventListener (NetStatusEvent.NET_STATUS, NetConnectionStatusHandler);
				m_NetConnection.removeEventListener (SecurityErrorEvent.SECURITY_ERROR, securityErrorHandler);
			}
		}
		
			
		//// COMMON STATUS HANDLER - NET CONNECTION AND NET STREAM ///////
		private function NetConnectionStatusHandler (event : NetStatusEvent) : void 
		{
			trace("RTMPConnection::NetConnectionStatusHandler ==> EVENT INFO CODE = " + event.info.code);
			switch (event.info.code) 
			{
				case "NetConnection.Connect.Success":
					InitNetStream();
					if (m_OnConnectionStatusEvent)
						m_OnConnectionStatusEvent.DispatchEvent();
					break;
				case "NetConnection.Connect.Failed":
					break;
				case "NetStream.Play.Start":
					break;
				case "NetStream.Play.Stop": 
					break; 
				case "NetStream.Play.StreamNotFound" :
					break;
				default:
					for (var prop:Object in event) 
					{
						trace("\t"+prop+":\t"+event[prop]);
					}
					break;
			}
		}
		
		private function securityErrorHandler(event:SecurityErrorEvent):void {
			trace("securityErrorHandler: " + event);
		}
		
		//// NET STREAM ///////
		
		private function InitNetStream () : Boolean
		{
			CloseNetStream ();
			
			m_NetStream = new NetStream (m_NetConnection);
			
			if (!m_NetStream)
				return false;
			
			ConfigureNetStream();
			RegisterNetStreamEvents();
			
			return true;
		}
		
		private function CloseNetStream () : void
		{
			if (!m_NetStream)
				return;
			
			m_NetStream.close();
			m_NetStream = null;
			m_CurrentPosition = 0;
		}
		
		private function ConfigureNetStream () : void
		{
			//Configure Gain here
			m_NetStream.soundTransform = new SoundTransform(m_AudioGain ? 1 : 0);
			m_CurrentPosition = 0;
			//Enable Audio
		}
		
		
		private function OnMetaDataHandler (videoMetaData : Object) : void
		{
			//trace("OnMetaDataHandler ==> Video Duration = " + info.duration + " Frame Rate = " + info.framerate);
			var key:String; 
			for (key in videoMetaData) 
			{ 
				trace(key + ": " + videoMetaData[key]); 
			} 
			
			m_Duration = videoMetaData.duration;
			m_FrameRate = videoMetaData.framerate;
		}
		
		private function OnStatusHandler () : void
		{
			trace("OnStatusHandler ==> ");
			if (m_OnStreamStatusEvent)
				m_OnStreamStatusEvent.DispatchEvent();
		}
		
		private function OnNetStreamBandWidthDoneHandler():void
		{
			trace("OnNetStreamBandWidthDoneHandler ==> ");
		}
		

		private function RegisterNetStreamEvents () : Boolean
		{
			m_NetStream.addEventListener(NetStatusEvent.NET_STATUS, NetConnectionStatusHandler);
			
			// Add bandwidth detection handlers on the NetConnection Client to
			// prevent Reference Errors at runtime when using the "live" and "vod" applications.          
			var clientObj:Object = new Object();
			
			clientObj.onMetaData = OnMetaDataHandler;
			clientObj.onStatus = OnStatusHandler;
			//clientObj.onBWDone = OnNetStreamBandWidthDoneHandler;
			//clientObj.onBWCheck = OnNetStreamBandWidthCheckHandler;
			
			m_NetStream.client = clientObj;
			
			return true;
		}
		
		
		//PUBLIC METHODS
		public function SetStreamConfigurationParams (enableAudio : Boolean, audioGain : Boolean) : void
		{
			//Enable Audio
			m_EnableAudio = enableAudio;
			//Use Gain
			m_AudioGain = audioGain;
		}
		
		public function StartPlayback (streamingURL : String) : Boolean
		{		
			//CloseNetStream();
			
			//Configure Gain here
			//ConfigureNetStream();

			//Call play
			m_NetStream.play(streamingURL);
			
			return true;
		}
		
		public function StopPlayback () : void
		{	
			m_NetStream.pause();
			//CloseNetStream();			
		}
				
		//Todo : Add parameters, Video Source, Audio Source
		public function StartRecording (publishURL : String) : Boolean
		{
			//CloseNetStream();
			
			//Configure Gain here
			//ConfigureNetStream();
			
			//Call publish
			m_NetStream.publish(publishURL, PUBLISH_URL_TYPE_RECORD);
			
			return true;
		}
		
		public function StopRecording () : void
		{
			CloseNetStream();
		}
		
		public function GetFrameRate () : Number
		{
			return m_FrameRate;
		}
		
		public function GetDuration() : Number
		{
			return m_Duration;
		}
		
		public function GetCurrentPosition () : Number
		{
			//We deal in milliseconds
			m_CurrentPosition = m_NetStream.time;
			return (m_NetStream.time * 1000);
		}
		
		public function SetPosition (nPosition : Number) : void
		{
			//We deal in milliseconds
			m_NetStream.seek(nPosition/1000);		
		}
		
		public function RegisterOnConnectionStatusEvent (contentLoadEvent : CustomEvent) : void
		{
			m_OnConnectionStatusEvent = contentLoadEvent;
		}
		
		public function RegisterOnStreamStatusEvent (contentLoadEvent : CustomEvent) : void
		{
			m_OnStreamStatusEvent = contentLoadEvent;
		}
		
		public function AttachStreamInputSource (streamInputSourceType : int, streamInputSource : Object) : void
		{
			if (streamInputSourceType == StreamSourceType.STREAM_SOURCE_TYPE_VIDEO)
			{
				var videoRecordingSource : Camera = Camera(streamInputSource);
				m_NetStream.attachCamera(videoRecordingSource);
			}
			else if (streamInputSourceType == StreamSourceType.STREAM_SOURCE_TYPE_AUDIO)
			{
				var audioRecordingSource : Microphone = Microphone (streamInputSource);
				m_NetStream.attachAudio(audioRecordingSource);	
			}
		}
		
		public function AttachStreamOutputContainer (streamOutputContainer : Object) : void
		{
			var videoContainer : Video = Video (streamOutputContainer);
			videoContainer.attachNetStream (m_NetStream);
		}		
	}
}