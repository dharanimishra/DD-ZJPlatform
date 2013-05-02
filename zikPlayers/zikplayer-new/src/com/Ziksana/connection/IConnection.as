package com.ziksana.connection
{
	import com.ziksana.events.ZEvent;

	/** 
	 * IConnection interface
	 * 
	 * @tag Tag text.
	 */
	public interface IConnection
	{
		function Connect (connectionURL : String) : Boolean;
		function Disconnect () : void;
		
		function StartPlayback (streamingURL : String) : Boolean;
		function StopPlayback () : void;
		function PausePlayback () : void;
		function ResumePlayback () : void;
		
		function StartRecording (publishURL : String) : Boolean;
		function StopRecording () : void;
		
		function GetCurrentPosition () : Number;
		function SetPosition (nPosition : Number) : void;
		
		function GetFrameRate () : Number;
		function GetDuration() : Number;
		
		function RegisterOnConnectionStatusEvent (eventName : String) : void;
		function RegisterOnStreamStatusEvent (eventName : String) : void;
		
		function AttachStreamInputSource (streamInputSourceType : int, streamInputSource : Object) : void;
		function AttachStreamOutputContainer (streamOutputContainer : Object) : void;
		
	}
}